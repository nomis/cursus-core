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
package org.spka.cursus.test.series_2017;

import static uk.uuid.cursus.db.data.RaceAttendee.Type.PILOT;
import static uk.uuid.cursus.db.data.Sex.FEMALE;
import static uk.uuid.cursus.db.data.Sex.MALE;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

@SuppressWarnings("nls")
public class Series2017 extends AbstractSPKASeries {
	public Series2017() {
		super("SPKA Race Series 2017/18", SPKAConstants.UUID_2012); //$NON-NLS-1$
	}

	protected static final int SERIES_FLEET = 6;
	protected static final int SERIES_FLEET_AT_EVENT1 = 6;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
	}

	@Override
	public void createDatabase() throws Exception {
		super.createDatabase();

		addSeries();
		addPilot("SCO045@2016", MALE, "Scotland");
		addPilot("SCO116@2010", MALE, "Scotland");
		addPilot("SCO159@2005", MALE, "Scotland");
		addPilot("SCO179@2005", MALE, "Scotland");
		addPilot("SCO296@2013", FEMALE, "Scotland");
		addPilot("SCO561@2012", MALE, "Scotland");
		addPilot("SCO808@2010", MALE, "Scotland");

		addAlias("SCO116", "SCO001");
	}

	protected void createEvent1Races() throws Exception {
		addEvent(1, "West Sands (07/10/2017 and 08/10/2017)");

		addRace(1, 1, "West Sands (07/10/2017)");
		addAttendees(1, 1, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO561", "SCO808");
		addLaps(1, 1, "1,808,1,808,1,561,808,1,808,45");
		addLaps(1, 1, "1,808,1,808,1,808,45");

		addRace(1, 2, "West Sands (07/10/2017)");
		addAttendees(1, 2, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO561", "SCO808");
		addLaps(1, 2, "1,808,45,1,808,296,1,808,45,1,808");
		addLaps(1, 2, "296,45,1,808,1,45,296,808,1,808,45");
		addLaps(1, 2, "296,1,808,296");

		addRace(1, 3, "West Sands (08/10/2017)");
		addAttendees(1, 3, PILOT, "SCO116", "SCO159", "SCO179", "SCO296", "SCO561", "SCO808");
		addLaps(1, 3, "1,808,1,1,808,159");
	}
}