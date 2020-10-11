package com.robot.admin.request;

import com.robot.admin.pojo.ImageInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AddProductList {
    /**
     * sku
     */
    private String sku;

    /**
     * 规格1
     */
    private Integer attrOne;

    /**
     * 规格2
     */
    private Integer attrTwo;

    /**
     * 规格1名称
     */
    private String attrOneName;

    /**
     * 规格2名称
     */
    private String attrTwoName;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 库存警告
     */
    private Integer warningStock;

    /**
     * price
     */
    private BigDecimal price;

    /**
     * 划线价
     */
    private BigDecimal marketPrice;

    /**
     * 图片
     */
    private String image;

    private List<ImageInfo> imageInfoList;

}
