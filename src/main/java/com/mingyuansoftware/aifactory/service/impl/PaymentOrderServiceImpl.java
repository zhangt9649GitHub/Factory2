package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.PaymentOrderDto;
import com.mingyuansoftware.aifactory.model.dto.PurchaseOrderDetailsDto;
import com.mingyuansoftware.aifactory.model.dto.ReimburseDto;
import com.mingyuansoftware.aifactory.service.PaymentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/7/17 15:00
 */

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

    @Autowired
    private PaymentOrderMapper paymentOrderMapper;
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private ReimburseMapper reimburseMapper;
    @Autowired
    private PayrollMapper payrollMapper;
    @Autowired
    private SalesReturnMapper salesReturnMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private SupplierMapper supplierMapper;


    @Override
    public List<PaymentOrder> selectPaymentOrderList(PaymentOrderDto paymentOrderDto) {
        try {
            return paymentOrderMapper.selectPaymentOrderList(paymentOrderDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(PaymentOrderDto paymentOrderDto) {
        try {
            return paymentOrderMapper.selectCount(paymentOrderDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*加法 add()函数     减法subtract()函数  乘法multipy()函数    除法divide()函数    绝对值abs()函数*/

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insertPaymentOrder(PaymentOrder paymentOrder) {
        String name = staffMapper.selectByPrimaryKey(paymentOrder.getStaffId()).getName();
        paymentOrder.setIsDelete((byte) 0);
        paymentOrder.setCreateTime(new Date());
        //设置查看的代付款金额
        paymentOrder.setPendingPaymentAmountView(paymentOrder.getPendingPaymentAmount());
        BigDecimal paymentAmount = paymentOrder.getPaymentAmount(); //付款金额
        BigDecimal pendingPaymentAmount = null;  //待付款金额
        if ("采购付款".equals(paymentOrder.getCategory())) {
            PurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(paymentOrder.getAssociatedDocumentId());
            if (purchaseOrder.getPaymentStatus() == 3) {  //3.已付款
                return 0;
            }
            /*if (purchaseOrder.getStorageState() == 3) {  //3.已入库
                return 0;
            }*/
            PurchaseOrderDetailsDto purchaseOrderDetailsDto = new PurchaseOrderDetailsDto();
            purchaseOrderDetailsDto.setPurchaseOrderNumber(paymentOrder.getAssociatedDocument());
            purchaseOrderDetailsDto.setPaymentDate(new Date());

            //折扣金额:折扣金额(采购订单)+折扣金额(付款) 进行累加
            BigDecimal discountAmount = purchaseOrder.getDiscountAmount().add(paymentOrder.getDiscountAmount());
            //采购订单:实付金额=实付金额(采购订单)+付款金额(付款)+核销金额(付款)
            BigDecimal actuallyPaidAmount = purchaseOrder.getActuallyPaidAmount().add(paymentAmount.add(paymentOrder.getWriteOffAmount()));
            //待付款金额=单据金额(付)-(实付金额(订)+折扣金额)
            pendingPaymentAmount = paymentOrder.getAmount().subtract(actuallyPaidAmount.add(discountAmount));
            //比较待付款金额和0,修改采购订单的付款状态 1.未付款 2.部分付款 3.已付款
            if (pendingPaymentAmount.compareTo(BigDecimal.ZERO) == 0) {//如果pendingPaymentAmount.compareTo(0)==0
                purchaseOrderDetailsDto.setPaymentStatus((byte) 3);
            } else if (pendingPaymentAmount.compareTo(BigDecimal.ZERO) == 1) {//如果pendingPaymentAmount.compareTo(0)>0
                purchaseOrderDetailsDto.setPaymentStatus((byte) 2);
            }
            //待核销金额
            paymentOrder.setPendingWriteOffAmount(paymentOrder.getPendingWriteOffAmount());
            purchaseOrderDetailsDto.setDiscountAmount(discountAmount);
            purchaseOrderDetailsDto.setActuallyPaidAmount(actuallyPaidAmount);
            purchaseOrderDetailsDto.setPendingAmount(pendingPaymentAmount);
            paymentOrder.setPendingPaymentAmount(pendingPaymentAmount);
            purchaseOrderMapper.updateByPurchaseOrderNumber(purchaseOrderDetailsDto);
            //根据供应商Id使用核销金额(核销金额(供应商)=核销金额(供应商)-核销金额(付款))
            supplierMapper.updateWriteOffAmountBySId(purchaseOrder.getSupplierId(),paymentOrder.getWriteOffAmount());
            name = paymentOrderMapper.selectStaffNameById(paymentOrder.getStaffId());
        }
        if ("报销付款".equals(paymentOrder.getCategory())) {
            //查询报销单付款状态
            Reimburse reimburse = reimburseMapper.selectByPrimaryKey(paymentOrder.getAssociatedDocumentId());
            if (reimburse.getState() == 2) {  //2.已付款
                return 0;
            }
            ReimburseDto reimburseDto = new ReimburseDto();
            reimburseDto.setState((byte) 2);  //修改报销单付款状态 2.已付款
            reimburseDto.setReimburseNumber(paymentOrder.getAssociatedDocument());
            reimburseMapper.updateByNumber(reimburseDto);
            name = paymentOrderMapper.selectStaffNameById(paymentOrder.getStaffId());
            paymentOrder.setDiscountAmount(BigDecimal.ZERO);//无折扣金额  暂时
        }
        if ("工资付款".equals(paymentOrder.getCategory())) {
            Payroll payroll = payrollMapper.selectByPrimaryKey(paymentOrder.getAssociatedDocumentId());
            if (payroll.getState() == 3) {  // 3.已付款
                return 0;
            }
            //修改工资单的付款时间和状态  3.已付款
            int state = 3;
            payrollMapper.updateStateById(paymentOrder.getAssociatedDocumentId(), state);
            name = paymentOrderMapper.selectStaffNameById(paymentOrder.getStaffId());
            paymentOrder.setDiscountAmount(BigDecimal.ZERO);//无折扣金额  暂时
        }
        if ("退货付款".equals(paymentOrder.getCategory())) {
            //销售退货
            SalesReturn salesReturn = salesReturnMapper.selectByPrimaryKey(paymentOrder.getAssociatedDocumentId());
            if (salesReturn.getPaymentStatus() == 3) {  //3.已回款
                return 0;
            }
            SalesReturn salesReturn1 = new SalesReturn();
            //修改销售退货单的回款状态 1.未回款 2.部分回款 3.已回款
            if (salesReturn.getAmountReceived().add(paymentAmount.add(paymentOrder.getWriteOffAmount())).compareTo(salesReturn.getAmount()) == 0) {//如果(已收金额+付款金额+核销金额)compareTo(金额)==0
                salesReturn1.setPaymentStatus((byte) 3);
            } else if (salesReturn.getAmountReceived().add(paymentAmount.add(paymentOrder.getWriteOffAmount())).compareTo(salesReturn.getAmount()) == -1) {//如果(已收金额+付款金额+核销金额)compareTo(金额)<0
                salesReturn1.setPaymentStatus((byte) 2);
            }else {     //金额有误
                System.out.println("erro!!!!金额有误");
                return 0;
            }
            salesReturn1.setSalesReturnId(paymentOrder.getAssociatedDocumentId());
            //销售退货单:已收金额=已收金额+付款金额+核销金额
            BigDecimal amountReceived = salesReturn.getAmountReceived().add(paymentAmount).add(paymentOrder.getWriteOffAmount());
            salesReturn1.setAmountReceived(amountReceived);//已收金额
            salesReturn1.setOutstandingAmount(paymentOrder.getAmount().subtract(amountReceived));//未收金额
            //待付款金额:单据金额(付)-(已收金额(销))
            pendingPaymentAmount = paymentOrder.getAmount().subtract(amountReceived);
            paymentOrder.setPendingPaymentAmount(pendingPaymentAmount);
            //待核销金额
            paymentOrder.setPendingWriteOffAmount(paymentOrder.getPendingWriteOffAmount());
            salesReturnMapper.updatePaymentInfoById(salesReturn1);
            BigDecimal writeOffAmountCus = customerMapper.selectCustomerByCId(salesReturn.getCustomerId()).getWriteOffAmount();
            //根据客户Id修改:核销金额(客户)+付款金额(付款)-核销金额(付款)
            customerMapper.updateWriteOffAmountByCId(salesReturn.getCustomerId(), writeOffAmountCus.add(paymentAmount).subtract(paymentOrder.getWriteOffAmount()));
            name = paymentOrderMapper.selectStaffNameById(paymentOrder.getStaffId());
            paymentOrder.setDiscountAmount(BigDecimal.ZERO);//无折扣金额  暂时
        }
        if ("其他付款".equals(paymentOrder.getCategory())) {
            name = paymentOrderMapper.selectStaffNameById(paymentOrder.getStaffId());
//            paymentOrder.setDiscountAmount(BigDecimal.ZERO);//无折扣金额  暂时
        }
        paymentOrder.setName(name);
        return paymentOrderMapper.insert(paymentOrder);
    }

    @Override
    public List<PaymentOrder> selectPaymentOrderSupplierList() {
        try {
            return purchaseOrderMapper.selectPaymentOrderSupplierList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectSuplierCount() {
        try {
            return purchaseOrderMapper.selectSuplierCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deletePaymentOrder(int paymentOrderId) {
        return paymentOrderMapper.updatePaymentOrderById(paymentOrderId);
    }

    @Override
    public PaymentOrder selectPaymentOrderById(int paymentOrderId) {
        try {
            return paymentOrderMapper.selectByPrimaryKey(paymentOrderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
