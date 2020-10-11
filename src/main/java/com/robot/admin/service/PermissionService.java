package com.robot.admin.service;

import com.robot.admin.request.PermissionList;
import com.robot.admin.request.PermissionUpdate;
import com.robot.admin.util.Message;

/**
 * 权限service
 */
public interface PermissionService {

    /**
     * 查询用户权限列表
     */
    Message list(PermissionList permissionList);

    /**
     * 查询所有权限列表
     */
    Message permissionList();

    /**
     * 更新用户权限信息
     */
    Message permissionUpdate(PermissionUpdate permissionUpdate);
}
