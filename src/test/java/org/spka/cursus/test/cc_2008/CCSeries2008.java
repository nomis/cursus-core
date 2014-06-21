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
package org.spka.cursus.test.cc_2008;

import org.spka.cursus.scoring.CCConstants;
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

public class CCSeries2008 extends AbstractSPKASeries {
	public CCSeries2008(boolean top3) {
		super("Celtic Challenge 2008", top3 ? CCConstants.UUID_2008 : SPKAConstants.UUID_2005, "Scotland", "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	protected static final int SERIES_FLEET_AT_EVENT1 = 18;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 18;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = "Saturday"; //$NON-NLS-1$
	protected static final int RACE1_FLEET = 16;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = "Sunday"; //$NON-NLS-1$
	protected static final int RACE2_FLEET = 17;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = "Sunday"; //$NON-NLS-1$
	protected static final int RACE3_FLEET = 17;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = "Sunday"; //$NON-NLS-1$
	protected static final int RACE4_FLEET = 17;

	protected Pilot sco019;
	protected Pilot sco023;
	protected Pilot sco033;
	protected Pilot sco060;
	protected Pilot sco071;
	protected Pilot sco081;
	protected Pilot sco135;
	protected Pilot sco136;
	protected Pilot sco154;
	protected Pilot sco158;
	protected Pilot sco159;
	protected Pilot sco179;
	protected Pilot sco197;
	protected Pilot sco200;
	protected Pilot ir027;
	protected Pilot ir052;
	protected Pilot ir073;
	protected Pilot ir085;

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

			// Create the 2008 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco019 = new Pilot(series, "SCO019@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco019);

			sco023 = new Pilot(series, "SCO023@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco023);

			sco033 = new Pilot(series, "SCO033@2006", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco033);

			sco060 = new Pilot(series, "SCO060@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco071 = new Pilot(series, "SCO071@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco071);

			sco081 = new Pilot(series, "SCO081@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco135 = new Pilot(series, "SCO135@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco135);

			sco136 = new Pilot(series, "SCO136@2005", Gender.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco136);

			sco154 = new Pilot(series, "SCO154@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco154);

			sco158 = new Pilot(series, "SCO158@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco158);

			sco159 = new Pilot(series, "SCO159@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco179 = new Pilot(series, "SCO179@2005", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco197 = new Pilot(series, "SCO197@2006", Gender.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco197);

			sco200 = new Pilot(series, "SCO200@2006", Gender.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco200);

			ir027 = new Pilot(series, "IR027@2005", Gender.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir027);

			ir052 = new Pilot(series, "IR052@2008", Gender.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir052);

			ir073 = new Pilot(series, "IR073@2008", Gender.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir073);

			ir085 = new Pilot(series, "IR085@2008", Gender.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir085);

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
			race1.getAttendees().put(sco023, new RaceAttendee(race1, sco023, RaceAttendee.Type.M_MARSHAL));
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco071, new RaceAttendee(race1, sco071, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco081, new RaceAttendee(race1, sco081, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco135, new RaceAttendee(race1, sco135, RaceAttendee.Type.M_MARSHAL));
			race1.getAttendees().put(sco136, new RaceAttendee(race1, sco136, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco154, new RaceAttendee(race1, sco154, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco159, new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco197, new RaceAttendee(race1, sco197, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco200, new RaceAttendee(race1, sco200, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir027, new RaceAttendee(race1, ir027, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir052, new RaceAttendee(race1, ir052, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir073, new RaceAttendee(race1, ir073, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir085, new RaceAttendee(race1, ir085, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "27,200,19,159,73,81,179,154,52,71,85"); //$NON-NLS-1$
			addLaps(race1, "27,200,19,159,73,81,179,154,52,71"); //$NON-NLS-1$
			addLaps(race1, "27,200,19,159,73,81,179,154,52,71"); //$NON-NLS-1$
			addLaps(race1, "27,200,19,159,73,81,179"); //$NON-NLS-1$
			addLaps(race1, "27,200,19,159"); //$NON-NLS-1$
			addLaps(race1, "27,200,19"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco023, new RaceAttendee(race2, sco023, RaceAttendee.Type.M_MARSHAL));
			race2.getAttendees().put(sco033, new RaceAttendee(race2, sco033, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco060, new RaceAttendee(race2, sco060, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco081, new RaceAttendee(race2, sco081, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco135, new RaceAttendee(race2, sco135, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco136, new RaceAttendee(race2, sco136, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco154, new RaceAttendee(race2, sco154, RaceAttendee.Type.M_MARSHAL));
			race2.getAttendees().put(sco158, new RaceAttendee(race2, sco158, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco159, new RaceAttendee(race2, sco159, RaceAttendee.Type.M_MARSHAL));
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco197, new RaceAttendee(race2, sco197, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco200, new RaceAttendee(race2, sco200, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir027, new RaceAttendee(race2, ir027, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir052, new RaceAttendee(race2, ir052, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir073, new RaceAttendee(race2, ir073, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir085, new RaceAttendee(race2, ir085, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "200,135,27,85,136,179,81,60,52,197,33,73"); //$NON-NLS-1$
			addLaps(race2, "200,135,27,85,136,179,81,60,52,197,33,73"); //$NON-NLS-1$
			addLaps(race2, "200,135,27,85,136,179,81,60,52,197"); //$NON-NLS-1$
			addLaps(race2, "200,135,27,85,136,179,81,60,52,197"); //$NON-NLS-1$
			addLaps(race2, "200,135,27,85,136,179,81,60,52,197"); //$NON-NLS-1$
			addLaps(race2, "200,135,27,85,136,179,81,60,52,197"); //$NON-NLS-1$
			addLaps(race2, "200,135,27,85,136,179"); //$NON-NLS-1$
			addLaps(race2, "200,135,27,85"); //$NON-NLS-1$
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
			race3.getAttendees().put(sco023, new RaceAttendee(race3, sco023, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco033, new RaceAttendee(race3, sco033, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco060, new RaceAttendee(race3, sco060, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco081, new RaceAttendee(race3, sco081, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco135, new RaceAttendee(race3, sco135, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco136, new RaceAttendee(race3, sco136, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco154, new RaceAttendee(race3, sco154, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco158, new RaceAttendee(race3, sco158, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco197, new RaceAttendee(race3, sco197, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco200, new RaceAttendee(race3, sco200, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir027, new RaceAttendee(race3, ir027, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir052, new RaceAttendee(race3, ir052, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir073, new RaceAttendee(race3, ir073, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir085, new RaceAttendee(race3, ir085, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "23,200,27,19,154,73,85,159,52,158"); //$NON-NLS-1$
			addLaps(race3, "23,200,27,19,154,73,85,159,52,158"); //$NON-NLS-1$
			addLaps(race3, "23,200,27,19,154,73,85,159,52,158"); //$NON-NLS-1$
			addLaps(race3, "23,200,27,19,154,73,85,159,52,158"); //$NON-NLS-1$
			addLaps(race3, "23,200,27,19,154,73,85,159,52,158"); //$NON-NLS-1$
			addLaps(race3, "23,200,27,19,154,73,85,159,52"); //$NON-NLS-1$
			addLaps(race3, "23,200,27,19,154,73,85"); //$NON-NLS-1$
			addLaps(race3, "23,200,27,19,154,73,85"); //$NON-NLS-1$
			addLaps(race3, "23,200,27,19,154"); //$NON-NLS-1$
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
			race4.getAttendees().put(sco023, new RaceAttendee(race4, sco023, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco033, new RaceAttendee(race4, sco033, RaceAttendee.Type.M_MARSHAL));
			race4.getAttendees().put(sco060, new RaceAttendee(race4, sco060, RaceAttendee.Type.M_MARSHAL));
			race4.getAttendees().put(sco081, new RaceAttendee(race4, sco081, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco135, new RaceAttendee(race4, sco135, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco136, new RaceAttendee(race4, sco136, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco154, new RaceAttendee(race4, sco154, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco158, new RaceAttendee(race4, sco158, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco179, new RaceAttendee(race4, sco179, RaceAttendee.Type.M_MARSHAL));
			race4.getAttendees().put(sco197, new RaceAttendee(race4, sco197, RaceAttendee.Type.M_MARSHAL));
			race4.getAttendees().put(sco200, new RaceAttendee(race4, sco200, RaceAttendee.Type.M_MARSHAL));
			race4.getAttendees().put(ir027, new RaceAttendee(race4, ir027, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir052, new RaceAttendee(race4, ir052, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir073, new RaceAttendee(race4, ir073, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir085, new RaceAttendee(race4, ir085, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "23,27,135,154,19,73,136,81,159,85,158,52"); //$NON-NLS-1$
			addLaps(race4, "23,27,135,154,19,73,136,81,159,85,158,52"); //$NON-NLS-1$
			addLaps(race4, "23,27,135,154,19,73,136,81,159,85,158,52"); //$NON-NLS-1$
			addLaps(race4, "23,27,135,154,19,73,136,81,159"); //$NON-NLS-1$
			addLaps(race4, "23,27,135,154,19,73,136,81"); //$NON-NLS-1$
			addLaps(race4, "23,27,135,154,19,73,136,81"); //$NON-NLS-1$
			addLaps(race4, "23,27,135,154,19,73,136"); //$NON-NLS-1$
			addLaps(race4, "23,27,135,154,19,73,136"); //$NON-NLS-1$
			addLaps(race4, "23,27,135,154,19"); //$NON-NLS-1$
			addLaps(race4, "23,27,135,154"); //$NON-NLS-1$
			raceDAO.persist(race4);

			DatabaseSession.commit();

			_race4 = race4;
		} finally {
			db.endSession();
		}
	}
}
