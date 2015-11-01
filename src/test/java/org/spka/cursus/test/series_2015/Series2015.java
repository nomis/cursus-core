/*
	cursus - Race series management program
	Copyright 2015  Simon Arlott

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
package org.spka.cursus.test.series_2015;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Class;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.RaceAttendee;
import eu.lp0.cursus.db.data.RaceTally;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.db.data.Sex;

public class Series2015 extends AbstractSPKASeries {
	public Series2015() {
		super("SPKA Race Series 2015/16", SPKAConstants.UUID_2012); //$NON-NLS-1$
	}

	protected static final int SERIES_FLEET = 7;
	protected static final int SERIES_FLEET_AT_EVENT1 = 7;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = "West Sands (31/10/2015 and 01/11/2015)"; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 10;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = "West Sands (31/10/2015)"; //$NON-NLS-1$
	protected static final int RACE1_PILOTS = 7;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = "West Sands (01/11/2015)"; //$NON-NLS-1$
	protected static final int RACE2_PILOTS = 6;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = "West Sands (01/11/2015)"; //$NON-NLS-1$
	protected static final int RACE3_PILOTS = 6;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = "West Sands (01/11/2015)"; //$NON-NLS-1$
	protected static final int RACE4_PILOTS = 6;

	protected Class junior;
	protected Class _16inWheel;
	protected Pilot sco018;
	protected Pilot sco060;
	protected Pilot sco081;
	protected Pilot sco116;
	protected Pilot sco153;
	protected Pilot sco296;
	protected Pilot sco808;

	private Series _series;
	private Event _event1;
	private Race _race1;
	private Race _race2;
	private Race _race3;
	private Race _race4;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
	}

	protected void createSeriesData() throws Exception {
		if (_series != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			// Create the 2015/16 series
			Series series = new Series(SERIES_NAME);

			// Create classes
			junior = new Class(series, "Junior"); //$NON-NLS-1$
			series.getClasses().add(junior);

			_16inWheel = new Class(series, "16\" Wheel"); //$NON-NLS-1$
			series.getClasses().add(_16inWheel);

			// Add all the pilots
			sco018 = new Pilot(series, "SCO018@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco018.getClasses().add(_16inWheel);
			series.getPilots().add(sco018);

			sco060 = new Pilot(series, "SCO060@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco081 = new Pilot(series, "SCO081@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco116 = new Pilot(series, "SCO116@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco116);

			sco153 = new Pilot(series, "SCO153@2014", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco153.getClasses().add(_16inWheel);
			series.getPilots().add(sco153);

			sco296 = new Pilot(series, "SCO296@2013", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco296);

			sco808 = new Pilot(series, "SCO808@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco808);

			createRaceNumbers(series.getPilots());

			// Save
			seriesDAO.persist(series);

			DatabaseSession.commit();

			_series = series;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent1Data() throws Exception {
		createSeriesData();

		if (_event1 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);

			Event event1 = new Event(series, EVENT1_NAME, EVENT1_DESC);
			series.getEvents().add(event1);
			eventDAO.persist(event1);

			DatabaseSession.commit();

			_event1 = event1;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent1Races() throws Exception {
		createRace1Data();
		createRace2Data();
		createRace3Data();
		createRace4Data();
	}

	protected void createRace1Data() throws Exception {
		createEvent1Data();

		if (_race1 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);

			Race race1 = new Race(event1, RACE1_NAME, RACE1_DESC);
			event1.getRaces().add(race1);
			race1.getAttendees().put(sco018, new RaceAttendee(race1, sco018, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco081, new RaceAttendee(race1, sco081, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco116, new RaceAttendee(race1, sco116, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco153, new RaceAttendee(race1, sco153, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco296, new RaceAttendee(race1, sco296, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco808, new RaceAttendee(race1, sco808, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "116,808,18,81,60,153"); //$NON-NLS-1$
			addLaps(race1, "116,808,81,18"); //$NON-NLS-1$
			addLaps(race1, "116,808,81,18"); //$NON-NLS-1$
			addLaps(race1, "116,808,18"); //$NON-NLS-1$
			addLaps(race1, "116,808"); //$NON-NLS-1$
			addLaps(race1, "116,808"); //$NON-NLS-1$
			addLaps(race1, "116"); //$NON-NLS-1$
			raceDAO.persist(race1);

			DatabaseSession.commit();

			_race1 = race1;
		} finally {
			db.endSession();
		}
	}

	protected void createRace2Data() throws Exception {
		createEvent1Data();

		if (_race2 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);

			Race race2 = new Race(event1, RACE2_NAME, RACE2_DESC);
			event1.getRaces().add(race2);
			race2.getAttendees().put(sco060, new RaceAttendee(race2, sco060, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco081, new RaceAttendee(race2, sco081, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco116, new RaceAttendee(race2, sco116, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco153, new RaceAttendee(race2, sco153, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco296, new RaceAttendee(race2, sco296, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco808, new RaceAttendee(race2, sco808, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "116,808,60,296,81"); //$NON-NLS-1$
			addLaps(race2, "116,808,60,296,81"); //$NON-NLS-1$
			addLaps(race2, "116,808,60,296"); //$NON-NLS-1$
			addLaps(race2, "116,808,60"); //$NON-NLS-1$
			addLaps(race2, "116,808,60"); //$NON-NLS-1$
			addLaps(race2, "116,808"); //$NON-NLS-1$
			addLaps(race2, "116"); //$NON-NLS-1$
			raceDAO.persist(race2);

			DatabaseSession.commit();

			_race2 = race2;
		} finally {
			db.endSession();
		}
	}

	protected void createRace3Data() throws Exception {
		createEvent1Data();

		if (_race3 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);

			Race race3 = new Race(event1, RACE3_NAME, RACE3_DESC);
			event1.getRaces().add(race3);
			race3.getAttendees().put(sco060, new RaceAttendee(race3, sco060, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco081, new RaceAttendee(race3, sco081, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco116, new RaceAttendee(race3, sco116, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco153, new RaceAttendee(race3, sco153, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco296, new RaceAttendee(race3, sco296, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco808, new RaceAttendee(race3, sco808, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "116,808,81,296,60"); //$NON-NLS-1$
			addLaps(race3, "116,808,296,81,60"); //$NON-NLS-1$
			addLaps(race3, "116,808,81,60"); //$NON-NLS-1$
			addLaps(race3, "116,808,81"); //$NON-NLS-1$
			addLaps(race3, "116,808"); //$NON-NLS-1$
			addLaps(race3, "116"); //$NON-NLS-1$
			addLaps(race3, "116"); //$NON-NLS-1$
			raceDAO.persist(race3);

			DatabaseSession.commit();

			_race3 = race3;
		} finally {
			db.endSession();
		}
	}

	protected void createRace4Data() throws Exception {
		createEvent1Data();

		if (_race4 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);

			Race race4 = new Race(event1, RACE4_NAME, RACE4_DESC);
			event1.getRaces().add(race4);
			race4.getAttendees().put(sco060, new RaceAttendee(race4, sco060, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco081, new RaceAttendee(race4, sco081, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco116, new RaceAttendee(race4, sco116, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco153, new RaceAttendee(race4, sco153, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco296, new RaceAttendee(race4, sco296, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco808, new RaceAttendee(race4, sco808, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "116,808,296,81"); //$NON-NLS-1$
			addLaps(race4, "116,808,296"); //$NON-NLS-1$
			addLaps(race4, "116,808"); //$NON-NLS-1$
			addLaps(race4, "116,808"); //$NON-NLS-1$
			addLaps(race4, "116,808"); //$NON-NLS-1$
			addLaps(race4, "116"); //$NON-NLS-1$
			raceDAO.persist(race4);

			DatabaseSession.commit();

			_race4 = race4;
		} finally {
			db.endSession();
		}
	}
}
