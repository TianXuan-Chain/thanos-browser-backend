package com.netease.thanos.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类GlobalSearchResponseDTO.java 的实现描述:
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class GlobalSearchResponseDTO implements Serializable {
    private int type;//1为交易， 2为块
    private Object list;
    private long total;
    private String searchType;
    private String searchValue;
    private long pageSize; //每页多少条
    private long pageTotal; //总页数

    public void resetPageSize() {
        if (total == 0 || pageSize == 0) {
            return;
        }
        long t = total / pageSize;
        if (total % pageSize != 0) {
            t += 1;
        }
        this.pageTotal = t;
    }
}
