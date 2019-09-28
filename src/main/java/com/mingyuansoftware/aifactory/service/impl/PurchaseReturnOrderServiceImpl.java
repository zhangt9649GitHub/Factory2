package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.PurchaseReturnOrderDto;
import com.mingyuansoftware.aifactory.service.PurchaseReturnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/7/26 15:33
 */

@Service
public class PurchaseReturnOrderServiceImpl implements PurchaseReturnOrderService {

    @Autowired
    private PurchaseReturnOrderMapper purchaseReturnOrderMapper;
    @Autowired
    private PurchaseReturnOrderDetailsMapper purchaseReturnOrderDetailsMapper;
    @Autowired
    private StockKucunGoodsMapper stockKucunGoodsMapper;
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private PurchaseOrderDetailsMapper purchaseOrderDetailsMapper;
    @Autowired
    private NoteDocumentMapper noteDocumentMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private SupplierGoodsMapper supplierGoodsMapper;

    @Override
    public List<PurchaseReturnOrderDto> selectPurchaseReturnOrderList(PurchaseReturnOrderDto purchaseReturnOrderDto) {
        try {
            return purchaseReturnOrderMapper.selectPurchaseReturnOrderList(purchaseReturnOrderDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectPurchaseReturnOrderCount(PurchaseReturnOrderDto purchaseReturnOrderDto) {
        try {
            return purchaseReturnOrderMapper.selectPurchaseReturnOrderCount(purchaseReturnOrderDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PurchaseOrder> selectPurchaseOrderBySupplierId(Integer supplierId) {
        try {
            List<PurchaseOrder> purchaseOrderList = purchaseOrderMapper.selectPurchaseOrderBySupplierId(supplierId);
            return purchaseOrderList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectPurchaseOrderCount(Integer supplierId) {
        try {
            return purchaseOrderMapper.selectPurchaseOrderCount(supplierId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PurchaseOrderDetails> selectPurchaseOrderGoodsList(int purchaseOrderId,String partsCd,String goodsName) {
        try {
            return purchaseOrderDetailsMapper.selectPurchaseOrderGoodsList(purchaseOrderId,partsCd,goodsName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectSalesReturnGoodsCount(int purchaseOrderId,String partsCd,String goodsName) {
        try {
            return purchaseOrderDetailsMapper.selectSalesReturnGoodsCount(purchaseOrderId,partsCd,goodsName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insertPurchaseReturnOrder(PurchaseReturnOrder purchaseReturnOrder) {
        purchaseReturnOrder.setIsDelete((byte) 0);
        purchaseReturnOrder.setCreateTime(new Date());
        purchaseReturnOrder.setStorageState((byte) 1);//出库状态:1.未出库
        purchaseReturnOrder.setPaymentStatus((byte) 1);//收款状态:1.未结算
        //采购退货金额是合计金额  ,设置未收款金额为采购退货金额,收款金额为0
        purchaseReturnOrder.setNoneReceiveAmount(purchaseReturnOrder.getPurchaseReturnAmount());
        purchaseReturnOrder.setReceivingAmount(BigDecimal.ZERO);
        int insertPro = purchaseReturnOrderMapper.insert(purchaseReturnOrder);
        int proId = purchaseReturnOrderMapper.selectLastId();
        List<PurchaseReturnOrderDetails> purchaseReturnOrderDetailsList = purchaseReturnOrder.getPurchaseReturnOrderDetailsList();
        if (!(purchaseReturnOrderDetailsList.isEmpty())) {
            for (PurchaseReturnOrderDetails purchaseReturnOrderDetails : purchaseReturnOrderDetailsList) {
                purchaseReturnOrderDetails.setProId(proId);
                purchaseReturnOrderDetails.setLeaveQuantity(BigDecimal.ZERO);
                purchaseReturnOrderDetails.setNoLeaveQuantity(purchaseReturnOrderDetails.getReturnQuantity());
                purchaseReturnOrderDetailsMapper.insert(purchaseReturnOrderDetails);
            }
        }
        return insertPro;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deletePurchaseReturnOrder(int proId) {
        return purchaseReturnOrderMapper.deletePROByProId(proId);
    }

    @Override
    public PurchaseReturnOrder selectPurchaseReturnOrderByProId(int proId) {
        try {
            PurchaseReturnOrder purchaseReturnOrder = purchaseReturnOrderMapper.selectByPrimaryKey(proId);
            List<PurchaseReturnOrderDetails> purchaseReturnOrderDetailsList = purchaseReturnOrderDetailsMapper.selectPurchaseReturnOrderDetailsByProId(proId);
            if (!(purchaseReturnOrderDetailsList.isEmpty())) {
                for (PurchaseReturnOrderDetails purchaseReturnOrderDetails : purchaseReturnOrderDetailsList) {
                    //根据采购订单id和货物id查询此货物的采购订单数量
                    PurchaseOrderDetails purchaseOrderDetails = purchaseOrderDetailsMapper.selectGoodsQuantityById(purchaseReturnOrder.getPurchaseOrderId(), purchaseReturnOrderDetails.getGoodsId());
                    if (purchaseOrderDetails != null && purchaseOrderDetails.getQuantity() != null) {
                        purchaseReturnOrderDetails.setQuantity(purchaseOrderDetails.getQuantity());
                    } else {
                        purchaseReturnOrderDetails.setQuantity(BigDecimal.ZERO);
                    }
                    KucunGoods kucunGoods = stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(purchaseReturnOrderDetails.getGoodsId());
                    if (kucunGoods != null && kucunGoods.getSkgCount() != null) {
                        //重新计数(库存数量)
                        purchaseReturnOrderDetails.setSkgCount(kucunGoods.getSkgCount());
                    } else {
                        purchaseReturnOrderDetails.setSkgCount(BigDecimal.ZERO);
                    }
                }
            }
            purchaseReturnOrder.setPurchaseReturnOrderDetailsList(purchaseReturnOrderDetailsList);
            return purchaseReturnOrder;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updatePurchaseReturnOrderInfo(PurchaseReturnOrder purchaseReturnOrder) {
        PurchaseReturnOrder purchaseReturnOrder1 = purchaseReturnOrderMapper.selectByPrimaryKey(purchaseReturnOrder.getProId());

        purchaseReturnOrder.setPurchaseReturnOrderNumber(purchaseReturnOrder1.getPurchaseReturnOrderNumber());
        purchaseReturnOrder.setStaffId(purchaseReturnOrder1.getStaffId());
        purchaseReturnOrder.setStorageTime(purchaseReturnOrder1.getStorageTime());
        purchaseReturnOrder.setStorageState(purchaseReturnOrder1.getStorageState());
        purchaseReturnOrder.setPaymentDate(purchaseReturnOrder1.getPaymentDate());
        purchaseReturnOrder.setPaymentStatus(purchaseReturnOrder1.getPaymentStatus());
        purchaseReturnOrder.setCreateTime(purchaseReturnOrder1.getCreateTime());
        purchaseReturnOrder.setUpdateTime(new Date());
        purchaseReturnOrder.setIsDelete(purchaseReturnOrder1.getIsDelete());
        //采购退货金额是合计金额  ,设置未收款金额为采购退货金额,收款金额为0
        purchaseReturnOrder.setNoneReceiveAmount(purchaseReturnOrder.getPurchaseReturnAmount());
        purchaseReturnOrder.setReceivingAmount(BigDecimal.ZERO);
        int updatePROInfo = purchaseReturnOrderMapper.updateByPrimaryKey(purchaseReturnOrder);
        List<PurchaseReturnOrderDetails> purchaseReturnOrderDetailsList1 = purchaseReturnOrderDetailsMapper.selectPurchaseReturnOrderDetailsByProId(purchaseReturnOrder.getProId());
        for (PurchaseReturnOrderDetails purchaseReturnOrderDetails : purchaseReturnOrderDetailsList1) {
            purchaseReturnOrderDetailsMapper.deleteByPrimaryKey(purchaseReturnOrderDetails.getProdId());
        }
        List<PurchaseReturnOrderDetails> purchaseReturnOrderDetailsList = purchaseReturnOrder.getPurchaseReturnOrderDetailsList();
        for (PurchaseReturnOrderDetails purchaseReturnOrderDetails : purchaseReturnOrderDetailsList) {
            purchaseReturnOrderDetails.setProId(purchaseReturnOrder.getProId());
            purchaseReturnOrderDetails.setLeaveQuantity(BigDecimal.ZERO);
            purchaseReturnOrderDetails.setNoLeaveQuantity(purchaseReturnOrderDetails.getReturnQuantity());
            purchaseReturnOrderDetailsMapper.insert(purchaseReturnOrderDetails);
        }

        //感觉有问题:只要退货操作就修改所有的采购订单状态和注文书状态  测试

        return updatePROInfo;
    }

    @Override
    public List<PurchaseReturnOrderDto> selectExportPurchaseReturnOrderList() {
        try {
            return purchaseReturnOrderMapper.selectExportPurchaseReturnOrderList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updatePurchaseReturnOrderStorageState(int purchaseReturnOrderId) {
        //编辑采购退货单的出库状态为已出库
        int updatePurchaseReturnOrderStorageState = purchaseReturnOrderMapper.updatePurchaseReturnOrderStorageState(purchaseReturnOrderId);
        PurchaseReturnOrder purchaseReturnOrder = purchaseReturnOrderMapper.selectByPrimaryKey(purchaseReturnOrderId);
        List<PurchaseReturnOrderDetails> purchaseReturnOrderDetailsList = purchaseReturnOrderDetailsMapper.selectPurchaseReturnOrderDetailsByProId(purchaseReturnOrderId);
        for (PurchaseReturnOrderDetails purchaseReturnOrderDetails : purchaseReturnOrderDetailsList) {
            //更新采购退货单详情中货物的已出库数量
            purchaseReturnOrderDetailsMapper.updateQuantity(purchaseReturnOrderDetails.getProdId(), purchaseReturnOrderDetails.getReturnQuantity());
            //采购订单的货物不能为空

            //更新采购订单详情的已退货数量
            purchaseOrderDetailsMapper.updateReturnQuantity(purchaseReturnOrder.getPurchaseOrderId(), purchaseReturnOrderDetails.getGoodsId(), purchaseReturnOrderDetails.getReturnQuantity());
            //更新采购订单详情的已入库数量,已入库数量:采购数量-已退货数量
            BigDecimal returnQuantity = purchaseOrderDetailsMapper.selectPDaPurchaseOrderDetailsByProIdAndGoodsId(purchaseReturnOrder.getPurchaseOrderId(), purchaseReturnOrderDetails.getGoodsId()).getPurchaseReturnAmount();
            purchaseOrderDetailsMapper.updateInQuantity(purchaseReturnOrder.getPurchaseOrderId(), purchaseReturnOrderDetails.getGoodsId(),returnQuantity);

            //更新供应商货物中的数量(退货数量*(-1))
            SupplierGoods supplierGoods = new SupplierGoods();
            supplierGoods.setSupplierId(purchaseReturnOrder.getSupplierId());
            supplierGoods.setPartsCd(goodsMapper.selectByPrimaryKey(purchaseReturnOrderDetails.getGoodsId()).getPartsCd());
            supplierGoods.setQuantity(purchaseReturnOrderDetails.getReturnQuantity().multiply(new BigDecimal(-1)));
            supplierGoodsMapper.updateQuantityBy(supplierGoods);

            //修改采购订单退货情况: 1.无退货 2.已退货
            int state = 2;
            purchaseOrderMapper.updatePurchaseReturnSituationById(purchaseReturnOrder.getPurchaseOrderId(),state);

            //修改注文书状态: 3.退换货   (注文书状态 1.无采购 2.采购中 3.退换货 4.交货期 5.订购/预警 6.已完成)
            state = 3;
            noteDocumentMapper.updateNdStatusByPurchaseOrderId(purchaseReturnOrder.getPurchaseOrderId(), state);
        }
        return updatePurchaseReturnOrderStorageState;
    }

    @Override
    public List<PurchaseReturnOrderDto> selectPurchaseReturnOrderListForReceipt() {
        try {
            return purchaseReturnOrderMapper.selectPurchaseReturnOrderListForReceipt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
