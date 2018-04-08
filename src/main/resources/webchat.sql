##########Webchat###start############
drop database if exists webchat;
create database webchat;
use webchat;
drop table if exists `user`;
create table `user`(
	`id` int(11) auto_increment not null,
	`loginName` varchar(255) not null,
	`nickName` varchar(255) not null,
	`password` varchar(255) not null,
	`createTime` datetime not null,
	`lastModifyTime` datetime not null,
	`headImg` varchar(100) not null,
	primary key(`id`)
)ENGINE=INNODB,CHARSET=utf8;
##########Webchat###end############