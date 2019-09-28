package com.mingyuansoftware.aifactory.enums;

public enum ZtCode {
    SUCCESS_GET(0, "获取成功"),
    FAIL_GET(20002, "获取失败"),
    SUCCESS_ADD(20003,"添加成功"),
    FAIL_ADD(20004,"添加失败"),
    SUCCESS_EDIT(20005, "编辑成功"),
    FAIL_EDIT(20006, "编辑失败"),
    SUCCESS_DELETE(20007, "删除成功"),
    FAIL_DELETE(20008, "删除失败"),
    CAN_USERNAME(20009,"恭喜您,该仓库名字可以使用"),
    UNABLE_CHECKNAME(20010,"该仓库名字已被使用"),
    EXIST_CUSTOMER(20011,"客户存在"),
    UNEXIST_CUSTOMER(20012,"客户不存在"),
    CAN_CREATEPO(20013, "可以创建采购订单"),
    UNABLE_CREATEPO(20014, "1.不是同一供应商;2.供应商不能为空;3.不要重复生成采购订单;不能创建采购订单"),
    SUCCESS_CREATEPO(20015, "生成采购订单成功"),
    FAIL_CREATEPO(20016, "生成采购订单失败"),
    CAN_AFFIRM(20017, "可以确认合同"),
    UNABLE_AFFIRM(20018, "请不要重复确认合同"),
    UNABLE_EDIT(20019, "此订单已入库或已付款，不可编辑操作,只能确认合同操作"),
    SUCCESS_SAVE(20020, "保存成功"),
    FAIL_SAVE(20021, "保存失败"),
    SUCCESS_UPLOAD(20022, "上传成功"),
    FAIL_UPLOAD(20023, "上传失败"),
    SUCCESS_RESET(20024, "重置失败"),
    FAIL_RESET(20025, "重置成功"),
    FAIL_SAVE_PO(20026, "请不要重复操作"),
    SUCCESS_IMPORT(20027,"导入成功"),
    FAIL_IMPORT(20028,"导入失败"),
    CAN_EDITNB(20029,"可以进行更新操作"),
    UNABLE_EDITNB(20030,"已生成采购订单,不能更新操作"),
    FAIL_READD(20031,"主产品已生成,不能重复添加"),//Bom表添加提示信息
    FAIL_SAVE_COUNT(20032, "保存失败,入库数量不能大于需要入库的数量");

    private int code;
    private String info;

    ZtCode(int code, String info){
        this.code=code;
        this.info=info;
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
