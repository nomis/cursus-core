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

import java.util.List;
import java.util.Map;

import uk.uuid.cursus.db.data.Penalty;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Race;

import com.google.common.collect.Table;

public interface RacePenaltiesData {
	public Table<Pilot, Race, Integer> getRacePenalties();

	public Map<Race, Integer> getRacePenalties(Pilot pilot);

	public Map<Pilot, Integer> getRacePenalties(Race race);

	public int getRacePenalties(Pilot pilot, Race race);

	public Table<Pilot, Race, List<Penalty>> getSimulatedRacePenalties();

	public Map<Race, List<Penalty>> getSimulatedRacePenalties(Pilot pilot);

	public Map<Pilot, List<Penalty>> getSimulatedRacePenalties(Race race);

	public List<Penalty> getSimulatedRacePenalties(Pilot pilot, Race race);
}