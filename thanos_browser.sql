
-- ----------------------------
-- Table structure for thanos_block
-- ----------------------------
DROP TABLE IF EXISTS `thanos_block`;
CREATE TABLE `thanos_block`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `pk_hash` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '块hash值',
  `number` bigint(20) NOT NULL COMMENT '高度',
  `event_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '事件id',
  `pre_event_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父事件id',
  `epoch` bigint(20) NULL DEFAULT NULL COMMENT '共识时期',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `evm_tnx_num` bigint(20) NULL DEFAULT NULL COMMENT '块包含的交易数',
  `global_event_num` bigint(20) NULL DEFAULT NULL COMMENT '块包含的交易数',
  `detail_info` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'rpc查询结果的所有数据',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) NULL DEFAULT 0 COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_hash`(`pk_hash`) USING BTREE,
  UNIQUE INDEX `idx_number`(`number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '天玄链区块信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thanos_blockChainInfo
-- ----------------------------
DROP TABLE IF EXISTS `thanos_blockChainInfo`;
CREATE TABLE `thanos_blockChainInfo`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `last_block_num` bigint(20) NULL DEFAULT NULL COMMENT '最新块高',
  `txn_count` bigint(20) NULL DEFAULT NULL COMMENT '交易量',
  `epoch` bigint(20) NULL DEFAULT NULL COMMENT '共识纪元',
  `round` bigint(20) NULL DEFAULT NULL COMMENT '当前共识轮数',
  `avg_time` decimal(5, 2) NULL DEFAULT NULL COMMENT '相邻两个块的timestamp之差的平均值',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) NULL DEFAULT 0 COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '天玄链全局信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thanos_contract
-- ----------------------------
DROP TABLE IF EXISTS `thanos_contract`;
CREATE TABLE `thanos_contract`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '合约地址',
  `contract_protocol` tinyint(4) NULL DEFAULT NULL COMMENT '合约协议，1:721 2:1155 -1:未指定',
  `contract_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '合约名称',
  `contract_deploy_address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '合约部署者区块链地址',
  `contract_description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '合约描述信息',
  `total_limit_supply` int(11) NULL DEFAULT -1 COMMENT '计划发行数量',
  `extend_info` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '合约，扩展描述信息',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `business_time` datetime NULL DEFAULT NULL COMMENT '业务时间：真正发生的时间',
  `version` bigint(20) NULL DEFAULT NULL,
  `remark` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `contract_address`(`contract_address`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '浏览器-合约信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thanos_contract_transaction
-- ----------------------------
DROP TABLE IF EXISTS `thanos_contract_transaction`;
CREATE TABLE `thanos_contract_transaction`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `contract_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '合约地址',
  `pk_hash` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '交易hash值',
  `partition_key` bigint(20) NOT NULL COMMENT '交易时间Key',
  `tx_detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '交易详情',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `business_time` datetime NULL DEFAULT NULL COMMENT '业务时间',
  `version` bigint(20) NULL DEFAULT 1 COMMENT '版本号',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  `is_delete` tinyint(2) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`, `contract_address`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '浏览器-合约交易表' ROW_FORMAT = Dynamic PARTITION BY KEY (`contract_address`)
PARTITIONS 63
(PARTITION `p0` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p1` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p10` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p11` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p12` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p13` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p14` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p15` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p16` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p17` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p18` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p19` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p2` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p20` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p21` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p22` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p23` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p24` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p25` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p26` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p27` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p28` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p29` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p3` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p30` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p31` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p32` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p33` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p34` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p35` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p36` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p37` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p38` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p39` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p4` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p40` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p41` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p42` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p43` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p44` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p45` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p46` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p47` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p48` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p49` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p5` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p50` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p51` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p52` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p53` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p54` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p55` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p56` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p57` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p58` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p59` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p6` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p60` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p61` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p62` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p7` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p8` MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p9` MAX_ROWS = 0 MIN_ROWS = 0 )
;

-- ----------------------------
-- Table structure for thanos_evm_transaction
-- ----------------------------
DROP TABLE IF EXISTS `thanos_evm_transaction`;
CREATE TABLE `thanos_evm_transaction`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `partition_key` bigint(20) NOT NULL,
  `pk_hash` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易hash值',
  `block_hash` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '块hash值',
  `block_number` bigint(20) NULL DEFAULT NULL COMMENT '块高',
  `block_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '区块生成时间',
  `transaction_index` bigint(20) NULL DEFAULT NULL COMMENT '交易下标',
  `transaction_type` tinyint(2) NULL DEFAULT NULL COMMENT '交易类型，1合约部署，2合约调用',
  `transaction_from` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发起地址',
  `transaction_to` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收地址',
  `gas_limit` bigint(20) NULL DEFAULT NULL COMMENT 'gas限制',
  `gas_price` decimal(30, 8) NULL DEFAULT NULL COMMENT 'gas价格',
  `random_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易nonce值',
  `contract_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合约地址',
  `contract_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合约名',
  `contract_version` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合约版本',
  `method` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被调用的合约中的函数名',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '被调用的函数的参数',
  `input_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '交易调用字符串',
  `dag_execute_status` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '交易dag执行状态',
  `biz_data` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上链事件hash',
  `trade_stat` int(11) NULL DEFAULT 1 COMMENT '交易链上执行状态：1成功， 0失败',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`, `partition_key`) USING BTREE,
  UNIQUE INDEX `idx_hash_partition_key`(`pk_hash`, `partition_key`) USING BTREE,
  INDEX `idx_number`(`block_number`, `partition_key`) USING BTREE,
  INDEX `idx_from`(`transaction_from`, `partition_key`) USING BTREE,
  INDEX `idx_hash`(`pk_hash`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '天玄链EVM交易信息表' ROW_FORMAT = Dynamic PARTITION BY RANGE (partition_key)
PARTITIONS 1
(PARTITION `p20240701` VALUES LESS THAN (20240701) ENGINE = InnoDB MAX_ROWS = 0 MIN_ROWS = 0)
;

-- ----------------------------
-- Table structure for thanos_evm_transactionReceipt
-- ----------------------------
DROP TABLE IF EXISTS `thanos_evm_transactionReceipt`;
CREATE TABLE `thanos_evm_transactionReceipt`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `transaction_hash` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易hash值',
  `block_hash` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '块hash值',
  `block_number` bigint(20) NULL DEFAULT NULL COMMENT '块高',
  `transaction_index` bigint(20) NULL DEFAULT NULL COMMENT '交易顺序',
  `gas_used` bigint(20) NULL DEFAULT NULL COMMENT '已用gas',
  `logs` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'logs信息',
  `error` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '错误信息',
  `execution_result` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '执行结果，16进制字符串',
  `detail_info` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'rpc查询结果的所有数据',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) NULL DEFAULT 0 COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_hash`(`transaction_hash`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '天玄链交易回执信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thanos_global_event
-- ----------------------------
DROP TABLE IF EXISTS `thanos_global_event`;
CREATE TABLE `thanos_global_event`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `event_hash` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '事件hash值',
  `block_hash` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '块hash值',
  `block_number` bigint(20) NULL DEFAULT NULL COMMENT '块高',
  `sender_address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件发起者',
  `nonce` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'nonce值',
  `command_code` int(11) NULL DEFAULT NULL COMMENT '事件类型码： 0-注册 1-退出',
  `raw_data` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '事件数据（未解析）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) NULL DEFAULT 0 COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_event_hash`(`event_hash`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '天玄链全局事件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thanos_tnxByDay
-- ----------------------------
DROP TABLE IF EXISTS `thanos_tnxByDay`;
CREATE TABLE `thanos_tnxByDay`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `pk_date` date NOT NULL COMMENT '交易时间',
  `txn_count` bigint(20) NULL DEFAULT NULL COMMENT '交易量',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) NULL DEFAULT 0 COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_pk_date`(`pk_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '天玄链每日交易量记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for create_time_partition
-- ----------------------------
DROP PROCEDURE IF EXISTS `create_time_partition`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `create_time_partition`()
BEGIN
    DECLARE start_date DATETIME DEFAULT DATE_ADD(CURDATE(), INTERVAL -60 DAY);
    DECLARE end_date DATETIME DEFAULT DATE_ADD(CURDATE(), INTERVAL 1 DAY);
    DECLARE partition_name VARCHAR(32); -- 设定一个合适的长度
    DECLARE partition_date INT; -- 每个分区的日期字符串

    WHILE start_date <= end_date DO
        -- 格式化日期为 YYYYMMDD
        SET partition_date = DATE_FORMAT(start_date, '%Y%m%d');
        SET partition_name = CONCAT('p', partition_date);
        
        -- 使用PREPARE语句来执行动态 SQL
        SET @sql = CONCAT('ALTER TABLE thanos_evm_transaction ADD PARTITION (PARTITION ', partition_name, ' VALUES LESS THAN (', partition_date, '))');
        PREPARE stmt FROM @sql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
        
        -- 递增日期
        SET start_date = DATE_ADD(start_date, INTERVAL 1 DAY);
    END WHILE;
END
;;
delimiter ;

call create_time_partition();

SET FOREIGN_KEY_CHECKS = 1;
