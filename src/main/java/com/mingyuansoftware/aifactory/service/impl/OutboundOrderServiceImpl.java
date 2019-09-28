package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.OutboundOrderDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.OutboundOrderMapper;
import com.mingyuansoftware.aifactory.model.OutboundOrder;
import com.mingyuansoftware.aifactory.model.OutboundOrderDetails;
import com.mingyuansoftware.aifactory.model.dto.OutboundOrderDto;
import com.mingyuansoftware.aifactory.model.dto.StaffUserLoginDto;
import com.mingyuansoftware.aifactory.service.OutboundOrderService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OutboundOrderServiceImpl implements OutboundOrderService {

    @Autowired
    private OutboundOrderMapper outboundOrderMapper;
    @Autowired
    private OutboundOrderDetailsMapper outboundOrderDetailsMapper;

    @Override
    public List<OutboundOrder> selectOutboundOrderList(OutboundOrderDto outboundOrderDto) {
        try{
          return outboundOrderMapper.selectOutboundOrderList(outboundOrderDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(OutboundOrderDto outboundOrderDto) {
        try{
          return outboundOrderMapper.selectCount(outboundOrderDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertOutboundOrder(OutboundOrder outboundOrder) {
        outboundOrder.setCreateTime(new Date());
        outboundOrder.setIsDelete((byte)0);
      /* Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
         int staffId = staff.getStaffId();
        outboundOrder.setStaffId(staffId);*/
        outboundOrderMapper.insert(outboundOrder);
       // Integer outboundOrderId =outboundOrderMapper.selectLastId();
        List<OutboundOrderDetails> outboundOrderDetails = outboundOrder.getOutboundOrderDetailsList();
        if(!(outboundOrderDetails.isEmpty())){
            for (OutboundOrderDetails outboundOrderDetails1:outboundOrderDetails
             ) {
                outboundOrderDetails1.setOutboundOrderId(outboundOrder.getOutboundOrderId());
                outboundOrderDetailsMapper.insert(outboundOrderDetails1);
            }
        }

    }

    @Override
    public OutboundOrder selectOutboundOrderById(int outboundOrderId) {
        try{
            OutboundOrder outboundOrder =  outboundOrderMapper.selectByPrimaryKey(outboundOrderId);
            List<OutboundOrderDetails>  outboundOrderDetails =outboundOrderDetailsMapper.selectOutboundOrderDetailsById(outboundOrderId);
            outboundOrder.setOutboundOrderDetailsList(outboundOrderDetails);
            return outboundOrder;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
