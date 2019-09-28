package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.ProductionInstructionDetailMapper;
import com.mingyuansoftware.aifactory.mapper.ProductionInstructionGoodsMapper;
import com.mingyuansoftware.aifactory.mapper.ProductionInstructionMapper;
import com.mingyuansoftware.aifactory.model.ProductionInstruction;
import com.mingyuansoftware.aifactory.model.ProductionInstructionDetail;
import com.mingyuansoftware.aifactory.model.ProductionInstructionGoods;
import com.mingyuansoftware.aifactory.model.dto.ProductionInstructionDto;
import com.mingyuansoftware.aifactory.service.ProductionInstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductionInstructionServiceImpl implements ProductionInstructionService {

    @Autowired
    private ProductionInstructionMapper productionInstructionMapper;
    @Autowired
    private ProductionInstructionGoodsMapper productionInstructionGoodsMapper;
    @Autowired
    private ProductionInstructionDetailMapper productionInstructionDetailMapper;

    @Override
    public List<ProductionInstruction> selectProductionInstructionList(ProductionInstructionDto productionInstructionDto) {
        try{
            return productionInstructionMapper.selectProductionInstructionList(productionInstructionDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountProductionInstruction(ProductionInstructionDto productionInstructionDto) {
        try{
            return productionInstructionMapper.selectCountProductionInstruction(productionInstructionDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ProductionInstruction selectProductionInstructionById(int productionInstructionId) {
        try{
            return productionInstructionMapper.selectByPrimaryKey(productionInstructionId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGoodsInfo(ProductionInstruction productionInstruction) {
            productionInstruction.setUpdateTime(new Date());
            productionInstructionMapper.updateByPrimaryKey(productionInstruction);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteProductionInstructionById(int productionInstructionId) {
        List<ProductionInstructionGoods> productionInstructionGoodsList =productionInstructionGoodsMapper.selectProductionInstructionDetailById(productionInstructionId);
        for (ProductionInstructionGoods productionInstructionGoods:productionInstructionGoodsList
             ) {
            List<ProductionInstructionDetail>  productionInstructionDetailList = productionInstructionDetailMapper.selectProductionInstructionDetailsById(productionInstructionGoods.getProductionInstructionGoodsId());
            for (ProductionInstructionDetail productionInstructionDetail:productionInstructionDetailList
                 ) {
                productionInstructionDetailMapper.deleteByPrimaryKey(productionInstructionDetail.getProductionInstructionDetailId());
            }
            productionInstructionGoodsMapper.deleteByPrimaryKey(productionInstructionGoods.getProductionInstructionGoodsId());
        }
      productionInstructionMapper.deleteByPrimaryKey(productionInstructionId);
    }

    @Override
    public List<ProductionInstruction> selectSerialNumberList() {
        try{
            return productionInstructionMapper.selectSerialNumberList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
