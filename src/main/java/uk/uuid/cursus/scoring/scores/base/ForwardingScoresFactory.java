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

import uk.uuid.cursus.scoring.data.OverallPenaltiesData;
import uk.uuid.cursus.scoring.data.OverallPointsData;
import uk.uuid.cursus.scoring.data.OverallPositionData;
import uk.uuid.cursus.scoring.data.RaceDiscardsData;
import uk.uuid.cursus.scoring.data.RaceLapsData;
import uk.uuid.cursus.scoring.data.RacePenaltiesData;
import uk.uuid.cursus.scoring.data.RacePointsData;
import uk.uuid.cursus.scoring.data.RacePositionsData;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.data.ScoresFactory;

public abstract class ForwardingScoresFactory implements ScoresFactory {
	protected abstract ScoresFactory delegate();

	@Override
	public RaceLapsData newRaceLapsData(Scores scores) {
		return delegate().newRaceLapsData(scores);
	}

	@Override
	public RacePointsData newRacePointsData(Scores scores) {
		return delegate().newRacePointsData(scores);
	}

	@Override
	public RacePenaltiesData newRacePenaltiesData(Scores scores) {
		return delegate().newRacePenaltiesData(scores);
	}

	@Override
	public RacePositionsData newRacePositionsData(Scores scores) {
		return delegate().newRacePositionsData(scores);
	}

	@Override
	public RaceDiscardsData newRaceDiscardsData(Scores scores) {
		return delegate().newRaceDiscardsData(scores);
	}

	@Override
	public OverallPenaltiesData newOverallPenaltiesData(Scores scores) {
		return delegate().newOverallPenaltiesData(scores);
	}

	@Override
	public OverallPointsData newOverallPointsData(Scores scores) {
		return delegate().newOverallPointsData(scores);
	}

	@Override
	public OverallPositionData newOverallPositionData(Scores scores) {
		return delegate().newOverallPositionData(scores);
	}
}