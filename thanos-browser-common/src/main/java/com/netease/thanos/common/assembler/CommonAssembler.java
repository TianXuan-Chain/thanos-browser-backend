package com.netease.thanos.common.assembler;

import org.apache.commons.lang3.StringUtils;

import com.netease.thanos.common.dto.ThanosErrorCodeDTO;

/**
 * 类ThanosErrorCodeDTO.java的实现描述：公共转换器转换器
 *
 * @author hzcaochongrui 2019年5月21日 下午4:08:05
 */
public class CommonAssembler {

    /**
     * ThanosErrorCode 转换成 ThanosErrorCodeDTO
     *
     * @param
     * @return
     */
    public static ThanosErrorCodeDTO errorCode2DTO(String errorCode) {

        if (StringUtils.isEmpty(errorCode)) {
            return ThanosErrorCodeDTO.SYSTEM_ERROR;
        }

        /**
         * 区块链团队内系统的问题统一对外封装为系统问题
         */
        if (errorCode.equals("0007") || errorCode.equals("0005")) {
            return ThanosErrorCodeDTO.SYSTEM_ERROR;
        }
        /**
         * 通用对外异常
         */
        if (errorCode.equals("0001")) {
            return ThanosErrorCodeDTO.NET_ERROR;
        }
        if (errorCode.equals("0002")) {
            return ThanosErrorCodeDTO.MISS_NEEDED_PARA;
        }
        if (errorCode.equals("0003")) {
            return ThanosErrorCodeDTO.PARAMETER_ERROR;
        }
        if (errorCode.equals("0004")) {
            return ThanosErrorCodeDTO.REPERT;
        }
        if (errorCode.equals("0006")) {
            return ThanosErrorCodeDTO.INTERFACE_OVERTIME;
        }

        if (errorCode.equals("0008")) {
            return ThanosErrorCodeDTO.FAIL;
        }

        return ThanosErrorCodeDTO.SYSTEM_ERROR;
    }
}
