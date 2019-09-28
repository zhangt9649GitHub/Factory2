package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.ProductionInstructionDetailMapper;
import com.mingyuansoftware.aifactory.model.ProductionInstructionDetail;
import com.mingyuansoftware.aifactory.service.ProductionInstructionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionInstructionDetailServiceImpl implements ProductionInstructionDetailService {

    @Autowired
    private ProductionInstructionDetailMapper productionInstructionDetailMapper;

    @Override
    public List<ProductionInstructionDetail> selectProductionInstructionDetailsById(int productionInstructionGoodsId) {
        try {
            return productionInstructionDetailMapper.selectProductionInstructionDetailsById(productionInstructionGoodsId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
