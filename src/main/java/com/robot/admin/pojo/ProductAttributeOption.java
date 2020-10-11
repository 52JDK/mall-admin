package com.robot.admin.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * product_attribute_option
 * @author 
 */
@Data
public class ProductAttributeOption implements Serializable {
    private Integer optionId;

    private Integer attrId;

    /**
     * 名字
     */
    private String optionName;

    /**
     * 排序
     */
    private Integer sort;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}