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
package uk.uuid.cursus.scoring.data;

public interface ScoresFactorySubset {
	public RaceLapsData newRaceLapsData(Scores scores);

	public RacePointsData newRacePointsData(Scores scores);

	public RacePenaltiesData newRacePenaltiesData(Scores scores);

	public RacePositionsData newRacePositionsData(Scores scores);

	public RaceDiscardsData newRaceDiscardsData(Scores scores);

	public OverallPenaltiesData newOverallPenaltiesData(Scores scores);

	public OverallPointsData newOverallPointsData(Scores scores);

	public OverallPositionData newOverallPositionData(Scores scores);
}