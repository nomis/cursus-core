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
package uk.uuid.cursus.scoring.scores.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.Map;

import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.scoring.data.RaceDiscardsData;
import uk.uuid.cursus.scoring.data.RacePenaltiesData;
import uk.uuid.cursus.scoring.data.RacePointsData;
import uk.uuid.cursus.scoring.data.ScoredData;
import uk.uuid.cursus.scoring.scores.impl.PilotRacePlacingComparator.PlacingMethod;

import com.google.common.collect.ComparisonChain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "SE_COMPARATOR_SHOULD_BE_SERIALIZABLE" })
public class AveragePointsComparator<T extends ScoredData & RacePointsData & RacePenaltiesData & RaceDiscardsData> implements Comparator<Pilot> {
	private final T scores;
	private final PlacingMethod placingMethod;

	public AveragePointsComparator(T scores, PlacingMethod placingMethod) {
		this.scores = scores;
		this.placingMethod = placingMethod;
	}

	@Override
	public int compare(Pilot o1, Pilot o2) {
		Map<Race, Integer> racePoints1 = scores.getRacePoints(o1);
		Map<Race, Integer> racePenalties1 = scores.getRacePenalties(o1);
		int points1 = 0;
		int races1 = 0;
		BigDecimal average1 = BigDecimal.ZERO;

		Map<Race, Integer> racePoints2 = scores.getRacePoints(o2);
		Map<Race, Integer> racePenalties2 = scores.getRacePenalties(o2);
		int points2 = 0;
		int races2 = 0;
		BigDecimal average2 = BigDecimal.ZERO;

		for (Race race : scores.getRaces()) {
			boolean include1 = false;
			boolean include2 = false;

			switch (placingMethod) {
			case INCLUDING_DISCARDS:
				include1 = true;
				include2 = true;
				break;

			case EXCLUDING_DISCARDS:
				include1 = !scores.getDiscardedRaces(o1).contains(race);
				include2 = !scores.getDiscardedRaces(o2).contains(race);
				break;

			case INCLUDING_PENALTIES_EXCLUDING_DISCARDS_EXCLUDING_SIMULATED:
				include1 = !scores.hasSimulatedRacePoints(o1, race);
				include2 = !scores.hasSimulatedRacePoints(o2, race);
				break;
			}

			if (include1) {
				points1 += racePoints1.get(race);
				points1 += racePenalties1.get(race);
				races1++;
			}

			if (include2) {
				points2 += racePoints2.get(race);
				points2 += racePenalties2.get(race);
				races2++;
			}
		}

		// Calculate the averages
		if (races1 != 0) {
			average1 = BigDecimal.valueOf(points1).divide(BigDecimal.valueOf(races1), 50, RoundingMode.HALF_EVEN);
		}
		if (races2 != 0) {
			average2 = BigDecimal.valueOf(points2).divide(BigDecimal.valueOf(races2), 50, RoundingMode.HALF_EVEN);
		}

		if (races1 == 0 || races2 == 0) {
			return ComparisonChain.start().compare(races2, races1).result();
		}

		return ComparisonChain.start().compare(average1, average2).compare(points1, points2).result();
	}

}
