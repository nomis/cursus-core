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
package org.spka.cursus.test.cc_2008;

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
public class Series2008Top4Event1Scores extends CCSeries2008 {
	public Series2008Top4Event1Scores() {
		super(true);
	}

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
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, event1), Predicates.in(getSeriesResultsPilots(series, event1)));
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

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, event1), getSeriesResultsEvents(series, event1),
					Predicates.in(getSeriesResultsPilots(series, event1)));
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
		Race race3 = raceDAO.find(event1, RACE3_NAME);
		Race race4 = raceDAO.find(event1, RACE4_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT1, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1, true);
		race1AssertUtil.assertPilot(ir027, 6, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco200, 6, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco019, 6, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco159, 5, 0, false, 4, 4);
		race1AssertUtil.assertPilot(ir073, 4, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco081, 4, 0, false, 6, 6);
		race1AssertUtil.assertPilot(ir052, 3, 0, false, 7, 7);
		race1AssertUtil.assertPilot(ir085, 1, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco179, 4, 0, true, 0, 9);
		race1AssertUtil.assertPilot(sco154, 3, 0, true, 0, 10);
		race1AssertUtil.assertPilot(sco071, 3, 0, true, 0, 11);
		race1AssertUtil.assertPilot(sco023, 0, 0, true, 0, 12);
		race1AssertUtil.assertPilot(sco033, 0, 0, true, 0, 12);
		race1AssertUtil.assertPilot(sco060, 0, 0, true, 0, 12);
		race1AssertUtil.assertPilot(sco135, 0, 0, true, 0, 12);
		race1AssertUtil.assertPilot(sco136, 0, 0, true, 0, 12);
		race1AssertUtil.assertPilot(sco158, 0, 0, true, 0, 12);
		race1AssertUtil.assertPilot(sco197, 0, 0, true, 0, 12);
		race1AssertUtil.assertDone(10);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2, true);
		race2AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco135, 8, 0, false, 2, 2);
		race2AssertUtil.assertPilot(ir027, 8, 0, false, 3, 3);
		race2AssertUtil.assertPilot(ir085, 8, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco136, 7, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco179, 7, 0, false, 6, 6);
		race2AssertUtil.assertPilot(ir052, 6, 0, false, 7, 7);
		race2AssertUtil.assertPilot(ir073, 2, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco081, 6, 0, true, 0, 9);
		race2AssertUtil.assertPilot(sco060, 6, 0, true, 0, 10);
		race2AssertUtil.assertPilot(sco197, 6, 0, true, 0, 11);
		race2AssertUtil.assertPilot(sco033, 2, 0, true, 0, 12);
		race2AssertUtil.assertPilot(sco019, 0, 0, true, 0, 13);
		race2AssertUtil.assertPilot(sco023, 0, 0, true, 0, 13);
		race2AssertUtil.assertPilot(sco071, 0, 0, true, 0, 13);
		race2AssertUtil.assertPilot(sco154, 0, 0, true, 0, 13);
		race2AssertUtil.assertPilot(sco158, 0, 0, true, 0, 13);
		race2AssertUtil.assertPilot(sco159, 0, 0, true, 0, 13);
		race2AssertUtil.assertDone(10);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3, true);
		race3AssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco200, 9, 0, false, 2, 2);
		race3AssertUtil.assertPilot(ir027, 9, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco019, 9, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco154, 9, 0, false, 5, 5);
		race3AssertUtil.assertPilot(ir073, 8, 0, false, 6, 6);
		race3AssertUtil.assertPilot(ir085, 8, 0, false, 7, 7);
		race3AssertUtil.assertPilot(ir052, 6, 0, false, 8, 8);
		race3AssertUtil.assertPilot(sco159, 6, 0, true, 0, 9);
		race3AssertUtil.assertPilot(sco158, 5, 0, true, 0, 10);
		race3AssertUtil.assertPilot(sco033, 0, 0, true, 0, 11);
		race3AssertUtil.assertPilot(sco060, 0, 0, true, 0, 11);
		race3AssertUtil.assertPilot(sco071, 0, 0, true, 0, 11);
		race3AssertUtil.assertPilot(sco081, 0, 0, true, 0, 11);
		race3AssertUtil.assertPilot(sco135, 0, 0, true, 0, 11);
		race3AssertUtil.assertPilot(sco136, 0, 0, true, 0, 11);
		race3AssertUtil.assertPilot(sco179, 0, 0, true, 0, 11);
		race3AssertUtil.assertPilot(sco197, 0, 0, true, 0, 11);
		race3AssertUtil.assertDone(10);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4, true);
		race4AssertUtil.assertPilot(sco023, 10, 0, false, 0, 1);
		race4AssertUtil.assertPilot(ir027, 10, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco135, 10, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco154, 10, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco019, 9, 0, false, 5, 5);
		race4AssertUtil.assertPilot(ir073, 8, 0, false, 6, 6);
		race4AssertUtil.assertPilot(ir085, 3, 0, false, 7, 7);
		race4AssertUtil.assertPilot(ir052, 3, 0, false, 8, 8);
		race4AssertUtil.assertPilot(sco136, 8, 0, true, 0, 9);
		race4AssertUtil.assertPilot(sco081, 6, 0, true, 0, 10);
		race4AssertUtil.assertPilot(sco159, 4, 0, true, 0, 11);
		race4AssertUtil.assertPilot(sco158, 3, 0, true, 0, 12);
		race4AssertUtil.assertPilot(sco033, 0, 0, true, 0, 13);
		race4AssertUtil.assertPilot(sco060, 0, 0, true, 0, 13);
		race4AssertUtil.assertPilot(sco071, 0, 0, true, 0, 13);
		race4AssertUtil.assertPilot(sco179, 0, 0, true, 0, 13);
		race4AssertUtil.assertPilot(sco197, 0, 0, true, 0, 13);
		race4AssertUtil.assertPilot(sco200, 0, 0, true, 0, 13);
		race4AssertUtil.assertDone(10);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 0, 1);
		overallAssertUtil.assertPilot(sco200, 0, 4, 2);
		overallAssertUtil.assertPilot(ir027, 0, 8, 3);
		overallAssertUtil.assertPilot(sco135, 0, 5, 4);
		overallAssertUtil.assertPilot(sco159, 0, 4, 5);
		overallAssertUtil.assertPilot(sco019, 0, 12, 6);
		overallAssertUtil.assertPilot(sco154, 0, 9, 7);
		overallAssertUtil.assertPilot(sco136, 0, 5, 8);
		overallAssertUtil.assertPilot(sco081, 0, 6, 9);
		overallAssertUtil.assertPilot(sco179, 0, 6, 9);
		overallAssertUtil.assertPilot(ir073, 0, 25, 11);
		overallAssertUtil.assertPilot(ir085, 0, 26, 12);
		overallAssertUtil.assertPilot(ir052, 0, 30, 13);
		overallAssertUtil.assertPilot(sco033, 0, 0, 14);
		overallAssertUtil.assertPilot(sco060, 0, 0, 14);
		overallAssertUtil.assertPilot(sco071, 0, 0, 14);
		overallAssertUtil.assertPilot(sco158, 0, 0, 14);
		overallAssertUtil.assertPilot(sco197, 0, 0, 14);
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
			Race race3 = raceDAO.find(event1, RACE3_NAME);
			Race race4 = raceDAO.find(event1, RACE4_NAME);

			Scores scores = scorer.scoreEvent(event1, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1, true);
			race1AssertUtil.assertPilot(ir027, 6, 0, false, 0, 1);
			race1AssertUtil.assertPilot(sco200, 6, 0, false, 2, 2);
			race1AssertUtil.assertPilot(sco019, 6, 0, false, 3, 3);
			race1AssertUtil.assertPilot(sco159, 5, 0, false, 4, 4);
			race1AssertUtil.assertPilot(ir073, 4, 0, false, 5, 5);
			race1AssertUtil.assertPilot(sco081, 4, 0, false, 6, 6);
			race1AssertUtil.assertPilot(ir052, 3, 0, false, 7, 7);
			race1AssertUtil.assertPilot(ir085, 1, 0, false, 8, 8);
			race1AssertUtil.assertPilot(sco179, 4, 0, true, 0, 9);
			race1AssertUtil.assertPilot(sco154, 3, 0, true, 0, 10);
			race1AssertUtil.assertPilot(sco071, 3, 0, true, 0, 11);
			race1AssertUtil.assertPilot(sco023, 0, 0, true, 0, 12);
			race1AssertUtil.assertPilot(sco033, 0, 0, true, 0, 12);
			race1AssertUtil.assertPilot(sco060, 0, 0, true, 0, 12);
			race1AssertUtil.assertPilot(sco135, 0, 0, true, 0, 12);
			race1AssertUtil.assertPilot(sco136, 0, 0, true, 0, 12);
			race1AssertUtil.assertPilot(sco158, 0, 0, true, 0, 12);
			race1AssertUtil.assertPilot(sco197, 0, 0, true, 0, 12);
			race1AssertUtil.assertDone(10);

			RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2, true);
			race2AssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			race2AssertUtil.assertPilot(sco135, 8, 0, false, 2, 2);
			race2AssertUtil.assertPilot(ir027, 8, 0, false, 3, 3);
			race2AssertUtil.assertPilot(ir085, 8, 0, false, 4, 4);
			race2AssertUtil.assertPilot(sco136, 7, 0, false, 5, 5);
			race2AssertUtil.assertPilot(sco179, 7, 0, false, 6, 6);
			race2AssertUtil.assertPilot(ir052, 6, 0, false, 7, 7);
			race2AssertUtil.assertPilot(ir073, 2, 0, false, 8, 8);
			race2AssertUtil.assertPilot(sco081, 6, 0, true, 0, 9);
			race2AssertUtil.assertPilot(sco060, 6, 0, true, 0, 10);
			race2AssertUtil.assertPilot(sco197, 6, 0, true, 0, 11);
			race2AssertUtil.assertPilot(sco033, 2, 0, true, 0, 12);
			race2AssertUtil.assertPilot(sco019, 0, 0, true, 0, 13);
			race2AssertUtil.assertPilot(sco023, 0, 0, true, 0, 13);
			race2AssertUtil.assertPilot(sco071, 0, 0, true, 0, 13);
			race2AssertUtil.assertPilot(sco154, 0, 0, true, 0, 13);
			race2AssertUtil.assertPilot(sco158, 0, 0, true, 0, 13);
			race2AssertUtil.assertPilot(sco159, 0, 0, true, 0, 13);
			race2AssertUtil.assertDone(10);

			RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3, true);
			race3AssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
			race3AssertUtil.assertPilot(sco200, 9, 0, false, 2, 2);
			race3AssertUtil.assertPilot(ir027, 9, 0, false, 3, 3);
			race3AssertUtil.assertPilot(sco019, 9, 0, false, 4, 4);
			race3AssertUtil.assertPilot(sco154, 9, 0, false, 5, 5);
			race3AssertUtil.assertPilot(ir073, 8, 0, false, 6, 6);
			race3AssertUtil.assertPilot(ir085, 8, 0, false, 7, 7);
			race3AssertUtil.assertPilot(ir052, 6, 0, false, 8, 8);
			race3AssertUtil.assertPilot(sco159, 6, 0, true, 0, 9);
			race3AssertUtil.assertPilot(sco158, 5, 0, true, 0, 10);
			race3AssertUtil.assertPilot(sco033, 0, 0, true, 0, 11);
			race3AssertUtil.assertPilot(sco060, 0, 0, true, 0, 11);
			race3AssertUtil.assertPilot(sco071, 0, 0, true, 0, 11);
			race3AssertUtil.assertPilot(sco081, 0, 0, true, 0, 11);
			race3AssertUtil.assertPilot(sco135, 0, 0, true, 0, 11);
			race3AssertUtil.assertPilot(sco136, 0, 0, true, 0, 11);
			race3AssertUtil.assertPilot(sco179, 0, 0, true, 0, 11);
			race3AssertUtil.assertPilot(sco197, 0, 0, true, 0, 11);
			race3AssertUtil.assertDone(10);

			RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4, true);
			race4AssertUtil.assertPilot(sco023, 10, 0, false, 0, 1);
			race4AssertUtil.assertPilot(ir027, 10, 0, false, 2, 2);
			race4AssertUtil.assertPilot(sco135, 10, 0, false, 3, 3);
			race4AssertUtil.assertPilot(sco154, 10, 0, false, 4, 4);
			race4AssertUtil.assertPilot(sco019, 9, 0, false, 5, 5);
			race4AssertUtil.assertPilot(ir073, 8, 0, false, 6, 6);
			race4AssertUtil.assertPilot(ir085, 3, 0, false, 7, 7);
			race4AssertUtil.assertPilot(ir052, 3, 0, false, 8, 8);
			race4AssertUtil.assertPilot(sco136, 8, 0, true, 0, 9);
			race4AssertUtil.assertPilot(sco081, 6, 0, true, 0, 10);
			race4AssertUtil.assertPilot(sco159, 4, 0, true, 0, 11);
			race4AssertUtil.assertPilot(sco158, 3, 0, true, 0, 12);
			race4AssertUtil.assertPilot(sco033, 0, 0, true, 0, 13);
			race4AssertUtil.assertPilot(sco060, 0, 0, true, 0, 13);
			race4AssertUtil.assertPilot(sco071, 0, 0, true, 0, 13);
			race4AssertUtil.assertPilot(sco179, 0, 0, true, 0, 13);
			race4AssertUtil.assertPilot(sco197, 0, 0, true, 0, 13);
			race4AssertUtil.assertPilot(sco200, 0, 0, true, 0, 13);
			race4AssertUtil.assertDone(10);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco200, 0, 4, 2);
			overallAssertUtil.assertPilot(ir027, 0, 8, 3);
			overallAssertUtil.assertPilot(sco135, 0, 5, 4);
			overallAssertUtil.assertPilot(sco159, 0, 4, 5);
			overallAssertUtil.assertPilot(sco019, 0, 12, 6);
			overallAssertUtil.assertPilot(sco154, 0, 9, 7);
			overallAssertUtil.assertPilot(sco136, 0, 5, 8);
			overallAssertUtil.assertPilot(sco081, 0, 6, 9);
			overallAssertUtil.assertPilot(sco179, 0, 6, 9);
			overallAssertUtil.assertPilot(ir073, 0, 25, 11);
			overallAssertUtil.assertPilot(ir085, 0, 26, 12);
			overallAssertUtil.assertPilot(ir052, 0, 30, 13);
			overallAssertUtil.assertPilot(sco033, 0, 0, 14);
			overallAssertUtil.assertPilot(sco060, 0, 0, 14);
			overallAssertUtil.assertPilot(sco071, 0, 0, 14);
			overallAssertUtil.assertPilot(sco158, 0, 0, 14);
			overallAssertUtil.assertPilot(sco197, 0, 0, 14);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race1, true);
			raceAssertUtil.assertPilot(ir027, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco200, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco019, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir073, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco081, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir052, 3, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir085, 1, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco179, 4, 0, true, 0, 9);
			raceAssertUtil.assertPilot(sco154, 3, 0, true, 0, 10);
			raceAssertUtil.assertPilot(sco071, 3, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco023, 0, 0, true, 0, 12);
			raceAssertUtil.assertPilot(sco060, 0, 0, true, 0, 12);
			raceAssertUtil.assertPilot(sco135, 0, 0, true, 0, 12);
			raceAssertUtil.assertPilot(sco136, 0, 0, true, 0, 12);
			raceAssertUtil.assertPilot(sco197, 0, 0, true, 0, 12);
			raceAssertUtil.assertDone(8);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir027, 0, 0, 1);
			overallAssertUtil.assertPilot(sco200, 0, 2, 2);
			overallAssertUtil.assertPilot(sco019, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(ir073, 0, 5, 5);
			overallAssertUtil.assertPilot(sco081, 0, 6, 6);
			overallAssertUtil.assertPilot(ir052, 0, 7, 7);
			overallAssertUtil.assertPilot(ir085, 0, 8, 8);
			overallAssertUtil.assertPilot(sco023, 0, 0, 9);
			overallAssertUtil.assertPilot(sco060, 0, 0, 9);
			overallAssertUtil.assertPilot(sco071, 0, 0, 9);
			overallAssertUtil.assertPilot(sco135, 0, 0, 9);
			overallAssertUtil.assertPilot(sco136, 0, 0, 9);
			overallAssertUtil.assertPilot(sco154, 0, 0, 9);
			overallAssertUtil.assertPilot(sco179, 0, 0, 9);
			overallAssertUtil.assertPilot(sco197, 0, 0, 9);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race2, true);
			raceAssertUtil.assertPilot(sco200, 8, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco135, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir027, 8, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir085, 8, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco136, 7, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco179, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir052, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir073, 2, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco081, 6, 0, true, 0, 9);
			raceAssertUtil.assertPilot(sco060, 6, 0, true, 0, 10);
			raceAssertUtil.assertPilot(sco197, 6, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco033, 2, 0, true, 0, 12);
			raceAssertUtil.assertPilot(sco019, 0, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco023, 0, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco154, 0, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco158, 0, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco159, 0, 0, true, 0, 13);
			raceAssertUtil.assertDone(9);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco200, 0, 0, 1);
			overallAssertUtil.assertPilot(sco135, 0, 2, 2);
			overallAssertUtil.assertPilot(ir027, 0, 3, 3);
			overallAssertUtil.assertPilot(ir085, 0, 4, 4);
			overallAssertUtil.assertPilot(sco136, 0, 5, 5);
			overallAssertUtil.assertPilot(sco179, 0, 6, 6);
			overallAssertUtil.assertPilot(ir052, 0, 7, 7);
			overallAssertUtil.assertPilot(ir073, 0, 8, 8);
			overallAssertUtil.assertPilot(sco019, 0, 0, 9);
			overallAssertUtil.assertPilot(sco023, 0, 0, 9);
			overallAssertUtil.assertPilot(sco033, 0, 0, 9);
			overallAssertUtil.assertPilot(sco060, 0, 0, 9);
			overallAssertUtil.assertPilot(sco081, 0, 0, 9);
			overallAssertUtil.assertPilot(sco154, 0, 0, 9);
			overallAssertUtil.assertPilot(sco158, 0, 0, 9);
			overallAssertUtil.assertPilot(sco159, 0, 0, 9);
			overallAssertUtil.assertPilot(sco197, 0, 0, 9);
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
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Race race3 = raceDAO.find(event1, RACE3_NAME);

			Scores scores = scorer.scoreRace(race3, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race3, true);
			raceAssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco200, 9, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir027, 9, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco019, 9, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco154, 9, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir073, 8, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir085, 8, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir052, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco159, 6, 0, true, 0, 9);
			raceAssertUtil.assertPilot(sco158, 5, 0, true, 0, 10);
			raceAssertUtil.assertPilot(sco033, 0, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco060, 0, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco081, 0, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco135, 0, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco136, 0, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco179, 0, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco197, 0, 0, true, 0, 11);
			raceAssertUtil.assertDone(9);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco200, 0, 2, 2);
			overallAssertUtil.assertPilot(ir027, 0, 3, 3);
			overallAssertUtil.assertPilot(sco019, 0, 4, 4);
			overallAssertUtil.assertPilot(sco154, 0, 5, 5);
			overallAssertUtil.assertPilot(ir073, 0, 6, 6);
			overallAssertUtil.assertPilot(ir085, 0, 7, 7);
			overallAssertUtil.assertPilot(ir052, 0, 8, 8);
			overallAssertUtil.assertPilot(sco033, 0, 0, 9);
			overallAssertUtil.assertPilot(sco060, 0, 0, 9);
			overallAssertUtil.assertPilot(sco081, 0, 0, 9);
			overallAssertUtil.assertPilot(sco135, 0, 0, 9);
			overallAssertUtil.assertPilot(sco136, 0, 0, 9);
			overallAssertUtil.assertPilot(sco158, 0, 0, 9);
			overallAssertUtil.assertPilot(sco159, 0, 0, 9);
			overallAssertUtil.assertPilot(sco179, 0, 0, 9);
			overallAssertUtil.assertPilot(sco197, 0, 0, 9);
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
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Race race4 = raceDAO.find(event1, RACE4_NAME);

			Scores scores = scorer.scoreRace(race4, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race4, true);
			raceAssertUtil.assertPilot(sco023, 10, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir027, 10, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco135, 10, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco154, 10, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco019, 9, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir073, 8, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir085, 3, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir052, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco136, 8, 0, true, 0, 9);
			raceAssertUtil.assertPilot(sco081, 6, 0, true, 0, 10);
			raceAssertUtil.assertPilot(sco159, 4, 0, true, 0, 11);
			raceAssertUtil.assertPilot(sco158, 3, 0, true, 0, 12);
			raceAssertUtil.assertPilot(sco033, 0, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco060, 0, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco179, 0, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco197, 0, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco200, 0, 0, true, 0, 13);
			raceAssertUtil.assertDone(9);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(ir027, 0, 2, 2);
			overallAssertUtil.assertPilot(sco135, 0, 3, 3);
			overallAssertUtil.assertPilot(sco154, 0, 4, 4);
			overallAssertUtil.assertPilot(sco019, 0, 5, 5);
			overallAssertUtil.assertPilot(ir073, 0, 6, 6);
			overallAssertUtil.assertPilot(ir085, 0, 7, 7);
			overallAssertUtil.assertPilot(ir052, 0, 8, 8);
			overallAssertUtil.assertPilot(sco033, 0, 0, 9);
			overallAssertUtil.assertPilot(sco060, 0, 0, 9);
			overallAssertUtil.assertPilot(sco081, 0, 0, 9);
			overallAssertUtil.assertPilot(sco136, 0, 0, 9);
			overallAssertUtil.assertPilot(sco158, 0, 0, 9);
			overallAssertUtil.assertPilot(sco159, 0, 0, 9);
			overallAssertUtil.assertPilot(sco179, 0, 0, 9);
			overallAssertUtil.assertPilot(sco197, 0, 0, 9);
			overallAssertUtil.assertPilot(sco200, 0, 0, 9);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}