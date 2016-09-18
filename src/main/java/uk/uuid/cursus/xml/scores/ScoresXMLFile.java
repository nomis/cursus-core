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

import java.util.List;

import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.xml.ImportException;
import uk.uuid.cursus.xml.common.AbstractXMLFile;

import com.google.common.io.ByteSource;

public class ScoresXMLFile extends AbstractXMLFile<ScoresXML> {
	public ScoresXMLFile() {
		super(ScoresXML.class);
	}

	public ScoresXMLFile(Scores seriesScores, List<Scores> eventScores, List<Scores> raceScores) {
		super(ScoresXML.class, new ScoresXML(seriesScores, eventScores, raceScores));
	}

	public ScoresXMLFile(ByteSource data) throws ImportException {
		super(ScoresXML.class, data);
	}
}