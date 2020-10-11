package com.robot.admin.shiro;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.robot.admin.exception.BaseException;
import com.robot.admin.exception.ServiceExceptionHandler;
import com.robot.admin.pojo.SysRolesPermissions;
import com.robot.admin.pojo.SysUsers;
import com.robot.admin.service.UserService;
import com.robot.admin.util.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Realm，认证用户，授权
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {


    @Resource
    private UserService userService;

    /**
     * 认证.登录
     * doGetAuthenticationInfo这个方法是在用户登录的时候调用的
     * 也就是执行SecurityUtils.getSubject().login()的时候调用；(即:登录验证)
     * 验证通过后会用户保存在缓存中的
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws BaseException {
        String username = (String) token.getPrincipal();
        SysUsers user = userService.findUserPermission(username);
        if (user == null) {
            throw new BaseException(ErrorType.USER_NOT_EXIST);
        }
        //将用户信息放入session中
        SecurityUtils.getSubject().getSession().setAttribute("session", user);
        return new SimpleAuthenticationInfo(user.getUserName(), user.getPassWord(),
                ByteSource.Util.bytes(user.getSalt()), getName());
    }

    /**
     * 授权
     * doGetAuthorizationInfo方法是在我们调用
     * SecurityUtils.getSubject().isPermitted（）这个方法，
     * 授权后用户角色及权限会保存在缓存中的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        // 这里单机我用的session，也可以用redis 进行存储
        //获取session中的用户，以下3种都可以
        // User user=(User) principal.getPrimaryPrincipal();
        //String userName=(String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        SysUsers user = (SysUsers) principal.fromRealm(this.getClass().getName()).iterator().next();
//        //查询数据库
//        user = userService.findUserPermission(user.getUserName());

        Session session = SecurityUtils.getSubject().getSession();
        SysUsers user = (SysUsers) session.getAttribute("session");
        Set<String> userPermissions = new HashSet<String>();
        Set<String> userRoles = new HashSet<String>();
        userRoles.add(user.getSysRoles().getRole());
        List<SysRolesPermissions> rolePermissions = user.getSysRolesPermissions();
        for (SysRolesPermissions permission : rolePermissions) {
            userPermissions.add(permission.getSysPermissions().getPermissionsCode());
        }
        //角色名集合
        info.setRoles(userRoles);
        //权限名集合,将权限放入shiro中,
        // 这里可以把url，按钮，菜单，api等当做资源来进行权限控制，从而对用户进行权限控制
        info.addStringPermissions(userPermissions);
        return info;
    }
}
