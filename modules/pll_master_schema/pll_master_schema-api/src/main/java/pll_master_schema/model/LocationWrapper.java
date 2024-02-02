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
 * This class is a wrapper for {@link Location}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Location
 * @generated
 */
public class LocationWrapper
	extends BaseModelWrapper<Location>
	implements Location, ModelWrapper<Location> {

	public LocationWrapper(Location location) {
		super(location);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("location", getLocation());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
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
	public Location cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this location.
	 *
	 * @return the company ID of this location
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this location.
	 *
	 * @return the create date of this location
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the location of this location.
	 *
	 * @return the location of this location
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the location ID of this location.
	 *
	 * @return the location ID of this location
	 */
	@Override
	public long getLocationId() {
		return model.getLocationId();
	}

	/**
	 * Returns the modified date of this location.
	 *
	 * @return the modified date of this location
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this location.
	 *
	 * @return the primary key of this location
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this location.
	 *
	 * @return the user ID of this location
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this location.
	 *
	 * @return the user name of this location
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this location.
	 *
	 * @return the user uuid of this location
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
	 * Sets the company ID of this location.
	 *
	 * @param companyId the company ID of this location
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this location.
	 *
	 * @param createDate the create date of this location
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the location of this location.
	 *
	 * @param location the location of this location
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the location ID of this location.
	 *
	 * @param locationId the location ID of this location
	 */
	@Override
	public void setLocationId(long locationId) {
		model.setLocationId(locationId);
	}

	/**
	 * Sets the modified date of this location.
	 *
	 * @param modifiedDate the modified date of this location
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this location.
	 *
	 * @param primaryKey the primary key of this location
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this location.
	 *
	 * @param userId the user ID of this location
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this location.
	 *
	 * @param userName the user name of this location
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this location.
	 *
	 * @param userUuid the user uuid of this location
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
	protected LocationWrapper wrap(Location location) {
		return new LocationWrapper(location);
	}

}