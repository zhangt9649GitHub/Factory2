package com.mingyuansoftware.aifactory.shiro;

import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.StaffPermission;

import com.mingyuansoftware.aifactory.model.dto.StaffUserLoginDto;
import com.mingyuansoftware.aifactory.service.StaffPermissionService;
import com.mingyuansoftware.aifactory.service.StaffUserLoginService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author
 * @date 2019/1/16 11:23
 */
@Component
public class CustomRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory
            .getLogger(CustomRealm.class);
//    private AdminRolse

    @Autowired
    private StaffUserLoginService staffUserLoginService;

    @Autowired
    private StaffPermissionService staffPermissionService;
    @Override
    /**
     * 授权
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        Staff userLoginDto =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(userLoginDto!=null){
            List<StaffPermission> permissions = userLoginDto.getPermissions();
            for (StaffPermission permission : permissions) {
                simpleAuthorInfo.addStringPermission(permission.getPermissions());
            }
            return simpleAuthorInfo;
        }
        Staff user = (Staff)principalCollection.getPrimaryPrincipal();
        logger.info(user.getJobNumber()+"正在授权");
        List<StaffPermission> list = staffPermissionService.selectByUId(user.getStaffId());
        for (StaffPermission a:list) {
            simpleAuthorInfo.addStringPermission(a.getPermissions());
        }
        logger.info(user.getJobNumber()+"授权成功");
        return simpleAuthorInfo;
    }

    @Override
    /**
     * 认证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("正在进行登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Staff user = staffUserLoginService.selectByName(token.getUsername());

        if (user==null){
          return null;
        }else{
            //      如果查出来的不为空就比对密码

            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
            super.clearCachedAuthenticationInfo(info.getPrincipals());
            if (user.getState()!=0){
                List<StaffPermission> list = staffPermissionService.selectByUId(user.getStaffId());
                user.setPermissions(list);
            }
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            return info;
        }


    }
}
