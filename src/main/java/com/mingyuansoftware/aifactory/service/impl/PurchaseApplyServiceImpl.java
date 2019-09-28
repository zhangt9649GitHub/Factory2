package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.PurchaseApplyDetailsDto;
import com.mingyuansoftware.aifactory.model.dto.PurchaseApplyDto;
import com.mingyuansoftware.aifactory.service.PurchaseApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 张婷
 * @date 2019/7/9 15:44
 */

@Service
public class PurchaseApplyServiceImpl implements PurchaseApplyService {

    @Autowired
    private PurchaseApplyMapper purchaseApplyMapper;
    @Autowired
    private PurchaseApplyDetailsMapper purchaseApplyDetailsMapper;
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private PurchaseOrderDetailsMapper purchaseOrderDetailsMapper;
    @Autowired
    private NoteDocumentMapper noteDocumentMapper;

    @Override
    public List<PurchaseApplyDetailsDto> selectpurchaseApplyList(PurchaseApplyDto purchaseApplyDto) {
        try {
            return purchaseApplyMapper.selectpurchaseApplyList(purchaseApplyDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(PurchaseApplyDto purchaseApplyDto) {
        try {
            return purchaseApplyMapper.selectCount(purchaseApplyDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insertPurchaseApply(PurchaseApply purchaseApply) {
        purchaseApply.setIsDelete((byte) 0);
        purchaseApply.setCreateTime(new Date());
        int insertPurchaseApply = purchaseApplyMapper.insert(purchaseApply);
        //获取最新的采购申请单id
        int purchaseApplyId = purchaseApplyMapper.selectLastId();
        List<PurchaseApplyDetails> purchaseApplyDetailsList = purchaseApply.getPurchaseApplyDetailsList();
        if (!(purchaseApplyDetailsList.isEmpty())) {
            for (PurchaseApplyDetails purchaseApplyDetails : purchaseApplyDetailsList) {
                purchaseApplyDetails.setPurchaseApplyId(purchaseApplyId);
                purchaseApplyDetails.setHandleStatus((byte) 1);
                purchaseApplyDetails.setHandleIdea("未生成");
                purchaseApplyDetails.setIsDelete((byte) 0);
                purchaseApplyDetailsMapper.insert(purchaseApplyDetails);
            }
        }
        return insertPurchaseApply;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deletePurchaseApply(int purchaseApplyDetailsId) {
        boolean flag = true;
        //根据采购申请单详情Id查询采购申请单Id
        int purchaseApplyId = purchaseApplyDetailsMapper.selectByPrimaryKey(purchaseApplyDetailsId).getPurchaseApplyId();
        //根据采购申请单详情Id删除数据
        int del = purchaseApplyDetailsMapper.updatePurchaseApplyDetailsById(purchaseApplyDetailsId);
        //根据采购申请单Id查询is_delete字段
        List<PurchaseApplyDetails> purchaseApplyDetailsList = purchaseApplyDetailsMapper.selectPurchaseApplyDetailsByPaId(purchaseApplyId);
        for(PurchaseApplyDetails purchaseApplyDetails:purchaseApplyDetailsList){
            if(purchaseApplyDetails.getIsDelete() == 0){        //还有采购申请单详情数据未删除
                flag = false;
                break;
            }
        }
        if(flag){
            //本条采购申请单下的数据都被逻辑删除,主表也需要修改is_delete字段为1.已删除
            purchaseApplyMapper.updatePurchaseApplyById(purchaseApplyId);
        }
        return del;
    }

    @Override
    public PurchaseApply selectPurchaseApplyById(int purchaseApplyDetailsId) {
        try {
            PurchaseApply purchaseApply = purchaseApplyMapper.selectPurchaseApplyById(purchaseApplyDetailsId);
            PurchaseApplyDetails purchaseApplyDetails = purchaseApplyDetailsMapper.selectByPrimaryKey(purchaseApplyDetailsId);
            purchaseApply.setPurchaseApplyDetails(purchaseApplyDetails);
            return purchaseApply;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updatePurchaseApply(PurchaseApply purchaseApply) {
        //可以编辑  主表:日期,员工,备注,  详情表:数量
        PurchaseApply purchaseApply1 = purchaseApplyMapper.selectPurchaseApplyById(purchaseApply.getPurchaseApplyDetailsId());
        purchaseApply.setPurchaseNumber(purchaseApply1.getPurchaseNumber());
        purchaseApply.setIsDelete(purchaseApply1.getIsDelete());
        purchaseApply.setCreateTime(purchaseApply1.getCreateTime());
        purchaseApply.setUpdateTime(new Date());
        purchaseApply.setPurchaseApplyId(purchaseApply1.getPurchaseApplyId());

        int purApply = purchaseApplyMapper.updateByPrimaryKey(purchaseApply);
        //遍历新的采购单详情内容
        PurchaseApplyDetails purchaseApplyDetails = purchaseApply.getPurchaseApplyDetails();
        if (purchaseApplyDetails != null) {
            //如果没有货物
            if (purchaseApplyDetails.getGoodsId() == null) {
                //根据采购详情id删除数据
                purchaseApplyDetailsMapper.deletePurchaseApplyDetails(purchaseApply.getPurchaseApplyDetailsId());
            } else {
                //如果有货物
                PurchaseApplyDetails purchaseApplyDetails1 = purchaseApplyDetailsMapper.selectByPrimaryKey(purchaseApply.getPurchaseApplyDetailsId());
                purchaseApplyDetails.setPurchaseApplyId(purchaseApplyDetails1.getPurchaseApplyId());
                purchaseApplyDetails.setHandleStatus(purchaseApplyDetails1.getHandleStatus());
                purchaseApplyDetails.setHandleIdea(purchaseApplyDetails1.getHandleIdea());
                purchaseApplyDetails.setIsDelete(purchaseApplyDetails1.getIsDelete());
//                    purchaseApplyDetails.setPurchaseCycle(purchaseApplyDetails1.getPurchaseCycle());
//                    purchaseApplyDetails.setPurpose(purchaseApplyDetails1.getPurpose());
//                    purchaseApplyDetails.setStairPrice(purchaseApplyDetails1.getStairPrice());
                //判断如果通过货物id查到采购详情单id  删除数据,重新插入
                purchaseApplyDetailsMapper.deletePurchaseApplyDetails(purchaseApply.getPurchaseApplyDetailsId());
                purchaseApplyDetailsMapper.insert(purchaseApplyDetails);
            }
        }
        return purApply;
    }

    @Override
    public List<PurchaseApplyDto> selectExportPurchaseApplyList() {
        try {
            return purchaseApplyMapper.selectExportPurchaseApplyList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PurchaseApply selectCreatePurchaseOrder(PurchaseApply purchaseApply) {
        try {
            List<PurchaseApplyDetails> purchaseApplyDetailsList = purchaseApply.getPurchaseApplyDetailsList();
            Set<Integer> supplierIdSet = new TreeSet<>();
            List<PurchaseApplyDetails> purchaseApplyDetailsList1 = new ArrayList<>();

            for (int i = 0; i < purchaseApplyDetailsList.size(); i++) {
                //根据采购申请单id查询供应商,如果供应商不同,返回0--创建失败
//                System.out.println(purchaseApplyDetailsList.get(i).getPurchaseApplyDetailsId());            //遍历出采购申请单id
                Integer supplierId = purchaseApplyDetailsMapper.selectSupplierIdById(purchaseApplyDetailsList.get(i).getPurchaseApplyDetailsId());
                if (supplierId == null) {  //没有供应商
                    return null;
                }
                supplierIdSet.add(supplierId);//将supplierId放入set集合中,set中不能放重复的内容

                //如果set的size()不等于1,一个以上供应商,不能生成
                if (supplierIdSet.size() != 1) {//            System.out.println("大小:" + supplierIdSet.size());//输出set大小
                    return null;
                }
                //如果set的size()等于1,可以生成采购订单,根据详情id查询采购订单需要的内容
//                purchaseApply = purchaseApplyMapper.selectPurchaseApplyById(purchaseApply.getPurchaseApplyId());
                PurchaseApplyDetails purchaseApplyDetails = purchaseApplyDetailsMapper.selectByPrimaryKey(purchaseApplyDetailsList.get(i).getPurchaseApplyDetailsId());
                purchaseApplyDetailsList1.add(purchaseApplyDetails);
            }
            purchaseApply.setPurchaseApplyDetailsList(purchaseApplyDetailsList1);
            return purchaseApply;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int createPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrder.setSalesOrderId(0);
        purchaseOrder.setIsDelete((byte) 0);
        purchaseOrder.setCreateTime(new Date());
        purchaseOrder.setOrderStatus((byte) 1);
        purchaseOrder.setStorageState((byte) 1);
        purchaseOrder.setPaymentStatus((byte) 1);
        purchaseOrder.setDiscountAmount(BigDecimal.ZERO);
        purchaseOrder.setActuallyPaidAmount(BigDecimal.ZERO);
        purchaseOrder.setPurchaseReturnSituation((byte) 1); //1.无退货
        purchaseOrder.setPendingAmount(purchaseOrder.getPurchaseAmount());//设置代付款金额为采购金额
        int insertPurchaseOrder = purchaseOrderMapper.insert(purchaseOrder);
        //获取最新的采购订单id
        int purchaseOrderId = purchaseOrderMapper.selectLastId();
        //获取新增的采购订单的详情的内容
        List<PurchaseOrderDetails> purchaseOrderDetailsList = purchaseOrder.getPurchaseOrderDetailsList();
        if (!(purchaseOrderDetailsList.isEmpty())) {
            for (PurchaseOrderDetails purchaseOrderDetails : purchaseOrderDetailsList) {
                purchaseOrderDetails.setPurchaseOrderId(purchaseOrderId);
                purchaseOrderDetails.setPodStorageState((byte) 1);//设置pda操作货物入库装状态
                purchaseOrderDetails.setPurchaseReturnAmount(BigDecimal.ZERO);
                purchaseOrderDetails.setInQuantity(BigDecimal.ZERO);
                purchaseOrderDetails.setNotInQuantity(purchaseOrderDetails.getQuantity());
                purchaseOrderDetails.setExcludingTaxAmount(BigDecimal.ZERO);
                purchaseOrderDetails.setTaxRate(BigDecimal.ZERO);
                purchaseOrderDetails.setTax(BigDecimal.ZERO);
                //先设置财务金额为0
                if (purchaseOrderDetails.getFinanceMoney() == null) {
                    purchaseOrderDetails.setFinanceMoney(BigDecimal.ZERO);
                }
                purchaseOrderDetailsMapper.insert(purchaseOrderDetails);
                //如果采购申请单详情id不为空,设置处理状态为2,处理意见已生成
                if (purchaseOrderDetails.getPurchaseApplyDetailsId() != null) {
                    purchaseApplyDetailsMapper.updateHandleStatusById(purchaseOrderDetails.getPurchaseApplyDetailsId());
                }
                //如果注文书id不为空,设置注文书状态为:2.采购中,添加采购订单id
                if (purchaseOrderDetails.getNdid() != null) {
                    int state = 2;
                    noteDocumentMapper.updateNdStatusById(purchaseOrderDetails.getNdid(), purchaseOrderId, state);
                }
                //修改货物的a单价的值
//                    goodsMapper.updateAPriceByGoodsId(purchaseOrderDetails.getGoodsId(),purchaseOrderDetails.getPurchasePrice());
            }
        }
        return insertPurchaseOrder;
    }

    @Override
    public int selectHandleStatus(PurchaseApply purchaseApply) {
        try {
            List<PurchaseApplyDetails> purchaseApplyDetailsList = purchaseApply.getPurchaseApplyDetailsList();
            for (int i = 0; i < purchaseApplyDetailsList.size(); i++) {
                PurchaseApplyDetails purchaseApplyDetails = purchaseApplyDetailsMapper.selectByPrimaryKey(purchaseApplyDetailsList.get(i).getPurchaseApplyDetailsId());
                int handleStatus = purchaseApplyDetails.getHandleStatus();
                if (handleStatus == 2) {
                    return 2;
                }
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*
    {
      "purchaseApplyDetailsList":[{"purchaseApplyId":1,"purchaseApplyDetailsId":1}],
      "purchaseApplyId":1,
      "purchaseApplyDetailsId":1,
      "capital": "capital",
      "comment": "comment",
      "defineDate": "2018-08-01",
      "deliveryDate": "2018-08-01",
      "paymentStatus": 1,
      "purchaseAmount": 200,
      "purchaseApplyDetails": {
        "excludingTaxAmount": 1.1,
        "financeMoney": 1.1,
        "quantity": 222,
        "tax": 1.1,
        "taxIncludedAmount": 1.1,
        "taxRate": 1.1
      },
      "purchaseOrderNumber": "1123445566",
      "purchaseType": 1,
      "storageState": 1,
      "storageTime": "2018-08-02"
    }
    */
}
