package com.mingyuansoftware.aifactory.service;


import com.mingyuansoftware.aifactory.model.Bizdictionary;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;

import java.util.List;

public interface BizDictionaryService {

    LayuiCommonResponse insert(Bizdictionary record);

    LayuiCommonResponse delete(int id);

    LayuiCommonResponse getByid(int id);

    LayuiCommonResponse getListByParentId(int id);

    LayuiCommonResponse update(Bizdictionary record);

    LayuiCommonResponse getAll();

    /**
     * 根据父id查询调拨类型列表
     * @param parentId
     * @return
     */
    List<Bizdictionary> selectListByParentId(int parentId);
}
