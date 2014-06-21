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
package org.spka.cursus.test.series_2005;

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
public class Series2005Event3Scores extends Series2005Event2Scores {
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
			Scores scores = scorer.scoreSeries(series, Predicates.in(getSeriesResultsPilots(series)));
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

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series), Predicates.in(getSeriesResultsPilots(series)));
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
		Race race3 = raceDAO.find(event1, RACE3_NAME);
		Race race4 = raceDAO.find(event1, RACE4_NAME);
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race5 = raceDAO.find(event2, RACE5_NAME);
		Race race6 = raceDAO.find(event2, RACE6_NAME);
		Race race7 = raceDAO.find(event2, RACE7_NAME);
		Event event3 = eventDAO.find(series, EVENT3_NAME);
		Race race8 = raceDAO.find(event3, RACE8_NAME);

		Assert.assertEquals(SERIES_FLEET, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco023, 3, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco020, 3, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco081, 3, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco160, 3, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco159, 3, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco019, 2, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco105, 2, 0, false, 7, 7);
		race1AssertUtil.assertPilot(sco095, 2, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco158, 2, 0, false, 9, 9);
		race1AssertUtil.assertPilot(sco136, 2, 0, false, 10, 10);
		race1AssertUtil.assertPilot(sco060, 1, 0, false, 11, 11);
		race1AssertUtil.assertPilot(k882, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco050, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco071, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco100, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco109, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco117, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco135, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco143, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco154, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco169, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco178, 0, 0, false, 17, 12);
		race1AssertUtil.assertPilot(sco179, 0, 0, false, 17, 12);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco020, 3, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco023, 3, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco095, 3, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco019, 3, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco081, 3, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco154, 3, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco050, 3, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco109, 2, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco160, 2, 0, false, 9, 9);
		race2AssertUtil.assertPilot(sco135, 2, 0, false, 10, 10);
		race2AssertUtil.assertPilot(sco158, 2, 0, false, 11, 11);
		race2AssertUtil.assertPilot(sco060, 2, 0, false, 12, 12);
		race2AssertUtil.assertPilot(sco136, 1, 0, false, 13, 13);
		race2AssertUtil.assertPilot(k882, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco071, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco100, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco105, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco117, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco143, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco159, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco169, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco178, 0, 0, false, 17, 14);
		race2AssertUtil.assertPilot(sco179, 0, 0, false, 17, 14);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco160, 5, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco020, 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco023, 5, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco095, 5, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco154, 5, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco136, 5, 0, false, 6, 6);
		race3AssertUtil.assertPilot(sco050, 5, 0, false, 7, 7);
		race3AssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
		race3AssertUtil.assertPilot(sco060, 4, 0, false, 9, 9);
		race3AssertUtil.assertPilot(sco117, 4, 0, false, 10, 10);
		race3AssertUtil.assertPilot(sco109, 4, 0, false, 11, 11);
		race3AssertUtil.assertPilot(sco081, 4, 0, false, 12, 12);
		race3AssertUtil.assertPilot(sco135, 3, 0, false, 13, 13);
		race3AssertUtil.assertPilot(sco159, 2, 0, false, 14, 14);
		race3AssertUtil.assertPilot(sco019, 1, 0, false, 15, 15);
		race3AssertUtil.assertPilot(k882, 0, 0, false, 17, 16);
		race3AssertUtil.assertPilot(sco071, 0, 0, false, 17, 16);
		race3AssertUtil.assertPilot(sco100, 0, 0, false, 17, 16);
		race3AssertUtil.assertPilot(sco105, 0, 0, false, 17, 16);
		race3AssertUtil.assertPilot(sco143, 0, 0, false, 17, 16);
		race3AssertUtil.assertPilot(sco169, 0, 0, false, 17, 16);
		race3AssertUtil.assertPilot(sco178, 0, 0, false, 17, 16);
		race3AssertUtil.assertPilot(sco179, 0, 0, false, 17, 16);
		race3AssertUtil.assertDone(0);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco020, 5, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco160, 5, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco081, 5, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco154, 4, 0, false, 5, 5);
		race4AssertUtil.assertPilot(sco019, 4, 0, false, 6, 6);
		race4AssertUtil.assertPilot(sco050, 4, 0, false, 7, 7);
		race4AssertUtil.assertPilot(sco158, 4, 0, false, 8, 8);
		race4AssertUtil.assertPilot(sco136, 4, 0, false, 9, 9);
		race4AssertUtil.assertPilot(sco159, 4, 0, false, 10, 10);
		race4AssertUtil.assertPilot(sco095, 4, 0, false, 11, 11);
		race4AssertUtil.assertPilot(sco117, 3, 0, false, 12, 12);
		race4AssertUtil.assertPilot(sco135, 3, 0, false, 13, 13);
		race4AssertUtil.assertPilot(sco109, 3, 0, false, 14, 14);
		race4AssertUtil.assertPilot(sco060, 3, 0, false, 15, 15);
		race4AssertUtil.assertPilot(k882, 0, 0, false, 17, 16);
		race4AssertUtil.assertPilot(sco071, 0, 0, false, 17, 16);
		race4AssertUtil.assertPilot(sco100, 0, 0, false, 17, 16);
		race4AssertUtil.assertPilot(sco105, 0, 0, false, 17, 16);
		race4AssertUtil.assertPilot(sco143, 0, 0, false, 17, 16);
		race4AssertUtil.assertPilot(sco169, 0, 0, false, 17, 16);
		race4AssertUtil.assertPilot(sco178, 0, 0, false, 17, 16);
		race4AssertUtil.assertPilot(sco179, 0, 0, false, 17, 16);
		race4AssertUtil.assertDone(0);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(sco160, 5, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco023, 5, 0, false, 2, 2);
		race5AssertUtil.assertPilot(k882, 5, 0, false, 3, 3);
		race5AssertUtil.assertPilot(sco019, 4, 0, false, 4, 4);
		race5AssertUtil.assertPilot(sco081, 3, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco109, 3, 0, false, 6, 6);
		race5AssertUtil.assertPilot(sco117, 3, 0, false, 7, 7);
		race5AssertUtil.assertPilot(sco154, 3, 0, false, 8, 8);
		race5AssertUtil.assertPilot(sco095, 3, 0, false, 9, 9);
		race5AssertUtil.assertPilot(sco100, 3, 0, false, 10, 10);
		race5AssertUtil.assertPilot(sco136, 3, 0, false, 11, 11);
		race5AssertUtil.assertPilot(sco071, 3, 0, false, 12, 12);
		race5AssertUtil.assertPilot(sco159, 3, 0, false, 13, 13);
		race5AssertUtil.assertPilot(sco158, 3, 0, false, 14, 14);
		race5AssertUtil.assertPilot(sco050, 2, 0, false, 15, 15);
		race5AssertUtil.assertPilot(sco135, 1, 0, false, 16, 16);
		race5AssertUtil.assertPilot(sco020, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco060, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco105, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco143, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco169, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco178, 0, 0, false, 18, 17);
		race5AssertUtil.assertPilot(sco179, 0, 0, false, 18, 17);
		race5AssertUtil.assertDone(0);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco023, 8, 0, false, 0, 1);
		race6AssertUtil.assertPilot(k882, 8, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco160, 8, 0, false, 3, 3);
		race6AssertUtil.assertPilot(sco081, 7, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco095, 7, 0, false, 5, 5);
		race6AssertUtil.assertPilot(sco019, 6, 0, false, 6, 6);
		race6AssertUtil.assertPilot(sco109, 6, 0, false, 7, 7);
		race6AssertUtil.assertPilot(sco071, 6, 0, false, 8, 8);
		race6AssertUtil.assertPilot(sco154, 6, 0, false, 9, 9);
		race6AssertUtil.assertPilot(sco135, 6, 0, false, 10, 10);
		race6AssertUtil.assertPilot(sco117, 6, 0, false, 11, 11);
		race6AssertUtil.assertPilot(sco100, 6, 0, false, 12, 12);
		race6AssertUtil.assertPilot(sco050, 6, 0, false, 13, 13);
		race6AssertUtil.assertPilot(sco136, 5, 0, false, 14, 14);
		race6AssertUtil.assertPilot(sco159, 5, 0, false, 15, 15);
		race6AssertUtil.assertPilot(sco158, 5, 0, false, 16, 16);
		race6AssertUtil.assertPilot(sco060, 4, 0, false, 17, 17);
		race6AssertUtil.assertPilot(sco020, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco105, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco143, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco169, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco178, 0, 0, false, 18, 18);
		race6AssertUtil.assertPilot(sco179, 0, 0, false, 18, 18);
		race6AssertUtil.assertDone(0);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
		race7AssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
		race7AssertUtil.assertPilot(sco160, 7, 0, false, 2, 2);
		race7AssertUtil.assertPilot(sco081, 6, 0, false, 3, 3);
		race7AssertUtil.assertPilot(k882, 6, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco154, 5, 0, false, 5, 5);
		race7AssertUtil.assertPilot(sco158, 5, 0, false, 6, 6);
		race7AssertUtil.assertPilot(sco117, 4, 0, false, 7, 7);
		race7AssertUtil.assertPilot(sco100, 4, 0, false, 8, 8);
		race7AssertUtil.assertPilot(sco109, 4, 0, false, 9, 9);
		race7AssertUtil.assertPilot(sco019, 4, 0, false, 10, 10);
		race7AssertUtil.assertPilot(sco136, 3, 0, false, 11, 11);
		race7AssertUtil.assertPilot(sco159, 3, 0, false, 12, 12);
		race7AssertUtil.assertPilot(sco135, 2, 0, false, 13, 13);
		race7AssertUtil.assertPilot(sco060, 2, 0, false, 14, 14);
		race7AssertUtil.assertPilot(sco050, 2, 0, false, 15, 15);
		race7AssertUtil.assertPilot(sco095, 2, 0, false, 16, 16);
		race7AssertUtil.assertPilot(sco071, 1, 0, false, 17, 17);
		race7AssertUtil.assertPilot(sco020, 0, 0, false, 18, 18);
		race7AssertUtil.assertPilot(sco105, 0, 0, false, 18, 18);
		race7AssertUtil.assertPilot(sco143, 0, 0, false, 18, 18);
		race7AssertUtil.assertPilot(sco169, 0, 0, false, 18, 18);
		race7AssertUtil.assertPilot(sco178, 0, 0, false, 18, 18);
		race7AssertUtil.assertPilot(sco179, 0, 0, false, 18, 18);
		race7AssertUtil.assertDone(0);

		RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
		race8AssertUtil.assertPilot(sco023, 8, 0, false, 0, 1);
		race8AssertUtil.assertPilot(sco160, 7, 0, false, 2, 2);
		race8AssertUtil.assertPilot(sco019, 6, 0, false, 3, 3);
		race8AssertUtil.assertPilot(sco169, 6, 0, false, 4, 4);
		race8AssertUtil.assertPilot(sco071, 5, 0, false, 5, 5);
		race8AssertUtil.assertPilot(sco117, 4, 0, false, 6, 6);
		race8AssertUtil.assertPilot(sco159, 4, 0, false, 7, 7);
		race8AssertUtil.assertPilot(sco154, 3, 0, false, 8, 8);
		race8AssertUtil.assertPilot(sco081, 3, 0, false, 9, 9);
		race8AssertUtil.assertPilot(sco109, 2, 0, false, 10, 10);
		race8AssertUtil.assertPilot(sco100, 2, 0, false, 11, 11);
		race8AssertUtil.assertPilot(sco060, 1, 0, false, 12, 12);
		race8AssertUtil.assertPilot(sco050, 1, 0, false, 13, 13);
		race8AssertUtil.assertPilot(sco095, 1, 0, false, 14, 14);
		race8AssertUtil.assertPilot(sco136, 1, 0, false, 15, 15);
		race8AssertUtil.assertPilot(k882, 0, 0, false, 16, 16);
		race8AssertUtil.assertPilot(sco020, 0, 0, false, 16, 16);
		race8AssertUtil.assertPilot(sco105, 0, 0, false, 16, 16);
		race8AssertUtil.assertPilot(sco135, 0, 0, false, 16, 16);
		race8AssertUtil.assertPilot(sco143, 0, 0, false, 16, 16);
		race8AssertUtil.assertPilot(sco158, 0, 0, false, 16, 16);
		race8AssertUtil.assertPilot(sco178, 0, 0, false, 16, 16);
		race8AssertUtil.assertPilot(sco179, 0, 0, false, 16, 16);
		race8AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 2, 1, 3, 2);
		overallAssertUtil.assertPilot(sco160, 0, 10, 2, 9, 4);
		overallAssertUtil.assertPilot(sco081, 0, 24, 3, 12, 9);
		overallAssertUtil.assertPilot(sco019, 0, 29, 4, 15, 10);
		overallAssertUtil.assertPilot(sco154, 0, 37, 5, 17, 9);
		overallAssertUtil.assertPilot(sco020, 0, 40, 6, 18, 18);
		overallAssertUtil.assertPilot(sco095, 0, 40, 7, 16, 14);
		overallAssertUtil.assertPilot(sco109, 0, 51, 8, 17, 14);
		overallAssertUtil.assertPilot(sco117, 0, 53, 9, 17, 17);
		overallAssertUtil.assertPilot(sco158, 0, 56, 10, 16, 16);
		overallAssertUtil.assertPilot(k882, 0, 59, 11, 17, 17);
		overallAssertUtil.assertPilot(sco136, 0, 60, 12, 15, 14);
		overallAssertUtil.assertPilot(sco159, 0, 61, 13, 17, 15);
		overallAssertUtil.assertPilot(sco050, 0, 62, 14, 17, 15);
		overallAssertUtil.assertPilot(sco060, 0, 73, 15, 18, 17);
		overallAssertUtil.assertPilot(sco100, 0, 75, 16, 17, 17);
		overallAssertUtil.assertPilot(sco135, 0, 75, 17, 17, 16);
		overallAssertUtil.assertPilot(sco071, 0, 76, 18, 17, 17);
		overallAssertUtil.assertPilot(sco169, 0, 90, 19, 18, 18);
		overallAssertUtil.assertPilot(sco105, 0, 92, 20, 18, 18);
		overallAssertUtil.assertPilot(sco143, 0, 102, 21, 18, 18);
		overallAssertUtil.assertPilot(sco178, 0, 102, 21, 18, 18);
		overallAssertUtil.assertPilot(sco179, 0, 102, 21, 18, 18);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent3() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Race race8 = raceDAO.find(event3, RACE8_NAME);

			Scores scores = scorer.scoreEvent(event3, Predicates.in(getEventResultsPilots(series, event3)));
			Assert.assertEquals(EVENT3_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE8_FLEET, scores.getFleetSize(race8));

			RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
			race8AssertUtil.assertPilot(sco023, 8, 0, false, 0, 1);
			race8AssertUtil.assertPilot(ir043, 8, 0, false, 2, 2);
			race8AssertUtil.assertPilot(ir027, 7, 0, false, 3, 3);
			race8AssertUtil.assertPilot(sco160, 7, 0, false, 4, 4);
			race8AssertUtil.assertPilot(sco019, 6, 0, false, 5, 5);
			race8AssertUtil.assertPilot(sco169, 6, 0, false, 6, 6);
			race8AssertUtil.assertPilot(sco071, 5, 0, false, 7, 7);
			race8AssertUtil.assertPilot(sco117, 4, 0, false, 8, 8);
			race8AssertUtil.assertPilot(sco159, 4, 0, false, 9, 9);
			race8AssertUtil.assertPilot(sco154, 3, 0, false, 10, 10);
			race8AssertUtil.assertPilot(sco081, 3, 0, false, 11, 11);
			race8AssertUtil.assertPilot(sco109, 2, 0, false, 12, 12);
			race8AssertUtil.assertPilot(sco100, 2, 0, false, 13, 13);
			race8AssertUtil.assertPilot(sco060, 1, 0, false, 14, 14);
			race8AssertUtil.assertPilot(sco050, 1, 0, false, 15, 15);
			race8AssertUtil.assertPilot(sco095, 1, 0, false, 16, 16);
			race8AssertUtil.assertPilot(sco136, 1, 0, false, 17, 17);
			race8AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(ir043, 0, 2, 2);
			overallAssertUtil.assertPilot(ir027, 0, 3, 3);
			overallAssertUtil.assertPilot(sco160, 0, 4, 4);
			overallAssertUtil.assertPilot(sco019, 0, 5, 5);
			overallAssertUtil.assertPilot(sco169, 0, 6, 6);
			overallAssertUtil.assertPilot(sco071, 0, 7, 7);
			overallAssertUtil.assertPilot(sco117, 0, 8, 8);
			overallAssertUtil.assertPilot(sco159, 0, 9, 9);
			overallAssertUtil.assertPilot(sco154, 0, 10, 10);
			overallAssertUtil.assertPilot(sco081, 0, 11, 11);
			overallAssertUtil.assertPilot(sco109, 0, 12, 12);
			overallAssertUtil.assertPilot(sco100, 0, 13, 13);
			overallAssertUtil.assertPilot(sco060, 0, 14, 14);
			overallAssertUtil.assertPilot(sco050, 0, 15, 15);
			overallAssertUtil.assertPilot(sco095, 0, 16, 16);
			overallAssertUtil.assertPilot(sco136, 0, 17, 17);
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
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Race race8 = raceDAO.find(event3, RACE8_NAME);

			Scores scores = scorer.scoreRace(race8, Predicates.in(getEventResultsPilots(series, event3)));
			Assert.assertEquals(EVENT3_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE8_FLEET, scores.getFleetSize(race8));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race8);
			raceAssertUtil.assertPilot(sco023, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir043, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir027, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco160, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco019, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco169, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco071, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco154, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco081, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco109, 2, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco100, 2, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco060, 1, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco050, 1, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco095, 1, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco136, 1, 0, false, 17, 17);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(ir043, 0, 2, 2);
			overallAssertUtil.assertPilot(ir027, 0, 3, 3);
			overallAssertUtil.assertPilot(sco160, 0, 4, 4);
			overallAssertUtil.assertPilot(sco019, 0, 5, 5);
			overallAssertUtil.assertPilot(sco169, 0, 6, 6);
			overallAssertUtil.assertPilot(sco071, 0, 7, 7);
			overallAssertUtil.assertPilot(sco117, 0, 8, 8);
			overallAssertUtil.assertPilot(sco159, 0, 9, 9);
			overallAssertUtil.assertPilot(sco154, 0, 10, 10);
			overallAssertUtil.assertPilot(sco081, 0, 11, 11);
			overallAssertUtil.assertPilot(sco109, 0, 12, 12);
			overallAssertUtil.assertPilot(sco100, 0, 13, 13);
			overallAssertUtil.assertPilot(sco060, 0, 14, 14);
			overallAssertUtil.assertPilot(sco050, 0, 15, 15);
			overallAssertUtil.assertPilot(sco095, 0, 16, 16);
			overallAssertUtil.assertPilot(sco136, 0, 17, 17);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}