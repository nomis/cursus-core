/*
	cursus - Race series management program
	Copyright 2013  Simon Arlott

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;

import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.scoring.data.OverallPointsData;
import eu.lp0.cursus.scoring.data.RaceDiscardsData;
import eu.lp0.cursus.scoring.data.RacePenaltiesData;
import eu.lp0.cursus.scoring.data.RacePointsData;
import eu.lp0.cursus.scoring.data.ScoredData;
import eu.lp0.cursus.util.PilotRaceNumberComparator;

public class TopCountryOverallPositionData<T extends ScoredData & RacePointsData & RacePenaltiesData & RaceDiscardsData & OverallPointsData> extends
		GenericOverallPositionData<T> {
	public TopCountryOverallPositionData(T scores) {
		super(scores, EqualPositioning.IF_REQUIRED, PilotRacePlacingComparator.PlacingMethod.EXCLUDING_SIMULATED, true);
	}

	@Override
	protected LinkedListMultimap<Integer, Pilot> calculateOverallPositionsWithOrder() {
		if (scores.getRaces().size() < 2) {
			return super.calculateOverallPositionsWithOrder();
		}

		Comparator<Pilot> averagePoints = new AveragePointsComparator<T>(scores, placingMethod);
		Comparator<Pilot> racePlacings = new PilotRacePlacingComparator<T>(scores, placingMethod);
		Comparator<Pilot> fallbackOrdering = new PilotRaceNumberComparator();
		SortedSet<Pilot> pilots = new TreeSet<Pilot>(Ordering.from(averagePoints).compound(racePlacings).compound(fallbackOrdering));
		pilots.addAll(scores.getPilots());

		LinkedListMultimap<Integer, Pilot> overallPositions = LinkedListMultimap.create();
		List<Pilot> collectedPilots = new ArrayList<Pilot>(scores.getPilots().size());
		int position = 1;

		PeekingIterator<Pilot> it = Iterators.peekingIterator(pilots.iterator());
		while (it.hasNext()) {
			Pilot pilot = it.next();
			collectedPilots.add(pilot);

			// If this pilot compares equally with the next pilot, add them too
			while (it.hasNext() && racePlacings.compare(it.peek(), pilot) == 0) {
				collectedPilots.add(it.next());
			}

			// Sort them by an arbitrary order
			Collections.sort(collectedPilots, fallbackOrdering);

			// Add them all to this position
			overallPositions.putAll(position, collectedPilots);
			position += collectedPilots.size();

			collectedPilots.clear();
		}

		return overallPositions;
	}
}