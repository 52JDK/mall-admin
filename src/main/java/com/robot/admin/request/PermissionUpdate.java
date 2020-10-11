package com.robot.admin.request;

import lombok.Data;

import java.util.List;

/**
 * 权限更新
 */
@Data
public class PermissionUpdate {

    //存放的是权限id
    private List<Integer> permissions;

    //用户id
    private Integer userId;

}
