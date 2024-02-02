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

import pll_master_schema.model.Location;

/**
 * The cache model class for representing Location in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LocationCacheModel
	implements CacheModel<Location>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LocationCacheModel)) {
			return false;
		}

		LocationCacheModel locationCacheModel = (LocationCacheModel)object;

		if (locationId == locationCacheModel.locationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, locationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{locationId=");
		sb.append(locationId);
		sb.append(", location=");
		sb.append(location);
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
	public Location toEntityModel() {
		LocationImpl locationImpl = new LocationImpl();

		locationImpl.setLocationId(locationId);

		if (location == null) {
			locationImpl.setLocation("");
		}
		else {
			locationImpl.setLocation(location);
		}

		locationImpl.setCompanyId(companyId);
		locationImpl.setUserId(userId);

		if (userName == null) {
			locationImpl.setUserName("");
		}
		else {
			locationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			locationImpl.setCreateDate(null);
		}
		else {
			locationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			locationImpl.setModifiedDate(null);
		}
		else {
			locationImpl.setModifiedDate(new Date(modifiedDate));
		}

		locationImpl.resetOriginalValues();

		return locationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		locationId = objectInput.readLong();
		location = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(locationId);

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

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

	public long locationId;
	public String location;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}