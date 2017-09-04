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

import org.fisly.cursus.scoring.FISLYConstants;
import org.fisly.cursus.test.europe_2017.FISLYSeries2017;
import org.spka.cursus.scoring.CCConstants;

public class ExportFISLYEurope2017Class8 extends ExportSeries {
	public ExportFISLYEurope2017Class8(String type, String desc, String scorer) {
		super("fislyEurope2017Class8_" + type, new FISLYSeries2017(type, desc, scorer), false); //$NON-NLS-1$
	}

	public ExportFISLYEurope2017Class8(String type, String desc, String scorer, String... stylesheets) {
		super("fislyEurope2017Class8_" + type, new FISLYSeries2017(type, desc, scorer), false, stylesheets); //$NON-NLS-1$
	}

	public static void main(String[] args) throws Exception {
		new ExportFISLYEurope2017Class8("a", "Combined", FISLYConstants.UUID_2010).export(); //$NON-NLS-1$ //$NON-NLS-2$
		new ExportFISLYEurope2017Class8("m", "Men", FISLYConstants.UUID_2010).export(); //$NON-NLS-1$ //$NON-NLS-2$
		new ExportFISLYEurope2017Class8("f", "Women", FISLYConstants.UUID_2010).export(); //$NON-NLS-1$ //$NON-NLS-2$
		new ExportFISLYEurope2017Class8("c", "Top Country", CCConstants.UUID_2008, "spka-cc.css").export(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		new ExportFISLYEurope2017Class8("x", "Top Country", CCConstants.UUID_2013, "spka-cc.css").export(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}