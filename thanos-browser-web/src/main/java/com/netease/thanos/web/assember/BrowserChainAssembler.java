package com.netease.thanos.web.assember;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.netease.thanos.api.dto.request.BlockQueryStepConditionReqDTO;
import com.netease.thanos.api.dto.request.TnxQueryStepCoditionReqDTO;
import com.netease.thanos.web.form.BlockQueryConditionForm;
import com.netease.thanos.web.form.TxnsQueryConditionForm;
/**
 * @Author lyy create on 2018-06-02
 */
public class BrowserChainAssembler {

    public static int DEFAULT_PAGE_SIZE = 10;

    public static int DEFAULT_CURRENT_PAGE = 1;

    public static BlockQueryStepConditionReqDTO blockQueryConditionForm2BlockQueryStepConditionReqDTO(BlockQueryConditionForm form) {
        BlockQueryStepConditionReqDTO req = new BlockQueryStepConditionReqDTO();

        if (!StringUtils.isEmpty(form.getPkHash())) {
            req.setPkHash(form.getPkHash());
        }

        req.setNumber(form.getNumber());

        if (form.getPageSize() != null) {
            req.setPageSize(form.getPageSize());
        } else {
            form.setPageSize(DEFAULT_PAGE_SIZE);
            req.setPageSize(DEFAULT_PAGE_SIZE);
        }

        req.setStartId(form.getStartId());
        req.setType(form.getType());
        req.setLastPageSize(form.getLastPageSize());

        return req;
    }

    private static final String TRANSFER_SIGN = "0xa9059cbb";


    private static String getTimeStrFrom(Long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(timestamp));
    }

    private static int getOffsetBy(int pageSize, int currentPage) {
        int offset = (currentPage - 1) * pageSize;
        return offset;
    }

    public static void main(String[] args) {

        System.out.println(getTimeStrFrom(System.currentTimeMillis()));
    }

    public static TnxQueryStepCoditionReqDTO txnsQueryConditionForm2TxnQueryStepConditionReqDTO(TxnsQueryConditionForm form) {
        TnxQueryStepCoditionReqDTO req = new TnxQueryStepCoditionReqDTO();

        if (form.getPageSize() != null) {
            req.setPageSize(form.getPageSize());
        } else {
            req.setPageSize(DEFAULT_PAGE_SIZE);
            form.setPageSize(DEFAULT_PAGE_SIZE);
        }

        if (!StringUtils.isEmpty(form.getBcAddress())) {
            req.setBcAddress(form.getBcAddress());
        }
        if (form.getBlockNumber() != null && form.getBlockNumber() > 0) {
            req.setBlockNumber(form.getBlockNumber());
        }
        req.setType(form.getType());
        req.setTxnHash(form.getPkHash());
        req.setStartId(form.getStartId());
        req.setStartBlockNumber(form.getStartBlockNumber());
        req.setLastPageSize(form.getLastPageSize());
        req.setBizData(form.getBizData());

        return req;
    }

 

 
}
