/*
	cursus - Race series management program
	Copyright 2016  Simon Arlott

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
package org.spka.cursus.test.cc_2016;

import org.fisly.cursus.scoring.FISLYConstants;
import org.spka.cursus.scoring.CCConstants;
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

public class CCSeries2016 extends AbstractSPKASeries {
	public CCSeries2016(boolean top3) {
		super("Celtic Challenge 2016", top3 ? CCConstants.UUID_2013 : FISLYConstants.UUID_2010, "Scotland", "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	protected static final int SERIES_FLEET = 9;
	protected static final int SERIES_FLEET_AT_EVENT1 = 9;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = "Benone Strand (18/06/2016 and 19/06/2016)"; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 9;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = "Benone Strand (18/06/2016)"; //$NON-NLS-1$
	protected static final int RACE1_PILOTS = 9;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = "Benone Strand (18/06/2016)"; //$NON-NLS-1$
	protected static final int RACE2_PILOTS = 9;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = "Benone Strand (18/06/2016)"; //$NON-NLS-1$
	protected static final int RACE3_PILOTS = 9;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = "Benone Strand (18/06/2016)"; //$NON-NLS-1$
	protected static final int RACE4_PILOTS = 9;

	protected Pilot sco116;
	protected Pilot sco159;
	protected Pilot sco808;
	protected Pilot ir016;
	protected Pilot ir021;
	protected Pilot ir023;
	protected Pilot ir053;
	protected Pilot ir077;
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

			// Create the 2016 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco116 = new Pilot(series, "SCO116@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco116);

			sco159 = new Pilot(series, "SCO159@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco808 = new Pilot(series, "SCO808@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco808);

			ir016 = new Pilot(series, "IR016@2010", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir016);

			ir021 = new Pilot(series, "IR021@2016", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir021);

			ir023 = new Pilot(series, "IR023@2016", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir023);

			ir053 = new Pilot(series, "IR053@2010", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir053);

			ir077 = new Pilot(series, "IR077@2009", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir077);

			ir085 = new Pilot(series, "IR085@2008", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
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
			race1.getAttendees().put(sco116, new RaceAttendee(race1, sco116, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco159, new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco808, new RaceAttendee(race1, sco808, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir016, new RaceAttendee(race1, ir016, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir021, new RaceAttendee(race1, ir021, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir023, new RaceAttendee(race1, ir023, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir053, new RaceAttendee(race1, ir053, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir077, new RaceAttendee(race1, ir077, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir085, new RaceAttendee(race1, ir085, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "116,808,21,53,77,85,159,23"); //$NON-NLS-1$
			addLaps(race1, "116,21,808,53,85,159,77,23"); //$NON-NLS-1$
			addLaps(race1, "116,21,808,53,85,159,77,23"); //$NON-NLS-1$
			addLaps(race1, "116,21,808,53,85,159,77,23"); //$NON-NLS-1$
			addLaps(race1, "116,21,808,53,85,159,77"); //$NON-NLS-1$
			addLaps(race1, "116,21,808,53,85,159"); //$NON-NLS-1$
			addLaps(race1, "116,21,808,53"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco116, new RaceAttendee(race2, sco116, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco159, new RaceAttendee(race2, sco159, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco808, new RaceAttendee(race2, sco808, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir016, new RaceAttendee(race2, ir016, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir021, new RaceAttendee(race2, ir021, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir023, new RaceAttendee(race2, ir023, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir053, new RaceAttendee(race2, ir053, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir077, new RaceAttendee(race2, ir077, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir085, new RaceAttendee(race2, ir085, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "21,116,53,77,159,808,23"); //$NON-NLS-1$
			addLaps(race2, "21,116,53,77,159"); //$NON-NLS-1$
			addLaps(race2, "21,116,53,77,159"); //$NON-NLS-1$
			addLaps(race2, "21,116,53"); //$NON-NLS-1$
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
			race3.getAttendees().put(sco116, new RaceAttendee(race3, sco116, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			RaceAttendee att808 = new RaceAttendee(race3, sco808, RaceAttendee.Type.PILOT);
			att808.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit scoring line mark")); //$NON-NLS-1$
			race3.getAttendees().put(sco808, att808);
			race3.getAttendees().put(ir016, new RaceAttendee(race3, ir016, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir021, new RaceAttendee(race3, ir021, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir023, new RaceAttendee(race3, ir023, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir053, new RaceAttendee(race3, ir053, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir077, new RaceAttendee(race3, ir077, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir085, new RaceAttendee(race3, ir085, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "21,808,116,53,159,77,85,16"); //$NON-NLS-1$
			addLaps(race3, "21,116,808,53,159,77,85"); //$NON-NLS-1$
			addLaps(race3, "21,116,53,808,159,77"); //$NON-NLS-1$
			addLaps(race3, "21,116,53,808,159,77"); //$NON-NLS-1$
			addLaps(race3, "808,116,159,53,21,77"); //$NON-NLS-1$
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
			race4.getAttendees().put(sco116, new RaceAttendee(race4, sco116, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco808, new RaceAttendee(race4, sco808, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir016, new RaceAttendee(race4, ir016, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir021, new RaceAttendee(race4, ir021, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir023, new RaceAttendee(race4, ir023, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir053, new RaceAttendee(race4, ir053, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir077, new RaceAttendee(race4, ir077, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir085, new RaceAttendee(race4, ir085, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "116,53,159,77,808,21,23"); //$NON-NLS-1$
			addLaps(race4, "116,53,159,808,21,77"); //$NON-NLS-1$
			addLaps(race4, "116,53,159,808,77,21"); //$NON-NLS-1$
			addLaps(race4, "53,116,808,159"); //$NON-NLS-1$
			raceDAO.persist(race4);

			DatabaseSession.commit();

			_race4 = race4;
		} finally {
			db.endSession();
		}
	}
}
