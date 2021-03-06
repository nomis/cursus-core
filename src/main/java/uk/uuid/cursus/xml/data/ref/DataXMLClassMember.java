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
package uk.uuid.cursus.xml.data.ref;

import uk.uuid.cursus.db.data.Class;
import uk.uuid.cursus.xml.common.AbstractXMLEntity;

public class DataXMLClassMember implements DataXMLClassRef, Comparable<DataXMLClassMember> {
	public DataXMLClassMember() {
	}

	public DataXMLClassMember(Class class_) {
		this.class_ = AbstractXMLEntity.generateId(class_);
	}

	private String class_;

	@Override
	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	@Override
	public int compareTo(DataXMLClassMember o) {
		return getClass_().compareTo(o.getClass_());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof DataXMLClassMember)) {
			return false;
		}

		if (o == this) {
			return true;
		}

		return getClass_().equals(((DataXMLClassMember)o).getClass_());
	}

	@Override
	public int hashCode() {
		return getClass_().hashCode();
	}
}