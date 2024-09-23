package com.netease.thanos.report.task;

import com.netease.thanos.core.depositChain.service.biz.ChainPartitionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DbParititionCheckAndAddTask {

    @Autowired
    private ChainPartitionService chainPartitionService;

    @Scheduled(cron = "0 5 0 * * ?")
    public void doCheckAndAddPartition() {
        log.info("DbParititionCheckAndAddTask.doCheckAndAddPartition start");
        chainPartitionService.checkAndAddPartition();
    }
}
