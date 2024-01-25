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

package com.pll.employee.directory.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeDirectoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDirectoryLocalService
 * @generated
 */
public class EmployeeDirectoryLocalServiceWrapper
	implements EmployeeDirectoryLocalService,
			   ServiceWrapper<EmployeeDirectoryLocalService> {

	public EmployeeDirectoryLocalServiceWrapper() {
		this(null);
	}

	public EmployeeDirectoryLocalServiceWrapper(
		EmployeeDirectoryLocalService employeeDirectoryLocalService) {

		_employeeDirectoryLocalService = employeeDirectoryLocalService;
	}

	/**
	 * Adds the employee directory to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDirectoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDirectory the employee directory
	 * @return the employee directory that was added
	 */
	@Override
	public com.pll.employee.directory.model.EmployeeDirectory
		addEmployeeDirectory(
			com.pll.employee.directory.model.EmployeeDirectory
				employeeDirectory) {

		return _employeeDirectoryLocalService.addEmployeeDirectory(
			employeeDirectory);
	}

	/**
	 * Creates a new employee directory with the primary key. Does not add the employee directory to the database.
	 *
	 * @param employeeId the primary key for the new employee directory
	 * @return the new employee directory
	 */
	@Override
	public com.pll.employee.directory.model.EmployeeDirectory
		createEmployeeDirectory(long employeeId) {

		return _employeeDirectoryLocalService.createEmployeeDirectory(
			employeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDirectoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee directory from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDirectoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDirectory the employee directory
	 * @return the employee directory that was removed
	 */
	@Override
	public com.pll.employee.directory.model.EmployeeDirectory
		deleteEmployeeDirectory(
			com.pll.employee.directory.model.EmployeeDirectory
				employeeDirectory) {

		return _employeeDirectoryLocalService.deleteEmployeeDirectory(
			employeeDirectory);
	}

	/**
	 * Deletes the employee directory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDirectoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeId the primary key of the employee directory
	 * @return the employee directory that was removed
	 * @throws PortalException if a employee directory with the primary key could not be found
	 */
	@Override
	public com.pll.employee.directory.model.EmployeeDirectory
			deleteEmployeeDirectory(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDirectoryLocalService.deleteEmployeeDirectory(
			employeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDirectoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeDirectoryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeDirectoryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDirectoryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeDirectoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.pll.employee.directory.model.impl.EmployeeDirectoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeeDirectoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.pll.employee.directory.model.impl.EmployeeDirectoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeeDirectoryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeDirectoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _employeeDirectoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.pll.employee.directory.model.EmployeeDirectory
		fetchEmployeeDirectory(long employeeId) {

		return _employeeDirectoryLocalService.fetchEmployeeDirectory(
			employeeId);
	}

	@Override
	public java.util.List<com.pll.employee.directory.model.EmployeeDirectory>
		findEmployeeByDepartmentName(String department) {

		return _employeeDirectoryLocalService.findEmployeeByDepartmentName(
			department);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDirectoryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the employee directories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.pll.employee.directory.model.impl.EmployeeDirectoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee directories
	 * @param end the upper bound of the range of employee directories (not inclusive)
	 * @return the range of employee directories
	 */
	@Override
	public java.util.List<com.pll.employee.directory.model.EmployeeDirectory>
		getEmployeeDirectories(int start, int end) {

		return _employeeDirectoryLocalService.getEmployeeDirectories(
			start, end);
	}

	/**
	 * Returns the number of employee directories.
	 *
	 * @return the number of employee directories
	 */
	@Override
	public int getEmployeeDirectoriesCount() {
		return _employeeDirectoryLocalService.getEmployeeDirectoriesCount();
	}

	/**
	 * Returns the employee directory with the primary key.
	 *
	 * @param employeeId the primary key of the employee directory
	 * @return the employee directory
	 * @throws PortalException if a employee directory with the primary key could not be found
	 */
	@Override
	public com.pll.employee.directory.model.EmployeeDirectory
			getEmployeeDirectory(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDirectoryLocalService.getEmployeeDirectory(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDirectoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDirectoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDirectoryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.pll.employee.directory.model.EmployeeDirectory>
		getusersByLocation(String location) {

		return _employeeDirectoryLocalService.getusersByLocation(location);
	}

	/**
	 * Updates the employee directory in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDirectoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDirectory the employee directory
	 * @return the employee directory that was updated
	 */
	@Override
	public com.pll.employee.directory.model.EmployeeDirectory
		updateEmployeeDirectory(
			com.pll.employee.directory.model.EmployeeDirectory
				employeeDirectory) {

		return _employeeDirectoryLocalService.updateEmployeeDirectory(
			employeeDirectory);
	}

	@Override
	public EmployeeDirectoryLocalService getWrappedService() {
		return _employeeDirectoryLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDirectoryLocalService employeeDirectoryLocalService) {

		_employeeDirectoryLocalService = employeeDirectoryLocalService;
	}

	private EmployeeDirectoryLocalService _employeeDirectoryLocalService;

}