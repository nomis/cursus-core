/*
	cursus - Race series management program
	Copyright 2019  Simon Arlott

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
import org.spka.cursus.scoring.CCConstants;
import org.spka.cursus.test.uk_2019.UKSeries2019;

public class ExportUKSeries2019 extends ExportSeries {
	public ExportUKSeries2019(String type, String desc, String scorer) {
		super("uk_2019" + type, new UKSeries2019(type, desc, scorer), false); //$NON-NLS-1$
	}

	public ExportUKSeries2019(String type, String desc, String scorer, String... stylesheets) {
		super("uk_2019" + type, new UKSeries2019(type, desc, scorer), false, stylesheets); //$NON-NLS-1$
	}

	public static void main(String[] args) throws Exception {
		new ExportUKSeries2019("a", "Combined", FISLYConstants.UUID_2010).export(); //$NON-NLS-1$ //$NON-NLS-2$
		new ExportUKSeries2019("m", "Men", FISLYConstants.UUID_2010).export(); //$NON-NLS-1$ //$NON-NLS-2$
		new ExportUKSeries2019("f", "Women", FISLYConstants.UUID_2010).export(); //$NON-NLS-1$ //$NON-NLS-2$
		new ExportUKSeries2019("c", "Top Country", CCConstants.UUID_2013, "spka-cc.css").export(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		new ExportUKSeries2019("dp", "Depowerable Kites", FISLYConstants.UUID_2010).export(); //$NON-NLS-1$ //$NON-NLS-2$
		new ExportUKSeries2019("fb", "Fixed Bridle Kites", FISLYConstants.UUID_2010).export(); //$NON-NLS-1$ //$NON-NLS-2$
		new ExportUKSeries2019("w", "16\" Wheels", FISLYConstants.UUID_2010).export(); //$NON-NLS-1$ //$NON-NLS-2$
	}
}