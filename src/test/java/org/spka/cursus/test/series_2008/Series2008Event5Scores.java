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

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.test.util.OverallAssertUtil;
import uk.uuid.cursus.test.util.RaceAssertUtil;

import com.google.common.base.Predicates;

/**
 * Scores at the end of event 5
 */
public class Series2008Event5Scores extends Series2008Event4Scores {
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
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race3 = raceDAO.find(event2, RACE3_NAME);
		Event event3 = eventDAO.find(series, EVENT3_NAME);
		Race race4 = raceDAO.find(event3, RACE4_NAME);
		Event event4 = eventDAO.find(series, EVENT4_NAME);
		Race race5 = raceDAO.find(event4, RACE5_NAME);
		Race race6 = raceDAO.find(event4, RACE6_NAME);
		Event event5 = eventDAO.find(series, EVENT5_NAME);
		Race race7 = raceDAO.find(event5, RACE7_NAME);
		Race race8 = raceDAO.find(event5, RACE8_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT5, scores.getPilots().size());

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
		race3AssertUtil.assertPilot(sco117, 5, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco159, 4, 0, false, 6, 6);
		race3AssertUtil.assertPilot(sco019, 0, 0, true, 6, 7);
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

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(sco200, 10, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco023, 10, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco154, 10, 0, false, 3, 3);
		race5AssertUtil.assertPilot(sco081, 9, 0, false, 4, 4);
		race5AssertUtil.assertPilot(sco179, 9, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco071, 6, 0, false, 6, 6);
		race5AssertUtil.assertPilot(sco019, 0, 0, true, 6, 7);
		race5AssertUtil.assertPilot(sco136, 6, 0, false, 7, 8);
		race5AssertUtil.assertPilot(sco159, 5, 0, false, 8, 9);
		race5AssertUtil.assertPilot(sco060, 5, 0, false, 9, 10);
		race5AssertUtil.assertPilot(sco117, 5, 0, false, 10, 11);
		race5AssertUtil.assertPilot(sco021, 0, 0, false, 13, 12);
		race5AssertUtil.assertPilot(sco158, 0, 0, false, 13, 12);
		race5AssertUtil.assertPilot(sco197, 0, 0, false, 13, 12);
		race5AssertUtil.assertDone(1);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
		race6AssertUtil.assertPilot(sco023, 7, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco154, 7, 0, false, 3, 3);
		race6AssertUtil.assertPilot(sco081, 7, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco117, 6, 0, false, 5, 5);
		race6AssertUtil.assertPilot(sco179, 5, 0, false, 6, 6);
		race6AssertUtil.assertPilot(sco021, 1, 0, false, 7, 7);
		race6AssertUtil.assertPilot(sco071, 1, 0, false, 8, 8);
		race6AssertUtil.assertPilot(sco060, 0, 0, true, 8, 9);
		race6AssertUtil.assertPilot(sco019, 0, 0, false, 13, 10);
		race6AssertUtil.assertPilot(sco136, 0, 0, false, 13, 10);
		race6AssertUtil.assertPilot(sco158, 0, 0, false, 13, 10);
		race6AssertUtil.assertPilot(sco159, 0, 0, false, 13, 10);
		race6AssertUtil.assertPilot(sco197, 0, 0, false, 13, 10);
		race6AssertUtil.assertDone(1);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
		race7AssertUtil.assertPilot(sco200, 11, 1, false, 0, 1);
		race7AssertUtil.assertPilot(sco023, 11, 0, false, 2, 2);
		race7AssertUtil.assertPilot(sco081, 11, 0, false, 3, 3);
		race7AssertUtil.assertPilot(sco179, 11, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco154, 8, 0, false, 5, 5);
		race7AssertUtil.assertPilot(sco159, 8, 0, false, 6, 6);
		race7AssertUtil.assertPilot(sco117, 7, 0, false, 7, 7);
		race7AssertUtil.assertPilot(sco060, 6, 0, false, 8, 8);
		race7AssertUtil.assertPilot(sco021, 1, 1, false, 9, 9);
		race7AssertUtil.assertPilot(sco019, 0, 0, false, 11, 10);
		race7AssertUtil.assertPilot(sco071, 0, 0, false, 11, 10);
		race7AssertUtil.assertPilot(sco136, 0, 0, false, 11, 10);
		race7AssertUtil.assertPilot(sco158, 0, 0, false, 11, 10);
		race7AssertUtil.assertPilot(sco197, 0, 0, false, 11, 10);
		race7AssertUtil.assertDone(0);

		RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
		race8AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
		race8AssertUtil.assertPilot(sco081, 8, 0, false, 2, 2);
		race8AssertUtil.assertPilot(sco023, 8, 0, false, 3, 3);
		race8AssertUtil.assertPilot(sco154, 6, 0, false, 4, 4);
		race8AssertUtil.assertPilot(sco117, 5, 0, false, 5, 5);
		race8AssertUtil.assertPilot(sco179, 5, 1, false, 6, 6);
		race8AssertUtil.assertPilot(sco060, 4, 0, false, 7, 7);
		race8AssertUtil.assertPilot(sco159, 3, 1, false, 8, 8);
		race8AssertUtil.assertPilot(sco021, 1, 0, false, 9, 9);
		race8AssertUtil.assertPilot(sco019, 0, 0, false, 11, 10);
		race8AssertUtil.assertPilot(sco071, 0, 0, false, 11, 10);
		race8AssertUtil.assertPilot(sco136, 0, 0, false, 11, 10);
		race8AssertUtil.assertPilot(sco158, 0, 0, false, 11, 10);
		race8AssertUtil.assertPilot(sco197, 0, 0, false, 11, 10);
		race8AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco200, 1, 3, 1, 2, 2);
		overallAssertUtil.assertPilot(sco023, 0, 6, 2, 3, 2);
		overallAssertUtil.assertPilot(sco081, 0, 19, 3, 10, 5);
		overallAssertUtil.assertPilot(sco179, 1, 27, 4, 10, 6);
		overallAssertUtil.assertPilot(sco154, 0, 29, 5, 9, 8);
		overallAssertUtil.assertPilot(sco019, 0, 37, 6, 13, 11);
		overallAssertUtil.assertPilot(sco117, 0, 37, 7, 14, 10);
		overallAssertUtil.assertPilot(sco071, 0, 40, 8, 11, 11);
		overallAssertUtil.assertPilot(sco159, 1, 45, 9, 13, 12);
		overallAssertUtil.assertPilot(sco060, 0, 47, 10, 14, 9);
		overallAssertUtil.assertPilot(sco136, 0, 54, 11, 13, 11);
		overallAssertUtil.assertPilot(sco021, 1, 58, 12, 13, 13);
		overallAssertUtil.assertPilot(sco197, 0, 59, 13, 13, 13);
		overallAssertUtil.assertPilot(sco158, 0, 71, 14, 13, 13);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent5() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race7 = raceDAO.find(event5, RACE7_NAME);
			Race race8 = raceDAO.find(event5, RACE8_NAME);

			Scores scores = scorer.scoreEvent(event5, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE7_FLEET, scores.getFleetSize(race7));
			Assert.assertEquals(RACE8_FLEET, scores.getFleetSize(race8));

			RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
			race7AssertUtil.assertPilot(sco200, 11, 1, false, 0, 1);
			race7AssertUtil.assertPilot(sco023, 11, 0, false, 2, 2);
			race7AssertUtil.assertPilot(sco081, 11, 0, false, 3, 3);
			race7AssertUtil.assertPilot(sco179, 11, 0, false, 4, 4);
			race7AssertUtil.assertPilot(sco154, 8, 0, false, 5, 5);
			race7AssertUtil.assertPilot(sco159, 8, 0, false, 6, 6);
			race7AssertUtil.assertPilot(sco117, 7, 0, false, 7, 7);
			race7AssertUtil.assertPilot(sco060, 6, 0, false, 8, 8);
			race7AssertUtil.assertPilot(sco021, 1, 1, false, 9, 9);
			race7AssertUtil.assertPilot(sco019, 0, 0, false, 11, 10);
			race7AssertUtil.assertDone(0);

			RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
			race8AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			race8AssertUtil.assertPilot(sco081, 8, 0, false, 2, 2);
			race8AssertUtil.assertPilot(sco023, 8, 0, false, 3, 3);
			race8AssertUtil.assertPilot(sco154, 6, 0, false, 4, 4);
			race8AssertUtil.assertPilot(sco117, 5, 0, false, 5, 5);
			race8AssertUtil.assertPilot(sco179, 5, 1, false, 6, 6);
			race8AssertUtil.assertPilot(sco060, 4, 0, false, 7, 7);
			race8AssertUtil.assertPilot(sco159, 3, 1, false, 8, 8);
			race8AssertUtil.assertPilot(sco021, 1, 0, false, 9, 9);
			race8AssertUtil.assertPilot(sco019, 0, 0, false, 11, 10);
			race8AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 1, 1, 1);
			overallAssertUtil.assertPilot(sco023, 0, 5, 2);
			overallAssertUtil.assertPilot(sco081, 0, 5, 2);
			overallAssertUtil.assertPilot(sco154, 0, 9, 4);
			overallAssertUtil.assertPilot(sco179, 1, 11, 5);
			overallAssertUtil.assertPilot(sco117, 0, 12, 6);
			overallAssertUtil.assertPilot(sco159, 1, 15, 7);
			overallAssertUtil.assertPilot(sco060, 0, 15, 8);
			overallAssertUtil.assertPilot(sco021, 1, 19, 9);
			overallAssertUtil.assertPilot(sco019, 0, 22, 10);
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
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race7 = raceDAO.find(event5, RACE7_NAME);

			Scores scores = scorer.scoreRace(race7, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE7_FLEET, scores.getFleetSize(race7));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race7);
			raceAssertUtil.assertPilot(sco200, 11, 1, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 11, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco081, 11, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco179, 11, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco154, 8, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco159, 8, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco117, 7, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco060, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco021, 1, 1, false, 9, 9);
			raceAssertUtil.assertPilot(sco019, 0, 0, false, 11, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 1, 1, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(sco081, 0, 3, 3);
			overallAssertUtil.assertPilot(sco179, 0, 4, 4);
			overallAssertUtil.assertPilot(sco154, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(sco117, 0, 7, 7);
			overallAssertUtil.assertPilot(sco060, 0, 8, 8);
			overallAssertUtil.assertPilot(sco021, 1, 10, 9);
			overallAssertUtil.assertPilot(sco019, 0, 11, 10);
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
			Event event5 = eventDAO.find(series, EVENT5_NAME);
			Race race8 = raceDAO.find(event5, RACE8_NAME);

			Scores scores = scorer.scoreRace(race8, Predicates.in(getEventResultsPilots(series, event5)));
			Assert.assertEquals(EVENT5_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE8_FLEET, scores.getFleetSize(race8));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race8);
			raceAssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco081, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco023, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco154, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco117, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco179, 5, 1, false, 6, 6);
			raceAssertUtil.assertPilot(sco060, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco159, 3, 1, false, 8, 8);
			raceAssertUtil.assertPilot(sco021, 1, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco019, 0, 0, false, 11, 10);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(sco081, 0, 2, 2);
			overallAssertUtil.assertPilot(sco023, 0, 3, 3);
			overallAssertUtil.assertPilot(sco154, 0, 4, 4);
			overallAssertUtil.assertPilot(sco117, 0, 5, 5);
			overallAssertUtil.assertPilot(sco179, 1, 7, 6);
			overallAssertUtil.assertPilot(sco060, 0, 7, 7);
			overallAssertUtil.assertPilot(sco159, 1, 9, 8);
			overallAssertUtil.assertPilot(sco021, 0, 9, 9);
			overallAssertUtil.assertPilot(sco019, 0, 11, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}