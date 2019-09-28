package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.ProductionEntryDetailsMapper;
import com.mingyuansoftware.aifactory.model.ProductionDaily;
import com.mingyuansoftware.aifactory.service.ProductionEntryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionEntryDetailsServiceImpl implements ProductionEntryDetailsService {

    @Autowired
    private ProductionEntryDetailsMapper productionEntryDetailsMapper;


    @Override
    public List<ProductionDaily> selectProductionDailyList(ProductionDaily productionDaily) {
        try{
            return productionEntryDetailsMapper.selectProductionDailyList(productionDaily);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountProductionDaily(ProductionDaily productionDaily) {
        try{
          return productionEntryDetailsMapper.selectCountProductionDaily(productionDaily);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
