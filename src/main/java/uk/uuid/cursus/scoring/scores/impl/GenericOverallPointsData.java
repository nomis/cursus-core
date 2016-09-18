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
package uk.uuid.cursus.scoring.scores.impl;

import java.util.Map.Entry;

import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.scoring.data.OverallPenaltiesData;
import uk.uuid.cursus.scoring.data.RaceDiscardsData;
import uk.uuid.cursus.scoring.data.RacePointsData;
import uk.uuid.cursus.scoring.data.ScoredData;
import uk.uuid.cursus.scoring.scores.base.AbstractOverallPointsData;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;

public class GenericOverallPointsData<T extends ScoredData & RacePointsData & RaceDiscardsData & OverallPenaltiesData> extends AbstractOverallPointsData<T> {
	public GenericOverallPointsData(T scores) {
		super(scores);
	}

	@Override
	protected int calculateOverallPoints(Pilot pilot) {
		int points = 0;

		// Add race points but not discards
		for (Entry<Race, Integer> racePoints : Maps.filterKeys(scores.getRacePoints(pilot), Predicates.not(Predicates.in(scores.getDiscardedRaces(pilot))))
				.entrySet()) {
			points += racePoints.getValue();
		}

		// Add all penalties (this includes race penalties)
		points += scores.getOverallPenalties(pilot);
		if (points < 0) {
			points = 0;
		}

		return points;
	}
}