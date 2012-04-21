/*
	cursus - Race series management program
	Copyright 2012  Simon Arlott

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

import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;

import eu.lp0.cursus.db.dao.EntityDAO;
import eu.lp0.cursus.db.data.Entity;
import eu.lp0.cursus.i18n.LocaleChangeEvent;
import eu.lp0.cursus.i18n.TranslatedEnum;
import eu.lp0.cursus.ui.common.HiddenEnumConstant;

public abstract class EnumDatabaseColumn<T extends Entity, V extends Enum<?>> extends DatabaseColumn<T, Object> {
	private final MutableListComboBoxModel<Object> values;
	private final Class<V> type;
	private final boolean nullable;

	public EnumDatabaseColumn(String name, Class<V> type, boolean nullable) {
		super(name);
		this.type = type;
		this.nullable = nullable;
		values = new MutableListComboBoxModel<Object>(generateValues());
		cellRenderer = new StringDatabaseTableCellRenderer<T, Object>(this);
	}

	public EnumDatabaseColumn(String name, DatabaseWindow win, EntityDAO<T> dao, Class<V> type, boolean nullable) {
		super(name, win, dao);
		this.type = type;
		this.nullable = nullable;
		values = new MutableListComboBoxModel<Object>(generateValues());
		cellRenderer = new StringDatabaseTableCellRenderer<T, Object>(this);
		cellEditor = new DatabaseTableCellEditor<T, Object>(this, new JComboBox(values));
	}

	// Uses DatabaseTableModel's EventBus
	@Subscribe
	public final void updateEnumValues(LocaleChangeEvent lce) {
		if (TranslatedEnum.class.isAssignableFrom(type)) {
			values.replaceAll(generateValues());
		}
	}

	private List<Object> generateValues() {
		if (nullable) {
			return Lists.<Object>asList("", type.getEnumConstants()); //$NON-NLS-1$
		} else {
			return Lists.<Object>newArrayList(Iterables.filter(Arrays.asList(type.getEnumConstants()), new Predicate<V>() {
				@Override
				public boolean apply(V input) {
					return !isHiddenEnumConstant(input);
				}
			}));
		}
	}

	public static boolean isHiddenEnumConstant(Enum<?> value) {
		try {
			return value.getClass().getField(value.name()).isAnnotationPresent(HiddenEnumConstant.class);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected final Object getValue(T row, boolean editing) {
		Object value = getEnumValue(row);
		if (value == null) {
			assert (nullable);
			value = ""; //$NON-NLS-1$
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected final boolean setValue(T row, Object value) {
		if (value.equals("")) { //$NON-NLS-1$
			assert (nullable);
			value = null;
		}
		return setEnumValue(row, (V)value);
	}

	protected abstract V getEnumValue(T row);

	protected abstract boolean setEnumValue(T row, V value);
}