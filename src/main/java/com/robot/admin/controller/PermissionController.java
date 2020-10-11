package com.robot.admin.controller;


import com.robot.admin.request.PermissionList;
import com.robot.admin.request.PermissionUpdate;
import com.robot.admin.service.PermissionService;
import com.robot.admin.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 权限管理 controller
 */
@Controller
@RequestMapping("/permission")
@CrossOrigin
@Slf4j
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    /**
     * 权限列表
     * @param permissionList
     * @return
     */
    @RequiresPermissions("permission:list")
    @RequestMapping("/list")
    @ResponseBody
    public Message list(@RequestBody PermissionList permissionList) {
        return permissionService.list(permissionList);
    }

    /**
     * 查询所有权限列表
     * @return
     */
    @RequiresPermissions("permission:permissionList")
    @RequestMapping("/permissionList")
    @ResponseBody
    public Message permissionList() {
        return permissionService.permissionList();
    }

    /**
     * 权限更新
     * @param permissionUpdate
     * @return
     */
    @RequiresPermissions("permission:update")
    @RequestMapping("/update")
    @ResponseBody
    public Message permissionUpdate(@RequestBody PermissionUpdate permissionUpdate) {
        return permissionService.permissionUpdate(permissionUpdate);
    }


}
