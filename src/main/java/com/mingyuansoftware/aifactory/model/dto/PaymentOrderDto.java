package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 张婷
 * @date 2019/7/17 15:03
 */

/*模糊查询*/

@ApiModel(description = "张婷")
public class PaymentOrderDto {

    @ApiModelProperty(value = "付款单编号",example = "paymentOrderNumber")
    private String paymentOrderNumber;

    @ApiModelProperty(value = "付款类别",example = "category")
    private String category;

    @ApiModelProperty(value = "用户日期",example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "收款方",example = "beneficiary")
    private String beneficiary;

    @ApiModelProperty(value = "付款金额",example = "1.1")
    private BigDecimal paymentAmount;

    @ApiModelProperty(value = "备注",example = "comment")
    private String comment;

    public String getPaymentOrderNumber() {
        return paymentOrderNumber;
    }

    public void setPaymentOrderNumber(String paymentOrderNumber) {
        this.paymentOrderNumber = paymentOrderNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDefineDate() {
        return defineDate;
    }

    public void setDefineDate(String defineDate) {
        this.defineDate = defineDate;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
