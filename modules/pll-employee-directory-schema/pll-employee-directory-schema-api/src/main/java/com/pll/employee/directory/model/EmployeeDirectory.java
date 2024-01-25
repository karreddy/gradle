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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EmployeeDirectory service. Represents a row in the &quot;pll_EmployeeDirectory&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDirectoryModel
 * @generated
 */
@ImplementationClassName(
	"com.pll.employee.directory.model.impl.EmployeeDirectoryImpl"
)
@ProviderType
public interface EmployeeDirectory
	extends EmployeeDirectoryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.pll.employee.directory.model.impl.EmployeeDirectoryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmployeeDirectory, Long> EMPLOYEE_ID_ACCESSOR =
		new Accessor<EmployeeDirectory, Long>() {

			@Override
			public Long get(EmployeeDirectory employeeDirectory) {
				return employeeDirectory.getEmployeeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EmployeeDirectory> getTypeClass() {
				return EmployeeDirectory.class;
			}

		};

}