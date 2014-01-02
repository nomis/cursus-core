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
package eu.lp0.cursus.db.data;

import eu.lp0.cursus.i18n.TranslatedEnum;

public enum Gender implements TranslatedEnum {
	/** Male */
	MALE ("gender.male"), //$NON-NLS-1$

	/** Female */
	FEMALE ("gender.female"); //$NON-NLS-1$

	private final String key;

	private Gender(String key) {
		this.key = key;
	}

	@Override
	public String getMessagesKey() {
		return key + ".long"; //$NON-NLS-1$
	}

	public String getShortMessagesKey() {
		return key + ".short"; //$NON-NLS-1$
	}
}