package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.StorageAccess;
import com.mingyuansoftware.aifactory.model.StorageGoodsDetail;
import com.mingyuansoftware.aifactory.model.dto.StorageAccessDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;

import java.util.List;

public interface StorageAccessService {
    LayuiCommonResponse deleteByPrimaryKey(Integer storageAccessId);


    LayuiCommonResponse insert(StorageAccess record);


    LayuiCommonResponse selectByPrimaryKey(Integer storageAccessId);


    LayuiCommonResponse selectAll(int page, int limit, StorageAccessDto storageAccessDto);

    LayuiCommonResponse selectGoodsByPage(int page, int limit);

    LayuiCommonResponse selectDetailGoods(int page, int limit,StorageGoodsDetail storageGoodsDetail);


    LayuiCommonResponse updateByPrimaryKey(StorageAccess record);
}
