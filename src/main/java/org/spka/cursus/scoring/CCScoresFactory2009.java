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

import eu.lp0.cursus.scoring.data.RacePointsData;
import eu.lp0.cursus.scoring.data.Scores;
import eu.lp0.cursus.scoring.scores.impl.GenericRacePointsData;
import eu.lp0.cursus.scoring.scores.impl.TopCountryRacePointsData;

public class CCScoresFactory2009 extends CCScoresFactory2008 {
	@Override
	public RacePointsData newRacePointsData(Scores scores) {
		return new TopCountryRacePointsData<Scores>(scores, GenericRacePointsData.FleetMethod.RACE, CCConstants.TOP_COUNTRY_PILOTS_2009,
				CCConstants.TOP_COUNTRY_PILOTS_2009);
	}
}