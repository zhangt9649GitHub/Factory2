package com.mingyuansoftware.aifactory.enums;

public enum HtCode {
    SUCCESS_GET(0, "获取成功"),
    FAIL_GET(10001, "获取失败"),
    SUCCESS_ADD(10002,"新增成功"),
    FAIL_ADD(10003,"新增失败"),
    SUCCESS_DELETE(10004,"删除成功"),
    FAIL_DELETE(10005,"删除失败"),
    SUCCESS_UPLOAD(10006,"上传成功"),
    FAIL_UPLOAD(10007,"上传失败"),
    SUCCESS_UPDATE(10008,"更新成功"),
    FAIL_UPDATE(10009,"更新失败"),
    FAIL_DELETE_STATE_ING(10010,"删除失败,此条记录状态为已领料无法删除"),
    FAIL_DELETE_STATE_DO(10011,"删除失败,此条记录状态为已确认无法删除"),
    FAIL_DELETE_STATE_OUT(10012,"删除失败,此条订单已出库,无法删除"),
    FAIL_DELETE_STATE_FINISH(10013,"删除失败,此条记录状态已更新，无法删除"),
    SUCCESS_IMPORT(10014,"导入成功"),
    FAIL_IMPORT(10015,"导入失败"),
    FAIL_UPDATE_STATE_ING(10016,"更新失败，此条记录已完成配货"),
    FAIL_UPDATE_STATE_DO(10017,"更新失败，此条记录已完成出库"),
    FAIL_UPDATE_STATE_PART(10018,"更新失败，此条排产单已部分完成"),
    FAIL_UPDATE_STATE_OVER(10019,"更新失败，此条排产单已完成"),
    FAIL_DELETE_STATE_PART(10020,"删除失败,此条排产单已部分完成"),
    FAIL_DELETE_STATE_OVER(10021,"删除失败,此条排产单已完成"),
    FAIL_DELETE_STATE_DISTRIBUTION(10022,"删除失败,此条订单已配货,无法删除"),
    SUCCESS_SAVE(10023,"保存成功"),
    FAIL_SAVE(10024,"保存失败"),
    FAIL_UPDATE_COMPLETE(10025,"更新失败,此条记录为已创建状态"),
    SUCCESS_SUBMIT(10026,"提交成功"),
    FAIL_SUBMIT(10027,"提交失败"),
    FAIL_UPDATE_PAYMENTSTATE(10028,"更新失败，此条订单已有回款"),
    FAIL_DELETE_PAYMENTSTATE(10029,"删除失败，此条订单已有回款"),
    FAIL_FIND_NULL_JOBNUMBER(10030,"未找到此员工编号"),
    FAIL_NULL_GOODS(10031,"未找到此货物信息"),
    FAIL_DELETE_STATE_AUDIT(10032,"删除失败，此条工资单已审核通过"),
    FAIL_DELETE_STATE_PAYMENT(10033,"删除失败，此条工资单已完成付款"),
    FAIL_UPDATE_STATE_AUDIT(10034,"更新失败，此条工资单已审核通过"),
    FAIL_UPDATE_STATE_PAYMENT(10035,"更新失败，此条工资单已完成付款"),
    FAIL_UPDATE_STATE_SOME_ING(10036,"更新失败,此条记录状态为已领料无法更新"),
    FAIL_UPDATE_STATE_ALL_DO(10037,"更新失败,此条记录状态为已确认无法更新"),
    FAIL_DELETE_STATE_ANG_ING(10038,"删除失败,此条记录状态为已部分领料无法删除"),
    FAIL_UPDATE_STATE_ANG_ING(10039,"更新失败,此条记录状态为已部分领料无法更新"),
    SUCCESS_PRINT(10040,"打印成功"),
    FAIL_PRINT(10041,"打印失败"),
    SUCCESS_PRINTING(10042,"正在打印中");


    private final int code;
    private final String info;

    HtCode(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
