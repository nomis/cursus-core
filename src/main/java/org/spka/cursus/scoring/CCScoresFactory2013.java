/*
	cursus - Race series management program
	Copyright 2013-2014  Simon Arlott

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

import uk.uuid.cursus.scoring.data.RacePointsData;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.scores.impl.GenericRacePointsData;
import uk.uuid.cursus.scoring.scores.impl.TopCountryRacePointsData;

public class CCScoresFactory2013 extends CCScoresFactory2008 {
	@Override
	public RacePointsData newRacePointsData(Scores scores) {
		return new TopCountryRacePointsData<Scores>(scores, GenericRacePointsData.FleetMethod.EVENT, GenericRacePointsData.FleetMethod.SERIES,
				CCConstants.TOP_COUNTRY_MIN_PILOTS_2013, CCConstants.TOP_COUNTRY_MAX_PILOTS_2013);
	}
}