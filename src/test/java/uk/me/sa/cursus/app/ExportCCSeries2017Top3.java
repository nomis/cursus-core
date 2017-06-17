/*
	cursus - Race series management program
	Copyright 2017  Simon Arlott

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

import org.spka.cursus.test.cc_2017.CCSeries2017;

public class ExportCCSeries2017Top3 extends ExportSeries {
	public ExportCCSeries2017Top3() {
		super("cc_2017_top3", new CCSeries2017(true), "spka-cc.css"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static void main(String[] args) throws Exception {
		new ExportCCSeries2017Top3().export();
	}
}