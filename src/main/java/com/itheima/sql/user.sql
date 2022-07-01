/*
 Navicat Premium Data Transfer

 Source Server         : windows
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 01/07/2022 21:17:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int(255) NULL DEFAULT NULL,
  `deleted` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1542785490560405505, '小明', 25, '1234@163.com', '2022-07-01 16:21:39', '2022-07-01 16:22:57', NULL, NULL);
INSERT INTO `user` VALUES (1542786717130076162, '小明', 25, '1234@163.com', '2022-07-01 16:26:32', '2022-07-01 16:26:32', NULL, NULL);
INSERT INTO `user` VALUES (1542797716088336386, '小房', 25, '1234@163.com', '2022-07-01 17:10:14', '2022-07-01 17:11:59', 2, NULL);
INSERT INTO `user` VALUES (1542855785321254913, '小', 25, '1234@163.com', '2022-07-01 21:00:59', '2022-07-01 21:00:59', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
