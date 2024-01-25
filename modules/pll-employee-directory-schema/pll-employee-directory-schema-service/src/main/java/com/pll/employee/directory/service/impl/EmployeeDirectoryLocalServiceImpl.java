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

package com.pll.employee.directory.service.impl;

import com.liferay.portal.aop.AopService;
import com.pll.employee.directory.model.EmployeeDirectory;
import com.pll.employee.directory.service.base.EmployeeDirectoryLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.pll.employee.directory.model.EmployeeDirectory",
	service = AopService.class
)
public class EmployeeDirectoryLocalServiceImpl
	extends EmployeeDirectoryLocalServiceBaseImpl {
	
	public List<EmployeeDirectory> findEmployeeByDepartmentName(String department) {
		return employeeDirectoryPersistence.findByDepartment(department);
}
	
	@Override
	public List<EmployeeDirectory> getusersByLocation(String location) {
	
		return employeeDirectoryPersistence.findBylocation(location);
	}
}	