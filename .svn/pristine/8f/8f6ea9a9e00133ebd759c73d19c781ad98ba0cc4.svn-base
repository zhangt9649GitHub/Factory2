package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.GoodsSupplier;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsSupplierMapper {
    int deleteByPrimaryKey(@Param("goodsId") Integer goodsId, @Param("supplierId") Integer supplierId);

    int insert(GoodsSupplier record);

    List<GoodsSupplier> selectAll();

    /**
     * 根据货物id删除货物供应商列表
     * @param goodsId
     */
    void deleteGoodsSupplierByGoodsId(@Param("goodsId") int goodsId);

    /**
     * 根据货物id查询货物供应商列表
     * @param goodsId
     * @return
     */
    List<GoodsSupplier>  selectGoodsSupplierByGoodsId(@Param("goodsId") int goodsId);
}