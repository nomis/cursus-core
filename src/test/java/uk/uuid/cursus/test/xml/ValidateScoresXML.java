/*
	cursus - Race series management program
	Copyright 2014  Simon Arlott

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
package uk.uuid.cursus.test.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import uk.uuid.cursus.db.Database;
import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.test.AbstractSeries;
import uk.uuid.cursus.xml.scores.ScoresXMLFile;

public class ValidateScoresXML extends AbstractValidateXML {
	@Override
	protected void check(AbstractSeries series) throws Exception {
		List<byte[]> files = new ArrayList<byte[]>();

		series.createAllData();

		Database db = series.getDatabase();
		db.startSession();
		try {
			DatabaseSession.begin();
			for (ScoresXMLFile scoresFile : series.createScores()) {
				files.add(validate(scoresFile));
			}
			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
		db.close(true);

		for (byte[] data : files) {
			ScoresXMLFile import_ = new ScoresXMLFile();
			import_.from(new ByteArrayInputStream(data));
			import_.getData();

			// TODO export, compare
			// ScoresXML file = import_.getData();
			// Scores seriesScores;
			// List<Scores> eventScores = new ArrayList<Scores>();
			// List<Scores> raceScores = new ArrayList<Scores>();
			// XMLScores xmlScores = new XMLScores(file);
			// seriesScores = xmlScores.newInstance(file.getSeriesResults());
			// for (ScoresXMLEventResults scores : file.getEventResults()) {
			// eventScores.add(xmlScores.newInstance(scores));
			// }
			// for (ScoresXMLRaceResults scores : file.getRaceResults()) {
			// raceScores.add(xmlScores.newInstance(scores));
			// }
		}

	}

	private static byte[] validate(ScoresXMLFile scores) throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		scores.to(os);

		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		Validator validator = Namespace.SCORES_V1.newValidator();
		validator.validate(new StreamSource(is));

		return os.toByteArray();
	}
}
