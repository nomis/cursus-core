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
 * Scores at the end of event 2 (08/12/2013)
 */
public class Series2013Event2Scores extends Series2013Event1Scores {
	@Override
	@Before
	public void createData() throws Exception {
		super.createData();
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
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race4 = raceDAO.find(event2, RACE4_NAME);
		Race race5 = raceDAO.find(event2, RACE5_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT2, scores.getPilots().size());
		Assert.assertEquals(RACE1_PILOTS, scores.getFleetSize(race1));
		Assert.assertEquals(RACE2_PILOTS, scores.getFleetSize(race2));
		Assert.assertEquals(RACE3_PILOTS, scores.getFleetSize(race3));
		Assert.assertEquals(RACE4_PILOTS, scores.getFleetSize(race4));
		Assert.assertEquals(RACE5_PILOTS, scores.getFleetSize(race5));

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
		race1AssertUtil.assertPilot(sco117, 0, 0, false, 13, 12);
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
		race2AssertUtil.assertPilot(sco117, 0, 0, false, 13, 12);
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
		race3AssertUtil.assertPilot(sco117, 0, 0, false, 13, 12);
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
		race4AssertUtil.assertPilot(sco018, 0, 0, false, 13, 11);
		race4AssertUtil.assertPilot(sco179, 0, 0, false, 13, 11);
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
		race5AssertUtil.assertPilot(sco018, 0, 0, false, 13, 11);
		race5AssertUtil.assertPilot(sco179, 0, 0, false, 13, 11);
		race5AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco069, 0, 2, 1, 2);
		overallAssertUtil.assertPilot(sco116, 0, 4, 2, 3);
		overallAssertUtil.assertPilot(sco159, 0, 13, 3, 5);
		overallAssertUtil.assertPilot(sco808, 0, 18, 4, 8);
		overallAssertUtil.assertPilot(sco087, 0, 20, 5, 7);
		overallAssertUtil.assertPilot(sco156, 0, 24, 6, 8);
		overallAssertUtil.assertPilot(sco179, 0, 28, 7, 13);
		overallAssertUtil.assertPilot(sco018, 0, 35, 8, 13);
		overallAssertUtil.assertPilot(sco296, 0, 35, 9, 12);
		overallAssertUtil.assertPilot(sco066, 0, 35, 10, 9);
		overallAssertUtil.assertPilot(sco117, 0, 39, 11, 13);
		overallAssertUtil.assertPilot(sco561, 0, 42, 12, 12);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent2() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race4 = raceDAO.find(event2, RACE4_NAME);
			Race race5 = raceDAO.find(event2, RACE5_NAME);

			Scores scores = scorer.scoreEvent(event2, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race4));
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race5));

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
			race5AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco069, 0, 4, 2);
			overallAssertUtil.assertPilot(sco159, 0, 6, 3);
			overallAssertUtil.assertPilot(sco087, 0, 10, 4);
			overallAssertUtil.assertPilot(sco156, 0, 10, 5);
			overallAssertUtil.assertPilot(sco808, 0, 12, 6);
			overallAssertUtil.assertPilot(sco117, 0, 13, 7);
			overallAssertUtil.assertPilot(sco296, 0, 15, 8);
			overallAssertUtil.assertPilot(sco066, 0, 18, 9);
			overallAssertUtil.assertPilot(sco561, 0, 22, 10);
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
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race4 = raceDAO.find(event2, RACE4_NAME);

			Scores scores = scorer.scoreRace(race4, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race4));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race4);
			raceAssertUtil.assertPilot(sco116, 11, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco069, 11, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 10, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco808, 10, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco156, 8, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco087, 8, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco117, 7, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco296, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco066, 2, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco561, 0, 0, false, 11, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco069, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco808, 0, 4, 4);
			overallAssertUtil.assertPilot(sco156, 0, 5, 5);
			overallAssertUtil.assertPilot(sco087, 0, 6, 6);
			overallAssertUtil.assertPilot(sco117, 0, 7, 7);
			overallAssertUtil.assertPilot(sco296, 0, 8, 8);
			overallAssertUtil.assertPilot(sco066, 0, 9, 9);
			overallAssertUtil.assertPilot(sco561, 0, 11, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace5() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race5 = raceDAO.find(event2, RACE5_NAME);

			Scores scores = scorer.scoreRace(race5, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT2_FLEET, scores.getFleetSize(race5));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race5);
			raceAssertUtil.assertPilot(sco116, 9, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco069, 9, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco087, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco156, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco296, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco808, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco066, 3, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco561, 0, 0, false, 11, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco069, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco087, 0, 4, 4);
			overallAssertUtil.assertPilot(sco156, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco296, 0, 7, 7);
			overallAssertUtil.assertPilot(sco808, 0, 8, 8);
			overallAssertUtil.assertPilot(sco066, 0, 9, 9);
			overallAssertUtil.assertPilot(sco561, 0, 11, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}