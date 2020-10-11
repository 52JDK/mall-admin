package com.robot.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.robot.admin.dao.DonateDao;
import com.robot.admin.dao.SysRolesDao;
import com.robot.admin.dao.SysRolesPermissionsDao;
import com.robot.admin.dao.SysUsersDao;
import com.robot.admin.pojo.Donate;
import com.robot.admin.pojo.SysRoles;
import com.robot.admin.pojo.SysRolesPermissions;
import com.robot.admin.pojo.SysUsers;
import com.robot.admin.service.UserService;
import com.robot.admin.util.Message;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private SysUsersDao sysUsersDao;

    @Resource
    private SysRolesDao sysRolesDao;

    @Resource
    private SysRolesPermissionsDao sysRolesPermissionsDao;

    @Resource
    private DonateDao donateDao;


    @Override
    public SysUsers findUserByName(String userName) {
        return sysUsersDao.findUserByName(userName);
    }

    @Override
    public SysUsers findUserPermission(String userName) throws AuthenticationException {
        if (userName == null) {
            return null;
        }
        SysUsers sysUsers = sysUsersDao.findUserByName(userName);
        List<SysRolesPermissions> sysRolesPermissions = sysRolesPermissionsDao.findPermissionList(sysUsers.getId());
        if (sysRolesPermissions == null) {
            throw new AuthenticationException();
        }
        SysRoles sysRoles = sysRolesDao.selectByPrimaryKey(sysUsers.getRoleId());
        sysUsers.setSysRolesPermissions(sysRolesPermissions);
        sysUsers.setSysRoles(sysRoles);
        return sysUsers;
    }

    @Override
    public Message findDonateList() {
        List<Donate> donates=donateDao.findList();
        return Message.success(donates);
    }

    @Override
    public SysUsers selectUserRole(String userName) {
        return sysUsersDao.selectUserRole(userName);
    }
}
