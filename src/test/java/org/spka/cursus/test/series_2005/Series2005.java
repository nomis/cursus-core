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
package org.spka.cursus.test.series_2005;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Gender;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.RaceAttendee;
import eu.lp0.cursus.db.data.RaceTally;
import eu.lp0.cursus.db.data.Series;

public class Series2005 extends AbstractSPKASeries {
	public Series2005() {
		super("SPKA Race Series 2005/06", SPKAConstants.UUID_2005, "Scotland", "England"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	protected static final int SERIES_FLEET_AT_EVENT1 = 16;
	protected static final int SERIES_FLEET_AT_EVENT2 = 19;
	protected static final int SERIES_FLEET_AT_EVENT3 = 20;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 16;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = ""; //$NON-NLS-1$
	protected static final int RACE1_FLEET = 16;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = ""; //$NON-NLS-1$
	protected static final int RACE2_FLEET = 16;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = ""; //$NON-NLS-1$
	protected static final int RACE3_FLEET = 16;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = ""; //$NON-NLS-1$
	protected static final int RACE4_FLEET = 16;

	protected static final String EVENT2_NAME = "Race Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 17;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = ""; //$NON-NLS-1$
	protected static final int RACE5_FLEET = 17;
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = ""; //$NON-NLS-1$
	protected static final int RACE6_FLEET = 17;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = ""; //$NON-NLS-1$
	protected static final int RACE7_FLEET = 17;

	protected static final String EVENT3_NAME = "Race Event 3"; //$NON-NLS-1$
	protected static final String EVENT3_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT3_FLEET = 17;
	protected static final String RACE8_NAME = "Race 8"; //$NON-NLS-1$
	protected static final String RACE8_DESC = ""; //$NON-NLS-1$
	protected static final int RACE8_FLEET = 17;

	protected Pilot sco019;
	protected Pilot sco020;
	protected Pilot sco023;
	protected Pilot sco050;
	protected Pilot sco060;
	protected Pilot sco071;
	protected Pilot sco081;
	protected Pilot sco095;
	protected Pilot sco100;
	protected Pilot sco105;
	protected Pilot sco109;
	protected Pilot sco117;
	protected Pilot sco135;
	protected Pilot sco136;
	protected Pilot sco143;
	protected Pilot sco154;
	protected Pilot sco158;
	protected Pilot sco159;
	protected Pilot sco160;
	protected Pilot sco169;
	protected Pilot sco178;
	protected Pilot sco179;
	protected Pilot ir027;
	protected Pilot ir043;
	protected Pilot k882;

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
	private Event _event3;
	private Race _race8;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
		createEvent2Races();
		createEvent3Races();
	}

	protected void createSeriesData() throws Exception {
		if (_series != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			// Create the 2005/06 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco019 = new Pilot(series, "SCO019@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco019);

			sco020 = new Pilot(series, "SCO020@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco020);

			sco023 = new Pilot(series, "SCO023@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco023);

			sco050 = new Pilot(series, "SCO050@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco050);

			sco060 = new Pilot(series, "SCO060@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco071 = new Pilot(series, "SCO071@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco071);

			sco081 = new Pilot(series, "SCO081@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco095 = new Pilot(series, "SCO095@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco095);

			sco100 = new Pilot(series, "SCO100@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco100);

			sco105 = new Pilot(series, "SCO105@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco105);

			sco109 = new Pilot(series, "SCO109@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco109);

			sco117 = new Pilot(series, "SCO117@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco117);

			sco135 = new Pilot(series, "SCO135@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco135);

			sco136 = new Pilot(series, "SCO136@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco136);

			sco143 = new Pilot(series, "SCO143@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco143);

			sco154 = new Pilot(series, "SCO154@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco154);

			sco158 = new Pilot(series, "SCO158@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco158);

			sco159 = new Pilot(series, "SCO159@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco160 = new Pilot(series, "SCO160@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco160);

			sco169 = new Pilot(series, "SCO169@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco169);

			sco178 = new Pilot(series, "SCO178@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco178);

			sco179 = new Pilot(series, "SCO179@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			ir027 = new Pilot(series, "IR027@2005", Gender.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir027);

			ir043 = new Pilot(series, "IR043@2005", Gender.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir043);

			k882 = new Pilot(series, "K882@2005", Gender.MALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k882);

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
			race1.getAttendees().put(sco019, new RaceAttendee(race1, sco019, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco020, new RaceAttendee(race1, sco020, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco023, new RaceAttendee(race1, sco023, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco050, new RaceAttendee(race1, sco050, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco081, new RaceAttendee(race1, sco081, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco095, new RaceAttendee(race1, sco095, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco105, new RaceAttendee(race1, sco105, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco109, new RaceAttendee(race1, sco109, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco117, new RaceAttendee(race1, sco117, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco135, new RaceAttendee(race1, sco135, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco136, new RaceAttendee(race1, sco136, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco154, new RaceAttendee(race1, sco154, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco158, new RaceAttendee(race1, sco158, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco159, new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco160, new RaceAttendee(race1, sco160, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "23,20,81,160,159,19,105,95,158,136,60"); //$NON-NLS-1$
			addLaps(race1, "23,20,81,160,159,19,105,95,158,136"); //$NON-NLS-1$
			addLaps(race1, "23,20,81,160,159"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco020, new RaceAttendee(race2, sco020, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco023, new RaceAttendee(race2, sco023, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco050, new RaceAttendee(race2, sco050, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco060, new RaceAttendee(race2, sco060, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco081, new RaceAttendee(race2, sco081, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco095, new RaceAttendee(race2, sco095, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco105, new RaceAttendee(race2, sco105, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco109, new RaceAttendee(race2, sco109, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco117, new RaceAttendee(race2, sco117, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco135, new RaceAttendee(race2, sco135, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco136, new RaceAttendee(race2, sco136, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco154, new RaceAttendee(race2, sco154, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco158, new RaceAttendee(race2, sco158, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco159, new RaceAttendee(race2, sco159, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco160, new RaceAttendee(race2, sco160, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "20,23,95,19,81,154,50,109,160,135,158,60,136"); //$NON-NLS-1$
			addLaps(race2, "20,23,95,19,81,154,50,109,160,135,158,60"); //$NON-NLS-1$
			addLaps(race2, "20,23,95,19,81,154,50"); //$NON-NLS-1$
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
			race3.getAttendees().put(sco019, new RaceAttendee(race3, sco019, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco020, new RaceAttendee(race3, sco020, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco023, new RaceAttendee(race3, sco023, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco050, new RaceAttendee(race3, sco050, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco060, new RaceAttendee(race3, sco060, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco081, new RaceAttendee(race3, sco081, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco095, new RaceAttendee(race3, sco095, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco105, new RaceAttendee(race3, sco105, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco109, new RaceAttendee(race3, sco109, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco117, new RaceAttendee(race3, sco117, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco135, new RaceAttendee(race3, sco135, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco136, new RaceAttendee(race3, sco136, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco154, new RaceAttendee(race3, sco154, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco158, new RaceAttendee(race3, sco158, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco160, new RaceAttendee(race3, sco160, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "160,20,23,95,154,136,50,158,60,117,109,81,135,159,19"); //$NON-NLS-1$
			addLaps(race3, "160,20,23,95,154,136,50,158,60,117,109,81,135,159"); //$NON-NLS-1$
			addLaps(race3, "160,20,23,95,154,136,50,158,60,117,109,81,135"); //$NON-NLS-1$
			addLaps(race3, "160,20,23,95,154,136,50,158,60,117,109,81"); //$NON-NLS-1$
			addLaps(race3, "160,20,23,95,154,136,50"); //$NON-NLS-1$
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
			race4.getAttendees().put(sco019, new RaceAttendee(race4, sco019, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco020, new RaceAttendee(race4, sco020, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco023, new RaceAttendee(race4, sco023, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco050, new RaceAttendee(race4, sco050, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco060, new RaceAttendee(race4, sco060, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco081, new RaceAttendee(race4, sco081, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco095, new RaceAttendee(race4, sco095, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco105, new RaceAttendee(race4, sco105, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco109, new RaceAttendee(race4, sco109, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco117, new RaceAttendee(race4, sco117, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco135, new RaceAttendee(race4, sco135, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco136, new RaceAttendee(race4, sco136, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco154, new RaceAttendee(race4, sco154, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco158, new RaceAttendee(race4, sco158, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco160, new RaceAttendee(race4, sco160, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "23,20,160,81,154,19,50,158,136,159,95,117,135,109,60"); //$NON-NLS-1$
			addLaps(race4, "23,20,160,81,154,19,50,158,136,159,95,117,135,109,60"); //$NON-NLS-1$
			addLaps(race4, "23,20,160,81,154,19,50,158,136,159,95,117,135,109,60"); //$NON-NLS-1$
			addLaps(race4, "23,20,160,81,154,19,50,158,136,159,95"); //$NON-NLS-1$
			addLaps(race4, "23,20,160,81"); //$NON-NLS-1$
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
			race5.getAttendees().put(sco019, new RaceAttendee(race5, sco019, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco023, new RaceAttendee(race5, sco023, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco050, new RaceAttendee(race5, sco050, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco060, new RaceAttendee(race5, sco060, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco071, new RaceAttendee(race5, sco071, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco081, new RaceAttendee(race5, sco081, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco095, new RaceAttendee(race5, sco095, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco100, new RaceAttendee(race5, sco100, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco109, new RaceAttendee(race5, sco109, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco117, new RaceAttendee(race5, sco117, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco135, new RaceAttendee(race5, sco135, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco136, new RaceAttendee(race5, sco136, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco154, new RaceAttendee(race5, sco154, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco158, new RaceAttendee(race5, sco158, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco159, new RaceAttendee(race5, sco159, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco160, new RaceAttendee(race5, sco160, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(k882, new RaceAttendee(race5, k882, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "160,23,882,19,81,109,117,154,95,100,136,71,159,158,50,135"); //$NON-NLS-1$
			addLaps(race5, "160,23,882,19,81,109,117,154,95,100,136,71,159,158,50"); //$NON-NLS-1$
			addLaps(race5, "160,23,882,19,81,109,117,154,95,100,136,71,159,158"); //$NON-NLS-1$
			addLaps(race5, "160,23,882,19"); //$NON-NLS-1$
			addLaps(race5, "160,23,882"); //$NON-NLS-1$
			raceDAO.persist(race5);

			DatabaseSession.commit();

			_race5 = race5;
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
			race6.getAttendees().put(sco019, new RaceAttendee(race6, sco019, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco023, new RaceAttendee(race6, sco023, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco050, new RaceAttendee(race6, sco050, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco060, new RaceAttendee(race6, sco060, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco071, new RaceAttendee(race6, sco071, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco081, new RaceAttendee(race6, sco081, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco095, new RaceAttendee(race6, sco095, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco100, new RaceAttendee(race6, sco100, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco109, new RaceAttendee(race6, sco109, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco117, new RaceAttendee(race6, sco117, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco135, new RaceAttendee(race6, sco135, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco136, new RaceAttendee(race6, sco136, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco154, new RaceAttendee(race6, sco154, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco158, new RaceAttendee(race6, sco158, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco159, new RaceAttendee(race6, sco159, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco160, new RaceAttendee(race6, sco160, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(k882, new RaceAttendee(race6, k882, RaceAttendee.Type.PILOT));
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race6, "23,882,160,81,95,19,109,71,154,135,117,100,50,136,159,158,60"); //$NON-NLS-1$
			addLaps(race6, "23,882,160,81,95,19,109,71,154,135,117,100,50,136,159,158,60"); //$NON-NLS-1$
			addLaps(race6, "23,882,160,81,95,19,109,71,154,135,117,100,50,136,159,158,60"); //$NON-NLS-1$
			addLaps(race6, "23,882,160,81,95,19,109,71,154,135,117,100,50,136,159,158,60"); //$NON-NLS-1$
			addLaps(race6, "23,882,160,81,95,19,109,71,154,135,117,100,50,136,159,158"); //$NON-NLS-1$
			addLaps(race6, "23,882,160,81,95,19,109,71,154,135,117,100,50"); //$NON-NLS-1$
			addLaps(race6, "23,882,160,81,95"); //$NON-NLS-1$
			addLaps(race6, "23,882,160"); //$NON-NLS-1$
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
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			Race race7 = new Race(event2, RACE7_NAME, RACE7_DESC);
			event2.getRaces().add(race7);
			race7.getAttendees().put(sco019, new RaceAttendee(race7, sco019, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco023, new RaceAttendee(race7, sco023, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco050, new RaceAttendee(race7, sco050, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco060, new RaceAttendee(race7, sco060, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco071, new RaceAttendee(race7, sco071, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco081, new RaceAttendee(race7, sco081, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco095, new RaceAttendee(race7, sco095, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco100, new RaceAttendee(race7, sco100, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco109, new RaceAttendee(race7, sco109, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco117, new RaceAttendee(race7, sco117, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco135, new RaceAttendee(race7, sco135, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco136, new RaceAttendee(race7, sco136, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco154, new RaceAttendee(race7, sco154, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco158, new RaceAttendee(race7, sco158, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco159, new RaceAttendee(race7, sco159, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco160, new RaceAttendee(race7, sco160, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(k882, new RaceAttendee(race7, k882, RaceAttendee.Type.PILOT));
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race7, "23,160,81,882,154,158,117,100,109,19,136,159,135,60,50,95,71"); //$NON-NLS-1$
			addLaps(race7, "23,160,81,882,154,158,117,100,109,19,136,159,135,60,50,95"); //$NON-NLS-1$
			addLaps(race7, "23,160,81,882,154,158,117,100,109,19,136,159"); //$NON-NLS-1$
			addLaps(race7, "23,160,81,882,154,158,117,100,109,19"); //$NON-NLS-1$
			addLaps(race7, "23,160,81,882,154,158"); //$NON-NLS-1$
			addLaps(race7, "23,160,81,882"); //$NON-NLS-1$
			addLaps(race7, "23,160"); //$NON-NLS-1$
			raceDAO.persist(race7);

			DatabaseSession.commit();

			_race7 = race7;
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
		createRace8Data();
	}

	protected void createRace8Data() throws Exception {
		createEvent3Data();

		if (_race8 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			Race race8 = new Race(event3, RACE8_NAME, RACE8_DESC);
			event3.getRaces().add(race8);
			race8.getAttendees().put(sco019, new RaceAttendee(race8, sco019, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco023, new RaceAttendee(race8, sco023, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco050, new RaceAttendee(race8, sco050, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco060, new RaceAttendee(race8, sco060, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco071, new RaceAttendee(race8, sco071, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco081, new RaceAttendee(race8, sco081, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco095, new RaceAttendee(race8, sco095, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco100, new RaceAttendee(race8, sco100, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco109, new RaceAttendee(race8, sco109, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco117, new RaceAttendee(race8, sco117, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco136, new RaceAttendee(race8, sco136, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco154, new RaceAttendee(race8, sco154, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco159, new RaceAttendee(race8, sco159, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco160, new RaceAttendee(race8, sco160, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco169, new RaceAttendee(race8, sco169, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(ir027, new RaceAttendee(race8, ir027, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(ir043, new RaceAttendee(race8, ir043, RaceAttendee.Type.PILOT));
			race8.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race8, "23,43,27,160,19,169,71,117,159,154,81,109,100,60,50,95,136"); //$NON-NLS-1$
			addLaps(race8, "23,43,27,160,19,169,71,117,159,154,81,109,100"); //$NON-NLS-1$
			addLaps(race8, "23,43,27,160,19,169,71,117,159,154,81"); //$NON-NLS-1$
			addLaps(race8, "23,43,27,160,19,169,71,117,159"); //$NON-NLS-1$
			addLaps(race8, "23,43,27,160,19,169,71"); //$NON-NLS-1$
			addLaps(race8, "23,43,27,160,19,169"); //$NON-NLS-1$
			addLaps(race8, "23,43,27,160"); //$NON-NLS-1$
			addLaps(race8, "23,43"); //$NON-NLS-1$
			raceDAO.persist(race8);

			DatabaseSession.commit();

			_race8 = race8;
		} finally {
			db.endSession();
		}
	}
}
