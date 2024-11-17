/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80040 (8.0.40)
 Source Host           : localhost:3306
 Source Schema         : office_test

 Target Server Type    : MySQL
 Target Server Version : 80040 (8.0.40)
 File Encoding         : 65001

 Date: 16/11/2024 20:29:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goback
-- ----------------------------
DROP TABLE IF EXISTS `goback`;
CREATE TABLE `goback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `blank` bit(1) DEFAULT NULL,
  `text` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_oy92ak6u4rmbq75jgb14npht7` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `chat` bit(1) DEFAULT NULL,
  `comment` bit(1) DEFAULT NULL,
  `copy` bit(1) DEFAULT NULL,
  `download` bit(1) DEFAULT NULL,
  `edit` bit(1) DEFAULT NULL,
  `fill_forms` bit(1) DEFAULT NULL,
  `modify_content_control` bit(1) DEFAULT NULL,
  `modify_filter` bit(1) DEFAULT NULL,
  `print` bit(1) DEFAULT NULL,
  `protect` bit(1) DEFAULT NULL,
  `review` bit(1) DEFAULT NULL,
  `submit_form` bit(1) DEFAULT NULL,
  `templates` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for permission_comments_edit_groups
-- ----------------------------
DROP TABLE IF EXISTS `permission_comments_edit_groups`;
CREATE TABLE `permission_comments_edit_groups` (
  `permission_id` int NOT NULL,
  `comments_edit_groups_id` int NOT NULL,
  KEY `FKlbhe7ny9mjn07p1xwkrd3h1yb` (`comments_edit_groups_id`),
  KEY `FKpksf6jjokwgmvwggd099kjr09` (`permission_id`),
  CONSTRAINT `FKlbhe7ny9mjn07p1xwkrd3h1yb` FOREIGN KEY (`comments_edit_groups_id`) REFERENCES `group` (`id`),
  CONSTRAINT `FKpksf6jjokwgmvwggd099kjr09` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for permission_comments_remove_groups
-- ----------------------------
DROP TABLE IF EXISTS `permission_comments_remove_groups`;
CREATE TABLE `permission_comments_remove_groups` (
  `permission_id` int NOT NULL,
  `comments_remove_groups_id` int NOT NULL,
  KEY `FKsen41hxdfv5t4b0ytpfi82a4r` (`comments_remove_groups_id`),
  KEY `FKqog1bgrs7us5dt5uhtydguyfa` (`permission_id`),
  CONSTRAINT `FKqog1bgrs7us5dt5uhtydguyfa` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
  CONSTRAINT `FKsen41hxdfv5t4b0ytpfi82a4r` FOREIGN KEY (`comments_remove_groups_id`) REFERENCES `group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for permission_comments_view_groups
-- ----------------------------
DROP TABLE IF EXISTS `permission_comments_view_groups`;
CREATE TABLE `permission_comments_view_groups` (
  `permission_id` int NOT NULL,
  `comments_view_groups_id` int NOT NULL,
  KEY `FKmor7cdm88o8mfewg6o9n04t8j` (`comments_view_groups_id`),
  KEY `FKmuk0dc9rcpt18cor01x67n782` (`permission_id`),
  CONSTRAINT `FKmor7cdm88o8mfewg6o9n04t8j` FOREIGN KEY (`comments_view_groups_id`) REFERENCES `group` (`id`),
  CONSTRAINT `FKmuk0dc9rcpt18cor01x67n782` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for permission_review_groups
-- ----------------------------
DROP TABLE IF EXISTS `permission_review_groups`;
CREATE TABLE `permission_review_groups` (
  `permission_id` int NOT NULL,
  `review_groups_id` int NOT NULL,
  KEY `FKl4mho2n64lq9a2h1b4au2x3fv` (`review_groups_id`),
  KEY `FK6ms0sjhw8wj09vpy7foja9ve6` (`permission_id`),
  CONSTRAINT `FK6ms0sjhw8wj09vpy7foja9ve6` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
  CONSTRAINT `FKl4mho2n64lq9a2h1b4au2x3fv` FOREIGN KEY (`review_groups_id`) REFERENCES `group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for permission_user_info_groups
-- ----------------------------
DROP TABLE IF EXISTS `permission_user_info_groups`;
CREATE TABLE `permission_user_info_groups` (
  `permission_id` int NOT NULL,
  `user_info_groups_id` int NOT NULL,
  KEY `FK578hwrnr3grtgbp6mi9e54y70` (`user_info_groups_id`),
  KEY `FKp1j6m4btimni50pexjmega83h` (`permission_id`),
  CONSTRAINT `FK578hwrnr3grtgbp6mi9e54y70` FOREIGN KEY (`user_info_groups_id`) REFERENCES `group` (`id`),
  CONSTRAINT `FKp1j6m4btimni50pexjmega83h` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar` bit(1) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `favorite` bit(1) DEFAULT NULL,
  `goback_id` int DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  `permissions_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgnrmauc9wy352fxvo3me9i618` (`group_id`),
  KEY `FKlcebiiafmhbni5wno43kx8yl` (`permissions_id`),
  CONSTRAINT `FKgnrmauc9wy352fxvo3me9i618` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`),
  CONSTRAINT `FKlcebiiafmhbni5wno43kx8yl` FOREIGN KEY (`permissions_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for user_descriptions
-- ----------------------------
DROP TABLE IF EXISTS `user_descriptions`;
CREATE TABLE `user_descriptions` (
  `user_id` int NOT NULL,
  `descriptions` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  KEY `FK3d34lkqdlp4mjftsjrfnxwxsf` (`user_id`),
  CONSTRAINT `FK3d34lkqdlp4mjftsjrfnxwxsf` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

SET FOREIGN_KEY_CHECKS = 1;
