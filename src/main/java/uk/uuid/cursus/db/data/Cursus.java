/*
	cursus - Race series management program
	Copyright 2011, 2013-2014  Simon Arlott

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

import javax.persistence.Column;
import javax.persistence.Entity;

import uk.uuid.cursus.db.Constants;

/**
 * Database identifier
 */
@Entity(name = "cursus")
public final class Cursus extends AbstractEntity {
	public Cursus() {
	}

	public Cursus(long version, String description) {
		setVersion(version);
		setDescription(description);
	}

	private Long version;

	@Column(nullable = false, unique = true)
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	private String description;

	@Column(nullable = false, length = Constants.MAX_STRING_LEN)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}