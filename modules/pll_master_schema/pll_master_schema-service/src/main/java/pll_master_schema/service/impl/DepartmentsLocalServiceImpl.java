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

package pll_master_schema.service.impl;

import com.liferay.portal.aop.AopService;


import java.util.List;

import org.osgi.service.component.annotations.Component;

import pll_master_schema.model.Departments;
import pll_master_schema.service.base.DepartmentsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=pll_master_schema.model.Departments",
	service = AopService.class
)
public class DepartmentsLocalServiceImpl
	extends DepartmentsLocalServiceBaseImpl {
	public List<Departments> getDepartmentsBylocationId(long locationId) {
		
		return departmentsPersistence.findBylocationId(locationId);
	}
}