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
package org.spka.cursus.scoring;

import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.scorer.AbstractScorer;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

public abstract class AbstractSPKAScorer extends AbstractScorer {
	/**
	 * Race scores include all pilots at the event
	 */
	@Override
	public Scores scoreRace(Race race, Predicate<Pilot> fleetFilter) {
		return super.scoreRace(race, Sets.filter(race.getEvent().getAllPilots(), fleetFilter), fleetFilter);
	}
}