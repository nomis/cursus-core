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
package org.spka.cursus.scoring;

import org.fisly.cursus.scoring.FISLYScoresFactory2010;

import uk.uuid.cursus.scoring.data.OverallPositionData;
import uk.uuid.cursus.scoring.data.RaceDiscardsData;
import uk.uuid.cursus.scoring.data.RacePenaltiesData;
import uk.uuid.cursus.scoring.data.RacePointsData;
import uk.uuid.cursus.scoring.data.RacePositionsData;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.scores.impl.GenericRaceDiscardsData;
import uk.uuid.cursus.scoring.scores.impl.GenericRacePenaltiesData;
import uk.uuid.cursus.scoring.scores.impl.GenericRacePointsData;
import uk.uuid.cursus.scoring.scores.impl.GenericRacePositionsData;
import uk.uuid.cursus.scoring.scores.impl.NoDiscards;
import uk.uuid.cursus.scoring.scores.impl.TopCountryOverallPositionData;
import uk.uuid.cursus.scoring.scores.impl.TopCountryRacePointsData;

public class CCScoresFactory2008 extends FISLYScoresFactory2010 {
	@Override
	public RacePenaltiesData newRacePenaltiesData(Scores scores) {
		return new GenericRacePenaltiesData<Scores>(scores, GenericRacePenaltiesData.CumulativeMethod.RACE, true);
	}

	@Override
	public RacePointsData newRacePointsData(Scores scores) {
		return new TopCountryRacePointsData<Scores>(scores, GenericRacePointsData.FleetMethod.RACE, CCConstants.TOP_COUNTRY_PILOTS_2008,
				CCConstants.TOP_COUNTRY_PILOTS_2008);
	}

	@Override
	public RacePositionsData newRacePositionsData(Scores scores) {
		return new GenericRacePositionsData<Scores>(scores, GenericRacePositionsData.EqualPositioning.WITHOUT_LAPS, true);
	}

	@Override
	public RaceDiscardsData newRaceDiscardsData(Scores scores) {
		return new GenericRaceDiscardsData<Scores>(scores, new NoDiscards());
	}

	@Override
	public OverallPositionData newOverallPositionData(Scores scores) {
		return new TopCountryOverallPositionData<Scores>(scores);
	}
}