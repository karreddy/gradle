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

package pll_master_schema.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import pll_master_schema.model.Departments;

/**
 * The cache model class for representing Departments in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DepartmentsCacheModel
	implements CacheModel<Departments>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DepartmentsCacheModel)) {
			return false;
		}

		DepartmentsCacheModel departmentsCacheModel =
			(DepartmentsCacheModel)object;

		if (departmentId == departmentsCacheModel.departmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, departmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{departmentId=");
		sb.append(departmentId);
		sb.append(", department=");
		sb.append(department);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Departments toEntityModel() {
		DepartmentsImpl departmentsImpl = new DepartmentsImpl();

		departmentsImpl.setDepartmentId(departmentId);

		if (department == null) {
			departmentsImpl.setDepartment("");
		}
		else {
			departmentsImpl.setDepartment(department);
		}

		departmentsImpl.setLocationId(locationId);
		departmentsImpl.setCompanyId(companyId);
		departmentsImpl.setUserId(userId);

		if (userName == null) {
			departmentsImpl.setUserName("");
		}
		else {
			departmentsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			departmentsImpl.setCreateDate(null);
		}
		else {
			departmentsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			departmentsImpl.setModifiedDate(null);
		}
		else {
			departmentsImpl.setModifiedDate(new Date(modifiedDate));
		}

		departmentsImpl.resetOriginalValues();

		return departmentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		departmentId = objectInput.readLong();
		department = objectInput.readUTF();

		locationId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(departmentId);

		if (department == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(department);
		}

		objectOutput.writeLong(locationId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long departmentId;
	public String department;
	public long locationId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}