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

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.test.util.OverallAssertUtil;
import uk.uuid.cursus.test.util.RaceAssertUtil;

import com.google.common.base.Predicates;

/**
 * Scores at the end of event 1
 */
public class Series2005Event1Scores extends Series2005 {
	@Override
	@Before
	public void createDatabase() throws Exception {
		super.createDatabase();
		createEvent1Races();
	}

	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, event1), Predicates.in(getSeriesResultsPilots(series, event1)));
			checkSeriesAtEvent1(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkSeriesAtEvent1() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);

			List<Race> races = new ArrayList<Race>();
			races.addAll(event1.getRaces());

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, event1), getSeriesResultsEvents(series, event1),
					Predicates.in(getSeriesResultsPilots(series, event1)));
			checkSeriesAtEvent1(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	private void checkSeriesAtEvent1(Scores scores) throws Exception {
		Series series = seriesDAO.find(SERIES_NAME);
		Event event1 = eventDAO.find(series, EVENT1_NAME);
		Race race1 = raceDAO.find(event1, RACE1_NAME);
		Race race2 = raceDAO.find(event1, RACE2_NAME);
		Race race3 = raceDAO.find(event1, RACE3_NAME);
		Race race4 = raceDAO.find(event1, RACE4_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT1, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco023, 3, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco020, 3, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco081, 3, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco160, 3, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco159, 3, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco019, 2, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco105, 2, 0, false, 7, 7);
		race1AssertUtil.assertPilot(sco095, 2, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco158, 2, 0, false, 9, 9);
		race1AssertUtil.assertPilot(sco136, 2, 0, false, 10, 10);
		race1AssertUtil.assertPilot(sco060, 1, 0, false, 11, 11);
		race1AssertUtil.assertPilot(sco050, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco109, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco117, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco135, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco154, 0, 0, false, 17, 12);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco020, 3, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco023, 3, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco095, 3, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco019, 3, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco081, 3, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco154, 3, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco050, 3, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco109, 2, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco160, 2, 0, false, 9, 9);
		race2AssertUtil.assertPilot(sco135, 2, 0, false, 10, 10);
		race2AssertUtil.assertPilot(sco158, 2, 0, false, 11, 11);
		race2AssertUtil.assertPilot(sco060, 2, 0, false, 12, 12);
		race2AssertUtil.assertPilot(sco136, 1, 0, false, 13, 13);
		race2AssertUtil.assertPilot(sco105, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco117, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco159, 0, 0, false, 17, 14);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco160, 5, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco020, 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco023, 5, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco095, 5, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco154, 5, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco136, 5, 0, false, 6, 6);
		race3AssertUtil.assertPilot(sco050, 5, 0, false, 7, 7);
		race3AssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
		race3AssertUtil.assertPilot(sco060, 4, 0, false, 9, 9);
		race3AssertUtil.assertPilot(sco117, 4, 0, false, 10, 10);
		race3AssertUtil.assertPilot(sco109, 4, 0, false, 11, 11);
		race3AssertUtil.assertPilot(sco081, 4, 0, false, 12, 12);
		race3AssertUtil.assertPilot(sco135, 3, 0, false, 13, 13);
		race3AssertUtil.assertPilot(sco159, 2, 0, false, 14, 14);
		race3AssertUtil.assertPilot(sco019, 1, 0, false, 15, 15);
		race3AssertUtil.assertPilot(sco105, 0, 0, false, 17, 16);
		race3AssertUtil.assertDone(0);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco020, 5, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco160, 5, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco081, 5, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco154, 4, 0, false, 5, 5);
		race4AssertUtil.assertPilot(sco019, 4, 0, false, 6, 6);
		race4AssertUtil.assertPilot(sco050, 4, 0, false, 7, 7);
		race4AssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
		race4AssertUtil.assertPilot(sco136, 4, 0, false, 9, 9);
		race4AssertUtil.assertPilot(sco159, 4, 0, false, 10, 10);
		race4AssertUtil.assertPilot(sco095, 4, 0, false, 11, 11);
		race4AssertUtil.assertPilot(sco117, 3, 0, false, 12, 12);
		race4AssertUtil.assertPilot(sco135, 3, 0, false, 13, 13);
		race4AssertUtil.assertPilot(sco109, 3, 0, false, 14, 14);
		race4AssertUtil.assertPilot(sco060, 3, 0, false, 15, 15);
		race4AssertUtil.assertPilot(sco105, 0, 0, false, 17, 16);
		race4AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 2, 1, 3);
		overallAssertUtil.assertPilot(sco020, 0, 4, 2, 2);
		overallAssertUtil.assertPilot(sco160, 0, 7, 3, 9);
		overallAssertUtil.assertPilot(sco081, 0, 12, 4, 12);
		overallAssertUtil.assertPilot(sco095, 0, 15, 5, 11);
		overallAssertUtil.assertPilot(sco019, 0, 16, 6, 15);
		overallAssertUtil.assertPilot(sco154, 0, 16, 7, 17);
		overallAssertUtil.assertPilot(sco050, 0, 21, 8, 17);
		overallAssertUtil.assertPilot(sco136, 0, 25, 9, 13);
		overallAssertUtil.assertPilot(sco158, 0, 25, 10, 11);
		overallAssertUtil.assertPilot(sco159, 0, 29, 11, 17);
		overallAssertUtil.assertPilot(sco060, 0, 32, 12, 15);
		overallAssertUtil.assertPilot(sco109, 0, 33, 13, 17);
		overallAssertUtil.assertPilot(sco135, 0, 36, 14, 17);
		overallAssertUtil.assertPilot(sco117, 0, 39, 15, 17);
		overallAssertUtil.assertPilot(sco105, 0, 41, 16, 17);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent1() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Race race1 = raceDAO.find(event1, RACE1_NAME);
			Race race2 = raceDAO.find(event1, RACE2_NAME);
			Race race3 = raceDAO.find(event1, RACE3_NAME);
			Race race4 = raceDAO.find(event1, RACE4_NAME);

			Scores scores = scorer.scoreEvent(event1, Predicates.in(getEventResultsPilots(series, event1)));
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE1_FLEET, scores.getFleetSize(race1));
			Assert.assertEquals(RACE2_FLEET, scores.getFleetSize(race2));
			Assert.assertEquals(RACE3_FLEET, scores.getFleetSize(race3));
			Assert.assertEquals(RACE4_FLEET, scores.getFleetSize(race4));

			RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
			race1AssertUtil.assertPilot(sco023, 3, 0, false, 0, 1);
			race1AssertUtil.assertPilot(sco020, 3, 0, false, 2, 2);
			race1AssertUtil.assertPilot(sco081, 3, 0, false, 3, 3);
			race1AssertUtil.assertPilot(sco160, 3, 0, false, 4, 4);
			race1AssertUtil.assertPilot(sco159, 3, 0, false, 5, 5);
			race1AssertUtil.assertPilot(sco019, 2, 0, false, 6, 6);
			race1AssertUtil.assertPilot(sco105, 2, 0, false, 7, 7);
			race1AssertUtil.assertPilot(sco095, 2, 0, false, 8, 8);
			race1AssertUtil.assertPilot(sco158, 2, 0, false, 9, 9);
			race1AssertUtil.assertPilot(sco136, 2, 0, false, 10, 10);
			race1AssertUtil.assertPilot(sco060, 1, 0, false, 11, 11);
			race1AssertUtil.assertPilot(sco050, 0, 0, false, 17, 12);
			race1AssertUtil.assertPilot(sco109, 0, 0, false, 17, 12);
			race1AssertUtil.assertPilot(sco117, 0, 0, false, 17, 12);
			race1AssertUtil.assertPilot(sco135, 0, 0, false, 17, 12);
			race1AssertUtil.assertPilot(sco154, 0, 0, false, 17, 12);
			race1AssertUtil.assertDone(0);

			RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
			race2AssertUtil.assertPilot(sco020, 3, 0, false, 0, 1);
			race2AssertUtil.assertPilot(sco023, 3, 0, false, 2, 2);
			race2AssertUtil.assertPilot(sco095, 3, 0, false, 3, 3);
			race2AssertUtil.assertPilot(sco019, 3, 0, false, 4, 4);
			race2AssertUtil.assertPilot(sco081, 3, 0, false, 5, 5);
			race2AssertUtil.assertPilot(sco154, 3, 0, false, 6, 6);
			race2AssertUtil.assertPilot(sco050, 3, 0, false, 7, 7);
			race2AssertUtil.assertPilot(sco109, 2, 0, false, 8, 8);
			race2AssertUtil.assertPilot(sco160, 2, 0, false, 9, 9);
			race2AssertUtil.assertPilot(sco135, 2, 0, false, 10, 10);
			race2AssertUtil.assertPilot(sco158, 2, 0, false, 11, 11);
			race2AssertUtil.assertPilot(sco060, 2, 0, false, 12, 12);
			race2AssertUtil.assertPilot(sco136, 1, 0, false, 13, 13);
			race2AssertUtil.assertPilot(sco105, 0, 0, false, 17, 14);
			race2AssertUtil.assertPilot(sco117, 0, 0, false, 17, 14);
			race2AssertUtil.assertPilot(sco159, 0, 0, false, 17, 14);
			race2AssertUtil.assertDone(0);

			RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
			race3AssertUtil.assertPilot(sco160, 5, 0, false, 0, 1);
			race3AssertUtil.assertPilot(sco020, 5, 0, false, 2, 2);
			race3AssertUtil.assertPilot(sco023, 5, 0, false, 3, 3);
			race3AssertUtil.assertPilot(sco095, 5, 0, false, 4, 4);
			race3AssertUtil.assertPilot(sco154, 5, 0, false, 5, 5);
			race3AssertUtil.assertPilot(sco136, 5, 0, false, 6, 6);
			race3AssertUtil.assertPilot(sco050, 5, 0, false, 7, 7);
			race3AssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
			race3AssertUtil.assertPilot(sco060, 4, 0, false, 9, 9);
			race3AssertUtil.assertPilot(sco117, 4, 0, false, 10, 10);
			race3AssertUtil.assertPilot(sco109, 4, 0, false, 11, 11);
			race3AssertUtil.assertPilot(sco081, 4, 0, false, 12, 12);
			race3AssertUtil.assertPilot(sco135, 3, 0, false, 13, 13);
			race3AssertUtil.assertPilot(sco159, 2, 0, false, 14, 14);
			race3AssertUtil.assertPilot(sco019, 1, 0, false, 15, 15);
			race3AssertUtil.assertPilot(sco105, 0, 0, false, 17, 16);
			race3AssertUtil.assertDone(0);

			RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
			race4AssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
			race4AssertUtil.assertPilot(sco020, 5, 0, false, 2, 2);
			race4AssertUtil.assertPilot(sco160, 5, 0, false, 3, 3);
			race4AssertUtil.assertPilot(sco081, 5, 0, false, 4, 4);
			race4AssertUtil.assertPilot(sco154, 4, 0, false, 5, 5);
			race4AssertUtil.assertPilot(sco019, 4, 0, false, 6, 6);
			race4AssertUtil.assertPilot(sco050, 4, 0, false, 7, 7);
			race4AssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
			race4AssertUtil.assertPilot(sco136, 4, 0, false, 9, 9);
			race4AssertUtil.assertPilot(sco159, 4, 0, false, 10, 10);
			race4AssertUtil.assertPilot(sco095, 4, 0, false, 11, 11);
			race4AssertUtil.assertPilot(sco117, 3, 0, false, 12, 12);
			race4AssertUtil.assertPilot(sco135, 3, 0, false, 13, 13);
			race4AssertUtil.assertPilot(sco109, 3, 0, false, 14, 14);
			race4AssertUtil.assertPilot(sco060, 3, 0, false, 15, 15);
			race4AssertUtil.assertPilot(sco105, 0, 0, false, 17, 16);
			race4AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 2, 1, 3);
			overallAssertUtil.assertPilot(sco020, 0, 4, 2, 2);
			overallAssertUtil.assertPilot(sco160, 0, 7, 3, 9);
			overallAssertUtil.assertPilot(sco081, 0, 12, 4, 12);
			overallAssertUtil.assertPilot(sco095, 0, 15, 5, 11);
			overallAssertUtil.assertPilot(sco019, 0, 16, 6, 15);
			overallAssertUtil.assertPilot(sco154, 0, 16, 7, 17);
			overallAssertUtil.assertPilot(sco050, 0, 21, 8, 17);
			overallAssertUtil.assertPilot(sco136, 0, 25, 9, 13);
			overallAssertUtil.assertPilot(sco158, 0, 25, 10, 11);
			overallAssertUtil.assertPilot(sco159, 0, 29, 11, 17);
			overallAssertUtil.assertPilot(sco060, 0, 32, 12, 15);
			overallAssertUtil.assertPilot(sco109, 0, 33, 13, 17);
			overallAssertUtil.assertPilot(sco135, 0, 36, 14, 17);
			overallAssertUtil.assertPilot(sco117, 0, 39, 15, 17);
			overallAssertUtil.assertPilot(sco105, 0, 41, 16, 17);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace1() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Race race1 = raceDAO.find(event1, RACE1_NAME);

			Scores scores = scorer.scoreRace(race1, Predicates.in(getEventResultsPilots(series, event1)));
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE1_FLEET, scores.getFleetSize(race1));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race1);
			raceAssertUtil.assertPilot(sco023, 3, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco020, 3, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco081, 3, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco160, 3, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco159, 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco019, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco105, 2, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco095, 2, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco158, 2, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco136, 2, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco060, 1, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco050, 0, 0, false, 17, 12);
			raceAssertUtil.assertPilot(sco109, 0, 0, false, 17, 12);
			raceAssertUtil.assertPilot(sco117, 0, 0, false, 17, 12);
			raceAssertUtil.assertPilot(sco135, 0, 0, false, 17, 12);
			raceAssertUtil.assertPilot(sco154, 0, 0, false, 17, 12);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco020, 0, 2, 2);
			overallAssertUtil.assertPilot(sco081, 0, 3, 3);
			overallAssertUtil.assertPilot(sco160, 0, 4, 4);
			overallAssertUtil.assertPilot(sco159, 0, 5, 5);
			overallAssertUtil.assertPilot(sco019, 0, 6, 6);
			overallAssertUtil.assertPilot(sco105, 0, 7, 7);
			overallAssertUtil.assertPilot(sco095, 0, 8, 8);
			overallAssertUtil.assertPilot(sco158, 0, 9, 9);
			overallAssertUtil.assertPilot(sco136, 0, 10, 10);
			overallAssertUtil.assertPilot(sco060, 0, 11, 11);
			overallAssertUtil.assertPilot(sco050, 0, 17, 12);
			overallAssertUtil.assertPilot(sco109, 0, 17, 12);
			overallAssertUtil.assertPilot(sco117, 0, 17, 12);
			overallAssertUtil.assertPilot(sco135, 0, 17, 12);
			overallAssertUtil.assertPilot(sco154, 0, 17, 12);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace2() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Race race2 = raceDAO.find(event1, RACE2_NAME);

			Scores scores = scorer.scoreRace(race2, Predicates.in(getEventResultsPilots(series, event1)));
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE2_FLEET, scores.getFleetSize(race2));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race2);
			raceAssertUtil.assertPilot(sco020, 3, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 3, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco095, 3, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco019, 3, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco081, 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco154, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco050, 3, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco109, 2, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco160, 2, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco135, 2, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco158, 2, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco060, 2, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco136, 1, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco105, 0, 0, false, 17, 14);
			raceAssertUtil.assertPilot(sco117, 0, 0, false, 17, 14);
			raceAssertUtil.assertPilot(sco159, 0, 0, false, 17, 14);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco020, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(sco095, 0, 3, 3);
			overallAssertUtil.assertPilot(sco019, 0, 4, 4);
			overallAssertUtil.assertPilot(sco081, 0, 5, 5);
			overallAssertUtil.assertPilot(sco154, 0, 6, 6);
			overallAssertUtil.assertPilot(sco050, 0, 7, 7);
			overallAssertUtil.assertPilot(sco109, 0, 8, 8);
			overallAssertUtil.assertPilot(sco160, 0, 9, 9);
			overallAssertUtil.assertPilot(sco135, 0, 10, 10);
			overallAssertUtil.assertPilot(sco158, 0, 11, 11);
			overallAssertUtil.assertPilot(sco060, 0, 12, 12);
			overallAssertUtil.assertPilot(sco136, 0, 13, 13);
			overallAssertUtil.assertPilot(sco105, 0, 17, 14);
			overallAssertUtil.assertPilot(sco117, 0, 17, 14);
			overallAssertUtil.assertPilot(sco159, 0, 17, 14);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace3() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Race race3 = raceDAO.find(event1, RACE3_NAME);

			Scores scores = scorer.scoreRace(race3, Predicates.in(getEventResultsPilots(series, event1)));
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE3_FLEET, scores.getFleetSize(race3));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race3);
			raceAssertUtil.assertPilot(sco160, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco020, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco023, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco095, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco154, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco136, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco050, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco060, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco109, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco081, 4, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco135, 3, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco159, 2, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco019, 1, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco105, 0, 0, false, 17, 16);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco160, 0, 0, 1);
			overallAssertUtil.assertPilot(sco020, 0, 2, 2);
			overallAssertUtil.assertPilot(sco023, 0, 3, 3);
			overallAssertUtil.assertPilot(sco095, 0, 4, 4);
			overallAssertUtil.assertPilot(sco154, 0, 5, 5);
			overallAssertUtil.assertPilot(sco136, 0, 6, 6);
			overallAssertUtil.assertPilot(sco050, 0, 7, 7);
			overallAssertUtil.assertPilot(sco158, 0, 8, 8);
			overallAssertUtil.assertPilot(sco060, 0, 9, 9);
			overallAssertUtil.assertPilot(sco117, 0, 10, 10);
			overallAssertUtil.assertPilot(sco109, 0, 11, 11);
			overallAssertUtil.assertPilot(sco081, 0, 12, 12);
			overallAssertUtil.assertPilot(sco135, 0, 13, 13);
			overallAssertUtil.assertPilot(sco159, 0, 14, 14);
			overallAssertUtil.assertPilot(sco019, 0, 15, 15);
			overallAssertUtil.assertPilot(sco105, 0, 17, 16);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace4() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Race race4 = raceDAO.find(event1, RACE4_NAME);

			Scores scores = scorer.scoreRace(race4, Predicates.in(getEventResultsPilots(series, event1)));
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE4_FLEET, scores.getFleetSize(race4));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race4);
			raceAssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco020, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco160, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco081, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco154, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco050, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco136, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco095, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco117, 3, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco135, 3, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco109, 3, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco060, 3, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco105, 0, 0, false, 17, 16);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco020, 0, 2, 2);
			overallAssertUtil.assertPilot(sco160, 0, 3, 3);
			overallAssertUtil.assertPilot(sco081, 0, 4, 4);
			overallAssertUtil.assertPilot(sco154, 0, 5, 5);
			overallAssertUtil.assertPilot(sco019, 0, 6, 6);
			overallAssertUtil.assertPilot(sco050, 0, 7, 7);
			overallAssertUtil.assertPilot(sco158, 0, 8, 8);
			overallAssertUtil.assertPilot(sco136, 0, 9, 9);
			overallAssertUtil.assertPilot(sco159, 0, 10, 10);
			overallAssertUtil.assertPilot(sco095, 0, 11, 11);
			overallAssertUtil.assertPilot(sco117, 0, 12, 12);
			overallAssertUtil.assertPilot(sco135, 0, 13, 13);
			overallAssertUtil.assertPilot(sco109, 0, 14, 14);
			overallAssertUtil.assertPilot(sco060, 0, 15, 15);
			overallAssertUtil.assertPilot(sco105, 0, 17, 16);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}