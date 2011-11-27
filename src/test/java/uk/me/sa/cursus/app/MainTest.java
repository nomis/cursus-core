/*
	cursus - Race series management program
	Copyright 2011  Simon Arlott

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package uk.me.sa.cursus.app;

import static eu.lp0.cursus.db.data.Gender.FEMALE;
import static eu.lp0.cursus.db.data.Gender.MALE;
import static uk.me.sa.cursus.app.MainTest.Country.ARMBONIA;
import static uk.me.sa.cursus.app.MainTest.Country.EARBONIA;
import static uk.me.sa.cursus.app.MainTest.Country.ELBONIA;
import static uk.me.sa.cursus.app.MainTest.Country.KNEEBONIA;
import static uk.me.sa.cursus.app.MainTest.Country.NORTH_LEGBONIA;
import static uk.me.sa.cursus.app.MainTest.Country.SOUTH_LEGBONIA;
import static uk.me.sa.cursus.app.MainTest.Country.TOEBONIA;

import java.sql.SQLException;
import java.util.Arrays;

import com.google.common.base.CaseFormat;

import eu.lp0.cursus.app.Main;
import eu.lp0.cursus.db.Database;
import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.InvalidDatabaseException;
import eu.lp0.cursus.db.dao.ClassDAO;
import eu.lp0.cursus.db.dao.CursusDAO;
import eu.lp0.cursus.db.dao.EventDAO;
import eu.lp0.cursus.db.dao.PilotDAO;
import eu.lp0.cursus.db.dao.RaceAttendeeDAO;
import eu.lp0.cursus.db.dao.RaceDAO;
import eu.lp0.cursus.db.dao.RaceNumberDAO;
import eu.lp0.cursus.db.dao.SeriesDAO;
import eu.lp0.cursus.db.data.Class;
import eu.lp0.cursus.db.data.Gender;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.RaceNumber;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.util.Background;
import eu.lp0.cursus.util.Messages;

public class MainTest extends Main {
	private static final ClassDAO classDAO = new ClassDAO();
	@SuppressWarnings("unused")
	private static final CursusDAO cursusDAO = new CursusDAO();
	@SuppressWarnings("unused")
	private static final EventDAO eventDAO = new EventDAO();
	private static final PilotDAO pilotDAO = new PilotDAO();
	@SuppressWarnings("unused")
	private static final RaceDAO raceDAO = new RaceDAO();
	@SuppressWarnings("unused")
	private static final RaceAttendeeDAO raceAttendeeDAO = new RaceAttendeeDAO();
	@SuppressWarnings("unused")
	private static final RaceNumberDAO raceNumberDAO = new RaceNumberDAO();
	private static final SeriesDAO seriesDAO = new SeriesDAO();

	public enum Country {
		ELBONIA ("ELB"), //$NON-NLS-1$

		KNEEBONIA ("K"), //$NON-NLS-1$

		NORTH_LEGBONIA ("NL"), //$NON-NLS-1$

		SOUTH_LEGBONIA ("SL"), //$NON-NLS-1$

		EARBONIA ("H"), //$NON-NLS-1$

		ARMBONIA ("A"), //$NON-NLS-1$

		TOEBONIA ("TO"); //$NON-NLS-1$

		public final String org;
		public final String name;

		private Country(String org) {
			this.org = org;
			this.name = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name()).replaceAll("([A-Z])", " $1"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public static void main(String[] args) {
		Background.execute(new MainTest(args));
	}

	public MainTest(String[] args) {
		super(args);
	}

	@Override
	protected Database createEmptyDatabase() throws InvalidDatabaseException, SQLException {
		Database db = super.createEmptyDatabase();

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(Messages.getString(Database.UNTITLED_SERIES));

			Class class1 = makeClass(series, "Class 1"); //$NON-NLS-1$
			Class class2 = makeClass(series, "Class 2"); //$NON-NLS-1$
			Class class3 = makeClass(series, "Class 3"); //$NON-NLS-1$
			Class class4 = makeClass(series, "Class 4"); //$NON-NLS-1$
			Class class5 = makeClass(series, "Class 5"); //$NON-NLS-1$
			@SuppressWarnings("unused")
			Class class6 = makeClass(series, "Class 6"); //$NON-NLS-1$
			@SuppressWarnings("unused")
			Class class7 = makeClass(series, "Class 7"); //$NON-NLS-1$
			@SuppressWarnings("unused")
			Class class8 = makeClass(series, "Class 8"); //$NON-NLS-1$
			@SuppressWarnings("unused")
			Class class9 = makeClass(series, "Class 9"); //$NON-NLS-1$
			Class classA = makeClass(series, "Class A"); //$NON-NLS-1$
			Class classB = makeClass(series, "Class B"); //$NON-NLS-1$
			Class classC = makeClass(series, "Class C"); //$NON-NLS-1$
			Class classD = makeClass(series, "Class D"); //$NON-NLS-1$
			Class classE = makeClass(series, "Class E"); //$NON-NLS-1$

			makePilot(series, "Alice", FEMALE, ELBONIA, ELBONIA, 1, class1, classA); //$NON-NLS-1$
			makePilot(series, "Arthur", MALE, EARBONIA, EARBONIA, 69, class1, classB); //$NON-NLS-1$
			makePilot(series, "Bob", MALE, KNEEBONIA, KNEEBONIA, 2, class1, classA); //$NON-NLS-1$
			makePilot(series, "Carol", FEMALE, ELBONIA, KNEEBONIA, 1, class1, classB); //$NON-NLS-1$
			makePilot(series, "Charlie", MALE, KNEEBONIA, ELBONIA, 2, class1, classC); //$NON-NLS-1$
			makePilot(series, "Carlos", MALE, ELBONIA, KNEEBONIA, 3, class1, classC); //$NON-NLS-1$
			makePilot(series, "Chuck", MALE, KNEEBONIA, ELBONIA, 3, class2, classD); //$NON-NLS-1$
			makePilot(series, "Dave", MALE, NORTH_LEGBONIA, NORTH_LEGBONIA, 30, class2, classE); //$NON-NLS-1$
			makePilot(series, "Dan", MALE, NORTH_LEGBONIA, NORTH_LEGBONIA, 50, class2, classE); //$NON-NLS-1$
			makePilot(series, "Eve", FEMALE, SOUTH_LEGBONIA, SOUTH_LEGBONIA, 400, class2, classD); //$NON-NLS-1$
			makePilot(series, "John", MALE, TOEBONIA, TOEBONIA, 38, class3, classA); //$NON-NLS-1$
			makePilot(series, "Jane", FEMALE, TOEBONIA, TOEBONIA, 26, class4, classB); //$NON-NLS-1$
			makePilot(series, "Mallory", MALE, SOUTH_LEGBONIA, SOUTH_LEGBONIA, 406, class3, classB); //$NON-NLS-1$
			makePilot(series, "Merlin", MALE, ARMBONIA, ARMBONIA, 1, class4, classA); //$NON-NLS-1$
			makePilot(series, "Peggy", FEMALE, SOUTH_LEGBONIA, SOUTH_LEGBONIA, 401, class3, classA); //$NON-NLS-1$
			makePilot(series, "Trent", MALE, EARBONIA, EARBONIA, 77, class4, classB); //$NON-NLS-1$
			makePilot(series, "Trudy", FEMALE, EARBONIA, EARBONIA, 84, class3, classB); //$NON-NLS-1$
			makePilot(series, "Victor", MALE, EARBONIA, EARBONIA, 91, class4, classA); //$NON-NLS-1$
			makePilot(series, "Walter", MALE, EARBONIA, EARBONIA, 4, class5); //$NON-NLS-1$

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}

		return db;
	}

	private Pilot makePilot(Series series, String name, Gender gender, Country country, Country org, int raceNo, Class... classes) {
		Pilot pilot = new Pilot(series, name, gender, country.name);
		pilot.setRaceNumber(new RaceNumber(pilot, org.org, raceNo));
		if (classes != null) {
			pilot.getClasses().addAll(Arrays.asList(classes));
		}
		pilotDAO.persist(pilot);
		return pilot;
	}

	private Class makeClass(Series series, String name) {
		Class cls = new Class(series, name);
		classDAO.persist(cls);
		return cls;
	}
}