package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.SalesReturnDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
@Mapper
public interface SalesReturnDetailsMapper {

    int deleteByPrimaryKey(Integer salesReturnDetailsId);


    int insert(SalesReturnDetails record);


    SalesReturnDetails selectByPrimaryKey(Integer salesReturnDetailsId);


    List<SalesReturnDetails> selectAll();


    int updateByPrimaryKey(SalesReturnDetails record);

    /**
     * 根据销售退货单id查询销售退货单详情集合
     * @param salesReturnId
     * @return
     */
    List<SalesReturnDetails> selectSalesReturnDetailsById(@Param("salesReturnId") int salesReturnId);

    /**
     * 更新销售订单详情中货物的已入库数量
     * @param salesReturnDetailsId
     */
    void updateQuantity(@Param("salesReturnDetailsId") int salesReturnDetailsId,@Param("quantity") BigDecimal quantity);
}