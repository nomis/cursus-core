/*
	cursus - Race series management program
	Copyright 2014-2015  Simon Arlott

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
package org.spka.cursus.test.series_2014;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Class;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Penalty;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.RaceAttendee;
import eu.lp0.cursus.db.data.RaceTally;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.db.data.Sex;

public class Series2014 extends AbstractSPKASeries {
	public Series2014() {
		super("SPKA Race Series 2014/15", SPKAConstants.UUID_2012); //$NON-NLS-1$
	}

	protected static final int SERIES_FLEET = 12;
	protected static final int SERIES_FLEET_AT_EVENT1 = 10;
	protected static final int SERIES_FLEET_AT_EVENT2 = 12;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = "Luce Bay (29/11/2014 and 30/11/2014)"; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 10;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = "Luce Bay (29/11/2014)"; //$NON-NLS-1$
	protected static final int RACE1_PILOTS = 10;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = "Luce Bay (29/11/2014)"; //$NON-NLS-1$
	protected static final int RACE2_PILOTS = 10;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = "Luce Bay (29/11/2014)"; //$NON-NLS-1$
	protected static final int RACE3_PILOTS = 10;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = "Luce Bay (29/11/2014)"; //$NON-NLS-1$
	protected static final int RACE4_PILOTS = 10;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = "Luce Bay (30/11/2014)"; //$NON-NLS-1$
	protected static final int RACE5_PILOTS = 8;

	protected static final String EVENT2_NAME = "Race Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = "West Sands (24/01/2015 and 25/01/2015)"; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 10;
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = "West Sands (24/01/2015)"; //$NON-NLS-1$
	protected static final int RACE6_PILOTS = 10;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = "West Sands (24/01/2015)"; //$NON-NLS-1$
	protected static final int RACE7_PILOTS = 10;
	protected static final String RACE8_NAME = "Race 8"; //$NON-NLS-1$
	protected static final String RACE8_DESC = "West Sands (25/01/2015)"; //$NON-NLS-1$
	protected static final int RACE8_PILOTS = 9;
	protected static final String RACE9_NAME = "Race 9"; //$NON-NLS-1$
	protected static final String RACE9_DESC = "West Sands (25/01/2015)"; //$NON-NLS-1$
	protected static final int RACE9_PILOTS = 9;
	protected static final String RACE10_NAME = "Race 10"; //$NON-NLS-1$
	protected static final String RACE10_DESC = "West Sands (25/01/2015)"; //$NON-NLS-1$
	protected static final int RACE10_PILOTS = 9;
	protected static final String RACE11_NAME = "Race 11"; //$NON-NLS-1$
	protected static final String RACE11_DESC = "West Sands (25/01/2015)"; //$NON-NLS-1$
	protected static final int RACE11_PILOTS = 9;

	protected Class junior;
	protected Class _16inWheel;
	protected Pilot sco018;
	protected Pilot sco066;
	protected Pilot sco069;
	protected Pilot sco087;
	protected Pilot sco116;
	protected Pilot sco156;
	protected Pilot sco179;
	protected Pilot sco296;
	protected Pilot sco315;
	protected Pilot sco528;
	protected Pilot sco561;
	protected Pilot sco808;

	private Series _series;
	private Event _event1;
	private Race _race1;
	private Race _race2;
	private Race _race3;
	private Race _race4;
	private Race _race5;
	private Event _event2;
	private Race _race6;
	private Race _race7;
	private Race _race8;
	private Race _race9;
	private Race _race10;
	private Race _race11;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
		createEvent2Races();
	}

	protected void createSeriesData() throws Exception {
		if (_series != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			// Create the 2014/15 series
			Series series = new Series(SERIES_NAME);

			// Create classes
			junior = new Class(series, "Junior"); //$NON-NLS-1$
			series.getClasses().add(junior);

			_16inWheel = new Class(series, "16\" Wheel"); //$NON-NLS-1$
			series.getClasses().add(_16inWheel);

			// Add all the pilots
			sco018 = new Pilot(series, "SCO018@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco018);

			sco066 = new Pilot(series, "SCO066@2013", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco066);

			sco069 = new Pilot(series, "SCO069@2013", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco069);

			sco087 = new Pilot(series, "SCO087@2009", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco087);

			sco116 = new Pilot(series, "SCO116@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco116);

			sco156 = new Pilot(series, "SCO156@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco156.getClasses().add(junior);
			series.getPilots().add(sco156);

			sco179 = new Pilot(series, "SCO179@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco296 = new Pilot(series, "SCO296@2013", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco296);

			sco315 = new Pilot(series, "SCO315@2011", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco315);

			sco528 = new Pilot(series, "SCO528@2011", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco528);

			sco561 = new Pilot(series, "SCO561@2012", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco561);

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
		createRace5Data();
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
			race1.getAttendees().put(sco066, new RaceAttendee(race1, sco066, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco069, new RaceAttendee(race1, sco069, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco087, new RaceAttendee(race1, sco087, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco116, new RaceAttendee(race1, sco116, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco156, new RaceAttendee(race1, sco156, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco296, new RaceAttendee(race1, sco296, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco528, new RaceAttendee(race1, sco528, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco808, new RaceAttendee(race1, sco808, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "69,116,179,808,528,87,18,156"); //$NON-NLS-1$
			addLaps(race1, "116,69,179,808,87,528,18,156"); //$NON-NLS-1$
			addLaps(race1, "116,69,179,808,528,87,18,156"); //$NON-NLS-1$
			addLaps(race1, "69,116,179,808,528,87,18,156"); //$NON-NLS-1$
			addLaps(race1, "69,116,179,808,528,87,18"); //$NON-NLS-1$
			addLaps(race1, "69,116,179,808,528"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco018, new RaceAttendee(race2, sco018, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco066, new RaceAttendee(race2, sco066, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco069, new RaceAttendee(race2, sco069, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco087, new RaceAttendee(race2, sco087, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco116, new RaceAttendee(race2, sco116, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco156, new RaceAttendee(race2, sco156, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco296, new RaceAttendee(race2, sco296, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco528, new RaceAttendee(race2, sco528, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco808, new RaceAttendee(race2, sco808, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "69,179,116,808,528,18,156,87,66"); //$NON-NLS-1$
			addLaps(race2, "69,179,116,808,528,156,87,18,66"); //$NON-NLS-1$
			addLaps(race2, "69,179,116,808,528,156,87,18"); //$NON-NLS-1$
			addLaps(race2, "69,179,116,808,528,156,87,18"); //$NON-NLS-1$
			addLaps(race2, "69,179,116,808,528,156"); //$NON-NLS-1$
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
			RaceAttendee att018 = new RaceAttendee(race3, sco018, RaceAttendee.Type.PILOT);
			att018.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 1")); //$NON-NLS-1$
			race3.getAttendees().put(sco018, att018);
			race3.getAttendees().put(sco066, new RaceAttendee(race3, sco066, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco069, new RaceAttendee(race3, sco069, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco087, new RaceAttendee(race3, sco087, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco116, new RaceAttendee(race3, sco116, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco156, new RaceAttendee(race3, sco156, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco296, new RaceAttendee(race3, sco296, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco528, new RaceAttendee(race3, sco528, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco808, new RaceAttendee(race3, sco808, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "179,116,808,69,156,87,18,528,66,296"); //$NON-NLS-1$
			addLaps(race3, "179,69,116,808,528,156,87,18,66"); //$NON-NLS-1$
			addLaps(race3, "179,69,808,116,528,156,87,18,66"); //$NON-NLS-1$
			addLaps(race3, "69,179,808,116,528,156,87,18"); //$NON-NLS-1$
			addLaps(race3, "69,179,808,116,528,156"); //$NON-NLS-1$
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
			race4.getAttendees().put(sco018, new RaceAttendee(race4, sco018, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco066, new RaceAttendee(race4, sco066, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco069, new RaceAttendee(race4, sco069, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco087, new RaceAttendee(race4, sco087, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco116, new RaceAttendee(race4, sco116, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco156, new RaceAttendee(race4, sco156, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco179, new RaceAttendee(race4, sco179, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco296, new RaceAttendee(race4, sco296, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco528, new RaceAttendee(race4, sco528, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco808, new RaceAttendee(race4, sco808, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "69,808,179,116,528,156,18,66,296,87"); //$NON-NLS-1$
			addLaps(race4, "69,808,179,116,18,156,66,87,296"); //$NON-NLS-1$
			addLaps(race4, "69,808,179,116,18,156,66,87,296"); //$NON-NLS-1$
			addLaps(race4, "69,808,179,116,18,156,66,87"); //$NON-NLS-1$
			addLaps(race4, "69,808,179,116,156,18,66"); //$NON-NLS-1$
			addLaps(race4, "69,808,179,116,156,18"); //$NON-NLS-1$
			addLaps(race4, "69,808,179,116"); //$NON-NLS-1$
			raceDAO.persist(race4);

			DatabaseSession.commit();

			_race4 = race4;
		} finally {
			db.endSession();
		}
	}

	protected void createRace5Data() throws Exception {
		createEvent1Data();

		if (_race5 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);

			Race race5 = new Race(event1, RACE5_NAME, RACE5_DESC);
			event1.getRaces().add(race5);
			race5.getAttendees().put(sco018, new RaceAttendee(race5, sco018, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco087, new RaceAttendee(race5, sco087, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco116, new RaceAttendee(race5, sco116, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco156, new RaceAttendee(race5, sco156, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco179, new RaceAttendee(race5, sco179, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco296, new RaceAttendee(race5, sco296, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco528, new RaceAttendee(race5, sco528, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco808, new RaceAttendee(race5, sco808, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "808,179,116,528"); //$NON-NLS-1$
			addLaps(race5, "179,808,116,528"); //$NON-NLS-1$
			addLaps(race5, "179,808,116,528"); //$NON-NLS-1$
			addLaps(race5, "179,808,116"); //$NON-NLS-1$
			addLaps(race5, "179,808,116"); //$NON-NLS-1$
			raceDAO.persist(race5);

			DatabaseSession.commit();

			_race5 = race5;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent2Data() throws Exception {
		createSeriesData();

		if (_event2 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);

			Event event2 = new Event(series, EVENT2_NAME, EVENT2_DESC);
			series.getEvents().add(event2);
			eventDAO.persist(event2);

			DatabaseSession.commit();

			_event2 = event2;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent2Races() throws Exception {
		createRace6Data();
		createRace7Data();
		createRace8Data();
		createRace9Data();
		createRace10Data();
		createRace11Data();
	}

	protected void createRace6Data() throws Exception {
		createEvent2Data();

		if (_race6 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race6 = new Race(event2, RACE6_NAME, RACE6_DESC);
			event2.getRaces().add(race6);
			race6.getAttendees().put(sco018, new RaceAttendee(race6, sco018, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco069, new RaceAttendee(race6, sco069, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco116, new RaceAttendee(race6, sco116, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco156, new RaceAttendee(race6, sco156, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco179, new RaceAttendee(race6, sco179, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco296, new RaceAttendee(race6, sco296, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco315, new RaceAttendee(race6, sco315, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco528, new RaceAttendee(race6, sco528, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco561, new RaceAttendee(race6, sco561, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco808, new RaceAttendee(race6, sco808, RaceAttendee.Type.PILOT));
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race6, "116,69,808,179,528,156,18,296,561,315"); //$NON-NLS-1$
			addLaps(race6, "116,69,179,808,528,18,156,296"); //$NON-NLS-1$
			addLaps(race6, "116,69,179,808,18,156,528,296"); //$NON-NLS-1$
			addLaps(race6, "116,69,179,808,156,18,528"); //$NON-NLS-1$
			addLaps(race6, "116,69,179,808,156"); //$NON-NLS-1$
			addLaps(race6, "116,69,179,808"); //$NON-NLS-1$
			raceDAO.persist(race6);

			DatabaseSession.commit();

			_race6 = race6;
		} finally {
			db.endSession();
		}
	}

	protected void createRace7Data() throws Exception {
		createEvent2Data();

		if (_race7 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race7 = new Race(event2, RACE7_NAME, RACE7_DESC);
			event2.getRaces().add(race7);
			race7.getAttendees().put(sco018, new RaceAttendee(race7, sco018, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco069, new RaceAttendee(race7, sco069, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco116, new RaceAttendee(race7, sco116, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco156, new RaceAttendee(race7, sco156, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco179, new RaceAttendee(race7, sco179, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco296, new RaceAttendee(race7, sco296, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco315, new RaceAttendee(race7, sco315, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco528, new RaceAttendee(race7, sco528, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco561, new RaceAttendee(race7, sco561, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco808, new RaceAttendee(race7, sco808, RaceAttendee.Type.PILOT));
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race7, "179,116,808,69,528,156,296,18,315"); //$NON-NLS-1$
			addLaps(race7, "179,116,808,69,18,296,528,315"); //$NON-NLS-1$
			addLaps(race7, "179,116,808,69"); //$NON-NLS-1$
			addLaps(race7, "179,116,808,69"); //$NON-NLS-1$
			addLaps(race7, "179,116,808"); //$NON-NLS-1$
			raceDAO.persist(race7);

			DatabaseSession.commit();

			_race7 = race7;
		} finally {
			db.endSession();
		}
	}

	protected void createRace8Data() throws Exception {
		createEvent2Data();

		if (_race8 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race8 = new Race(event2, RACE8_NAME, RACE8_DESC);
			event2.getRaces().add(race8);
			race8.getAttendees().put(sco069, new RaceAttendee(race8, sco069, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco116, new RaceAttendee(race8, sco116, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco156, new RaceAttendee(race8, sco156, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco179, new RaceAttendee(race8, sco179, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco296, new RaceAttendee(race8, sco296, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco315, new RaceAttendee(race8, sco315, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco528, new RaceAttendee(race8, sco528, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco561, new RaceAttendee(race8, sco561, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco808, new RaceAttendee(race8, sco808, RaceAttendee.Type.PILOT));
			race8.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race8, "116,179,808,528,156,315,69,296"); //$NON-NLS-1$
			addLaps(race8, "116,179,528,808,156,69,315"); //$NON-NLS-1$
			addLaps(race8, "116,179,528,808,156,69,315"); //$NON-NLS-1$
			addLaps(race8, "116,179,528,808,69,156"); //$NON-NLS-1$
			addLaps(race8, "116,179,528,808,69,156"); //$NON-NLS-1$
			addLaps(race8, "116,179,528,808,69"); //$NON-NLS-1$
			addLaps(race8, "116,179,528"); //$NON-NLS-1$
			addLaps(race8, "116,179,528"); //$NON-NLS-1$
			addLaps(race8, "116"); //$NON-NLS-1$
			raceDAO.persist(race8);

			DatabaseSession.commit();

			_race8 = race8;
		} finally {
			db.endSession();
		}
	}

	protected void createRace9Data() throws Exception {
		createEvent2Data();

		if (_race9 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race9 = new Race(event2, RACE9_NAME, RACE9_DESC);
			event2.getRaces().add(race9);
			race9.getAttendees().put(sco069, new RaceAttendee(race9, sco069, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco116, new RaceAttendee(race9, sco116, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco156, new RaceAttendee(race9, sco156, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco179, new RaceAttendee(race9, sco179, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco296, new RaceAttendee(race9, sco296, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco315, new RaceAttendee(race9, sco315, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco528, new RaceAttendee(race9, sco528, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco561, new RaceAttendee(race9, sco561, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco808, new RaceAttendee(race9, sco808, RaceAttendee.Type.PILOT));
			race9.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race9, "69,116,528,808,156,179,296,315,561"); //$NON-NLS-1$
			addLaps(race9, "69,116,528,808,179,156,315,561"); //$NON-NLS-1$
			addLaps(race9, "69,116,528,808,179,156,315"); //$NON-NLS-1$
			addLaps(race9, "69,116,528,808,179,156"); //$NON-NLS-1$
			addLaps(race9, "69,116,528,808,179,156"); //$NON-NLS-1$
			addLaps(race9, "69,116,528,808,179,156"); //$NON-NLS-1$
			addLaps(race9, "69,116,528,808"); //$NON-NLS-1$
			addLaps(race9, "69,116,528"); //$NON-NLS-1$
			raceDAO.persist(race9);

			DatabaseSession.commit();

			_race9 = race9;
		} finally {
			db.endSession();
		}
	}

	protected void createRace10Data() throws Exception {
		createEvent2Data();

		if (_race10 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race10 = new Race(event2, RACE10_NAME, RACE10_DESC);
			event2.getRaces().add(race10);
			race10.getAttendees().put(sco069, new RaceAttendee(race10, sco069, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco116, new RaceAttendee(race10, sco116, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco156, new RaceAttendee(race10, sco156, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco179, new RaceAttendee(race10, sco179, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco296, new RaceAttendee(race10, sco296, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco315, new RaceAttendee(race10, sco315, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco528, new RaceAttendee(race10, sco528, RaceAttendee.Type.PILOT));
			RaceAttendee att561 = new RaceAttendee(race10, sco561, RaceAttendee.Type.PILOT);
			att561.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit a mark")); //$NON-NLS-1$
			race10.getAttendees().put(sco561, att561);
			race10.getAttendees().put(sco808, new RaceAttendee(race10, sco808, RaceAttendee.Type.PILOT));
			race10.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race10, "69,116,179,808,528,156,296,315"); //$NON-NLS-1$
			addLaps(race10, "69,116,179,808,528,156,296"); //$NON-NLS-1$
			addLaps(race10, "69,116,179,808,528,156"); //$NON-NLS-1$
			addLaps(race10, "69,116,179,528,808"); //$NON-NLS-1$
			addLaps(race10, "69,116,179,528"); //$NON-NLS-1$
			addLaps(race10, "69,116,179,528"); //$NON-NLS-1$
			addLaps(race10, "69,116,179"); //$NON-NLS-1$
			raceDAO.persist(race10);

			DatabaseSession.commit();

			_race10 = race10;
		} finally {
			db.endSession();
		}
	}

	protected void createRace11Data() throws Exception {
		createEvent2Data();

		if (_race11 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race11 = new Race(event2, RACE11_NAME, RACE11_DESC);
			event2.getRaces().add(race11);
			race11.getAttendees().put(sco069, new RaceAttendee(race11, sco069, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco116, new RaceAttendee(race11, sco116, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco156, new RaceAttendee(race11, sco156, RaceAttendee.Type.PILOT));
			RaceAttendee att179 = new RaceAttendee(race11, sco179, RaceAttendee.Type.PILOT);
			att179.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit a mark")); //$NON-NLS-1$
			race11.getAttendees().put(sco179, att179);
			race11.getAttendees().put(sco296, new RaceAttendee(race11, sco296, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco315, new RaceAttendee(race11, sco315, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco528, new RaceAttendee(race11, sco528, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco561, new RaceAttendee(race11, sco561, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco808, new RaceAttendee(race11, sco808, RaceAttendee.Type.PILOT));
			race11.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race11, "116,179,808,528,156,69,296,315"); //$NON-NLS-1$
			addLaps(race11, "116,179,808,528,69,156,296"); //$NON-NLS-1$
			addLaps(race11, "116,179,69,808,528,156"); //$NON-NLS-1$
			addLaps(race11, "116,69,808,156,528,179"); //$NON-NLS-1$
			addLaps(race11, "116,69,808,528,156,179"); //$NON-NLS-1$
			addLaps(race11, "116,69,808,528,156"); //$NON-NLS-1$
			addLaps(race11, "116,69"); //$NON-NLS-1$
			raceDAO.persist(race11);

			DatabaseSession.commit();

			_race11 = race11;
		} finally {
			db.endSession();
		}
	}
}
