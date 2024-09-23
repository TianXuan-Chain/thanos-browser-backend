package com.netease.thanos.web.form;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TxnCountForm {
    private static final long serialVersionUID = -8445430254929212861L;
    /**
     * 查询天数
     */
    Integer size;
}
