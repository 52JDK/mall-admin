package com.robot.admin.request;

import lombok.Data;

/**
 * 订单物流
 */
@Data
public class OrderDelivery {

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * 物流公司
     */
    private String expressCompany;

    /**
     * 物流单号
     */
    private String expressCode;
}
