/*
	cursus - Race series management program
	Copyright 2012  Simon Arlott

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

import eu.lp0.cursus.scoring.data.OverallPenaltiesData;
import eu.lp0.cursus.scoring.data.Scores;
import eu.lp0.cursus.scoring.scores.impl.GenericDiscardCalculator;
import eu.lp0.cursus.scoring.scores.impl.GenericOverallPenaltiesData;

public class SPKAScoresFactory2012 extends SPKAScoresFactory2011 {
	@Override
	public OverallPenaltiesData newOverallPenaltiesData(Scores scores) {
		return new GenericOverallPenaltiesData<Scores>(scores, SPKAConstants.EVENT_NON_ATTENDANCE_POINTS_2012, new GenericDiscardCalculator(4));
	}
}