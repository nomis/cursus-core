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
package org.spka.cursus.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import org.fisly.cursus.test.europe_2011.FISLYSeries2011;
import org.junit.Test;
import org.spka.cursus.test.cc_2008.CCSeries2008;
import org.spka.cursus.test.cc_2013.CCSeries2013;
import org.spka.cursus.test.cc_2014.CCSeries2014;
import org.spka.cursus.test.series_2005.Series2005;
import org.spka.cursus.test.series_2006.Series2006;
import org.spka.cursus.test.series_2007.Series2007;
import org.spka.cursus.test.series_2008.Series2008;
import org.spka.cursus.test.series_2009.Series2009;
import org.spka.cursus.test.series_2010.Series2010;
import org.spka.cursus.test.series_2011.Series2011;
import org.spka.cursus.test.series_2012.Series2012;
import org.spka.cursus.test.series_2013.Series2013;

import eu.lp0.cursus.db.Database;
import eu.lp0.cursus.db.DatabaseSession;
import eu.lp0.cursus.test.AbstractSeries;
import eu.lp0.cursus.test.xml.Namespace;
import eu.lp0.cursus.xml.scores.ScoresXMLFile;

public class ValidateScoresXML {
	@Test
	public void fisly2011() throws Exception {
		check(new FISLYSeries2011());
	}

	@Test
	public void series2005() throws Exception {
		check(new Series2005());
	}

	@Test
	public void series2006() throws Exception {
		check(new Series2006());
	}

	@Test
	public void series2007() throws Exception {
		check(new Series2007());
	}

	@Test
	public void series2008() throws Exception {
		check(new Series2008());
	}

	@Test
	public void series2009() throws Exception {
		check(new Series2009());
	}

	@Test
	public void series2010() throws Exception {
		check(new Series2010());
	}

	@Test
	public void series2011() throws Exception {
		check(new Series2011());
	}

	@Test
	public void series2012() throws Exception {
		check(new Series2012());
	}

	@Test
	public void series2013() throws Exception {
		check(new Series2013());
	}

	@Test
	public void cc2008() throws Exception {
		check(new CCSeries2008(false));
	}

	@Test
	public void cc2008top3() throws Exception {
		check(new CCSeries2008(true));
	}

	@Test
	public void cc2013() throws Exception {
		check(new CCSeries2013(false));
	}

	@Test
	public void cc2013top5() throws Exception {
		check(new CCSeries2013(true));
	}

	@Test
	public void cc2014() throws Exception {
		check(new CCSeries2014(false));
	}

	@Test
	public void cc2014top3() throws Exception {
		check(new CCSeries2014(true));
	}

	private static void check(AbstractSeries series) throws Exception {
		series.createAllData();

		Database db = series.getDatabase();
		db.startSession();
		try {
			DatabaseSession.begin();
			for (ScoresXMLFile scoresFile : series.createScores()) {
				validate(scoresFile);
			}
			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
		db.close(true);
	}

	private static void validate(ScoresXMLFile scores) throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		scores.to(os);

		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		Validator validator = Namespace.SCORES_V1.newValidator();
		validator.validate(new StreamSource(is));
	}
}