package com.robot.admin.service;


import com.robot.admin.pojo.SysPermissions;
import com.robot.admin.util.Message;

/**
 * 路由
 */
public interface RouterService {

    /**
     * 查询路由列表
     * @return Message
     */
    Message routerList();

    /**
     * 更新路由列表
     * @return Message
     */
    Message routerUpdate(SysPermissions sysPermissions);

    /**
     * 删除路由
     * @param sysPermissions
     * @return Message
     */
    Message routerDelete(SysPermissions sysPermissions);
}
