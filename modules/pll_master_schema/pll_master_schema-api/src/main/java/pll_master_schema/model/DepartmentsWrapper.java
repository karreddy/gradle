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

package pll_master_schema.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Departments}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Departments
 * @generated
 */
public class DepartmentsWrapper
	extends BaseModelWrapper<Departments>
	implements Departments, ModelWrapper<Departments> {

	public DepartmentsWrapper(Departments departments) {
		super(departments);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("departmentId", getDepartmentId());
		attributes.put("department", getDepartment());
		attributes.put("locationId", getLocationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Departments cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this departments.
	 *
	 * @return the company ID of this departments
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this departments.
	 *
	 * @return the create date of this departments
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the department of this departments.
	 *
	 * @return the department of this departments
	 */
	@Override
	public String getDepartment() {
		return model.getDepartment();
	}

	/**
	 * Returns the department ID of this departments.
	 *
	 * @return the department ID of this departments
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the location ID of this departments.
	 *
	 * @return the location ID of this departments
	 */
	@Override
	public long getLocationId() {
		return model.getLocationId();
	}

	/**
	 * Returns the modified date of this departments.
	 *
	 * @return the modified date of this departments
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this departments.
	 *
	 * @return the primary key of this departments
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this departments.
	 *
	 * @return the user ID of this departments
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this departments.
	 *
	 * @return the user name of this departments
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this departments.
	 *
	 * @return the user uuid of this departments
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this departments.
	 *
	 * @param companyId the company ID of this departments
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this departments.
	 *
	 * @param createDate the create date of this departments
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the department of this departments.
	 *
	 * @param department the department of this departments
	 */
	@Override
	public void setDepartment(String department) {
		model.setDepartment(department);
	}

	/**
	 * Sets the department ID of this departments.
	 *
	 * @param departmentId the department ID of this departments
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the location ID of this departments.
	 *
	 * @param locationId the location ID of this departments
	 */
	@Override
	public void setLocationId(long locationId) {
		model.setLocationId(locationId);
	}

	/**
	 * Sets the modified date of this departments.
	 *
	 * @param modifiedDate the modified date of this departments
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this departments.
	 *
	 * @param primaryKey the primary key of this departments
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this departments.
	 *
	 * @param userId the user ID of this departments
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this departments.
	 *
	 * @param userName the user name of this departments
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this departments.
	 *
	 * @param userUuid the user uuid of this departments
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DepartmentsWrapper wrap(Departments departments) {
		return new DepartmentsWrapper(departments);
	}

}