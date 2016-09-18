/*
	cursus - Race series management program
	Copyright 2012, 2014  Simon Arlott

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
package uk.uuid.cursus.xml;

import java.util.Locale;
import java.util.Properties;

import org.beanio.types.ConfigurableTypeHandler;
import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

public class EnumTypeHandler<T extends Enum<T>> implements ConfigurableTypeHandler {
	private enum Convert {
		ASIS,

		LOWERCASE,

		UPPERCASE;
	}

	private Class<T> type;
	private Convert read = Convert.ASIS;
	private Convert write = Convert.ASIS;

	@SuppressWarnings({ "rawtypes" })
	@Override
	public TypeHandler newInstance(Properties properties) throws IllegalArgumentException {
		return new EnumTypeHandler();
	}

	@Override
	public Object parse(String text) throws TypeConversionException {
		switch (read) {
		case LOWERCASE:
			text = text.toLowerCase(Locale.ROOT);
			break;

		case UPPERCASE:
			text = text.toUpperCase(Locale.ROOT);
			break;

		case ASIS:
		default:
			break;
		}

		return Enum.valueOf(type, text);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String format(Object value) {
		if (value == null) {
			return null;
		}

		String name = ((T)value).name();

		switch (write) {
		case LOWERCASE:
			name = name.toLowerCase(Locale.ROOT);
			break;

		case UPPERCASE:
			name = name.toUpperCase(Locale.ROOT);
			break;

		case ASIS:
		default:
			break;
		}

		return name;
	}

	@Override
	public Class<T> getType() {
		assert (type != null);
		return type;
	}

	@SuppressWarnings("unchecked")
	public void setEnum(String value) throws ClassNotFoundException {
		type = (Class<T>)Class.forName(value);
	}

	public void setRead(Convert value) {
		read = value;
	}

	public void setWrite(Convert value) {
		write = value;
	}
}