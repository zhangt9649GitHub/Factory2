package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.PdaOutBoundGoodsTask;
import com.mingyuansoftware.aifactory.model.Shipment;
import com.mingyuansoftware.aifactory.model.dto.ShipmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipmentService {

    /***
     * 获取出货单列表
     * @return
     */
    List<PdaOutBoundGoodsTask>  selectPdaOutboundGoodsTaskList();

    /**
     * 获取出货单列表总条数
     * @return
     */
    int selectPdaOutboundGoodsTaskListCount();

    /**
     * 获取出货单列表
     * @param shipmentDto
     * @return
     */
    List<Shipment>  selectShipmentList(ShipmentDto shipmentDto);

    /**
     * 获取出货单列表总条数
     * @param shipmentDto
     * @return
     */
    int selectCountShipmentList(ShipmentDto shipmentDto);

    /**
     * 根据出货单id查询出货单详情
     * @param shipmentId
     * @return
     */
    Shipment selectShipmentById(int shipmentId);

    /**
     * 修改出货单状态
     * @param shipmentId
     */
    void updateShipmentState(int shipmentId);

    /**
     * 修改出货单的打印状态
     * @param shipmentId
     * @param isPrint
     */
    void updateShipmentPrintById(int shipmentId,int isPrint);

    Shipment selectShipmentPrint();
}
