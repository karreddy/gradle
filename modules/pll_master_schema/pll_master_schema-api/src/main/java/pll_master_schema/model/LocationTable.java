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
 * The table class for the &quot;pll_master_Location&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Location
 * @generated
 */
public class LocationTable extends BaseTable<LocationTable> {

	public static final LocationTable INSTANCE = new LocationTable();

	public final Column<LocationTable, Long> locationId = createColumn(
		"locationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LocationTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LocationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LocationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LocationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private LocationTable() {
		super("pll_master_Location", LocationTable::new);
	}

}