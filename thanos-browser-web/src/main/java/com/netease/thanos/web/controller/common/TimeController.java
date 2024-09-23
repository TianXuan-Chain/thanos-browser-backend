package com.netease.thanos.web.controller.common;

import com.netease.thanos.api.dto.thanos.ThanosContractDTO;
import com.netease.thanos.report.job.thanos.BlockTnxReporterHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kingkong on 2018/2/26.
 */
@Controller
@RequestMapping(value = {"/time"})
@Slf4j
public class TimeController {

    @Autowired
    private BlockTnxReporterHandler blockTnxReporterHandler;

    @RequestMapping(value = "/doBlockTxnReporter", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String doBlockTxnReporter() {
        blockTnxReporterHandler.doHandle();
        return "1";
    }


    @RequestMapping(value = "/handleContractDetail", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String handleContractDetail(@RequestParam String contractAddress) {
        ThanosContractDTO thanosContractDTO = new ThanosContractDTO();
        thanosContractDTO.setContractAddress(contractAddress);
        List<ThanosContractDTO> thanosContractDTOList = Arrays.asList(thanosContractDTO);

        blockTnxReporterHandler.handleContractDetail(thanosContractDTOList);
        return "1";
    }

}

