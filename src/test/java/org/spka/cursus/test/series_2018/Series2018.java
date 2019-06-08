/*
	cursus - Race series management program
	Copyright 2018-2019  Simon Arlott

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

import uk.uuid.cursus.db.data.Penalty;

@SuppressWarnings("nls")
public class Series2018 extends AbstractSPKASeries {
	public Series2018() {
		super("SPKA Race Series 2018/19", SPKAConstants.UUID_2012); //$NON-NLS-1$
	}

	protected static final int SERIES_FLEET = 8;
	protected static final int SERIES_FLEET_AT_EVENT1 = 7;
	protected static final int SERIES_FLEET_AT_EVENT2 = 8;
	protected static final int SERIES_FLEET_AT_EVENT3 = 8;
	protected static final int SERIES_FLEET_AT_EVENT4 = 8;
	protected static final int SERIES_FLEET_AT_EVENT5 = 8;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
		createEvent2Races();
		createEvent3Races();
		createEvent4Races();
		createEvent5Races();
	}

	@Override
	public void createDatabase() throws Exception {
		super.createDatabase();

		addSeries();
		addPilot("SCO018@2010", MALE, "Scotland");
		addPilot("SCO045@2016", MALE, "Scotland");
		addPilot("SCO066@2013", MALE, "Scotland");
		addPilot("SCO116@2010", MALE, "Scotland");
		addPilot("SCO159@2005", MALE, "Scotland");
		addPilot("SCO179@2005", MALE, "Scotland");
		addPilot("SCO296@2013", FEMALE, "Scotland");
		addPilot("SCO808@2010", MALE, "Scotland");

		addAlias("SCO116", "SCO012", "SCO001");
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

	protected void createEvent2Races() throws Exception {
		addEvent(2, "West Sands (12/01/2019)");

		addRace(2, 4, "West Sands (12/01/2019)");
		addAttendees(2, 4, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(2, 4, "12,80,66,18,45,296");
		addLaps(2, 4, "12,80,66,18,45,296");
		addLaps(2, 4, "12,80,66,18,45,296");
		addLaps(2, 4, "12,80,66,18,45");
		addLaps(2, 4, "12,80,66");
		addLaps(2, 4, "12");

		addRace(2, 5, "West Sands (12/01/2019)");
		addAttendees(2, 5, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(2, 5, "12,80,45,66,18");
		addLaps(2, 5, "12,80,66,45,18");
		addLaps(2, 5, "12,80,18,66,45");
		addLaps(2, 5, "12,80,66,18,45");
		addLaps(2, 5, "12");
		addLaps(2, 5, "12");

		addRace(2, 6, "West Sands (12/01/2019)");
		addAttendees(2, 6, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(2, 6, "12,80,66,18,45,296");
		addLaps(2, 6, "12,80,66,18,45,296");
		addLaps(2, 6, "12,80,66,18,45,296");
		addLaps(2, 6, "12,66,45,18,80");
		addLaps(2, 6, "12,66");
		addLaps(2, 6, "12");

		addRace(2, 7, "West Sands (12/01/2019)");
		addAttendees(2, 7, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(2, 7, "12,80,66");
		addLaps(2, 7, "12,80,66");
		addLaps(2, 7, "12,80,66");
		addLaps(2, 7, "12,66,80");
		addLaps(2, 7, "12,66,80");
		addLaps(2, 7, "12,66,80");
	}

	protected void createEvent3Races() throws Exception {
		addEvent(3, "West Sands (23/02/2019)");

		addRace(3, 8, "West Sands (23/02/2019)");
		addAttendees(3, 8, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(3, 8, "12,79,80,66,45");
		addLaps(3, 8, "12,79,66,80,45");
		addLaps(3, 8, "12,80,66,79");
		addLaps(3, 8, "12,80,66,79");

		addRace(3, 9, "West Sands (23/02/2019)");
		addAttendees(3, 9, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO296", "SCO808");
		addLaps(3, 9, "79,12,80,66");
		addLaps(3, 9, "12,79,80,66");
		addLaps(3, 9, "12,80,66");
		addLaps(3, 9, "12,80,66");
	}

	protected void createEvent4Races() throws Exception {
		addEvent(4, "Luce Bay (11/05/2019)");

		addRace(4, 10, "Luce Bay (11/05/2019)");
		addAttendees(4, 10, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(4, 10, "1,80,66,159,18,45,79");
		addLaps(4, 10, "1,80,18,159,79,45");
		addLaps(4, 10, "1,80,159,79,18,45");
		addLaps(4, 10, "1,80,79,18,159");
		addLaps(4, 10, "1,80");

		addRace(4, 11, "Luce Bay (11/05/2019)");
		addAttendees(4, 11, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addPenalty(4, 11, "SCO066", new Penalty(Penalty.Type.AUTOMATIC, "Hit finish mark"));
		addLaps(4, 11, "79,1,80,66,45,159,18,296");
		addLaps(4, 11, "1,79,80,66,45,159,18");
		addLaps(4, 11, "1,79,80,45,66,159,18");
		addLaps(4, 11, "1,79,80,45,66");
		addLaps(4, 11, "80,79,1,45");

		addRace(4, 12, "Luce Bay (11/05/2019)");
		addAttendees(4, 12, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(4, 12, "1,79,80,66,45,296,159");
		addLaps(4, 12, "1,79,80,66,45,159,296");
		addLaps(4, 12, "1,79,80,66,45,159");
		addLaps(4, 12, "1,79,80,66,45");
		addLaps(4, 12, "1,79,80,66,45");

		addRace(4, 13, "Luce Bay (11/05/2019)");
		addAttendees(4, 13, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(4, 13, "1,80,79,66,45,18,296");
		addLaps(4, 13, "1,80,66,45,18");
		addLaps(4, 13, "80,1,66,18");
		addLaps(4, 13, "80,1,66,18");
		addLaps(4, 13, "80,1,66");
	}

	protected void createEvent5Races() throws Exception {
		addEvent(5, "Luce Bay (08/06/2019)");

		addRace(5, 14, "Luce Bay (08/06/2019)");
		addAttendees(5, 14, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO808");
		addLaps(5, 14, "79,1,80,66,18,45");
		addLaps(5, 14, "1,79,80,66,18,45");
		addLaps(5, 14, "1,79,66,80,18,45");
		addLaps(5, 14, "79,1,66,80,18");

		addRace(5, 15, "Luce Bay (08/06/2019)");
		addAttendees(5, 15, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO808");
		addLaps(5, 15, "1,80,79,66,18,45");
		addLaps(5, 15, "1,79,80,66,18,45");
		addLaps(5, 15, "1,79,80,66,18,45");
		addLaps(5, 15, "1,79,66,80");

		addRace(5, 16, "Luce Bay (08/06/2019)");
		addAttendees(5, 16, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO808");
		addLaps(5, 16, "80,1,79,66,18,45");
		addLaps(5, 16, "1,80,79,66,18,45");
		addLaps(5, 16, "1,80,79,66,18");

		addRace(5, 17, "Luce Bay (08/06/2019)");
		addAttendees(5, 17, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO179", "SCO808");
		addLaps(5, 17, "1,79,80,66,18,45");
		addLaps(5, 17, "1,80,66,18,79");
		addLaps(5, 17, "1,66,80,18,79");
		addLaps(5, 17, "1,66,80,18");
	}
}
