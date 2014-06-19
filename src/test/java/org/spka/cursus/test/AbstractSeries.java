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
package org.spka.cursus.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.annotation.Nonnull;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.RaceNumber;
import eu.lp0.cursus.db.data.RaceTally;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.scoring.data.Scores;
import eu.lp0.cursus.test.db.AbstractDatabaseTest;

@SuppressWarnings({ "NP_PARAMETER_MUST_BE_NONNULL_BUT_MARKED_AS_NULLABLE", "SIC_INNER_SHOULD_BE_STATIC_ANON" })
public class AbstractSeries extends AbstractDatabaseTest {
	protected final Set<String> SERIES_COUNTRIES = new HashSet<String>(Arrays.asList("Scotland")); //$NON-NLS-1$

	private static boolean isPrivateSeries(Series series) {
		return series.getName().startsWith("SPKA "); //$NON-NLS-1$
	}

	/**
	 * Get all the pilots in a Scotland series
	 */
	protected Set<Pilot> getSeriesResultsPilots(final Series series) throws Exception {
		return Sets.filter(series.getPilots(), new Predicate<Pilot>() {
			@Override
			public boolean apply(@Nonnull Pilot pilot) {
				return !isPrivateSeries(series) || SERIES_COUNTRIES.contains(pilot.getCountry());
			}
		});
	}

	/**
	 * Get all the pilots at a Scotland event (including non-Scotland pilots)
	 * (but only up to and including the specified event)
	 */
	protected Set<Pilot> getEventResultsPilots(final Series series, final Event event) {
		return Sets.filter(series.getPilots(), new Predicate<Pilot>() {
			@Override
			public boolean apply(@Nonnull Pilot pilot) {
				for (Race race : event.getRaces()) {
					if (race.getAttendees().containsKey(pilot)) {
						return true;
					}
				}

				for (Race race : pilot.getRaces().keySet()) {
					if (race.getEvent().compareTo(event) <= 0) {
						return !isPrivateSeries(series) || SERIES_COUNTRIES.contains(pilot.getCountry());
					}
				}

				for (Event event_ : pilot.getEvents()) {
					if (event_.compareTo(event) <= 0) {
						return !isPrivateSeries(series) || SERIES_COUNTRIES.contains(pilot.getCountry());
					}
				}

				return false;
			}
		});
	}

	/**
	 * Get all the pilots in a Scotland series (only up to and including the specified event)
	 */
	protected Set<Pilot> getSeriesResultsPilots(final Series series, final Event event) {
		return Sets.filter(series.getPilots(), new Predicate<Pilot>() {
			@Override
			public boolean apply(@Nonnull Pilot pilot) {
				for (Race race : pilot.getRaces().keySet()) {
					if (race.getEvent().compareTo(event) <= 0) {
						return !isPrivateSeries(series) || SERIES_COUNTRIES.contains(pilot.getCountry());
					}
				}

				for (Event event_ : pilot.getEvents()) {
					if (event_.compareTo(event) <= 0) {
						return !isPrivateSeries(series) || SERIES_COUNTRIES.contains(pilot.getCountry());
					}
				}

				return false;
			}
		});
	}

	/**
	 * Get all the events up to and and including the specified event
	 */
	protected static Set<Event> getSeriesResultsEvents(Series series, final Event event) {
		return Sets.filter(Sets.newHashSet(series.getEvents()), new Predicate<Event>() {
			@Override
			public boolean apply(@Nonnull Event event_) {
				return (event_.compareTo(event) <= 0);
			}
		});
	}

	protected static void debugPrintScores(Scores scores) {
		List<Event> events = new ArrayList<Event>();
		for (Race race : scores.getRaces()) {
			if (!events.contains(race.getEvent())) {
				events.add(race.getEvent());
			}
		}

		System.out.print("Pos\tPilot"); //$NON-NLS-1$
		int i = 1;
		for (Race race : scores.getRaces()) {
			System.out.print("\tE" + (events.indexOf(race.getEvent()) + 1)); //$NON-NLS-1$
			System.out.print("/R" + i); //$NON-NLS-1$
			i++;
		}
		if (scores.getRaces().size() == 1) {
			System.out.print("\tLaps"); //$NON-NLS-1$
		}
		System.out.print("\tPen"); //$NON-NLS-1$
		for (i = 1; i <= scores.getDiscardCount(); i++) {
			System.out.print("\tDisc"); //$NON-NLS-1$
		}
		System.out.println("\tTotal"); //$NON-NLS-1$
		for (Pilot pilot : scores.getOverallOrder()) {
			System.out.print(scores.getOverallPosition(pilot) + ":\t" + pilot.getName()); //$NON-NLS-1$
			for (Race race : scores.getRaces()) {
				System.out.print("\t" + scores.getRacePoints(pilot, race)); //$NON-NLS-1$
				if (scores.getSimulatedRacePoints(pilot).contains(race)) {
					System.out.print("*"); //$NON-NLS-1$
				}
			}
			if (scores.getRaces().size() == 1) {
				System.out.print("\t" + scores.getLaps(pilot, scores.getRaces().get(0))); //$NON-NLS-1$
			}
			System.out.print("\t" + scores.getOverallPenalties(pilot)); //$NON-NLS-1$ 
			for (i = 1; i <= scores.getDiscardCount(); i++) {
				System.out.print("\t" + scores.getRaceDiscard(pilot, i)); //$NON-NLS-1$ 
			}
			System.out.println("\t" + scores.getOverallPoints(pilot)); //$NON-NLS-1$ 
		}
	}

	protected void createRaceNumbers(Collection<Pilot> pilots) {
		for (Pilot pilot : pilots) {
			pilot.setRaceNumber(RaceNumber.valueOfFor(pilot.getName().split("@")[0], pilot)); //$NON-NLS-1$
		}
	}

	protected void attendEvent(Event event, Pilot pilot) {
		pilot = pilotDAO.get(pilot);
		pilot.getEvents().add(event);
		pilotDAO.persist(pilot);
	}

	protected void addLaps(Race race, String laps) {
		laps: for (String lap : laps.split(",", -1)) { //$NON-NLS-1$
			for (Pilot pilot : race.getAttendees().keySet()) {
				if (pilot.getRaceNumber().getNumber() == Integer.parseInt(lap)) {
					race.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", pilot)); //$NON-NLS-1$
					continue laps;
				}
			}
			throw new NoSuchElementException("Can't find pilot " + lap); //$NON-NLS-1$
		}
	}
}