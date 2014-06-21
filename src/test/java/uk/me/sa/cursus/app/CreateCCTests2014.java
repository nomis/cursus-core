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
import org.spka.cursus.test.cc_2014.CCSeries2014;

public class CreateCCTests2014 {
	@Ignore
	public static class AllScores extends CCSeries2014 {
		@SuppressWarnings("nls")
		public AllScores() throws Exception {
			super(false);

			createDatabase();
			CreateSPKATests create = new CreateSPKATests(this, "cc_2014", "CCSeries2014");

			createEvent1Races();
			create.generate("Series2014Event1Scores");
			createEvent2Races();
			create.generate("Series2014Event2Scores");

			closeDatabase();
		}
	}

	public static void main(String[] args) throws Exception {
		new AllScores();
	}
}
