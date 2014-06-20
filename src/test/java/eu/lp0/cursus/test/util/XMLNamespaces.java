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
package eu.lp0.cursus.test.util;

public enum XMLNamespaces {
	DATA_V1 ("urn:oid:1.3.6.1.4.1.39777.1.0.1.0.1", "data-v1.xsd"), //$NON-NLS-1$ //$NON-NLS-2$

	RESULTS_V1 ("urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1", "results-v1.xsd"), //$NON-NLS-1$ //$NON-NLS-2$

	SCORES_V1 ("urn:oid:1.3.6.1.4.1.39777.1.0.1.1.1", "scores-v1.xsd"); //$NON-NLS-1$ //$NON-NLS-2$

	public final String uri;
	public final String filename;

	private XMLNamespaces(String uri, String filename) {
		this.uri = uri;
		this.filename = filename;
	}
}
