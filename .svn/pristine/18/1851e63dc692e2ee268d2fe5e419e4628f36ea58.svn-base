package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.OutboundOrder;
import com.mingyuansoftware.aifactory.model.dto.OutboundOrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OutboundOrderService {

    /**
     * 获取出库单列表
     * @param outboundOrderDto
     * @return
     */
    List<OutboundOrder> selectOutboundOrderList(OutboundOrderDto outboundOrderDto);

    /**
     * 获取出库单列表总条数
     * @param outboundOrderDto
     * @return
     */
    int selectCount(OutboundOrderDto outboundOrderDto);

    /**
     * 新增出库单
     * @param outboundOrder
     */
    void insertOutboundOrder(OutboundOrder outboundOrder);

    /**
     * 根据id查询出库单信息
     * @return
     */
    OutboundOrder selectOutboundOrderById(int outboundOrderId);
}
