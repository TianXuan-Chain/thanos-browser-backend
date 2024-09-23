package com.netease.thanos.api.commom;

/**
 * 
 * 类StarErrorCodeDTO.java的实现描述：星球错误码
 * @author hzcaochongrui 2018年5月22日 下午4:49:55
 */
public enum NBassErrorCodeDTO {

    //********常用错误码********
    OK("00", "请求接口成功"),
    NET_ERROR("01", "网络异常"),
    MISS_NEEDED_PARA("02", "缺失必要参数"),
    SYSTEM_ERROR("03", "系统繁忙，请稍候再试"),
    DATABASE_ERROR("04", "数据库异常"),
    PARAMETER_ERROR("05", "参数错误"),
    REPEAT_OPERATION("06","重复操作"),   
    EXECUTE_FAIL("07","执行失败"),
    EXECUTE_SUCCESS("08","执行成功"),

    EXECUTE_FAIL_NO_RETRY("09","执行失败不可重试"),
    EXECUTE_FAIL_CAN_RETRY("10","执行失败可重试"),
    EXECUTE_FAIL_NO_DATAY("11","未查询到数据");




    // 错误码
    private String    code;
    // 错误码描述
    private String desc;

    NBassErrorCodeDTO(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    
    public String getCode() {
        return code;
    }

    
    public void setCode(String code) {
        this.code = code;
    }

    
    public String getDesc() {
        return desc;
    }

    
    public void setDesc(String desc) {
        this.desc = desc;
    }

    
}
