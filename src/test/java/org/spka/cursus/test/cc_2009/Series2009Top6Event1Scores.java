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
package org.spka.cursus.test.cc_2009;

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
 * Scores at the end of event 1
 */
public class Series2009Top6Event1Scores extends CCSeries2009 {
	public Series2009Top6Event1Scores() {
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
		Race race5 = raceDAO.find(event1, RACE5_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT1, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1, true);
		race1AssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
		race1AssertUtil.assertPilot(ir022, 5, 0, false, 2, 2);
		race1AssertUtil.assertPilot(ir043, 4, 0, false, 3, 3);
		race1AssertUtil.assertPilot(ir014, 4, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco179, 4, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco159, 4, 0, false, 6, 6);
		race1AssertUtil.assertPilot(ir027, 4, 0, false, 7, 7);
		race1AssertUtil.assertPilot(ir085, 4, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco019, 4, 0, false, 9, 9);
		race1AssertUtil.assertPilot(ir073, 4, 0, false, 10, 10);
		race1AssertUtil.assertPilot(sco197, 3, 0, false, 11, 11);
		race1AssertUtil.assertPilot(sco154, 1, 0, false, 12, 12);
		race1AssertUtil.assertPilot(ir077, 3, 0, true, 0, 13);
		race1AssertUtil.assertPilot(ir025, 2, 0, true, 0, 14);
		race1AssertUtil.assertPilot(sco081, 1, 0, true, 0, 15);
		race1AssertUtil.assertPilot(ir028, 0, 0, true, 0, 16);
		race1AssertUtil.assertPilot(sco060, 0, 0, true, 0, 16);
		race1AssertUtil.assertDone(5);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2, true);
		race2AssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
		race2AssertUtil.assertPilot(ir027, 5, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco019, 4, 0, false, 4, 3);
		race2AssertUtil.assertPilot(ir043, 5, 3, false, 3, 4);
		race2AssertUtil.assertPilot(sco159, 4, 1, false, 5, 5);
		race2AssertUtil.assertPilot(sco179, 4, 0, false, 6, 6);
		race2AssertUtil.assertPilot(ir014, 4, 0, false, 7, 7);
		race2AssertUtil.assertPilot(sco154, 4, 0, false, 8, 8);
		race2AssertUtil.assertPilot(sco060, 4, 0, false, 9, 9);
		race2AssertUtil.assertPilot(ir022, 3, 0, false, 10, 10);
		race2AssertUtil.assertPilot(ir025, 3, 0, false, 11, 11);
		race2AssertUtil.assertPilot(ir085, 2, 0, false, 12, 12);
		race2AssertUtil.assertPilot(sco197, 3, 0, true, 0, 13);
		race2AssertUtil.assertPilot(ir073, 2, 0, true, 0, 14);
		race2AssertUtil.assertPilot(ir028, 0, 0, true, 0, 15);
		race2AssertUtil.assertPilot(ir077, 0, 0, true, 0, 15);
		race2AssertUtil.assertPilot(sco081, 0, 0, true, 0, 15);
		race2AssertUtil.assertDone(5);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3, true);
		race3AssertUtil.assertPilot(ir027, 5, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco023, 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(ir014, 4, 0, false, 3, 3);
		race3AssertUtil.assertPilot(ir022, 4, 0, false, 4, 4);
		race3AssertUtil.assertPilot(ir073, 4, 0, false, 5, 5);
		race3AssertUtil.assertPilot(ir043, 4, 0, false, 6, 6);
		race3AssertUtil.assertPilot(sco019, 4, 0, false, 7, 7);
		race3AssertUtil.assertPilot(sco179, 4, 0, false, 8, 8);
		race3AssertUtil.assertPilot(ir085, 4, 0, false, 9, 9);
		race3AssertUtil.assertPilot(sco197, 3, 0, false, 10, 10);
		race3AssertUtil.assertPilot(sco154, 3, 0, false, 11, 11);
		race3AssertUtil.assertPilot(sco159, 3, 0, false, 12, 12);
		race3AssertUtil.assertPilot(ir025, 4, 0, true, 0, 13);
		race3AssertUtil.assertPilot(ir028, 0, 0, true, 0, 14);
		race3AssertUtil.assertPilot(ir077, 0, 0, true, 0, 14);
		race3AssertUtil.assertPilot(sco060, 0, 0, true, 0, 14);
		race3AssertUtil.assertPilot(sco081, 0, 0, true, 0, 14);
		race3AssertUtil.assertDone(5);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4, true);
		race4AssertUtil.assertPilot(ir027, 7, 0, false, 0, 1);
		race4AssertUtil.assertPilot(ir043, 6, 0, false, 2, 2);
		race4AssertUtil.assertPilot(ir022, 6, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco023, 6, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco154, 5, 0, false, 5, 5);
		race4AssertUtil.assertPilot(ir073, 5, 0, false, 6, 6);
		race4AssertUtil.assertPilot(ir025, 5, 0, false, 7, 7);
		race4AssertUtil.assertPilot(ir014, 5, 0, false, 8, 8);
		race4AssertUtil.assertPilot(sco019, 5, 0, false, 9, 9);
		race4AssertUtil.assertPilot(sco081, 4, 0, false, 10, 10);
		race4AssertUtil.assertPilot(sco159, 4, 0, false, 11, 11);
		race4AssertUtil.assertPilot(sco060, 3, 0, false, 12, 12);
		race4AssertUtil.assertPilot(ir085, 4, 0, true, 0, 13);
		race4AssertUtil.assertPilot(sco179, 1, 0, true, 0, 14);
		race4AssertUtil.assertPilot(ir028, 0, 0, true, 0, 15);
		race4AssertUtil.assertPilot(ir077, 0, 0, true, 0, 15);
		race4AssertUtil.assertPilot(sco197, 0, 0, true, 0, 15);
		race4AssertUtil.assertDone(5);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5, true);
		race5AssertUtil.assertPilot(ir027, 7, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco023, 7, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco154, 7, 1, false, 3, 3);
		race5AssertUtil.assertPilot(ir043, 7, 0, false, 4, 4);
		race5AssertUtil.assertPilot(ir022, 6, 0, false, 5, 5);
		race5AssertUtil.assertPilot(ir025, 6, 0, false, 6, 6);
		race5AssertUtil.assertPilot(ir073, 6, 0, false, 7, 7);
		race5AssertUtil.assertPilot(sco159, 6, 1, false, 8, 8);
		race5AssertUtil.assertPilot(sco179, 6, 1, false, 9, 9);
		race5AssertUtil.assertPilot(sco060, 5, 0, false, 10, 10);
		race5AssertUtil.assertPilot(ir077, 2, 0, false, 11, 11);
		race5AssertUtil.assertPilot(sco081, 1, 0, false, 12, 12);
		race5AssertUtil.assertPilot(ir085, 2, 0, true, 0, 13);
		race5AssertUtil.assertPilot(ir014, 1, 0, true, 0, 14);
		race5AssertUtil.assertPilot(sco019, 1, 0, true, 0, 15);
		race5AssertUtil.assertPilot(ir028, 0, 0, true, 0, 16);
		race5AssertUtil.assertPilot(sco197, 0, 0, true, 0, 16);
		race5AssertUtil.assertDone(5);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco023, 0, 8, 1);
		overallAssertUtil.assertPilot(ir027, 0, 9, 2);
		overallAssertUtil.assertPilot(ir043, 3, 21, 3);
		overallAssertUtil.assertPilot(ir022, 0, 24, 4);
		overallAssertUtil.assertPilot(ir014, 0, 22, 5);
		overallAssertUtil.assertPilot(ir073, 0, 28, 6);
		overallAssertUtil.assertPilot(sco019, 0, 29, 7);
		overallAssertUtil.assertPilot(sco179, 1, 29, 8);
		overallAssertUtil.assertPilot(ir025, 0, 24, 9);
		overallAssertUtil.assertPilot(sco154, 1, 40, 10);
		overallAssertUtil.assertPilot(sco159, 2, 44, 11);
		overallAssertUtil.assertPilot(ir085, 0, 29, 12);
		overallAssertUtil.assertPilot(sco060, 0, 31, 13);
		overallAssertUtil.assertPilot(sco197, 0, 21, 14);
		overallAssertUtil.assertPilot(ir077, 0, 11, 15);
		overallAssertUtil.assertPilot(sco081, 0, 22, 16);
		overallAssertUtil.assertPilot(ir028, 0, 0, 17);
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
			Race race5 = raceDAO.find(event1, RACE5_NAME);

			Scores scores = scorer.scoreEvent(event1, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1, true);
			race1AssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
			race1AssertUtil.assertPilot(ir022, 5, 0, false, 2, 2);
			race1AssertUtil.assertPilot(ir043, 4, 0, false, 3, 3);
			race1AssertUtil.assertPilot(ir014, 4, 0, false, 4, 4);
			race1AssertUtil.assertPilot(sco179, 4, 0, false, 5, 5);
			race1AssertUtil.assertPilot(sco159, 4, 0, false, 6, 6);
			race1AssertUtil.assertPilot(ir027, 4, 0, false, 7, 7);
			race1AssertUtil.assertPilot(ir085, 4, 0, false, 8, 8);
			race1AssertUtil.assertPilot(sco019, 4, 0, false, 9, 9);
			race1AssertUtil.assertPilot(ir073, 4, 0, false, 10, 10);
			race1AssertUtil.assertPilot(sco197, 3, 0, false, 11, 11);
			race1AssertUtil.assertPilot(sco154, 1, 0, false, 12, 12);
			race1AssertUtil.assertPilot(ir077, 3, 0, true, 0, 13);
			race1AssertUtil.assertPilot(ir025, 2, 0, true, 0, 14);
			race1AssertUtil.assertPilot(sco081, 1, 0, true, 0, 15);
			race1AssertUtil.assertPilot(ir028, 0, 0, true, 0, 16);
			race1AssertUtil.assertPilot(sco060, 0, 0, true, 0, 16);
			race1AssertUtil.assertDone(5);

			RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2, true);
			race2AssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
			race2AssertUtil.assertPilot(ir027, 5, 0, false, 2, 2);
			race2AssertUtil.assertPilot(sco019, 4, 0, false, 4, 3);
			race2AssertUtil.assertPilot(ir043, 5, 3, false, 3, 4);
			race2AssertUtil.assertPilot(sco159, 4, 1, false, 5, 5);
			race2AssertUtil.assertPilot(sco179, 4, 0, false, 6, 6);
			race2AssertUtil.assertPilot(ir014, 4, 0, false, 7, 7);
			race2AssertUtil.assertPilot(sco154, 4, 0, false, 8, 8);
			race2AssertUtil.assertPilot(sco060, 4, 0, false, 9, 9);
			race2AssertUtil.assertPilot(ir022, 3, 0, false, 10, 10);
			race2AssertUtil.assertPilot(ir025, 3, 0, false, 11, 11);
			race2AssertUtil.assertPilot(ir085, 2, 0, false, 12, 12);
			race2AssertUtil.assertPilot(sco197, 3, 0, true, 0, 13);
			race2AssertUtil.assertPilot(ir073, 2, 0, true, 0, 14);
			race2AssertUtil.assertPilot(ir028, 0, 0, true, 0, 15);
			race2AssertUtil.assertPilot(ir077, 0, 0, true, 0, 15);
			race2AssertUtil.assertPilot(sco081, 0, 0, true, 0, 15);
			race2AssertUtil.assertDone(5);

			RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3, true);
			race3AssertUtil.assertPilot(ir027, 5, 0, false, 0, 1);
			race3AssertUtil.assertPilot(sco023, 5, 0, false, 2, 2);
			race3AssertUtil.assertPilot(ir014, 4, 0, false, 3, 3);
			race3AssertUtil.assertPilot(ir022, 4, 0, false, 4, 4);
			race3AssertUtil.assertPilot(ir073, 4, 0, false, 5, 5);
			race3AssertUtil.assertPilot(ir043, 4, 0, false, 6, 6);
			race3AssertUtil.assertPilot(sco019, 4, 0, false, 7, 7);
			race3AssertUtil.assertPilot(sco179, 4, 0, false, 8, 8);
			race3AssertUtil.assertPilot(ir085, 4, 0, false, 9, 9);
			race3AssertUtil.assertPilot(sco197, 3, 0, false, 10, 10);
			race3AssertUtil.assertPilot(sco154, 3, 0, false, 11, 11);
			race3AssertUtil.assertPilot(sco159, 3, 0, false, 12, 12);
			race3AssertUtil.assertPilot(ir025, 4, 0, true, 0, 13);
			race3AssertUtil.assertPilot(ir028, 0, 0, true, 0, 14);
			race3AssertUtil.assertPilot(ir077, 0, 0, true, 0, 14);
			race3AssertUtil.assertPilot(sco060, 0, 0, true, 0, 14);
			race3AssertUtil.assertPilot(sco081, 0, 0, true, 0, 14);
			race3AssertUtil.assertDone(5);

			RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4, true);
			race4AssertUtil.assertPilot(ir027, 7, 0, false, 0, 1);
			race4AssertUtil.assertPilot(ir043, 6, 0, false, 2, 2);
			race4AssertUtil.assertPilot(ir022, 6, 0, false, 3, 3);
			race4AssertUtil.assertPilot(sco023, 6, 0, false, 4, 4);
			race4AssertUtil.assertPilot(sco154, 5, 0, false, 5, 5);
			race4AssertUtil.assertPilot(ir073, 5, 0, false, 6, 6);
			race4AssertUtil.assertPilot(ir025, 5, 0, false, 7, 7);
			race4AssertUtil.assertPilot(ir014, 5, 0, false, 8, 8);
			race4AssertUtil.assertPilot(sco019, 5, 0, false, 9, 9);
			race4AssertUtil.assertPilot(sco081, 4, 0, false, 10, 10);
			race4AssertUtil.assertPilot(sco159, 4, 0, false, 11, 11);
			race4AssertUtil.assertPilot(sco060, 3, 0, false, 12, 12);
			race4AssertUtil.assertPilot(ir085, 4, 0, true, 0, 13);
			race4AssertUtil.assertPilot(sco179, 1, 0, true, 0, 14);
			race4AssertUtil.assertPilot(ir028, 0, 0, true, 0, 15);
			race4AssertUtil.assertPilot(ir077, 0, 0, true, 0, 15);
			race4AssertUtil.assertPilot(sco197, 0, 0, true, 0, 15);
			race4AssertUtil.assertDone(5);

			RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5, true);
			race5AssertUtil.assertPilot(ir027, 7, 0, false, 0, 1);
			race5AssertUtil.assertPilot(sco023, 7, 0, false, 2, 2);
			race5AssertUtil.assertPilot(sco154, 7, 1, false, 3, 3);
			race5AssertUtil.assertPilot(ir043, 7, 0, false, 4, 4);
			race5AssertUtil.assertPilot(ir022, 6, 0, false, 5, 5);
			race5AssertUtil.assertPilot(ir025, 6, 0, false, 6, 6);
			race5AssertUtil.assertPilot(ir073, 6, 0, false, 7, 7);
			race5AssertUtil.assertPilot(sco159, 6, 1, false, 8, 8);
			race5AssertUtil.assertPilot(sco179, 6, 1, false, 9, 9);
			race5AssertUtil.assertPilot(sco060, 5, 0, false, 10, 10);
			race5AssertUtil.assertPilot(ir077, 2, 0, false, 11, 11);
			race5AssertUtil.assertPilot(sco081, 1, 0, false, 12, 12);
			race5AssertUtil.assertPilot(ir085, 2, 0, true, 0, 13);
			race5AssertUtil.assertPilot(ir014, 1, 0, true, 0, 14);
			race5AssertUtil.assertPilot(sco019, 1, 0, true, 0, 15);
			race5AssertUtil.assertPilot(ir028, 0, 0, true, 0, 16);
			race5AssertUtil.assertPilot(sco197, 0, 0, true, 0, 16);
			race5AssertUtil.assertDone(5);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 8, 1);
			overallAssertUtil.assertPilot(ir027, 0, 9, 2);
			overallAssertUtil.assertPilot(ir043, 3, 21, 3);
			overallAssertUtil.assertPilot(ir022, 0, 24, 4);
			overallAssertUtil.assertPilot(ir014, 0, 22, 5);
			overallAssertUtil.assertPilot(ir073, 0, 28, 6);
			overallAssertUtil.assertPilot(sco019, 0, 29, 7);
			overallAssertUtil.assertPilot(sco179, 1, 29, 8);
			overallAssertUtil.assertPilot(ir025, 0, 24, 9);
			overallAssertUtil.assertPilot(sco154, 1, 40, 10);
			overallAssertUtil.assertPilot(sco159, 2, 44, 11);
			overallAssertUtil.assertPilot(ir085, 0, 29, 12);
			overallAssertUtil.assertPilot(sco060, 0, 31, 13);
			overallAssertUtil.assertPilot(sco197, 0, 21, 14);
			overallAssertUtil.assertPilot(ir077, 0, 11, 15);
			overallAssertUtil.assertPilot(sco081, 0, 22, 16);
			overallAssertUtil.assertPilot(ir028, 0, 0, 17);
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
			raceAssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir022, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir043, 4, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir014, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir027, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir085, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir073, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco197, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco154, 1, 0, false, 12, 12);
			raceAssertUtil.assertPilot(ir077, 3, 0, true, 0, 13);
			raceAssertUtil.assertPilot(ir025, 2, 0, true, 0, 14);
			raceAssertUtil.assertPilot(sco081, 1, 0, true, 0, 15);
			raceAssertUtil.assertPilot(ir028, 0, 0, true, 0, 16);
			raceAssertUtil.assertPilot(sco060, 0, 0, true, 0, 16);
			raceAssertUtil.assertDone(5);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(ir022, 0, 2, 2);
			overallAssertUtil.assertPilot(ir043, 0, 3, 3);
			overallAssertUtil.assertPilot(ir014, 0, 4, 4);
			overallAssertUtil.assertPilot(sco179, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(ir027, 0, 7, 7);
			overallAssertUtil.assertPilot(ir085, 0, 8, 8);
			overallAssertUtil.assertPilot(sco019, 0, 9, 9);
			overallAssertUtil.assertPilot(ir073, 0, 10, 10);
			overallAssertUtil.assertPilot(sco197, 0, 11, 11);
			overallAssertUtil.assertPilot(sco154, 0, 12, 12);
			overallAssertUtil.assertPilot(ir025, 0, 0, 13);
			overallAssertUtil.assertPilot(ir028, 0, 0, 13);
			overallAssertUtil.assertPilot(ir077, 0, 0, 13);
			overallAssertUtil.assertPilot(sco060, 0, 0, 13);
			overallAssertUtil.assertPilot(sco081, 0, 0, 13);
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
			raceAssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir027, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 4, 3);
			raceAssertUtil.assertPilot(ir043, 5, 3, false, 3, 4);
			raceAssertUtil.assertPilot(sco159, 4, 1, false, 5, 5);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir014, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco154, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco060, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir022, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(ir025, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir085, 2, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco197, 3, 0, true, 0, 13);
			raceAssertUtil.assertPilot(ir073, 2, 0, true, 0, 14);
			raceAssertUtil.assertPilot(ir028, 0, 0, true, 0, 15);
			raceAssertUtil.assertPilot(ir077, 0, 0, true, 0, 15);
			raceAssertUtil.assertPilot(sco081, 0, 0, true, 0, 15);
			raceAssertUtil.assertDone(5);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(ir027, 0, 2, 2);
			overallAssertUtil.assertPilot(sco019, 0, 4, 3);
			overallAssertUtil.assertPilot(ir043, 3, 6, 4);
			overallAssertUtil.assertPilot(sco159, 1, 6, 4);
			overallAssertUtil.assertPilot(sco179, 0, 6, 4);
			overallAssertUtil.assertPilot(ir014, 0, 7, 7);
			overallAssertUtil.assertPilot(sco154, 0, 8, 8);
			overallAssertUtil.assertPilot(sco060, 0, 9, 9);
			overallAssertUtil.assertPilot(ir022, 0, 10, 10);
			overallAssertUtil.assertPilot(ir025, 0, 11, 11);
			overallAssertUtil.assertPilot(ir085, 0, 12, 12);
			overallAssertUtil.assertPilot(ir028, 0, 0, 13);
			overallAssertUtil.assertPilot(ir073, 0, 0, 13);
			overallAssertUtil.assertPilot(ir077, 0, 0, 13);
			overallAssertUtil.assertPilot(sco081, 0, 0, 13);
			overallAssertUtil.assertPilot(sco197, 0, 0, 13);
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
			raceAssertUtil.assertPilot(ir027, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir014, 4, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir022, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir073, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir043, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir085, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco197, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco154, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco159, 3, 0, false, 12, 12);
			raceAssertUtil.assertPilot(ir025, 4, 0, true, 0, 13);
			raceAssertUtil.assertPilot(ir028, 0, 0, true, 0, 14);
			raceAssertUtil.assertPilot(ir077, 0, 0, true, 0, 14);
			raceAssertUtil.assertPilot(sco060, 0, 0, true, 0, 14);
			raceAssertUtil.assertPilot(sco081, 0, 0, true, 0, 14);
			raceAssertUtil.assertDone(5);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir027, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(ir014, 0, 3, 3);
			overallAssertUtil.assertPilot(ir022, 0, 4, 4);
			overallAssertUtil.assertPilot(ir073, 0, 5, 5);
			overallAssertUtil.assertPilot(ir043, 0, 6, 6);
			overallAssertUtil.assertPilot(sco019, 0, 7, 7);
			overallAssertUtil.assertPilot(sco179, 0, 8, 8);
			overallAssertUtil.assertPilot(ir085, 0, 9, 9);
			overallAssertUtil.assertPilot(sco197, 0, 10, 10);
			overallAssertUtil.assertPilot(sco154, 0, 11, 11);
			overallAssertUtil.assertPilot(sco159, 0, 12, 12);
			overallAssertUtil.assertPilot(ir025, 0, 0, 13);
			overallAssertUtil.assertPilot(ir028, 0, 0, 13);
			overallAssertUtil.assertPilot(ir077, 0, 0, 13);
			overallAssertUtil.assertPilot(sco060, 0, 0, 13);
			overallAssertUtil.assertPilot(sco081, 0, 0, 13);
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
			raceAssertUtil.assertPilot(ir027, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir043, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir022, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco023, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco154, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir073, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir025, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir014, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco019, 5, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco081, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco060, 3, 0, false, 12, 12);
			raceAssertUtil.assertPilot(ir085, 4, 0, true, 0, 13);
			raceAssertUtil.assertPilot(sco179, 1, 0, true, 0, 14);
			raceAssertUtil.assertPilot(ir028, 0, 0, true, 0, 15);
			raceAssertUtil.assertPilot(ir077, 0, 0, true, 0, 15);
			raceAssertUtil.assertPilot(sco197, 0, 0, true, 0, 15);
			raceAssertUtil.assertDone(5);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir027, 0, 0, 1);
			overallAssertUtil.assertPilot(ir043, 0, 2, 2);
			overallAssertUtil.assertPilot(ir022, 0, 3, 3);
			overallAssertUtil.assertPilot(sco023, 0, 4, 4);
			overallAssertUtil.assertPilot(sco154, 0, 5, 5);
			overallAssertUtil.assertPilot(ir073, 0, 6, 6);
			overallAssertUtil.assertPilot(ir025, 0, 7, 7);
			overallAssertUtil.assertPilot(ir014, 0, 8, 8);
			overallAssertUtil.assertPilot(sco019, 0, 9, 9);
			overallAssertUtil.assertPilot(sco081, 0, 10, 10);
			overallAssertUtil.assertPilot(sco159, 0, 11, 11);
			overallAssertUtil.assertPilot(sco060, 0, 12, 12);
			overallAssertUtil.assertPilot(ir028, 0, 0, 13);
			overallAssertUtil.assertPilot(ir077, 0, 0, 13);
			overallAssertUtil.assertPilot(ir085, 0, 0, 13);
			overallAssertUtil.assertPilot(sco179, 0, 0, 13);
			overallAssertUtil.assertPilot(sco197, 0, 0, 13);
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
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Race race5 = raceDAO.find(event1, RACE5_NAME);

			Scores scores = scorer.scoreRace(race5, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race5, true);
			raceAssertUtil.assertPilot(ir027, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco023, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco154, 7, 1, false, 3, 3);
			raceAssertUtil.assertPilot(ir043, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir022, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir025, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir073, 6, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco159, 6, 1, false, 8, 8);
			raceAssertUtil.assertPilot(sco179, 6, 1, false, 9, 9);
			raceAssertUtil.assertPilot(sco060, 5, 0, false, 10, 10);
			raceAssertUtil.assertPilot(ir077, 2, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco081, 1, 0, false, 12, 12);
			raceAssertUtil.assertPilot(ir085, 2, 0, true, 0, 13);
			raceAssertUtil.assertPilot(ir014, 1, 0, true, 0, 14);
			raceAssertUtil.assertPilot(sco019, 1, 0, true, 0, 15);
			raceAssertUtil.assertPilot(ir028, 0, 0, true, 0, 16);
			raceAssertUtil.assertPilot(sco197, 0, 0, true, 0, 16);
			raceAssertUtil.assertDone(5);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir027, 0, 0, 1);
			overallAssertUtil.assertPilot(sco023, 0, 2, 2);
			overallAssertUtil.assertPilot(ir043, 0, 4, 3);
			overallAssertUtil.assertPilot(sco154, 1, 4, 3);
			overallAssertUtil.assertPilot(ir022, 0, 5, 5);
			overallAssertUtil.assertPilot(ir025, 0, 6, 6);
			overallAssertUtil.assertPilot(ir073, 0, 7, 7);
			overallAssertUtil.assertPilot(sco159, 1, 9, 8);
			overallAssertUtil.assertPilot(sco060, 0, 10, 9);
			overallAssertUtil.assertPilot(sco179, 1, 10, 9);
			overallAssertUtil.assertPilot(ir077, 0, 11, 11);
			overallAssertUtil.assertPilot(sco081, 0, 12, 12);
			overallAssertUtil.assertPilot(ir014, 0, 0, 13);
			overallAssertUtil.assertPilot(ir028, 0, 0, 13);
			overallAssertUtil.assertPilot(ir085, 0, 0, 13);
			overallAssertUtil.assertPilot(sco019, 0, 0, 13);
			overallAssertUtil.assertPilot(sco197, 0, 0, 13);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}