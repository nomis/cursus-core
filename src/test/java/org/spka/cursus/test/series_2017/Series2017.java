/*
	cursus - Race series management program
	Copyright 2017-2018  Simon Arlott

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

import uk.uuid.cursus.db.data.Penalty;
import uk.uuid.cursus.db.data.Penalty.Type;

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
		addPilot("SCO068@2009", MALE, "Scotland");
		addPilot("SCO116@2010", MALE, "Scotland");
		addPilot("SCO159@2005", MALE, "Scotland");
		addPilot("SCO179@2005", MALE, "Scotland");
		addPilot("SCO296@2013", FEMALE, "Scotland");
		addPilot("SCO561@2012", MALE, "Scotland");
		addPilot("SCO808@2010", MALE, "Scotland");
		addPilot("K854@2015", MALE, "England");

		addAlias("SCO116", "SCO001");
		addAlias("SCO116", "SCO011");
		addAlias("SCO159", "SCO015");
		addAlias("SCO179", "SCO079");
		addAlias("SCO808", "SCO080");
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

	protected void createEvent2Races() throws Exception {
		addEvent(2, "Luce Bay (24/02/2018 and 25/02/2018)");

		addRace(2, 4, "Luce Bay (24/02/2018)");
		addAttendees(2, 4, PILOT, "SCO018", "SCO045", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO561", "SCO808");
		addLaps(2, 4, "11,79,80,18,15,45,296,68");
		addLaps(2, 4, "11,79,80,18,45,296,68");
		addLaps(2, 4, "11,79,80,18,45,296,68");
		addLaps(2, 4, "11,79,80,18,45,296,68");
		addLaps(2, 4, "11,79,80,18,45,296");
		addLaps(2, 4, "11,79,80,18,45");
		addLaps(2, 4, "11,79,80,18,45");
		addLaps(2, 4, "11,79,80,18,45");
		addLaps(2, 4, "11,79");
		addLaps(2, 4, "11,79");

		addRace(2, 5, "Luce Bay (24/02/2018)");
		addAttendees(2, 5, PILOT, "SCO018", "SCO045", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO561", "SCO808");
		addLaps(2, 5, "11,80,68,18,15,45,296");
		addLaps(2, 5, "11,80,68,18,45,15,296");
		addLaps(2, 5, "11,80,68,45,15");
		addLaps(2, 5, "11,80,68,45,15");
		addLaps(2, 5, "11,80,68,45,15");
		addLaps(2, 5, "11,80,68,45,15");
		addLaps(2, 5, "11,80,68");
		addLaps(2, 5, "11");

		addRace(2, 6, "Luce Bay (24/02/2018)");
		addAttendees(2, 6, PILOT, "SCO018", "SCO045", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO561", "SCO808");
		addLaps(2, 6, "11,79,80,45,15,68,296");
		addLaps(2, 6, "11,79,80,45,15,68,296");
		addLaps(2, 6, "11,79,80,45,68,15,296");
		addLaps(2, 6, "11,79,80,45,68,15,296");
		addLaps(2, 6, "11,79,80,45,68,15");
		addLaps(2, 6, "11,79,80,45,68,15");
		addLaps(2, 6, "11,79,80");
		addLaps(2, 6, "11,79");

		addRace(2, 7, "Luce Bay (25/02/2018)");
		addAttendees(2, 7, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO561", "SCO808");
		addPenalty(2, 7, "SCO561", new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 7"));
		addLaps(2, 7, "11,80,79,66,18,68,45,296,561");
		addLaps(2, 7, "11,79,80,66,18,68,45,296");
		addLaps(2, 7, "11,79,80,66,18,68,45,296");
		addLaps(2, 7, "11,79,80,66,18,68,45,296");
		addLaps(2, 7, "11,80,79,66,68,18,45");
		addLaps(2, 7, "11,80,79,66,68,18,45");
		addLaps(2, 7, "11,80,79,66,68");
		addLaps(2, 7, "11,80,79");

		addRace(2, 8, "Luce Bay (25/02/2018)");
		addAttendees(2, 8, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO561", "SCO808");
		addPenalty(2, 8, "SCO159", new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 6"));
		addLaps(2, 8, "11,79,80,66,68,18,45,296");
		addLaps(2, 8, "11,79,80,66,68,18,45,296");
		addLaps(2, 8, "11,79,80,68,66,18,45");
		addLaps(2, 8, "79,11,80,66,18,68,45");
		addLaps(2, 8, "79,11,80,66,18,68");
		addLaps(2, 8, "79,11,80");

		addRace(2, 9, "Luce Bay (25/02/2018)");
		addAttendees(2, 9, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO561", "SCO808");
		addLaps(2, 9, "11,79,80,68,66,18,15,45,296");
		addLaps(2, 9, "11,79,80,68,66,15,18,45,296");
		addLaps(2, 9, "11,79,80,68,66,18,15,45,296");
		addLaps(2, 9, "11,79,80,68,18,15,45,296");
		addLaps(2, 9, "11,79,80,68,18,15,45");
		addLaps(2, 9, "11,79,80,68,18");
		addLaps(2, 9, "11,79,80");

		addRace(2, 10, "Luce Bay (25/02/2018)");
		addAttendees(2, 10, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO561", "SCO808");
		addLaps(2, 10, "11,79,80,66,68,15,45,296");
		addLaps(2, 10, "11,79,80,68,66,15,45,296");
		addLaps(2, 10, "11,79,80,68,66,15,45,296");
		addLaps(2, 10, "11,79,80,68,15,66,45,296");
		addLaps(2, 10, "11,79,80,68,15,66,45");
		addLaps(2, 10, "11,79,80,68,15,66");
		addLaps(2, 10, "11,79,80");
		addPenalty(2, 10, "SCO116", new Penalty(Penalty.Type.AUTOMATIC, "Failed to give priority on start line"));
	}

	protected void createEvent3Races() throws Exception {
		addEvent(3, "West Sands (24/03/2018 and 25/03/2018)");

		addRace(3, 11, "West Sands (24/03/2018)");
		addAttendees(3, 11, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(3, 11, "79,1,80,18,66,15,68");
		addLaps(3, 11, "79,1,80,15,66,68");
		addLaps(3, 11, "79,1,80,15,66");
		addLaps(3, 11, "79,1,80");
		addLaps(3, 11, "79,1");

		addRace(3, 12, "West Sands (24/03/2018)");
		addAttendees(3, 12, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(3, 12, "79,1,66,80,18,68,15");
		addLaps(3, 12, "79,1,66,80,68,18,15");
		addLaps(3, 12, "79,1,80,66,18,68");
		addLaps(3, 12, "79,1,66,80");
		addLaps(3, 12, "1,79");

		addRace(3, 13, "West Sands (24/03/2018)");
		addAttendees(3, 13, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(3, 13, "1,80,18,15,79,66,45");
		addLaps(3, 13, "1,80,79,18,15,45");
		addLaps(3, 13, "1,80,79,18,15");
		addLaps(3, 13, "1,80,18,79");
		addLaps(3, 13, "1,80,79,18");
		addLaps(3, 13, "1,80");

		addRace(3, 14, "West Sands (24/03/2018)");
		addAttendees(3, 14, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(3, 14, "1,79,15,80,68,66,45");
		addLaps(3, 14, "1,79,80,15,68,66,45");
		addLaps(3, 14, "1,79,80,15,68,66,45");
		addLaps(3, 14, "1,79,80,68,15,66,45");
		addLaps(3, 14, "1,79,80,15,68");
		addLaps(3, 14, "79,80,1");

		addRace(3, 15, "West Sands (25/03/2018)");
		addAttendees(3, 15, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addPenalty(3, 15, "SCO018", new Penalty(Type.AUTOMATIC, "Hit safety line mark"));
		addLaps(3, 15, "1,79,80,68,15,66,18,45");
		addLaps(3, 15, "1,79,80,68,15,18,45,66");
		addLaps(3, 15, "1,79,80,15,68,18,66,45");
		addLaps(3, 15, "79,1,80,15,68,45,66");
		addLaps(3, 15, "79,1,80,15,68");
		addLaps(3, 15, "1,79,80,68,15");
		addLaps(3, 15, "1,79,80");
		addLaps(3, 15, "1,79,80");

		addRace(3, 16, "West Sands (25/03/2018)");
		addAttendees(3, 16, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(3, 16, "1,79,80,68,15,18,66");
		addLaps(3, 16, "1,79,80,15,68,66");
		addLaps(3, 16, "1,80,79,15,68");
		addLaps(3, 16, "1,80,79,15");
		addLaps(3, 16, "1,80,79");
		addLaps(3, 16, "1,80,79");

		addRace(3, 17, "West Sands (25/03/2018)");
		addAttendees(3, 17, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(3, 17, "1,79,80,68,15,18,66,45");
		addLaps(3, 17, "1,79,80,68,15,18,45,66");
		addLaps(3, 17, "1,79,80,68,15,18,45,66");
		addLaps(3, 17, "1,79,80,68,15,45,66,18");
		addLaps(3, 17, "1,79,80,15");
		addLaps(3, 17, "1,79,80");
		addLaps(3, 17, "1,79");

		addRace(3, 18, "West Sands (25/03/2018)");
		addAttendees(3, 18, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(3, 18, "1,79,80,68,15,66,45,18");
		addLaps(3, 18, "1,79,80,68,15,66,45");
		addLaps(3, 18, "1,79,80,68,15,66");
		addLaps(3, 18, "79,80,1,68");
		addLaps(3, 18, "79,80,1");
	}

	protected void createEvent4Races() throws Exception {
		addEvent(4, "Luce Bay (21/04/2018)");

		addRace(4, 19, "Luce Bay (21/04/2018)");
		addAttendees(4, 19, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808", "K854");
		addLaps(4, 19, "1,80,854,66,18,79,45,15,296");
		addLaps(4, 19, "1,80,854,79,66,18,45");
		addLaps(4, 19, "1,80,854,79,66,18,45");
		addLaps(4, 19, "1,80,854,79,66");
		addLaps(4, 19, "1,80,854,79");

		addRace(4, 20, "Luce Bay (21/04/2018)");
		addAttendees(4, 20, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808", "K854");
		addLaps(4, 20, "854,1,80,79,15,18,45,66,296");
		addLaps(4, 20, "1,854,80,79,15,18,45,66,296");
		addLaps(4, 20, "1,854,80,79,15,45,18,66,296");
		addLaps(4, 20, "1,854,79,80,15,18,45,66,296");
		addLaps(4, 20, "1,854,79,80,15,45,18,66");
		addLaps(4, 20, "1,854,79,80");
		addLaps(4, 20, "1,854,79,80");

		addRace(4, 21, "Luce Bay (21/04/2018)");
		addAttendees(4, 21, PILOT, "SCO018", "SCO045", "SCO066", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808", "K854");
		addLaps(4, 21, "1,80,854,79,18,15,45,296");
		addLaps(4, 21, "1,79,80,854,18,15,45");
		addLaps(4, 21, "1,79,854,80,18,15,45");
		addLaps(4, 21, "1,79,854,80,18,15,45");
		addLaps(4, 21, "1,79,854,80,18");
		addLaps(4, 21, "1,79,854,80");
	}

	protected void createEvent5Races() throws Exception {
		addEvent(5, "West Sands (19/05/2018)");

		addRace(5, 22, "West Sands (19/05/2018)");
		addAttendees(5, 22, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addPenalty(5, 22, "SCO159", new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 4"));
		addPenalty(5, 22, "SCO159", new Penalty(Penalty.Type.AUTOMATIC, "Hit the chequered flag"));
		addLaps(5, 22, "1,80,68,66,15,45,79");
		addLaps(5, 22, "1,80,66,68,15,45,79");
		addLaps(5, 22, "1,80,66,68,15,45,79");
		addLaps(5, 22, "1,80,68,66,15,45");
		addLaps(5, 22, "1,80,66,68,15");
		addLaps(5, 22, "1,80,68,66");
		addLaps(5, 22, "1,80");

		addRace(5, 23, "West Sands (19/05/2018)");
		addAttendees(5, 23, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addPenalty(5, 23, "SCO159", new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 4"));
		addLaps(5, 23, "1,79,80,66,68,15,18,45");
		addLaps(5, 23, "1,79,80,15,68,66,18,45");
		addLaps(5, 23, "1,79,80,15,68,66,18,45");
		addLaps(5, 23, "1,79,80,15,68,66,18,45");
		addLaps(5, 23, "1,79,80,15,68,66,18");
		addLaps(5, 23, "1,79,80,15,68,66");
		addLaps(5, 23, "1,79");

		addRace(5, 24, "West Sands (19/05/2018)");
		addAttendees(5, 24, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addPenalty(5, 24, "SCO018", new Penalty(Penalty.Type.AUTOMATIC, "Hit mark 1"));
		addLaps(5, 24, "79,1,80,66,68,15,18,45,296");
		addLaps(5, 24, "1,79,80,66,68,15,18,45,296");
		addLaps(5, 24, "1,79,80,66,68,18,45,15,296");
		addLaps(5, 24, "1,79,80,66,68,18,45,15");
		addLaps(5, 24, "1,79,80,66,68,18,45");
		addLaps(5, 24, "1,79,80,66,68,18");
		addLaps(5, 24, "1,79,80,66,68");
		addLaps(5, 24, "1,79,80");
		addLaps(5, 24, "1,79,80");

		addRace(5, 25, "West Sands (19/05/2018)");
		addAttendees(5, 25, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(5, 25, "79,1,80,66,15,68,45,18,296");
		addLaps(5, 25, "79,1,80,66,15,68,18,45,296");
		addLaps(5, 25, "79,1,80,66,15,68,18,45,296");
		addLaps(5, 25, "79,1,80,66,15,68,18,45");
		addLaps(5, 25, "79,1,80,66,15,68,18");
		addLaps(5, 25, "79,1,80,66,68,15");
		addLaps(5, 25, "79,1,80");

		addRace(5, 26, "West Sands (19/05/2018)");
		addAttendees(5, 26, PILOT, "SCO018", "SCO045", "SCO066", "SCO068", "SCO116", "SCO159", "SCO179", "SCO296", "SCO808");
		addLaps(5, 26, "1,79,80,68,15,18,66,45,296");
		addLaps(5, 26, "1,79,80,68,15,18,66,45,296");
		addLaps(5, 26, "1,79,80,68,15,66,45,18,296");
		addLaps(5, 26, "1,79,80,68,15,66,45,18,296");
		addLaps(5, 26, "1,79,80,66,68,15,18,45");
		addLaps(5, 26, "1,79,80,66,68,15,18,45");
		addLaps(5, 26, "1,79,80,66,68,15");
		addLaps(5, 26, "1,79,80,66,68");
		addLaps(5, 26, "1,79");
	}
}