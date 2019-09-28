package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.SalesOrderDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.SalesOrderMapper;
import com.mingyuansoftware.aifactory.mapper.ShipmentDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.ShipmentMapper;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.ShipmentDto;
import com.mingyuansoftware.aifactory.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentMapper shipmentMapper;
    @Autowired
    private ShipmentDetailsMapper shipmentDetailsMapper;
    @Autowired
    private SalesOrderDetailsMapper salesOrderDetailsMapper;
    @Autowired
    private SalesOrderMapper salesOrderMapper;

    @Override
    public List<PdaOutBoundGoodsTask> selectPdaOutboundGoodsTaskList() {
        return shipmentMapper.selectPdaOutboundGoodsTaskList();
    }

    @Override
    public int selectPdaOutboundGoodsTaskListCount() {
        return shipmentMapper.selectPdaOutboundGoodsTaskListCount();
    }

    @Override
    public List<Shipment> selectShipmentList(ShipmentDto shipmentDto) {
        return shipmentMapper.selectShipmentList(shipmentDto);
    }

    @Override
    public int selectCountShipmentList(ShipmentDto shipmentDto) {
        return shipmentMapper.selectCountShipmentList(shipmentDto);
    }

    @Override
    public Shipment selectShipmentById(int shipmentId) {
        Shipment shipment = shipmentMapper.selectByPrimaryKey(shipmentId);
        List<ShipmentDetails> shipmentDetailsList =shipmentDetailsMapper.selectShipmentDetailsListById(shipmentId);
        shipment.setShipmentDetailsList(shipmentDetailsList);
        return shipment;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateShipmentState(int shipmentId) {
       //修改出货单状态为已出货
        int state = 3;
        shipmentMapper.updateShipmentState(shipmentId,state);
        Shipment shipment = shipmentMapper.selectByPrimaryKey(shipmentId);
        if(shipment.getSalesOrderId()!=null){
            boolean flag = true;
            int state1 = 1;
            List<SalesOrderDetails> salesOrderDetailsList1 = salesOrderDetailsMapper.selectSalesOrderDetailsListById(shipment.getSalesOrderId());
            for (SalesOrderDetails salesOrderDetails:salesOrderDetailsList1
            ) {
                if(salesOrderDetails.getStatus()<3){
                    flag = false;
                    if(salesOrderDetails.getStatus()==2){
                        state1=2;
                    }
                }
            }
            if(flag){
                state1 =3;
                salesOrderMapper.updateSaleOrderState(shipment.getSalesOrderId(),state1);
            }else{
                if(state1==2){
                    salesOrderMapper.updateSaleOrderState(shipment.getSalesOrderId(),state1);
                }
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateShipmentPrintById(int shipmentId, int isPrint) {
        shipmentMapper.updateShipmentPrintById(shipmentId,isPrint);
    }

    @Override
    public Shipment selectShipmentPrint() {
        Shipment shipment = shipmentMapper.selectShipmentPrint();
        if(shipment!=null){
         List<ShipmentDetails> shipmentDetailsList =shipmentDetailsMapper.selectShipmentDetailsListById(shipment.getShipmentId());
            for (ShipmentDetails shipmentDetails:shipmentDetailsList
                 ) {
                SalesOrderDetails salesOrderDetails = salesOrderDetailsMapper.selectByPrimaryKey(shipmentDetails.getSalesOrderDetailsId());
                if(salesOrderDetails!=null){
                    shipmentDetails.setLotNumber(salesOrderDetails.getLotNumber());
                    shipmentDetails.setReturnNumber(salesOrderDetails.getReturnNumber());
                }
            }
            shipment.setShipmentDetailsList(shipmentDetailsList);
        }
        return shipment;
    }
}
