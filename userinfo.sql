/*
Navicat MySQL Data Transfer

Source Server         : qwer
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : userinfo

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-06-28 18:23:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `loginAccount` varchar(20) NOT NULL,
  `loginPassword` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`loginAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('', '');
INSERT INTO `userinfo` VALUES ('1', '1');
INSERT INTO `userinfo` VALUES ('3', '3');
INSERT INTO `userinfo` VALUES ('a', 'a');
INSERT INTO `userinfo` VALUES ('qs', '123');
INSERT INTO `userinfo` VALUES ('z', '123');
INSERT INTO `userinfo` VALUES ('zhangsan', '123');
