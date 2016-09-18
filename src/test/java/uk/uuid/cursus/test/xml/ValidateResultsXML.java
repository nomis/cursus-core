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

import java.util.Collection;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import uk.uuid.cursus.db.Database;
import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.publish.html.XSLTHTMLGenerator;
import uk.uuid.cursus.test.AbstractSeries;
import uk.uuid.cursus.xml.scores.ScoresXMLFile;

import com.google.common.io.ByteSource;

public class ValidateResultsXML extends AbstractValidateXML {
	@Override
	protected void check(AbstractSeries series) throws Exception {
		series.createAllData();

		Database db = series.getDatabase();
		db.startSession();
		try {
			DatabaseSession.begin();
			for (ScoresXMLFile scoresFile : series.createScores()) {
				XSLTHTMLGenerator gen = new XSLTHTMLGenerator("filename1", "filename2", scoresFile); //$NON-NLS-1$ //$NON-NLS-2$

				validate(gen.getMenuPage().values());

				gen.getHeaders().add("header1"); //$NON-NLS-1$
				gen.getFooters().add("footer1"); //$NON-NLS-1$
				gen.getStyleSheets().add("stylesheet1"); //$NON-NLS-1$
				gen.getFlags().put("compact-race", "10"); //$NON-NLS-1$ //$NON-NLS-2$
				gen.getClasses().put("class1", "name1"); //$NON-NLS-1$ //$NON-NLS-2$

				validate(gen.getSimplePage().values());

				gen.getHeaders().add("header2"); //$NON-NLS-1$
				gen.getFooters().add("footer2"); //$NON-NLS-1$
				gen.getStyleSheets().add("stylesheet2"); //$NON-NLS-1$
				if (series.getScorer().getClass().getSimpleName().startsWith("CCScorer")) { //$NON-NLS-1$
					gen.getFlags().put("top-country", null); //$NON-NLS-1$ 
				}
				gen.getFlags().put("compact-event", "10"); //$NON-NLS-1$ //$NON-NLS-2$
				gen.getClasses().put("class2", "name2"); //$NON-NLS-1$ //$NON-NLS-2$

				validate(gen.getSplitPages().values());
			}
			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
		db.close(true);
	}

	private static void validate(Collection<ByteSource> pages) throws Exception {
		for (ByteSource page : pages) {
			Validator validator = Namespace.RESULTS_V1.newValidator();
			validator.validate(new StreamSource(page.openStream()));
		}
	}
}
