/*
	cursus - Race series management program
	Copyright 2011-2014  Simon Arlott

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU Affero General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU Affero General Public License for more details.

	You should have received a copy of the GNU Affero General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package uk.uuid.cursus.db;

import java.io.File;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.uuid.cursus.db.dao.CursusDAO;
import uk.uuid.cursus.db.data.Cursus;
import uk.uuid.cursus.util.ProgressMonitor;

public abstract class Database {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private final String name;
	private final DatabaseSession sessionFactory;

	private static final CursusDAO cursusDAO = new CursusDAO();

	public enum Mode {
		/** Don't initialise any tables */
		NO_INIT,

		/** Check database version and open */
		OPEN,

		/** Open database without checking version */
		FORCE_OPEN;
	}

	static {
		System.setProperty("h2.allowedClasses", "none"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	protected Database(String name, String url, String user, String password, Mode mode) throws SQLException, DatabaseVersionException,
			InvalidDatabaseException {
		this.name = name;

		log.info("Connecting to database \"" + name + "\" at \"" + url + "\""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		Properties config = new Properties();
		config.setProperty("javax.persistence.jdbc.url", url); //$NON-NLS-1$
		config.setProperty("javax.persistence.jdbc.user", user); //$NON-NLS-1$
		config.setProperty("javax.persistence.jdbc.password", password); //$NON-NLS-1$

		sessionFactory = initSession(config, mode);
	}

	public String getName() {
		return name;
	}

	public final void startSession() {
		sessionFactory.startSession();
	}

	public final void endSession() {
		sessionFactory.endSession();
	}

	private DatabaseSession initSession(Properties config, Mode mode) throws InvalidDatabaseException {
		final String CHECK = "/check"; //$NON-NLS-1$
		final String UPDATE = "/update"; //$NON-NLS-1$

		if (mode != Mode.FORCE_OPEN) {
			DatabaseSession ro = new DatabaseSession(Persistence.createEntityManagerFactory(getClass().getPackage().getName() + CHECK, config));

			if (mode == Mode.NO_INIT) {
				return ro;
			}

			try {
				ro.startSession();
				try {
					DatabaseSession.begin();
					checkVersion(true);
					DatabaseSession.commit();
				} finally {
					ro.endSession();
				}
			} finally {
				ro.closeFactory(true);
			}
		}

		DatabaseSession rw = new DatabaseSession(Persistence.createEntityManagerFactory(getClass().getPackage().getName() + UPDATE, config));
		boolean ok = false;

		try {
			rw.startSession();
			try {
				DatabaseSession.begin();
				checkVersion(false);
				DatabaseSession.commit();
			} finally {
				rw.endSession();
			}

			ok = true;
			return rw;
		} finally {
			if (!ok) {
				rw.closeFactory(true);
			}
		}
	}

	private void checkVersion(boolean checkSchema) throws InvalidDatabaseException {
		Cursus cursus = cursusDAO.findSingleton();
		if (cursus == null) {
			log.info("Database \"" + name + "\" has no version record, setting to " + DatabaseVersion.getLatest()); //$NON-NLS-1$ //$NON-NLS-2$

			cursus = new Cursus(DatabaseVersion.getLatest().asLong(), Constants.LIB_DESC);
			cursusDAO.persist(cursus);
		} else {
			log.info("Database \"" + name + "\" has version " + DatabaseVersion.parseLong(cursus.getVersion())); //$NON-NLS-1$ //$NON-NLS-2$
			if (cursus.getVersion() > DatabaseVersion.getLatest().asLong()) {
				if (checkSchema) {
					// TODO support upgrading
					throw new DatabaseVersionException(cursus);
				} else {
					cursus.setVersion(DatabaseVersion.getLatest().asLong());
					log.info("Database \"" + name + "\" version record upgraded to " + DatabaseVersion.getLatest()); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
	}

	public boolean isSaved() {
		return !sessionFactory.isFactoryActive();
	}

	public final FileDatabase saveAs(ProgressMonitor progress, File file) throws Exception {
		return FileDatabase.save(progress, this, file);
	}

	void postClose() {
	}

	public final boolean close(boolean force) {
		boolean closed = sessionFactory.closeFactory(force);
		if (closed) {
			postClose();
		}
		return closed;
	}

	public void delete() {
		close(true);
	}
}