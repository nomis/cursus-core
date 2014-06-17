/*
	cursus - Race series management program
	Copyright 2014  Simon Arlott

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
package org.spka.cursus.test.series_2008;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSeries;

import eu.lp0.cursus.db.DatabaseSession;
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

public abstract class AbstractSeries2008 extends AbstractSeries {
	protected static final String SERIES_NAME = "SPKA Race Series 2008/09"; //$NON-NLS-1$
	protected static final int SERIES_FLEET = 14;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 11;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = ""; //$NON-NLS-1$
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = ""; //$NON-NLS-1$

	protected static final String EVENT2_NAME = "Race Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 12;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = ""; //$NON-NLS-1$

	protected static final String EVENT3_NAME = "Race Event 3"; //$NON-NLS-1$
	protected static final String EVENT3_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT3_FLEET = 13;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = ""; //$NON-NLS-1$

	protected static final String EVENT4_NAME = "Race Event 4"; //$NON-NLS-1$
	protected static final String EVENT4_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT4_FLEET = 12;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = ""; //$NON-NLS-1$
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = ""; //$NON-NLS-1$

	protected static final String EVENT5_NAME = "Race Event 5"; //$NON-NLS-1$
	protected static final String EVENT5_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT5_FLEET = 10;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = ""; //$NON-NLS-1$
	protected static final String RACE8_NAME = "Race 8"; //$NON-NLS-1$
	protected static final String RACE8_DESC = ""; //$NON-NLS-1$

	protected static final String EVENT6_NAME = "Race Event 6"; //$NON-NLS-1$
	protected static final String EVENT6_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT6_FLEET = 12;
	protected static final String RACE9_NAME = "Race 9"; //$NON-NLS-1$
	protected static final String RACE9_DESC = ""; //$NON-NLS-1$
	protected static final String RACE10_NAME = "Race 10"; //$NON-NLS-1$
	protected static final String RACE10_DESC = ""; //$NON-NLS-1$
	protected static final String RACE11_NAME = "Race 11"; //$NON-NLS-1$
	protected static final String RACE11_DESC = ""; //$NON-NLS-1$
	protected static final String RACE12_NAME = "Race 12"; //$NON-NLS-1$
	protected static final String RACE12_DESC = ""; //$NON-NLS-1$

	protected Scorer scorer = ScorerFactory.newScorer(SPKAConstants.UUID_2005);

	protected Pilot sco019;
	protected Pilot sco021;
	protected Pilot sco023;
	protected Pilot sco060;
	protected Pilot sco071;
	protected Pilot sco081;
	protected Pilot sco117;
	protected Pilot sco136;
	protected Pilot sco154;
	protected Pilot sco158;
	protected Pilot sco159;
	protected Pilot sco179;
	protected Pilot sco197;
	protected Pilot sco200;

	private Series _series;
	private Event _event1;
	private Race _race1;
	private Race _race2;
	private Event _event2;
	private Race _race3;
	private Event _event3;
	private Race _race4;
	private Event _event4;
	private Race _race5;
	private Race _race6;
	private Event _event5;
	private Race _race7;
	private Race _race8;
	private Event _event6;
	private Race _race9;
	private Race _race10;
	private Race _race11;
	private Race _race12;

	protected void createSeriesData() throws Exception {
		if (_series != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			// Create the 2008/09 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco019 = new Pilot(series, "SCO019", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco019);

			sco021 = new Pilot(series, "SCO021", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco021);

			sco023 = new Pilot(series, "SCO023", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco023);

			sco060 = new Pilot(series, "SCO060", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco071 = new Pilot(series, "SCO071", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco071);

			sco081 = new Pilot(series, "SCO081", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco117 = new Pilot(series, "SCO117", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco117);

			sco136 = new Pilot(series, "SCO136", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco136);

			sco154 = new Pilot(series, "SCO154", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco154);

			sco158 = new Pilot(series, "SCO158", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco158);

			sco159 = new Pilot(series, "SCO159", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco179 = new Pilot(series, "SCO179", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco197 = new Pilot(series, "SCO197", Gender.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco197);

			sco200 = new Pilot(series, "SCO200", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco200);

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
			race1.getAttendees().put(sco019, new RaceAttendee(race1, sco019, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco023, new RaceAttendee(race1, sco023, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.M_MARSHAL));
			race1.getAttendees().put(sco071, new RaceAttendee(race1, sco071, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco081, new RaceAttendee(race1, sco081, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco117, new RaceAttendee(race1, sco117, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco136, new RaceAttendee(race1, sco136, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco154, new RaceAttendee(race1, sco154, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco197, new RaceAttendee(race1, sco197, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco200, new RaceAttendee(race1, sco200, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "23,200,179,19,81,71,117,154,136"); //$NON-NLS-1$
			addLaps(race1, "23,200,179,19,81,71,117"); //$NON-NLS-1$
			addLaps(race1, "23,200"); //$NON-NLS-1$
			addLaps(race1, "23"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco019, new RaceAttendee(race2, sco019, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco023, new RaceAttendee(race2, sco023, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco060, new RaceAttendee(race2, sco060, RaceAttendee.Type.M_MARSHAL));
			race2.getAttendees().put(sco071, new RaceAttendee(race2, sco071, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco081, new RaceAttendee(race2, sco081, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco117, new RaceAttendee(race2, sco117, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco136, new RaceAttendee(race2, sco136, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco154, new RaceAttendee(race2, sco154, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco197, new RaceAttendee(race2, sco197, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco200, new RaceAttendee(race2, sco200, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "23,200,81,19,136,71,154,117,197,179"); //$NON-NLS-1$
			addLaps(race2, "23,200,81,19,136,71,154,117,197,179"); //$NON-NLS-1$
			addLaps(race2, "23,200,81,19,136,71,154"); //$NON-NLS-1$
			addLaps(race2, "23,200,81,19,136"); //$NON-NLS-1$
			addLaps(race2, "23,200"); //$NON-NLS-1$
			raceDAO.persist(race2);

			DatabaseSession.commit();

			_race2 = race2;
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
		createRace3Data();
	}

	protected void createRace3Data() throws Exception {
		createEvent2Data();

		if (_race3 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race3 = new Race(event2, RACE3_NAME, RACE3_DESC);
			event2.getRaces().add(race3);
			race3.getAttendees().put(sco019, new RaceAttendee(race3, sco019, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco023, new RaceAttendee(race3, sco023, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco060, new RaceAttendee(race3, sco060, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco071, new RaceAttendee(race3, sco071, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco081, new RaceAttendee(race3, sco081, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco117, new RaceAttendee(race3, sco117, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco136, new RaceAttendee(race3, sco136, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco154, new RaceAttendee(race3, sco154, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco197, new RaceAttendee(race3, sco197, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco200, new RaceAttendee(race3, sco200, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "23,200,179,71,117,159,197,60,154,81,136"); //$NON-NLS-1$
			addLaps(race3, "23,200,179,71,117,159,197,60,154"); //$NON-NLS-1$
			addLaps(race3, "23,200,179,71,117,159,197,60"); //$NON-NLS-1$
			addLaps(race3, "23,200,179,71,117,159"); //$NON-NLS-1$
			addLaps(race3, "23,200,179,71,117"); //$NON-NLS-1$
			addLaps(race3, "23,200,179,71"); //$NON-NLS-1$
			addLaps(race3, "23,200"); //$NON-NLS-1$
			raceDAO.persist(race3);

			DatabaseSession.commit();

			_race3 = race3;
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
		createRace4Data();
	}

	protected void createRace4Data() throws Exception {
		createEvent3Data();

		if (_race4 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			Race race4 = new Race(event3, RACE4_NAME, RACE4_DESC);
			event3.getRaces().add(race4);
			race4.getAttendees().put(sco019, new RaceAttendee(race4, sco019, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco021, new RaceAttendee(race4, sco021, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco023, new RaceAttendee(race4, sco023, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco060, new RaceAttendee(race4, sco060, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco071, new RaceAttendee(race4, sco071, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco081, new RaceAttendee(race4, sco081, RaceAttendee.Type.PILOT));
			// race4.getAttendees().put(sco117, new RaceAttendee(race4, sco117, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco136, new RaceAttendee(race4, sco136, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco154, new RaceAttendee(race4, sco154, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco158, new RaceAttendee(race4, sco158, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco179, new RaceAttendee(race4, sco179, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco197, new RaceAttendee(race4, sco197, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco200, new RaceAttendee(race4, sco200, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "200,23,81,159,179,19,154,21,197,71,136,158"); //$NON-NLS-1$
			addLaps(race4, "200,23,81,159,179,19,154,21,197,71"); //$NON-NLS-1$
			addLaps(race4, "200,23,81,159,179,19,154,21"); //$NON-NLS-1$
			addLaps(race4, "200,23,81,159,179,19"); //$NON-NLS-1$
			addLaps(race4, "200,23,81"); //$NON-NLS-1$
			addLaps(race4, "200,23,81"); //$NON-NLS-1$
			raceDAO.persist(race4);

			DatabaseSession.commit();

			_race4 = race4;
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
		createRace5Data();
		createRace6Data();
	}

	protected void createRace5Data() throws Exception {
		createEvent4Data();

		if (_race5 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race5 = new Race(event4, RACE5_NAME, RACE5_DESC);
			event4.getRaces().add(race5);
			race5.getAttendees().put(sco019, new RaceAttendee(race5, sco019, RaceAttendee.Type.M_MARSHAL));
			race5.getAttendees().put(sco021, new RaceAttendee(race5, sco021, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco023, new RaceAttendee(race5, sco023, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco060, new RaceAttendee(race5, sco060, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco071, new RaceAttendee(race5, sco071, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco081, new RaceAttendee(race5, sco081, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco117, new RaceAttendee(race5, sco117, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco136, new RaceAttendee(race5, sco136, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco154, new RaceAttendee(race5, sco154, RaceAttendee.Type.PILOT));
			// race5.getAttendees().put(sco158, new RaceAttendee(race5, sco158, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco159, new RaceAttendee(race5, sco159, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco179, new RaceAttendee(race5, sco179, RaceAttendee.Type.PILOT));
			// race5.getAttendees().put(sco197, new RaceAttendee(race5, sco197, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco200, new RaceAttendee(race5, sco200, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "200,23,154,81,179,71,136,159,60,117"); //$NON-NLS-1$
			addLaps(race5, "200,23,154,81,179,71,136,159,60,117"); //$NON-NLS-1$
			addLaps(race5, "200,23,154,81,179,71,136,159,60,117"); //$NON-NLS-1$
			addLaps(race5, "200,23,154,81,179,71,136,159,60,117"); //$NON-NLS-1$
			addLaps(race5, "200,23,154,81,179,71,136,159,60,117"); //$NON-NLS-1$
			addLaps(race5, "200,23,154,81,179,71,136"); //$NON-NLS-1$
			addLaps(race5, "200,23,154,81,179"); //$NON-NLS-1$
			addLaps(race5, "200,23,154,81,179"); //$NON-NLS-1$
			addLaps(race5, "200,23,154,81,179"); //$NON-NLS-1$
			addLaps(race5, "200,23,154"); //$NON-NLS-1$
			raceDAO.persist(race5);

			DatabaseSession.commit();

			_race5 = race5;
		} finally {
			db.endSession();
		}
	}

	protected void createRace6Data() throws Exception {
		createEvent4Data();

		if (_race6 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race6 = new Race(event4, RACE6_NAME, RACE6_DESC);
			event4.getRaces().add(race6);
			race6.getAttendees().put(sco019, new RaceAttendee(race6, sco019, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco021, new RaceAttendee(race6, sco021, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco023, new RaceAttendee(race6, sco023, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco060, new RaceAttendee(race6, sco060, RaceAttendee.Type.M_MARSHAL));
			race6.getAttendees().put(sco071, new RaceAttendee(race6, sco071, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco081, new RaceAttendee(race6, sco081, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco117, new RaceAttendee(race6, sco117, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco136, new RaceAttendee(race6, sco136, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco154, new RaceAttendee(race6, sco154, RaceAttendee.Type.PILOT));
			// race6.getAttendees().put(sco158, new RaceAttendee(race6, sco158, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco159, new RaceAttendee(race6, sco159, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco179, new RaceAttendee(race6, sco179, RaceAttendee.Type.PILOT));
			// race6.getAttendees().put(sco197, new RaceAttendee(race6, sco197, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco200, new RaceAttendee(race6, sco200, RaceAttendee.Type.PILOT));
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race6, "200,23,154,81,117,179,21,71"); //$NON-NLS-1$
			addLaps(race6, "200,23,154,81,117,179"); //$NON-NLS-1$
			addLaps(race6, "200,23,154,81,117,179"); //$NON-NLS-1$
			addLaps(race6, "200,23,154,81,117,179"); //$NON-NLS-1$
			addLaps(race6, "200,23,154,81,117,179"); //$NON-NLS-1$
			addLaps(race6, "200,23,154,81,117"); //$NON-NLS-1$
			addLaps(race6, "200,23,154,81"); //$NON-NLS-1$
			addLaps(race6, "200"); //$NON-NLS-1$
			raceDAO.persist(race6);

			DatabaseSession.commit();

			_race6 = race6;
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
		createRace7Data();
		createRace8Data();
	}

	protected void createRace7Data() throws Exception {
		createEvent5Data();

		if (_race7 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race7 = new Race(event5, RACE7_NAME, RACE7_DESC);
			event5.getRaces().add(race7);
			race7.getAttendees().put(sco019, new RaceAttendee(race7, sco019, RaceAttendee.Type.PILOT));
			RaceAttendee att021 = new RaceAttendee(race7, sco021, RaceAttendee.Type.PILOT);
			att021.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Collision with marker")); //$NON-NLS-1$
			race7.getAttendees().put(sco021, att021);
			race7.getAttendees().put(sco023, new RaceAttendee(race7, sco023, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco060, new RaceAttendee(race7, sco060, RaceAttendee.Type.PILOT));
			// race7.getAttendees().put(sco071, new RaceAttendee(race7, sco071, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco081, new RaceAttendee(race7, sco081, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco117, new RaceAttendee(race7, sco117, RaceAttendee.Type.PILOT));
			// race7.getAttendees().put(sco136, new RaceAttendee(race7, sco136, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco154, new RaceAttendee(race7, sco154, RaceAttendee.Type.PILOT));
			// race7.getAttendees().put(sco158, new RaceAttendee(race7, sco158, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco159, new RaceAttendee(race7, sco159, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco179, new RaceAttendee(race7, sco179, RaceAttendee.Type.PILOT));
			// race7.getAttendees().put(sco197, new RaceAttendee(race7, sco197, RaceAttendee.Type.PILOT));
			RaceAttendee att200 = new RaceAttendee(race7, sco200, RaceAttendee.Type.PILOT);
			att200.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Overshot safety line")); //$NON-NLS-1$
			race7.getAttendees().put(sco200, att200);
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race7, "200,23,81,179,154,159,117,60,21"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179,154,159,117,60"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179,154,159,117,60"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179,154,159,117,60"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179,154,159,117,60"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179,154,159,117,60"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179,154,159,117"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179,154,159"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179"); //$NON-NLS-1$
			addLaps(race7, "200,23,81,179"); //$NON-NLS-1$
			raceDAO.persist(race7);

			DatabaseSession.commit();

			_race7 = race7;
		} finally {
			db.endSession();
		}
	}

	protected void createRace8Data() throws Exception {
		createEvent5Data();

		if (_race8 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			Race race8 = new Race(event5, RACE8_NAME, RACE8_DESC);
			event5.getRaces().add(race8);
			race8.getAttendees().put(sco019, new RaceAttendee(race8, sco019, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco021, new RaceAttendee(race8, sco021, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco023, new RaceAttendee(race8, sco023, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco060, new RaceAttendee(race8, sco060, RaceAttendee.Type.PILOT));
			// race8.getAttendees().put(sco071, new RaceAttendee(race8, sco071, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco081, new RaceAttendee(race8, sco081, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco117, new RaceAttendee(race8, sco117, RaceAttendee.Type.PILOT));
			// race8.getAttendees().put(sco136, new RaceAttendee(race8, sco136, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco154, new RaceAttendee(race8, sco154, RaceAttendee.Type.PILOT));
			// race8.getAttendees().put(sco158, new RaceAttendee(race8, sco158, RaceAttendee.Type.PILOT));
			RaceAttendee att159 = new RaceAttendee(race8, sco159, RaceAttendee.Type.PILOT);
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Overshot safety line")); //$NON-NLS-1$
			race8.getAttendees().put(sco159, att159);
			RaceAttendee att179 = new RaceAttendee(race8, sco179, RaceAttendee.Type.PILOT);
			att179.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Lines clipped marker")); //$NON-NLS-1$
			race8.getAttendees().put(sco179, att179);
			// race8.getAttendees().put(sco197, new RaceAttendee(race8, sco197, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco200, new RaceAttendee(race8, sco200, RaceAttendee.Type.PILOT));
			race8.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race8, "200,81,23,154,117,179,60,159,21"); //$NON-NLS-1$
			addLaps(race8, "200,81,23,154,117,179,60,159"); //$NON-NLS-1$
			addLaps(race8, "200,81,23,154,117,179,60,159"); //$NON-NLS-1$
			addLaps(race8, "200,81,23,154,117,179,60"); //$NON-NLS-1$
			addLaps(race8, "200,81,23,154,117,179"); //$NON-NLS-1$
			addLaps(race8, "200,81,23,154"); //$NON-NLS-1$
			addLaps(race8, "200,81,23"); //$NON-NLS-1$
			addLaps(race8, "200,81,23"); //$NON-NLS-1$
			raceDAO.persist(race8);

			DatabaseSession.commit();

			_race8 = race8;
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
		createRace9Data();
		createRace10Data();
		createRace11Data();
		createRace12Data();
	}

	protected void createRace9Data() throws Exception {
		createEvent6Data();

		if (_race9 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);

			Race race9 = new Race(event6, RACE9_NAME, RACE9_DESC);
			event6.getRaces().add(race9);
			race9.getAttendees().put(sco019, new RaceAttendee(race9, sco019, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco021, new RaceAttendee(race9, sco021, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco023, new RaceAttendee(race9, sco023, RaceAttendee.Type.M_MARSHAL));
			race9.getAttendees().put(sco060, new RaceAttendee(race9, sco060, RaceAttendee.Type.PILOT));
			// race9.getAttendees().put(sco071, new RaceAttendee(race9, sco071, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco081, new RaceAttendee(race9, sco081, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco117, new RaceAttendee(race9, sco117, RaceAttendee.Type.PILOT));
			// race9.getAttendees().put(sco136, new RaceAttendee(race9, sco136, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco154, new RaceAttendee(race9, sco154, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco158, new RaceAttendee(race9, sco158, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco159, new RaceAttendee(race9, sco159, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco179, new RaceAttendee(race9, sco179, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco197, new RaceAttendee(race9, sco197, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco200, new RaceAttendee(race9, sco200, RaceAttendee.Type.PILOT));
			race9.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race9, "81,200,179,159,154,117,19,197,60,158,21"); //$NON-NLS-1$
			addLaps(race9, "81,200,179,159,154,117,19,197,60,158"); //$NON-NLS-1$
			addLaps(race9, "81,200,179,159,154,117,19,197,60,158"); //$NON-NLS-1$
			addLaps(race9, "81,200,179,159,154,117,19,197"); //$NON-NLS-1$
			addLaps(race9, "81,200,179,159,154,117,19,197"); //$NON-NLS-1$
			addLaps(race9, "81,200,179,159,154,117"); //$NON-NLS-1$
			addLaps(race9, "81,200,179,159"); //$NON-NLS-1$
			raceDAO.persist(race9);

			DatabaseSession.commit();

			_race9 = race9;
		} finally {
			db.endSession();
		}
	}

	protected void createRace10Data() throws Exception {
		createEvent6Data();

		if (_race10 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);

			Race race10 = new Race(event6, RACE10_NAME, RACE10_DESC);
			event6.getRaces().add(race10);
			race10.getAttendees().put(sco019, new RaceAttendee(race10, sco019, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco021, new RaceAttendee(race10, sco021, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco023, new RaceAttendee(race10, sco023, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco060, new RaceAttendee(race10, sco060, RaceAttendee.Type.PILOT));
			// race10.getAttendees().put(sco071, new RaceAttendee(race10, sco071, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco081, new RaceAttendee(race10, sco081, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco117, new RaceAttendee(race10, sco117, RaceAttendee.Type.PILOT));
			// race10.getAttendees().put(sco136, new RaceAttendee(race10, sco136, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco154, new RaceAttendee(race10, sco154, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco158, new RaceAttendee(race10, sco158, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco159, new RaceAttendee(race10, sco159, RaceAttendee.Type.M_MARSHAL));
			race10.getAttendees().put(sco179, new RaceAttendee(race10, sco179, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco197, new RaceAttendee(race10, sco197, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco200, new RaceAttendee(race10, sco200, RaceAttendee.Type.PILOT));
			race10.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race10, "81,200,154,179,23,117,197,60,21,19,158"); //$NON-NLS-1$
			addLaps(race10, "81,200,154,179,23,117,197,60,21"); //$NON-NLS-1$
			addLaps(race10, "81,200,154,179,23,117,197,60,21"); //$NON-NLS-1$
			addLaps(race10, "81,200,154,179,23,117,197,60,21"); //$NON-NLS-1$
			addLaps(race10, "81,200,154,179,23,117,197,60"); //$NON-NLS-1$
			addLaps(race10, "81,200,154,179,23,117,197"); //$NON-NLS-1$
			addLaps(race10, "81,200,154,179,23,117"); //$NON-NLS-1$
			addLaps(race10, "81,200,154,179"); //$NON-NLS-1$
			raceDAO.persist(race10);

			DatabaseSession.commit();

			_race10 = race10;
		} finally {
			db.endSession();
		}
	}

	protected void createRace11Data() throws Exception {
		createEvent6Data();

		if (_race11 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);

			Race race11 = new Race(event6, RACE11_NAME, RACE11_DESC);
			event6.getRaces().add(race11);
			race11.getAttendees().put(sco019, new RaceAttendee(race11, sco019, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco021, new RaceAttendee(race11, sco021, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco023, new RaceAttendee(race11, sco023, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco060, new RaceAttendee(race11, sco060, RaceAttendee.Type.PILOT));
			// race11.getAttendees().put(sco071, new RaceAttendee(race11, sco071, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco081, new RaceAttendee(race11, sco081, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco117, new RaceAttendee(race11, sco117, RaceAttendee.Type.PILOT));
			// race11.getAttendees().put(sco136, new RaceAttendee(race11, sco136, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco154, new RaceAttendee(race11, sco154, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco158, new RaceAttendee(race11, sco158, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco159, new RaceAttendee(race11, sco159, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco179, new RaceAttendee(race11, sco179, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco197, new RaceAttendee(race11, sco197, RaceAttendee.Type.M_MARSHAL));
			race11.getAttendees().put(sco200, new RaceAttendee(race11, sco200, RaceAttendee.Type.PILOT));
			race11.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race11, "200,23,154,179,81,117,159,158,19,21,60"); //$NON-NLS-1$
			addLaps(race11, "200,23,154,179,81,117,159,158,19,21,60"); //$NON-NLS-1$
			addLaps(race11, "200,23,154,179,81,117,159,158,19,21"); //$NON-NLS-1$
			addLaps(race11, "200,23,154,179,81,117,159,158,19,21"); //$NON-NLS-1$
			addLaps(race11, "200,23,154,179,81,117,159,158,19,21"); //$NON-NLS-1$
			addLaps(race11, "200,23,154,179,81,117,159,158"); //$NON-NLS-1$
			addLaps(race11, "200,23,154,179,81,117"); //$NON-NLS-1$
			addLaps(race11, "200,23,154,179,81"); //$NON-NLS-1$
			raceDAO.persist(race11);

			DatabaseSession.commit();

			_race11 = race11;
		} finally {
			db.endSession();
		}
	}

	protected void createRace12Data() throws Exception {
		createEvent6Data();

		if (_race12 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);

			Race race12 = new Race(event6, RACE12_NAME, RACE12_DESC);
			event6.getRaces().add(race12);
			race12.getAttendees().put(sco019, new RaceAttendee(race12, sco019, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco021, new RaceAttendee(race12, sco021, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco023, new RaceAttendee(race12, sco023, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco060, new RaceAttendee(race12, sco060, RaceAttendee.Type.PILOT));
			// race12.getAttendees().put(sco071, new RaceAttendee(race12, sco071, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco081, new RaceAttendee(race12, sco081, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco117, new RaceAttendee(race12, sco117, RaceAttendee.Type.PILOT));
			// race12.getAttendees().put(sco136, new RaceAttendee(race12, sco136, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco154, new RaceAttendee(race12, sco154, RaceAttendee.Type.M_MARSHAL));
			race12.getAttendees().put(sco158, new RaceAttendee(race12, sco158, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco159, new RaceAttendee(race12, sco159, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco179, new RaceAttendee(race12, sco179, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco197, new RaceAttendee(race12, sco197, RaceAttendee.Type.PILOT));
			race12.getAttendees().put(sco200, new RaceAttendee(race12, sco200, RaceAttendee.Type.PILOT));
			race12.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race12, "200,23,179,159,117,19,197,21,81,60,158"); //$NON-NLS-1$
			addLaps(race12, "200,23,179,159,117,19,197,21,81"); //$NON-NLS-1$
			addLaps(race12, "200,23,179,159,117,19,197,21,81"); //$NON-NLS-1$
			addLaps(race12, "200,23,179,159,117,19,197,21"); //$NON-NLS-1$
			addLaps(race12, "200,23,179,159,117,19,197"); //$NON-NLS-1$
			addLaps(race12, "200,23,179,159,117,19,197"); //$NON-NLS-1$
			addLaps(race12, "200,23,179,159,117"); //$NON-NLS-1$
			addLaps(race12, "200,23,179"); //$NON-NLS-1$
			raceDAO.persist(race12);

			DatabaseSession.commit();

			_race12 = race12;
		} finally {
			db.endSession();
		}
	}
}