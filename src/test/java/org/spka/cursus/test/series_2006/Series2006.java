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
package org.spka.cursus.test.series_2006;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Penalty;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.RaceAttendee;
import uk.uuid.cursus.db.data.RaceTally;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.db.data.Sex;

public class Series2006 extends AbstractSPKASeries {
	public Series2006() {
		super("SPKA Race Series 2006/07", SPKAConstants.UUID_2005); //$NON-NLS-1$
	}

	protected static final int SERIES_FLEET_AT_EVENT1 = 21;
	protected static final int SERIES_FLEET_AT_EVENT2 = 23;
	protected static final int SERIES_FLEET_AT_EVENT3 = 24;
	protected static final int SERIES_FLEET_AT_EVENT4 = 25;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 21;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = ""; //$NON-NLS-1$
	protected static final int RACE1_FLEET = 20;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = ""; //$NON-NLS-1$
	protected static final int RACE2_FLEET = 21;

	protected static final String EVENT2_NAME = "Race Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 20;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = ""; //$NON-NLS-1$
	protected static final int RACE3_FLEET = 20;

	protected static final String EVENT3_NAME = "Race Event 3"; //$NON-NLS-1$
	protected static final String EVENT3_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT3_FLEET = 17;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = ""; //$NON-NLS-1$
	protected static final int RACE4_FLEET = 17;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = ""; //$NON-NLS-1$
	protected static final int RACE5_FLEET = 17;
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = ""; //$NON-NLS-1$
	protected static final int RACE6_FLEET = 17;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = ""; //$NON-NLS-1$
	protected static final int RACE7_FLEET = 17;
	protected static final String RACE8_NAME = "Race 8"; //$NON-NLS-1$
	protected static final String RACE8_DESC = ""; //$NON-NLS-1$
	protected static final int RACE8_FLEET = 17;

	protected static final String EVENT4_NAME = "Race Event 4"; //$NON-NLS-1$
	protected static final String EVENT4_DESC = ""; //$NON-NLS-1$
	protected static final int EVENT4_FLEET = 21;
	protected static final String RACE9_NAME = "Race 9"; //$NON-NLS-1$
	protected static final String RACE9_DESC = ""; //$NON-NLS-1$
	protected static final int RACE9_FLEET = 21;
	protected static final String RACE10_NAME = "Race 10"; //$NON-NLS-1$
	protected static final String RACE10_DESC = ""; //$NON-NLS-1$
	protected static final int RACE10_FLEET = 21;
	protected static final String RACE11_NAME = "Race 11"; //$NON-NLS-1$
	protected static final String RACE11_DESC = ""; //$NON-NLS-1$
	protected static final int RACE11_FLEET = 21;

	protected Pilot sco019;
	protected Pilot sco023;
	protected Pilot sco033;
	protected Pilot sco050;
	protected Pilot sco060;
	protected Pilot sco071;
	protected Pilot sco081;
	protected Pilot sco095;
	protected Pilot sco100;
	protected Pilot sco109;
	protected Pilot sco117;
	protected Pilot sco135;
	protected Pilot sco136;
	protected Pilot sco143;
	protected Pilot sco154;
	protected Pilot sco158;
	protected Pilot sco159;
	protected Pilot sco173;
	protected Pilot sco179;
	protected Pilot sco181;
	protected Pilot sco183;
	protected Pilot sco197;
	protected Pilot sco198;
	protected Pilot sco200;
	protected Pilot sco205;
	protected Pilot sco206;
	protected Pilot k795;
	protected Pilot k796;

	private Series _series;
	private Event _event1;
	private Race _race1;
	private Race _race2;
	private Event _event2;
	private Race _race3;
	private Event _event3;
	private Race _race4;
	private Race _race5;
	private Race _race6;
	private Race _race7;
	private Race _race8;
	private Event _event4;
	private Race _race9;
	private Race _race10;
	private Race _race11;

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

			// Create the 2006/07 series
			Series series = new Series(SERIES_NAME);

			// Add all the pilots
			sco019 = new Pilot(series, "SCO019@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco019);

			sco023 = new Pilot(series, "SCO023@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco023);

			sco033 = new Pilot(series, "SCO033@2006", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco033);

			sco050 = new Pilot(series, "SCO050@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco050);

			sco060 = new Pilot(series, "SCO060@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco071 = new Pilot(series, "SCO071@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco071);

			sco081 = new Pilot(series, "SCO081@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco095 = new Pilot(series, "SCO095@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco095);

			sco100 = new Pilot(series, "SCO100@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco100);

			sco109 = new Pilot(series, "SCO109@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco109);

			sco117 = new Pilot(series, "SCO117@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco117);

			sco135 = new Pilot(series, "SCO135@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco135);

			sco136 = new Pilot(series, "SCO136@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco136);

			sco143 = new Pilot(series, "SCO143@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco143);

			sco154 = new Pilot(series, "SCO154@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco154);

			sco158 = new Pilot(series, "SCO158@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco158);

			sco159 = new Pilot(series, "SCO159@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco173 = new Pilot(series, "SCO173@2006", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco173);

			sco179 = new Pilot(series, "SCO179@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco181 = new Pilot(series, "SCO181@2006", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco181);

			sco183 = new Pilot(series, "SCO183@2006", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco183);

			sco197 = new Pilot(series, "SCO197@2006", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco197);

			sco198 = new Pilot(series, "SCO198@2006", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco198);

			sco200 = new Pilot(series, "SCO200@2006", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco200);

			sco205 = new Pilot(series, "SCO205@2006", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco205);

			sco206 = new Pilot(series, "SCO206@2006", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco206);

			k795 = new Pilot(series, "K795@2006", Sex.MALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k795);

			k796 = new Pilot(series, "K796@2006", Sex.MALE, "England"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(k796);

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
			race1.getAttendees().put(sco019, new RaceAttendee(race1, sco019, RaceAttendee.Type.M_MARSHAL));
			race1.getAttendees().put(sco023, new RaceAttendee(race1, sco023, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco033, new RaceAttendee(race1, sco033, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco050, new RaceAttendee(race1, sco050, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco071, new RaceAttendee(race1, sco071, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco081, new RaceAttendee(race1, sco081, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco095, new RaceAttendee(race1, sco095, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco109, new RaceAttendee(race1, sco109, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco117, new RaceAttendee(race1, sco117, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco135, new RaceAttendee(race1, sco135, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco136, new RaceAttendee(race1, sco136, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco154, new RaceAttendee(race1, sco154, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco158, new RaceAttendee(race1, sco158, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco159, new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco181, new RaceAttendee(race1, sco181, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco200, new RaceAttendee(race1, sco200, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco205, new RaceAttendee(race1, sco205, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco206, new RaceAttendee(race1, sco206, RaceAttendee.Type.PILOT));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race1, "23,159,71,60,117,50,95,179,135,136,200,181,109,33,158,206,154,205,81"); //$NON-NLS-1$
			addLaps(race1, "23,159,71,60,117,50,95,179,135,136,200,181,109,33,158,206,154"); //$NON-NLS-1$
			addLaps(race1, "23,159,71,60,117,50,95,179,135,136,200,181,109,33,158,206,154"); //$NON-NLS-1$
			addLaps(race1, "23,159,71,60,117,50,95,179,135,136,200,181,109,33,158,206"); //$NON-NLS-1$
			addLaps(race1, "23,159,71,60,117,50,95,179,135,136,200,181,109,33"); //$NON-NLS-1$
			addLaps(race1, "23,159,71,60,117,50,95,179,135,136,200,181,109,33"); //$NON-NLS-1$
			addLaps(race1, "23,159,71,60,117,50,95,179,135,136"); //$NON-NLS-1$
			addLaps(race1, "23,159,71,60,117,50,95,179,135"); //$NON-NLS-1$
			addLaps(race1, "23,159"); //$NON-NLS-1$
			addLaps(race1, "23"); //$NON-NLS-1$
			addLaps(race1, "23"); //$NON-NLS-1$
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
			race2.getAttendees().put(sco033, new RaceAttendee(race2, sco033, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco050, new RaceAttendee(race2, sco050, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco060, new RaceAttendee(race2, sco060, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco071, new RaceAttendee(race2, sco071, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco081, new RaceAttendee(race2, sco081, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco095, new RaceAttendee(race2, sco095, RaceAttendee.Type.M_MARSHAL));
			race2.getAttendees().put(sco100, new RaceAttendee(race2, sco100, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco109, new RaceAttendee(race2, sco109, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco117, new RaceAttendee(race2, sco117, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco135, new RaceAttendee(race2, sco135, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco136, new RaceAttendee(race2, sco136, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco154, new RaceAttendee(race2, sco154, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco158, new RaceAttendee(race2, sco158, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco159, new RaceAttendee(race2, sco159, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco181, new RaceAttendee(race2, sco181, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco200, new RaceAttendee(race2, sco200, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco205, new RaceAttendee(race2, sco205, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco206, new RaceAttendee(race2, sco206, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race2, "23,135,159,200,117,179,71,50,81,154,100,181,60,136,158,109,33"); //$NON-NLS-1$
			addLaps(race2, "23,135,159,200,117,179,71,50,81,154,100,181,60,136,158,109,33"); //$NON-NLS-1$
			addLaps(race2, "23,135,159,200,117,179,71,50,81,154,100,181,60,136,158,109"); //$NON-NLS-1$
			addLaps(race2, "23,135,159,200,117,179,71,50,81,154,100,181,60,136,158,109"); //$NON-NLS-1$
			addLaps(race2, "23,135,159,200,117,179,71,50,81,154,100,181,60,136,158,109"); //$NON-NLS-1$
			addLaps(race2, "23,135,159,200,117,179,71,50,81,154,100,181,60,136,158,109"); //$NON-NLS-1$
			addLaps(race2, "23,135,159,200,117,179,71,50,81,154,100,181,60"); //$NON-NLS-1$
			addLaps(race2, "23,135,159,200,117,179,71,50"); //$NON-NLS-1$
			addLaps(race2, "23,135,159,200,117,179"); //$NON-NLS-1$
			addLaps(race2, "23"); //$NON-NLS-1$
			addLaps(race2, "23"); //$NON-NLS-1$
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
			race3.getAttendees().put(sco060, new RaceAttendee(race3, sco060, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco071, new RaceAttendee(race3, sco071, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco081, new RaceAttendee(race3, sco081, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco095, new RaceAttendee(race3, sco095, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco100, new RaceAttendee(race3, sco100, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco109, new RaceAttendee(race3, sco109, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco117, new RaceAttendee(race3, sco117, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco135, new RaceAttendee(race3, sco135, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco136, new RaceAttendee(race3, sco136, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco154, new RaceAttendee(race3, sco154, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco158, new RaceAttendee(race3, sco158, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco197, new RaceAttendee(race3, sco197, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco183, new RaceAttendee(race3, sco183, RaceAttendee.Type.M_MARSHAL));
			race3.getAttendees().put(sco200, new RaceAttendee(race3, sco200, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco205, new RaceAttendee(race3, sco205, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco206, new RaceAttendee(race3, sco206, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race3, "81,23,200,71,158,159,100,136,135,206,154,95,19,197"); //$NON-NLS-1$
			addLaps(race3, "81,23,200,71,158,159,100,136,135,206,154,95"); //$NON-NLS-1$
			addLaps(race3, "81,23,200,71,158,159,100,136,135,206,154"); //$NON-NLS-1$
			addLaps(race3, "81,23,200,71,158,159,100,136,135,206,154"); //$NON-NLS-1$
			addLaps(race3, "81,23,200,71,158,159,100,136"); //$NON-NLS-1$
			addLaps(race3, "81,23,200,71"); //$NON-NLS-1$
			addLaps(race3, "81,23,200,71"); //$NON-NLS-1$
			addLaps(race3, "81,23"); //$NON-NLS-1$
			addLaps(race3, "81"); //$NON-NLS-1$
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
		createRace5Data();
		createRace6Data();
		createRace7Data();
		createRace8Data();
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
			race4.getAttendees().put(sco023, new RaceAttendee(race4, sco023, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco060, new RaceAttendee(race4, sco060, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco071, new RaceAttendee(race4, sco071, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco081, new RaceAttendee(race4, sco081, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco095, new RaceAttendee(race4, sco095, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco100, new RaceAttendee(race4, sco100, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco109, new RaceAttendee(race4, sco109, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco117, new RaceAttendee(race4, sco117, RaceAttendee.Type.PILOT));
			RaceAttendee att135 = new RaceAttendee(race4, sco135, RaceAttendee.Type.PILOT);
			att135.getPenalties().add(new Penalty(Penalty.Type.CANCEL_LAPS, "Running over a marker flag")); //$NON-NLS-1$
			race4.getAttendees().put(sco135, att135);
			race4.getAttendees().put(sco136, new RaceAttendee(race4, sco136, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco154, new RaceAttendee(race4, sco154, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco158, new RaceAttendee(race4, sco158, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco197, new RaceAttendee(race4, sco197, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco198, new RaceAttendee(race4, sco198, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco200, new RaceAttendee(race4, sco200, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race4, "81,23,19,200,71,136,159,95,117,135,60,158,100,198,154"); //$NON-NLS-1$
			addLaps(race4, "81,23,19,200,71,136,159,95,117,135,60,158,100,198,154"); //$NON-NLS-1$
			addLaps(race4, "81,23,19,200,71,136,159,95,117,135,60,158,100,198,154"); //$NON-NLS-1$
			addLaps(race4, "81,23,19,200,71,136,159,95,117,135,60,158,100"); //$NON-NLS-1$
			addLaps(race4, "81,23,19,200,71,136,159,95,117,135"); //$NON-NLS-1$
			addLaps(race4, "81,23,19,200,71,136"); //$NON-NLS-1$
			addLaps(race4, "81"); //$NON-NLS-1$
			raceDAO.persist(race4);

			DatabaseSession.commit();

			_race4 = race4;
		} finally {
			db.endSession();
		}
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
			race5.getAttendees().put(sco071, new RaceAttendee(race5, sco071, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco081, new RaceAttendee(race5, sco081, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco095, new RaceAttendee(race5, sco095, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco100, new RaceAttendee(race5, sco100, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco109, new RaceAttendee(race5, sco109, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco117, new RaceAttendee(race5, sco117, RaceAttendee.Type.PILOT));
			RaceAttendee att135 = new RaceAttendee(race5, sco135, RaceAttendee.Type.PILOT);
			att135.getPenalties().add(new Penalty(Penalty.Type.CANCEL_LAPS, "Running over a marker flag")); //$NON-NLS-1$
			race5.getAttendees().put(sco135, att135);
			race5.getAttendees().put(sco136, new RaceAttendee(race5, sco136, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco154, new RaceAttendee(race5, sco154, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco158, new RaceAttendee(race5, sco158, RaceAttendee.Type.M_MARSHAL));
			race5.getAttendees().put(sco159, new RaceAttendee(race5, sco159, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco197, new RaceAttendee(race5, sco197, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco198, new RaceAttendee(race5, sco198, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco200, new RaceAttendee(race5, sco200, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race5, "23,81,71,200,136,19,135,154,95,159,60,100,117,198,197"); //$NON-NLS-1$
			addLaps(race5, "23,81,71,200,136,19,135,154,95,159,60,100,117,198"); //$NON-NLS-1$
			addLaps(race5, "23,81,71,200,136,19,135,154,95,159,60,100,117,198"); //$NON-NLS-1$
			addLaps(race5, "23,81,71,200,136,19,135,154,95,159,60,100,117"); //$NON-NLS-1$
			addLaps(race5, "23,81,71,200,136,19,135,154,95,159,60,100,117"); //$NON-NLS-1$
			addLaps(race5, "23,81,71,200,136,19,135,154,95,159,60,100,117"); //$NON-NLS-1$
			addLaps(race5, "23,81,71,200,136,19,135,154,95,159,60"); //$NON-NLS-1$
			addLaps(race5, "23,81,71,200,136,19,135"); //$NON-NLS-1$
			addLaps(race5, "23,81,71,135"); //$NON-NLS-1$
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
			race6.getAttendees().put(sco197, new RaceAttendee(race6, sco197, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco198, new RaceAttendee(race6, sco198, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco200, new RaceAttendee(race6, sco200, RaceAttendee.Type.PILOT));
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race6, "23,81,200,154,95,71,135,19,136,159,100,117,60,158,198,109,197"); //$NON-NLS-1$
			addLaps(race6, "23,81,200,154,95,71,135,19,136,159,100,117,60,158,198,109,197"); //$NON-NLS-1$
			addLaps(race6, "23,81,200,154,95,71,135,19,136,159,100,117,60,158,198,109"); //$NON-NLS-1$
			addLaps(race6, "23,81,200,154,95,71,135,19,136,159,100,117,60,158"); //$NON-NLS-1$
			addLaps(race6, "23,81,200,154,95,71,135,19,136,159,100,117,60"); //$NON-NLS-1$
			addLaps(race6, "23,81,200,154,95,71,135,19,136,159,100"); //$NON-NLS-1$
			addLaps(race6, "23,81,200,154,95,71,135,19,136,159"); //$NON-NLS-1$
			addLaps(race6, "23,81,200,154,95"); //$NON-NLS-1$
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
			race7.getAttendees().put(sco023, new RaceAttendee(race7, sco023, RaceAttendee.Type.M_MARSHAL));
			race7.getAttendees().put(sco060, new RaceAttendee(race7, sco060, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco071, new RaceAttendee(race7, sco071, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco081, new RaceAttendee(race7, sco081, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco095, new RaceAttendee(race7, sco095, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco100, new RaceAttendee(race7, sco100, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco109, new RaceAttendee(race7, sco109, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco117, new RaceAttendee(race7, sco117, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco135, new RaceAttendee(race7, sco135, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco136, new RaceAttendee(race7, sco136, RaceAttendee.Type.PILOT));
			RaceAttendee att154 = new RaceAttendee(race7, sco154, RaceAttendee.Type.PILOT);
			att154.getPenalties().add(new Penalty(Penalty.Type.CANCEL_LAPS, "Running over a marker flag")); //$NON-NLS-1$
			race7.getAttendees().put(sco154, att154);
			race7.getAttendees().put(sco158, new RaceAttendee(race7, sco158, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco159, new RaceAttendee(race7, sco159, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco197, new RaceAttendee(race7, sco197, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco198, new RaceAttendee(race7, sco198, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco200, new RaceAttendee(race7, sco200, RaceAttendee.Type.PILOT));
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race7, "81,200,154,135,136,100,71,159,117,95,60,19,109,158,197"); //$NON-NLS-1$
			addLaps(race7, "81,200,154,135,136,100,71,159,117,95,60,19,109,158"); //$NON-NLS-1$
			addLaps(race7, "81,200,154,135,136,100,71,159,117,95,60,19,109,158"); //$NON-NLS-1$
			addLaps(race7, "81,200,154,135,136,100,71,159,117,95,60,19,109"); //$NON-NLS-1$
			addLaps(race7, "81,200,154,135,136,100,71,159,117,95,60,19,109"); //$NON-NLS-1$
			addLaps(race7, "81,200,154,135,136,100,71,159,117,95,60,19"); //$NON-NLS-1$
			addLaps(race7, "81,200,154,135,136,100,71,159,117,95,60"); //$NON-NLS-1$
			addLaps(race7, "81,200,154,135,136,100,71"); //$NON-NLS-1$
			addLaps(race7, "81,200,154"); //$NON-NLS-1$
			raceDAO.persist(race7);

			DatabaseSession.commit();

			_race7 = race7;
		} finally {
			db.endSession();
		}
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
			race8.getAttendees().put(sco060, new RaceAttendee(race8, sco060, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco071, new RaceAttendee(race8, sco071, RaceAttendee.Type.M_MARSHAL));
			race8.getAttendees().put(sco081, new RaceAttendee(race8, sco081, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco095, new RaceAttendee(race8, sco095, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco100, new RaceAttendee(race8, sco100, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco109, new RaceAttendee(race8, sco109, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco117, new RaceAttendee(race8, sco117, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco135, new RaceAttendee(race8, sco135, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco136, new RaceAttendee(race8, sco136, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco154, new RaceAttendee(race8, sco154, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco158, new RaceAttendee(race8, sco158, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco159, new RaceAttendee(race8, sco159, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco197, new RaceAttendee(race8, sco197, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco198, new RaceAttendee(race8, sco198, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco200, new RaceAttendee(race8, sco200, RaceAttendee.Type.PILOT));
			race8.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race8, "23,154,81,200,100,135,136,159,19,117,95,60,158,109,197"); //$NON-NLS-1$
			addLaps(race8, "23,154,81,200,100,135,136,159,19,117,95,60,158,109"); //$NON-NLS-1$
			addLaps(race8, "23,154,81,200,100,135,136,159,19,117,95,60,158,109"); //$NON-NLS-1$
			addLaps(race8, "23,154,81,200,100,135,136,159,19,117,95,60,158"); //$NON-NLS-1$
			addLaps(race8, "23,154,81,200,100,135,136,159,19,117,95,60,158"); //$NON-NLS-1$
			addLaps(race8, "23,154,81,200,100,135,136,159,19,117,95,60,158"); //$NON-NLS-1$
			addLaps(race8, "23,154,81,200,100,135,136,159,19,117"); //$NON-NLS-1$
			addLaps(race8, "23,154,81,200,100,135"); //$NON-NLS-1$
			addLaps(race8, "23,154"); //$NON-NLS-1$
			raceDAO.persist(race8);

			DatabaseSession.commit();

			_race8 = race8;
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
		createRace9Data();
		createRace10Data();
		createRace11Data();
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
			race9.getAttendees().put(sco019, new RaceAttendee(race9, sco019, RaceAttendee.Type.M_MARSHAL));
			race9.getAttendees().put(sco023, new RaceAttendee(race9, sco023, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco033, new RaceAttendee(race9, sco033, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco060, new RaceAttendee(race9, sco060, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco071, new RaceAttendee(race9, sco071, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco095, new RaceAttendee(race9, sco095, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco100, new RaceAttendee(race9, sco100, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco117, new RaceAttendee(race9, sco117, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco135, new RaceAttendee(race9, sco135, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco136, new RaceAttendee(race9, sco136, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco143, new RaceAttendee(race9, sco143, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco154, new RaceAttendee(race9, sco154, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco158, new RaceAttendee(race9, sco158, RaceAttendee.Type.M_MARSHAL));
			race9.getAttendees().put(sco159, new RaceAttendee(race9, sco159, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco179, new RaceAttendee(race9, sco179, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco197, new RaceAttendee(race9, sco197, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco198, new RaceAttendee(race9, sco198, RaceAttendee.Type.M_MARSHAL));
			race9.getAttendees().put(sco200, new RaceAttendee(race9, sco200, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(sco205, new RaceAttendee(race9, sco205, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(k795, new RaceAttendee(race9, k795, RaceAttendee.Type.PILOT));
			race9.getAttendees().put(k796, new RaceAttendee(race9, k796, RaceAttendee.Type.PILOT));
			race9.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race9, "796,71,154,179,135,200,795,159,136,23,100,143,117,205,197,33,60"); //$NON-NLS-1$
			addLaps(race9, "796,71,154,179,135,200,795,159,136,23,100,143,117,205,197"); //$NON-NLS-1$
			addLaps(race9, "796,71,154,179,135,200,795,159,136,23,100,143,117"); //$NON-NLS-1$
			addLaps(race9, "796,71,154,179,135,200,795,159,136"); //$NON-NLS-1$
			addLaps(race9, "796,71,154,179,135,200,795,159"); //$NON-NLS-1$
			addLaps(race9, "796,71,154,179,135,200,795"); //$NON-NLS-1$
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
			race10.getAttendees().put(sco023, new RaceAttendee(race10, sco023, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco033, new RaceAttendee(race10, sco033, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco060, new RaceAttendee(race10, sco060, RaceAttendee.Type.M_MARSHAL));
			race10.getAttendees().put(sco071, new RaceAttendee(race10, sco071, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco095, new RaceAttendee(race10, sco095, RaceAttendee.Type.M_MARSHAL));
			race10.getAttendees().put(sco100, new RaceAttendee(race10, sco100, RaceAttendee.Type.M_MARSHAL));
			race10.getAttendees().put(sco117, new RaceAttendee(race10, sco117, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco135, new RaceAttendee(race10, sco135, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco136, new RaceAttendee(race10, sco136, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco143, new RaceAttendee(race10, sco143, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco154, new RaceAttendee(race10, sco154, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco158, new RaceAttendee(race10, sco158, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco159, new RaceAttendee(race10, sco159, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco179, new RaceAttendee(race10, sco179, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco197, new RaceAttendee(race10, sco197, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco198, new RaceAttendee(race10, sco198, RaceAttendee.Type.M_MARSHAL));
			race10.getAttendees().put(sco200, new RaceAttendee(race10, sco200, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(sco205, new RaceAttendee(race10, sco205, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(k795, new RaceAttendee(race10, k795, RaceAttendee.Type.PILOT));
			race10.getAttendees().put(k796, new RaceAttendee(race10, k796, RaceAttendee.Type.PILOT));
			race10.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race10, "23,796,19,159,795,117,135,154,136,205,179,197,71,143,33,158,200"); //$NON-NLS-1$
			addLaps(race10, "23,796,19,159,795,117,135,154,136,205,179,197,71,143,33,158,200"); //$NON-NLS-1$
			addLaps(race10, "23,796,19,159,795,117,135,154,136,205,179,197,71,143,33,158"); //$NON-NLS-1$
			addLaps(race10, "23,796,19,159,795,117,135,154,136,205,179,197,71"); //$NON-NLS-1$
			addLaps(race10, "23,796,19,159,795,117,135,154,136,205"); //$NON-NLS-1$
			addLaps(race10, "23,796,19,159,795,117"); //$NON-NLS-1$
			addLaps(race10, "23,796,19"); //$NON-NLS-1$
			raceDAO.persist(race10);

			DatabaseSession.commit();

			_race10 = race10;
		} finally {
			db.endSession();
		}
	}

	protected void createRace11Data() throws Exception {
		createEvent4Data();

		if (_race11 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race11 = new Race(event4, RACE11_NAME, RACE11_DESC);
			event4.getRaces().add(race11);
			race11.getAttendees().put(sco019, new RaceAttendee(race11, sco019, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco023, new RaceAttendee(race11, sco023, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco033, new RaceAttendee(race11, sco033, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco060, new RaceAttendee(race11, sco060, RaceAttendee.Type.M_MARSHAL));
			race11.getAttendees().put(sco071, new RaceAttendee(race11, sco071, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco095, new RaceAttendee(race11, sco095, RaceAttendee.Type.M_MARSHAL));
			race11.getAttendees().put(sco100, new RaceAttendee(race11, sco100, RaceAttendee.Type.M_MARSHAL));
			race11.getAttendees().put(sco117, new RaceAttendee(race11, sco117, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco135, new RaceAttendee(race11, sco135, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco136, new RaceAttendee(race11, sco136, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco143, new RaceAttendee(race11, sco143, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco154, new RaceAttendee(race11, sco154, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco158, new RaceAttendee(race11, sco158, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco159, new RaceAttendee(race11, sco159, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco179, new RaceAttendee(race11, sco179, RaceAttendee.Type.PILOT));
			RaceAttendee att197 = new RaceAttendee(race11, sco197, RaceAttendee.Type.PILOT);
			att197.getPenalties().add(new Penalty(Penalty.Type.CANCEL_LAPS, "Running over a marker flag")); //$NON-NLS-1$
			race11.getAttendees().put(sco197, att197);
			race11.getAttendees().put(sco198, new RaceAttendee(race11, sco198, RaceAttendee.Type.M_MARSHAL));
			race11.getAttendees().put(sco200, new RaceAttendee(race11, sco200, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(sco205, new RaceAttendee(race11, sco205, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(k795, new RaceAttendee(race11, k795, RaceAttendee.Type.PILOT));
			race11.getAttendees().put(k796, new RaceAttendee(race11, k796, RaceAttendee.Type.PILOT));
			race11.getTallies().add(new RaceTally(RaceTally.Type.START));
			addLaps(race11, "796,23,19,200,154,117,795,136,71,205,158,159,197,179,143,135,33"); //$NON-NLS-1$
			addLaps(race11, "796,23,19,200,154,117,795,136,71,205,158,159,197,179,143,135,33"); //$NON-NLS-1$
			addLaps(race11, "796,23,19,200,154,117,795,136,71,205,158,159,197,179,143,135"); //$NON-NLS-1$
			addLaps(race11, "796,23,19,200,154,117,795,136,71,205,158,159,197,179,143,135"); //$NON-NLS-1$
			addLaps(race11, "796,23,19,200,154,117,795,136,71,205,158,159,197,179,143,135"); //$NON-NLS-1$
			addLaps(race11, "796,23,19,200,154,117,795,136,71,205,158,159,197"); //$NON-NLS-1$
			addLaps(race11, "796,23,19,200,154,117,795,136,71,205,158,159"); //$NON-NLS-1$
			addLaps(race11, "796,23,19,200"); //$NON-NLS-1$
			addLaps(race11, "796,23"); //$NON-NLS-1$
			raceDAO.persist(race11);

			DatabaseSession.commit();

			_race11 = race11;
		} finally {
			db.endSession();
		}
	}
}
