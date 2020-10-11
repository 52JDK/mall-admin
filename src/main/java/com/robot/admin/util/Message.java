package com.robot.admin.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author robot
 * @date 2020/1/7 15:53
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message implements Serializable {



    private String code;

    private String message;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message() {
    }

    public Message(Object data) {
        this.data = data;
    }

    public Message( Object data, String code) {
        this.code = code;
        this.data = data;
    }


    public Message(Object data, ErrorType errorType) {
        this.data = data;
        this.code = errorType.getErrorCode();
        this.message = errorType.getErrorMsg();
    }

    public Message(ErrorType errorType) {
        this.code = errorType.getErrorCode();
        this.message = errorType.getErrorMsg();
    }

    /**
     * 成功 不带返回值
     *
     * @param errorType
     * @return
     */
    public static Message success(ErrorType errorType) {
        return new Message( errorType);
    }

    public static Message success() {
        return new Message(ErrorType.SUCCESS);
    }


    /**
     * 成功带返回数据
     *
     * @param object
     * @param errorType
     * @return
     */
    public static Message success(Object object, ErrorType errorType) {
        return new Message(object, errorType);
    }


    public static Message success(Object object) {
        return new Message(object,ErrorType.SUCCESS);
    }


    /**
     * 失败返回
     *
     * @param errorType
     * @return
     */
    public static Message error(ErrorType errorType) {
        return new Message(errorType);
    }

    public static Message error(String errorCode, String msg) {
        return new Message(errorCode,msg);
    }
}
