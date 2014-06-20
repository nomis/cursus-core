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
package org.spka.cursus.test.series_2011;

import java.io.File;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.io.Closeables;

import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.db.data.Event;
import eu.lp0.cursus.db.data.Race;
import eu.lp0.cursus.db.data.Series;
import eu.lp0.cursus.scoring.data.Scores;
import eu.lp0.cursus.test.util.XMLNamespaces;
import eu.lp0.cursus.xml.ExportException;
import eu.lp0.cursus.xml.scores.ScoresXMLFile;

public class Series2011Results extends AbstractSeries2011 {
	@Test
	public void checkSchema() throws Exception {
		Scores seriesScores;
		List<Scores> eventScores = new ArrayList<Scores>();
		List<Scores> raceScores = new ArrayList<Scores>();
		final ScoresXMLFile export;

		createSeriesData();

		db.startSession();
		try {
			DatabaseSession.begin();

			Series series = seriesDAO.find(SERIES_NAME);
			seriesScores = scorer.scoreSeries(series, Predicates.in(getSeriesResultsPilots(series)));

			for (Event event : series.getEvents()) {
				if (!event.getRaces().isEmpty()) {
					eventScores.add(scorer.scoreRaces(event.getRaces(), Predicates.in(getEventResultsPilots(series, event))));

					for (Race race : event.getRaces()) {
						raceScores.add(scorer.scoreRaces(Collections.singletonList(race), Predicates.in(getEventResultsPilots(series, event))));
					}
				}
			}

			export = new ScoresXMLFile(seriesScores, eventScores, raceScores);
			debugPrintScores(seriesScores);

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}

		PipedInputStream in = new PipedInputStream();
		final PipedOutputStream out = new PipedOutputStream(in);
		Source xmlFile = new StreamSource(in);

		new Thread() {
			@Override
			public void run() {
				try {
					export.to(out);
				} catch (ExportException e) {
					e.printStackTrace();
				} finally {
					try {
						Closeables.close(out, true);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

		SchemaFactory factory = SchemaFactory.newInstance(XMLNamespaces.RESULTS_V1.uri);
		Source schemaFile = new StreamSource(new File("src/xml/xsd/" + XMLNamespaces.RESULTS_V1.filename)); //$NON-NLS-1$
		Schema schema = factory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		validator.validate(xmlFile);
	}
}