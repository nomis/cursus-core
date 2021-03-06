/*
	cursus - Race series management program
	Copyright 2012, 2014  Simon Arlott

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
package org.spka.cursus.test.series_2011;

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
 * Scores at the end of non-event 2 (03/12/2011 to 04/12/2011)
 */
public class Series2011NonEvent2Scores extends Series2011Event1Scores {
	@Override
	@Before
	public void createDatabase() throws Exception {
		super.createDatabase();
		createNonEvent2Data();
	}

	@Override
	@Test
	public void checkSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event nonEvent2 = eventDAO.find(series, NON_EVENT2_NAME);
			Scores scores = scorer.scoreSeries(series, getSeriesResultsPilots(series, nonEvent2), Predicates.in(getSeriesResultsPilots(series, nonEvent2)));
			checkSeriesAtNonEvent2(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Test
	public final void checkSeriesAtNonEvent2() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event1 = eventDAO.find(series, EVENT1_NAME);
			Event nonEvent2 = eventDAO.find(series, NON_EVENT2_NAME);

			List<Race> races = new ArrayList<Race>();
			races.addAll(event1.getRaces());

			Scores scores = scorer.scoreRaces(races, getSeriesResultsPilots(series, nonEvent2), getSeriesResultsEvents(series, nonEvent2),
					Predicates.in(getSeriesResultsPilots(series, nonEvent2)));
			checkSeriesAtNonEvent2(scores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	private void checkSeriesAtNonEvent2(Scores scores) throws Exception {
		Series series = seriesDAO.find(SERIES_NAME);
		Event event1 = eventDAO.find(series, EVENT1_NAME);
		Race race1 = raceDAO.find(event1, RACE1_NAME);

		Assert.assertEquals(SERIES_FLEET_AT_NON_EVENT2, scores.getPilots().size());
		Assert.assertEquals(SERIES_FLEET_AT_NON_EVENT2, scores.getFleetSize(race1));

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(sco068, 5, 0, false, 0, 1);
		race1AssertUtil.assertPilot(sco200, 5, 0, false, 2, 2);
		race1AssertUtil.assertPilot(sco179, 5, 0, false, 3, 3);
		race1AssertUtil.assertPilot(sco808, 5, 0, false, 4, 4);
		race1AssertUtil.assertPilot(sco116, 5, 0, false, 5, 5);
		race1AssertUtil.assertPilot(sco081, 5, 0, false, 6, 6);
		race1AssertUtil.assertPilot(sco136, 4, 0, false, 7, 7);
		race1AssertUtil.assertPilot(sco248, 4, 0, false, 8, 8);
		race1AssertUtil.assertPilot(sco528, 4, 0, false, 9, 9);
		race1AssertUtil.assertPilot(sco467, 4, 0, false, 10, 10);
		race1AssertUtil.assertPilot(sco159, 4, 0, false, 11, 11);
		race1AssertUtil.assertPilot(sco019, 3, 0, false, 12, 12);
		race1AssertUtil.assertPilot(sco018, 3, 0, false, 13, 13);
		race1AssertUtil.assertPilot(sco198, 3, 0, false, 14, 14);
		race1AssertUtil.assertPilot(sco087, 3, 0, false, 15, 15);
		race1AssertUtil.assertPilot(sco197, 2, 0, false, 16, 16);
		race1AssertUtil.assertPilot(sco158, 2, 0, false, 17, 17);
		race1AssertUtil.assertPilot(sco320, 1, 0, false, 18, 18);
		race1AssertUtil.assertPilot(sco249, 1, 0, false, 19, 19);
		race1AssertUtil.assertPilot(sco040, 0, 0, false, 24, 20);
		race1AssertUtil.assertPilot(sco060, 0, 0, false, 24, 20);
		race1AssertUtil.assertPilot(sco153, 0, 0, false, 24, 20);
		race1AssertUtil.assertPilot(sco156, 0, 0, false, 24, 20);
		race1AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(sco068, 0, 0, 1);
		overallAssertUtil.assertPilot(sco200, 0, 2, 2);
		overallAssertUtil.assertPilot(sco179, 0, 3, 3);
		overallAssertUtil.assertPilot(sco808, 0, 4, 4);
		overallAssertUtil.assertPilot(sco116, 0, 5, 5);
		overallAssertUtil.assertPilot(sco081, 0, 6, 6);
		overallAssertUtil.assertPilot(sco136, 0, 7, 7);
		overallAssertUtil.assertPilot(sco248, 0, 8, 8);
		overallAssertUtil.assertPilot(sco528, 0, 9, 9);
		overallAssertUtil.assertPilot(sco467, 0, 10, 10);
		overallAssertUtil.assertPilot(sco159, 0, 11, 11);
		overallAssertUtil.assertPilot(sco019, 0, 12, 12);
		overallAssertUtil.assertPilot(sco018, 1, 14, 13);
		overallAssertUtil.assertPilot(sco087, 0, 15, 14);
		overallAssertUtil.assertPilot(sco198, 2, 16, 15);
		overallAssertUtil.assertPilot(sco197, 0, 16, 16);
		overallAssertUtil.assertPilot(sco320, 0, 18, 17);
		overallAssertUtil.assertPilot(sco158, 2, 19, 18);
		overallAssertUtil.assertPilot(sco249, 0, 19, 19);
		overallAssertUtil.assertPilot(sco060, 0, 24, 20);
		overallAssertUtil.assertPilot(sco153, 0, 24, 20);
		overallAssertUtil.assertPilot(sco156, 0, 24, 20);
		overallAssertUtil.assertPilot(sco040, 1, 25, 23);
		overallAssertUtil.assertOrder();
	}

	@Test
	public final void checkNonEvent2() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event nonEvent2 = eventDAO.find(series, NON_EVENT2_NAME);
			Assert.assertEquals(0, nonEvent2.getRaces().size());

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}
}