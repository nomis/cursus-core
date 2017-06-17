/*
	cursus - Race series management program
	Copyright 2011-2014  Simon Arlott

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
package uk.uuid.cursus.db.data;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;

import uk.uuid.cursus.db.Constants;

@Entity(name = "race_no")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "series_id", "organisation", "number" }) })
public final class RaceNumber extends AbstractEntity implements Comparable<RaceNumber> {
	public static final Pattern RACE_NUMBER_PATTERN = Pattern.compile("^([^0-9]+)([0-9]+)$"); //$NON-NLS-1$
	private static final Pattern RACE_NUMBER_WITHOUT_ORG_PATTERN = Pattern.compile("^([0-9]+)$"); //$NON-NLS-1$

	RaceNumber() {
	}

	public RaceNumber(Pilot pilot, String organisation, int number) {
		setSeries(pilot.getSeries());
		setPilot(pilot);
		setOrganisation(organisation);
		setNumber(number);
	}

	private Series series;

	@ManyToOne(optional = false)
	@JoinColumn(name = "series_id", nullable = false)
	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	private String organisation;

	@Column(nullable = false, length = Constants.MAX_STRING_LEN)
	public String getOrganisation() {
		return organisation.toUpperCase(Locale.ENGLISH).replaceAll("[^A-Z]", ""); //$NON-NLS-1$ //$NON-NLS-2$ ;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation.toUpperCase(Locale.ENGLISH).replaceAll("[^A-Z]", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private Integer number;

	@Column(nullable = false)
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private Pilot pilot;

	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	@Override
	public int compareTo(RaceNumber o) {
		return ComparisonChain.start().compare(getOrganisation(), o.getOrganisation()).compare(getNumber(), o.getNumber()).compare(getSeries(), o.getSeries())
				.result();
	}

	@Override
	public String toString() {
		return String.format("%s%02d", getOrganisation(), getNumber()); //$NON-NLS-1$
	}

	public static RaceNumber valueOfFor(String value, Race race) {
		Matcher matcherWithOrg = RACE_NUMBER_PATTERN.matcher(value);
		Matcher matcherWithoutOrg = RACE_NUMBER_WITHOUT_ORG_PATTERN.matcher(value);
		String organisation;
		int number;

		if (matcherWithOrg.matches()) {
			organisation = matcherWithOrg.group(1);
			number = Integer.valueOf(matcherWithOrg.group(2));
		} else if (matcherWithoutOrg.matches()) {
			organisation = null;
			number = Integer.valueOf(matcherWithoutOrg.group(1));
		} else {
			throw new IllegalArgumentException("Unable to parse race number: " + value); //$NON-NLS-1$
		}

		RaceNumber pilot = null;
		for (RaceAttendee attendee : race.getAttendees().values()) {
			for (RaceNumber raceNumber : attendee.getPilot().getRaceNumbers()) {
				if (raceNumber.getNumber() == number) {
					if (organisation == null) {
						if (pilot != null) {
							throw new NoSuchElementException("Ambiguous race number: " + value); //$NON-NLS-1$
						}
						pilot = raceNumber;
					} else if (raceNumber.getOrganisation().equals(organisation)) {
						pilot = raceNumber;
					}
				}
			}
		}

		if (pilot == null) {
			throw new NoSuchElementException("Can't find pilot: " + value); //$NON-NLS-1$
		}

		return pilot;
	}

	public static RaceNumber valueOfFor(String value, Pilot pilot) {
		Matcher matcher = RACE_NUMBER_PATTERN.matcher(value);
		Preconditions.checkArgument(matcher.matches(), "Unable to parse race number: %s", value); //$NON-NLS-1$
		String organisation = matcher.group(1);
		int number = Integer.valueOf(matcher.group(2));

		return new RaceNumber(pilot, organisation, number).directReference();
	}

	private RaceNumber directReference() {
		for (RaceNumber pilotRaceNumber : getPilot().getRaceNumbers()) {
			if (pilotRaceNumber.compareTo(this) == 0) {
				return pilotRaceNumber;
			}
		}
		return this;
	}
}