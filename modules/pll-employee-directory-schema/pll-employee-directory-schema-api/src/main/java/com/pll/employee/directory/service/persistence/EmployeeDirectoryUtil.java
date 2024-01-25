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

package com.pll.employee.directory.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.pll.employee.directory.model.EmployeeDirectory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee directory service. This utility wraps <code>com.pll.employee.directory.service.persistence.impl.EmployeeDirectoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDirectoryPersistence
 * @generated
 */
public class EmployeeDirectoryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmployeeDirectory employeeDirectory) {
		getPersistence().clearCache(employeeDirectory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EmployeeDirectory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDirectory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDirectory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDirectory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDirectory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDirectory update(
		EmployeeDirectory employeeDirectory) {

		return getPersistence().update(employeeDirectory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDirectory update(
		EmployeeDirectory employeeDirectory, ServiceContext serviceContext) {

		return getPersistence().update(employeeDirectory, serviceContext);
	}

	/**
	 * Returns all the employee directories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee directories
	 */
	public static List<EmployeeDirectory> findByemployeeId(long employeeId) {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee directories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDirectoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee directories
	 * @param end the upper bound of the range of employee directories (not inclusive)
	 * @return the range of matching employee directories
	 */
	public static List<EmployeeDirectory> findByemployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByemployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee directories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDirectoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee directories
	 * @param end the upper bound of the range of employee directories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee directories
	 */
	public static List<EmployeeDirectory> findByemployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDirectory> orderByComparator) {

		return getPersistence().findByemployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee directories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDirectoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee directories
	 * @param end the upper bound of the range of employee directories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee directories
	 */
	public static List<EmployeeDirectory> findByemployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDirectory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByemployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee directory in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee directory
	 * @throws NoSuchEmployeeDirectoryException if a matching employee directory could not be found
	 */
	public static EmployeeDirectory findByemployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeDirectory> orderByComparator)
		throws com.pll.employee.directory.exception.
			NoSuchEmployeeDirectoryException {

		return getPersistence().findByemployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee directory in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee directory, or <code>null</code> if a matching employee directory could not be found
	 */
	public static EmployeeDirectory fetchByemployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeDirectory> orderByComparator) {

		return getPersistence().fetchByemployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee directory in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee directory
	 * @throws NoSuchEmployeeDirectoryException if a matching employee directory could not be found
	 */
	public static EmployeeDirectory findByemployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeDirectory> orderByComparator)
		throws com.pll.employee.directory.exception.
			NoSuchEmployeeDirectoryException {

		return getPersistence().findByemployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee directory in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee directory, or <code>null</code> if a matching employee directory could not be found
	 */
	public static EmployeeDirectory fetchByemployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeDirectory> orderByComparator) {

		return getPersistence().fetchByemployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee directories where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByemployeeId(long employeeId) {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	 * Returns the number of employee directories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee directories
	 */
	public static int countByemployeeId(long employeeId) {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	 * Caches the employee directory in the entity cache if it is enabled.
	 *
	 * @param employeeDirectory the employee directory
	 */
	public static void cacheResult(EmployeeDirectory employeeDirectory) {
		getPersistence().cacheResult(employeeDirectory);
	}

	/**
	 * Caches the employee directories in the entity cache if it is enabled.
	 *
	 * @param employeeDirectories the employee directories
	 */
	public static void cacheResult(
		List<EmployeeDirectory> employeeDirectories) {

		getPersistence().cacheResult(employeeDirectories);
	}

	/**
	 * Creates a new employee directory with the primary key. Does not add the employee directory to the database.
	 *
	 * @param employeeId the primary key for the new employee directory
	 * @return the new employee directory
	 */
	public static EmployeeDirectory create(long employeeId) {
		return getPersistence().create(employeeId);
	}

	/**
	 * Removes the employee directory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee directory
	 * @return the employee directory that was removed
	 * @throws NoSuchEmployeeDirectoryException if a employee directory with the primary key could not be found
	 */
	public static EmployeeDirectory remove(long employeeId)
		throws com.pll.employee.directory.exception.
			NoSuchEmployeeDirectoryException {

		return getPersistence().remove(employeeId);
	}

	public static EmployeeDirectory updateImpl(
		EmployeeDirectory employeeDirectory) {

		return getPersistence().updateImpl(employeeDirectory);
	}

	/**
	 * Returns the employee directory with the primary key or throws a <code>NoSuchEmployeeDirectoryException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee directory
	 * @return the employee directory
	 * @throws NoSuchEmployeeDirectoryException if a employee directory with the primary key could not be found
	 */
	public static EmployeeDirectory findByPrimaryKey(long employeeId)
		throws com.pll.employee.directory.exception.
			NoSuchEmployeeDirectoryException {

		return getPersistence().findByPrimaryKey(employeeId);
	}

	/**
	 * Returns the employee directory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee directory
	 * @return the employee directory, or <code>null</code> if a employee directory with the primary key could not be found
	 */
	public static EmployeeDirectory fetchByPrimaryKey(long employeeId) {
		return getPersistence().fetchByPrimaryKey(employeeId);
	}

	/**
	 * Returns all the employee directories.
	 *
	 * @return the employee directories
	 */
	public static List<EmployeeDirectory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee directories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDirectoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee directories
	 * @param end the upper bound of the range of employee directories (not inclusive)
	 * @return the range of employee directories
	 */
	public static List<EmployeeDirectory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee directories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDirectoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee directories
	 * @param end the upper bound of the range of employee directories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee directories
	 */
	public static List<EmployeeDirectory> findAll(
		int start, int end,
		OrderByComparator<EmployeeDirectory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee directories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDirectoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee directories
	 * @param end the upper bound of the range of employee directories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee directories
	 */
	public static List<EmployeeDirectory> findAll(
		int start, int end,
		OrderByComparator<EmployeeDirectory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee directories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee directories.
	 *
	 * @return the number of employee directories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDirectoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EmployeeDirectoryPersistence _persistence;

}