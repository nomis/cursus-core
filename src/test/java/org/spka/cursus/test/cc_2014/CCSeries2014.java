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
package org.spka.cursus.test.cc_2014;

import org.fisly.cursus.scoring.FISLYConstants;
import org.spka.cursus.scoring.CCConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Sex;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.RaceAttendee;
import eu.lp0.cursus.db.data.RaceTally;
import eu.lp0.cursus.db.data.Series;

public class CCSeries2014 extends AbstractSPKASeries {
	public CCSeries2014(boolean top5) {
		super("Celtic Challenge 2014", top5 ? CCConstants.UUID_2013 : FISLYConstants.UUID_2010, "Scotland", "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	protected static final int SERIES_FLEET = 15;
	protected static final int SERIES_FLEET_AT_EVENT1 = 10;
	protected static final int SERIES_FLEET_AT_EVENT2 = 15;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = "Bettystown (24/05/2014)"; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 10;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = "Bettystown (24/05/2014)"; //$NON-NLS-1$
	protected static final int RACE1_PILOTS = 10;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = "Bettystown (24/05/2014)"; //$NON-NLS-1$
	protected static final int RACE2_PILOTS = 10;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = "Bettystown (24/05/2014)"; //$NON-NLS-1$
	protected static final int RACE3_PILOTS = 10;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = "Bettystown (24/05/2014)"; //$NON-NLS-1$
	protected static final int RACE4_PILOTS = 10;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = "Bettystown (24/05/2014)"; //$NON-NLS-1$
	protected static final int RACE5_PILOTS = 10;

	protected static final String EVENT2_NAME = "Race Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = "West Sands (14/06/2014 and 15/06/2014)"; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 0;
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = "West Sands (14/06/2014)"; //$NON-NLS-1$
	protected static final int RACE6_PILOTS = 9;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = "West Sands (14/06/2014)"; //$NON-NLS-1$
	protected static final int RACE7_PILOTS = 9;

	protected Pilot sco060;
	protected Pilot sco066;
	protected Pilot sco076;
	protected Pilot sco116;
	protected Pilot sco153;
	protected Pilot sco159;
	protected Pilot sco179;
	protected Pilot sco808;
	protected Pilot ir000;
	protected Pilot ir014;
	protected Pilot ir016;
	protected Pilot ir025;
	protected Pilot ir027;
	protected Pilot ir053;
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

			// Create the 2014 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco060 = new Pilot(series, "SCO060@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco066 = new Pilot(series, "SCO066@2013", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco066);

			sco076 = new Pilot(series, "SCO076@2012", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco076);

			sco116 = new Pilot(series, "SCO116@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco116);

			sco153 = new Pilot(series, "SCO153@2010", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco153);

			sco159 = new Pilot(series, "SCO159@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco179 = new Pilot(series, "SCO179@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco808 = new Pilot(series, "SCO808@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco808);

			ir000 = new Pilot(series, "IR000@2014", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir000);

			ir014 = new Pilot(series, "IR014@2009", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir014);

			ir016 = new Pilot(series, "IR016@2013", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir016);

			ir025 = new Pilot(series, "IR025@2009", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir025);

			ir027 = new Pilot(series, "IR027@2005", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir027);

			ir053 = new Pilot(series, "IR053@2012", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir053);

			ir181 = new Pilot(series, "IR181@2012", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
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
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco116, new RaceAttendee(race1, sco116, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco153, new RaceAttendee(race1, sco153, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir000, new RaceAttendee(race1, ir000, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir014, new RaceAttendee(race1, ir014, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir016, new RaceAttendee(race1, ir016, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir025, new RaceAttendee(race1, ir025, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir027, new RaceAttendee(race1, ir027, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir053, new RaceAttendee(race1, ir053, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "14,179,116,27,53,16,60,25,153"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco116, new RaceAttendee(race2, sco116, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco153, new RaceAttendee(race2, sco153, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir000, new RaceAttendee(race2, ir000, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir014, new RaceAttendee(race2, ir014, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir016, new RaceAttendee(race2, ir016, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir025, new RaceAttendee(race2, ir025, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir027, new RaceAttendee(race2, ir027, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir053, new RaceAttendee(race2, ir053, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "14,27,53,179,25,16,60,153,116"); //$NON-NLS-1$
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
			race3.getAttendees().put(sco116, new RaceAttendee(race3, sco116, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco153, new RaceAttendee(race3, sco153, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir000, new RaceAttendee(race3, ir000, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir014, new RaceAttendee(race3, ir014, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir016, new RaceAttendee(race3, ir016, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir025, new RaceAttendee(race3, ir025, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir027, new RaceAttendee(race3, ir027, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir053, new RaceAttendee(race3, ir053, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "27,179,116,53,25,16,60,0,153"); //$NON-NLS-1$
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
			race4.getAttendees().put(sco116, new RaceAttendee(race4, sco116, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco153, new RaceAttendee(race4, sco153, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco179, new RaceAttendee(race4, sco179, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir000, new RaceAttendee(race4, ir000, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir014, new RaceAttendee(race4, ir014, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir016, new RaceAttendee(race4, ir016, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir025, new RaceAttendee(race4, ir025, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir027, new RaceAttendee(race4, ir027, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir053, new RaceAttendee(race4, ir053, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "179,27,14,116,53,60,16,153,25"); //$NON-NLS-1$
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
			race5.getAttendees().put(sco060, new RaceAttendee(race5, sco060, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco116, new RaceAttendee(race5, sco116, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco153, new RaceAttendee(race5, sco153, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco179, new RaceAttendee(race5, sco179, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir000, new RaceAttendee(race5, ir000, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir014, new RaceAttendee(race5, ir014, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir016, new RaceAttendee(race5, ir016, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir025, new RaceAttendee(race5, ir025, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir027, new RaceAttendee(race5, ir027, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir053, new RaceAttendee(race5, ir053, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "27,116,179,14,53,25,0,153,60"); //$NON-NLS-1$
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
			race6.getAttendees().put(sco076, new RaceAttendee(race6, sco076, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco116, new RaceAttendee(race6, sco116, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco159, new RaceAttendee(race6, sco159, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco179, new RaceAttendee(race6, sco179, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco808, new RaceAttendee(race6, sco808, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(ir027, new RaceAttendee(race6, ir027, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(ir053, new RaceAttendee(race6, ir053, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(ir181, new RaceAttendee(race6, ir181, RaceAttendee.Type.PILOT));
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			addLaps(race6, "27,116,181,179,808,159"); //$NON-NLS-1$
			// 2
			addLaps(race6, "27,116,181,179,53,808,159"); //$NON-NLS-1$
			// 3
			addLaps(race6, "27,116,181,179,53"); //$NON-NLS-1$
			// 4
			addLaps(race6, "116,181,179,27,159,808"); //$NON-NLS-1$
			// 5
			addLaps(race6, "116,27,181,179,808,159,53"); //$NON-NLS-1$
			// 6
			addLaps(race6, "116,27,179,181,808,159,53"); //$NON-NLS-1$
			// 7
			addLaps(race6, "116,27,179,181,808,159"); //$NON-NLS-1$
			// 8
			addLaps(race6, "27,116,179,181,53,808,159"); //$NON-NLS-1$
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
			race7.getAttendees().put(sco076, new RaceAttendee(race7, sco076, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco116, new RaceAttendee(race7, sco116, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco159, new RaceAttendee(race7, sco159, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco179, new RaceAttendee(race7, sco179, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco808, new RaceAttendee(race7, sco808, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(ir027, new RaceAttendee(race7, ir027, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(ir053, new RaceAttendee(race7, ir053, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(ir181, new RaceAttendee(race7, ir181, RaceAttendee.Type.PILOT));
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			addLaps(race7, "27,181,179,116,808,159,53"); //$NON-NLS-1$
			// 2
			addLaps(race7, "27,76,181,808,179,116,159"); //$NON-NLS-1$
			// 3
			addLaps(race7, "27,181,179,808,116,53,159,76"); //$NON-NLS-1$
			// 4
			addLaps(race7, "27,181,179,808,116,53"); //$NON-NLS-1$
			// 5
			addLaps(race7, "27,159,181,179,116,808,53"); //$NON-NLS-1$
			// 6
			addLaps(race7, "27,181,179,116,159,808,53,181"); //$NON-NLS-1$
			// 7
			addLaps(race7, "27,179,116,808,159,53,181,76"); //$NON-NLS-1$
			// 8
			addLaps(race7, "27,179,116,808,159,53"); //$NON-NLS-1$
			raceDAO.persist(race7);

			DatabaseSession.commit();

			_race7 = race7;
		} finally {
			db.endSession();
		}
	}
}
