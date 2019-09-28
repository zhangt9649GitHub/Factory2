package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.OutboundOrderDetails;
import com.mingyuansoftware.aifactory.model.dto.OutboundOrderDetailsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OutboundOrderDetailsMapper {


    int deleteByPrimaryKey(Integer outboundOrderDetailsId);


    int insert(OutboundOrderDetails record);


    OutboundOrderDetails selectByPrimaryKey(Integer outboundOrderDetailsId);


    List<OutboundOrderDetails> selectAll();


    int updateByPrimaryKey(OutboundOrderDetails record);

    List<OutboundOrderDetails> selectOutboundOrderDetailsById(int outboundOrderId);

    /**
     * 获取出库明细列表
     * @param outboundOrderDetailsDto
     * @param startTime
     * @param endTime
     * @return
     */
    List<OutboundOrderDetailsDto> selectOutboundOrderDetailsList(@Param("outboundOrderDetailsDto") OutboundOrderDetailsDto outboundOrderDetailsDto,
                                                                 @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 获取出库明细列表总条目
     * @param outboundOrderDetailsDto
     * @param startTime
     * @param endTime
     * @return
     */
    int selectCount(@Param("outboundOrderDetailsDto") OutboundOrderDetailsDto outboundOrderDetailsDto,
                    @Param("startTime") String startTime, @Param("endTime") String endTime);
}