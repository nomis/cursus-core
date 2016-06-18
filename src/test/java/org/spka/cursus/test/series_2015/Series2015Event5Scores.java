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
package org.spka.cursus.test.series_2015;

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
 * Scores at the end of event 5 (07/05/2016 to 08/05/2016)
 */
public class Series2015Event5Scores extends Series2015Event4Scores {
	@Override
	@Before
	public void createDatabase() throws Exception {
		super.createDatabase();
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
		Race race4 = raceDAO.find(event1, RACE4_NAME);
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race5 = raceDAO.find(event2, RACE5_NAME);
		Race race6 = raceDAO.find(event2, RACE6_NAME);
		Race race7 = raceDAO.find(event2, RACE7_NAME);
		Race race8 = raceDAO.find(event2, RACE8_NAME);
		Event event3 = eventDAO.find(series, EVENT3_NAME);
		Race race9 = raceDAO.find(event3, RACE9_NAME);
		Race race10 = raceDAO.find(event3, RACE10_NAME);
		Race race11 = raceDAO.find(event3, RACE11_NAME);
		Race race12 = raceDAO.find(event3, RACE12_NAME);
		Event event4 = eventDAO.find(series, EVENT4_NAME);
		Race race13 = raceDAO.find(event4, RACE13_NAME);
		Race race14 = raceDAO.find(event4, RACE14_NAME);
		Race race15 = raceDAO.find(event4, RACE15_NAME);
		Event event5 = eventDAO.find(series, EVENT5_NAME);
		Race race16 = raceDAO.find(event5, RACE16_NAME);
		Race race17 = raceDAO.find(event5, RACE17_NAME);
		Race race18 = raceDAO.find(event5, RACE18_NAME);
		Race race19 = raceDAO.find(event5, RACE19_NAME);
		Race race20 = raceDAO.find(event5, RACE20_NAME);
		Race race21 = raceDAO.find(event5, RACE21_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT5, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco018, 4, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco081, 3, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco060, 1, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco153, 1, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco296, 0, 0, false, 8, 7);
		race1AssertUtil.assertPilot(sco066, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco179, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco884, 0, 0, false, 14, 8);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco060, 5, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco296, 3, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco081, 2, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco018, 0, 0, false, 8, 6);
		race2AssertUtil.assertPilot(sco153, 0, 0, false, 8, 6);
		race2AssertUtil.assertPilot(sco066, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco179, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco884, 0, 0, false, 14, 8);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco808, 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco081, 4, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco060, 3, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco296, 2, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco018, 0, 0, false, 8, 6);
		race3AssertUtil.assertPilot(sco153, 0, 0, false, 8, 6);
		race3AssertUtil.assertPilot(sco066, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco179, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco884, 0, 0, false, 14, 8);
		race3AssertUtil.assertDone(0);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco808, 5, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco296, 2, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco081, 1, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco018, 0, 0, false, 8, 5);
		race4AssertUtil.assertPilot(sco060, 0, 0, false, 8, 5);
		race4AssertUtil.assertPilot(sco153, 0, 0, false, 8, 5);
		race4AssertUtil.assertPilot(sco066, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco179, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco884, 0, 0, false, 14, 8);
		race4AssertUtil.assertDone(0);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco808, 7, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco087, 5, 0, false, 3, 3);
		race5AssertUtil.assertPilot(sco159, 5, 0, false, 4, 4);
		race5AssertUtil.assertPilot(sco156, 3, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco066, 3, 0, false, 6, 6);
		race5AssertUtil.assertPilot(sco018, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco060, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco081, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco153, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco179, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco296, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco884, 0, 0, false, 14, 7);
		race5AssertUtil.assertDone(0);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
		race6AssertUtil.assertPilot(sco808, 8, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco159, 7, 0, false, 3, 3);
		race6AssertUtil.assertPilot(sco087, 6, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco156, 5, 0, false, 5, 5);
		race6AssertUtil.assertPilot(sco066, 4, 0, false, 6, 6);
		race6AssertUtil.assertPilot(sco018, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco060, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco081, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco153, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco179, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco296, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco884, 0, 0, false, 14, 7);
		race6AssertUtil.assertDone(0);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
		race7AssertUtil.assertPilot(sco116, 5, 0, false, 0, 1);
		race7AssertUtil.assertPilot(sco808, 4, 0, false, 2, 2);
		race7AssertUtil.assertPilot(sco159, 3, 0, false, 3, 3);
		race7AssertUtil.assertPilot(sco087, 2, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco066, 1, 0, false, 5, 5);
		race7AssertUtil.assertPilot(sco156, 1, 0, false, 6, 6);
		race7AssertUtil.assertPilot(sco018, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco060, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco081, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco153, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco179, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco296, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco884, 0, 0, false, 14, 7);
		race7AssertUtil.assertDone(0);

		RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
		race8AssertUtil.assertPilot(sco116, 4, 0, false, 0, 1);
		race8AssertUtil.assertPilot(sco159, 2, 0, false, 2, 2);
		race8AssertUtil.assertPilot(sco066, 1, 0, false, 3, 3);
		race8AssertUtil.assertPilot(sco087, 0, 0, false, 7, 4);
		race8AssertUtil.assertPilot(sco156, 0, 0, false, 7, 4);
		race8AssertUtil.assertPilot(sco808, 0, 0, false, 7, 4);
		race8AssertUtil.assertPilot(sco018, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco060, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco081, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco153, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco179, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco296, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco884, 0, 0, false, 14, 7);
		race8AssertUtil.assertDone(0);

		RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
		race9AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race9AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race9AssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
		race9AssertUtil.assertPilot(sco156, 5, 0, false, 4, 4);
		race9AssertUtil.assertPilot(sco066, 5, 0, false, 5, 5);
		race9AssertUtil.assertPilot(sco884, 2, 0, false, 6, 6);
		race9AssertUtil.assertPilot(sco018, 1, 0, false, 7, 7);
		race9AssertUtil.assertPilot(sco296, 0, 0, false, 9, 8);
		race9AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race9AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race9AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race9AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race9AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race9AssertUtil.assertDone(0);

		RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
		race10AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race10AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race10AssertUtil.assertPilot(sco179, 5, 0, false, 3, 3);
		race10AssertUtil.assertPilot(sco156, 3, 0, false, 4, 4);
		race10AssertUtil.assertPilot(sco884, 2, 0, false, 5, 5);
		race10AssertUtil.assertPilot(sco066, 2, 0, false, 6, 6);
		race10AssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
		race10AssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
		race10AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race10AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race10AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race10AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race10AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race10AssertUtil.assertDone(0);

		RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
		race11AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race11AssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
		race11AssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
		race11AssertUtil.assertPilot(sco066, 3, 0, false, 4, 4);
		race11AssertUtil.assertPilot(sco884, 2, 0, false, 5, 5);
		race11AssertUtil.assertPilot(sco156, 2, 0, false, 6, 6);
		race11AssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
		race11AssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
		race11AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race11AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race11AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race11AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race11AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race11AssertUtil.assertDone(0);

		RaceAssertUtil race12AssertUtil = new RaceAssertUtil(scores, race12);
		race12AssertUtil.assertPilot(sco116, 5, 0, false, 0, 1);
		race12AssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
		race12AssertUtil.assertPilot(sco808, 4, 0, false, 3, 3);
		race12AssertUtil.assertPilot(sco156, 4, 0, false, 4, 4);
		race12AssertUtil.assertPilot(sco066, 3, 0, false, 5, 5);
		race12AssertUtil.assertPilot(sco884, 2, 0, false, 6, 6);
		race12AssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
		race12AssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
		race12AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race12AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race12AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race12AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race12AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race12AssertUtil.assertDone(0);

		RaceAssertUtil race13AssertUtil = new RaceAssertUtil(scores, race13);
		race13AssertUtil.assertPilot(sco179, 6, 0, false, 0, 1);
		race13AssertUtil.assertPilot(sco116, 6, 0, false, 2, 2);
		race13AssertUtil.assertPilot(sco018, 5, 0, false, 3, 3);
		race13AssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
		race13AssertUtil.assertPilot(sco156, 4, 0, false, 5, 5);
		race13AssertUtil.assertPilot(sco159, 3, 0, false, 6, 6);
		race13AssertUtil.assertPilot(sco296, 3, 0, false, 7, 7);
		race13AssertUtil.assertPilot(sco066, 1, 0, false, 8, 8);
		race13AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race13AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race13AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race13AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race13AssertUtil.assertPilot(sco884, 0, 0, false, 14, 9);
		race13AssertUtil.assertDone(0);

		RaceAssertUtil race14AssertUtil = new RaceAssertUtil(scores, race14);
		race14AssertUtil.assertPilot(sco116, 5, 0, false, 0, 1);
		race14AssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
		race14AssertUtil.assertPilot(sco159, 4, 0, false, 3, 3);
		race14AssertUtil.assertPilot(sco808, 4, 0, false, 4, 4);
		race14AssertUtil.assertPilot(sco156, 3, 0, false, 5, 5);
		race14AssertUtil.assertPilot(sco018, 1, 1, false, 6, 6);
		race14AssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
		race14AssertUtil.assertPilot(sco066, 0, 0, false, 9, 8);
		race14AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race14AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race14AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race14AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race14AssertUtil.assertPilot(sco884, 0, 0, false, 14, 9);
		race14AssertUtil.assertDone(0);

		RaceAssertUtil race15AssertUtil = new RaceAssertUtil(scores, race15);
		race15AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race15AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race15AssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
		race15AssertUtil.assertPilot(sco156, 5, 0, false, 4, 4);
		race15AssertUtil.assertPilot(sco018, 5, 0, false, 5, 5);
		race15AssertUtil.assertPilot(sco159, 5, 1, false, 6, 6);
		race15AssertUtil.assertPilot(sco066, 4, 0, false, 7, 7);
		race15AssertUtil.assertPilot(sco296, 1, 0, false, 8, 8);
		race15AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race15AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race15AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race15AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race15AssertUtil.assertPilot(sco884, 0, 0, false, 14, 9);
		race15AssertUtil.assertDone(0);

		RaceAssertUtil race16AssertUtil = new RaceAssertUtil(scores, race16);
		race16AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
		race16AssertUtil.assertPilot(sco179, 8, 0, false, 2, 2);
		race16AssertUtil.assertPilot(sco159, 7, 0, false, 3, 3);
		race16AssertUtil.assertPilot(sco018, 7, 0, false, 4, 4);
		race16AssertUtil.assertPilot(sco066, 7, 0, false, 5, 5);
		race16AssertUtil.assertPilot(sco296, 5, 0, false, 6, 6);
		race16AssertUtil.assertPilot(sco884, 4, 0, false, 7, 7);
		race16AssertUtil.assertPilot(sco060, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco153, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race16AssertUtil.assertPilot(sco808, 0, 0, false, 14, 8);
		race16AssertUtil.assertDone(0);

		RaceAssertUtil race17AssertUtil = new RaceAssertUtil(scores, race17);
		race17AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
		race17AssertUtil.assertPilot(sco018, 7, 0, false, 2, 2);
		race17AssertUtil.assertPilot(sco066, 7, 0, false, 3, 3);
		race17AssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
		race17AssertUtil.assertPilot(sco296, 5, 0, false, 5, 5);
		race17AssertUtil.assertPilot(sco179, 4, 0, false, 6, 6);
		race17AssertUtil.assertPilot(sco884, 1, 0, false, 7, 7);
		race17AssertUtil.assertPilot(sco060, 0, 0, false, 14, 8);
		race17AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
		race17AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race17AssertUtil.assertPilot(sco153, 0, 0, false, 14, 8);
		race17AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race17AssertUtil.assertPilot(sco808, 0, 0, false, 14, 8);
		race17AssertUtil.assertDone(0);

		RaceAssertUtil race18AssertUtil = new RaceAssertUtil(scores, race18);
		race18AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
		race18AssertUtil.assertPilot(sco179, 8, 0, false, 2, 2);
		race18AssertUtil.assertPilot(sco159, 7, 0, false, 3, 3);
		race18AssertUtil.assertPilot(sco018, 7, 0, false, 4, 4);
		race18AssertUtil.assertPilot(sco296, 5, 0, false, 5, 5);
		race18AssertUtil.assertPilot(sco066, 3, 0, false, 6, 6);
		race18AssertUtil.assertPilot(sco884, 3, 0, false, 7, 7);
		race18AssertUtil.assertPilot(sco060, 0, 0, false, 14, 8);
		race18AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
		race18AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race18AssertUtil.assertPilot(sco153, 0, 0, false, 14, 8);
		race18AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race18AssertUtil.assertPilot(sco808, 0, 0, false, 14, 8);
		race18AssertUtil.assertDone(0);

		RaceAssertUtil race19AssertUtil = new RaceAssertUtil(scores, race19);
		race19AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race19AssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
		race19AssertUtil.assertPilot(sco018, 5, 0, false, 3, 3);
		race19AssertUtil.assertPilot(sco066, 5, 0, false, 4, 4);
		race19AssertUtil.assertPilot(sco159, 4, 0, false, 5, 5);
		race19AssertUtil.assertPilot(sco296, 2, 0, false, 6, 6);
		race19AssertUtil.assertPilot(sco884, 0, 0, false, 8, 7);
		race19AssertUtil.assertPilot(sco060, 0, 0, false, 14, 8);
		race19AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
		race19AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race19AssertUtil.assertPilot(sco153, 0, 0, false, 14, 8);
		race19AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race19AssertUtil.assertPilot(sco808, 0, 0, false, 14, 8);
		race19AssertUtil.assertDone(0);

		RaceAssertUtil race20AssertUtil = new RaceAssertUtil(scores, race20);
		race20AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race20AssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
		race20AssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
		race20AssertUtil.assertPilot(sco018, 5, 0, false, 4, 4);
		race20AssertUtil.assertPilot(sco066, 5, 0, false, 5, 5);
		race20AssertUtil.assertPilot(sco296, 2, 0, false, 6, 6);
		race20AssertUtil.assertPilot(sco884, 0, 0, false, 8, 7);
		race20AssertUtil.assertPilot(sco060, 0, 0, false, 14, 8);
		race20AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
		race20AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race20AssertUtil.assertPilot(sco153, 0, 0, false, 14, 8);
		race20AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race20AssertUtil.assertPilot(sco808, 0, 0, false, 14, 8);
		race20AssertUtil.assertDone(0);

		RaceAssertUtil race21AssertUtil = new RaceAssertUtil(scores, race21);
		race21AssertUtil.assertPilot(sco116, 3, 0, false, 0, 1);
		race21AssertUtil.assertPilot(sco159, 3, 0, false, 2, 2);
		race21AssertUtil.assertPilot(sco179, 3, 0, false, 3, 3);
		race21AssertUtil.assertPilot(sco066, 2, 1, false, 4, 4);
		race21AssertUtil.assertPilot(sco018, 1, 0, false, 5, 5);
		race21AssertUtil.assertPilot(sco884, 0, 0, false, 8, 6);
		race21AssertUtil.assertPilot(sco296, 0, 1, false, 8, 7);
		race21AssertUtil.assertPilot(sco060, 0, 0, false, 14, 8);
		race21AssertUtil.assertPilot(sco081, 0, 0, false, 14, 8);
		race21AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race21AssertUtil.assertPilot(sco153, 0, 0, false, 14, 8);
		race21AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race21AssertUtil.assertPilot(sco808, 0, 0, false, 14, 8);
		race21AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco116, 0, 0, 1, 2, 0, 0, 0, 0);
		overallAssertUtil.assertPilot(sco808, 0, 55, 2, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco179, 0, 74, 3, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco066, 1, 83, 4, 14, 14, 14, 14, 9);
		overallAssertUtil.assertPilot(sco018, 1, 89, 5, 14, 14, 14, 14, 9);
		overallAssertUtil.assertPilot(sco159, 1, 90, 6, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco296, 1, 100, 7, 14, 14, 14, 14, 9);
		overallAssertUtil.assertPilot(sco156, 0, 125, 8, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco884, 0, 151, 9, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco081, 0, 184, 10, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco087, 0, 186, 11, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco060, 0, 188, 12, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco153, 0, 198, 13, 14, 14, 14, 14, 14);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent5() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race16 = raceDAO.find(event5, RACE16_NAME);
			Race race17 = raceDAO.find(event5, RACE17_NAME);
			Race race18 = raceDAO.find(event5, RACE18_NAME);
			Race race19 = raceDAO.find(event5, RACE19_NAME);
			Race race20 = raceDAO.find(event5, RACE20_NAME);
			Race race21 = raceDAO.find(event5, RACE21_NAME);

			Scores scores = scorer.scoreEvent(event5, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race16));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race17));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race18));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race19));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race20));
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race21));

			RaceAssertUtil race16AssertUtil = new RaceAssertUtil(scores, race16);
			race16AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			race16AssertUtil.assertPilot(sco179, 8, 0, false, 2, 2);
			race16AssertUtil.assertPilot(sco159, 7, 0, false, 3, 3);
			race16AssertUtil.assertPilot(sco018, 7, 0, false, 4, 4);
			race16AssertUtil.assertPilot(sco066, 7, 0, false, 5, 5);
			race16AssertUtil.assertPilot(sco296, 5, 0, false, 6, 6);
			race16AssertUtil.assertPilot(sco884, 4, 0, false, 7, 7);
			race16AssertUtil.assertDone(0);

			RaceAssertUtil race17AssertUtil = new RaceAssertUtil(scores, race17);
			race17AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			race17AssertUtil.assertPilot(sco018, 7, 0, false, 2, 2);
			race17AssertUtil.assertPilot(sco066, 7, 0, false, 3, 3);
			race17AssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
			race17AssertUtil.assertPilot(sco296, 5, 0, false, 5, 5);
			race17AssertUtil.assertPilot(sco179, 4, 0, false, 6, 6);
			race17AssertUtil.assertPilot(sco884, 1, 0, false, 7, 7);
			race17AssertUtil.assertDone(0);

			RaceAssertUtil race18AssertUtil = new RaceAssertUtil(scores, race18);
			race18AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			race18AssertUtil.assertPilot(sco179, 8, 0, false, 2, 2);
			race18AssertUtil.assertPilot(sco159, 7, 0, false, 3, 3);
			race18AssertUtil.assertPilot(sco018, 7, 0, false, 4, 4);
			race18AssertUtil.assertPilot(sco296, 5, 0, false, 5, 5);
			race18AssertUtil.assertPilot(sco066, 3, 0, false, 6, 6);
			race18AssertUtil.assertPilot(sco884, 3, 0, false, 7, 7);
			race18AssertUtil.assertDone(0);

			RaceAssertUtil race19AssertUtil = new RaceAssertUtil(scores, race19);
			race19AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			race19AssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
			race19AssertUtil.assertPilot(sco018, 5, 0, false, 3, 3);
			race19AssertUtil.assertPilot(sco066, 5, 0, false, 4, 4);
			race19AssertUtil.assertPilot(sco159, 4, 0, false, 5, 5);
			race19AssertUtil.assertPilot(sco296, 2, 0, false, 6, 6);
			race19AssertUtil.assertPilot(sco884, 0, 0, false, 8, 7);
			race19AssertUtil.assertDone(0);

			RaceAssertUtil race20AssertUtil = new RaceAssertUtil(scores, race20);
			race20AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			race20AssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
			race20AssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			race20AssertUtil.assertPilot(sco018, 5, 0, false, 4, 4);
			race20AssertUtil.assertPilot(sco066, 5, 0, false, 5, 5);
			race20AssertUtil.assertPilot(sco296, 2, 0, false, 6, 6);
			race20AssertUtil.assertPilot(sco884, 0, 0, false, 8, 7);
			race20AssertUtil.assertDone(0);

			RaceAssertUtil race21AssertUtil = new RaceAssertUtil(scores, race21);
			race21AssertUtil.assertPilot(sco116, 3, 0, false, 0, 1);
			race21AssertUtil.assertPilot(sco159, 3, 0, false, 2, 2);
			race21AssertUtil.assertPilot(sco179, 3, 0, false, 3, 3);
			race21AssertUtil.assertPilot(sco066, 2, 1, false, 4, 4);
			race21AssertUtil.assertPilot(sco018, 1, 0, false, 5, 5);
			race21AssertUtil.assertPilot(sco884, 0, 0, false, 8, 6);
			race21AssertUtil.assertPilot(sco296, 0, 1, false, 8, 7);
			race21AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1, 0);
			overallAssertUtil.assertPilot(sco179, 0, 11, 2, 6);
			overallAssertUtil.assertPilot(sco159, 0, 15, 3, 5);
			overallAssertUtil.assertPilot(sco018, 0, 17, 4, 5);
			overallAssertUtil.assertPilot(sco066, 1, 22, 5, 6);
			overallAssertUtil.assertPilot(sco296, 1, 29, 6, 8);
			overallAssertUtil.assertPilot(sco884, 0, 37, 7, 8);
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
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco018, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco066, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco296, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco884, 4, 0, false, 7, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco179, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco018, 0, 4, 4);
			overallAssertUtil.assertPilot(sco066, 0, 5, 5);
			overallAssertUtil.assertPilot(sco296, 0, 6, 6);
			overallAssertUtil.assertPilot(sco884, 0, 7, 7);
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
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco018, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco066, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco296, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco884, 1, 0, false, 7, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco018, 0, 2, 2);
			overallAssertUtil.assertPilot(sco066, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco296, 0, 5, 5);
			overallAssertUtil.assertPilot(sco179, 0, 6, 6);
			overallAssertUtil.assertPilot(sco884, 0, 7, 7);
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
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco018, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco296, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco066, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco884, 3, 0, false, 7, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco179, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco018, 0, 4, 4);
			overallAssertUtil.assertPilot(sco296, 0, 5, 5);
			overallAssertUtil.assertPilot(sco066, 0, 6, 6);
			overallAssertUtil.assertPilot(sco884, 0, 7, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace19() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race19 = raceDAO.find(event5, RACE19_NAME);

			Scores scores = scorer.scoreRace(race19, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race19));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race19);
			raceAssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco018, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco066, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco296, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 8, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco179, 0, 2, 2);
			overallAssertUtil.assertPilot(sco018, 0, 3, 3);
			overallAssertUtil.assertPilot(sco066, 0, 4, 4);
			overallAssertUtil.assertPilot(sco159, 0, 5, 5);
			overallAssertUtil.assertPilot(sco296, 0, 6, 6);
			overallAssertUtil.assertPilot(sco884, 0, 8, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace20() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race20 = raceDAO.find(event5, RACE20_NAME);

			Scores scores = scorer.scoreRace(race20, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race20));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race20);
			raceAssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco018, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco066, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco296, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 8, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco179, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco018, 0, 4, 4);
			overallAssertUtil.assertPilot(sco066, 0, 5, 5);
			overallAssertUtil.assertPilot(sco296, 0, 6, 6);
			overallAssertUtil.assertPilot(sco884, 0, 8, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace21() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race21 = raceDAO.find(event5, RACE21_NAME);

			Scores scores = scorer.scoreRace(race21, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT5_FLEET, scores.getFleetSize(race21));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race21);
			raceAssertUtil.assertPilot(sco116, 3, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco159, 3, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 3, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco066, 2, 1, false, 4, 4);
			raceAssertUtil.assertPilot(sco018, 1, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 8, 6);
			raceAssertUtil.assertPilot(sco296, 0, 1, false, 8, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(sco066, 1, 5, 4);
			overallAssertUtil.assertPilot(sco018, 0, 5, 5);
			overallAssertUtil.assertPilot(sco884, 0, 8, 6);
			overallAssertUtil.assertPilot(sco296, 1, 9, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}