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
package org.spka.cursus.test.series_2015;

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
 * Scores at the end of event 3 (13/02/2016 to 14/02/2016)
 */
public class Series2015Event3Scores extends Series2015Event2Scores {
	@Override
	@Before
	public void createDatabase() throws Exception {
		super.createDatabase();
		createEvent3Races();
	}

	@Override
	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, event3), Predicates.in(getSeriesResultsPilots(series, event3)));
			checkSeriesAtEvent3(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkSeriesAtEvent3() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Event event2 = eventDAO.find(series, EVENT2_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);

			List<Race> races = new ArrayList<Race>();
			races.addAll(event1.getRaces());
			races.addAll(event2.getRaces());
			races.addAll(event3.getRaces());

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, event3), getSeriesResultsEvents(series, event3),
					Predicates.in(getSeriesResultsPilots(series, event3)));
			checkSeriesAtEvent3(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	private void checkSeriesAtEvent3(Scores scores) throws Exception {
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
		Race race8 = raceDAO.find(event2, RACE8_NAME);
		Event event3 = eventDAO.find(series, EVENT3_NAME);
		Race race9 = raceDAO.find(event3, RACE9_NAME);
		Race race10 = raceDAO.find(event3, RACE10_NAME);
		Race race11 = raceDAO.find(event3, RACE11_NAME);
		Race race12 = raceDAO.find(event3, RACE12_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_EVENT3, scores.getPilots().size());

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco018, 4, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco081, 3, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco060, 1, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco153, 1, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco296, 0, 0, false, 8, 7);
		race1AssertUtil.assertPilot(sco066, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco179, 0, 0, false, 14, 8);
		race1AssertUtil.assertPilot(sco884, 0, 0, false, 14, 8);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race2AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race2AssertUtil.assertPilot(sco060, 5, 0, false, 3, 3);
		race2AssertUtil.assertPilot(sco296, 3, 0, false, 4, 4);
		race2AssertUtil.assertPilot(sco081, 2, 0, false, 5, 5);
		race2AssertUtil.assertPilot(sco018, 0, 0, false, 8, 6);
		race2AssertUtil.assertPilot(sco153, 0, 0, false, 8, 6);
		race2AssertUtil.assertPilot(sco066, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco179, 0, 0, false, 14, 8);
		race2AssertUtil.assertPilot(sco884, 0, 0, false, 14, 8);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race3AssertUtil.assertPilot(sco808, 5, 0, false, 2, 2);
		race3AssertUtil.assertPilot(sco081, 4, 0, false, 3, 3);
		race3AssertUtil.assertPilot(sco060, 3, 0, false, 4, 4);
		race3AssertUtil.assertPilot(sco296, 2, 0, false, 5, 5);
		race3AssertUtil.assertPilot(sco018, 0, 0, false, 8, 6);
		race3AssertUtil.assertPilot(sco153, 0, 0, false, 8, 6);
		race3AssertUtil.assertPilot(sco066, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco179, 0, 0, false, 14, 8);
		race3AssertUtil.assertPilot(sco884, 0, 0, false, 14, 8);
		race3AssertUtil.assertDone(0);

		RaceAssertUtil race4AssertUtil = new RaceAssertUtil(scores, race4);
		race4AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race4AssertUtil.assertPilot(sco808, 5, 0, false, 2, 2);
		race4AssertUtil.assertPilot(sco296, 2, 0, false, 3, 3);
		race4AssertUtil.assertPilot(sco081, 1, 0, false, 4, 4);
		race4AssertUtil.assertPilot(sco018, 0, 0, false, 8, 5);
		race4AssertUtil.assertPilot(sco060, 0, 0, false, 8, 5);
		race4AssertUtil.assertPilot(sco153, 0, 0, false, 8, 5);
		race4AssertUtil.assertPilot(sco066, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco087, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco156, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco159, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco179, 0, 0, false, 14, 8);
		race4AssertUtil.assertPilot(sco884, 0, 0, false, 14, 8);
		race4AssertUtil.assertDone(0);

		RaceAssertUtil race5AssertUtil = new RaceAssertUtil(scores, race5);
		race5AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race5AssertUtil.assertPilot(sco808, 7, 0, false, 2, 2);
		race5AssertUtil.assertPilot(sco087, 5, 0, false, 3, 3);
		race5AssertUtil.assertPilot(sco159, 5, 0, false, 4, 4);
		race5AssertUtil.assertPilot(sco156, 3, 0, false, 5, 5);
		race5AssertUtil.assertPilot(sco066, 3, 0, false, 6, 6);
		race5AssertUtil.assertPilot(sco018, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco060, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco081, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco153, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco179, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco296, 0, 0, false, 14, 7);
		race5AssertUtil.assertPilot(sco884, 0, 0, false, 14, 7);
		race5AssertUtil.assertDone(0);

		RaceAssertUtil race6AssertUtil = new RaceAssertUtil(scores, race6);
		race6AssertUtil.assertPilot(sco116, 8, 0, false, 0, 1);
		race6AssertUtil.assertPilot(sco808, 8, 0, false, 2, 2);
		race6AssertUtil.assertPilot(sco159, 7, 0, false, 3, 3);
		race6AssertUtil.assertPilot(sco087, 6, 0, false, 4, 4);
		race6AssertUtil.assertPilot(sco156, 5, 0, false, 5, 5);
		race6AssertUtil.assertPilot(sco066, 4, 0, false, 6, 6);
		race6AssertUtil.assertPilot(sco018, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco060, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco081, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco153, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco179, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco296, 0, 0, false, 14, 7);
		race6AssertUtil.assertPilot(sco884, 0, 0, false, 14, 7);
		race6AssertUtil.assertDone(0);

		RaceAssertUtil race7AssertUtil = new RaceAssertUtil(scores, race7);
		race7AssertUtil.assertPilot(sco116, 5, 0, false, 0, 1);
		race7AssertUtil.assertPilot(sco808, 4, 0, false, 2, 2);
		race7AssertUtil.assertPilot(sco159, 3, 0, false, 3, 3);
		race7AssertUtil.assertPilot(sco087, 2, 0, false, 4, 4);
		race7AssertUtil.assertPilot(sco066, 1, 0, false, 5, 5);
		race7AssertUtil.assertPilot(sco156, 1, 0, false, 6, 6);
		race7AssertUtil.assertPilot(sco018, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco060, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco081, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco153, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco179, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco296, 0, 0, false, 14, 7);
		race7AssertUtil.assertPilot(sco884, 0, 0, false, 14, 7);
		race7AssertUtil.assertDone(0);

		RaceAssertUtil race8AssertUtil = new RaceAssertUtil(scores, race8);
		race8AssertUtil.assertPilot(sco116, 4, 0, false, 0, 1);
		race8AssertUtil.assertPilot(sco159, 2, 0, false, 2, 2);
		race8AssertUtil.assertPilot(sco066, 1, 0, false, 3, 3);
		race8AssertUtil.assertPilot(sco087, 0, 0, false, 7, 4);
		race8AssertUtil.assertPilot(sco156, 0, 0, false, 7, 4);
		race8AssertUtil.assertPilot(sco808, 0, 0, false, 7, 4);
		race8AssertUtil.assertPilot(sco018, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco060, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco081, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco153, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco179, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco296, 0, 0, false, 14, 7);
		race8AssertUtil.assertPilot(sco884, 0, 0, false, 14, 7);
		race8AssertUtil.assertDone(0);

		RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
		race9AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
		race9AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race9AssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
		race9AssertUtil.assertPilot(sco156, 5, 0, false, 4, 4);
		race9AssertUtil.assertPilot(sco066, 5, 0, false, 5, 5);
		race9AssertUtil.assertPilot(sco884, 2, 0, false, 6, 6);
		race9AssertUtil.assertPilot(sco018, 1, 0, false, 7, 7);
		race9AssertUtil.assertPilot(sco296, 0, 0, false, 9, 8);
		race9AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race9AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race9AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race9AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race9AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race9AssertUtil.assertDone(0);

		RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
		race10AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race10AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
		race10AssertUtil.assertPilot(sco179, 5, 0, false, 3, 3);
		race10AssertUtil.assertPilot(sco156, 3, 0, false, 4, 4);
		race10AssertUtil.assertPilot(sco884, 2, 0, false, 5, 5);
		race10AssertUtil.assertPilot(sco066, 2, 0, false, 6, 6);
		race10AssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
		race10AssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
		race10AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race10AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race10AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race10AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race10AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race10AssertUtil.assertDone(0);

		RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
		race11AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
		race11AssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
		race11AssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
		race11AssertUtil.assertPilot(sco066, 3, 0, false, 4, 4);
		race11AssertUtil.assertPilot(sco884, 2, 0, false, 5, 5);
		race11AssertUtil.assertPilot(sco156, 2, 0, false, 6, 6);
		race11AssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
		race11AssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
		race11AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race11AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race11AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race11AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race11AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race11AssertUtil.assertDone(0);

		RaceAssertUtil race12AssertUtil = new RaceAssertUtil(scores, race12);
		race12AssertUtil.assertPilot(sco116, 5, 0, false, 0, 1);
		race12AssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
		race12AssertUtil.assertPilot(sco808, 4, 0, false, 3, 3);
		race12AssertUtil.assertPilot(sco156, 4, 0, false, 4, 4);
		race12AssertUtil.assertPilot(sco066, 3, 0, false, 5, 5);
		race12AssertUtil.assertPilot(sco884, 2, 0, false, 6, 6);
		race12AssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
		race12AssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
		race12AssertUtil.assertPilot(sco060, 0, 0, false, 14, 9);
		race12AssertUtil.assertPilot(sco081, 0, 0, false, 14, 9);
		race12AssertUtil.assertPilot(sco087, 0, 0, false, 14, 9);
		race12AssertUtil.assertPilot(sco153, 0, 0, false, 14, 9);
		race12AssertUtil.assertPilot(sco159, 0, 0, false, 14, 9);
		race12AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco116, 0, 0, 1, 0, 0, 0);
		overallAssertUtil.assertPilot(sco808, 0, 18, 2, 7, 3, 3);
		overallAssertUtil.assertPilot(sco066, 0, 54, 3, 14, 14, 14);
		overallAssertUtil.assertPilot(sco156, 0, 55, 4, 14, 14, 14);
		overallAssertUtil.assertPilot(sco296, 0, 64, 5, 14, 14, 14);
		overallAssertUtil.assertPilot(sco018, 0, 75, 6, 14, 14, 14);
		overallAssertUtil.assertPilot(sco179, 0, 80, 7, 14, 14, 14);
		overallAssertUtil.assertPilot(sco159, 0, 82, 8, 14, 14, 14);
		overallAssertUtil.assertPilot(sco081, 0, 86, 9, 14, 14, 14);
		overallAssertUtil.assertPilot(sco087, 0, 88, 10, 14, 14, 14);
		overallAssertUtil.assertPilot(sco060, 0, 90, 11, 14, 14, 14);
		overallAssertUtil.assertPilot(sco884, 0, 92, 12, 14, 14, 14);
		overallAssertUtil.assertPilot(sco153, 0, 100, 13, 14, 14, 14);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkEvent3() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Race race9 = raceDAO.find(event3, RACE9_NAME);
			Race race10 = raceDAO.find(event3, RACE10_NAME);
			Race race11 = raceDAO.find(event3, RACE11_NAME);
			Race race12 = raceDAO.find(event3, RACE12_NAME);

			Scores scores = scorer.scoreEvent(event3, Predicates.in(getEventResultsPilots(series, event3)));
			Assert.assertEquals(EVENT3_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT3_FLEET, scores.getFleetSize(race9));
			Assert.assertEquals(EVENT3_FLEET, scores.getFleetSize(race10));
			Assert.assertEquals(EVENT3_FLEET, scores.getFleetSize(race11));
			Assert.assertEquals(EVENT3_FLEET, scores.getFleetSize(race12));

			RaceAssertUtil race9AssertUtil = new RaceAssertUtil(scores, race9);
			race9AssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			race9AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
			race9AssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
			race9AssertUtil.assertPilot(sco156, 5, 0, false, 4, 4);
			race9AssertUtil.assertPilot(sco066, 5, 0, false, 5, 5);
			race9AssertUtil.assertPilot(sco884, 2, 0, false, 6, 6);
			race9AssertUtil.assertPilot(sco018, 1, 0, false, 7, 7);
			race9AssertUtil.assertPilot(sco296, 0, 0, false, 9, 8);
			race9AssertUtil.assertDone(0);

			RaceAssertUtil race10AssertUtil = new RaceAssertUtil(scores, race10);
			race10AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			race10AssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
			race10AssertUtil.assertPilot(sco179, 5, 0, false, 3, 3);
			race10AssertUtil.assertPilot(sco156, 3, 0, false, 4, 4);
			race10AssertUtil.assertPilot(sco884, 2, 0, false, 5, 5);
			race10AssertUtil.assertPilot(sco066, 2, 0, false, 6, 6);
			race10AssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
			race10AssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
			race10AssertUtil.assertDone(0);

			RaceAssertUtil race11AssertUtil = new RaceAssertUtil(scores, race11);
			race11AssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			race11AssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
			race11AssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
			race11AssertUtil.assertPilot(sco066, 3, 0, false, 4, 4);
			race11AssertUtil.assertPilot(sco884, 2, 0, false, 5, 5);
			race11AssertUtil.assertPilot(sco156, 2, 0, false, 6, 6);
			race11AssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
			race11AssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
			race11AssertUtil.assertDone(0);

			RaceAssertUtil race12AssertUtil = new RaceAssertUtil(scores, race12);
			race12AssertUtil.assertPilot(sco116, 5, 0, false, 0, 1);
			race12AssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
			race12AssertUtil.assertPilot(sco808, 4, 0, false, 3, 3);
			race12AssertUtil.assertPilot(sco156, 4, 0, false, 4, 4);
			race12AssertUtil.assertPilot(sco066, 3, 0, false, 5, 5);
			race12AssertUtil.assertPilot(sco884, 2, 0, false, 6, 6);
			race12AssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
			race12AssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
			race12AssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1, 0);
			overallAssertUtil.assertPilot(sco179, 0, 7, 2, 3);
			overallAssertUtil.assertPilot(sco808, 0, 7, 2, 3);
			overallAssertUtil.assertPilot(sco156, 0, 12, 4, 6);
			overallAssertUtil.assertPilot(sco066, 0, 14, 5, 6);
			overallAssertUtil.assertPilot(sco884, 0, 16, 6, 6);
			overallAssertUtil.assertPilot(sco296, 0, 21, 7, 9);
			overallAssertUtil.assertPilot(sco018, 0, 25, 8, 9);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace9() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Race race9 = raceDAO.find(event3, RACE9_NAME);

			Scores scores = scorer.scoreRace(race9, Predicates.in(getEventResultsPilots(series, event3)));
			Assert.assertEquals(EVENT3_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT3_FLEET, scores.getFleetSize(race9));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race9);
			raceAssertUtil.assertPilot(sco116, 7, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 6, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco156, 5, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco066, 5, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco884, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco018, 1, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco296, 0, 0, false, 9, 8);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(sco156, 0, 4, 4);
			overallAssertUtil.assertPilot(sco066, 0, 5, 5);
			overallAssertUtil.assertPilot(sco884, 0, 6, 6);
			overallAssertUtil.assertPilot(sco018, 0, 7, 7);
			overallAssertUtil.assertPilot(sco296, 0, 9, 8);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace10() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Race race10 = raceDAO.find(event3, RACE10_NAME);

			Scores scores = scorer.scoreRace(race10, Predicates.in(getEventResultsPilots(series, event3)));
			Assert.assertEquals(EVENT3_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT3_FLEET, scores.getFleetSize(race10));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race10);
			raceAssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco808, 6, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco179, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco156, 3, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco884, 2, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco066, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco296, 2, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco808, 0, 2, 2);
			overallAssertUtil.assertPilot(sco179, 0, 3, 3);
			overallAssertUtil.assertPilot(sco156, 0, 4, 4);
			overallAssertUtil.assertPilot(sco884, 0, 5, 5);
			overallAssertUtil.assertPilot(sco066, 0, 6, 6);
			overallAssertUtil.assertPilot(sco296, 0, 7, 7);
			overallAssertUtil.assertPilot(sco018, 0, 9, 8);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace11() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Race race11 = raceDAO.find(event3, RACE11_NAME);

			Scores scores = scorer.scoreRace(race11, Predicates.in(getEventResultsPilots(series, event3)));
			Assert.assertEquals(EVENT3_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT3_FLEET, scores.getFleetSize(race11));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race11);
			raceAssertUtil.assertPilot(sco116, 6, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 5, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco066, 3, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco884, 2, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco156, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco179, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(sco066, 0, 4, 4);
			overallAssertUtil.assertPilot(sco884, 0, 5, 5);
			overallAssertUtil.assertPilot(sco156, 0, 6, 6);
			overallAssertUtil.assertPilot(sco296, 0, 7, 7);
			overallAssertUtil.assertPilot(sco018, 0, 9, 8);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkRace12() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event3 = eventDAO.find(series, EVENT3_NAME);
			Race race12 = raceDAO.find(event3, RACE12_NAME);

			Scores scores = scorer.scoreRace(race12, Predicates.in(getEventResultsPilots(series, event3)));
			Assert.assertEquals(EVENT3_FLEET, scores.getPilots().size());
			Assert.assertEquals(EVENT3_FLEET, scores.getFleetSize(race12));

			RaceAssertUtil raceAssertUtil = new RaceAssertUtil(scores, race12);
			raceAssertUtil.assertPilot(sco116, 5, 0, false, 0, 1);
			raceAssertUtil.assertPilot(sco179, 5, 0, false, 2, 2);
			raceAssertUtil.assertPilot(sco808, 4, 0, false, 3, 3);
			raceAssertUtil.assertPilot(sco156, 4, 0, false, 4, 4);
			raceAssertUtil.assertPilot(sco066, 3, 0, false, 5, 5);
			raceAssertUtil.assertPilot(sco884, 2, 0, false, 6, 6);
			raceAssertUtil.assertPilot(sco296, 1, 0, false, 7, 7);
			raceAssertUtil.assertPilot(sco018, 0, 0, false, 9, 8);
			raceAssertUtil.assertDone(0);

			OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
			overallAssertUtil.assertPilot(sco116, 0, 0, 1);
			overallAssertUtil.assertPilot(sco179, 0, 2, 2);
			overallAssertUtil.assertPilot(sco808, 0, 3, 3);
			overallAssertUtil.assertPilot(sco156, 0, 4, 4);
			overallAssertUtil.assertPilot(sco066, 0, 5, 5);
			overallAssertUtil.assertPilot(sco884, 0, 6, 6);
			overallAssertUtil.assertPilot(sco296, 0, 7, 7);
			overallAssertUtil.assertPilot(sco018, 0, 9, 8);
			overallAssertUtil.assertOrder();

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}