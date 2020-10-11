package com.robot.admin.pojo;

import lombok.Data;

import java.util.List;

@Data
public class SpeciesAttribute {

    /**
     * 商品品牌
     */
    private List<SpeciesOption> speciesOption;

    /**
     * 商品选项规格一
     */
    private List<ProductAttribute> attributeOne;

    /**
     * 商品选项规格二
     */
    private List<ProductAttribute> attributeTwo;
}
