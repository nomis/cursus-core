/*
	cursus - Race series management program
	Copyright 2011-2014  Simon Arlott

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
package org.spka.cursus.test.series_2010;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Class;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Penalty;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.RaceAttendee;
import uk.uuid.cursus.db.data.RaceTally;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.db.data.Sex;

public class Series2010 extends AbstractSPKASeries {
	public Series2010() {
		super("SPKA Race Series 2010/11", SPKAConstants.UUID_2010); //$NON-NLS-1$
	}

	protected static final int SERIES_FLEET_AT_EVENT1 = 17;
	protected static final int SERIES_FLEET_AT_EVENT2 = 17;
	protected static final int SERIES_FLEET_AT_EVENT3 = 18;
	protected static final int SERIES_FLEET_AT_EVENT4 = 19;

	protected static final String EVENT1_NAME = "Race Event 1"; //$NON-NLS-1$
	protected static final String EVENT1_DESC = "Luce Bay (16/10/2010 and 17/10/2010)"; //$NON-NLS-1$
	protected static final int EVENT1_FLEET = 17;
	protected static final String RACE1_NAME = "Race 1"; //$NON-NLS-1$
	protected static final String RACE1_DESC = "Luce Bay (17/10/2010)"; //$NON-NLS-1$
	protected static final int RACE1_PILOTS = 17;
	protected static final String RACE2_NAME = "Race 2"; //$NON-NLS-1$
	protected static final String RACE2_DESC = "Luce Bay (17/10/2010)"; //$NON-NLS-1$
	protected static final int RACE2_PILOTS = 17;
	protected static final String RACE3_NAME = "Race 3"; //$NON-NLS-1$
	protected static final String RACE3_DESC = "Luce Bay (17/10/2010)"; //$NON-NLS-1$
	protected static final int RACE3_PILOTS = 17;

	protected static final String EVENT2_NAME = "Race Event 2"; //$NON-NLS-1$
	protected static final String EVENT2_DESC = "West Sands (27/11/2010)"; //$NON-NLS-1$
	protected static final int EVENT2_FLEET = 13;
	protected static final String RACE4_NAME = "Race 4"; //$NON-NLS-1$
	protected static final String RACE4_DESC = "West Sands (27/11/2010)"; //$NON-NLS-1$
	protected static final int RACE4_PILOTS = 13;

	protected static final String EVENT3_NAME = "Race Event 3"; //$NON-NLS-1$
	protected static final String EVENT3_DESC = "Luce Bay (12/02/2011 and 13/02/2011)"; //$NON-NLS-1$
	protected static final int EVENT3_FLEET = 15;
	protected static final String RACE5_NAME = "Race 5"; //$NON-NLS-1$
	protected static final String RACE5_DESC = "Luce Bay (12/02/2011)"; //$NON-NLS-1$
	protected static final int RACE5_PILOTS = 15;

	protected static final String EVENT4_NAME = "Race Event 4"; //$NON-NLS-1$
	protected static final String EVENT4_DESC = "West Sands (18/06/2011 and 19/06/2011)"; //$NON-NLS-1$
	protected static final int EVENT4_FLEET = 15;
	protected static final String RACE6_NAME = "Race 6"; //$NON-NLS-1$
	protected static final String RACE6_DESC = "West Sands (18/06/2011)"; //$NON-NLS-1$
	protected static final int RACE6_PILOTS = 15;
	protected static final String RACE7_NAME = "Race 7"; //$NON-NLS-1$
	protected static final String RACE7_DESC = "West Sands (18/06/2011)"; //$NON-NLS-1$
	protected static final int RACE7_PILOTS = 15;
	protected static final String RACE8_NAME = "Race 8"; //$NON-NLS-1$
	protected static final String RACE8_DESC = "West Sands (19/06/2011)"; //$NON-NLS-1$
	protected static final int RACE8_PILOTS = 15;

	protected Class junior;
	protected Class _16inWheel;
	protected Pilot sco018;
	protected Pilot sco019;
	protected Pilot sco042;
	protected Pilot sco060;
	protected Pilot sco068;
	protected Pilot sco081;
	protected Pilot sco087;
	protected Pilot sco116;
	protected Pilot sco136;
	protected Pilot sco153;
	protected Pilot sco156;
	protected Pilot sco158;
	protected Pilot sco159;
	protected Pilot sco179;
	protected Pilot sco197;
	protected Pilot sco200;
	protected Pilot sco248;
	protected Pilot sco249;
	protected Pilot sco808;

	private Series _series;
	private Event _event1;
	private Race _race1;
	private Race _race2;
	private Race _race3;
	private Event _event2;
	private Race _race4;
	private Event _event3;
	private Race _race5;
	private Event _event4;
	private Race _race6;
	private Race _race7;
	private Race _race8;

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

			// Create the 2010/11 series
			Series series = new Series(SERIES_NAME);

			// Create classes
			junior = new Class(series, "Junior"); //$NON-NLS-1$
			series.getClasses().add(junior);

			_16inWheel = new Class(series, "16\" Wheel"); //$NON-NLS-1$
			series.getClasses().add(_16inWheel);

			// Add all the pilots
			sco018 = new Pilot(series, "SCO018@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco018);

			sco019 = new Pilot(series, "SCO019@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco019);

			sco042 = new Pilot(series, "SCO042@2009", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco042.getClasses().add(junior);
			sco042.getClasses().add(_16inWheel);
			series.getPilots().add(sco042);

			sco060 = new Pilot(series, "SCO060@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco060);

			sco068 = new Pilot(series, "SCO068@2009", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco068);

			sco081 = new Pilot(series, "SCO081@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco081);

			sco087 = new Pilot(series, "SCO087@2009", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco087.getClasses().add(_16inWheel);
			series.getPilots().add(sco087);

			sco116 = new Pilot(series, "SCO116@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco116.getClasses().add(junior);
			series.getPilots().add(sco116);

			sco136 = new Pilot(series, "SCO136@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco136);

			sco153 = new Pilot(series, "SCO153@2010", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco153.getClasses().add(_16inWheel);
			series.getPilots().add(sco153);

			sco156 = new Pilot(series, "SCO156@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco156.getClasses().add(junior);
			sco156.getClasses().add(_16inWheel);
			series.getPilots().add(sco156);

			sco158 = new Pilot(series, "SCO158@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco158.getClasses().add(_16inWheel);
			series.getPilots().add(sco158);

			sco159 = new Pilot(series, "SCO159@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco159);

			sco179 = new Pilot(series, "SCO179@2005", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco179);

			sco197 = new Pilot(series, "SCO197@2006", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco197);

			sco200 = new Pilot(series, "SCO200@2006", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco200);

			sco248 = new Pilot(series, "SCO248@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco248.getClasses().add(_16inWheel);
			series.getPilots().add(sco248);

			sco249 = new Pilot(series, "SCO249@2010", Sex.FEMALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			sco249.getClasses().add(_16inWheel);
			series.getPilots().add(sco249);

			sco808 = new Pilot(series, "SCO808@2010", Sex.MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
			series.getPilots().add(sco808);

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
			race1.getAttendees().put(sco018, new RaceAttendee(race1, sco018, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco019, new RaceAttendee(race1, sco019, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco042, new RaceAttendee(race1, sco042, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco060, new RaceAttendee(race1, sco060, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco068, new RaceAttendee(race1, sco068, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco081, new RaceAttendee(race1, sco081, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco087, new RaceAttendee(race1, sco087, RaceAttendee.Type.M_RACE_MASTER));
			race1.getAttendees().put(sco116, new RaceAttendee(race1, sco116, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco153, new RaceAttendee(race1, sco153, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco156, new RaceAttendee(race1, sco156, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco159, new RaceAttendee(race1, sco159, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco179, new RaceAttendee(race1, sco179, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco197, new RaceAttendee(race1, sco197, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco200, new RaceAttendee(race1, sco200, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco248, new RaceAttendee(race1, sco248, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco249, new RaceAttendee(race1, sco249, RaceAttendee.Type.PILOT));
			race1.getAttendees().put(sco808, new RaceAttendee(race1, sco808, RaceAttendee.Type.M_SCORER));
			race1.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco042)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			// 2
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco042)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			// 3
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			// 4
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			// 5
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
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
			race2.getAttendees().put(sco018, new RaceAttendee(race2, sco018, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco019, new RaceAttendee(race2, sco019, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco042, new RaceAttendee(race2, sco042, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco060, new RaceAttendee(race2, sco060, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco068, new RaceAttendee(race2, sco068, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco081, new RaceAttendee(race2, sco081, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco087, new RaceAttendee(race2, sco087, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco116, new RaceAttendee(race2, sco116, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco153, new RaceAttendee(race2, sco153, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco156, new RaceAttendee(race2, sco156, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco159, new RaceAttendee(race2, sco159, RaceAttendee.Type.M_SCORER));
			race2.getAttendees().put(sco179, new RaceAttendee(race2, sco179, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco197, new RaceAttendee(race2, sco197, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco200, new RaceAttendee(race2, sco200, RaceAttendee.Type.M_RACE_MASTER));
			race2.getAttendees().put(sco248, new RaceAttendee(race2, sco248, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco249, new RaceAttendee(race2, sco249, RaceAttendee.Type.PILOT));
			race2.getAttendees().put(sco808, new RaceAttendee(race2, sco808, RaceAttendee.Type.PILOT));
			race2.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco042)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco153)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco197)); //$NON-NLS-1$
			// 2
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco042)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco197)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco153)); //$NON-NLS-1$
			// 3
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			// 4
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			// 5
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
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
			race3.getAttendees().put(sco018, new RaceAttendee(race3, sco018, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco019, new RaceAttendee(race3, sco019, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco042, new RaceAttendee(race3, sco042, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco060, new RaceAttendee(race3, sco060, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco068, new RaceAttendee(race3, sco068, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco081, new RaceAttendee(race3, sco081, RaceAttendee.Type.PILOT));
			RaceAttendee att087 = new RaceAttendee(race3, sco087, RaceAttendee.Type.PILOT);
			att087.getPenalties().add(new Penalty(Penalty.Type.AUTOMATIC, "Hit a mark")); //$NON-NLS-1$
			race3.getAttendees().put(sco087, att087);
			race3.getAttendees().put(sco116, new RaceAttendee(race3, sco116, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco153, new RaceAttendee(race3, sco153, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco156, new RaceAttendee(race3, sco156, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco159, new RaceAttendee(race3, sco159, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco179, new RaceAttendee(race3, sco179, RaceAttendee.Type.M_RACE_MASTER));
			race3.getAttendees().put(sco197, new RaceAttendee(race3, sco197, RaceAttendee.Type.M_SCORER));
			race3.getAttendees().put(sco200, new RaceAttendee(race3, sco200, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco248, new RaceAttendee(race3, sco248, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco249, new RaceAttendee(race3, sco249, RaceAttendee.Type.PILOT));
			race3.getAttendees().put(sco808, new RaceAttendee(race3, sco808, RaceAttendee.Type.PILOT));
			race3.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco042)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco153)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			// 2
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco042)); //$NON-NLS-1$
			// 3
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco042)); //$NON-NLS-1$
			// 4
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			// 5
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			// 6
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			// 7
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			raceDAO.persist(race3);

			DatabaseSession.commit();

			_race3 = race3;
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
		createRace4Data();
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
			race4.getAttendees().put(sco019, new RaceAttendee(race4, sco019, RaceAttendee.Type.M_RACE_MASTER));
			race4.getAttendees().put(sco060, new RaceAttendee(race4, sco060, RaceAttendee.Type.M_SCORER));
			race4.getAttendees().put(sco068, new RaceAttendee(race4, sco068, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco081, new RaceAttendee(race4, sco081, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco087, new RaceAttendee(race4, sco087, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco116, new RaceAttendee(race4, sco116, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco153, new RaceAttendee(race4, sco153, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco156, new RaceAttendee(race4, sco156, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco159, new RaceAttendee(race4, sco159, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco179, new RaceAttendee(race4, sco179, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco197, new RaceAttendee(race4, sco197, RaceAttendee.Type.V_MARSHAL));
			race4.getAttendees().put(sco200, new RaceAttendee(race4, sco200, RaceAttendee.Type.PILOT));
			race4.getAttendees().put(sco808, new RaceAttendee(race4, sco808, RaceAttendee.Type.PILOT));
			race4.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			// 2
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			// 3
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			// 4
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			// 5
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			// 6
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race4.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
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
			race5.getAttendees().put(sco018, new RaceAttendee(race5, sco018, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco019, new RaceAttendee(race5, sco019, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco060, new RaceAttendee(race5, sco060, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco068, new RaceAttendee(race5, sco068, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco081, new RaceAttendee(race5, sco081, RaceAttendee.Type.M_RACE_MASTER));
			race5.getAttendees().put(sco087, new RaceAttendee(race5, sco087, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco116, new RaceAttendee(race5, sco116, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco153, new RaceAttendee(race5, sco153, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco158, new RaceAttendee(race5, sco158, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco159, new RaceAttendee(race5, sco159, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco179, new RaceAttendee(race5, sco179, RaceAttendee.Type.M_SCORER));
			race5.getAttendees().put(sco200, new RaceAttendee(race5, sco200, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco248, new RaceAttendee(race5, sco248, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco249, new RaceAttendee(race5, sco249, RaceAttendee.Type.PILOT));
			race5.getAttendees().put(sco808, new RaceAttendee(race5, sco808, RaceAttendee.Type.PILOT));
			race5.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			// 2
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco158)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			// 3
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			// 4
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco158)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			// 5
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			// 6
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco158)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco060)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race5.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			raceDAO.persist(race5);

			DatabaseSession.commit();

			_race5 = race5;
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
		createRace6Data();
		createRace7Data();
		createRace8Data();
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
			race6.getAttendees().put(sco018, new RaceAttendee(race6, sco018, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco019, new RaceAttendee(race6, sco019, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco068, new RaceAttendee(race6, sco068, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco081, new RaceAttendee(race6, sco081, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco087, new RaceAttendee(race6, sco087, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco116, new RaceAttendee(race6, sco116, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco136, new RaceAttendee(race6, sco136, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco153, new RaceAttendee(race6, sco153, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco156, new RaceAttendee(race6, sco156, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco159, new RaceAttendee(race6, sco159, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco179, new RaceAttendee(race6, sco179, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco200, new RaceAttendee(race6, sco200, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco248, new RaceAttendee(race6, sco248, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco249, new RaceAttendee(race6, sco249, RaceAttendee.Type.PILOT));
			race6.getAttendees().put(sco808, new RaceAttendee(race6, sco808, RaceAttendee.Type.PILOT));
			race6.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			// 2
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			// 3
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			// 4
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			// 5
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			// 6
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race6.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			raceDAO.persist(race6);

			DatabaseSession.commit();

			_race6 = race6;
		} finally {
			db.endSession();
		}
	}

	protected void createRace7Data() throws Exception {
		createEvent4Data();

		if (_race7 != null) {
			return;
		}

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			Race race7 = new Race(event4, RACE7_NAME, RACE7_DESC);
			event4.getRaces().add(race7);
			race7.getAttendees().put(sco018, new RaceAttendee(race7, sco018, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco019, new RaceAttendee(race7, sco019, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco068, new RaceAttendee(race7, sco068, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco081, new RaceAttendee(race7, sco081, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco087, new RaceAttendee(race7, sco087, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco116, new RaceAttendee(race7, sco116, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco136, new RaceAttendee(race7, sco136, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco153, new RaceAttendee(race7, sco153, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco156, new RaceAttendee(race7, sco156, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco159, new RaceAttendee(race7, sco159, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco179, new RaceAttendee(race7, sco179, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco200, new RaceAttendee(race7, sco200, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco248, new RaceAttendee(race7, sco248, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco249, new RaceAttendee(race7, sco249, RaceAttendee.Type.PILOT));
			race7.getAttendees().put(sco808, new RaceAttendee(race7, sco808, RaceAttendee.Type.PILOT));
			race7.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco153)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco156)); //$NON-NLS-1$
			// 2
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco153)); //$NON-NLS-1$
			// 3
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco019)); //$NON-NLS-1$
			// 4
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco200)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco018)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco136)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			race7.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			raceDAO.persist(race7);

			DatabaseSession.commit();

			_race7 = race7;
		} finally {
			db.endSession();
		}
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
			race8.getAttendees().put(sco018, new RaceAttendee(race8, sco018, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco019, new RaceAttendee(race8, sco019, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco068, new RaceAttendee(race8, sco068, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco081, new RaceAttendee(race8, sco081, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco087, new RaceAttendee(race8, sco087, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco116, new RaceAttendee(race8, sco116, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco136, new RaceAttendee(race8, sco136, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco153, new RaceAttendee(race8, sco153, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco156, new RaceAttendee(race8, sco156, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco159, new RaceAttendee(race8, sco159, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco179, new RaceAttendee(race8, sco179, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco200, new RaceAttendee(race8, sco200, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco248, new RaceAttendee(race8, sco248, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco249, new RaceAttendee(race8, sco249, RaceAttendee.Type.PILOT));
			race8.getAttendees().put(sco808, new RaceAttendee(race8, sco808, RaceAttendee.Type.PILOT));
			race8.getTallies().add(new RaceTally(RaceTally.Type.START));
			// 1
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco153)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			// 2
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco153)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco116)); //$NON-NLS-1$
			// 3
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco153)); //$NON-NLS-1$
			// 4
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco159)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco087)); //$NON-NLS-1$
			// 5
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco068)); //$NON-NLS-1$
			// 6
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco249)); //$NON-NLS-1$
			// 7
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco808)); //$NON-NLS-1$
			// 8
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco179)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco081)); //$NON-NLS-1$
			race8.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", sco248)); //$NON-NLS-1$
			raceDAO.persist(race8);

			DatabaseSession.commit();

			_race8 = race8;
		} finally {
			db.endSession();
		}
	}
}