package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.StorageAccess;
import com.mingyuansoftware.aifactory.model.dto.RequisitionGoodsDto;
import com.mingyuansoftware.aifactory.model.dto.StorageAccessDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface StorageAccessMapper {

    int deleteByPrimaryKey(Integer storageAccessId);


    int insert(StorageAccess record);


    StorageAccess selectByPrimaryKey(Integer storageAccessId);


    List<StorageAccess> selectAll(StorageAccessDto storageAccessDto);


    int updateByPrimaryKey(StorageAccess record);


    /**
     * 根据仓库id查询货物列表
     * @param warehouseId
     * @return
     */
    List<RequisitionGoodsDto> selectInventoryGoodsList(@Param("warehouseId") int warehouseId);

    /**
     * 根据仓库id查询货物列表数量
     * @param warehouseId
     * @return
     */
    int selectInventoryGoodsCount(@Param("warehouseId") int warehouseId);
}