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

import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.xml.scores.data.ScoresXMLOverallScore;
import uk.uuid.cursus.xml.scores.ref.ScoresXMLEvent;

public abstract class AbstractScoresXMLResults {
	public AbstractScoresXMLResults() {
	}

	public AbstractScoresXMLResults(Scores scores) {
		this();
		scorer = scores.getScorer();

		events = new ArrayList<ScoresXMLEvent>(scores.getEvents().size());
		for (Event event_ : scores.getEvents()) {
			events.add(new ScoresXMLEvent(event_));
		}

		overallPilots = new ArrayList<ScoresXMLOverallScore>(scores.getOverallOrder().size());
		for (Pilot pilot : scores.getOverallOrder()) {
			overallPilots.add(new ScoresXMLOverallScore(scores, pilot));
		}
	}

	private String scorer;

	public String getScorer() {
		return scorer;
	}

	public void setScorer(String scorer) {
		this.scorer = scorer;
	}

	private ArrayList<ScoresXMLEvent> events;

	public ArrayList<ScoresXMLEvent> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<ScoresXMLEvent> events) {
		this.events = events;
	}

	private ArrayList<ScoresXMLOverallScore> overallPilots;

	public ArrayList<ScoresXMLOverallScore> getOverallPilots() {
		return overallPilots;
	}

	public void setOverallPilots(ArrayList<ScoresXMLOverallScore> overallPilots) {
		this.overallPilots = overallPilots;
	}
}