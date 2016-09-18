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
import java.util.Collection;

import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.xml.common.AbstractXMLEntity;

public class ScoresXMLSeriesEventResults {
	public ScoresXMLSeriesEventResults() {
	}

	public ScoresXMLSeriesEventResults(Scores scores, Event event, Collection<Race> races) {
		this.event = AbstractXMLEntity.generateId(event);

		this.raceResults = new ArrayList<ScoresXMLEventRaceResults>(races.size());
		for (Race race : races) {
			this.raceResults.add(new ScoresXMLEventRaceResults(scores, race));
		}
	}

	private String event;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	private ArrayList<ScoresXMLEventRaceResults> raceResults;

	public ArrayList<ScoresXMLEventRaceResults> getRaceResults() {
		return raceResults;
	}

	public void setRaceResults(ArrayList<ScoresXMLEventRaceResults> raceResults) {
		this.raceResults = raceResults;
	}
}