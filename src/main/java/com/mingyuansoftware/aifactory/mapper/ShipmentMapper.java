package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PdaOutBoundGoodsTask;
import com.mingyuansoftware.aifactory.model.Shipment;
import com.mingyuansoftware.aifactory.model.dto.ShipmentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface ShipmentMapper {

    int deleteByPrimaryKey(Integer shipmentId);

    int insert(Shipment record);

    Shipment selectByPrimaryKey(Integer shipmentId);

    List<Shipment> selectAll();

    int updateByPrimaryKey(Shipment record);

    /**
     * 获取出货单列表
     * @return
     */
    List<PdaOutBoundGoodsTask> selectPdaOutboundGoodsTaskList();

    /**
     * 获取出货单列表总条数
     * @return
     */
    int selectPdaOutboundGoodsTaskListCount();

    /**
     * 修改出货单状态
     * @param shipmentId
     * @param state
     */
    void updateShipmentState(@Param("shipmentId") int shipmentId, @Param("state") int state);

    /**
     * 获取出货单列表
     * @param shipmentDto
     * @return
     */
    List<Shipment> selectShipmentList(@Param("shipmentDto") ShipmentDto shipmentDto);

    /**
     * 获取出货单列表总条数
     * @param shipmentDto
     * @return
     */
    int selectCountShipmentList(@Param("shipmentDto") ShipmentDto shipmentDto);

    /**
     * 修改出货单的打印状态
     * @param shipmentId
     * @param isPrint
     */
    void updateShipmentPrintById(@Param("shipmentId") int shipmentId,@Param("isPrint") int isPrint);

    /**
     * 获取打印发货单信息
     * @return
     */
    Shipment selectShipmentPrint();
}