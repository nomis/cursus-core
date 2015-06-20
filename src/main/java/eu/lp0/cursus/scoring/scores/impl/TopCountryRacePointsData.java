/*
	cursus - Race series management program
	Copyright 2012, 2014  Simon Arlott

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
package eu.lp0.cursus.scoring.scores.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.scoring.data.Scores;

public class TopCountryRacePointsData<T extends Scores> extends GenericRacePointsData<T> {
	private final int minCount;
	private final int maxCount;
	protected final Supplier<Map<Event, Integer>> lazyCount = Suppliers.memoize(new Supplier<Map<Event, Integer>>() {
		@Override
		public Map<Event, Integer> get() {
			Map<Event, Integer> eventCount = new HashMap<Event, Integer>();
			for (Event event : scores.getEvents()) {
				Multimap<String, Pilot> countryPilots = HashMultimap.create();

				for (Race race : event.getRaces()) {
					for (Pilot pilot : Maps.filterKeys(race.getAttendees(), Predicates.in(scores.getFleet())).keySet()) {
						countryPilots.put(pilot.getCountry(), pilot);
					}
				}

				int value = maxCount;

				for (String country : countryPilots.keySet()) {
					if (countryPilots.get(country).size() < minCount) {
						throw new IllegalStateException("Country " + country + " does not have " + minCount + " pilot(s) for every race in event " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								+ event.getName() + ": " + countryPilots.get(country)); //$NON-NLS-1$
					}

					value = Math.min(value, countryPilots.get(country).size());
				}

				eventCount.put(event, value);
			}
			return eventCount;
		}
	});
	protected final Supplier<Multimap<Race, Pilot>> lazyScoredPilots = Suppliers.memoize(new Supplier<Multimap<Race, Pilot>>() {
		@Override
		public Multimap<Race, Pilot> get() {
			Multimap<Race, Pilot> scoredPilots = HashMultimap.create(scores.getRaces().size(), maxCount);
			for (Race race : scores.getRaces()) {
				int count = lazyCount.get().get(race.getEvent());
				Multimap<String, Pilot> countryPilots = LinkedHashMultimap.create();

				for (Pilot pilot : scores.getLapOrder(race)) {
					if (countryPilots.get(pilot.getCountry()).size() < count) {
						countryPilots.put(pilot.getCountry(), pilot);
					}
				}

				for (String country : countryPilots.keySet()) {
					if (countryPilots.get(country).size() < count) {
						count = Math.min(count, countryPilots.get(country).size());

						// If country has less than minCount, ignore this race
						if (count < minCount) {
							count = 0;
						}
					}
				}

				// Truncate all other countries down to the lowest country
				for (String country : ImmutableList.copyOf(countryPilots.keySet())) {
					if (countryPilots.get(country).size() > count) {
						countryPilots.replaceValues(country, Iterables.limit(ImmutableList.copyOf(countryPilots.get(country)), count));
					}
				}

				scoredPilots.putAll(race, countryPilots.values());
			}
			return scoredPilots;
		}
	});

	public TopCountryRacePointsData(T scores, FleetMethod fleetMethod, int minCount, int maxCount) {
		this(scores, fleetMethod, fleetMethod, minCount, maxCount);
	}

	public TopCountryRacePointsData(T scores, FleetMethod raceFleetMethod, FleetMethod nonAttendeeFleetMethod, int minCount, int maxCount) {
		super(scores, raceFleetMethod, nonAttendeeFleetMethod);

		Preconditions.checkArgument(minCount > 0);
		Preconditions.checkArgument(maxCount >= minCount);

		this.minCount = minCount;
		this.maxCount = maxCount;
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