/*
	cursus - Race series management program
	Copyright 2016  Simon Arlott

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
package org.spka.cursus.test.cc_2016;

import static eu.lp0.cursus.db.data.Penalty.Type.AUTOMATIC;
import static eu.lp0.cursus.db.data.RaceAttendee.Type.PILOT;
import static eu.lp0.cursus.db.data.Sex.MALE;

import org.fisly.cursus.scoring.FISLYConstants;
import org.spka.cursus.scoring.CCConstants;
import org.spka.cursus.test.AbstractSPKASeries;

import eu.lp0.cursus.db.data.Penalty;

public class CCSeries2016 extends AbstractSPKASeries {
	public CCSeries2016(boolean top3) {
		super("Celtic Challenge 2016", top3 ? CCConstants.UUID_2013 : FISLYConstants.UUID_2010, "Scotland", "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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
		addPilot("SCO116@2010", MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
		addPilot("SCO159@2005", MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
		addPilot("SCO808@2010", MALE, "Scotland"); //$NON-NLS-1$ //$NON-NLS-2$
		addPilot("IR016@2010", MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
		addPilot("IR021@2016", MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
		addPilot("IR023@2016", MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
		addPilot("IR053@2010", MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
		addPilot("IR077@2009", MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
		addPilot("IR085@2008", MALE, "Ireland"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	protected void createEvent1Races() throws Exception {
		addEvent(1, "Benone Strand (18/06/2016 and 19/06/2016)"); //$NON-NLS-1$

		addRace(1, 1, "Benone Strand (18/06/2016)"); //$NON-NLS-1$
		addAttendees(1, 1, PILOT, "SCO116", "SCO159", "SCO808"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		addAttendees(1, 1, PILOT, "IR016", "IR021", "IR023", "IR053", "IR077", "IR085"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
		addLaps(1, 1, "116,808,21,53,77,85,159,23"); //$NON-NLS-1$
		addLaps(1, 1, "116,21,808,53,85,159,77,23"); //$NON-NLS-1$
		addLaps(1, 1, "116,21,808,53,85,159,77,23"); //$NON-NLS-1$
		addLaps(1, 1, "116,21,808,53,85,159,77,23"); //$NON-NLS-1$
		addLaps(1, 1, "116,21,808,53,85,159,77"); //$NON-NLS-1$
		addLaps(1, 1, "116,21,808,53,85,159"); //$NON-NLS-1$
		addLaps(1, 1, "116,21,808,53"); //$NON-NLS-1$

		addRace(1, 2, "Benone Strand (18/06/2016)"); //$NON-NLS-1$
		addAttendees(1, 2, PILOT, "SCO116", "SCO159", "SCO808"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		addAttendees(1, 2, PILOT, "IR016", "IR021", "IR023", "IR053", "IR077", "IR085"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
		addLaps(1, 2, "21,116,53,77,159,808,23"); //$NON-NLS-1$
		addLaps(1, 2, "21,116,53,77,159"); //$NON-NLS-1$
		addLaps(1, 2, "21,116,53,77,159"); //$NON-NLS-1$
		addLaps(1, 2, "21,116,53"); //$NON-NLS-1$

		addRace(1, 3, "Benone Strand (18/06/2016)"); //$NON-NLS-1$
		addAttendees(1, 3, PILOT, "SCO116", "SCO159", "SCO808"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		addAttendees(1, 3, PILOT, "IR016", "IR021", "IR023", "IR053", "IR077", "IR085"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
		addLaps(1, 3, "21,808,116,53,159,77,85,16"); //$NON-NLS-1$
		addLaps(1, 3, "21,116,808,53,159,77,85"); //$NON-NLS-1$
		addLaps(1, 3, "21,116,53,808,159,77"); //$NON-NLS-1$
		addLaps(1, 3, "21,116,53,808,159,77"); //$NON-NLS-1$
		addLaps(1, 3, "808,116,159,53,21,77"); //$NON-NLS-1$
		addPenalty(1, 3, "SCO808", new Penalty(AUTOMATIC, "Hit scoring line mark")); //$NON-NLS-1$ //$NON-NLS-2$

		addRace(1, 4, "Benone Strand (18/06/2016)"); //$NON-NLS-1$
		addAttendees(1, 4, PILOT, "SCO116", "SCO159", "SCO808"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		addAttendees(1, 4, PILOT, "IR016", "IR021", "IR023", "IR053", "IR077", "IR085"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
		addLaps(1, 4, "116,53,159,77,808,21,23"); //$NON-NLS-1$
		addLaps(1, 4, "116,53,159,808,21,77"); //$NON-NLS-1$
		addLaps(1, 4, "116,53,159,808,77,21"); //$NON-NLS-1$
		addLaps(1, 4, "53,116,808,159"); //$NON-NLS-1$
	}
}
