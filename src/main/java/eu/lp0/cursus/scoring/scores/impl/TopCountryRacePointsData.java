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
package eu.lp0.cursus.scoring.scores.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;

import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.scoring.data.Scores;

public class TopCountryRacePointsData<T extends Scores> extends GenericRacePointsData<T> {
	private final int count;
	protected final Supplier<Multimap<Race, Pilot>> lazyScoredPilots = Suppliers.memoize(new Supplier<Multimap<Race, Pilot>>() {
		@Override
		public Multimap<Race, Pilot> get() {
			Multimap<Race, Pilot> scoredPilots = HashMultimap.create(scores.getRaces().size(), count);
			for (Race race : scores.getRaces()) {
				Multimap<String, Pilot> countryPilots = HashMultimap.create();

				for (Pilot pilot : scores.getLapOrder(race)) {
					if (countryPilots.get(pilot.getCountry()).size() < count) {
						countryPilots.put(pilot.getCountry(), pilot);
					}
				}

				for (String country : countryPilots.keySet()) {
					if (countryPilots.get(country).size() != count) {
						throw new IllegalStateException("Country " + countryPilots + " does not have " + count + " pilot(s)"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					}
				}

				scoredPilots.putAll(race, countryPilots.values());
			}
			return scoredPilots;
		}
	});

	public TopCountryRacePointsData(T scores, FleetMethod fleetMethod, int count) {
		super(scores, fleetMethod);

		this.count = count;
	}

	public TopCountryRacePointsData(T scores, FleetMethod raceFleetMethod, FleetMethod nonAttendeeFleetMethod, int count) {
		super(scores, raceFleetMethod, nonAttendeeFleetMethod);

		this.count = count;
	}

	@Override
	protected boolean calculateSimulatedRacePoints(Pilot pilot, Race race) {
		return !lazyScoredPilots.get().get(race).contains(pilot);
	}

	@Override
	protected Map<Pilot, Integer> calculateRacePoints(Race race) {
		Map<Pilot, Integer> racePoints = new HashMap<Pilot, Integer>(scores.getPilots().size() * 2);
		List<Pilot> lapOrder = scores.getLapOrder(race);
		Collection<Pilot> scoredPilots = lazyScoredPilots.get().get(race);

		// Score everyone who completed a lap
		int points = 0;
		for (Pilot pilot : Iterables.filter(lapOrder, Predicates.in(scoredPilots))) {
			racePoints.put(pilot, points);
			points += (points == 0) ? 2 : 1;
		}

		// Score everyone else
		for (Pilot pilot : scores.getPilots()) {
			if (!scoredPilots.contains(pilot)) {
				racePoints.put(pilot, 0);
			} else if (!racePoints.containsKey(pilot)) {
				racePoints.put(pilot, getPointsForNoLaps(pilot, race));
			}
		}

		return racePoints;
	}
}