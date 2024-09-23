package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_ec_files表数据实体对象
 * 
 * @author db-generator
 * @since 2020年12月23日15:59:18
 */ 
@Data
public class NvDepositEcFiles implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Long id;

    /**
     * 证据文件
     */
    private String uniqueNumber;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件类型
     */
    private Integer fileType;

    /**
     * 文件hash
     */
    private String fileHash;

    /**
     * 父文件名
     */
    private String parentFile;

    /**
     * 文件加密密钥
     */
    private String txId;

    /**
     * 文件存储地址
     */
    private String txHash;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;

}