package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.PurchaseApply;
import com.mingyuansoftware.aifactory.model.PurchaseApplyDetails;
import com.mingyuansoftware.aifactory.model.PurchaseOrder;
import com.mingyuansoftware.aifactory.model.dto.PurchaseApplyDetailsDto;
import com.mingyuansoftware.aifactory.model.dto.PurchaseApplyDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/7/9 15:43
 */

@Service
public interface PurchaseApplyService {
    /**
     * 获取采购申请单列表
     * @param purchaseApplyDto
     * @return
     */
    List<PurchaseApplyDetailsDto> selectpurchaseApplyList(PurchaseApplyDto purchaseApplyDto);

    /**
     * 获取采购申请单列表条数
     * @param purchaseApplyDto
     * @return
     */
    int selectCount(PurchaseApplyDto purchaseApplyDto);

    /**
     * 新增采购申请单
     * @param purchaseApply
     * @return
     */
    int insertPurchaseApply(PurchaseApply purchaseApply);

    /**
     * 逻辑删除采购申请单
     * @param purchaseApplyDetailsId
     * @return
     */
    int deletePurchaseApply(int purchaseApplyDetailsId);

    /**
     * 根据采购申请单详情id获取采购申请单信息
     * @param purchaseApplyDetailsId
     * @return
     */
    PurchaseApply selectPurchaseApplyById(int purchaseApplyDetailsId);

    /**
     * 更新采购申请单
     * @param purchaseApply
     * @return
     */
    int updatePurchaseApply(PurchaseApply purchaseApply);

    /**
     * 获取导出的采购申请单列表
     * @return
     */
    List<PurchaseApplyDto> selectExportPurchaseApplyList();

    /**
     * 根据采购申请单详情id查询供应商
     * @param purchaseApply
     * @return
     */

    PurchaseApply selectCreatePurchaseOrder(PurchaseApply purchaseApply);

    /**
     * 生成采购订单
     * @param purchaseOrder
     * @return
     */
    int createPurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 查询查询采购申请单详情处理状态
     * @param purchaseApply
     * @return
     */
    int selectHandleStatus(PurchaseApply purchaseApply);
}
