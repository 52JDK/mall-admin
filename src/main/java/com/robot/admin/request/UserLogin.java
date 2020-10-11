package com.robot.admin.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLogin {

    @NotNull(message = "用户名不能为空")
    private String userName;

    @NotNull(message = "密码不能为空")
    private String passWord;
}
