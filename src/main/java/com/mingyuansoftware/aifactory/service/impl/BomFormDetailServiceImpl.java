package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.BomFormDetailMapper;
import com.mingyuansoftware.aifactory.model.BomFormDetail;
import com.mingyuansoftware.aifactory.service.BomFormDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BomFormDetailServiceImpl implements BomFormDetailService {

    @Autowired
    private BomFormDetailMapper bomFormDetailMapper;

    @Override
    public List<BomFormDetail> selectBomFormDetailById(int bomId) {
        try{
            return bomFormDetailMapper.selectBomFormDetailById(bomId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
