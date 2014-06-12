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
package org.spka.cursus.test.series_2013;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicates;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.scoring.data.Scores;
import eu.lp0.cursus.test.util.OverallAssertUtil;
import eu.lp0.cursus.test.util.RaceAssertUtil;

/**
 * Scores at the end of event 4 (22/02/2014)
 */
public class Series2013Event4Scores extends Series2013Event3Scores {
	@Override
	@Before
	public void createData() throws Exception {
		super.createData();
		createEvent4Races();
	}

	@Override
	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, event4), Predicates.in(getSeriesResultsPilots(series, event4)));
			checkSeriesAtEvent4(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkSeriesAtEvent4() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			List<Race> races = new ArrayList<Race>();
			races.addAll(event1.getRaces());
			races.addAll(event2.getRaces());
			races.addAll(event3.getRaces());
			races.addAll(event4.getRaces());

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, event4), getSeriesResultsEvents(series, event4),
					Predicates.in(getSeriesResultsPilots(series, event4)));
			checkSeriesAtEvent4(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	private void checkSeriesAtEvent4(Scores scores) throws Exception {
		Series series = seriesDAO.find(SERIES_NAME);
		Event event1 = eventDAO.find(series, EVENT1_NAME);
		Race race1 = raceDAO.find(event1, RACE1_NAME);
		Race race2 = raceDAO.find(event1, RACE2_NAME);
		Race race3 = raceDAO.find(event1, RACE3_NAME);
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race4 = raceDAO.find(event2, RACE4_NAME);
		Race race5 = raceDAO.find(event2, RACE5_NAME);
		Event event3 = eventDAO.find(series, EVENT3_NAME);
		Race race6 = raceDAO.find(event3, RACE6_NAME);
		Event event4 = eventDAO.find(series, EVENT4_NAME);
		Race race7 = raceDAO.find(event4, RACE7_NAME);
		Race race8 = raceDAO.find(event4, RACE8_NAME);
		Race race9 = raceDAO.find(event4, RACE9_NAME);
		Race race10 = raceDAO.find(event4, RACE10_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT4, scores.getPilots().size());
		Assert.assertEquals(RACE1_PILOTS, scores.getFleetSize(race1));
		Assert.assertEquals(RACE2_PILOTS, scores.getFleetSize(race2));
		Assert.assertEquals(RACE3_PILOTS, scores.getFleetSize(race3));
		Assert.assertEquals(RACE4_PILOTS, scores.getFleetSize(race4));
		Assert.assertEquals(RACE5_PILOTS, scores.getFleetSize(race5));
		Assert.assertEquals(RACE6_PILOTS, scores.getFleetSize(race6));
		Assert.assertEquals(RACE7_PILOTS, scores.getFleetSize(race7));
		Assert.assertEquals(RACE8_PILOTS, scores.getFleetSize(race8));
		Assert.assertEquals(RACE9_PILOTS, scores.getFleetSize(race9));
		Assert.assertEquals(RACE10_PILOTS, scores.getFleetSize(race10));

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco069, 8, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco116, 8, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco018, 6, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco808, 5, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
		race1AssertUtil.assertPilot(sco156, 4, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco066, 3, 0, false, 9, 9);
		race1AssertUtil.assertPilot(sco296, 2, 0, false, 10, 10);
		race1AssertUtil.assertPilot(sco561, 2, 0, false, 11, 11);
		race1AssertUtil.assertPilot(sco081, 0, 0, false, 18, 12);
		race1AssertUtil.assertPilot(sco117, 0, 0, false, 18, 12);
		race1AssertUtil.assertPilot(sco153, 0, 0, false, 18, 12);
		race1AssertUtil.assertPilot(sco315, 0, 0, false, 18, 12);
		race1AssertUtil.assertPilot(sco528, 0, 0, false, 18, 12);
		race1AssertUtil.assertPilot(sco666, 0, 0, false, 18, 12);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco069, 6, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco087, 5, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco018, 4, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco808, 4, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco156, 4, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco179, 3, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco066, 3, 0, false, 9, 9);
		race2AssertUtil.assertPilot(sco296, 1, 0, false, 10, 10);
		race2AssertUtil.assertPilot(sco561, 0, 0, false, 12, 11);
		race2AssertUtil.assertPilot(sco081, 0, 0, false, 18, 12);
		race2AssertUtil.assertPilot(sco117, 0, 0, false, 18, 12);
		race2AssertUtil.assertPilot(sco153, 0, 0, false, 18, 12);
		race2AssertUtil.assertPilot(sco315, 0, 0, false, 18, 12);
		race2AssertUtil.assertPilot(sco528, 0, 0, false, 18, 12);
		race2AssertUtil.assertPilot(sco666, 0, 0, false, 18, 12);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco069, 8, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco808, 8, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco116, 8, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco159, 6, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco087, 5, 0, false, 6, 6);
		race3AssertUtil.assertPilot(sco156, 4, 0, false, 7, 7);
		race3AssertUtil.assertPilot(sco066, 3, 0, false, 8, 8);
		race3AssertUtil.assertPilot(sco561, 1, 0, false, 9, 9);
		race3AssertUtil.assertPilot(sco018, 0, 0, false, 12, 10);
		race3AssertUtil.assertPilot(sco296, 0, 0, false, 12, 10);
		race3AssertUtil.assertPilot(sco081, 0, 0, false, 18, 12);
		race3AssertUtil.assertPilot(sco117, 0, 0, false, 18, 12);
		race3AssertUtil.assertPilot(sco153, 0, 0, false, 18, 12);
		race3AssertUtil.assertPilot(sco315, 0, 0, false, 18, 12);
		race3AssertUtil.assertPilot(sco528, 0, 0, false, 18, 12);
		race3AssertUtil.assertPilot(sco666, 0, 0, false, 18, 12);
		race3AssertUtil.assertDone(0);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco116, 11, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco069, 11, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco159, 10, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco808, 10, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco156, 8, 0, false, 5, 5);
		race4AssertUtil.assertPilot(sco087, 8, 0, false, 6, 6);
		race4AssertUtil.assertPilot(sco117, 7, 0, false, 7, 7);
		race4AssertUtil.assertPilot(sco296, 5, 0, false, 8, 8);
		race4AssertUtil.assertPilot(sco066, 2, 0, false, 9, 9);
		race4AssertUtil.assertPilot(sco561, 0, 0, false, 11, 10);
		race4AssertUtil.assertPilot(sco018, 0, 0, false, 18, 11);
		race4AssertUtil.assertPilot(sco081, 0, 0, false, 18, 11);
		race4AssertUtil.assertPilot(sco153, 0, 0, false, 18, 11);
		race4AssertUtil.assertPilot(sco179, 0, 0, false, 18, 11);
		race4AssertUtil.assertPilot(sco315, 0, 0, false, 18, 11);
		race4AssertUtil.assertPilot(sco528, 0, 0, false, 18, 11);
		race4AssertUtil.assertPilot(sco666, 0, 0, false, 18, 11);
		race4AssertUtil.assertDone(0);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco069, 9, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco159, 8, 0, false, 3, 3);
		race5AssertUtil.assertPilot(sco087, 7, 0, false, 4, 4);
		race5AssertUtil.assertPilot(sco156, 7, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco117, 6, 0, false, 6, 6);
		race5AssertUtil.assertPilot(sco296, 4, 0, false, 7, 7);
		race5AssertUtil.assertPilot(sco808, 3, 0, false, 8, 8);
		race5AssertUtil.assertPilot(sco066, 3, 0, false, 9, 9);
		race5AssertUtil.assertPilot(sco561, 0, 0, false, 11, 10);
		race5AssertUtil.assertPilot(sco018, 0, 0, false, 18, 11);
		race5AssertUtil.assertPilot(sco081, 0, 0, false, 18, 11);
		race5AssertUtil.assertPilot(sco153, 0, 0, false, 18, 11);
		race5AssertUtil.assertPilot(sco179, 0, 0, false, 18, 11);
		race5AssertUtil.assertPilot(sco315, 0, 0, false, 18, 11);
		race5AssertUtil.assertPilot(sco528, 0, 0, false, 18, 11);
		race5AssertUtil.assertPilot(sco666, 0, 0, false, 18, 11);
		race5AssertUtil.assertDone(0);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco069, 4, 0, false, 0, 1);
		race6AssertUtil.assertPilot(sco179, 3, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco159, 3, 0, false, 3, 3);
		race6AssertUtil.assertPilot(sco117, 2, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco018, 2, 0, false, 5, 5);
		race6AssertUtil.assertPilot(sco116, 2, 1, false, 6, 6);
		race6AssertUtil.assertPilot(sco808, 2, 0, false, 7, 7);
		race6AssertUtil.assertPilot(sco156, 1, 0, false, 8, 8);
		race6AssertUtil.assertPilot(sco666, 1, 0, false, 9, 9);
		race6AssertUtil.assertPilot(sco153, 0, 0, false, 12, 10);
		race6AssertUtil.assertPilot(sco296, 0, 0, false, 12, 10);
		race6AssertUtil.assertPilot(sco066, 0, 0, false, 18, 12);
		race6AssertUtil.assertPilot(sco081, 0, 0, false, 18, 12);
		race6AssertUtil.assertPilot(sco087, 0, 0, false, 18, 12);
		race6AssertUtil.assertPilot(sco315, 0, 0, false, 18, 12);
		race6AssertUtil.assertPilot(sco528, 0, 0, false, 18, 12);
		race6AssertUtil.assertPilot(sco561, 0, 0, false, 18, 12);
		race6AssertUtil.assertDone(0);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
		race7AssertUtil.assertPilot(sco069, 10, 0, false, 0, 1);
		race7AssertUtil.assertPilot(sco116, 10, 1, false, 2, 2);
		race7AssertUtil.assertPilot(sco528, 10, 0, false, 3, 3);
		race7AssertUtil.assertPilot(sco808, 9, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco018, 9, 0, false, 5, 5);
		race7AssertUtil.assertPilot(sco159, 8, 0, false, 6, 6);
		race7AssertUtil.assertPilot(sco179, 6, 0, false, 7, 7);
		race7AssertUtil.assertPilot(sco296, 5, 0, false, 8, 8);
		race7AssertUtil.assertPilot(sco117, 4, 0, false, 9, 9);
		race7AssertUtil.assertPilot(sco081, 1, 0, false, 10, 10);
		race7AssertUtil.assertPilot(sco561, 1, 0, false, 11, 11);
		race7AssertUtil.assertPilot(sco153, 0, 0, false, 14, 12);
		race7AssertUtil.assertPilot(sco315, 0, 0, false, 14, 12);
		race7AssertUtil.assertPilot(sco066, 0, 0, false, 18, 14);
		race7AssertUtil.assertPilot(sco087, 0, 0, false, 18, 14);
		race7AssertUtil.assertPilot(sco156, 0, 0, false, 18, 14);
		race7AssertUtil.assertPilot(sco666, 0, 0, false, 18, 14);
		race7AssertUtil.assertDone(0);

		RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
		race8AssertUtil.assertPilot(sco069, 10, 0, false, 0, 1);
		race8AssertUtil.assertPilot(sco116, 10, 0, false, 2, 2);
		race8AssertUtil.assertPilot(sco528, 10, 0, false, 3, 3);
		race8AssertUtil.assertPilot(sco159, 8, 0, false, 4, 4);
		race8AssertUtil.assertPilot(sco808, 8, 0, false, 5, 5);
		race8AssertUtil.assertPilot(sco179, 7, 0, false, 6, 6);
		race8AssertUtil.assertPilot(sco117, 7, 0, false, 7, 7);
		race8AssertUtil.assertPilot(sco081, 6, 0, false, 8, 8);
		race8AssertUtil.assertPilot(sco296, 6, 0, false, 9, 9);
		race8AssertUtil.assertPilot(sco018, 5, 0, false, 10, 10);
		race8AssertUtil.assertPilot(sco561, 4, 0, false, 11, 11);
		race8AssertUtil.assertPilot(sco153, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco315, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco066, 0, 0, false, 18, 14);
		race8AssertUtil.assertPilot(sco087, 0, 0, false, 18, 14);
		race8AssertUtil.assertPilot(sco156, 0, 0, false, 18, 14);
		race8AssertUtil.assertPilot(sco666, 0, 0, false, 18, 14);
		race8AssertUtil.assertDone(0);

		RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
		race9AssertUtil.assertPilot(sco069, 11, 0, false, 0, 1);
		race9AssertUtil.assertPilot(sco808, 11, 0, false, 2, 2);
		race9AssertUtil.assertPilot(sco159, 11, 0, false, 3, 3);
		race9AssertUtil.assertPilot(sco116, 10, 0, false, 4, 4);
		race9AssertUtil.assertPilot(sco179, 10, 0, false, 5, 5);
		race9AssertUtil.assertPilot(sco018, 10, 0, false, 6, 6);
		race9AssertUtil.assertPilot(sco528, 10, 0, false, 7, 7);
		race9AssertUtil.assertPilot(sco117, 9, 0, false, 8, 8);
		race9AssertUtil.assertPilot(sco296, 7, 0, false, 9, 9);
		race9AssertUtil.assertPilot(sco561, 2, 0, false, 10, 10);
		race9AssertUtil.assertPilot(sco081, 1, 0, false, 11, 11);
		race9AssertUtil.assertPilot(sco153, 0, 0, false, 14, 12);
		race9AssertUtil.assertPilot(sco315, 0, 0, false, 14, 12);
		race9AssertUtil.assertPilot(sco066, 0, 0, false, 18, 14);
		race9AssertUtil.assertPilot(sco087, 0, 0, false, 18, 14);
		race9AssertUtil.assertPilot(sco156, 0, 0, false, 18, 14);
		race9AssertUtil.assertPilot(sco666, 0, 0, false, 18, 14);
		race9AssertUtil.assertDone(0);

		RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
		race10AssertUtil.assertPilot(sco069, 10, 0, false, 0, 1);
		race10AssertUtil.assertPilot(sco808, 10, 0, false, 2, 2);
		race10AssertUtil.assertPilot(sco159, 9, 0, false, 3, 3);
		race10AssertUtil.assertPilot(sco018, 9, 0, false, 4, 4);
		race10AssertUtil.assertPilot(sco528, 8, 0, false, 5, 5);
		race10AssertUtil.assertPilot(sco296, 6, 0, false, 6, 6);
		race10AssertUtil.assertPilot(sco117, 5, 1, false, 7, 7);
		race10AssertUtil.assertPilot(sco179, 3, 0, false, 8, 8);
		race10AssertUtil.assertPilot(sco116, 1, 0, false, 9, 9);
		race10AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
		race10AssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
		race10AssertUtil.assertPilot(sco315, 0, 0, false, 14, 10);
		race10AssertUtil.assertPilot(sco561, 0, 0, false, 14, 10);
		race10AssertUtil.assertPilot(sco066, 0, 0, false, 18, 14);
		race10AssertUtil.assertPilot(sco087, 0, 0, false, 18, 14);
		race10AssertUtil.assertPilot(sco156, 0, 0, false, 18, 14);
		race10AssertUtil.assertPilot(sco666, 0, 0, false, 18, 14);
		race10AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco069, 0, 0, 1, 2, 2);
		overallAssertUtil.assertPilot(sco116, 2, 17, 2, 9, 6);
		overallAssertUtil.assertPilot(sco159, 0, 26, 3, 6, 5);
		overallAssertUtil.assertPilot(sco808, 0, 31, 4, 8, 7);
		overallAssertUtil.assertPilot(sco179, 0, 43, 5, 18, 18);
		overallAssertUtil.assertPilot(sco018, 0, 52, 6, 18, 18);
		overallAssertUtil.assertPilot(sco117, 1, 67, 7, 18, 18);
		overallAssertUtil.assertPilot(sco296, 0, 67, 8, 12, 12);
		overallAssertUtil.assertPilot(sco156, 0, 76, 9, 18, 18);
		overallAssertUtil.assertPilot(sco087, 0, 81, 10, 18, 18);
		overallAssertUtil.assertPilot(sco561, 0, 86, 11, 18, 14);
		overallAssertUtil.assertPilot(sco528, 0, 90, 12, 18, 18);
		overallAssertUtil.assertPilot(sco066, 0, 98, 13, 18, 18);
		overallAssertUtil.assertPilot(sco081, 0, 115, 14, 18, 18);
		overallAssertUtil.assertPilot(sco153, 0, 122, 15, 18, 18);
		overallAssertUtil.assertPilot(sco315, 0, 128, 16, 18, 18);
		overallAssertUtil.assertPilot(sco666, 0, 135, 17, 18, 18);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent4() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race7 = raceDAO.find(event4, RACE7_NAME);
			Race race8 = raceDAO.find(event4, RACE8_NAME);
			Race race9 = raceDAO.find(event4, RACE9_NAME);
			Race race10 = raceDAO.find(event4, RACE10_NAME);

			Scores scores = scorer.scoreEvent(event4, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race7));
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race8));
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race9));
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race10));

			RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
			race7AssertUtil.assertPilot(sco069, 10, 0, false, 0, 1);
			race7AssertUtil.assertPilot(sco116, 10, 1, false, 2, 2);
			race7AssertUtil.assertPilot(sco528, 10, 0, false, 3, 3);
			race7AssertUtil.assertPilot(sco808, 9, 0, false, 4, 4);
			race7AssertUtil.assertPilot(sco018, 9, 0, false, 5, 5);
			race7AssertUtil.assertPilot(sco159, 8, 0, false, 6, 6);
			race7AssertUtil.assertPilot(sco179, 6, 0, false, 7, 7);
			race7AssertUtil.assertPilot(sco296, 5, 0, false, 8, 8);
			race7AssertUtil.assertPilot(sco117, 4, 0, false, 9, 9);
			race7AssertUtil.assertPilot(sco081, 1, 0, false, 10, 10);
			race7AssertUtil.assertPilot(sco561, 1, 0, false, 11, 11);
			race7AssertUtil.assertPilot(sco153, 0, 0, false, 14, 12);
			race7AssertUtil.assertPilot(sco315, 0, 0, false, 14, 12);
			race7AssertUtil.assertDone(0);

			RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
			race8AssertUtil.assertPilot(sco069, 10, 0, false, 0, 1);
			race8AssertUtil.assertPilot(sco116, 10, 0, false, 2, 2);
			race8AssertUtil.assertPilot(sco528, 10, 0, false, 3, 3);
			race8AssertUtil.assertPilot(sco159, 8, 0, false, 4, 4);
			race8AssertUtil.assertPilot(sco808, 8, 0, false, 5, 5);
			race8AssertUtil.assertPilot(sco179, 7, 0, false, 6, 6);
			race8AssertUtil.assertPilot(sco117, 7, 0, false, 7, 7);
			race8AssertUtil.assertPilot(sco081, 6, 0, false, 8, 8);
			race8AssertUtil.assertPilot(sco296, 6, 0, false, 9, 9);
			race8AssertUtil.assertPilot(sco018, 5, 0, false, 10, 10);
			race8AssertUtil.assertPilot(sco561, 4, 0, false, 11, 11);
			race8AssertUtil.assertPilot(sco153, 0, 0, false, 14, 12);
			race8AssertUtil.assertPilot(sco315, 0, 0, false, 14, 12);
			race8AssertUtil.assertDone(0);

			RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
			race9AssertUtil.assertPilot(sco069, 11, 0, false, 0, 1);
			race9AssertUtil.assertPilot(sco808, 11, 0, false, 2, 2);
			race9AssertUtil.assertPilot(sco159, 11, 0, false, 3, 3);
			race9AssertUtil.assertPilot(sco116, 10, 0, false, 4, 4);
			race9AssertUtil.assertPilot(sco179, 10, 0, false, 5, 5);
			race9AssertUtil.assertPilot(sco018, 10, 0, false, 6, 6);
			race9AssertUtil.assertPilot(sco528, 10, 0, false, 7, 7);
			race9AssertUtil.assertPilot(sco117, 9, 0, false, 8, 8);
			race9AssertUtil.assertPilot(sco296, 7, 0, false, 9, 9);
			race9AssertUtil.assertPilot(sco561, 2, 0, false, 10, 10);
			race9AssertUtil.assertPilot(sco081, 1, 0, false, 11, 11);
			race9AssertUtil.assertPilot(sco153, 0, 0, false, 14, 12);
			race9AssertUtil.assertPilot(sco315, 0, 0, false, 14, 12);
			race9AssertUtil.assertDone(0);

			RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
			race10AssertUtil.assertPilot(sco069, 10, 0, false, 0, 1);
			race10AssertUtil.assertPilot(sco808, 10, 0, false, 2, 2);
			race10AssertUtil.assertPilot(sco159, 9, 0, false, 3, 3);
			race10AssertUtil.assertPilot(sco018, 9, 0, false, 4, 4);
			race10AssertUtil.assertPilot(sco528, 8, 0, false, 5, 5);
			race10AssertUtil.assertPilot(sco296, 6, 0, false, 6, 6);
			race10AssertUtil.assertPilot(sco117, 5, 1, false, 7, 7);
			race10AssertUtil.assertPilot(sco179, 3, 0, false, 8, 8);
			race10AssertUtil.assertPilot(sco116, 1, 0, false, 9, 9);
			race10AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
			race10AssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
			race10AssertUtil.assertPilot(sco315, 0, 0, false, 14, 10);
			race10AssertUtil.assertPilot(sco561, 0, 0, false, 14, 10);
			race10AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1, 0);
			overallAssertUtil.assertPilot(sco808, 0, 8, 2, 5);
			overallAssertUtil.assertPilot(sco116, 1, 9, 3, 9);
			overallAssertUtil.assertPilot(sco159, 0, 10, 4, 6);
			overallAssertUtil.assertPilot(sco528, 0, 11, 5, 7);
			overallAssertUtil.assertPilot(sco018, 0, 15, 6, 10);
			overallAssertUtil.assertPilot(sco179, 0, 18, 7, 8);
			overallAssertUtil.assertPilot(sco296, 0, 23, 8, 9);
			overallAssertUtil.assertPilot(sco117, 1, 23, 9, 9);
			overallAssertUtil.assertPilot(sco081, 0, 29, 10, 14);
			overallAssertUtil.assertPilot(sco561, 0, 32, 11, 14);
			overallAssertUtil.assertPilot(sco153, 0, 42, 12, 14);
			overallAssertUtil.assertPilot(sco315, 0, 42, 12, 14);
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
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race7 = raceDAO.find(event4, RACE7_NAME);

			Scores scores = scorer.scoreRace(race7, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race7));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race7);
			raceAssertUtil.assertPilot(sco069, 10, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 10, 1, false, 2, 2);
			raceAssertUtil.assertPilot(sco528, 10, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco808, 9, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco018, 9, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco159, 8, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco296, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco081, 1, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco561, 1, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco153, 0, 0, false, 14, 12);
			raceAssertUtil.assertPilot(sco315, 0, 0, false, 14, 12);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 1, 3, 2);
			overallAssertUtil.assertPilot(sco528, 0, 3, 3);
			overallAssertUtil.assertPilot(sco808, 0, 4, 4);
			overallAssertUtil.assertPilot(sco018, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(sco179, 0, 7, 7);
			overallAssertUtil.assertPilot(sco296, 0, 8, 8);
			overallAssertUtil.assertPilot(sco117, 0, 9, 9);
			overallAssertUtil.assertPilot(sco081, 0, 10, 10);
			overallAssertUtil.assertPilot(sco561, 0, 11, 11);
			overallAssertUtil.assertPilot(sco153, 0, 14, 12);
			overallAssertUtil.assertPilot(sco315, 0, 14, 12);
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
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race8 = raceDAO.find(event4, RACE8_NAME);

			Scores scores = scorer.scoreRace(race8, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race8));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race8);
			raceAssertUtil.assertPilot(sco069, 10, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 10, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco528, 10, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 8, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco808, 8, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco179, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco117, 7, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco081, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco296, 6, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco018, 5, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco561, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco153, 0, 0, false, 14, 12);
			raceAssertUtil.assertPilot(sco315, 0, 0, false, 14, 12);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco528, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco808, 0, 5, 5);
			overallAssertUtil.assertPilot(sco179, 0, 6, 6);
			overallAssertUtil.assertPilot(sco117, 0, 7, 7);
			overallAssertUtil.assertPilot(sco081, 0, 8, 8);
			overallAssertUtil.assertPilot(sco296, 0, 9, 9);
			overallAssertUtil.assertPilot(sco018, 0, 10, 10);
			overallAssertUtil.assertPilot(sco561, 0, 11, 11);
			overallAssertUtil.assertPilot(sco153, 0, 14, 12);
			overallAssertUtil.assertPilot(sco315, 0, 14, 12);
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
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race9 = raceDAO.find(event4, RACE9_NAME);

			Scores scores = scorer.scoreRace(race9, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race9));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race9);
			raceAssertUtil.assertPilot(sco069, 11, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 11, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 11, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco116, 10, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco179, 10, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco018, 10, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco528, 10, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco117, 9, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco296, 7, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco561, 2, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco081, 1, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco153, 0, 0, false, 14, 12);
			raceAssertUtil.assertPilot(sco315, 0, 0, false, 14, 12);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco116, 0, 4, 4);
			overallAssertUtil.assertPilot(sco179, 0, 5, 5);
			overallAssertUtil.assertPilot(sco018, 0, 6, 6);
			overallAssertUtil.assertPilot(sco528, 0, 7, 7);
			overallAssertUtil.assertPilot(sco117, 0, 8, 8);
			overallAssertUtil.assertPilot(sco296, 0, 9, 9);
			overallAssertUtil.assertPilot(sco561, 0, 10, 10);
			overallAssertUtil.assertPilot(sco081, 0, 11, 11);
			overallAssertUtil.assertPilot(sco153, 0, 14, 12);
			overallAssertUtil.assertPilot(sco315, 0, 14, 12);
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
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race10 = raceDAO.find(event4, RACE10_NAME);

			Scores scores = scorer.scoreRace(race10, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race10));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race10);
			raceAssertUtil.assertPilot(sco069, 10, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 10, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 9, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco018, 9, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco528, 8, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco296, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco117, 5, 1, false, 7, 7);
			raceAssertUtil.assertPilot(sco179, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco116, 1, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
			raceAssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
			raceAssertUtil.assertPilot(sco315, 0, 0, false, 14, 10);
			raceAssertUtil.assertPilot(sco561, 0, 0, false, 14, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco018, 0, 4, 4);
			overallAssertUtil.assertPilot(sco528, 0, 5, 5);
			overallAssertUtil.assertPilot(sco296, 0, 6, 6);
			overallAssertUtil.assertPilot(sco117, 1, 8, 7);
			overallAssertUtil.assertPilot(sco179, 0, 8, 8);
			overallAssertUtil.assertPilot(sco116, 0, 9, 9);
			overallAssertUtil.assertPilot(sco081, 0, 14, 10);
			overallAssertUtil.assertPilot(sco153, 0, 14, 10);
			overallAssertUtil.assertPilot(sco315, 0, 14, 10);
			overallAssertUtil.assertPilot(sco561, 0, 14, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}