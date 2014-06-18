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
 * Scores at the end of event 1
 */
public class Series2006Event1Scores extends AbstractSeries2006 {
	@Override
	@Before
	public void createDatabase() throws Exception {
		super.createDatabase();
		createEvent1Races();
	}

	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Scores scores = scorer.scoreSeries(series, Predicates.in(getSeriesResultsPilots(series)));
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

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series), Predicates.in(getSeriesResultsPilots(series)));
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

		Assert.assertEquals(SERIES_FLEET, scores.getPilots().size());

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
		race1AssertUtil.assertPilot(sco033, 6, 0, false, 14, 14);
		race1AssertUtil.assertPilot(sco158, 4, 0, false, 15, 15);
		race1AssertUtil.assertPilot(sco206, 4, 0, false, 16, 16);
		race1AssertUtil.assertPilot(sco154, 3, 0, false, 17, 17);
		race1AssertUtil.assertPilot(sco205, 1, 0, false, 18, 18);
		race1AssertUtil.assertPilot(sco081, 1, 0, false, 19, 19);
		race1AssertUtil.assertPilot(sco019, 0, 0, true, 21, 20);
		race1AssertUtil.assertPilot(sco100, 0, 0, false, 21, 20);
		race1AssertUtil.assertPilot(sco143, 0, 0, false, 21, 20);
		race1AssertUtil.assertPilot(sco173, 0, 0, false, 21, 20);
		race1AssertUtil.assertPilot(sco183, 0, 0, false, 21, 20);
		race1AssertUtil.assertPilot(sco197, 0, 0, false, 21, 20);
		race1AssertUtil.assertPilot(sco198, 0, 0, false, 21, 20);
		race1AssertUtil.assertDone(1);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco023, 12, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco135, 9, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco159, 9, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco200, 9, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco117, 9, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco179, 9, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco071, 8, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco095, 0, 0, true, 7, 8);
		race2AssertUtil.assertPilot(sco050, 8, 0, false, 8, 9);
		race2AssertUtil.assertPilot(sco081, 7, 0, false, 9, 10);
		race2AssertUtil.assertPilot(sco154, 7, 0, false, 10, 11);
		race2AssertUtil.assertPilot(sco100, 7, 0, false, 11, 12);
		race2AssertUtil.assertPilot(sco181, 7, 0, false, 12, 13);
		race2AssertUtil.assertPilot(sco060, 7, 0, false, 13, 14);
		race2AssertUtil.assertPilot(sco136, 6, 0, false, 14, 15);
		race2AssertUtil.assertPilot(sco158, 6, 0, false, 15, 16);
		race2AssertUtil.assertPilot(sco109, 6, 0, false, 16, 17);
		race2AssertUtil.assertPilot(sco033, 2, 0, false, 17, 18);
		race2AssertUtil.assertPilot(sco019, 0, 0, true, 22, 19);
		race2AssertUtil.assertPilot(sco143, 0, 0, false, 22, 19);
		race2AssertUtil.assertPilot(sco173, 0, 0, false, 22, 19);
		race2AssertUtil.assertPilot(sco183, 0, 0, false, 22, 19);
		race2AssertUtil.assertPilot(sco197, 0, 0, false, 22, 19);
		race2AssertUtil.assertPilot(sco198, 0, 0, false, 22, 19);
		race2AssertUtil.assertPilot(sco205, 0, 0, false, 22, 19);
		race2AssertUtil.assertPilot(sco206, 0, 0, false, 22, 19);
		race2AssertUtil.assertDone(2);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 0, 1);
		overallAssertUtil.assertPilot(sco159, 0, 5, 2);
		overallAssertUtil.assertPilot(sco071, 0, 10, 3);
		overallAssertUtil.assertPilot(sco117, 0, 10, 4);
		overallAssertUtil.assertPilot(sco135, 0, 11, 5);
		overallAssertUtil.assertPilot(sco050, 0, 14, 6);
		overallAssertUtil.assertPilot(sco179, 0, 14, 6);
		overallAssertUtil.assertPilot(sco095, 0, 14, 8);
		overallAssertUtil.assertPilot(sco200, 0, 15, 9);
		overallAssertUtil.assertPilot(sco060, 0, 17, 10);
		overallAssertUtil.assertPilot(sco136, 0, 24, 11);
		overallAssertUtil.assertPilot(sco181, 0, 24, 12);
		overallAssertUtil.assertPilot(sco154, 0, 27, 13);
		overallAssertUtil.assertPilot(sco081, 0, 28, 14);
		overallAssertUtil.assertPilot(sco109, 0, 29, 15);
		overallAssertUtil.assertPilot(sco158, 0, 30, 16);
		overallAssertUtil.assertPilot(sco033, 0, 31, 17);
		overallAssertUtil.assertPilot(sco100, 0, 32, 18);
		overallAssertUtil.assertPilot(sco206, 0, 38, 19);
		overallAssertUtil.assertPilot(sco205, 0, 40, 20);
		overallAssertUtil.assertPilot(sco019, 0, 43, 21);
		overallAssertUtil.assertPilot(sco143, 0, 43, 21);
		overallAssertUtil.assertPilot(sco173, 0, 43, 21);
		overallAssertUtil.assertPilot(sco183, 0, 43, 21);
		overallAssertUtil.assertPilot(sco197, 0, 43, 21);
		overallAssertUtil.assertPilot(sco198, 0, 43, 21);
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

			Scores scores = scorer.scoreEvent(event1, Predicates.in(getEventResultsPilots(series, event1)));
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE1_FLEET, scores.getFleetSize(race1));
			Assert.assertEquals(RACE2_FLEET, scores.getFleetSize(race2));

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
			race1AssertUtil.assertPilot(sco033, 6, 0, false, 14, 14);
			race1AssertUtil.assertPilot(sco158, 4, 0, false, 15, 15);
			race1AssertUtil.assertPilot(sco206, 4, 0, false, 16, 16);
			race1AssertUtil.assertPilot(sco154, 3, 0, false, 17, 17);
			race1AssertUtil.assertPilot(sco205, 1, 0, false, 18, 18);
			race1AssertUtil.assertPilot(sco081, 1, 0, false, 19, 19);
			race1AssertUtil.assertPilot(sco019, 0, 0, true, 21, 20);
			race1AssertUtil.assertPilot(sco100, 0, 0, false, 21, 20);
			race1AssertUtil.assertDone(1);

			RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
			race2AssertUtil.assertPilot(sco023, 12, 0, false, 0, 1);
			race2AssertUtil.assertPilot(sco135, 9, 0, false, 2, 2);
			race2AssertUtil.assertPilot(sco159, 9, 0, false, 3, 3);
			race2AssertUtil.assertPilot(sco200, 9, 0, false, 4, 4);
			race2AssertUtil.assertPilot(sco117, 9, 0, false, 5, 5);
			race2AssertUtil.assertPilot(sco179, 9, 0, false, 6, 6);
			race2AssertUtil.assertPilot(sco071, 8, 0, false, 7, 7);
			race2AssertUtil.assertPilot(sco095, 0, 0, true, 7, 8);
			race2AssertUtil.assertPilot(sco050, 8, 0, false, 8, 9);
			race2AssertUtil.assertPilot(sco081, 7, 0, false, 9, 10);
			race2AssertUtil.assertPilot(sco154, 7, 0, false, 10, 11);
			race2AssertUtil.assertPilot(sco100, 7, 0, false, 11, 12);
			race2AssertUtil.assertPilot(sco181, 7, 0, false, 12, 13);
			race2AssertUtil.assertPilot(sco060, 7, 0, false, 13, 14);
			race2AssertUtil.assertPilot(sco136, 6, 0, false, 14, 15);
			race2AssertUtil.assertPilot(sco158, 6, 0, false, 15, 16);
			race2AssertUtil.assertPilot(sco109, 6, 0, false, 16, 17);
			race2AssertUtil.assertPilot(sco033, 2, 0, false, 17, 18);
			race2AssertUtil.assertPilot(sco019, 0, 0, true, 22, 19);
			race2AssertUtil.assertPilot(sco205, 0, 0, false, 22, 19);
			race2AssertUtil.assertPilot(sco206, 0, 0, false, 22, 19);
			race2AssertUtil.assertDone(2);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 5, 2);
			overallAssertUtil.assertPilot(sco071, 0, 10, 3);
			overallAssertUtil.assertPilot(sco117, 0, 10, 4);
			overallAssertUtil.assertPilot(sco135, 0, 11, 5);
			overallAssertUtil.assertPilot(sco050, 0, 14, 6);
			overallAssertUtil.assertPilot(sco179, 0, 14, 6);
			overallAssertUtil.assertPilot(sco095, 0, 14, 8);
			overallAssertUtil.assertPilot(sco200, 0, 15, 9);
			overallAssertUtil.assertPilot(sco060, 0, 17, 10);
			overallAssertUtil.assertPilot(sco136, 0, 24, 11);
			overallAssertUtil.assertPilot(sco181, 0, 24, 12);
			overallAssertUtil.assertPilot(sco154, 0, 27, 13);
			overallAssertUtil.assertPilot(sco081, 0, 28, 14);
			overallAssertUtil.assertPilot(sco109, 0, 29, 15);
			overallAssertUtil.assertPilot(sco158, 0, 30, 16);
			overallAssertUtil.assertPilot(sco033, 0, 31, 17);
			overallAssertUtil.assertPilot(sco100, 0, 32, 18);
			overallAssertUtil.assertPilot(sco206, 0, 38, 19);
			overallAssertUtil.assertPilot(sco205, 0, 40, 20);
			overallAssertUtil.assertPilot(sco019, 0, 43, 21);
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
			Assert.assertEquals(RACE1_FLEET, scores.getFleetSize(race1));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race1);
			raceAssertUtil.assertPilot(sco023, 12, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco159, 9, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco071, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco060, 8, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco117, 8, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco050, 8, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco095, 8, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco179, 8, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco135, 8, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco136, 7, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco200, 6, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco181, 6, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco109, 6, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco033, 6, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco158, 4, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco206, 4, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco154, 3, 0, false, 17, 17);
			raceAssertUtil.assertPilot(sco205, 1, 0, false, 18, 18);
			raceAssertUtil.assertPilot(sco081, 1, 0, false, 19, 19);
			raceAssertUtil.assertPilot(sco019, 0, 0, true, 21, 20);
			raceAssertUtil.assertPilot(sco100, 0, 0, false, 21, 20);
			raceAssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 2, 2);
			overallAssertUtil.assertPilot(sco071, 0, 3, 3);
			overallAssertUtil.assertPilot(sco060, 0, 4, 4);
			overallAssertUtil.assertPilot(sco117, 0, 5, 5);
			overallAssertUtil.assertPilot(sco050, 0, 6, 6);
			overallAssertUtil.assertPilot(sco095, 0, 7, 7);
			overallAssertUtil.assertPilot(sco179, 0, 8, 8);
			overallAssertUtil.assertPilot(sco135, 0, 9, 9);
			overallAssertUtil.assertPilot(sco136, 0, 10, 10);
			overallAssertUtil.assertPilot(sco200, 0, 11, 11);
			overallAssertUtil.assertPilot(sco181, 0, 12, 12);
			overallAssertUtil.assertPilot(sco109, 0, 13, 13);
			overallAssertUtil.assertPilot(sco033, 0, 14, 14);
			overallAssertUtil.assertPilot(sco158, 0, 15, 15);
			overallAssertUtil.assertPilot(sco206, 0, 16, 16);
			overallAssertUtil.assertPilot(sco154, 0, 17, 17);
			overallAssertUtil.assertPilot(sco205, 0, 18, 18);
			overallAssertUtil.assertPilot(sco081, 0, 19, 19);
			overallAssertUtil.assertPilot(sco019, 0, 21, 20);
			overallAssertUtil.assertPilot(sco100, 0, 21, 20);
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
			Assert.assertEquals(RACE2_FLEET, scores.getFleetSize(race2));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race2);
			raceAssertUtil.assertPilot(sco023, 12, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco135, 9, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 9, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco200, 9, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco117, 9, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco179, 9, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco071, 8, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco050, 8, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco081, 7, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco154, 7, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco100, 7, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco181, 7, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco060, 7, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco136, 6, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco158, 6, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco109, 6, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco033, 2, 0, false, 17, 17);
			raceAssertUtil.assertPilot(sco019, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco095, 0, 0, true, 22, 18);
			raceAssertUtil.assertPilot(sco205, 0, 0, false, 22, 18);
			raceAssertUtil.assertPilot(sco206, 0, 0, false, 22, 18);
			raceAssertUtil.assertDone(2);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco135, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco200, 0, 4, 4);
			overallAssertUtil.assertPilot(sco117, 0, 5, 5);
			overallAssertUtil.assertPilot(sco179, 0, 6, 6);
			overallAssertUtil.assertPilot(sco071, 0, 7, 7);
			overallAssertUtil.assertPilot(sco050, 0, 8, 8);
			overallAssertUtil.assertPilot(sco081, 0, 9, 9);
			overallAssertUtil.assertPilot(sco154, 0, 10, 10);
			overallAssertUtil.assertPilot(sco100, 0, 11, 11);
			overallAssertUtil.assertPilot(sco181, 0, 12, 12);
			overallAssertUtil.assertPilot(sco060, 0, 13, 13);
			overallAssertUtil.assertPilot(sco136, 0, 14, 14);
			overallAssertUtil.assertPilot(sco158, 0, 15, 15);
			overallAssertUtil.assertPilot(sco109, 0, 16, 16);
			overallAssertUtil.assertPilot(sco033, 0, 17, 17);
			overallAssertUtil.assertPilot(sco019, 0, 22, 18);
			overallAssertUtil.assertPilot(sco095, 0, 22, 18);
			overallAssertUtil.assertPilot(sco205, 0, 22, 18);
			overallAssertUtil.assertPilot(sco206, 0, 22, 18);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}