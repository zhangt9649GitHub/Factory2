package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.config.LogConfig;
import com.mingyuansoftware.aifactory.constants.Constants;
import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;

import com.mingyuansoftware.aifactory.model.dto.ProductionOrderDto;
import com.mingyuansoftware.aifactory.model.dto.StaffUserLoginDto;
import com.mingyuansoftware.aifactory.service.ProductionOrderService;
import com.mingyuansoftware.aifactory.util.MyException;
import com.mingyuansoftware.aifactory.util.RandomCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductionOrderServiceImpl implements ProductionOrderService {

    @Autowired
    private ProductionOrderMapper productionOrderMapper;
    @Autowired
    private ProductionOrderDetailsMapper productionOrderDetailsMapper;
    @Autowired
    private BomFormMapper bomFormMapper;
    @Autowired
    private PickingMapper pickingMapper;
    @Autowired
    private PickingDetailsMapper pickingDetailsMapper;

    @Override
    public List<ProductionOrder> selectProductionOrderList(ProductionOrderDto productionOrderDto) {
        try{
            return productionOrderMapper.selectProductionOrderList(productionOrderDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(ProductionOrderDto productionOrderDto) {
        try{
          return productionOrderMapper.selectCount(productionOrderDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertProductionOrder(ProductionOrder productionOrder) {
        productionOrder.setIsDelete((byte)0);
        //已创建
        productionOrder.setState((byte)1);
        productionOrder.setCreateTime(new Date());
        productionOrderMapper.insert(productionOrder);
        int ProductionOrderId = productionOrder.getProductionOrderId();
       /* StaffUserLoginDto userLoginDto =(StaffUserLoginDto) SecurityUtils.getSubject().getSession().getAttribute("user");
        int staffId = userLoginDto.getStaffId();
        productionOrder.setStaffId(staffId);*/
        //勾选自动生成领料单
        if(productionOrder.getIsCreatePicking()==1){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String d = sdf.format(date);
            //生成领料单  先遍历需要生成的领料单数据
            for (Picking picking:productionOrder.getPickingList()) {
                boolean flag = true;
                String noteDcNumber = "10" + RandomCodeUtil.getRandomCode();
                picking.setPickingNumber(noteDcNumber);//领料单编号
                picking.setCreateTime(date);
                picking.setState((byte)1);
                picking.setIsDelete((byte)0);
                picking.setAddTime(d);
                picking.setPsId(ProductionOrderId);
                pickingMapper.insert(picking);
                int pickingId = pickingMapper.selectLastId();
                int size = picking.getPickingDetailsList().size();
                int i = 0;
                for (PickingDetails pickingDetails:picking.getPickingDetailsList()){
                    i = ++i;
                    if (flag) {
                        for (PickingDetails pickingDetails1 : pickingDetails.getPickingDetailsList()) {
                            pickingDetails1.setPickingId(pickingId);
                            //                    pickingDetails.setPickingId(picking.getPickingId());
                            //根据货物Id和领料单Id查询领料单详情
                            PickingDetails pickingDetails2 = pickingDetailsMapper.selectGoodsInfoByGoodsNumber(pickingDetails1.getGoodsId(), pickingId);
                            if (pickingDetails2 != null){
                                BigDecimal quantity = pickingDetails2.getQuantity().add(pickingDetails1.getQuantity());
                                //根据领料单详情Id修改领料单详情中货物的数量
                                pickingDetailsMapper.updatePickingDetailsGoodsQuantityByPDId(pickingDetails2.getPickingDetailsId(),quantity);
                            } else{//如果,不同就进行添加
                                pickingDetailsMapper.insert(pickingDetails1);
                            }
                            //仓库切换
                            if (LogConfig.warehouseType == 1){
                                //如果仓库类型是1,就是天津总库
                                pickingDetails1.setIntoWarehouseId(Constants.WAREHOUSE_ID);
                                pickingDetails1.setOutWarehouseId(Constants.WAREHOUSE_ID);
                            }
                            //根据领料单Id改领料单出入库仓库Id
                            pickingMapper.updateWarehouseById(pickingId, pickingDetails1.getIntoWarehouseId(), pickingDetails1.getOutWarehouseId());
                        }
                        flag = false;
                    }
                    if (size!=i) {
                        if (!flag){
                            flag = true;
                            noteDcNumber = "10" + RandomCodeUtil.getRandomCode();
                            picking.setPickingNumber(noteDcNumber);//领料单编号
                            picking.setCreateTime(new Date());
                            picking.setState((byte)1);
                            picking.setIsDelete((byte)0);
                            picking.setAddTime(d);
                            picking.setPsId(ProductionOrderId);
                            pickingMapper.insert(picking);
                            pickingId = pickingMapper.selectLastId();
                        }
                    }
                }
            }
        }
       // int productionInstructionId= 0;
        for (ProductionOrderDetails productionOrderDetails:productionOrder.getProductionOrderDetailsList()
             ) {
            //int productionInstructionId = productionOrderDetails.getProductionInstructionId();
          /*  if(productionInstructionId==0){

            }else if(productionInstructionId!=productionOrderDetails.getProductionInstructionId()){
               throw new MyException("新增失败,排产单内的货物必须属于同一批次");
            }*/
            BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(productionOrderDetails.getGoodsId());
            if(bomForm==null){
                throw new MyException("新增失败,部品CD:"+productionOrderDetails.getPartsCd()+"的货物在BOM表单中未找到,请先创建此货物的Bom表单");
            }
            productionOrderDetails.setBomId(bomForm.getBomId());
            productionOrderDetails.setProductionOrderId(productionOrder.getProductionOrderId());
            productionOrderDetails.setInventoryQuantity(BigDecimal.ZERO);
            productionOrderDetails.setStatus((byte)1);
            productionOrderDetailsMapper.insert(productionOrderDetails);
        }


    }

    @Override
    public ProductionOrder selectProductionOrderById(int productionOrderId) {
        try{
            ProductionOrder productionOrder = productionOrderMapper.selectByPrimaryKey(productionOrderId);
            List<ProductionOrderDetails> productionOrderDetailsList = productionOrderDetailsMapper.selectProductionOrderDetailsById(productionOrderId);
            productionOrder.setProductionOrderDetailsList(productionOrderDetailsList);
            return productionOrder;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProductionOrderById(int productionOrderId) {
        productionOrderMapper.updateProductionOrderById(productionOrderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProductionOrderInfo(ProductionOrder productionOrder) {
       ProductionOrder productionOrder1= productionOrderMapper.selectByPrimaryKey(productionOrder.getProductionOrderId());
        productionOrder1.setStaffId(productionOrder.getStaffId());
        productionOrder1.setUpdateTime(new Date());
        productionOrder1.setAddTime(productionOrder.getAddTime());
        //勾选自动生成领料单
        if(productionOrder.getIsCreatePicking()==1){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String d = sdf.format(date);
            //生成领料单  先遍历需要生成的领料单数据
            for (Picking picking:productionOrder.getPickingList()) {
                boolean flag = true;
                String noteDcNumber = "10" + RandomCodeUtil.getRandomCode();
                picking.setPickingNumber(noteDcNumber);//领料单编号
                picking.setCreateTime(date);
                picking.setState((byte)1);
                picking.setIsDelete((byte)0);
                picking.setAddTime(d);
                picking.setPsId(productionOrder.getProductionOrderId());
                pickingMapper.insert(picking);
                int pickingId = pickingMapper.selectLastId();
                int size = picking.getPickingDetailsList().size();
                int i = 0;
                for (PickingDetails pickingDetails:picking.getPickingDetailsList()){
                    i = ++i;
                    if (flag) {
                        for (PickingDetails pickingDetails1 : pickingDetails.getPickingDetailsList()) {
                            pickingDetails1.setPickingId(pickingId);
                            //                    pickingDetails.setPickingId(picking.getPickingId());
                            pickingDetailsMapper.insert(pickingDetails1);
                            //根据领料单Id改领料单出入库仓库Id
                            pickingMapper.updateWarehouseById(pickingId, pickingDetails1.getIntoWarehouseId(), pickingDetails1.getOutWarehouseId());
                        }
                        flag = false;
                    }
                    if (size!=i) {
                        if (!flag){
                            flag = true;
                            noteDcNumber = "10" + RandomCodeUtil.getRandomCode();
                            picking.setPickingNumber(noteDcNumber);//领料单编号
                            picking.setCreateTime(new Date());
                            picking.setState((byte)1);
                            picking.setIsDelete((byte)0);
                            picking.setAddTime(d);
                            picking.setPsId(productionOrder.getProductionOrderId());
                            pickingMapper.insert(picking);
                            pickingId = pickingMapper.selectLastId();
                        }
                    }
                }
            }
        }
        productionOrderMapper.updateByPrimaryKey(productionOrder1);
        List<ProductionOrderDetails> productionOrderDetailsList = productionOrderDetailsMapper.selectProductionOrderDetailsById(productionOrder.getProductionOrderId());
        //排产单详情的修改暂定
        for (ProductionOrderDetails productionOrderDetails:productionOrderDetailsList
             ) {
            productionOrderDetailsMapper.deleteByPrimaryKey(productionOrderDetails.getProductionOrderDetailsId());
        }
        List<ProductionOrderDetails> productionOrderDetailsList1 =productionOrder.getProductionOrderDetailsList();
        int productionInstructionId= 0;
        for (ProductionOrderDetails productionOrderDetails:productionOrderDetailsList1
             ) {
            if(productionInstructionId==0){
                productionInstructionId = productionOrderDetails.getProductionInstructionId();
            }else if(productionInstructionId!=productionOrderDetails.getProductionInstructionId()){
                throw new MyException("编辑失败,排产单内的货物必须属于同一批次");
            }
            BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(productionOrderDetails.getGoodsId());
            if(bomForm==null){
                throw new MyException("编辑失败,部品CD:"+productionOrderDetails.getPartsCd()+"的货物在BOM表单中未找到,请先创建此货物的Bom表单");
            }
            productionOrderDetails.setBomId(bomForm.getBomId());
            productionOrderDetails.setProductionOrderId(productionOrder.getProductionOrderId());
            productionOrderDetails.setInventoryQuantity(BigDecimal.ZERO);
            productionOrderDetails.setStatus((byte)1);
            productionOrderDetails.setStatus((byte)1);
            productionOrderDetailsMapper.insert(productionOrderDetails);
        }

    }

    @Override
    public List<PDAProductionEntryTask> selectPdaProductionEntryTaskList() {
        try{
            return productionOrderMapper.selectPdaProductionEntryTaskList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectPdaProductionEntryListTaskCount() {
        try{
            return productionOrderMapper.selectPdaProductionEntryListTaskCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<ProductionOrderInfo> selectProductionOrderInfoList() {
        try{
            return productionOrderMapper.selectProductionOrderInfoList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountProductionOrderInfoList() {
        try{
          return productionOrderMapper.selectCountProductionOrderInfoList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
