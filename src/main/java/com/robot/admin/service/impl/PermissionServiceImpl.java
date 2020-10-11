package com.robot.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.admin.dao.SysRolesPermissionsDao;
import com.robot.admin.dao.SysUsersDao;
import com.robot.admin.pojo.SysRolesPermissions;
import com.robot.admin.request.PermissionList;
import com.robot.admin.request.PermissionUpdate;
import com.robot.admin.service.PermissionService;
import com.robot.admin.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private SysUsersDao sysUsersDao;

    @Resource
    private SysRolesPermissionsDao sysRolesPermissionsDao;

    @Override
    public Message list(PermissionList permissionList) {
        List<JSONObject> sysUsers = sysUsersDao.selectBatch();
        return Message.success(sysUsers);
    }

    @Override
    public Message permissionList() {
        return Message.success(sysRolesPermissionsDao.listAllPermission());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Message permissionUpdate(PermissionUpdate permissionUpdate) {
        List<SysRolesPermissions> list = new ArrayList<>();
        for (Integer integer : permissionUpdate.getPermissions()) {
            SysRolesPermissions sysRolesPermissions = new SysRolesPermissions();
            sysRolesPermissions.setPermissionsId(integer);
            sysRolesPermissions.setUserId(permissionUpdate.getUserId());
            sysRolesPermissions.setCreateTime(new Date());
            sysRolesPermissions.setUpdateTime(new Date());
            list.add(sysRolesPermissions);
        }
        sysRolesPermissionsDao.deleteByUid(permissionUpdate.getUserId());
        sysRolesPermissionsDao.insertBatch(list);
        return Message.success();
    }


}
