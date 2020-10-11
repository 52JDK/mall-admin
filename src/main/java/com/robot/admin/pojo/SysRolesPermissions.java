package com.robot.admin.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_roles_permissions
 * @author 
 */
@Data
public class SysRolesPermissions implements Serializable {
    /**
     * 编号
     */
    private Long id;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 权限id
     */
    private Integer permissionsId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private SysPermissions sysPermissions;

    private static final long serialVersionUID = 1L;
}