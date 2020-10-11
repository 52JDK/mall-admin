package com.robot.admin.request;

import lombok.Data;

import java.util.Date;

@Data
public class CouponList {

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 类型
     */
    private Integer type;

    private Date startTime;

    private Date endTime;

    private Integer pageSize;

    private Integer pageNum;
}
