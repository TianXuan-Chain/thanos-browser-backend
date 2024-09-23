package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_system_config表数据实体对象
 * 
 * @author db-generator
 * @since 2022年10月08日11:25:34
 */ 
@Data
public class NvSystemConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String configKey;

    /**
     * 配置描述
     */
    private String configDesc;

    private Date createTime;

    /**
     * 业务时间：真正发生的时间
     */
    private Date businessTime;

    private Long version;

    /**
     * 描述
     */
    private String remark;

    private String configValue;
}