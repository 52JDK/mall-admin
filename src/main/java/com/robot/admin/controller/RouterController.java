package com.robot.admin.controller;

import com.robot.admin.pojo.SysPermissions;
import com.robot.admin.request.PermissionUpdate;
import com.robot.admin.service.RouterService;
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
 * 权限路由
 */
@Controller
@RequestMapping("/router")
@CrossOrigin
@Slf4j
public class RouterController {

    @Resource
    private RouterService routerService;

    /**
     * 权限路由列表
     * @return
     */
    @RequiresPermissions("router:list")
    @RequestMapping("/list")
    @ResponseBody
    public Message routerList() {
        return routerService.routerList();
    }


    /**
     * 更新权限路由
     * @param sysPermissions
     * @return
     */
    @RequiresPermissions("router:update")
    @RequestMapping("/update")
    @ResponseBody
    public Message routerUpdate(@RequestBody SysPermissions sysPermissions) {
        return routerService.routerUpdate(sysPermissions);
    }

    /**
     * 权限路由删除
     * @param sysPermissions
     * @return
     */
    @RequiresPermissions("router:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public Message routerDelete(@RequestBody SysPermissions sysPermissions) {
        return routerService.routerDelete(sysPermissions);
    }
}
