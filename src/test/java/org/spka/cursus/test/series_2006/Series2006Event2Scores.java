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
 * Scores at the end of event 2
 */
public class Series2006Event2Scores extends Series2006Event1Scores {
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
		Event event2 = eventDAO.find(series, EVENT2_NAME);
		Race race3 = raceDAO.find(event2, RACE3_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT2, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco023, 12, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco159, 9, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco071, 8, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco060, 8, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco117, 8, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco050, 8, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco095, 8, 0, false, 7, 7);
		race1AssertUtil.assertPilot(sco179, 8, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco135, 8, 0, false, 9, 9);
		race1AssertUtil.assertPilot(sco136, 7, 0, false, 10, 10);
		race1AssertUtil.assertPilot(sco200, 6, 0, false, 11, 11);
		race1AssertUtil.assertPilot(sco181, 6, 0, false, 12, 12);
		race1AssertUtil.assertPilot(sco109, 6, 0, false, 13, 13);
		race1AssertUtil.assertPilot(sco019, 0, 0, true, 13, 14);
		race1AssertUtil.assertPilot(sco033, 6, 0, false, 14, 15);
		race1AssertUtil.assertPilot(sco158, 4, 0, false, 15, 16);
		race1AssertUtil.assertPilot(sco206, 4, 0, false, 16, 17);
		race1AssertUtil.assertPilot(sco154, 3, 0, false, 17, 18);
		race1AssertUtil.assertPilot(sco205, 1, 0, false, 18, 19);
		race1AssertUtil.assertPilot(sco081, 1, 0, false, 19, 20);
		race1AssertUtil.assertPilot(sco100, 0, 0, false, 21, 21);
		race1AssertUtil.assertPilot(sco183, 0, 0, false, 21, 21);
		race1AssertUtil.assertPilot(sco197, 0, 0, false, 21, 21);
		race1AssertUtil.assertDone(1);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco023, 12, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco135, 9, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco159, 9, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco200, 9, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco117, 9, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco179, 9, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco071, 8, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco050, 8, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco081, 7, 0, false, 9, 9);
		race2AssertUtil.assertPilot(sco154, 7, 0, false, 10, 10);
		race2AssertUtil.assertPilot(sco095, 0, 0, true, 10, 11);
		race2AssertUtil.assertPilot(sco100, 7, 0, false, 11, 12);
		race2AssertUtil.assertPilot(sco181, 7, 0, false, 12, 13);
		race2AssertUtil.assertPilot(sco060, 7, 0, false, 13, 14);
		race2AssertUtil.assertPilot(sco019, 0, 0, true, 13, 15);
		race2AssertUtil.assertPilot(sco136, 6, 0, false, 14, 16);
		race2AssertUtil.assertPilot(sco158, 6, 0, false, 15, 17);
		race2AssertUtil.assertPilot(sco109, 6, 0, false, 16, 18);
		race2AssertUtil.assertPilot(sco033, 2, 0, false, 17, 19);
		race2AssertUtil.assertPilot(sco183, 0, 0, false, 22, 20);
		race2AssertUtil.assertPilot(sco197, 0, 0, false, 22, 20);
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
		race3AssertUtil.assertPilot(sco060, 0, 0, true, 9, 10);
		race3AssertUtil.assertPilot(sco206, 4, 0, false, 10, 11);
		race3AssertUtil.assertPilot(sco154, 4, 0, false, 11, 12);
		race3AssertUtil.assertPilot(sco095, 2, 0, false, 12, 13);
		race3AssertUtil.assertPilot(sco019, 1, 0, false, 13, 14);
		race3AssertUtil.assertPilot(sco197, 1, 0, false, 14, 15);
		race3AssertUtil.assertPilot(sco033, 0, 0, false, 21, 16);
		race3AssertUtil.assertPilot(sco050, 0, 0, false, 21, 16);
		race3AssertUtil.assertPilot(sco109, 0, 0, false, 21, 16);
		race3AssertUtil.assertPilot(sco117, 0, 0, false, 21, 16);
		race3AssertUtil.assertPilot(sco179, 0, 0, false, 21, 16);
		race3AssertUtil.assertPilot(sco181, 0, 0, false, 21, 16);
		race3AssertUtil.assertPilot(sco205, 0, 0, false, 21, 16);
		race3AssertUtil.assertPilot(sco183, 0, 0, true, 22, 23);
		race3AssertUtil.assertDone(2);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 2, 1);
		overallAssertUtil.assertPilot(sco159, 0, 11, 2);
		overallAssertUtil.assertPilot(sco071, 0, 14, 3);
		overallAssertUtil.assertPilot(sco200, 0, 18, 4);
		overallAssertUtil.assertPilot(sco135, 0, 20, 5);
		overallAssertUtil.assertPilot(sco060, 0, 26, 6);
		overallAssertUtil.assertPilot(sco081, 0, 28, 7);
		overallAssertUtil.assertPilot(sco095, 0, 29, 8);
		overallAssertUtil.assertPilot(sco117, 0, 31, 9);
		overallAssertUtil.assertPilot(sco136, 0, 32, 10);
		overallAssertUtil.assertPilot(sco158, 0, 35, 11);
		overallAssertUtil.assertPilot(sco050, 0, 35, 12);
		overallAssertUtil.assertPilot(sco179, 0, 35, 12);
		overallAssertUtil.assertPilot(sco154, 0, 38, 14);
		overallAssertUtil.assertPilot(sco100, 0, 39, 15);
		overallAssertUtil.assertPilot(sco019, 0, 39, 16);
		overallAssertUtil.assertPilot(sco181, 0, 45, 17);
		overallAssertUtil.assertPilot(sco206, 0, 48, 18);
		overallAssertUtil.assertPilot(sco109, 0, 50, 19);
		overallAssertUtil.assertPilot(sco033, 0, 52, 20);
		overallAssertUtil.assertPilot(sco197, 0, 57, 21);
		overallAssertUtil.assertPilot(sco205, 0, 61, 22);
		overallAssertUtil.assertPilot(sco183, 0, 65, 23);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent2() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race3 = raceDAO.find(event2, RACE3_NAME);

			Scores scores = scorer.scoreEvent(event2, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE3_FLEET, scores.getFleetSize(race3));

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
			race3AssertUtil.assertPilot(sco154, 4, 0, false, 11, 11);
			race3AssertUtil.assertPilot(sco095, 2, 0, false, 12, 12);
			race3AssertUtil.assertPilot(sco019, 1, 0, false, 13, 13);
			race3AssertUtil.assertPilot(sco197, 1, 0, false, 14, 14);
			race3AssertUtil.assertPilot(sco060, 0, 0, true, 21, 15);
			race3AssertUtil.assertPilot(sco109, 0, 0, false, 21, 15);
			race3AssertUtil.assertPilot(sco117, 0, 0, false, 21, 15);
			race3AssertUtil.assertPilot(sco179, 0, 0, false, 21, 15);
			race3AssertUtil.assertPilot(sco183, 0, 0, true, 21, 15);
			race3AssertUtil.assertPilot(sco205, 0, 0, false, 21, 15);
			race3AssertUtil.assertDone(2);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco081, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(sco200, 0, 3, 3);
			overallAssertUtil.assertPilot(sco071, 0, 4, 4);
			overallAssertUtil.assertPilot(sco158, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(sco100, 0, 7, 7);
			overallAssertUtil.assertPilot(sco136, 0, 8, 8);
			overallAssertUtil.assertPilot(sco135, 0, 9, 9);
			overallAssertUtil.assertPilot(sco206, 0, 10, 10);
			overallAssertUtil.assertPilot(sco154, 0, 11, 11);
			overallAssertUtil.assertPilot(sco095, 0, 12, 12);
			overallAssertUtil.assertPilot(sco019, 0, 13, 13);
			overallAssertUtil.assertPilot(sco197, 0, 14, 14);
			overallAssertUtil.assertPilot(sco060, 0, 21, 15);
			overallAssertUtil.assertPilot(sco109, 0, 21, 15);
			overallAssertUtil.assertPilot(sco117, 0, 21, 15);
			overallAssertUtil.assertPilot(sco179, 0, 21, 15);
			overallAssertUtil.assertPilot(sco183, 0, 21, 15);
			overallAssertUtil.assertPilot(sco205, 0, 21, 15);
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
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Race race3 = raceDAO.find(event2, RACE3_NAME);

			Scores scores = scorer.scoreRace(race3, Predicates.in(getEventResultsPilots(series, event2)));
			Assert.assertEquals(EVENT2_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE3_FLEET, scores.getFleetSize(race3));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race3);
			raceAssertUtil.assertPilot(sco081, 9, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco200, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco071, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco158, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco100, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco136, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco135, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco206, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco154, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco095, 2, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco019, 1, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco197, 1, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco060, 0, 0, true, 21, 15);
			raceAssertUtil.assertPilot(sco109, 0, 0, false, 21, 15);
			raceAssertUtil.assertPilot(sco117, 0, 0, false, 21, 15);
			raceAssertUtil.assertPilot(sco179, 0, 0, false, 21, 15);
			raceAssertUtil.assertPilot(sco183, 0, 0, true, 21, 15);
			raceAssertUtil.assertPilot(sco205, 0, 0, false, 21, 15);
			raceAssertUtil.assertDone(2);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco081, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(sco200, 0, 3, 3);
			overallAssertUtil.assertPilot(sco071, 0, 4, 4);
			overallAssertUtil.assertPilot(sco158, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(sco100, 0, 7, 7);
			overallAssertUtil.assertPilot(sco136, 0, 8, 8);
			overallAssertUtil.assertPilot(sco135, 0, 9, 9);
			overallAssertUtil.assertPilot(sco206, 0, 10, 10);
			overallAssertUtil.assertPilot(sco154, 0, 11, 11);
			overallAssertUtil.assertPilot(sco095, 0, 12, 12);
			overallAssertUtil.assertPilot(sco019, 0, 13, 13);
			overallAssertUtil.assertPilot(sco197, 0, 14, 14);
			overallAssertUtil.assertPilot(sco060, 0, 21, 15);
			overallAssertUtil.assertPilot(sco109, 0, 21, 15);
			overallAssertUtil.assertPilot(sco117, 0, 21, 15);
			overallAssertUtil.assertPilot(sco179, 0, 21, 15);
			overallAssertUtil.assertPilot(sco183, 0, 21, 15);
			overallAssertUtil.assertPilot(sco205, 0, 21, 15);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}