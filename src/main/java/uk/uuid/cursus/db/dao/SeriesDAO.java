/*
	cursus - Race series management program
	Copyright 2011, 2014  Simon Arlott

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
package uk.uuid.cursus.db.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uk.uuid.cursus.db.data.Series;

public class SeriesDAO extends NamedEntityDAO<Series> {
	public SeriesDAO() {
		super(Series.class);
	}

	public Series find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Series> q = cb.createQuery(Series.class);
		Root<Series> s = q.from(Series.class);
		q.select(s);
		q.where(cb.equal(s.get("name"), name)); //$NON-NLS-1$

		TypedQuery<Series> tq = em.createQuery(q);
		return tq.getSingleResult();
	}
}