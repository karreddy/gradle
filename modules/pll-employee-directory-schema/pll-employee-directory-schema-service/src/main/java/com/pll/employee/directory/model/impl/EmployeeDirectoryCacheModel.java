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

package com.pll.employee.directory.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.pll.employee.directory.model.EmployeeDirectory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDirectory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDirectoryCacheModel
	implements CacheModel<EmployeeDirectory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDirectoryCacheModel)) {
			return false;
		}

		EmployeeDirectoryCacheModel employeeDirectoryCacheModel =
			(EmployeeDirectoryCacheModel)object;

		if (employeeId == employeeDirectoryCacheModel.employeeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", employeeName=");
		sb.append(employeeName);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", extentionNumber=");
		sb.append(extentionNumber);
		sb.append(", directNumber=");
		sb.append(directNumber);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", alternateNumber=");
		sb.append(alternateNumber);
		sb.append(", residenceNumber=");
		sb.append(residenceNumber);
		sb.append(", faxNumber=");
		sb.append(faxNumber);
		sb.append(", location=");
		sb.append(location);
		sb.append(", department=");
		sb.append(department);
		sb.append(", bloodGroup=");
		sb.append(bloodGroup);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", presentGrade=");
		sb.append(presentGrade);
		sb.append(", passportNumber=");
		sb.append(passportNumber);
		sb.append(", passportValidity=");
		sb.append(passportValidity);
		sb.append(", anniversary=");
		sb.append(anniversary);
		sb.append(", uanNumber=");
		sb.append(uanNumber);
		sb.append(", aboutMe=");
		sb.append(aboutMe);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDirectory toEntityModel() {
		EmployeeDirectoryImpl employeeDirectoryImpl =
			new EmployeeDirectoryImpl();

		employeeDirectoryImpl.setEmployeeId(employeeId);
		employeeDirectoryImpl.setGroupId(groupId);
		employeeDirectoryImpl.setCompanyId(companyId);
		employeeDirectoryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			employeeDirectoryImpl.setCreateDate(null);
		}
		else {
			employeeDirectoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDirectoryImpl.setModifiedDate(null);
		}
		else {
			employeeDirectoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (employeeName == null) {
			employeeDirectoryImpl.setEmployeeName("");
		}
		else {
			employeeDirectoryImpl.setEmployeeName(employeeName);
		}

		if (designation == null) {
			employeeDirectoryImpl.setDesignation("");
		}
		else {
			employeeDirectoryImpl.setDesignation(designation);
		}

		if (extentionNumber == null) {
			employeeDirectoryImpl.setExtentionNumber("");
		}
		else {
			employeeDirectoryImpl.setExtentionNumber(extentionNumber);
		}

		if (directNumber == null) {
			employeeDirectoryImpl.setDirectNumber("");
		}
		else {
			employeeDirectoryImpl.setDirectNumber(directNumber);
		}

		if (mobileNumber == null) {
			employeeDirectoryImpl.setMobileNumber("");
		}
		else {
			employeeDirectoryImpl.setMobileNumber(mobileNumber);
		}

		if (alternateNumber == null) {
			employeeDirectoryImpl.setAlternateNumber("");
		}
		else {
			employeeDirectoryImpl.setAlternateNumber(alternateNumber);
		}

		if (residenceNumber == null) {
			employeeDirectoryImpl.setResidenceNumber("");
		}
		else {
			employeeDirectoryImpl.setResidenceNumber(residenceNumber);
		}

		if (faxNumber == null) {
			employeeDirectoryImpl.setFaxNumber("");
		}
		else {
			employeeDirectoryImpl.setFaxNumber(faxNumber);
		}

		if (location == null) {
			employeeDirectoryImpl.setLocation("");
		}
		else {
			employeeDirectoryImpl.setLocation(location);
		}

		if (department == null) {
			employeeDirectoryImpl.setDepartment("");
		}
		else {
			employeeDirectoryImpl.setDepartment(department);
		}

		if (bloodGroup == null) {
			employeeDirectoryImpl.setBloodGroup("");
		}
		else {
			employeeDirectoryImpl.setBloodGroup(bloodGroup);
		}

		employeeDirectoryImpl.setFileEntryId(fileEntryId);

		if (presentGrade == null) {
			employeeDirectoryImpl.setPresentGrade("");
		}
		else {
			employeeDirectoryImpl.setPresentGrade(presentGrade);
		}

		if (passportNumber == null) {
			employeeDirectoryImpl.setPassportNumber("");
		}
		else {
			employeeDirectoryImpl.setPassportNumber(passportNumber);
		}

		if (passportValidity == Long.MIN_VALUE) {
			employeeDirectoryImpl.setPassportValidity(null);
		}
		else {
			employeeDirectoryImpl.setPassportValidity(
				new Date(passportValidity));
		}

		if (anniversary == Long.MIN_VALUE) {
			employeeDirectoryImpl.setAnniversary(null);
		}
		else {
			employeeDirectoryImpl.setAnniversary(new Date(anniversary));
		}

		if (uanNumber == null) {
			employeeDirectoryImpl.setUanNumber("");
		}
		else {
			employeeDirectoryImpl.setUanNumber(uanNumber);
		}

		if (aboutMe == null) {
			employeeDirectoryImpl.setAboutMe("");
		}
		else {
			employeeDirectoryImpl.setAboutMe(aboutMe);
		}

		employeeDirectoryImpl.resetOriginalValues();

		return employeeDirectoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		employeeName = objectInput.readUTF();
		designation = objectInput.readUTF();
		extentionNumber = objectInput.readUTF();
		directNumber = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();
		alternateNumber = objectInput.readUTF();
		residenceNumber = objectInput.readUTF();
		faxNumber = objectInput.readUTF();
		location = objectInput.readUTF();
		department = objectInput.readUTF();
		bloodGroup = objectInput.readUTF();

		fileEntryId = objectInput.readLong();
		presentGrade = objectInput.readUTF();
		passportNumber = objectInput.readUTF();
		passportValidity = objectInput.readLong();
		anniversary = objectInput.readLong();
		uanNumber = objectInput.readUTF();
		aboutMe = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (employeeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeName);
		}

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		if (extentionNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(extentionNumber);
		}

		if (directNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(directNumber);
		}

		if (mobileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNumber);
		}

		if (alternateNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(alternateNumber);
		}

		if (residenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(residenceNumber);
		}

		if (faxNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(faxNumber);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (department == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (bloodGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bloodGroup);
		}

		objectOutput.writeLong(fileEntryId);

		if (presentGrade == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(presentGrade);
		}

		if (passportNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(passportNumber);
		}

		objectOutput.writeLong(passportValidity);
		objectOutput.writeLong(anniversary);

		if (uanNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uanNumber);
		}

		if (aboutMe == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aboutMe);
		}
	}

	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String employeeName;
	public String designation;
	public String extentionNumber;
	public String directNumber;
	public String mobileNumber;
	public String alternateNumber;
	public String residenceNumber;
	public String faxNumber;
	public String location;
	public String department;
	public String bloodGroup;
	public long fileEntryId;
	public String presentGrade;
	public String passportNumber;
	public long passportValidity;
	public long anniversary;
	public String uanNumber;
	public String aboutMe;

}