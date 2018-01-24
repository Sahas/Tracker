create database trackerdb character set UTF8mb4 collate utf8mb4_bin;

use trackerdb;

create table DEVICE_TYPE (`TYPE_ID` smallint unsigned not null AUTO_INCREMENT,
	`TYPE_NAME` VARCHAR(255) not null, 
	`created_by` VARCHAR(255) DEFAULT NULL,	
	`created_date` DATETIME DEFAULT NULL,	
	`updated_by` VARCHAR(255) DEFAULT NULL,
	`updated_date` DATETIME DEFAULT NULL,
	PRIMARY KEY (`TYPE_ID`),
	unique key `TYPE_NAME` (`TYPE_NAME`)
	);

create table ASSET_TYPE (`TYPE_ID` smallint unsigned not null AUTO_INCREMENT,
	`TYPE_NAME` VARCHAR(255) not null, 
	`created_by` VARCHAR(255) DEFAULT NULL,	
	`created_date` DATETIME DEFAULT NULL,	
	`updated_by` VARCHAR(255) DEFAULT NULL,
	`updated_date` DATETIME DEFAULT NULL,
	PRIMARY KEY (`TYPE_ID`),
	unique key `TYPE_NAME` (`TYPE_NAME`)
	);
	
create table DEVICE_DETAILS (`DEVICE_ID` mediumint unsigned not null AUTO_INCREMENT,
	`DEVICE_NAME` VARCHAR(255) not null,
	`DEVICE_TYPE` smallint unsigned not null,
	`created_by` VARCHAR(255) DEFAULT NULL,	
	`created_date` DATETIME DEFAULT NULL,	
	`updated_by` VARCHAR(255) DEFAULT NULL,
	`updated_date` DATETIME DEFAULT NULL,
	primary key (`DEVICE_ID`),
	foreign key (`DEVICE_TYPE`) references DEVICE_TYPE(`TYPE_ID`)
);

create table ASSET_DETAILS (`ASSET_ID` mediumint unsigned not null AUTO_INCREMENT,
	`ASSET_NAME` VARCHAR(255),
	`ASSET_TYPE` smallint unsigned not null,
	`created_by` VARCHAR(255) DEFAULT NULL,	
	`created_date` DATETIME DEFAULT NULL,	
	`updated_by` VARCHAR(255) DEFAULT NULL,
	`updated_date` DATETIME DEFAULT NULL,
	primary key (`ASSET_ID`),
	foreign key (`ASSET_TYPE`) references asset_type(TYPE_ID)
);

create table TRACKING_DATA (`TRACKING_ID` bigint(22) unsigned not null AUTO_INCREMENT,
	`LAT` DECIMAL(10, 8) not null,
	`LNG` DECIMAL(11,8) not null,
	`TIMESTAMP` DATETIME DEFAULT current_timestamp,
	`SPEED` FLOAT(7,3) ,
	`DEVICE_ID` mediumint unsigned not null,
	`ASSET_ID` mediumint unsigned,
	`METADATA` TEXT,
	primary key (`TRACKING_ID`),
	foreign key (`DEVICE_ID`) references DEVICE_DETAILS(`DEVICE_ID`),
	foreign key (`ASSET_ID`) references ASSET_DETAILS(`ASSET_ID`)
);

