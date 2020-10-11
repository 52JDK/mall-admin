package com.robot.admin.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_roles
 * @author 
 */
@Data
public class SysRoles implements Serializable {
    /**
     * 角色编号
     */
    private Long id;

    /**
     * 角色名称
     */
    private String role;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 父节点
     */
    private Long pid;

    /**
     * 是否锁定
     */
    private Boolean available;

    private static final long serialVersionUID = 1L;
}