/*
	cursus - Race series management program
	Copyright 2016  Simon Arlott

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

import org.junit.Ignore;
import org.spka.cursus.test.series_2015.Series2015;

@Ignore
@SuppressWarnings("nls")
public class CreateSPKATests2015 extends Series2015 {
	public static void main(String[] args) throws Exception {
		new CreateSPKATests2015().createTests();
	}

	private void createTests() throws Exception {
		createDatabase();
		CreateSPKATests create = new CreateSPKATests(this, "series_2015", "Series2015");

		createEvent1Races();
		create.generate("Series2015Event1Scores");
		createEvent2Races();
		create.generate("Series2015Event2Scores");
		createEvent3Races();
		create.generate("Series2015Event3Scores");
		createEvent4Races();
		create.generate("Series2015Event4Scores");
		createEvent5Races();
		create.generate("Series2015Event5Scores");
		createEvent6Races();
		create.generate("Series2015Event6Scores");

		closeDatabase();
	}
}
