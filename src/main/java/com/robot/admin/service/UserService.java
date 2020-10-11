package com.robot.admin.service;

import com.alibaba.fastjson.JSONObject;
import com.robot.admin.pojo.Donate;
import com.robot.admin.pojo.SysUsers;
import com.robot.admin.util.Message;
import org.apache.shiro.authc.AuthenticationException;

/**
 * 用户查询
 */
public interface UserService {

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    SysUsers findUserByName(String userName);

    /**
     * 根据用户名查询权限
     * @param userName
     * @return
     * @throws AuthenticationException
     */
    SysUsers findUserPermission(String userName) throws AuthenticationException;

    /**
     * 查询捐赠列表
     * @return
     */
    Message findDonateList();

    /**
     * 查询用户角色
     * @param userName
     * @return
     */
    SysUsers selectUserRole(String userName);
}
