package com.netease.thanos.core.depositChain.bo;

import lombok.Data;

import java.util.List;

@Data
public class NvEvidenceChainDefineBo {

    private List<FuncDefine> objectFuncList;
    private List<FuncDefine> corporationFuncList;
    private List<FuncDefine> userFuncList;

    @Data
    public static class FuncDefine {
        private List<FuncNameDefine> funcNameDefine;
        private Boolean start;
        private Boolean end;
    }

    @Data
    public static class FuncNameDefine {
        private String funName;
        private String chineseName;
    }

}
