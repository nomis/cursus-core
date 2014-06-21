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
public class Series2009Event1Scores extends CCSeries2009 {
	public Series2009Event1Scores() {
		super(false);
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

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
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
		race1AssertUtil.assertPilot(ir077, 3, 0, false, 11, 11);
		race1AssertUtil.assertPilot(sco197, 3, 0, false, 12, 12);
		race1AssertUtil.assertPilot(ir025, 2, 0, false, 13, 13);
		race1AssertUtil.assertPilot(sco154, 1, 0, false, 14, 14);
		race1AssertUtil.assertPilot(sco081, 1, 0, false, 15, 15);
		race1AssertUtil.assertPilot(ir028, 0, 0, false, 18, 16);
		race1AssertUtil.assertPilot(sco060, 0, 0, false, 18, 16);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
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
		race2AssertUtil.assertPilot(sco197, 3, 0, false, 11, 11);
		race2AssertUtil.assertPilot(ir025, 3, 0, false, 12, 12);
		race2AssertUtil.assertPilot(ir085, 2, 0, false, 13, 13);
		race2AssertUtil.assertPilot(ir073, 2, 0, false, 14, 14);
		race2AssertUtil.assertPilot(ir028, 0, 0, false, 18, 15);
		race2AssertUtil.assertPilot(ir077, 0, 0, false, 18, 15);
		race2AssertUtil.assertPilot(sco081, 0, 0, false, 18, 15);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(ir027, 5, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco023, 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(ir014, 4, 0, false, 3, 3);
		race3AssertUtil.assertPilot(ir022, 4, 0, false, 4, 4);
		race3AssertUtil.assertPilot(ir073, 4, 0, false, 5, 5);
		race3AssertUtil.assertPilot(ir043, 4, 0, false, 6, 6);
		race3AssertUtil.assertPilot(sco019, 4, 0, false, 7, 7);
		race3AssertUtil.assertPilot(sco179, 4, 0, false, 8, 8);
		race3AssertUtil.assertPilot(ir085, 4, 0, false, 9, 9);
		race3AssertUtil.assertPilot(ir025, 4, 0, false, 10, 10);
		race3AssertUtil.assertPilot(sco197, 3, 0, false, 11, 11);
		race3AssertUtil.assertPilot(sco154, 3, 0, false, 12, 12);
		race3AssertUtil.assertPilot(sco159, 3, 0, false, 13, 13);
		race3AssertUtil.assertPilot(ir028, 0, 0, false, 18, 14);
		race3AssertUtil.assertPilot(ir077, 0, 0, false, 18, 14);
		race3AssertUtil.assertPilot(sco060, 0, 0, false, 18, 14);
		race3AssertUtil.assertPilot(sco081, 0, 0, false, 18, 14);
		race3AssertUtil.assertDone(0);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
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
		race4AssertUtil.assertPilot(ir085, 4, 0, false, 11, 11);
		race4AssertUtil.assertPilot(sco159, 4, 0, false, 12, 12);
		race4AssertUtil.assertPilot(sco060, 3, 0, false, 13, 13);
		race4AssertUtil.assertPilot(sco179, 1, 0, false, 14, 14);
		race4AssertUtil.assertPilot(ir028, 0, 0, false, 18, 15);
		race4AssertUtil.assertPilot(ir077, 0, 0, false, 18, 15);
		race4AssertUtil.assertPilot(sco197, 0, 0, false, 18, 15);
		race4AssertUtil.assertDone(0);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(ir027, 7, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco023, 7, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco154, 7, 1, false, 3, 3);
		race5AssertUtil.assertPilot(ir043, 7, 0, false, 4, 4);
		race5AssertUtil.assertPilot(ir022, 6, 0, false, 5, 5);
		race5AssertUtil.assertPilot(ir025, 6, 0, false, 6, 6);
		race5AssertUtil.assertPilot(ir073, 6, 0, false, 7, 7);
		race5AssertUtil.assertPilot(sco159, 6, 2, false, 8, 8);
		race5AssertUtil.assertPilot(sco179, 6, 1, false, 9, 9);
		race5AssertUtil.assertPilot(sco060, 5, 0, false, 10, 10);
		race5AssertUtil.assertPilot(ir077, 2, 0, false, 11, 11);
		race5AssertUtil.assertPilot(ir085, 2, 0, false, 12, 12);
		race5AssertUtil.assertPilot(ir014, 1, 0, false, 13, 13);
		race5AssertUtil.assertPilot(sco081, 1, 0, false, 14, 14);
		race5AssertUtil.assertPilot(sco019, 1, 1, false, 15, 15);
		race5AssertUtil.assertPilot(ir028, 0, 0, false, 18, 16);
		race5AssertUtil.assertPilot(sco197, 0, 0, false, 18, 16);
		race5AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(ir027, 0, 2, 1, 7);
		overallAssertUtil.assertPilot(sco023, 0, 4, 2, 4);
		overallAssertUtil.assertPilot(ir022, 0, 14, 3, 10);
		overallAssertUtil.assertPilot(ir043, 3, 15, 4, 6);
		overallAssertUtil.assertPilot(ir014, 0, 22, 5, 13);
		overallAssertUtil.assertPilot(ir073, 0, 28, 6, 14);
		overallAssertUtil.assertPilot(sco154, 1, 29, 7, 14);
		overallAssertUtil.assertPilot(sco179, 1, 29, 8, 14);
		overallAssertUtil.assertPilot(sco019, 1, 30, 9, 15);
		overallAssertUtil.assertPilot(sco159, 3, 34, 10, 13);
		overallAssertUtil.assertPilot(ir025, 0, 35, 11, 13);
		overallAssertUtil.assertPilot(ir085, 0, 40, 12, 13);
		overallAssertUtil.assertPilot(sco060, 0, 50, 13, 18);
		overallAssertUtil.assertPilot(sco197, 0, 52, 14, 18);
		overallAssertUtil.assertPilot(sco081, 0, 57, 15, 18);
		overallAssertUtil.assertPilot(ir077, 0, 58, 16, 18);
		overallAssertUtil.assertPilot(ir028, 0, 72, 17, 18);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE1_FLEET, scores.getFleetSize(race1));
			Assert.assertEquals(RACE2_FLEET, scores.getFleetSize(race2));
			Assert.assertEquals(RACE3_FLEET, scores.getFleetSize(race3));
			Assert.assertEquals(RACE4_FLEET, scores.getFleetSize(race4));
			Assert.assertEquals(RACE5_FLEET, scores.getFleetSize(race5));

			RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
			race1AssertUtil.assertPilot(k099, 5, 0, false, 0, 1);
			race1AssertUtil.assertPilot(k016, 5, 0, false, 2, 2);
			race1AssertUtil.assertPilot(sco023, 5, 0, false, 3, 3);
			race1AssertUtil.assertPilot(ir022, 5, 0, false, 4, 4);
			race1AssertUtil.assertPilot(ir043, 4, 0, false, 5, 5);
			race1AssertUtil.assertPilot(ir014, 4, 0, false, 6, 6);
			race1AssertUtil.assertPilot(sco179, 4, 0, false, 7, 7);
			race1AssertUtil.assertPilot(sco159, 4, 0, false, 8, 8);
			race1AssertUtil.assertPilot(ir027, 4, 0, false, 9, 9);
			race1AssertUtil.assertPilot(ir085, 4, 0, false, 10, 10);
			race1AssertUtil.assertPilot(sco019, 4, 0, false, 11, 11);
			race1AssertUtil.assertPilot(ir073, 4, 0, false, 12, 12);
			race1AssertUtil.assertPilot(ir077, 3, 0, false, 13, 13);
			race1AssertUtil.assertPilot(sco197, 3, 0, false, 14, 14);
			race1AssertUtil.assertPilot(k877, 3, 0, false, 15, 15);
			race1AssertUtil.assertPilot(k015, 2, 0, false, 16, 16);
			race1AssertUtil.assertPilot(ir025, 2, 0, false, 17, 17);
			race1AssertUtil.assertPilot(sco154, 1, 0, false, 18, 18);
			race1AssertUtil.assertPilot(sco081, 1, 0, false, 19, 19);
			race1AssertUtil.assertPilot(k078, 1, 0, false, 20, 20);
			race1AssertUtil.assertPilot(ir028, 0, 0, false, 23, 21);
			race1AssertUtil.assertPilot(sco060, 0, 0, false, 23, 21);
			race1AssertUtil.assertDone(0);

			RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
			race2AssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
			race2AssertUtil.assertPilot(k099, 5, 0, false, 2, 2);
			race2AssertUtil.assertPilot(k016, 5, 0, false, 3, 3);
			race2AssertUtil.assertPilot(ir027, 5, 0, false, 4, 4);
			race2AssertUtil.assertPilot(k877, 5, 0, false, 5, 5);
			race2AssertUtil.assertPilot(sco019, 4, 0, false, 7, 6);
			race2AssertUtil.assertPilot(ir043, 5, 3, false, 6, 7);
			race2AssertUtil.assertPilot(sco159, 4, 1, false, 8, 8);
			race2AssertUtil.assertPilot(sco179, 4, 0, false, 9, 9);
			race2AssertUtil.assertPilot(k015, 4, 0, false, 10, 10);
			race2AssertUtil.assertPilot(k078, 4, 0, false, 11, 11);
			race2AssertUtil.assertPilot(ir014, 4, 0, false, 12, 12);
			race2AssertUtil.assertPilot(sco154, 4, 0, false, 13, 13);
			race2AssertUtil.assertPilot(sco060, 4, 0, false, 14, 14);
			race2AssertUtil.assertPilot(ir022, 3, 0, false, 15, 15);
			race2AssertUtil.assertPilot(sco197, 3, 0, false, 16, 16);
			race2AssertUtil.assertPilot(ir025, 3, 0, false, 17, 17);
			race2AssertUtil.assertPilot(ir085, 2, 0, false, 18, 18);
			race2AssertUtil.assertPilot(ir073, 2, 0, false, 19, 19);
			race2AssertUtil.assertPilot(ir028, 0, 0, false, 23, 20);
			race2AssertUtil.assertPilot(ir077, 0, 0, false, 23, 20);
			race2AssertUtil.assertPilot(sco081, 0, 0, false, 23, 20);
			race2AssertUtil.assertDone(0);

			RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
			race3AssertUtil.assertPilot(k099, 5, 0, false, 0, 1);
			race3AssertUtil.assertPilot(k016, 5, 0, false, 2, 2);
			race3AssertUtil.assertPilot(k877, 5, 0, false, 3, 3);
			race3AssertUtil.assertPilot(ir027, 5, 0, false, 4, 4);
			race3AssertUtil.assertPilot(sco023, 5, 0, false, 5, 5);
			race3AssertUtil.assertPilot(ir014, 4, 0, false, 6, 6);
			race3AssertUtil.assertPilot(ir022, 4, 0, false, 7, 7);
			race3AssertUtil.assertPilot(ir073, 4, 0, false, 8, 8);
			race3AssertUtil.assertPilot(ir043, 4, 0, false, 9, 9);
			race3AssertUtil.assertPilot(sco019, 4, 0, false, 10, 10);
			race3AssertUtil.assertPilot(sco179, 4, 0, false, 11, 11);
			race3AssertUtil.assertPilot(ir085, 4, 0, false, 12, 12);
			race3AssertUtil.assertPilot(ir025, 4, 0, false, 13, 13);
			race3AssertUtil.assertPilot(k015, 4, 0, false, 14, 14);
			race3AssertUtil.assertPilot(sco197, 3, 0, false, 15, 15);
			race3AssertUtil.assertPilot(sco154, 3, 0, false, 16, 16);
			race3AssertUtil.assertPilot(sco159, 3, 0, false, 17, 17);
			race3AssertUtil.assertPilot(ir028, 0, 0, false, 23, 18);
			race3AssertUtil.assertPilot(ir077, 0, 0, false, 23, 18);
			race3AssertUtil.assertPilot(k078, 0, 0, false, 23, 18);
			race3AssertUtil.assertPilot(sco060, 0, 0, false, 23, 18);
			race3AssertUtil.assertPilot(sco081, 0, 0, false, 23, 18);
			race3AssertUtil.assertDone(0);

			RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
			race4AssertUtil.assertPilot(k099, 7, 0, false, 0, 1);
			race4AssertUtil.assertPilot(k016, 7, 0, false, 2, 2);
			race4AssertUtil.assertPilot(ir027, 7, 0, false, 3, 3);
			race4AssertUtil.assertPilot(ir043, 6, 0, false, 4, 4);
			race4AssertUtil.assertPilot(ir022, 6, 0, false, 5, 5);
			race4AssertUtil.assertPilot(sco023, 6, 0, false, 6, 6);
			race4AssertUtil.assertPilot(k877, 5, 0, false, 7, 7);
			race4AssertUtil.assertPilot(sco154, 5, 0, false, 8, 8);
			race4AssertUtil.assertPilot(ir073, 5, 0, false, 9, 9);
			race4AssertUtil.assertPilot(ir025, 5, 0, false, 10, 10);
			race4AssertUtil.assertPilot(k015, 5, 0, false, 11, 11);
			race4AssertUtil.assertPilot(ir014, 5, 0, false, 12, 12);
			race4AssertUtil.assertPilot(sco019, 5, 0, false, 13, 13);
			race4AssertUtil.assertPilot(sco081, 4, 0, false, 14, 14);
			race4AssertUtil.assertPilot(ir085, 4, 0, false, 15, 15);
			race4AssertUtil.assertPilot(sco159, 4, 0, false, 16, 16);
			race4AssertUtil.assertPilot(sco060, 3, 0, false, 17, 17);
			race4AssertUtil.assertPilot(sco179, 1, 0, false, 18, 18);
			race4AssertUtil.assertPilot(ir028, 0, 0, false, 23, 19);
			race4AssertUtil.assertPilot(ir077, 0, 0, false, 23, 19);
			race4AssertUtil.assertPilot(k078, 0, 0, false, 23, 19);
			race4AssertUtil.assertPilot(sco197, 0, 0, false, 23, 19);
			race4AssertUtil.assertDone(0);

			RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
			race5AssertUtil.assertPilot(k016, 7, 1, false, 0, 1);
			race5AssertUtil.assertPilot(k099, 7, 1, false, 2, 2);
			race5AssertUtil.assertPilot(ir027, 7, 0, false, 3, 3);
			race5AssertUtil.assertPilot(sco023, 7, 0, false, 4, 4);
			race5AssertUtil.assertPilot(sco154, 7, 1, false, 5, 5);
			race5AssertUtil.assertPilot(ir043, 7, 0, false, 6, 6);
			race5AssertUtil.assertPilot(k877, 7, 1, false, 7, 7);
			race5AssertUtil.assertPilot(ir022, 6, 0, false, 8, 8);
			race5AssertUtil.assertPilot(k015, 6, 1, false, 9, 9);
			race5AssertUtil.assertPilot(ir025, 6, 0, false, 10, 10);
			race5AssertUtil.assertPilot(ir073, 6, 0, false, 11, 11);
			race5AssertUtil.assertPilot(sco159, 6, 2, false, 12, 12);
			race5AssertUtil.assertPilot(sco179, 6, 1, false, 13, 13);
			race5AssertUtil.assertPilot(sco060, 5, 0, false, 14, 14);
			race5AssertUtil.assertPilot(ir077, 2, 0, false, 15, 15);
			race5AssertUtil.assertPilot(ir085, 2, 0, false, 16, 16);
			race5AssertUtil.assertPilot(ir014, 1, 0, false, 17, 17);
			race5AssertUtil.assertPilot(sco081, 1, 0, false, 18, 18);
			race5AssertUtil.assertPilot(sco019, 1, 1, false, 19, 19);
			race5AssertUtil.assertPilot(ir028, 0, 0, false, 23, 20);
			race5AssertUtil.assertPilot(k078, 0, 0, false, 23, 20);
			race5AssertUtil.assertPilot(sco197, 0, 0, false, 23, 20);
			race5AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(k099, 1, 3, 1, 2);
			overallAssertUtil.assertPilot(k016, 1, 7, 2, 3);
			overallAssertUtil.assertPilot(sco023, 0, 12, 3, 6);
			overallAssertUtil.assertPilot(ir027, 0, 14, 4, 9);
			overallAssertUtil.assertPilot(k877, 1, 23, 5, 15);
			overallAssertUtil.assertPilot(ir043, 3, 24, 6, 9);
			overallAssertUtil.assertPilot(ir022, 0, 24, 7, 15);
			overallAssertUtil.assertPilot(ir014, 0, 36, 8, 17);
			overallAssertUtil.assertPilot(ir073, 0, 40, 9, 19);
			overallAssertUtil.assertPilot(sco179, 1, 41, 10, 18);
			overallAssertUtil.assertPilot(sco019, 1, 42, 11, 19);
			overallAssertUtil.assertPilot(sco154, 1, 43, 12, 18);
			overallAssertUtil.assertPilot(k015, 1, 45, 13, 16);
			overallAssertUtil.assertPilot(sco159, 3, 47, 14, 17);
			overallAssertUtil.assertPilot(ir025, 0, 50, 15, 17);
			overallAssertUtil.assertPilot(ir085, 0, 53, 16, 18);
			overallAssertUtil.assertPilot(sco060, 0, 68, 17, 23);
			overallAssertUtil.assertPilot(sco197, 0, 68, 18, 23);
			overallAssertUtil.assertPilot(ir077, 0, 74, 19, 23);
			overallAssertUtil.assertPilot(sco081, 0, 74, 20, 23);
			overallAssertUtil.assertPilot(k078, 0, 77, 21, 23);
			overallAssertUtil.assertPilot(ir028, 0, 92, 22, 23);
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
			raceAssertUtil.assertPilot(k099, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(k016, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco023, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir022, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir043, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir014, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir027, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir085, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir073, 4, 0, false, 12, 12);
			raceAssertUtil.assertPilot(ir077, 3, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco197, 3, 0, false, 14, 14);
			raceAssertUtil.assertPilot(k877, 3, 0, false, 15, 15);
			raceAssertUtil.assertPilot(k015, 2, 0, false, 16, 16);
			raceAssertUtil.assertPilot(ir025, 2, 0, false, 17, 17);
			raceAssertUtil.assertPilot(sco154, 1, 0, false, 18, 18);
			raceAssertUtil.assertPilot(sco081, 1, 0, false, 19, 19);
			raceAssertUtil.assertPilot(k078, 1, 0, false, 20, 20);
			raceAssertUtil.assertPilot(ir028, 0, 0, false, 23, 21);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 23, 21);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(k099, 0, 0, 1);
			overallAssertUtil.assertPilot(k016, 0, 2, 2);
			overallAssertUtil.assertPilot(sco023, 0, 3, 3);
			overallAssertUtil.assertPilot(ir022, 0, 4, 4);
			overallAssertUtil.assertPilot(ir043, 0, 5, 5);
			overallAssertUtil.assertPilot(ir014, 0, 6, 6);
			overallAssertUtil.assertPilot(sco179, 0, 7, 7);
			overallAssertUtil.assertPilot(sco159, 0, 8, 8);
			overallAssertUtil.assertPilot(ir027, 0, 9, 9);
			overallAssertUtil.assertPilot(ir085, 0, 10, 10);
			overallAssertUtil.assertPilot(sco019, 0, 11, 11);
			overallAssertUtil.assertPilot(ir073, 0, 12, 12);
			overallAssertUtil.assertPilot(ir077, 0, 13, 13);
			overallAssertUtil.assertPilot(sco197, 0, 14, 14);
			overallAssertUtil.assertPilot(k877, 0, 15, 15);
			overallAssertUtil.assertPilot(k015, 0, 16, 16);
			overallAssertUtil.assertPilot(ir025, 0, 17, 17);
			overallAssertUtil.assertPilot(sco154, 0, 18, 18);
			overallAssertUtil.assertPilot(sco081, 0, 19, 19);
			overallAssertUtil.assertPilot(k078, 0, 20, 20);
			overallAssertUtil.assertPilot(ir028, 0, 23, 21);
			overallAssertUtil.assertPilot(sco060, 0, 23, 21);
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
			raceAssertUtil.assertPilot(sco023, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(k099, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(k016, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir027, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(k877, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 7, 6);
			raceAssertUtil.assertPilot(ir043, 5, 3, false, 6, 7);
			raceAssertUtil.assertPilot(sco159, 4, 1, false, 8, 8);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(k015, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(k078, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir014, 4, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco154, 4, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco060, 4, 0, false, 14, 14);
			raceAssertUtil.assertPilot(ir022, 3, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco197, 3, 0, false, 16, 16);
			raceAssertUtil.assertPilot(ir025, 3, 0, false, 17, 17);
			raceAssertUtil.assertPilot(ir085, 2, 0, false, 18, 18);
			raceAssertUtil.assertPilot(ir073, 2, 0, false, 19, 19);
			raceAssertUtil.assertPilot(ir028, 0, 0, false, 23, 20);
			raceAssertUtil.assertPilot(ir077, 0, 0, false, 23, 20);
			raceAssertUtil.assertPilot(sco081, 0, 0, false, 23, 20);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco023, 0, 0, 1);
			overallAssertUtil.assertPilot(k099, 0, 2, 2);
			overallAssertUtil.assertPilot(k016, 0, 3, 3);
			overallAssertUtil.assertPilot(ir027, 0, 4, 4);
			overallAssertUtil.assertPilot(k877, 0, 5, 5);
			overallAssertUtil.assertPilot(sco019, 0, 7, 6);
			overallAssertUtil.assertPilot(ir043, 3, 9, 7);
			overallAssertUtil.assertPilot(sco159, 1, 9, 8);
			overallAssertUtil.assertPilot(sco179, 0, 9, 9);
			overallAssertUtil.assertPilot(k015, 0, 10, 10);
			overallAssertUtil.assertPilot(k078, 0, 11, 11);
			overallAssertUtil.assertPilot(ir014, 0, 12, 12);
			overallAssertUtil.assertPilot(sco154, 0, 13, 13);
			overallAssertUtil.assertPilot(sco060, 0, 14, 14);
			overallAssertUtil.assertPilot(ir022, 0, 15, 15);
			overallAssertUtil.assertPilot(sco197, 0, 16, 16);
			overallAssertUtil.assertPilot(ir025, 0, 17, 17);
			overallAssertUtil.assertPilot(ir085, 0, 18, 18);
			overallAssertUtil.assertPilot(ir073, 0, 19, 19);
			overallAssertUtil.assertPilot(ir028, 0, 23, 20);
			overallAssertUtil.assertPilot(ir077, 0, 23, 20);
			overallAssertUtil.assertPilot(sco081, 0, 23, 20);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE3_FLEET, scores.getFleetSize(race3));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race3);
			raceAssertUtil.assertPilot(k099, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(k016, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(k877, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir027, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco023, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir014, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir022, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir073, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir043, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco019, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco179, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir085, 4, 0, false, 12, 12);
			raceAssertUtil.assertPilot(ir025, 4, 0, false, 13, 13);
			raceAssertUtil.assertPilot(k015, 4, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco197, 3, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco154, 3, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco159, 3, 0, false, 17, 17);
			raceAssertUtil.assertPilot(ir028, 0, 0, false, 23, 18);
			raceAssertUtil.assertPilot(ir077, 0, 0, false, 23, 18);
			raceAssertUtil.assertPilot(k078, 0, 0, false, 23, 18);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 23, 18);
			raceAssertUtil.assertPilot(sco081, 0, 0, false, 23, 18);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(k099, 0, 0, 1);
			overallAssertUtil.assertPilot(k016, 0, 2, 2);
			overallAssertUtil.assertPilot(k877, 0, 3, 3);
			overallAssertUtil.assertPilot(ir027, 0, 4, 4);
			overallAssertUtil.assertPilot(sco023, 0, 5, 5);
			overallAssertUtil.assertPilot(ir014, 0, 6, 6);
			overallAssertUtil.assertPilot(ir022, 0, 7, 7);
			overallAssertUtil.assertPilot(ir073, 0, 8, 8);
			overallAssertUtil.assertPilot(ir043, 0, 9, 9);
			overallAssertUtil.assertPilot(sco019, 0, 10, 10);
			overallAssertUtil.assertPilot(sco179, 0, 11, 11);
			overallAssertUtil.assertPilot(ir085, 0, 12, 12);
			overallAssertUtil.assertPilot(ir025, 0, 13, 13);
			overallAssertUtil.assertPilot(k015, 0, 14, 14);
			overallAssertUtil.assertPilot(sco197, 0, 15, 15);
			overallAssertUtil.assertPilot(sco154, 0, 16, 16);
			overallAssertUtil.assertPilot(sco159, 0, 17, 17);
			overallAssertUtil.assertPilot(ir028, 0, 23, 18);
			overallAssertUtil.assertPilot(ir077, 0, 23, 18);
			overallAssertUtil.assertPilot(k078, 0, 23, 18);
			overallAssertUtil.assertPilot(sco060, 0, 23, 18);
			overallAssertUtil.assertPilot(sco081, 0, 23, 18);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE4_FLEET, scores.getFleetSize(race4));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race4);
			raceAssertUtil.assertPilot(k099, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(k016, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir027, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir043, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir022, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco023, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(k877, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco154, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir073, 5, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir025, 5, 0, false, 10, 10);
			raceAssertUtil.assertPilot(k015, 5, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir014, 5, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco019, 5, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco081, 4, 0, false, 14, 14);
			raceAssertUtil.assertPilot(ir085, 4, 0, false, 15, 15);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 16, 16);
			raceAssertUtil.assertPilot(sco060, 3, 0, false, 17, 17);
			raceAssertUtil.assertPilot(sco179, 1, 0, false, 18, 18);
			raceAssertUtil.assertPilot(ir028, 0, 0, false, 23, 19);
			raceAssertUtil.assertPilot(ir077, 0, 0, false, 23, 19);
			raceAssertUtil.assertPilot(k078, 0, 0, false, 23, 19);
			raceAssertUtil.assertPilot(sco197, 0, 0, false, 23, 19);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(k099, 0, 0, 1);
			overallAssertUtil.assertPilot(k016, 0, 2, 2);
			overallAssertUtil.assertPilot(ir027, 0, 3, 3);
			overallAssertUtil.assertPilot(ir043, 0, 4, 4);
			overallAssertUtil.assertPilot(ir022, 0, 5, 5);
			overallAssertUtil.assertPilot(sco023, 0, 6, 6);
			overallAssertUtil.assertPilot(k877, 0, 7, 7);
			overallAssertUtil.assertPilot(sco154, 0, 8, 8);
			overallAssertUtil.assertPilot(ir073, 0, 9, 9);
			overallAssertUtil.assertPilot(ir025, 0, 10, 10);
			overallAssertUtil.assertPilot(k015, 0, 11, 11);
			overallAssertUtil.assertPilot(ir014, 0, 12, 12);
			overallAssertUtil.assertPilot(sco019, 0, 13, 13);
			overallAssertUtil.assertPilot(sco081, 0, 14, 14);
			overallAssertUtil.assertPilot(ir085, 0, 15, 15);
			overallAssertUtil.assertPilot(sco159, 0, 16, 16);
			overallAssertUtil.assertPilot(sco060, 0, 17, 17);
			overallAssertUtil.assertPilot(sco179, 0, 18, 18);
			overallAssertUtil.assertPilot(ir028, 0, 23, 19);
			overallAssertUtil.assertPilot(ir077, 0, 23, 19);
			overallAssertUtil.assertPilot(k078, 0, 23, 19);
			overallAssertUtil.assertPilot(sco197, 0, 23, 19);
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
			Assert.assertEquals(EVENT1_FLEET, scores.getPilots().size());
			Assert.assertEquals(RACE5_FLEET, scores.getFleetSize(race5));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race5);
			raceAssertUtil.assertPilot(k016, 7, 1, false, 0, 1);
			raceAssertUtil.assertPilot(k099, 7, 1, false, 2, 2);
			raceAssertUtil.assertPilot(ir027, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco023, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco154, 7, 1, false, 5, 5);
			raceAssertUtil.assertPilot(ir043, 7, 0, false, 6, 6);
			raceAssertUtil.assertPilot(k877, 7, 1, false, 7, 7);
			raceAssertUtil.assertPilot(ir022, 6, 0, false, 8, 8);
			raceAssertUtil.assertPilot(k015, 6, 1, false, 9, 9);
			raceAssertUtil.assertPilot(ir025, 6, 0, false, 10, 10);
			raceAssertUtil.assertPilot(ir073, 6, 0, false, 11, 11);
			raceAssertUtil.assertPilot(sco159, 6, 2, false, 12, 12);
			raceAssertUtil.assertPilot(sco179, 6, 1, false, 13, 13);
			raceAssertUtil.assertPilot(sco060, 5, 0, false, 14, 14);
			raceAssertUtil.assertPilot(ir077, 2, 0, false, 15, 15);
			raceAssertUtil.assertPilot(ir085, 2, 0, false, 16, 16);
			raceAssertUtil.assertPilot(ir014, 1, 0, false, 17, 17);
			raceAssertUtil.assertPilot(sco081, 1, 0, false, 18, 18);
			raceAssertUtil.assertPilot(sco019, 1, 1, false, 19, 19);
			raceAssertUtil.assertPilot(ir028, 0, 0, false, 23, 20);
			raceAssertUtil.assertPilot(k078, 0, 0, false, 23, 20);
			raceAssertUtil.assertPilot(sco197, 0, 0, false, 23, 20);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(k016, 1, 1, 1);
			overallAssertUtil.assertPilot(k099, 1, 3, 2);
			overallAssertUtil.assertPilot(ir027, 0, 3, 3);
			overallAssertUtil.assertPilot(sco023, 0, 4, 4);
			overallAssertUtil.assertPilot(sco154, 1, 6, 5);
			overallAssertUtil.assertPilot(ir043, 0, 6, 6);
			overallAssertUtil.assertPilot(k877, 1, 8, 7);
			overallAssertUtil.assertPilot(ir022, 0, 8, 8);
			overallAssertUtil.assertPilot(k015, 1, 10, 9);
			overallAssertUtil.assertPilot(ir025, 0, 10, 10);
			overallAssertUtil.assertPilot(ir073, 0, 11, 11);
			overallAssertUtil.assertPilot(sco159, 2, 14, 12);
			overallAssertUtil.assertPilot(sco179, 1, 14, 13);
			overallAssertUtil.assertPilot(sco060, 0, 14, 14);
			overallAssertUtil.assertPilot(ir077, 0, 15, 15);
			overallAssertUtil.assertPilot(ir085, 0, 16, 16);
			overallAssertUtil.assertPilot(ir014, 0, 17, 17);
			overallAssertUtil.assertPilot(sco081, 0, 18, 18);
			overallAssertUtil.assertPilot(sco019, 1, 20, 19);
			overallAssertUtil.assertPilot(ir028, 0, 23, 20);
			overallAssertUtil.assertPilot(k078, 0, 23, 20);
			overallAssertUtil.assertPilot(sco197, 0, 23, 20);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}