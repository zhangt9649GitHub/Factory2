package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.OutboundOrder;
import com.mingyuansoftware.aifactory.model.dto.OutboundOrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OutboundOrderMapper {


    int deleteByPrimaryKey(Integer outboundOrderId);


    int insert(OutboundOrder record);


    OutboundOrder selectByPrimaryKey(Integer outboundOrderId);


    List<OutboundOrder> selectAll();


    int updateByPrimaryKey(OutboundOrder record);

    /**
     * 获取出库单列表
     * @param outboundOrderDto
     * @return
     */
    List<OutboundOrder> selectOutboundOrderList(@Param("outboundOrderDto") OutboundOrderDto outboundOrderDto);

    /**
     * 获取出库单列表总条数
     * @param outboundOrderDto
     * @return
     */
    int selectCount(@Param("outboundOrderDto") OutboundOrderDto outboundOrderDto);

    int selectLastId();
}