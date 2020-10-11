package com.robot.admin.request;

import lombok.Data;

@Data
public class ProductList {

    private String productId;

    private String name;

    private Integer pageSize;

    private Integer pageNum;
}
