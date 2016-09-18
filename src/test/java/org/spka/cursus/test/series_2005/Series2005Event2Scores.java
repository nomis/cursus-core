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

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.test.util.OverallAssertUtil;
import uk.uuid.cursus.test.util.RaceAssertUtil;

import com.google.common.base.Predicates;

/**
 * Scores at the end of event 2
 */
public class Series2005Event2Scores extends Series2005Event1Scores {
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
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race5 = raceDAO.find(event2, RACE5_NAME);
		Race race6 = raceDAO.find(event2, RACE6_NAME);
		Race race7 = raceDAO.find(event2, RACE7_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT2, scores.getPilots().size());

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
		race1AssertUtil.assertPilot(sco154, 0, 0, false, 17, 12);
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
		race2AssertUtil.assertPilot(sco159, 0, 0, false, 17, 14);
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
		race7AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 4, 1, 3);
		overallAssertUtil.assertPilot(sco160, 0, 12, 2, 9);
		overallAssertUtil.assertPilot(sco081, 0, 24, 3, 12);
		overallAssertUtil.assertPilot(sco019, 0, 36, 4, 15);
		overallAssertUtil.assertPilot(sco154, 0, 38, 5, 17);
		overallAssertUtil.assertPilot(sco095, 0, 40, 6, 16);
		overallAssertUtil.assertPilot(sco020, 0, 42, 7, 18);
		overallAssertUtil.assertPilot(sco109, 0, 55, 8, 17);
		overallAssertUtil.assertPilot(sco158, 0, 56, 9, 16);
		overallAssertUtil.assertPilot(k882, 0, 60, 10, 17);
		overallAssertUtil.assertPilot(sco136, 0, 60, 11, 14);
		overallAssertUtil.assertPilot(sco050, 0, 64, 12, 17);
		overallAssertUtil.assertPilot(sco117, 0, 64, 13, 17);
		overallAssertUtil.assertPilot(sco159, 0, 69, 14, 17);
		overallAssertUtil.assertPilot(sco135, 0, 75, 15, 17);
		overallAssertUtil.assertPilot(sco060, 0, 78, 16, 18);
		overallAssertUtil.assertPilot(sco100, 0, 81, 17, 17);
		overallAssertUtil.assertPilot(sco071, 0, 88, 18, 17);
		overallAssertUtil.assertPilot(sco105, 0, 94, 19, 18);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent2() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race5 = raceDAO.find(event2, RACE5_NAME);
			Race race6 = raceDAO.find(event2, RACE6_NAME);
			Race race7 = raceDAO.find(event2, RACE7_NAME);

			Scores scores = scorer.scoreEvent(event2, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE5_FLEET, scores.getFleetSize(race5));
			Assert.assertEquals(RACE6_FLEET, scores.getFleetSize(race6));
			Assert.assertEquals(RACE7_FLEET, scores.getFleetSize(race7));

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
			race5AssertUtil.assertPilot(sco060, 0, 0, false, 18, 17);
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
			race7AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 2, 1);
			overallAssertUtil.assertPilot(sco160, 0, 5, 2);
			overallAssertUtil.assertPilot(k882, 0, 9, 3);
			overallAssertUtil.assertPilot(sco081, 0, 12, 4);
			overallAssertUtil.assertPilot(sco019, 0, 20, 5);
			overallAssertUtil.assertPilot(sco154, 0, 22, 6);
			overallAssertUtil.assertPilot(sco109, 0, 22, 7);
			overallAssertUtil.assertPilot(sco117, 0, 25, 8);
			overallAssertUtil.assertPilot(sco095, 0, 30, 9);
			overallAssertUtil.assertPilot(sco100, 0, 30, 10);
			overallAssertUtil.assertPilot(sco158, 0, 36, 11);
			overallAssertUtil.assertPilot(sco136, 0, 36, 12);
			overallAssertUtil.assertPilot(sco071, 0, 37, 13);
			overallAssertUtil.assertPilot(sco135, 0, 39, 14);
			overallAssertUtil.assertPilot(sco159, 0, 40, 15);
			overallAssertUtil.assertPilot(sco050, 0, 43, 16);
			overallAssertUtil.assertPilot(sco060, 0, 49, 17);
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
			Assert.assertEquals(RACE5_FLEET, scores.getFleetSize(race5));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race5);
			raceAssertUtil.assertPilot(sco160, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(k882, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco081, 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco109, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco117, 3, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco154, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco095, 3, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco100, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco136, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco071, 3, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco159, 3, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco158, 3, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco050, 2, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco135, 1, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 18, 17);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco160, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(k882, 0, 3, 3);
			overallAssertUtil.assertPilot(sco019, 0, 4, 4);
			overallAssertUtil.assertPilot(sco081, 0, 5, 5);
			overallAssertUtil.assertPilot(sco109, 0, 6, 6);
			overallAssertUtil.assertPilot(sco117, 0, 7, 7);
			overallAssertUtil.assertPilot(sco154, 0, 8, 8);
			overallAssertUtil.assertPilot(sco095, 0, 9, 9);
			overallAssertUtil.assertPilot(sco100, 0, 10, 10);
			overallAssertUtil.assertPilot(sco136, 0, 11, 11);
			overallAssertUtil.assertPilot(sco071, 0, 12, 12);
			overallAssertUtil.assertPilot(sco159, 0, 13, 13);
			overallAssertUtil.assertPilot(sco158, 0, 14, 14);
			overallAssertUtil.assertPilot(sco050, 0, 15, 15);
			overallAssertUtil.assertPilot(sco135, 0, 16, 16);
			overallAssertUtil.assertPilot(sco060, 0, 18, 17);
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
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE6_FLEET, scores.getFleetSize(race6));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race6);
			raceAssertUtil.assertPilot(sco023, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(k882, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco160, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco081, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco095, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco019, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco109, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco071, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco154, 6, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco135, 6, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco117, 6, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco100, 6, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco050, 6, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco136, 5, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco158, 5, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco060, 4, 0, false, 17, 17);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(k882, 0, 2, 2);
			overallAssertUtil.assertPilot(sco160, 0, 3, 3);
			overallAssertUtil.assertPilot(sco081, 0, 4, 4);
			overallAssertUtil.assertPilot(sco095, 0, 5, 5);
			overallAssertUtil.assertPilot(sco019, 0, 6, 6);
			overallAssertUtil.assertPilot(sco109, 0, 7, 7);
			overallAssertUtil.assertPilot(sco071, 0, 8, 8);
			overallAssertUtil.assertPilot(sco154, 0, 9, 9);
			overallAssertUtil.assertPilot(sco135, 0, 10, 10);
			overallAssertUtil.assertPilot(sco117, 0, 11, 11);
			overallAssertUtil.assertPilot(sco100, 0, 12, 12);
			overallAssertUtil.assertPilot(sco050, 0, 13, 13);
			overallAssertUtil.assertPilot(sco136, 0, 14, 14);
			overallAssertUtil.assertPilot(sco159, 0, 15, 15);
			overallAssertUtil.assertPilot(sco158, 0, 16, 16);
			overallAssertUtil.assertPilot(sco060, 0, 17, 17);
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
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE7_FLEET, scores.getFleetSize(race7));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race7);
			raceAssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco160, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco081, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(k882, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco154, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco158, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco100, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco109, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco136, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco159, 3, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco135, 2, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco060, 2, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco050, 2, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco095, 2, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco071, 1, 0, false, 17, 17);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco160, 0, 2, 2);
			overallAssertUtil.assertPilot(sco081, 0, 3, 3);
			overallAssertUtil.assertPilot(k882, 0, 4, 4);
			overallAssertUtil.assertPilot(sco154, 0, 5, 5);
			overallAssertUtil.assertPilot(sco158, 0, 6, 6);
			overallAssertUtil.assertPilot(sco117, 0, 7, 7);
			overallAssertUtil.assertPilot(sco100, 0, 8, 8);
			overallAssertUtil.assertPilot(sco109, 0, 9, 9);
			overallAssertUtil.assertPilot(sco019, 0, 10, 10);
			overallAssertUtil.assertPilot(sco136, 0, 11, 11);
			overallAssertUtil.assertPilot(sco159, 0, 12, 12);
			overallAssertUtil.assertPilot(sco135, 0, 13, 13);
			overallAssertUtil.assertPilot(sco060, 0, 14, 14);
			overallAssertUtil.assertPilot(sco050, 0, 15, 15);
			overallAssertUtil.assertPilot(sco095, 0, 16, 16);
			overallAssertUtil.assertPilot(sco071, 0, 17, 17);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}