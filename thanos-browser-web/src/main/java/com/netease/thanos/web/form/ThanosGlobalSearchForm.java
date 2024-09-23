package com.netease.thanos.web.form;

import lombok.Data;

/**
 * 类GlobalSearchForm.java的实现描述：全局搜索form
 *
 * @author xuhao create on 2021/2/4 11:17
 */

@Data
public class ThanosGlobalSearchForm extends PageQueryForm {
    /**
     * 查询条件字符串
     */
    String search;
}
