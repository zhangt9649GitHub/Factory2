/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: SupplierServiceImpl
 * Author:   EDZ
 * Date:     2019/6/29 10:17
 * Description: 供应商
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.mapper.SupplierContactMapper;
import com.mingyuansoftware.aifactory.mapper.SupplierGoodsMapper;
import com.mingyuansoftware.aifactory.mapper.SupplierMapper;
import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.Supplier;
import com.mingyuansoftware.aifactory.model.SupplierContact;
import com.mingyuansoftware.aifactory.model.SupplierGoods;
import com.mingyuansoftware.aifactory.model.dto.SupplierDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈供应商〉
 *
 * @author EDZ
 * @create 2019/6/29
 * @since 1.0.0
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Resource
    private SupplierMapper supplierMapper;

    @Resource
    private SupplierContactMapper supplierContactMapper;

    @Resource
    private SupplierGoodsMapper supplierGoodsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LayuiCommonResponse insert(Supplier supplier) {



            byte isDelete=0;
            supplier.setIsDelete(isDelete);
            supplier.setCreateTime(new Date());
            supplier.setUpdateTime(new Date());
            supplierMapper.insert(supplier);
            List<SupplierContact> supplierContacts = supplier.getSupplierContacts();
            for (int i = 0; i < supplierContacts.size(); i++) {
                SupplierContact supplierContact = supplierContacts.get(i);
                supplierContact.setIsDelete(isDelete);
                supplierContact.setSupplierId(supplier.getSupplierId());
                supplierContactMapper.insert(supplierContact);
            }
            List<SupplierGoods> supplierGoods = supplier.getSupplierGoods();
            for (int i = 0; i < supplierGoods.size(); i++) {
                SupplierGoods supplierGood = supplierGoods.get(i);
                supplierGood.setIsDelete(isDelete);
                supplierGood.setSupplierId(supplier.getSupplierId());
                supplierGoodsMapper.insert(supplierGood);
            }

            return new LayuiCommonResponse(WlCode.SUCCESS_INSERT,0,supplier);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LayuiCommonResponse delete(int id) {

            supplierMapper.deleteByPrimaryKey(id);
            supplierContactMapper.deleteByPrimaryKey(id);
            supplierGoodsMapper.deleteByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_DELETE,0,"");

    }

    @Override
    public LayuiCommonResponse getByid(int id) {
        try {
            Supplier supplier = supplierMapper.selectByPrimaryKey(id);
            List<SupplierContact> supplierContacts = supplierContactMapper.selectByPrimaryKey(id);
            List<SupplierGoods> supplierGoods = supplierGoodsMapper.selectByPrimaryKey(id);
            supplier.setSupplierContacts(supplierContacts);
            supplier.setSupplierGoods(supplierGoods);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,supplier);
        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LayuiCommonResponse update(Supplier supplier) {


            supplier.setUpdateTime(new Date());
            supplierMapper.updateByPrimaryKey(supplier);
            supplierContactMapper.deleteKey(supplier.getSupplierId());
            supplierGoodsMapper.deleteKey(supplier.getSupplierId());
            byte isDelete=0;
            List<SupplierContact> supplierContacts = supplier.getSupplierContacts();
            for (int i = 0; i < supplierContacts.size(); i++) {
                SupplierContact supplierContact = supplierContacts.get(i);
                supplierContact.setIsDelete(isDelete);
                supplierContact.setSupplierId(supplier.getSupplierId());
                supplierContactMapper.insert(supplierContact);
            }
            List<SupplierGoods> supplierGoods = supplier.getSupplierGoods();
            for (int i = 0; i < supplierGoods.size(); i++) {
                SupplierGoods supplierGood = supplierGoods.get(i);
                supplierGood.setIsDelete(isDelete);
                supplierGood.setSupplierId(supplier.getSupplierId());
                supplierGoodsMapper.insert(supplierGood);
            }

            return new LayuiCommonResponse(WlCode.SUCCESS_UPDAE,0,supplier);

    }

    @Override
    public LayuiCommonResponse getAll() {

        try {
            List<Supplier> suppliers = supplierMapper.selectAll();
            return new LayuiCommonResponse(WlCode.SUCCESS_GET, suppliers.size(),suppliers);
        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }

    @Override
    public LayuiCommonResponse getByPage(int page, int limit,  SupplierDto supplierDto) {

        try {
            PageHelper.startPage(page, limit);
            List<Supplier> list = supplierMapper.selectByPage(supplierDto);
            Page<Supplier> page1= (Page<Supplier>) list;
            return new LayuiCommonResponse(WlCode.SUCCESS_GET, (int) page1.getTotal(),page1.getResult());

        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }


    }

    @Override
    public List<Supplier> getSupplierNameList() {
        try{
            return supplierMapper.selectSupplierNameList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
