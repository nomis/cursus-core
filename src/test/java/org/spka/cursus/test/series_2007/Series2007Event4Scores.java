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
package org.spka.cursus.test.series_2007;

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
 * Scores at the end of event 4 (Celtic Challenge)
 */
public class Series2007Event4Scores extends Series2007Event3Scores {
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
			Event event4 = eventDAO.find(series, EVENT4_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, event4), Predicates.in(getSeriesResultsPilots(series, event4)));
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

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, event4), getSeriesResultsEvents(series, event4),
					Predicates.in(getSeriesResultsPilots(series, event4)));
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
		Race race8 = raceDAO.find(event3, RACE8_NAME);
		Event event4 = eventDAO.find(series, EVENT4_NAME);
		Race race9 = raceDAO.find(event4, RACE9_NAME);
		Race race10 = raceDAO.find(event4, RACE10_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT4, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco154, 9, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco200, 8, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco159, 8, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco136, 7, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco135, 7, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco197, 7, 0, false, 7, 7);
		race1AssertUtil.assertPilot(sco060, 6, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco143, 6, 0, false, 9, 9);
		race1AssertUtil.assertPilot(sco221, 6, 0, false, 10, 10);
		race1AssertUtil.assertPilot(sco081, 5, 0, false, 11, 11);
		race1AssertUtil.assertPilot(sco071, 5, 0, false, 12, 12);
		race1AssertUtil.assertPilot(sco019, 5, 0, false, 13, 13);
		race1AssertUtil.assertPilot(sco205, 5, 0, false, 14, 14);
		race1AssertUtil.assertPilot(sco169, 5, 0, false, 15, 15);
		race1AssertUtil.assertPilot(sco198, 4, 0, false, 16, 16);
		race1AssertUtil.assertPilot(sco158, 4, 0, false, 17, 17);
		race1AssertUtil.assertPilot(sco193, 1, 0, false, 18, 18);
		race1AssertUtil.assertPilot(sco023, 0, 0, false, 21, 19);
		race1AssertUtil.assertPilot(sco033, 0, 0, false, 21, 19);
		race1AssertUtil.assertPilot(sco109, 0, 0, false, 21, 19);
		race1AssertUtil.assertPilot(sco117, 0, 0, false, 21, 19);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco200, 7, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco081, 7, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco154, 7, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco135, 7, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco071, 7, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco136, 7, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco159, 7, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco158, 6, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco179, 6, 0, false, 9, 9);
		race2AssertUtil.assertPilot(sco109, 5, 0, false, 10, 10);
		race2AssertUtil.assertPilot(sco060, 5, 0, false, 11, 11);
		race2AssertUtil.assertPilot(sco197, 5, 0, false, 12, 12);
		race2AssertUtil.assertPilot(sco169, 5, 0, false, 13, 13);
		race2AssertUtil.assertPilot(sco198, 4, 0, false, 14, 14);
		race2AssertUtil.assertPilot(sco205, 4, 0, false, 15, 15);
		race2AssertUtil.assertPilot(sco193, 2, 0, false, 16, 16);
		race2AssertUtil.assertPilot(sco019, 0, 0, false, 21, 17);
		race2AssertUtil.assertPilot(sco023, 0, 0, false, 21, 17);
		race2AssertUtil.assertPilot(sco033, 0, 0, false, 21, 17);
		race2AssertUtil.assertPilot(sco117, 0, 0, false, 21, 17);
		race2AssertUtil.assertPilot(sco143, 0, 0, false, 21, 17);
		race2AssertUtil.assertPilot(sco221, 0, 0, false, 21, 17);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco200, 5, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco023, 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco081, 5, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco154, 4, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco179, 4, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco071, 4, 0, false, 6, 6);
		race3AssertUtil.assertPilot(sco135, 4, 0, false, 7, 7);
		race3AssertUtil.assertPilot(sco019, 4, 0, false, 8, 8);
		race3AssertUtil.assertPilot(sco197, 0, 0, true, 8, 9);
		race3AssertUtil.assertPilot(sco159, 3, 0, false, 9, 10);
		race3AssertUtil.assertPilot(sco060, 3, 0, false, 10, 11);
		race3AssertUtil.assertPilot(sco136, 0, 0, true, 10, 12);
		race3AssertUtil.assertPilot(sco117, 3, 0, false, 11, 13);
		race3AssertUtil.assertPilot(sco193, 2, 0, false, 12, 14);
		race3AssertUtil.assertPilot(sco109, 2, 0, false, 13, 15);
		race3AssertUtil.assertPilot(sco205, 0, 0, true, 14, 16);
		race3AssertUtil.assertPilot(sco033, 0, 0, false, 17, 17);
		race3AssertUtil.assertPilot(sco143, 0, 0, false, 17, 17);
		race3AssertUtil.assertPilot(sco158, 0, 0, false, 17, 17);
		race3AssertUtil.assertPilot(sco169, 0, 0, false, 17, 17);
		race3AssertUtil.assertPilot(sco198, 0, 0, false, 17, 17);
		race3AssertUtil.assertPilot(sco221, 0, 0, false, 17, 17);
		race3AssertUtil.assertDone(3);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco071, 8, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco159, 8, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco154, 8, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco081, 0, 0, true, 4, 5);
		race4AssertUtil.assertPilot(sco200, 7, 0, false, 5, 6);
		race4AssertUtil.assertPilot(sco135, 7, 0, false, 6, 7);
		race4AssertUtil.assertPilot(sco019, 6, 0, false, 7, 8);
		race4AssertUtil.assertPilot(sco060, 6, 0, false, 8, 9);
		race4AssertUtil.assertPilot(sco197, 6, 0, false, 9, 10);
		race4AssertUtil.assertPilot(sco179, 6, 0, false, 10, 11);
		race4AssertUtil.assertPilot(sco143, 0, 0, true, 11, 12);
		race4AssertUtil.assertPilot(sco033, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco109, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco117, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco136, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco158, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco169, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco193, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco198, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco205, 0, 0, false, 14, 13);
		race4AssertUtil.assertPilot(sco221, 0, 0, false, 14, 13);
		race4AssertUtil.assertDone(2);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco019, 9, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco135, 9, 0, false, 3, 3);
		race5AssertUtil.assertPilot(sco159, 0, 0, true, 3, 4);
		race5AssertUtil.assertPilot(sco200, 8, 0, false, 4, 5);
		race5AssertUtil.assertPilot(sco081, 8, 0, false, 5, 6);
		race5AssertUtil.assertPilot(sco071, 8, 0, false, 6, 7);
		race5AssertUtil.assertPilot(sco154, 7, 0, false, 7, 8);
		race5AssertUtil.assertPilot(sco197, 7, 0, false, 8, 9);
		race5AssertUtil.assertPilot(sco060, 7, 0, false, 9, 10);
		race5AssertUtil.assertPilot(sco143, 6, 0, false, 10, 11);
		race5AssertUtil.assertPilot(sco179, 6, 0, false, 11, 12);
		race5AssertUtil.assertPilot(sco033, 0, 0, false, 14, 13);
		race5AssertUtil.assertPilot(sco109, 0, 0, false, 14, 13);
		race5AssertUtil.assertPilot(sco117, 0, 0, false, 14, 13);
		race5AssertUtil.assertPilot(sco136, 0, 0, false, 14, 13);
		race5AssertUtil.assertPilot(sco158, 0, 0, false, 14, 13);
		race5AssertUtil.assertPilot(sco169, 0, 0, false, 14, 13);
		race5AssertUtil.assertPilot(sco193, 0, 0, false, 14, 13);
		race5AssertUtil.assertPilot(sco198, 0, 0, false, 14, 13);
		race5AssertUtil.assertPilot(sco205, 0, 0, true, 14, 13);
		race5AssertUtil.assertPilot(sco221, 0, 0, false, 14, 13);
		race5AssertUtil.assertDone(2);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
		race6AssertUtil.assertPilot(sco200, 9, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco159, 9, 0, false, 3, 3);
		race6AssertUtil.assertPilot(sco154, 0, 0, true, 3, 4);
		race6AssertUtil.assertPilot(sco135, 8, 0, false, 4, 5);
		race6AssertUtil.assertPilot(sco143, 8, 0, false, 5, 6);
		race6AssertUtil.assertPilot(sco197, 8, 0, false, 6, 7);
		race6AssertUtil.assertPilot(sco019, 0, 0, true, 6, 8);
		race6AssertUtil.assertPilot(sco060, 7, 0, false, 7, 9);
		race6AssertUtil.assertPilot(sco071, 7, 0, false, 8, 10);
		race6AssertUtil.assertPilot(sco179, 7, 0, false, 9, 11);
		race6AssertUtil.assertPilot(sco081, 4, 0, false, 10, 12);
		race6AssertUtil.assertPilot(sco205, 4, 0, false, 11, 13);
		race6AssertUtil.assertPilot(sco033, 0, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco109, 0, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco117, 0, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco136, 0, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco158, 0, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco169, 0, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco193, 0, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco198, 0, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco221, 0, 0, false, 14, 14);
		race6AssertUtil.assertDone(2);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
		race7AssertUtil.assertPilot(sco200, 10, 0, false, 0, 1);
		race7AssertUtil.assertPilot(sco023, 10, 0, false, 2, 2);
		race7AssertUtil.assertPilot(sco159, 10, 0, false, 3, 3);
		race7AssertUtil.assertPilot(sco081, 10, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco154, 10, 0, false, 5, 5);
		race7AssertUtil.assertPilot(sco135, 9, 0, false, 6, 6);
		race7AssertUtil.assertPilot(sco179, 0, 0, true, 6, 7);
		race7AssertUtil.assertPilot(sco071, 9, 0, false, 7, 8);
		race7AssertUtil.assertPilot(sco019, 6, 0, false, 8, 9);
		race7AssertUtil.assertPilot(sco060, 0, 0, true, 8, 10);
		race7AssertUtil.assertPilot(sco197, 5, 0, false, 9, 11);
		race7AssertUtil.assertPilot(sco143, 2, 0, false, 10, 12);
		race7AssertUtil.assertPilot(sco033, 0, 0, false, 14, 13);
		race7AssertUtil.assertPilot(sco109, 0, 0, false, 14, 13);
		race7AssertUtil.assertPilot(sco117, 0, 0, false, 14, 13);
		race7AssertUtil.assertPilot(sco136, 0, 0, false, 14, 13);
		race7AssertUtil.assertPilot(sco158, 0, 0, false, 14, 13);
		race7AssertUtil.assertPilot(sco169, 0, 0, false, 14, 13);
		race7AssertUtil.assertPilot(sco193, 0, 0, false, 14, 13);
		race7AssertUtil.assertPilot(sco198, 0, 0, false, 14, 13);
		race7AssertUtil.assertPilot(sco205, 0, 0, false, 14, 13);
		race7AssertUtil.assertPilot(sco221, 0, 0, false, 14, 13);
		race7AssertUtil.assertDone(2);

		RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
		race8AssertUtil.assertPilot(sco159, 10, 0, false, 0, 1);
		race8AssertUtil.assertPilot(sco200, 0, 0, true, 1, 2);
		race8AssertUtil.assertPilot(sco023, 10, 0, false, 2, 3);
		race8AssertUtil.assertPilot(sco154, 10, 0, false, 3, 4);
		race8AssertUtil.assertPilot(sco081, 10, 0, false, 4, 5);
		race8AssertUtil.assertPilot(sco179, 10, 0, false, 5, 6);
		race8AssertUtil.assertPilot(sco071, 9, 0, false, 6, 7);
		race8AssertUtil.assertPilot(sco019, 9, 0, false, 7, 8);
		race8AssertUtil.assertPilot(sco135, 9, 0, false, 8, 9);
		race8AssertUtil.assertPilot(sco197, 8, 0, false, 9, 10);
		race8AssertUtil.assertPilot(sco060, 7, 0, false, 10, 11);
		race8AssertUtil.assertPilot(sco033, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco109, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco117, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco136, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco143, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco158, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco169, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco193, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco198, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco205, 0, 0, false, 14, 12);
		race8AssertUtil.assertPilot(sco221, 0, 0, false, 14, 12);
		race8AssertUtil.assertDone(1);

		RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
		race9AssertUtil.assertPilot(sco200, 6, 0, false, 0, 1);
		race9AssertUtil.assertPilot(sco023, 0, 0, true, 1, 2);
		race9AssertUtil.assertPilot(sco019, 6, 0, false, 2, 3);
		race9AssertUtil.assertPilot(sco159, 5, 0, false, 3, 4);
		race9AssertUtil.assertPilot(sco169, 4, 0, false, 4, 5);
		race9AssertUtil.assertPilot(sco135, 0, 0, true, 4, 6);
		race9AssertUtil.assertPilot(sco081, 4, 0, false, 5, 7);
		race9AssertUtil.assertPilot(sco179, 4, 0, false, 6, 8);
		race9AssertUtil.assertPilot(sco154, 3, 0, false, 7, 9);
		race9AssertUtil.assertPilot(sco071, 3, 0, false, 8, 10);
		race9AssertUtil.assertPilot(sco033, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco060, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco109, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco117, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco136, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco143, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco158, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco193, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco197, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco198, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco205, 0, 0, false, 14, 11);
		race9AssertUtil.assertPilot(sco221, 0, 0, false, 14, 11);
		race9AssertUtil.assertDone(2);

		RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
		race10AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
		race10AssertUtil.assertPilot(sco023, 0, 0, true, 1, 2);
		race10AssertUtil.assertPilot(sco135, 8, 0, false, 2, 3);
		race10AssertUtil.assertPilot(sco136, 7, 0, false, 3, 4);
		race10AssertUtil.assertPilot(sco154, 0, 0, true, 3, 5);
		race10AssertUtil.assertPilot(sco159, 0, 0, true, 3, 5);
		race10AssertUtil.assertPilot(sco179, 7, 0, false, 4, 7);
		race10AssertUtil.assertPilot(sco081, 6, 0, false, 5, 8);
		race10AssertUtil.assertPilot(sco060, 6, 0, false, 6, 9);
		race10AssertUtil.assertPilot(sco019, 0, 0, true, 6, 10);
		race10AssertUtil.assertPilot(sco197, 6, 0, false, 7, 11);
		race10AssertUtil.assertPilot(sco033, 2, 0, false, 8, 12);
		race10AssertUtil.assertPilot(sco169, 2, 0, false, 9, 13);
		race10AssertUtil.assertPilot(sco071, 0, 0, false, 15, 14);
		race10AssertUtil.assertPilot(sco109, 0, 0, false, 15, 14);
		race10AssertUtil.assertPilot(sco117, 0, 0, false, 15, 14);
		race10AssertUtil.assertPilot(sco143, 0, 0, false, 15, 14);
		race10AssertUtil.assertPilot(sco158, 0, 0, false, 15, 14);
		race10AssertUtil.assertPilot(sco193, 0, 0, false, 15, 14);
		race10AssertUtil.assertPilot(sco198, 0, 0, false, 15, 14);
		race10AssertUtil.assertPilot(sco205, 0, 0, false, 15, 14);
		race10AssertUtil.assertPilot(sco221, 0, 0, false, 15, 14);
		race10AssertUtil.assertDone(4);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco200, 0, 5, 1, 5, 4);
		overallAssertUtil.assertPilot(sco023, 0, 8, 2, 21, 21);
		overallAssertUtil.assertPilot(sco159, 0, 21, 3, 9, 7);
		overallAssertUtil.assertPilot(sco154, 0, 25, 4, 7, 7);
		overallAssertUtil.assertPilot(sco081, 0, 32, 5, 11, 10);
		overallAssertUtil.assertPilot(sco135, 0, 35, 6, 8, 7);
		overallAssertUtil.assertPilot(sco019, 0, 46, 7, 21, 13);
		overallAssertUtil.assertPilot(sco071, 0, 48, 8, 15, 12);
		overallAssertUtil.assertPilot(sco179, 0, 48, 9, 11, 10);
		overallAssertUtil.assertPilot(sco197, 0, 63, 10, 14, 12);
		overallAssertUtil.assertPilot(sco060, 0, 66, 11, 14, 11);
		overallAssertUtil.assertPilot(sco136, 0, 80, 12, 14, 14);
		overallAssertUtil.assertPilot(sco143, 0, 88, 13, 21, 17);
		overallAssertUtil.assertPilot(sco169, 0, 96, 14, 17, 15);
		overallAssertUtil.assertPilot(sco158, 0, 107, 15, 17, 17);
		overallAssertUtil.assertPilot(sco109, 0, 107, 16, 21, 15);
		overallAssertUtil.assertPilot(sco033, 0, 109, 17, 21, 21);
		overallAssertUtil.assertPilot(sco221, 0, 109, 18, 21, 17);
		overallAssertUtil.assertPilot(sco205, 0, 109, 19, 15, 15);
		overallAssertUtil.assertPilot(sco117, 0, 110, 20, 21, 21);
		overallAssertUtil.assertPilot(sco193, 0, 111, 21, 18, 16);
		overallAssertUtil.assertPilot(sco198, 0, 113, 22, 17, 16);
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

			Scores scores = scorer.scoreEvent(event4, Predicates.in(getEventResultsPilots(series, event4)));
			Assert.assertEquals(EVENT4_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE9_FLEET, scores.getFleetSize(race9));
			Assert.assertEquals(RACE10_FLEET, scores.getFleetSize(race10));

			RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
			race9AssertUtil.assertPilot(sco200, 6, 0, false, 0, 1);
			race9AssertUtil.assertPilot(sco019, 6, 0, false, 2, 2);
			race9AssertUtil.assertPilot(sco135, 0, 0, true, 2, 3);
			race9AssertUtil.assertPilot(sco159, 5, 0, false, 3, 4);
			race9AssertUtil.assertPilot(sco169, 4, 0, false, 4, 5);
			race9AssertUtil.assertPilot(sco081, 4, 0, false, 5, 6);
			race9AssertUtil.assertPilot(sco179, 4, 0, false, 6, 7);
			race9AssertUtil.assertPilot(sco154, 3, 0, false, 7, 8);
			race9AssertUtil.assertPilot(sco071, 3, 0, false, 8, 9);
			race9AssertUtil.assertPilot(sco023, 0, 0, true, 14, 10);
			race9AssertUtil.assertPilot(sco033, 0, 0, false, 14, 10);
			race9AssertUtil.assertPilot(sco060, 0, 0, false, 14, 10);
			race9AssertUtil.assertPilot(sco109, 0, 0, false, 14, 10);
			race9AssertUtil.assertPilot(sco136, 0, 0, false, 14, 10);
			race9AssertUtil.assertPilot(sco197, 0, 0, false, 14, 10);
			race9AssertUtil.assertDone(2);

			RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
			race10AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			race10AssertUtil.assertPilot(sco135, 8, 0, false, 2, 2);
			race10AssertUtil.assertPilot(sco019, 0, 0, true, 2, 3);
			race10AssertUtil.assertPilot(sco136, 7, 0, false, 3, 4);
			race10AssertUtil.assertPilot(sco159, 0, 0, true, 3, 5);
			race10AssertUtil.assertPilot(sco179, 7, 0, false, 4, 6);
			race10AssertUtil.assertPilot(sco081, 6, 0, false, 5, 7);
			race10AssertUtil.assertPilot(sco060, 6, 0, false, 6, 8);
			race10AssertUtil.assertPilot(sco197, 6, 0, false, 7, 9);
			race10AssertUtil.assertPilot(sco154, 0, 0, true, 7, 10);
			race10AssertUtil.assertPilot(sco033, 2, 0, false, 8, 11);
			race10AssertUtil.assertPilot(sco169, 2, 0, false, 9, 12);
			race10AssertUtil.assertPilot(sco023, 0, 0, true, 15, 13);
			race10AssertUtil.assertPilot(sco071, 0, 0, false, 15, 13);
			race10AssertUtil.assertPilot(sco109, 0, 0, false, 15, 13);
			race10AssertUtil.assertDone(4);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(sco019, 0, 4, 2);
			overallAssertUtil.assertPilot(sco135, 0, 4, 2);
			overallAssertUtil.assertPilot(sco159, 0, 6, 4);
			overallAssertUtil.assertPilot(sco179, 0, 10, 5);
			overallAssertUtil.assertPilot(sco081, 0, 10, 6);
			overallAssertUtil.assertPilot(sco169, 0, 13, 7);
			overallAssertUtil.assertPilot(sco154, 0, 14, 8);
			overallAssertUtil.assertPilot(sco136, 0, 17, 9);
			overallAssertUtil.assertPilot(sco060, 0, 20, 10);
			overallAssertUtil.assertPilot(sco197, 0, 21, 11);
			overallAssertUtil.assertPilot(sco033, 0, 22, 12);
			overallAssertUtil.assertPilot(sco071, 0, 23, 13);
			overallAssertUtil.assertPilot(sco023, 0, 29, 14);
			overallAssertUtil.assertPilot(sco109, 0, 29, 14);
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
			raceAssertUtil.assertPilot(sco200, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco019, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco169, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco081, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco154, 3, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco071, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco023, 0, 0, true, 14, 9);
			raceAssertUtil.assertPilot(sco033, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco109, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco135, 0, 0, true, 14, 9);
			raceAssertUtil.assertPilot(sco136, 0, 0, false, 14, 9);
			raceAssertUtil.assertPilot(sco197, 0, 0, false, 14, 9);
			raceAssertUtil.assertDone(2);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(sco019, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco169, 0, 4, 4);
			overallAssertUtil.assertPilot(sco081, 0, 5, 5);
			overallAssertUtil.assertPilot(sco179, 0, 6, 6);
			overallAssertUtil.assertPilot(sco154, 0, 7, 7);
			overallAssertUtil.assertPilot(sco071, 0, 8, 8);
			overallAssertUtil.assertPilot(sco023, 0, 14, 9);
			overallAssertUtil.assertPilot(sco033, 0, 14, 9);
			overallAssertUtil.assertPilot(sco060, 0, 14, 9);
			overallAssertUtil.assertPilot(sco109, 0, 14, 9);
			overallAssertUtil.assertPilot(sco135, 0, 14, 9);
			overallAssertUtil.assertPilot(sco136, 0, 14, 9);
			overallAssertUtil.assertPilot(sco197, 0, 14, 9);
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
			raceAssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco135, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco136, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco179, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco081, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco060, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco197, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco033, 2, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco169, 2, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco019, 0, 0, true, 15, 10);
			raceAssertUtil.assertPilot(sco023, 0, 0, true, 15, 10);
			raceAssertUtil.assertPilot(sco071, 0, 0, false, 15, 10);
			raceAssertUtil.assertPilot(sco109, 0, 0, false, 15, 10);
			raceAssertUtil.assertPilot(sco154, 0, 0, true, 15, 10);
			raceAssertUtil.assertPilot(sco159, 0, 0, true, 15, 10);
			raceAssertUtil.assertDone(4);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(sco135, 0, 2, 2);
			overallAssertUtil.assertPilot(sco136, 0, 3, 3);
			overallAssertUtil.assertPilot(sco179, 0, 4, 4);
			overallAssertUtil.assertPilot(sco081, 0, 5, 5);
			overallAssertUtil.assertPilot(sco060, 0, 6, 6);
			overallAssertUtil.assertPilot(sco197, 0, 7, 7);
			overallAssertUtil.assertPilot(sco033, 0, 8, 8);
			overallAssertUtil.assertPilot(sco169, 0, 9, 9);
			overallAssertUtil.assertPilot(sco019, 0, 15, 10);
			overallAssertUtil.assertPilot(sco023, 0, 15, 10);
			overallAssertUtil.assertPilot(sco071, 0, 15, 10);
			overallAssertUtil.assertPilot(sco109, 0, 15, 10);
			overallAssertUtil.assertPilot(sco154, 0, 15, 10);
			overallAssertUtil.assertPilot(sco159, 0, 15, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}