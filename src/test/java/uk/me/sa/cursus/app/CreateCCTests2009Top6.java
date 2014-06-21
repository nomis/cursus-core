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
import org.spka.cursus.test.cc_2009.CCSeries2009;

@Ignore
@SuppressWarnings("nls")
public class CreateCCTests2009Top6 extends CCSeries2009 {
	public static void main(String[] args) throws Exception {
		new CreateCCTests2009Top6().createTests();
	}

	public CreateCCTests2009Top6() {
		super(true);
	}

	private void createTests() throws Exception {
		createDatabase();
		CreateSPKATests create = new CreateSPKATests(this, "cc_2009", "CCSeries2009Top6");

		createEvent1Races();
		create.generate("Series2009Top6Event1Scores");

		closeDatabase();
	}
}
