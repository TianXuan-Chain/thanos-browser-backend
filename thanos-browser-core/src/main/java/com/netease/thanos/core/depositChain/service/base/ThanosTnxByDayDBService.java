package com.netease.thanos.core.depositChain.service.base;

import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.entity.ThanosTnxbyday;
import com.netease.thanos.core.depositChain.entity.ThanosTnxbydayExample;
import com.netease.thanos.core.depositChain.exception.ThanosChainDBException;
import com.netease.thanos.core.depositChain.repository.ThanosTnxbydayMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 类ThanosTnxByDayDBService.java的实现描述：区块 db service
 *
 * @author xuhao create on 2021/1/20 17:39
 */

@Service
@Slf4j
public class ThanosTnxByDayDBService {
    @Autowired
    private ThanosTnxbydayMapper thanosTnxbydayMapper;

    /**
     * 新增记录或者更新记录
     *
     * @param tnxIncr
     * @param date
     * @return
     * @throws ThanosChainDBException
     */
    public boolean createOrModifyWithTnxIncr(Long tnxIncr, Date date) throws ThanosChainDBException {
        try {
            if (tnxIncr == null || date == null) {
                log.warn("ThanosTnxByDayDBService createOrModifyWithTnxIncr miss needed param. tnxIncr:{}, date:{}.", tnxIncr, date);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }

            //先查询，如果已存在，则更新；否则，直接插入新记录
            ThanosTnxbyday tnxbyday = queryByPkDate(date);
            if (tnxbyday == null) {
                tnxbyday = new ThanosTnxbyday();
                tnxbyday.setPkDate(date);
                tnxbyday.setTxnCount(tnxIncr);
                int count = thanosTnxbydayMapper.insert(tnxbyday);
                if (count != 1) {
                    log.error("ThanosTnxByDayDBService insert error! and count:{}.", count);
                    throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
                }
            } else {
                tnxbyday.setTxnCount(tnxbyday.getTxnCount() + tnxIncr);
                int count = thanosTnxbydayMapper.updateByPrimaryKey(tnxbyday);
                if (count != 1) {
                    log.error("ThanosTnxByDayDBService update error! and count:{}.", count);
                    throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
                }
            }
            return true;
        } catch (Exception e) {
            log.error("ThanosTnxByDayDBService createOrModifyWithTnxIncr Exception, tnxIncr:{}, date:{}. e:{}.", tnxIncr, date, e.getMessage());
            throw new ThanosChainDBException("ThanosTnxByDayDBService createOrModifyWithTnxIncr exception.", e);
        }
    }

    public List<ThanosTnxbyday> queryListBySize(Integer size) {
        try {
            if (size == null || size <= 0) {
                log.warn("ThanosTnxByDayDBService queryListBySize with invalid size. size:{}.", size);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosTnxbydayExample example = new ThanosTnxbydayExample();
            example.setOrderByClause("pk_date desc");
            example.withLimit(size);
            return thanosTnxbydayMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("ThanosTnxByDayDBService queryListBySize Exception.size:{}, e:{}.", size, e.getMessage());
            throw new ThanosChainDBException("ThanosTnxByDayDBService queryListBySize exception.", e);
        }
    }

    /**
     * 根据日期查询表中的链信息记录
     *
     * @return
     * @throws ThanosChainDBException
     */
    public ThanosTnxbyday queryByPkDate(Date pkDate) throws ThanosChainDBException {
        try {
            ThanosTnxbydayExample example = new ThanosTnxbydayExample();
            example.createCriteria().andPkDateEqualTo(pkDate);
            List<ThanosTnxbyday> list = thanosTnxbydayMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            log.error("ThanosTnxByDayDBService queryByPkDate Exception. e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosTnxByDayDBService queryByPkDate exception.", e);
        }
    }

    /**
     * 查询最近的有交易的（txnCount > 0）记录
     *
     * @return
     * @throws ThanosChainDBException
     */
    public ThanosTnxbyday queryLastTxnRecord() throws ThanosChainDBException {
        try {
            ThanosTnxbydayExample example = new ThanosTnxbydayExample();
            example.createCriteria().andTxnCountGreaterThan(0L);
            example.setOrderByClause(" pk_date desc");
            example.withLimit(1);
            List<ThanosTnxbyday> list = thanosTnxbydayMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            log.error("ThanosTnxByDayDBService queryLastTxnRecord Exception. e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosTnxByDayDBService queryLastTxnRecord exception.", e);
        }
    }

}
