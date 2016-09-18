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
package org.spka.cursus.test.cc_2013;

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
 * Scores at the end of event 1 (25/05/2013 to 26/05/2013)
 */
public class Series2013Event1Scores extends CCSeries2013 {
	public Series2013Event1Scores() {
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
		Race race6 = raceDAO.find(event1, RACE6_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT1, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race1AssertUtil.assertPilot(ir181, 7, 0, false, 2, 2);
		race1AssertUtil.assertPilot(ir027, 6, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco159, 6, 1, false, 5, 5);
		race1AssertUtil.assertPilot(sco666, 5, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco808, 5, 0, false, 7, 7);
		race1AssertUtil.assertPilot(ir085, 5, 0, false, 8, 8);
		race1AssertUtil.assertPilot(ir014, 4, 1, false, 9, 9);
		race1AssertUtil.assertPilot(sco153, 4, 0, false, 10, 10);
		race1AssertUtil.assertPilot(ir053, 3, 0, false, 11, 11);
		race1AssertUtil.assertPilot(ir077, 2, 0, false, 12, 12);
		race1AssertUtil.assertPilot(ir016, 2, 0, false, 13, 13);
		race1AssertUtil.assertPilot(ir025, 2, 0, false, 14, 14);
		race1AssertUtil.assertPilot(sco060, 1, 0, false, 15, 15);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(ir014, 5, 0, false, 0, 1);
		race2AssertUtil.assertPilot(ir027, 5, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco528, 5, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
		race2AssertUtil.assertPilot(ir085, 5, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco116, 4, 0, false, 6, 6);
		race2AssertUtil.assertPilot(sco666, 4, 0, false, 7, 7);
		race2AssertUtil.assertPilot(ir053, 4, 0, false, 8, 8);
		race2AssertUtil.assertPilot(ir025, 4, 0, false, 9, 9);
		race2AssertUtil.assertPilot(ir077, 4, 0, false, 10, 10);
		race2AssertUtil.assertPilot(sco159, 4, 0, false, 11, 11);
		race2AssertUtil.assertPilot(ir016, 3, 1, false, 12, 12);
		race2AssertUtil.assertPilot(sco153, 2, 0, false, 13, 13);
		race2AssertUtil.assertPilot(ir181, 0, 0, false, 16, 14);
		race2AssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(ir181, 5, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco159, 4, 0, false, 3, 2);
		race3AssertUtil.assertPilot(sco808, 4, 0, false, 4, 3);
		race3AssertUtil.assertPilot(ir027, 5, 3, false, 2, 4);
		race3AssertUtil.assertPilot(sco528, 4, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco116, 4, 0, false, 6, 6);
		race3AssertUtil.assertPilot(ir085, 4, 0, false, 7, 7);
		race3AssertUtil.assertPilot(ir014, 3, 0, false, 8, 8);
		race3AssertUtil.assertPilot(sco666, 3, 0, false, 9, 9);
		race3AssertUtil.assertPilot(ir025, 3, 0, false, 10, 10);
		race3AssertUtil.assertPilot(ir016, 3, 0, false, 11, 11);
		race3AssertUtil.assertPilot(ir077, 2, 0, false, 12, 12);
		race3AssertUtil.assertPilot(ir053, 2, 0, false, 13, 13);
		race3AssertUtil.assertPilot(sco153, 1, 0, false, 14, 14);
		race3AssertUtil.assertPilot(sco060, 0, 0, false, 16, 15);
		race3AssertUtil.assertDone(0);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(ir181, 4, 0, false, 0, 1);
		race4AssertUtil.assertPilot(ir027, 4, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco159, 3, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco808, 3, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco528, 3, 0, false, 5, 5);
		race4AssertUtil.assertPilot(ir085, 3, 0, false, 6, 6);
		race4AssertUtil.assertPilot(ir025, 3, 0, false, 7, 7);
		race4AssertUtil.assertPilot(ir077, 3, 0, false, 8, 8);
		race4AssertUtil.assertPilot(ir014, 2, 0, false, 9, 9);
		race4AssertUtil.assertPilot(sco666, 2, 0, false, 10, 10);
		race4AssertUtil.assertPilot(ir053, 2, 0, false, 12, 11);
		race4AssertUtil.assertPilot(ir016, 2, 2, false, 11, 12);
		race4AssertUtil.assertPilot(sco116, 1, 0, false, 13, 13);
		race4AssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
		race4AssertUtil.assertPilot(sco153, 0, 0, false, 16, 14);
		race4AssertUtil.assertDone(0);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco116, 7, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
		race5AssertUtil.assertPilot(ir014, 7, 0, false, 4, 4);
		race5AssertUtil.assertPilot(ir025, 6, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
		race5AssertUtil.assertPilot(ir085, 5, 1, false, 7, 7);
		race5AssertUtil.assertPilot(sco528, 5, 0, false, 8, 8);
		race5AssertUtil.assertPilot(ir077, 4, 0, false, 9, 9);
		race5AssertUtil.assertPilot(ir053, 3, 0, false, 10, 10);
		race5AssertUtil.assertPilot(sco666, 2, 0, false, 11, 11);
		race5AssertUtil.assertPilot(ir027, 1, 0, false, 12, 12);
		race5AssertUtil.assertPilot(ir016, 1, 0, false, 13, 13);
		race5AssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
		race5AssertUtil.assertPilot(sco153, 0, 0, false, 16, 14);
		race5AssertUtil.assertDone(0);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race6AssertUtil.assertPilot(ir025, 7, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco528, 6, 0, false, 4, 3);
		race6AssertUtil.assertPilot(ir014, 6, 2, false, 3, 4);
		race6AssertUtil.assertPilot(sco808, 6, 1, false, 5, 5);
		race6AssertUtil.assertPilot(ir027, 6, 0, false, 6, 6);
		race6AssertUtil.assertPilot(ir016, 4, 0, false, 7, 7);
		race6AssertUtil.assertPilot(sco159, 4, 0, false, 8, 8);
		race6AssertUtil.assertPilot(ir053, 3, 0, false, 9, 9);
		race6AssertUtil.assertPilot(ir181, 3, 0, false, 10, 10);
		race6AssertUtil.assertPilot(ir085, 3, 0, false, 11, 11);
		race6AssertUtil.assertPilot(ir077, 2, 0, false, 12, 12);
		race6AssertUtil.assertPilot(sco153, 1, 0, false, 13, 13);
		race6AssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
		race6AssertUtil.assertPilot(sco666, 0, 0, false, 16, 14);
		race6AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(ir181, 0, 12, 1, 16);
		overallAssertUtil.assertPilot(sco116, 0, 14, 2, 13);
		overallAssertUtil.assertPilot(ir027, 3, 18, 3, 12);
		overallAssertUtil.assertPilot(sco808, 1, 21, 4, 7);
		overallAssertUtil.assertPilot(sco528, 0, 21, 5, 8);
		overallAssertUtil.assertPilot(sco159, 1, 26, 6, 11);
		overallAssertUtil.assertPilot(ir014, 3, 27, 7, 9);
		overallAssertUtil.assertPilot(ir025, 0, 33, 8, 14);
		overallAssertUtil.assertPilot(ir085, 1, 34, 9, 11);
		overallAssertUtil.assertPilot(sco666, 0, 43, 10, 16);
		overallAssertUtil.assertPilot(ir053, 0, 50, 11, 13);
		overallAssertUtil.assertPilot(ir077, 0, 51, 12, 12);
		overallAssertUtil.assertPilot(ir016, 3, 57, 13, 13);
		overallAssertUtil.assertPilot(sco153, 0, 66, 14, 16);
		overallAssertUtil.assertPilot(sco060, 0, 79, 15, 16);
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
			Race race6 = raceDAO.find(event1, RACE6_NAME);

			Scores scores = scorer.scoreEvent(event1, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
			race1AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			race1AssertUtil.assertPilot(ir181, 7, 0, false, 2, 2);
			race1AssertUtil.assertPilot(ir027, 6, 0, false, 3, 3);
			race1AssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
			race1AssertUtil.assertPilot(sco159, 6, 1, false, 5, 5);
			race1AssertUtil.assertPilot(sco666, 5, 0, false, 6, 6);
			race1AssertUtil.assertPilot(sco808, 5, 0, false, 7, 7);
			race1AssertUtil.assertPilot(ir085, 5, 0, false, 8, 8);
			race1AssertUtil.assertPilot(ir014, 4, 1, false, 9, 9);
			race1AssertUtil.assertPilot(sco153, 4, 0, false, 10, 10);
			race1AssertUtil.assertPilot(ir053, 3, 0, false, 11, 11);
			race1AssertUtil.assertPilot(ir077, 2, 0, false, 12, 12);
			race1AssertUtil.assertPilot(ir016, 2, 0, false, 13, 13);
			race1AssertUtil.assertPilot(ir025, 2, 0, false, 14, 14);
			race1AssertUtil.assertPilot(sco060, 1, 0, false, 15, 15);
			race1AssertUtil.assertDone(0);

			RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
			race2AssertUtil.assertPilot(ir014, 5, 0, false, 0, 1);
			race2AssertUtil.assertPilot(ir027, 5, 0, false, 2, 2);
			race2AssertUtil.assertPilot(sco528, 5, 0, false, 3, 3);
			race2AssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
			race2AssertUtil.assertPilot(ir085, 5, 0, false, 5, 5);
			race2AssertUtil.assertPilot(sco116, 4, 0, false, 6, 6);
			race2AssertUtil.assertPilot(sco666, 4, 0, false, 7, 7);
			race2AssertUtil.assertPilot(ir053, 4, 0, false, 8, 8);
			race2AssertUtil.assertPilot(ir025, 4, 0, false, 9, 9);
			race2AssertUtil.assertPilot(ir077, 4, 0, false, 10, 10);
			race2AssertUtil.assertPilot(sco159, 4, 0, false, 11, 11);
			race2AssertUtil.assertPilot(ir016, 3, 1, false, 12, 12);
			race2AssertUtil.assertPilot(sco153, 2, 0, false, 13, 13);
			race2AssertUtil.assertPilot(ir181, 0, 0, false, 16, 14);
			race2AssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
			race2AssertUtil.assertDone(0);

			RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
			race3AssertUtil.assertPilot(ir181, 5, 0, false, 0, 1);
			race3AssertUtil.assertPilot(sco159, 4, 0, false, 3, 2);
			race3AssertUtil.assertPilot(sco808, 4, 0, false, 4, 3);
			race3AssertUtil.assertPilot(ir027, 5, 3, false, 2, 4);
			race3AssertUtil.assertPilot(sco528, 4, 0, false, 5, 5);
			race3AssertUtil.assertPilot(sco116, 4, 0, false, 6, 6);
			race3AssertUtil.assertPilot(ir085, 4, 0, false, 7, 7);
			race3AssertUtil.assertPilot(ir014, 3, 0, false, 8, 8);
			race3AssertUtil.assertPilot(sco666, 3, 0, false, 9, 9);
			race3AssertUtil.assertPilot(ir025, 3, 0, false, 10, 10);
			race3AssertUtil.assertPilot(ir016, 3, 0, false, 11, 11);
			race3AssertUtil.assertPilot(ir077, 2, 0, false, 12, 12);
			race3AssertUtil.assertPilot(ir053, 2, 0, false, 13, 13);
			race3AssertUtil.assertPilot(sco153, 1, 0, false, 14, 14);
			race3AssertUtil.assertPilot(sco060, 0, 0, false, 16, 15);
			race3AssertUtil.assertDone(0);

			RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
			race4AssertUtil.assertPilot(ir181, 4, 0, false, 0, 1);
			race4AssertUtil.assertPilot(ir027, 4, 0, false, 2, 2);
			race4AssertUtil.assertPilot(sco159, 3, 0, false, 3, 3);
			race4AssertUtil.assertPilot(sco808, 3, 0, false, 4, 4);
			race4AssertUtil.assertPilot(sco528, 3, 0, false, 5, 5);
			race4AssertUtil.assertPilot(ir085, 3, 0, false, 6, 6);
			race4AssertUtil.assertPilot(ir025, 3, 0, false, 7, 7);
			race4AssertUtil.assertPilot(ir077, 3, 0, false, 8, 8);
			race4AssertUtil.assertPilot(ir014, 2, 0, false, 9, 9);
			race4AssertUtil.assertPilot(sco666, 2, 0, false, 10, 10);
			race4AssertUtil.assertPilot(ir053, 2, 0, false, 12, 11);
			race4AssertUtil.assertPilot(ir016, 2, 2, false, 11, 12);
			race4AssertUtil.assertPilot(sco116, 1, 0, false, 13, 13);
			race4AssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
			race4AssertUtil.assertPilot(sco153, 0, 0, false, 16, 14);
			race4AssertUtil.assertDone(0);

			RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
			race5AssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
			race5AssertUtil.assertPilot(sco116, 7, 0, false, 2, 2);
			race5AssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
			race5AssertUtil.assertPilot(ir014, 7, 0, false, 4, 4);
			race5AssertUtil.assertPilot(ir025, 6, 0, false, 5, 5);
			race5AssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
			race5AssertUtil.assertPilot(ir085, 5, 1, false, 7, 7);
			race5AssertUtil.assertPilot(sco528, 5, 0, false, 8, 8);
			race5AssertUtil.assertPilot(ir077, 4, 0, false, 9, 9);
			race5AssertUtil.assertPilot(ir053, 3, 0, false, 10, 10);
			race5AssertUtil.assertPilot(sco666, 2, 0, false, 11, 11);
			race5AssertUtil.assertPilot(ir027, 1, 0, false, 12, 12);
			race5AssertUtil.assertPilot(ir016, 1, 0, false, 13, 13);
			race5AssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
			race5AssertUtil.assertPilot(sco153, 0, 0, false, 16, 14);
			race5AssertUtil.assertDone(0);

			RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
			race6AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			race6AssertUtil.assertPilot(ir025, 7, 0, false, 2, 2);
			race6AssertUtil.assertPilot(sco528, 6, 0, false, 4, 3);
			race6AssertUtil.assertPilot(ir014, 6, 2, false, 3, 4);
			race6AssertUtil.assertPilot(sco808, 6, 1, false, 5, 5);
			race6AssertUtil.assertPilot(ir027, 6, 0, false, 6, 6);
			race6AssertUtil.assertPilot(ir016, 4, 0, false, 7, 7);
			race6AssertUtil.assertPilot(sco159, 4, 0, false, 8, 8);
			race6AssertUtil.assertPilot(ir053, 3, 0, false, 9, 9);
			race6AssertUtil.assertPilot(ir181, 3, 0, false, 10, 10);
			race6AssertUtil.assertPilot(ir085, 3, 0, false, 11, 11);
			race6AssertUtil.assertPilot(ir077, 2, 0, false, 12, 12);
			race6AssertUtil.assertPilot(sco153, 1, 0, false, 13, 13);
			race6AssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
			race6AssertUtil.assertPilot(sco666, 0, 0, false, 16, 14);
			race6AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir181, 0, 12, 1, 16);
			overallAssertUtil.assertPilot(sco116, 0, 14, 2, 13);
			overallAssertUtil.assertPilot(ir027, 3, 18, 3, 12);
			overallAssertUtil.assertPilot(sco808, 1, 21, 4, 7);
			overallAssertUtil.assertPilot(sco528, 0, 21, 5, 8);
			overallAssertUtil.assertPilot(sco159, 1, 26, 6, 11);
			overallAssertUtil.assertPilot(ir014, 3, 27, 7, 9);
			overallAssertUtil.assertPilot(ir025, 0, 33, 8, 14);
			overallAssertUtil.assertPilot(ir085, 1, 34, 9, 11);
			overallAssertUtil.assertPilot(sco666, 0, 43, 10, 16);
			overallAssertUtil.assertPilot(ir053, 0, 50, 11, 13);
			overallAssertUtil.assertPilot(ir077, 0, 51, 12, 12);
			overallAssertUtil.assertPilot(ir016, 3, 57, 13, 13);
			overallAssertUtil.assertPilot(sco153, 0, 66, 14, 16);
			overallAssertUtil.assertPilot(sco060, 0, 79, 15, 16);
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
			raceAssertUtil.assertPilot(ir181, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(ir027, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco528, 6, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco159, 6, 1, false, 5, 5);
			raceAssertUtil.assertPilot(sco666, 5, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco808, 5, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir085, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir014, 4, 1, false, 9, 9);
			raceAssertUtil.assertPilot(sco153, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(ir053, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir077, 2, 0, false, 12, 12);
			raceAssertUtil.assertPilot(ir016, 2, 0, false, 13, 13);
			raceAssertUtil.assertPilot(ir025, 2, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco060, 1, 0, false, 15, 15);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(ir181, 0, 2, 2);
			overallAssertUtil.assertPilot(ir027, 0, 3, 3);
			overallAssertUtil.assertPilot(sco528, 0, 4, 4);
			overallAssertUtil.assertPilot(sco159, 1, 6, 5);
			overallAssertUtil.assertPilot(sco666, 0, 6, 6);
			overallAssertUtil.assertPilot(sco808, 0, 7, 7);
			overallAssertUtil.assertPilot(ir085, 0, 8, 8);
			overallAssertUtil.assertPilot(ir014, 1, 10, 9);
			overallAssertUtil.assertPilot(sco153, 0, 10, 10);
			overallAssertUtil.assertPilot(ir053, 0, 11, 11);
			overallAssertUtil.assertPilot(ir077, 0, 12, 12);
			overallAssertUtil.assertPilot(ir016, 0, 13, 13);
			overallAssertUtil.assertPilot(ir025, 0, 14, 14);
			overallAssertUtil.assertPilot(sco060, 0, 15, 15);
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
			raceAssertUtil.assertPilot(ir014, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir027, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco528, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir085, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco116, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco666, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir053, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir025, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir077, 4, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir016, 3, 1, false, 12, 12);
			raceAssertUtil.assertPilot(sco153, 2, 0, false, 13, 13);
			raceAssertUtil.assertPilot(ir181, 0, 0, false, 16, 14);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir014, 0, 0, 1);
			overallAssertUtil.assertPilot(ir027, 0, 2, 2);
			overallAssertUtil.assertPilot(sco528, 0, 3, 3);
			overallAssertUtil.assertPilot(sco808, 0, 4, 4);
			overallAssertUtil.assertPilot(ir085, 0, 5, 5);
			overallAssertUtil.assertPilot(sco116, 0, 6, 6);
			overallAssertUtil.assertPilot(sco666, 0, 7, 7);
			overallAssertUtil.assertPilot(ir053, 0, 8, 8);
			overallAssertUtil.assertPilot(ir025, 0, 9, 9);
			overallAssertUtil.assertPilot(ir077, 0, 10, 10);
			overallAssertUtil.assertPilot(sco159, 0, 11, 11);
			overallAssertUtil.assertPilot(ir016, 1, 13, 12);
			overallAssertUtil.assertPilot(sco153, 0, 13, 13);
			overallAssertUtil.assertPilot(ir181, 0, 16, 14);
			overallAssertUtil.assertPilot(sco060, 0, 16, 14);
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
			raceAssertUtil.assertPilot(ir181, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 3, 2);
			raceAssertUtil.assertPilot(sco808, 4, 0, false, 4, 3);
			raceAssertUtil.assertPilot(ir027, 5, 3, false, 2, 4);
			raceAssertUtil.assertPilot(sco528, 4, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco116, 4, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir085, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir014, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(sco666, 3, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir025, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(ir016, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir077, 2, 0, false, 12, 12);
			raceAssertUtil.assertPilot(ir053, 2, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco153, 1, 0, false, 14, 14);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 16, 15);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir181, 0, 0, 1);
			overallAssertUtil.assertPilot(sco159, 0, 3, 2);
			overallAssertUtil.assertPilot(sco808, 0, 4, 3);
			overallAssertUtil.assertPilot(ir027, 3, 5, 4);
			overallAssertUtil.assertPilot(sco528, 0, 5, 5);
			overallAssertUtil.assertPilot(sco116, 0, 6, 6);
			overallAssertUtil.assertPilot(ir085, 0, 7, 7);
			overallAssertUtil.assertPilot(ir014, 0, 8, 8);
			overallAssertUtil.assertPilot(sco666, 0, 9, 9);
			overallAssertUtil.assertPilot(ir025, 0, 10, 10);
			overallAssertUtil.assertPilot(ir016, 0, 11, 11);
			overallAssertUtil.assertPilot(ir077, 0, 12, 12);
			overallAssertUtil.assertPilot(ir053, 0, 13, 13);
			overallAssertUtil.assertPilot(sco153, 0, 14, 14);
			overallAssertUtil.assertPilot(sco060, 0, 16, 15);
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
			raceAssertUtil.assertPilot(ir181, 4, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir027, 4, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco159, 3, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco808, 3, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco528, 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(ir085, 3, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir025, 3, 0, false, 7, 7);
			raceAssertUtil.assertPilot(ir077, 3, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir014, 2, 0, false, 9, 9);
			raceAssertUtil.assertPilot(sco666, 2, 0, false, 10, 10);
			raceAssertUtil.assertPilot(ir053, 2, 0, false, 12, 11);
			raceAssertUtil.assertPilot(ir016, 2, 2, false, 11, 12);
			raceAssertUtil.assertPilot(sco116, 1, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
			raceAssertUtil.assertPilot(sco153, 0, 0, false, 16, 14);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir181, 0, 0, 1);
			overallAssertUtil.assertPilot(ir027, 0, 2, 2);
			overallAssertUtil.assertPilot(sco159, 0, 3, 3);
			overallAssertUtil.assertPilot(sco808, 0, 4, 4);
			overallAssertUtil.assertPilot(sco528, 0, 5, 5);
			overallAssertUtil.assertPilot(ir085, 0, 6, 6);
			overallAssertUtil.assertPilot(ir025, 0, 7, 7);
			overallAssertUtil.assertPilot(ir077, 0, 8, 8);
			overallAssertUtil.assertPilot(ir014, 0, 9, 9);
			overallAssertUtil.assertPilot(sco666, 0, 10, 10);
			overallAssertUtil.assertPilot(ir053, 0, 12, 11);
			overallAssertUtil.assertPilot(ir016, 2, 13, 12);
			overallAssertUtil.assertPilot(sco116, 0, 13, 13);
			overallAssertUtil.assertPilot(sco060, 0, 16, 14);
			overallAssertUtil.assertPilot(sco153, 0, 16, 14);
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

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race5);
			raceAssertUtil.assertPilot(ir181, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 7, 0, false, 3, 3);
			raceAssertUtil.assertPilot(ir014, 7, 0, false, 4, 4);
			raceAssertUtil.assertPilot(ir025, 6, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco159, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir085, 5, 1, false, 7, 7);
			raceAssertUtil.assertPilot(sco528, 5, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir077, 4, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir053, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(sco666, 2, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir027, 1, 0, false, 12, 12);
			raceAssertUtil.assertPilot(ir016, 1, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
			raceAssertUtil.assertPilot(sco153, 0, 0, false, 16, 14);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(ir181, 0, 0, 1);
			overallAssertUtil.assertPilot(sco116, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(ir014, 0, 4, 4);
			overallAssertUtil.assertPilot(ir025, 0, 5, 5);
			overallAssertUtil.assertPilot(sco159, 0, 6, 6);
			overallAssertUtil.assertPilot(ir085, 1, 8, 7);
			overallAssertUtil.assertPilot(sco528, 0, 8, 8);
			overallAssertUtil.assertPilot(ir077, 0, 9, 9);
			overallAssertUtil.assertPilot(ir053, 0, 10, 10);
			overallAssertUtil.assertPilot(sco666, 0, 11, 11);
			overallAssertUtil.assertPilot(ir027, 0, 12, 12);
			overallAssertUtil.assertPilot(ir016, 0, 13, 13);
			overallAssertUtil.assertPilot(sco060, 0, 16, 14);
			overallAssertUtil.assertPilot(sco153, 0, 16, 14);
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
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Race race6 = raceDAO.find(event1, RACE6_NAME);

			Scores scores = scorer.scoreRace(race6, Predicates.in(getEventResultsPilots(series, event1)));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race6);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(ir025, 7, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco528, 6, 0, false, 4, 3);
			raceAssertUtil.assertPilot(ir014, 6, 2, false, 3, 4);
			raceAssertUtil.assertPilot(sco808, 6, 1, false, 5, 5);
			raceAssertUtil.assertPilot(ir027, 6, 0, false, 6, 6);
			raceAssertUtil.assertPilot(ir016, 4, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco159, 4, 0, false, 8, 8);
			raceAssertUtil.assertPilot(ir053, 3, 0, false, 9, 9);
			raceAssertUtil.assertPilot(ir181, 3, 0, false, 10, 10);
			raceAssertUtil.assertPilot(ir085, 3, 0, false, 11, 11);
			raceAssertUtil.assertPilot(ir077, 2, 0, false, 12, 12);
			raceAssertUtil.assertPilot(sco153, 1, 0, false, 13, 13);
			raceAssertUtil.assertPilot(sco060, 0, 0, false, 16, 14);
			raceAssertUtil.assertPilot(sco666, 0, 0, false, 16, 14);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(ir025, 0, 2, 2);
			overallAssertUtil.assertPilot(sco528, 0, 4, 3);
			overallAssertUtil.assertPilot(ir014, 2, 5, 4);
			overallAssertUtil.assertPilot(sco808, 1, 6, 5);
			overallAssertUtil.assertPilot(ir027, 0, 6, 6);
			overallAssertUtil.assertPilot(ir016, 0, 7, 7);
			overallAssertUtil.assertPilot(sco159, 0, 8, 8);
			overallAssertUtil.assertPilot(ir053, 0, 9, 9);
			overallAssertUtil.assertPilot(ir181, 0, 10, 10);
			overallAssertUtil.assertPilot(ir085, 0, 11, 11);
			overallAssertUtil.assertPilot(ir077, 0, 12, 12);
			overallAssertUtil.assertPilot(sco153, 0, 13, 13);
			overallAssertUtil.assertPilot(sco060, 0, 16, 14);
			overallAssertUtil.assertPilot(sco666, 0, 16, 14);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}