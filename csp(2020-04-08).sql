/*
 Navicat MySQL Data Transfer

 Source Server         : ZCL
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : csp

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 08/04/2020 20:52:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `AdminID` int(20) NOT NULL AUTO_INCREMENT,
  `AdmPassword` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `AdmName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`AdminID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '123', 'admin1');

-- ----------------------------
-- Table structure for buycar
-- ----------------------------
DROP TABLE IF EXISTS `buycar`;
CREATE TABLE `buycar`  (
  `Uphone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `GoodsID` int(11) NOT NULL,
  `GoodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `GoodsNum` int(11) NOT NULL,
  `GoodsPrice` int(11) NOT NULL,
  PRIMARY KEY (`GoodsID`, `Uphone`) USING BTREE,
  INDEX `Uphone`(`Uphone`) USING BTREE,
  CONSTRAINT `buycar_ibfk_1` FOREIGN KEY (`GoodsID`) REFERENCES `goods` (`GoodsID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `buycar_ibfk_2` FOREIGN KEY (`Uphone`) REFERENCES `user` (`Uphone`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `GoodsID` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `GoodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `Uphone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `Price` int(50) NOT NULL COMMENT '商品价格',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '出售规格',
  `Sort` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类',
  `Count` int(50) NOT NULL COMMENT '数量',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片',
  `details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '注释',
  PRIMARY KEY (`GoodsID`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  INDEX `Uphone`(`Uphone`) USING BTREE,
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`Uphone`) REFERENCES `user` (`Uphone`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `recordID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`recordID`) USING BTREE,
  INDEX `userID`(`userID`) USING BTREE,
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`Uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sellgoods
-- ----------------------------
DROP TABLE IF EXISTS `sellgoods`;
CREATE TABLE `sellgoods`  (
  `sellID` int(11) NOT NULL AUTO_INCREMENT,
  `UserPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GoodsID` int(11) NOT NULL,
  `GoodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GoodsNum` int(11) NOT NULL,
  `Aprice` int(10) NOT NULL COMMENT '单价',
  `PostDate` datetime(0) NOT NULL,
  `pinglun` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sellID`) USING BTREE,
  INDEX `GoodsID`(`GoodsID`) USING BTREE,
  CONSTRAINT `sellgoods_ibfk_1` FOREIGN KEY (`GoodsID`) REFERENCES `goods` (`GoodsID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Uid` int(11) NOT NULL AUTO_INCREMENT,
  `Uname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Upassword` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Uphone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Uschool` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Usex` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Uhead` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `Udizhi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Uxinyu` int(11) NULL DEFAULT NULL,
  `Umoney` float(20, 0) NULL DEFAULT 10000,
  `Uquestion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Uanswer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Uemail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Ujieshao` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Uid`) USING BTREE,
  INDEX `Uname`(`Uname`) USING BTREE,
  INDEX `Uphone`(`Uphone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '123', '111', '1', NULL, NULL, NULL, NULL, 10000, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, '1999', '99', '99', NULL, NULL, NULL, NULL, NULL, 10000, NULL, NULL, '99', NULL);

SET FOREIGN_KEY_CHECKS = 1;
