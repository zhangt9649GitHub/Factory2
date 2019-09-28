package com.mingyuansoftware.aifactory.model;

/**
 * @author 张赛潮
 * @date 2019/7/13 10:10
 */
public class StaffPermission {
    private String url;//接口路径
    private String permissions; //该路径所需的权限
    private int accessId;

    public StaffPermission(String url, String permissions, int accessId) {
        this.url = url;
        this.permissions = permissions;
        this.accessId = accessId;
    }

    public int getAccessId() {
        return accessId;
    }

    public void setAccessId(int accessId) {
        this.accessId = accessId;
    }

    public StaffPermission() {
        super();
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
