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
 * Scores at the end of event 1 (26/10/2013)
 */
public class Series2013Event1Scores extends AbstractSeries2013 {
	@Before
	public void createData() throws Exception {
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

		Assert.assertEquals(SERIES_FLEET_AT_EVENT1, scores.getPilots().size());
		Assert.assertEquals(RACE1_PILOTS, scores.getFleetSize(race1));
		Assert.assertEquals(RACE2_PILOTS, scores.getFleetSize(race2));
		Assert.assertEquals(RACE3_PILOTS, scores.getFleetSize(race3));

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
		race3AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco069, 0, 0, 1);
		overallAssertUtil.assertPilot(sco116, 0, 7, 2);
		overallAssertUtil.assertPilot(sco159, 0, 12, 3);
		overallAssertUtil.assertPilot(sco808, 0, 14, 4);
		overallAssertUtil.assertPilot(sco179, 0, 15, 5);
		overallAssertUtil.assertPilot(sco087, 0, 17, 6);
		overallAssertUtil.assertPilot(sco018, 0, 22, 7);
		overallAssertUtil.assertPilot(sco156, 0, 22, 8);
		overallAssertUtil.assertPilot(sco066, 0, 26, 9);
		overallAssertUtil.assertPilot(sco561, 0, 32, 10);
		overallAssertUtil.assertPilot(sco296, 0, 32, 11);
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

			Scores scores = scorer.scoreEvent(event1, Predicates.in(getEventResultsPilots(series, event1)));
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race1));
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race2));
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race3));

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
			race3AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 7, 2);
			overallAssertUtil.assertPilot(sco159, 0, 12, 3);
			overallAssertUtil.assertPilot(sco808, 0, 14, 4);
			overallAssertUtil.assertPilot(sco179, 0, 15, 5);
			overallAssertUtil.assertPilot(sco087, 0, 17, 6);
			overallAssertUtil.assertPilot(sco018, 0, 22, 7);
			overallAssertUtil.assertPilot(sco156, 0, 22, 8);
			overallAssertUtil.assertPilot(sco066, 0, 26, 9);
			overallAssertUtil.assertPilot(sco561, 0, 32, 10);
			overallAssertUtil.assertPilot(sco296, 0, 32, 11);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race1));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race1);
			raceAssertUtil.assertPilot(sco069, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco018, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco808, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco156, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco066, 3, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco296, 2, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco561, 2, 0, false, 11, 11);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco018, 0, 5, 5);
			overallAssertUtil.assertPilot(sco808, 0, 6, 6);
			overallAssertUtil.assertPilot(sco087, 0, 7, 7);
			overallAssertUtil.assertPilot(sco156, 0, 8, 8);
			overallAssertUtil.assertPilot(sco066, 0, 9, 9);
			overallAssertUtil.assertPilot(sco296, 0, 10, 10);
			overallAssertUtil.assertPilot(sco561, 0, 11, 11);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race2));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race2);
			raceAssertUtil.assertPilot(sco069, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco087, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco018, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco808, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco156, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco179, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco066, 3, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco296, 1, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco561, 0, 0, false, 12, 11);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco087, 0, 4, 4);
			overallAssertUtil.assertPilot(sco018, 0, 5, 5);
			overallAssertUtil.assertPilot(sco808, 0, 6, 6);
			overallAssertUtil.assertPilot(sco156, 0, 7, 7);
			overallAssertUtil.assertPilot(sco179, 0, 8, 8);
			overallAssertUtil.assertPilot(sco066, 0, 9, 9);
			overallAssertUtil.assertPilot(sco296, 0, 10, 10);
			overallAssertUtil.assertPilot(sco561, 0, 12, 11);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race3));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race3);
			raceAssertUtil.assertPilot(sco069, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco116, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco087, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco156, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco066, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco561, 1, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 12, 10);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 12, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco069, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco116, 0, 3, 3);
			overallAssertUtil.assertPilot(sco179, 0, 4, 4);
			overallAssertUtil.assertPilot(sco159, 0, 5, 5);
			overallAssertUtil.assertPilot(sco087, 0, 6, 6);
			overallAssertUtil.assertPilot(sco156, 0, 7, 7);
			overallAssertUtil.assertPilot(sco066, 0, 8, 8);
			overallAssertUtil.assertPilot(sco561, 0, 9, 9);
			overallAssertUtil.assertPilot(sco018, 0, 12, 10);
			overallAssertUtil.assertPilot(sco296, 0, 12, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}