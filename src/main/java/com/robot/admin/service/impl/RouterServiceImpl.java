package com.robot.admin.service.impl;

import com.robot.admin.dao.SysPermissionsDao;
import com.robot.admin.pojo.SysPermissions;
import com.robot.admin.service.RouterService;

import com.robot.admin.util.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class RouterServiceImpl implements RouterService {

    @Resource
    private SysPermissionsDao sysPermissionsDao;

    @Override
    public Message routerList() {
        return Message.success(sysPermissionsDao.list());
    }

    @Override
    public Message routerUpdate(SysPermissions sysPermissions) {
        if (sysPermissions.getId() != null) {
            sysPermissionsDao.updateByPrimaryKey(sysPermissions);
        } else {
            sysPermissionsDao.insert(sysPermissions);
        }
        return Message.success();
    }

    @Override
    public Message routerDelete(SysPermissions sysPermissions) {
        sysPermissionsDao.deleteByPrimaryKey(sysPermissions.getId());
        return Message.success();
    }


}