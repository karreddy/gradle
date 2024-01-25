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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;pll_EmployeeDirectory&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDirectory
 * @generated
 */
public class EmployeeDirectoryTable extends BaseTable<EmployeeDirectoryTable> {

	public static final EmployeeDirectoryTable INSTANCE =
		new EmployeeDirectoryTable();

	public final Column<EmployeeDirectoryTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeDirectoryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> employeeName =
		createColumn(
			"employeeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> designation =
		createColumn(
			"designation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> extentionNumber =
		createColumn(
			"extentionNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> directNumber =
		createColumn(
			"directNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> mobileNumber =
		createColumn(
			"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> alternateNumber =
		createColumn(
			"alternateNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> residenceNumber =
		createColumn(
			"residenceNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> faxNumber =
		createColumn(
			"faxNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> department =
		createColumn(
			"department", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> bloodGroup =
		createColumn(
			"bloodGroup", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, Long> fileEntryId =
		createColumn(
			"fileEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> presentGrade =
		createColumn(
			"presentGrade", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> passportNumber =
		createColumn(
			"passportNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, Date> passportValidity =
		createColumn(
			"passportValidity", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, Date> anniversary =
		createColumn(
			"anniversary", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> uanNumber =
		createColumn(
			"uanNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDirectoryTable, String> aboutMe = createColumn(
		"aboutMe", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EmployeeDirectoryTable() {
		super("pll_EmployeeDirectory", EmployeeDirectoryTable::new);
	}

}