package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PdaOutBoundGoodsTask;
import com.mingyuansoftware.aifactory.model.SalesOrder;
import com.mingyuansoftware.aifactory.model.dto.SalesOrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SalesOrderMapper {


    int deleteByPrimaryKey(Integer salesOrderId);


    int insert(SalesOrder record);


    SalesOrder selectByPrimaryKey(Integer salesOrderId);


    List<SalesOrder> selectAll();


    int updateByPrimaryKey(SalesOrder record);

    int updateBySaleNumber(SalesOrder record);

    /**
     * 获取销售订单列表
     * @param salesOrderDto
     * @return
     */
    List<SalesOrder> selectSalesOrderList(@Param("salesOrderDto") SalesOrderDto salesOrderDto);

    /**
     * 获取销售订单总条数
     * @param salesOrderDto
     * @return
     */
    int selectSalesOrderCount(@Param("salesOrderDto") SalesOrderDto salesOrderDto);

    /**
     * 修改销售订单为删除状态
     * @param salesOrderId
     */
    void updateSalesOrderById(@Param("salesOrderId") int salesOrderId);

    /**
     * 根据销售订单id查询销售订单详情
     * @param salesOrderId
     * @return
     */
    SalesOrder selectSalesOrderById(@Param("salesOrderId") int salesOrderId);

    /**
     * 查询刚插入的一条数据的主键id
     * @return
     */
    Integer selectLastId();

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
     * 修改销售订单状态为已出库
     * @param salesOrderId
     * @param state
     */
    void updateSaleOrderState(@Param("salesOrderId") int salesOrderId,@Param("state") int state);

    List<SalesOrder> selectByCustomerId1(int id);
}