/*
	cursus - Race series management program
	Copyright 2011-2012, 2014  Simon Arlott

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
package uk.uuid.cursus.test.util;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;

import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.scoring.data.Scores;

import com.google.common.collect.Sets;

public class RaceAssertUtil {
	private final Scores scores;
	private final Race race;
	private final boolean allowSimulatedWithoutLaps;

	private final Set<Pilot> expectedRaceOrder = new LinkedHashSet<Pilot>();
	private boolean done = false;

	public RaceAssertUtil(Scores scores, Race race) {
		this(scores, race, false);
	}

	public RaceAssertUtil(Scores scores, Race race, boolean allowSimulatedWithoutLaps) {
		this.scores = scores;
		this.race = race;
		this.allowSimulatedWithoutLaps = allowSimulatedWithoutLaps;
	}

	public void assertPilot(Pilot pilot, int expectedLaps, int expectedPenalties, boolean expectedSimulatedRacePoints, int expectedPoints, int expectedPosition) {
		Assert.assertFalse(done);

		if (expectedSimulatedRacePoints && !allowSimulatedWithoutLaps) {
			Assert.assertEquals("Pilot " + pilot.getName() + " cannot have simulated race points with non-zero laps", 0, expectedLaps); //$NON-NLS-1$//$NON-NLS-2$
		}

		Assert.assertTrue("Pilot " + pilot.getName() + " does not exist in scores", scores.getPilots().contains(pilot)); //$NON-NLS-1$//$NON-NLS-2$
		Assert.assertEquals("Race laps mismatch for " + pilot.getName(), expectedLaps, scores.getLaps(pilot, race)); //$NON-NLS-1$
		Assert.assertEquals("Race penalties mismatch for " + pilot.getName(), expectedPenalties, scores.getRacePenalties(pilot, race)); //$NON-NLS-1$
		Assert.assertEquals("Race points simulation mismatch for " + pilot.getName(), expectedSimulatedRacePoints, scores.hasSimulatedRacePoints(pilot, race)); //$NON-NLS-1$
		Assert.assertEquals("Race points mismatch for " + pilot.getName(), expectedPoints, scores.getRacePoints(pilot, race)); //$NON-NLS-1$
		Assert.assertEquals("Race position mismatch for " + pilot.getName(), expectedPosition, scores.getRacePosition(pilot, race)); //$NON-NLS-1$
		Assert.assertTrue("Pilot " + pilot.getName() + " already specified", expectedRaceOrder.add(pilot)); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public void assertDone(int expectedSimulatedRacePointsPilots) {
		Assert.assertFalse(done);

		Assert.assertArrayEquals(new Object[0], Sets.difference(new HashSet<Pilot>(scores.getSimulatedRacePoints(race)), expectedRaceOrder).toArray());
		Assert.assertEquals(expectedSimulatedRacePointsPilots, scores.getSimulatedRacePoints(race).size());
		Assert.assertEquals(scores.getPilots().size(), expectedRaceOrder.size());
		Assert.assertEquals(scores.getPilots().size(), scores.getRaceOrder(race).size());
		Assert.assertArrayEquals(expectedRaceOrder.toArray(), scores.getRaceOrder(race).toArray());
		done = true;
	}
}