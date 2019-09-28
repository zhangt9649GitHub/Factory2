package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.RefundPickingDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.RefundPickingMapper;
import com.mingyuansoftware.aifactory.model.RefundPicking;
import com.mingyuansoftware.aifactory.model.RefundPickingDetails;
import com.mingyuansoftware.aifactory.model.RefundPickingGoods;
import com.mingyuansoftware.aifactory.service.RefundPickingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RefundPickingDetailsServiceImpl implements RefundPickingDetailsService {

    @Autowired
    private RefundPickingDetailsMapper refundPickingDetailsMapper;
    @Autowired
    private RefundPickingMapper refundPickingMapper;

    @Override
    public List<RefundPickingGoods> SelectPdaRefundPickingGoodsList(int refundPickingId) {
        try{
            return refundPickingDetailsMapper.SelectPdaRefundPickingGoodsList(refundPickingId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectPdaRefundPickingGoodsListCount(int refundPickingId) {
        try{
           return refundPickingDetailsMapper.selectPdaRefundPickingGoodsListCount(refundPickingId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public RefundPickingDetails selectRefundGoodsCount(int goodsId, int refundPickingId) {
        try{
            return refundPickingDetailsMapper.selectRefundGoodsCount(goodsId,refundPickingId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRefundPickingDetailsStatus(int refundPickingDetailsId) {
        //修改退料单此条货物为已领料
        refundPickingDetailsMapper.updateRefundPickingDetailsStatus(refundPickingDetailsId);
        RefundPickingDetails refundPickingDetails = refundPickingDetailsMapper.selectByPrimaryKey(refundPickingDetailsId);
        List<RefundPickingDetails> refundPickingDetailsList = refundPickingDetailsMapper.selectRefundPinkingDetailsById(refundPickingDetails.getRefundPickingId());
        boolean flag = true;
        for (RefundPickingDetails refundPickingDetails1:refundPickingDetailsList
        ) {
            if(refundPickingDetails1.getStatus()==1){
                flag = false;
                break;
            }
        }
        //退料单详情内所有货物全部完成已领料，则修改退料单状态为已领料
        if(flag){
            //已领料
            int state = 2;
            refundPickingMapper.updateRefundPickingState(refundPickingDetails.getRefundPickingId(),state);
        }
    }
}
