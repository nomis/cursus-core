/*
	cursus - Race series management program
	Copyright 2011  Simon Arlott

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

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.scoring.AveragingRacePointsData;
import eu.lp0.cursus.scoring.Scores;

public class RacePointsData2011<T extends Scores> extends AveragingRacePointsData<T> {
	private final Supplier<Integer> lazyRaceFleetSize = Suppliers.memoize(new Supplier<Integer>() {
		@Override
		public Integer get() {
			return calculateFleetSize();
		}
	});

	public RacePointsData2011(T scores, Method method, Rounding rounding) {
		super(scores, method, rounding);
	}

	@Override
	protected int getPointsForNoLaps(Pilot pilot, Race race) {
		if (race.getAttendees().containsKey(pilot)) {
			return getFleetSize(race) + 1;
		} else {
			return getFleetSize(race) + 2;
		}
	}

	@Override
	public int getFleetSize(Race race) {
		return lazyRaceFleetSize.get();
	}

	protected int calculateFleetSize() {
		assert (!scores.getRaces().isEmpty());
		return Scorer2011.calculateFleetSize(scores.getRaces().get(0).getEvent().getSeries());
	}
}