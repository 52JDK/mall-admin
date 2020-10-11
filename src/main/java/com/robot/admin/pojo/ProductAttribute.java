package com.robot.admin.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * product_attribute
 *
 * @author
 */
@Data
public class ProductAttribute implements Serializable {
    private Integer id;

    private String productId;

    private String name;

    private Integer type;

    private Integer sort;

    private Date createTime;

    private Date updateTime;

    private Integer isMultiple;

    private List<ProductAttributeOption> productAttributeOptions;

    private static final long serialVersionUID = 1L;


}