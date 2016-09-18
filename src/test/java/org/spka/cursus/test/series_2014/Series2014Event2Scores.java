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
package org.spka.cursus.test.series_2014;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicates;

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.test.util.OverallAssertUtil;
import uk.uuid.cursus.test.util.RaceAssertUtil;

/**
 * Scores at the end of event 2 (24/01/2015 to 25/01/2015)
 */
public class Series2014Event2Scores extends Series2014Event1Scores {
	@Override
	@Before
	public void createDatabase() throws Exception {
		super.createDatabase();
		createEvent2Races();
	}

	@Override
	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, event2), Predicates.in(getSeriesResultsPilots(series, event2)));
			checkSeriesAtEvent2(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkSeriesAtEvent2() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);

			List<Race> races = new ArrayList<Race>();
			races.addAll(event1.getRaces());
			races.addAll(event2.getRaces());

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, event2), getSeriesResultsEvents(series, event2),
					Predicates.in(getSeriesResultsPilots(series, event2)));
			checkSeriesAtEvent2(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	private void checkSeriesAtEvent2(Scores scores) throws Exception {
		Series series = seriesDAO.find(SERIES_NAME);
		Event event1 = eventDAO.find(series, EVENT1_NAME);
		Race race1 = raceDAO.find(event1, RACE1_NAME);
		Race race2 = raceDAO.find(event1, RACE2_NAME);
		Race race3 = raceDAO.find(event1, RACE3_NAME);
		Race race4 = raceDAO.find(event1, RACE4_NAME);
		Race race5 = raceDAO.find(event1, RACE5_NAME);
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race6 = raceDAO.find(event2, RACE6_NAME);
		Race race7 = raceDAO.find(event2, RACE7_NAME);
		Race race8 = raceDAO.find(event2, RACE8_NAME);
		Race race9 = raceDAO.find(event2, RACE9_NAME);
		Race race10 = raceDAO.find(event2, RACE10_NAME);
		Race race11 = raceDAO.find(event2, RACE11_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT2, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco069, 6, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco116, 6, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco808, 6, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco528, 6, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco087, 5, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco018, 5, 0, false, 7, 7);
		race1AssertUtil.assertPilot(sco156, 4, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco066, 0, 0, false, 11, 9);
		race1AssertUtil.assertPilot(sco296, 0, 0, false, 11, 9);
		race1AssertUtil.assertPilot(sco315, 0, 0, false, 13, 11);
		race1AssertUtil.assertPilot(sco561, 0, 0, false, 13, 11);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco069, 5, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco116, 5, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco528, 5, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco156, 5, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco018, 4, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco066, 2, 0, false, 9, 9);
		race2AssertUtil.assertPilot(sco296, 0, 0, false, 11, 10);
		race2AssertUtil.assertPilot(sco315, 0, 0, false, 13, 11);
		race2AssertUtil.assertPilot(sco561, 0, 0, false, 13, 11);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco069, 5, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco116, 5, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco528, 5, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco156, 5, 0, false, 6, 6);
		race3AssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
		race3AssertUtil.assertPilot(sco018, 4, 1, false, 8, 8);
		race3AssertUtil.assertPilot(sco066, 3, 0, false, 9, 9);
		race3AssertUtil.assertPilot(sco296, 1, 0, false, 10, 10);
		race3AssertUtil.assertPilot(sco315, 0, 0, false, 13, 11);
		race3AssertUtil.assertPilot(sco561, 0, 0, false, 13, 11);
		race3AssertUtil.assertDone(0);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco069, 7, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco808, 7, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco179, 7, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco116, 7, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco156, 6, 0, false, 5, 5);
		race4AssertUtil.assertPilot(sco018, 6, 0, false, 6, 6);
		race4AssertUtil.assertPilot(sco066, 5, 0, false, 7, 7);
		race4AssertUtil.assertPilot(sco087, 4, 0, false, 8, 8);
		race4AssertUtil.assertPilot(sco296, 3, 0, false, 9, 9);
		race4AssertUtil.assertPilot(sco528, 1, 0, false, 10, 10);
		race4AssertUtil.assertPilot(sco315, 0, 0, false, 13, 11);
		race4AssertUtil.assertPilot(sco561, 0, 0, false, 13, 11);
		race4AssertUtil.assertDone(0);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(sco179, 5, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco808, 5, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco116, 5, 0, false, 3, 3);
		race5AssertUtil.assertPilot(sco528, 3, 0, false, 4, 4);
		race5AssertUtil.assertPilot(sco018, 0, 0, false, 11, 5);
		race5AssertUtil.assertPilot(sco066, 0, 0, false, 11, 5);
		race5AssertUtil.assertPilot(sco069, 0, 0, false, 11, 5);
		race5AssertUtil.assertPilot(sco087, 0, 0, false, 11, 5);
		race5AssertUtil.assertPilot(sco156, 0, 0, false, 11, 5);
		race5AssertUtil.assertPilot(sco296, 0, 0, false, 11, 5);
		race5AssertUtil.assertPilot(sco315, 0, 0, false, 13, 11);
		race5AssertUtil.assertPilot(sco561, 0, 0, false, 13, 11);
		race5AssertUtil.assertDone(0);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race6AssertUtil.assertPilot(sco069, 6, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
		race6AssertUtil.assertPilot(sco808, 6, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco156, 5, 0, false, 5, 5);
		race6AssertUtil.assertPilot(sco018, 4, 0, false, 6, 6);
		race6AssertUtil.assertPilot(sco528, 4, 0, false, 7, 7);
		race6AssertUtil.assertPilot(sco296, 3, 0, false, 8, 8);
		race6AssertUtil.assertPilot(sco561, 1, 0, false, 9, 9);
		race6AssertUtil.assertPilot(sco315, 1, 0, false, 10, 10);
		race6AssertUtil.assertPilot(sco066, 0, 0, false, 13, 11);
		race6AssertUtil.assertPilot(sco087, 0, 0, false, 13, 11);
		race6AssertUtil.assertDone(0);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
		race7AssertUtil.assertPilot(sco179, 5, 0, false, 0, 1);
		race7AssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
		race7AssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
		race7AssertUtil.assertPilot(sco069, 4, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco018, 2, 0, false, 5, 5);
		race7AssertUtil.assertPilot(sco296, 2, 0, false, 6, 6);
		race7AssertUtil.assertPilot(sco528, 2, 0, false, 7, 7);
		race7AssertUtil.assertPilot(sco315, 2, 0, false, 8, 8);
		race7AssertUtil.assertPilot(sco156, 1, 0, false, 9, 9);
		race7AssertUtil.assertPilot(sco561, 0, 0, false, 11, 10);
		race7AssertUtil.assertPilot(sco066, 0, 0, false, 13, 11);
		race7AssertUtil.assertPilot(sco087, 0, 0, false, 13, 11);
		race7AssertUtil.assertDone(0);

		RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
		race8AssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
		race8AssertUtil.assertPilot(sco179, 8, 0, false, 2, 2);
		race8AssertUtil.assertPilot(sco528, 8, 0, false, 3, 3);
		race8AssertUtil.assertPilot(sco808, 6, 0, false, 4, 4);
		race8AssertUtil.assertPilot(sco069, 6, 0, false, 5, 5);
		race8AssertUtil.assertPilot(sco156, 5, 0, false, 6, 6);
		race8AssertUtil.assertPilot(sco315, 3, 0, false, 7, 7);
		race8AssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
		race8AssertUtil.assertPilot(sco018, 0, 0, false, 11, 9);
		race8AssertUtil.assertPilot(sco561, 0, 0, false, 11, 9);
		race8AssertUtil.assertPilot(sco066, 0, 0, false, 13, 11);
		race8AssertUtil.assertPilot(sco087, 0, 0, false, 13, 11);
		race8AssertUtil.assertDone(0);

		RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
		race9AssertUtil.assertPilot(sco069, 8, 0, false, 0, 1);
		race9AssertUtil.assertPilot(sco116, 8, 0, false, 2, 2);
		race9AssertUtil.assertPilot(sco528, 8, 0, false, 3, 3);
		race9AssertUtil.assertPilot(sco808, 7, 0, false, 4, 4);
		race9AssertUtil.assertPilot(sco179, 6, 0, false, 5, 5);
		race9AssertUtil.assertPilot(sco156, 6, 0, false, 6, 6);
		race9AssertUtil.assertPilot(sco315, 3, 0, false, 7, 7);
		race9AssertUtil.assertPilot(sco561, 2, 0, false, 8, 8);
		race9AssertUtil.assertPilot(sco296, 1, 0, false, 9, 9);
		race9AssertUtil.assertPilot(sco018, 0, 0, false, 11, 10);
		race9AssertUtil.assertPilot(sco066, 0, 0, false, 13, 11);
		race9AssertUtil.assertPilot(sco087, 0, 0, false, 13, 11);
		race9AssertUtil.assertDone(0);

		RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
		race10AssertUtil.assertPilot(sco069, 7, 0, false, 0, 1);
		race10AssertUtil.assertPilot(sco116, 7, 0, false, 2, 2);
		race10AssertUtil.assertPilot(sco179, 7, 0, false, 3, 3);
		race10AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
		race10AssertUtil.assertPilot(sco808, 4, 0, false, 5, 5);
		race10AssertUtil.assertPilot(sco156, 3, 0, false, 6, 6);
		race10AssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
		race10AssertUtil.assertPilot(sco315, 1, 0, false, 8, 8);
		race10AssertUtil.assertPilot(sco018, 0, 0, false, 11, 9);
		race10AssertUtil.assertPilot(sco561, 0, 1, false, 11, 10);
		race10AssertUtil.assertPilot(sco066, 0, 0, false, 13, 11);
		race10AssertUtil.assertPilot(sco087, 0, 0, false, 13, 11);
		race10AssertUtil.assertDone(0);

		RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
		race11AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race11AssertUtil.assertPilot(sco069, 7, 0, false, 2, 2);
		race11AssertUtil.assertPilot(sco808, 6, 0, false, 3, 3);
		race11AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
		race11AssertUtil.assertPilot(sco156, 6, 0, false, 5, 5);
		race11AssertUtil.assertPilot(sco179, 5, 1, false, 6, 6);
		race11AssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
		race11AssertUtil.assertPilot(sco315, 1, 0, false, 8, 8);
		race11AssertUtil.assertPilot(sco018, 0, 0, false, 11, 9);
		race11AssertUtil.assertPilot(sco561, 0, 0, false, 11, 9);
		race11AssertUtil.assertPilot(sco066, 0, 0, false, 13, 11);
		race11AssertUtil.assertPilot(sco087, 0, 0, false, 13, 11);
		race11AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco069, 0, 8, 1, 11, 5);
		overallAssertUtil.assertPilot(sco116, 0, 14, 2, 4, 4);
		overallAssertUtil.assertPilot(sco179, 1, 19, 3, 6, 5);
		overallAssertUtil.assertPilot(sco808, 0, 29, 4, 5, 4);
		overallAssertUtil.assertPilot(sco528, 0, 40, 5, 10, 7);
		overallAssertUtil.assertPilot(sco156, 0, 53, 6, 11, 9);
		overallAssertUtil.assertPilot(sco018, 1, 74, 7, 11, 11);
		overallAssertUtil.assertPilot(sco296, 0, 75, 8, 11, 11);
		overallAssertUtil.assertPilot(sco315, 0, 87, 9, 13, 13);
		overallAssertUtil.assertPilot(sco087, 0, 91, 10, 13, 13);
		overallAssertUtil.assertPilot(sco066, 0, 99, 11, 13, 13);
		overallAssertUtil.assertPilot(sco561, 1, 101, 12, 13, 13);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent2() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race6 = raceDAO.find(event2, RACE6_NAME);
			Race race7 = raceDAO.find(event2, RACE7_NAME);
			Race race8 = raceDAO.find(event2, RACE8_NAME);
			Race race9 = raceDAO.find(event2, RACE9_NAME);
			Race race10 = raceDAO.find(event2, RACE10_NAME);
			Race race11 = raceDAO.find(event2, RACE11_NAME);

			Scores scores = scorer.scoreEvent(event2, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race6));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race7));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race8));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race9));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race10));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race11));

			RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
			race6AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			race6AssertUtil.assertPilot(sco069, 6, 0, false, 2, 2);
			race6AssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
			race6AssertUtil.assertPilot(sco808, 6, 0, false, 4, 4);
			race6AssertUtil.assertPilot(sco156, 5, 0, false, 5, 5);
			race6AssertUtil.assertPilot(sco018, 4, 0, false, 6, 6);
			race6AssertUtil.assertPilot(sco528, 4, 0, false, 7, 7);
			race6AssertUtil.assertPilot(sco296, 3, 0, false, 8, 8);
			race6AssertUtil.assertPilot(sco561, 1, 0, false, 9, 9);
			race6AssertUtil.assertPilot(sco315, 1, 0, false, 10, 10);
			race6AssertUtil.assertDone(0);

			RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
			race7AssertUtil.assertPilot(sco179, 5, 0, false, 0, 1);
			race7AssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
			race7AssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
			race7AssertUtil.assertPilot(sco069, 4, 0, false, 4, 4);
			race7AssertUtil.assertPilot(sco018, 2, 0, false, 5, 5);
			race7AssertUtil.assertPilot(sco296, 2, 0, false, 6, 6);
			race7AssertUtil.assertPilot(sco528, 2, 0, false, 7, 7);
			race7AssertUtil.assertPilot(sco315, 2, 0, false, 8, 8);
			race7AssertUtil.assertPilot(sco156, 1, 0, false, 9, 9);
			race7AssertUtil.assertPilot(sco561, 0, 0, false, 11, 10);
			race7AssertUtil.assertDone(0);

			RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
			race8AssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
			race8AssertUtil.assertPilot(sco179, 8, 0, false, 2, 2);
			race8AssertUtil.assertPilot(sco528, 8, 0, false, 3, 3);
			race8AssertUtil.assertPilot(sco808, 6, 0, false, 4, 4);
			race8AssertUtil.assertPilot(sco069, 6, 0, false, 5, 5);
			race8AssertUtil.assertPilot(sco156, 5, 0, false, 6, 6);
			race8AssertUtil.assertPilot(sco315, 3, 0, false, 7, 7);
			race8AssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
			race8AssertUtil.assertPilot(sco018, 0, 0, false, 11, 9);
			race8AssertUtil.assertPilot(sco561, 0, 0, false, 11, 9);
			race8AssertUtil.assertDone(0);

			RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
			race9AssertUtil.assertPilot(sco069, 8, 0, false, 0, 1);
			race9AssertUtil.assertPilot(sco116, 8, 0, false, 2, 2);
			race9AssertUtil.assertPilot(sco528, 8, 0, false, 3, 3);
			race9AssertUtil.assertPilot(sco808, 7, 0, false, 4, 4);
			race9AssertUtil.assertPilot(sco179, 6, 0, false, 5, 5);
			race9AssertUtil.assertPilot(sco156, 6, 0, false, 6, 6);
			race9AssertUtil.assertPilot(sco315, 3, 0, false, 7, 7);
			race9AssertUtil.assertPilot(sco561, 2, 0, false, 8, 8);
			race9AssertUtil.assertPilot(sco296, 1, 0, false, 9, 9);
			race9AssertUtil.assertPilot(sco018, 0, 0, false, 11, 10);
			race9AssertUtil.assertDone(0);

			RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
			race10AssertUtil.assertPilot(sco069, 7, 0, false, 0, 1);
			race10AssertUtil.assertPilot(sco116, 7, 0, false, 2, 2);
			race10AssertUtil.assertPilot(sco179, 7, 0, false, 3, 3);
			race10AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
			race10AssertUtil.assertPilot(sco808, 4, 0, false, 5, 5);
			race10AssertUtil.assertPilot(sco156, 3, 0, false, 6, 6);
			race10AssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
			race10AssertUtil.assertPilot(sco315, 1, 0, false, 8, 8);
			race10AssertUtil.assertPilot(sco018, 0, 0, false, 11, 9);
			race10AssertUtil.assertPilot(sco561, 0, 1, false, 11, 10);
			race10AssertUtil.assertDone(0);

			RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
			race11AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			race11AssertUtil.assertPilot(sco069, 7, 0, false, 2, 2);
			race11AssertUtil.assertPilot(sco808, 6, 0, false, 3, 3);
			race11AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
			race11AssertUtil.assertPilot(sco156, 6, 0, false, 5, 5);
			race11AssertUtil.assertPilot(sco179, 5, 1, false, 6, 6);
			race11AssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
			race11AssertUtil.assertPilot(sco315, 1, 0, false, 8, 8);
			race11AssertUtil.assertPilot(sco018, 0, 0, false, 11, 9);
			race11AssertUtil.assertPilot(sco561, 0, 0, false, 11, 9);
			race11AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 4, 1, 2);
			overallAssertUtil.assertPilot(sco069, 0, 8, 2, 5);
			overallAssertUtil.assertPilot(sco179, 1, 14, 3, 6);
			overallAssertUtil.assertPilot(sco808, 0, 18, 4, 5);
			overallAssertUtil.assertPilot(sco528, 0, 21, 5, 7);
			overallAssertUtil.assertPilot(sco156, 0, 28, 6, 9);
			overallAssertUtil.assertPilot(sco296, 0, 36, 7, 9);
			overallAssertUtil.assertPilot(sco315, 0, 38, 8, 10);
			overallAssertUtil.assertPilot(sco018, 0, 44, 9, 11);
			overallAssertUtil.assertPilot(sco561, 1, 51, 10, 11);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace6() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race6 = raceDAO.find(event2, RACE6_NAME);

			Scores scores = scorer.scoreRace(race6, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race6));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race6);
			raceAssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco069, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco156, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco018, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco528, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco296, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco561, 1, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco315, 1, 0, false, 10, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco069, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(sco808, 0, 4, 4);
			overallAssertUtil.assertPilot(sco156, 0, 5, 5);
			overallAssertUtil.assertPilot(sco018, 0, 6, 6);
			overallAssertUtil.assertPilot(sco528, 0, 7, 7);
			overallAssertUtil.assertPilot(sco296, 0, 8, 8);
			overallAssertUtil.assertPilot(sco561, 0, 9, 9);
			overallAssertUtil.assertPilot(sco315, 0, 10, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace7() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race7 = raceDAO.find(event2, RACE7_NAME);

			Scores scores = scorer.scoreRace(race7, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race7));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race7);
			raceAssertUtil.assertPilot(sco179, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco069, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco018, 2, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco296, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco528, 2, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco315, 2, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco156, 1, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco561, 0, 0, false, 11, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco179, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(sco069, 0, 4, 4);
			overallAssertUtil.assertPilot(sco018, 0, 5, 5);
			overallAssertUtil.assertPilot(sco296, 0, 6, 6);
			overallAssertUtil.assertPilot(sco528, 0, 7, 7);
			overallAssertUtil.assertPilot(sco315, 0, 8, 8);
			overallAssertUtil.assertPilot(sco156, 0, 9, 9);
			overallAssertUtil.assertPilot(sco561, 0, 11, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace8() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race8 = raceDAO.find(event2, RACE8_NAME);

			Scores scores = scorer.scoreRace(race8, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race8));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race8);
			raceAssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco528, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco069, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco156, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco315, 3, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 11, 9);
			raceAssertUtil.assertPilot(sco561, 0, 0, false, 11, 9);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco179, 0, 2, 2);
			overallAssertUtil.assertPilot(sco528, 0, 3, 3);
			overallAssertUtil.assertPilot(sco808, 0, 4, 4);
			overallAssertUtil.assertPilot(sco069, 0, 5, 5);
			overallAssertUtil.assertPilot(sco156, 0, 6, 6);
			overallAssertUtil.assertPilot(sco315, 0, 7, 7);
			overallAssertUtil.assertPilot(sco296, 0, 8, 8);
			overallAssertUtil.assertPilot(sco018, 0, 11, 9);
			overallAssertUtil.assertPilot(sco561, 0, 11, 9);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace9() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race9 = raceDAO.find(event2, RACE9_NAME);

			Scores scores = scorer.scoreRace(race9, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race9));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race9);
			raceAssertUtil.assertPilot(sco069, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco528, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco808, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco156, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco315, 3, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco561, 2, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco296, 1, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 11, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco528, 0, 3, 3);
			overallAssertUtil.assertPilot(sco808, 0, 4, 4);
			overallAssertUtil.assertPilot(sco179, 0, 5, 5);
			overallAssertUtil.assertPilot(sco156, 0, 6, 6);
			overallAssertUtil.assertPilot(sco315, 0, 7, 7);
			overallAssertUtil.assertPilot(sco561, 0, 8, 8);
			overallAssertUtil.assertPilot(sco296, 0, 9, 9);
			overallAssertUtil.assertPilot(sco018, 0, 11, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace10() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race10 = raceDAO.find(event2, RACE10_NAME);

			Scores scores = scorer.scoreRace(race10, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race10));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race10);
			raceAssertUtil.assertPilot(sco069, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco808, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco156, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco315, 1, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 11, 9);
			raceAssertUtil.assertPilot(sco561, 0, 1, false, 11, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(sco528, 0, 4, 4);
			overallAssertUtil.assertPilot(sco808, 0, 5, 5);
			overallAssertUtil.assertPilot(sco156, 0, 6, 6);
			overallAssertUtil.assertPilot(sco296, 0, 7, 7);
			overallAssertUtil.assertPilot(sco315, 0, 8, 8);
			overallAssertUtil.assertPilot(sco018, 0, 11, 9);
			overallAssertUtil.assertPilot(sco561, 1, 12, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace11() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race11 = raceDAO.find(event2, RACE11_NAME);

			Scores scores = scorer.scoreRace(race11, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race11));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race11);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco069, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco156, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco179, 5, 1, false, 6, 6);
			raceAssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco315, 1, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 11, 9);
			raceAssertUtil.assertPilot(sco561, 0, 0, false, 11, 9);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco069, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(sco528, 0, 4, 4);
			overallAssertUtil.assertPilot(sco156, 0, 5, 5);
			overallAssertUtil.assertPilot(sco179, 1, 7, 6);
			overallAssertUtil.assertPilot(sco296, 0, 7, 7);
			overallAssertUtil.assertPilot(sco315, 0, 8, 8);
			overallAssertUtil.assertPilot(sco018, 0, 11, 9);
			overallAssertUtil.assertPilot(sco561, 0, 11, 9);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}