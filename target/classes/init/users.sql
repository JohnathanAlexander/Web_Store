DROP DATABASE users IF EXISTS;
CREATE DATABASE users;

CREATE TABLE user_information (
	recordId primary key int(11) AUTO_INCREMENT UNIQUE NOT NULL,
	username varchar(50) not null unique,
	password varchar(50) not null,
	first_name varchar(20),
	last_name varchar(20),
	email varchar(50) not null unique,
	userAuthLevel varchar(15) not null default 'USER',
	mostRecentLogin DATETIME default null,
	accountCreatedDate DATETIME default null
)

CREATE TABLE elevated_user_actions(
	recordId primary key int(11) AUTO_INCREMENT unique not null,
	username varchar(50) not null,
	action varchar(45) not null,
	timestamp datetime not null
	
	CONSTRAINT fk_username
	FOREIGN KEY fk_username
	REFERENCES `users`.`user_information`(username)
)

CREATE TABLE password_resets(
	recordId primary key not null unique AUTO_INCREMENT,
	resetee varchar(45) not null,
	resetter varchar(45) not null,
	timestamp datetime not null
	
	constraint resetee
	foreign key resetee
	references `users`.`user_information`(username)
	
	constraint resetter
	foreign key resetter
	references `users`.`user_information`(username)
)

CREATE TABLE report_generation(
	recordId int(11) not null primary key AUTO_INCREMENT unique,
	username varchar(50) not null,
	generated_report varchar(45) not null,
	timestamp datetime not null
	
	constraint username
	foreign key username
	references `users`.`user_information`(username)
)