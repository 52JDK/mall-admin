package com.robot.admin.request;

import lombok.Data;

/**
 * 订单列表
 */
@Data
public class OrderList {

    /**
     * uid
     */
    private String uid;

    /**
     * 订单号
     */
    private String orderCode;
    private Integer pageNum;
    private Integer pageSize;
}
