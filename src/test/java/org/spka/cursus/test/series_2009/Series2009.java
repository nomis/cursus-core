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
package org.spka.cursus.test.series_2009;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Gender;
import eu.lp0.cursus.db.data.Penalty;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.RaceAttendee;
import eu.lp0.cursus.db.data.RaceTally;
import eu.lp0.cursus.db.data.Series;

public class Series2009 extends AbstractSPKASeries {
	public Series2009() {
		super("SPKA Race Series 2009/10", SPKAConstants.UUID_2005); //$NON-NLS-1$
	}

	protected static final int SERIES_FLEET = 15;
	protected static final int SERIES_FLEET_AT_EVENT1 = 13;
	protected static final int SERIES_FLEET_AT_EVENT2 = 14;
	protected static final int SERIES_FLEET_AT_EVENT3 = 15;
	protected static final int SERIES_FLEET_AT_EVENT4 = 15;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 14;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = ""; //$NON-NLS-1$
	protected static final int RACE1_FLEET = 14;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = ""; //$NON-NLS-1$
	protected static final int RACE2_FLEET = 14;

	protected static final String EVENT2_NAME = "Race Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 10;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = ""; //$NON-NLS-1$
	protected static final int RACE3_FLEET = 10;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = ""; //$NON-NLS-1$
	protected static final int RACE4_FLEET = 10;

	protected static final String EVENT3_NAME = "Race Event 3"; //$NON-NLS-1$
	protected static final String EVENT3_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT3_FLEET = 9;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = ""; //$NON-NLS-1$
	protected static final int RACE5_FLEET = 9;
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = ""; //$NON-NLS-1$
	protected static final int RACE6_FLEET = 9;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = ""; //$NON-NLS-1$
	protected static final int RACE7_FLEET = 9;

	protected static final String EVENT4_NAME = "Race Event 4"; //$NON-NLS-1$
	protected static final String EVENT4_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT4_FLEET = 8;
	protected static final String RACE8_NAME = "Race 8"; //$NON-NLS-1$
	protected static final String RACE8_DESC = ""; //$NON-NLS-1$
	protected static final int RACE8_FLEET = 8;
	protected static final String RACE9_NAME = "Race 9"; //$NON-NLS-1$
	protected static final String RACE9_DESC = ""; //$NON-NLS-1$
	protected static final int RACE9_FLEET = 8;
	protected static final String RACE10_NAME = "Race 10"; //$NON-NLS-1$
	protected static final String RACE10_DESC = ""; //$NON-NLS-1$
	protected static final int RACE10_FLEET = 8;

	protected Pilot sco019;
	protected Pilot sco023;
	protected Pilot sco042;
	protected Pilot sco060;
	protected Pilot sco068;
	protected Pilot sco071;
	protected Pilot sco081;
	protected Pilot sco087;
	protected Pilot sco117;
	protected Pilot sco154;
	protected Pilot sco158;
	protected Pilot sco159;
	protected Pilot sco179;
	protected Pilot sco193;
	protected Pilot sco197;
	protected Pilot k071;

	private Series _series;
	private Event _event1;
	private Race _race1;
	private Race _race2;
	private Event _event2;
	private Race _race3;
	private Race _race4;
	private Event _event3;
	private Race _race5;
	private Race _race6;
	private Race _race7;
	private Event _event4;
	private Race _race8;
	private Race _race9;
	private Race _race10;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
		createEvent2Races();
		createEvent3Races();
		createEvent4Races();
	}

	protected void createSeriesData() throws Exception {
		if (_series != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			// Create the 2009/10 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco019 = new Pilot(series, "SCO019@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco019);

			sco023 = new Pilot(series, "SCO023@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco023);

			sco042 = new Pilot(series, "SCO042@2009", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco042);

			sco060 = new Pilot(series, "SCO060@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco068 = new Pilot(series, "SCO068@2009", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco068);

			sco071 = new Pilot(series, "SCO071@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco071);

			sco081 = new Pilot(series, "SCO081@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco087 = new Pilot(series, "SCO087@2009", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco087);

			sco117 = new Pilot(series, "SCO117@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco117);

			sco154 = new Pilot(series, "SCO154@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco154);

			sco158 = new Pilot(series, "SCO158@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco158);

			sco159 = new Pilot(series, "SCO159@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco179 = new Pilot(series, "SCO179@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco193 = new Pilot(series, "SCO193@2009", Gender.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco193);

			sco197 = new Pilot(series, "SCO197@2006", Gender.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco197);

			k071 = new Pilot(series, "K071@2009", Gender.MALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k071);

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
			race1.getAttendees().put(sco042, new RaceAttendee(race1, sco042, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.M_MARSHAL));
			race1.getAttendees().put(sco071, new RaceAttendee(race1, sco071, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco081, new RaceAttendee(race1, sco081, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco087, new RaceAttendee(race1, sco087, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco117, new RaceAttendee(race1, sco117, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco154, new RaceAttendee(race1, sco154, RaceAttendee.Type.PILOT));
			RaceAttendee att159 = new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT);
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race1.getAttendees().put(sco159, att159);
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco193, new RaceAttendee(race1, sco193, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco197, new RaceAttendee(race1, sco197, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(k071, new RaceAttendee(race1, k071, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "23,154,159,197,179,117,87,19"); //$NON-NLS-1$
			addLaps(race1, "23,154,159,197,179,117,87,19"); //$NON-NLS-1$
			addLaps(race1, "23,154,159,197,179,117,87"); //$NON-NLS-1$
			addLaps(race1, "23,154,159,197,179,117,87"); //$NON-NLS-1$
			addLaps(race1, "23,154,159,197"); //$NON-NLS-1$
			addLaps(race1, "23,154"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco019, new RaceAttendee(race2, sco019, RaceAttendee.Type.M_MARSHAL));
			race2.getAttendees().put(sco023, new RaceAttendee(race2, sco023, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco042, new RaceAttendee(race2, sco042, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco060, new RaceAttendee(race2, sco060, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco071, new RaceAttendee(race2, sco071, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco081, new RaceAttendee(race2, sco081, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco087, new RaceAttendee(race2, sco087, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco117, new RaceAttendee(race2, sco117, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco154, new RaceAttendee(race2, sco154, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco159, new RaceAttendee(race2, sco159, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco193, new RaceAttendee(race2, sco193, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco197, new RaceAttendee(race2, sco197, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(k071, new RaceAttendee(race2, k071, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "23,159,154,117,179,197,60,87,42"); //$NON-NLS-1$
			addLaps(race2, "23,159,154,117,179,197,60,87,42"); //$NON-NLS-1$
			addLaps(race2, "23,159,154,117,179,197,60,87,42"); //$NON-NLS-1$
			addLaps(race2, "23,159,154,117,179,197,60,87,42"); //$NON-NLS-1$
			addLaps(race2, "23,159,154,117,179,197,60,87"); //$NON-NLS-1$
			addLaps(race2, "23,159,154,117,179,197,60"); //$NON-NLS-1$
			addLaps(race2, "23,159,154,117"); //$NON-NLS-1$
			addLaps(race2, "23,159"); //$NON-NLS-1$
			addLaps(race2, "23"); //$NON-NLS-1$
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
		createRace4Data();
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
			race3.getAttendees().put(sco019, new RaceAttendee(race3, sco019, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco023, new RaceAttendee(race3, sco023, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco060, new RaceAttendee(race3, sco060, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco068, new RaceAttendee(race3, sco068, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco117, new RaceAttendee(race3, sco117, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco154, new RaceAttendee(race3, sco154, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco193, new RaceAttendee(race3, sco193, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco197, new RaceAttendee(race3, sco197, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "23,68,117,19,197,159,60,179"); //$NON-NLS-1$
			addLaps(race3, "23,68,117,19,197,159,60"); //$NON-NLS-1$
			addLaps(race3, "23,68,117,19,197,159,60"); //$NON-NLS-1$
			addLaps(race3, "23,68,117,19,197,159,60"); //$NON-NLS-1$
			addLaps(race3, "23,68,117,19,197,159,60"); //$NON-NLS-1$
			addLaps(race3, "23,68,117,19,197,159"); //$NON-NLS-1$
			addLaps(race3, "23,68,117,19,197"); //$NON-NLS-1$
			addLaps(race3, "23,68,117"); //$NON-NLS-1$
			addLaps(race3, "23,68"); //$NON-NLS-1$
			addLaps(race3, "23"); //$NON-NLS-1$
			raceDAO.persist(race3);

			DatabaseSession.commit();

			_race3 = race3;
		} finally {
			db.endSession();
		}
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
			race4.getAttendees().put(sco019, new RaceAttendee(race4, sco019, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco023, new RaceAttendee(race4, sco023, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco060, new RaceAttendee(race4, sco060, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco068, new RaceAttendee(race4, sco068, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco117, new RaceAttendee(race4, sco117, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco154, new RaceAttendee(race4, sco154, RaceAttendee.Type.PILOT));
			RaceAttendee att159 = new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT);
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race4.getAttendees().put(sco159, att159);
			race4.getAttendees().put(sco179, new RaceAttendee(race4, sco179, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco193, new RaceAttendee(race4, sco193, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco197, new RaceAttendee(race4, sco197, RaceAttendee.Type.M_MARSHAL));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "23,19,179,159,117,68,60,154"); //$NON-NLS-1$
			addLaps(race4, "23,19,179,159,117,68,60,154"); //$NON-NLS-1$
			addLaps(race4, "23,19,179,159,117"); //$NON-NLS-1$
			addLaps(race4, "23,19,179"); //$NON-NLS-1$
			addLaps(race4, "23,19"); //$NON-NLS-1$
			addLaps(race4, "23,19"); //$NON-NLS-1$
			addLaps(race4, "23,19"); //$NON-NLS-1$
			addLaps(race4, "23"); //$NON-NLS-1$
			raceDAO.persist(race4);

			DatabaseSession.commit();

			_race4 = race4;
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
		createRace5Data();
		createRace6Data();
		createRace7Data();
	}

	protected void createRace5Data() throws Exception {
		createEvent3Data();

		if (_race5 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			Race race5 = new Race(event3, RACE5_NAME, RACE5_DESC);
			event3.getRaces().add(race5);
			race5.getAttendees().put(sco019, new RaceAttendee(race5, sco019, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco023, new RaceAttendee(race5, sco023, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco060, new RaceAttendee(race5, sco060, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco117, new RaceAttendee(race5, sco117, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco154, new RaceAttendee(race5, sco154, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco158, new RaceAttendee(race5, sco158, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco159, new RaceAttendee(race5, sco159, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco179, new RaceAttendee(race5, sco179, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco197, new RaceAttendee(race5, sco197, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "159,179,23,154,117,197,19,158,60"); //$NON-NLS-1$
			addLaps(race5, "159,179,23,154,117,197,19,158,60"); //$NON-NLS-1$
			addLaps(race5, "159,179,23,154,117,197,19,158,60"); //$NON-NLS-1$
			addLaps(race5, "159,179,23,154,117,197,19,158"); //$NON-NLS-1$
			addLaps(race5, "159,179,23,154,117,197"); //$NON-NLS-1$
			addLaps(race5, "159,179,23,154"); //$NON-NLS-1$
			raceDAO.persist(race5);

			DatabaseSession.commit();

			_race5 = race5;
		} finally {
			db.endSession();
		}
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
			race6.getAttendees().put(sco019, new RaceAttendee(race6, sco019, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco023, new RaceAttendee(race6, sco023, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco060, new RaceAttendee(race6, sco060, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco117, new RaceAttendee(race6, sco117, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco154, new RaceAttendee(race6, sco154, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco158, new RaceAttendee(race6, sco158, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco159, new RaceAttendee(race6, sco159, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco179, new RaceAttendee(race6, sco179, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco197, new RaceAttendee(race6, sco197, RaceAttendee.Type.PILOT));
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race6, "23,154,159,19,179,117,60,158,197"); //$NON-NLS-1$
			addLaps(race6, "23,154,159,19,179,117,60,158,197"); //$NON-NLS-1$
			addLaps(race6, "23,154,159,19,179,117,60,158,197"); //$NON-NLS-1$
			addLaps(race6, "23,154,159,19,179,117,60,158,197"); //$NON-NLS-1$
			addLaps(race6, "23,154,159,19,179,117,60,158,197"); //$NON-NLS-1$
			addLaps(race6, "23,154,159,19,179,117,60,158"); //$NON-NLS-1$
			addLaps(race6, "23,154,159,19,179"); //$NON-NLS-1$
			raceDAO.persist(race6);

			DatabaseSession.commit();

			_race6 = race6;
		} finally {
			db.endSession();
		}
	}

	protected void createRace7Data() throws Exception {
		createEvent3Data();

		if (_race7 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			Race race7 = new Race(event3, RACE7_NAME, RACE7_DESC);
			event3.getRaces().add(race7);
			race7.getAttendees().put(sco019, new RaceAttendee(race7, sco019, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco023, new RaceAttendee(race7, sco023, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco060, new RaceAttendee(race7, sco060, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco117, new RaceAttendee(race7, sco117, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco154, new RaceAttendee(race7, sco154, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco158, new RaceAttendee(race7, sco158, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco159, new RaceAttendee(race7, sco159, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco179, new RaceAttendee(race7, sco179, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco197, new RaceAttendee(race7, sco197, RaceAttendee.Type.PILOT));
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race7, "23,179,154,117,60,197,19,158,159"); //$NON-NLS-1$
			addLaps(race7, "23,179,154,117,60,197,19,158,159"); //$NON-NLS-1$
			addLaps(race7, "23,179,154,117,60,197,19,158,159"); //$NON-NLS-1$
			addLaps(race7, "23,179,154,117,60,197,19,158"); //$NON-NLS-1$
			addLaps(race7, "23,179,154,117,60,197"); //$NON-NLS-1$
			addLaps(race7, "23,179,154,117"); //$NON-NLS-1$
			addLaps(race7, "23,179"); //$NON-NLS-1$
			raceDAO.persist(race7);

			DatabaseSession.commit();

			_race7 = race7;
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
		createRace8Data();
		createRace9Data();
		createRace10Data();
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
			race8.getAttendees().put(sco019, new RaceAttendee(race8, sco019, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco042, new RaceAttendee(race8, sco042, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco060, new RaceAttendee(race8, sco060, RaceAttendee.Type.PILOT));
			RaceAttendee att087 = new RaceAttendee(race8, sco087, RaceAttendee.Type.PILOT);
			att087.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race8.getAttendees().put(sco087, att087);
			race8.getAttendees().put(sco154, new RaceAttendee(race8, sco154, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco159, new RaceAttendee(race8, sco159, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco179, new RaceAttendee(race8, sco179, RaceAttendee.Type.M_MARSHAL));
			race8.getAttendees().put(sco197, new RaceAttendee(race8, sco197, RaceAttendee.Type.PILOT));
			race8.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race8, "159,154,19,197,87,42"); //$NON-NLS-1$
			addLaps(race8, "159,154,19,197,87"); //$NON-NLS-1$
			addLaps(race8, "159,154,19,197,87"); //$NON-NLS-1$
			addLaps(race8, "159,154,19,197,87"); //$NON-NLS-1$
			addLaps(race8, "159,154,19,197,87"); //$NON-NLS-1$
			addLaps(race8, "159,154,19,197"); //$NON-NLS-1$
			addLaps(race8, "159,154,19"); //$NON-NLS-1$
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
			race9.getAttendees().put(sco019, new RaceAttendee(race9, sco019, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco042, new RaceAttendee(race9, sco042, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco060, new RaceAttendee(race9, sco060, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco087, new RaceAttendee(race9, sco087, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco154, new RaceAttendee(race9, sco154, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco159, new RaceAttendee(race9, sco159, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco179, new RaceAttendee(race9, sco179, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco197, new RaceAttendee(race9, sco197, RaceAttendee.Type.PILOT));
			race9.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race9, "179,159,154,197,87,19"); //$NON-NLS-1$
			addLaps(race9, "179,159,154,197,87,19"); //$NON-NLS-1$
			addLaps(race9, "179,159,154,197,87,19"); //$NON-NLS-1$
			addLaps(race9, "179,159,154,197,87"); //$NON-NLS-1$
			addLaps(race9, "179,159,154,197"); //$NON-NLS-1$
			addLaps(race9, "179,159,154"); //$NON-NLS-1$
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
			race10.getAttendees().put(sco019, new RaceAttendee(race10, sco019, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco042, new RaceAttendee(race10, sco042, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco060, new RaceAttendee(race10, sco060, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco087, new RaceAttendee(race10, sco087, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco154, new RaceAttendee(race10, sco154, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco159, new RaceAttendee(race10, sco159, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco179, new RaceAttendee(race10, sco179, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco197, new RaceAttendee(race10, sco197, RaceAttendee.Type.PILOT));
			race10.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race10, "179,154,159,197,87,19"); //$NON-NLS-1$
			addLaps(race10, "179,154,159,197,87,19"); //$NON-NLS-1$
			addLaps(race10, "179,154,159,197,87,19"); //$NON-NLS-1$
			addLaps(race10, "179,154,159,197,87"); //$NON-NLS-1$
			addLaps(race10, "179,154,159,197"); //$NON-NLS-1$
			addLaps(race10, "179,154"); //$NON-NLS-1$
			raceDAO.persist(race10);

			DatabaseSession.commit();

			_race10 = race10;
		} finally {
			db.endSession();
		}
	}
}