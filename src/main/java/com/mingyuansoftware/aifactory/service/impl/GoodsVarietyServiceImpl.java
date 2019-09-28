package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.GoodsVarietyMapper;
import com.mingyuansoftware.aifactory.model.GoodsVariety;
import com.mingyuansoftware.aifactory.service.GoodsVarietyService;
import com.mingyuansoftware.aifactory.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsVarietyServiceImpl implements GoodsVarietyService {

    @Autowired
    private GoodsVarietyMapper goodsVarietyMapper;


    @Override
    public List<GoodsVariety> selectGoodsVarietyList() {
        try{
           return goodsVarietyMapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GoodsVariety> selectAllGoodsVarietyList(GoodsVariety goodsVariety) {
        try{
            return goodsVarietyMapper.selectAllGoodsVarietyList(goodsVariety);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountGoodsVarietyList(GoodsVariety goodsVariety) {
        try{
            return goodsVarietyMapper.selectCountGoodsVarietyList(goodsVariety);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertGoodsVariety(GoodsVariety goodsVariety) {
        GoodsVariety goodsVariety1 =goodsVarietyMapper.selectByPrimaryKey(goodsVariety.getVarietyValue());
        if(goodsVariety1!=null){
            throw new MyException("新增失败,此品种值已存在");
        }
        goodsVarietyMapper.insert(goodsVariety);
    }

    @Override
    public GoodsVariety selectGoodsVarietyById(int varietyValue) {
        return goodsVarietyMapper.selectByPrimaryKey(varietyValue);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGoodsVariety(GoodsVariety goodsVariety) {
        goodsVarietyMapper.updateByPrimaryKey(goodsVariety);
    }
}
