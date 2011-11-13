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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.scoring.Scores;
import eu.lp0.cursus.scoring.ScoringSystem;

@ScoringSystem(uuid = SPKAConstants.UUID_2011, name = SPKAConstants.NAME_2011)
public class Scorer2011 extends Scorer2010 {
	@Override
	public Scores scoreRaces(List<Race> races, Set<Pilot> pilots) {
		return new ScoresFactory2011().newScores(pilots, races);
	}

	public static int calculateFleetSize(Series series) {
		Set<Pilot> pilots = new HashSet<Pilot>(series.getPilots().size() * 2);
		for (Event event : series.getEvents()) {
			for (Race race : event.getRaces()) {
				pilots.addAll(race.getAttendees().keySet());
			}
		}
		return pilots.size();
	}
}