package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainBlockDTO;
import com.netease.thanos.api.dto.response.BlockInfoResponseDTO;
import com.netease.thanos.api.dto.response.LotteryBlockResponseDTO;
import com.netease.thanos.common.constants.BlockAreaCode;
import com.netease.thanos.core.depositChain.bo.BcBlockBO;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */

public class DepositChainBlockAssembler {

    public static BcBlockBO dto2Bo(DepositChainBlockDTO source) {
        BcBlockBO dest = new BcBlockBO();
        //BeanUtils.copyProperties(source, dest);
        dest.setAvgGasPrice(source.getAvgGasPrice());
        dest.setBlockArea(source.getBlockArea());
        dest.setExtraData(source.getExtraData());
        dest.setGasLimit(source.getGasLimit());
        dest.setGasUsed(source.getGasUsed());
        dest.setGenIndex(source.getGenIndex());
        dest.setId(source.getId());
        dest.setMiner(source.getMiner());
        dest.setNumber(source.getNumber());
        dest.setParentHash(source.getParentHash());
        dest.setPkHash(source.getPkHash());
        dest.setSize(source.getSize());
        dest.setTimestamp(source.getTimestamp());
        dest.setTxn(source.getTxn());

        return dest;
    }

    public static List<BcBlockBO> dtos2Bos(List<DepositChainBlockDTO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BcBlockBO> result = new ArrayList<>();
        for (DepositChainBlockDTO source : sources) {
            BcBlockBO dest = new BcBlockBO();
            //BeanUtils.copyProperties(source, dest);
            dest.setAvgGasPrice(source.getAvgGasPrice());
            dest.setBlockArea(source.getBlockArea());
            dest.setExtraData(source.getExtraData());
            dest.setGasLimit(source.getGasLimit());
            dest.setGasUsed(source.getGasUsed());
            dest.setGenIndex(source.getGenIndex());
            dest.setId(source.getId());
            dest.setMiner(source.getMiner());
            dest.setNumber(source.getNumber());
            dest.setParentHash(source.getParentHash());
            dest.setPkHash(source.getPkHash());
            dest.setSize(source.getSize());
            dest.setTimestamp(source.getTimestamp());
            dest.setTxn(source.getTxn());
            result.add(dest);
        }
        return result;
    }

    public static DepositChainBlockDTO bo2dto(BcBlockBO source) {
        DepositChainBlockDTO dest = new DepositChainBlockDTO();
        //BeanUtils.copyProperties(source, dest);

        dest.setAvgGasPrice(source.getAvgGasPrice());
        dest.setBlockArea(source.getBlockArea());
        dest.setExtraData(source.getExtraData());
        dest.setGasLimit(source.getGasLimit());
        dest.setGasUsed(source.getGasUsed());
        dest.setGenIndex(source.getGenIndex());
        dest.setId(source.getId());
        dest.setMiner(source.getMiner());
        dest.setNumber(source.getNumber());
        dest.setParentHash(source.getParentHash());
        dest.setPkHash(source.getPkHash());
        dest.setSize(source.getSize());
        dest.setTimestamp(source.getTimestamp());
        dest.setTxn(source.getTxn());
        return dest;
    }


    public static List<DepositChainBlockDTO> bos2dtos(List<BcBlockBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<DepositChainBlockDTO> result = new ArrayList<>();
        for (BcBlockBO source : sources) {
            DepositChainBlockDTO dest = new DepositChainBlockDTO();

            dest.setAvgGasPrice(source.getAvgGasPrice());
            dest.setBlockArea(source.getBlockArea());
            dest.setExtraData(source.getExtraData());
            dest.setGasLimit(source.getGasLimit());
            dest.setGasUsed(source.getGasUsed());
            dest.setGenIndex(source.getGenIndex());
            dest.setId(source.getId());
            dest.setMiner(source.getMiner());
            dest.setNumber(source.getNumber());
            dest.setParentHash(source.getParentHash());
            dest.setPkHash(source.getPkHash());
            dest.setSize(source.getSize());
            dest.setTimestamp(source.getTimestamp());
            dest.setTxn(source.getTxn());

            //BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }

    /**
     * dubbo 返回值
     * @param source
     * @return
     */
    public static BlockInfoResponseDTO bo2ResponseDtoWithOutInfo(BcBlockBO source) {
        BlockInfoResponseDTO dest = new BlockInfoResponseDTO();
        BeanUtils.copyProperties(source, dest);
        dest.setBlockAreaInfo(BlockAreaCode.getBlockAreaById(source.getBlockArea()));
        return dest;
    }

    /**
     * dubbo 返回值
     * @param sources
     * @return
     */
    public static List<BlockInfoResponseDTO> bos2ResponseDtosWithOutInfo(List<BcBlockBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BlockInfoResponseDTO> result = new ArrayList<>();
        for (BcBlockBO source : sources) {
            BlockInfoResponseDTO dest = new BlockInfoResponseDTO();
            BeanUtils.copyProperties(source, dest);
            dest.setBlockAreaInfo(BlockAreaCode.getBlockAreaById(source.getBlockArea()));
            result.add(dest);
        }
        return result;
    }

    /**
     * 返回块内容
     * @param starBcBlockBos
     * @return
     */
    public static List<LotteryBlockResponseDTO> bo2LotteryBlockResponseDto(List<BcBlockBO> starBcBlockBos) {
        if (CollectionUtils.isEmpty(starBcBlockBos)) {
            return Collections.EMPTY_LIST;
        }

        List<LotteryBlockResponseDTO> result = new ArrayList<>();
        for (BcBlockBO source : starBcBlockBos) {
            LotteryBlockResponseDTO dest = new LotteryBlockResponseDTO();
            dest.setNumber(source.getNumber());
            dest.setPkHash(source.getPkHash());
            dest.setTimestamp(source.getTimestamp());
            dest.setTxn(source.getTxn());
            result.add(dest);
        }
        return result;
    }
}
