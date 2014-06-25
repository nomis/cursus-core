/*
	cursus - Race series management program
	Copyright 2014  Simon Arlott

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
package eu.lp0.cursus.xml.results.data;

public class ResultsXMLSplit {
	private static final String SPLIT_NAME = "%1$s%2$s%3$d%4$s"; //$NON-NLS-1$

	public enum Type {
		RACE ("race", "r"), //$NON-NLS-1$ //$NON-NLS-2$

		EVENT ("event", "e"), //$NON-NLS-1$ //$NON-NLS-2$

		SERIES ("series", "s"); //$NON-NLS-1$ //$NON-NLS-2$

		public final String index;
		public final String fileName;

		private Type(String index, String fileName) {
			this.index = index;
			this.fileName = fileName;
		}
	}

	public ResultsXMLSplit() {
	}

	public ResultsXMLSplit(String prefix, Type type, int index, String suffix) {
		this.prefix = prefix;
		this.type = type;
		this.index = index;
		this.suffix = suffix;
	}

	public String createFileName() {
		return String.format(SPLIT_NAME, prefix, type.fileName, index, suffix);
	}

	private String prefix;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	private Integer index;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	private String suffix;

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
