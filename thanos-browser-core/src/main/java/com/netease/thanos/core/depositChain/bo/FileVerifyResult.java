package com.netease.thanos.core.depositChain.bo;

@lombok.Data
public class FileVerifyResult {
	//ok for success , fail for fail
    private String verifyResult;
    private DepositSummary depositSummary;
    private DepositMainFile depositMainFile;
    private DepositEventData depositEventData;
    
    public static FileVerifyResult fail() {
    	FileVerifyResult r=new FileVerifyResult();
		r.setVerifyResult("fail");
		return r;
    }
}

// DepositEventData.java

