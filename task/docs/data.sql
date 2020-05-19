/*
 Navicat Premium Data Transfer

 Source Server         : 111.229.16.57
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 111.229.16.57:3306
 Source Schema         : task

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 19/05/2020 21:42:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shadowsky_account
-- ----------------------------
DROP TABLE IF EXISTS `shadowsky_account`;
CREATE TABLE `shadowsky_account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shadowsky_signin_log
-- ----------------------------
DROP TABLE IF EXISTS `shadowsky_signin_log`;
CREATE TABLE `shadowsky_signin_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `result` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
