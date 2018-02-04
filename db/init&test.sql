/*
 Navicat Premium Data Transfer

 Source Server         : my
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : my

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 04/02/2018 21:15:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_article
-- ----------------------------
DROP TABLE IF EXISTS `article_article`;
CREATE TABLE `article_article`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKmd66ia851cf819we898q4dqxp`(`author_id`) USING BTREE,
  INDEX `FKgamg6jq0jbdyymg1qg6c1114b`(`category_id`) USING BTREE,
  CONSTRAINT `FKgamg6jq0jbdyymg1qg6c1114b` FOREIGN KEY (`category_id`) REFERENCES `article_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKmd66ia851cf819we898q4dqxp` FOREIGN KEY (`author_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_article
-- ----------------------------
INSERT INTO `article_article` VALUES (4, '<p style=\"text-align: left; margin-top: 28px; margin-bottom: 0px; font-size: 16px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 28px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64);\"><span style=\"text-align: justify; text-indent: 2em;\">我们必须承认，</span><a href=\"http://sports.163.com/keywords/6/8/6885897f/1.html\" title=\"梅西\" target=\"_blank\" style=\"text-align: justify; text-indent: 2em; background-color: rgb(255, 255, 255); color: rgb(15, 107, 153);\">梅西</a><span style=\"text-align: justify; text-indent: 2em;\">在</span><a href=\"http://sports.163.com/keywords/8/7/897f7532/1.html\" title=\"西甲\" target=\"_blank\" style=\"text-align: justify; text-indent: 2em; background-color: rgb(255, 255, 255); color: rgb(15, 107, 153);\">西甲</a><span style=\"text-align: justify; text-indent: 2em;\">生涯诺坎普200战中的表现不够出色。在阵地战中，梅西失去了射门精度，盲目盘带失误还直接导致</span><a href=\"http://sports.163.com/keywords/5/f/5df48428/1.html\" title=\"巴萨\" target=\"_blank\" style=\"text-align: justify; text-indent: 2em; background-color: rgb(255, 255, 255); color: rgb(15, 107, 153);\">巴萨</a><span style=\"text-align: justify; text-indent: 2em;\">丢球。不过最终帮助巴萨逆转的，仍然是梅西。这一次，梅西利用任意球打进制胜球。</span><br></p><p class=\"f_center\" style=\"margin-top: 28px; margin-bottom: 0px; font-size: 16px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 28px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center;\"><img alt=\"梅西超C罗成西甲任意球之王 圆月弯刀也是常规操作\" src=\"http://cms-bucket.nosdn.127.net/9611c743cd984531ae1065050c153ade20180129061709.jpeg?imageView&amp;thumbnail=550x0\" style=\"vertical-align: top; border: 0px; margin-right: auto; margin-left: auto; display: block;\"><br></p><p style=\"margin-top: 28px; margin-bottom: 0px; font-size: 16px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 28px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify;\">在上半场终盘阶段，梅西曾经踢过一次高质量的任意球。在右侧禁区前，梅西左脚任意球射门。<a href=\"http://sports.163.com/keywords/7/a/76ae7403/1.html\" title=\"皮球\" target=\"_blank\" style=\"color: rgb(15, 107, 153);\">皮球</a>在绕过人墙后快速下坠，并且带有强烈的侧旋。客队门将<a href=\"http://sports.163.com/keywords/5/1/5e15520779d1/1.html\" title=\"帕切科\" target=\"_blank\" style=\"color: rgb(15, 107, 153);\">帕切科</a>全力飞身扑救，他用指尖触碰到了皮球，皮球最终在击中右侧门柱后弹出底线。在21轮西甲联赛中，这是梅西第13次射中门框。</p><p style=\"margin-top: 28px; margin-bottom: 0px; font-size: 16px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 28px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify;\">在这次任意球攻防中，梅西输给了帕切科。不服输的梅西，在下半场终盘阶段又来了个几乎相同的任意球射门。几乎相同的射门位置，几乎相同的射门脚法，几乎相同的射门角度。这一次，帕切科仍然用指尖触碰到了皮球，但没有门柱来帮忙了。帕切科虽然碰到了球，但皮球仍然飞入了网窝之中。</p><p class=\"f_center\" style=\"margin-top: 28px; margin-bottom: 0px; font-size: 16px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 28px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center;\"><img alt=\"梅西超C罗成西甲任意球之王 圆月弯刀也是常规操作\" src=\"http://cms-bucket.nosdn.127.net/e0b017ca744345f6800584e2bd1262e820180129061731.gif\" style=\"vertical-align: top; border: 0px; margin-right: auto; margin-left: auto; display: block;\"><br></p><p style=\"margin-top: 28px; margin-bottom: 0px; font-size: 16px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 28px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify;\"></p><p style=\"margin-top: 28px; margin-bottom: 0px; font-size: 16px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 28px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify;\">这个进球，是梅西半个月来打进的第二个精彩任意球。在1月中旬，巴萨客场4比2逆转<a href=\"http://goal.sports.163.com/23/team/188.html\" style=\"color: rgb(15, 107, 153);\">皇家社会</a>，梅西就曾打进了一个极为漂亮的落叶球。梅西主罚的任意球直挂球门左上死角，阿根廷国门鲁利完全没有做出扑救动作来。今夜，梅西又靠这个任意球帮助巴萨逆转获胜。</p><p style=\"margin-top: 28px; margin-bottom: 0px; font-size: 16px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 28px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify;\"><b>在梅西的西甲生涯中，这是他踢进的第21个任意球，他是西甲最近25年中的任意球之王。</b>C罗在西甲打进了20个任意球，梅西又在这项他原本大幅度落后的数据上逆转了葡萄牙人。比进球、比助攻、比突破、比输送威胁球，C罗原本就不是梅西的对手，如今他又在任意球上被梅西超越。C罗领先梅西的，也许也仅有点球了。在对阵瓦伦点球双响炮之后，C罗以72次主罚点球成为西甲历史12码之王。</p>', '2018-01-30 13:48:31', '梅西超C罗成西甲任意球之王 圆月弯刀也是常规操作', 1, 3, '2018-02-04 17:59:55');
INSERT INTO `article_article` VALUES (5, '<font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">import&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">lombok.EqualsAndHashCode;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"></font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#646464\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">@EqualsAndHashCode</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">(</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">exclude=</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">{</font><font color=\"#2a00ff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">\"id\"</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">,&nbsp;</font><font color=\"#2a00ff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">\"shape\"</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">})</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">public&nbsp;class&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">EqualsAndHashCodeExample&nbsp;</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">{</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">private&nbsp;transient&nbsp;</b></font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">int&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">transientVar&nbsp;=&nbsp;</font><font color=\"#990000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">10</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">private&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">String&nbsp;name;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">private&nbsp;</b></font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">double&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">score;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">private&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">Shape&nbsp;shape&nbsp;=&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">new&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">Square</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">(</font><font color=\"#990000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">5</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">,&nbsp;</font><font color=\"#990000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">10</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">)</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">private&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">String</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">[]&nbsp;</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">tags;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">private&nbsp;</b></font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">int&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">id;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">public&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">String&nbsp;getName</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">()&nbsp;{</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">return&nbsp;this</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">.name;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">}</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#646464\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">@EqualsAndHashCode</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">(</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">callSuper=</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">true</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">)</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">public&nbsp;static&nbsp;class&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">Square&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">extends&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">Shape&nbsp;</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">{</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">private&nbsp;final&nbsp;</b></font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">int&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">width,&nbsp;height;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;&nbsp;&nbsp;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">public&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">Square</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">(</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">int&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">width,&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">int&nbsp;</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">height</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">)&nbsp;{</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">this</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">.width&nbsp;=&nbsp;width;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color=\"#7f0055\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\"><b style=\"font-weight: bold;\">this</b></font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">.height&nbsp;=&nbsp;height;</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">}</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#ffffff\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">&nbsp;&nbsp;</font><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">}</font><br style=\"color: rgb(199, 37, 78); font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; white-space: nowrap; background-color: rgb(252, 252, 252);\"><font color=\"#000000\" style=\"white-space: pre; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; background-color: rgb(252, 252, 252);\">}</font>', '2018-02-04 18:01:26', 'With Lombok EqualsAndHashCode', 1, 3, '2018-02-04 19:57:17');

-- ----------------------------
-- Table structure for article_category
-- ----------------------------
DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sort` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_hwokd4h9xg8tl23yb004m6tey`(`name`) USING BTREE,
  INDEX `FK6mogxrytxjptt5e35785ne1n`(`parent_id`) USING BTREE,
  CONSTRAINT `FK6mogxrytxjptt5e35785ne1n` FOREIGN KEY (`parent_id`) REFERENCES `article_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_category
-- ----------------------------
INSERT INTO `article_category` VALUES (3, '2018-01-29 12:43:00', '测试分类00', 0, NULL, '2018-02-04 17:57:35');
INSERT INTO `article_category` VALUES (10, '2018-02-04 21:09:49', 'saadsf', 0, 3, '2018-02-04 21:09:49');
INSERT INTO `article_category` VALUES (11, '2018-02-04 21:09:58', 'wefwf', 0, NULL, '2018-02-04 21:09:58');

-- ----------------------------
-- Table structure for logging_event
-- ----------------------------
DROP TABLE IF EXISTS `logging_event`;
CREATE TABLE `logging_event`  (
  `timestmp` bigint(20) NOT NULL,
  `formatted_message` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `logger_name` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `level_string` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `thread_name` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `reference_flag` smallint(6) DEFAULT NULL,
  `arg0` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `arg1` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `arg2` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `arg3` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `caller_filename` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `caller_class` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `caller_method` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `caller_line` char(4) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`event_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3763 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logging_event
-- ----------------------------
INSERT INTO `logging_event` VALUES (1517749661103, '删除所有日志', 'site.fish119.adminss.controller.log.LoggingController', 'INFO', 'http-nio-9999-exec-1', 0, '1', 'Sun Feb 04 21:07:41 CST 2018', NULL, NULL, 'LoggingController.java', 'site.fish119.adminss.controller.log.LoggingController', 'deleteAllLogs', '59', 3700);
INSERT INTO `logging_event` VALUES (1517749662149, '200::OK', 'site.fish119.adminss.controller.log.LoggingController', 'INFO', 'http-nio-9999-exec-1', 0, '1', 'DELETE::http://127.0.0.1:9999/logs', '1178', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3701);
INSERT INTO `logging_event` VALUES (1517749669342, '200::OK', 'site.fish119.adminss.controller.setting.UserController', 'INFO', 'http-nio-9999-exec-9', 0, '1', 'GET::http://127.0.0.1:9999/setting/users', '11', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3702);
INSERT INTO `logging_event` VALUES (1517749669343, '200::OK', 'site.fish119.adminss.controller.setting.DepartController', 'INFO', 'http-nio-9999-exec-4', 0, '1', 'GET::http://127.0.0.1:9999/setting/departments', '3', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3703);
INSERT INTO `logging_event` VALUES (1517749669363, '200::OK', 'site.fish119.adminss.controller.setting.RoleController', 'INFO', 'http-nio-9999-exec-6', 0, '1', 'GET::http://127.0.0.1:9999/setting/roles', '31', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3704);
INSERT INTO `logging_event` VALUES (1517749673829, '200::OK', 'site.fish119.adminss.controller.auth.AuthController', 'INFO', 'http-nio-9999-exec-1', 0, NULL, 'POST::http://127.0.0.1:9999/auth', '161', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3705);
INSERT INTO `logging_event` VALUES (1517749673977, '200::OK', 'site.fish119.adminss.controller.main.MainController', 'INFO', 'http-nio-9999-exec-8', 0, '1', 'POST::http://127.0.0.1:9999/index', '34', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3706);
INSERT INTO `logging_event` VALUES (1517749725187, 'Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@3d5051a0: startup date [Sun Feb 04 21:08:45 CST 2018]; root of context hierarchy', 'org.springframework.context.annotation.AnnotationConfigApplicationContext', 'INFO', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'AbstractApplicationContext.java', 'org.springframework.context.support.AbstractApplicationContext', 'prepareRefresh', '583', 3707);
INSERT INTO `logging_event` VALUES (1517749725440, 'Bean \'configurationPropertiesRebinderAutoConfiguration\' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$6f0942a0] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)', 'org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker', 'INFO', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'PostProcessorRegistrationDelegate.java', 'org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker', 'postProcessAfterInitialization', '327', 3708);
INSERT INTO `logging_event` VALUES (1517749725768, 'No active profile set, falling back to default profiles: default', 'site.fish119.adminss.AdminssApplication', 'INFO', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'SpringApplication.java', 'org.springframework.boot.SpringApplication', 'logStartupProfileInfo', '593', 3709);
INSERT INTO `logging_event` VALUES (1517749731591, 'Could not validate configuration attributes as the SecurityMetadataSource did not return any attributes from getAllConfigAttributes()', 'site.fish119.adminss.secruity.SecurityInterceptorImple', 'WARN', 'localhost-startStop-1', 0, NULL, NULL, NULL, NULL, 'AbstractSecurityInterceptor.java', 'org.springframework.security.access.intercept.AbstractSecurityInterceptor', 'afterPropertiesSet', '159', 3710);
INSERT INTO `logging_event` VALUES (1517749735510, 'No URLs will be polled as dynamic configuration sources.', 'com.netflix.config.sources.URLConfigurationSource', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'URLConfigurationSource.java', 'com.netflix.config.sources.URLConfigurationSource', '<init>', '120', 3711);
INSERT INTO `logging_event` VALUES (1517749735527, 'No URLs will be polled as dynamic configuration sources.', 'com.netflix.config.sources.URLConfigurationSource', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'URLConfigurationSource.java', 'com.netflix.config.sources.URLConfigurationSource', '<init>', '120', 3712);
INSERT INTO `logging_event` VALUES (1517749735900, 'Locations list is empty. No resources will be served unless a custom ResourceResolver is configured as an alternative to PathResourceResolver.', 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'ResourceHttpRequestHandler.java', 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler', 'afterPropertiesSet', '311', 3713);
INSERT INTO `logging_event` VALUES (1517749735909, 'Locations list is empty. No resources will be served unless a custom ResourceResolver is configured as an alternative to PathResourceResolver.', 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'ResourceHttpRequestHandler.java', 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler', 'afterPropertiesSet', '311', 3714);
INSERT INTO `logging_event` VALUES (1517749737578, 'Bean with key \'zuulEndpoint\' has been registered as an MBean but has no exposed attributes or operations', 'org.springframework.jmx.export.annotation.AnnotationMBeanExporter', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'MBeanExporter.java', 'org.springframework.jmx.export.MBeanExporter', 'getMBeanInfo', '849', 3715);
INSERT INTO `logging_event` VALUES (1517749738929, 'Trying to infer dataType java.util.Set<site.fish119.adminss.domain.sys.Role>', 'springfox.documentation.spring.web.readers.parameter.ParameterDataTypeReader', 'WARN', 'restartedMain', 0, 'java.util.Set<site.fish119.adminss.domain.sys.Role>', NULL, NULL, NULL, 'ParameterDataTypeReader.java', 'springfox.documentation.spring.web.readers.parameter.ParameterDataTypeReader', 'apply', '86', 3716);
INSERT INTO `logging_event` VALUES (1517749739543, 'Started AdminssApplication in 15.323 seconds (JVM running for 16.178)', 'site.fish119.adminss.AdminssApplication', 'INFO', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'StartupInfoLogger.java', 'org.springframework.boot.StartupInfoLogger', 'logStarted', '57', 3717);
INSERT INTO `logging_event` VALUES (1517749739680, 'No routes found from RouteLocator', 'org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping', 'WARN', 'http-nio-9999-exec-1', 0, NULL, NULL, NULL, NULL, 'ZuulHandlerMapping.java', 'org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping', 'registerHandlers', '117', 3718);
INSERT INTO `logging_event` VALUES (1517749770299, '200::OK', 'site.fish119.adminss.controller.main.MainController', 'INFO', 'http-nio-9999-exec-8', 0, '1', 'POST::http://127.0.0.1:9999/index', '90', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3719);
INSERT INTO `logging_event` VALUES (1517749775761, '200::OK', 'site.fish119.adminss.controller.article.ArticleController', 'INFO', 'http-nio-9999-exec-1', 0, '1', 'GET::http://127.0.0.1:9999/article/categories', '25', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3720);
INSERT INTO `logging_event` VALUES (1517749788928, '200::OK', 'site.fish119.adminss.controller.article.ArticleController', 'INFO', 'http-nio-9999-exec-6', 0, '1', 'POST::http://127.0.0.1:9999/article/categories', '135', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3721);
INSERT INTO `logging_event` VALUES (1517749798407, '200::OK', 'site.fish119.adminss.controller.article.ArticleController', 'INFO', 'http-nio-9999-exec-7', 0, '1', 'POST::http://127.0.0.1:9999/article/categories', '28', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3722);
INSERT INTO `logging_event` VALUES (1517749948752, 'Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@1f8dc32c: startup date [Sun Feb 04 21:12:28 CST 2018]; root of context hierarchy', 'org.springframework.context.annotation.AnnotationConfigApplicationContext', 'INFO', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'AbstractApplicationContext.java', 'org.springframework.context.support.AbstractApplicationContext', 'prepareRefresh', '583', 3723);
INSERT INTO `logging_event` VALUES (1517749949019, 'Bean \'configurationPropertiesRebinderAutoConfiguration\' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$a84e4e9d] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)', 'org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker', 'INFO', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'PostProcessorRegistrationDelegate.java', 'org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker', 'postProcessAfterInitialization', '327', 3724);
INSERT INTO `logging_event` VALUES (1517749949352, 'No active profile set, falling back to default profiles: default', 'site.fish119.adminss.AdminssApplication', 'INFO', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'SpringApplication.java', 'org.springframework.boot.SpringApplication', 'logStartupProfileInfo', '593', 3725);
INSERT INTO `logging_event` VALUES (1517749955119, 'Could not validate configuration attributes as the SecurityMetadataSource did not return any attributes from getAllConfigAttributes()', 'site.fish119.adminss.secruity.SecurityInterceptorImple', 'WARN', 'localhost-startStop-1', 0, NULL, NULL, NULL, NULL, 'AbstractSecurityInterceptor.java', 'org.springframework.security.access.intercept.AbstractSecurityInterceptor', 'afterPropertiesSet', '159', 3726);
INSERT INTO `logging_event` VALUES (1517749958874, 'No URLs will be polled as dynamic configuration sources.', 'com.netflix.config.sources.URLConfigurationSource', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'URLConfigurationSource.java', 'com.netflix.config.sources.URLConfigurationSource', '<init>', '120', 3727);
INSERT INTO `logging_event` VALUES (1517749958888, 'No URLs will be polled as dynamic configuration sources.', 'com.netflix.config.sources.URLConfigurationSource', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'URLConfigurationSource.java', 'com.netflix.config.sources.URLConfigurationSource', '<init>', '120', 3728);
INSERT INTO `logging_event` VALUES (1517749959209, 'Locations list is empty. No resources will be served unless a custom ResourceResolver is configured as an alternative to PathResourceResolver.', 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'ResourceHttpRequestHandler.java', 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler', 'afterPropertiesSet', '311', 3729);
INSERT INTO `logging_event` VALUES (1517749959218, 'Locations list is empty. No resources will be served unless a custom ResourceResolver is configured as an alternative to PathResourceResolver.', 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'ResourceHttpRequestHandler.java', 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler', 'afterPropertiesSet', '311', 3730);
INSERT INTO `logging_event` VALUES (1517749960810, 'Bean with key \'zuulEndpoint\' has been registered as an MBean but has no exposed attributes or operations', 'org.springframework.jmx.export.annotation.AnnotationMBeanExporter', 'WARN', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'MBeanExporter.java', 'org.springframework.jmx.export.MBeanExporter', 'getMBeanInfo', '849', 3731);
INSERT INTO `logging_event` VALUES (1517749962121, 'Trying to infer dataType java.util.Set<site.fish119.adminss.domain.sys.Role>', 'springfox.documentation.spring.web.readers.parameter.ParameterDataTypeReader', 'WARN', 'restartedMain', 0, 'java.util.Set<site.fish119.adminss.domain.sys.Role>', NULL, NULL, NULL, 'ParameterDataTypeReader.java', 'springfox.documentation.spring.web.readers.parameter.ParameterDataTypeReader', 'apply', '86', 3732);
INSERT INTO `logging_event` VALUES (1517749962726, 'Started AdminssApplication in 14.86 seconds (JVM running for 15.592)', 'site.fish119.adminss.AdminssApplication', 'INFO', 'restartedMain', 0, NULL, NULL, NULL, NULL, 'StartupInfoLogger.java', 'org.springframework.boot.StartupInfoLogger', 'logStarted', '57', 3733);
INSERT INTO `logging_event` VALUES (1517749962853, 'No routes found from RouteLocator', 'org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping', 'WARN', 'http-nio-9999-exec-1', 0, NULL, NULL, NULL, NULL, 'ZuulHandlerMapping.java', 'org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping', 'registerHandlers', '117', 3734);
INSERT INTO `logging_event` VALUES (1517749970719, '200::OK', 'site.fish119.adminss.controller.article.ArticleController', 'INFO', 'http-nio-9999-exec-4', 0, '1', 'GET::http://127.0.0.1:9999/article/categories', '26', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3735);
INSERT INTO `logging_event` VALUES (1517749970783, '200::OK', 'site.fish119.adminss.controller.main.MainController', 'INFO', 'http-nio-9999-exec-6', 0, '1', 'POST::http://127.0.0.1:9999/index', '90', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3736);
INSERT INTO `logging_event` VALUES (1517749973441, '200::OK', 'site.fish119.adminss.controller.article.ArticleController', 'INFO', 'http-nio-9999-exec-9', 0, '1', 'GET::http://127.0.0.1:9999/article/articles', '120', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3737);
INSERT INTO `logging_event` VALUES (1517749977403, '200::OK', 'site.fish119.adminss.controller.setting.DepartController', 'INFO', 'http-nio-9999-exec-1', 0, '1', 'GET::http://127.0.0.1:9999/setting/departments', '15', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3738);
INSERT INTO `logging_event` VALUES (1517749977971, '200::OK', 'site.fish119.adminss.controller.setting.DepartController', 'INFO', 'http-nio-9999-exec-2', 0, '1', 'GET::http://127.0.0.1:9999/setting/departments', '5', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3739);
INSERT INTO `logging_event` VALUES (1517749978029, '200::OK', 'site.fish119.adminss.controller.setting.UserController', 'INFO', 'http-nio-9999-exec-7', 0, '1', 'GET::http://127.0.0.1:9999/setting/users', '31', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3740);
INSERT INTO `logging_event` VALUES (1517749978030, '200::OK', 'site.fish119.adminss.controller.setting.RoleController', 'INFO', 'http-nio-9999-exec-3', 0, '1', 'GET::http://127.0.0.1:9999/setting/roles', '64', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3741);
INSERT INTO `logging_event` VALUES (1517749982280, '200::OK', 'site.fish119.adminss.controller.log.LoggingController', 'INFO', 'http-nio-9999-exec-6', 0, '1', 'GET::http://127.0.0.1:9999/logs', '18', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3742);
INSERT INTO `logging_event` VALUES (1517749984598, '200::OK', 'site.fish119.adminss.controller.setting.AuthorityController', 'INFO', 'http-nio-9999-exec-8', 0, '1', 'GET::http://127.0.0.1:9999/setting/authorities', '34', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3743);
INSERT INTO `logging_event` VALUES (1517749985291, '200::OK', 'site.fish119.adminss.controller.setting.MenuController', 'INFO', 'http-nio-9999-exec-2', 0, '1', 'GET::http://127.0.0.1:9999/setting/menus', '19', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3744);
INSERT INTO `logging_event` VALUES (1517749986214, '200::OK', 'site.fish119.adminss.controller.setting.MenuController', 'INFO', 'http-nio-9999-exec-3', 0, '1', 'GET::http://127.0.0.1:9999/setting/menus', '11', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3745);
INSERT INTO `logging_event` VALUES (1517749986238, '200::OK', 'site.fish119.adminss.controller.setting.AuthorityController', 'INFO', 'http-nio-9999-exec-4', 0, '1', 'GET::http://127.0.0.1:9999/setting/authorities', '35', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3746);
INSERT INTO `logging_event` VALUES (1517749986239, '200::OK', 'site.fish119.adminss.controller.setting.RoleController', 'INFO', 'http-nio-9999-exec-7', 0, '1', 'GET::http://127.0.0.1:9999/setting/roles', '32', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3747);
INSERT INTO `logging_event` VALUES (1517749986872, '200::OK', 'site.fish119.adminss.controller.setting.AuthorityController', 'INFO', 'http-nio-9999-exec-6', 0, '1', 'GET::http://127.0.0.1:9999/setting/authorities', '27', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3748);
INSERT INTO `logging_event` VALUES (1517749990411, '200::OK', 'site.fish119.adminss.controller.auth.AuthController', 'INFO', 'http-nio-9999-exec-5', 0, NULL, 'POST::http://127.0.0.1:9999/auth', '160', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3749);
INSERT INTO `logging_event` VALUES (1517749990563, '200::OK', 'site.fish119.adminss.controller.main.MainController', 'INFO', 'http-nio-9999-exec-9', 0, '1', 'POST::http://127.0.0.1:9999/index', '29', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3750);
INSERT INTO `logging_event` VALUES (1517749993752, '200::OK', 'site.fish119.adminss.controller.article.ArticleController', 'INFO', 'http-nio-9999-exec-1', 0, '1', 'GET::http://127.0.0.1:9999/article/categories', '5', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3751);
INSERT INTO `logging_event` VALUES (1517749994302, '200::OK', 'site.fish119.adminss.controller.article.ArticleController', 'INFO', 'http-nio-9999-exec-2', 0, '1', 'GET::http://127.0.0.1:9999/article/articles', '49', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3752);
INSERT INTO `logging_event` VALUES (1517749996235, '200::OK', 'site.fish119.adminss.controller.setting.DepartController', 'INFO', 'http-nio-9999-exec-4', 0, '1', 'GET::http://127.0.0.1:9999/setting/departments', '4', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3753);
INSERT INTO `logging_event` VALUES (1517749996241, '200::OK', 'site.fish119.adminss.controller.setting.UserController', 'INFO', 'http-nio-9999-exec-7', 0, '1', 'GET::http://127.0.0.1:9999/setting/users', '9', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3754);
INSERT INTO `logging_event` VALUES (1517749996260, '200::OK', 'site.fish119.adminss.controller.setting.RoleController', 'INFO', 'http-nio-9999-exec-3', 0, '1', 'GET::http://127.0.0.1:9999/setting/roles', '29', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3755);
INSERT INTO `logging_event` VALUES (1517749996895, '200::OK', 'site.fish119.adminss.controller.setting.DepartController', 'INFO', 'http-nio-9999-exec-5', 0, '1', 'GET::http://127.0.0.1:9999/setting/departments', '4', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3756);
INSERT INTO `logging_event` VALUES (1517749999977, '200::OK', 'site.fish119.adminss.controller.log.LoggingController', 'INFO', 'http-nio-9999-exec-6', 0, '1', 'GET::http://127.0.0.1:9999/logs', '4', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3757);
INSERT INTO `logging_event` VALUES (1517750001860, '200::OK', 'site.fish119.adminss.controller.setting.AuthorityController', 'INFO', 'http-nio-9999-exec-5', 0, '1', 'GET::http://127.0.0.1:9999/setting/authorities', '24', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3758);
INSERT INTO `logging_event` VALUES (1517750002489, '200::OK', 'site.fish119.adminss.controller.setting.MenuController', 'INFO', 'http-nio-9999-exec-10', 0, '1', 'GET::http://127.0.0.1:9999/setting/menus', '8', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3759);
INSERT INTO `logging_event` VALUES (1517750003073, '200::OK', 'site.fish119.adminss.controller.setting.MenuController', 'INFO', 'http-nio-9999-exec-4', 0, '1', 'GET::http://127.0.0.1:9999/setting/menus', '8', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3760);
INSERT INTO `logging_event` VALUES (1517750003096, '200::OK', 'site.fish119.adminss.controller.setting.RoleController', 'INFO', 'http-nio-9999-exec-1', 0, '1', 'GET::http://127.0.0.1:9999/setting/roles', '31', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3761);
INSERT INTO `logging_event` VALUES (1517750003097, '200::OK', 'site.fish119.adminss.controller.setting.AuthorityController', 'INFO', 'http-nio-9999-exec-2', 0, '1', 'GET::http://127.0.0.1:9999/setting/authorities', '32', '127.0.0.1', 'WebLogAspect.java', 'site.fish119.adminss.utils.WebLogAspect', 'doAfterReturning', '72', 3762);

-- ----------------------------
-- Table structure for logging_event_exception
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_exception`;
CREATE TABLE `logging_event_exception`  (
  `event_id` bigint(20) NOT NULL,
  `i` smallint(6) NOT NULL,
  `trace_line` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`event_id`, `i`) USING BTREE,
  CONSTRAINT `logging_event_exception_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logging_event_property
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_property`;
CREATE TABLE `logging_event_property`  (
  `event_id` bigint(20) NOT NULL,
  `mapped_key` varchar(254) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mapped_value` text CHARACTER SET utf8 COLLATE utf8_bin,
  PRIMARY KEY (`event_id`, `mapped_key`) USING BTREE,
  CONSTRAINT `logging_event_property_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sort` bigint(20) DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/',
  `parent_id` bigint(20) DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_nwj602y8xtbwasdtvcvcn4j8s`(`name`) USING BTREE,
  INDEX `FK7jouvtrmxkx4yq25e6vrjnn28`(`parent_id`) USING BTREE,
  CONSTRAINT `FK7jouvtrmxkx4yq25e6vrjnn28` FOREIGN KEY (`parent_id`) REFERENCES `sys_authority` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES (1, '首页分类', '首页', 0, '/', NULL, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (2, '获取首页数据', '获取首页数据', 0, '/index', 1, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (3, 'get all menus', '获取所有菜单', 0, '/setting/menus', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (4, '编辑菜单', '编辑菜单', 1, '/setting/menu/*', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (5, '编辑子菜单', '编辑子菜单', 2, '/setting/menus/*/menus/*', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (6, '系统设置分类', '系统设置', 20, '/', NULL, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (9, '获取所有权限', '获取所有权限', 3, '/setting/authorities', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (10, '修改权限', '修改权限', 4, '/setting/authority/*', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (11, '修改子权限', '修改子权限', 5, '/setting/authorities/*/authorities/*', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (17, '获取角色列表及保存角色(POST方法）', '获取角色列表及保存角色', 6, '/setting/roles', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (18, '编辑单个角色（暂时只有DELETE方法有效）', '编辑单个角色', 7, '/setting/role/{id}', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (19, '部门（获取列表、编辑保存）', '部门', 9, '/setting/departments', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (20, '根据ID编辑部门(暂仅删除)', '修改部门(暂仅删除)', 9, '/setting/department/*', 6, 'DELETE', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (21, '用户(获取列表,保存)', '用户(获取列表,保存)', 11, '/setting/users', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (22, '将选定用户的密码重置为默认密码', '重置默认密码', 10, '/setting/users/setDefaultPassword', 6, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (23, '删除用户', '删除用户', 11, '/setting/users/*', 6, 'DELETE', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (24, '用户电话号码是否重复', '用户电话号码是否重复', 12, '/setting/user/*/phone/*', 6, 'GET', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (25, '用户名是否重复', '用户名是否重复', 13, '/setting/user/*/username/*', 6, 'GET', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (26, '用户昵称是否重复', '昵称是否重复', 13, '/setting/user/*/nickname/*', 6, 'GET', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (27, '通过Email查找用户(Email是否重复）', '通过Email查找用户', 12, '/setting/user/*/email', 6, 'GET', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (28, '', 'ces', 2, 'cs', NULL, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (29, 'aaa', 'aaa', 0, 'abababab', 28, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (30, '', 'bbb', 0, 'babab', 28, 'GET', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (31, '获取当前用户信息', '获取当前用户信息', 2, '/setting/user/current', 32, 'GET', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (32, '个人设置、当前登录用户信息相关', '个人设置', 1, '/', NULL, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (33, '设置当前用户头像', '设置头像', 1, '/setting/profile/setAvatar', 32, 'POST', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (34, '包括当前用户数据、所有部门数据、所有角色数据', '获取“个人信息”功能所需数据', 0, '/setting/profile', 32, 'GET', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (35, '修改当前用户密码', '修改密码', 4, '/setting/profile/changePassword', 32, 'POST', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (36, '系统监控', '系统监控', 19, '/', NULL, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (38, '查询系统日志列表', '系统日志', 0, '/logs', 36, 'GET', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (39, '清空日志', '清空日志', 1, '/logs', 36, 'DELETE', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (40, '内容管理', '内容管理', 1, '/', NULL, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (41, '内容分类管理(增改查）', '内容分类管理', 0, '/article/categories', 40, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (42, '删除内容分类', '删除内容分类', 1, '/article/categories/*', 40, 'DELETE', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (43, '查询文章列表、保存文章', '文章管理(列表、保存）', 2, '/article/articles', 40, 'ALL', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (44, '上传内容中的图片', '上传图片', 3, '/article/imageUpload', 40, 'POST', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_authority` VALUES (45, '删除内容', '删除内容', 4, '/article/articles/*', 40, 'DELETE', '2018-02-04 20:43:17', '2018-02-04 20:43:17');

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sort` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_3c0icpjqmnbs7vsjqwg3cpff3`(`name`) USING BTREE,
  INDEX `FK5bcsdbqycjdgdvti7a55b3ht1`(`parent_id`) USING BTREE,
  CONSTRAINT `FK5bcsdbqycjdgdvti7a55b3ht1` FOREIGN KEY (`parent_id`) REFERENCES `sys_department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES (1, 0, NULL, '总部', '2018-02-04 20:04:26', '2018-02-04 20:04:26');
INSERT INTO `sys_department` VALUES (2, 0, 1, '管理部', '2018-02-04 20:04:26', '2018-02-04 20:04:52');
INSERT INTO `sys_department` VALUES (36, 1, NULL, '测试', '2018-02-04 20:04:26', '2018-02-04 20:05:28');
INSERT INTO `sys_department` VALUES (44, 0, 36, 'AAAA', '2018-02-04 20:04:26', '2018-02-04 20:05:21');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sort` bigint(20) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK2jrf4gb0gjqi8882gxytpxnhe`(`parent_id`) USING BTREE,
  CONSTRAINT `FK2jrf4gb0gjqi8882gxytpxnhe` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, NULL, 'home', 0, '首页', NULL, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (2, '/main', 'dashboard', 0, 'dashboard', 1, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (3, NULL, 'settings', 20, '系统设置', NULL, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (4, '/settings/users', 'account_circle', 1, '用户管理', 32, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (5, '/settings/roles', 'supervisor_account', 0, '角色管理', 3, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (6, '/settings/authorities', 'lock', 1, '权限管理', 3, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (7, '/settings/menus', 'menu', 2, '菜单管理', 3, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (32, '', 'person', 19, '人员管理', NULL, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (42, '/settings/departments', 'account_balance', 0, '部门管理', 32, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (46, '', 'account_circle', 18, '个人设置', NULL, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (47, '/profile/profile', 'face', 0, '个人信息', 46, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (48, '', 'visibility', 19, '系统监控', NULL, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (49, '/monitor/dbmonitor', 'dns', 1, '数据库', 48, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (50, '/monitor/loggings', 'event_note', 2, '系统日志', 48, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (51, '/monitor/statemonitor', 'dvr', 0, '系统状态', 48, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (52, '/', 'library_books', 1, '内容管理', NULL, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (53, '/article/category', 'style', 0, '内容分类', 52, '2018-02-04 20:12:41', '2018-02-04 20:12:41');
INSERT INTO `sys_menu` VALUES (54, '/article/article', 'description', 1, '内容管理', 52, '2018-02-04 20:12:41', '2018-02-04 20:12:41');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sort` bigint(20) DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_bqy406dtsr7j7d6fawi1ckyn1`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 0, '2018-02-04 20:32:01', '2018-02-04 20:32:34');
INSERT INTO `sys_role` VALUES (2, '超级用户', 1, '2018-02-04 20:32:03', '2018-02-04 20:32:10');
INSERT INTO `sys_role` VALUES (5, 'ces', 2, '2018-02-04 20:32:06', '2018-02-04 20:32:13');

-- ----------------------------
-- Table structure for sys_role_authorities
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_authorities`;
CREATE TABLE `sys_role_authorities`  (
  `role_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`, `authority_id`) USING BTREE,
  INDEX `FK9lufow11qo4ioejn7im8i4qaj`(`authority_id`) USING BTREE,
  CONSTRAINT `FK9lufow11qo4ioejn7im8i4qaj` FOREIGN KEY (`authority_id`) REFERENCES `sys_authority` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `FKlniymbjbgoofxh7g22ic5x3dd` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_authorities
-- ----------------------------
INSERT INTO `sys_role_authorities` VALUES (1, 1);
INSERT INTO `sys_role_authorities` VALUES (5, 1);
INSERT INTO `sys_role_authorities` VALUES (1, 2);
INSERT INTO `sys_role_authorities` VALUES (2, 2);
INSERT INTO `sys_role_authorities` VALUES (5, 2);
INSERT INTO `sys_role_authorities` VALUES (1, 3);
INSERT INTO `sys_role_authorities` VALUES (2, 3);
INSERT INTO `sys_role_authorities` VALUES (1, 4);
INSERT INTO `sys_role_authorities` VALUES (2, 4);
INSERT INTO `sys_role_authorities` VALUES (1, 5);
INSERT INTO `sys_role_authorities` VALUES (2, 5);
INSERT INTO `sys_role_authorities` VALUES (1, 6);
INSERT INTO `sys_role_authorities` VALUES (1, 9);
INSERT INTO `sys_role_authorities` VALUES (2, 9);
INSERT INTO `sys_role_authorities` VALUES (1, 10);
INSERT INTO `sys_role_authorities` VALUES (2, 10);
INSERT INTO `sys_role_authorities` VALUES (1, 11);
INSERT INTO `sys_role_authorities` VALUES (2, 11);
INSERT INTO `sys_role_authorities` VALUES (1, 17);
INSERT INTO `sys_role_authorities` VALUES (2, 17);
INSERT INTO `sys_role_authorities` VALUES (1, 18);
INSERT INTO `sys_role_authorities` VALUES (2, 18);
INSERT INTO `sys_role_authorities` VALUES (1, 19);
INSERT INTO `sys_role_authorities` VALUES (2, 19);
INSERT INTO `sys_role_authorities` VALUES (1, 20);
INSERT INTO `sys_role_authorities` VALUES (2, 20);
INSERT INTO `sys_role_authorities` VALUES (1, 21);
INSERT INTO `sys_role_authorities` VALUES (2, 21);
INSERT INTO `sys_role_authorities` VALUES (1, 22);
INSERT INTO `sys_role_authorities` VALUES (2, 22);
INSERT INTO `sys_role_authorities` VALUES (1, 23);
INSERT INTO `sys_role_authorities` VALUES (2, 23);
INSERT INTO `sys_role_authorities` VALUES (1, 24);
INSERT INTO `sys_role_authorities` VALUES (2, 24);
INSERT INTO `sys_role_authorities` VALUES (1, 25);
INSERT INTO `sys_role_authorities` VALUES (2, 25);
INSERT INTO `sys_role_authorities` VALUES (1, 26);
INSERT INTO `sys_role_authorities` VALUES (2, 26);
INSERT INTO `sys_role_authorities` VALUES (1, 27);
INSERT INTO `sys_role_authorities` VALUES (2, 27);
INSERT INTO `sys_role_authorities` VALUES (2, 29);
INSERT INTO `sys_role_authorities` VALUES (2, 30);
INSERT INTO `sys_role_authorities` VALUES (1, 31);
INSERT INTO `sys_role_authorities` VALUES (2, 31);
INSERT INTO `sys_role_authorities` VALUES (1, 33);
INSERT INTO `sys_role_authorities` VALUES (2, 33);
INSERT INTO `sys_role_authorities` VALUES (1, 34);
INSERT INTO `sys_role_authorities` VALUES (2, 34);
INSERT INTO `sys_role_authorities` VALUES (1, 35);
INSERT INTO `sys_role_authorities` VALUES (2, 35);
INSERT INTO `sys_role_authorities` VALUES (1, 38);
INSERT INTO `sys_role_authorities` VALUES (2, 38);
INSERT INTO `sys_role_authorities` VALUES (1, 39);
INSERT INTO `sys_role_authorities` VALUES (2, 39);
INSERT INTO `sys_role_authorities` VALUES (1, 41);
INSERT INTO `sys_role_authorities` VALUES (2, 41);
INSERT INTO `sys_role_authorities` VALUES (1, 42);
INSERT INTO `sys_role_authorities` VALUES (2, 42);
INSERT INTO `sys_role_authorities` VALUES (1, 43);
INSERT INTO `sys_role_authorities` VALUES (2, 43);
INSERT INTO `sys_role_authorities` VALUES (1, 44);
INSERT INTO `sys_role_authorities` VALUES (2, 44);
INSERT INTO `sys_role_authorities` VALUES (1, 45);
INSERT INTO `sys_role_authorities` VALUES (2, 45);

-- ----------------------------
-- Table structure for sys_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menus`;
CREATE TABLE `sys_role_menus`  (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE,
  INDEX `FK6ye9n219h3egm4csthaaxt6qm`(`menu_id`) USING BTREE,
  CONSTRAINT `FK6ye9n219h3egm4csthaaxt6qm` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKt8curcxjlubvnbrj60h8dmuts` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menus
-- ----------------------------
INSERT INTO `sys_role_menus` VALUES (1, 1);
INSERT INTO `sys_role_menus` VALUES (2, 1);
INSERT INTO `sys_role_menus` VALUES (5, 1);
INSERT INTO `sys_role_menus` VALUES (1, 2);
INSERT INTO `sys_role_menus` VALUES (2, 2);
INSERT INTO `sys_role_menus` VALUES (5, 2);
INSERT INTO `sys_role_menus` VALUES (1, 3);
INSERT INTO `sys_role_menus` VALUES (2, 3);
INSERT INTO `sys_role_menus` VALUES (1, 4);
INSERT INTO `sys_role_menus` VALUES (2, 4);
INSERT INTO `sys_role_menus` VALUES (1, 5);
INSERT INTO `sys_role_menus` VALUES (2, 5);
INSERT INTO `sys_role_menus` VALUES (1, 6);
INSERT INTO `sys_role_menus` VALUES (2, 6);
INSERT INTO `sys_role_menus` VALUES (1, 7);
INSERT INTO `sys_role_menus` VALUES (2, 7);
INSERT INTO `sys_role_menus` VALUES (1, 32);
INSERT INTO `sys_role_menus` VALUES (2, 32);
INSERT INTO `sys_role_menus` VALUES (1, 42);
INSERT INTO `sys_role_menus` VALUES (2, 42);
INSERT INTO `sys_role_menus` VALUES (1, 46);
INSERT INTO `sys_role_menus` VALUES (2, 46);
INSERT INTO `sys_role_menus` VALUES (1, 47);
INSERT INTO `sys_role_menus` VALUES (2, 47);
INSERT INTO `sys_role_menus` VALUES (1, 48);
INSERT INTO `sys_role_menus` VALUES (2, 48);
INSERT INTO `sys_role_menus` VALUES (1, 49);
INSERT INTO `sys_role_menus` VALUES (2, 49);
INSERT INTO `sys_role_menus` VALUES (1, 50);
INSERT INTO `sys_role_menus` VALUES (2, 50);
INSERT INTO `sys_role_menus` VALUES (1, 51);
INSERT INTO `sys_role_menus` VALUES (2, 51);
INSERT INTO `sys_role_menus` VALUES (1, 52);
INSERT INTO `sys_role_menus` VALUES (2, 52);
INSERT INTO `sys_role_menus` VALUES (1, 53);
INSERT INTO `sys_role_menus` VALUES (2, 53);
INSERT INTO `sys_role_menus` VALUES (1, 54);
INSERT INTO `sys_role_menus` VALUES (2, 54);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `last_password_reset_date` datetime(0) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_51bvuyvihefoh4kp5syh2jpi4`(`username`) USING BTREE,
  UNIQUE INDEX `sys_user_un_phone`(`phone`) USING BTREE,
  UNIQUE INDEX `sys_user_un_nickname`(`nickname`) USING BTREE,
  INDEX `FK4w939ws31adtcrmodq3varlii`(`dept_id`) USING BTREE,
  CONSTRAINT `FK4w939ws31adtcrmodq3varlii` FOREIGN KEY (`dept_id`) REFERENCES `sys_department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2018-01-27 00:39:12', '$2a$10$Bs0To3uH8JpnJWNV4JjnmuwhVcCvCHcFNkxq77fWIdKmhmjJM/8fu', 'string', '1.png', 1, '管理员', '18888888888', '888@888.com', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (2, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'test', 'fish119.png', 1, 'test', '139123458', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (3, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'ttt', 'fish119.png', 1, 'ttt', '139123459', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (4, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'test1', 'fish119.png', 1, 'test1', '139123460', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (6, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'string1', 'fish119.png', 1, 'string1', '139123462', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (7, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'test2', 'fish119.png', 1, 'test2', '139123463', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (8, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'ttt3', 'fish119.png', 1, 'ttt3', '139123464', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (9, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'test4', 'fish119.png', 1, 'test4', '139123465', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (10, '2018-02-04 20:45:42', '$2a$10$MSZC6EwZMixzH9NXSlC6VerlzcxKGLa0cGAUfPCrvWcJDSS33hpiy', '444444', 'fish119.png', 1, '444444', '13912346913', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (11, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'string22', 'fish119.png', 1, 'string22', '139123467', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (12, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'test3', 'fish119.png', 1, 'test3', '139123468', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (13, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', '433111', 'fish119.png', 1, '4331111', '13912346921', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (14, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', '4ffwef3', 'fish119.png', 1, '4ffwef3', '139123470', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (15, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'test13', 'fish119.png', 1, 'test13', '139123471', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (18, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', '8765', 'fish119.png', 1, '8765', '139123474', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (19, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', '654', 'fish119.png', 1, '654', '139123475', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (23, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'gweg', 'fish119.png', 1, 'gweg', '139123479', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (25, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'wff', 'fish119.png', 1, 'wff', '139123481', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (26, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'wbwbw', 'fish119.png', 1, 'wbwbw', '139123482', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (27, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'zxcvz', 'fish119.png', 1, 'zxcvz', '139123483', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (28, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'sdfwef', 'fish119.png', 1, 'sdfwef', '139123484', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (30, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'x', 'fish119.png', 1, 'x', '139123486', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (31, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'wrhrwh', 'fish119.png', 1, 'wrhrwh', '139123487', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (33, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'wer', 'fish119.png', 1, 'wer', '139123489', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (34, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', 'ehtjl2', 'fish119.png', 1, 'ehtjl2', '13912349022', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (35, '2018-01-09 12:58:31', '$2a$10$nzGlB5KrSU.KJ3QuRkQvRekz4ISHncaZlclT4JY4yvZBvOBu3wxcC', '4ffwefnbmbnm', 'fish119.png', 1, '4ffwefnbmbnm', '139123491', '', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (39, '2018-01-24 16:53:01', '$2a$10$kpntSh0NDJaD6S2e0HX56OKLVWh0QZW.6WJxYGqvFfO9KnckuT4Cu', 'tttaaaa', NULL, 36, 'testtt', '12121212111', '1212@1212.com', '2018-02-04 20:43:17', '2018-02-04 20:43:17');
INSERT INTO `sys_user` VALUES (44, '2018-02-04 20:58:09', '$2a$10$cnbBOKvHWTHL51Vh63GKwOhepgwf8eG3g0M5jwZR2cnr6m4qg.o1S', '990909909', NULL, 44, '0909090', '19022212122', NULL, '2018-02-04 20:58:09', '2018-02-04 20:58:09');
INSERT INTO `sys_user` VALUES (45, '2018-02-04 21:03:21', '$2a$10$55TNnat04aiBYlF.r0yvC.KcWHMsVr6YsmJmcARN/cWZHHW/gCcvS', 'hghghg', NULL, 36, 'ghghgh', '11353463451', NULL, '2018-02-04 21:03:21', '2018-02-04 21:03:21');

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FKqwiuml6b7mjmk48u5b9hmk853`(`role_id`) USING BTREE,
  CONSTRAINT `FKp2804vh0ea810pitigxq5n6pn` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKqwiuml6b7mjmk48u5b9hmk853` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO `sys_user_roles` VALUES (1, 1);
INSERT INTO `sys_user_roles` VALUES (39, 2);
INSERT INTO `sys_user_roles` VALUES (39, 5);

SET FOREIGN_KEY_CHECKS = 1;
