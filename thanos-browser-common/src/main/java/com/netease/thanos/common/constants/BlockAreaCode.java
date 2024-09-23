package com.netease.thanos.common.constants;

import lombok.Getter;

/**
 * 类BlockAreaCode.java 的实现描述: 矿区名称枚举类
 * Created by wangting04 on 2018/08/13
 */
@Getter
public enum BlockAreaCode {
 
    BLOCK_AREA_1(1, "网易区块链"),
    BLOCK_AREA_2(2, "网易区块链"),
    BLOCK_AREA_3(3, "杭州市杭州互联网公证处"),
    BLOCK_AREA_4(4, "杭州市杭州互联网公证处"),
    BLOCK_AREA_5(5, "北京轻信科技有限公司");;

    private int blockAreaId;
    private String blockAreaInfo;

    private BlockAreaCode(int blockAreaId, String blockAreaInfo) {
        this.blockAreaId = blockAreaId;
        this.blockAreaInfo = blockAreaInfo;
    }

    public static String getBlockAreaById(int blockAreaId){
        switch (blockAreaId){
            case 1:
                return BLOCK_AREA_1.blockAreaInfo;
            case 2:
                return BLOCK_AREA_2.blockAreaInfo;
            case 3:
                return BLOCK_AREA_3.blockAreaInfo;
            case 4:
                return BLOCK_AREA_4.blockAreaInfo;
            case 5:
                return BLOCK_AREA_5.blockAreaInfo;
        }
        return null;
    }

}
