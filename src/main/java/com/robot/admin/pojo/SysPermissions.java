package com.robot.admin.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_permissions
 * @author 
 */
@Data
public class SysPermissions implements Serializable {
    private Integer id;

    /**
     * 菜单code
     *
     */
    private String menuCode;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 权限code
     */
    private String permissionsCode;

    /**
     * 权限名称
     */
    private String permissionsName;

    /**
     * 是否必选
     */
    private Integer requiredPermission;

    private static final long serialVersionUID = 1L;
}