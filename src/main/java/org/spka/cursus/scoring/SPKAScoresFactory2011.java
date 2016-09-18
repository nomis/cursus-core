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
package org.spka.cursus.scoring;

import java.math.RoundingMode;

import org.fisly.cursus.scoring.FISLYScoresFactory2010;

import uk.uuid.cursus.scoring.data.OverallPenaltiesData;
import uk.uuid.cursus.scoring.data.RacePointsData;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.scores.impl.AveragingRacePointsData;
import uk.uuid.cursus.scoring.scores.impl.GenericOverallPenaltiesData;
import uk.uuid.cursus.scoring.scores.impl.GenericRacePointsData;
import uk.uuid.cursus.scoring.scores.impl.NoDiscards;

public class SPKAScoresFactory2011 extends FISLYScoresFactory2010 {
	@Override
	public RacePointsData newRacePointsData(Scores scores) {
		return new AveragingRacePointsData<Scores>(scores, GenericRacePointsData.FleetMethod.EVENTS_SCORED,
				AveragingRacePointsData.AveragingMethod.AFTER_DISCARDS, RoundingMode.HALF_UP);
	}

	@Override
	public OverallPenaltiesData newOverallPenaltiesData(Scores scores) {
		return new GenericOverallPenaltiesData<Scores>(scores, SPKAConstants.EVENT_NON_ATTENDANCE_POINTS_2011, new NoDiscards());
	}
}