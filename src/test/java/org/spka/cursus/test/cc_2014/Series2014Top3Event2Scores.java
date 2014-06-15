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
package org.spka.cursus.test.cc_2014;

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
 * Scores at the end of event 2 (14/06/2014 to 15/06/2014)
 */
public class Series2014Top3Event2Scores extends Series2014Top3Event1Scores {
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

		Assert.assertEquals(SERIES_FLEET_AT_EVENT2, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1, true);
		race1AssertUtil.assertPilot(ir014, 1, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco179, 1, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco116, 1, 0, false, 3, 3);
		race1AssertUtil.assertPilot(ir027, 1, 0, false, 4, 4);
		race1AssertUtil.assertPilot(ir053, 1, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco060, 1, 0, false, 6, 6);
		race1AssertUtil.assertPilot(ir016, 1, 0, true, 0, 7);
		race1AssertUtil.assertPilot(ir025, 1, 0, true, 0, 8);
		race1AssertUtil.assertPilot(sco153, 1, 0, true, 0, 9);
		race1AssertUtil.assertPilot(ir000, 0, 0, true, 0, 10);
		race1AssertUtil.assertPilot(ir181, 0, 0, true, 0, 10);
		race1AssertUtil.assertPilot(sco066, 0, 0, true, 0, 10);
		race1AssertUtil.assertPilot(sco076, 0, 0, true, 0, 10);
		race1AssertUtil.assertPilot(sco159, 0, 0, true, 0, 10);
		race1AssertUtil.assertPilot(sco808, 0, 0, true, 0, 10);
		race1AssertUtil.assertDone(9);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2, true);
		race2AssertUtil.assertPilot(ir014, 1, 0, false, 0, 1);
		race2AssertUtil.assertPilot(ir027, 1, 0, false, 2, 2);
		race2AssertUtil.assertPilot(ir053, 1, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco179, 1, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco060, 1, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco153, 1, 0, false, 6, 6);
		race2AssertUtil.assertPilot(ir025, 1, 0, true, 0, 7);
		race2AssertUtil.assertPilot(ir016, 1, 0, true, 0, 8);
		race2AssertUtil.assertPilot(sco116, 1, 0, true, 0, 9);
		race2AssertUtil.assertPilot(ir000, 0, 0, true, 0, 10);
		race2AssertUtil.assertPilot(ir181, 0, 0, true, 0, 10);
		race2AssertUtil.assertPilot(sco066, 0, 0, true, 0, 10);
		race2AssertUtil.assertPilot(sco076, 0, 0, true, 0, 10);
		race2AssertUtil.assertPilot(sco159, 0, 0, true, 0, 10);
		race2AssertUtil.assertPilot(sco808, 0, 0, true, 0, 10);
		race2AssertUtil.assertDone(9);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3, true);
		race3AssertUtil.assertPilot(ir027, 1, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco179, 1, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco116, 1, 0, false, 3, 3);
		race3AssertUtil.assertPilot(ir053, 1, 0, false, 4, 4);
		race3AssertUtil.assertPilot(ir025, 1, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco060, 1, 0, false, 6, 6);
		race3AssertUtil.assertPilot(ir016, 1, 0, true, 0, 7);
		race3AssertUtil.assertPilot(ir000, 1, 0, true, 0, 8);
		race3AssertUtil.assertPilot(sco153, 1, 0, true, 0, 9);
		race3AssertUtil.assertPilot(ir014, 0, 0, true, 0, 10);
		race3AssertUtil.assertPilot(ir181, 0, 0, true, 0, 10);
		race3AssertUtil.assertPilot(sco066, 0, 0, true, 0, 10);
		race3AssertUtil.assertPilot(sco076, 0, 0, true, 0, 10);
		race3AssertUtil.assertPilot(sco159, 0, 0, true, 0, 10);
		race3AssertUtil.assertPilot(sco808, 0, 0, true, 0, 10);
		race3AssertUtil.assertDone(9);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4, true);
		race4AssertUtil.assertPilot(sco179, 1, 0, false, 0, 1);
		race4AssertUtil.assertPilot(ir027, 1, 0, false, 2, 2);
		race4AssertUtil.assertPilot(ir014, 1, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco116, 1, 0, false, 4, 4);
		race4AssertUtil.assertPilot(ir053, 1, 0, false, 5, 5);
		race4AssertUtil.assertPilot(sco060, 1, 0, false, 6, 6);
		race4AssertUtil.assertPilot(ir016, 1, 0, true, 0, 7);
		race4AssertUtil.assertPilot(sco153, 1, 0, true, 0, 8);
		race4AssertUtil.assertPilot(ir025, 1, 0, true, 0, 9);
		race4AssertUtil.assertPilot(ir000, 0, 0, true, 0, 10);
		race4AssertUtil.assertPilot(ir181, 0, 0, true, 0, 10);
		race4AssertUtil.assertPilot(sco066, 0, 0, true, 0, 10);
		race4AssertUtil.assertPilot(sco076, 0, 0, true, 0, 10);
		race4AssertUtil.assertPilot(sco159, 0, 0, true, 0, 10);
		race4AssertUtil.assertPilot(sco808, 0, 0, true, 0, 10);
		race4AssertUtil.assertDone(9);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5, true);
		race5AssertUtil.assertPilot(ir027, 1, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco116, 1, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco179, 1, 0, false, 3, 3);
		race5AssertUtil.assertPilot(ir014, 1, 0, false, 4, 4);
		race5AssertUtil.assertPilot(ir053, 1, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco153, 1, 0, false, 6, 6);
		race5AssertUtil.assertPilot(ir025, 1, 0, true, 0, 7);
		race5AssertUtil.assertPilot(ir000, 1, 0, true, 0, 8);
		race5AssertUtil.assertPilot(sco060, 1, 0, true, 0, 9);
		race5AssertUtil.assertPilot(ir016, 0, 0, true, 0, 10);
		race5AssertUtil.assertPilot(ir181, 0, 0, true, 0, 10);
		race5AssertUtil.assertPilot(sco066, 0, 0, true, 0, 10);
		race5AssertUtil.assertPilot(sco076, 0, 0, true, 0, 10);
		race5AssertUtil.assertPilot(sco159, 0, 0, true, 0, 10);
		race5AssertUtil.assertPilot(sco808, 0, 0, true, 0, 10);
		race5AssertUtil.assertDone(9);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6, true);
		race6AssertUtil.assertPilot(ir027, 8, 0, false, 0, 1);
		race6AssertUtil.assertPilot(sco116, 8, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
		race6AssertUtil.assertPilot(ir181, 8, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco808, 7, 0, false, 5, 5);
		race6AssertUtil.assertPilot(ir053, 5, 0, false, 6, 6);
		race6AssertUtil.assertPilot(sco159, 7, 0, true, 0, 7);
		race6AssertUtil.assertPilot(ir000, 0, 0, true, 0, 8);
		race6AssertUtil.assertPilot(ir014, 0, 0, true, 0, 8);
		race6AssertUtil.assertPilot(ir016, 0, 0, true, 0, 8);
		race6AssertUtil.assertPilot(ir025, 0, 0, true, 0, 8);
		race6AssertUtil.assertPilot(sco060, 0, 0, true, 0, 8);
		race6AssertUtil.assertPilot(sco066, 0, 0, true, 0, 8);
		race6AssertUtil.assertPilot(sco076, 0, 0, true, 0, 8);
		race6AssertUtil.assertPilot(sco153, 0, 0, true, 0, 8);
		race6AssertUtil.assertDone(9);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7, true);
		race7AssertUtil.assertPilot(ir181, 8, 0, false, 0, 1);
		race7AssertUtil.assertPilot(ir027, 8, 0, false, 2, 2);
		race7AssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
		race7AssertUtil.assertPilot(sco116, 8, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco808, 8, 0, false, 5, 5);
		race7AssertUtil.assertPilot(ir053, 7, 0, false, 6, 6);
		race7AssertUtil.assertPilot(sco159, 7, 0, true, 0, 7);
		race7AssertUtil.assertPilot(sco076, 3, 0, true, 0, 8);
		race7AssertUtil.assertPilot(ir000, 0, 0, true, 0, 9);
		race7AssertUtil.assertPilot(ir014, 0, 0, true, 0, 9);
		race7AssertUtil.assertPilot(ir016, 0, 0, true, 0, 9);
		race7AssertUtil.assertPilot(ir025, 0, 0, true, 0, 9);
		race7AssertUtil.assertPilot(sco060, 0, 0, true, 0, 9);
		race7AssertUtil.assertPilot(sco066, 0, 0, true, 0, 9);
		race7AssertUtil.assertPilot(sco153, 0, 0, true, 0, 9);
		race7AssertUtil.assertDone(9);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(ir027, 0, 10, 1);
		overallAssertUtil.assertPilot(ir014, 0, 7, 2);
		overallAssertUtil.assertPilot(ir181, 0, 4, 3);
		overallAssertUtil.assertPilot(sco179, 0, 17, 4);
		overallAssertUtil.assertPilot(sco116, 0, 18, 5);
		overallAssertUtil.assertPilot(ir053, 0, 34, 6);
		overallAssertUtil.assertPilot(ir025, 0, 5, 7);
		overallAssertUtil.assertPilot(sco808, 0, 10, 8);
		overallAssertUtil.assertPilot(sco060, 0, 23, 9);
		overallAssertUtil.assertPilot(sco153, 0, 12, 10);
		overallAssertUtil.assertPilot(ir000, 0, 0, 11);
		overallAssertUtil.assertPilot(ir016, 0, 0, 11);
		overallAssertUtil.assertPilot(sco066, 0, 0, 11);
		overallAssertUtil.assertPilot(sco076, 0, 0, 11);
		overallAssertUtil.assertPilot(sco159, 0, 0, 11);
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

			Scores scores = scorer.scoreEvent(event2, Predicates.in(getEventResultsPilots(series, event2)));

			RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6, true);
			race6AssertUtil.assertPilot(ir027, 8, 0, false, 0, 1);
			race6AssertUtil.assertPilot(sco116, 8, 0, false, 2, 2);
			race6AssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
			race6AssertUtil.assertPilot(ir181, 8, 0, false, 4, 4);
			race6AssertUtil.assertPilot(sco808, 7, 0, false, 5, 5);
			race6AssertUtil.assertPilot(ir053, 5, 0, false, 6, 6);
			race6AssertUtil.assertPilot(sco159, 7, 0, true, 0, 7);
			race6AssertUtil.assertPilot(sco066, 0, 0, true, 0, 8);
			race6AssertUtil.assertPilot(sco076, 0, 0, true, 0, 8);
			race6AssertUtil.assertDone(3);

			RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7, true);
			race7AssertUtil.assertPilot(ir181, 8, 0, false, 0, 1);
			race7AssertUtil.assertPilot(ir027, 8, 0, false, 2, 2);
			race7AssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
			race7AssertUtil.assertPilot(sco116, 8, 0, false, 4, 4);
			race7AssertUtil.assertPilot(sco808, 8, 0, false, 5, 5);
			race7AssertUtil.assertPilot(ir053, 7, 0, false, 6, 6);
			race7AssertUtil.assertPilot(sco159, 7, 0, true, 0, 7);
			race7AssertUtil.assertPilot(sco076, 3, 0, true, 0, 8);
			race7AssertUtil.assertPilot(sco066, 0, 0, true, 0, 9);
			race7AssertUtil.assertDone(3);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir027, 0, 2, 1);
			overallAssertUtil.assertPilot(ir181, 0, 4, 2);
			overallAssertUtil.assertPilot(sco116, 0, 6, 3);
			overallAssertUtil.assertPilot(sco179, 0, 6, 4);
			overallAssertUtil.assertPilot(sco808, 0, 10, 5);
			overallAssertUtil.assertPilot(ir053, 0, 12, 6);
			overallAssertUtil.assertPilot(sco066, 0, 0, 7);
			overallAssertUtil.assertPilot(sco076, 0, 0, 7);
			overallAssertUtil.assertPilot(sco159, 0, 0, 7);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race6, true);
			raceAssertUtil.assertPilot(ir027, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir181, 8, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco808, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir053, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco159, 7, 0, true, 0, 7);
			raceAssertUtil.assertPilot(sco066, 0, 0, true, 0, 8);
			raceAssertUtil.assertPilot(sco076, 0, 0, true, 0, 8);
			raceAssertUtil.assertDone(3);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir027, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(ir181, 0, 4, 4);
			overallAssertUtil.assertPilot(sco808, 0, 5, 5);
			overallAssertUtil.assertPilot(ir053, 0, 6, 6);
			overallAssertUtil.assertPilot(sco066, 0, 0, 7);
			overallAssertUtil.assertPilot(sco076, 0, 0, 7);
			overallAssertUtil.assertPilot(sco159, 0, 0, 7);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race7, true);
			raceAssertUtil.assertPilot(ir181, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir027, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco808, 8, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir053, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco159, 7, 0, true, 0, 7);
			raceAssertUtil.assertPilot(sco076, 3, 0, true, 0, 8);
			raceAssertUtil.assertPilot(sco066, 0, 0, true, 0, 9);
			raceAssertUtil.assertDone(3);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir181, 0, 0, 1);
			overallAssertUtil.assertPilot(ir027, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(sco116, 0, 4, 4);
			overallAssertUtil.assertPilot(sco808, 0, 5, 5);
			overallAssertUtil.assertPilot(ir053, 0, 6, 6);
			overallAssertUtil.assertPilot(sco066, 0, 0, 7);
			overallAssertUtil.assertPilot(sco076, 0, 0, 7);
			overallAssertUtil.assertPilot(sco159, 0, 0, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}