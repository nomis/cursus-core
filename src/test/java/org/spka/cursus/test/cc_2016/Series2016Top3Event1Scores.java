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

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.test.util.OverallAssertUtil;
import uk.uuid.cursus.test.util.RaceAssertUtil;

/**
 * Scores at the end of event 1 (18/06/2016 to 19/06/2016)
 */
@SuppressWarnings("nls")
public class Series2016Top3Event1Scores extends CCSeries2016 {
	public Series2016Top3Event1Scores() {
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
			Event event1 = eventDAO.find(series, "Race Event 1");
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
			Event event1 = eventDAO.find(series, "Race Event 1");

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
		Event event1 = eventDAO.find(series, "Race Event 1");
		Race race1 = raceDAO.find(event1, "Race 1");
		Race race2 = raceDAO.find(event1, "Race 2");
		Race race3 = raceDAO.find(event1, "Race 3");
		Race race4 = raceDAO.find(event1, "Race 4");

		Assert.assertEquals(SERIES_FLEET_AT_EVENT1, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1, true);
		race1AssertUtil.assertPilot(findPilot("SCO116"), 7, 0, false, 0, 1);
		race1AssertUtil.assertPilot(findPilot("IR021"), 7, 0, false, 2, 2);
		race1AssertUtil.assertPilot(findPilot("SCO808"), 7, 0, false, 3, 3);
		race1AssertUtil.assertPilot(findPilot("IR053"), 7, 0, false, 4, 4);
		race1AssertUtil.assertPilot(findPilot("IR085"), 6, 0, false, 5, 5);
		race1AssertUtil.assertPilot(findPilot("SCO159"), 6, 0, false, 6, 6);
		race1AssertUtil.assertPilot(findPilot("IR077"), 5, 0, true, 0, 7);
		race1AssertUtil.assertPilot(findPilot("IR023"), 4, 0, true, 0, 8);
		race1AssertUtil.assertPilot(findPilot("IR016"), 0, 0, true, 0, 9);
		race1AssertUtil.assertDone(3);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2, true);
		race2AssertUtil.assertPilot(findPilot("IR021"), 4, 0, false, 0, 1);
		race2AssertUtil.assertPilot(findPilot("SCO116"), 4, 0, false, 2, 2);
		race2AssertUtil.assertPilot(findPilot("IR053"), 4, 0, false, 3, 3);
		race2AssertUtil.assertPilot(findPilot("IR077"), 3, 0, false, 4, 4);
		race2AssertUtil.assertPilot(findPilot("SCO159"), 3, 0, false, 5, 5);
		race2AssertUtil.assertPilot(findPilot("SCO808"), 1, 0, false, 6, 6);
		race2AssertUtil.assertPilot(findPilot("IR023"), 1, 0, true, 0, 7);
		race2AssertUtil.assertPilot(findPilot("IR016"), 0, 0, true, 0, 8);
		race2AssertUtil.assertPilot(findPilot("IR085"), 0, 0, true, 0, 8);
		race2AssertUtil.assertDone(3);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3, true);
		race3AssertUtil.assertPilot(findPilot("SCO808"), 5, 1, false, 0, 1);
		race3AssertUtil.assertPilot(findPilot("SCO116"), 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(findPilot("SCO159"), 5, 0, false, 3, 3);
		race3AssertUtil.assertPilot(findPilot("IR053"), 5, 0, false, 4, 4);
		race3AssertUtil.assertPilot(findPilot("IR021"), 5, 0, false, 5, 5);
		race3AssertUtil.assertPilot(findPilot("IR077"), 5, 0, false, 6, 6);
		race3AssertUtil.assertPilot(findPilot("IR085"), 2, 0, true, 0, 7);
		race3AssertUtil.assertPilot(findPilot("IR016"), 1, 0, true, 0, 8);
		race3AssertUtil.assertPilot(findPilot("IR023"), 0, 0, true, 0, 9);
		race3AssertUtil.assertDone(3);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4, true);
		race4AssertUtil.assertPilot(findPilot("IR053"), 4, 0, false, 0, 1);
		race4AssertUtil.assertPilot(findPilot("SCO116"), 4, 0, false, 2, 2);
		race4AssertUtil.assertPilot(findPilot("SCO808"), 4, 0, false, 3, 3);
		race4AssertUtil.assertPilot(findPilot("SCO159"), 4, 0, false, 4, 4);
		race4AssertUtil.assertPilot(findPilot("IR077"), 3, 0, false, 5, 5);
		race4AssertUtil.assertPilot(findPilot("IR021"), 3, 0, false, 6, 6);
		race4AssertUtil.assertPilot(findPilot("IR023"), 1, 0, true, 0, 7);
		race4AssertUtil.assertPilot(findPilot("IR016"), 0, 0, true, 0, 8);
		race4AssertUtil.assertPilot(findPilot("IR085"), 0, 0, true, 0, 8);
		race4AssertUtil.assertDone(3);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(findPilot("SCO116"), 0, 6, 1);
		overallAssertUtil.assertPilot(findPilot("IR053"), 0, 11, 2);
		overallAssertUtil.assertPilot(findPilot("IR021"), 0, 13, 3);
		overallAssertUtil.assertPilot(findPilot("SCO808"), 1, 13, 4);
		overallAssertUtil.assertPilot(findPilot("SCO159"), 0, 18, 5);
		overallAssertUtil.assertPilot(findPilot("IR085"), 0, 5, 6);
		overallAssertUtil.assertPilot(findPilot("IR077"), 0, 15, 7);
		overallAssertUtil.assertPilot(findPilot("IR016"), 0, 0, 8);
		overallAssertUtil.assertPilot(findPilot("IR023"), 0, 0, 8);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent1() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, "Race Event 1");
			Race race1 = raceDAO.find(event1, "Race 1");
			Race race2 = raceDAO.find(event1, "Race 2");
			Race race3 = raceDAO.find(event1, "Race 3");
			Race race4 = raceDAO.find(event1, "Race 4");

			Scores scores = scorer.scoreEvent(event1, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1, true);
			race1AssertUtil.assertPilot(findPilot("SCO116"), 7, 0, false, 0, 1);
			race1AssertUtil.assertPilot(findPilot("IR021"), 7, 0, false, 2, 2);
			race1AssertUtil.assertPilot(findPilot("SCO808"), 7, 0, false, 3, 3);
			race1AssertUtil.assertPilot(findPilot("IR053"), 7, 0, false, 4, 4);
			race1AssertUtil.assertPilot(findPilot("IR085"), 6, 0, false, 5, 5);
			race1AssertUtil.assertPilot(findPilot("SCO159"), 6, 0, false, 6, 6);
			race1AssertUtil.assertPilot(findPilot("IR077"), 5, 0, true, 0, 7);
			race1AssertUtil.assertPilot(findPilot("IR023"), 4, 0, true, 0, 8);
			race1AssertUtil.assertPilot(findPilot("IR016"), 0, 0, true, 0, 9);
			race1AssertUtil.assertDone(3);

			RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2, true);
			race2AssertUtil.assertPilot(findPilot("IR021"), 4, 0, false, 0, 1);
			race2AssertUtil.assertPilot(findPilot("SCO116"), 4, 0, false, 2, 2);
			race2AssertUtil.assertPilot(findPilot("IR053"), 4, 0, false, 3, 3);
			race2AssertUtil.assertPilot(findPilot("IR077"), 3, 0, false, 4, 4);
			race2AssertUtil.assertPilot(findPilot("SCO159"), 3, 0, false, 5, 5);
			race2AssertUtil.assertPilot(findPilot("SCO808"), 1, 0, false, 6, 6);
			race2AssertUtil.assertPilot(findPilot("IR023"), 1, 0, true, 0, 7);
			race2AssertUtil.assertPilot(findPilot("IR016"), 0, 0, true, 0, 8);
			race2AssertUtil.assertPilot(findPilot("IR085"), 0, 0, true, 0, 8);
			race2AssertUtil.assertDone(3);

			RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3, true);
			race3AssertUtil.assertPilot(findPilot("SCO808"), 5, 1, false, 0, 1);
			race3AssertUtil.assertPilot(findPilot("SCO116"), 5, 0, false, 2, 2);
			race3AssertUtil.assertPilot(findPilot("SCO159"), 5, 0, false, 3, 3);
			race3AssertUtil.assertPilot(findPilot("IR053"), 5, 0, false, 4, 4);
			race3AssertUtil.assertPilot(findPilot("IR021"), 5, 0, false, 5, 5);
			race3AssertUtil.assertPilot(findPilot("IR077"), 5, 0, false, 6, 6);
			race3AssertUtil.assertPilot(findPilot("IR085"), 2, 0, true, 0, 7);
			race3AssertUtil.assertPilot(findPilot("IR016"), 1, 0, true, 0, 8);
			race3AssertUtil.assertPilot(findPilot("IR023"), 0, 0, true, 0, 9);
			race3AssertUtil.assertDone(3);

			RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4, true);
			race4AssertUtil.assertPilot(findPilot("IR053"), 4, 0, false, 0, 1);
			race4AssertUtil.assertPilot(findPilot("SCO116"), 4, 0, false, 2, 2);
			race4AssertUtil.assertPilot(findPilot("SCO808"), 4, 0, false, 3, 3);
			race4AssertUtil.assertPilot(findPilot("SCO159"), 4, 0, false, 4, 4);
			race4AssertUtil.assertPilot(findPilot("IR077"), 3, 0, false, 5, 5);
			race4AssertUtil.assertPilot(findPilot("IR021"), 3, 0, false, 6, 6);
			race4AssertUtil.assertPilot(findPilot("IR023"), 1, 0, true, 0, 7);
			race4AssertUtil.assertPilot(findPilot("IR016"), 0, 0, true, 0, 8);
			race4AssertUtil.assertPilot(findPilot("IR085"), 0, 0, true, 0, 8);
			race4AssertUtil.assertDone(3);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(findPilot("SCO116"), 0, 6, 1);
			overallAssertUtil.assertPilot(findPilot("IR053"), 0, 11, 2);
			overallAssertUtil.assertPilot(findPilot("IR021"), 0, 13, 3);
			overallAssertUtil.assertPilot(findPilot("SCO808"), 1, 13, 4);
			overallAssertUtil.assertPilot(findPilot("SCO159"), 0, 18, 5);
			overallAssertUtil.assertPilot(findPilot("IR085"), 0, 5, 6);
			overallAssertUtil.assertPilot(findPilot("IR077"), 0, 15, 7);
			overallAssertUtil.assertPilot(findPilot("IR016"), 0, 0, 8);
			overallAssertUtil.assertPilot(findPilot("IR023"), 0, 0, 8);
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
			Event event1 = eventDAO.find(series, "Race Event 1");
			Race race1 = raceDAO.find(event1, "Race 1");

			Scores scores = scorer.scoreRace(race1, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race1, true);
			raceAssertUtil.assertPilot(findPilot("SCO116"), 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(findPilot("IR021"), 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(findPilot("SCO808"), 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(findPilot("IR053"), 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(findPilot("IR085"), 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(findPilot("SCO159"), 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(findPilot("IR077"), 5, 0, true, 0, 7);
			raceAssertUtil.assertPilot(findPilot("IR023"), 4, 0, true, 0, 8);
			raceAssertUtil.assertPilot(findPilot("IR016"), 0, 0, true, 0, 9);
			raceAssertUtil.assertDone(3);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(findPilot("SCO116"), 0, 0, 1);
			overallAssertUtil.assertPilot(findPilot("IR021"), 0, 2, 2);
			overallAssertUtil.assertPilot(findPilot("SCO808"), 0, 3, 3);
			overallAssertUtil.assertPilot(findPilot("IR053"), 0, 4, 4);
			overallAssertUtil.assertPilot(findPilot("IR085"), 0, 5, 5);
			overallAssertUtil.assertPilot(findPilot("SCO159"), 0, 6, 6);
			overallAssertUtil.assertPilot(findPilot("IR016"), 0, 0, 7);
			overallAssertUtil.assertPilot(findPilot("IR023"), 0, 0, 7);
			overallAssertUtil.assertPilot(findPilot("IR077"), 0, 0, 7);
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
			Event event1 = eventDAO.find(series, "Race Event 1");
			Race race2 = raceDAO.find(event1, "Race 2");

			Scores scores = scorer.scoreRace(race2, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race2, true);
			raceAssertUtil.assertPilot(findPilot("IR021"), 4, 0, false, 0, 1);
			raceAssertUtil.assertPilot(findPilot("SCO116"), 4, 0, false, 2, 2);
			raceAssertUtil.assertPilot(findPilot("IR053"), 4, 0, false, 3, 3);
			raceAssertUtil.assertPilot(findPilot("IR077"), 3, 0, false, 4, 4);
			raceAssertUtil.assertPilot(findPilot("SCO159"), 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(findPilot("SCO808"), 1, 0, false, 6, 6);
			raceAssertUtil.assertPilot(findPilot("IR023"), 1, 0, true, 0, 7);
			raceAssertUtil.assertPilot(findPilot("IR016"), 0, 0, true, 0, 8);
			raceAssertUtil.assertPilot(findPilot("IR085"), 0, 0, true, 0, 8);
			raceAssertUtil.assertDone(3);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(findPilot("IR021"), 0, 0, 1);
			overallAssertUtil.assertPilot(findPilot("SCO116"), 0, 2, 2);
			overallAssertUtil.assertPilot(findPilot("IR053"), 0, 3, 3);
			overallAssertUtil.assertPilot(findPilot("IR077"), 0, 4, 4);
			overallAssertUtil.assertPilot(findPilot("SCO159"), 0, 5, 5);
			overallAssertUtil.assertPilot(findPilot("SCO808"), 0, 6, 6);
			overallAssertUtil.assertPilot(findPilot("IR016"), 0, 0, 7);
			overallAssertUtil.assertPilot(findPilot("IR023"), 0, 0, 7);
			overallAssertUtil.assertPilot(findPilot("IR085"), 0, 0, 7);
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
			Event event1 = eventDAO.find(series, "Race Event 1");
			Race race3 = raceDAO.find(event1, "Race 3");

			Scores scores = scorer.scoreRace(race3, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race3, true);
			raceAssertUtil.assertPilot(findPilot("SCO808"), 5, 1, false, 0, 1);
			raceAssertUtil.assertPilot(findPilot("SCO116"), 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(findPilot("SCO159"), 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(findPilot("IR053"), 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(findPilot("IR021"), 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(findPilot("IR077"), 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(findPilot("IR085"), 2, 0, true, 0, 7);
			raceAssertUtil.assertPilot(findPilot("IR016"), 1, 0, true, 0, 8);
			raceAssertUtil.assertPilot(findPilot("IR023"), 0, 0, true, 0, 9);
			raceAssertUtil.assertDone(3);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(findPilot("SCO808"), 1, 1, 1);
			overallAssertUtil.assertPilot(findPilot("SCO116"), 0, 2, 2);
			overallAssertUtil.assertPilot(findPilot("SCO159"), 0, 3, 3);
			overallAssertUtil.assertPilot(findPilot("IR053"), 0, 4, 4);
			overallAssertUtil.assertPilot(findPilot("IR021"), 0, 5, 5);
			overallAssertUtil.assertPilot(findPilot("IR077"), 0, 6, 6);
			overallAssertUtil.assertPilot(findPilot("IR016"), 0, 0, 7);
			overallAssertUtil.assertPilot(findPilot("IR023"), 0, 0, 7);
			overallAssertUtil.assertPilot(findPilot("IR085"), 0, 0, 7);
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
			Event event1 = eventDAO.find(series, "Race Event 1");
			Race race4 = raceDAO.find(event1, "Race 4");

			Scores scores = scorer.scoreRace(race4, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race4, true);
			raceAssertUtil.assertPilot(findPilot("IR053"), 4, 0, false, 0, 1);
			raceAssertUtil.assertPilot(findPilot("SCO116"), 4, 0, false, 2, 2);
			raceAssertUtil.assertPilot(findPilot("SCO808"), 4, 0, false, 3, 3);
			raceAssertUtil.assertPilot(findPilot("SCO159"), 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(findPilot("IR077"), 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(findPilot("IR021"), 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(findPilot("IR023"), 1, 0, true, 0, 7);
			raceAssertUtil.assertPilot(findPilot("IR016"), 0, 0, true, 0, 8);
			raceAssertUtil.assertPilot(findPilot("IR085"), 0, 0, true, 0, 8);
			raceAssertUtil.assertDone(3);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(findPilot("IR053"), 0, 0, 1);
			overallAssertUtil.assertPilot(findPilot("SCO116"), 0, 2, 2);
			overallAssertUtil.assertPilot(findPilot("SCO808"), 0, 3, 3);
			overallAssertUtil.assertPilot(findPilot("SCO159"), 0, 4, 4);
			overallAssertUtil.assertPilot(findPilot("IR077"), 0, 5, 5);
			overallAssertUtil.assertPilot(findPilot("IR021"), 0, 6, 6);
			overallAssertUtil.assertPilot(findPilot("IR016"), 0, 0, 7);
			overallAssertUtil.assertPilot(findPilot("IR023"), 0, 0, 7);
			overallAssertUtil.assertPilot(findPilot("IR085"), 0, 0, 7);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}