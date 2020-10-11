package com.robot.admin.exception;


import com.robot.admin.util.ErrorType;
import com.robot.admin.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 异常拦截类
 * 可以根据不同的Exception 拦截
 * 从而返回不同的信息
 */

@ControllerAdvice
@Slf4j
public class ServiceExceptionHandler {


    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public Message handleException(BaseException e) {
        log.error(e.getMessage(), e);
        return Message.error(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    @ResponseBody
    public Message handleException(IncorrectCredentialsException e) {
        log.error(e.getMessage(), e);
        return Message.error(ErrorType.PASSWORD_ERROR);
    }


    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Message handleException(UnauthorizedException e) {
        log.error(e.getMessage(), e);
        return Message.error(ErrorType.USER_PERMISSION);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Message handleException(AuthenticationException e) {
        log.error(e.getMessage(), e);
        return Message.error(ErrorType.USER_NOT_EXIST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Message handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Message.error(ErrorType.ERROR);
    }

}
