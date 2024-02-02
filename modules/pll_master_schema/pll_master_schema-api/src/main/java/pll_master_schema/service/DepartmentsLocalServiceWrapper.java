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

package pll_master_schema.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DepartmentsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentsLocalService
 * @generated
 */
public class DepartmentsLocalServiceWrapper
	implements DepartmentsLocalService,
			   ServiceWrapper<DepartmentsLocalService> {

	public DepartmentsLocalServiceWrapper() {
		this(null);
	}

	public DepartmentsLocalServiceWrapper(
		DepartmentsLocalService departmentsLocalService) {

		_departmentsLocalService = departmentsLocalService;
	}

	/**
	 * Adds the departments to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departments the departments
	 * @return the departments that was added
	 */
	@Override
	public pll_master_schema.model.Departments addDepartments(
		pll_master_schema.model.Departments departments) {

		return _departmentsLocalService.addDepartments(departments);
	}

	/**
	 * Creates a new departments with the primary key. Does not add the departments to the database.
	 *
	 * @param departmentId the primary key for the new departments
	 * @return the new departments
	 */
	@Override
	public pll_master_schema.model.Departments createDepartments(
		long departmentId) {

		return _departmentsLocalService.createDepartments(departmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the departments from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departments the departments
	 * @return the departments that was removed
	 */
	@Override
	public pll_master_schema.model.Departments deleteDepartments(
		pll_master_schema.model.Departments departments) {

		return _departmentsLocalService.deleteDepartments(departments);
	}

	/**
	 * Deletes the departments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentId the primary key of the departments
	 * @return the departments that was removed
	 * @throws PortalException if a departments with the primary key could not be found
	 */
	@Override
	public pll_master_schema.model.Departments deleteDepartments(
			long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentsLocalService.deleteDepartments(departmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _departmentsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _departmentsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _departmentsLocalService.dynamicQuery();
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

		return _departmentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>pll_master_schema.model.impl.DepartmentsModelImpl</code>.
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

		return _departmentsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>pll_master_schema.model.impl.DepartmentsModelImpl</code>.
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

		return _departmentsLocalService.dynamicQuery(
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

		return _departmentsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _departmentsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public pll_master_schema.model.Departments fetchDepartments(
		long departmentId) {

		return _departmentsLocalService.fetchDepartments(departmentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _departmentsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the departments with the primary key.
	 *
	 * @param departmentId the primary key of the departments
	 * @return the departments
	 * @throws PortalException if a departments with the primary key could not be found
	 */
	@Override
	public pll_master_schema.model.Departments getDepartments(long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentsLocalService.getDepartments(departmentId);
	}

	@Override
	public java.util.List<pll_master_schema.model.Departments>
		getDepartmentsBylocationId(long locationId) {

		return _departmentsLocalService.getDepartmentsBylocationId(locationId);
	}

	/**
	 * Returns a range of all the departmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>pll_master_schema.model.impl.DepartmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of departmentses
	 * @param end the upper bound of the range of departmentses (not inclusive)
	 * @return the range of departmentses
	 */
	@Override
	public java.util.List<pll_master_schema.model.Departments> getDepartmentses(
		int start, int end) {

		return _departmentsLocalService.getDepartmentses(start, end);
	}

	/**
	 * Returns the number of departmentses.
	 *
	 * @return the number of departmentses
	 */
	@Override
	public int getDepartmentsesCount() {
		return _departmentsLocalService.getDepartmentsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _departmentsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _departmentsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the departments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departments the departments
	 * @return the departments that was updated
	 */
	@Override
	public pll_master_schema.model.Departments updateDepartments(
		pll_master_schema.model.Departments departments) {

		return _departmentsLocalService.updateDepartments(departments);
	}

	@Override
	public DepartmentsLocalService getWrappedService() {
		return _departmentsLocalService;
	}

	@Override
	public void setWrappedService(
		DepartmentsLocalService departmentsLocalService) {

		_departmentsLocalService = departmentsLocalService;
	}

	private DepartmentsLocalService _departmentsLocalService;

}