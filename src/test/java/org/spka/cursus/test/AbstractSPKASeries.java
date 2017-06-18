/*
	cursus - Race series management program
	Copyright 2012-2016  Simon Arlott

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

import static uk.uuid.cursus.db.data.RaceTally.Type.START;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Penalty;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.RaceAttendee;
import uk.uuid.cursus.db.data.RaceNumber;
import uk.uuid.cursus.db.data.RaceTally;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.db.data.Sex;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.test.AbstractSeries;
import uk.uuid.cursus.xml.scores.ScoresXMLFile;

@SuppressFBWarnings({ "NP_PARAMETER_MUST_BE_NONNULL_BUT_MARKED_AS_NULLABLE" })
public abstract class AbstractSPKASeries extends AbstractSeries {
	private final Set<String> SERIES_COUNTRIES;

	public AbstractSPKASeries(String seriesName, String scorerUUID) {
		this(seriesName, scorerUUID, "Scotland"); //$NON-NLS-1$
	}

	public AbstractSPKASeries(String seriesName, String scorerUUID, String... seriesCountries) {
		super(seriesName, scorerUUID);
		SERIES_COUNTRIES = new HashSet<String>(Arrays.asList(seriesCountries));
	}

	public String[] getSeriesCountries() {
		return SERIES_COUNTRIES.toArray(new String[0]);
	}

	@Override
	public List<ScoresXMLFile> createScores() throws Exception {
		Scores seriesScores;
		List<Scores> eventScores = new ArrayList<Scores>();
		List<Scores> raceScores = new ArrayList<Scores>();

		Series series = seriesDAO.find(SERIES_NAME);
		seriesScores = scorer.scoreSeries(series, Predicates.in(getSeriesResultsPilots(series)));

		for (Event event : series.getEvents()) {
			if (!event.getRaces().isEmpty()) {
				eventScores.add(scorer.scoreRaces(event.getRaces(), Predicates.in(getEventResultsPilots(series, event))));

				for (Race race : event.getRaces()) {
					raceScores.add(scorer.scoreRaces(Collections.singletonList(race), Predicates.in(getEventResultsPilots(series, event))));
				}
			}
		}

		return Arrays.asList(new ScoresXMLFile(seriesScores, eventScores, raceScores));
	}

	protected boolean isStrictCountryFilter() {
		return false;
	}

	/**
	 * Get all the pilots in a Scotland series
	 */
	public Set<Pilot> getSeriesResultsPilots(final Series series) throws Exception {
		return Sets.filter(series.getPilots(), new Predicate<Pilot>() {
			@Override
			public boolean apply(@Nonnull Pilot pilot) {
				return SERIES_COUNTRIES.contains(pilot.getCountry());
			}
		});
	}

	/**
	 * Get all the pilots at a Scotland event (including non-Scotland pilots)
	 * (but only up to and including the specified event)
	 */
	public Set<Pilot> getEventResultsPilots(final Series series, final Event event) {
		if (isStrictCountryFilter()) {
			return getSeriesResultsPilots(series, event);
		}

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
						return SERIES_COUNTRIES.contains(pilot.getCountry());
					}
				}

				for (Event event_ : pilot.getEvents()) {
					if (event_.compareTo(event) <= 0) {
						return SERIES_COUNTRIES.contains(pilot.getCountry());
					}
				}

				return false;
			}
		});
	}

	/**
	 * Get all the pilots in a Scotland series (only up to and including the specified event)
	 */
	public Set<Pilot> getSeriesResultsPilots(final Series series, final Event event) {
		return Sets.filter(series.getPilots(), new Predicate<Pilot>() {
			@Override
			public boolean apply(@Nonnull Pilot pilot) {
				for (Race race : pilot.getRaces().keySet()) {
					if (race.getEvent().compareTo(event) <= 0) {
						return SERIES_COUNTRIES.contains(pilot.getCountry());
					}
				}

				for (Event event_ : pilot.getEvents()) {
					if (event_.compareTo(event) <= 0) {
						return SERIES_COUNTRIES.contains(pilot.getCountry());
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

	protected void addSeries() throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = new Series(SERIES_NAME);
			seriesDAO.persist(series);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	protected void addPilot(String name, Sex sex, String country, String... classes) throws Exception {
		addPilot(name, name.split("@")[0], sex, country, classes); //$NON-NLS-1$
	}

	protected void addPilot(String name, String raceNumber, Sex sex, String country, String... classes) throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Pilot pilot = new Pilot(series, name, sex, country);
			pilot.setRaceNumber(RaceNumber.valueOfFor(raceNumber, pilot));
			series.getPilots().add(pilot);
			seriesDAO.persist(series);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	protected void addAlias(String name, String... aliases) throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Pilot pilot = findPilot(name);
			for (String alias : aliases) {
				pilot.getRaceNumbers().add(RaceNumber.valueOfFor(alias, pilot));
			}
			pilotDAO.persist(pilot);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	protected void addEvent(int number, String desc) throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);

			Event event = new Event(series, "Race Event " + number, desc); //$NON-NLS-1$
			series.getEvents().add(event);
			eventDAO.persist(event);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	protected void addRace(int eventNumber, int raceNumber, String desc) throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event = eventDAO.find(series, "Race Event " + eventNumber); //$NON-NLS-1$

			Race race = new Race(event, "Race " + raceNumber, desc); //$NON-NLS-1$
			event.getRaces().add(race);
			race.getTallies().add(new RaceTally(START));
			raceDAO.persist(race);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	protected void addAttendees(int eventNumber, int raceNumber, RaceAttendee.Type type, String... pilotNames) throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event = eventDAO.find(series, "Race Event " + eventNumber); //$NON-NLS-1$
			Race race = raceDAO.find(event, "Race " + raceNumber); //$NON-NLS-1$
			for (String pilotName : pilotNames) {
				Pilot pilot = RaceNumber.valueOfFor(pilotName, series).getPilot();
				race.getAttendees().put(pilot, new RaceAttendee(race, pilot, RaceAttendee.Type.PILOT));
			}
			raceDAO.persist(race);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	protected void addLaps(int eventNumber, int raceNumber, String laps) {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event = eventDAO.find(series, "Race Event " + eventNumber); //$NON-NLS-1$
			Race race = raceDAO.find(event, "Race " + raceNumber); //$NON-NLS-1$
			addLaps(race, laps);
			raceDAO.persist(race);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	protected void addPenalty(int eventNumber, int raceNumber, String pilotName, Penalty penalty) throws Exception {
		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			Event event = eventDAO.find(series, "Race Event " + eventNumber); //$NON-NLS-1$
			Race race = raceDAO.find(event, "Race " + raceNumber); //$NON-NLS-1$
			RaceNumber.valueOfFor(pilotName, race).getPilot().getRaces().get(race).getPenalties().add(penalty);
			raceDAO.persist(race);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	protected Pilot findPilot(String name) throws Exception {
		Series series = seriesDAO.find(SERIES_NAME);
		for (Pilot pilot : series.getPilots()) {
			if (pilot.getName().startsWith(name + "@")) { //$NON-NLS-1$
				return pilot;
			}
		}
		throw new Exception("Pilot " + name + " not found"); //$NON-NLS-1$ //$NON-NLS-2$
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
		if (laps.isEmpty()) {
			return;
		}

		for (String lap : laps.split(",", -1)) { //$NON-NLS-1$
			race.getTallies().add(new RaceTally(RaceTally.Type.LAP, "", RaceNumber.valueOfFor(lap, race).getPilot())); //$NON-NLS-1$
		}
	}
}
