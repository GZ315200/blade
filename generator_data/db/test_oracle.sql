/*
 Navicat Premium Data Transfer

 Source Server         : oracle
 Source Server Type    : Oracle
 Source Server Version : 112010
 Source Host           : 192.168.1.192
 Source Schema         : UNISTACK

 Target Server Type    : Oracle
 Target Server Version : 112010
 File Encoding         : utf-8

 Date: 03/20/2018 11:38:41 AM
*/

-- ----------------------------
--  Table structure for test
-- ----------------------------
DROP TABLE "UNISTACK"."test";
CREATE TABLE "test" (   "id" NUMBER NOT NULL, "source" NUMBER, "sink" NUMBER, "createtime" DATE);

-- ----------------------------
--  Primary key structure for table test
-- ----------------------------
ALTER TABLE "UNISTACK"."test" ADD CONSTRAINT "SYS_C0020595" PRIMARY KEY("id");

-- ----------------------------
--  Checks structure for table test
-- ----------------------------
ALTER TABLE "UNISTACK"."test" ADD CONSTRAINT "SYS_C0020594" CHECK ("id" IS NOT NULL) ENABLE;

