drop table if exists thanos_blockChainInfo;
CREATE TABLE `thanos_blockChainInfo`
(
  `id`             bigint(20) NOT NULL auto_increment COMMENT '主键ID',
  `last_block_num` bigint(20)                      DEFAULT NULL COMMENT '最新块高',
  `txn_count`      bigint(20)                      DEFAULT NULL COMMENT '交易量',
  `epoch`          bigint(20)                      DEFAULT NULL COMMENT '共识纪元',
  `round`          bigint(20)                      DEFAULT NULL COMMENT '当前共识轮数',
  `avg_time`       decimal(5, 2)                   DEFAULT NULL COMMENT '相邻两个块的timestamp之差的平均值',
  `create_time`    datetime   NOT NULL COMMENT '创建时间',
  `update_time`    timestamp  NOT NULL             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='天玄链全局信息表';

drop table if exists thanos_tnxByDay;
CREATE TABLE `thanos_tnxByDay`
(
  `id`          bigint(20) NOT NULL auto_increment COMMENT '主键ID',
  `pk_date`     date   NOT NULL COMMENT '交易时间',
  `txn_count`   bigint(20)                      DEFAULT NULL COMMENT '交易量',
  `create_time` datetime   NOT NULL COMMENT '创建时间',
  `update_time` timestamp  NOT NULL             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_pk_date` (`pk_date`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='天玄链每日交易量记录表';


drop table if exists thanos_block;
CREATE TABLE `thanos_block`
(
  `id`               bigint(20)   NOT NULL auto_increment COMMENT '主键ID',
  `pk_hash`             varchar(128) NOT NULL COMMENT '块hash值',
  `number`           bigint(20)   NOT NULL COMMENT '高度',
  `event_id`         varchar(128) NOT NULL COMMENT '事件id',
  `pre_event_id`     varchar(128) NOT NULL COMMENT '父事件id',
  `epoch`            bigint(20)            DEFAULT NULL COMMENT '共识时期',
  `timestamp`        timestamp COMMENT '时间戳',
  `evm_tnx_num`      bigint(20)            DEFAULT NULL COMMENT '块包含的交易数',
  `global_event_num` bigint(20)            DEFAULT NULL COMMENT '块包含的交易数',
  `detail_info`      longtext COMMENT 'rpc查询结果的所有数据',
  `create_time`      datetime     NOT NULL COMMENT '创建时间',
  `update_time`      timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hash` (`pk_hash`),
  UNIQUE KEY `idx_number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='天玄链区块信息表';

drop table if exists thanos_evm_transactionReceipt;
CREATE TABLE `thanos_evm_transactionReceipt`
(
  `id`                bigint(20)   NOT NULL auto_increment COMMENT '主键ID',
  `transaction_hash`  varchar(128) NOT NULL COMMENT '交易hash值',
  `block_hash`        varchar(128)          DEFAULT NULL COMMENT '块hash值',
  `block_number`      bigint(20)            DEFAULT NULL COMMENT '块高',
  `transaction_index` bigint(20)            DEFAULT NULL COMMENT '交易顺序',
  `gas_used`          bigint(20)            DEFAULT NULL COMMENT '已用gas',
  `logs`              longtext COMMENT 'logs信息',
  `error`             longtext              DEFAULT NULL COMMENT '错误信息',
  `execution_result`  longtext COMMENT '执行结果，16进制字符串',
  `detail_info`       longtext COMMENT 'rpc查询结果的所有数据',
  `create_time`       datetime     NOT NULL COMMENT '创建时间',
  `update_time`       timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hash` (`transaction_hash`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='天玄链交易回执信息表';

drop table if exists thanos_global_event;
CREATE TABLE `thanos_global_event`
(
  `id`           bigint(20)   NOT NULL auto_increment COMMENT '主键ID',
  `event_hash`   varchar(128) NOT NULL COMMENT '事件hash值',
  `block_hash`   varchar(128)          DEFAULT NULL COMMENT '块hash值',
  `block_number` bigint(20)            DEFAULT NULL COMMENT '块高',
  `sender_address`    varchar(256)          DEFAULT NULL COMMENT '事件发起者',
  `nonce`        varchar(128)          DEFAULT NULL COMMENT 'nonce值',
  `command_code`   int(11)               DEFAULT NULL COMMENT '事件类型码： 0-注册 1-退出',
  `raw_data`     longtext               DEFAULT NULL COMMENT '事件数据（未解析）',
  `create_time`  datetime     NOT NULL COMMENT '创建时间',
  `update_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '1:删除；0:正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_event_hash` (`event_hash`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='天玄链全局事件表';

drop table if exists thanos_evm_transaction;
CREATE TABLE `thanos_evm_transaction`
(
  `id`                bigint(20)   NOT NULL auto_increment COMMENT '主键ID',
  `partition_key` bigint(20) NOT NULL,
  `pk_hash`              varchar(128) NOT NULL COMMENT '交易hash值',
  `block_hash`        varchar(128)          DEFAULT NULL COMMENT '块hash值',
  `block_number`      bigint(20)            DEFAULT NULL COMMENT '块高',
  `block_timestamp`   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '区块生成时间',
  `transaction_index` bigint(20)            DEFAULT NULL COMMENT '交易下标',
  `transaction_type` tinyint(2) DEFAULT NULL COMMENT '交易类型，1合约部署，2合约调用',
  `transaction_from`  varchar(64)           DEFAULT NULL COMMENT '发起地址',
  `transaction_to`    varchar(64)           DEFAULT NULL COMMENT '接收地址',
  `gas_limit`         bigint(20)            DEFAULT NULL COMMENT 'gas限制',
  `gas_price`         decimal(30, 8)        DEFAULT NULL COMMENT 'gas价格',
  `random_id`         varchar(128)          DEFAULT NULL COMMENT '交易nonce值',
  `contract_address`  varchar(128)          DEFAULT NULL COMMENT '合约地址',
  `contract_name`     varchar(128)          DEFAULT NULL COMMENT '合约名',
  `contract_version`  varchar(256)          DEFAULT NULL COMMENT '合约版本',
  `method`            varchar(256)          DEFAULT NULL COMMENT '被调用的合约中的函数名',
  `params`            text COMMENT '被调用的函数的参数',
  `input_text`        text COMMENT '交易调用字符串',
  `dag_execute_status` text COMMENT '交易dag执行状态',
  `biz_data` varchar(255) DEFAULT NULL COMMENT '上链事件hash',
  `trade_stat` int(11) DEFAULT '1' COMMENT '交易链上执行状态：1成功， 0失败',
  `create_time`       datetime     NOT NULL COMMENT '创建时间',
  `update_time`       timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `remark` varchar(512) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`,`partition_key`),
  UNIQUE KEY `idx_hash_partition_key` (`pk_hash`,`partition_key`),
  KEY `idx_number` (`block_number`, `partition_key`),
  KEY `idx_from` (`transaction_from`, `partition_key`),
  KEY `idx_hash` (`pk_hash`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='天玄链EVM交易信息表'
/*!50100 PARTITION BY RANGE (partition_key)
(PARTITION p20230615 VALUES LESS THAN(20230615) ENGINE = InnoDB)*/;

