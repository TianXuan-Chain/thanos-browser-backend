DROP TABLE IF EXISTS `thanos_contract`;
CREATE TABLE `thanos_contract`
(
    `id`                      bigint(20)      NOT NULL AUTO_INCREMENT,
    `contract_address`        varchar(64)     DEFAULT NULL COMMENT '合约地址',
    `contract_protocol`       tinyint(4)      DEFAULT NULL COMMENT '合约协议，1:721 2:1155 -1:未指定',
    `contract_name`           varchar(64)     DEFAULT NULL COMMENT '合约名称',
    `contract_deploy_address` varchar(64)     DEFAULT NULL COMMENT '合约部署者区块链地址',
    `contract_description`    varchar(1024)   DEFAULT NULL COMMENT '合约描述信息',
    `total_limit_supply`      int(11)         DEFAULT '-1' COMMENT '计划发行数量',
    `extend_info`             varchar(1024)   DEFAULT NULL COMMENT '合约，扩展描述信息',
    `create_time`             datetime        DEFAULT NULL,
    `update_time`             timestamp       NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `business_time`           datetime        DEFAULT NULL COMMENT '业务时间：真正发生的时间',
    `version`                 bigint(20)      DEFAULT NULL,
    `remark`                  varchar(512)    DEFAULT NULL COMMENT '描述',
    `is_delete`               tinyint(2)      DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `contract_address` (`contract_address`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT ='浏览器-合约信息表';


DROP TABLE IF EXISTS `thanos_contract_transaction`;
CREATE TABLE `thanos_contract_transaction` (
  `id`                          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `contract_address`            varchar(64) COLLATE utf8_bin NOT NULL COMMENT '合约地址',
  `pk_hash`                     varchar(128) NOT NULL COMMENT '交易hash值',
  `partition_key`               bigint(20) NOT NULL COMMENT '交易时间Key',
  `tx_detail`                   text CHARACTER SET utf8 COMMENT '交易详情',
  `create_time`                 datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`                 timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `business_time`               datetime DEFAULT NULL COMMENT '业务时间',
  `version`                     bigint(20) DEFAULT '1' COMMENT '版本号',
  `remark`                      varchar(512) DEFAULT NULL COMMENT '备注',
  `is_delete`                   tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`, `contract_address`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='浏览器-合约交易表'
/*!50100 PARTITION BY KEY (contract_address)
PARTITIONS 63 */;