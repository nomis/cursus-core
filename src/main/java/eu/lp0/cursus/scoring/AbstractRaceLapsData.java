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
package eu.lp0.cursus.scoring;

import java.util.Collections;
import java.util.Map;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table;

import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;

public abstract class AbstractRaceLapsData<T extends ScoredData> implements RaceLapsData {
	protected final T scores;

	protected final Table<Pilot, Race, Integer> raceLaps;

	public AbstractRaceLapsData(T scores) {
		this.scores = scores;

		raceLaps = ArrayTable.create(scores.getPilots(), scores.getRaces());
	}

	@Override
	public Integer getLaps(Pilot pilot, Race race) {
		return raceLaps.get(pilot, race);
	}

	@Override
	public Map<Race, Integer> getLaps(Pilot pilot) {
		return Collections.unmodifiableMap(raceLaps.row(pilot));
	}

	@Override
	public Map<Pilot, Integer> getLaps(Race race) {
		return Collections.unmodifiableMap(raceLaps.column(race));
	}

	@Override
	public abstract void completeRaceLap(Pilot pilot, Race race) throws UnsupportedOperationException;
}