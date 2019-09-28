/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: BizDictionaryServiceImpl
 * Author:   EDZ
 * Date:     2019/6/27 11:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.mapper.BizdictionaryMapper;
import com.mingyuansoftware.aifactory.model.Bizdictionary;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.BizDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author EDZ
 * @create 2019/6/27
 * @since 1.0.0
 */
@Service
public class BizDictionaryServiceImpl implements BizDictionaryService{
    @Resource
    private BizdictionaryMapper bizdictionaryMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public LayuiCommonResponse insert(Bizdictionary record) {

            int insert = 0;
            insert = bizdictionaryMapper.insert(record);
            return new LayuiCommonResponse(WlCode.SUCCESS_INSERT,insert,record);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LayuiCommonResponse delete(int id) {

            bizdictionaryMapper.deleteByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_DELETE,0,"");

    }

    @Override
    public LayuiCommonResponse getByid(int id) {
        try {
            Bizdictionary bizdictionary = bizdictionaryMapper.selectByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,bizdictionary);
        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }

    @Override
    public LayuiCommonResponse getListByParentId(int id) {
        try {
            List<String> bizdictionary = bizdictionaryMapper.selectByParentKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,bizdictionary);
        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LayuiCommonResponse update(Bizdictionary record) {

            bizdictionaryMapper.updateByPrimaryKey(record);
            return new LayuiCommonResponse(WlCode.SUCCESS_UPDAE,0,"");
    }

    @Override
    public LayuiCommonResponse getAll() {
        try {
            List<Bizdictionary> list = bizdictionaryMapper.selectAll();
            return new LayuiCommonResponse(WlCode.SUCCESS_GET, list.size(),list);
        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }

    @Override
    public List<Bizdictionary> selectListByParentId(int parentId) {
        try{
           return bizdictionaryMapper.selectListByParentId(parentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
