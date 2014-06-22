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
package org.spka.cursus.test.cc_2010;

import org.spka.cursus.scoring.CCConstants;
import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Penalty;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.RaceAttendee;
import eu.lp0.cursus.db.data.RaceTally;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.db.data.Sex;

public class CCSeries2010 extends AbstractSPKASeries {
	public CCSeries2010(boolean top5) {
		super("Celtic Challenge 2010", top5 ? CCConstants.UUID_2013 : SPKAConstants.UUID_2005, "Scotland", "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	protected static final int SERIES_FLEET_AT_EVENT1 = 18;
	protected static final int SERIES_FLEET_AT_EVENT2 = 22;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = "Ireland"; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 18;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = ""; //$NON-NLS-1$
	protected static final int RACE1_FLEET = 18;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = ""; //$NON-NLS-1$
	protected static final int RACE2_FLEET = 18;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = ""; //$NON-NLS-1$
	protected static final int RACE3_FLEET = 18;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = ""; //$NON-NLS-1$
	protected static final int RACE4_FLEET = 18;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = ""; //$NON-NLS-1$
	protected static final int RACE5_FLEET = 18;

	protected static final String EVENT2_NAME = "Race Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = "Scotland"; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 12;
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = ""; //$NON-NLS-1$
	protected static final int RACE6_FLEET = 12;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = ""; //$NON-NLS-1$
	protected static final int RACE7_FLEET = 12;
	protected static final String RACE8_NAME = "Race 8"; //$NON-NLS-1$
	protected static final String RACE8_DESC = ""; //$NON-NLS-1$
	protected static final int RACE8_FLEET = 12;

	protected Pilot sco019;
	protected Pilot sco042;
	protected Pilot sco060;
	protected Pilot sco081;
	protected Pilot sco087;
	protected Pilot sco154;
	protected Pilot sco159;
	protected Pilot sco179;
	protected Pilot sco197;
	protected Pilot ir014;
	protected Pilot ir016;
	protected Pilot ir022;
	protected Pilot ir025;
	protected Pilot ir027;
	protected Pilot ir043;
	protected Pilot ir053;
	protected Pilot ir073;
	protected Pilot ir075;
	protected Pilot ir077;
	protected Pilot ir085;
	protected Pilot ir178;
	protected Pilot ir181;

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

			// Create the 2010 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco019 = new Pilot(series, "SCO019@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco019);

			sco042 = new Pilot(series, "SCO042@2009", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco042);

			sco060 = new Pilot(series, "SCO060@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco081 = new Pilot(series, "SCO081@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco087 = new Pilot(series, "SCO087@2009", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco087);

			sco154 = new Pilot(series, "SCO154@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco154);

			sco159 = new Pilot(series, "SCO159@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco179 = new Pilot(series, "SCO179@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco197 = new Pilot(series, "SCO197@2006", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco197);

			ir014 = new Pilot(series, "IR014@2009", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir014);

			ir022 = new Pilot(series, "IR022@2009", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir022);

			ir025 = new Pilot(series, "IR025@2009", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir025);

			ir027 = new Pilot(series, "IR027@2005", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir027);

			ir016 = new Pilot(series, "IR016@2010", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir016);

			ir043 = new Pilot(series, "IR043@2005", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir043);

			ir053 = new Pilot(series, "IR053@2010", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir053);

			ir073 = new Pilot(series, "IR073@2008", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir073);

			ir075 = new Pilot(series, "IR075@2010", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir075);

			ir077 = new Pilot(series, "IR077@2009", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir077);

			ir085 = new Pilot(series, "IR085@2008", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir085);

			ir178 = new Pilot(series, "IR178@2010", null, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir178);

			ir181 = new Pilot(series, "IR181@2010", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir181);

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
			race1.getAttendees().put(sco019, new RaceAttendee(race1, sco019, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco081, new RaceAttendee(race1, sco081, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco159, new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco197, new RaceAttendee(race1, sco197, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir014, new RaceAttendee(race1, ir014, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir016, new RaceAttendee(race1, ir016, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir022, new RaceAttendee(race1, ir022, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir025, new RaceAttendee(race1, ir025, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir027, new RaceAttendee(race1, ir027, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir043, new RaceAttendee(race1, ir043, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir053, new RaceAttendee(race1, ir053, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir073, new RaceAttendee(race1, ir073, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir077, new RaceAttendee(race1, ir077, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir085, new RaceAttendee(race1, ir085, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir178, new RaceAttendee(race1, ir178, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir181, new RaceAttendee(race1, ir181, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "27,85,14,77,81,25,179,43,159,178,73,53,197,19,60"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco060, new RaceAttendee(race2, sco060, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco081, new RaceAttendee(race2, sco081, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco159, new RaceAttendee(race2, sco159, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco197, new RaceAttendee(race2, sco197, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir014, new RaceAttendee(race2, ir014, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir016, new RaceAttendee(race2, ir016, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir022, new RaceAttendee(race2, ir022, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir025, new RaceAttendee(race2, ir025, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir027, new RaceAttendee(race2, ir027, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir043, new RaceAttendee(race2, ir043, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir053, new RaceAttendee(race2, ir053, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir073, new RaceAttendee(race2, ir073, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir077, new RaceAttendee(race2, ir077, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir085, new RaceAttendee(race2, ir085, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir178, new RaceAttendee(race2, ir178, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir181, new RaceAttendee(race2, ir181, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "179,43,27,22,85,77,53,181,81,159,19,60"); //$NON-NLS-1$
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
			race3.getAttendees().put(sco060, new RaceAttendee(race3, sco060, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco081, new RaceAttendee(race3, sco081, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco197, new RaceAttendee(race3, sco197, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir014, new RaceAttendee(race3, ir014, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir016, new RaceAttendee(race3, ir016, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir022, new RaceAttendee(race3, ir022, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir025, new RaceAttendee(race3, ir025, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir027, new RaceAttendee(race3, ir027, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir043, new RaceAttendee(race3, ir043, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir053, new RaceAttendee(race3, ir053, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir073, new RaceAttendee(race3, ir073, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir077, new RaceAttendee(race3, ir077, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir085, new RaceAttendee(race3, ir085, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir178, new RaceAttendee(race3, ir178, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir181, new RaceAttendee(race3, ir181, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "27,14,77,60,25,81,22,179,181,85,53,43,178,73"); //$NON-NLS-1$
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
			race4.getAttendees().put(sco060, new RaceAttendee(race4, sco060, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco081, new RaceAttendee(race4, sco081, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco179, new RaceAttendee(race4, sco179, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco197, new RaceAttendee(race4, sco197, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir014, new RaceAttendee(race4, ir014, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir016, new RaceAttendee(race4, ir016, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir022, new RaceAttendee(race4, ir022, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir025, new RaceAttendee(race4, ir025, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir027, new RaceAttendee(race4, ir027, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir043, new RaceAttendee(race4, ir043, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir053, new RaceAttendee(race4, ir053, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir073, new RaceAttendee(race4, ir073, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir077, new RaceAttendee(race4, ir077, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir085, new RaceAttendee(race4, ir085, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir178, new RaceAttendee(race4, ir178, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir181, new RaceAttendee(race4, ir181, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "77,27,22,159,179,85,81,19,73,25,197,16,60"); //$NON-NLS-1$
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
			race5.getAttendees().put(sco019, new RaceAttendee(race5, sco019, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco060, new RaceAttendee(race5, sco060, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco081, new RaceAttendee(race5, sco081, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco159, new RaceAttendee(race5, sco159, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco179, new RaceAttendee(race5, sco179, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco197, new RaceAttendee(race5, sco197, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir014, new RaceAttendee(race5, ir014, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir016, new RaceAttendee(race5, ir016, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir022, new RaceAttendee(race5, ir022, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir025, new RaceAttendee(race5, ir025, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir027, new RaceAttendee(race5, ir027, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir043, new RaceAttendee(race5, ir043, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir053, new RaceAttendee(race5, ir053, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir073, new RaceAttendee(race5, ir073, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir077, new RaceAttendee(race5, ir077, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir085, new RaceAttendee(race5, ir085, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir178, new RaceAttendee(race5, ir178, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir181, new RaceAttendee(race5, ir181, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "27,14,179,22,19,81,25,181,159,73,197,60,53,85"); //$NON-NLS-1$
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
			race6.getAttendees().put(sco042, new RaceAttendee(race6, sco042, RaceAttendee.Type.PILOT));
			RaceAttendee att087 = new RaceAttendee(race6, sco087, RaceAttendee.Type.PILOT);
			att087.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race6.getAttendees().put(sco087, att087);
			race6.getAttendees().put(sco154, new RaceAttendee(race6, sco154, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco159, new RaceAttendee(race6, sco159, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco179, new RaceAttendee(race6, sco179, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco197, new RaceAttendee(race6, sco197, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(ir027, new RaceAttendee(race6, ir027, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(ir053, new RaceAttendee(race6, ir053, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(ir073, new RaceAttendee(race6, ir073, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(ir075, new RaceAttendee(race6, ir075, RaceAttendee.Type.PILOT));
			RaceAttendee att085 = new RaceAttendee(race6, ir085, RaceAttendee.Type.PILOT);
			att085.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race6.getAttendees().put(ir085, att085);
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race6, "159,73,154,85,19,197,87,27,53,42"); //$NON-NLS-1$
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
			race7.getAttendees().put(sco019, new RaceAttendee(race7, sco019, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco042, new RaceAttendee(race7, sco042, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco087, new RaceAttendee(race7, sco087, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco154, new RaceAttendee(race7, sco154, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco159, new RaceAttendee(race7, sco159, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco179, new RaceAttendee(race7, sco179, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco197, new RaceAttendee(race7, sco197, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(ir027, new RaceAttendee(race7, ir027, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(ir053, new RaceAttendee(race7, ir053, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(ir073, new RaceAttendee(race7, ir073, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(ir075, new RaceAttendee(race7, ir075, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(ir085, new RaceAttendee(race7, ir085, RaceAttendee.Type.PILOT));
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race7, "27,179,159,154,197,75,87,19,53"); //$NON-NLS-1$
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
			race8.getAttendees().put(sco019, new RaceAttendee(race8, sco019, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco042, new RaceAttendee(race8, sco042, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco087, new RaceAttendee(race8, sco087, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco154, new RaceAttendee(race8, sco154, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco159, new RaceAttendee(race8, sco159, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco179, new RaceAttendee(race8, sco179, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco197, new RaceAttendee(race8, sco197, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(ir027, new RaceAttendee(race8, ir027, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(ir053, new RaceAttendee(race8, ir053, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(ir073, new RaceAttendee(race8, ir073, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(ir075, new RaceAttendee(race8, ir075, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(ir085, new RaceAttendee(race8, ir085, RaceAttendee.Type.PILOT));
			race8.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race8, "85,179,73,27,154,159,197,75,87,19,53"); //$NON-NLS-1$
			raceDAO.persist(race8);

			DatabaseSession.commit();

			_race8 = race8;
		} finally {
			db.endSession();
		}
	}
}
