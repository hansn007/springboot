/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost
 Source Database       : school

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : utf-8

 Date: 06/07/2018 11:38:54 AM
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `courses`
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `cno` varchar(50) NOT NULL,
  `cname` varchar(100) NOT NULL,
  `tno` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `courses`
-- ----------------------------
BEGIN;
INSERT INTO `courses` VALUES ('3-105', '计算机导论', '825'), ('3-245', '操作系统', '804'), ('6-166', '数据电路', '856'), ('9-888', '高等数学', '100');
COMMIT;

-- ----------------------------
--  Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `low` float(11,0) DEFAULT NULL,
  `upp` float(11,0) DEFAULT NULL,
  `rank` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `grade`
-- ----------------------------
BEGIN;
INSERT INTO `grade` VALUES ('90', null, null), ('80', null, null), ('70', null, null), ('60', null, null), ('0', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `scores`
-- ----------------------------
DROP TABLE IF EXISTS `scores`;
CREATE TABLE `scores` (
  `sno` varchar(30) NOT NULL,
  `cno` varchar(50) NOT NULL,
  `degree` float(10,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `scores`
-- ----------------------------
BEGIN;
INSERT INTO `scores` VALUES ('103', '3-245', '86.0'), ('105', '3-245', '75.0'), ('109', '3-245', '68.0'), ('103', '3-105', '92.0'), ('105', '3-105', '88.0'), ('109', '3-105', '76.0'), ('101', '3-105', '64.0'), ('107', '3-105', '91.0'), ('108', '3-105', '78.0'), ('101', '6-166', '85.0'), ('107', '6-106', '79.0'), ('108', '6-166', '81.0');
COMMIT;

-- ----------------------------
--  Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `sno` varchar(3) NOT NULL,
  `sname` varchar(40) NOT NULL,
  `ssex` varchar(20) NOT NULL,
  `sbirthday` datetime DEFAULT NULL,
  `classes` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `students`
-- ----------------------------
BEGIN;
INSERT INTO `students` VALUES ('108', '曾华', '男', '1977-09-01 00:00:00', '95033'), ('105', '匡明', '男', '1975-10-02 00:00:00', '95031'), ('107', '王丽', '女', '1976-01-23 00:00:00', '95033'), ('101', '李军', '男', '1976-02-20 00:00:00', '95033'), ('109', '王芳', '女', '1975-02-10 00:00:00', '95031'), ('103', '陆君', '男', '1974-06-03 00:00:00', '95031');
COMMIT;

-- ----------------------------
--  Table structure for `teachers`
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `tno` varchar(3) NOT NULL,
  `tname` varchar(40) NOT NULL,
  `tsex` varchar(20) NOT NULL,
  `tbirthday` datetime NOT NULL,
  `prof` varchar(60) DEFAULT NULL,
  `depart` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `teachers`
-- ----------------------------
BEGIN;
INSERT INTO `teachers` VALUES ('804', '李诚', '男', '1958-12-02 00:00:00', '副教授', '计算机系'), ('856', '张旭', '男', '1969-03-12 00:00:00', '讲师', '电子工程系'), ('825', '王萍', '女', '1972-05-05 00:00:00', '助教', '计算机系'), ('831', '刘冰', '女', '1977-08-14 00:00:00', '助教', '电子工程系');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
