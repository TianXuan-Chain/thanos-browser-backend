package com.netease.thanos.report.task;

import com.netease.thanos.report.job.thanos.BlockTnxReporterHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BlockExportTask {

    @Autowired
    private BlockTnxReporterHandler blockTnxReporterHandler;


    @Scheduled(cron = "0/15 * * * * ?")
    public void doBlockTxnReporter() {
        log.info("BlockExportTask.doBlockTxnReporter start");
        blockTnxReporterHandler.doHandle();
    }
}
