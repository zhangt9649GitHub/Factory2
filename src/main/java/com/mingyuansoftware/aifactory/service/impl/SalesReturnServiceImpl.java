package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.SalesReturnDto;
import com.mingyuansoftware.aifactory.service.SalesReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class SalesReturnServiceImpl implements SalesReturnService {

    @Autowired
    private SalesReturnMapper salesReturnMapper;
    @Autowired
    private SalesReturnDetailsMapper salesReturnDetailsMapper;
    @Autowired
    private StockKucunGoodsMapper stockKucunGoodsMapper;
    @Autowired
    private SalesOrderDetailsMapper salesOrderDetailsMapper;


    @Override
    public List<SalesReturn> selectSalesReturnList(SalesReturnDto salesReturnDto) {
        try{
            return salesReturnMapper.selectSalesReturnList(salesReturnDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectSalesReturnCount(SalesReturnDto salesReturnDto) {
        try{
            return salesReturnMapper.selectSalesReturnCount(salesReturnDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertSalesReturn(SalesReturn salesReturn) {
        salesReturn.setCreateTime(new Date());
        salesReturn.setIsDelete((byte)0);
       /*Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
         int staffId = staff.getStaffId();
        salesReturn.setStaffId(staffId);*/
        //订单状态为已创建
        salesReturn.setState((byte)1);
        //回款状态为未回款
        salesReturn.setPaymentStatus((byte)1);
        salesReturn.setAmountReceived(BigDecimal.ZERO);
        salesReturn.setOutstandingAmount(salesReturn.getAmount());
        salesReturnMapper.insert(salesReturn);
        List<SalesReturnDetails> salesReturnDetailsList = salesReturn.getSalesReturnDetailsList();
        if(!(salesReturnDetailsList.isEmpty())){
            for (SalesReturnDetails salesReturnDetails:salesReturnDetailsList
            ) {
                salesReturnDetails.setNoArrivedQuantity(salesReturnDetails.getQuantity());
                salesReturnDetails.setArrivedQuantity(BigDecimal.ZERO);
                salesReturnDetails.setSalesReturnId(salesReturn.getSalesReturnId());
                salesReturnDetailsMapper.insert(salesReturnDetails);
            }
        }
    }

    @Override
    public SalesReturn selectSalesReturnById(int salesReturnId) {
        try{
            SalesReturn salesReturn = salesReturnMapper.selectByPrimaryKey(salesReturnId);
            List<SalesReturnDetails> salesReturnDetailsList = salesReturnDetailsMapper.selectSalesReturnDetailsById(salesReturnId);
            if(!(salesReturnDetailsList.isEmpty())){
                for (SalesReturnDetails salesReturnDetails:salesReturnDetailsList
                     ) {
                    //根据销售订单id和货物id查询此货物的销售订单数量
                   SalesOrderDetails salesOrderDetails = salesOrderDetailsMapper.selectGoodsQuantityById(salesReturn.getSalesOrderId(),salesReturnDetails.getGoods().getGoodsId());
                   if(salesOrderDetails!=null&&salesOrderDetails.getQuantity()!=null) {
                       salesReturnDetails.setOrderQuantity(salesOrderDetails.getQuantity());
                   }else{
                       salesReturnDetails.setOrderQuantity(BigDecimal.ZERO);
                   }
                    KucunGoods kucunGoods = stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(salesReturnDetails.getGoods().getGoodsId());
                    if(kucunGoods!=null&& kucunGoods.getSkgCount()!=null){
                        salesReturnDetails.setSkgCount(kucunGoods.getSkgCount());
                    }else{
                        salesReturnDetails.setSkgCount(BigDecimal.ZERO);
                    }
                }
            }
            salesReturn.setSalesReturnDetailsList(salesReturnDetailsList);
            return salesReturn;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateSalesReturnInfo(SalesReturn salesReturn) {
        SalesReturn salesReturn1 = salesReturnMapper.selectByPrimaryKey(salesReturn.getSalesReturnId());
        salesReturn.setCreateTime(salesReturn1.getCreateTime());
        salesReturn.setState(salesReturn1.getState());
        salesReturn.setIsDelete(salesReturn1.getIsDelete());
        salesReturn.setUpdateTime(new Date());
        salesReturn.setPaymentStatus(salesReturn1.getPaymentStatus());
        salesReturn.setSalesReturnNumber(salesReturn1.getSalesReturnNumber());
        salesReturn.setAmountReceived(BigDecimal.ZERO);
        salesReturn.setOutstandingAmount(salesReturn.getAmount());
        salesReturnMapper.updateByPrimaryKey(salesReturn);
        List<SalesReturnDetails> salesReturnDetailsList1 = salesReturnDetailsMapper.selectSalesReturnDetailsById(salesReturn.getSalesReturnId());
        for (SalesReturnDetails salesReturnDetails:salesReturnDetailsList1
             ) {
            salesReturnDetailsMapper.deleteByPrimaryKey(salesReturnDetails.getSalesReturnDetailsId());
        }
        List<SalesReturnDetails> salesReturnDetailsList = salesReturn.getSalesReturnDetailsList();
        for (SalesReturnDetails salesReturnDetails:salesReturnDetailsList
             ) {
            salesReturnDetails.setNoArrivedQuantity(salesReturnDetails.getQuantity());
            salesReturnDetails.setArrivedQuantity(BigDecimal.ZERO);
            salesReturnDetails.setSalesReturnId(salesReturn.getSalesReturnId());
            salesReturnDetailsMapper.insert(salesReturnDetails);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteSalesReturnById(int salesReturnId) {
        salesReturnMapper.updateSalesReturnById(salesReturnId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateSalesReturnState(int salesReturnId) {
        //更新销售退货单的状态为已入库
        salesReturnMapper.updateSalesReturnState(salesReturnId);
        SalesReturn salesReturn = salesReturnMapper.selectByPrimaryKey(salesReturnId);
       List<SalesReturnDetails> salesReturnDetailsList = salesReturnDetailsMapper.selectSalesReturnDetailsById(salesReturnId);
        for (SalesReturnDetails salesReturnDetails:salesReturnDetailsList
             ) {
            salesReturnDetailsMapper.updateQuantity(salesReturnDetails.getSalesReturnDetailsId(),salesReturnDetails.getQuantity());
            SalesOrderDetails salesOrderDetails = salesOrderDetailsMapper.selectReturnQuantity(salesReturn.getSalesOrderId(),salesReturnDetails.getGoods().getGoodsId());
            BigDecimal quantity = salesOrderDetails.getReturnAmount().add(salesReturnDetails.getQuantity());
            //更新销售订单的退货数量
            salesOrderDetailsMapper.updateReturnQuantity(salesReturn.getSalesOrderId(),salesReturnDetails.getGoods().getGoodsId(),quantity);
        }
    }

    @Override
    public List<SalesReturn> selectSalesReturnListForPayment() {
        try {
            return salesReturnMapper.selectSalesReturnListForPayment();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
