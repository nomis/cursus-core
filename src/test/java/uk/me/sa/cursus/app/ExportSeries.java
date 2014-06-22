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

import com.google.common.io.Files;

import eu.lp0.cursus.db.Database;
import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.test.AbstractSeries;
import eu.lp0.cursus.xml.scores.ScoresXMLFile;

public class ExportSeries {
	private final String fileName;
	private final AbstractSeries series;

	public ExportSeries(String fileName, AbstractSeries series) {
		this.fileName = fileName;
		this.series = series;
	}

	public void export() throws Exception {
		series.createAllData();

		Database db = series.getDatabase();
		db.startSession();
		try {
			DatabaseSession.begin();
			for (ScoresXMLFile scoresFile : series.createScores()) {
				export(scoresFile);
			}
			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
		db.close(true);
	}

	private void export(ScoresXMLFile scores) throws Exception {
		scores.to(new File("target" + File.separator + fileName + ".xml")); //$NON-NLS-1$ //$NON-NLS-2$

		BufferedWriter bw;
		bw = Files.newWriter(new File("target" + File.separator + fileName + "_tabs.xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
		bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-menu.xsl\"?>\n"); //$NON-NLS-1$
		bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
		bw.write("\t<load href=\"" + fileName + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
		if (getClass().getName().contains("Top")) { //$NON-NLS-1$
			bw.write("\t<flag name=\"top-country\"/>\n"); //$NON-NLS-1$
		}
		bw.write("</cursus>\n"); //$NON-NLS-1$
		bw.close();

		bw = Files.newWriter(new File("target" + File.separator + fileName + "_simple.xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
		bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-simple.xsl\"?>\n"); //$NON-NLS-1$
		bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
		bw.write("\t<load href=\"" + fileName + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
		if (getClass().getName().contains("Top")) { //$NON-NLS-1$
			bw.write("\t<flag name=\"top-country\"/>\n"); //$NON-NLS-1$
		}
		bw.write("</cursus>\n"); //$NON-NLS-1$
		bw.close();

		bw = Files.newWriter(new File("target" + File.separator + fileName + "_split-series1.xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
		bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-split.xsl\"?>\n"); //$NON-NLS-1$
		bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
		bw.write("\t<load href=\"" + fileName + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
		if (getClass().getName().contains("Top")) { //$NON-NLS-1$
			bw.write("\t<flag name=\"top-country\"/>\n"); //$NON-NLS-1$
		}
		bw.write("\t<split prefix=\"" + fileName + "_split-\" type=\"series\" index=\"1\" suffix=\".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		bw.write("</cursus>\n"); //$NON-NLS-1$
		bw.close();

		for (int i = 1; i <= scores.getData().getEventResults().size(); i++) {
			bw = Files.newWriter(new File("target" + File.separator + fileName + "_split-event" + i + ".xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
			bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-split.xsl\"?>\n"); //$NON-NLS-1$
			bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
			bw.write("\t<load href=\"" + fileName + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
			bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
			if (getClass().getName().contains("Top")) { //$NON-NLS-1$
				bw.write("\t<flag name=\"top-country\"/>\n"); //$NON-NLS-1$
			}
			bw.write("\t<split prefix=\"" + fileName + "_split-\" type=\"event\" index=\"" + i + "\" suffix=\".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			bw.write("</cursus>\n"); //$NON-NLS-1$
			bw.close();
		}

		for (int i = 1; i <= scores.getData().getRaceResults().size(); i++) {
			bw = Files.newWriter(new File("target" + File.separator + fileName + "_split-race" + i + ".xml"), Charset.forName("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
			bw.write("<?xml-stylesheet type=\"text/xsl\" href=\"../../../src/main/xml/xsl/results-html-split.xsl\"?>\n"); //$NON-NLS-1$
			bw.write("<cursus xmlns=\"urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1\">\n"); //$NON-NLS-1$
			bw.write("\t<load href=\"" + fileName + ".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
			bw.write("\t<stylesheet href=\"spka.css\"/>\n"); //$NON-NLS-1$
			if (getClass().getName().contains("Top")) { //$NON-NLS-1$
				bw.write("\t<flag name=\"top-country\"/>\n"); //$NON-NLS-1$
			}
			bw.write("\t<split prefix=\"" + fileName + "_split-\" type=\"race\" index=\"" + i + "\" suffix=\".xml\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			bw.write("</cursus>\n"); //$NON-NLS-1$
			bw.close();
		}
	}
}