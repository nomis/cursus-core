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
package org.spka.cursus.test.cc_2013;

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
 * Scores at the end of event 2 (15/06/2013 to 16/06/2013)
 */
public class Series2013Top5Event2Scores extends Series2013Top5Event1Scores {
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
		Race race6 = raceDAO.find(event1, RACE6_NAME);
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race7 = raceDAO.find(event2, RACE7_NAME);
		Race race8 = raceDAO.find(event2, RACE8_NAME);
		Race race9 = raceDAO.find(event2, RACE9_NAME);
		Race race10 = raceDAO.find(event2, RACE10_NAME);
		Race race11 = raceDAO.find(event2, RACE11_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT2, scores.getPilots().size());
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

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1, true);
		race1AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race1AssertUtil.assertPilot(ir181, 7, 0, false, 2, 2);
		race1AssertUtil.assertPilot(ir001, 6, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco159, 6, 1, false, 5, 5);
		race1AssertUtil.assertPilot(sco666, 5, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco808, 5, 0, false, 7, 7);
		race1AssertUtil.assertPilot(ir085, 5, 0, false, 8, 8);
		race1AssertUtil.assertPilot(ir014, 4, 1, false, 9, 9);
		race1AssertUtil.assertPilot(ir053, 3, 0, false, 10, 10);
		race1AssertUtil.assertPilot(sco153, 4, 0, true, 0, 11);
		race1AssertUtil.assertPilot(ir077, 2, 0, true, 0, 12);
		race1AssertUtil.assertPilot(ir016, 2, 0, true, 0, 13);
		race1AssertUtil.assertPilot(ir025, 2, 0, true, 0, 14);
		race1AssertUtil.assertPilot(sco060, 1, 0, true, 0, 15);
		race1AssertUtil.assertPilot(sco018, 0, 0, true, 0, 16);
		race1AssertUtil.assertPilot(sco068, 0, 0, true, 0, 16);
		race1AssertUtil.assertPilot(sco087, 0, 0, true, 0, 16);
		race1AssertUtil.assertPilot(sco156, 0, 0, true, 0, 16);
		race1AssertUtil.assertPilot(sco179, 0, 0, true, 0, 16);
		race1AssertUtil.assertPilot(sco200, 0, 0, true, 0, 16);
		race1AssertUtil.assertDone(11);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2, true);
		race2AssertUtil.assertPilot(ir014, 5, 0, false, 0, 1);
		race2AssertUtil.assertPilot(ir001, 5, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco528, 5, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
		race2AssertUtil.assertPilot(ir085, 5, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco116, 4, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco666, 4, 0, false, 7, 7);
		race2AssertUtil.assertPilot(ir053, 4, 0, false, 8, 8);
		race2AssertUtil.assertPilot(ir025, 4, 0, false, 9, 9);
		race2AssertUtil.assertPilot(sco159, 4, 0, false, 10, 10);
		race2AssertUtil.assertPilot(ir077, 4, 0, true, 0, 11);
		race2AssertUtil.assertPilot(ir016, 3, 0, true, 0, 12);
		race2AssertUtil.assertPilot(sco153, 2, 0, true, 0, 13);
		race2AssertUtil.assertPilot(ir181, 0, 0, true, 0, 14);
		race2AssertUtil.assertPilot(sco018, 0, 0, true, 0, 14);
		race2AssertUtil.assertPilot(sco060, 0, 0, true, 0, 14);
		race2AssertUtil.assertPilot(sco068, 0, 0, true, 0, 14);
		race2AssertUtil.assertPilot(sco087, 0, 0, true, 0, 14);
		race2AssertUtil.assertPilot(sco156, 0, 0, true, 0, 14);
		race2AssertUtil.assertPilot(sco179, 0, 0, true, 0, 14);
		race2AssertUtil.assertPilot(sco200, 0, 0, true, 0, 14);
		race2AssertUtil.assertDone(11);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3, true);
		race3AssertUtil.assertPilot(ir181, 5, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco159, 4, 0, false, 3, 2);
		race3AssertUtil.assertPilot(sco808, 4, 0, false, 4, 3);
		race3AssertUtil.assertPilot(ir001, 5, 3, false, 2, 4);
		race3AssertUtil.assertPilot(sco528, 4, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco116, 4, 0, false, 6, 6);
		race3AssertUtil.assertPilot(ir085, 4, 0, false, 7, 7);
		race3AssertUtil.assertPilot(ir014, 3, 0, false, 8, 8);
		race3AssertUtil.assertPilot(sco666, 3, 0, false, 9, 9);
		race3AssertUtil.assertPilot(ir025, 3, 0, false, 10, 10);
		race3AssertUtil.assertPilot(ir016, 3, 0, true, 0, 11);
		race3AssertUtil.assertPilot(ir077, 2, 0, true, 0, 12);
		race3AssertUtil.assertPilot(ir053, 2, 0, true, 0, 13);
		race3AssertUtil.assertPilot(sco153, 1, 0, true, 0, 14);
		race3AssertUtil.assertPilot(sco018, 0, 0, true, 0, 15);
		race3AssertUtil.assertPilot(sco060, 0, 0, true, 0, 15);
		race3AssertUtil.assertPilot(sco068, 0, 0, true, 0, 15);
		race3AssertUtil.assertPilot(sco087, 0, 0, true, 0, 15);
		race3AssertUtil.assertPilot(sco156, 0, 0, true, 0, 15);
		race3AssertUtil.assertPilot(sco179, 0, 0, true, 0, 15);
		race3AssertUtil.assertPilot(sco200, 0, 0, true, 0, 15);
		race3AssertUtil.assertDone(11);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4, true);
		race4AssertUtil.assertPilot(ir181, 4, 0, false, 0, 1);
		race4AssertUtil.assertPilot(ir001, 4, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco159, 3, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco808, 3, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco528, 3, 0, false, 5, 5);
		race4AssertUtil.assertPilot(ir085, 3, 0, false, 6, 6);
		race4AssertUtil.assertPilot(ir025, 3, 0, false, 7, 7);
		race4AssertUtil.assertPilot(ir077, 3, 0, false, 8, 8);
		race4AssertUtil.assertPilot(sco666, 2, 0, false, 9, 9);
		race4AssertUtil.assertPilot(sco116, 1, 0, false, 10, 10);
		race4AssertUtil.assertPilot(ir014, 2, 0, true, 0, 11);
		race4AssertUtil.assertPilot(ir016, 2, 0, true, 0, 12);
		race4AssertUtil.assertPilot(ir053, 2, 0, true, 0, 13);
		race4AssertUtil.assertPilot(sco018, 0, 0, true, 0, 14);
		race4AssertUtil.assertPilot(sco060, 0, 0, true, 0, 14);
		race4AssertUtil.assertPilot(sco068, 0, 0, true, 0, 14);
		race4AssertUtil.assertPilot(sco087, 0, 0, true, 0, 14);
		race4AssertUtil.assertPilot(sco153, 0, 0, true, 0, 14);
		race4AssertUtil.assertPilot(sco156, 0, 0, true, 0, 14);
		race4AssertUtil.assertPilot(sco179, 0, 0, true, 0, 14);
		race4AssertUtil.assertPilot(sco200, 0, 0, true, 0, 14);
		race4AssertUtil.assertDone(11);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5, true);
		race5AssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco116, 7, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
		race5AssertUtil.assertPilot(ir014, 7, 0, false, 4, 4);
		race5AssertUtil.assertPilot(ir025, 6, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
		race5AssertUtil.assertPilot(ir085, 5, 1, false, 7, 7);
		race5AssertUtil.assertPilot(sco528, 5, 0, false, 8, 8);
		race5AssertUtil.assertPilot(ir077, 4, 0, false, 9, 9);
		race5AssertUtil.assertPilot(sco666, 2, 0, false, 10, 10);
		race5AssertUtil.assertPilot(ir053, 3, 0, true, 0, 11);
		race5AssertUtil.assertPilot(ir001, 1, 0, true, 0, 12);
		race5AssertUtil.assertPilot(ir016, 1, 0, true, 0, 13);
		race5AssertUtil.assertPilot(sco018, 0, 0, true, 0, 14);
		race5AssertUtil.assertPilot(sco060, 0, 0, true, 0, 14);
		race5AssertUtil.assertPilot(sco068, 0, 0, true, 0, 14);
		race5AssertUtil.assertPilot(sco087, 0, 0, true, 0, 14);
		race5AssertUtil.assertPilot(sco153, 0, 0, true, 0, 14);
		race5AssertUtil.assertPilot(sco156, 0, 0, true, 0, 14);
		race5AssertUtil.assertPilot(sco179, 0, 0, true, 0, 14);
		race5AssertUtil.assertPilot(sco200, 0, 0, true, 0, 14);
		race5AssertUtil.assertDone(11);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6, true);
		race6AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race6AssertUtil.assertPilot(ir025, 7, 0, false, 2, 2);
		race6AssertUtil.assertPilot(ir014, 6, 1, false, 3, 3);
		race6AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco808, 6, 1, false, 5, 5);
		race6AssertUtil.assertPilot(ir001, 6, 0, false, 6, 6);
		race6AssertUtil.assertPilot(ir016, 4, 0, false, 7, 7);
		race6AssertUtil.assertPilot(sco159, 4, 0, false, 8, 8);
		race6AssertUtil.assertPilot(ir053, 3, 0, false, 9, 9);
		race6AssertUtil.assertPilot(sco153, 1, 0, false, 10, 10);
		race6AssertUtil.assertPilot(ir181, 3, 0, true, 0, 11);
		race6AssertUtil.assertPilot(ir085, 3, 0, true, 0, 12);
		race6AssertUtil.assertPilot(ir077, 2, 0, true, 0, 13);
		race6AssertUtil.assertPilot(sco018, 0, 0, true, 0, 14);
		race6AssertUtil.assertPilot(sco060, 0, 0, true, 0, 14);
		race6AssertUtil.assertPilot(sco068, 0, 0, true, 0, 14);
		race6AssertUtil.assertPilot(sco087, 0, 0, true, 0, 14);
		race6AssertUtil.assertPilot(sco156, 0, 0, true, 0, 14);
		race6AssertUtil.assertPilot(sco179, 0, 0, true, 0, 14);
		race6AssertUtil.assertPilot(sco200, 0, 0, true, 0, 14);
		race6AssertUtil.assertPilot(sco666, 0, 0, true, 0, 14);
		race6AssertUtil.assertDone(11);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7, true);
		race7AssertUtil.assertPilot(sco200, 6, 0, false, 0, 1);
		race7AssertUtil.assertPilot(ir001, 6, 0, false, 2, 2);
		race7AssertUtil.assertPilot(sco068, 6, 0, false, 3, 3);
		race7AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco808, 6, 0, false, 5, 5);
		race7AssertUtil.assertPilot(sco159, 5, 0, false, 6, 6);
		race7AssertUtil.assertPilot(ir085, 5, 0, false, 7, 7);
		race7AssertUtil.assertPilot(ir053, 5, 0, false, 8, 8);
		race7AssertUtil.assertPilot(ir181, 5, 0, false, 9, 9);
		race7AssertUtil.assertPilot(ir025, 4, 0, false, 10, 10);
		race7AssertUtil.assertPilot(sco179, 5, 0, true, 0, 11);
		race7AssertUtil.assertPilot(sco018, 5, 0, true, 0, 12);
		race7AssertUtil.assertPilot(ir077, 4, 0, true, 0, 13);
		race7AssertUtil.assertPilot(sco666, 4, 0, true, 0, 14);
		race7AssertUtil.assertPilot(sco116, 3, 0, true, 0, 15);
		race7AssertUtil.assertPilot(sco156, 3, 0, true, 0, 16);
		race7AssertUtil.assertPilot(ir016, 2, 0, true, 0, 17);
		race7AssertUtil.assertPilot(sco087, 2, 0, true, 0, 18);
		race7AssertUtil.assertPilot(ir014, 0, 0, true, 0, 19);
		race7AssertUtil.assertPilot(sco060, 0, 0, true, 0, 19);
		race7AssertUtil.assertPilot(sco153, 0, 0, true, 0, 19);
		race7AssertUtil.assertDone(11);

		RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8, true);
		race8AssertUtil.assertPilot(ir001, 6, 0, false, 0, 1);
		race8AssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
		race8AssertUtil.assertPilot(sco116, 6, 0, false, 3, 3);
		race8AssertUtil.assertPilot(sco200, 6, 0, false, 4, 4);
		race8AssertUtil.assertPilot(ir181, 6, 0, false, 5, 5);
		race8AssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
		race8AssertUtil.assertPilot(sco808, 6, 0, false, 7, 7);
		race8AssertUtil.assertPilot(ir025, 6, 0, false, 8, 8);
		race8AssertUtil.assertPilot(ir085, 5, 0, false, 9, 9);
		race8AssertUtil.assertPilot(ir077, 5, 0, false, 10, 10);
		race8AssertUtil.assertPilot(sco666, 6, 0, true, 0, 11);
		race8AssertUtil.assertPilot(sco528, 5, 0, true, 0, 12);
		race8AssertUtil.assertPilot(sco087, 5, 0, true, 0, 13);
		race8AssertUtil.assertPilot(sco068, 5, 0, true, 0, 14);
		race8AssertUtil.assertPilot(ir053, 5, 0, true, 0, 15);
		race8AssertUtil.assertPilot(ir016, 2, 0, true, 0, 16);
		race8AssertUtil.assertPilot(ir014, 0, 0, true, 0, 17);
		race8AssertUtil.assertPilot(sco018, 0, 0, true, 0, 17);
		race8AssertUtil.assertPilot(sco060, 0, 0, true, 0, 17);
		race8AssertUtil.assertPilot(sco153, 0, 0, true, 0, 17);
		race8AssertUtil.assertPilot(sco156, 0, 0, true, 0, 17);
		race8AssertUtil.assertDone(11);

		RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9, true);
		race9AssertUtil.assertPilot(sco200, 7, 0, false, 0, 1);
		race9AssertUtil.assertPilot(ir181, 7, 0, false, 2, 2);
		race9AssertUtil.assertPilot(sco116, 7, 0, false, 3, 3);
		race9AssertUtil.assertPilot(sco159, 7, 0, false, 4, 4);
		race9AssertUtil.assertPilot(sco068, 7, 0, false, 5, 5);
		race9AssertUtil.assertPilot(sco666, 7, 0, false, 6, 6);
		race9AssertUtil.assertPilot(ir025, 6, 0, false, 7, 7);
		race9AssertUtil.assertPilot(ir053, 6, 0, false, 8, 8);
		race9AssertUtil.assertPilot(ir016, 6, 0, false, 9, 9);
		race9AssertUtil.assertPilot(ir001, 5, 0, false, 10, 10);
		race9AssertUtil.assertPilot(sco808, 7, 0, true, 0, 11);
		race9AssertUtil.assertPilot(sco087, 6, 0, true, 0, 12);
		race9AssertUtil.assertPilot(sco528, 6, 0, true, 0, 13);
		race9AssertUtil.assertPilot(sco179, 5, 0, true, 0, 14);
		race9AssertUtil.assertPilot(sco156, 5, 0, true, 0, 15);
		race9AssertUtil.assertPilot(ir085, 4, 0, true, 0, 16);
		race9AssertUtil.assertPilot(ir014, 0, 0, true, 0, 17);
		race9AssertUtil.assertPilot(ir077, 0, 0, true, 0, 17);
		race9AssertUtil.assertPilot(sco018, 0, 0, true, 0, 17);
		race9AssertUtil.assertPilot(sco060, 0, 0, true, 0, 17);
		race9AssertUtil.assertPilot(sco153, 0, 0, true, 0, 17);
		race9AssertUtil.assertDone(11);

		RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10, true);
		race10AssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
		race10AssertUtil.assertPilot(sco200, 7, 0, false, 2, 2);
		race10AssertUtil.assertPilot(ir001, 7, 0, false, 3, 3);
		race10AssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
		race10AssertUtil.assertPilot(sco116, 7, 0, false, 5, 5);
		race10AssertUtil.assertPilot(sco068, 7, 0, false, 6, 6);
		race10AssertUtil.assertPilot(sco808, 7, 0, false, 7, 7);
		race10AssertUtil.assertPilot(ir053, 6, 0, false, 8, 8);
		race10AssertUtil.assertPilot(ir085, 6, 0, false, 9, 9);
		race10AssertUtil.assertPilot(ir025, 5, 0, false, 10, 10);
		race10AssertUtil.assertPilot(sco666, 6, 0, true, 0, 11);
		race10AssertUtil.assertPilot(sco528, 6, 0, true, 0, 12);
		race10AssertUtil.assertPilot(sco159, 6, 0, true, 0, 13);
		race10AssertUtil.assertPilot(sco087, 5, 0, true, 0, 14);
		race10AssertUtil.assertPilot(ir016, 4, 0, true, 0, 15);
		race10AssertUtil.assertPilot(sco156, 4, 0, true, 0, 16);
		race10AssertUtil.assertPilot(ir077, 2, 0, true, 0, 17);
		race10AssertUtil.assertPilot(ir014, 0, 0, true, 0, 18);
		race10AssertUtil.assertPilot(sco018, 0, 0, true, 0, 18);
		race10AssertUtil.assertPilot(sco060, 0, 0, true, 0, 18);
		race10AssertUtil.assertPilot(sco153, 0, 0, true, 0, 18);
		race10AssertUtil.assertDone(11);

		RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11, true);
		race11AssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
		race11AssertUtil.assertPilot(sco200, 7, 0, false, 2, 2);
		race11AssertUtil.assertPilot(ir001, 7, 0, false, 3, 3);
		race11AssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
		race11AssertUtil.assertPilot(ir085, 7, 0, false, 5, 5);
		race11AssertUtil.assertPilot(sco159, 7, 0, false, 6, 6);
		race11AssertUtil.assertPilot(sco116, 7, 0, false, 7, 7);
		race11AssertUtil.assertPilot(sco808, 6, 0, false, 8, 8);
		race11AssertUtil.assertPilot(ir025, 6, 0, false, 9, 9);
		race11AssertUtil.assertPilot(ir053, 4, 0, false, 10, 10);
		race11AssertUtil.assertPilot(sco528, 6, 0, true, 0, 11);
		race11AssertUtil.assertPilot(sco666, 5, 0, true, 0, 12);
		race11AssertUtil.assertPilot(ir016, 3, 0, true, 0, 13);
		race11AssertUtil.assertPilot(sco156, 2, 0, true, 0, 14);
		race11AssertUtil.assertPilot(sco087, 1, 0, true, 0, 15);
		race11AssertUtil.assertPilot(ir014, 0, 0, true, 0, 16);
		race11AssertUtil.assertPilot(ir077, 0, 0, true, 0, 16);
		race11AssertUtil.assertPilot(sco018, 0, 0, true, 0, 16);
		race11AssertUtil.assertPilot(sco060, 0, 0, true, 0, 16);
		race11AssertUtil.assertPilot(sco068, 0, 0, true, 0, 16);
		race11AssertUtil.assertPilot(sco153, 0, 0, true, 0, 16);
		race11AssertUtil.assertDone(11);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco200, 0, 8, 1);
		overallAssertUtil.assertPilot(ir181, 0, 18, 2);
		overallAssertUtil.assertPilot(sco179, 0, 10, 3);
		overallAssertUtil.assertPilot(ir001, 3, 36, 4);
		overallAssertUtil.assertPilot(sco116, 0, 42, 5);
		overallAssertUtil.assertPilot(sco068, 0, 14, 6);
		overallAssertUtil.assertPilot(sco528, 0, 33, 7);
		overallAssertUtil.assertPilot(ir014, 2, 26, 8);
		overallAssertUtil.assertPilot(sco808, 1, 55, 9);
		overallAssertUtil.assertPilot(sco159, 1, 58, 10);
		overallAssertUtil.assertPilot(ir085, 1, 64, 11);
		overallAssertUtil.assertPilot(ir025, 0, 77, 12);
		overallAssertUtil.assertPilot(sco666, 0, 47, 13);
		overallAssertUtil.assertPilot(ir016, 0, 16, 14);
		overallAssertUtil.assertPilot(ir053, 0, 61, 15);
		overallAssertUtil.assertPilot(ir077, 0, 27, 16);
		overallAssertUtil.assertPilot(sco153, 0, 10, 17);
		overallAssertUtil.assertPilot(sco018, 0, 0, 18);
		overallAssertUtil.assertPilot(sco060, 0, 0, 18);
		overallAssertUtil.assertPilot(sco087, 0, 0, 18);
		overallAssertUtil.assertPilot(sco156, 0, 0, 18);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent2() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race7 = raceDAO.find(event2, RACE7_NAME);
			Race race8 = raceDAO.find(event2, RACE8_NAME);
			Race race9 = raceDAO.find(event2, RACE9_NAME);
			Race race10 = raceDAO.find(event2, RACE10_NAME);
			Race race11 = raceDAO.find(event2, RACE11_NAME);

			Scores scores = scorer.scoreEvent(event2, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race7));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race8));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race9));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race10));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race11));

			RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7, true);
			race7AssertUtil.assertPilot(sco200, 6, 0, false, 0, 1);
			race7AssertUtil.assertPilot(ir001, 6, 0, false, 2, 2);
			race7AssertUtil.assertPilot(sco068, 6, 0, false, 3, 3);
			race7AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
			race7AssertUtil.assertPilot(sco808, 6, 0, false, 5, 5);
			race7AssertUtil.assertPilot(sco159, 5, 0, false, 6, 6);
			race7AssertUtil.assertPilot(ir085, 5, 0, false, 7, 7);
			race7AssertUtil.assertPilot(ir053, 5, 0, false, 8, 8);
			race7AssertUtil.assertPilot(ir181, 5, 0, false, 9, 9);
			race7AssertUtil.assertPilot(ir025, 4, 0, false, 10, 10);
			race7AssertUtil.assertPilot(sco179, 5, 0, true, 0, 11);
			race7AssertUtil.assertPilot(sco018, 5, 0, true, 0, 12);
			race7AssertUtil.assertPilot(ir077, 4, 0, true, 0, 13);
			race7AssertUtil.assertPilot(sco666, 4, 0, true, 0, 14);
			race7AssertUtil.assertPilot(sco116, 3, 0, true, 0, 15);
			race7AssertUtil.assertPilot(sco156, 3, 0, true, 0, 16);
			race7AssertUtil.assertPilot(ir016, 2, 0, true, 0, 17);
			race7AssertUtil.assertPilot(sco087, 2, 0, true, 0, 18);
			race7AssertUtil.assertDone(8);

			RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8, true);
			race8AssertUtil.assertPilot(ir001, 6, 0, false, 0, 1);
			race8AssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
			race8AssertUtil.assertPilot(sco116, 6, 0, false, 3, 3);
			race8AssertUtil.assertPilot(sco200, 6, 0, false, 4, 4);
			race8AssertUtil.assertPilot(ir181, 6, 0, false, 5, 5);
			race8AssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
			race8AssertUtil.assertPilot(sco808, 6, 0, false, 7, 7);
			race8AssertUtil.assertPilot(ir025, 6, 0, false, 8, 8);
			race8AssertUtil.assertPilot(ir085, 5, 0, false, 9, 9);
			race8AssertUtil.assertPilot(ir077, 5, 0, false, 10, 10);
			race8AssertUtil.assertPilot(sco666, 6, 0, true, 0, 11);
			race8AssertUtil.assertPilot(sco528, 5, 0, true, 0, 12);
			race8AssertUtil.assertPilot(sco087, 5, 0, true, 0, 13);
			race8AssertUtil.assertPilot(sco068, 5, 0, true, 0, 14);
			race8AssertUtil.assertPilot(ir053, 5, 0, true, 0, 15);
			race8AssertUtil.assertPilot(ir016, 2, 0, true, 0, 16);
			race8AssertUtil.assertPilot(sco018, 0, 0, true, 0, 17);
			race8AssertUtil.assertPilot(sco156, 0, 0, true, 0, 17);
			race8AssertUtil.assertDone(8);

			RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9, true);
			race9AssertUtil.assertPilot(sco200, 7, 0, false, 0, 1);
			race9AssertUtil.assertPilot(ir181, 7, 0, false, 2, 2);
			race9AssertUtil.assertPilot(sco116, 7, 0, false, 3, 3);
			race9AssertUtil.assertPilot(sco159, 7, 0, false, 4, 4);
			race9AssertUtil.assertPilot(sco068, 7, 0, false, 5, 5);
			race9AssertUtil.assertPilot(sco666, 7, 0, false, 6, 6);
			race9AssertUtil.assertPilot(ir025, 6, 0, false, 7, 7);
			race9AssertUtil.assertPilot(ir053, 6, 0, false, 8, 8);
			race9AssertUtil.assertPilot(ir016, 6, 0, false, 9, 9);
			race9AssertUtil.assertPilot(ir001, 5, 0, false, 10, 10);
			race9AssertUtil.assertPilot(sco808, 7, 0, true, 0, 11);
			race9AssertUtil.assertPilot(sco087, 6, 0, true, 0, 12);
			race9AssertUtil.assertPilot(sco528, 6, 0, true, 0, 13);
			race9AssertUtil.assertPilot(sco179, 5, 0, true, 0, 14);
			race9AssertUtil.assertPilot(sco156, 5, 0, true, 0, 15);
			race9AssertUtil.assertPilot(ir085, 4, 0, true, 0, 16);
			race9AssertUtil.assertPilot(ir077, 0, 0, true, 0, 17);
			race9AssertUtil.assertPilot(sco018, 0, 0, true, 0, 17);
			race9AssertUtil.assertDone(8);

			RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10, true);
			race10AssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
			race10AssertUtil.assertPilot(sco200, 7, 0, false, 2, 2);
			race10AssertUtil.assertPilot(ir001, 7, 0, false, 3, 3);
			race10AssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
			race10AssertUtil.assertPilot(sco116, 7, 0, false, 5, 5);
			race10AssertUtil.assertPilot(sco068, 7, 0, false, 6, 6);
			race10AssertUtil.assertPilot(sco808, 7, 0, false, 7, 7);
			race10AssertUtil.assertPilot(ir053, 6, 0, false, 8, 8);
			race10AssertUtil.assertPilot(ir085, 6, 0, false, 9, 9);
			race10AssertUtil.assertPilot(ir025, 5, 0, false, 10, 10);
			race10AssertUtil.assertPilot(sco666, 6, 0, true, 0, 11);
			race10AssertUtil.assertPilot(sco528, 6, 0, true, 0, 12);
			race10AssertUtil.assertPilot(sco159, 6, 0, true, 0, 13);
			race10AssertUtil.assertPilot(sco087, 5, 0, true, 0, 14);
			race10AssertUtil.assertPilot(ir016, 4, 0, true, 0, 15);
			race10AssertUtil.assertPilot(sco156, 4, 0, true, 0, 16);
			race10AssertUtil.assertPilot(ir077, 2, 0, true, 0, 17);
			race10AssertUtil.assertPilot(sco018, 0, 0, true, 0, 18);
			race10AssertUtil.assertDone(8);

			RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11, true);
			race11AssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
			race11AssertUtil.assertPilot(sco200, 7, 0, false, 2, 2);
			race11AssertUtil.assertPilot(ir001, 7, 0, false, 3, 3);
			race11AssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
			race11AssertUtil.assertPilot(ir085, 7, 0, false, 5, 5);
			race11AssertUtil.assertPilot(sco159, 7, 0, false, 6, 6);
			race11AssertUtil.assertPilot(sco116, 7, 0, false, 7, 7);
			race11AssertUtil.assertPilot(sco808, 6, 0, false, 8, 8);
			race11AssertUtil.assertPilot(ir025, 6, 0, false, 9, 9);
			race11AssertUtil.assertPilot(ir053, 4, 0, false, 10, 10);
			race11AssertUtil.assertPilot(sco528, 6, 0, true, 0, 11);
			race11AssertUtil.assertPilot(sco666, 5, 0, true, 0, 12);
			race11AssertUtil.assertPilot(ir016, 3, 0, true, 0, 13);
			race11AssertUtil.assertPilot(sco156, 2, 0, true, 0, 14);
			race11AssertUtil.assertPilot(sco087, 1, 0, true, 0, 15);
			race11AssertUtil.assertPilot(ir077, 0, 0, true, 0, 16);
			race11AssertUtil.assertPilot(sco018, 0, 0, true, 0, 16);
			race11AssertUtil.assertPilot(sco068, 0, 0, true, 0, 16);
			race11AssertUtil.assertDone(8);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 8, 1);
			overallAssertUtil.assertPilot(ir181, 0, 16, 2);
			overallAssertUtil.assertPilot(sco179, 0, 10, 3);
			overallAssertUtil.assertPilot(ir001, 0, 18, 4);
			overallAssertUtil.assertPilot(sco528, 0, 4, 5);
			overallAssertUtil.assertPilot(sco116, 0, 18, 6);
			overallAssertUtil.assertPilot(sco068, 0, 14, 7);
			overallAssertUtil.assertPilot(sco159, 0, 22, 8);
			overallAssertUtil.assertPilot(sco666, 0, 6, 9);
			overallAssertUtil.assertPilot(sco808, 0, 27, 10);
			overallAssertUtil.assertPilot(ir085, 0, 30, 11);
			overallAssertUtil.assertPilot(ir053, 0, 34, 12);
			overallAssertUtil.assertPilot(ir025, 0, 44, 13);
			overallAssertUtil.assertPilot(ir016, 0, 9, 14);
			overallAssertUtil.assertPilot(ir077, 0, 10, 15);
			overallAssertUtil.assertPilot(sco018, 0, 0, 16);
			overallAssertUtil.assertPilot(sco087, 0, 0, 16);
			overallAssertUtil.assertPilot(sco156, 0, 0, 16);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race7, true);
			raceAssertUtil.assertPilot(sco200, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir001, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco068, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir085, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir053, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir181, 5, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir025, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco179, 5, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco018, 5, 0, true, 0, 12);
			raceAssertUtil.assertPilot(ir077, 4, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco666, 4, 0, true, 0, 14);
			raceAssertUtil.assertPilot(sco116, 3, 0, true, 0, 15);
			raceAssertUtil.assertPilot(sco156, 3, 0, true, 0, 16);
			raceAssertUtil.assertPilot(ir016, 2, 0, true, 0, 17);
			raceAssertUtil.assertPilot(sco087, 2, 0, true, 0, 18);
			raceAssertUtil.assertDone(8);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(ir001, 0, 2, 2);
			overallAssertUtil.assertPilot(sco068, 0, 3, 3);
			overallAssertUtil.assertPilot(sco528, 0, 4, 4);
			overallAssertUtil.assertPilot(sco808, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(ir085, 0, 7, 7);
			overallAssertUtil.assertPilot(ir053, 0, 8, 8);
			overallAssertUtil.assertPilot(ir181, 0, 9, 9);
			overallAssertUtil.assertPilot(ir025, 0, 10, 10);
			overallAssertUtil.assertPilot(ir016, 0, 0, 11);
			overallAssertUtil.assertPilot(ir077, 0, 0, 11);
			overallAssertUtil.assertPilot(sco018, 0, 0, 11);
			overallAssertUtil.assertPilot(sco087, 0, 0, 11);
			overallAssertUtil.assertPilot(sco116, 0, 0, 11);
			overallAssertUtil.assertPilot(sco156, 0, 0, 11);
			overallAssertUtil.assertPilot(sco179, 0, 0, 11);
			overallAssertUtil.assertPilot(sco666, 0, 0, 11);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race8, true);
			raceAssertUtil.assertPilot(ir001, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco116, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco200, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir181, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir025, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir085, 5, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir077, 5, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco666, 6, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco528, 5, 0, true, 0, 12);
			raceAssertUtil.assertPilot(sco087, 5, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco068, 5, 0, true, 0, 14);
			raceAssertUtil.assertPilot(ir053, 5, 0, true, 0, 15);
			raceAssertUtil.assertPilot(ir016, 2, 0, true, 0, 16);
			raceAssertUtil.assertPilot(sco018, 0, 0, true, 0, 17);
			raceAssertUtil.assertPilot(sco156, 0, 0, true, 0, 17);
			raceAssertUtil.assertDone(8);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir001, 0, 0, 1);
			overallAssertUtil.assertPilot(sco179, 0, 2, 2);
			overallAssertUtil.assertPilot(sco116, 0, 3, 3);
			overallAssertUtil.assertPilot(sco200, 0, 4, 4);
			overallAssertUtil.assertPilot(ir181, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(sco808, 0, 7, 7);
			overallAssertUtil.assertPilot(ir025, 0, 8, 8);
			overallAssertUtil.assertPilot(ir085, 0, 9, 9);
			overallAssertUtil.assertPilot(ir077, 0, 10, 10);
			overallAssertUtil.assertPilot(ir016, 0, 0, 11);
			overallAssertUtil.assertPilot(ir053, 0, 0, 11);
			overallAssertUtil.assertPilot(sco018, 0, 0, 11);
			overallAssertUtil.assertPilot(sco068, 0, 0, 11);
			overallAssertUtil.assertPilot(sco087, 0, 0, 11);
			overallAssertUtil.assertPilot(sco156, 0, 0, 11);
			overallAssertUtil.assertPilot(sco528, 0, 0, 11);
			overallAssertUtil.assertPilot(sco666, 0, 0, 11);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race9, true);
			raceAssertUtil.assertPilot(sco200, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir181, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco068, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco666, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir025, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir053, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir016, 6, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir001, 5, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco808, 7, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco087, 6, 0, true, 0, 12);
			raceAssertUtil.assertPilot(sco528, 6, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco179, 5, 0, true, 0, 14);
			raceAssertUtil.assertPilot(sco156, 5, 0, true, 0, 15);
			raceAssertUtil.assertPilot(ir085, 4, 0, true, 0, 16);
			raceAssertUtil.assertPilot(ir077, 0, 0, true, 0, 17);
			raceAssertUtil.assertPilot(sco018, 0, 0, true, 0, 17);
			raceAssertUtil.assertDone(8);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(ir181, 0, 2, 2);
			overallAssertUtil.assertPilot(sco116, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco068, 0, 5, 5);
			overallAssertUtil.assertPilot(sco666, 0, 6, 6);
			overallAssertUtil.assertPilot(ir025, 0, 7, 7);
			overallAssertUtil.assertPilot(ir053, 0, 8, 8);
			overallAssertUtil.assertPilot(ir016, 0, 9, 9);
			overallAssertUtil.assertPilot(ir001, 0, 10, 10);
			overallAssertUtil.assertPilot(ir077, 0, 0, 11);
			overallAssertUtil.assertPilot(ir085, 0, 0, 11);
			overallAssertUtil.assertPilot(sco018, 0, 0, 11);
			overallAssertUtil.assertPilot(sco087, 0, 0, 11);
			overallAssertUtil.assertPilot(sco156, 0, 0, 11);
			overallAssertUtil.assertPilot(sco179, 0, 0, 11);
			overallAssertUtil.assertPilot(sco528, 0, 0, 11);
			overallAssertUtil.assertPilot(sco808, 0, 0, 11);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race10, true);
			raceAssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco200, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir001, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco068, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco808, 7, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir053, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir085, 6, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir025, 5, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco666, 6, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco528, 6, 0, true, 0, 12);
			raceAssertUtil.assertPilot(sco159, 6, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco087, 5, 0, true, 0, 14);
			raceAssertUtil.assertPilot(ir016, 4, 0, true, 0, 15);
			raceAssertUtil.assertPilot(sco156, 4, 0, true, 0, 16);
			raceAssertUtil.assertPilot(ir077, 2, 0, true, 0, 17);
			raceAssertUtil.assertPilot(sco018, 0, 0, true, 0, 18);
			raceAssertUtil.assertDone(8);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir181, 0, 0, 1);
			overallAssertUtil.assertPilot(sco200, 0, 2, 2);
			overallAssertUtil.assertPilot(ir001, 0, 3, 3);
			overallAssertUtil.assertPilot(sco179, 0, 4, 4);
			overallAssertUtil.assertPilot(sco116, 0, 5, 5);
			overallAssertUtil.assertPilot(sco068, 0, 6, 6);
			overallAssertUtil.assertPilot(sco808, 0, 7, 7);
			overallAssertUtil.assertPilot(ir053, 0, 8, 8);
			overallAssertUtil.assertPilot(ir085, 0, 9, 9);
			overallAssertUtil.assertPilot(ir025, 0, 10, 10);
			overallAssertUtil.assertPilot(ir016, 0, 0, 11);
			overallAssertUtil.assertPilot(ir077, 0, 0, 11);
			overallAssertUtil.assertPilot(sco018, 0, 0, 11);
			overallAssertUtil.assertPilot(sco087, 0, 0, 11);
			overallAssertUtil.assertPilot(sco156, 0, 0, 11);
			overallAssertUtil.assertPilot(sco159, 0, 0, 11);
			overallAssertUtil.assertPilot(sco528, 0, 0, 11);
			overallAssertUtil.assertPilot(sco666, 0, 0, 11);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race11, true);
			raceAssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco200, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir001, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir085, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco159, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir025, 6, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir053, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco528, 6, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco666, 5, 0, true, 0, 12);
			raceAssertUtil.assertPilot(ir016, 3, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco156, 2, 0, true, 0, 14);
			raceAssertUtil.assertPilot(sco087, 1, 0, true, 0, 15);
			raceAssertUtil.assertPilot(ir077, 0, 0, true, 0, 16);
			raceAssertUtil.assertPilot(sco018, 0, 0, true, 0, 16);
			raceAssertUtil.assertPilot(sco068, 0, 0, true, 0, 16);
			raceAssertUtil.assertDone(8);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir181, 0, 0, 1);
			overallAssertUtil.assertPilot(sco200, 0, 2, 2);
			overallAssertUtil.assertPilot(ir001, 0, 3, 3);
			overallAssertUtil.assertPilot(sco179, 0, 4, 4);
			overallAssertUtil.assertPilot(ir085, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(sco116, 0, 7, 7);
			overallAssertUtil.assertPilot(sco808, 0, 8, 8);
			overallAssertUtil.assertPilot(ir025, 0, 9, 9);
			overallAssertUtil.assertPilot(ir053, 0, 10, 10);
			overallAssertUtil.assertPilot(ir016, 0, 0, 11);
			overallAssertUtil.assertPilot(ir077, 0, 0, 11);
			overallAssertUtil.assertPilot(sco018, 0, 0, 11);
			overallAssertUtil.assertPilot(sco068, 0, 0, 11);
			overallAssertUtil.assertPilot(sco087, 0, 0, 11);
			overallAssertUtil.assertPilot(sco156, 0, 0, 11);
			overallAssertUtil.assertPilot(sco528, 0, 0, 11);
			overallAssertUtil.assertPilot(sco666, 0, 0, 11);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}