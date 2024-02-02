/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package pll_master_schema.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import pll_master_schema.exception.NoSuchDepartmentsException;

import pll_master_schema.model.Departments;
import pll_master_schema.model.DepartmentsTable;
import pll_master_schema.model.impl.DepartmentsImpl;
import pll_master_schema.model.impl.DepartmentsModelImpl;

import pll_master_schema.service.persistence.DepartmentsPersistence;
import pll_master_schema.service.persistence.DepartmentsUtil;
import pll_master_schema.service.persistence.impl.constants.pll_masterPersistenceConstants;

/**
 * The persistence implementation for the departments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DepartmentsPersistence.class)
public class DepartmentsPersistenceImpl
	extends BasePersistenceImpl<Departments> implements DepartmentsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DepartmentsUtil</code> to access the departments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DepartmentsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBylocationId;
	private FinderPath _finderPathWithoutPaginationFindBylocationId;
	private FinderPath _finderPathCountBylocationId;

	/**
	 * Returns all the departmentses where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the matching departmentses
	 */
	@Override
	public List<Departments> findBylocationId(long locationId) {
		return findBylocationId(
			locationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the departmentses where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentsModelImpl</code>.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of departmentses
	 * @param end the upper bound of the range of departmentses (not inclusive)
	 * @return the range of matching departmentses
	 */
	@Override
	public List<Departments> findBylocationId(
		long locationId, int start, int end) {

		return findBylocationId(locationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the departmentses where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentsModelImpl</code>.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of departmentses
	 * @param end the upper bound of the range of departmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching departmentses
	 */
	@Override
	public List<Departments> findBylocationId(
		long locationId, int start, int end,
		OrderByComparator<Departments> orderByComparator) {

		return findBylocationId(
			locationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the departmentses where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentsModelImpl</code>.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of departmentses
	 * @param end the upper bound of the range of departmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching departmentses
	 */
	@Override
	public List<Departments> findBylocationId(
		long locationId, int start, int end,
		OrderByComparator<Departments> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBylocationId;
				finderArgs = new Object[] {locationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBylocationId;
			finderArgs = new Object[] {
				locationId, start, end, orderByComparator
			};
		}

		List<Departments> list = null;

		if (useFinderCache) {
			list = (List<Departments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Departments departments : list) {
					if (locationId != departments.getLocationId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DEPARTMENTS_WHERE);

			sb.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DepartmentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(locationId);

				list = (List<Departments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first departments in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching departments
	 * @throws NoSuchDepartmentsException if a matching departments could not be found
	 */
	@Override
	public Departments findBylocationId_First(
			long locationId, OrderByComparator<Departments> orderByComparator)
		throws NoSuchDepartmentsException {

		Departments departments = fetchBylocationId_First(
			locationId, orderByComparator);

		if (departments != null) {
			return departments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("locationId=");
		sb.append(locationId);

		sb.append("}");

		throw new NoSuchDepartmentsException(sb.toString());
	}

	/**
	 * Returns the first departments in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching departments, or <code>null</code> if a matching departments could not be found
	 */
	@Override
	public Departments fetchBylocationId_First(
		long locationId, OrderByComparator<Departments> orderByComparator) {

		List<Departments> list = findBylocationId(
			locationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last departments in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching departments
	 * @throws NoSuchDepartmentsException if a matching departments could not be found
	 */
	@Override
	public Departments findBylocationId_Last(
			long locationId, OrderByComparator<Departments> orderByComparator)
		throws NoSuchDepartmentsException {

		Departments departments = fetchBylocationId_Last(
			locationId, orderByComparator);

		if (departments != null) {
			return departments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("locationId=");
		sb.append(locationId);

		sb.append("}");

		throw new NoSuchDepartmentsException(sb.toString());
	}

	/**
	 * Returns the last departments in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching departments, or <code>null</code> if a matching departments could not be found
	 */
	@Override
	public Departments fetchBylocationId_Last(
		long locationId, OrderByComparator<Departments> orderByComparator) {

		int count = countBylocationId(locationId);

		if (count == 0) {
			return null;
		}

		List<Departments> list = findBylocationId(
			locationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the departmentses before and after the current departments in the ordered set where locationId = &#63;.
	 *
	 * @param departmentId the primary key of the current departments
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next departments
	 * @throws NoSuchDepartmentsException if a departments with the primary key could not be found
	 */
	@Override
	public Departments[] findBylocationId_PrevAndNext(
			long departmentId, long locationId,
			OrderByComparator<Departments> orderByComparator)
		throws NoSuchDepartmentsException {

		Departments departments = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			Departments[] array = new DepartmentsImpl[3];

			array[0] = getBylocationId_PrevAndNext(
				session, departments, locationId, orderByComparator, true);

			array[1] = departments;

			array[2] = getBylocationId_PrevAndNext(
				session, departments, locationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Departments getBylocationId_PrevAndNext(
		Session session, Departments departments, long locationId,
		OrderByComparator<Departments> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEPARTMENTS_WHERE);

		sb.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DepartmentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(locationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(departments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Departments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the departmentses where locationId = &#63; from the database.
	 *
	 * @param locationId the location ID
	 */
	@Override
	public void removeBylocationId(long locationId) {
		for (Departments departments :
				findBylocationId(
					locationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(departments);
		}
	}

	/**
	 * Returns the number of departmentses where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the number of matching departmentses
	 */
	@Override
	public int countBylocationId(long locationId) {
		FinderPath finderPath = _finderPathCountBylocationId;

		Object[] finderArgs = new Object[] {locationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEPARTMENTS_WHERE);

			sb.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(locationId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LOCATIONID_LOCATIONID_2 =
		"departments.locationId = ?";

	public DepartmentsPersistenceImpl() {
		setModelClass(Departments.class);

		setModelImplClass(DepartmentsImpl.class);
		setModelPKClass(long.class);

		setTable(DepartmentsTable.INSTANCE);
	}

	/**
	 * Caches the departments in the entity cache if it is enabled.
	 *
	 * @param departments the departments
	 */
	@Override
	public void cacheResult(Departments departments) {
		entityCache.putResult(
			DepartmentsImpl.class, departments.getPrimaryKey(), departments);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the departmentses in the entity cache if it is enabled.
	 *
	 * @param departmentses the departmentses
	 */
	@Override
	public void cacheResult(List<Departments> departmentses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (departmentses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Departments departments : departmentses) {
			if (entityCache.getResult(
					DepartmentsImpl.class, departments.getPrimaryKey()) ==
						null) {

				cacheResult(departments);
			}
		}
	}

	/**
	 * Clears the cache for all departmentses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DepartmentsImpl.class);

		finderCache.clearCache(DepartmentsImpl.class);
	}

	/**
	 * Clears the cache for the departments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Departments departments) {
		entityCache.removeResult(DepartmentsImpl.class, departments);
	}

	@Override
	public void clearCache(List<Departments> departmentses) {
		for (Departments departments : departmentses) {
			entityCache.removeResult(DepartmentsImpl.class, departments);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DepartmentsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DepartmentsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new departments with the primary key. Does not add the departments to the database.
	 *
	 * @param departmentId the primary key for the new departments
	 * @return the new departments
	 */
	@Override
	public Departments create(long departmentId) {
		Departments departments = new DepartmentsImpl();

		departments.setNew(true);
		departments.setPrimaryKey(departmentId);

		departments.setCompanyId(CompanyThreadLocal.getCompanyId());

		return departments;
	}

	/**
	 * Removes the departments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the departments
	 * @return the departments that was removed
	 * @throws NoSuchDepartmentsException if a departments with the primary key could not be found
	 */
	@Override
	public Departments remove(long departmentId)
		throws NoSuchDepartmentsException {

		return remove((Serializable)departmentId);
	}

	/**
	 * Removes the departments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the departments
	 * @return the departments that was removed
	 * @throws NoSuchDepartmentsException if a departments with the primary key could not be found
	 */
	@Override
	public Departments remove(Serializable primaryKey)
		throws NoSuchDepartmentsException {

		Session session = null;

		try {
			session = openSession();

			Departments departments = (Departments)session.get(
				DepartmentsImpl.class, primaryKey);

			if (departments == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartmentsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(departments);
		}
		catch (NoSuchDepartmentsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Departments removeImpl(Departments departments) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(departments)) {
				departments = (Departments)session.get(
					DepartmentsImpl.class, departments.getPrimaryKeyObj());
			}

			if (departments != null) {
				session.delete(departments);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (departments != null) {
			clearCache(departments);
		}

		return departments;
	}

	@Override
	public Departments updateImpl(Departments departments) {
		boolean isNew = departments.isNew();

		if (!(departments instanceof DepartmentsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(departments.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(departments);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in departments proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Departments implementation " +
					departments.getClass());
		}

		DepartmentsModelImpl departmentsModelImpl =
			(DepartmentsModelImpl)departments;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (departments.getCreateDate() == null)) {
			if (serviceContext == null) {
				departments.setCreateDate(date);
			}
			else {
				departments.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!departmentsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				departments.setModifiedDate(date);
			}
			else {
				departments.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(departments);
			}
			else {
				departments = (Departments)session.merge(departments);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DepartmentsImpl.class, departmentsModelImpl, false, true);

		if (isNew) {
			departments.setNew(false);
		}

		departments.resetOriginalValues();

		return departments;
	}

	/**
	 * Returns the departments with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the departments
	 * @return the departments
	 * @throws NoSuchDepartmentsException if a departments with the primary key could not be found
	 */
	@Override
	public Departments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDepartmentsException {

		Departments departments = fetchByPrimaryKey(primaryKey);

		if (departments == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDepartmentsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return departments;
	}

	/**
	 * Returns the departments with the primary key or throws a <code>NoSuchDepartmentsException</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the departments
	 * @return the departments
	 * @throws NoSuchDepartmentsException if a departments with the primary key could not be found
	 */
	@Override
	public Departments findByPrimaryKey(long departmentId)
		throws NoSuchDepartmentsException {

		return findByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns the departments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the departments
	 * @return the departments, or <code>null</code> if a departments with the primary key could not be found
	 */
	@Override
	public Departments fetchByPrimaryKey(long departmentId) {
		return fetchByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns all the departmentses.
	 *
	 * @return the departmentses
	 */
	@Override
	public List<Departments> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the departmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of departmentses
	 * @param end the upper bound of the range of departmentses (not inclusive)
	 * @return the range of departmentses
	 */
	@Override
	public List<Departments> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the departmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of departmentses
	 * @param end the upper bound of the range of departmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of departmentses
	 */
	@Override
	public List<Departments> findAll(
		int start, int end, OrderByComparator<Departments> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the departmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of departmentses
	 * @param end the upper bound of the range of departmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of departmentses
	 */
	@Override
	public List<Departments> findAll(
		int start, int end, OrderByComparator<Departments> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Departments> list = null;

		if (useFinderCache) {
			list = (List<Departments>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEPARTMENTS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEPARTMENTS;

				sql = sql.concat(DepartmentsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Departments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the departmentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Departments departments : findAll()) {
			remove(departments);
		}
	}

	/**
	 * Returns the number of departmentses.
	 *
	 * @return the number of departmentses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEPARTMENTS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "departmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEPARTMENTS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DepartmentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the departments persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBylocationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylocationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"locationId"}, true);

		_finderPathWithoutPaginationFindBylocationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylocationId",
			new String[] {Long.class.getName()}, new String[] {"locationId"},
			true);

		_finderPathCountBylocationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylocationId",
			new String[] {Long.class.getName()}, new String[] {"locationId"},
			false);

		_setDepartmentsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDepartmentsUtilPersistence(null);

		entityCache.removeCache(DepartmentsImpl.class.getName());
	}

	private void _setDepartmentsUtilPersistence(
		DepartmentsPersistence departmentsPersistence) {

		try {
			Field field = DepartmentsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, departmentsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = pll_masterPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = pll_masterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = pll_masterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DEPARTMENTS =
		"SELECT departments FROM Departments departments";

	private static final String _SQL_SELECT_DEPARTMENTS_WHERE =
		"SELECT departments FROM Departments departments WHERE ";

	private static final String _SQL_COUNT_DEPARTMENTS =
		"SELECT COUNT(departments) FROM Departments departments";

	private static final String _SQL_COUNT_DEPARTMENTS_WHERE =
		"SELECT COUNT(departments) FROM Departments departments WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "departments.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Departments exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Departments exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DepartmentsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}