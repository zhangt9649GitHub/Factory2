/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: ReceiptServiceImpl
 * Author:   EDZ
 * Date:     2019/7/17 10:08
 * Description: 收款单
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.PurchaseReturnOrder;
import com.mingyuansoftware.aifactory.model.Receipt;
import com.mingyuansoftware.aifactory.model.SalesOrder;
import com.mingyuansoftware.aifactory.model.dto.PurchaseReturnOrderDto;
import com.mingyuansoftware.aifactory.model.dto.ReceiptDto;
import com.mingyuansoftware.aifactory.model.dto.SalesOrderDto;
import com.mingyuansoftware.aifactory.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈收款单〉
 *
 * @author EDZ
 * @create 2019/7/17
 * @since 1.0.0
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptMapper receiptMapper;

    @Autowired
    private SalesOrderMapper salesOrderMapper;

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private PurchaseReturnOrderMapper purchaseReturnOrderMapper;
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer receiptId) {
        return receiptMapper.deleteByPrimaryKey(receiptId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Receipt record) {
        record.setCreateTime(new Date());
        record.setIsDelete((byte) 0);
        SalesOrderDto salesOrderDto=new SalesOrderDto();
        salesOrderDto.setSalesOrderNumber(record.getAssociatedDocument());
        List<SalesOrder> salesOrders = salesOrderMapper.selectSalesOrderList(salesOrderDto);
        BigDecimal collectionAmount = record.getCollectionAmount();//收款金额
        BigDecimal writeOffAmount = record.getWriteOffAmount();//核销金额
        BigDecimal pendingWriteOffAmount = record.getPendingWriteOffAmount();//待核销金额
        if("销售收款".equals(record.getCategory())){
            SalesOrder salesOrder1 = salesOrders.get(0);

            SalesOrder salesOrder=new SalesOrder();
            salesOrder.setAmountReceived(salesOrder1.getAmountReceived().add(collectionAmount).add(writeOffAmount));
            salesOrder.setOutstandingAmount(salesOrder1.getOutstandingAmount().subtract(collectionAmount).subtract(writeOffAmount));
            salesOrder.setSalesOrderNumber(record.getAssociatedDocument());
            if(salesOrder1.getAmountReceived().add(collectionAmount).add(writeOffAmount).compareTo(salesOrder1.getAmount())==-1){
                salesOrder.setPaymentStatus((byte) 2);
            }else if(salesOrder1.getAmountReceived().add(collectionAmount).add(writeOffAmount).compareTo(salesOrder1.getAmount())==0){
                salesOrder.setPaymentStatus((byte) 3);
            }else if(salesOrder1.getAmountReceived().add(collectionAmount).add(writeOffAmount).compareTo(BigDecimal.ZERO)==0){
                salesOrder.setPaymentStatus((byte) 1);
            }
            salesOrder.setUpdateTime(new Date());
            salesOrderMapper.updateBySaleNumber(salesOrder);
            Map map = new HashMap();
            map.put("writeOffAmount",pendingWriteOffAmount.subtract(writeOffAmount));
            map.put("customerId",record.getPayerId());
            customerMapper.updateWriteOffAmount(map);
        }
        if("其他收款".equals(record.getCategory())){
        }
        if("采购退货收款".equals(record.getCategory())){
            //采购退货
            //1.查询采购退货单数据3
            PurchaseReturnOrderDto purchaseReturnOrderDto = new PurchaseReturnOrderDto();
            purchaseReturnOrderDto.setPurchaseReturnOrderNumber(record.getAssociatedDocument());
            List<PurchaseReturnOrderDto> purchaseReturnOrderList = purchaseReturnOrderMapper.selectPurchaseReturnOrderList(purchaseReturnOrderDto);
                PurchaseReturnOrderDto purchaseReturnOrderDto1 = purchaseReturnOrderList.get(0);
                //2.判断收款状态==2.已结算
                if(purchaseReturnOrderDto1.getPaymentStatus() == 2){
                    return 0;
                }
                //3.准备采购退货实体类(存放准备修改的付款数据)
                PurchaseReturnOrder purchaseReturnOrder = new PurchaseReturnOrder();
                //4.修改采购退货单的付款状态 ( 1.未结算 2.已结算 3.部分结算)
                if(purchaseReturnOrderDto1.getReceivingAmount().add(collectionAmount.add(writeOffAmount)).compareTo(purchaseReturnOrderDto1.getPurchaseReturnAmount()) == 0) {            //如果(收款金额(采)+收款金额+核销金额)compareTo(采购退货金额)==0  设置采购退货付款状态:2.已结算
                    purchaseReturnOrder.setPaymentStatus((byte)2);
                } else if (purchaseReturnOrderDto1.getReceivingAmount().add(collectionAmount.add(writeOffAmount)).compareTo(purchaseReturnOrderDto1.getPurchaseReturnAmount()) == -1) {   //如果(收款金额(采)+收款金额+核销金额)compareTo(采购退货金额)<0   设置采购退货付款状态:3.部分结算
                    purchaseReturnOrder.setPaymentStatus((byte)3);
                } else {    //金额有误,并且return 0;
                    System.out.println("erro!!!!金额有误");
                    return 0;
                }
                purchaseReturnOrder.setProId(purchaseReturnOrderDto1.getProId());
                //采购退货单:收款金额=收款金额+收款金额+核销金额
                BigDecimal receivingAmount = purchaseReturnOrderDto1.getReceivingAmount().add(collectionAmount).add(writeOffAmount);
                //设置收款金额,未收金额(采购退货金额-已付金额)
                purchaseReturnOrder.setReceivingAmount(receivingAmount);//收款金额
                purchaseReturnOrder.setNoneReceiveAmount(purchaseReturnOrderDto1.getPurchaseReturnAmount().subtract(receivingAmount));//未收金额
                //应收金额:单据金额(付)-收款金额(采)
                BigDecimal amountReceivable = record.getAmount().subtract(receivingAmount);
                record.setAmountReceivable(record.getAmountReceivable());
                //收款单设置待核销金额
                record.setPendingWriteOffAmount(record.getPendingWriteOffAmount());
                //修改采购退货单的付款金额(采购退货单的实体类)
                purchaseReturnOrderMapper.updateReceiptInfoById(purchaseReturnOrder);
                //核销金额(供应商)
                BigDecimal writeOffAmountSup = supplierMapper.selectByPrimaryKey(purchaseReturnOrderDto1.getSupplierId()).getPendingAmount();
                //根据供应商Id修改:核销金额(供应商)+收款金额(收)-核销金额(收)
                supplierMapper.updatePendingAmountBySId(purchaseReturnOrderDto1.getSupplierId(),writeOffAmountSup.add(collectionAmount).subtract(writeOffAmount));
        }
        return receiptMapper.insert(record);
    }

    @Override
    public Receipt selectByPrimaryKey(Integer receiptId) {
        return receiptMapper.selectByPrimaryKey(receiptId);
    }

    @Override
    public List<Receipt> selectAll(ReceiptDto receiptDto) {
        return receiptMapper.selectAll(receiptDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(Receipt record) {
        record.setUpdateTime(new Date());
        SalesOrderDto salesOrderDto=new SalesOrderDto();
        salesOrderDto.setSalesOrderNumber(record.getAssociatedDocument());
        List<SalesOrder> salesOrders = salesOrderMapper.selectSalesOrderList(salesOrderDto);
        SalesOrder salesOrder1 = salesOrders.get(0);
        if("销售收款".equals(record.getCategory())){
            BigDecimal collectionAmount = record.getCollectionAmount();
            SalesOrder salesOrder=new SalesOrder();
            salesOrder.setAmountReceived(salesOrder1.getAmountReceived().add(collectionAmount));
            salesOrder.setOutstandingAmount(salesOrder1.getOutstandingAmount().subtract(collectionAmount));
            salesOrder.setSalesOrderNumber(record.getAssociatedDocument());
            if(salesOrder1.getAmountReceived().add(collectionAmount).compareTo(salesOrder1.getAmount())==-1){
                salesOrder.setPaymentStatus((byte) 2);
            }else if(salesOrder1.getAmountReceived().add(collectionAmount).compareTo(salesOrder1.getAmount())==0){
                salesOrder.setPaymentStatus((byte) 3);
            }else if(salesOrder1.getAmountReceived().add(collectionAmount).compareTo(BigDecimal.ZERO)==0){
                salesOrder.setPaymentStatus((byte) 1);
            }
            salesOrder.setUpdateTime(new Date());
            salesOrderMapper.updateBySaleNumber(salesOrder);
        }


        return receiptMapper.updateByPrimaryKey(record);
    }
}
