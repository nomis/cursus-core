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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;

public abstract class AbstractRaceOrderData<T extends ScoredData> implements RaceOrderData {
	protected final T scores;

	public AbstractRaceOrderData(T scores) {
		this.scores = scores;
	}

	@Override
	public Map<Race, List<Pilot>> getRaceOrder() {
		Map<Race, List<Pilot>> raceOrder = new HashMap<Race, List<Pilot>>();
		for (Race race : scores.getRaces()) {
			raceOrder.put(race, getRaceOrder(race));
		}
		return raceOrder;
	}

	@Override
	public abstract List<Pilot> getRaceOrder(Race race);
}