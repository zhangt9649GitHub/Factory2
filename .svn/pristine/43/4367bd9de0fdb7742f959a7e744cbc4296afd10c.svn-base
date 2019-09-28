package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PurchaseApply;
import com.mingyuansoftware.aifactory.model.dto.PurchaseApplyDetailsDto;
import com.mingyuansoftware.aifactory.model.dto.PurchaseApplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PurchaseApplyMapper {
    int deleteByPrimaryKey(Integer purchaseApplyId);

    int insert(PurchaseApply record);

    PurchaseApply selectByPrimaryKey(Integer purchaseApplyId);

    List<PurchaseApply> selectAll();

    int updateByPrimaryKey(PurchaseApply record);

    /**
     * 获取采购申请单列表
     * @param purchaseApplyDto
     * @return
     */
    List<PurchaseApplyDetailsDto> selectpurchaseApplyList(@Param("purchaseApplyDto") PurchaseApplyDto purchaseApplyDto);

    /**
     * 获取采购申请单列表条数
     * @param purchaseApplyDto
     * @return
     */
    int selectCount(@Param("purchaseApplyDto") PurchaseApplyDto purchaseApplyDto);

    /**
     * 获取刚刚插入的记录id
     * @return
     */
    int selectLastId();

    /**
     * 逻辑删除采购申请单
     * @param purchaseApplyId
     * @return
     */
    int updatePurchaseApplyById(@Param("purchaseApplyId") int purchaseApplyId);

    /**
     * 根据采购申请单详情id查询一条采购申请单信息
     * @param purchaseApplyDetailsId
     * @return
     */
    PurchaseApply selectPurchaseApplyById(@Param("purchaseApplyDetailsId") int purchaseApplyDetailsId);

    /**
     * 获取导出的采购申请单列表
     * @return
     */
    List<PurchaseApplyDto> selectExportPurchaseApplyList();
}