package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.dto.OutboundOrderDetailsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OutboundOrderDetailsService {

    /**
     * 获取出库明细列表
     * @param outboundOrderDetailsDto
     * @return
     */
    List<OutboundOrderDetailsDto> selectOutboundOrderDetailsList(OutboundOrderDetailsDto outboundOrderDetailsDto,String startTime,String endTime);

    /**
     * 获取出库明细列表总条目
     * @param outboundOrderDetailsDto
     * @return
     */
    int selectCount(OutboundOrderDetailsDto outboundOrderDetailsDto,String startTime,String endTime);
}
