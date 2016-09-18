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

import org.fisly.cursus.test.europe_2011.FISLYSeries2011;
import org.junit.Test;
import org.spka.cursus.test.cc_2008.CCSeries2008;
import org.spka.cursus.test.cc_2009.CCSeries2009;
import org.spka.cursus.test.cc_2010.CCSeries2010;
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

import uk.uuid.cursus.test.AbstractSeries;

public abstract class AbstractValidateXML {
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
	public void cc2009() throws Exception {
		check(new CCSeries2009(false));
	}

	@Test
	public void cc2009top6() throws Exception {
		check(new CCSeries2009(true));
	}

	@Test
	public void cc2010() throws Exception {
		check(new CCSeries2010(false));
	}

	@Test
	public void cc2010top5() throws Exception {
		check(new CCSeries2010(true));
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

	protected abstract void check(AbstractSeries series) throws Exception;
}