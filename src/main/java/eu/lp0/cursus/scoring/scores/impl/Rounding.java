/*
	cursus - Race series management program
	Copyright 2012-2013  Simon Arlott

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
package eu.lp0.cursus.scoring.scores.impl;

import java.math.BigDecimal;

public enum Rounding {
	/** @see BigDecimal#ROUND_DOWN */
	ROUND_DOWN (BigDecimal.ROUND_DOWN),

	/** @see BigDecimal#ROUND_HALF_DOWN */
	ROUND_HALF_DOWN (BigDecimal.ROUND_HALF_DOWN),

	/** @see BigDecimal#ROUND_HALF_EVEN */
	ROUND_HALF_EVEN (BigDecimal.ROUND_HALF_EVEN),

	/** @see BigDecimal#ROUND_HALF_UP */
	ROUND_HALF_UP (BigDecimal.ROUND_HALF_UP),

	/** @see BigDecimal#ROUND_UP */
	ROUND_UP (BigDecimal.ROUND_UP);

	private int value;

	private Rounding(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}