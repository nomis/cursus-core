/*
	cursus - Race series management program
	Copyright 2019-2020  Simon Arlott

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
package org.spka.cursus.test.series_2019;

import static uk.uuid.cursus.db.data.RaceAttendee.Type.PILOT;
import static uk.uuid.cursus.db.data.Sex.FEMALE;
import static uk.uuid.cursus.db.data.Sex.MALE;

import org.spka.cursus.scoring.SPKAConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import uk.uuid.cursus.db.data.Penalty;

@SuppressWarnings("nls")
public class Series2019 extends AbstractSPKASeries {
	public Series2019() {
		super("SPKA Race Series 2019/20", SPKAConstants.UUID_2012); //$NON-NLS-1$
	}

	protected static final int SERIES_FLEET = 8;
	protected static final int SERIES_FLEET_AT_EVENT1 = 6;
	protected static final int SERIES_FLEET_AT_EVENT2 = 8;
	protected static final int SERIES_FLEET_AT_EVENT3 = 8;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
		createEvent2Races();
		createEvent3Races();
	}

	@Override
	public void createDatabase() throws Exception {
		super.createDatabase();

		addSeries();
		addPilot("SCO018@2010", MALE, "Scotland");
		addPilot("SCO045@2016", MALE, "Scotland");
		addPilot("SCO066@2013", MALE, "Scotland");
		addPilot("SCO087@2009", MALE, "Scotland");
		addPilot("SCO116@2010", MALE, "Scotland");
		// addPilot("SCO159@2005", MALE, "Scotland");
		addPilot("SCO179@2005", MALE, "Scotland");
		addPilot("SCO296@2013", FEMALE, "Scotland");
		addPilot("SCO808@2010", MALE, "Scotland");

		addAlias("SCO116", "SCO001");
		addAlias("SCO179", "SCO002");
		addAlias("SCO808", "SCO003");
		addAlias("SCO066", "SCO004");
	}

	protected void createEvent1Races() throws Exception {
		addEvent(1, "Luce Bay (05/10/2019 and 06/10/2019)");

		addRace(1, 1, "Luce Bay (05/10/2019)");
		addAttendees(1, 1, PILOT, "SCO018", "SCO116", "SCO179", "SCO808");
		addLaps(1, 1, "3,1,2,18");
		// addLaps(1, 1, "3");
		addLaps(1, 1, "1,2,18,1,3,2,18,1,3,2,3,1,18,2");
		addLaps(1, 1, "3,1,18,2,3,1,2,18");

		addRace(1, 2, "Luce Bay (05/10/2019)");
		addAttendees(1, 2, PILOT, "SCO018", "SCO116", "SCO179", "SCO808");
		addPenalty(1, 2, "SCO808", new Penalty(Penalty.Type.AUTOMATIC, "Ran over start line marker at start"));
		addLaps(1, 2, "2,1,3,18");
		addLaps(1, 2, "2,3,1,18,1,3,18,1,3,18,1,3,1,3,18,2");

		addRace(1, 3, "Luce Bay (05/10/2019)");
		addAttendees(1, 3, PILOT, "SCO018", "SCO116", "SCO179", "SCO808");
		addLaps(1, 3, "1,3,2,18");
		addLaps(1, 3, "1,3,2,1,3,2,1,3,2,1,2,3,1,2,3");

		addRace(1, 4, "Luce Bay (05/10/2019)");
		addAttendees(1, 4, PILOT, "SCO018", "SCO116", "SCO179", "SCO808");
		addLaps(1, 4, "3,1,2,18");
		addLaps(1, 4, "1,3,2,18,1,3,2,18,1,3,2,18,1,3,2");
		addLaps(1, 4, "1,3,2");

		addRace(1, 5, "Luce Bay (06/10/2019)");
		addAttendees(1, 5, PILOT, "SCO018", "SCO066", "SCO087", "SCO116", "SCO179", "SCO808");
		addLaps(1, 5, "2,3,4,18,1");
		addLaps(1, 5, "2,4,3,1,18,2,4,3,87,1,2,18,4");
		addLaps(1, 5, "3,1,2,4,3,1,2,18,4,3,1,87");

		addRace(1, 6, "Luce Bay (06/10/2019)");
		addAttendees(1, 6, PILOT, "SCO018", "SCO066", "SCO087", "SCO116", "SCO179", "SCO808");
		addLaps(1, 6, "2,1,3,4,18,87");
		addLaps(1, 6, "2,1,3,4,18,1,2,3,87,4,1,18,2");
		addLaps(1, 6, "3,4,1,2,3,4,1,87,2,3,1,4,2");
		addLaps(1, 6, "3");

		addRace(1, 7, "Luce Bay (06/10/2019)");
		addAttendees(1, 7, PILOT, "SCO018", "SCO066", "SCO087", "SCO116", "SCO179", "SCO808");
		addLaps(1, 7, "2,1,3,4,87");
		addLaps(1, 7, "3,4,2,3,4,18,2,3,4,2,18");
		addLaps(1, 7, "3,4,2,18,3,4,2,18");

		addRace(1, 8, "Luce Bay (06/10/2019)");
		addAttendees(1, 8, PILOT, "SCO018", "SCO066", "SCO087", "SCO116", "SCO179", "SCO808");
		addLaps(1, 8, "1,3,4,2,18");
		addLaps(1, 8, "1,3,2,4,18,1,2,4,3,1,2,18");
		addLaps(1, 8, "3,4,1,2,3,4,18,1,2,3,4,1");
		addLaps(1, 8, "18,2,3,4");
	}

	protected void createEvent2Races() throws Exception {
		addEvent(2, "West Sands (30/11/2019 and 01/12/2019)");

		addRace(2, 9, "West Sands (30/11/2019)");
		addAttendees(2, 9, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(2, 9, "2,3,1,2,3,2,3,2,3,2,2,3,2");

		addRace(2, 10, "West Sands (30/11/2019)");
		addAttendees(2, 10, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(2, 10, "2,1,3,2,1,3,2,1,2,3,1,2,1,3,2,1,3");

		addRace(2, 11, "West Sands (01/12/2019)");
		addAttendees(2, 11, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(2, 11, "2,1,3,45,2,1,3,45,1,2,3,1,2,45,3");
		addLaps(2, 11, "1,2,3,45,1,2,3,1,45,2,3");
		addLaps(2, 11, "1,2,45,3,1,2,3,45");

		addRace(2, 12, "West Sands (01/12/2019)");
		addAttendees(2, 12, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(2, 12, "2,1,3,45,2,1,3,2,1,3,2,1,3,2,1,3,2,1,45,3");

		addRace(2, 13, "West Sands (01/12/2019)");
		addAttendees(2, 13, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(2, 13, "1,3,2,45,1,3,2,45,1,3,2,1,45,3,2,1,3,2,45");
		addLaps(2, 13, "1,3,2,45,1,3,2,45");
	}

	protected void createEvent3Races() throws Exception {
		addEvent(3, "West Sands (29/02/2020)");

		addRace(3, 14, "West Sands (29/02/2020)");
		addAttendees(3, 14, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(3, 14, "3,1,45,2,296");
		addLaps(3, 14, "3,1,45,2,3,1");
		addLaps(3, 14, "45,2,3,1,45,2,3,1,2,45,3");
		addLaps(3, 14, "1,2,45,3,1,2,45");

		addRace(3, 15, "West Sands (29/02/2020)");
		addAttendees(3, 15, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(3, 15, "3,1,2,45,1,3,2,296,45,1,3,2");
		addLaps(3, 15, "1,3,45,296,2,1,3,45,2,1,3,296");
		addLaps(3, 15, "45,1,2,3,45");

		addRace(3, 16, "West Sands (29/02/2020)");
		addAttendees(3, 16, PILOT, "SCO045", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(3, 16, "3,1,45,1,3,45,1,3,2,1,3,45");
		addLaps(3, 16, "1,2,3,45");
	}
}
