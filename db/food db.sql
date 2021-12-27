/*
SQLyog - Free MySQL GUI v5.13
Host - 5.0.22-community-nt : Database - onlinefoodorder
*********************************************************************
Server version : 5.0.22-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `onlinefoodorder`;

USE `onlinefoodorder`;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `admintable` */

DROP TABLE IF EXISTS `admintable`;

CREATE TABLE `admintable` (
  `username` varchar(50) default NULL,
  `password` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admintable` */

insert into `admintable` (`username`,`password`) values ('admin','admin');

/*Table structure for table `costdetails` */

DROP TABLE IF EXISTS `costdetails`;

CREATE TABLE `costdetails` (
  `userid` varchar(50) default NULL,
  `productname` varchar(50) default NULL,
  `count1` varchar(50) default NULL,
  `totamount` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `costdetails` */

insert into `costdetails` (`userid`,`productname`,`count1`,`totamount`) values ('kowsi','pizza-1','2','400');
insert into `costdetails` (`userid`,`productname`,`count1`,`totamount`) values ('kowsi','pizza-1','2','400');

/*Table structure for table `deliverdetails` */

DROP TABLE IF EXISTS `deliverdetails`;

CREATE TABLE `deliverdetails` (
  `userid` varchar(50) default NULL,
  `delivername` varchar(50) default NULL,
  `mobile` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `deliverdetails` */

insert into `deliverdetails` (`userid`,`delivername`,`mobile`) values ('kowsi','vicky','7502483537');
insert into `deliverdetails` (`userid`,`delivername`,`mobile`) values ('kowsi','vicky','7502483537');

/*Table structure for table `fooddetails` */

DROP TABLE IF EXISTS `fooddetails`;

CREATE TABLE `fooddetails` (
  `fileid` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `price` varchar(50) default NULL,
  `filename` varchar(200) default NULL,
  PRIMARY KEY  (`fileid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `fooddetails` */

insert into `fooddetails` (`fileid`,`name`,`price`,`filename`) values (1,'Pizza','100','veg.jpg');
insert into `fooddetails` (`fileid`,`name`,`price`,`filename`) values (2,'Pizza nonveg','120','maxresdefault.jpg');

/*Table structure for table `userdetails` */

DROP TABLE IF EXISTS `userdetails`;

CREATE TABLE `userdetails` (
  `name` varchar(50) default NULL,
  `username` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `emailid` varchar(50) default NULL,
  `phonenum` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `city` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userdetails` */

insert into `userdetails` (`name`,`username`,`password`,`emailid`,`phonenum`,`address`,`city`) values ('Selva','selva','java','dselvait@gmail.com','null','Nehru street Ramnagar','Coimbatore');

/*Table structure for table `userorders` */

DROP TABLE IF EXISTS `userorders`;

CREATE TABLE `userorders` (
  `username` varchar(50) default NULL,
  `mobile` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `mailid` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userorders` */

insert into `userorders` (`username`,`mobile`,`address`,`mailid`) values ('selva','9750999918','cbe','dselvait@gmail.com');
insert into `userorders` (`username`,`mobile`,`address`,`mailid`) values ('kowsi','9025123475','cbe','kowsi12@gmail.com');
insert into `userorders` (`username`,`mobile`,`address`,`mailid`) values ('kowsi','9000357019','cbe','dselvait@gmail.com');

SET SQL_MODE=@OLD_SQL_MODE;