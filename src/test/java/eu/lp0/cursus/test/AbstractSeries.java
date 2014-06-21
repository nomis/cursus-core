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
package eu.lp0.cursus.test;

import java.util.List;

import eu.lp0.cursus.scoring.scorer.Scorer;
import eu.lp0.cursus.scoring.scorer.ScorerFactory;
import eu.lp0.cursus.test.db.AbstractDatabaseTest;
import eu.lp0.cursus.xml.scores.ScoresXMLFile;

public abstract class AbstractSeries extends AbstractDatabaseTest {
	protected final String SERIES_NAME;
	protected final Scorer scorer;

	public AbstractSeries(String seriesName, String scorerUUID) {
		this.SERIES_NAME = seriesName;
		this.scorer = ScorerFactory.newScorer(scorerUUID);
	}

	public abstract void createAllData() throws Exception;

	public abstract List<ScoresXMLFile> createScores() throws Exception;
}
