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
package org.spka.cursus.test.cc_2009;

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

public class CCSeries2009 extends AbstractSPKASeries {
	private boolean top6;

	public CCSeries2009(boolean top6) {
		super("Celtic Challenge 2009", top6 ? CCConstants.UUID_2009 : SPKAConstants.UUID_2005, "Scotland", "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		this.top6 = top6;
	}

	protected static final int SERIES_FLEET_AT_EVENT1 = 17;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 22;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = "Saturday"; //$NON-NLS-1$
	protected static final int RACE1_FLEET = 22;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = "Saturday"; //$NON-NLS-1$
	protected static final int RACE2_FLEET = 22;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = "Saturday"; //$NON-NLS-1$
	protected static final int RACE3_FLEET = 22;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = "Sunday"; //$NON-NLS-1$
	protected static final int RACE4_FLEET = 22;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = "Sunday"; //$NON-NLS-1$
	protected static final int RACE5_FLEET = 22;

	protected Pilot sco019;
	protected Pilot sco023;
	protected Pilot sco060;
	protected Pilot sco081;
	protected Pilot sco154;
	protected Pilot sco159;
	protected Pilot sco179;
	protected Pilot sco197;
	protected Pilot ir014;
	protected Pilot ir022;
	protected Pilot ir025;
	protected Pilot ir027;
	protected Pilot ir028;
	protected Pilot ir043;
	protected Pilot ir073;
	protected Pilot ir077;
	protected Pilot ir085;
	protected Pilot k015;
	protected Pilot k016;
	protected Pilot k078;
	protected Pilot k099;
	protected Pilot k877;

	private Series _series;
	private Event _event1;
	private Race _race1;
	private Race _race2;
	private Race _race3;
	private Race _race4;
	private Race _race5;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
	}

	@Override
	protected boolean isStrictCountryFilter() {
		return top6;
	}

	protected void createSeriesData() throws Exception {
		if (_series != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			// Create the 2009 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco019 = new Pilot(series, "SCO019@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco019);

			sco023 = new Pilot(series, "SCO023@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco023);

			sco060 = new Pilot(series, "SCO060@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco081 = new Pilot(series, "SCO081@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

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

			ir028 = new Pilot(series, "IR028@2009", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir028);

			ir043 = new Pilot(series, "IR043@2005", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir043);

			ir073 = new Pilot(series, "IR073@2008", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir073);

			ir077 = new Pilot(series, "IR077@2009", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir077);

			ir085 = new Pilot(series, "IR085@2008", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir085);

			k015 = new Pilot(series, "K015@2009", Sex.MALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k015);

			k016 = new Pilot(series, "K016@2009", Sex.MALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k016);

			k078 = new Pilot(series, "K078@2009", Sex.FEMALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k078);

			k099 = new Pilot(series, "K099@2009", Sex.MALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k099);

			k877 = new Pilot(series, "K877@2009", Sex.MALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k877);

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
			race1.getAttendees().put(sco023, new RaceAttendee(race1, sco023, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.V_MARSHAL));
			race1.getAttendees().put(sco081, new RaceAttendee(race1, sco081, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco154, new RaceAttendee(race1, sco154, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco159, new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco197, new RaceAttendee(race1, sco197, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir014, new RaceAttendee(race1, ir014, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir022, new RaceAttendee(race1, ir022, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir025, new RaceAttendee(race1, ir025, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir027, new RaceAttendee(race1, ir027, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir028, new RaceAttendee(race1, ir028, RaceAttendee.Type.V_MARSHAL));
			race1.getAttendees().put(ir043, new RaceAttendee(race1, ir043, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir073, new RaceAttendee(race1, ir073, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir077, new RaceAttendee(race1, ir077, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir085, new RaceAttendee(race1, ir085, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(k015, new RaceAttendee(race1, k015, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(k016, new RaceAttendee(race1, k016, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(k078, new RaceAttendee(race1, k078, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(k099, new RaceAttendee(race1, k099, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(k877, new RaceAttendee(race1, k877, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "99,16,23,22,43,14,179,159,27,85,19,73,77,197,877,15,25,154,81,78"); //$NON-NLS-1$
			addLaps(race1, "99,16,23,22,43,14,179,159,27,85,19,73,77,197,877,15,25"); //$NON-NLS-1$
			addLaps(race1, "99,16,23,22,43,14,179,159,27,85,19,73,77,197,877"); //$NON-NLS-1$
			addLaps(race1, "99,16,23,22,43,14,179,159,27,85,19,73"); //$NON-NLS-1$
			addLaps(race1, "99,16,23,22"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco060, new RaceAttendee(race2, sco060, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco081, new RaceAttendee(race2, sco081, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco154, new RaceAttendee(race2, sco154, RaceAttendee.Type.PILOT));
			RaceAttendee att159 = new RaceAttendee(race2, sco159, RaceAttendee.Type.PILOT);
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race2.getAttendees().put(sco159, att159);
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco197, new RaceAttendee(race2, sco197, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir014, new RaceAttendee(race2, ir014, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir022, new RaceAttendee(race2, ir022, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir025, new RaceAttendee(race2, ir025, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir027, new RaceAttendee(race2, ir027, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir028, new RaceAttendee(race2, ir028, RaceAttendee.Type.V_MARSHAL));
			RaceAttendee att043 = new RaceAttendee(race2, ir043, RaceAttendee.Type.PILOT);
			att043.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 2));
			race2.getAttendees().put(ir043, att043);
			race2.getAttendees().put(ir073, new RaceAttendee(race2, ir073, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir077, new RaceAttendee(race2, ir077, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir085, new RaceAttendee(race2, ir085, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(k015, new RaceAttendee(race2, k015, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(k016, new RaceAttendee(race2, k016, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(k078, new RaceAttendee(race2, k078, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(k099, new RaceAttendee(race2, k099, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(k877, new RaceAttendee(race2, k877, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "23,99,16,27,877,19,43,159,179,15,78,14,154,60,22,197,25,85,73"); //$NON-NLS-1$
			addLaps(race2, "23,99,16,27,877,19,43,159,179,15,78,14,154,60,22,197,25,85,73"); //$NON-NLS-1$
			addLaps(race2, "23,99,16,27,877,19,43,159,179,15,78,14,154,60,22,197,25"); //$NON-NLS-1$
			addLaps(race2, "23,99,16,27,877,19,43,159,179,15,78,14,154,60"); //$NON-NLS-1$
			addLaps(race2, "23,99,16,27,877,43"); //$NON-NLS-1$
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
			race3.getAttendees().put(sco060, new RaceAttendee(race3, sco060, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco081, new RaceAttendee(race3, sco081, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco154, new RaceAttendee(race3, sco154, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco197, new RaceAttendee(race3, sco197, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir014, new RaceAttendee(race3, ir014, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir022, new RaceAttendee(race3, ir022, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir025, new RaceAttendee(race3, ir025, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir027, new RaceAttendee(race3, ir027, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir028, new RaceAttendee(race3, ir028, RaceAttendee.Type.V_MARSHAL));
			race3.getAttendees().put(ir043, new RaceAttendee(race3, ir043, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir073, new RaceAttendee(race3, ir073, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir077, new RaceAttendee(race3, ir077, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir085, new RaceAttendee(race3, ir085, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(k015, new RaceAttendee(race3, k015, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(k016, new RaceAttendee(race3, k016, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(k078, new RaceAttendee(race3, k078, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(k099, new RaceAttendee(race3, k099, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(k877, new RaceAttendee(race3, k877, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "99,16,877,27,23,14,22,73,43,19,179,85,25,15,197,154,159"); //$NON-NLS-1$
			addLaps(race3, "99,16,877,27,23,14,22,73,43,19,179,85,25,15,197,154,159"); //$NON-NLS-1$
			addLaps(race3, "99,16,877,27,23,14,22,73,43,19,179,85,25,15,197,154,159"); //$NON-NLS-1$
			addLaps(race3, "99,16,877,27,23,14,22,73,43,19,179,85,25,15"); //$NON-NLS-1$
			addLaps(race3, "99,16,877,27,23"); //$NON-NLS-1$
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
			race4.getAttendees().put(sco060, new RaceAttendee(race4, sco060, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco081, new RaceAttendee(race4, sco081, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco154, new RaceAttendee(race4, sco154, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco179, new RaceAttendee(race4, sco179, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco197, new RaceAttendee(race4, sco197, RaceAttendee.Type.V_MARSHAL));
			race4.getAttendees().put(ir014, new RaceAttendee(race4, ir014, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir022, new RaceAttendee(race4, ir022, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir025, new RaceAttendee(race4, ir025, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir027, new RaceAttendee(race4, ir027, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir028, new RaceAttendee(race4, ir028, RaceAttendee.Type.V_MARSHAL));
			race4.getAttendees().put(ir043, new RaceAttendee(race4, ir043, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir073, new RaceAttendee(race4, ir073, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir077, new RaceAttendee(race4, ir077, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir085, new RaceAttendee(race4, ir085, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(k015, new RaceAttendee(race4, k015, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(k016, new RaceAttendee(race4, k016, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(k078, new RaceAttendee(race4, k078, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(k099, new RaceAttendee(race4, k099, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(k877, new RaceAttendee(race4, k877, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "99,16,27,43,22,23,877,154,73,25,15,14,19,81,85,159,60,179"); //$NON-NLS-1$
			addLaps(race4, "99,16,27,43,22,23,877,154,73,25,15,14,19,81,85,159,60"); //$NON-NLS-1$
			addLaps(race4, "99,16,27,43,22,23,877,154,73,25,15,14,19,81,85,159,60"); //$NON-NLS-1$
			addLaps(race4, "99,16,27,43,22,23,877,154,73,25,15,14,19,81,85,159"); //$NON-NLS-1$
			addLaps(race4, "99,16,27,43,22,23,877,154,73,25,15,14,19"); //$NON-NLS-1$
			addLaps(race4, "99,16,27,43,22,23"); //$NON-NLS-1$
			addLaps(race4, "99,16,27"); //$NON-NLS-1$
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
			RaceAttendee att019 = new RaceAttendee(race5, sco019, RaceAttendee.Type.PILOT);
			att019.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race5.getAttendees().put(sco019, att019);
			race5.getAttendees().put(sco023, new RaceAttendee(race5, sco023, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco060, new RaceAttendee(race5, sco060, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco081, new RaceAttendee(race5, sco081, RaceAttendee.Type.PILOT));
			RaceAttendee att154 = new RaceAttendee(race5, sco154, RaceAttendee.Type.PILOT);
			att154.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race5.getAttendees().put(sco154, att154);
			RaceAttendee att159 = new RaceAttendee(race5, sco159, RaceAttendee.Type.PILOT);
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race5.getAttendees().put(sco159, att159);
			RaceAttendee att179 = new RaceAttendee(race5, sco179, RaceAttendee.Type.PILOT);
			att179.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race5.getAttendees().put(sco179, att179);
			race5.getAttendees().put(sco197, new RaceAttendee(race5, sco197, RaceAttendee.Type.V_MARSHAL));
			race5.getAttendees().put(ir014, new RaceAttendee(race5, ir014, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir022, new RaceAttendee(race5, ir022, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir025, new RaceAttendee(race5, ir025, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir027, new RaceAttendee(race5, ir027, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir028, new RaceAttendee(race5, ir028, RaceAttendee.Type.V_MARSHAL));
			race5.getAttendees().put(ir043, new RaceAttendee(race5, ir043, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir073, new RaceAttendee(race5, ir073, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir077, new RaceAttendee(race5, ir077, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(ir085, new RaceAttendee(race5, ir085, RaceAttendee.Type.PILOT));
			RaceAttendee att015 = new RaceAttendee(race5, k015, RaceAttendee.Type.PILOT);
			att015.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race5.getAttendees().put(k015, att015);
			RaceAttendee att016 = new RaceAttendee(race5, k016, RaceAttendee.Type.PILOT);
			att016.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race5.getAttendees().put(k016, att016);
			race5.getAttendees().put(k078, new RaceAttendee(race5, k078, RaceAttendee.Type.PILOT));
			RaceAttendee att099 = new RaceAttendee(race5, k099, RaceAttendee.Type.PILOT);
			att099.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race5.getAttendees().put(k099, att099);
			RaceAttendee att877 = new RaceAttendee(race5, k877, RaceAttendee.Type.PILOT);
			att877.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC));
			race5.getAttendees().put(k877, att877);
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "16,99,27,23,154,43,877,22,15,25,73,159,179,60,77,85,14,81,19"); //$NON-NLS-1$
			addLaps(race5, "16,99,27,23,154,43,877,22,15,25,73,159,179,60,77,85"); //$NON-NLS-1$
			addLaps(race5, "16,99,27,23,154,43,877,22,15,25,73,159,179,60"); //$NON-NLS-1$
			addLaps(race5, "16,99,27,23,154,43,877,22,15,25,73,159,179,60"); //$NON-NLS-1$
			addLaps(race5, "16,99,27,23,154,43,877,22,15,25,73,159,179,60"); //$NON-NLS-1$
			addLaps(race5, "16,99,27,23,154,43,877,22,15,25,73,159,179"); //$NON-NLS-1$
			addLaps(race5, "16,99,27,23,154,43,877"); //$NON-NLS-1$
			raceDAO.persist(race5);

			DatabaseSession.commit();

			_race5 = race5;
		} finally {
			db.endSession();
		}
	}
}
