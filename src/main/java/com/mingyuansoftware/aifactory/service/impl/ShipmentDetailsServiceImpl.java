package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.ShipmentDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.ShipmentMapper;
import com.mingyuansoftware.aifactory.model.PDAOutboundGoods;
import com.mingyuansoftware.aifactory.model.SalesOrderDetails;
import com.mingyuansoftware.aifactory.model.ShipmentDetails;
import com.mingyuansoftware.aifactory.service.ShipmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipmentDetailsServiceImpl implements ShipmentDetailsService {

    @Autowired
    private ShipmentDetailsMapper shipmentDetailsMapper;
    @Autowired
    private ShipmentMapper shipmentMapper;

    @Override
    public List<PDAOutboundGoods> selectPdaOutboundGoodsList(int shipmentId) {
        return shipmentDetailsMapper.selectPdaOutboundGoodsList(shipmentId);
    }

    @Override
    public ShipmentDetails selectPdaOutboundGoodsCount(int goodsId, int shipmentId) {
        return shipmentDetailsMapper.selectPdaOutboundGoodsCount(goodsId,shipmentId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateShipmentStatus(int shipmentDetailsId) {
        //根据详情查出货物id和出货单id
        ShipmentDetails shipmentDetails = shipmentDetailsMapper.selectByPrimaryKey(shipmentDetailsId);
        //查出符合货物的集合
        List<ShipmentDetails> shipmentDetailsList = shipmentDetailsMapper.selectShipmentDetailsListByIdAndGoodsId(shipmentDetails.getShipmentId(),shipmentDetails.getGoodsId());
        for (ShipmentDetails shipmentDetails1:shipmentDetailsList
             ) {
            //1.修改出货单详情表状态为已配货
            shipmentDetailsMapper.updateShipmentStatus(shipmentDetails1.getShipmentDetailsId());
        }
        List<ShipmentDetails> shipmentDetailsList1 = shipmentDetailsMapper.selectShipmentDetailsListById(shipmentDetails.getShipmentId());
        boolean flag = true;
        for (ShipmentDetails shipmentDetails1:shipmentDetailsList1
        ) {
            if(shipmentDetails1.getStatus()==1){
                flag = false;
                break;
            }
        }
        if(flag){
            //已配货
            int state = 2;
            shipmentMapper.updateShipmentState(shipmentDetails.getShipmentId(),state);
        }
    }
}
