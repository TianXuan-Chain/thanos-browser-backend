package com.netease.thanos.core.depositChain.bo;

import java.util.List;

import com.netease.thanos.core.depositChain.bo.NvEvidenceChainDefineBo.FuncNameDefine;

@lombok.Data
public class EcDefine {
    private Boolean end;
    private List<FuncNameDefine> funcNameDefine;
    private Boolean start;
}

// FuncNameDefine.java

