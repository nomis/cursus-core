/*
	cursus - Race series management program
	Copyright 2011, 2013-2014  Simon Arlott

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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.google.common.base.Preconditions;

public class DatabaseSession {
	private static final ThreadLocal<EntityManager> THREADS = new ThreadLocal<EntityManager>();
	private final EntityManagerFactory emf;
	private long openCount;

	DatabaseSession(EntityManagerFactory emf) {
		this.emf = emf;
	}

	void startSession() {
		Preconditions.checkState(THREADS.get() == null, "Session already open"); //$NON-NLS-1$
		synchronized (this) {
			Preconditions.checkState(emf.isOpen(), "Factory not open"); //$NON-NLS-1$
			openCount++;
		}
		THREADS.set(emf.createEntityManager());
	}

	public static EntityManager getEntityManager() {
		EntityManager em = THREADS.get();
		Preconditions.checkState(em != null, "Session not open"); //$NON-NLS-1$
		return em;
	}

	public static EntityTransaction getTransaction() {
		return getEntityManager().getTransaction();
	}

	public static void begin() {
		getTransaction().begin();
	}

	public static void commit() {
		getTransaction().commit();
	}

	public static void rollback() {
		getTransaction().rollback();
	}

	void endSession() {
		getEntityManager().close();
		synchronized (this) {
			openCount--;
		}
		THREADS.set(null);
	}

	boolean isFactoryActive() {
		synchronized (this) {
			return openCount > 0;
		}
	}

	boolean closeFactory(boolean force) {
		if (!emf.isOpen()) {
			return true;
		}

		synchronized (this) {
			if (openCount == 0 || force) {
				shutdown();
				return true;
			}
		}
		return false;
	}

	private void shutdown() {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.createNativeQuery("SHUTDOWN").executeUpdate(); //$NON-NLS-1$
		} finally {
			em.close();
		}

		emf.close();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (emf.isOpen()) {
			shutdown();
		}
	}
}