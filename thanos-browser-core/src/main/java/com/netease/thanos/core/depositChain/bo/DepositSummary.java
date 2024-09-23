package com.netease.thanos.core.depositChain.bo;

import java.util.List;

@lombok.Data
public class DepositSummary {
	
    private String node;
    private String unifiedEvidenceCode;
    private String depositMethod;
    private String depositType;
    private List<Integer> blockHeight;
    private Integer depositEventNo;
    private Integer depositFileNo;
    private String txHash;
    
    private Long  depositTimeBegin;    
    private Long  depositTimeEnd;
}
