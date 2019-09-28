package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.PdaOutBoundGoodsTask;
import com.mingyuansoftware.aifactory.model.SalesOrder;
import com.mingyuansoftware.aifactory.model.dto.SalesOrderDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface SalesOrderService {

    /**
     * 获取销售订单列表
     * @param salesOrderDto
     * @return
     */
    List<SalesOrder> selectSalesOrderList(SalesOrderDto salesOrderDto);

    /**
     * 获取销售订单总条数
     * @param salesOrderDto
     * @return
     */
    int selectSalesOrderCount(SalesOrderDto salesOrderDto);

    /**
     * 删除销售订单
     * @param salesOrderId
     */
    void deleteSalesOrderById(int salesOrderId);

    /**
     * 根据销售订单id查询销售订单信息
     * @param salesOrderId
     * @return
     */
    SalesOrder  selectSalesOrderById(int salesOrderId);

    /**
     * 新增销售订单
     * @param salesOrder
     */
    void insertSalesOrder(SalesOrder salesOrder);

    /**
     * 编辑销售订单
     * @param salesOrder
     */
    void updateRequisitionInfo(SalesOrder salesOrder);

    List<SalesOrder> selectByCustomerId(Integer customerId);

    /**
     * 获取PDA商品出库任务列表
     * @return
     */
    List<PdaOutBoundGoodsTask> selectPdaOutboundGoodsTaskList();

    /**
     * 获取商品出库任务列表总条数
     * @return
     */
    int selectPdaOutboundGoodsTaskListCount();

    /**
     * 更新销售订单状态为已出库
     * @param salesOrderId
     */
    void updateSalesOrderState(int salesOrderId);

    List<SalesOrder> selectByCustomerId1(int id);

    void importSalesOrder(String fileName, MultipartFile file);
}
