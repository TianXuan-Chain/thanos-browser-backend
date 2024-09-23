package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_evidence_point_hashs表数据实体对象
 * 
 * @author db-generator
 * @since 2020年12月27日17:05:35
 */ 
@Data
public class NvDepositEvidencePointHashs extends NvDepositEvidencePointHashsKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 证据点类型
     */
    private Integer evidencePointType;

    /**
     * 证据点编号
     */
    private Long evidencePointId;

    /**
     * 参数名
     */
    private String txDataFileField;

    /**
     * 文件是否主体文件
     */
    private Integer txDataFileIsMain;

    /**
     * hash存证文件名
     */
    private String txDataFileName;

    /**
     * 交易hash
     */
    private String txDataFileFieldHash;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;
}