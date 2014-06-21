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

import org.spka.cursus.test.series_2006.Series2006;

public class ExportSPKASeries2006 extends ExportSeries {
	public ExportSPKASeries2006() {
		super("spka_2006-07", new Series2006()); //$NON-NLS-1$
	}

	public static void main(String[] args) throws Exception {
		new ExportSPKASeries2006().export();
	}
}