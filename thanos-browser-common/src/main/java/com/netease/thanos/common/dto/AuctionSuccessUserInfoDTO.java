package com.netease.thanos.common.dto;

import java.io.Serializable;


public class AuctionSuccessUserInfoDTO   implements Serializable {
   
    /**
     * 
     */
    private static final long serialVersionUID = -9062250796940816679L;
    private String trueName;
    private  String address;
    private  String mobilePhone;
    private  String email;
    private String auctionGoodsId;
    private  String userNumber;
    
    private Integer matchAution;
    
    public String getTrueName() {
        return trueName;
    }
    
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getMobilePhone() {
        return mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAuctionGoodsId() {
        return auctionGoodsId;
    }
    
    public void setAuctionGoodsId(String auctionGoodsId) {
        this.auctionGoodsId = auctionGoodsId;
    }

    
    public String getUserNumber() {
        return userNumber;
    }

    
    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    
    public Integer getMatchAution() {
        return matchAution;
    }

    
    public void setMatchAution(Integer matchAution) {
        this.matchAution = matchAution;
    }

  
    
    
}
