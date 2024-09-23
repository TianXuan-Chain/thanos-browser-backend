package com.netease.thanos.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 类StarChainTransactionResponseDTO.java 的实现描述: 交易查询分页返回类
 * Created by wangting04 on 2018/08/10
 */
@Getter
@Setter
@ToString
public class TransactionsResponseDTO implements Serializable {
    private List<TransactionInfoResponseDTO> list;
    private long total;  //总条数
    private long pageSize; //每页多少条
    private long pageTotal; //总页数
    private long lastPageSize; //  取最后一页的时候去的pagesize，若没有则按照原先规则

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

    /**
     * 设置最后一页的时候去的pagesize
     */
    public void resetLastPageSize() {
        long size = total % pageSize;
        if(size != 0){
            this.lastPageSize = size;
        }else{
            this.lastPageSize =pageSize;
        }
    }
}