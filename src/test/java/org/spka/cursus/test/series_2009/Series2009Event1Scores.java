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
 * Scores at the end of event 1
 */
public class Series2009Event1Scores extends AbstractSeries2009 {
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
		race2AssertUtil.assertPilot(sco197, 6, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco060, 6, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco087, 5, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco019, 0, 0, true, 8, 9);
		race2AssertUtil.assertPilot(sco042, 4, 0, false, 9, 10);
		race2AssertUtil.assertPilot(sco068, 0, 0, false, 14, 11);
		race2AssertUtil.assertPilot(sco071, 0, 0, false, 14, 11);
		race2AssertUtil.assertPilot(sco081, 0, 0, false, 14, 11);
		race2AssertUtil.assertPilot(sco158, 0, 0, false, 14, 11);
		race2AssertUtil.assertPilot(sco193, 0, 0, false, 14, 11);
		race2AssertUtil.assertDone(1);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 0, 1);
		overallAssertUtil.assertPilot(sco154, 0, 5, 2);
		overallAssertUtil.assertPilot(sco159, 1, 6, 3);
		overallAssertUtil.assertPilot(sco117, 0, 10, 4);
		overallAssertUtil.assertPilot(sco197, 0, 10, 4);
		overallAssertUtil.assertPilot(sco179, 0, 10, 6);
		overallAssertUtil.assertPilot(sco060, 0, 14, 7);
		overallAssertUtil.assertPilot(sco087, 0, 15, 8);
		overallAssertUtil.assertPilot(sco019, 0, 16, 9);
		overallAssertUtil.assertPilot(sco042, 0, 23, 10);
		overallAssertUtil.assertPilot(sco068, 0, 28, 11);
		overallAssertUtil.assertPilot(sco071, 0, 28, 11);
		overallAssertUtil.assertPilot(sco081, 0, 28, 11);
		overallAssertUtil.assertPilot(sco158, 0, 28, 11);
		overallAssertUtil.assertPilot(sco193, 0, 28, 11);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race1));
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race2));

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
			race1AssertUtil.assertPilot(k071, 0, 0, false, 15, 10);
			race1AssertUtil.assertPilot(sco042, 0, 0, false, 15, 10);
			race1AssertUtil.assertPilot(sco071, 0, 0, false, 15, 10);
			race1AssertUtil.assertPilot(sco081, 0, 0, false, 15, 10);
			race1AssertUtil.assertPilot(sco193, 0, 0, false, 15, 10);
			race1AssertUtil.assertDone(1);

			RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
			race2AssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
			race2AssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
			race2AssertUtil.assertPilot(sco154, 7, 0, false, 3, 3);
			race2AssertUtil.assertPilot(sco117, 7, 0, false, 4, 4);
			race2AssertUtil.assertPilot(sco179, 6, 0, false, 5, 5);
			race2AssertUtil.assertPilot(sco197, 6, 0, false, 6, 6);
			race2AssertUtil.assertPilot(sco060, 6, 0, false, 7, 7);
			race2AssertUtil.assertPilot(sco087, 5, 0, false, 8, 8);
			race2AssertUtil.assertPilot(sco019, 0, 0, true, 8, 9);
			race2AssertUtil.assertPilot(sco042, 4, 0, false, 9, 10);
			race2AssertUtil.assertPilot(k071, 0, 0, false, 15, 11);
			race2AssertUtil.assertPilot(sco071, 0, 0, false, 15, 11);
			race2AssertUtil.assertPilot(sco081, 0, 0, false, 15, 11);
			race2AssertUtil.assertPilot(sco193, 0, 0, false, 15, 11);
			race2AssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco154, 0, 5, 2);
			overallAssertUtil.assertPilot(sco159, 1, 6, 3);
			overallAssertUtil.assertPilot(sco117, 0, 10, 4);
			overallAssertUtil.assertPilot(sco197, 0, 10, 4);
			overallAssertUtil.assertPilot(sco179, 0, 10, 6);
			overallAssertUtil.assertPilot(sco060, 0, 14, 7);
			overallAssertUtil.assertPilot(sco087, 0, 15, 8);
			overallAssertUtil.assertPilot(sco019, 0, 16, 9);
			overallAssertUtil.assertPilot(sco042, 0, 24, 10);
			overallAssertUtil.assertPilot(k071, 0, 30, 11);
			overallAssertUtil.assertPilot(sco071, 0, 30, 11);
			overallAssertUtil.assertPilot(sco081, 0, 30, 11);
			overallAssertUtil.assertPilot(sco193, 0, 30, 11);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race1));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race1);
			raceAssertUtil.assertPilot(sco023, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco154, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 5, 1, false, 3, 3);
			raceAssertUtil.assertPilot(sco197, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco117, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco087, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco019, 2, 0, false, 8, 8);
			raceAssertUtil.assertPilot(k071, 0, 0, false, 15, 9);
			raceAssertUtil.assertPilot(sco042, 0, 0, false, 15, 9);
			raceAssertUtil.assertPilot(sco060, 0, 0, true, 15, 9);
			raceAssertUtil.assertPilot(sco071, 0, 0, false, 15, 9);
			raceAssertUtil.assertPilot(sco081, 0, 0, false, 15, 9);
			raceAssertUtil.assertPilot(sco193, 0, 0, false, 15, 9);
			raceAssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco154, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 1, 4, 3);
			overallAssertUtil.assertPilot(sco197, 0, 4, 4);
			overallAssertUtil.assertPilot(sco179, 0, 5, 5);
			overallAssertUtil.assertPilot(sco117, 0, 6, 6);
			overallAssertUtil.assertPilot(sco087, 0, 7, 7);
			overallAssertUtil.assertPilot(sco019, 0, 8, 8);
			overallAssertUtil.assertPilot(k071, 0, 15, 9);
			overallAssertUtil.assertPilot(sco042, 0, 15, 9);
			overallAssertUtil.assertPilot(sco060, 0, 15, 9);
			overallAssertUtil.assertPilot(sco071, 0, 15, 9);
			overallAssertUtil.assertPilot(sco081, 0, 15, 9);
			overallAssertUtil.assertPilot(sco193, 0, 15, 9);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getFleetSize(race2));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race2);
			raceAssertUtil.assertPilot(sco023, 9, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco159, 8, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco154, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco117, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco197, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco060, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco087, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco042, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(k071, 0, 0, false, 15, 10);
			raceAssertUtil.assertPilot(sco019, 0, 0, true, 15, 10);
			raceAssertUtil.assertPilot(sco071, 0, 0, false, 15, 10);
			raceAssertUtil.assertPilot(sco081, 0, 0, false, 15, 10);
			raceAssertUtil.assertPilot(sco193, 0, 0, false, 15, 10);
			raceAssertUtil.assertDone(1);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 2, 2);
			overallAssertUtil.assertPilot(sco154, 0, 3, 3);
			overallAssertUtil.assertPilot(sco117, 0, 4, 4);
			overallAssertUtil.assertPilot(sco179, 0, 5, 5);
			overallAssertUtil.assertPilot(sco197, 0, 6, 6);
			overallAssertUtil.assertPilot(sco060, 0, 7, 7);
			overallAssertUtil.assertPilot(sco087, 0, 8, 8);
			overallAssertUtil.assertPilot(sco042, 0, 9, 9);
			overallAssertUtil.assertPilot(k071, 0, 15, 10);
			overallAssertUtil.assertPilot(sco019, 0, 15, 10);
			overallAssertUtil.assertPilot(sco071, 0, 15, 10);
			overallAssertUtil.assertPilot(sco081, 0, 15, 10);
			overallAssertUtil.assertPilot(sco193, 0, 15, 10);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}