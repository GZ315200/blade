/*
 Navicat Premium Data Transfer

 Source Server         : pg
 Source Server Type    : PostgreSQL
 Source Server Version : 90606
 Source Host           : 192.168.1.191
 Source Database       : test
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90606
 File Encoding         : utf-8

 Date: 03/12/2018 21:05:22 PM
*/

-- ----------------------------
--  Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS "public"."test";
CREATE TABLE "public"."test" (
	"id" int4,
	"sink" varchar COLLATE "default",
	"source" varchar COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."test" OWNER TO "postgres";

