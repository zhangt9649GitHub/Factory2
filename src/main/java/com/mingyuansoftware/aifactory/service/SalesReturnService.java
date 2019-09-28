package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.SalesReturn;
import com.mingyuansoftware.aifactory.model.dto.SalesReturnDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalesReturnService {

    /**
     * 获取销售退货单列表
     * @param salesReturnDto
     * @return
     */
    List<SalesReturn> selectSalesReturnList(SalesReturnDto salesReturnDto);

    /**
     * 获取销售退货单列表总条目
     * @param salesReturnDto
     * @return
     */
    int selectSalesReturnCount(SalesReturnDto salesReturnDto);

    /**
     * 新增销售退货单
     * @param salesReturn
     */
    void insertSalesReturn(SalesReturn salesReturn);

    /**
     * 查看销售退货单详情
     * @param salesReturnId
     * @return
     */
    SalesReturn selectSalesReturnById(int salesReturnId);

    /**
     * 更新销售退货单
     * @param salesReturn
     */
    void updateSalesReturnInfo(SalesReturn salesReturn);

    /**
     * 删除销售退货单
     * @param salesReturnId
     */
    void deleteSalesReturnById(int salesReturnId);

    /**
     * 更新销售退货单的状态为已入库
     * @param salesReturnId
     */
    void updateSalesReturnState(int salesReturnId);

    /**
     * 获取销售退货单列表(付款使用)
     * @return
     */
    List<SalesReturn> selectSalesReturnListForPayment();
}
