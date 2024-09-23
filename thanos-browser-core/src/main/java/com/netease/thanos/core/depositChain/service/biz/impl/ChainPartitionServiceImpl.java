package com.netease.thanos.core.depositChain.service.biz.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.netease.thanos.common.utils.DateUtil;
import com.netease.thanos.core.depositChain.exception.ThanosChainBizException;
import com.netease.thanos.core.depositChain.service.biz.ChainPartitionService;
import com.netease.thanos.core.depositChain.util.PartitionKeyUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChainPartitionServiceImpl implements ChainPartitionService {

    
    @Resource
    private DataSource nvDataSource;
    
	
	@Override
	public void checkAndAddPartition() {
        Connection nvConnection = null;
        Statement nvStatement = null;
        try {
            nvConnection = nvDataSource.getConnection();
            nvStatement = addPartitionKey(nvConnection);               
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error( "checkAndAddPartition failed.", e);
            throw new ThanosChainBizException("checkAndAddPartition exception.", e);
        } finally {
            
            if (nvStatement != null) {
                try {
                	nvStatement.close();
                } catch (Exception e) {
                }
            }
            if (nvConnection != null) {
                try {
                	nvConnection.close();
                } catch (Exception e) {
                }
            }
        }
    }
	
	

	private Statement addPartitionKey(Connection connection) throws Exception {
		Statement statement;
		statement = connection.createStatement();
		boolean res = false;
		//======thanos_evm_transaction===
		String tableName = "thanos_evm_transaction";
		try {
		    Long tomorrow = PartitionKeyUtil.getPartitionKey(DateUtil.getDateAfterDay(new Date(), 1));
		    String sql = "ALTER TABLE " + tableName + " ADD PARTITION(PARTITION p" + tomorrow + " VALUES LESS THAN (" + tomorrow + ") ENGINE = InnoDB);";
		    log.info("checkAndAddPartition start add tomorrow partition. date:{}.", tomorrow);
		    res = statement.execute(sql);
		} catch (Exception e) {
		    String errorMsg = e.getMessage();
		    if (StringUtils.isBlank(errorMsg) || !errorMsg.contains("Duplicate partition")) {
		        log.error("addPartitionKey add tomorrow partition failed.tableName={}",tableName, e);
		        throw new ThanosChainBizException("ChainPartitionServiceImpl checkAndAddPartition add tomorrow partition exception.", e);
		    }
		}
		log.info("thanos_evm_transaction checkAndAddPartition add tomorrow partition down, res:{}.", res);
		return statement;
	}

}
