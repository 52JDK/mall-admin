package com.robot.admin.request;

import lombok.Data;

@Data
public class EnableProduct {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 是否开启
     */
    private int enable;
}
