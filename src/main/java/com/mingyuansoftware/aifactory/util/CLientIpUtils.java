package com.mingyuansoftware.aifactory.util;


import javax.servlet.http.HttpServletRequest;

public class CLientIpUtils {

    /**
     * 获取客户ip地址工具类
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request){
        String  clientIp = null;
                clientIp = request.getHeader("x-forwarded-for");
        if(clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if(clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if(clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }
        return clientIp;

    }
}
