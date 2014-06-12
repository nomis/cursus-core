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
 * Scores at the end of event 5 (22/03/2014 to 23/03/2014)
 */
public class Series2013Event5Scores extends Series2013Event4Scores {
	@Override
	@Before
	public void createData() throws Exception {
		super.createData();
		createEvent5Races();
	}

	@Override
	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, event5), Predicates.in(getSeriesResultsPilots(series, event5)));
			checkSeriesAtEvent5(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkSeriesAtEvent5() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);

			List<Race> races = new ArrayList<Race>();
			races.addAll(event1.getRaces());
			races.addAll(event2.getRaces());
			races.addAll(event3.getRaces());
			races.addAll(event4.getRaces());
			races.addAll(event5.getRaces());

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, event5), getSeriesResultsEvents(series, event5),
					Predicates.in(getSeriesResultsPilots(series, event5)));
			checkSeriesAtEvent5(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	private void checkSeriesAtEvent5(Scores scores) throws Exception {
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
		Event event5 = eventDAO.find(series, EVENT5_NAME);
		Race race11 = raceDAO.find(event5, RACE11_NAME);
		Race race12 = raceDAO.find(event5, RACE12_NAME);
		Race race13 = raceDAO.find(event5, RACE13_NAME);
		Race race14 = raceDAO.find(event5, RACE14_NAME);
		Race race15 = raceDAO.find(event5, RACE15_NAME);
		Race race16 = raceDAO.find(event5, RACE16_NAME);
		Race race17 = raceDAO.find(event5, RACE17_NAME);
		Race race18 = raceDAO.find(event5, RACE18_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT5, scores.getPilots().size());
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
		Assert.assertEquals(RACE11_PILOTS, scores.getFleetSize(race11));
		Assert.assertEquals(RACE12_PILOTS, scores.getFleetSize(race12));
		Assert.assertEquals(RACE13_PILOTS, scores.getFleetSize(race13));
		Assert.assertEquals(RACE14_PILOTS, scores.getFleetSize(race14));
		Assert.assertEquals(RACE15_PILOTS, scores.getFleetSize(race15));
		Assert.assertEquals(RACE16_PILOTS, scores.getFleetSize(race16));
		Assert.assertEquals(RACE17_PILOTS, scores.getFleetSize(race17));
		Assert.assertEquals(RACE18_PILOTS, scores.getFleetSize(race18));

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
		race1AssertUtil.assertPilot(sco081, 0, 0, false, 19, 12);
		race1AssertUtil.assertPilot(sco117, 0, 0, false, 19, 12);
		race1AssertUtil.assertPilot(sco153, 0, 0, false, 19, 12);
		race1AssertUtil.assertPilot(sco249, 0, 0, false, 19, 12);
		race1AssertUtil.assertPilot(sco315, 0, 0, false, 19, 12);
		race1AssertUtil.assertPilot(sco528, 0, 0, false, 19, 12);
		race1AssertUtil.assertPilot(sco666, 0, 0, false, 19, 12);
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
		race2AssertUtil.assertPilot(sco081, 0, 0, false, 19, 12);
		race2AssertUtil.assertPilot(sco117, 0, 0, false, 19, 12);
		race2AssertUtil.assertPilot(sco153, 0, 0, false, 19, 12);
		race2AssertUtil.assertPilot(sco249, 0, 0, false, 19, 12);
		race2AssertUtil.assertPilot(sco315, 0, 0, false, 19, 12);
		race2AssertUtil.assertPilot(sco528, 0, 0, false, 19, 12);
		race2AssertUtil.assertPilot(sco666, 0, 0, false, 19, 12);
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
		race3AssertUtil.assertPilot(sco081, 0, 0, false, 19, 12);
		race3AssertUtil.assertPilot(sco117, 0, 0, false, 19, 12);
		race3AssertUtil.assertPilot(sco153, 0, 0, false, 19, 12);
		race3AssertUtil.assertPilot(sco249, 0, 0, false, 19, 12);
		race3AssertUtil.assertPilot(sco315, 0, 0, false, 19, 12);
		race3AssertUtil.assertPilot(sco528, 0, 0, false, 19, 12);
		race3AssertUtil.assertPilot(sco666, 0, 0, false, 19, 12);
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
		race4AssertUtil.assertPilot(sco018, 0, 0, false, 19, 11);
		race4AssertUtil.assertPilot(sco081, 0, 0, false, 19, 11);
		race4AssertUtil.assertPilot(sco153, 0, 0, false, 19, 11);
		race4AssertUtil.assertPilot(sco179, 0, 0, false, 19, 11);
		race4AssertUtil.assertPilot(sco249, 0, 0, false, 19, 11);
		race4AssertUtil.assertPilot(sco315, 0, 0, false, 19, 11);
		race4AssertUtil.assertPilot(sco528, 0, 0, false, 19, 11);
		race4AssertUtil.assertPilot(sco666, 0, 0, false, 19, 11);
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
		race5AssertUtil.assertPilot(sco018, 0, 0, false, 19, 11);
		race5AssertUtil.assertPilot(sco081, 0, 0, false, 19, 11);
		race5AssertUtil.assertPilot(sco153, 0, 0, false, 19, 11);
		race5AssertUtil.assertPilot(sco179, 0, 0, false, 19, 11);
		race5AssertUtil.assertPilot(sco249, 0, 0, false, 19, 11);
		race5AssertUtil.assertPilot(sco315, 0, 0, false, 19, 11);
		race5AssertUtil.assertPilot(sco528, 0, 0, false, 19, 11);
		race5AssertUtil.assertPilot(sco666, 0, 0, false, 19, 11);
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
		race6AssertUtil.assertPilot(sco066, 0, 0, false, 19, 12);
		race6AssertUtil.assertPilot(sco081, 0, 0, false, 19, 12);
		race6AssertUtil.assertPilot(sco087, 0, 0, false, 19, 12);
		race6AssertUtil.assertPilot(sco249, 0, 0, false, 19, 12);
		race6AssertUtil.assertPilot(sco315, 0, 0, false, 19, 12);
		race6AssertUtil.assertPilot(sco528, 0, 0, false, 19, 12);
		race6AssertUtil.assertPilot(sco561, 0, 0, false, 19, 12);
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
		race7AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race7AssertUtil.assertPilot(sco087, 0, 0, false, 19, 14);
		race7AssertUtil.assertPilot(sco156, 0, 0, false, 19, 14);
		race7AssertUtil.assertPilot(sco249, 0, 0, false, 19, 14);
		race7AssertUtil.assertPilot(sco666, 0, 0, false, 19, 14);
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
		race8AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race8AssertUtil.assertPilot(sco087, 0, 0, false, 19, 14);
		race8AssertUtil.assertPilot(sco156, 0, 0, false, 19, 14);
		race8AssertUtil.assertPilot(sco249, 0, 0, false, 19, 14);
		race8AssertUtil.assertPilot(sco666, 0, 0, false, 19, 14);
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
		race9AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race9AssertUtil.assertPilot(sco087, 0, 0, false, 19, 14);
		race9AssertUtil.assertPilot(sco156, 0, 0, false, 19, 14);
		race9AssertUtil.assertPilot(sco249, 0, 0, false, 19, 14);
		race9AssertUtil.assertPilot(sco666, 0, 0, false, 19, 14);
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
		race10AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race10AssertUtil.assertPilot(sco087, 0, 0, false, 19, 14);
		race10AssertUtil.assertPilot(sco156, 0, 0, false, 19, 14);
		race10AssertUtil.assertPilot(sco249, 0, 0, false, 19, 14);
		race10AssertUtil.assertPilot(sco666, 0, 0, false, 19, 14);
		race10AssertUtil.assertDone(0);

		RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
		race11AssertUtil.assertPilot(sco808, 5, 0, false, 0, 1);
		race11AssertUtil.assertPilot(sco069, 5, 0, false, 2, 2);
		race11AssertUtil.assertPilot(sco116, 5, 0, false, 3, 3);
		race11AssertUtil.assertPilot(sco528, 5, 0, false, 4, 4);
		race11AssertUtil.assertPilot(sco159, 5, 0, false, 5, 5);
		race11AssertUtil.assertPilot(sco666, 5, 0, false, 6, 6);
		race11AssertUtil.assertPilot(sco018, 4, 0, false, 7, 7);
		race11AssertUtil.assertPilot(sco117, 4, 0, false, 8, 8);
		race11AssertUtil.assertPilot(sco087, 4, 0, false, 9, 9);
		race11AssertUtil.assertPilot(sco156, 3, 0, false, 10, 10);
		race11AssertUtil.assertPilot(sco081, 2, 0, false, 11, 11);
		race11AssertUtil.assertPilot(sco249, 0, 0, false, 14, 12);
		race11AssertUtil.assertPilot(sco296, 0, 0, false, 14, 12);
		race11AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race11AssertUtil.assertPilot(sco153, 0, 0, false, 19, 14);
		race11AssertUtil.assertPilot(sco179, 0, 0, false, 19, 14);
		race11AssertUtil.assertPilot(sco315, 0, 0, false, 19, 14);
		race11AssertUtil.assertPilot(sco561, 0, 0, false, 19, 14);
		race11AssertUtil.assertDone(0);

		RaceAssertUtil race12AssertUtil = new RaceAssertUtil(scores, race12);
		race12AssertUtil.assertPilot(sco116, 5, 0, false, 2, 1);
		race12AssertUtil.assertPilot(sco069, 5, 3, false, 0, 2);
		race12AssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
		race12AssertUtil.assertPilot(sco528, 5, 0, false, 4, 4);
		race12AssertUtil.assertPilot(sco159, 5, 0, false, 5, 5);
		race12AssertUtil.assertPilot(sco018, 5, 0, false, 6, 6);
		race12AssertUtil.assertPilot(sco666, 4, 0, false, 7, 7);
		race12AssertUtil.assertPilot(sco081, 4, 0, false, 8, 8);
		race12AssertUtil.assertPilot(sco117, 4, 0, false, 9, 9);
		race12AssertUtil.assertPilot(sco087, 4, 0, false, 10, 10);
		race12AssertUtil.assertPilot(sco156, 3, 0, false, 11, 11);
		race12AssertUtil.assertPilot(sco249, 0, 0, false, 14, 12);
		race12AssertUtil.assertPilot(sco296, 0, 0, false, 14, 12);
		race12AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race12AssertUtil.assertPilot(sco153, 0, 0, false, 19, 14);
		race12AssertUtil.assertPilot(sco179, 0, 0, false, 19, 14);
		race12AssertUtil.assertPilot(sco315, 0, 0, false, 19, 14);
		race12AssertUtil.assertPilot(sco561, 0, 0, false, 19, 14);
		race12AssertUtil.assertDone(0);

		RaceAssertUtil race13AssertUtil = new RaceAssertUtil(scores, race13);
		race13AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race13AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race13AssertUtil.assertPilot(sco069, 6, 0, false, 3, 3);
		race13AssertUtil.assertPilot(sco528, 5, 1, false, 4, 4);
		race13AssertUtil.assertPilot(sco081, 5, 0, false, 5, 5);
		race13AssertUtil.assertPilot(sco666, 5, 0, false, 7, 6);
		race13AssertUtil.assertPilot(sco018, 5, 0, false, 8, 7);
		race13AssertUtil.assertPilot(sco159, 5, 3, false, 6, 8);
		race13AssertUtil.assertPilot(sco117, 4, 0, false, 9, 9);
		race13AssertUtil.assertPilot(sco087, 4, 0, false, 10, 10);
		race13AssertUtil.assertPilot(sco156, 3, 0, false, 11, 11);
		race13AssertUtil.assertPilot(sco296, 3, 0, false, 12, 12);
		race13AssertUtil.assertPilot(sco249, 0, 0, false, 14, 13);
		race13AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race13AssertUtil.assertPilot(sco153, 0, 0, false, 19, 14);
		race13AssertUtil.assertPilot(sco179, 0, 0, false, 19, 14);
		race13AssertUtil.assertPilot(sco315, 0, 0, false, 19, 14);
		race13AssertUtil.assertPilot(sco561, 0, 0, false, 19, 14);
		race13AssertUtil.assertDone(0);

		RaceAssertUtil race14AssertUtil = new RaceAssertUtil(scores, race14);
		race14AssertUtil.assertPilot(sco528, 11, 0, false, 0, 1);
		race14AssertUtil.assertPilot(sco666, 11, 0, false, 2, 2);
		race14AssertUtil.assertPilot(sco081, 11, 0, false, 3, 3);
		race14AssertUtil.assertPilot(sco069, 11, 0, false, 4, 4);
		race14AssertUtil.assertPilot(sco159, 11, 0, false, 5, 5);
		race14AssertUtil.assertPilot(sco117, 10, 0, false, 6, 6);
		race14AssertUtil.assertPilot(sco087, 9, 0, false, 7, 7);
		race14AssertUtil.assertPilot(sco808, 8, 0, false, 8, 8);
		race14AssertUtil.assertPilot(sco156, 8, 0, false, 9, 9);
		race14AssertUtil.assertPilot(sco296, 7, 0, false, 10, 10);
		race14AssertUtil.assertPilot(sco018, 2, 0, false, 11, 11);
		race14AssertUtil.assertPilot(sco116, 0, 0, false, 14, 12);
		race14AssertUtil.assertPilot(sco249, 0, 0, false, 14, 12);
		race14AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race14AssertUtil.assertPilot(sco153, 0, 0, false, 19, 14);
		race14AssertUtil.assertPilot(sco179, 0, 0, false, 19, 14);
		race14AssertUtil.assertPilot(sco315, 0, 0, false, 19, 14);
		race14AssertUtil.assertPilot(sco561, 0, 0, false, 19, 14);
		race14AssertUtil.assertDone(0);

		RaceAssertUtil race15AssertUtil = new RaceAssertUtil(scores, race15);
		race15AssertUtil.assertPilot(sco069, 4, 0, false, 0, 1);
		race15AssertUtil.assertPilot(sco808, 4, 0, false, 2, 2);
		race15AssertUtil.assertPilot(sco528, 4, 0, false, 3, 3);
		race15AssertUtil.assertPilot(sco116, 4, 0, false, 4, 4);
		race15AssertUtil.assertPilot(sco666, 3, 0, false, 5, 5);
		race15AssertUtil.assertPilot(sco117, 3, 0, false, 6, 6);
		race15AssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
		race15AssertUtil.assertPilot(sco018, 0, 0, false, 14, 8);
		race15AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
		race15AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race15AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race15AssertUtil.assertPilot(sco249, 0, 0, false, 14, 8);
		race15AssertUtil.assertPilot(sco087, 0, 1, false, 14, 13);
		race15AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race15AssertUtil.assertPilot(sco153, 0, 0, false, 19, 14);
		race15AssertUtil.assertPilot(sco179, 0, 0, false, 19, 14);
		race15AssertUtil.assertPilot(sco315, 0, 0, false, 19, 14);
		race15AssertUtil.assertPilot(sco561, 0, 0, false, 19, 14);
		race15AssertUtil.assertDone(0);

		RaceAssertUtil race16AssertUtil = new RaceAssertUtil(scores, race16);
		race16AssertUtil.assertPilot(sco069, 5, 0, false, 0, 1);
		race16AssertUtil.assertPilot(sco528, 5, 0, false, 2, 2);
		race16AssertUtil.assertPilot(sco666, 5, 0, false, 3, 3);
		race16AssertUtil.assertPilot(sco116, 5, 0, false, 4, 4);
		race16AssertUtil.assertPilot(sco808, 5, 0, false, 5, 5);
		race16AssertUtil.assertPilot(sco117, 4, 0, false, 6, 6);
		race16AssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
		race16AssertUtil.assertPilot(sco018, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco249, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco296, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race16AssertUtil.assertPilot(sco153, 0, 0, false, 19, 14);
		race16AssertUtil.assertPilot(sco179, 0, 0, false, 19, 14);
		race16AssertUtil.assertPilot(sco315, 0, 0, false, 19, 14);
		race16AssertUtil.assertPilot(sco561, 0, 0, false, 19, 14);
		race16AssertUtil.assertDone(0);

		RaceAssertUtil race17AssertUtil = new RaceAssertUtil(scores, race17);
		race17AssertUtil.assertPilot(sco116, 4, 0, false, 0, 1);
		race17AssertUtil.assertPilot(sco808, 4, 0, false, 2, 2);
		race17AssertUtil.assertPilot(sco528, 4, 0, false, 3, 3);
		race17AssertUtil.assertPilot(sco666, 4, 0, false, 4, 4);
		race17AssertUtil.assertPilot(sco117, 3, 0, false, 5, 5);
		race17AssertUtil.assertPilot(sco087, 2, 0, false, 6, 6);
		race17AssertUtil.assertPilot(sco069, 2, 0, false, 7, 7);
		race17AssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
		race17AssertUtil.assertPilot(sco018, 0, 0, false, 14, 9);
		race17AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race17AssertUtil.assertPilot(sco156, 0, 0, false, 14, 9);
		race17AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race17AssertUtil.assertPilot(sco249, 0, 0, false, 14, 9);
		race17AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race17AssertUtil.assertPilot(sco153, 0, 0, false, 19, 14);
		race17AssertUtil.assertPilot(sco179, 0, 0, false, 19, 14);
		race17AssertUtil.assertPilot(sco315, 0, 0, false, 19, 14);
		race17AssertUtil.assertPilot(sco561, 0, 0, false, 19, 14);
		race17AssertUtil.assertDone(0);

		RaceAssertUtil race18AssertUtil = new RaceAssertUtil(scores, race18);
		race18AssertUtil.assertPilot(sco069, 5, 0, false, 0, 1);
		race18AssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
		race18AssertUtil.assertPilot(sco528, 5, 0, false, 3, 3);
		race18AssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
		race18AssertUtil.assertPilot(sco666, 5, 0, false, 5, 5);
		race18AssertUtil.assertPilot(sco117, 4, 0, false, 6, 6);
		race18AssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
		race18AssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
		race18AssertUtil.assertPilot(sco018, 0, 0, false, 14, 9);
		race18AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race18AssertUtil.assertPilot(sco156, 0, 0, false, 14, 9);
		race18AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race18AssertUtil.assertPilot(sco249, 0, 0, false, 14, 9);
		race18AssertUtil.assertPilot(sco066, 0, 0, false, 19, 14);
		race18AssertUtil.assertPilot(sco153, 0, 0, false, 19, 14);
		race18AssertUtil.assertPilot(sco179, 0, 0, false, 19, 14);
		race18AssertUtil.assertPilot(sco315, 0, 0, false, 19, 14);
		race18AssertUtil.assertPilot(sco561, 0, 0, false, 19, 14);
		race18AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco069, 3, 7, 1, 7, 4, 3, 2);
		overallAssertUtil.assertPilot(sco116, 2, 28, 2, 14, 9, 6, 4);
		overallAssertUtil.assertPilot(sco808, 0, 43, 3, 8, 8, 7, 6);
		overallAssertUtil.assertPilot(sco159, 3, 61, 4, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco528, 1, 80, 5, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco117, 1, 95, 6, 19, 19, 19, 9);
		overallAssertUtil.assertPilot(sco018, 0, 112, 7, 19, 19, 14, 14);
		overallAssertUtil.assertPilot(sco087, 1, 117, 8, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco296, 0, 124, 9, 14, 14, 14, 12);
		overallAssertUtil.assertPilot(sco156, 0, 137, 10, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco666, 0, 143, 11, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco179, 0, 157, 12, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco081, 0, 164, 13, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco561, 0, 195, 14, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco066, 0, 215, 15, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco249, 0, 226, 16, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco153, 0, 239, 17, 19, 19, 19, 19);
		overallAssertUtil.assertPilot(sco315, 0, 246, 18, 19, 19, 19, 19);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent5() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race11 = raceDAO.find(event5, RACE11_NAME);
			Race race12 = raceDAO.find(event5, RACE12_NAME);
			Race race13 = raceDAO.find(event5, RACE13_NAME);
			Race race14 = raceDAO.find(event5, RACE14_NAME);
			Race race15 = raceDAO.find(event5, RACE15_NAME);
			Race race16 = raceDAO.find(event5, RACE16_NAME);
			Race race17 = raceDAO.find(event5, RACE17_NAME);
			Race race18 = raceDAO.find(event5, RACE18_NAME);

			Scores scores = scorer.scoreEvent(event5, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race11));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race12));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race13));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race14));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race15));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race16));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race17));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race18));

			RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
			race11AssertUtil.assertPilot(sco808, 5, 0, false, 0, 1);
			race11AssertUtil.assertPilot(sco069, 5, 0, false, 2, 2);
			race11AssertUtil.assertPilot(sco116, 5, 0, false, 3, 3);
			race11AssertUtil.assertPilot(sco528, 5, 0, false, 4, 4);
			race11AssertUtil.assertPilot(sco159, 5, 0, false, 5, 5);
			race11AssertUtil.assertPilot(sco666, 5, 0, false, 6, 6);
			race11AssertUtil.assertPilot(sco018, 4, 0, false, 7, 7);
			race11AssertUtil.assertPilot(sco117, 4, 0, false, 8, 8);
			race11AssertUtil.assertPilot(sco087, 4, 0, false, 9, 9);
			race11AssertUtil.assertPilot(sco156, 3, 0, false, 10, 10);
			race11AssertUtil.assertPilot(sco081, 2, 0, false, 11, 11);
			race11AssertUtil.assertPilot(sco249, 0, 0, false, 14, 12);
			race11AssertUtil.assertPilot(sco296, 0, 0, false, 14, 12);
			race11AssertUtil.assertDone(0);

			RaceAssertUtil race12AssertUtil = new RaceAssertUtil(scores, race12);
			race12AssertUtil.assertPilot(sco116, 5, 0, false, 2, 1);
			race12AssertUtil.assertPilot(sco069, 5, 3, false, 0, 2);
			race12AssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
			race12AssertUtil.assertPilot(sco528, 5, 0, false, 4, 4);
			race12AssertUtil.assertPilot(sco159, 5, 0, false, 5, 5);
			race12AssertUtil.assertPilot(sco018, 5, 0, false, 6, 6);
			race12AssertUtil.assertPilot(sco666, 4, 0, false, 7, 7);
			race12AssertUtil.assertPilot(sco081, 4, 0, false, 8, 8);
			race12AssertUtil.assertPilot(sco117, 4, 0, false, 9, 9);
			race12AssertUtil.assertPilot(sco087, 4, 0, false, 10, 10);
			race12AssertUtil.assertPilot(sco156, 3, 0, false, 11, 11);
			race12AssertUtil.assertPilot(sco249, 0, 0, false, 14, 12);
			race12AssertUtil.assertPilot(sco296, 0, 0, false, 14, 12);
			race12AssertUtil.assertDone(0);

			RaceAssertUtil race13AssertUtil = new RaceAssertUtil(scores, race13);
			race13AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			race13AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
			race13AssertUtil.assertPilot(sco069, 6, 0, false, 3, 3);
			race13AssertUtil.assertPilot(sco528, 5, 1, false, 4, 4);
			race13AssertUtil.assertPilot(sco081, 5, 0, false, 5, 5);
			race13AssertUtil.assertPilot(sco666, 5, 0, false, 7, 6);
			race13AssertUtil.assertPilot(sco018, 5, 0, false, 8, 7);
			race13AssertUtil.assertPilot(sco159, 5, 3, false, 6, 8);
			race13AssertUtil.assertPilot(sco117, 4, 0, false, 9, 9);
			race13AssertUtil.assertPilot(sco087, 4, 0, false, 10, 10);
			race13AssertUtil.assertPilot(sco156, 3, 0, false, 11, 11);
			race13AssertUtil.assertPilot(sco296, 3, 0, false, 12, 12);
			race13AssertUtil.assertPilot(sco249, 0, 0, false, 14, 13);
			race13AssertUtil.assertDone(0);

			RaceAssertUtil race14AssertUtil = new RaceAssertUtil(scores, race14);
			race14AssertUtil.assertPilot(sco528, 11, 0, false, 0, 1);
			race14AssertUtil.assertPilot(sco666, 11, 0, false, 2, 2);
			race14AssertUtil.assertPilot(sco081, 11, 0, false, 3, 3);
			race14AssertUtil.assertPilot(sco069, 11, 0, false, 4, 4);
			race14AssertUtil.assertPilot(sco159, 11, 0, false, 5, 5);
			race14AssertUtil.assertPilot(sco117, 10, 0, false, 6, 6);
			race14AssertUtil.assertPilot(sco087, 9, 0, false, 7, 7);
			race14AssertUtil.assertPilot(sco808, 8, 0, false, 8, 8);
			race14AssertUtil.assertPilot(sco156, 8, 0, false, 9, 9);
			race14AssertUtil.assertPilot(sco296, 7, 0, false, 10, 10);
			race14AssertUtil.assertPilot(sco018, 2, 0, false, 11, 11);
			race14AssertUtil.assertPilot(sco116, 0, 0, false, 14, 12);
			race14AssertUtil.assertPilot(sco249, 0, 0, false, 14, 12);
			race14AssertUtil.assertDone(0);

			RaceAssertUtil race15AssertUtil = new RaceAssertUtil(scores, race15);
			race15AssertUtil.assertPilot(sco069, 4, 0, false, 0, 1);
			race15AssertUtil.assertPilot(sco808, 4, 0, false, 2, 2);
			race15AssertUtil.assertPilot(sco528, 4, 0, false, 3, 3);
			race15AssertUtil.assertPilot(sco116, 4, 0, false, 4, 4);
			race15AssertUtil.assertPilot(sco666, 3, 0, false, 5, 5);
			race15AssertUtil.assertPilot(sco117, 3, 0, false, 6, 6);
			race15AssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
			race15AssertUtil.assertPilot(sco018, 0, 0, false, 14, 8);
			race15AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
			race15AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
			race15AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
			race15AssertUtil.assertPilot(sco249, 0, 0, false, 14, 8);
			race15AssertUtil.assertPilot(sco087, 0, 1, false, 14, 13);
			race15AssertUtil.assertDone(0);

			RaceAssertUtil race16AssertUtil = new RaceAssertUtil(scores, race16);
			race16AssertUtil.assertPilot(sco069, 5, 0, false, 0, 1);
			race16AssertUtil.assertPilot(sco528, 5, 0, false, 2, 2);
			race16AssertUtil.assertPilot(sco666, 5, 0, false, 3, 3);
			race16AssertUtil.assertPilot(sco116, 5, 0, false, 4, 4);
			race16AssertUtil.assertPilot(sco808, 5, 0, false, 5, 5);
			race16AssertUtil.assertPilot(sco117, 4, 0, false, 6, 6);
			race16AssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
			race16AssertUtil.assertPilot(sco018, 0, 0, false, 14, 8);
			race16AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
			race16AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
			race16AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
			race16AssertUtil.assertPilot(sco249, 0, 0, false, 14, 8);
			race16AssertUtil.assertPilot(sco296, 0, 0, false, 14, 8);
			race16AssertUtil.assertDone(0);

			RaceAssertUtil race17AssertUtil = new RaceAssertUtil(scores, race17);
			race17AssertUtil.assertPilot(sco116, 4, 0, false, 0, 1);
			race17AssertUtil.assertPilot(sco808, 4, 0, false, 2, 2);
			race17AssertUtil.assertPilot(sco528, 4, 0, false, 3, 3);
			race17AssertUtil.assertPilot(sco666, 4, 0, false, 4, 4);
			race17AssertUtil.assertPilot(sco117, 3, 0, false, 5, 5);
			race17AssertUtil.assertPilot(sco087, 2, 0, false, 6, 6);
			race17AssertUtil.assertPilot(sco069, 2, 0, false, 7, 7);
			race17AssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
			race17AssertUtil.assertPilot(sco018, 0, 0, false, 14, 9);
			race17AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
			race17AssertUtil.assertPilot(sco156, 0, 0, false, 14, 9);
			race17AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
			race17AssertUtil.assertPilot(sco249, 0, 0, false, 14, 9);
			race17AssertUtil.assertDone(0);

			RaceAssertUtil race18AssertUtil = new RaceAssertUtil(scores, race18);
			race18AssertUtil.assertPilot(sco069, 5, 0, false, 0, 1);
			race18AssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
			race18AssertUtil.assertPilot(sco528, 5, 0, false, 3, 3);
			race18AssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
			race18AssertUtil.assertPilot(sco666, 5, 0, false, 5, 5);
			race18AssertUtil.assertPilot(sco117, 4, 0, false, 6, 6);
			race18AssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
			race18AssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
			race18AssertUtil.assertPilot(sco018, 0, 0, false, 14, 9);
			race18AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
			race18AssertUtil.assertPilot(sco156, 0, 0, false, 14, 9);
			race18AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
			race18AssertUtil.assertPilot(sco249, 0, 0, false, 14, 9);
			race18AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 3, 8, 1, 7, 4);
			overallAssertUtil.assertPilot(sco116, 0, 11, 2, 14, 4);
			overallAssertUtil.assertPilot(sco808, 0, 13, 3, 8, 5);
			overallAssertUtil.assertPilot(sco528, 1, 16, 4, 4, 4);
			overallAssertUtil.assertPilot(sco666, 0, 25, 5, 7, 7);
			overallAssertUtil.assertPilot(sco117, 0, 37, 6, 9, 9);
			overallAssertUtil.assertPilot(sco087, 1, 47, 7, 14, 10);
			overallAssertUtil.assertPilot(sco159, 3, 52, 8, 14, 14);
			overallAssertUtil.assertPilot(sco081, 0, 55, 9, 14, 14);
			overallAssertUtil.assertPilot(sco296, 0, 59, 10, 14, 14);
			overallAssertUtil.assertPilot(sco018, 0, 60, 11, 14, 14);
			overallAssertUtil.assertPilot(sco156, 0, 69, 12, 14, 14);
			overallAssertUtil.assertPilot(sco249, 0, 84, 13, 14, 14);
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
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race11 = raceDAO.find(event5, RACE11_NAME);

			Scores scores = scorer.scoreRace(race11, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race11));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race11);
			raceAssertUtil.assertPilot(sco808, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco069, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco116, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco528, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco666, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco018, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco156, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco081, 2, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco249, 0, 0, false, 14, 12);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 14, 12);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco808, 0, 0, 1);
			overallAssertUtil.assertPilot(sco069, 0, 2, 2);
			overallAssertUtil.assertPilot(sco116, 0, 3, 3);
			overallAssertUtil.assertPilot(sco528, 0, 4, 4);
			overallAssertUtil.assertPilot(sco159, 0, 5, 5);
			overallAssertUtil.assertPilot(sco666, 0, 6, 6);
			overallAssertUtil.assertPilot(sco018, 0, 7, 7);
			overallAssertUtil.assertPilot(sco117, 0, 8, 8);
			overallAssertUtil.assertPilot(sco087, 0, 9, 9);
			overallAssertUtil.assertPilot(sco156, 0, 10, 10);
			overallAssertUtil.assertPilot(sco081, 0, 11, 11);
			overallAssertUtil.assertPilot(sco249, 0, 14, 12);
			overallAssertUtil.assertPilot(sco296, 0, 14, 12);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace12() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race12 = raceDAO.find(event5, RACE12_NAME);

			Scores scores = scorer.scoreRace(race12, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race12));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race12);
			raceAssertUtil.assertPilot(sco116, 5, 0, false, 2, 1);
			raceAssertUtil.assertPilot(sco069, 5, 3, false, 0, 2);
			raceAssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco528, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco018, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco666, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco081, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco156, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco249, 0, 0, false, 14, 12);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 14, 12);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 2, 1);
			overallAssertUtil.assertPilot(sco069, 3, 3, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(sco528, 0, 4, 4);
			overallAssertUtil.assertPilot(sco159, 0, 5, 5);
			overallAssertUtil.assertPilot(sco018, 0, 6, 6);
			overallAssertUtil.assertPilot(sco666, 0, 7, 7);
			overallAssertUtil.assertPilot(sco081, 0, 8, 8);
			overallAssertUtil.assertPilot(sco117, 0, 9, 9);
			overallAssertUtil.assertPilot(sco087, 0, 10, 10);
			overallAssertUtil.assertPilot(sco156, 0, 11, 11);
			overallAssertUtil.assertPilot(sco249, 0, 14, 12);
			overallAssertUtil.assertPilot(sco296, 0, 14, 12);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace13() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race13 = raceDAO.find(event5, RACE13_NAME);

			Scores scores = scorer.scoreRace(race13, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race13));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race13);
			raceAssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco069, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco528, 5, 1, false, 4, 4);
			raceAssertUtil.assertPilot(sco081, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco666, 5, 0, false, 7, 6);
			raceAssertUtil.assertPilot(sco018, 5, 0, false, 8, 7);
			raceAssertUtil.assertPilot(sco159, 5, 3, false, 6, 8);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco156, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco296, 3, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco249, 0, 0, false, 14, 13);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco069, 0, 3, 3);
			overallAssertUtil.assertPilot(sco528, 1, 5, 4);
			overallAssertUtil.assertPilot(sco081, 0, 5, 5);
			overallAssertUtil.assertPilot(sco666, 0, 7, 6);
			overallAssertUtil.assertPilot(sco018, 0, 8, 7);
			overallAssertUtil.assertPilot(sco159, 3, 9, 8);
			overallAssertUtil.assertPilot(sco117, 0, 9, 9);
			overallAssertUtil.assertPilot(sco087, 0, 10, 10);
			overallAssertUtil.assertPilot(sco156, 0, 11, 11);
			overallAssertUtil.assertPilot(sco296, 0, 12, 12);
			overallAssertUtil.assertPilot(sco249, 0, 14, 13);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace14() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race14 = raceDAO.find(event5, RACE14_NAME);

			Scores scores = scorer.scoreRace(race14, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race14));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race14);
			raceAssertUtil.assertPilot(sco528, 11, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco666, 11, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco081, 11, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco069, 11, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco159, 11, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 10, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco087, 9, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco808, 8, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco156, 8, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco296, 7, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco018, 2, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco116, 0, 0, false, 14, 12);
			raceAssertUtil.assertPilot(sco249, 0, 0, false, 14, 12);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco528, 0, 0, 1);
			overallAssertUtil.assertPilot(sco666, 0, 2, 2);
			overallAssertUtil.assertPilot(sco081, 0, 3, 3);
			overallAssertUtil.assertPilot(sco069, 0, 4, 4);
			overallAssertUtil.assertPilot(sco159, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco087, 0, 7, 7);
			overallAssertUtil.assertPilot(sco808, 0, 8, 8);
			overallAssertUtil.assertPilot(sco156, 0, 9, 9);
			overallAssertUtil.assertPilot(sco296, 0, 10, 10);
			overallAssertUtil.assertPilot(sco018, 0, 11, 11);
			overallAssertUtil.assertPilot(sco116, 0, 14, 12);
			overallAssertUtil.assertPilot(sco249, 0, 14, 12);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace15() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race15 = raceDAO.find(event5, RACE15_NAME);

			Scores scores = scorer.scoreRace(race15, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race15));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race15);
			raceAssertUtil.assertPilot(sco069, 4, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 4, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco528, 4, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco116, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco666, 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco249, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco087, 0, 1, false, 14, 13);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco528, 0, 3, 3);
			overallAssertUtil.assertPilot(sco116, 0, 4, 4);
			overallAssertUtil.assertPilot(sco666, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco296, 0, 7, 7);
			overallAssertUtil.assertPilot(sco018, 0, 14, 8);
			overallAssertUtil.assertPilot(sco081, 0, 14, 8);
			overallAssertUtil.assertPilot(sco156, 0, 14, 8);
			overallAssertUtil.assertPilot(sco159, 0, 14, 8);
			overallAssertUtil.assertPilot(sco249, 0, 14, 8);
			overallAssertUtil.assertPilot(sco087, 1, 15, 13);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace16() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race16 = raceDAO.find(event5, RACE16_NAME);

			Scores scores = scorer.scoreRace(race16, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race16));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race16);
			raceAssertUtil.assertPilot(sco069, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco528, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco666, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco116, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco808, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco249, 0, 0, false, 14, 8);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 14, 8);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco528, 0, 2, 2);
			overallAssertUtil.assertPilot(sco666, 0, 3, 3);
			overallAssertUtil.assertPilot(sco116, 0, 4, 4);
			overallAssertUtil.assertPilot(sco808, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco087, 0, 7, 7);
			overallAssertUtil.assertPilot(sco018, 0, 14, 8);
			overallAssertUtil.assertPilot(sco081, 0, 14, 8);
			overallAssertUtil.assertPilot(sco156, 0, 14, 8);
			overallAssertUtil.assertPilot(sco159, 0, 14, 8);
			overallAssertUtil.assertPilot(sco249, 0, 14, 8);
			overallAssertUtil.assertPilot(sco296, 0, 14, 8);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace17() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race17 = raceDAO.find(event5, RACE17_NAME);

			Scores scores = scorer.scoreRace(race17, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race17));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race17);
			raceAssertUtil.assertPilot(sco116, 4, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 4, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco528, 4, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco666, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco117, 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco087, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco069, 2, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco156, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco249, 0, 0, false, 14, 9);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco528, 0, 3, 3);
			overallAssertUtil.assertPilot(sco666, 0, 4, 4);
			overallAssertUtil.assertPilot(sco117, 0, 5, 5);
			overallAssertUtil.assertPilot(sco087, 0, 6, 6);
			overallAssertUtil.assertPilot(sco069, 0, 7, 7);
			overallAssertUtil.assertPilot(sco296, 0, 8, 8);
			overallAssertUtil.assertPilot(sco018, 0, 14, 9);
			overallAssertUtil.assertPilot(sco081, 0, 14, 9);
			overallAssertUtil.assertPilot(sco156, 0, 14, 9);
			overallAssertUtil.assertPilot(sco159, 0, 14, 9);
			overallAssertUtil.assertPilot(sco249, 0, 14, 9);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace18() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race18 = raceDAO.find(event5, RACE18_NAME);

			Scores scores = scorer.scoreRace(race18, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race18));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race18);
			raceAssertUtil.assertPilot(sco069, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco528, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco666, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco156, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco249, 0, 0, false, 14, 9);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco528, 0, 3, 3);
			overallAssertUtil.assertPilot(sco808, 0, 4, 4);
			overallAssertUtil.assertPilot(sco666, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco087, 0, 7, 7);
			overallAssertUtil.assertPilot(sco296, 0, 8, 8);
			overallAssertUtil.assertPilot(sco018, 0, 14, 9);
			overallAssertUtil.assertPilot(sco081, 0, 14, 9);
			overallAssertUtil.assertPilot(sco156, 0, 14, 9);
			overallAssertUtil.assertPilot(sco159, 0, 14, 9);
			overallAssertUtil.assertPilot(sco249, 0, 14, 9);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}