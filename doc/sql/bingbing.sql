CREATE DATABASE `bingbing`CHARACTER SET utf8 COLLATE utf8_bin; 

USE `bingbing`; 

CREATE TABLE `bingbing`.`t_user_info`(  
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` VARCHAR(60) NOT NULL COMMENT '姓名',
  `nickname` VARCHAR(60) COMMENT '昵称',
  `age` INT COMMENT '年龄',
  `birthday` DATE COMMENT '生日',
  `mobile` VARCHAR(20) COMMENT '手机号码',
  `id_no` VARCHAR(30) COMMENT '身份证号码',
  `is_valid` CHAR(1) DEFAULT '1'  COMMENT '是否有效0无效1有效',
  `creat_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
  `update_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  COMMENT '更新时间',
  `creat_user` VARCHAR(60) DEFAULT 'system'  COMMENT '创建人',
  `update_user` VARCHAR(60) DEFAULT 'system'  COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_bin
COMMENT='用户信息表';

ALTER TABLE `bingbing`.`t_user_info`   
  ADD  UNIQUE INDEX `uidex_user_info_id_no` (`id_no`);



CREATE TABLE `bingbing`.`t_card_info`(  
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` BIGINT NOT NULL COMMENT '用户id',
  `card_no` VARCHAR(30) NOT NULL COMMENT '卡号',
  `card_name` VARCHAR(60) COMMENT '卡名称',
  `amt` DECIMAL COMMENT '卡余额',
  `is_valid` CHAR(1) DEFAULT '1'  COMMENT '0无效1有效',
  `creat_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
  `update_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  COMMENT '更新时间',
  `creat_user` VARCHAR(60) DEFAULT 'system'  COMMENT '创建人',
  `update_user` VARCHAR(60) DEFAULT 'system'  COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_bin
COMMENT='用户绑卡卡信息表';



