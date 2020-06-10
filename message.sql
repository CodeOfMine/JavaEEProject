/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : javaee

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-06-10 15:19:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(50) NOT NULL,
  `content` varchar(255) NOT NULL,
  `time` varchar(50) NOT NULL,
  `userId` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`messageId`),
  KEY `FK_ID` (`userId`),
  CONSTRAINT `FK_ID` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
