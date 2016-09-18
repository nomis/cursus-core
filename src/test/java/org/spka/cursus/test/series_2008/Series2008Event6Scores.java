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
 * Scores at the end of event 6
 */
public class Series2008Event6Scores extends Series2008Event5Scores {
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
		Event event6 = eventDAO.find(series, EVENT6_NAME);
		Race race9 = raceDAO.find(event6, RACE9_NAME);
		Race race10 = raceDAO.find(event6, RACE10_NAME);
		Race race11 = raceDAO.find(event6, RACE11_NAME);
		Race race12 = raceDAO.find(event6, RACE12_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT6, scores.getPilots().size());

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
		race3AssertUtil.assertPilot(sco197, 3, 0, false, 7, 7);
		race3AssertUtil.assertPilot(sco019, 0, 0, true, 7, 8);
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
		race5AssertUtil.assertPilot(sco136, 6, 0, false, 7, 7);
		race5AssertUtil.assertPilot(sco019, 0, 0, true, 7, 8);
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

		RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
		race9AssertUtil.assertPilot(sco081, 7, 0, false, 0, 1);
		race9AssertUtil.assertPilot(sco023, 0, 0, true, 1, 2);
		race9AssertUtil.assertPilot(sco200, 7, 0, false, 2, 3);
		race9AssertUtil.assertPilot(sco179, 7, 0, false, 3, 4);
		race9AssertUtil.assertPilot(sco159, 7, 0, false, 4, 5);
		race9AssertUtil.assertPilot(sco154, 6, 0, false, 5, 6);
		race9AssertUtil.assertPilot(sco117, 6, 0, false, 6, 7);
		race9AssertUtil.assertPilot(sco019, 5, 0, false, 7, 8);
		race9AssertUtil.assertPilot(sco197, 5, 0, false, 8, 9);
		race9AssertUtil.assertPilot(sco060, 3, 0, false, 9, 10);
		race9AssertUtil.assertPilot(sco158, 3, 0, false, 10, 11);
		race9AssertUtil.assertPilot(sco021, 1, 0, false, 11, 12);
		race9AssertUtil.assertPilot(sco071, 0, 0, false, 13, 13);
		race9AssertUtil.assertPilot(sco136, 0, 0, false, 13, 13);
		race9AssertUtil.assertDone(1);

		RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
		race10AssertUtil.assertPilot(sco081, 8, 0, false, 0, 1);
		race10AssertUtil.assertPilot(sco200, 8, 0, false, 2, 2);
		race10AssertUtil.assertPilot(sco154, 8, 0, false, 3, 3);
		race10AssertUtil.assertPilot(sco179, 8, 0, false, 4, 4);
		race10AssertUtil.assertPilot(sco023, 7, 0, false, 5, 5);
		race10AssertUtil.assertPilot(sco117, 7, 0, false, 6, 6);
		race10AssertUtil.assertPilot(sco159, 0, 0, true, 6, 7);
		race10AssertUtil.assertPilot(sco197, 6, 0, false, 7, 8);
		race10AssertUtil.assertPilot(sco060, 5, 0, false, 8, 9);
		race10AssertUtil.assertPilot(sco021, 4, 0, false, 9, 10);
		race10AssertUtil.assertPilot(sco019, 1, 0, false, 10, 11);
		race10AssertUtil.assertPilot(sco071, 0, 0, false, 13, 12);
		race10AssertUtil.assertPilot(sco136, 0, 0, false, 13, 12);
		race10AssertUtil.assertPilot(sco158, 0, 0, false, 13, 12);
		race10AssertUtil.assertDone(1);

		RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
		race11AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
		race11AssertUtil.assertPilot(sco023, 8, 0, false, 2, 2);
		race11AssertUtil.assertPilot(sco154, 8, 0, false, 3, 3);
		race11AssertUtil.assertPilot(sco179, 8, 0, false, 4, 4);
		race11AssertUtil.assertPilot(sco081, 8, 0, false, 5, 5);
		race11AssertUtil.assertPilot(sco117, 7, 0, false, 6, 6);
		race11AssertUtil.assertPilot(sco159, 6, 0, false, 7, 7);
		race11AssertUtil.assertPilot(sco158, 6, 0, false, 8, 8);
		race11AssertUtil.assertPilot(sco019, 5, 0, false, 9, 9);
		race11AssertUtil.assertPilot(sco197, 0, 0, true, 9, 10);
		race11AssertUtil.assertPilot(sco021, 5, 0, false, 10, 11);
		race11AssertUtil.assertPilot(sco060, 2, 0, false, 11, 12);
		race11AssertUtil.assertPilot(sco071, 0, 0, false, 13, 13);
		race11AssertUtil.assertPilot(sco136, 0, 0, false, 13, 13);
		race11AssertUtil.assertDone(1);

		RaceAssertUtil race12AssertUtil = new RaceAssertUtil(scores, race12);
		race12AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
		race12AssertUtil.assertPilot(sco023, 8, 0, false, 2, 2);
		race12AssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
		race12AssertUtil.assertPilot(sco159, 7, 0, false, 4, 4);
		race12AssertUtil.assertPilot(sco154, 0, 0, true, 4, 5);
		race12AssertUtil.assertPilot(sco117, 7, 0, false, 5, 6);
		race12AssertUtil.assertPilot(sco019, 6, 0, false, 6, 7);
		race12AssertUtil.assertPilot(sco197, 6, 0, false, 7, 8);
		race12AssertUtil.assertPilot(sco021, 4, 0, false, 8, 9);
		race12AssertUtil.assertPilot(sco081, 3, 0, false, 9, 10);
		race12AssertUtil.assertPilot(sco060, 1, 0, false, 10, 11);
		race12AssertUtil.assertPilot(sco158, 1, 0, false, 11, 12);
		race12AssertUtil.assertPilot(sco071, 0, 0, false, 13, 13);
		race12AssertUtil.assertPilot(sco136, 0, 0, false, 13, 13);
		race12AssertUtil.assertDone(1);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco200, 1, 5, 1, 2, 2, 2);
		overallAssertUtil.assertPilot(sco023, 0, 11, 2, 5, 3, 2);
		overallAssertUtil.assertPilot(sco081, 0, 24, 3, 10, 9, 5);
		overallAssertUtil.assertPilot(sco179, 1, 35, 4, 10, 6, 6);
		overallAssertUtil.assertPilot(sco154, 0, 37, 5, 9, 8, 7);
		overallAssertUtil.assertPilot(sco117, 0, 52, 6, 14, 10, 8);
		overallAssertUtil.assertPilot(sco159, 1, 54, 7, 13, 12, 12);
		overallAssertUtil.assertPilot(sco019, 0, 60, 8, 13, 11, 11);
		overallAssertUtil.assertPilot(sco060, 0, 73, 9, 14, 11, 10);
		overallAssertUtil.assertPilot(sco071, 0, 75, 10, 13, 13, 13);
		overallAssertUtil.assertPilot(sco197, 0, 78, 11, 13, 13, 12);
		overallAssertUtil.assertPilot(sco021, 1, 84, 12, 13, 13, 12);
		overallAssertUtil.assertPilot(sco136, 0, 91, 13, 13, 13, 13);
		overallAssertUtil.assertPilot(sco158, 0, 100, 14, 13, 13, 13);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent6() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race9 = raceDAO.find(event6, RACE9_NAME);
			Race race10 = raceDAO.find(event6, RACE10_NAME);
			Race race11 = raceDAO.find(event6, RACE11_NAME);
			Race race12 = raceDAO.find(event6, RACE12_NAME);

			Scores scores = scorer.scoreEvent(event6, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE9_FLEET, scores.getFleetSize(race9));
			Assert.assertEquals(RACE10_FLEET, scores.getFleetSize(race10));
			Assert.assertEquals(RACE11_FLEET, scores.getFleetSize(race11));
			Assert.assertEquals(RACE12_FLEET, scores.getFleetSize(race12));

			RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
			race9AssertUtil.assertPilot(sco081, 7, 0, false, 0, 1);
			race9AssertUtil.assertPilot(sco200, 7, 0, false, 2, 2);
			race9AssertUtil.assertPilot(sco023, 0, 0, true, 2, 3);
			race9AssertUtil.assertPilot(sco179, 7, 0, false, 3, 4);
			race9AssertUtil.assertPilot(sco159, 7, 0, false, 4, 5);
			race9AssertUtil.assertPilot(sco154, 6, 0, false, 5, 6);
			race9AssertUtil.assertPilot(sco117, 6, 0, false, 6, 7);
			race9AssertUtil.assertPilot(sco019, 5, 0, false, 7, 8);
			race9AssertUtil.assertPilot(sco197, 5, 0, false, 8, 9);
			race9AssertUtil.assertPilot(sco060, 3, 0, false, 9, 10);
			race9AssertUtil.assertPilot(sco158, 3, 0, false, 10, 11);
			race9AssertUtil.assertPilot(sco021, 1, 0, false, 11, 12);
			race9AssertUtil.assertDone(1);

			RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
			race10AssertUtil.assertPilot(sco081, 8, 0, false, 0, 1);
			race10AssertUtil.assertPilot(sco200, 8, 0, false, 2, 2);
			race10AssertUtil.assertPilot(sco154, 8, 0, false, 3, 3);
			race10AssertUtil.assertPilot(sco179, 8, 0, false, 4, 4);
			race10AssertUtil.assertPilot(sco159, 0, 0, true, 4, 5);
			race10AssertUtil.assertPilot(sco023, 7, 0, false, 5, 6);
			race10AssertUtil.assertPilot(sco117, 7, 0, false, 6, 7);
			race10AssertUtil.assertPilot(sco197, 6, 0, false, 7, 8);
			race10AssertUtil.assertPilot(sco060, 5, 0, false, 8, 9);
			race10AssertUtil.assertPilot(sco021, 4, 0, false, 9, 10);
			race10AssertUtil.assertPilot(sco019, 1, 0, false, 10, 11);
			race10AssertUtil.assertPilot(sco158, 0, 0, false, 13, 12);
			race10AssertUtil.assertDone(1);

			RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
			race11AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			race11AssertUtil.assertPilot(sco023, 8, 0, false, 2, 2);
			race11AssertUtil.assertPilot(sco154, 8, 0, false, 3, 3);
			race11AssertUtil.assertPilot(sco179, 8, 0, false, 4, 4);
			race11AssertUtil.assertPilot(sco081, 8, 0, false, 5, 5);
			race11AssertUtil.assertPilot(sco117, 7, 0, false, 6, 6);
			race11AssertUtil.assertPilot(sco159, 6, 0, false, 7, 7);
			race11AssertUtil.assertPilot(sco197, 0, 0, true, 7, 8);
			race11AssertUtil.assertPilot(sco158, 6, 0, false, 8, 9);
			race11AssertUtil.assertPilot(sco019, 5, 0, false, 9, 10);
			race11AssertUtil.assertPilot(sco021, 5, 0, false, 10, 11);
			race11AssertUtil.assertPilot(sco060, 2, 0, false, 11, 12);
			race11AssertUtil.assertDone(1);

			RaceAssertUtil race12AssertUtil = new RaceAssertUtil(scores, race12);
			race12AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			race12AssertUtil.assertPilot(sco023, 8, 0, false, 2, 2);
			race12AssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
			race12AssertUtil.assertPilot(sco154, 0, 0, true, 3, 4);
			race12AssertUtil.assertPilot(sco159, 7, 0, false, 4, 5);
			race12AssertUtil.assertPilot(sco117, 7, 0, false, 5, 6);
			race12AssertUtil.assertPilot(sco019, 6, 0, false, 6, 7);
			race12AssertUtil.assertPilot(sco197, 6, 0, false, 7, 8);
			race12AssertUtil.assertPilot(sco021, 4, 0, false, 8, 9);
			race12AssertUtil.assertPilot(sco081, 3, 0, false, 9, 10);
			race12AssertUtil.assertPilot(sco060, 1, 0, false, 10, 11);
			race12AssertUtil.assertPilot(sco158, 1, 0, false, 11, 12);
			race12AssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 2, 1, 2);
			overallAssertUtil.assertPilot(sco081, 0, 5, 2, 9);
			overallAssertUtil.assertPilot(sco023, 0, 6, 3, 5);
			overallAssertUtil.assertPilot(sco154, 0, 9, 4, 5);
			overallAssertUtil.assertPilot(sco179, 0, 10, 5, 4);
			overallAssertUtil.assertPilot(sco159, 0, 12, 6, 7);
			overallAssertUtil.assertPilot(sco117, 0, 17, 7, 6);
			overallAssertUtil.assertPilot(sco197, 0, 21, 8, 8);
			overallAssertUtil.assertPilot(sco019, 0, 22, 9, 10);
			overallAssertUtil.assertPilot(sco021, 0, 27, 10, 11);
			overallAssertUtil.assertPilot(sco060, 0, 27, 10, 11);
			overallAssertUtil.assertPilot(sco158, 0, 29, 12, 13);
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
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race9 = raceDAO.find(event6, RACE9_NAME);

			Scores scores = scorer.scoreRace(race9, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE9_FLEET, scores.getFleetSize(race9));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race9);
			raceAssertUtil.assertPilot(sco081, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco200, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco154, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco019, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco197, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco060, 3, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco158, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco021, 1, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco023, 0, 0, true, 13, 12);
			raceAssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco081, 0, 0, 1);
			overallAssertUtil.assertPilot(sco200, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco154, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco019, 0, 7, 7);
			overallAssertUtil.assertPilot(sco197, 0, 8, 8);
			overallAssertUtil.assertPilot(sco060, 0, 9, 9);
			overallAssertUtil.assertPilot(sco158, 0, 10, 10);
			overallAssertUtil.assertPilot(sco021, 0, 11, 11);
			overallAssertUtil.assertPilot(sco023, 0, 13, 12);
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
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race10 = raceDAO.find(event6, RACE10_NAME);

			Scores scores = scorer.scoreRace(race10, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE10_FLEET, scores.getFleetSize(race10));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race10);
			raceAssertUtil.assertPilot(sco081, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco200, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco154, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco023, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco197, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco060, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco021, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco019, 1, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco158, 0, 0, false, 13, 11);
			raceAssertUtil.assertPilot(sco159, 0, 0, true, 13, 11);
			raceAssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco081, 0, 0, 1);
			overallAssertUtil.assertPilot(sco200, 0, 2, 2);
			overallAssertUtil.assertPilot(sco154, 0, 3, 3);
			overallAssertUtil.assertPilot(sco179, 0, 4, 4);
			overallAssertUtil.assertPilot(sco023, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco197, 0, 7, 7);
			overallAssertUtil.assertPilot(sco060, 0, 8, 8);
			overallAssertUtil.assertPilot(sco021, 0, 9, 9);
			overallAssertUtil.assertPilot(sco019, 0, 10, 10);
			overallAssertUtil.assertPilot(sco158, 0, 13, 11);
			overallAssertUtil.assertPilot(sco159, 0, 13, 11);
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
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race11 = raceDAO.find(event6, RACE11_NAME);

			Scores scores = scorer.scoreRace(race11, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE11_FLEET, scores.getFleetSize(race11));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race11);
			raceAssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco154, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco081, 8, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco158, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco019, 5, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco021, 5, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco060, 2, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco197, 0, 0, true, 13, 12);
			raceAssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(sco154, 0, 3, 3);
			overallAssertUtil.assertPilot(sco179, 0, 4, 4);
			overallAssertUtil.assertPilot(sco081, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco159, 0, 7, 7);
			overallAssertUtil.assertPilot(sco158, 0, 8, 8);
			overallAssertUtil.assertPilot(sco019, 0, 9, 9);
			overallAssertUtil.assertPilot(sco021, 0, 10, 10);
			overallAssertUtil.assertPilot(sco060, 0, 11, 11);
			overallAssertUtil.assertPilot(sco197, 0, 13, 12);
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
			Event event6 = eventDAO.find(series, EVENT6_NAME);
			Race race12 = raceDAO.find(event6, RACE12_NAME);

			Scores scores = scorer.scoreRace(race12, Predicates.in(getEventResultsPilots(series, event6)));
			Assert.assertEquals(EVENT6_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE12_FLEET, scores.getFleetSize(race12));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race12);
			raceAssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco117, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco019, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco197, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco021, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco081, 3, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco060, 1, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco158, 1, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco154, 0, 0, true, 13, 12);
			raceAssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(sco117, 0, 5, 5);
			overallAssertUtil.assertPilot(sco019, 0, 6, 6);
			overallAssertUtil.assertPilot(sco197, 0, 7, 7);
			overallAssertUtil.assertPilot(sco021, 0, 8, 8);
			overallAssertUtil.assertPilot(sco081, 0, 9, 9);
			overallAssertUtil.assertPilot(sco060, 0, 10, 10);
			overallAssertUtil.assertPilot(sco158, 0, 11, 11);
			overallAssertUtil.assertPilot(sco154, 0, 13, 12);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}