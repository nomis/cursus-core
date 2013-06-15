/*
	cursus - Race series management program
	Copyright 2013  Simon Arlott

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spka.cursus.scoring;

import org.fisly.cursus.scoring.FISLYScoresFactory2010;

import eu.lp0.cursus.scoring.data.OverallPositionData;
import eu.lp0.cursus.scoring.data.RaceDiscardsData;
import eu.lp0.cursus.scoring.data.RacePenaltiesData;
import eu.lp0.cursus.scoring.data.RacePointsData;
import eu.lp0.cursus.scoring.data.RacePositionsData;
import eu.lp0.cursus.scoring.data.Scores;
import eu.lp0.cursus.scoring.scores.impl.GenericRaceDiscardsData;
import eu.lp0.cursus.scoring.scores.impl.GenericRacePenaltiesData;
import eu.lp0.cursus.scoring.scores.impl.GenericRacePointsData;
import eu.lp0.cursus.scoring.scores.impl.GenericRacePositionsData;
import eu.lp0.cursus.scoring.scores.impl.NoDiscards;
import eu.lp0.cursus.scoring.scores.impl.PilotRacePlacingComparator;
import eu.lp0.cursus.scoring.scores.impl.PilotRacePlacingOverallPositionData;
import eu.lp0.cursus.scoring.scores.impl.TopCountryRacePointsData;

public class CCScoresFactory2013 extends FISLYScoresFactory2010 {
	@Override
	public RacePenaltiesData newRacePenaltiesData(Scores scores) {
		return new GenericRacePenaltiesData<Scores>(scores, GenericRacePenaltiesData.CumulativeMethod.RACE, true);
	}

	@Override
	public RacePointsData newRacePointsData(Scores scores) {
		return new TopCountryRacePointsData<Scores>(scores, GenericRacePointsData.FleetMethod.EVENT, GenericRacePointsData.FleetMethod.SERIES,
				CCConstants.TOP_COUNTRY_PILOTS_2013);
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
		return new PilotRacePlacingOverallPositionData<Scores>(scores, PilotRacePlacingComparator.PlacingMethod.EXCLUDING_SIMULATED);
	}
}