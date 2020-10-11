package com.robot.admin.controller;


import com.robot.admin.pojo.SysUsers;
import com.robot.admin.request.UserLogin;
import com.robot.admin.service.UserService;
import com.robot.admin.util.JWTUtil;
import com.robot.admin.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 用户登录 controller
 */
@Controller
@RequestMapping("/userLogin")
@Slf4j
@CrossOrigin
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * 用户登录 JWT 判断
     * @param userLogin
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public Message index(@RequestBody @Valid UserLogin userLogin) {
        UsernamePasswordToken token = new UsernamePasswordToken(userLogin.getUserName(), userLogin.getPassWord());
        // 该方法会直接到 shiro 目录下 MyShiroRealm doGetAuthenticationInfo 方法中
        SecurityUtils.getSubject().login(token);
        //JWT 生成token
        Message newToken = JWTUtil.createJWT(userLogin.getUserName());
        SysUsers sysUsers = userService.selectUserRole(userLogin.getUserName());
        sysUsers.setToken((String) newToken.getData());
        return Message.success(sysUsers);
    }

    /**
     * 获取赞赏列表
     * @return
     */
    @RequestMapping("/findDonateList")
    @ResponseBody
    public Message findDonateList() {
        return Message.success(userService.findDonateList());
    }
}
