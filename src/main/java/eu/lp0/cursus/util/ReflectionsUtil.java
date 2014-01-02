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
package eu.lp0.cursus.util;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class ReflectionsUtil {
	private static Reflections reflections;

	public static synchronized Reflections getInstance() {
		if (reflections == null) {
			ConfigurationBuilder config = new ConfigurationBuilder();
			config.setUrls(ClasspathHelper.forPackage("eu.lp0.cursus", ClasspathHelper.contextClassLoader())); //$NON-NLS-1$
			config.setScanners(new SubTypesScanner());

			reflections = new Reflections(config);
		}
		return reflections;
	}
}