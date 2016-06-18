/*
	cursus - Race series management program
	Copyright 2015  Simon Arlott

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
package org.spka.cursus.test.cc_2015;

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

public class CCSeries2015 extends AbstractSPKASeries {
	public CCSeries2015(boolean top3) {
		super("Celtic Challenge 2015", top3 ? CCConstants.UUID_2013 : FISLYConstants.UUID_2010, "Scotland", "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	protected static final int SERIES_FLEET = 9;
	protected static final int SERIES_FLEET_AT_EVENT1 = 9;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = "Luce Bay (20/06/2015 and 21/06/2015)"; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 8;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = "Luce Bay (20/06/2015)"; //$NON-NLS-1$
	protected static final int RACE1_PILOTS = 8;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = "Luce Bay (20/06/2015)"; //$NON-NLS-1$
	protected static final int RACE2_PILOTS = 8;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = "Luce Bay (21/06/2015)"; //$NON-NLS-1$
	protected static final int RACE3_PILOTS = 9;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = "Luce Bay (21/06/2015)"; //$NON-NLS-1$
	protected static final int RACE4_PILOTS = 9;

	protected Pilot sco066;
	protected Pilot sco087;
	protected Pilot sco116;
	protected Pilot sco156;
	protected Pilot sco159;
	protected Pilot sco808;
	protected Pilot ir016;
	protected Pilot ir027;
	protected Pilot ir181;

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

			// Create the 2014 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco066 = new Pilot(series, "SCO066@2013", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco066);

			sco087 = new Pilot(series, "SCO087@2009", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco087);

			sco116 = new Pilot(series, "SCO116@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco116);

			sco156 = new Pilot(series, "SCO156@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco156);

			sco159 = new Pilot(series, "SCO159@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco808 = new Pilot(series, "SCO808@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco808);

			ir016 = new Pilot(series, "IR016@2010", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir016);

			ir027 = new Pilot(series, "IR027@2005", Sex.MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(ir027);

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
			race1.getAttendees().put(sco087, new RaceAttendee(race1, sco087, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco116, new RaceAttendee(race1, sco116, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco156, new RaceAttendee(race1, sco156, RaceAttendee.Type.PILOT));
			RaceAttendee att159 = new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT);
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 1, "Hit mark 4")); //$NON-NLS-1$
			race1.getAttendees().put(sco159, att159);
			race1.getAttendees().put(sco808, new RaceAttendee(race1, sco808, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir016, new RaceAttendee(race1, ir016, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir027, new RaceAttendee(race1, ir027, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(ir181, new RaceAttendee(race1, ir181, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "181,808,87,159,116"); //$NON-NLS-1$
			addLaps(race1, "808,181,27,159"); //$NON-NLS-1$
			addLaps(race1, "181,808,156,116,159,27"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco087, new RaceAttendee(race2, sco087, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco116, new RaceAttendee(race2, sco116, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco156, new RaceAttendee(race2, sco156, RaceAttendee.Type.PILOT));
			RaceAttendee att159 = new RaceAttendee(race2, sco159, RaceAttendee.Type.PILOT);
			att159.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 1, "Hit mark 4")); //$NON-NLS-1$
			race2.getAttendees().put(sco159, att159);
			race2.getAttendees().put(sco808, new RaceAttendee(race2, sco808, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir016, new RaceAttendee(race2, ir016, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(ir027, new RaceAttendee(race2, ir027, RaceAttendee.Type.PILOT));
			RaceAttendee att181 = new RaceAttendee(race2, ir181, RaceAttendee.Type.PILOT);
			att181.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 1, "Pushing into the wind")); //$NON-NLS-1$
			race2.getAttendees().put(ir181, att181);
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "181,808,116,27"); //$NON-NLS-1$
			addLaps(race2, "181,808,159,27"); //$NON-NLS-1$
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
			race3.getAttendees().put(sco066, new RaceAttendee(race3, sco066, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco087, new RaceAttendee(race3, sco087, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco116, new RaceAttendee(race3, sco116, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco156, new RaceAttendee(race3, sco156, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco808, new RaceAttendee(race3, sco808, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir016, new RaceAttendee(race3, ir016, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir027, new RaceAttendee(race3, ir027, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(ir181, new RaceAttendee(race3, ir181, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "181,808,27,116,156"); //$NON-NLS-1$
			addLaps(race3, "181,27,808,66,116,16,87"); //$NON-NLS-1$
			addLaps(race3, "181,27,808,156,116,159"); //$NON-NLS-1$
			addLaps(race3, "181,87,808,27,66,116,156"); //$NON-NLS-1$
			addLaps(race3, "181,159,808,27,87,116"); //$NON-NLS-1$
			addLaps(race3, "181,156,159,66,27,808,87,116"); //$NON-NLS-1$
			addLaps(race3, "181,156,27,808,116,159,66,87"); //$NON-NLS-1$
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
			race4.getAttendees().put(sco066, new RaceAttendee(race4, sco066, RaceAttendee.Type.PILOT));
			RaceAttendee att087 = new RaceAttendee(race4, sco087, RaceAttendee.Type.PILOT);
			att087.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, 1, "Hit mark 5")); //$NON-NLS-1$
			race4.getAttendees().put(sco087, att087);
			race4.getAttendees().put(sco116, new RaceAttendee(race4, sco116, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco156, new RaceAttendee(race4, sco156, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco808, new RaceAttendee(race4, sco808, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir016, new RaceAttendee(race4, ir016, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir027, new RaceAttendee(race4, ir027, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(ir181, new RaceAttendee(race4, ir181, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "27,181,808,116,159"); //$NON-NLS-1$
			addLaps(race4, "181,156,87,27,116,16"); //$NON-NLS-1$
			addLaps(race4, "181,808,27,116,87,156"); //$NON-NLS-1$
			addLaps(race4, "181,808,27,116,16,87"); //$NON-NLS-1$
			addLaps(race4, "181,159,156,808,27,116"); //$NON-NLS-1$
			addLaps(race4, "181,87,27,156,159,808,16"); //$NON-NLS-1$
			raceDAO.persist(race4);

			DatabaseSession.commit();

			_race4 = race4;
		} finally {
			db.endSession();
		}
	}
}
