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

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.test.util.OverallAssertUtil;
import uk.uuid.cursus.test.util.RaceAssertUtil;

/**
 * Scores at the end of event 6 (28/05/2016 to 29/05/2016)
 */
public class Series2015Event6Scores extends Series2015Event5Scores {
	@Override
	@Before
	public void createDatabase() throws Exception {
		super.createDatabase();
		createEvent6Races();
	}

	@Override
	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, event6), Predicates.in(getSeriesResultsPilots(series, event6)));
			checkSeriesAtEvent6(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkSeriesAtEvent6() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);

			List<Race> races = new ArrayList<Race>();
			races.addAll(event1.getRaces());
			races.addAll(event2.getRaces());
			races.addAll(event3.getRaces());
			races.addAll(event4.getRaces());
			races.addAll(event5.getRaces());
			races.addAll(event6.getRaces());

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, event6), getSeriesResultsEvents(series, event6),
					Predicates.in(getSeriesResultsPilots(series, event6)));
			checkSeriesAtEvent6(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	private void checkSeriesAtEvent6(Scores scores) throws Exception {
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
		Event event6 = eventDAO.find(series, EVENT6_NAME);
		Race race22 = raceDAO.find(event6, RACE22_NAME);
		Race race23 = raceDAO.find(event6, RACE23_NAME);
		Race race24 = raceDAO.find(event6, RACE24_NAME);
		Race race25 = raceDAO.find(event6, RACE25_NAME);
		Race race26 = raceDAO.find(event6, RACE26_NAME);
		Race race27 = raceDAO.find(event6, RACE27_NAME);
		Race race28 = raceDAO.find(event6, RACE28_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT6, scores.getPilots().size());

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

		RaceAssertUtil race22AssertUtil = new RaceAssertUtil(scores, race22);
		race22AssertUtil.assertPilot(sco116, 3, 0, false, 0, 1);
		race22AssertUtil.assertPilot(sco808, 3, 0, false, 2, 2);
		race22AssertUtil.assertPilot(sco066, 3, 0, false, 3, 3);
		race22AssertUtil.assertPilot(sco159, 3, 0, false, 4, 4);
		race22AssertUtil.assertPilot(sco018, 2, 0, false, 5, 5);
		race22AssertUtil.assertPilot(sco087, 2, 0, false, 6, 6);
		race22AssertUtil.assertPilot(sco156, 0, 0, false, 10, 7);
		race22AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
		race22AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
		race22AssertUtil.assertPilot(sco060, 0, 0, false, 14, 10);
		race22AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
		race22AssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
		race22AssertUtil.assertPilot(sco179, 0, 0, false, 14, 10);
		race22AssertUtil.assertDone(0);

		RaceAssertUtil race23AssertUtil = new RaceAssertUtil(scores, race23);
		race23AssertUtil.assertPilot(sco808, 2, 0, false, 0, 1);
		race23AssertUtil.assertPilot(sco116, 2, 0, false, 2, 2);
		race23AssertUtil.assertPilot(sco066, 2, 0, false, 3, 3);
		race23AssertUtil.assertPilot(sco159, 2, 0, false, 4, 4);
		race23AssertUtil.assertPilot(sco156, 1, 0, false, 5, 5);
		race23AssertUtil.assertPilot(sco018, 0, 0, false, 10, 6);
		race23AssertUtil.assertPilot(sco087, 0, 0, false, 10, 6);
		race23AssertUtil.assertPilot(sco296, 0, 0, false, 10, 6);
		race23AssertUtil.assertPilot(sco884, 0, 0, false, 10, 6);
		race23AssertUtil.assertPilot(sco060, 0, 0, false, 14, 10);
		race23AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
		race23AssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
		race23AssertUtil.assertPilot(sco179, 0, 0, false, 14, 10);
		race23AssertUtil.assertDone(0);

		RaceAssertUtil race24AssertUtil = new RaceAssertUtil(scores, race24);
		race24AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race24AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race24AssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
		race24AssertUtil.assertPilot(sco087, 5, 0, false, 4, 4);
		race24AssertUtil.assertPilot(sco156, 4, 0, false, 5, 5);
		race24AssertUtil.assertPilot(sco066, 4, 0, false, 6, 6);
		race24AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
		race24AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
		race24AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
		race24AssertUtil.assertPilot(sco060, 0, 0, false, 14, 10);
		race24AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
		race24AssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
		race24AssertUtil.assertPilot(sco179, 0, 0, false, 14, 10);
		race24AssertUtil.assertDone(0);

		RaceAssertUtil race25AssertUtil = new RaceAssertUtil(scores, race25);
		race25AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
		race25AssertUtil.assertPilot(sco808, 7, 0, false, 2, 2);
		race25AssertUtil.assertPilot(sco066, 7, 0, false, 3, 3);
		race25AssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
		race25AssertUtil.assertPilot(sco156, 6, 0, false, 5, 5);
		race25AssertUtil.assertPilot(sco087, 6, 0, false, 6, 6);
		race25AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
		race25AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
		race25AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
		race25AssertUtil.assertPilot(sco060, 0, 0, false, 14, 10);
		race25AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
		race25AssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
		race25AssertUtil.assertPilot(sco179, 0, 0, false, 14, 10);
		race25AssertUtil.assertDone(0);

		RaceAssertUtil race26AssertUtil = new RaceAssertUtil(scores, race26);
		race26AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
		race26AssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
		race26AssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
		race26AssertUtil.assertPilot(sco066, 7, 0, false, 4, 4);
		race26AssertUtil.assertPilot(sco087, 6, 0, false, 5, 5);
		race26AssertUtil.assertPilot(sco156, 6, 0, false, 6, 6);
		race26AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
		race26AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
		race26AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
		race26AssertUtil.assertPilot(sco060, 0, 0, false, 14, 10);
		race26AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
		race26AssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
		race26AssertUtil.assertPilot(sco179, 0, 0, false, 14, 10);
		race26AssertUtil.assertDone(0);

		RaceAssertUtil race27AssertUtil = new RaceAssertUtil(scores, race27);
		race27AssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
		race27AssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
		race27AssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
		race27AssertUtil.assertPilot(sco087, 7, 0, false, 4, 4);
		race27AssertUtil.assertPilot(sco156, 5, 0, false, 5, 5);
		race27AssertUtil.assertPilot(sco066, 1, 0, false, 6, 6);
		race27AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
		race27AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
		race27AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
		race27AssertUtil.assertPilot(sco060, 0, 0, false, 14, 10);
		race27AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
		race27AssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
		race27AssertUtil.assertPilot(sco179, 0, 0, false, 14, 10);
		race27AssertUtil.assertDone(0);

		RaceAssertUtil race28AssertUtil = new RaceAssertUtil(scores, race28);
		race28AssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
		race28AssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
		race28AssertUtil.assertPilot(sco808, 6, 0, false, 3, 3);
		race28AssertUtil.assertPilot(sco066, 4, 1, false, 4, 4);
		race28AssertUtil.assertPilot(sco087, 4, 0, false, 5, 5);
		race28AssertUtil.assertPilot(sco156, 3, 0, false, 6, 6);
		race28AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
		race28AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
		race28AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
		race28AssertUtil.assertPilot(sco060, 0, 0, false, 14, 10);
		race28AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
		race28AssertUtil.assertPilot(sco153, 0, 0, false, 14, 10);
		race28AssertUtil.assertPilot(sco179, 0, 0, false, 14, 10);
		race28AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco116, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0);
		overallAssertUtil.assertPilot(sco808, 0, 49, 2, 14, 14, 14, 14, 14, 14, 7);
		overallAssertUtil.assertPilot(sco159, 1, 83, 3, 14, 14, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco066, 2, 98, 4, 14, 14, 14, 14, 9, 8, 7);
		overallAssertUtil.assertPilot(sco018, 1, 133, 5, 14, 14, 14, 14, 10, 10, 10);
		overallAssertUtil.assertPilot(sco156, 0, 139, 6, 14, 14, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco179, 0, 144, 7, 14, 14, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco296, 1, 149, 8, 14, 14, 14, 14, 10, 10, 10);
		overallAssertUtil.assertPilot(sco884, 0, 193, 9, 14, 14, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco087, 0, 198, 10, 14, 14, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco081, 0, 254, 11, 14, 14, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco060, 0, 258, 12, 14, 14, 14, 14, 14, 14, 14);
		overallAssertUtil.assertPilot(sco153, 0, 268, 13, 14, 14, 14, 14, 14, 14, 14);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent6() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race22 = raceDAO.find(event6, RACE22_NAME);
			Race race23 = raceDAO.find(event6, RACE23_NAME);
			Race race24 = raceDAO.find(event6, RACE24_NAME);
			Race race25 = raceDAO.find(event6, RACE25_NAME);
			Race race26 = raceDAO.find(event6, RACE26_NAME);
			Race race27 = raceDAO.find(event6, RACE27_NAME);
			Race race28 = raceDAO.find(event6, RACE28_NAME);

			Scores scores = scorer.scoreEvent(event6, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race22));
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race23));
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race24));
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race25));
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race26));
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race27));
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race28));

			RaceAssertUtil race22AssertUtil = new RaceAssertUtil(scores, race22);
			race22AssertUtil.assertPilot(sco116, 3, 0, false, 0, 1);
			race22AssertUtil.assertPilot(sco808, 3, 0, false, 2, 2);
			race22AssertUtil.assertPilot(sco066, 3, 0, false, 3, 3);
			race22AssertUtil.assertPilot(sco159, 3, 0, false, 4, 4);
			race22AssertUtil.assertPilot(sco018, 2, 0, false, 5, 5);
			race22AssertUtil.assertPilot(sco087, 2, 0, false, 6, 6);
			race22AssertUtil.assertPilot(sco156, 0, 0, false, 10, 7);
			race22AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			race22AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			race22AssertUtil.assertDone(0);

			RaceAssertUtil race23AssertUtil = new RaceAssertUtil(scores, race23);
			race23AssertUtil.assertPilot(sco808, 2, 0, false, 0, 1);
			race23AssertUtil.assertPilot(sco116, 2, 0, false, 2, 2);
			race23AssertUtil.assertPilot(sco066, 2, 0, false, 3, 3);
			race23AssertUtil.assertPilot(sco159, 2, 0, false, 4, 4);
			race23AssertUtil.assertPilot(sco156, 1, 0, false, 5, 5);
			race23AssertUtil.assertPilot(sco018, 0, 0, false, 10, 6);
			race23AssertUtil.assertPilot(sco087, 0, 0, false, 10, 6);
			race23AssertUtil.assertPilot(sco296, 0, 0, false, 10, 6);
			race23AssertUtil.assertPilot(sco884, 0, 0, false, 10, 6);
			race23AssertUtil.assertDone(0);

			RaceAssertUtil race24AssertUtil = new RaceAssertUtil(scores, race24);
			race24AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			race24AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
			race24AssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			race24AssertUtil.assertPilot(sco087, 5, 0, false, 4, 4);
			race24AssertUtil.assertPilot(sco156, 4, 0, false, 5, 5);
			race24AssertUtil.assertPilot(sco066, 4, 0, false, 6, 6);
			race24AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			race24AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			race24AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			race24AssertUtil.assertDone(0);

			RaceAssertUtil race25AssertUtil = new RaceAssertUtil(scores, race25);
			race25AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			race25AssertUtil.assertPilot(sco808, 7, 0, false, 2, 2);
			race25AssertUtil.assertPilot(sco066, 7, 0, false, 3, 3);
			race25AssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
			race25AssertUtil.assertPilot(sco156, 6, 0, false, 5, 5);
			race25AssertUtil.assertPilot(sco087, 6, 0, false, 6, 6);
			race25AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			race25AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			race25AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			race25AssertUtil.assertDone(0);

			RaceAssertUtil race26AssertUtil = new RaceAssertUtil(scores, race26);
			race26AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			race26AssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
			race26AssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
			race26AssertUtil.assertPilot(sco066, 7, 0, false, 4, 4);
			race26AssertUtil.assertPilot(sco087, 6, 0, false, 5, 5);
			race26AssertUtil.assertPilot(sco156, 6, 0, false, 6, 6);
			race26AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			race26AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			race26AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			race26AssertUtil.assertDone(0);

			RaceAssertUtil race27AssertUtil = new RaceAssertUtil(scores, race27);
			race27AssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
			race27AssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
			race27AssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
			race27AssertUtil.assertPilot(sco087, 7, 0, false, 4, 4);
			race27AssertUtil.assertPilot(sco156, 5, 0, false, 5, 5);
			race27AssertUtil.assertPilot(sco066, 1, 0, false, 6, 6);
			race27AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			race27AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			race27AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			race27AssertUtil.assertDone(0);

			RaceAssertUtil race28AssertUtil = new RaceAssertUtil(scores, race28);
			race28AssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
			race28AssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
			race28AssertUtil.assertPilot(sco808, 6, 0, false, 3, 3);
			race28AssertUtil.assertPilot(sco066, 4, 1, false, 4, 4);
			race28AssertUtil.assertPilot(sco087, 4, 0, false, 5, 5);
			race28AssertUtil.assertPilot(sco156, 3, 0, false, 6, 6);
			race28AssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			race28AssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			race28AssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			race28AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1, 2);
			overallAssertUtil.assertPilot(sco808, 0, 12, 2, 3);
			overallAssertUtil.assertPilot(sco159, 0, 17, 3, 4);
			overallAssertUtil.assertPilot(sco066, 1, 24, 4, 6);
			overallAssertUtil.assertPilot(sco087, 0, 30, 5, 10);
			overallAssertUtil.assertPilot(sco156, 0, 32, 6, 10);
			overallAssertUtil.assertPilot(sco018, 0, 55, 7, 10);
			overallAssertUtil.assertPilot(sco296, 0, 60, 8, 10);
			overallAssertUtil.assertPilot(sco884, 0, 60, 8, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace22() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race22 = raceDAO.find(event6, RACE22_NAME);

			Scores scores = scorer.scoreRace(race22, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race22));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race22);
			raceAssertUtil.assertPilot(sco116, 3, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 3, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco066, 3, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 3, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco018, 2, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco087, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco156, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco066, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco018, 0, 5, 5);
			overallAssertUtil.assertPilot(sco087, 0, 6, 6);
			overallAssertUtil.assertPilot(sco156, 0, 10, 7);
			overallAssertUtil.assertPilot(sco296, 0, 10, 7);
			overallAssertUtil.assertPilot(sco884, 0, 10, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace23() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race23 = raceDAO.find(event6, RACE23_NAME);

			Scores scores = scorer.scoreRace(race23, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race23));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race23);
			raceAssertUtil.assertPilot(sco808, 2, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 2, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco066, 2, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 2, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco156, 1, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 10, 6);
			raceAssertUtil.assertPilot(sco087, 0, 0, false, 10, 6);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 10, 6);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 10, 6);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco808, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco066, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco156, 0, 5, 5);
			overallAssertUtil.assertPilot(sco018, 0, 10, 6);
			overallAssertUtil.assertPilot(sco087, 0, 10, 6);
			overallAssertUtil.assertPilot(sco296, 0, 10, 6);
			overallAssertUtil.assertPilot(sco884, 0, 10, 6);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace24() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race24 = raceDAO.find(event6, RACE24_NAME);

			Scores scores = scorer.scoreRace(race24, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race24));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race24);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco087, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco156, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco066, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco087, 0, 4, 4);
			overallAssertUtil.assertPilot(sco156, 0, 5, 5);
			overallAssertUtil.assertPilot(sco066, 0, 6, 6);
			overallAssertUtil.assertPilot(sco018, 0, 10, 7);
			overallAssertUtil.assertPilot(sco296, 0, 10, 7);
			overallAssertUtil.assertPilot(sco884, 0, 10, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace25() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race25 = raceDAO.find(event6, RACE25_NAME);

			Scores scores = scorer.scoreRace(race25, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race25));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race25);
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco066, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco156, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco087, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco066, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco156, 0, 5, 5);
			overallAssertUtil.assertPilot(sco087, 0, 6, 6);
			overallAssertUtil.assertPilot(sco018, 0, 10, 7);
			overallAssertUtil.assertPilot(sco296, 0, 10, 7);
			overallAssertUtil.assertPilot(sco884, 0, 10, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace26() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race26 = raceDAO.find(event6, RACE26_NAME);

			Scores scores = scorer.scoreRace(race26, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race26));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race26);
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco066, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco087, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco156, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(sco066, 0, 4, 4);
			overallAssertUtil.assertPilot(sco087, 0, 5, 5);
			overallAssertUtil.assertPilot(sco156, 0, 6, 6);
			overallAssertUtil.assertPilot(sco018, 0, 10, 7);
			overallAssertUtil.assertPilot(sco296, 0, 10, 7);
			overallAssertUtil.assertPilot(sco884, 0, 10, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace27() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race27 = raceDAO.find(event6, RACE27_NAME);

			Scores scores = scorer.scoreRace(race27, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race27));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race27);
			raceAssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco087, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco156, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco066, 1, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(sco087, 0, 4, 4);
			overallAssertUtil.assertPilot(sco156, 0, 5, 5);
			overallAssertUtil.assertPilot(sco066, 0, 6, 6);
			overallAssertUtil.assertPilot(sco018, 0, 10, 7);
			overallAssertUtil.assertPilot(sco296, 0, 10, 7);
			overallAssertUtil.assertPilot(sco884, 0, 10, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace28() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race28 = raceDAO.find(event6, RACE28_NAME);

			Scores scores = scorer.scoreRace(race28, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT6_FLEET, scores.getFleetSize(race28));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race28);
			raceAssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco066, 4, 1, false, 4, 4);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco156, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 10, 7);
			raceAssertUtil.assertPilot(sco884, 0, 0, false, 10, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(sco066, 1, 5, 4);
			overallAssertUtil.assertPilot(sco087, 0, 5, 5);
			overallAssertUtil.assertPilot(sco156, 0, 6, 6);
			overallAssertUtil.assertPilot(sco018, 0, 10, 7);
			overallAssertUtil.assertPilot(sco296, 0, 10, 7);
			overallAssertUtil.assertPilot(sco884, 0, 10, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}