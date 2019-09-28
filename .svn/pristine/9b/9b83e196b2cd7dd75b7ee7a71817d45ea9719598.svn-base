package com.mingyuansoftware.aifactory.controller;


import com.mingyuansoftware.aifactory.enums.WlCode;


import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.StaffPermissionService;
import com.mingyuansoftware.aifactory.service.StaffUserLoginService;
import com.mingyuansoftware.aifactory.util.CLientIpUtils;
import com.mingyuansoftware.aifactory.util.DateUtil;
import com.mingyuansoftware.aifactory.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author 张赛潮
 * @date 2019/7/13 17:11
 */
@RestController
@RequestMapping("adminlogin")
@Api(value = "AdminLoginController-API",description = "后台管理登录-api",tags = {"后台登录"})
public class StaffLoginController {

    @Autowired
    private StaffUserLoginService staffUserLoginService;

    @Autowired
    private StaffPermissionService staffPermissionService;

    @RequestMapping(value = "/loginAdmin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "后台登录",notes = "登录",nickname = "loginAdmin",tags={"@王力影"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "实时定位实体类用户名", dataType = "Staff"),

    })
    public LayuiCommonResponse loginAdmin(@RequestBody Staff user, HttpServletRequest request) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        if (user.getJobNumber()==null&&user.getJobNumber()==""&&user.getPassword()==null&&user.getPassword()==""){
           response.setMsg(WlCode.ERROR_LOGIN_NAME_PASSWORD_NULL.getInfo());
           response.setCode(WlCode.ERROR_LOGIN_NAME_PASSWORD_NULL.getCode());
            return response;
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            user.setPassword(MD5Util.encrypt(user.getPassword()));
            UsernamePasswordToken token = new UsernamePasswordToken(user.getJobNumber(), user.getPassword());
//            调用登录认证方法

            subject.login(token);
            HttpSession session = request.getSession();
            Staff us = (Staff) session.getAttribute("user");
            // 设置session过期时间
            session.setMaxInactiveInterval(60*60);
//            如果用户被禁用
            if (us.getState()==0){
                response.setMsg(WlCode.USER_STATUS_ERROR.getInfo());
                response.setCode(WlCode.USER_STATUS_ERROR.getCode());
                request.getSession().removeAttribute("user");
                return response;
            }
//            记录用户登录时间ip
//
//           给用户添加权限


            us.setLoginIp(CLientIpUtils.getIp(request));
            us.setLoginTime(DateUtil.getDateTime());
            staffUserLoginService.updateUserLogin(us);
            response.setCode(WlCode.SUCCESS_LOGIN.getCode());
            response.setMsg(WlCode.SUCCESS_LOGIN.getInfo());
            response.setData(us);
//            用户名不存在

        }catch (UnknownAccountException e){
            response.setMsg(WlCode.ERROR_LOGIN_NAME_EXCIST.getInfo());
            response.setCode(WlCode.ERROR_LOGIN_NAME_EXCIST.getCode());
//            密码错误
        }catch (IncorrectCredentialsException e){
            response.setMsg(WlCode.ERROR_NAME_PASSWORD_EXCIST.getInfo());
            response.setCode(WlCode.ERROR_NAME_PASSWORD_EXCIST.getCode());
        }

        return response;
    }

    @RequestMapping(value = "/logOutAdmin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "后台登出",notes = "登出",nickname = "logOutAdmin",tags={"@王力影"})
    public LayuiCommonResponse logOutAdmin() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        response.setCode(0);
        response.setMsg("退出成功");
        return response;
    }




}
