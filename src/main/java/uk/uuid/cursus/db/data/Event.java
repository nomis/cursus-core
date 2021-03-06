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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import uk.uuid.cursus.db.Constants;

import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;

/**
 * Race event
 */
@Entity(name = "event")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "series_id", "name" }) })
public final class Event extends AbstractEntity implements Comparable<Event>, RaceEntity {
	Event() {
	}

	public Event(Series series) {
		this(series, "", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public Event(Series series, String name) {
		this(series, name, ""); //$NON-NLS-1$
	}

	public Event(Series series, String name, String description) {
		setSeries(series);
		setName(name);
		setDescription(description);
	}

	private Series series;

	// Should be bidirectional, but Hibernate refuse to fix HHH-5390
	@ManyToOne(optional = false)
	@JoinColumn(name = "series_id", insertable = false, updatable = false, nullable = false)
	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	@Transient
	public Integer getSeriesOrder() {
		int index = getSeries().getEvents().indexOf(this);
		Preconditions.checkState(index != -1, "Event does not exist in series"); //$NON-NLS-1$
		return index;
	}

	private String name;

	@Column(nullable = false, length = Constants.MAX_STRING_LEN)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String description;

	@Column(nullable = false, length = Constants.MAX_STRING_LEN)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Set<Pilot> attendees = new HashSet<Pilot>();

	@ManyToMany(cascade = { CascadeType.DETACH }, mappedBy = "events")
	public Set<Pilot> getAttendees() {
		return attendees;
	}

	public void setAttendees(Set<Pilot> attendees) {
		this.attendees = attendees;
	}

	private List<Race> races = new ArrayList<Race>();

	// Should be bidirectional, but Hibernate refuse to fix HHH-5390
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "event_id", nullable = false)
	@OrderColumn(name = "event_order", nullable = false)
	public List<Race> getRaces() {
		return races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
	}

	@Transient
	public Set<Pilot> getAllPilots() {
		Set<Pilot> pilots = new HashSet<Pilot>();
		pilots.addAll(getAttendees());
		for (Race race : getRaces()) {
			pilots.addAll(race.getAttendees().keySet());
		}
		return pilots;
	}

	@Override
	public String toString() {
		return getName().length() > 0 ? getName() : "[#" + getId() + "]"; //$NON-NLS-1$ //$NON-NLS-2$ 
	}

	@Override
	public int compareTo(Event o) {
		return ComparisonChain.start().compare(getSeries(), o.getSeries()).compare(getSeriesOrder(), o.getSeriesOrder()).result();
	}
}