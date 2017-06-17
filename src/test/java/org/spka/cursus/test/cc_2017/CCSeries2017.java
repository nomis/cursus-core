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
package org.spka.cursus.test.cc_2017;

import static uk.uuid.cursus.db.data.RaceAttendee.Type.PILOT;
import static uk.uuid.cursus.db.data.Sex.MALE;

import org.fisly.cursus.scoring.FISLYConstants;
import org.spka.cursus.scoring.CCConstants;
import org.spka.cursus.test.AbstractSPKASeries;

@SuppressWarnings("nls")
public class CCSeries2017 extends AbstractSPKASeries {
	public CCSeries2017(boolean top3) {
		super("Celtic Challenge 2017", top3 ? CCConstants.UUID_2013 : FISLYConstants.UUID_2010, "Scotland", "Ireland");
	}

	protected static final int SERIES_FLEET = 9;
	protected static final int SERIES_FLEET_AT_EVENT1 = 9;

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
		addPilot("SCO087@2009", MALE, "Scotland");
		addPilot("SCO116@2010", MALE, "Scotland");
		addPilot("SCO159@2005", MALE, "Ireland");
		addPilot("SCO179@2005", MALE, "Scotland");
		addPilot("SCO808@2010", MALE, "Scotland");
		addPilot("IR021@2016", MALE, "Ireland");
		addPilot("IR053@2010", MALE, "Ireland");

		addAlias("SCO116", "SCO001");
		addAlias("IR021", "IR002");
		addAlias("IR053", "IR001");
	}

	protected void createEvent1Races() throws Exception {
		addEvent(1, "Luce Bay (17/06/2017)");

		addRace(1, 1, "Luce Bay (17/06/2017)");
		addAttendees(1, 1, PILOT, "SCO045", "SCO066", "SCO087", "SCO116", "SCO159", "SCO179", "SCO808");
		addAttendees(1, 1, PILOT, "IR021", "IR053");
		addLaps(1, 1, "IR2,SCO1,179");
		addLaps(1, 1, "SCO1,808,159,IR2,179");

		addRace(1, 2, "Luce Bay (17/06/2017)");
		addAttendees(1, 2, PILOT, "SCO045", "SCO066", "SCO087", "SCO116", "SCO159", "SCO179", "SCO808");
		addAttendees(1, 2, PILOT, "IR021", "IR053");
		addLaps(1, 2, "179,SCO1,IR2,IR1,66,159");
		addLaps(1, 2, "179,IR2,SCO1,IR1,66,808,159");
		addLaps(1, 2, "IR2,179,SCO1,IR1,87,66,808,159");

		addRace(1, 3, "Luce Bay (17/06/2017)");
		addAttendees(1, 3, PILOT, "SCO045", "SCO066", "SCO087", "SCO116", "SCO159", "SCO179", "SCO808");
		addAttendees(1, 3, PILOT, "IR021", "IR053");
		addLaps(1, 3, "IR2,IR1,179,SCO1,66,159,87,808,45");
		addLaps(1, 3, "IR2,179,IR1,SCO1,159,66,808,87");
		addLaps(1, 3, "IR2,179,SCO1,IR1,808,45,159,66,179");
		addLaps(1, 3, "IR2,SCO1,IR1,87,808,179");
		addLaps(1, 3, "IR2,159,SCO1,IR1,66,45,808,179,87");
		addLaps(1, 3, "SCO1,IR2,159,IR1,808,45,66,179");
		addLaps(1, 3, "SCO1,IR2,IR1,808,159,45,66");

		addRace(1, 4, "Luce Bay (17/06/2017)");
		addAttendees(1, 4, PILOT, "SCO045", "SCO066", "SCO087", "SCO116", "SCO159", "SCO179", "SCO808");
		addAttendees(1, 4, PILOT, "IR021", "IR053");
		addLaps(1, 4, "SCO1,179,808,IR2,IR1,159");
		addLaps(1, 4, "SCO1,179,45,808,IR2,IR1,66");
		addLaps(1, 4, "SCO1,87,179,159,808,IR2,IR1");
		addLaps(1, 4, "SCO1,179,66,808");
		addLaps(1, 4, "SCO1,179,159,IR1,IR2,87,808");
		addLaps(1, 4, "SCO1,66,179,IR1,808,IR2,159");

		addRace(1, 5, "Luce Bay (17/06/2017)");
		addAttendees(1, 5, PILOT, "SCO045", "SCO066", "SCO087", "SCO116", "SCO159", "SCO179", "SCO808");
		addAttendees(1, 5, PILOT, "IR021", "IR053");
		addLaps(1, 5, "179,SCO1,IR2,808,159,IR1");
		addLaps(1, 5, "179,SCO1,IR2,808,66,179");
		addLaps(1, 5, "SCO1,IR1,159,IR2,179");
		addLaps(1, 5, "SCO1,66,808,IR2,179");
		addLaps(1, 5, "SCO1,159,808,IR1,IR2,66");
	}
}
