package com.mingyuansoftware.aifactory.enums;

public enum WlCode {
    SUCCESS_GET(0, "获取成功"),
    FAIL_GET(30001, "获取失败"),
    SUCCESS_DELETE(30002, "删除成功"),
    FAIL_DELETE(30003, "删除失败"),
    SUCCESS_INSERT(30004, "新增成功"),
    FAIL_INSERT(30005, "新增失败"),
    SUCCESS_UPDAE(30006, "更新成功"),
    FAIL_UPDATE(30007, "更新失败"),
    ERROR_LOGIN_NAME_PASSWORD_NULL(30008,"Error,用户名或者密码不能为空"),
    ERROR_LOGIN_NAME_EXCIST(30009,"Error,用户名不存在"),
    ERROR_NAME_PASSWORD_EXCIST(30010,"Error,用户名或者密码错误"),
    SUCCESS_LOGIN(30011, "登录成功"),
    USER_STATUS_ERROR(30012, "已删除"),//已删除

    ;


    private int code;
    private String info;

    WlCode(int code, String info) {
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
