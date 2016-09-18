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
package uk.uuid.cursus.scoring.scores.base;

import java.util.List;
import java.util.Set;

import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.data.ScoresFactory;
import uk.uuid.cursus.scoring.scorer.Scorer;
import uk.uuid.cursus.scoring.scores.impl.GenericScores;

import com.google.common.base.Predicate;

public abstract class AbstractScoresFactory implements ScoresFactory {
	@Override
	public Scores newScores(Set<Pilot> pilots, List<Race> races, Set<Event> events, Predicate<Pilot> fleetFilter, Scorer scorer) {
		return new GenericScores(pilots, races, events, fleetFilter, this, scorer);
	}
}