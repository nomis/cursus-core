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
package uk.me.sa.cursus.app;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Ignore;
import org.spka.cursus.test.series_2008.Series2008;

import com.google.common.base.Predicates;
import com.google.common.io.Files;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.scoring.data.Scores;
import eu.lp0.cursus.xml.scores.ScoresXML;
import eu.lp0.cursus.xml.scores.ScoresXMLFile;
import eu.lp0.cursus.xml.scores.XMLScores;
import eu.lp0.cursus.xml.scores.results.ScoresXMLEventResults;
import eu.lp0.cursus.xml.scores.results.ScoresXMLRaceResults;

public class ExportSPKASeries2008 {
	public static final String FILE_NAME = "spka_2008-09"; //$NON-NLS-1$
	public static final File SERIES_FILE1 = new File("target/" + FILE_NAME + ".xml"); //$NON-NLS-1$ //$NON-NLS-2$
	public static final File SERIES_FILE2 = new File("target/_" + FILE_NAME + ".xml"); //$NON-NLS-1$ //$NON-NLS-2$

	@Ignore
	public static class AllScores extends Series2008 {
		public final ScoresXMLFile export;

		public AllScores() throws Exception {
			Scores seriesScores;
			List<Scores> eventScores = new ArrayList<Scores>();
			List<Scores> raceScores = new ArrayList<Scores>();

			createAllData();

			db.startSession();
			try {
				DatabaseSession.begin();

				Series series = seriesDAO.find(SERIES_NAME);
				seriesScores = scorer.scoreSeries(series, Predicates.in(getSeriesResultsPilots(series)));

				for (Event event : series.getEvents()) {
					eventScores.add(scorer.scoreRaces(event.getRaces(), Predicates.in(getEventResultsPilots(series, event))));

					for (Race race : event.getRaces()) {
						raceScores.add(scorer.scoreRaces(Collections.singletonList(race), Predicates.in(getEventResultsPilots(series, event))));
					}
				}

				export = new ScoresXMLFile(seriesScores, eventScores, raceScores);

				DatabaseSession.commit();
			} finally {
				db.endSession();
			}

			closeDatabase();
		}
	}

	public static void main(String[] args) throws Exception {
		ScoresXMLFile export1 = new AllScores().export;
		export1.to(SERIES_FILE1);

		ScoresXMLFile import_ = new ScoresXMLFile();
		import_.from(SERIES_FILE1);

		ScoresXML file = import_.getData();
		Scores seriesScores;
		List<Scores> eventScores = new ArrayList<Scores>();
		List<Scores> raceScores = new ArrayList<Scores>();
		XMLScores xmlScores = new XMLScores(file);
		seriesScores = xmlScores.newInstance(file.getSeriesResults());
		for (ScoresXMLEventResults scores : file.getEventResults()) {
			eventScores.add(xmlScores.newInstance(scores));
		}
		for (ScoresXMLRaceResults scores : file.getRaceResults()) {
			raceScores.add(xmlScores.newInstance(scores));
		}

		ScoresXMLFile export2 = new ScoresXMLFile(seriesScores, eventScores, raceScores);
		export2.to(SERIES_FILE2);

		BufferedWriter bw;
		bw = Files.newWriter(new File("target/" + FILE_NAME + "_tabs.xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
		bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-menu.xsl\"?>\n"); //$NON-NLS-1$
		bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
		bw.write("\t<load href=\"" + FILE_NAME + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
		bw.write("</cursus>\n"); //$NON-NLS-1$
		bw.close();

		bw = Files.newWriter(new File("target/" + FILE_NAME + "_simple.xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
		bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-simple.xsl\"?>\n"); //$NON-NLS-1$
		bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
		bw.write("\t<load href=\"" + FILE_NAME + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
		bw.write("</cursus>\n"); //$NON-NLS-1$
		bw.close();

		bw = Files.newWriter(new File("target/" + FILE_NAME + "_split-series1.xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
		bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-split.xsl\"?>\n"); //$NON-NLS-1$
		bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
		bw.write("\t<load href=\"" + FILE_NAME + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
		bw.write("\t<split prefix=\"" + FILE_NAME + "_split-\" type=\"series\" index=\"1\" suffix=\".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		bw.write("</cursus>\n"); //$NON-NLS-1$
		bw.close();

		for (int i = 1; i <= file.getEventResults().size(); i++) {
			bw = Files.newWriter(new File("target/" + FILE_NAME + "_split-event" + i + ".xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
			bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-split.xsl\"?>\n"); //$NON-NLS-1$
			bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
			bw.write("\t<load href=\"" + FILE_NAME + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
			bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
			bw.write("\t<split prefix=\"" + FILE_NAME + "_split-\" type=\"event\" index=\"" + i + "\" suffix=\".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			bw.write("</cursus>\n"); //$NON-NLS-1$
			bw.close();
		}

		for (int i = 1; i <= file.getRaceResults().size(); i++) {
			bw = Files.newWriter(new File("target/" + FILE_NAME + "_split-race" + i + ".xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
			bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-split.xsl\"?>\n"); //$NON-NLS-1$
			bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
			bw.write("\t<load href=\"" + FILE_NAME + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
			bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
			bw.write("\t<split prefix=\"" + FILE_NAME + "_split-\" type=\"race\" index=\"" + i + "\" suffix=\".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			bw.write("</cursus>\n"); //$NON-NLS-1$
			bw.close();
		}
	}
}