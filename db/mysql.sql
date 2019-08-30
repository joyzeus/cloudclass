CREATE TABLE `email_config` (
                                `table_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键Id',
                                `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户Id',
                                `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '账户',
                                `account_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '账户类型',
                                `email_type` int(11) NOT NULL DEFAULT '0' COMMENT '邮件类型',
                                `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
                                `creat_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人',
                                PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='邮箱配置';


CREATE TABLE `exception_log` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                 `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类名',
                                 `method_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '方法名',
                                 `exception_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '异常类型',
                                 `exception_msg` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '异常信息',
                                 `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '远程访问主机IP',
                                 `create_userid` int(11) NOT NULL DEFAULT '0' COMMENT '产生人id',
                                 `addtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '异常发生时间',
                                 `view` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否查看，1：未查看、2：已查看',
                                 `view_time` datetime NOT NULL DEFAULT (_utf8mb4'1970-01-01 00:00:00') COMMENT '查看时间',
                                 `view_userid` int(11) NOT NULL DEFAULT '0' COMMENT '查看人id',
                                 `resolve` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否解决',
                                 `resolve_time` datetime NOT NULL DEFAULT (_utf8mb4'1970-01-01 00:00:00') COMMENT '解决时间',
                                 `resolve_userid` int(11) NOT NULL DEFAULT '0' COMMENT '解决人id',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='异常信息日志';


CREATE TABLE `login_log` (
                             `table_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键Id',
                             `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户Id',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '登录IP',
                             `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '登录地址',
                             `device_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '设备类型',
                             `agent_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '代理',
                             `karnel_version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '内核版本',
                             `useragent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '代理详细信息',
                             `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '消息',
                             PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='登录日志';


CREATE TABLE `users` (
                         `table_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一主键Id',
                         `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '账户名称',
                         `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',
                         `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户名',
                         `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '手机号',
                         `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '邮箱',
                         `sex` int(255) NOT NULL DEFAULT '0' COMMENT '性别',
                         `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '头像',
                         `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户Id',
                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

INSERT INTO `manager`.`users`(`table_id`, `account`, `password`, `username`, `mobile`, `email`, `sex`, `icon`, `user_id`, `create_time`, `update_time`) VALUES (1, '13006382305', 'e10adc3949ba59abbe56e057f20f883e', '周旭', '13006382305', '1419982188@qq.com', 1, '', 10000, '2019-08-07 16:31:28', '2019-08-07 16:32:11');



CREATE TABLE `douban_movie` (
                                `movie_id` int(11) NOT NULL AUTO_INCREMENT,
                                `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电影名称',
                                `director` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '导演',
                                `scenarist` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编剧',
                                `actors` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '主演',
                                `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '类型',
                                `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '制片国家/地区',
                                `language` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '语言',
                                `release_date` date NOT NULL DEFAULT '1900-01-01' COMMENT '上映日期',
                                `duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '片长',
                                `rating_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '豆瓣评分',
                                `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标签',
                                PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='豆瓣电影表';



CREATE TABLE `douban_movie_comments` (
                                         `comment_id` int(11) NOT NULL,
                                         `comment_info` text COLLATE utf8mb4_general_ci NOT NULL,
                                         `comment_author` text COLLATE utf8mb4_general_ci NOT NULL,
                                         `commenter_img_url` text COLLATE utf8mb4_general_ci NOT NULL,
                                         `comment-vote` text COLLATE utf8mb4_general_ci NOT NULL,
                                         `comment_movie` text COLLATE utf8mb4_general_ci NOT NULL,
                                         `record_id` text COLLATE utf8mb4_general_ci NOT NULL,
                                         PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='豆瓣电影评论表';

CREATE TABLE `douban_book` (
                               `table_id` int(11) NOT NULL AUTO_INCREMENT,
                               `book_id` int(11) NOT NULL DEFAULT '0',
                               `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
                               `type_id` int(11) NOT NULL DEFAULT '0',
                               `author` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
                               `translator` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
                               `publishing_house` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '出版社',
                               `publish_time` date NOT NULL DEFAULT '1900-01-01' COMMENT '出版时间',
                               `price` decimal(10,2) NOT NULL DEFAULT '0.00',
                               `score` decimal(10,2) NOT NULL DEFAULT '0.00',
                               `rate_count` int(11) NOT NULL DEFAULT '0',
                               `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
                               `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
                               PRIMARY KEY (`table_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11278 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `douban_book_type` (
                                    `table_id` int(11) NOT NULL AUTO_INCREMENT,
                                    `type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
                                    `link` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
                                    `count` int(11) NOT NULL DEFAULT '0',
                                    PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `permission` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `node_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `path` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `parent_id` int(11) NOT NULL DEFAULT '0',
  `has_child` tinyint(4) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0',
  `order_id` int(11) NOT NULL DEFAULT '0',
  `actived` tinyint(4) NOT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `permission_group` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限描述',
  `group_type` int(11) NOT NULL COMMENT '权限组类型',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='权限组/角色';



CREATE TABLE `permission_group_relation` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL DEFAULT '0',
  `group_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `permission_id` int(11) NOT NULL DEFAULT '0',
  `permission_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `user_permission` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `relation_id` int(11) NOT NULL DEFAULT '0' COMMENT '权限Id',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '权限类型',
  `user_id` int(11) NOT NULL COMMENT '用户Id',
  `expired_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '权限有效期',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户权限表';