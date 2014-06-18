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
package org.spka.cursus.test.series_2006;

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
public class Series2006Event4Scores extends Series2006Event3Scores {
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
		Event event3 = eventDAO.find(series, EVENT3_NAME);
		Race race4 = raceDAO.find(event3, RACE4_NAME);
		Race race5 = raceDAO.find(event3, RACE5_NAME);
		Race race6 = raceDAO.find(event3, RACE6_NAME);
		Race race7 = raceDAO.find(event3, RACE7_NAME);
		Event event4 = eventDAO.find(series, EVENT4_NAME);
		Race race9 = raceDAO.find(event4, RACE9_NAME);
		Race race10 = raceDAO.find(event4, RACE10_NAME);
		Race race11 = raceDAO.find(event4, RACE11_NAME);

		Assert.assertEquals(SERIES_FLEET, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco023, 12, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco159, 9, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco071, 8, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco060, 8, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco019, 0, 0, true, 4, 5);
		race1AssertUtil.assertPilot(sco117, 8, 0, false, 5, 6);
		race1AssertUtil.assertPilot(sco050, 8, 0, false, 6, 7);
		race1AssertUtil.assertPilot(sco095, 8, 0, false, 7, 8);
		race1AssertUtil.assertPilot(sco179, 8, 0, false, 8, 9);
		race1AssertUtil.assertPilot(sco135, 8, 0, false, 9, 10);
		race1AssertUtil.assertPilot(sco136, 7, 0, false, 10, 11);
		race1AssertUtil.assertPilot(sco200, 6, 0, false, 11, 12);
		race1AssertUtil.assertPilot(sco181, 6, 0, false, 12, 13);
		race1AssertUtil.assertPilot(sco109, 6, 0, false, 13, 14);
		race1AssertUtil.assertPilot(sco033, 6, 0, false, 14, 15);
		race1AssertUtil.assertPilot(sco158, 4, 0, false, 15, 16);
		race1AssertUtil.assertPilot(sco206, 4, 0, false, 16, 17);
		race1AssertUtil.assertPilot(sco154, 3, 0, false, 17, 18);
		race1AssertUtil.assertPilot(sco205, 1, 0, false, 18, 19);
		race1AssertUtil.assertPilot(sco081, 1, 0, false, 19, 20);
		race1AssertUtil.assertPilot(sco100, 0, 0, false, 21, 21);
		race1AssertUtil.assertPilot(sco143, 0, 0, false, 21, 21);
		race1AssertUtil.assertPilot(sco173, 0, 0, false, 21, 21);
		race1AssertUtil.assertPilot(sco183, 0, 0, false, 21, 21);
		race1AssertUtil.assertPilot(sco197, 0, 0, false, 21, 21);
		race1AssertUtil.assertPilot(sco198, 0, 0, false, 21, 21);
		race1AssertUtil.assertDone(1);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco023, 12, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco135, 9, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco159, 9, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco200, 9, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco019, 0, 0, true, 4, 5);
		race2AssertUtil.assertPilot(sco117, 9, 0, false, 5, 6);
		race2AssertUtil.assertPilot(sco179, 9, 0, false, 6, 7);
		race2AssertUtil.assertPilot(sco071, 8, 0, false, 7, 8);
		race2AssertUtil.assertPilot(sco050, 8, 0, false, 8, 9);
		race2AssertUtil.assertPilot(sco095, 0, 0, true, 8, 10);
		race2AssertUtil.assertPilot(sco081, 7, 0, false, 9, 11);
		race2AssertUtil.assertPilot(sco154, 7, 0, false, 10, 12);
		race2AssertUtil.assertPilot(sco100, 7, 0, false, 11, 13);
		race2AssertUtil.assertPilot(sco181, 7, 0, false, 12, 14);
		race2AssertUtil.assertPilot(sco060, 7, 0, false, 13, 15);
		race2AssertUtil.assertPilot(sco136, 6, 0, false, 14, 16);
		race2AssertUtil.assertPilot(sco158, 6, 0, false, 15, 17);
		race2AssertUtil.assertPilot(sco109, 6, 0, false, 16, 18);
		race2AssertUtil.assertPilot(sco033, 2, 0, false, 17, 19);
		race2AssertUtil.assertPilot(sco143, 0, 0, false, 22, 20);
		race2AssertUtil.assertPilot(sco173, 0, 0, false, 22, 20);
		race2AssertUtil.assertPilot(sco183, 0, 0, false, 22, 20);
		race2AssertUtil.assertPilot(sco197, 0, 0, false, 22, 20);
		race2AssertUtil.assertPilot(sco198, 0, 0, false, 22, 20);
		race2AssertUtil.assertPilot(sco205, 0, 0, false, 22, 20);
		race2AssertUtil.assertPilot(sco206, 0, 0, false, 22, 20);
		race2AssertUtil.assertDone(2);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco081, 9, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco023, 8, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco200, 7, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco071, 7, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco158, 5, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco159, 5, 0, false, 6, 6);
		race3AssertUtil.assertPilot(sco100, 5, 0, false, 7, 7);
		race3AssertUtil.assertPilot(sco136, 5, 0, false, 8, 8);
		race3AssertUtil.assertPilot(sco135, 4, 0, false, 9, 9);
		race3AssertUtil.assertPilot(sco206, 4, 0, false, 10, 10);
		race3AssertUtil.assertPilot(sco060, 0, 0, true, 10, 11);
		race3AssertUtil.assertPilot(sco154, 4, 0, false, 11, 12);
		race3AssertUtil.assertPilot(sco095, 2, 0, false, 12, 13);
		race3AssertUtil.assertPilot(sco019, 1, 0, false, 13, 14);
		race3AssertUtil.assertPilot(sco197, 1, 0, false, 14, 15);
		race3AssertUtil.assertPilot(sco183, 0, 0, true, 19, 16);
		race3AssertUtil.assertPilot(sco033, 0, 0, false, 21, 17);
		race3AssertUtil.assertPilot(sco050, 0, 0, false, 21, 17);
		race3AssertUtil.assertPilot(sco109, 0, 0, false, 21, 17);
		race3AssertUtil.assertPilot(sco117, 0, 0, false, 21, 17);
		race3AssertUtil.assertPilot(sco143, 0, 0, false, 21, 17);
		race3AssertUtil.assertPilot(sco173, 0, 0, false, 21, 17);
		race3AssertUtil.assertPilot(sco179, 0, 0, false, 21, 17);
		race3AssertUtil.assertPilot(sco181, 0, 0, false, 21, 17);
		race3AssertUtil.assertPilot(sco198, 0, 0, false, 21, 17);
		race3AssertUtil.assertPilot(sco205, 0, 0, false, 21, 17);
		race3AssertUtil.assertDone(2);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco081, 7, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco023, 6, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco019, 6, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco200, 6, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco071, 6, 0, false, 5, 5);
		race4AssertUtil.assertPilot(sco136, 6, 0, false, 6, 6);
		race4AssertUtil.assertPilot(sco159, 5, 0, false, 7, 7);
		race4AssertUtil.assertPilot(sco095, 5, 0, false, 8, 8);
		race4AssertUtil.assertPilot(sco117, 5, 0, false, 9, 9);
		race4AssertUtil.assertPilot(sco135, 4, 0, false, 10, 10);
		race4AssertUtil.assertPilot(sco060, 4, 0, false, 11, 11);
		race4AssertUtil.assertPilot(sco158, 4, 0, false, 12, 12);
		race4AssertUtil.assertPilot(sco100, 4, 0, false, 13, 13);
		race4AssertUtil.assertPilot(sco198, 3, 0, false, 14, 14);
		race4AssertUtil.assertPilot(sco154, 3, 0, false, 15, 15);
		race4AssertUtil.assertPilot(sco033, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco050, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco109, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco143, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco173, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco179, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco181, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco183, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco197, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco205, 0, 0, false, 18, 16);
		race4AssertUtil.assertPilot(sco206, 0, 0, false, 18, 16);
		race4AssertUtil.assertDone(0);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco081, 9, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco071, 9, 0, false, 3, 3);
		race5AssertUtil.assertPilot(sco200, 8, 0, false, 4, 4);
		race5AssertUtil.assertPilot(sco136, 8, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco019, 8, 0, false, 6, 6);
		race5AssertUtil.assertPilot(sco135, 8, 0, false, 7, 7);
		race5AssertUtil.assertPilot(sco154, 7, 0, false, 8, 8);
		race5AssertUtil.assertPilot(sco095, 7, 0, false, 9, 9);
		race5AssertUtil.assertPilot(sco159, 7, 0, false, 10, 10);
		race5AssertUtil.assertPilot(sco060, 7, 0, false, 11, 11);
		race5AssertUtil.assertPilot(sco158, 0, 0, true, 11, 12);
		race5AssertUtil.assertPilot(sco100, 6, 0, false, 12, 13);
		race5AssertUtil.assertPilot(sco117, 6, 0, false, 13, 14);
		race5AssertUtil.assertPilot(sco198, 3, 0, false, 14, 15);
		race5AssertUtil.assertPilot(sco197, 1, 0, false, 15, 16);
		race5AssertUtil.assertPilot(sco033, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco050, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco109, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco143, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco173, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco179, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco181, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco183, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco205, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco206, 0, 0, false, 18, 17);
		race5AssertUtil.assertDone(1);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco023, 8, 0, false, 0, 1);
		race6AssertUtil.assertPilot(sco081, 8, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco200, 8, 0, false, 3, 3);
		race6AssertUtil.assertPilot(sco154, 8, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco095, 8, 0, false, 5, 5);
		race6AssertUtil.assertPilot(sco071, 7, 0, false, 6, 6);
		race6AssertUtil.assertPilot(sco135, 7, 0, false, 7, 7);
		race6AssertUtil.assertPilot(sco019, 7, 0, false, 8, 8);
		race6AssertUtil.assertPilot(sco136, 7, 0, false, 9, 9);
		race6AssertUtil.assertPilot(sco159, 7, 0, false, 10, 10);
		race6AssertUtil.assertPilot(sco100, 6, 0, false, 11, 11);
		race6AssertUtil.assertPilot(sco117, 5, 0, false, 12, 12);
		race6AssertUtil.assertPilot(sco060, 5, 0, false, 13, 13);
		race6AssertUtil.assertPilot(sco158, 4, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco198, 3, 0, false, 15, 15);
		race6AssertUtil.assertPilot(sco109, 3, 0, false, 16, 16);
		race6AssertUtil.assertPilot(sco197, 2, 0, false, 17, 17);
		race6AssertUtil.assertPilot(sco033, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco050, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco143, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco173, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco179, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco181, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco183, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco205, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco206, 0, 0, false, 18, 18);
		race6AssertUtil.assertDone(0);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
		race7AssertUtil.assertPilot(sco081, 9, 0, false, 0, 1);
		race7AssertUtil.assertPilot(sco023, 0, 0, true, 0, 2);
		race7AssertUtil.assertPilot(sco200, 9, 0, false, 2, 3);
		race7AssertUtil.assertPilot(sco154, 8, 0, false, 3, 4);
		race7AssertUtil.assertPilot(sco135, 8, 0, false, 4, 5);
		race7AssertUtil.assertPilot(sco136, 8, 0, false, 5, 6);
		race7AssertUtil.assertPilot(sco100, 8, 0, false, 6, 7);
		race7AssertUtil.assertPilot(sco071, 8, 0, false, 7, 8);
		race7AssertUtil.assertPilot(sco159, 7, 0, false, 8, 9);
		race7AssertUtil.assertPilot(sco117, 7, 0, false, 9, 10);
		race7AssertUtil.assertPilot(sco095, 7, 0, false, 10, 11);
		race7AssertUtil.assertPilot(sco060, 7, 0, false, 11, 12);
		race7AssertUtil.assertPilot(sco019, 6, 0, false, 12, 13);
		race7AssertUtil.assertPilot(sco109, 5, 0, false, 13, 14);
		race7AssertUtil.assertPilot(sco158, 3, 0, false, 14, 15);
		race7AssertUtil.assertPilot(sco197, 1, 0, false, 15, 16);
		race7AssertUtil.assertPilot(sco033, 0, 0, false, 18, 17);
		race7AssertUtil.assertPilot(sco050, 0, 0, false, 18, 17);
		race7AssertUtil.assertPilot(sco143, 0, 0, false, 18, 17);
		race7AssertUtil.assertPilot(sco173, 0, 0, false, 18, 17);
		race7AssertUtil.assertPilot(sco179, 0, 0, false, 18, 17);
		race7AssertUtil.assertPilot(sco181, 0, 0, false, 18, 17);
		race7AssertUtil.assertPilot(sco183, 0, 0, false, 18, 17);
		race7AssertUtil.assertPilot(sco198, 0, 0, false, 18, 17);
		race7AssertUtil.assertPilot(sco205, 0, 0, false, 18, 17);
		race7AssertUtil.assertPilot(sco206, 0, 0, false, 18, 17);
		race7AssertUtil.assertDone(1);

		RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
		race9AssertUtil.assertPilot(sco071, 6, 0, false, 0, 1);
		race9AssertUtil.assertPilot(sco154, 6, 0, false, 2, 2);
		race9AssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
		race9AssertUtil.assertPilot(sco135, 6, 0, false, 4, 4);
		race9AssertUtil.assertPilot(sco019, 0, 0, true, 4, 5);
		race9AssertUtil.assertPilot(sco200, 6, 0, false, 5, 6);
		race9AssertUtil.assertPilot(sco159, 5, 0, false, 6, 7);
		race9AssertUtil.assertPilot(sco136, 4, 0, false, 7, 8);
		race9AssertUtil.assertPilot(sco023, 3, 0, false, 8, 9);
		race9AssertUtil.assertPilot(sco100, 3, 0, false, 9, 10);
		race9AssertUtil.assertPilot(sco143, 3, 0, false, 10, 11);
		race9AssertUtil.assertPilot(sco117, 3, 0, false, 11, 12);
		race9AssertUtil.assertPilot(sco158, 0, 0, true, 11, 13);
		race9AssertUtil.assertPilot(sco205, 2, 0, false, 12, 14);
		race9AssertUtil.assertPilot(sco197, 2, 0, false, 13, 15);
		race9AssertUtil.assertPilot(sco033, 1, 0, false, 14, 16);
		race9AssertUtil.assertPilot(sco060, 1, 0, false, 15, 17);
		race9AssertUtil.assertPilot(sco198, 0, 0, true, 16, 18);
		race9AssertUtil.assertPilot(sco050, 0, 0, false, 20, 19);
		race9AssertUtil.assertPilot(sco081, 0, 0, false, 20, 19);
		race9AssertUtil.assertPilot(sco095, 0, 0, false, 20, 19);
		race9AssertUtil.assertPilot(sco109, 0, 0, false, 20, 19);
		race9AssertUtil.assertPilot(sco173, 0, 0, false, 20, 19);
		race9AssertUtil.assertPilot(sco181, 0, 0, false, 20, 19);
		race9AssertUtil.assertPilot(sco183, 0, 0, false, 20, 19);
		race9AssertUtil.assertPilot(sco206, 0, 0, false, 20, 19);
		race9AssertUtil.assertDone(3);

		RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
		race10AssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
		race10AssertUtil.assertPilot(sco019, 7, 0, false, 2, 2);
		race10AssertUtil.assertPilot(sco159, 6, 0, false, 3, 3);
		race10AssertUtil.assertPilot(sco117, 6, 0, false, 4, 4);
		race10AssertUtil.assertPilot(sco135, 5, 0, false, 5, 5);
		race10AssertUtil.assertPilot(sco154, 5, 0, false, 6, 6);
		race10AssertUtil.assertPilot(sco136, 5, 0, false, 7, 7);
		race10AssertUtil.assertPilot(sco205, 5, 0, false, 8, 8);
		race10AssertUtil.assertPilot(sco095, 0, 0, true, 8, 9);
		race10AssertUtil.assertPilot(sco179, 4, 0, false, 9, 10);
		race10AssertUtil.assertPilot(sco100, 0, 0, true, 9, 11);
		race10AssertUtil.assertPilot(sco197, 4, 0, false, 10, 12);
		race10AssertUtil.assertPilot(sco060, 0, 0, true, 10, 13);
		race10AssertUtil.assertPilot(sco071, 4, 0, false, 11, 14);
		race10AssertUtil.assertPilot(sco143, 3, 0, false, 12, 15);
		race10AssertUtil.assertPilot(sco033, 3, 0, false, 13, 16);
		race10AssertUtil.assertPilot(sco158, 3, 0, false, 14, 17);
		race10AssertUtil.assertPilot(sco200, 2, 0, false, 15, 18);
		race10AssertUtil.assertPilot(sco198, 0, 0, true, 16, 19);
		race10AssertUtil.assertPilot(sco050, 0, 0, false, 20, 20);
		race10AssertUtil.assertPilot(sco081, 0, 0, false, 20, 20);
		race10AssertUtil.assertPilot(sco109, 0, 0, false, 20, 20);
		race10AssertUtil.assertPilot(sco173, 0, 0, false, 20, 20);
		race10AssertUtil.assertPilot(sco181, 0, 0, false, 20, 20);
		race10AssertUtil.assertPilot(sco183, 0, 0, false, 20, 20);
		race10AssertUtil.assertPilot(sco206, 0, 0, false, 20, 20);
		race10AssertUtil.assertDone(4);

		RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
		race11AssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
		race11AssertUtil.assertPilot(sco019, 8, 0, false, 2, 2);
		race11AssertUtil.assertPilot(sco200, 8, 0, false, 3, 3);
		race11AssertUtil.assertPilot(sco154, 7, 0, false, 4, 4);
		race11AssertUtil.assertPilot(sco117, 7, 0, false, 5, 5);
		race11AssertUtil.assertPilot(sco136, 7, 0, false, 6, 6);
		race11AssertUtil.assertPilot(sco071, 7, 0, false, 7, 7);
		race11AssertUtil.assertPilot(sco205, 7, 0, false, 8, 8);
		race11AssertUtil.assertPilot(sco095, 0, 0, true, 8, 9);
		race11AssertUtil.assertPilot(sco158, 7, 0, false, 9, 10);
		race11AssertUtil.assertPilot(sco100, 0, 0, true, 9, 11);
		race11AssertUtil.assertPilot(sco159, 7, 0, false, 10, 12);
		race11AssertUtil.assertPilot(sco060, 0, 0, true, 10, 13);
		race11AssertUtil.assertPilot(sco197, 5, 0, false, 11, 14);
		race11AssertUtil.assertPilot(sco179, 5, 0, false, 12, 15);
		race11AssertUtil.assertPilot(sco143, 5, 0, false, 13, 16);
		race11AssertUtil.assertPilot(sco135, 5, 0, false, 14, 17);
		race11AssertUtil.assertPilot(sco033, 2, 0, false, 15, 18);
		race11AssertUtil.assertPilot(sco198, 0, 0, true, 16, 19);
		race11AssertUtil.assertPilot(sco050, 0, 0, false, 20, 20);
		race11AssertUtil.assertPilot(sco081, 0, 0, false, 20, 20);
		race11AssertUtil.assertPilot(sco109, 0, 0, false, 20, 20);
		race11AssertUtil.assertPilot(sco173, 0, 0, false, 20, 20);
		race11AssertUtil.assertPilot(sco181, 0, 0, false, 20, 20);
		race11AssertUtil.assertPilot(sco183, 0, 0, false, 20, 20);
		race11AssertUtil.assertPilot(sco206, 0, 0, false, 20, 20);
		race11AssertUtil.assertDone(4);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 2, 1, 8, 2);
		overallAssertUtil.assertPilot(sco200, 0, 28, 2, 15, 11);
		overallAssertUtil.assertPilot(sco019, 0, 33, 3, 13, 12);
		overallAssertUtil.assertPilot(sco071, 0, 35, 4, 11, 7);
		overallAssertUtil.assertPilot(sco159, 0, 45, 5, 10, 10);
		overallAssertUtil.assertPilot(sco135, 0, 47, 6, 14, 10);
		overallAssertUtil.assertPilot(sco154, 0, 48, 7, 17, 15);
		overallAssertUtil.assertPilot(sco081, 0, 52, 8, 20, 20);
		overallAssertUtil.assertPilot(sco136, 0, 53, 9, 14, 10);
		overallAssertUtil.assertPilot(sco117, 0, 60, 10, 21, 13);
		overallAssertUtil.assertPilot(sco095, 0, 63, 11, 20, 12);
		overallAssertUtil.assertPilot(sco100, 0, 74, 12, 21, 13);
		overallAssertUtil.assertPilot(sco060, 0, 80, 13, 15, 13);
		overallAssertUtil.assertPilot(sco158, 0, 90, 14, 15, 15);
		overallAssertUtil.assertPilot(sco179, 0, 92, 15, 21, 18);
		overallAssertUtil.assertPilot(sco197, 0, 113, 16, 22, 21);
		overallAssertUtil.assertPilot(sco205, 0, 118, 17, 22, 21);
		overallAssertUtil.assertPilot(sco050, 0, 126, 18, 21, 20);
		overallAssertUtil.assertPilot(sco033, 0, 127, 19, 21, 18);
		overallAssertUtil.assertPilot(sco143, 0, 128, 20, 22, 21);
		overallAssertUtil.assertPilot(sco198, 0, 130, 21, 22, 21);
		overallAssertUtil.assertPilot(sco109, 0, 134, 22, 21, 20);
		overallAssertUtil.assertPilot(sco181, 0, 136, 23, 21, 20);
		overallAssertUtil.assertPilot(sco206, 0, 138, 24, 22, 20);
		overallAssertUtil.assertPilot(sco183, 0, 151, 25, 22, 21);
		overallAssertUtil.assertPilot(sco173, 0, 153, 26, 22, 21);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent4() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race9 = raceDAO.find(event4, RACE9_NAME);
			Race race10 = raceDAO.find(event4, RACE10_NAME);
			Race race11 = raceDAO.find(event4, RACE11_NAME);

			Scores scores = scorer.scoreEvent(event4, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE9_FLEET, scores.getFleetSize(race9));
			Assert.assertEquals(RACE10_FLEET, scores.getFleetSize(race10));
			Assert.assertEquals(RACE11_FLEET, scores.getFleetSize(race11));

			RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
			race9AssertUtil.assertPilot(k796, 6, 0, false, 0, 1);
			race9AssertUtil.assertPilot(sco071, 6, 0, false, 2, 2);
			race9AssertUtil.assertPilot(sco154, 6, 0, false, 3, 3);
			race9AssertUtil.assertPilot(sco019, 0, 0, true, 3, 4);
			race9AssertUtil.assertPilot(sco179, 6, 0, false, 4, 5);
			race9AssertUtil.assertPilot(sco135, 6, 0, false, 5, 6);
			race9AssertUtil.assertPilot(sco200, 6, 0, false, 6, 7);
			race9AssertUtil.assertPilot(k795, 6, 0, false, 7, 8);
			race9AssertUtil.assertPilot(sco159, 5, 0, false, 8, 9);
			race9AssertUtil.assertPilot(sco136, 4, 0, false, 9, 10);
			race9AssertUtil.assertPilot(sco023, 3, 0, false, 10, 11);
			race9AssertUtil.assertPilot(sco100, 3, 0, false, 11, 12);
			race9AssertUtil.assertPilot(sco143, 3, 0, false, 12, 13);
			race9AssertUtil.assertPilot(sco117, 3, 0, false, 13, 14);
			race9AssertUtil.assertPilot(sco205, 2, 0, false, 14, 15);
			race9AssertUtil.assertPilot(sco158, 0, 0, true, 14, 16);
			race9AssertUtil.assertPilot(sco197, 2, 0, false, 15, 17);
			race9AssertUtil.assertPilot(sco033, 1, 0, false, 16, 18);
			race9AssertUtil.assertPilot(sco060, 1, 0, false, 17, 19);
			race9AssertUtil.assertPilot(sco095, 0, 0, false, 22, 20);
			race9AssertUtil.assertPilot(sco198, 0, 0, true, 22, 20);
			race9AssertUtil.assertDone(3);

			RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
			race10AssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
			race10AssertUtil.assertPilot(k796, 7, 0, false, 2, 2);
			race10AssertUtil.assertPilot(sco019, 7, 0, false, 3, 3);
			race10AssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
			race10AssertUtil.assertPilot(k795, 6, 0, false, 5, 5);
			race10AssertUtil.assertPilot(sco117, 6, 0, false, 6, 6);
			race10AssertUtil.assertPilot(sco135, 5, 0, false, 7, 7);
			race10AssertUtil.assertPilot(sco154, 5, 0, false, 8, 8);
			race10AssertUtil.assertPilot(sco136, 5, 0, false, 9, 9);
			race10AssertUtil.assertPilot(sco205, 5, 0, false, 10, 10);
			race10AssertUtil.assertPilot(sco179, 4, 0, false, 11, 11);
			race10AssertUtil.assertPilot(sco100, 0, 0, true, 11, 12);
			race10AssertUtil.assertPilot(sco197, 4, 0, false, 12, 13);
			race10AssertUtil.assertPilot(sco071, 4, 0, false, 13, 14);
			race10AssertUtil.assertPilot(sco143, 3, 0, false, 14, 15);
			race10AssertUtil.assertPilot(sco033, 3, 0, false, 15, 16);
			race10AssertUtil.assertPilot(sco158, 3, 0, false, 16, 17);
			race10AssertUtil.assertPilot(sco200, 2, 0, false, 17, 18);
			race10AssertUtil.assertPilot(sco060, 0, 0, true, 17, 19);
			race10AssertUtil.assertPilot(sco095, 0, 0, true, 22, 20);
			race10AssertUtil.assertPilot(sco198, 0, 0, true, 22, 20);
			race10AssertUtil.assertDone(4);

			RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
			race11AssertUtil.assertPilot(k796, 9, 0, false, 0, 1);
			race11AssertUtil.assertPilot(sco023, 9, 0, false, 2, 2);
			race11AssertUtil.assertPilot(sco019, 8, 0, false, 3, 3);
			race11AssertUtil.assertPilot(sco200, 8, 0, false, 4, 4);
			race11AssertUtil.assertPilot(sco154, 7, 0, false, 5, 5);
			race11AssertUtil.assertPilot(sco117, 7, 0, false, 6, 6);
			race11AssertUtil.assertPilot(k795, 7, 0, false, 7, 7);
			race11AssertUtil.assertPilot(sco136, 7, 0, false, 8, 8);
			race11AssertUtil.assertPilot(sco071, 7, 0, false, 9, 9);
			race11AssertUtil.assertPilot(sco205, 7, 0, false, 10, 10);
			race11AssertUtil.assertPilot(sco158, 7, 0, false, 11, 11);
			race11AssertUtil.assertPilot(sco100, 0, 0, true, 11, 12);
			race11AssertUtil.assertPilot(sco159, 7, 0, false, 12, 13);
			race11AssertUtil.assertPilot(sco197, 5, 0, false, 13, 14);
			race11AssertUtil.assertPilot(sco179, 5, 0, false, 14, 15);
			race11AssertUtil.assertPilot(sco143, 5, 0, false, 15, 16);
			race11AssertUtil.assertPilot(sco135, 5, 0, false, 16, 17);
			race11AssertUtil.assertPilot(sco033, 2, 0, false, 17, 18);
			race11AssertUtil.assertPilot(sco060, 0, 0, true, 17, 19);
			race11AssertUtil.assertPilot(sco095, 0, 0, true, 22, 20);
			race11AssertUtil.assertPilot(sco198, 0, 0, true, 22, 20);
			race11AssertUtil.assertDone(4);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(k796, 0, 2, 1);
			overallAssertUtil.assertPilot(sco019, 0, 9, 2);
			overallAssertUtil.assertPilot(sco023, 0, 12, 3);
			overallAssertUtil.assertPilot(sco154, 0, 16, 4);
			overallAssertUtil.assertPilot(k795, 0, 19, 5);
			overallAssertUtil.assertPilot(sco071, 0, 24, 6);
			overallAssertUtil.assertPilot(sco159, 0, 24, 7);
			overallAssertUtil.assertPilot(sco117, 0, 25, 8);
			overallAssertUtil.assertPilot(sco136, 0, 26, 9);
			overallAssertUtil.assertPilot(sco200, 0, 27, 10);
			overallAssertUtil.assertPilot(sco135, 0, 28, 11);
			overallAssertUtil.assertPilot(sco179, 0, 29, 12);
			overallAssertUtil.assertPilot(sco100, 0, 33, 13);
			overallAssertUtil.assertPilot(sco205, 0, 34, 14);
			overallAssertUtil.assertPilot(sco197, 0, 40, 15);
			overallAssertUtil.assertPilot(sco158, 0, 41, 16);
			overallAssertUtil.assertPilot(sco143, 0, 41, 17);
			overallAssertUtil.assertPilot(sco033, 0, 48, 18);
			overallAssertUtil.assertPilot(sco060, 0, 51, 19);
			overallAssertUtil.assertPilot(sco095, 0, 66, 20);
			overallAssertUtil.assertPilot(sco198, 0, 66, 20);
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
			Assert.assertEquals(RACE9_FLEET, scores.getFleetSize(race9));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race9);
			raceAssertUtil.assertPilot(k796, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco071, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco154, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco135, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco200, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(k795, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco136, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco023, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco100, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco143, 3, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco117, 3, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco205, 2, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco197, 2, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco033, 1, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco060, 1, 0, false, 17, 17);
			raceAssertUtil.assertPilot(sco019, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco095, 0, 0, false, 22, 18);
			raceAssertUtil.assertPilot(sco158, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco198, 0, 0, true, 22, 18);
			raceAssertUtil.assertDone(3);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(k796, 0, 0, 1);
			overallAssertUtil.assertPilot(sco071, 0, 2, 2);
			overallAssertUtil.assertPilot(sco154, 0, 3, 3);
			overallAssertUtil.assertPilot(sco179, 0, 4, 4);
			overallAssertUtil.assertPilot(sco135, 0, 5, 5);
			overallAssertUtil.assertPilot(sco200, 0, 6, 6);
			overallAssertUtil.assertPilot(k795, 0, 7, 7);
			overallAssertUtil.assertPilot(sco159, 0, 8, 8);
			overallAssertUtil.assertPilot(sco136, 0, 9, 9);
			overallAssertUtil.assertPilot(sco023, 0, 10, 10);
			overallAssertUtil.assertPilot(sco100, 0, 11, 11);
			overallAssertUtil.assertPilot(sco143, 0, 12, 12);
			overallAssertUtil.assertPilot(sco117, 0, 13, 13);
			overallAssertUtil.assertPilot(sco205, 0, 14, 14);
			overallAssertUtil.assertPilot(sco197, 0, 15, 15);
			overallAssertUtil.assertPilot(sco033, 0, 16, 16);
			overallAssertUtil.assertPilot(sco060, 0, 17, 17);
			overallAssertUtil.assertPilot(sco019, 0, 22, 18);
			overallAssertUtil.assertPilot(sco095, 0, 22, 18);
			overallAssertUtil.assertPilot(sco158, 0, 22, 18);
			overallAssertUtil.assertPilot(sco198, 0, 22, 18);
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
			Assert.assertEquals(RACE10_FLEET, scores.getFleetSize(race10));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race10);
			raceAssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(k796, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco019, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(k795, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco135, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco154, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco136, 5, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco205, 5, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco197, 4, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco071, 4, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco143, 3, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco033, 3, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco158, 3, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco200, 2, 0, false, 17, 17);
			raceAssertUtil.assertPilot(sco060, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco095, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco100, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco198, 0, 0, true, 22, 18);
			raceAssertUtil.assertDone(4);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(k796, 0, 2, 2);
			overallAssertUtil.assertPilot(sco019, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(k795, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco135, 0, 7, 7);
			overallAssertUtil.assertPilot(sco154, 0, 8, 8);
			overallAssertUtil.assertPilot(sco136, 0, 9, 9);
			overallAssertUtil.assertPilot(sco205, 0, 10, 10);
			overallAssertUtil.assertPilot(sco179, 0, 11, 11);
			overallAssertUtil.assertPilot(sco197, 0, 12, 12);
			overallAssertUtil.assertPilot(sco071, 0, 13, 13);
			overallAssertUtil.assertPilot(sco143, 0, 14, 14);
			overallAssertUtil.assertPilot(sco033, 0, 15, 15);
			overallAssertUtil.assertPilot(sco158, 0, 16, 16);
			overallAssertUtil.assertPilot(sco200, 0, 17, 17);
			overallAssertUtil.assertPilot(sco060, 0, 22, 18);
			overallAssertUtil.assertPilot(sco095, 0, 22, 18);
			overallAssertUtil.assertPilot(sco100, 0, 22, 18);
			overallAssertUtil.assertPilot(sco198, 0, 22, 18);
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
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Race race11 = raceDAO.find(event4, RACE11_NAME);

			Scores scores = scorer.scoreRace(race11, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE11_FLEET, scores.getFleetSize(race11));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race11);
			raceAssertUtil.assertPilot(k796, 9, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 9, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco019, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco200, 8, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco154, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(k795, 7, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco136, 7, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco071, 7, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco205, 7, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco158, 7, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco159, 7, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco197, 5, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco179, 5, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco143, 5, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco135, 5, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco033, 2, 0, false, 17, 17);
			raceAssertUtil.assertPilot(sco060, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco095, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco100, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco198, 0, 0, true, 22, 18);
			raceAssertUtil.assertDone(4);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(k796, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(sco019, 0, 3, 3);
			overallAssertUtil.assertPilot(sco200, 0, 4, 4);
			overallAssertUtil.assertPilot(sco154, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(k795, 0, 7, 7);
			overallAssertUtil.assertPilot(sco136, 0, 8, 8);
			overallAssertUtil.assertPilot(sco071, 0, 9, 9);
			overallAssertUtil.assertPilot(sco205, 0, 10, 10);
			overallAssertUtil.assertPilot(sco158, 0, 11, 11);
			overallAssertUtil.assertPilot(sco159, 0, 12, 12);
			overallAssertUtil.assertPilot(sco197, 0, 13, 13);
			overallAssertUtil.assertPilot(sco179, 0, 14, 14);
			overallAssertUtil.assertPilot(sco143, 0, 15, 15);
			overallAssertUtil.assertPilot(sco135, 0, 16, 16);
			overallAssertUtil.assertPilot(sco033, 0, 17, 17);
			overallAssertUtil.assertPilot(sco060, 0, 22, 18);
			overallAssertUtil.assertPilot(sco095, 0, 22, 18);
			overallAssertUtil.assertPilot(sco100, 0, 22, 18);
			overallAssertUtil.assertPilot(sco198, 0, 22, 18);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}