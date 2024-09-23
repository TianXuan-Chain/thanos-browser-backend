package com.netease.thanos.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockDetailForm {
    /**
     * 区块hash
     */
    private String pkHash;
}
