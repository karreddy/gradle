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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.pll.employee.directory.exception.NoSuchEmployeeDirectoryException;
import com.pll.employee.directory.model.EmployeeDirectory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee directory service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDirectoryUtil
 * @generated
 */
@ProviderType
public interface EmployeeDirectoryPersistence
	extends BasePersistence<EmployeeDirectory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDirectoryUtil} to access the employee directory persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee directories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee directories
	 */
	public java.util.List<EmployeeDirectory> findByemployeeId(long employeeId);

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
	public java.util.List<EmployeeDirectory> findByemployeeId(
		long employeeId, int start, int end);

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
	public java.util.List<EmployeeDirectory> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDirectory>
			orderByComparator);

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
	public java.util.List<EmployeeDirectory> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDirectory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee directory in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee directory
	 * @throws NoSuchEmployeeDirectoryException if a matching employee directory could not be found
	 */
	public EmployeeDirectory findByemployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDirectory>
				orderByComparator)
		throws NoSuchEmployeeDirectoryException;

	/**
	 * Returns the first employee directory in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee directory, or <code>null</code> if a matching employee directory could not be found
	 */
	public EmployeeDirectory fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDirectory>
			orderByComparator);

	/**
	 * Returns the last employee directory in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee directory
	 * @throws NoSuchEmployeeDirectoryException if a matching employee directory could not be found
	 */
	public EmployeeDirectory findByemployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDirectory>
				orderByComparator)
		throws NoSuchEmployeeDirectoryException;

	/**
	 * Returns the last employee directory in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee directory, or <code>null</code> if a matching employee directory could not be found
	 */
	public EmployeeDirectory fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDirectory>
			orderByComparator);

	/**
	 * Removes all the employee directories where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByemployeeId(long employeeId);

	/**
	 * Returns the number of employee directories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee directories
	 */
	public int countByemployeeId(long employeeId);

	/**
	 * Caches the employee directory in the entity cache if it is enabled.
	 *
	 * @param employeeDirectory the employee directory
	 */
	public void cacheResult(EmployeeDirectory employeeDirectory);

	/**
	 * Caches the employee directories in the entity cache if it is enabled.
	 *
	 * @param employeeDirectories the employee directories
	 */
	public void cacheResult(
		java.util.List<EmployeeDirectory> employeeDirectories);

	/**
	 * Creates a new employee directory with the primary key. Does not add the employee directory to the database.
	 *
	 * @param employeeId the primary key for the new employee directory
	 * @return the new employee directory
	 */
	public EmployeeDirectory create(long employeeId);

	/**
	 * Removes the employee directory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee directory
	 * @return the employee directory that was removed
	 * @throws NoSuchEmployeeDirectoryException if a employee directory with the primary key could not be found
	 */
	public EmployeeDirectory remove(long employeeId)
		throws NoSuchEmployeeDirectoryException;

	public EmployeeDirectory updateImpl(EmployeeDirectory employeeDirectory);

	/**
	 * Returns the employee directory with the primary key or throws a <code>NoSuchEmployeeDirectoryException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee directory
	 * @return the employee directory
	 * @throws NoSuchEmployeeDirectoryException if a employee directory with the primary key could not be found
	 */
	public EmployeeDirectory findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeDirectoryException;

	/**
	 * Returns the employee directory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee directory
	 * @return the employee directory, or <code>null</code> if a employee directory with the primary key could not be found
	 */
	public EmployeeDirectory fetchByPrimaryKey(long employeeId);

	/**
	 * Returns all the employee directories.
	 *
	 * @return the employee directories
	 */
	public java.util.List<EmployeeDirectory> findAll();

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
	public java.util.List<EmployeeDirectory> findAll(int start, int end);

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
	public java.util.List<EmployeeDirectory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDirectory>
			orderByComparator);

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
	public java.util.List<EmployeeDirectory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDirectory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee directories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee directories.
	 *
	 * @return the number of employee directories
	 */
	public int countAll();

}