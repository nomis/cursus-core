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
package uk.uuid.cursus.xml.scores.results;

import java.util.ArrayList;

import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.xml.common.AbstractXMLEntity;
import uk.uuid.cursus.xml.data.ref.DataXMLRaceRef;
import uk.uuid.cursus.xml.scores.data.ScoresXMLRaceScore;

import com.google.common.base.Preconditions;

public class ScoresXMLRaceResults extends AbstractScoresXMLResults implements DataXMLRaceRef {
	public ScoresXMLRaceResults() {
	}

	public ScoresXMLRaceResults(Scores scores) {
		super(scores);

		Preconditions.checkArgument(!scores.getRaces().isEmpty(), "No race"); //$NON-NLS-1$
		Preconditions.checkArgument(scores.getRaces().size() == 1, "Multiple races not allowed"); //$NON-NLS-1$
		Race race_ = scores.getRaces().iterator().next();
		race = AbstractXMLEntity.generateId(race_);

		fleet = scores.getFleetSize(race_);

		racePilots = new ArrayList<ScoresXMLRaceScore>(scores.getRaceOrder(race_).size());
		for (Pilot pilot : scores.getRaceOrder(race_)) {
			racePilots.add(new ScoresXMLRaceScore(scores, race_, pilot));
		}
	}

	private String race;

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	private int fleet;

	public int getFleet() {
		return fleet;
	}

	public void setFleet(int fleet) {
		this.fleet = fleet;
	}

	private ArrayList<ScoresXMLRaceScore> racePilots;

	public ArrayList<ScoresXMLRaceScore> getRacePilots() {
		return racePilots;
	}

	public void setRacePilots(ArrayList<ScoresXMLRaceScore> racePilots) {
		this.racePilots = racePilots;
	}
}