/*
	cursus - Race series management program
	Copyright 2012-2014  Simon Arlott

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
package uk.uuid.cursus.scoring.scores.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import uk.uuid.cursus.db.data.Penalty;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.RaceAttendee;
import uk.uuid.cursus.db.data.RaceTally;
import uk.uuid.cursus.scoring.data.RacePenaltiesData;
import uk.uuid.cursus.scoring.data.ScoredData;
import uk.uuid.cursus.scoring.scores.base.AbstractRaceLapsData;
import uk.uuid.cursus.util.PilotRaceNumberComparator;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "NP_PARAMETER_MUST_BE_NONNULL_BUT_MARKED_AS_NULLABLE" })
public class GenericRaceLapsData<T extends ScoredData & RacePenaltiesData> extends AbstractRaceLapsData<T> {
	private static final int EXPECTED_MAXIMUM_LAPS = 32;
	private static final int EXPECTED_MAXIMUM_PENALTIES = 2;
	private final boolean scoreBeforeStart;
	private final boolean scoreAfterFinish;

	public GenericRaceLapsData(T scores, boolean scoreBeforeStart, boolean scoreAfterFinish) {
		super(scores);

		this.scoreBeforeStart = scoreBeforeStart;
		this.scoreAfterFinish = scoreAfterFinish;
	}

	@Override
	protected List<Pilot> calculateRaceLapsInOrder(Race race, Map<Pilot, Integer> laps) {
		ListMultimap<Integer, Pilot> raceOrder = ArrayListMultimap.create(EXPECTED_MAXIMUM_LAPS, scores.getPilots().size());

		extractRaceLaps(race, laps, raceOrder, null);

		// Get penalties for each pilot
		ListMultimap<Pilot, Penalty> cancelLaps = ArrayListMultimap.create(EXPECTED_MAXIMUM_PENALTIES, scores.getPilots().size());
		ListMultimap<Pilot, Penalty> adjustLaps = ArrayListMultimap.create(EXPECTED_MAXIMUM_PENALTIES, scores.getPilots().size());
		for (RaceAttendee attendee : Maps.filterKeys(race.getAttendees(), Predicates.in(scores.getPilots())).values()) {
			for (Penalty penalty : Iterables.concat(Ordering.natural().immutableSortedCopy(attendee.getPenalties()),
					scores.getSimulatedRacePenalties(attendee.getPilot(), race))) {
				if (penalty.getValue() != 0) {
					switch (penalty.getType()) {
					case CANCEL_LAPS:
						cancelLaps.put(attendee.getPilot(), penalty);
						break;

					case ADJUST_LAPS:
						adjustLaps.put(attendee.getPilot(), penalty);
						break;

					default:
						break;
					}
				}
			}
		}

		// Apply lap cancellation penalties
		if (!cancelLaps.isEmpty()) {
			final Multiset<Pilot> pilotLaps = HashMultiset.create(laps.size());

			for (Map.Entry<Pilot, Integer> pilotLapCount : laps.entrySet()) {
				pilotLaps.setCount(pilotLapCount.getKey(), pilotLapCount.getValue());
			}

			for (Map.Entry<Pilot, Penalty> entry : cancelLaps.entries()) {
				int value = entry.getValue().getValue();
				if (value > 0) {
					pilotLaps.remove(entry.getKey(), value);
				} else {
					pilotLaps.add(entry.getKey(), Math.abs(value));
				}
			}

			extractRaceLaps(race, laps, raceOrder, new Predicate<Pilot>() {
				@Override
				public boolean apply(@Nullable Pilot pilot) {
					return pilotLaps.remove(pilot);
				}
			});
		}

		// Save pilot order
		List<Pilot> origPilotOrder = getPilotOrder(raceOrder);
		SortedSet<Pilot> noLaps = new TreeSet<Pilot>(new PilotRaceNumberComparator());
		Set<Integer> changed = new HashSet<Integer>();

		// It is intentional that pilots can end up having 0 laps but be considered to have completed the race
		for (Map.Entry<Pilot, Penalty> entry : adjustLaps.entries()) {
			Pilot pilot = entry.getKey();
			int lapCount = laps.get(pilot);

			raceOrder.remove(lapCount, pilot);
			changed.add(lapCount);

			lapCount += entry.getValue().getValue();
			if (lapCount <= 0) {
				lapCount = 0;
				noLaps.add(pilot);
			}
			laps.put(pilot, lapCount);

			raceOrder.put(lapCount, pilot);
			changed.add(lapCount);
		}

		// Apply original pilot order
		if (!changed.isEmpty()) {
			origPilotOrder.addAll(noLaps);

			for (Integer lapCount : changed) {
				raceOrder.replaceValues(lapCount, Ordering.explicit(origPilotOrder).immutableSortedCopy(raceOrder.get(lapCount)));
			}

			return getPilotOrder(raceOrder);
		} else {
			return origPilotOrder;
		}
	}

	private void extractRaceLaps(Race race, Map<Pilot, Integer> laps, ListMultimap<Integer, Pilot> raceOrder, Predicate<Pilot> filter) {
		for (Pilot pilot : scores.getPilots()) {
			laps.put(pilot, 0);
		}

		raceOrder.clear();

		for (Pilot pilot : extractRaceLaps(race, filter)) {
			int lapCount = laps.get(pilot);

			raceOrder.remove(lapCount, pilot);
			laps.put(pilot, ++lapCount);
			raceOrder.put(lapCount, pilot);
		}
	}

	protected Iterable<Pilot> extractRaceLaps(Race race, Predicate<Pilot> filter) {
		// If they aren't marked as attending the race as a pilot, they don't get scored
		Predicate<Pilot> attending = Predicates.in(filteredPilots(race));
		if (filter != null) {
			filter = Predicates.and(attending, filter);
		} else {
			filter = attending;
		}

		// Convert a list of race events into a list of valid pilot laps
		return Iterables.filter(Iterables.transform(Iterables.unmodifiableIterable(race.getTallies()), new Function<RaceTally, Pilot>() {
			boolean scoring = scoreBeforeStart;

			@Override
			public Pilot apply(@Nonnull RaceTally tally) {
				switch (tally.getType()) {
				case START:
					scoring = true;
					break;

				case LAP:
					if (scoring) {
						return tally.getPilot();
					}
					break;

				case INVALID_LAP:
					break;

				case FINISH:
					scoring = scoreAfterFinish;
					break;
				}

				return null;
			}

		}), filter);
	}

	protected List<Pilot> getPilotOrder(ListMultimap<Integer, Pilot> raceOrder) {
		List<Pilot> pilotOrder = new ArrayList<Pilot>(scores.getPilots().size());
		for (Integer lap : Ordering.natural().reverse().immutableSortedCopy(raceOrder.keySet())) {
			pilotOrder.addAll(raceOrder.get(lap));
		}
		return pilotOrder;
	}

	private Set<Pilot> filteredPilots(Race race) {
		ImmutableSet.Builder<Pilot> pilots = ImmutableSet.builder();
		for (RaceAttendee attendee : Maps.filterKeys(race.getAttendees(), Predicates.in(scores.getFleet())).values()) {
			if (attendee.getType() == RaceAttendee.Type.PILOT) {
				pilots.add(attendee.getPilot());
			}
		}
		return pilots.build();
	}
}