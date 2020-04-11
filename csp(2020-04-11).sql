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

 Date: 11/04/2020 19:25:45
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
  `bcID` int(11) NOT NULL COMMENT '购物车商品ID',
  `uID` int(11) NOT NULL COMMENT '用户ID',
  `gID` int(11) NOT NULL COMMENT '商品ID',
  `gName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名字',
  `gCount` int(11) NOT NULL COMMENT '加入购物车的商品数量',
  `gPrice` int(11) NULL DEFAULT NULL COMMENT '商品单价',
  PRIMARY KEY (`bcID`) USING BTREE,
  INDEX `Uphone`(`uID`) USING BTREE
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
INSERT INTO `goods` VALUES (1, '一', 1, NULL, 5, 'home', 12, NULL, NULL);
INSERT INTO `goods` VALUES (2, '二', 1, NULL, 11, 'travel', 12, NULL, NULL);
INSERT INTO `goods` VALUES (3, '三', 1, NULL, 11, 'electronic', 12, NULL, NULL);
INSERT INTO `goods` VALUES (4, '四', 2, NULL, 12, 'literature', 12, NULL, NULL);
INSERT INTO `goods` VALUES (5, '五', 2, NULL, 12, 'other', 12, NULL, NULL);
INSERT INTO `goods` VALUES (6, '六', 2, NULL, 12, 'literature', 12, NULL, NULL);
INSERT INTO `goods` VALUES (7, '七', 2, NULL, 12, 'food', 12, NULL, NULL);
INSERT INTO `goods` VALUES (8, '八', 2, NULL, 12, 'food', 12, NULL, NULL);
INSERT INTO `goods` VALUES (9, '九', 2, NULL, 12, 'home', 12, NULL, NULL);
INSERT INTO `goods` VALUES (10, '十', 2, NULL, 12, 'food', 12, NULL, NULL);
INSERT INTO `goods` VALUES (11, '十一', 2, NULL, 12, 'travel', 12, NULL, NULL);
INSERT INTO `goods` VALUES (12, '十二', 2, NULL, 12, 'electronic', 12, NULL, NULL);
INSERT INTO `goods` VALUES (13, '十三', 2, NULL, 12, 'literature', 12, NULL, NULL);
INSERT INTO `goods` VALUES (14, '十四', 2, NULL, 12, 'food', 12, NULL, NULL);
INSERT INTO `goods` VALUES (15, '十五', 2, NULL, 12, 'electronic', 12, NULL, NULL);
INSERT INTO `goods` VALUES (16, '十六', 2, NULL, 12, 'home', 12, NULL, NULL);
INSERT INTO `goods` VALUES (17, '十七', 2, NULL, 12, 'literature', 12, NULL, NULL);
INSERT INTO `goods` VALUES (18, '十八', 2, NULL, 12, 'food', 12, NULL, NULL);
INSERT INTO `goods` VALUES (19, '十九', 2, NULL, 12, 'electronic', 12, NULL, NULL);
INSERT INTO `goods` VALUES (20, '二十', 2, NULL, 12, 'travel', 12, NULL, NULL);
INSERT INTO `goods` VALUES (21, '二十一', 2, NULL, 12, 'home', 12, NULL, NULL);
INSERT INTO `goods` VALUES (22, '二十二', 2, NULL, 12, 'other', 12, NULL, NULL);
INSERT INTO `goods` VALUES (23, '二十三', 2, NULL, 12, 'other', 12, NULL, NULL);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `rID` int(11) NOT NULL AUTO_INCREMENT,
  `uID` int(11) NOT NULL,
  `rMessage` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `rDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rID`) USING BTREE,
  INDEX `userID`(`uID`) USING BTREE,
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`uID`) REFERENCES `user` (`Uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for soldgoods
-- ----------------------------
DROP TABLE IF EXISTS `soldgoods`;
CREATE TABLE `soldgoods`  (
  `sgID` int(11) NOT NULL AUTO_INCREMENT,
  `gID` int(11) NOT NULL COMMENT '商品ID',
  `suID` int(11) NOT NULL COMMENT '卖家用户ID',
  `buID` int(11) NOT NULL COMMENT '买家用户ID',
  `gName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '商品名字',
  `sgCount` int(11) NULL DEFAULT NULL COMMENT '卖出商品数量',
  `gPrice` int(10) NULL DEFAULT NULL COMMENT '商品单价',
  `sgDate` varchar(0) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '出售日期',
  `sgPinglun` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '评论',
  PRIMARY KEY (`sgID`) USING BTREE,
  INDEX `GoodsID`(`gID`) USING BTREE
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
