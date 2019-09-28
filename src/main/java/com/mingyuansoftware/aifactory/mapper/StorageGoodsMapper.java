package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.StorageGoods;
import com.mingyuansoftware.aifactory.model.StorageGoodsDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface StorageGoodsMapper {

    int deleteByPrimaryKey(Integer storageGoodsId);


    int insert(StorageGoods record);


    List<StorageGoods> selectByPrimaryKey(Integer storageGoodsId);


    List<StorageGoods> selectAll(StorageGoodsDetail storageGoodsDetail);


    int updateByPrimaryKey(StorageGoods record);
}