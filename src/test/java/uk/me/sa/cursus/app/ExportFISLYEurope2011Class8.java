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
package uk.me.sa.cursus.app;

import java.io.File;

import org.fisly.cursus.test.europe_2011.FISLYSeries2011;
import org.junit.Ignore;

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.db.data.Sex;
import uk.uuid.cursus.scoring.data.Scores;
import uk.uuid.cursus.scoring.scorer.FleetFilter;
import uk.uuid.cursus.xml.scores.ScoresXML;
import uk.uuid.cursus.xml.scores.ScoresXMLFile;
import uk.uuid.cursus.xml.scores.XMLScores;

public class ExportFISLYEurope2011Class8 {
	public static final File SERIES_FILE_A1 = new File("target/fislyEurope2011Class8_a1.xml"); //$NON-NLS-1$
	public static final File SERIES_FILE_A2 = new File("target/fislyEurope2011Class8_a2.xml"); //$NON-NLS-1$
	public static final File SERIES_FILE_M1 = new File("target/fislyEurope2011Class8_m1.xml"); //$NON-NLS-1$
	public static final File SERIES_FILE_M2 = new File("target/fislyEurope2011Class8_m2.xml"); //$NON-NLS-1$
	public static final File SERIES_FILE_F1 = new File("target/fislyEurope2011Class8_f1.xml"); //$NON-NLS-1$
	public static final File SERIES_FILE_F2 = new File("target/fislyEurope2011Class8_f2.xml"); //$NON-NLS-1$

	@Ignore
	public static class AllScores extends FISLYSeries2011 {
		public final ScoresXMLFile exportA;
		public final ScoresXMLFile exportM;
		public final ScoresXMLFile exportF;

		public AllScores() throws Exception {
			Scores seriesScoresA;
			Scores seriesScoresM;
			Scores seriesScoresF;

			createAllData();

			db.startSession();
			try {
				DatabaseSession.begin();

				Series series = seriesDAO.find(SERIES_NAME);
				seriesScoresA = scorer.scoreSeries(series);
				seriesScoresM = scorer.scoreSeries(series, FleetFilter.from(Sex.MALE));
				seriesScoresF = scorer.scoreSeries(series, FleetFilter.from(Sex.FEMALE));

				exportA = new ScoresXMLFile(seriesScoresA, null, null);
				exportM = new ScoresXMLFile(seriesScoresM, null, null);
				exportF = new ScoresXMLFile(seriesScoresF, null, null);

				DatabaseSession.commit();
			} finally {
				db.endSession();
			}

			closeDatabase();
		}
	}

	public static void main(String[] args) throws Exception {
		AllScores allScores = new AllScores();

		{
			ScoresXMLFile export1 = allScores.exportA;
			export1.to(SERIES_FILE_A1);

			ScoresXMLFile import_ = new ScoresXMLFile();
			import_.from(SERIES_FILE_A1);

			ScoresXML file = import_.getData();
			Scores seriesScores;
			XMLScores xmlScores = new XMLScores(file);
			seriesScores = xmlScores.newInstance(file.getSeriesResults());

			ScoresXMLFile export2 = new ScoresXMLFile(seriesScores, null, null);
			export2.to(SERIES_FILE_A2);
		}

		{
			ScoresXMLFile export1 = allScores.exportM;
			export1.to(SERIES_FILE_M1);

			ScoresXMLFile import_ = new ScoresXMLFile();
			import_.from(SERIES_FILE_M1);

			ScoresXML file = import_.getData();
			Scores seriesScores;
			XMLScores xmlScores = new XMLScores(file);
			seriesScores = xmlScores.newInstance(file.getSeriesResults());

			ScoresXMLFile export2 = new ScoresXMLFile(seriesScores, null, null);
			export2.to(SERIES_FILE_M2);
		}

		{
			ScoresXMLFile export1 = allScores.exportF;
			export1.to(SERIES_FILE_F1);

			ScoresXMLFile import_ = new ScoresXMLFile();
			import_.from(SERIES_FILE_F1);

			ScoresXML file = import_.getData();
			Scores seriesScores;
			XMLScores xmlScores = new XMLScores(file);
			seriesScores = xmlScores.newInstance(file.getSeriesResults());

			ScoresXMLFile export2 = new ScoresXMLFile(seriesScores, null, null);
			export2.to(SERIES_FILE_F2);
		}
	}
}