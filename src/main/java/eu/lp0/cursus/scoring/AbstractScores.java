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
package eu.lp0.cursus.scoring;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.Race;

public abstract class AbstractScores implements Scores {
	protected final Collection<Pilot> pilots;
	protected final List<Race> races;

	public AbstractScores(Collection<Pilot> pilots, List<Race> races) {
		this.pilots = pilots;
		this.races = races;
	}

	public Collection<Pilot> getPilots() {
		return Collections.unmodifiableCollection(pilots);
	}

	public List<Race> getRaces() {
		return Collections.unmodifiableList(races);
	}
}