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
package org.spka.cursus.test.cc_2013;

import org.spka.cursus.scoring.CCConstants;

import eu.lp0.cursus.scoring.scorer.ScorerFactory;

public class AbstractSeries2013Top5 extends AbstractSeries2013 {
	public AbstractSeries2013Top5() {
		scorer = ScorerFactory.newScorer(CCConstants.UUID_2013);
	}
}