package com.robot.admin.util;

/**
 * @author robot
 * @date 2020/1/7 16:03
 */
public enum ErrorType {

    SUCCESS("0000", "成功"),
    ERROR("9999", "失败"),
    SIGN_ERROR("1006","sign错误"),
    TOKE_ERROR("1005","token解析异常"),
    TOKEN_EXPIRES("1004","token过期"),
    LOGIN_SUCCESS("1003", "登录成功"),
    USER_NOT_EXIST("1002","用户不存在,请注册"),
    USER_PERMISSION("1007","用户权限不足"),
    USER_NOT_LOGIN("1008","用户未登录"),
    PASSWORD_ERROR("1009","密码错误"),
    COUPON_TPL_NOT_EXIST("1019","优惠券不存在"),
    COUPON_NUM_MAX("1020","优惠券已发完"),
    COUPON_EXPIRE("1021","优惠券已过期"),


    ;
    private String errorCode;

    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

     ErrorType(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
