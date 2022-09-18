show databases;
CREATE DATABASE maintenance;
USE maintenance;

CREATE TABLE user_data (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
team varchar (15) NOT NULL,
_name varchar (15) NOT NULL,
last_name varchar (15) NOT NULL,
user_name varchar (15) NOT NULL UNIQUE,
pass_word varchar (15) NOT NULL,
team_admin boolean NOT NULL
);

CREATE TABLE team_data (  
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
team varchar (20) NOT NULL UNIQUE,
user_admin varchar (15) NOT NULL
);

CREATE TABLE admin_order (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
team varchar (20) NOT NULL,
_date date,
work_order_number varchar (15) NOT NULL UNIQUE,
estimated_time int (2) NOT NULL,
responsible varchar (31) NOT NULL,
activity varchar (50) NOT NULL,
suggestions varchar (200) DEFAULT NULL
);

CREATE TABLE user_order (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
team varchar (20) NOT NULL,
real_time int (2) DEFAULT NULL,
activity_finished boolean DEFAULT NULL,
notes varchar (200) DEFAULT NULL
);

drop database maintenance;
drop table user_data;
drop table team_data;
drop table admin_order;
drop table user_order;

insert into app_dates (team,_date,work_order_number, estimated_time, responsible, activity, suggestions, real_time, activity_finished, notes)
values ("grupo5", STR_TO_DATE('1-01-2012', '%d-%m-%Y') , 3, 31.33, "pablo", "trabajo", "NA", 4, True, "NA" );