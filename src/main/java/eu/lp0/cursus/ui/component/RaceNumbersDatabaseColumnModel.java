/*
	cursus - Race series management program
	Copyright 2011  Simon Arlott

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.lp0.cursus.ui.component;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

import eu.lp0.cursus.db.dao.PilotDAO;
import eu.lp0.cursus.db.dao.RaceNumberDAO;
import eu.lp0.cursus.db.data.Pilot;
import eu.lp0.cursus.db.data.RaceNumber;
import eu.lp0.cursus.util.DatabaseError;
import eu.lp0.cursus.util.Messages;

public class RaceNumbersDatabaseColumnModel extends StringDatabaseColumnModel<Pilot> {
	private static final PilotDAO pilotDAO = new PilotDAO();
	private static final RaceNumberDAO raceNumberDAO = new RaceNumberDAO();

	public RaceNumbersDatabaseColumnModel(String name) {
		super(name);
	}

	public RaceNumbersDatabaseColumnModel(String name, DatabaseWindow win) {
		super(name, win, pilotDAO, Integer.MAX_VALUE);
	}

	private Iterable<RaceNumber> getRaceNumberList(Pilot row) {
		if (row.getRaceNumber() == null) {
			return Ordering.natural().sortedCopy(row.getRaceNumbers());
		} else {
			return Iterables.concat(Collections.singletonList(row.getRaceNumber()),
					Ordering.natural().sortedCopy(Sets.difference(row.getRaceNumbers(), Collections.singleton(row.getRaceNumber()))));
		}
	}

	@Override
	protected String getValue(Pilot row) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (RaceNumber raceNo : getRaceNumberList(row)) {
			if (sb.length() > 0) {
				sb.append(first ? "; " : ", "); //$NON-NLS-1$ //$NON-NLS-2$
				first = false;
			}
			sb.append(raceNo);
		}
		return sb.toString();
	}

	@Override
	protected boolean setValue(Pilot row, String values) {
		LinkedHashSet<RaceNumber> raceNos = new LinkedHashSet<RaceNumber>();

		for (String value : values.toString().split("[ ,;/]+")) { //$NON-NLS-1$
			if (value.length() > 0) {
				RaceNumber raceNo;

				try {
					raceNo = RaceNumber.valueOfFor(value, row);
				} catch (IllegalArgumentException e) {
					DatabaseError.unableToSave(win.getFrame(), getName(), String.format(Messages.getString("pilot.race-number.invalid"), value)); //$NON-NLS-1$
					return false;
				}

				if (!raceNumberDAO.isRaceNumberOk(raceNo)) {
					DatabaseError.unableToSave(win.getFrame(), getName(), String.format(Messages.getString("pilot.race-number.in-use"), raceNo)); //$NON-NLS-1$
					return false;
				}

				raceNos.add(raceNo);
			}
		}

		Iterator<RaceNumber> it = raceNos.iterator();
		row.setRaceNumber(it.hasNext() ? it.next() : null);
		row.getRaceNumbers().retainAll(raceNos);
		row.getRaceNumbers().addAll(ImmutableSet.copyOf(Sets.difference(raceNos, row.getRaceNumbers())));
		return true;
	}
}