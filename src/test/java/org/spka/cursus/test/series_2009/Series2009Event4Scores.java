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
package org.spka.cursus.test.series_2009;

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
 * Scores at the end of event 4
 */
public class Series2009Event4Scores extends Series2009Event3Scores {
	@Override
	@Before
	public void createDatabase() throws Exception {
		super.createDatabase();
		createEvent4Races();
	}

	@Override
	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Scores scores = scorer.scoreSeries(series, Predicates.in(getSeriesResultsPilots(series)));
			checkSeriesAtEvent4(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkSeriesAtEvent4() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);

			List<Race> races = new ArrayList<Race>();
			races.addAll(event1.getRaces());
			races.addAll(event2.getRaces());
			races.addAll(event3.getRaces());
			races.addAll(event4.getRaces());

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series), Predicates.in(getSeriesResultsPilots(series)));
			checkSeriesAtEvent4(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	private void checkSeriesAtEvent4(Scores scores) throws Exception {
		Series series = seriesDAO.find(SERIES_NAME);
		Event event1 = eventDAO.find(series, EVENT1_NAME);
		Race race1 = raceDAO.find(event1, RACE1_NAME);
		Race race2 = raceDAO.find(event1, RACE2_NAME);
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race3 = raceDAO.find(event2, RACE3_NAME);
		Race race4 = raceDAO.find(event2, RACE4_NAME);
		Event event3 = eventDAO.find(series, EVENT3_NAME);
		Race race5 = raceDAO.find(event3, RACE5_NAME);
		Race race6 = raceDAO.find(event3, RACE6_NAME);
		Race race7 = raceDAO.find(event3, RACE7_NAME);
		Event event4 = eventDAO.find(series, EVENT4_NAME);
		Race race8 = raceDAO.find(event4, RACE8_NAME);
		Race race9 = raceDAO.find(event4, RACE9_NAME);
		Race race10 = raceDAO.find(event4, RACE10_NAME);

		Assert.assertEquals(SERIES_FLEET, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco154, 6, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco159, 5, 1, false, 3, 3);
		race1AssertUtil.assertPilot(sco197, 5, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco179, 4, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco117, 4, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
		race1AssertUtil.assertPilot(sco060, 0, 0, true, 7, 8);
		race1AssertUtil.assertPilot(sco019, 2, 0, false, 8, 9);
		race1AssertUtil.assertPilot(sco042, 0, 0, false, 14, 10);
		race1AssertUtil.assertPilot(sco068, 0, 0, false, 14, 10);
		race1AssertUtil.assertPilot(sco071, 0, 0, false, 14, 10);
		race1AssertUtil.assertPilot(sco081, 0, 0, false, 14, 10);
		race1AssertUtil.assertPilot(sco158, 0, 0, false, 14, 10);
		race1AssertUtil.assertPilot(sco193, 0, 0, false, 14, 10);
		race1AssertUtil.assertDone(1);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco154, 7, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco117, 7, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco179, 6, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco019, 0, 0, true, 5, 6);
		race2AssertUtil.assertPilot(sco197, 6, 0, false, 6, 7);
		race2AssertUtil.assertPilot(sco060, 6, 0, false, 7, 8);
		race2AssertUtil.assertPilot(sco087, 5, 0, false, 8, 9);
		race2AssertUtil.assertPilot(sco042, 4, 0, false, 9, 10);
		race2AssertUtil.assertPilot(sco068, 0, 0, false, 14, 11);
		race2AssertUtil.assertPilot(sco071, 0, 0, false, 14, 11);
		race2AssertUtil.assertPilot(sco081, 0, 0, false, 14, 11);
		race2AssertUtil.assertPilot(sco158, 0, 0, false, 14, 11);
		race2AssertUtil.assertPilot(sco193, 0, 0, false, 14, 11);
		race2AssertUtil.assertDone(1);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco023, 10, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco068, 9, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco154, 0, 0, true, 2, 3);
		race3AssertUtil.assertPilot(sco117, 8, 0, false, 3, 4);
		race3AssertUtil.assertPilot(sco019, 7, 0, false, 4, 5);
		race3AssertUtil.assertPilot(sco197, 7, 0, false, 5, 6);
		race3AssertUtil.assertPilot(sco159, 6, 0, false, 6, 7);
		race3AssertUtil.assertPilot(sco060, 5, 0, false, 7, 8);
		race3AssertUtil.assertPilot(sco179, 1, 0, false, 8, 9);
		race3AssertUtil.assertPilot(sco042, 0, 0, false, 11, 10);
		race3AssertUtil.assertPilot(sco071, 0, 0, false, 11, 10);
		race3AssertUtil.assertPilot(sco081, 0, 0, false, 11, 10);
		race3AssertUtil.assertPilot(sco087, 0, 0, false, 11, 10);
		race3AssertUtil.assertPilot(sco158, 0, 0, false, 11, 10);
		race3AssertUtil.assertPilot(sco193, 0, 0, false, 11, 10);
		race3AssertUtil.assertDone(1);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco023, 8, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco019, 7, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco179, 4, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco117, 3, 0, false, 5, 4);
		race4AssertUtil.assertPilot(sco197, 0, 0, true, 5, 5);
		race4AssertUtil.assertPilot(sco159, 3, 2, false, 4, 6);
		race4AssertUtil.assertPilot(sco068, 2, 0, false, 6, 7);
		race4AssertUtil.assertPilot(sco060, 2, 0, false, 7, 8);
		race4AssertUtil.assertPilot(sco154, 2, 0, false, 8, 9);
		race4AssertUtil.assertPilot(sco042, 0, 0, false, 11, 10);
		race4AssertUtil.assertPilot(sco071, 0, 0, false, 11, 10);
		race4AssertUtil.assertPilot(sco081, 0, 0, false, 11, 10);
		race4AssertUtil.assertPilot(sco087, 0, 0, false, 11, 10);
		race4AssertUtil.assertPilot(sco158, 0, 0, false, 11, 10);
		race4AssertUtil.assertPilot(sco193, 0, 0, false, 11, 10);
		race4AssertUtil.assertDone(1);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(sco159, 6, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco179, 6, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco023, 6, 0, false, 3, 3);
		race5AssertUtil.assertPilot(sco154, 6, 0, false, 4, 4);
		race5AssertUtil.assertPilot(sco117, 5, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco197, 5, 0, false, 6, 6);
		race5AssertUtil.assertPilot(sco019, 4, 0, false, 7, 7);
		race5AssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
		race5AssertUtil.assertPilot(sco060, 3, 0, false, 9, 9);
		race5AssertUtil.assertPilot(sco042, 0, 0, false, 10, 10);
		race5AssertUtil.assertPilot(sco068, 0, 0, false, 10, 10);
		race5AssertUtil.assertPilot(sco071, 0, 0, false, 10, 10);
		race5AssertUtil.assertPilot(sco081, 0, 0, false, 10, 10);
		race5AssertUtil.assertPilot(sco087, 0, 0, false, 10, 10);
		race5AssertUtil.assertPilot(sco193, 0, 0, false, 10, 10);
		race5AssertUtil.assertDone(0);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
		race6AssertUtil.assertPilot(sco154, 7, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco159, 7, 0, false, 3, 3);
		race6AssertUtil.assertPilot(sco019, 7, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco179, 7, 0, false, 5, 5);
		race6AssertUtil.assertPilot(sco117, 6, 0, false, 6, 6);
		race6AssertUtil.assertPilot(sco060, 6, 0, false, 7, 7);
		race6AssertUtil.assertPilot(sco158, 6, 0, false, 8, 8);
		race6AssertUtil.assertPilot(sco197, 5, 0, false, 9, 9);
		race6AssertUtil.assertPilot(sco042, 0, 0, false, 10, 10);
		race6AssertUtil.assertPilot(sco068, 0, 0, false, 10, 10);
		race6AssertUtil.assertPilot(sco071, 0, 0, false, 10, 10);
		race6AssertUtil.assertPilot(sco081, 0, 0, false, 10, 10);
		race6AssertUtil.assertPilot(sco087, 0, 0, false, 10, 10);
		race6AssertUtil.assertPilot(sco193, 0, 0, false, 10, 10);
		race6AssertUtil.assertDone(0);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
		race7AssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
		race7AssertUtil.assertPilot(sco179, 7, 0, false, 2, 2);
		race7AssertUtil.assertPilot(sco154, 6, 0, false, 3, 3);
		race7AssertUtil.assertPilot(sco117, 6, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco060, 5, 0, false, 5, 5);
		race7AssertUtil.assertPilot(sco197, 5, 0, false, 6, 6);
		race7AssertUtil.assertPilot(sco019, 4, 0, false, 7, 7);
		race7AssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
		race7AssertUtil.assertPilot(sco159, 3, 0, false, 9, 9);
		race7AssertUtil.assertPilot(sco042, 0, 0, false, 10, 10);
		race7AssertUtil.assertPilot(sco068, 0, 0, false, 10, 10);
		race7AssertUtil.assertPilot(sco071, 0, 0, false, 10, 10);
		race7AssertUtil.assertPilot(sco081, 0, 0, false, 10, 10);
		race7AssertUtil.assertPilot(sco087, 0, 0, false, 10, 10);
		race7AssertUtil.assertPilot(sco193, 0, 0, false, 10, 10);
		race7AssertUtil.assertDone(0);

		RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
		race8AssertUtil.assertPilot(sco159, 7, 0, false, 0, 1);
		race8AssertUtil.assertPilot(sco154, 7, 0, false, 2, 2);
		race8AssertUtil.assertPilot(sco179, 0, 0, true, 2, 3);
		race8AssertUtil.assertPilot(sco019, 7, 0, false, 3, 4);
		race8AssertUtil.assertPilot(sco197, 6, 0, false, 4, 5);
		race8AssertUtil.assertPilot(sco087, 5, 1, false, 5, 6);
		race8AssertUtil.assertPilot(sco042, 1, 0, false, 6, 7);
		race8AssertUtil.assertPilot(sco023, 0, 0, false, 9, 8);
		race8AssertUtil.assertPilot(sco060, 0, 0, false, 9, 8);
		race8AssertUtil.assertPilot(sco068, 0, 0, false, 9, 8);
		race8AssertUtil.assertPilot(sco071, 0, 0, false, 9, 8);
		race8AssertUtil.assertPilot(sco081, 0, 0, false, 9, 8);
		race8AssertUtil.assertPilot(sco117, 0, 0, false, 9, 8);
		race8AssertUtil.assertPilot(sco158, 0, 0, false, 9, 8);
		race8AssertUtil.assertPilot(sco193, 0, 0, false, 9, 8);
		race8AssertUtil.assertDone(1);

		RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
		race9AssertUtil.assertPilot(sco179, 6, 0, false, 0, 1);
		race9AssertUtil.assertPilot(sco159, 6, 0, false, 2, 2);
		race9AssertUtil.assertPilot(sco154, 6, 0, false, 3, 3);
		race9AssertUtil.assertPilot(sco197, 5, 0, false, 4, 4);
		race9AssertUtil.assertPilot(sco087, 4, 0, false, 5, 5);
		race9AssertUtil.assertPilot(sco019, 3, 0, false, 6, 6);
		race9AssertUtil.assertPilot(sco023, 0, 0, false, 9, 7);
		race9AssertUtil.assertPilot(sco042, 0, 0, false, 9, 7);
		race9AssertUtil.assertPilot(sco060, 0, 0, false, 9, 7);
		race9AssertUtil.assertPilot(sco068, 0, 0, false, 9, 7);
		race9AssertUtil.assertPilot(sco071, 0, 0, false, 9, 7);
		race9AssertUtil.assertPilot(sco081, 0, 0, false, 9, 7);
		race9AssertUtil.assertPilot(sco117, 0, 0, false, 9, 7);
		race9AssertUtil.assertPilot(sco158, 0, 0, false, 9, 7);
		race9AssertUtil.assertPilot(sco193, 0, 0, false, 9, 7);
		race9AssertUtil.assertDone(0);

		RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
		race10AssertUtil.assertPilot(sco179, 6, 0, false, 0, 1);
		race10AssertUtil.assertPilot(sco154, 6, 0, false, 2, 2);
		race10AssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
		race10AssertUtil.assertPilot(sco197, 5, 0, false, 4, 4);
		race10AssertUtil.assertPilot(sco087, 4, 0, false, 5, 5);
		race10AssertUtil.assertPilot(sco019, 3, 0, false, 6, 6);
		race10AssertUtil.assertPilot(sco023, 0, 0, false, 9, 7);
		race10AssertUtil.assertPilot(sco042, 0, 0, false, 9, 7);
		race10AssertUtil.assertPilot(sco060, 0, 0, false, 9, 7);
		race10AssertUtil.assertPilot(sco068, 0, 0, false, 9, 7);
		race10AssertUtil.assertPilot(sco071, 0, 0, false, 9, 7);
		race10AssertUtil.assertPilot(sco081, 0, 0, false, 9, 7);
		race10AssertUtil.assertPilot(sco117, 0, 0, false, 9, 7);
		race10AssertUtil.assertPilot(sco158, 0, 0, false, 9, 7);
		race10AssertUtil.assertPilot(sco193, 0, 0, false, 9, 7);
		race10AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 12, 1, 9, 9);
		overallAssertUtil.assertPilot(sco179, 0, 19, 2, 8, 5);
		overallAssertUtil.assertPilot(sco154, 0, 19, 3, 8, 4);
		overallAssertUtil.assertPilot(sco159, 3, 20, 4, 9, 6);
		overallAssertUtil.assertPilot(sco019, 0, 37, 5, 8, 7);
		overallAssertUtil.assertPilot(sco197, 0, 38, 6, 9, 6);
		overallAssertUtil.assertPilot(sco117, 0, 42, 7, 9, 9);
		overallAssertUtil.assertPilot(sco060, 0, 58, 8, 9, 9);
		overallAssertUtil.assertPilot(sco087, 1, 61, 9, 11, 11);
		overallAssertUtil.assertPilot(sco068, 0, 65, 10, 14, 14);
		overallAssertUtil.assertPilot(sco158, 0, 73, 11, 14, 14);
		overallAssertUtil.assertPilot(sco042, 0, 74, 12, 14, 11);
		overallAssertUtil.assertPilot(sco071, 0, 79, 13, 14, 14);
		overallAssertUtil.assertPilot(sco081, 0, 79, 13, 14, 14);
		overallAssertUtil.assertPilot(sco193, 0, 79, 13, 14, 14);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent4() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race8 = raceDAO.find(event4, RACE8_NAME);
			Race race9 = raceDAO.find(event4, RACE9_NAME);
			Race race10 = raceDAO.find(event4, RACE10_NAME);

			Scores scores = scorer.scoreEvent(event4, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race8));
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race9));
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race10));

			RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
			race8AssertUtil.assertPilot(sco159, 7, 0, false, 0, 1);
			race8AssertUtil.assertPilot(sco179, 0, 0, true, 0, 2);
			race8AssertUtil.assertPilot(sco154, 7, 0, false, 2, 3);
			race8AssertUtil.assertPilot(sco019, 7, 0, false, 3, 4);
			race8AssertUtil.assertPilot(sco197, 6, 0, false, 4, 5);
			race8AssertUtil.assertPilot(sco087, 5, 1, false, 5, 6);
			race8AssertUtil.assertPilot(sco042, 1, 0, false, 6, 7);
			race8AssertUtil.assertPilot(sco060, 0, 0, false, 9, 8);
			race8AssertUtil.assertDone(1);

			RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
			race9AssertUtil.assertPilot(sco179, 6, 0, false, 0, 1);
			race9AssertUtil.assertPilot(sco159, 6, 0, false, 2, 2);
			race9AssertUtil.assertPilot(sco154, 6, 0, false, 3, 3);
			race9AssertUtil.assertPilot(sco197, 5, 0, false, 4, 4);
			race9AssertUtil.assertPilot(sco087, 4, 0, false, 5, 5);
			race9AssertUtil.assertPilot(sco019, 3, 0, false, 6, 6);
			race9AssertUtil.assertPilot(sco042, 0, 0, false, 9, 7);
			race9AssertUtil.assertPilot(sco060, 0, 0, false, 9, 7);
			race9AssertUtil.assertDone(0);

			RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
			race10AssertUtil.assertPilot(sco179, 6, 0, false, 0, 1);
			race10AssertUtil.assertPilot(sco154, 6, 0, false, 2, 2);
			race10AssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			race10AssertUtil.assertPilot(sco197, 5, 0, false, 4, 4);
			race10AssertUtil.assertPilot(sco087, 4, 0, false, 5, 5);
			race10AssertUtil.assertPilot(sco019, 3, 0, false, 6, 6);
			race10AssertUtil.assertPilot(sco042, 0, 0, false, 9, 7);
			race10AssertUtil.assertPilot(sco060, 0, 0, false, 9, 7);
			race10AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco179, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 5, 2);
			overallAssertUtil.assertPilot(sco154, 0, 7, 3);
			overallAssertUtil.assertPilot(sco197, 0, 12, 4);
			overallAssertUtil.assertPilot(sco019, 0, 15, 5);
			overallAssertUtil.assertPilot(sco087, 1, 16, 6);
			overallAssertUtil.assertPilot(sco042, 0, 24, 7);
			overallAssertUtil.assertPilot(sco060, 0, 27, 8);
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
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race8 = raceDAO.find(event4, RACE8_NAME);

			Scores scores = scorer.scoreRace(race8, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race8));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race8);
			raceAssertUtil.assertPilot(sco159, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco154, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco019, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco197, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco087, 5, 1, false, 5, 5);
			raceAssertUtil.assertPilot(sco042, 1, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 9, 7);
			raceAssertUtil.assertPilot(sco179, 0, 0, true, 9, 7);
			raceAssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco159, 0, 0, 1);
			overallAssertUtil.assertPilot(sco154, 0, 2, 2);
			overallAssertUtil.assertPilot(sco019, 0, 3, 3);
			overallAssertUtil.assertPilot(sco197, 0, 4, 4);
			overallAssertUtil.assertPilot(sco087, 1, 6, 5);
			overallAssertUtil.assertPilot(sco042, 0, 6, 6);
			overallAssertUtil.assertPilot(sco060, 0, 9, 7);
			overallAssertUtil.assertPilot(sco179, 0, 9, 7);
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
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race9 = raceDAO.find(event4, RACE9_NAME);

			Scores scores = scorer.scoreRace(race9, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race9));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race9);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco154, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco197, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco019, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco042, 0, 0, false, 9, 7);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 9, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco179, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 2, 2);
			overallAssertUtil.assertPilot(sco154, 0, 3, 3);
			overallAssertUtil.assertPilot(sco197, 0, 4, 4);
			overallAssertUtil.assertPilot(sco087, 0, 5, 5);
			overallAssertUtil.assertPilot(sco019, 0, 6, 6);
			overallAssertUtil.assertPilot(sco042, 0, 9, 7);
			overallAssertUtil.assertPilot(sco060, 0, 9, 7);
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
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race10 = raceDAO.find(event4, RACE10_NAME);

			Scores scores = scorer.scoreRace(race10, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT4_FLEET, scores.getFleetSize(race10));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race10);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco154, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco197, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco019, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco042, 0, 0, false, 9, 7);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 9, 7);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco179, 0, 0, 1);
			overallAssertUtil.assertPilot(sco154, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco197, 0, 4, 4);
			overallAssertUtil.assertPilot(sco087, 0, 5, 5);
			overallAssertUtil.assertPilot(sco019, 0, 6, 6);
			overallAssertUtil.assertPilot(sco042, 0, 9, 7);
			overallAssertUtil.assertPilot(sco060, 0, 9, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}