package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.ProductionEntry;
import com.mingyuansoftware.aifactory.model.ProductionEntryInfo;
import com.mingyuansoftware.aifactory.model.dto.PDAProductionEntryDto;
import com.mingyuansoftware.aifactory.model.dto.ProductionEntryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionEntryService {

    /**
     * 获取生产入库单列表
     * @param productionEntryDto
     * @return
     */
    List<ProductionEntry> selectProductionEntryList(ProductionEntryDto productionEntryDto);

    /**
     * 获取生产入库单列表总条目
     * @param productionEntryDto
     * @return
     */
    int selectCountProductionEntry(ProductionEntryDto productionEntryDto);


    /**
     * 删除生产入库单
     * @param productionEntryId
     */
    void deleteProductionEntryById(int productionEntryId);

    /**
     * 根据生产入库单id查询详情
     * @param productionEntryId
     * @return
     */
    ProductionEntryInfo selectProductionEntryInfoById(int productionEntryId);

    /**
     * 新增生产入库单
     * @param pdaProductionEntryDtoList
     */
    String  insertPdaProductionEntryList( List<PDAProductionEntryDto> pdaProductionEntryDtoList);
}
