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
package org.spka.cursus.test.cc_2018;

import static uk.uuid.cursus.db.data.RaceAttendee.Type.PILOT;
import static uk.uuid.cursus.db.data.Sex.MALE;

import org.fisly.cursus.scoring.FISLYConstants;
import org.spka.cursus.scoring.CCConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import uk.uuid.cursus.db.data.Penalty;
import uk.uuid.cursus.db.data.Penalty.Type;

@SuppressWarnings("nls")
public class CCSeries2018 extends AbstractSPKASeries {
	protected boolean top4;

	public CCSeries2018(boolean top4) {
		super("Celtic Challenge 2018", top4 ? CCConstants.UUID_2013 : FISLYConstants.UUID_2010, "Scotland", "Ireland");
		this.top4 = top4;
	}

	protected static final int SERIES_FLEET = 10;
	protected static final int SERIES_FLEET_AT_EVENT1 = 10;

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
	}

	@Override
	public void createDatabase() throws Exception {
		super.createDatabase();

		addSeries();
		addPilot("SCO018@2010", MALE, "Scotland");
		addPilot("SCO116@2010", MALE, "Scotland");
		addPilot("SCO159@2005", MALE, "Scotland");
		addPilot("SCO179@2005", MALE, "Scotland");
		addPilot("SCO808@2010", MALE, "Scotland");
		addPilot("IR021@2016", MALE, "Ireland");
		addPilot("IR023@2016", MALE, "Ireland");
		addPilot("IR053@2010", MALE, "Ireland");
		addPilot("IR077@2009", MALE, "Ireland");
		addPilot("IR260@2018", MALE, "Ireland");

		addAlias("SCO018", "SCO156");
		addAlias("SCO116", "SCO001");
		addAlias("SCO159", "SCO015");
		addAlias("SCO179", "SCO079");
		addAlias("SCO808", "SCO080");
		addAlias("IR021", "IR002");
		addAlias("IR053", "IR001");
	}

	protected void createEvent1Races() throws Exception {
		addEvent(1, "Benone Strand (23/06/2018 and 24/06/2018)");

		addRace(1, 1, "Benone Strand (23/06/2018)");
		addAttendees(1, 1, PILOT, "SCO018", "SCO116", "SCO159", "SCO179", "SCO808");
		addAttendees(1, 1, PILOT, "IR021", "IR023", "IR077", "IR260");
		addLaps(1, 1, "80,1,2,156,79,77,15");
		addLaps(1, 1, "1,80,2,79,156");
		addLaps(1, 1, "1,80,2,79");
		addLaps(1, 1, "1,2,77,79,156,80");
		addLaps(1, 1, "1,79,2,15,77,23,80,156,260");

		addRace(1, 2, "Benone Strand (23/06/2018)");
		addAttendees(1, 2, PILOT, "SCO018", "SCO116", "SCO159", "SCO179", "SCO808");
		addAttendees(1, 2, PILOT, "IR021", "IR023", "IR077", "IR260");
		addLaps(1, 2, "79,80,1,2,156,77,15");
		addLaps(1, 2, "79,80,1,2,156,77,15");
		addLaps(1, 2, "79,1,80,2,156");
		addLaps(1, 2, "79,77,1,15,80,2,156");
		addLaps(1, 2, "79,1,80,15,77,2,156");
		addLaps(1, 2, "79,1,80,15,77,2,156");
		addLaps(1, 2, "79,1,80,15");
		addLaps(1, 2, "1,2,79,77,156,80");
		addLaps(1, 2, "1,79,2,15,156,77,80");
		addLaps(1, 2, "1,15,156,80,77,2");

		addRace(1, 3, "Benone Strand (24/06/2018)");
		addAttendees(1, 3, PILOT, "SCO018", "SCO116", "SCO159", "SCO179", "SCO808");
		addAttendees(1, 3, PILOT, "IR021", "IR053", "IR077", "IR260");
		addPenalty(1, 3, "IR077", new Penalty(Type.AUTOMATIC, 1, "Hit scoring line cone"));
		addLaps(1, 3, "SCO1,IR1,79,2,77,80,156,15");
		addLaps(1, 3, "79,2,IR1,SCO1,77,80,156,15");
		addLaps(1, 3, "79,77,IR1,80,156");
		addLaps(1, 3, "79,SCO1,15,77,IR1,SCO1,80");
		addLaps(1, 3, "79,156,15,77,SCO1,2,80,IR1");
		addLaps(1, 3, "79,156,SCO1,77,15,2,80,IR1");

		addRace(1, 4, "Benone Strand (24/06/2018)");
		addAttendees(1, 4, PILOT, "SCO018", "SCO116", "SCO159", "SCO179", "SCO808");
		addAttendees(1, 4, PILOT, "IR021", "IR053", "IR077", "IR260");
		addPenalty(1, 4, "IR021", new Penalty(Type.AUTOMATIC, 1, "Hit scoring line mark"));
		addLaps(1, 4, "SCO1,80,77,IR2,79,IR1,15,156");
		addLaps(1, 4, "SCO1,2,79,77,80,IR1");
		addLaps(1, 4, "SCO1,15,79,2,77,IR1,80");
		addLaps(1, 4, "SCO1,79");
		addLaps(1, 4, "SCO1,IR1,80,2,77,156,79,15");
		addLaps(1, 4, "SCO1,IR1,2,80,77,156,79,15");
	}
}