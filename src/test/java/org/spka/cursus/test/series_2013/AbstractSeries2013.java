/*
	cursus - Race series management program
	Copyright 2013-2014  Simon Arlott

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
package org.spka.cursus.test.series_2013;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSeries;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Class;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Gender;
import eu.lp0.cursus.db.data.Penalty;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.RaceAttendee;
import eu.lp0.cursus.db.data.RaceNumber;
import eu.lp0.cursus.db.data.RaceTally;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.scoring.scorer.Scorer;
import eu.lp0.cursus.scoring.scorer.ScorerFactory;

public abstract class AbstractSeries2013 extends AbstractSeries {
	protected static final String SERIES_NAME = "SPKA Race Series 2013/14"; //$NON-NLS-1$
	protected static final int SERIES_FLEET = 18;
	protected static final int SERIES_FLEET_AT_EVENT1 = 11;
	protected static final int SERIES_FLEET_AT_EVENT2 = 12;
	protected static final int SERIES_FLEET_AT_EVENT3 = 14;
	protected static final int SERIES_FLEET_AT_EVENT4 = 17;
	protected static final int SERIES_FLEET_AT_EVENT5 = 18;
	protected static final int SERIES_FLEET_AT_EVENT6 = 18;

	protected static final String EVENT1_NAME = "Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = "Luce Bay (26/10/2013)"; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 11;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = "Luce Bay (26/10/2013)"; //$NON-NLS-1$
	protected static final int RACE1_PILOTS = 11;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = "Luce Bay (26/10/2013)"; //$NON-NLS-1$
	protected static final int RACE2_PILOTS = 11;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = "Luce Bay (26/10/2013)"; //$NON-NLS-1$
	protected static final int RACE3_PILOTS = 11;

	protected static final String EVENT2_NAME = "Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = "West Sands (08/12/2013)"; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 10;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = "West Sands (08/12/2013)"; //$NON-NLS-1$
	protected static final int RACE4_PILOTS = 10;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = "West Sands (08/12/2013)"; //$NON-NLS-1$
	protected static final int RACE5_PILOTS = 10;

	protected static final String EVENT3_NAME = "Event 3"; //$NON-NLS-1$
	protected static final String EVENT3_DESC = "West Sands (04/01/2014)"; //$NON-NLS-1$
	protected static final int EVENT3_FLEET = 11;
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = "West Sands (04/01/2014)"; //$NON-NLS-1$
	protected static final int RACE6_PILOTS = 11;

	protected static final String EVENT4_NAME = "Event 4"; //$NON-NLS-1$
	protected static final String EVENT4_DESC = "West Sands (22/02/2014)"; //$NON-NLS-1$
	protected static final int EVENT4_FLEET = 13;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = "West Sands (22/02/2014)"; //$NON-NLS-1$
	protected static final int RACE7_PILOTS = 13;
	protected static final String RACE8_NAME = "Race 8"; //$NON-NLS-1$
	protected static final String RACE8_DESC = "West Sands (22/02/2014)"; //$NON-NLS-1$
	protected static final int RACE8_PILOTS = 13;
	protected static final String RACE9_NAME = "Race 9"; //$NON-NLS-1$
	protected static final String RACE9_DESC = "West Sands (22/02/2014)"; //$NON-NLS-1$
	protected static final int RACE9_PILOTS = 13;
	protected static final String RACE10_NAME = "Race 10"; //$NON-NLS-1$
	protected static final String RACE10_DESC = "West Sands (22/02/2014)"; //$NON-NLS-1$
	protected static final int RACE10_PILOTS = 13;

	protected static final String EVENT5_NAME = "Event 5"; //$NON-NLS-1$
	protected static final String EVENT5_DESC = "West Sands (22/03/2014 and 23/03/2014)"; //$NON-NLS-1$
	protected static final int EVENT5_FLEET = 13;
	protected static final String RACE11_NAME = "Race 11"; //$NON-NLS-1$
	protected static final String RACE11_DESC = "West Sands (22/03/2014)"; //$NON-NLS-1$
	protected static final int RACE11_PILOTS = 13;
	protected static final String RACE12_NAME = "Race 12"; //$NON-NLS-1$
	protected static final String RACE12_DESC = "West Sands (22/03/2014)"; //$NON-NLS-1$
	protected static final int RACE12_PILOTS = 13;
	protected static final String RACE13_NAME = "Race 13"; //$NON-NLS-1$
	protected static final String RACE13_DESC = "West Sands (22/03/2014)"; //$NON-NLS-1$
	protected static final int RACE13_PILOTS = 13;
	protected static final String RACE14_NAME = "Race 14"; //$NON-NLS-1$
	protected static final String RACE14_DESC = "West Sands (22/03/2014)"; //$NON-NLS-1$
	protected static final int RACE14_PILOTS = 13;
	protected static final String RACE15_NAME = "Race 15"; //$NON-NLS-1$
	protected static final String RACE15_DESC = "West Sands (23/03/2014)"; //$NON-NLS-1$
	protected static final int RACE15_PILOTS = 13;
	protected static final String RACE16_NAME = "Race 16"; //$NON-NLS-1$
	protected static final String RACE16_DESC = "West Sands (23/03/2014)"; //$NON-NLS-1$
	protected static final int RACE16_PILOTS = 13;
	protected static final String RACE17_NAME = "Race 17"; //$NON-NLS-1$
	protected static final String RACE17_DESC = "West Sands (23/03/2014)"; //$NON-NLS-1$
	protected static final int RACE17_PILOTS = 13;
	protected static final String RACE18_NAME = "Race 18"; //$NON-NLS-1$
	protected static final String RACE18_DESC = "West Sands (23/03/2014)"; //$NON-NLS-1$
	protected static final int RACE18_PILOTS = 13;

	protected static final String EVENT6_NAME = "Event 6"; //$NON-NLS-1$
	protected static final String EVENT6_DESC = "Fraserburgh Esplanade (05/04/2014)"; //$NON-NLS-1$
	protected static final int EVENT6_FLEET = 13;
	protected static final String RACE19_NAME = "Race 19"; //$NON-NLS-1$
	protected static final String RACE19_DESC = "Fraserburgh Esplanade (05/04/2014)"; //$NON-NLS-1$
	protected static final int RACE19_PILOTS = 13;
	protected static final String RACE20_NAME = "Race 20"; //$NON-NLS-1$
	protected static final String RACE20_DESC = "Fraserburgh Esplanade (05/04/2014)"; //$NON-NLS-1$
	protected static final int RACE20_PILOTS = 13;

	protected Scorer scorer = ScorerFactory.newScorer(SPKAConstants.UUID_2012);

	protected Class junior;
	protected Class _16inWheel;
	protected Pilot sco018;
	protected Pilot sco066;
	protected Pilot sco069;
	protected Pilot sco081;
	protected Pilot sco087;
	protected Pilot sco116;
	protected Pilot sco117;
	protected Pilot sco153;
	protected Pilot sco156;
	protected Pilot sco159;
	protected Pilot sco179;
	protected Pilot sco249;
	protected Pilot sco296;
	protected Pilot sco315;
	protected Pilot sco528;
	protected Pilot sco561;
	protected Pilot sco666;
	protected Pilot sco808;

	private Series _series;
	private Event _event1;
	private Race _race1;
	private Race _race2;
	private Race _race3;
	private Event _event2;
	private Race _race4;
	private Race _race5;
	private Event _event3;
	private Race _race6;
	private Event _event4;
	private Race _race7;
	private Race _race8;
	private Race _race9;
	private Race _race10;
	private Event _event5;
	private Race _race11;
	private Race _race12;
	private Race _race13;
	private Race _race14;
	private Race _race15;
	private Race _race16;
	private Race _race17;
	private Race _race18;
	private Event _event6;
	private Race _race19;
	private Race _race20;

	protected void createSeriesData() throws Exception {
		if (_series != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			// Create the 2013/14 series
			Series series = new Series(SERIES_NAME);

			// Create classes
			junior = new Class(series, "Junior"); //$NON-NLS-1$
			series.getClasses().add(junior);

			_16inWheel = new Class(series, "16\" Wheel"); //$NON-NLS-1$
			series.getClasses().add(_16inWheel);

			// Add all the pilots
			sco018 = new Pilot(series, "SCO018", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco018);

			sco066 = new Pilot(series, "SCO066", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco066.getClasses().add(_16inWheel);
			series.getPilots().add(sco066);

			sco069 = new Pilot(series, "SCO069", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco069);

			sco081 = new Pilot(series, "SCO081", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco087 = new Pilot(series, "SCO087", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco087);

			sco116 = new Pilot(series, "SCO116", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco116);

			sco117 = new Pilot(series, "SCO117", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco117);

			sco153 = new Pilot(series, "SCO153", Gender.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco153.getClasses().add(_16inWheel);
			series.getPilots().add(sco153);

			sco156 = new Pilot(series, "SCO156", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco156.getClasses().add(junior);
			series.getPilots().add(sco156);

			sco159 = new Pilot(series, "SCO159", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco179 = new Pilot(series, "SCO179", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco249 = new Pilot(series, "SCO249", Gender.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco249);

			sco296 = new Pilot(series, "SCO296", Gender.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco296.getClasses().add(_16inWheel);
			series.getPilots().add(sco296);

			sco315 = new Pilot(series, "SCO315", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco315.getClasses().add(_16inWheel);
			series.getPilots().add(sco315);

			sco528 = new Pilot(series, "SCO528", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco528);

			sco561 = new Pilot(series, "SCO561", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco561);

			sco666 = new Pilot(series, "SCO666", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco666);

			sco808 = new Pilot(series, "SCO808", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco808);

			// Create race numbers
			for (Pilot pilot : series.getPilots()) {
				pilot.setRaceNumber(RaceNumber.valueOfFor(pilot.getName(), pilot));
			}

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
			race1.getAttendees().put(sco159, new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco296, new RaceAttendee(race1, sco296, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco561, new RaceAttendee(race1, sco561, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco808, new RaceAttendee(race1, sco808, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "69,179,808,116,18,159,87,156,66,296,561"); //$NON-NLS-1$
			addLaps(race1, "69,179,116,808,18,159,87,156,66,296,561"); //$NON-NLS-1$
			addLaps(race1, "69,179,116,808,159,18,156,87,66"); //$NON-NLS-1$
			addLaps(race1, "69,116,179,808,159,18,87,156"); //$NON-NLS-1$
			addLaps(race1, "69,116,179,159,18,808"); //$NON-NLS-1$
			addLaps(race1, "69,116,179,159,18"); //$NON-NLS-1$
			addLaps(race1, "69,116,179"); //$NON-NLS-1$
			addLaps(race1, "69,116,179"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco159, new RaceAttendee(race2, sco159, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco296, new RaceAttendee(race2, sco296, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco561, new RaceAttendee(race2, sco561, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco808, new RaceAttendee(race2, sco808, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "69,179,808,159,87,18,156,116,66,296"); //$NON-NLS-1$
			addLaps(race2, "69,179,808,159,87,18,116,156,66"); //$NON-NLS-1$
			addLaps(race2, "69,179,808,159,116,87,18,156,66"); //$NON-NLS-1$
			addLaps(race2, "69,159,116,87,18,808,156"); //$NON-NLS-1$
			addLaps(race2, "69,116,159,87"); //$NON-NLS-1$
			addLaps(race2, "69"); //$NON-NLS-1$
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
			race3.getAttendees().put(sco018, new RaceAttendee(race3, sco018, RaceAttendee.Type.V_SCORER));
			race3.getAttendees().put(sco066, new RaceAttendee(race3, sco066, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco069, new RaceAttendee(race3, sco069, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco087, new RaceAttendee(race3, sco087, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco116, new RaceAttendee(race3, sco116, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco156, new RaceAttendee(race3, sco156, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco296, new RaceAttendee(race3, sco296, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco561, new RaceAttendee(race3, sco561, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco808, new RaceAttendee(race3, sco808, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "69,116,808,159,179,87,156,66,561"); //$NON-NLS-1$
			addLaps(race3, "69,808,116,159,179,87,156,66"); //$NON-NLS-1$
			addLaps(race3, "69,808,116,179,159,87,156,66"); //$NON-NLS-1$
			addLaps(race3, "69,808,116,179,159,87,156"); //$NON-NLS-1$
			addLaps(race3, "808,69,116,179,159,87"); //$NON-NLS-1$
			addLaps(race3, "69,808,116,179,159"); //$NON-NLS-1$
			addLaps(race3, "69,808,116,179"); //$NON-NLS-1$
			addLaps(race3, "69,808,116"); //$NON-NLS-1$
			raceDAO.persist(race3);

			DatabaseSession.commit();

			_race3 = race3;
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
		createRace4Data();
		createRace5Data();
	}

	protected void createRace4Data() throws Exception {
		createEvent2Data();

		if (_race4 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race4 = new Race(event2, RACE4_NAME, RACE4_DESC);
			event2.getRaces().add(race4);
			race4.getAttendees().put(sco066, new RaceAttendee(race4, sco066, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco069, new RaceAttendee(race4, sco069, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco087, new RaceAttendee(race4, sco087, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco116, new RaceAttendee(race4, sco116, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco117, new RaceAttendee(race4, sco117, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco156, new RaceAttendee(race4, sco156, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco296, new RaceAttendee(race4, sco296, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco561, new RaceAttendee(race4, sco561, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco808, new RaceAttendee(race4, sco808, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "69,116,159,808,156,87"); //$NON-NLS-1$
			addLaps(race4, "116,69,159,117,808,296,87,156"); //$NON-NLS-1$
			addLaps(race4, "116,69,159,808,66,117"); //$NON-NLS-1$
			addLaps(race4, "116,69,156,87,159,296,808"); //$NON-NLS-1$
			addLaps(race4, "116,69,159,117,156,87,808"); //$NON-NLS-1$
			addLaps(race4, "116,69,159,296"); //$NON-NLS-1$
			addLaps(race4, "116,69,808,156,87,159,117"); //$NON-NLS-1$
			addLaps(race4, "116,69,808,156,66,159"); //$NON-NLS-1$
			addLaps(race4, "116,69,87,117,296,808,159,156"); //$NON-NLS-1$
			addLaps(race4, "116,69,87,808,117"); //$NON-NLS-1$
			addLaps(race4, "116,159,69,156,296,87,808,117"); //$NON-NLS-1$
			raceDAO.persist(race4);

			DatabaseSession.commit();

			_race4 = race4;
		} finally {
			db.endSession();
		}
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
			race5.getAttendees().put(sco069, new RaceAttendee(race5, sco069, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco087, new RaceAttendee(race5, sco087, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco116, new RaceAttendee(race5, sco116, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco117, new RaceAttendee(race5, sco117, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco156, new RaceAttendee(race5, sco156, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco159, new RaceAttendee(race5, sco159, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco296, new RaceAttendee(race5, sco296, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco561, new RaceAttendee(race5, sco561, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco808, new RaceAttendee(race5, sco808, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "69,116,808,159,156,87,117"); //$NON-NLS-1$
			addLaps(race5, "69,116,66,159,87,156"); //$NON-NLS-1$
			addLaps(race5, "69,116,296,117"); //$NON-NLS-1$
			addLaps(race5, "69,159,116,87,156,66,117"); //$NON-NLS-1$
			addLaps(race5, "69,116,159,296,87,156"); //$NON-NLS-1$
			addLaps(race5, "69,116,117,159,87,156"); //$NON-NLS-1$
			addLaps(race5, "69,116,296,117,159,808"); //$NON-NLS-1$
			addLaps(race5, "116,69,87,156,159"); //$NON-NLS-1$
			addLaps(race5, "116,808,117,87,296,156,69,159,66"); //$NON-NLS-1$
			raceDAO.persist(race5);

			DatabaseSession.commit();

			_race5 = race5;
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
		createRace6Data();
	}

	protected void createRace6Data() throws Exception {
		createEvent3Data();

		if (_race6 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			Race race6 = new Race(event3, RACE6_NAME, RACE6_DESC);
			event3.getRaces().add(race6);
			race6.getAttendees().put(sco018, new RaceAttendee(race6, sco018, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco069, new RaceAttendee(race6, sco069, RaceAttendee.Type.PILOT));
			RaceAttendee att116 = new RaceAttendee(race6, sco116, RaceAttendee.Type.PILOT);
			att116.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 2")); //$NON-NLS-1$
			race6.getAttendees().put(sco116, att116);
			race6.getAttendees().put(sco117, new RaceAttendee(race6, sco117, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco153, new RaceAttendee(race6, sco153, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco156, new RaceAttendee(race6, sco156, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco159, new RaceAttendee(race6, sco159, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco179, new RaceAttendee(race6, sco179, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco296, new RaceAttendee(race6, sco296, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco666, new RaceAttendee(race6, sco666, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco808, new RaceAttendee(race6, sco808, RaceAttendee.Type.PILOT));
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race6, "69,179,159,117,18,116,808,156,666"); //$NON-NLS-1$
			addLaps(race6, "69,179,159,117,18,116,808"); //$NON-NLS-1$
			addLaps(race6, "69,179,159"); //$NON-NLS-1$
			addLaps(race6, "69"); //$NON-NLS-1$
			raceDAO.persist(race6);

			DatabaseSession.commit();

			_race6 = race6;
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
		createRace7Data();
		createRace8Data();
		createRace9Data();
		createRace10Data();
	}

	protected void createRace7Data() throws Exception {
		createEvent4Data();

		if (_race7 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race7 = new Race(event4, RACE7_NAME, RACE7_DESC);
			event4.getRaces().add(race7);
			race7.getAttendees().put(sco018, new RaceAttendee(race7, sco018, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco069, new RaceAttendee(race7, sco069, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco081, new RaceAttendee(race7, sco081, RaceAttendee.Type.PILOT));
			RaceAttendee att116 = new RaceAttendee(race7, sco116, RaceAttendee.Type.PILOT);
			att116.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 4")); //$NON-NLS-1$
			race7.getAttendees().put(sco116, att116);
			race7.getAttendees().put(sco117, new RaceAttendee(race7, sco117, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco153, new RaceAttendee(race7, sco153, RaceAttendee.Type.V_SCORER));
			race7.getAttendees().put(sco159, new RaceAttendee(race7, sco159, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco179, new RaceAttendee(race7, sco179, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco296, new RaceAttendee(race7, sco296, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco315, new RaceAttendee(race7, sco315, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco528, new RaceAttendee(race7, sco528, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco561, new RaceAttendee(race7, sco561, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco808, new RaceAttendee(race7, sco808, RaceAttendee.Type.PILOT));
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race7, "69,808,528,116,81,159,18,296,179,117,561"); //$NON-NLS-1$
			addLaps(race7, "69,528,116,808,18,159,296,179,117"); //$NON-NLS-1$
			addLaps(race7, "69,116,528,808,18,159,296,179,117"); //$NON-NLS-1$
			addLaps(race7, "69,116,528,808,18,159,179,296,117"); //$NON-NLS-1$
			addLaps(race7, "69,116,528,808,18,159,179,296"); //$NON-NLS-1$
			addLaps(race7, "69,116,528,808,18,159,179"); //$NON-NLS-1$
			addLaps(race7, "69,116,528,808,18,159"); //$NON-NLS-1$

			addLaps(race7, "69,116,528,808,18,159"); //$NON-NLS-1$
			addLaps(race7, "69,116,528,808,18"); //$NON-NLS-1$
			addLaps(race7, "69,116,528"); //$NON-NLS-1$
			raceDAO.persist(race7);

			DatabaseSession.commit();

			_race7 = race7;
		} finally {
			db.endSession();
		}
	}

	protected void createRace8Data() throws Exception {
		createEvent4Data();

		if (_race8 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race8 = new Race(event4, RACE8_NAME, RACE8_DESC);
			event4.getRaces().add(race8);
			race8.getAttendees().put(sco018, new RaceAttendee(race8, sco018, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco069, new RaceAttendee(race8, sco069, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco081, new RaceAttendee(race8, sco081, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco116, new RaceAttendee(race8, sco116, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco117, new RaceAttendee(race8, sco117, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco153, new RaceAttendee(race8, sco153, RaceAttendee.Type.V_SCORER));
			race8.getAttendees().put(sco159, new RaceAttendee(race8, sco159, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco179, new RaceAttendee(race8, sco179, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco296, new RaceAttendee(race8, sco296, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco315, new RaceAttendee(race8, sco315, RaceAttendee.Type.V_MARSHAL));
			race8.getAttendees().put(sco528, new RaceAttendee(race8, sco528, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco561, new RaceAttendee(race8, sco561, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco808, new RaceAttendee(race8, sco808, RaceAttendee.Type.PILOT));
			race8.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race8, "808,179,528,116,69,18,81,159,117,296,561"); //$NON-NLS-1$
			addLaps(race8, "808,69,528,116,179,18,159,81,117,296,561"); //$NON-NLS-1$
			addLaps(race8, "69,116,528,18,179,159,81,117,808,296,561"); //$NON-NLS-1$
			addLaps(race8, "69,116,528,18,159,81,117,808,179,296,561"); //$NON-NLS-1$
			addLaps(race8, "69,116,528,18,159,81,117,808,179,296"); //$NON-NLS-1$
			addLaps(race8, "69,116,528,159,808,179,81,117,296"); //$NON-NLS-1$
			addLaps(race8, "69,116,528,159,808,179,117"); //$NON-NLS-1$
			addLaps(race8, "69,116,528,159,808"); //$NON-NLS-1$
			addLaps(race8, "69,116,528"); //$NON-NLS-1$
			addLaps(race8, "69,116,528"); //$NON-NLS-1$
			raceDAO.persist(race8);

			DatabaseSession.commit();

			_race8 = race8;
		} finally {
			db.endSession();
		}
	}

	protected void createRace9Data() throws Exception {
		createEvent4Data();

		if (_race9 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race9 = new Race(event4, RACE9_NAME, RACE9_DESC);
			event4.getRaces().add(race9);
			race9.getAttendees().put(sco018, new RaceAttendee(race9, sco018, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco069, new RaceAttendee(race9, sco069, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco081, new RaceAttendee(race9, sco081, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco116, new RaceAttendee(race9, sco116, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco117, new RaceAttendee(race9, sco117, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco153, new RaceAttendee(race9, sco153, RaceAttendee.Type.V_SCORER));
			race9.getAttendees().put(sco159, new RaceAttendee(race9, sco159, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco179, new RaceAttendee(race9, sco179, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco296, new RaceAttendee(race9, sco296, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco315, new RaceAttendee(race9, sco315, RaceAttendee.Type.V_MARSHAL));
			race9.getAttendees().put(sco528, new RaceAttendee(race9, sco528, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco561, new RaceAttendee(race9, sco561, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco808, new RaceAttendee(race9, sco808, RaceAttendee.Type.PILOT));
			race9.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race9, "116,69,808,179,18,159,528,117,296,561,81"); //$NON-NLS-1$
			addLaps(race9, "116,69,808,179,18,159,528,117,296,561"); //$NON-NLS-1$
			addLaps(race9, "116,69,808,179,159,18,528,117,296"); //$NON-NLS-1$
			addLaps(race9, "116,69,808,179,159,18,528,117,296"); //$NON-NLS-1$
			addLaps(race9, "116,69,179,808,159,18,528,117,296"); //$NON-NLS-1$
			addLaps(race9, "69,116,808,159,179,18,528,117,296"); //$NON-NLS-1$
			addLaps(race9, "69,116,808,159,179,18,528,117,296"); //$NON-NLS-1$
			addLaps(race9, "69,116,808,159,179,18,528,117"); //$NON-NLS-1$
			addLaps(race9, "69,116,808,159,179,18,528,117"); //$NON-NLS-1$
			addLaps(race9, "69,116,808,159,179,18,528"); //$NON-NLS-1$
			addLaps(race9, "69,808,159"); //$NON-NLS-1$
			raceDAO.persist(race9);

			DatabaseSession.commit();

			_race9 = race9;
		} finally {
			db.endSession();
		}
	}

	protected void createRace10Data() throws Exception {
		createEvent4Data();

		if (_race10 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race10 = new Race(event4, RACE10_NAME, RACE10_DESC);
			event4.getRaces().add(race10);
			race10.getAttendees().put(sco018, new RaceAttendee(race10, sco018, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco069, new RaceAttendee(race10, sco069, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco081, new RaceAttendee(race10, sco081, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco116, new RaceAttendee(race10, sco116, RaceAttendee.Type.PILOT));
			RaceAttendee att117 = new RaceAttendee(race10, sco117, RaceAttendee.Type.PILOT);
			att117.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 1")); //$NON-NLS-1$
			race10.getAttendees().put(sco117, att117);
			race10.getAttendees().put(sco153, new RaceAttendee(race10, sco153, RaceAttendee.Type.V_SCORER));
			race10.getAttendees().put(sco159, new RaceAttendee(race10, sco159, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco179, new RaceAttendee(race10, sco179, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco296, new RaceAttendee(race10, sco296, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco315, new RaceAttendee(race10, sco315, RaceAttendee.Type.V_MARSHAL));
			race10.getAttendees().put(sco528, new RaceAttendee(race10, sco528, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco561, new RaceAttendee(race10, sco561, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco808, new RaceAttendee(race10, sco808, RaceAttendee.Type.PILOT));
			race10.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race10, "69,808,159,18,179,528,296,117,116"); //$NON-NLS-1$
			addLaps(race10, "69,808,179,18,159,528,296,117"); //$NON-NLS-1$
			addLaps(race10, "808,179,69,18,159,296,528,117"); //$NON-NLS-1$
			addLaps(race10, "808,69,18,159,528,296,117"); //$NON-NLS-1$
			addLaps(race10, "808,69,159,18,528,296,117"); //$NON-NLS-1$
			addLaps(race10, "808,69,159,18,528,296"); //$NON-NLS-1$
			addLaps(race10, "69,808,159,18,528"); //$NON-NLS-1$
			addLaps(race10, "69,808,159,18,528"); //$NON-NLS-1$
			addLaps(race10, "69,808,159,18"); //$NON-NLS-1$
			addLaps(race10, "69,808"); //$NON-NLS-1$
			raceDAO.persist(race10);

			DatabaseSession.commit();

			_race10 = race10;
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
		createRace11Data();
		createRace12Data();
		createRace13Data();
		createRace14Data();
		createRace15Data();
		createRace16Data();
		createRace17Data();
		createRace18Data();
	}

	protected void createRace11Data() throws Exception {
		createEvent5Data();

		if (_race11 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race11 = new Race(event5, RACE11_NAME, RACE11_DESC);
			event5.getRaces().add(race11);
			race11.getAttendees().put(sco018, new RaceAttendee(race11, sco018, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco069, new RaceAttendee(race11, sco069, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco081, new RaceAttendee(race11, sco081, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco087, new RaceAttendee(race11, sco087, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco116, new RaceAttendee(race11, sco116, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco117, new RaceAttendee(race11, sco117, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco156, new RaceAttendee(race11, sco156, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco159, new RaceAttendee(race11, sco159, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco249, new RaceAttendee(race11, sco249, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco296, new RaceAttendee(race11, sco296, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco528, new RaceAttendee(race11, sco528, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco666, new RaceAttendee(race11, sco666, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco808, new RaceAttendee(race11, sco808, RaceAttendee.Type.PILOT));
			race11.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race11, "808,69,116,528,666,159,18,81,87,117,156"); //$NON-NLS-1$
			addLaps(race11, "808,69,116,528,159,666,18,117,87,81,156"); //$NON-NLS-1$
			addLaps(race11, "808,69,116,528,159,666,18,117,87,156"); //$NON-NLS-1$
			addLaps(race11, "69,808,116,528,159,666,18,117,87"); //$NON-NLS-1$
			addLaps(race11, "808,69,116,528,159,666"); //$NON-NLS-1$
			raceDAO.persist(race11);

			DatabaseSession.commit();

			_race11 = race11;
		} finally {
			db.endSession();
		}
	}

	protected void createRace12Data() throws Exception {
		createEvent5Data();

		if (_race12 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race12 = new Race(event5, RACE12_NAME, RACE12_DESC);
			event5.getRaces().add(race12);
			race12.getAttendees().put(sco018, new RaceAttendee(race12, sco018, RaceAttendee.Type.PILOT));
			RaceAttendee att069 = new RaceAttendee(race12, sco069, RaceAttendee.Type.PILOT);
			att069.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 8")); //$NON-NLS-1$
			att069.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 8")); //$NON-NLS-1$
			race12.getAttendees().put(sco069, att069);
			race12.getAttendees().put(sco081, new RaceAttendee(race12, sco081, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco087, new RaceAttendee(race12, sco087, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco116, new RaceAttendee(race12, sco116, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco117, new RaceAttendee(race12, sco117, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco156, new RaceAttendee(race12, sco156, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco159, new RaceAttendee(race12, sco159, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco249, new RaceAttendee(race12, sco249, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco296, new RaceAttendee(race12, sco296, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco528, new RaceAttendee(race12, sco528, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco666, new RaceAttendee(race12, sco666, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco808, new RaceAttendee(race12, sco808, RaceAttendee.Type.PILOT));
			race12.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race12, "116,69,808,528,159,18,666,87,117,81,156"); //$NON-NLS-1$
			addLaps(race12, "69,116,808,528,159,18,666,81,117,87,156"); //$NON-NLS-1$
			addLaps(race12, "69,116,808,528,159,18,666,81,117,87,156"); //$NON-NLS-1$
			addLaps(race12, "69,116,808,528,159,18,666,81,117,87"); //$NON-NLS-1$
			addLaps(race12, "69,116,808,528,159,18"); //$NON-NLS-1$
			raceDAO.persist(race12);

			DatabaseSession.commit();

			_race12 = race12;
		} finally {
			db.endSession();
		}
	}

	protected void createRace13Data() throws Exception {
		createEvent5Data();

		if (_race13 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race13 = new Race(event5, RACE13_NAME, RACE13_DESC);
			event5.getRaces().add(race13);
			race13.getAttendees().put(sco018, new RaceAttendee(race13, sco018, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco069, new RaceAttendee(race13, sco069, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco081, new RaceAttendee(race13, sco081, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco087, new RaceAttendee(race13, sco087, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco116, new RaceAttendee(race13, sco116, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco117, new RaceAttendee(race13, sco117, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco156, new RaceAttendee(race13, sco156, RaceAttendee.Type.PILOT));
			RaceAttendee att159 = new RaceAttendee(race13, sco159, RaceAttendee.Type.PILOT);
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Pushing into the wind")); //$NON-NLS-1$
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 8")); //$NON-NLS-1$
			race13.getAttendees().put(sco159, att159);
			race13.getAttendees().put(sco249, new RaceAttendee(race13, sco249, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco296, new RaceAttendee(race13, sco296, RaceAttendee.Type.PILOT));
			RaceAttendee att528 = new RaceAttendee(race13, sco528, RaceAttendee.Type.PILOT);
			att528.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 5")); //$NON-NLS-1$
			race13.getAttendees().put(sco528, att528);
			race13.getAttendees().put(sco666, new RaceAttendee(race13, sco666, RaceAttendee.Type.PILOT));
			race13.getAttendees().put(sco808, new RaceAttendee(race13, sco808, RaceAttendee.Type.PILOT));
			race13.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race13, "116,808,69,528,159,81,666,18,117,87,156,296"); //$NON-NLS-1$
			addLaps(race13, "116,69,808,528,159,81,18,666,117,87,156,296"); //$NON-NLS-1$
			addLaps(race13, "116,69,808,159,528,81,666,18,117,87,156,296"); //$NON-NLS-1$
			addLaps(race13, "116,69,808,528,159,81,666,18,117,87"); //$NON-NLS-1$
			addLaps(race13, "116,808,69,528,81,159,666,18"); //$NON-NLS-1$
			addLaps(race13, "116,808,69"); //$NON-NLS-1$
			raceDAO.persist(race13);

			DatabaseSession.commit();

			_race13 = race13;
		} finally {
			db.endSession();
		}
	}

	protected void createRace14Data() throws Exception {
		createEvent5Data();

		if (_race14 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race14 = new Race(event5, RACE14_NAME, RACE14_DESC);
			event5.getRaces().add(race14);
			race14.getAttendees().put(sco018, new RaceAttendee(race14, sco018, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco069, new RaceAttendee(race14, sco069, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco081, new RaceAttendee(race14, sco081, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco087, new RaceAttendee(race14, sco087, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco116, new RaceAttendee(race14, sco116, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco117, new RaceAttendee(race14, sco117, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco156, new RaceAttendee(race14, sco156, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco159, new RaceAttendee(race14, sco159, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco249, new RaceAttendee(race14, sco249, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco296, new RaceAttendee(race14, sco296, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco528, new RaceAttendee(race14, sco528, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco666, new RaceAttendee(race14, sco666, RaceAttendee.Type.PILOT));
			race14.getAttendees().put(sco808, new RaceAttendee(race14, sco808, RaceAttendee.Type.PILOT));
			race14.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race14, "528,666,81,159,18,87,117,156,296,69,808"); //$NON-NLS-1$
			addLaps(race14, "528,666,81,159,18,117,87,156,296,69,808"); //$NON-NLS-1$
			addLaps(race14, "528,666,81,159,117,87,156,69,296,808"); //$NON-NLS-1$
			addLaps(race14, "528,666,81,159,117,87,69,156,296,808"); //$NON-NLS-1$ 808,296
			addLaps(race14, "528,666,81,159,117,87,69,156,296,808"); //$NON-NLS-1$ 808,156,296
			addLaps(race14, "528,666,81,159,117,69,87,156,808,296"); //$NON-NLS-1$ 808,156,296
			addLaps(race14, "528,666,81,159,69,117,87,808,156,296"); //$NON-NLS-1$
			addLaps(race14, "528,666,81,159,69,117,87,808,156"); //$NON-NLS-1$
			addLaps(race14, "528,666,81,159,69,117,87"); //$NON-NLS-1$ +808
			addLaps(race14, "528,666,81,159,69,117"); //$NON-NLS-1$
			addLaps(race14, "528,666,81,69,159"); //$NON-NLS-1$
			raceDAO.persist(race14);

			DatabaseSession.commit();

			_race14 = race14;
		} finally {
			db.endSession();
		}
	}

	protected void createRace15Data() throws Exception {
		createEvent5Data();

		if (_race15 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race15 = new Race(event5, RACE15_NAME, RACE15_DESC);
			event5.getRaces().add(race15);
			race15.getAttendees().put(sco069, new RaceAttendee(race15, sco069, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco081, new RaceAttendee(race15, sco081, RaceAttendee.Type.PILOT));
			RaceAttendee att087 = new RaceAttendee(race15, sco087, RaceAttendee.Type.PILOT);
			att087.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit a mark")); //$NON-NLS-1$
			race15.getAttendees().put(sco087, att087);
			race15.getAttendees().put(sco116, new RaceAttendee(race15, sco116, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco117, new RaceAttendee(race15, sco117, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco156, new RaceAttendee(race15, sco156, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco249, new RaceAttendee(race15, sco249, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco296, new RaceAttendee(race15, sco296, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco528, new RaceAttendee(race15, sco528, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco666, new RaceAttendee(race15, sco666, RaceAttendee.Type.PILOT));
			race15.getAttendees().put(sco808, new RaceAttendee(race15, sco808, RaceAttendee.Type.PILOT));
			race15.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race15, "69,528,808,116,666,117,296"); //$NON-NLS-1$
			addLaps(race15, "69,808,528,116,666,117"); //$NON-NLS-1$
			addLaps(race15, "69,528,808,116,666,117"); //$NON-NLS-1$
			addLaps(race15, "69,808,528,116"); //$NON-NLS-1$
			raceDAO.persist(race15);

			DatabaseSession.commit();

			_race15 = race15;
		} finally {
			db.endSession();
		}
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
			race16.getAttendees().put(sco069, new RaceAttendee(race16, sco069, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco081, new RaceAttendee(race16, sco081, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco087, new RaceAttendee(race16, sco087, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco116, new RaceAttendee(race16, sco116, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco117, new RaceAttendee(race16, sco117, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco156, new RaceAttendee(race16, sco156, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco249, new RaceAttendee(race16, sco249, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco296, new RaceAttendee(race16, sco296, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco528, new RaceAttendee(race16, sco528, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco666, new RaceAttendee(race16, sco666, RaceAttendee.Type.PILOT));
			race16.getAttendees().put(sco808, new RaceAttendee(race16, sco808, RaceAttendee.Type.PILOT));
			race16.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race16, "69,666,116,528,808,117,87"); //$NON-NLS-1$
			addLaps(race16, "69,528,666,116,808,117,87"); //$NON-NLS-1$
			addLaps(race16, "69,528,666,116,808,117,87"); //$NON-NLS-1$
			addLaps(race16, "69,528,666,116,808,117,87"); //$NON-NLS-1$
			addLaps(race16, "69,528,666,116,808"); //$NON-NLS-1$
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
			race17.getAttendees().put(sco069, new RaceAttendee(race17, sco069, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco081, new RaceAttendee(race17, sco081, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco087, new RaceAttendee(race17, sco087, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco116, new RaceAttendee(race17, sco116, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco117, new RaceAttendee(race17, sco117, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco156, new RaceAttendee(race17, sco156, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco249, new RaceAttendee(race17, sco249, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco296, new RaceAttendee(race17, sco296, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco528, new RaceAttendee(race17, sco528, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco666, new RaceAttendee(race17, sco666, RaceAttendee.Type.PILOT));
			race17.getAttendees().put(sco808, new RaceAttendee(race17, sco808, RaceAttendee.Type.PILOT));
			race17.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race17, "116,808,666,69,528,117,87,296"); //$NON-NLS-1$
			addLaps(race17, "116,808,528,666,117,87,69"); //$NON-NLS-1$
			addLaps(race17, "116,808,528,666,117"); //$NON-NLS-1$
			addLaps(race17, "116,808,528,666"); //$NON-NLS-1$
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
			race18.getAttendees().put(sco069, new RaceAttendee(race18, sco069, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco081, new RaceAttendee(race18, sco081, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco087, new RaceAttendee(race18, sco087, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco116, new RaceAttendee(race18, sco116, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco117, new RaceAttendee(race18, sco117, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco156, new RaceAttendee(race18, sco156, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco249, new RaceAttendee(race18, sco249, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco296, new RaceAttendee(race18, sco296, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco528, new RaceAttendee(race18, sco528, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco666, new RaceAttendee(race18, sco666, RaceAttendee.Type.PILOT));
			race18.getAttendees().put(sco808, new RaceAttendee(race18, sco808, RaceAttendee.Type.PILOT));
			race18.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race18, "69,116,528,808,666,117,87,296"); //$NON-NLS-1$
			addLaps(race18, "69,116,528,808,666,117,87"); //$NON-NLS-1$
			addLaps(race18, "69,116,528,666,808,117,87"); //$NON-NLS-1$
			addLaps(race18, "69,116,528,808,666,117,87"); //$NON-NLS-1$
			addLaps(race18, "69,116,528,808,666"); //$NON-NLS-1$
			raceDAO.persist(race18);

			DatabaseSession.commit();

			_race18 = race18;
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
		createRace19Data();
		createRace20Data();
	}

	protected void createRace19Data() throws Exception {
		createEvent6Data();

		if (_race19 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);

			Race race19 = new Race(event6, RACE19_NAME, RACE19_DESC);
			event6.getRaces().add(race19);
			race19.getAttendees().put(sco069, new RaceAttendee(race19, sco069, RaceAttendee.Type.PILOT));
			RaceAttendee att116 = new RaceAttendee(race19, sco116, RaceAttendee.Type.PILOT);
			att116.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Crossed orange line (to mark 1)")); //$NON-NLS-1$
			race19.getAttendees().put(sco116, att116);
			race19.getAttendees().put(sco156, new RaceAttendee(race19, sco156, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco179, new RaceAttendee(race19, sco179, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco249, new RaceAttendee(race19, sco249, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco528, new RaceAttendee(race19, sco528, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco561, new RaceAttendee(race19, sco561, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco666, new RaceAttendee(race19, sco666, RaceAttendee.Type.PILOT));
			race19.getAttendees().put(sco808, new RaceAttendee(race19, sco808, RaceAttendee.Type.PILOT));
			race19.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race19, "116,528,69,808,179,666"); //$NON-NLS-1$
			addLaps(race19, "528,808,69,179,116,666"); //$NON-NLS-1$
			addLaps(race19, "528,808,69,666,179,116"); //$NON-NLS-1$
			addLaps(race19, "528,808,69,179,666"); //$NON-NLS-1$
			addLaps(race19, "528,808,69,666,179"); //$NON-NLS-1$
			addLaps(race19, "528,808,69,666"); //$NON-NLS-1$
			addLaps(race19, "528,808,69,666"); //$NON-NLS-1$
			addLaps(race19, "528,808"); //$NON-NLS-1$
			addLaps(race19, "528"); //$NON-NLS-1$
			raceDAO.persist(race19);

			DatabaseSession.commit();

			_race19 = race19;
		} finally {
			db.endSession();
		}
	}

	protected void createRace20Data() throws Exception {
		createEvent6Data();

		if (_race20 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);

			Race race20 = new Race(event6, RACE20_NAME, RACE20_DESC);
			event6.getRaces().add(race20);
			RaceAttendee att069 = new RaceAttendee(race20, sco069, RaceAttendee.Type.PILOT);
			att069.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 1")); //$NON-NLS-1$
			race20.getAttendees().put(sco069, att069);
			race20.getAttendees().put(sco116, new RaceAttendee(race20, sco116, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco156, new RaceAttendee(race20, sco156, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco179, new RaceAttendee(race20, sco179, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco249, new RaceAttendee(race20, sco249, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco528, new RaceAttendee(race20, sco528, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco561, new RaceAttendee(race20, sco561, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco666, new RaceAttendee(race20, sco666, RaceAttendee.Type.PILOT));
			race20.getAttendees().put(sco808, new RaceAttendee(race20, sco808, RaceAttendee.Type.PILOT));
			race20.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race20, "116,528,808,69,666,156,179"); //$NON-NLS-1$
			addLaps(race20, "116,528,808,69,666,156,179"); //$NON-NLS-1$
			addLaps(race20, "116,528,69,808,666,179,156"); //$NON-NLS-1$
			addLaps(race20, "528,116,69,808,666,179,156"); //$NON-NLS-1$
			addLaps(race20, "528,116,69,808,666,179"); //$NON-NLS-1$
			addLaps(race20, "528,69,116,808,666"); //$NON-NLS-1$
			addLaps(race20, "528,69,808,116"); //$NON-NLS-1$
			addLaps(race20, "528,69,808,116"); //$NON-NLS-1$
			raceDAO.persist(race20);

			DatabaseSession.commit();

			_race20 = race20;
		} finally {
			db.endSession();
		}
	}
}
