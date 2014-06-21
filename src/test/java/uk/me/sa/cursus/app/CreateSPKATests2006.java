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

import org.junit.Ignore;
import org.spka.cursus.test.series_2006.Series2006;

@Ignore
@SuppressWarnings("nls")
public class CreateSPKATests2006 extends Series2006 {
	public static void main(String[] args) throws Exception {
		new CreateSPKATests2006().createTests();
	}

	private void createTests() throws Exception {
		createDatabase();
		CreateSPKATests create = new CreateSPKATests(this, "series_2006", "Series2006");

		createEvent1Races();
		create.generate("Series2006Event1Scores");
		createEvent2Races();
		create.generate("Series2006Event2Scores");
		createEvent3Races();
		create.generate("Series2006Event3Scores");
		createEvent4Races();
		create.generate("Series2006Event4Scores");

		closeDatabase();
	}
}
