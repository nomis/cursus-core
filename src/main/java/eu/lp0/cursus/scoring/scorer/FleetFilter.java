/*
	cursus - Race series management program
	Copyright 2012-2014  Simon Arlott

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
package eu.lp0.cursus.scoring.scorer;

import java.util.Set;

import javax.annotation.Nonnull;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import eu.lp0.cursus.db.data.Class;
import eu.lp0.cursus.db.data.Gender;
import eu.lp0.cursus.db.data.Pilot;

@SuppressFBWarnings({ "NP_PARAMETER_MUST_BE_NONNULL_BUT_MARKED_AS_NULLABLE" })
public class FleetFilter {
	public static Predicate<Pilot> from(final Set<Class> classes) {
		if (classes.isEmpty()) {
			return Predicates.alwaysTrue();
		}

		return new Predicate<Pilot>() {
			@Override
			public boolean apply(@Nonnull Pilot pilot) {
				return !Sets.intersection(pilot.getClasses(), classes).isEmpty();
			}
		};
	}

	public static Predicate<Pilot> from(final Gender gender) {
		if (gender == null) {
			return Predicates.alwaysTrue();
		}

		return new Predicate<Pilot>() {
			@Override
			public boolean apply(@Nonnull Pilot pilot) {
				return pilot.getGender() == gender || pilot.getGender() == null;
			}
		};
	}

	public static Predicate<Pilot> from(final Set<Class> classes, final Gender gender) {
		if (classes.isEmpty()) {
			return from(gender);
		}

		if (gender == null) {
			return from(classes);
		}

		final Predicate<Pilot> classFilter = FleetFilter.from(classes);
		final Predicate<Pilot> genderFilter = FleetFilter.from(gender);

		return new Predicate<Pilot>() {
			@Override
			public boolean apply(@Nonnull Pilot pilot) {
				return genderFilter.apply(pilot) && classFilter.apply(pilot);
			}
		};
	}
}