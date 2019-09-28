package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.PickingDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.PickingMapper;
import com.mingyuansoftware.aifactory.model.PickingDetails;
import com.mingyuansoftware.aifactory.model.PickingGoods;
import com.mingyuansoftware.aifactory.model.dto.PickingDetailsDto;
import com.mingyuansoftware.aifactory.service.PickingDetailsService;
import com.mingyuansoftware.aifactory.service.PickingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PickingDetailsServiceImpl implements PickingDetailsService {

    @Autowired
    private PickingDetailsMapper pickingDetailsMapper;
    @Autowired
    private PickingMapper pickingMapper;


    @Override
    public List<PickingDetailsDto> selectPickingDetailsList(PickingDetailsDto pickingDetailsDto) {
        try{
            return pickingDetailsMapper.selectPickingDetailsList(pickingDetailsDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountPickingDetails(PickingDetailsDto pickingDetailsDto) {
        try{
           return pickingDetailsMapper.selectCountPickingDetails(pickingDetailsDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PickingGoods> selectPdaPickingGoodsList(int pickingId) {
        try{
            return pickingDetailsMapper.selectPdaPickingGoodsList(pickingId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectPdaPickingGoodsListCount(int pickingId) {
        try{
          return pickingDetailsMapper.selectPdaPickingGoodsListCount(pickingId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public PickingDetails selectGoodsInfoByGoodsNumber(int goodsId, int pickingId) {
        try{
            return pickingDetailsMapper.selectGoodsInfoByGoodsNumber(goodsId,pickingId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePickingDetailsStatus(int staffId,int pickingDetailsId) {
        //修改领料单此条货物为已领料
        pickingDetailsMapper.updatePickingDetailsStatus(pickingDetailsId);
        PickingDetails pickingDetails = pickingDetailsMapper.selectByPrimaryKey(pickingDetailsId);
        List<PickingDetails> pickingDetailsList = pickingDetailsMapper.selectPickingDetailById(pickingDetails.getPickingId());
        boolean flag = true;
        for (PickingDetails pickingDetails1:pickingDetailsList
             ) {
            if(pickingDetails1.getStatus()==1){
                flag = false;
                break;
            }
        }
        //领料单详情内所有货物全部完成已领料，则修改领料单状态为已领料
        if(flag){
            //已领料
            int state = 2;
            pickingMapper.updatePickingState(pickingDetails.getPickingId(),state,staffId);
        }
    }

    @Override
    public List<PickingDetailsDto> selectPickingInfoList() {
        try{
            return pickingDetailsMapper.selectPickingInfoList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountPickingInfoList() {
        try{
            return pickingDetailsMapper.selectCountPickingInfoList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
