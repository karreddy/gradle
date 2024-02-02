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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;pll_master_Departments&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Departments
 * @generated
 */
public class DepartmentsTable extends BaseTable<DepartmentsTable> {

	public static final DepartmentsTable INSTANCE = new DepartmentsTable();

	public final Column<DepartmentsTable, Long> departmentId = createColumn(
		"departmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DepartmentsTable, String> department = createColumn(
		"department", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentsTable, Long> locationId = createColumn(
		"locationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentsTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentsTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DepartmentsTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DepartmentsTable() {
		super("pll_master_Departments", DepartmentsTable::new);
	}

}