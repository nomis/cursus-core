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
package uk.uuid.cursus.xml.scores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.uuid.cursus.db.data.Penalty;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.scoring.data.OverallPenaltiesData;
import uk.uuid.cursus.scoring.data.OverallPointsData;
import uk.uuid.cursus.scoring.data.OverallPositionData;
import uk.uuid.cursus.scoring.data.RaceDiscardsData;
import uk.uuid.cursus.scoring.data.RaceLapsData;
import uk.uuid.cursus.scoring.data.RacePenaltiesData;
import uk.uuid.cursus.scoring.data.RacePointsData;
import uk.uuid.cursus.scoring.data.RacePositionsData;
import uk.uuid.cursus.scoring.data.ScoredData;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.scores.base.AbstractOverallPenaltiesData;
import uk.uuid.cursus.scoring.scores.base.AbstractOverallPointsData;
import uk.uuid.cursus.scoring.scores.base.AbstractOverallPositionData;
import uk.uuid.cursus.scoring.scores.base.AbstractRaceDiscardsData;
import uk.uuid.cursus.scoring.scores.base.AbstractRaceLapsData;
import uk.uuid.cursus.scoring.scores.base.AbstractRacePenaltiesData;
import uk.uuid.cursus.scoring.scores.base.AbstractRacePointsData;
import uk.uuid.cursus.scoring.scores.base.AbstractRacePositionsData;
import uk.uuid.cursus.scoring.scores.base.AbstractScoresFactory;
import uk.uuid.cursus.xml.data.entity.DataXMLPenalty;
import uk.uuid.cursus.xml.scores.data.ScoresXMLOverallScore;
import uk.uuid.cursus.xml.scores.data.ScoresXMLRaceScore;
import uk.uuid.cursus.xml.scores.ref.ScoresXMLRaceDiscard;

import com.google.common.collect.LinkedListMultimap;

class XMLScoresFactory extends AbstractScoresFactory {
	private final XMLScores xmlScores;
	private final XMLScores.Subset subset;

	public XMLScoresFactory(XMLScores xmlScores, XMLScores.Subset subset) {
		this.xmlScores = xmlScores;
		this.subset = subset;
	}

	@Override
	public RaceLapsData newRaceLapsData(Scores scores) {
		return new AbstractRaceLapsData<ScoredData>(scores) {
			@Override
			protected List<Pilot> calculateRaceLapsInOrder(Race race, Map<Pilot, Integer> laps) {
				List<Pilot> pilots = new ArrayList<Pilot>();
				for (ScoresXMLRaceScore raceScore : subset.getRaceScores(race)) {
					Pilot pilot = xmlScores.dereference(raceScore);
					pilots.add(pilot);
					laps.put(pilot, raceScore.getLaps());
				}
				return pilots;
			}
		};
	}

	@Override
	public RacePointsData newRacePointsData(Scores scores) {
		return new AbstractRacePointsData<ScoredData>(scores) {
			@Override
			public int getFleetSize(Race race) {
				return subset.getFleetSize(race);
			}

			@Override
			protected Map<Pilot, Integer> calculateRacePoints(Race race) {
				Map<Pilot, Integer> racePoints = new HashMap<Pilot, Integer>();
				for (ScoresXMLRaceScore raceScore : subset.getRaceScores(race)) {
					Pilot pilot = xmlScores.dereference(raceScore);
					racePoints.put(pilot, raceScore.getPoints());
				}
				return racePoints;
			}

			@Override
			protected boolean calculateSimulatedRacePoints(Pilot pilot, Race race) {
				return subset.getRaceScore(pilot, race).isSimulated();
			}
		};
	}

	@Override
	public RacePenaltiesData newRacePenaltiesData(Scores scores) {
		return new AbstractRacePenaltiesData<ScoredData>(scores) {
			@Override
			protected int calculateRacePenalties(Pilot pilot, Race race) {
				return subset.getRaceScore(pilot, race).getPenalties();
			}

			@Override
			protected List<Penalty> calculateSimulatedRacePenalties(Pilot pilot, Race race) {
				List<DataXMLPenalty> xmlPenalties = subset.getRaceScore(pilot, race).getSimulatedPenalties();
				if (xmlPenalties == null) {
					return Collections.emptyList();
				}

				List<Penalty> penalties = new ArrayList<Penalty>(xmlPenalties.size());
				for (DataXMLPenalty xmlPenalty : xmlPenalties) {
					Penalty penalty = new Penalty(xmlPenalty.getType(), xmlPenalty.getValue(), XMLScores.wrapNull(xmlPenalty.getReason()));
					penalties.add(penalty);
				}
				return penalties;
			}
		};
	}

	@Override
	public RacePositionsData newRacePositionsData(Scores scores) {
		return new AbstractRacePositionsData<ScoredData>(scores) {
			@Override
			protected LinkedListMultimap<Integer, Pilot> calculateRacePositionsWithOrder(Race race) {
				LinkedListMultimap<Integer, Pilot> racePositions = LinkedListMultimap.create();
				for (ScoresXMLRaceScore raceScore : subset.getRaceScores(race)) {
					Pilot pilot = xmlScores.dereference(raceScore);
					racePositions.put(raceScore.getPosition(), pilot);
				}
				return racePositions;
			}
		};
	}

	@Override
	public RaceDiscardsData newRaceDiscardsData(Scores scores) {
		return new AbstractRaceDiscardsData<Scores>(scores, subset.getDiscards()) {
			@Override
			protected List<Race> calculateDiscardedRaces(Pilot pilot) {
				List<Race> races = new ArrayList<Race>();
				if (discards > 0) {
					for (ScoresXMLRaceDiscard race : subset.getOverallScore(pilot).getDiscards()) {
						races.add(xmlScores.dereference(race));
					}
				}
				return races;
			}
		};
	}

	@Override
	public OverallPenaltiesData newOverallPenaltiesData(Scores scores) {
		return new AbstractOverallPenaltiesData<ScoredData>(scores) {
			@Override
			protected int calculateOverallPenalties(Pilot pilot) {
				return subset.getOverallScore(pilot).getPenalties();
			}

			@Override
			protected List<Penalty> calculateSimulatedOverallPenalties(Pilot pilot) {
				List<DataXMLPenalty> xmlPenalties = subset.getOverallScore(pilot).getSimulatedPenalties();
				if (xmlPenalties == null) {
					return Collections.emptyList();
				}

				List<Penalty> penalties = new ArrayList<Penalty>(xmlPenalties.size());
				for (DataXMLPenalty xmlPenalty : xmlPenalties) {
					Penalty penalty = new Penalty(xmlPenalty.getType(), xmlPenalty.getValue(), XMLScores.wrapNull(xmlPenalty.getReason()));
					penalties.add(penalty);
				}
				return penalties;
			}
		};
	}

	@Override
	public OverallPointsData newOverallPointsData(Scores scores) {
		return new AbstractOverallPointsData<ScoredData>(scores) {
			@Override
			protected int calculateOverallPoints(Pilot pilot) {
				return subset.getOverallScore(pilot).getPoints();
			}
		};
	}

	@Override
	public OverallPositionData newOverallPositionData(Scores scores) {
		return new AbstractOverallPositionData<ScoredData>(scores) {
			@Override
			protected LinkedListMultimap<Integer, Pilot> calculateOverallPositionsWithOrder() {
				LinkedListMultimap<Integer, Pilot> overallPositions = LinkedListMultimap.create();
				for (ScoresXMLOverallScore overallScore : subset.getOverallScores()) {
					Pilot pilot = xmlScores.dereference(overallScore);
					overallPositions.put(overallScore.getPosition(), pilot);
				}
				return overallPositions;
			}
		};
	}
}