/*
	cursus - Race series management program
	Copyright 2018  Simon Arlott

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
package org.spka.cursus.test.series_2018;

import static uk.uuid.cursus.db.data.RaceAttendee.Type.PILOT;
import static uk.uuid.cursus.db.data.Sex.FEMALE;
import static uk.uuid.cursus.db.data.Sex.MALE;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

@SuppressWarnings("nls")
public class Series2018 extends AbstractSPKASeries {
	public Series2018() {
		super("SPKA Race Series 2018/19", SPKAConstants.UUID_2012); //$NON-NLS-1$
	}

	protected static final int SERIES_FLEET = 7;
	protected static final int SERIES_FLEET_AT_EVENT1 = 7;

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
		addPilot("SCO066@2013", MALE, "Scotland");
		addPilot("SCO116@2010", MALE, "Scotland");
		addPilot("SCO159@2005", MALE, "Scotland");
		addPilot("SCO179@2005", MALE, "Scotland");
		addPilot("SCO296@2013", FEMALE, "Scotland");
		addPilot("SCO808@2010", MALE, "Scotland");

		addAlias("SCO116", "SCO012");
		addAlias("SCO179", "SCO079");
		addAlias("SCO808", "SCO080");
	}

	protected void createEvent1Races() throws Exception {
		addEvent(1, "Luce Bay (01/12/2018)");

		addRace(1, 1, "Luce Bay (01/12/2018)");
		addAttendees(1, 1, PILOT, "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(1, 1, "79,12,80,66,79,80,12,45,66,79,12,80,66,79,45");
		addLaps(1, 1, "12,159,80,296,66,79,12,80,45,159,66,79,12,80,66");
		addLaps(1, 1, "45,159");

		addRace(1, 2, "Luce Bay (01/12/2018)");
		addAttendees(1, 2, PILOT, "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(1, 2, "79,12,80,66,45,159,79,12,66,80,45,79,12,159,80");
		addLaps(1, 2, "66,12,79,45,66,80,296,12,79,45,80,159,66");

		addRace(1, 3, "Luce Bay (01/12/2018)");
		addAttendees(1, 3, PILOT, "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(1, 3, "12,80,79,66,159,12,45,80,79,66,12,80,79,66,159");
		addLaps(1, 3, "12,45,79,80,159,66");
	}
}