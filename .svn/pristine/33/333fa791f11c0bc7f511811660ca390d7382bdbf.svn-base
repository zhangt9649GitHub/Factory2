package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.constants.Constants;
import com.mingyuansoftware.aifactory.mapper.OutboundOrderDetailsMapper;
import com.mingyuansoftware.aifactory.model.dto.OutboundOrderDetailsDto;
import com.mingyuansoftware.aifactory.service.OutboundOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutboundOrderDetailsServiceImpl implements OutboundOrderDetailsService {

    @Autowired
    private OutboundOrderDetailsMapper outboundOrderDetailsMapper;

    @Override
    public List<OutboundOrderDetailsDto> selectOutboundOrderDetailsList(OutboundOrderDetailsDto outboundOrderDetailsDto,String startTime,String endTime) {
       try{
           List<OutboundOrderDetailsDto>  outboundOrderDetailsDtos = outboundOrderDetailsMapper.selectOutboundOrderDetailsList(outboundOrderDetailsDto,startTime,endTime);
           for (OutboundOrderDetailsDto outboundOrderDetailsDto1:outboundOrderDetailsDtos
                ) {
               for (int s: Constants.MAP_CATEGORY.keySet()
               ) {
                   if(outboundOrderDetailsDto1.getCategory()==s){
                       outboundOrderDetailsDto1.setCategoryName(Constants.MAP_CATEGORY.get(s));
                   }
               }
           }
           return outboundOrderDetailsDtos;
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }

    @Override
    public int selectCount(OutboundOrderDetailsDto outboundOrderDetailsDto,String startTime,String endTime) {
        try{
          return outboundOrderDetailsMapper.selectCount(outboundOrderDetailsDto,startTime,endTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
