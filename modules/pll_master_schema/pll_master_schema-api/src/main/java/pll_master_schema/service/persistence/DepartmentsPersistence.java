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

package pll_master_schema.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import pll_master_schema.exception.NoSuchDepartmentsException;

import pll_master_schema.model.Departments;

/**
 * The persistence interface for the departments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentsUtil
 * @generated
 */
@ProviderType
public interface DepartmentsPersistence extends BasePersistence<Departments> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DepartmentsUtil} to access the departments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the departmentses where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the matching departmentses
	 */
	public java.util.List<Departments> findBylocationId(long locationId);

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
	public java.util.List<Departments> findBylocationId(
		long locationId, int start, int end);

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
	public java.util.List<Departments> findBylocationId(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Departments>
			orderByComparator);

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
	public java.util.List<Departments> findBylocationId(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Departments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first departments in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching departments
	 * @throws NoSuchDepartmentsException if a matching departments could not be found
	 */
	public Departments findBylocationId_First(
			long locationId,
			com.liferay.portal.kernel.util.OrderByComparator<Departments>
				orderByComparator)
		throws NoSuchDepartmentsException;

	/**
	 * Returns the first departments in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching departments, or <code>null</code> if a matching departments could not be found
	 */
	public Departments fetchBylocationId_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator<Departments>
			orderByComparator);

	/**
	 * Returns the last departments in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching departments
	 * @throws NoSuchDepartmentsException if a matching departments could not be found
	 */
	public Departments findBylocationId_Last(
			long locationId,
			com.liferay.portal.kernel.util.OrderByComparator<Departments>
				orderByComparator)
		throws NoSuchDepartmentsException;

	/**
	 * Returns the last departments in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching departments, or <code>null</code> if a matching departments could not be found
	 */
	public Departments fetchBylocationId_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator<Departments>
			orderByComparator);

	/**
	 * Returns the departmentses before and after the current departments in the ordered set where locationId = &#63;.
	 *
	 * @param departmentId the primary key of the current departments
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next departments
	 * @throws NoSuchDepartmentsException if a departments with the primary key could not be found
	 */
	public Departments[] findBylocationId_PrevAndNext(
			long departmentId, long locationId,
			com.liferay.portal.kernel.util.OrderByComparator<Departments>
				orderByComparator)
		throws NoSuchDepartmentsException;

	/**
	 * Removes all the departmentses where locationId = &#63; from the database.
	 *
	 * @param locationId the location ID
	 */
	public void removeBylocationId(long locationId);

	/**
	 * Returns the number of departmentses where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the number of matching departmentses
	 */
	public int countBylocationId(long locationId);

	/**
	 * Caches the departments in the entity cache if it is enabled.
	 *
	 * @param departments the departments
	 */
	public void cacheResult(Departments departments);

	/**
	 * Caches the departmentses in the entity cache if it is enabled.
	 *
	 * @param departmentses the departmentses
	 */
	public void cacheResult(java.util.List<Departments> departmentses);

	/**
	 * Creates a new departments with the primary key. Does not add the departments to the database.
	 *
	 * @param departmentId the primary key for the new departments
	 * @return the new departments
	 */
	public Departments create(long departmentId);

	/**
	 * Removes the departments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the departments
	 * @return the departments that was removed
	 * @throws NoSuchDepartmentsException if a departments with the primary key could not be found
	 */
	public Departments remove(long departmentId)
		throws NoSuchDepartmentsException;

	public Departments updateImpl(Departments departments);

	/**
	 * Returns the departments with the primary key or throws a <code>NoSuchDepartmentsException</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the departments
	 * @return the departments
	 * @throws NoSuchDepartmentsException if a departments with the primary key could not be found
	 */
	public Departments findByPrimaryKey(long departmentId)
		throws NoSuchDepartmentsException;

	/**
	 * Returns the departments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the departments
	 * @return the departments, or <code>null</code> if a departments with the primary key could not be found
	 */
	public Departments fetchByPrimaryKey(long departmentId);

	/**
	 * Returns all the departmentses.
	 *
	 * @return the departmentses
	 */
	public java.util.List<Departments> findAll();

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
	public java.util.List<Departments> findAll(int start, int end);

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
	public java.util.List<Departments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Departments>
			orderByComparator);

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
	public java.util.List<Departments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Departments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the departmentses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of departmentses.
	 *
	 * @return the number of departmentses
	 */
	public int countAll();

}