/*
	cursus - Race series management program
	Copyright 2011-2014  Simon Arlott

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
package org.fisly.cursus.scoring;

import uk.uuid.cursus.scoring.data.OverallPenaltiesData;
import uk.uuid.cursus.scoring.data.OverallPointsData;
import uk.uuid.cursus.scoring.data.OverallPositionData;
import uk.uuid.cursus.scoring.data.RaceDiscardsData;
import uk.uuid.cursus.scoring.data.RaceLapsData;
import uk.uuid.cursus.scoring.data.RacePenaltiesData;
import uk.uuid.cursus.scoring.data.RacePointsData;
import uk.uuid.cursus.scoring.data.RacePositionsData;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.scores.base.AbstractScoresFactory;
import uk.uuid.cursus.scoring.scores.impl.GenericDiscardCalculator;
import uk.uuid.cursus.scoring.scores.impl.GenericOverallPenaltiesData;
import uk.uuid.cursus.scoring.scores.impl.GenericOverallPointsData;
import uk.uuid.cursus.scoring.scores.impl.GenericOverallPositionData;
import uk.uuid.cursus.scoring.scores.impl.GenericRaceDiscardsData;
import uk.uuid.cursus.scoring.scores.impl.GenericRaceLapsData;
import uk.uuid.cursus.scoring.scores.impl.GenericRacePenaltiesData;
import uk.uuid.cursus.scoring.scores.impl.GenericRacePointsData;
import uk.uuid.cursus.scoring.scores.impl.GenericRacePositionsData;
import uk.uuid.cursus.scoring.scores.impl.NoDiscards;
import uk.uuid.cursus.scoring.scores.impl.PilotRacePlacingComparator;

public class FISLYScoresFactory2010 extends AbstractScoresFactory {
	protected static final int RACES_PER_DISCARD = 4;

	@Override
	public RaceLapsData newRaceLapsData(Scores scores) {
		return new GenericRaceLapsData<Scores>(scores, false, true);
	}

	@Override
	public RacePenaltiesData newRacePenaltiesData(Scores scores) {
		return new GenericRacePenaltiesData<Scores>(scores, GenericRacePenaltiesData.CumulativeMethod.EVENT);
	}

	@Override
	public RacePointsData newRacePointsData(Scores scores) {
		return new GenericRacePointsData<Scores>(scores, GenericRacePointsData.FleetMethod.EVENT);
	}

	@Override
	public RacePositionsData newRacePositionsData(Scores scores) {
		return new GenericRacePositionsData<Scores>(scores, GenericRacePositionsData.EqualPositioning.WITHOUT_LAPS);
	}

	@Override
	public RaceDiscardsData newRaceDiscardsData(Scores scores) {
		return new GenericRaceDiscardsData<Scores>(scores, new GenericDiscardCalculator(RACES_PER_DISCARD));
	}

	@Override
	public OverallPenaltiesData newOverallPenaltiesData(Scores scores) {
		return new GenericOverallPenaltiesData<Scores>(scores, 0, new NoDiscards());
	}

	@Override
	public OverallPointsData newOverallPointsData(Scores scores) {
		return new GenericOverallPointsData<Scores>(scores);
	}

	@Override
	public OverallPositionData newOverallPositionData(Scores scores) {
		return new GenericOverallPositionData<Scores>(scores, GenericOverallPositionData.EqualPositioning.IF_REQUIRED,
				PilotRacePlacingComparator.PlacingMethod.EXCLUDING_DISCARDS);
	}
}