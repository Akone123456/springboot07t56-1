-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot07t56
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot07t56`
--

/*!40000 DROP DATABASE IF EXISTS `springboot07t56`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot07t56` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot07t56`;

--
-- Table structure for table `cheliangxinxi`
--

DROP TABLE IF EXISTS `cheliangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheliangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangbianhao` varchar(200) DEFAULT NULL COMMENT '车辆编号',
  `cheliangleixing` varchar(200) DEFAULT NULL COMMENT '车辆类型',
  `chejiahao` varchar(200) DEFAULT NULL COMMENT '车架号',
  `zaizhongliang` varchar(200) DEFAULT NULL COMMENT '载重量',
  `licheng` varchar(200) DEFAULT NULL COMMENT '里程',
  `sijixingming` varchar(200) DEFAULT NULL COMMENT '司机姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649844248761 DEFAULT CHARSET=utf8 COMMENT='车辆信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheliangxinxi`
--

LOCK TABLES `cheliangxinxi` WRITE;
/*!40000 ALTER TABLE `cheliangxinxi` DISABLE KEYS */;
INSERT INTO `cheliangxinxi` VALUES (61,'2022-04-13 09:53:39','车辆编号1','车辆类型1','车架号1','载重量1','里程1','司机姓名1'),(62,'2022-04-13 09:53:39','车辆编号2','车辆类型2','车架号2','载重量2','里程2','司机姓名2'),(63,'2022-04-13 09:53:39','车辆编号3','车辆类型3','车架号3','载重量3','里程3','司机姓名3'),(64,'2022-04-13 09:53:39','车辆编号4','车辆类型4','车架号4','载重量4','里程4','司机姓名4'),(65,'2022-04-13 09:53:39','车辆编号5','车辆类型5','车架号5','载重量5','里程5','司机姓名5'),(66,'2022-04-13 09:53:39','车辆编号6','车辆类型6','车架号6','载重量6','里程6','司机姓名6'),(1649844248760,'2022-04-13 10:04:08','111111','拖头','15311515311','500KG','XXXX','李四');
/*!40000 ALTER TABLE `cheliangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg'),(7,'APIKey','ihML0NfEM0jokUAuBD9tbYtW'),(8,'SecretKey','WK2bRUFf2uNe3oEoQXULpi8Y37aCvFdD');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huowuxinxi`
--

DROP TABLE IF EXISTS `huowuxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huowuxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `luxianmingcheng` varchar(200) DEFAULT NULL COMMENT '路线名称',
  `huowumingcheng` varchar(200) DEFAULT NULL COMMENT '货物名称',
  `zhongliang` float DEFAULT NULL COMMENT '重量',
  `wuliudanjia` float DEFAULT NULL COMMENT '物流单价',
  `zongjia` float DEFAULT NULL COMMENT '总价',
  `fahuoshijian` datetime DEFAULT NULL COMMENT '发货时间',
  `shouhuorenxingming` varchar(200) DEFAULT NULL COMMENT '收货人姓名',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `gongsibianhao` varchar(200) DEFAULT NULL COMMENT '公司编号',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  `longitude` float DEFAULT NULL COMMENT '经度',
  `latitude` float DEFAULT NULL COMMENT '纬度',
  `fulladdress` varchar(200) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dingdanbianhao` (`dingdanbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1649844406896 DEFAULT CHARSET=utf8 COMMENT='货物信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huowuxinxi`
--

LOCK TABLES `huowuxinxi` WRITE;
/*!40000 ALTER TABLE `huowuxinxi` DISABLE KEYS */;
INSERT INTO `huowuxinxi` VALUES (41,'2022-04-13 09:53:39','1111111111','路线名称1','货物名称1',1,1,1,'2022-04-13 17:53:39','收货人姓名1','13823888881','公司编号1','账号1','姓名1','13823888881','upload/huowuxinxi_tupian1.jpg','是','','未支付',1,1,'宇宙银河系地球1号'),(42,'2022-04-13 09:53:39','2222222222','路线名称2','货物名称2',2,2,2,'2022-04-13 17:53:39','收货人姓名2','13823888882','公司编号2','账号2','姓名2','13823888882','upload/huowuxinxi_tupian2.jpg','是','','未支付',2,2,'宇宙银河系地球2号'),(43,'2022-04-13 09:53:39','3333333333','路线名称3','货物名称3',3,3,3,'2022-04-13 17:53:39','收货人姓名3','13823888883','公司编号3','账号3','姓名3','13823888883','upload/huowuxinxi_tupian3.jpg','是','','未支付',3,3,'宇宙银河系地球3号'),(44,'2022-04-13 09:53:39','4444444444','路线名称4','货物名称4',4,4,4,'2022-04-13 17:53:39','收货人姓名4','13823888884','公司编号4','账号4','姓名4','13823888884','upload/huowuxinxi_tupian4.jpg','是','','未支付',4,4,'宇宙银河系地球4号'),(45,'2022-04-13 09:53:39','5555555555','路线名称5','货物名称5',5,5,5,'2022-04-13 17:53:39','收货人姓名5','13823888885','公司编号5','账号5','姓名5','13823888885','upload/huowuxinxi_tupian5.jpg','是','','未支付',5,5,'宇宙银河系地球5号'),(46,'2022-04-13 09:53:39','6666666666','路线名称6','货物名称6',6,6,6,'2022-04-13 17:53:39','收货人姓名6','13823888886','公司编号6','账号6','姓名6','13823888886','upload/huowuxinxi_tupian6.jpg','是','','未支付',6,6,'宇宙银河系地球6号'),(1649844406895,'2022-04-13 10:06:46','1649844540726','XXXX','xxx',500,80,40000,'2022-04-13 18:09:00','王五','18154541454','222','111','张三','18154541454','upload/1649844387708.jpg','是','xxx','已支付',116.382,39.8945,'北京市西城区椿树街道西南园北京市第四十三中学');
/*!40000 ALTER TABLE `huowuxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1649843697170,'333','yonghu','用户','3n1agghbobsrxn41gszbkw2zbjmzffqn','2022-04-13 09:55:00','2022-04-13 10:55:01'),(2,1649844177253,'222','yunshugongsi','运输公司','ftfmv0z6iyn2evno16c1o93r4tm8e0xc','2022-04-13 10:03:10','2022-04-13 11:07:59'),(3,1649844128033,'111','yonghu','用户','gohgz5pzphdav21nkuv6bz47lbpqlcst','2022-04-13 10:04:14','2022-04-13 11:07:40'),(4,1,'abo','users','管理员','kyavob6jo6rojdcehfg5qj1go4tu198q','2022-04-13 10:13:42','2022-04-13 11:13:43');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2022-04-13 09:53:39');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wuliuluxian`
--

DROP TABLE IF EXISTS `wuliuluxian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wuliuluxian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `luxianmingcheng` varchar(200) DEFAULT NULL COMMENT '路线名称',
  `qidiandizhi` varchar(200) DEFAULT NULL COMMENT '起点地址',
  `daodadizhi` varchar(200) DEFAULT NULL COMMENT '到达地址',
  `wuliudanjia` float DEFAULT NULL COMMENT '物流单价',
  `luxianxiangqing` longtext COMMENT '路线详情',
  `gongsibianhao` varchar(200) DEFAULT NULL COMMENT '公司编号',
  `gongsimingcheng` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649844214288 DEFAULT CHARSET=utf8 COMMENT='物流路线';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wuliuluxian`
--

LOCK TABLES `wuliuluxian` WRITE;
/*!40000 ALTER TABLE `wuliuluxian` DISABLE KEYS */;
INSERT INTO `wuliuluxian` VALUES (31,'2022-04-13 09:53:39','路线名称1','起点地址1','到达地址1',1,'路线详情1','公司编号1','公司名称1','13823888881'),(32,'2022-04-13 09:53:39','路线名称2','起点地址2','到达地址2',2,'路线详情2','公司编号2','公司名称2','13823888882'),(33,'2022-04-13 09:53:39','路线名称3','起点地址3','到达地址3',3,'路线详情3','公司编号3','公司名称3','13823888883'),(34,'2022-04-13 09:53:39','路线名称4','起点地址4','到达地址4',4,'路线详情4','公司编号4','公司名称4','13823888884'),(35,'2022-04-13 09:53:39','路线名称5','起点地址5','到达地址5',5,'路线详情5','公司编号5','公司名称5','13823888885'),(36,'2022-04-13 09:53:39','路线名称6','起点地址6','到达地址6',6,'路线详情6','公司编号6','公司名称6','13823888886'),(1649844214287,'2022-04-13 10:03:33','XXXX','XXXX','XXXX',80,'<p>XXXXXX</p>','222','XXX','18154541454');
/*!40000 ALTER TABLE `wuliuluxian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) NOT NULL COMMENT '账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1649844128034 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (11,'2022-04-13 09:53:39','账号1','123456','姓名1','男','13823888881','440300199101010001','upload/yonghu_touxiang1.jpg'),(12,'2022-04-13 09:53:39','账号2','123456','姓名2','男','13823888882','440300199202020002','upload/yonghu_touxiang2.jpg'),(13,'2022-04-13 09:53:39','账号3','123456','姓名3','男','13823888883','440300199303030003','upload/yonghu_touxiang3.jpg'),(14,'2022-04-13 09:53:39','账号4','123456','姓名4','男','13823888884','440300199404040004','upload/yonghu_touxiang4.jpg'),(15,'2022-04-13 09:53:39','账号5','123456','姓名5','男','13823888885','440300199505050005','upload/yonghu_touxiang5.jpg'),(16,'2022-04-13 09:53:39','账号6','123456','姓名6','男','13823888886','440300199606060006','upload/yonghu_touxiang6.jpg'),(1649843697170,'2022-04-13 09:54:57','333','333','333',NULL,NULL,NULL,'upload/1649843726871.jpg'),(1649844128033,'2022-04-13 10:02:08','111','111','张三','男','18154541454','441454515415414514','upload/1649844268707.jpg');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yundanxinxi`
--

DROP TABLE IF EXISTS `yundanxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yundanxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `luxianmingcheng` varchar(200) DEFAULT NULL COMMENT '路线名称',
  `huowumingcheng` varchar(200) DEFAULT NULL COMMENT '货物名称',
  `zhongliang` float DEFAULT NULL COMMENT '重量',
  `wuliudanjia` float DEFAULT NULL COMMENT '物流单价',
  `zongjia` float DEFAULT NULL COMMENT '总价',
  `yundanzhuangtai` varchar(200) DEFAULT NULL COMMENT '运单状态',
  `shouhuorenxingming` varchar(200) DEFAULT NULL COMMENT '收货人姓名',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `cheliangbianhao` varchar(200) DEFAULT NULL COMMENT '车辆编号',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `gongsibianhao` varchar(200) DEFAULT NULL COMMENT '公司编号',
  `gongsimingcheng` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649844452658 DEFAULT CHARSET=utf8 COMMENT='运单信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yundanxinxi`
--

LOCK TABLES `yundanxinxi` WRITE;
/*!40000 ALTER TABLE `yundanxinxi` DISABLE KEYS */;
INSERT INTO `yundanxinxi` VALUES (51,'2022-04-13 09:53:39','订单编号1','路线名称1','货物名称1',1,1,1,'待发货','收货人姓名1','13823888881','车辆编号1','账号1','姓名1','13823888881','公司编号1','公司名称1','是',''),(52,'2022-04-13 09:53:39','订单编号2','路线名称2','货物名称2',2,2,2,'待发货','收货人姓名2','13823888882','车辆编号2','账号2','姓名2','13823888882','公司编号2','公司名称2','是',''),(53,'2022-04-13 09:53:39','订单编号3','路线名称3','货物名称3',3,3,3,'待发货','收货人姓名3','13823888883','车辆编号3','账号3','姓名3','13823888883','公司编号3','公司名称3','是',''),(54,'2022-04-13 09:53:39','订单编号4','路线名称4','货物名称4',4,4,4,'待发货','收货人姓名4','13823888884','车辆编号4','账号4','姓名4','13823888884','公司编号4','公司名称4','是',''),(55,'2022-04-13 09:53:39','订单编号5','路线名称5','货物名称5',5,5,5,'待发货','收货人姓名5','13823888885','车辆编号5','账号5','姓名5','13823888885','公司编号5','公司名称5','是',''),(56,'2022-04-13 09:53:39','订单编号6','路线名称6','货物名称6',6,6,6,'待发货','收货人姓名6','13823888886','车辆编号6','账号6','姓名6','13823888886','公司编号6','公司名称6','是',''),(1649844452657,'2022-04-13 10:07:32','1649844540726','XXXX','xxx',500,80,40000,'已送达','王五','18154541454','111111','111','张三','18154541454','222','XXX','是','已收货');
/*!40000 ALTER TABLE `yundanxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yunshugongsi`
--

DROP TABLE IF EXISTS `yunshugongsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yunshugongsi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gongsibianhao` varchar(200) NOT NULL COMMENT '公司编号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `gongsimingcheng` varchar(200) NOT NULL COMMENT '公司名称',
  `gongsidizhi` varchar(200) DEFAULT NULL COMMENT '公司地址',
  `fuzeren` varchar(200) DEFAULT NULL COMMENT '负责人',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `yingyezhizhao` varchar(200) DEFAULT NULL COMMENT '营业执照',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gongsibianhao` (`gongsibianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1649844177254 DEFAULT CHARSET=utf8 COMMENT='运输公司';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yunshugongsi`
--

LOCK TABLES `yunshugongsi` WRITE;
/*!40000 ALTER TABLE `yunshugongsi` DISABLE KEYS */;
INSERT INTO `yunshugongsi` VALUES (21,'2022-04-13 09:53:39','公司编号1','123456','公司名称1','公司地址1','负责人1','13823888881','upload/yunshugongsi_yingyezhizhao1.jpg'),(22,'2022-04-13 09:53:39','公司编号2','123456','公司名称2','公司地址2','负责人2','13823888882','upload/yunshugongsi_yingyezhizhao2.jpg'),(23,'2022-04-13 09:53:39','公司编号3','123456','公司名称3','公司地址3','负责人3','13823888883','upload/yunshugongsi_yingyezhizhao3.jpg'),(24,'2022-04-13 09:53:39','公司编号4','123456','公司名称4','公司地址4','负责人4','13823888884','upload/yunshugongsi_yingyezhizhao4.jpg'),(25,'2022-04-13 09:53:39','公司编号5','123456','公司名称5','公司地址5','负责人5','13823888885','upload/yunshugongsi_yingyezhizhao5.jpg'),(26,'2022-04-13 09:53:39','公司编号6','123456','公司名称6','公司地址6','负责人6','13823888886','upload/yunshugongsi_yingyezhizhao6.jpg'),(1649844177253,'2022-04-13 10:02:57','222','222','XXX','XXX','李四','18154541454','upload/1649844199193.png');
/*!40000 ALTER TABLE `yunshugongsi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-13 21:11:55
