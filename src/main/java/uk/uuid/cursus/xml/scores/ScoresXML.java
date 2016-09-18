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
package uk.uuid.cursus.xml.scores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import uk.uuid.cursus.db.Constants;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.xml.data.entity.DataXMLSeries;
import uk.uuid.cursus.xml.scores.results.ScoresXMLEventResults;
import uk.uuid.cursus.xml.scores.results.ScoresXMLRaceResults;
import uk.uuid.cursus.xml.scores.results.ScoresXMLSeriesResults;

import com.google.common.base.Preconditions;

public class ScoresXML {
	public ScoresXML() {
	}

	public ScoresXML(Scores seriesScores, List<Scores> eventScores, List<Scores> raceScores) {
		Set<Series> checkSeries = new HashSet<Series>();
		SortedSet<Event> events = new TreeSet<Event>();
		SortedSet<Race> races = new TreeSet<Race>();
		Set<Pilot> pilots = new HashSet<Pilot>();

		if (seriesScores != null) {
			this.seriesResults = new ScoresXMLSeriesResults(seriesScores);
			checkSeries.add(seriesScores.getSeries());
			races.addAll(seriesScores.getRaces());
			events.addAll(seriesScores.getEvents());
			pilots.addAll(seriesScores.getPilots());
		}

		if (eventScores != null) {
			this.eventResults = new ArrayList<ScoresXMLEventResults>(eventScores.size());
			for (Scores scores : eventScores) {
				this.eventResults.add(new ScoresXMLEventResults(scores));
				checkSeries.add(scores.getSeries());
				races.addAll(scores.getRaces());
				events.addAll(scores.getEvents());
				pilots.addAll(scores.getPilots());
			}
		}

		if (raceScores != null) {
			this.raceResults = new ArrayList<ScoresXMLRaceResults>(raceScores.size());
			for (Scores scores : raceScores) {
				this.raceResults.add(new ScoresXMLRaceResults(scores));
				checkSeries.add(scores.getSeries());
				races.addAll(scores.getRaces());
				events.addAll(scores.getEvents());
				pilots.addAll(scores.getPilots());
			}
		}
		Preconditions.checkArgument(!checkSeries.isEmpty(), "No series"); //$NON-NLS-1$
		Preconditions.checkArgument(checkSeries.size() == 1, "Multiple series not allowed"); //$NON-NLS-1$

		generator = Constants.LIB_DESC;
		series = new DataXMLSeries(checkSeries.iterator().next(), events, races, pilots);
	}

	private String generator;

	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}

	private DataXMLSeries series;

	public DataXMLSeries getSeries() {
		return series;
	}

	public void setSeries(DataXMLSeries series) {
		this.series = series;
	}

	private ScoresXMLSeriesResults seriesResults;

	public ScoresXMLSeriesResults getSeriesResults() {
		return seriesResults;
	}

	public void setSeriesResults(ScoresXMLSeriesResults seriesResults) {
		this.seriesResults = seriesResults;
	}

	private ArrayList<ScoresXMLEventResults> eventResults;

	public ArrayList<ScoresXMLEventResults> getEventResults() {
		return eventResults;
	}

	public void setEventResults(ArrayList<ScoresXMLEventResults> eventResults) {
		this.eventResults = eventResults;
	}

	private ArrayList<ScoresXMLRaceResults> raceResults;

	public ArrayList<ScoresXMLRaceResults> getRaceResults() {
		return raceResults;
	}

	public void setRaceResults(ArrayList<ScoresXMLRaceResults> raceResults) {
		this.raceResults = raceResults;
	}
}