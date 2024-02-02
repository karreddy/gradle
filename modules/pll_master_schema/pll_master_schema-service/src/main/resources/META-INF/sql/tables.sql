create table pll_master_Departments (
	departmentId LONG not null primary key,
	department VARCHAR(75) null,
	locationId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table pll_master_Location (
	locationId LONG not null primary key,
	location VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);