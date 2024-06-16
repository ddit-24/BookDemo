# BookDemo
javaweb项目 eclipse +jsp +servlet开发


本项目为一个简易的图书管理系统，具有简单的增删改查功能，验证码，批量删除，按作者或书名模糊查询图书等基本作业要求。

还实现了简单的强制登录功能，不能访问未登录的页面，用户登陆成功后还可以退出账号重新登陆。

登录账号：admin 密码 123 其他账号可数据库看，可自行注册

数据库 名为user 账号为root 密码为123456

封装JDBC配置文件和工具类方便使用，拿到项目需要更改配置文件

下面是用navicat导出的sql文件的内容，可以复制粘贴运行，记得先创建一个user数据库，然后执行语句。

/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 16/06/2024 09:10:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bookid` int(0) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `price` double NOT NULL,
  `authors` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `categoryid` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`bookid`) USING BTREE,
  INDEX `categoryid`(`categoryid`) USING BTREE,
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (2, '理想国(中文)', 33, '柏拉图', 5);
INSERT INTO `book` VALUES (3, '四库全书', 55, '佚名', 3);
INSERT INTO `book` VALUES (31, '呼兰河传', 25, '萧红', 1);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `categoryid` int(0) NOT NULL,
  `categoryname` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`categoryid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '小说');
INSERT INTO `category` VALUES (2, '散文');
INSERT INTO `category` VALUES (3, '历史');
INSERT INTO `category` VALUES (4, '传记');
INSERT INTO `category` VALUES (5, '哲学');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123');
INSERT INTO `user` VALUES (2, 'jiu1', '123');
INSERT INTO `user` VALUES (5, 'jiu2', '123');
INSERT INTO `user` VALUES (6, 'one1', '123');

SET FOREIGN_KEY_CHECKS = 1;




