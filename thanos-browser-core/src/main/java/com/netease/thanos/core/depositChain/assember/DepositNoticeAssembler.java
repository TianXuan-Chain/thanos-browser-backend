package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositNoticeDTO;
import com.netease.thanos.core.depositChain.bo.BcNotice;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 类StarNoticeAssembler.java 的实现描述:
 * @Author kingkong create on 2018-08-28
 */
public class DepositNoticeAssembler {

    public static List<DepositNoticeDTO> bo2Dtos(List<BcNotice> notices) {
        if (CollectionUtils.isEmpty(notices)) {
            return Collections.EMPTY_LIST;
        }

        List<DepositNoticeDTO> result = new ArrayList<>();
        for (BcNotice source : notices) {
            DepositNoticeDTO dest = DepositNoticeDTO.builder()
                    .businessTime(source.getBusinessTime())
                    .createTime(source.getCreateTime())
                    .createUser(source.getCreateUser())
                    .id(source.getId())
                    .ifOnline(source.getIfOnline())
                    .version(source.getVersion())
                    .noticeInfo(source.getNoticeInfo())
                    .remark(source.getRemark()).build();
            result.add(dest);
        }
        return result;
    }

}
