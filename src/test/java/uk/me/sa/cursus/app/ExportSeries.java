/*
	cursus - Race series management program
	Copyright 2014,2017  Simon Arlott

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
import java.util.Arrays;
import java.util.Map;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;

import uk.uuid.cursus.db.Database;
import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.publish.html.XSLTHTMLGenerator;
import uk.uuid.cursus.test.AbstractSeries;
import uk.uuid.cursus.xml.data.entity.DataXMLClass;
import uk.uuid.cursus.xml.scores.ScoresXMLFile;

public class ExportSeries {
	private final String fileName;
	private final AbstractSeries series;
	private final boolean local;
	private final String[] styleSheets;

	public ExportSeries(String fileName, AbstractSeries series, String... styleSheets) {
		this(fileName, series, true, styleSheets);
	}

	public ExportSeries(String fileName, AbstractSeries series, boolean local, String... styleSheets) {
		this.fileName = fileName;
		this.series = series;
		this.local = local;
		this.styleSheets = styleSheets;
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

		XSLTHTMLGenerator gen = new XSLTHTMLGenerator(fileName + ".xml", fileName, local ? "../../../src/main/resources/uk/uuid/cursus" : null, scores); //$NON-NLS-1$ //$NON-NLS-2$

		gen.setLongNames(true);
		gen.getStyleSheets().add("spka.css"); //$NON-NLS-1$
		gen.getStyleSheets().addAll(Arrays.asList(styleSheets));
		gen.getFlags().put("compact-race", "10"); //$NON-NLS-1$ //$NON-NLS-2$
		gen.getFlags().put("compact-event", "10"); //$NON-NLS-1$ //$NON-NLS-2$
		if (getClass().getName().contains("Top")) { //$NON-NLS-1$
			gen.getFlags().put("top-country", null); //$NON-NLS-1$
		}

		for (DataXMLClass class_ : scores.getData().getSeries().getClasses()) {
			if (class_.getName().equals("16\" Wheel")) { //$NON-NLS-1$
				gen.getClasses().put(class_.getName(), "16\""); //$NON-NLS-1$
			} else if (class_.getName().equals("Junior")) { //$NON-NLS-1$
				gen.getClasses().put(class_.getName(), class_.getName());
			}
		}

		for (Map.Entry<String, ByteSource> page : Iterables.concat(gen.getMenuPage().entrySet(), gen.getSimplePage().entrySet(),
				gen.getSplitPages().entrySet())) {
			page.getValue().copyTo(Files.asByteSink(new File("target" + File.separator + page.getKey()))); //$NON-NLS-1$
		}
	}
}