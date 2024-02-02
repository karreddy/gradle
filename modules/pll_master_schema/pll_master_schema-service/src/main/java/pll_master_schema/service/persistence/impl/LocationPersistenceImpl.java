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

import pll_master_schema.exception.NoSuchLocationException;

import pll_master_schema.model.Location;
import pll_master_schema.model.LocationTable;
import pll_master_schema.model.impl.LocationImpl;
import pll_master_schema.model.impl.LocationModelImpl;

import pll_master_schema.service.persistence.LocationPersistence;
import pll_master_schema.service.persistence.LocationUtil;
import pll_master_schema.service.persistence.impl.constants.pll_masterPersistenceConstants;

/**
 * The persistence implementation for the location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LocationPersistence.class)
public class LocationPersistenceImpl
	extends BasePersistenceImpl<Location> implements LocationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LocationUtil</code> to access the location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LocationImpl.class.getName();

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
	 * Returns all the locations where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the matching locations
	 */
	@Override
	public List<Location> findBylocationId(long locationId) {
		return findBylocationId(
			locationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the locations where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of matching locations
	 */
	@Override
	public List<Location> findBylocationId(
		long locationId, int start, int end) {

		return findBylocationId(locationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching locations
	 */
	@Override
	public List<Location> findBylocationId(
		long locationId, int start, int end,
		OrderByComparator<Location> orderByComparator) {

		return findBylocationId(
			locationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the locations where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching locations
	 */
	@Override
	public List<Location> findBylocationId(
		long locationId, int start, int end,
		OrderByComparator<Location> orderByComparator, boolean useFinderCache) {

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

		List<Location> list = null;

		if (useFinderCache) {
			list = (List<Location>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Location location : list) {
					if (locationId != location.getLocationId()) {
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

			sb.append(_SQL_SELECT_LOCATION_WHERE);

			sb.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(locationId);

				list = (List<Location>)QueryUtil.list(
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
	 * Returns the first location in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location
	 * @throws NoSuchLocationException if a matching location could not be found
	 */
	@Override
	public Location findBylocationId_First(
			long locationId, OrderByComparator<Location> orderByComparator)
		throws NoSuchLocationException {

		Location location = fetchBylocationId_First(
			locationId, orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("locationId=");
		sb.append(locationId);

		sb.append("}");

		throw new NoSuchLocationException(sb.toString());
	}

	/**
	 * Returns the first location in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location, or <code>null</code> if a matching location could not be found
	 */
	@Override
	public Location fetchBylocationId_First(
		long locationId, OrderByComparator<Location> orderByComparator) {

		List<Location> list = findBylocationId(
			locationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last location in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location
	 * @throws NoSuchLocationException if a matching location could not be found
	 */
	@Override
	public Location findBylocationId_Last(
			long locationId, OrderByComparator<Location> orderByComparator)
		throws NoSuchLocationException {

		Location location = fetchBylocationId_Last(
			locationId, orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("locationId=");
		sb.append(locationId);

		sb.append("}");

		throw new NoSuchLocationException(sb.toString());
	}

	/**
	 * Returns the last location in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location, or <code>null</code> if a matching location could not be found
	 */
	@Override
	public Location fetchBylocationId_Last(
		long locationId, OrderByComparator<Location> orderByComparator) {

		int count = countBylocationId(locationId);

		if (count == 0) {
			return null;
		}

		List<Location> list = findBylocationId(
			locationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the locations where locationId = &#63; from the database.
	 *
	 * @param locationId the location ID
	 */
	@Override
	public void removeBylocationId(long locationId) {
		for (Location location :
				findBylocationId(
					locationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(location);
		}
	}

	/**
	 * Returns the number of locations where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the number of matching locations
	 */
	@Override
	public int countBylocationId(long locationId) {
		FinderPath finderPath = _finderPathCountBylocationId;

		Object[] finderArgs = new Object[] {locationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOCATION_WHERE);

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
		"location.locationId = ?";

	public LocationPersistenceImpl() {
		setModelClass(Location.class);

		setModelImplClass(LocationImpl.class);
		setModelPKClass(long.class);

		setTable(LocationTable.INSTANCE);
	}

	/**
	 * Caches the location in the entity cache if it is enabled.
	 *
	 * @param location the location
	 */
	@Override
	public void cacheResult(Location location) {
		entityCache.putResult(
			LocationImpl.class, location.getPrimaryKey(), location);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the locations in the entity cache if it is enabled.
	 *
	 * @param locations the locations
	 */
	@Override
	public void cacheResult(List<Location> locations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (locations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Location location : locations) {
			if (entityCache.getResult(
					LocationImpl.class, location.getPrimaryKey()) == null) {

				cacheResult(location);
			}
		}
	}

	/**
	 * Clears the cache for all locations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LocationImpl.class);

		finderCache.clearCache(LocationImpl.class);
	}

	/**
	 * Clears the cache for the location.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Location location) {
		entityCache.removeResult(LocationImpl.class, location);
	}

	@Override
	public void clearCache(List<Location> locations) {
		for (Location location : locations) {
			entityCache.removeResult(LocationImpl.class, location);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LocationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LocationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new location with the primary key. Does not add the location to the database.
	 *
	 * @param locationId the primary key for the new location
	 * @return the new location
	 */
	@Override
	public Location create(long locationId) {
		Location location = new LocationImpl();

		location.setNew(true);
		location.setPrimaryKey(locationId);

		location.setCompanyId(CompanyThreadLocal.getCompanyId());

		return location;
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locationId the primary key of the location
	 * @return the location that was removed
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	@Override
	public Location remove(long locationId) throws NoSuchLocationException {
		return remove((Serializable)locationId);
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location that was removed
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	@Override
	public Location remove(Serializable primaryKey)
		throws NoSuchLocationException {

		Session session = null;

		try {
			session = openSession();

			Location location = (Location)session.get(
				LocationImpl.class, primaryKey);

			if (location == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(location);
		}
		catch (NoSuchLocationException noSuchEntityException) {
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
	protected Location removeImpl(Location location) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(location)) {
				location = (Location)session.get(
					LocationImpl.class, location.getPrimaryKeyObj());
			}

			if (location != null) {
				session.delete(location);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (location != null) {
			clearCache(location);
		}

		return location;
	}

	@Override
	public Location updateImpl(Location location) {
		boolean isNew = location.isNew();

		if (!(location instanceof LocationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(location.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(location);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in location proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Location implementation " +
					location.getClass());
		}

		LocationModelImpl locationModelImpl = (LocationModelImpl)location;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (location.getCreateDate() == null)) {
			if (serviceContext == null) {
				location.setCreateDate(date);
			}
			else {
				location.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!locationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				location.setModifiedDate(date);
			}
			else {
				location.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(location);
			}
			else {
				location = (Location)session.merge(location);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LocationImpl.class, locationModelImpl, false, true);

		if (isNew) {
			location.setNew(false);
		}

		location.resetOriginalValues();

		return location;
	}

	/**
	 * Returns the location with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	@Override
	public Location findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLocationException {

		Location location = fetchByPrimaryKey(primaryKey);

		if (location == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLocationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return location;
	}

	/**
	 * Returns the location with the primary key or throws a <code>NoSuchLocationException</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	@Override
	public Location findByPrimaryKey(long locationId)
		throws NoSuchLocationException {

		return findByPrimaryKey((Serializable)locationId);
	}

	/**
	 * Returns the location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location, or <code>null</code> if a location with the primary key could not be found
	 */
	@Override
	public Location fetchByPrimaryKey(long locationId) {
		return fetchByPrimaryKey((Serializable)locationId);
	}

	/**
	 * Returns all the locations.
	 *
	 * @return the locations
	 */
	@Override
	public List<Location> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of locations
	 */
	@Override
	public List<Location> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of locations
	 */
	@Override
	public List<Location> findAll(
		int start, int end, OrderByComparator<Location> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of locations
	 */
	@Override
	public List<Location> findAll(
		int start, int end, OrderByComparator<Location> orderByComparator,
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

		List<Location> list = null;

		if (useFinderCache) {
			list = (List<Location>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOCATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOCATION;

				sql = sql.concat(LocationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Location>)QueryUtil.list(
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
	 * Removes all the locations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Location location : findAll()) {
			remove(location);
		}
	}

	/**
	 * Returns the number of locations.
	 *
	 * @return the number of locations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOCATION);

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
		return "locationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOCATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LocationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the location persistence.
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

		_setLocationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLocationUtilPersistence(null);

		entityCache.removeCache(LocationImpl.class.getName());
	}

	private void _setLocationUtilPersistence(
		LocationPersistence locationPersistence) {

		try {
			Field field = LocationUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, locationPersistence);
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

	private static final String _SQL_SELECT_LOCATION =
		"SELECT location FROM Location location";

	private static final String _SQL_SELECT_LOCATION_WHERE =
		"SELECT location FROM Location location WHERE ";

	private static final String _SQL_COUNT_LOCATION =
		"SELECT COUNT(location) FROM Location location";

	private static final String _SQL_COUNT_LOCATION_WHERE =
		"SELECT COUNT(location) FROM Location location WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "location.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Location exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Location exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LocationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}