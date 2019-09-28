package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.PDAOutboundGoods;
import com.mingyuansoftware.aifactory.model.SalesOrder;
import com.mingyuansoftware.aifactory.model.SalesOrderDetails;
import com.mingyuansoftware.aifactory.model.ShipmentDetails;
import com.mingyuansoftware.aifactory.model.dto.SalesDetailsDto;
import com.mingyuansoftware.aifactory.model.dto.SalesOrderDetailsListDto;
import com.mingyuansoftware.aifactory.model.dto.ShipmentListDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface SalesOrderDetailsService {
    /**
     * 获取销售明细列表
     * @param salesDetailsDto
     * @param startTime
     * @param endTime
     * @return
     */
    List<SalesDetailsDto> selectSalesDetailsList(SalesDetailsDto salesDetailsDto,String startTime,String endTime);

    /**
     * 获取销售明细列表总条数
     * @param salesDetailsDto
     * @param startTime
     * @param endTime
     * @return
     */
    int selectSalesDetailsCount(SalesDetailsDto salesDetailsDto,String startTime,String endTime);

    /**
     * 根据销售订单获取货物列表
     * @param salesOrderId
     * @return
     */
    List<SalesOrderDetails>  selectSalesReturnGoodsList(int salesOrderId,String partsCd,String goodsName);

    /**
     * 根据销售订单获取货物列表总条数
     * @param salesOrderId
     * @return
     */
    int selectSalesReturnGoodsCount(int salesOrderId,String partsCd,String goodsName);

    /**
     * 根据客户id获取销售订单列表
     * @param customerId
     * @return
     */
    List<SalesOrder> selectSalesOrderListByCustomerId(int customerId);

    /**
     * 根据销售订单获取出库商品列表
     * @param salesOrderId
     * @return
     */
    List<PDAOutboundGoods> selectPdaOutboundGoodsList(int salesOrderId);

    /**
     * 获取销售订单内货物的数量
     * @param goodsId
     * @param salesOrderId
     * @return
     */
    SalesOrderDetails selectPdaOutboundGoodsCount(int goodsId,int salesOrderId);

    /**
     * 修改销售订单状态为已配货
     * @param salesOrderDetailsId
     */
    void updateSaleOrderDetailsStatus(int salesOrderDetailsId);

    SalesOrderDetails selectByPrimaryKey(int salesOrderDetailsId);

    /**
     * 修改销售订单的出货数量
     * @param shipmentListDto
     */
    List<ShipmentDetails>   updateSaleOrderDetailsQuantity(ShipmentListDto shipmentListDto);
}
