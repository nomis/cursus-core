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
package uk.uuid.cursus.xml.scores.ref;

import uk.uuid.cursus.db.data.Race;
import uk.uuid.cursus.xml.common.AbstractXMLEntity;
import uk.uuid.cursus.xml.data.ref.DataXMLRaceRef;

public class ScoresXMLRaceDiscard implements DataXMLRaceRef {
	public ScoresXMLRaceDiscard() {
	}

	public ScoresXMLRaceDiscard(Race race_) {
		race = AbstractXMLEntity.generateId(race_);
	}

	private String race;

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
}