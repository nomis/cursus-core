/*
	cursus - Race series management program
	Copyright 2012-2014  Simon Arlott

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
package uk.uuid.cursus.test.scoring;

import org.junit.Test;

import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.RaceAttendee;
import uk.uuid.cursus.db.data.RaceTally;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.scorer.Scorer;
import uk.uuid.cursus.scoring.scorer.ScorerFactory;
import uk.uuid.cursus.test.util.OverallAssertUtil;
import uk.uuid.cursus.test.util.RaceAssertUtil;

public class BasicRaceTest {
	@Test
	public void score1Race() throws Exception {
		Series series = new Series("Series 1"); //$NON-NLS-1$
		Event event = new Event(series, "Event"); //$NON-NLS-1$
		series.getEvents().add(event);
		Race race1 = new Race(event, "Race 1"); //$NON-NLS-1$
		event.getRaces().add(race1);

		Pilot pilot1 = new Pilot(series, "Pilot 1"); //$NON-NLS-1$
		race1.getAttendees().put(pilot1, new RaceAttendee(race1, pilot1, RaceAttendee.Type.PILOT));
		pilot1.getRaces().put(race1, race1.getAttendees().get(pilot1));
		series.getPilots().add(pilot1);

		Pilot pilot2 = new Pilot(series, "Pilot 2"); //$NON-NLS-1$
		race1.getAttendees().put(pilot2, new RaceAttendee(race1, pilot2, RaceAttendee.Type.PILOT));
		pilot2.getRaces().put(race1, race1.getAttendees().get(pilot2));
		series.getPilots().add(pilot2);

		Pilot pilot3 = new Pilot(series, "Pilot 3"); //$NON-NLS-1$
		race1.getAttendees().put(pilot3, new RaceAttendee(race1, pilot3, RaceAttendee.Type.PILOT));
		pilot3.getRaces().put(race1, race1.getAttendees().get(pilot3));
		series.getPilots().add(pilot3);

		race1.getTallies().add(new RaceTally(RaceTally.Type.START));
		race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot1)); //$NON-NLS-1$
		race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot2)); //$NON-NLS-1$

		Scorer scorer = ScorerFactory.newScorer(TestScorer1.UUID);
		Scores scores = scorer.scoreSeries(series);

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(pilot1, 1, 0, false, 0, 1);
		race1AssertUtil.assertPilot(pilot2, 1, 0, false, 2, 2);
		race1AssertUtil.assertPilot(pilot3, 0, 0, false, 4, 3);
		race1AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(pilot1, 0, 0, 1);
		overallAssertUtil.assertPilot(pilot2, 0, 2, 2);
		overallAssertUtil.assertPilot(pilot3, 0, 4, 3);
		overallAssertUtil.assertOrder();
	}

	@Test
	public void score2Races() throws Exception {
		Series series = new Series("Series 1"); //$NON-NLS-1$
		Event event = new Event(series, "Event"); //$NON-NLS-1$
		series.getEvents().add(event);
		Race race1 = new Race(event, "Race 1"); //$NON-NLS-1$
		event.getRaces().add(race1);
		Race race2 = new Race(event, "Race 2"); //$NON-NLS-1$
		event.getRaces().add(race2);

		Pilot pilot1 = new Pilot(series, "Pilot 1"); //$NON-NLS-1$
		race1.getAttendees().put(pilot1, new RaceAttendee(race1, pilot1, RaceAttendee.Type.PILOT));
		pilot1.getRaces().put(race1, race1.getAttendees().get(pilot1));
		race2.getAttendees().put(pilot1, new RaceAttendee(race2, pilot1, RaceAttendee.Type.PILOT));
		pilot1.getRaces().put(race2, race2.getAttendees().get(pilot1));
		series.getPilots().add(pilot1);

		Pilot pilot2 = new Pilot(series, "Pilot 2"); //$NON-NLS-1$
		race1.getAttendees().put(pilot2, new RaceAttendee(race1, pilot2, RaceAttendee.Type.PILOT));
		pilot2.getRaces().put(race1, race1.getAttendees().get(pilot2));
		race2.getAttendees().put(pilot2, new RaceAttendee(race2, pilot2, RaceAttendee.Type.PILOT));
		pilot2.getRaces().put(race2, race2.getAttendees().get(pilot2));
		series.getPilots().add(pilot2);

		Pilot pilot3 = new Pilot(series, "Pilot 3"); //$NON-NLS-1$
		race1.getAttendees().put(pilot3, new RaceAttendee(race1, pilot3, RaceAttendee.Type.PILOT));
		pilot3.getRaces().put(race1, race1.getAttendees().get(pilot3));
		race2.getAttendees().put(pilot3, new RaceAttendee(race2, pilot3, RaceAttendee.Type.PILOT));
		pilot3.getRaces().put(race2, race2.getAttendees().get(pilot3));
		series.getPilots().add(pilot3);

		race1.getTallies().add(new RaceTally(RaceTally.Type.START));
		race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot1)); //$NON-NLS-1$
		race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot2)); //$NON-NLS-1$

		race2.getTallies().add(new RaceTally(RaceTally.Type.START));
		race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot1)); //$NON-NLS-1$
		race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot2)); //$NON-NLS-1$

		Scorer scorer = ScorerFactory.newScorer(TestScorer1.UUID);
		Scores scores = scorer.scoreSeries(series);

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(pilot1, 1, 0, false, 0, 1);
		race1AssertUtil.assertPilot(pilot2, 1, 0, false, 2, 2);
		race1AssertUtil.assertPilot(pilot3, 0, 0, false, 4, 3);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(pilot1, 1, 0, false, 0, 1);
		race2AssertUtil.assertPilot(pilot2, 1, 0, false, 2, 2);
		race2AssertUtil.assertPilot(pilot3, 0, 0, false, 4, 3);
		race2AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(pilot1, 0, 0, 1);
		overallAssertUtil.assertPilot(pilot2, 0, 4, 2);
		overallAssertUtil.assertPilot(pilot3, 0, 8, 3);
		overallAssertUtil.assertOrder();
	}

	@Test
	public void score3Races() throws Exception {
		Series series = new Series("Series 1"); //$NON-NLS-1$
		Event event = new Event(series, "Event"); //$NON-NLS-1$
		series.getEvents().add(event);
		Race race1 = new Race(event, "Race 1"); //$NON-NLS-1$
		event.getRaces().add(race1);
		Race race2 = new Race(event, "Race 2"); //$NON-NLS-1$
		event.getRaces().add(race2);
		Race race3 = new Race(event, "Race 3"); //$NON-NLS-1$
		event.getRaces().add(race3);

		Pilot pilot1 = new Pilot(series, "Pilot 1"); //$NON-NLS-1$
		race1.getAttendees().put(pilot1, new RaceAttendee(race1, pilot1, RaceAttendee.Type.PILOT));
		pilot1.getRaces().put(race1, race1.getAttendees().get(pilot1));
		race2.getAttendees().put(pilot1, new RaceAttendee(race2, pilot1, RaceAttendee.Type.PILOT));
		pilot1.getRaces().put(race2, race2.getAttendees().get(pilot1));
		race3.getAttendees().put(pilot1, new RaceAttendee(race3, pilot1, RaceAttendee.Type.PILOT));
		pilot1.getRaces().put(race3, race3.getAttendees().get(pilot1));
		series.getPilots().add(pilot1);

		Pilot pilot2 = new Pilot(series, "Pilot 2"); //$NON-NLS-1$
		race1.getAttendees().put(pilot2, new RaceAttendee(race1, pilot2, RaceAttendee.Type.PILOT));
		pilot2.getRaces().put(race1, race1.getAttendees().get(pilot2));
		race2.getAttendees().put(pilot2, new RaceAttendee(race2, pilot2, RaceAttendee.Type.PILOT));
		pilot2.getRaces().put(race2, race2.getAttendees().get(pilot2));
		race3.getAttendees().put(pilot2, new RaceAttendee(race3, pilot2, RaceAttendee.Type.PILOT));
		pilot2.getRaces().put(race3, race3.getAttendees().get(pilot2));
		series.getPilots().add(pilot2);

		Pilot pilot3 = new Pilot(series, "Pilot 3"); //$NON-NLS-1$
		race1.getAttendees().put(pilot3, new RaceAttendee(race1, pilot3, RaceAttendee.Type.PILOT));
		pilot3.getRaces().put(race1, race1.getAttendees().get(pilot3));
		race2.getAttendees().put(pilot3, new RaceAttendee(race2, pilot3, RaceAttendee.Type.PILOT));
		pilot3.getRaces().put(race2, race2.getAttendees().get(pilot3));
		race3.getAttendees().put(pilot3, new RaceAttendee(race3, pilot3, RaceAttendee.Type.PILOT));
		pilot3.getRaces().put(race3, race3.getAttendees().get(pilot3));
		series.getPilots().add(pilot3);

		race1.getTallies().add(new RaceTally(RaceTally.Type.START));
		race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot1)); //$NON-NLS-1$
		race1.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot2)); //$NON-NLS-1$

		race2.getTallies().add(new RaceTally(RaceTally.Type.START));
		race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot2)); //$NON-NLS-1$
		race2.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot1)); //$NON-NLS-1$

		race3.getTallies().add(new RaceTally(RaceTally.Type.START));
		race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot1)); //$NON-NLS-1$
		race3.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot2)); //$NON-NLS-1$

		Scorer scorer = ScorerFactory.newScorer(TestScorer1.UUID);
		Scores scores = scorer.scoreSeries(series);

		RaceAssertUtil race1AssertUtil = new RaceAssertUtil(scores, race1);
		race1AssertUtil.assertPilot(pilot1, 1, 0, false, 0, 1);
		race1AssertUtil.assertPilot(pilot2, 1, 0, false, 2, 2);
		race1AssertUtil.assertPilot(pilot3, 0, 0, false, 4, 3);
		race1AssertUtil.assertDone(0);

		RaceAssertUtil race2AssertUtil = new RaceAssertUtil(scores, race2);
		race2AssertUtil.assertPilot(pilot2, 1, 0, false, 0, 1);
		race2AssertUtil.assertPilot(pilot1, 1, 0, false, 2, 2);
		race2AssertUtil.assertPilot(pilot3, 0, 0, false, 4, 3);
		race2AssertUtil.assertDone(0);

		RaceAssertUtil race3AssertUtil = new RaceAssertUtil(scores, race3);
		race3AssertUtil.assertPilot(pilot1, 1, 0, false, 0, 1);
		race3AssertUtil.assertPilot(pilot2, 1, 0, false, 2, 2);
		race3AssertUtil.assertPilot(pilot3, 0, 0, false, 4, 3);
		race3AssertUtil.assertDone(0);

		OverallAssertUtil overallAssertUtil = new OverallAssertUtil(scores);
		overallAssertUtil.assertPilot(pilot1, 0, 2, 1);
		overallAssertUtil.assertPilot(pilot2, 0, 4, 2);
		overallAssertUtil.assertPilot(pilot3, 0, 12, 3);
		overallAssertUtil.assertOrder();
	}
}