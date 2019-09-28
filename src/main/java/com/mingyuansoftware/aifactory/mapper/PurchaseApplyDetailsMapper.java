package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PurchaseApplyDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PurchaseApplyDetailsMapper {
    int deleteByPrimaryKey(Integer purchaseApplyDetailsId);

    int insert(PurchaseApplyDetails record);

    PurchaseApplyDetails selectByPrimaryKey(Integer purchaseApplyDetailsId);

    List<PurchaseApplyDetails> selectAll();

    int updateByPrimaryKey(PurchaseApplyDetails record);

    /**
     * 根据采购申请单详情id删除详情表中的数据
     * @param purchaseApplyDetailsId
     */
    void deletePurchaseApplyDetails(@Param("purchaseApplyDetailsId") Integer purchaseApplyDetailsId);

    /**
     * 根据采购申请单id查询采购申请单详情
     * @param purchaseApplyId
     */
    List<PurchaseApplyDetails> selectPurchaseApplyDetailsByPaId(@Param("purchaseApplyId") Integer purchaseApplyId);

    /**
     * 根据采购申请单id查询供应商id
     * @param purchaseApplyDetailsId
     * @return
     */
    Integer selectSupplierIdById(@Param("purchaseApplyDetailsId") Integer purchaseApplyDetailsId);

    /**
     * 修改处理状态
     * @param purchaseApplyDetailsId
     */
    void updateHandleStatusById(@Param("purchaseApplyDetailsId") Integer purchaseApplyDetailsId);

    /**
     * 根据采购申请单Id逻辑删除
     * @param purchaseApplyDetailsId
     * @return
     */
    int updatePurchaseApplyDetailsById(@Param("purchaseApplyDetailsId") int purchaseApplyDetailsId);
}