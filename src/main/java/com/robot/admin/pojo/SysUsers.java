package com.robot.admin.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * sys_users
 * @author 
 */
@Data
public class SysUsers implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 角色
     */
    private Integer roleId;

    /**
     *  角色简介
     */
    private SysRoles sysRoles;

    /**
     * 角色权限
     */
    private List<SysRolesPermissions> sysRolesPermissions;

    /**
     * 是否锁定
     */
    private Boolean locked;

    /**
     * 图像
     */
    private String img;

    /**
     * 角色名称
     */
    private String role;

    /**
     * token
     */
    private String token;
    private static final long serialVersionUID = 1L;
}