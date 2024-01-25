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

package com.pll.employee.directory.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeDirectory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDirectory
 * @generated
 */
public class EmployeeDirectoryWrapper
	extends BaseModelWrapper<EmployeeDirectory>
	implements EmployeeDirectory, ModelWrapper<EmployeeDirectory> {

	public EmployeeDirectoryWrapper(EmployeeDirectory employeeDirectory) {
		super(employeeDirectory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeName", getEmployeeName());
		attributes.put("designation", getDesignation());
		attributes.put("extentionNumber", getExtentionNumber());
		attributes.put("directNumber", getDirectNumber());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("alternateNumber", getAlternateNumber());
		attributes.put("residenceNumber", getResidenceNumber());
		attributes.put("faxNumber", getFaxNumber());
		attributes.put("location", getLocation());
		attributes.put("department", getDepartment());
		attributes.put("bloodGroup", getBloodGroup());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("presentGrade", getPresentGrade());
		attributes.put("passportNumber", getPassportNumber());
		attributes.put("passportValidity", getPassportValidity());
		attributes.put("anniversary", getAnniversary());
		attributes.put("uanNumber", getUanNumber());
		attributes.put("aboutMe", getAboutMe());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String employeeName = (String)attributes.get("employeeName");

		if (employeeName != null) {
			setEmployeeName(employeeName);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		String extentionNumber = (String)attributes.get("extentionNumber");

		if (extentionNumber != null) {
			setExtentionNumber(extentionNumber);
		}

		String directNumber = (String)attributes.get("directNumber");

		if (directNumber != null) {
			setDirectNumber(directNumber);
		}

		String mobileNumber = (String)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		String alternateNumber = (String)attributes.get("alternateNumber");

		if (alternateNumber != null) {
			setAlternateNumber(alternateNumber);
		}

		String residenceNumber = (String)attributes.get("residenceNumber");

		if (residenceNumber != null) {
			setResidenceNumber(residenceNumber);
		}

		String faxNumber = (String)attributes.get("faxNumber");

		if (faxNumber != null) {
			setFaxNumber(faxNumber);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String bloodGroup = (String)attributes.get("bloodGroup");

		if (bloodGroup != null) {
			setBloodGroup(bloodGroup);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String presentGrade = (String)attributes.get("presentGrade");

		if (presentGrade != null) {
			setPresentGrade(presentGrade);
		}

		String passportNumber = (String)attributes.get("passportNumber");

		if (passportNumber != null) {
			setPassportNumber(passportNumber);
		}

		Date passportValidity = (Date)attributes.get("passportValidity");

		if (passportValidity != null) {
			setPassportValidity(passportValidity);
		}

		Date anniversary = (Date)attributes.get("anniversary");

		if (anniversary != null) {
			setAnniversary(anniversary);
		}

		String uanNumber = (String)attributes.get("uanNumber");

		if (uanNumber != null) {
			setUanNumber(uanNumber);
		}

		String aboutMe = (String)attributes.get("aboutMe");

		if (aboutMe != null) {
			setAboutMe(aboutMe);
		}
	}

	@Override
	public EmployeeDirectory cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the about me of this employee directory.
	 *
	 * @return the about me of this employee directory
	 */
	@Override
	public String getAboutMe() {
		return model.getAboutMe();
	}

	/**
	 * Returns the alternate number of this employee directory.
	 *
	 * @return the alternate number of this employee directory
	 */
	@Override
	public String getAlternateNumber() {
		return model.getAlternateNumber();
	}

	/**
	 * Returns the anniversary of this employee directory.
	 *
	 * @return the anniversary of this employee directory
	 */
	@Override
	public Date getAnniversary() {
		return model.getAnniversary();
	}

	/**
	 * Returns the blood group of this employee directory.
	 *
	 * @return the blood group of this employee directory
	 */
	@Override
	public String getBloodGroup() {
		return model.getBloodGroup();
	}

	/**
	 * Returns the company ID of this employee directory.
	 *
	 * @return the company ID of this employee directory
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee directory.
	 *
	 * @return the create date of this employee directory
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the department of this employee directory.
	 *
	 * @return the department of this employee directory
	 */
	@Override
	public String getDepartment() {
		return model.getDepartment();
	}

	/**
	 * Returns the designation of this employee directory.
	 *
	 * @return the designation of this employee directory
	 */
	@Override
	public String getDesignation() {
		return model.getDesignation();
	}

	/**
	 * Returns the direct number of this employee directory.
	 *
	 * @return the direct number of this employee directory
	 */
	@Override
	public String getDirectNumber() {
		return model.getDirectNumber();
	}

	/**
	 * Returns the employee ID of this employee directory.
	 *
	 * @return the employee ID of this employee directory
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee name of this employee directory.
	 *
	 * @return the employee name of this employee directory
	 */
	@Override
	public String getEmployeeName() {
		return model.getEmployeeName();
	}

	/**
	 * Returns the extention number of this employee directory.
	 *
	 * @return the extention number of this employee directory
	 */
	@Override
	public String getExtentionNumber() {
		return model.getExtentionNumber();
	}

	/**
	 * Returns the fax number of this employee directory.
	 *
	 * @return the fax number of this employee directory
	 */
	@Override
	public String getFaxNumber() {
		return model.getFaxNumber();
	}

	/**
	 * Returns the file entry ID of this employee directory.
	 *
	 * @return the file entry ID of this employee directory
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the group ID of this employee directory.
	 *
	 * @return the group ID of this employee directory
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the location of this employee directory.
	 *
	 * @return the location of this employee directory
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the mobile number of this employee directory.
	 *
	 * @return the mobile number of this employee directory
	 */
	@Override
	public String getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the modified date of this employee directory.
	 *
	 * @return the modified date of this employee directory
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the passport number of this employee directory.
	 *
	 * @return the passport number of this employee directory
	 */
	@Override
	public String getPassportNumber() {
		return model.getPassportNumber();
	}

	/**
	 * Returns the passport validity of this employee directory.
	 *
	 * @return the passport validity of this employee directory
	 */
	@Override
	public Date getPassportValidity() {
		return model.getPassportValidity();
	}

	/**
	 * Returns the present grade of this employee directory.
	 *
	 * @return the present grade of this employee directory
	 */
	@Override
	public String getPresentGrade() {
		return model.getPresentGrade();
	}

	/**
	 * Returns the primary key of this employee directory.
	 *
	 * @return the primary key of this employee directory
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the residence number of this employee directory.
	 *
	 * @return the residence number of this employee directory
	 */
	@Override
	public String getResidenceNumber() {
		return model.getResidenceNumber();
	}

	/**
	 * Returns the uan number of this employee directory.
	 *
	 * @return the uan number of this employee directory
	 */
	@Override
	public String getUanNumber() {
		return model.getUanNumber();
	}

	/**
	 * Returns the user ID of this employee directory.
	 *
	 * @return the user ID of this employee directory
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this employee directory.
	 *
	 * @return the user uuid of this employee directory
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
	 * Sets the about me of this employee directory.
	 *
	 * @param aboutMe the about me of this employee directory
	 */
	@Override
	public void setAboutMe(String aboutMe) {
		model.setAboutMe(aboutMe);
	}

	/**
	 * Sets the alternate number of this employee directory.
	 *
	 * @param alternateNumber the alternate number of this employee directory
	 */
	@Override
	public void setAlternateNumber(String alternateNumber) {
		model.setAlternateNumber(alternateNumber);
	}

	/**
	 * Sets the anniversary of this employee directory.
	 *
	 * @param anniversary the anniversary of this employee directory
	 */
	@Override
	public void setAnniversary(Date anniversary) {
		model.setAnniversary(anniversary);
	}

	/**
	 * Sets the blood group of this employee directory.
	 *
	 * @param bloodGroup the blood group of this employee directory
	 */
	@Override
	public void setBloodGroup(String bloodGroup) {
		model.setBloodGroup(bloodGroup);
	}

	/**
	 * Sets the company ID of this employee directory.
	 *
	 * @param companyId the company ID of this employee directory
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee directory.
	 *
	 * @param createDate the create date of this employee directory
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the department of this employee directory.
	 *
	 * @param department the department of this employee directory
	 */
	@Override
	public void setDepartment(String department) {
		model.setDepartment(department);
	}

	/**
	 * Sets the designation of this employee directory.
	 *
	 * @param designation the designation of this employee directory
	 */
	@Override
	public void setDesignation(String designation) {
		model.setDesignation(designation);
	}

	/**
	 * Sets the direct number of this employee directory.
	 *
	 * @param directNumber the direct number of this employee directory
	 */
	@Override
	public void setDirectNumber(String directNumber) {
		model.setDirectNumber(directNumber);
	}

	/**
	 * Sets the employee ID of this employee directory.
	 *
	 * @param employeeId the employee ID of this employee directory
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee name of this employee directory.
	 *
	 * @param employeeName the employee name of this employee directory
	 */
	@Override
	public void setEmployeeName(String employeeName) {
		model.setEmployeeName(employeeName);
	}

	/**
	 * Sets the extention number of this employee directory.
	 *
	 * @param extentionNumber the extention number of this employee directory
	 */
	@Override
	public void setExtentionNumber(String extentionNumber) {
		model.setExtentionNumber(extentionNumber);
	}

	/**
	 * Sets the fax number of this employee directory.
	 *
	 * @param faxNumber the fax number of this employee directory
	 */
	@Override
	public void setFaxNumber(String faxNumber) {
		model.setFaxNumber(faxNumber);
	}

	/**
	 * Sets the file entry ID of this employee directory.
	 *
	 * @param fileEntryId the file entry ID of this employee directory
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the group ID of this employee directory.
	 *
	 * @param groupId the group ID of this employee directory
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the location of this employee directory.
	 *
	 * @param location the location of this employee directory
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the mobile number of this employee directory.
	 *
	 * @param mobileNumber the mobile number of this employee directory
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the modified date of this employee directory.
	 *
	 * @param modifiedDate the modified date of this employee directory
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the passport number of this employee directory.
	 *
	 * @param passportNumber the passport number of this employee directory
	 */
	@Override
	public void setPassportNumber(String passportNumber) {
		model.setPassportNumber(passportNumber);
	}

	/**
	 * Sets the passport validity of this employee directory.
	 *
	 * @param passportValidity the passport validity of this employee directory
	 */
	@Override
	public void setPassportValidity(Date passportValidity) {
		model.setPassportValidity(passportValidity);
	}

	/**
	 * Sets the present grade of this employee directory.
	 *
	 * @param presentGrade the present grade of this employee directory
	 */
	@Override
	public void setPresentGrade(String presentGrade) {
		model.setPresentGrade(presentGrade);
	}

	/**
	 * Sets the primary key of this employee directory.
	 *
	 * @param primaryKey the primary key of this employee directory
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the residence number of this employee directory.
	 *
	 * @param residenceNumber the residence number of this employee directory
	 */
	@Override
	public void setResidenceNumber(String residenceNumber) {
		model.setResidenceNumber(residenceNumber);
	}

	/**
	 * Sets the uan number of this employee directory.
	 *
	 * @param uanNumber the uan number of this employee directory
	 */
	@Override
	public void setUanNumber(String uanNumber) {
		model.setUanNumber(uanNumber);
	}

	/**
	 * Sets the user ID of this employee directory.
	 *
	 * @param userId the user ID of this employee directory
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this employee directory.
	 *
	 * @param userUuid the user uuid of this employee directory
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
	protected EmployeeDirectoryWrapper wrap(
		EmployeeDirectory employeeDirectory) {

		return new EmployeeDirectoryWrapper(employeeDirectory);
	}

}