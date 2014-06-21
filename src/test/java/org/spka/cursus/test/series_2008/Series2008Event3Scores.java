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
package org.spka.cursus.test.series_2008;

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
 * Scores at the end of event 3
 */
public class Series2008Event3Scores extends Series2008Event2Scores {
	@Override
	@Before
	public void createDatabase() throws Exception {
		super.createDatabase();
		createEvent3Races();
	}

	@Override
	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, event3), Predicates.in(getSeriesResultsPilots(series, event3)));
			checkSeriesAtEvent3(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkSeriesAtEvent3() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			List<Race> races = new ArrayList<Race>();
			races.addAll(event1.getRaces());
			races.addAll(event2.getRaces());
			races.addAll(event3.getRaces());

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, event3), getSeriesResultsEvents(series, event3),
					Predicates.in(getSeriesResultsPilots(series, event3)));
			checkSeriesAtEvent3(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	private void checkSeriesAtEvent3(Scores scores) throws Exception {
		Series series = seriesDAO.find(SERIES_NAME);
		Event event1 = eventDAO.find(series, EVENT1_NAME);
		Race race1 = raceDAO.find(event1, RACE1_NAME);
		Race race2 = raceDAO.find(event1, RACE2_NAME);
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race3 = raceDAO.find(event2, RACE3_NAME);
		Event event3 = eventDAO.find(series, EVENT3_NAME);
		Race race4 = raceDAO.find(event3, RACE4_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT3, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco023, 4, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco200, 3, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco179, 2, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco019, 2, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco081, 2, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco071, 2, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco117, 2, 0, false, 7, 7);
		race1AssertUtil.assertPilot(sco154, 1, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco060, 0, 0, true, 8, 9);
		race1AssertUtil.assertPilot(sco136, 1, 0, false, 9, 10);
		race1AssertUtil.assertPilot(sco021, 0, 0, false, 12, 11);
		race1AssertUtil.assertPilot(sco158, 0, 0, false, 12, 11);
		race1AssertUtil.assertPilot(sco159, 0, 0, false, 12, 11);
		race1AssertUtil.assertPilot(sco197, 0, 0, false, 12, 11);
		race1AssertUtil.assertDone(1);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco200, 5, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco081, 4, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco019, 4, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco136, 4, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco071, 3, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco154, 3, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco117, 2, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco060, 0, 0, true, 8, 9);
		race2AssertUtil.assertPilot(sco197, 2, 0, false, 9, 10);
		race2AssertUtil.assertPilot(sco179, 2, 0, false, 10, 11);
		race2AssertUtil.assertPilot(sco021, 0, 0, false, 12, 12);
		race2AssertUtil.assertPilot(sco158, 0, 0, false, 12, 12);
		race2AssertUtil.assertPilot(sco159, 0, 0, false, 12, 12);
		race2AssertUtil.assertDone(1);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco200, 7, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco071, 6, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco019, 0, 0, true, 4, 5);
		race3AssertUtil.assertPilot(sco117, 5, 0, false, 5, 6);
		race3AssertUtil.assertPilot(sco159, 4, 0, false, 6, 7);
		race3AssertUtil.assertPilot(sco197, 3, 0, false, 7, 8);
		race3AssertUtil.assertPilot(sco060, 3, 0, false, 8, 9);
		race3AssertUtil.assertPilot(sco154, 2, 0, false, 9, 10);
		race3AssertUtil.assertPilot(sco081, 1, 0, false, 10, 11);
		race3AssertUtil.assertPilot(sco136, 1, 0, false, 11, 12);
		race3AssertUtil.assertPilot(sco021, 0, 0, false, 13, 13);
		race3AssertUtil.assertPilot(sco158, 0, 0, false, 13, 13);
		race3AssertUtil.assertDone(1);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco200, 6, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco023, 6, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco081, 6, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco159, 4, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco179, 4, 0, false, 5, 5);
		race4AssertUtil.assertPilot(sco019, 4, 0, false, 6, 6);
		race4AssertUtil.assertPilot(sco154, 3, 0, false, 7, 7);
		race4AssertUtil.assertPilot(sco021, 3, 0, false, 8, 8);
		race4AssertUtil.assertPilot(sco197, 2, 0, false, 9, 9);
		race4AssertUtil.assertPilot(sco071, 2, 0, false, 10, 10);
		race4AssertUtil.assertPilot(sco136, 1, 0, false, 11, 11);
		race4AssertUtil.assertPilot(sco158, 1, 0, false, 12, 12);
		race4AssertUtil.assertPilot(sco060, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco117, 0, 0, false, 14, 13);
		race4AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 0, 1, 2);
		overallAssertUtil.assertPilot(sco200, 0, 4, 2, 2);
		overallAssertUtil.assertPilot(sco081, 0, 11, 3, 10);
		overallAssertUtil.assertPilot(sco179, 0, 11, 3, 10);
		overallAssertUtil.assertPilot(sco019, 0, 12, 5, 6);
		overallAssertUtil.assertPilot(sco071, 0, 16, 6, 10);
		overallAssertUtil.assertPilot(sco117, 0, 20, 7, 14);
		overallAssertUtil.assertPilot(sco159, 0, 22, 8, 12);
		overallAssertUtil.assertPilot(sco154, 0, 22, 9, 9);
		overallAssertUtil.assertPilot(sco060, 0, 24, 10, 14);
		overallAssertUtil.assertPilot(sco136, 0, 25, 11, 11);
		overallAssertUtil.assertPilot(sco197, 0, 25, 12, 12);
		overallAssertUtil.assertPilot(sco021, 0, 32, 13, 13);
		overallAssertUtil.assertPilot(sco158, 0, 36, 14, 13);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent3() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Race race4 = raceDAO.find(event3, RACE4_NAME);

			Scores scores = scorer.scoreEvent(event3, Predicates.in(getEventResultsPilots(series, event3)));
			Assert.assertEquals(EVENT3_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE4_FLEET, scores.getFleetSize(race4));

			RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
			race4AssertUtil.assertPilot(sco200, 6, 0, false, 0, 1);
			race4AssertUtil.assertPilot(sco023, 6, 0, false, 2, 2);
			race4AssertUtil.assertPilot(sco081, 6, 0, false, 3, 3);
			race4AssertUtil.assertPilot(sco159, 4, 0, false, 4, 4);
			race4AssertUtil.assertPilot(sco179, 4, 0, false, 5, 5);
			race4AssertUtil.assertPilot(sco019, 4, 0, false, 6, 6);
			race4AssertUtil.assertPilot(sco154, 3, 0, false, 7, 7);
			race4AssertUtil.assertPilot(sco021, 3, 0, false, 8, 8);
			race4AssertUtil.assertPilot(sco197, 2, 0, false, 9, 9);
			race4AssertUtil.assertPilot(sco071, 2, 0, false, 10, 10);
			race4AssertUtil.assertPilot(sco136, 1, 0, false, 11, 11);
			race4AssertUtil.assertPilot(sco158, 1, 0, false, 12, 12);
			race4AssertUtil.assertPilot(sco060, 0, 0, false, 14, 13);
			race4AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(sco081, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco179, 0, 5, 5);
			overallAssertUtil.assertPilot(sco019, 0, 6, 6);
			overallAssertUtil.assertPilot(sco154, 0, 7, 7);
			overallAssertUtil.assertPilot(sco021, 0, 8, 8);
			overallAssertUtil.assertPilot(sco197, 0, 9, 9);
			overallAssertUtil.assertPilot(sco071, 0, 10, 10);
			overallAssertUtil.assertPilot(sco136, 0, 11, 11);
			overallAssertUtil.assertPilot(sco158, 0, 12, 12);
			overallAssertUtil.assertPilot(sco060, 0, 14, 13);
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
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Race race4 = raceDAO.find(event3, RACE4_NAME);

			Scores scores = scorer.scoreRace(race4, Predicates.in(getEventResultsPilots(series, event3)));
			Assert.assertEquals(EVENT3_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE4_FLEET, scores.getFleetSize(race4));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race4);
			raceAssertUtil.assertPilot(sco200, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco081, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco154, 3, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco021, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco197, 2, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco071, 2, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco136, 1, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco158, 1, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 14, 13);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(sco081, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco179, 0, 5, 5);
			overallAssertUtil.assertPilot(sco019, 0, 6, 6);
			overallAssertUtil.assertPilot(sco154, 0, 7, 7);
			overallAssertUtil.assertPilot(sco021, 0, 8, 8);
			overallAssertUtil.assertPilot(sco197, 0, 9, 9);
			overallAssertUtil.assertPilot(sco071, 0, 10, 10);
			overallAssertUtil.assertPilot(sco136, 0, 11, 11);
			overallAssertUtil.assertPilot(sco158, 0, 12, 12);
			overallAssertUtil.assertPilot(sco060, 0, 14, 13);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}