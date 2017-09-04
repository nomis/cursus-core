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
package org.fisly.cursus.test.europe_2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

import javax.annotation.Nonnull;

import org.spka.cursus.test.AbstractSPKASeries;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import uk.uuid.cursus.db.DatabaseSession;
import uk.uuid.cursus.db.data.Event;
import uk.uuid.cursus.db.data.Penalty;
import uk.uuid.cursus.db.data.Penalty.Type;
import uk.uuid.cursus.db.data.Pilot;
import uk.uuid.cursus.db.data.Series;
import uk.uuid.cursus.db.data.Sex;

@SuppressWarnings("nls")
public class FISLYSeries2017 extends AbstractSPKASeries {
	private String type;

	public FISLYSeries2017(String type, String desc, String scorer) {
		super("FISLY European Championships 2017 (" + desc + ")", scorer); //$NON-NLS-1$
		this.type = type;
	}

	@Override
	public Set<Pilot> getSeriesResultsPilots(final Series series) {
		return Sets.filter(series.getPilots(), new Predicate<Pilot>() {
			@Override
			public boolean apply(@Nonnull Pilot pilot) {
				if (type.equals("c") || type.equals("x")) {
					if (pilot.getCountry().equals("Denmark")) {
						return false;
					}
					if (pilot.getCountry().equals("Belgium")) {
						return false;
					}
					return true;
				} else {
					return type.equals("a") || pilot.getSex().name().charAt(0) == type.toUpperCase().charAt(0);
				}
			}
		});
	}

	@Override
	public Set<Pilot> getSeriesResultsPilots(final Series series, final Event event) {
		return getSeriesResultsPilots(series);
	}

	@Override
	protected boolean isStrictCountryFilter() {
		return true;
	}

	@Override
	public void createAllData() throws Exception {
		createDatabase();
		createEvent1Races();
		createEvent2Races();
		createEvent3Races();

		db.startSession();
		try {
			DatabaseSession.begin();

			for (Event event : eventDAO.findAll()) {
				event.setName(event.getName().replaceAll("Race Event ", "Day "));
				eventDAO.persist(event);
			}

			DatabaseSession.commit();
		} finally {
			db.endSession();
		}
	}

	@Override
	public void createDatabase() throws Exception {
		super.createDatabase();

		addSeries();

		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/org/fisly/cursus/test/europe_2017/Pilots.csv")));
		while (br.ready()) {
			String[] values = br.readLine().split(",");
			addPilot(values[2] + " " + values[1], values[0], Sex.valueOf(values[3]), values[4]);
		}
		br.close();
	}

	protected void createEvent1Races() throws Exception {
		addEvent(1, "Hoylake (30/08/2017)");

		for (int race = 1; race <= 3; race++) {
			addRace(1, race, "Hoylake (30/08/2017)");
			addAllAttendees(1, race);

			BufferedReader br = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream("/org/fisly/cursus/test/europe_2017/Euros_R" + race + "_data.txt")));
			while (br.ready()) {
				addLaps(1, race, br.readLine().split(" ")[0].substring(1));
			}
			br.close();
		}

		addPenalty(1, 1, "F32", new Penalty(Type.AUTOMATIC));
	}

	protected void createEvent2Races() throws Exception {
		addEvent(2, "Hoylake (31/08/2017)");

		for (int race = 4; race <= 6; race++) {
			addRace(2, race, "Hoylake (31/08/2017)");
			addAllAttendees(2, race);

			BufferedReader br = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream("/org/fisly/cursus/test/europe_2017/Euros_R" + race + "_data.txt")));
			while (br.ready()) {
				addLaps(2, race, br.readLine().split(" ")[0].substring(1));
			}
			br.close();
		}

		addPenalty(2, 4, "B45", new Penalty(Type.AUTOMATIC));
		addPenalty(2, 4, "K54", new Penalty(Type.AUTOMATIC));
		addPenalty(2, 5, "B45", new Penalty(Type.AUTOMATIC));
	}

	protected void createEvent3Races() throws Exception {
		addEvent(3, "Hoylake (01/09/2017)");

		for (int race = 7; race <= 10; race++) {
			addRace(3, race, "Hoylake (01/09/2017)");
			addAllAttendees(3, race);

			BufferedReader br = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream("/org/fisly/cursus/test/europe_2017/Euros_R" + race + "_data.txt")));
			while (br.ready()) {
				addLaps(3, race, br.readLine().split(" ")[0].substring(1));
			}
			br.close();
		}
	}
}