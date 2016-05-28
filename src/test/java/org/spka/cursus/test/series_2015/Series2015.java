/*
	cursus - Race series management program
	Copyright 2015-2016  Simon Arlott

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
import eu.lp0.cursus.db.data.Penalty;
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

	protected static final int SERIES_FLEET = 11;
	protected static final int SERIES_FLEET_AT_EVENT1 = 7;
	protected static final int SERIES_FLEET_AT_EVENT2 = 11;
	protected static final int SERIES_FLEET_AT_EVENT3 = 13;
	protected static final int SERIES_FLEET_AT_EVENT4 = 13;
	protected static final int SERIES_FLEET_AT_EVENT5 = 13;
	protected static final int SERIES_FLEET_AT_EVENT6 = 13;

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

	protected static final String EVENT2_NAME = "Race Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = "Luce Bay (06/12/2015)"; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 6;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = "Luce Bay (06/12/2015)"; //$NON-NLS-1$
	protected static final int RACE5_PILOTS = 6;
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = "Luce Bay (06/12/2015)"; //$NON-NLS-1$
	protected static final int RACE6_PILOTS = 6;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = "Luce Bay (06/12/2015)"; //$NON-NLS-1$
	protected static final int RACE7_PILOTS = 6;
	protected static final String RACE8_NAME = "Race 8"; //$NON-NLS-1$
	protected static final String RACE8_DESC = "Luce Bay (06/12/2015)"; //$NON-NLS-1$
	protected static final int RACE8_PILOTS = 6;

	protected static final String EVENT3_NAME = "Race Event 3"; //$NON-NLS-1$
	protected static final String EVENT3_DESC = "West Sands (13/02/2016 and 14/02/2016)"; //$NON-NLS-1$
	protected static final int EVENT3_FLEET = 8;
	protected static final String RACE9_NAME = "Race 9"; //$NON-NLS-1$
	protected static final String RACE9_DESC = "West Sands (13/02/2016)"; //$NON-NLS-1$
	protected static final int RACE9_PILOTS = 8;
	protected static final String RACE10_NAME = "Race 10"; //$NON-NLS-1$
	protected static final String RACE10_DESC = "West Sands (14/02/2016)"; //$NON-NLS-1$
	protected static final int RACE10_PILOTS = 8;
	protected static final String RACE11_NAME = "Race 11"; //$NON-NLS-1$
	protected static final String RACE11_DESC = "West Sands (14/02/2016)"; //$NON-NLS-1$
	protected static final int RACE11_PILOTS = 8;
	protected static final String RACE12_NAME = "Race 12"; //$NON-NLS-1$
	protected static final String RACE12_DESC = "West Sands (14/02/2016)"; //$NON-NLS-1$
	protected static final int RACE12_PILOTS = 8;

	protected static final String EVENT4_NAME = "Race Event 4"; //$NON-NLS-1$
	protected static final String EVENT4_DESC = "West Sands (10/04/2016)"; //$NON-NLS-1$
	protected static final int EVENT4_FLEET = 9;
	protected static final String RACE13_NAME = "Race 13"; //$NON-NLS-1$
	protected static final String RACE13_DESC = "West Sands (10/04/2016)"; //$NON-NLS-1$
	protected static final int RACE13_PILOTS = 9;
	protected static final String RACE14_NAME = "Race 14"; //$NON-NLS-1$
	protected static final String RACE14_DESC = "West Sands (10/04/2016)"; //$NON-NLS-1$
	protected static final int RACE14_PILOTS = 9;
	protected static final String RACE15_NAME = "Race 15"; //$NON-NLS-1$
	protected static final String RACE15_DESC = "West Sands (10/04/2016)"; //$NON-NLS-1$
	protected static final int RACE15_PILOTS = 9;

	protected static final String EVENT5_NAME = "Race Event 5"; //$NON-NLS-1$
	protected static final String EVENT5_DESC = "West Sands (07/05/2016 and 08/05/2016)"; //$NON-NLS-1$
	protected static final int EVENT5_FLEET = 7;
	protected static final String RACE16_NAME = "Race 16"; //$NON-NLS-1$
	protected static final String RACE16_DESC = "West Sands (07/05/2016)"; //$NON-NLS-1$
	protected static final int RACE16_PILOTS = 7;
	protected static final String RACE17_NAME = "Race 17"; //$NON-NLS-1$
	protected static final String RACE17_DESC = "West Sands (07/05/2016)"; //$NON-NLS-1$
	protected static final int RACE17_PILOTS = 7;
	protected static final String RACE18_NAME = "Race 18"; //$NON-NLS-1$
	protected static final String RACE18_DESC = "West Sands (07/05/2016)"; //$NON-NLS-1$
	protected static final int RACE18_PILOTS = 7;
	protected static final String RACE19_NAME = "Race 19"; //$NON-NLS-1$
	protected static final String RACE19_DESC = "West Sands (08/05/2016)"; //$NON-NLS-1$
	protected static final int RACE19_PILOTS = 7;
	protected static final String RACE20_NAME = "Race 20"; //$NON-NLS-1$
	protected static final String RACE20_DESC = "West Sands (08/05/2016)"; //$NON-NLS-1$
	protected static final int RACE20_PILOTS = 7;
	protected static final String RACE21_NAME = "Race 21"; //$NON-NLS-1$
	protected static final String RACE21_DESC = "West Sands (08/05/2016)"; //$NON-NLS-1$
	protected static final int RACE21_PILOTS = 7;

	protected static final String EVENT6_NAME = "Race Event 6"; //$NON-NLS-1$
	protected static final String EVENT6_DESC = "Luce Bay (28/05/2016)"; //$NON-NLS-1$
	protected static final int EVENT6_FLEET = 9;
	protected static final String RACE22_NAME = "Race 22"; //$NON-NLS-1$
	protected static final String RACE22_DESC = "Luce Bay (28/05/2016)"; //$NON-NLS-1$
	protected static final int RACE22_PILOTS = 9;
	protected static final String RACE23_NAME = "Race 23"; //$NON-NLS-1$
	protected static final String RACE23_DESC = "Luce Bay (28/05/2016)"; //$NON-NLS-1$
	protected static final int RACE23_PILOTS = 9;

	protected Class junior;
	protected Class _16inWheel;
	protected Pilot sco018;
	protected Pilot sco060;
	protected Pilot sco066;
	protected Pilot sco081;
	protected Pilot sco087;
	protected Pilot sco116;
	protected Pilot sco153;
	protected Pilot sco156;
	protected Pilot sco159;
	protected Pilot sco179;
	protected Pilot sco296;
	protected Pilot sco808;
	protected Pilot sco884;
	protected Pilot k854;

	private Series _series;
	private Event _event1;
	private Race _race1;
	private Race _race2;
	private Race _race3;
	private Race _race4;
	private Event _event2;
	private Race _race5;
	private Race _race6;
	private Race _race7;
	private Race _race8;
	private Event _event3;
	private Race _race9;
	private Race _race10;
	private Race _race11;
	private Race _race12;
	private Event _event4;
	private Race _race13;
	private Race _race14;
	private Race _race15;
	private Event _event5;
	private Race _race16;
	private Race _race17;
	private Race _race18;
	private Race _race19;
	private Race _race20;
	private Race _race21;
	private Event _event6;
	private Race _race22;
	private Race _race23;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
		createEvent2Races();
		createEvent3Races();
		createEvent4Races();
		createEvent5Races();
		createEvent6Races();
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
			// sco018.getClasses().add(_16inWheel); // Not Event 3
			series.getPilots().add(sco018);

			sco060 = new Pilot(series, "SCO060@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco066 = new Pilot(series, "SCO066@2013", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco066);

			sco081 = new Pilot(series, "SCO081@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco087 = new Pilot(series, "SCO087@2009", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco087.getClasses().add(_16inWheel);
			series.getPilots().add(sco087);

			sco116 = new Pilot(series, "SCO116@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco116);

			sco153 = new Pilot(series, "SCO153@2014", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco153.getClasses().add(_16inWheel);
			series.getPilots().add(sco153);

			sco156 = new Pilot(series, "SCO156@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco156);

			sco159 = new Pilot(series, "SCO159@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco179 = new Pilot(series, "SCO179@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco296 = new Pilot(series, "SCO296@2013", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco296);

			sco808 = new Pilot(series, "SCO808@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco808);

			sco884 = new Pilot(series, "SCO884@2015", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco884.getClasses().add(_16inWheel);
			series.getPilots().add(sco884);

			k854 = new Pilot(series, "K854@2015", Sex.MALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k854);

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
		createRace5Data();
		createRace6Data();
		createRace7Data();
		createRace8Data();
	}

	protected void createRace5Data() throws Exception {
		createEvent2Data();

		if (_race5 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race5 = new Race(event2, RACE5_NAME, RACE5_DESC);
			event2.getRaces().add(race5);
			race5.getAttendees().put(sco066, new RaceAttendee(race5, sco066, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco087, new RaceAttendee(race5, sco087, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco116, new RaceAttendee(race5, sco116, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco156, new RaceAttendee(race5, sco156, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco159, new RaceAttendee(race5, sco159, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco808, new RaceAttendee(race5, sco808, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "808,116,87,159,66,156"); //$NON-NLS-1$
			addLaps(race5, "116,808,159,87,66,156"); //$NON-NLS-1$
			addLaps(race5, "116,808,159,87,156,66"); //$NON-NLS-1$
			addLaps(race5, "116,808,159,87"); //$NON-NLS-1$
			addLaps(race5, "116,808,87,159"); //$NON-NLS-1$
			addLaps(race5, "116,808"); //$NON-NLS-1$
			addLaps(race5, "116,808"); //$NON-NLS-1$
			raceDAO.persist(race5);

			DatabaseSession.commit();

			_race2 = race5;
		} finally {
			db.endSession();
		}
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
			race6.getAttendees().put(sco066, new RaceAttendee(race6, sco066, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco087, new RaceAttendee(race6, sco087, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco116, new RaceAttendee(race6, sco116, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco156, new RaceAttendee(race6, sco156, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco159, new RaceAttendee(race6, sco159, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco808, new RaceAttendee(race6, sco808, RaceAttendee.Type.PILOT));
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race6, "808,116,159,87,156,66"); //$NON-NLS-1$
			addLaps(race6, "116,808,159,87,156,66"); //$NON-NLS-1$
			addLaps(race6, "116,808,159,87,156,66"); //$NON-NLS-1$
			addLaps(race6, "116,808,159,87,156,66"); //$NON-NLS-1$
			addLaps(race6, "116,808,159,87,156"); //$NON-NLS-1$
			addLaps(race6, "116,808,159,87"); //$NON-NLS-1$
			addLaps(race6, "116,808,159"); //$NON-NLS-1$
			addLaps(race6, "116,808"); //$NON-NLS-1$
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
			race7.getAttendees().put(sco066, new RaceAttendee(race7, sco066, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco087, new RaceAttendee(race7, sco087, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco116, new RaceAttendee(race7, sco116, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco156, new RaceAttendee(race7, sco156, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco159, new RaceAttendee(race7, sco159, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco808, new RaceAttendee(race7, sco808, RaceAttendee.Type.PILOT));
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race7, "116,87,808,159,66,156"); //$NON-NLS-1$
			addLaps(race7, "116,808,159,87"); //$NON-NLS-1$
			addLaps(race7, "116,808,159"); //$NON-NLS-1$
			addLaps(race7, "116,808"); //$NON-NLS-1$
			addLaps(race7, "116"); //$NON-NLS-1$
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
			race8.getAttendees().put(sco066, new RaceAttendee(race8, sco066, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco087, new RaceAttendee(race8, sco087, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco116, new RaceAttendee(race8, sco116, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco156, new RaceAttendee(race8, sco156, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco159, new RaceAttendee(race8, sco159, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco808, new RaceAttendee(race8, sco808, RaceAttendee.Type.PILOT));
			race8.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race8, "116,159,66"); //$NON-NLS-1$
			addLaps(race8, "116,159"); //$NON-NLS-1$
			addLaps(race8, "116"); //$NON-NLS-1$
			addLaps(race8, "116"); //$NON-NLS-1$
			raceDAO.persist(race8);

			DatabaseSession.commit();

			_race8 = race8;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent3Data() throws Exception {
		createSeriesData();

		if (_event3 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);

			Event event3 = new Event(series, EVENT3_NAME, EVENT3_DESC);
			series.getEvents().add(event3);
			eventDAO.persist(event3);

			DatabaseSession.commit();

			_event3 = event3;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent3Races() throws Exception {
		createRace9Data();
		createRace10Data();
		createRace11Data();
		createRace12Data();
	}

	protected void createRace9Data() throws Exception {
		createEvent3Data();

		if (_race9 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			Race race9 = new Race(event3, RACE9_NAME, RACE9_DESC);
			event3.getRaces().add(race9);
			race9.getAttendees().put(sco018, new RaceAttendee(race9, sco018, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco066, new RaceAttendee(race9, sco066, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco116, new RaceAttendee(race9, sco116, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco156, new RaceAttendee(race9, sco156, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco179, new RaceAttendee(race9, sco179, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco296, new RaceAttendee(race9, sco296, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco808, new RaceAttendee(race9, sco808, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco884, new RaceAttendee(race9, sco884, RaceAttendee.Type.PILOT));
			race9.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race9, "116,179,808,18,66,156,884"); //$NON-NLS-1$
			addLaps(race9, "116,179,808,156,66,884"); //$NON-NLS-1$
			addLaps(race9, "116,179,808,66,156"); //$NON-NLS-1$
			addLaps(race9, "116,179,808,156,66"); //$NON-NLS-1$
			addLaps(race9, "116,808,179,156,66"); //$NON-NLS-1$
			addLaps(race9, "116,808,179"); //$NON-NLS-1$
			addLaps(race9, "116"); //$NON-NLS-1$
			raceDAO.persist(race9);

			DatabaseSession.commit();

			_race9 = race9;
		} finally {
			db.endSession();
		}
	}

	protected void createRace10Data() throws Exception {
		createEvent3Data();

		if (_race10 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			Race race10 = new Race(event3, RACE10_NAME, RACE10_DESC);
			event3.getRaces().add(race10);
			race10.getAttendees().put(sco066, new RaceAttendee(race10, sco066, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco116, new RaceAttendee(race10, sco116, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco156, new RaceAttendee(race10, sco156, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco179, new RaceAttendee(race10, sco179, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco296, new RaceAttendee(race10, sco296, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco808, new RaceAttendee(race10, sco808, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco884, new RaceAttendee(race10, sco884, RaceAttendee.Type.PILOT));
			race10.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race10, "808,116,179,156,296,884,66"); //$NON-NLS-1$
			addLaps(race10, "808,116,179,156,884,66,296"); //$NON-NLS-1$
			addLaps(race10, "116,808,179,156"); //$NON-NLS-1$
			addLaps(race10, "116,808,179"); //$NON-NLS-1$
			addLaps(race10, "116,808,179"); //$NON-NLS-1$
			addLaps(race10, "116,808"); //$NON-NLS-1$
			raceDAO.persist(race10);

			DatabaseSession.commit();

			_race10 = race10;
		} finally {
			db.endSession();
		}
	}

	protected void createRace11Data() throws Exception {
		createEvent3Data();

		if (_race11 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			Race race11 = new Race(event3, RACE11_NAME, RACE11_DESC);
			event3.getRaces().add(race11);
			race11.getAttendees().put(sco066, new RaceAttendee(race11, sco066, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco116, new RaceAttendee(race11, sco116, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco156, new RaceAttendee(race11, sco156, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco179, new RaceAttendee(race11, sco179, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco296, new RaceAttendee(race11, sco296, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco808, new RaceAttendee(race11, sco808, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco884, new RaceAttendee(race11, sco884, RaceAttendee.Type.PILOT));
			race11.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race11, "116,179,808,66,884,156,296"); //$NON-NLS-1$
			addLaps(race11, "116,179,808,66,884,156"); //$NON-NLS-1$
			addLaps(race11, "116,179,808,66"); //$NON-NLS-1$
			addLaps(race11, "116,179,808"); //$NON-NLS-1$
			addLaps(race11, "116,179,808"); //$NON-NLS-1$
			addLaps(race11, "116"); //$NON-NLS-1$
			raceDAO.persist(race11);

			DatabaseSession.commit();

			_race11 = race11;
		} finally {
			db.endSession();
		}
	}

	protected void createRace12Data() throws Exception {
		createEvent3Data();

		if (_race12 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			Race race12 = new Race(event3, RACE12_NAME, RACE12_DESC);
			event3.getRaces().add(race12);
			race12.getAttendees().put(sco066, new RaceAttendee(race12, sco066, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco116, new RaceAttendee(race12, sco116, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco156, new RaceAttendee(race12, sco156, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco179, new RaceAttendee(race12, sco179, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco296, new RaceAttendee(race12, sco296, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco808, new RaceAttendee(race12, sco808, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco884, new RaceAttendee(race12, sco884, RaceAttendee.Type.PILOT));
			race12.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race12, "116,179,808,156,66,884,296"); //$NON-NLS-1$
			addLaps(race12, "116,179,808,156,66,884"); //$NON-NLS-1$
			addLaps(race12, "116,179,808,156,66"); //$NON-NLS-1$
			addLaps(race12, "116,179,808,156"); //$NON-NLS-1$
			addLaps(race12, "116,179"); //$NON-NLS-1$
			raceDAO.persist(race12);

			DatabaseSession.commit();

			_race12 = race12;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent4Data() throws Exception {
		createSeriesData();

		if (_event4 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);

			Event event4 = new Event(series, EVENT4_NAME, EVENT4_DESC);
			series.getEvents().add(event4);
			eventDAO.persist(event4);

			DatabaseSession.commit();

			_event4 = event4;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent4Races() throws Exception {
		createRace13Data();
		createRace14Data();
		createRace15Data();
	}

	protected void createRace13Data() throws Exception {
		createEvent4Data();

		if (_race13 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race13 = new Race(event4, RACE13_NAME, RACE13_DESC);
			event4.getRaces().add(race13);
			race13.getAttendees().put(sco018, new RaceAttendee(race13, sco018, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco066, new RaceAttendee(race13, sco066, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco116, new RaceAttendee(race13, sco116, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco156, new RaceAttendee(race13, sco156, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco159, new RaceAttendee(race13, sco159, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco179, new RaceAttendee(race13, sco179, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco296, new RaceAttendee(race13, sco296, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco808, new RaceAttendee(race13, sco808, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(k854, new RaceAttendee(race13, k854, RaceAttendee.Type.PILOT));
			race13.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race13, "854,116,808,179,18,156"); //$NON-NLS-1$
			addLaps(race13, "854,116,179,66,296,18,808"); //$NON-NLS-1$
			addLaps(race13, "854,179,116,159,156,808"); //$NON-NLS-1$
			addLaps(race13, "854,18,179,116,159"); //$NON-NLS-1$
			addLaps(race13, "854,179,156,18,116,296,808"); //$NON-NLS-1$
			addLaps(race13, "854,179,159,116,18,156,808,296"); //$NON-NLS-1$
			raceDAO.persist(race13);

			DatabaseSession.commit();

			_race13 = race13;
		} finally {
			db.endSession();
		}
	}

	protected void createRace14Data() throws Exception {
		createEvent4Data();

		if (_race14 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race14 = new Race(event4, RACE14_NAME, RACE14_DESC);
			event4.getRaces().add(race14);
			RaceAttendee att018 = new RaceAttendee(race14, sco018, RaceAttendee.Type.PILOT);
			att018.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 1, "Hit a mark")); //$NON-NLS-1$
			race14.getAttendees().put(sco018, att018);
			race14.getAttendees().put(sco066, new RaceAttendee(race14, sco066, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco116, new RaceAttendee(race14, sco116, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco156, new RaceAttendee(race14, sco156, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco159, new RaceAttendee(race14, sco159, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco179, new RaceAttendee(race14, sco179, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco296, new RaceAttendee(race14, sco296, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco808, new RaceAttendee(race14, sco808, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(k854, new RaceAttendee(race14, k854, RaceAttendee.Type.PILOT));
			race14.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race14, "116,854,179,808,159,156"); //$NON-NLS-1$
			addLaps(race14, "116,854,179,18,808"); //$NON-NLS-1$
			addLaps(race14, "116,159,179,854,808"); //$NON-NLS-1$
			addLaps(race14, "116,156,159,179,854"); //$NON-NLS-1$
			addLaps(race14, "116,179,159,854,296,156,808"); //$NON-NLS-1$
			raceDAO.persist(race14);

			DatabaseSession.commit();

			_race14 = race14;
		} finally {
			db.endSession();
		}
	}

	protected void createRace15Data() throws Exception {
		createEvent4Data();

		if (_race15 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race15 = new Race(event4, RACE15_NAME, RACE15_DESC);
			event4.getRaces().add(race15);
			race15.getAttendees().put(sco018, new RaceAttendee(race15, sco018, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco066, new RaceAttendee(race15, sco066, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco116, new RaceAttendee(race15, sco116, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco156, new RaceAttendee(race15, sco156, RaceAttendee.Type.PILOT));
			RaceAttendee att159 = new RaceAttendee(race15, sco159, RaceAttendee.Type.PILOT);
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 1, "Hit a mark")); //$NON-NLS-1$
			race15.getAttendees().put(sco159, att159);
			race15.getAttendees().put(sco179, new RaceAttendee(race15, sco179, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco296, new RaceAttendee(race15, sco296, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco808, new RaceAttendee(race15, sco808, RaceAttendee.Type.PILOT));
			RaceAttendee att854 = new RaceAttendee(race15, k854, RaceAttendee.Type.PILOT);
			att854.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 1, "Hit a mark")); //$NON-NLS-1$
			race15.getAttendees().put(k854, att854);
			race15.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race15, "854,179,116,808,159,156,66,18,296"); //$NON-NLS-1$
			addLaps(race15, "854,116,179,808,159,156,66,18"); //$NON-NLS-1$
			addLaps(race15, "854,116,179,808,159,156,18,66"); //$NON-NLS-1$
			addLaps(race15, "116,854,808,179,156,18,159,66"); //$NON-NLS-1$
			addLaps(race15, "116,854,808,179,156,18,159"); //$NON-NLS-1$
			addLaps(race15, "116,808,179,854"); //$NON-NLS-1$
			raceDAO.persist(race15);

			DatabaseSession.commit();

			_race15 = race15;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent5Data() throws Exception {
		createSeriesData();

		if (_event5 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);

			Event event5 = new Event(series, EVENT5_NAME, EVENT5_DESC);
			series.getEvents().add(event5);
			eventDAO.persist(event5);

			DatabaseSession.commit();

			_event5 = event5;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent5Races() throws Exception {
		createRace16Data();
		createRace17Data();
		createRace18Data();
		createRace19Data();
		createRace20Data();
		createRace21Data();
	}

	protected void createRace16Data() throws Exception {
		createEvent5Data();

		if (_race16 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race16 = new Race(event5, RACE16_NAME, RACE16_DESC);
			event5.getRaces().add(race16);
			race16.getAttendees().put(sco018, new RaceAttendee(race16, sco018, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco066, new RaceAttendee(race16, sco066, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco116, new RaceAttendee(race16, sco116, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco159, new RaceAttendee(race16, sco159, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco179, new RaceAttendee(race16, sco179, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco296, new RaceAttendee(race16, sco296, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco884, new RaceAttendee(race16, sco884, RaceAttendee.Type.PILOT));
			race16.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race16, "179,116,159,18,66,884,296"); //$NON-NLS-1$
			addLaps(race16, "179,116,159,18,66,884,296"); //$NON-NLS-1$
			addLaps(race16, "179,116,159,18,66,296,884"); //$NON-NLS-1$
			addLaps(race16, "179,116,159,18,66,296,884"); //$NON-NLS-1$
			addLaps(race16, "179,116,159,18,66,296"); //$NON-NLS-1$
			addLaps(race16, "116,179,159,18,66"); //$NON-NLS-1$
			addLaps(race16, "116,179,159,18,66"); //$NON-NLS-1$
			addLaps(race16, "116,179"); //$NON-NLS-1$
			raceDAO.persist(race16);

			DatabaseSession.commit();

			_race16 = race16;
		} finally {
			db.endSession();
		}
	}

	protected void createRace17Data() throws Exception {
		createEvent5Data();

		if (_race17 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race17 = new Race(event5, RACE17_NAME, RACE17_DESC);
			event5.getRaces().add(race17);
			race17.getAttendees().put(sco018, new RaceAttendee(race17, sco018, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco066, new RaceAttendee(race17, sco066, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco116, new RaceAttendee(race17, sco116, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco159, new RaceAttendee(race17, sco159, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco179, new RaceAttendee(race17, sco179, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco296, new RaceAttendee(race17, sco296, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco884, new RaceAttendee(race17, sco884, RaceAttendee.Type.PILOT));
			race17.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race17, "116,66,18,159,884,296,179"); //$NON-NLS-1$
			addLaps(race17, "116,18,66,296,159,179"); //$NON-NLS-1$
			addLaps(race17, "116,18,66,159,296,179"); //$NON-NLS-1$
			addLaps(race17, "116,18,66,159,296,179"); //$NON-NLS-1$
			addLaps(race17, "116,18,66,159,296"); //$NON-NLS-1$
			addLaps(race17, "116,18,66,159"); //$NON-NLS-1$
			addLaps(race17, "116,18,66"); //$NON-NLS-1$
			addLaps(race17, "116"); //$NON-NLS-1$
			raceDAO.persist(race17);

			DatabaseSession.commit();

			_race17 = race17;
		} finally {
			db.endSession();
		}
	}

	protected void createRace18Data() throws Exception {
		createEvent5Data();

		if (_race18 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race18 = new Race(event5, RACE18_NAME, RACE18_DESC);
			event5.getRaces().add(race18);
			race18.getAttendees().put(sco018, new RaceAttendee(race18, sco018, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco066, new RaceAttendee(race18, sco066, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco116, new RaceAttendee(race18, sco116, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco159, new RaceAttendee(race18, sco159, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco179, new RaceAttendee(race18, sco179, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco296, new RaceAttendee(race18, sco296, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco884, new RaceAttendee(race18, sco884, RaceAttendee.Type.PILOT));
			race18.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race18, "116,179,159,18,296,884,66"); //$NON-NLS-1$
			addLaps(race18, "116,179,159,18,296,884,66"); //$NON-NLS-1$
			addLaps(race18, "116,179,159,18,296,66,884"); //$NON-NLS-1$
			addLaps(race18, "116,179,159,18,296"); //$NON-NLS-1$
			addLaps(race18, "116,179,159,18,296"); //$NON-NLS-1$
			addLaps(race18, "116,179,159,18"); //$NON-NLS-1$
			addLaps(race18, "116,179,159,18"); //$NON-NLS-1$
			addLaps(race18, "116,179"); //$NON-NLS-1$
			raceDAO.persist(race18);

			DatabaseSession.commit();

			_race18 = race18;
		} finally {
			db.endSession();
		}
	}

	protected void createRace19Data() throws Exception {
		createEvent5Data();

		if (_race19 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race19 = new Race(event5, RACE19_NAME, RACE19_DESC);
			event5.getRaces().add(race19);
			race19.getAttendees().put(sco018, new RaceAttendee(race19, sco018, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco066, new RaceAttendee(race19, sco066, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco116, new RaceAttendee(race19, sco116, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco159, new RaceAttendee(race19, sco159, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco179, new RaceAttendee(race19, sco179, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco296, new RaceAttendee(race19, sco296, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco884, new RaceAttendee(race19, sco884, RaceAttendee.Type.PILOT));
			race19.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race19, "116,179,159,18,66,296"); //$NON-NLS-1$
			addLaps(race19, "116,179,18,66,159,296"); //$NON-NLS-1$
			addLaps(race19, "116,179,18,66,159"); //$NON-NLS-1$
			addLaps(race19, "116,179,18,66,159"); //$NON-NLS-1$
			addLaps(race19, "116,179,18,66"); //$NON-NLS-1$
			addLaps(race19, "116,179"); //$NON-NLS-1$
			raceDAO.persist(race19);

			DatabaseSession.commit();

			_race19 = race19;
		} finally {
			db.endSession();
		}
	}

	protected void createRace20Data() throws Exception {
		createEvent5Data();

		if (_race20 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race20 = new Race(event5, RACE20_NAME, RACE20_DESC);
			event5.getRaces().add(race20);
			race20.getAttendees().put(sco018, new RaceAttendee(race20, sco018, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco066, new RaceAttendee(race20, sco066, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco116, new RaceAttendee(race20, sco116, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco159, new RaceAttendee(race20, sco159, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco179, new RaceAttendee(race20, sco179, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco296, new RaceAttendee(race20, sco296, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco884, new RaceAttendee(race20, sco884, RaceAttendee.Type.PILOT));
			race20.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race20, "116,179,159,66,18,296"); //$NON-NLS-1$
			addLaps(race20, "116,179,159,18,66,296"); //$NON-NLS-1$
			addLaps(race20, "116,179,159,18,66"); //$NON-NLS-1$
			addLaps(race20, "116,179,159,18,66"); //$NON-NLS-1$
			addLaps(race20, "116,179,159,18,66"); //$NON-NLS-1$
			addLaps(race20, "116,179"); //$NON-NLS-1$
			raceDAO.persist(race20);

			DatabaseSession.commit();

			_race20 = race20;
		} finally {
			db.endSession();
		}
	}

	protected void createRace21Data() throws Exception {
		createEvent5Data();

		if (_race21 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race21 = new Race(event5, RACE21_NAME, RACE21_DESC);
			event5.getRaces().add(race21);
			race21.getAttendees().put(sco018, new RaceAttendee(race21, sco018, RaceAttendee.Type.PILOT));
			RaceAttendee att066 = new RaceAttendee(race21, sco066, RaceAttendee.Type.PILOT);
			att066.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 1, "Hit start line mark")); //$NON-NLS-1$
			race21.getAttendees().put(sco066, att066);
			race21.getAttendees().put(sco116, new RaceAttendee(race21, sco116, RaceAttendee.Type.PILOT));
			race21.getAttendees().put(sco159, new RaceAttendee(race21, sco159, RaceAttendee.Type.PILOT));
			race21.getAttendees().put(sco179, new RaceAttendee(race21, sco179, RaceAttendee.Type.PILOT));
			RaceAttendee att296 = new RaceAttendee(race21, sco296, RaceAttendee.Type.PILOT);
			att296.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 1, "Hit start line mark")); //$NON-NLS-1$
			race21.getAttendees().put(sco296, att296);
			race21.getAttendees().put(sco884, new RaceAttendee(race21, sco884, RaceAttendee.Type.PILOT));
			race21.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race21, "116,159,179,66,18"); //$NON-NLS-1$
			addLaps(race21, "116,179,159,66"); //$NON-NLS-1$
			addLaps(race21, "116,159,179"); //$NON-NLS-1$
			raceDAO.persist(race21);

			DatabaseSession.commit();

			_race21 = race21;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent6Data() throws Exception {
		createSeriesData();

		if (_event6 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);

			Event event6 = new Event(series, EVENT6_NAME, EVENT6_DESC);
			series.getEvents().add(event6);
			eventDAO.persist(event6);

			DatabaseSession.commit();

			_event6 = event6;
		} finally {
			db.endSession();
		}
	}

	protected void createEvent6Races() throws Exception {
		createRace22Data();
		createRace23Data();
	}

	protected void createRace22Data() throws Exception {
		createEvent6Data();

		if (_race22 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT6_NAME);

			Race race22 = new Race(event5, RACE22_NAME, RACE22_DESC);
			event5.getRaces().add(race22);
			race22.getAttendees().put(sco018, new RaceAttendee(race22, sco018, RaceAttendee.Type.PILOT));
			race22.getAttendees().put(sco066, new RaceAttendee(race22, sco066, RaceAttendee.Type.PILOT));
			race22.getAttendees().put(sco087, new RaceAttendee(race22, sco087, RaceAttendee.Type.PILOT));
			race22.getAttendees().put(sco116, new RaceAttendee(race22, sco116, RaceAttendee.Type.PILOT));
			race22.getAttendees().put(sco156, new RaceAttendee(race22, sco156, RaceAttendee.Type.PILOT));
			race22.getAttendees().put(sco159, new RaceAttendee(race22, sco159, RaceAttendee.Type.PILOT));
			race22.getAttendees().put(sco296, new RaceAttendee(race22, sco296, RaceAttendee.Type.PILOT));
			race22.getAttendees().put(sco808, new RaceAttendee(race22, sco808, RaceAttendee.Type.PILOT));
			race22.getAttendees().put(sco884, new RaceAttendee(race22, sco884, RaceAttendee.Type.PILOT));
			race22.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race22, "116,808,66,159,18,87"); //$NON-NLS-1$
			addLaps(race22, "116,808,66,159,18,87"); //$NON-NLS-1$
			addLaps(race22, "116,808,66,159"); //$NON-NLS-1$
			raceDAO.persist(race22);

			DatabaseSession.commit();

			_race22 = race22;
		} finally {
			db.endSession();
		}
	}

	protected void createRace23Data() throws Exception {
		createEvent6Data();

		if (_race23 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);

			Race race23 = new Race(event6, RACE23_NAME, RACE23_DESC);
			event6.getRaces().add(race23);
			race23.getAttendees().put(sco018, new RaceAttendee(race23, sco018, RaceAttendee.Type.PILOT));
			race23.getAttendees().put(sco066, new RaceAttendee(race23, sco066, RaceAttendee.Type.PILOT));
			race23.getAttendees().put(sco087, new RaceAttendee(race23, sco087, RaceAttendee.Type.PILOT));
			race23.getAttendees().put(sco116, new RaceAttendee(race23, sco116, RaceAttendee.Type.PILOT));
			race23.getAttendees().put(sco156, new RaceAttendee(race23, sco156, RaceAttendee.Type.PILOT));
			race23.getAttendees().put(sco159, new RaceAttendee(race23, sco159, RaceAttendee.Type.PILOT));
			race23.getAttendees().put(sco296, new RaceAttendee(race23, sco296, RaceAttendee.Type.PILOT));
			race23.getAttendees().put(sco808, new RaceAttendee(race23, sco808, RaceAttendee.Type.PILOT));
			race23.getAttendees().put(sco884, new RaceAttendee(race23, sco884, RaceAttendee.Type.PILOT));
			race23.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race23, "808,116,66,159,156"); //$NON-NLS-1$
			addLaps(race23, "808,116,66,159"); //$NON-NLS-1$
			raceDAO.persist(race23);

			DatabaseSession.commit();

			_race23 = race23;
		} finally {
			db.endSession();
		}
	}
}
