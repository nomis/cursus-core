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
import org.spka.cursus.test.cc_2008.CCSeries2008;

@Ignore
@SuppressWarnings("nls")
public class CreateCCTests2008 extends CCSeries2008 {
	public static void main(String[] args) throws Exception {
		new CreateCCTests2008().createTests();
	}

	public CreateCCTests2008() {
		super(false);
	}

	private void createTests() throws Exception {
		createDatabase();
		CreateSPKATests create = new CreateSPKATests(this, "cc_2008", "CCSeries2008");

		createEvent1Races();
		create.generate("Series2008Event1Scores");

		closeDatabase();
	}
}
