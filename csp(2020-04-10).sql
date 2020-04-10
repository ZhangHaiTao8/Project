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

 Date: 10/04/2020 19:51:57
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
  CONSTRAINT `buycar_ibfk_1` FOREIGN KEY (`GoodsID`) REFERENCES `goods` (`gID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `buycar_ibfk_2` FOREIGN KEY (`Uphone`) REFERENCES `user` (`Uphone`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `gID` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `gName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `uID` int(11) NOT NULL COMMENT '用户ID',
  `uName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `gPrice` int(50) NOT NULL COMMENT '商品价格',
  `gType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类',
  `gCount` int(50) NOT NULL COMMENT '数量',
  `gPicture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `gDetails` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '注释',
  PRIMARY KEY (`gID`) USING BTREE,
  INDEX `UserName`(`uName`) USING BTREE,
  INDEX `UserID`(`uID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '123', 1, NULL, 5, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (2, '123', 1, NULL, 11, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (3, '123', 1, NULL, 11, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (4, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (5, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (6, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (7, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (8, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (9, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (10, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (11, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (12, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (13, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (14, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (15, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (16, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (17, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (18, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (19, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (20, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (21, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (22, '123', 2, NULL, 12, '食品', 12, NULL, NULL);
INSERT INTO `goods` VALUES (23, '123', 2, NULL, 12, '食品', 12, NULL, NULL);

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
-- Table structure for soldgoods
-- ----------------------------
DROP TABLE IF EXISTS `soldgoods`;
CREATE TABLE `soldgoods`  (
  `SoldGoodsID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GoodsID` int(11) NOT NULL,
  `GoodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `GoodsCount` int(11) NOT NULL,
  `GoodsPrice` int(10) NOT NULL COMMENT '单价',
  `SoldDate` datetime(0) NULL DEFAULT NULL,
  `pinglun` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SoldGoodsID`) USING BTREE,
  INDEX `GoodsID`(`GoodsID`) USING BTREE
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
