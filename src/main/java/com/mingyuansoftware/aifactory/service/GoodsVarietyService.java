package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.GoodsVariety;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsVarietyService {

    /**
     * 获取货物品种集合
     * @return
     */
    List<GoodsVariety> selectGoodsVarietyList();

    /**
     * 获取货物品种列表
     * @param goodsVariety
     * @return
     */
    List<GoodsVariety> selectAllGoodsVarietyList(GoodsVariety goodsVariety);

    /**
     * 获取货物品种列表总条数
     * @param goodsVariety
     * @return
     */
    int selectCountGoodsVarietyList(GoodsVariety goodsVariety);

    /**
     * 新增货物品种
     * @param goodsVariety
     */
    void insertGoodsVariety(GoodsVariety goodsVariety);

    /**
     * 根据品种值查询货物品种信息
     * @param varietyValue
     * @return
     */
    GoodsVariety selectGoodsVarietyById(int varietyValue);

    /**
     * 更新货物品种信息
     * @param goodsVariety
     */
    void updateGoodsVariety(GoodsVariety goodsVariety);

}
