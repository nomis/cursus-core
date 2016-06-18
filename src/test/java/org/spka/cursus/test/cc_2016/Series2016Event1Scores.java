/*
	cursus - Race series management program
	Copyright 2016  Simon Arlott

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
package org.spka.cursus.test.cc_2016;

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
 * Scores at the end of event 1 (18/06/2016 to 19/06/2016)
 */
public class Series2016Event1Scores extends CCSeries2016 {
	public Series2016Event1Scores() {
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

		Assert.assertEquals(SERIES_FLEET_AT_EVENT1, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race1AssertUtil.assertPilot(ir021, 7, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
		race1AssertUtil.assertPilot(ir053, 7, 0, false, 4, 4);
		race1AssertUtil.assertPilot(ir085, 6, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
		race1AssertUtil.assertPilot(ir077, 5, 0, false, 7, 7);
		race1AssertUtil.assertPilot(ir023, 4, 0, false, 8, 8);
		race1AssertUtil.assertPilot(ir016, 0, 0, false, 10, 9);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(ir021, 4, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco116, 4, 0, false, 2, 2);
		race2AssertUtil.assertPilot(ir053, 4, 0, false, 3, 3);
		race2AssertUtil.assertPilot(ir077, 3, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco159, 3, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco808, 1, 0, false, 6, 6);
		race2AssertUtil.assertPilot(ir023, 1, 0, false, 7, 7);
		race2AssertUtil.assertPilot(ir016, 0, 0, false, 10, 8);
		race2AssertUtil.assertPilot(ir085, 0, 0, false, 10, 8);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco808, 5, 1, false, 0, 1);
		race3AssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
		race3AssertUtil.assertPilot(ir053, 5, 0, false, 4, 4);
		race3AssertUtil.assertPilot(ir021, 5, 0, false, 5, 5);
		race3AssertUtil.assertPilot(ir077, 5, 0, false, 6, 6);
		race3AssertUtil.assertPilot(ir085, 2, 0, false, 7, 7);
		race3AssertUtil.assertPilot(ir016, 1, 0, false, 8, 8);
		race3AssertUtil.assertPilot(ir023, 0, 0, false, 10, 9);
		race3AssertUtil.assertDone(0);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(ir053, 4, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco116, 4, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco808, 4, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco159, 4, 0, false, 4, 4);
		race4AssertUtil.assertPilot(ir077, 3, 0, false, 5, 5);
		race4AssertUtil.assertPilot(ir021, 3, 0, false, 6, 6);
		race4AssertUtil.assertPilot(ir023, 1, 0, false, 7, 7);
		race4AssertUtil.assertPilot(ir016, 0, 0, false, 10, 8);
		race4AssertUtil.assertPilot(ir085, 0, 0, false, 10, 8);
		race4AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco116, 0, 4, 1, 2);
		overallAssertUtil.assertPilot(ir021, 0, 7, 2, 6);
		overallAssertUtil.assertPilot(sco808, 1, 7, 3, 6);
		overallAssertUtil.assertPilot(ir053, 0, 7, 4, 4);
		overallAssertUtil.assertPilot(sco159, 0, 12, 5, 6);
		overallAssertUtil.assertPilot(ir077, 0, 15, 6, 7);
		overallAssertUtil.assertPilot(ir085, 0, 22, 7, 10);
		overallAssertUtil.assertPilot(ir023, 0, 22, 8, 10);
		overallAssertUtil.assertPilot(ir016, 0, 28, 9, 10);
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

			RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
			race1AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			race1AssertUtil.assertPilot(ir021, 7, 0, false, 2, 2);
			race1AssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
			race1AssertUtil.assertPilot(ir053, 7, 0, false, 4, 4);
			race1AssertUtil.assertPilot(ir085, 6, 0, false, 5, 5);
			race1AssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
			race1AssertUtil.assertPilot(ir077, 5, 0, false, 7, 7);
			race1AssertUtil.assertPilot(ir023, 4, 0, false, 8, 8);
			race1AssertUtil.assertPilot(ir016, 0, 0, false, 10, 9);
			race1AssertUtil.assertDone(0);

			RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
			race2AssertUtil.assertPilot(ir021, 4, 0, false, 0, 1);
			race2AssertUtil.assertPilot(sco116, 4, 0, false, 2, 2);
			race2AssertUtil.assertPilot(ir053, 4, 0, false, 3, 3);
			race2AssertUtil.assertPilot(ir077, 3, 0, false, 4, 4);
			race2AssertUtil.assertPilot(sco159, 3, 0, false, 5, 5);
			race2AssertUtil.assertPilot(sco808, 1, 0, false, 6, 6);
			race2AssertUtil.assertPilot(ir023, 1, 0, false, 7, 7);
			race2AssertUtil.assertPilot(ir016, 0, 0, false, 10, 8);
			race2AssertUtil.assertPilot(ir085, 0, 0, false, 10, 8);
			race2AssertUtil.assertDone(0);

			RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
			race3AssertUtil.assertPilot(sco808, 5, 1, false, 0, 1);
			race3AssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
			race3AssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			race3AssertUtil.assertPilot(ir053, 5, 0, false, 4, 4);
			race3AssertUtil.assertPilot(ir021, 5, 0, false, 5, 5);
			race3AssertUtil.assertPilot(ir077, 5, 0, false, 6, 6);
			race3AssertUtil.assertPilot(ir085, 2, 0, false, 7, 7);
			race3AssertUtil.assertPilot(ir016, 1, 0, false, 8, 8);
			race3AssertUtil.assertPilot(ir023, 0, 0, false, 10, 9);
			race3AssertUtil.assertDone(0);

			RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
			race4AssertUtil.assertPilot(ir053, 4, 0, false, 0, 1);
			race4AssertUtil.assertPilot(sco116, 4, 0, false, 2, 2);
			race4AssertUtil.assertPilot(sco808, 4, 0, false, 3, 3);
			race4AssertUtil.assertPilot(sco159, 4, 0, false, 4, 4);
			race4AssertUtil.assertPilot(ir077, 3, 0, false, 5, 5);
			race4AssertUtil.assertPilot(ir021, 3, 0, false, 6, 6);
			race4AssertUtil.assertPilot(ir023, 1, 0, false, 7, 7);
			race4AssertUtil.assertPilot(ir016, 0, 0, false, 10, 8);
			race4AssertUtil.assertPilot(ir085, 0, 0, false, 10, 8);
			race4AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 4, 1, 2);
			overallAssertUtil.assertPilot(ir021, 0, 7, 2, 6);
			overallAssertUtil.assertPilot(sco808, 1, 7, 3, 6);
			overallAssertUtil.assertPilot(ir053, 0, 7, 4, 4);
			overallAssertUtil.assertPilot(sco159, 0, 12, 5, 6);
			overallAssertUtil.assertPilot(ir077, 0, 15, 6, 7);
			overallAssertUtil.assertPilot(ir085, 0, 22, 7, 10);
			overallAssertUtil.assertPilot(ir023, 0, 22, 8, 10);
			overallAssertUtil.assertPilot(ir016, 0, 28, 9, 10);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race1);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir021, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir053, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir085, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir077, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir023, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir016, 0, 0, false, 10, 9);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(ir021, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(ir053, 0, 4, 4);
			overallAssertUtil.assertPilot(ir085, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(ir077, 0, 7, 7);
			overallAssertUtil.assertPilot(ir023, 0, 8, 8);
			overallAssertUtil.assertPilot(ir016, 0, 10, 9);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race2);
			raceAssertUtil.assertPilot(ir021, 4, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 4, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir053, 4, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir077, 3, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco159, 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco808, 1, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir023, 1, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir016, 0, 0, false, 10, 8);
			raceAssertUtil.assertPilot(ir085, 0, 0, false, 10, 8);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir021, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(ir053, 0, 3, 3);
			overallAssertUtil.assertPilot(ir077, 0, 4, 4);
			overallAssertUtil.assertPilot(sco159, 0, 5, 5);
			overallAssertUtil.assertPilot(sco808, 0, 6, 6);
			overallAssertUtil.assertPilot(ir023, 0, 7, 7);
			overallAssertUtil.assertPilot(ir016, 0, 10, 8);
			overallAssertUtil.assertPilot(ir085, 0, 10, 8);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race3);
			raceAssertUtil.assertPilot(sco808, 5, 1, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir053, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir021, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir077, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir085, 2, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir016, 1, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir023, 0, 0, false, 10, 9);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco808, 1, 1, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(ir053, 0, 4, 4);
			overallAssertUtil.assertPilot(ir021, 0, 5, 5);
			overallAssertUtil.assertPilot(ir077, 0, 6, 6);
			overallAssertUtil.assertPilot(ir085, 0, 7, 7);
			overallAssertUtil.assertPilot(ir016, 0, 8, 8);
			overallAssertUtil.assertPilot(ir023, 0, 10, 9);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race4);
			raceAssertUtil.assertPilot(ir053, 4, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 4, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 4, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir077, 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir021, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir023, 1, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir016, 0, 0, false, 10, 8);
			raceAssertUtil.assertPilot(ir085, 0, 0, false, 10, 8);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir053, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(sco159, 0, 4, 4);
			overallAssertUtil.assertPilot(ir077, 0, 5, 5);
			overallAssertUtil.assertPilot(ir021, 0, 6, 6);
			overallAssertUtil.assertPilot(ir023, 0, 7, 7);
			overallAssertUtil.assertPilot(ir016, 0, 10, 8);
			overallAssertUtil.assertPilot(ir085, 0, 10, 8);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}