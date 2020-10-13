package com.robot.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.admin.dao.*;
import com.robot.admin.pojo.*;
import com.robot.admin.request.*;
import com.robot.admin.service.ProductService;
import com.robot.admin.util.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Resource
    private ProductImgDao productImgDao;

    @Resource
    private ProductSkuDao productSkuDao;

    @Resource
    private SpeciesOptionDao speciesOptionDao;

    @Resource
    private ProductAttributeDao attributeDao;

    @Resource
    private ProductAttributeOptionDao productAttributeOptionDao;


    private static final String successStr = "success";

    @Override
    public Message ProductList(ProductList productLists) {
        Page page = PageHelper.startPage(productLists.getPageNum(), productLists.getPageSize());
        List<Product> productList = productDao.findProductList(productLists);
        PageInfo pageInfo = new PageInfo(productList);
        pageInfo.setTotal(page.getTotal());
        return Message.success(pageInfo);
    }

    @Override
    public Message productDetail(ProductDetail productDetail) throws Exception {
        String productId = productDetail.getProductId();
        Product product = productDao.findProductById(productId);
        ProductImg productImgs = productImgDao.findByProductId(productId);
        List<ProductSku> productSkus = productSkuDao.findByProductId(productId);
        AddProduct addProduct = convertAddProduct(product, productImgs, productSkus);
        return Message.success(addProduct);
    }

    @Override
    public Message enableProduct(EnableProduct enableProduct) throws Exception {
        productDao.enableProduct(enableProduct);
        return Message.success();
    }

    public Message findSpecies() throws Exception {
        SpeciesAttribute speciesAttribute = new SpeciesAttribute();
        List<SpeciesOption> speciesOption = speciesOptionDao.findSpecies();
        List<ProductAttribute> attributeOne = attributeDao.findAttributeList(1);
        List<ProductAttribute> attributesTwo = attributeDao.findAttributeList(2);
        speciesAttribute.setSpeciesOption(speciesOption);
        speciesAttribute.setAttributeOne(attributeOne);
        speciesAttribute.setAttributeTwo(attributesTwo);
        return Message.success(speciesAttribute);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Message ProductAdd(AddProduct addProduct) throws Exception {
        ProductImg productImg = convertImg(addProduct);
        Product product = convertProduct(addProduct);
        List<ProductSku> skus = convertSku(addProduct);
        if (addProduct.getId() != null) {
            productImg.setProductId(addProduct.getProductId());
            productImgDao.updateByProductId(productImg);
            productDao.updateByPrimaryKeySelective(product);
            productSkuDao.deleteByProductId(addProduct.getProductId());
        } else {
            productImgDao.insert(productImg);
            productDao.insert(product);
        }
        productSkuDao.insertBatch(skus);
        return Message.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Message deleteProduct(ProductDetail detail) throws Exception {
        productImgDao.deleteByProductId(detail.getProductId());
        productDao.deleteProductId(detail.getProductId());
        productSkuDao.deleteByProductId(detail.getProductId());
        return Message.success();
    }

    private AddProduct convertAddProduct(Product product, ProductImg productImgs, List<ProductSku> productSkus) throws Exception {
        AddProduct addProduct = new AddProduct();
        addProduct.setName(product.getName());
        addProduct.setProductId(product.getProductId());
        addProduct.setBrandId(product.getSpeciesOptionId());
        addProduct.setPrice(product.getPrice());
        addProduct.setVirtualNum(product.getVirtualNum());
        addProduct.setSort(product.getSort());
        addProduct.setRecommend(product.getRecommend() == 1);
        if (StringUtils.isNotBlank(product.getRights())) {
            addProduct.setRights(product.getRights());
        }
        addProduct.setIntroduction(product.getTitle());
        addProduct.setMainImg(convertImageInfo(product.getImg()));
        addProduct.setRollImg(convertImageInfo(productImgs.getRollImg()));
        addProduct.setDetailImg(convertImageInfo(productImgs.getDetailImg()));
        addProduct.setTableData(convertProductList(productSkus));
        return addProduct;
    }


    private List<ProductSku> convertSku(AddProduct addProduct) {
        List<ProductSku> skus = new ArrayList<>();
        if (null != addProduct.getTableData()) {
            for (AddProductList addProductList : addProduct.getTableData()) {
                ProductSku productSku = new ProductSku();
                productSku.setSku(addProductList.getSku());
                productSku.setProductId(addProduct.getProductId());
                productSku.setName(addProduct.getName());
                productSku.setAttrOne(addProductList.getAttrOne());
                productSku.setAttrTwo(addProductList.getAttrTwo());
                productSku.setPictureUrl(addProductList.getImage());
                productSku.setWarningStock(addProductList.getWarningStock());
                productSku.setMarketPrice(addProductList.getMarketPrice());
                productSku.setStock(addProductList.getStock());
                productSku.setPrice(addProductList.getPrice());
                productSku.setTitle(addProduct.getIntroduction());
                productSku.setCreateTime(new Date());
                productSku.setUpdateTime(new Date());
                skus.add(productSku);
            }
        }
        return skus;
    }


    private Product convertProduct(AddProduct addProduct) {
        Product product = new Product();
        product.setProductId(addProduct.getProductId());
        product.setSpeciesOptionId(addProduct.getBrandId());
        product.setName(addProduct.getName());
        if (addProduct.isRecommend()) {
            product.setRecommend(1);
        } else {
            product.setRecommend(0);
        }
        product.setVirtualNum(addProduct.getVirtualNum());
        product.setSort(addProduct.getSort());
        product.setTitle(addProduct.getIntroduction());
        product.setImg(addProduct.getImg());
        product.setPrice(addProduct.getPrice());
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        product.setRights(addProduct.getRights());
        return product;
    }


    private ProductImg convertImg(AddProduct addProduct) {
        ProductImg productImg = new ProductImg();
        productImg.setProductId(addProduct.getProductId());
        if (addProduct.getRollImg() != null) {
            String rollImg = convertImgStr(addProduct.getRollImg()).toString();
            productImg.setRollImg(rollImg);
        }
        if (addProduct.getDetailImg() != null) {
            String detailImg = convertImgStr(addProduct.getDetailImg()).toString();
            productImg.setDetailImg(detailImg);
        }
        productImg.setCreateTime(new Date());
        productImg.setUpdateTime(new Date());
        return productImg;
    }

    private List<ImageInfo> convertImageInfo(String images) {
        List<ImageInfo> imageInfos = new ArrayList<>();
        String[] imageStr = images.split(",");
        for (String str : imageStr) {
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.setName(str);
            imageInfo.setUrl(str);
            imageInfo.setStatus(successStr);
            imageInfos.add(imageInfo);
        }
        return imageInfos;
    }

    private List<AddProductList> convertProductList(List<ProductSku> productSkus) {
        List<AddProductList> addProductLists = new ArrayList<>();
        List<ProductAttributeOption> attribute = productAttributeOptionDao.findList();
        for (ProductSku productSku : productSkus) {
            AddProductList addProductList = new AddProductList();
            addProductList.setAttrOne(productSku.getAttrOne());
            addProductList.setAttrTwo(productSku.getAttrTwo());
            for (ProductAttributeOption option : attribute) {
                if (null != productSku.getAttrOne() && option.getOptionId().equals(productSku.getAttrOne())) {
                    addProductList.setAttrOneName(option.getOptionName());
                }
                if (null != productSku.getAttrTwo() && option.getOptionId().equals(productSku.getAttrTwo())) {
                    addProductList.setAttrTwoName(option.getOptionName());
                }
            }
            addProductList.setImage(productSku.getPictureUrl());
            addProductList.setMarketPrice(productSku.getMarketPrice());
            addProductList.setPrice(productSku.getPrice());
            addProductList.setSku(productSku.getSku());
            addProductList.setStock(productSku.getStock());
            addProductList.setWarningStock(productSku.getWarningStock());
            addProductList.setImageInfoList(convertImageInfo(productSku.getPictureUrl()));
            addProductLists.add(addProductList);

        }
        return addProductLists;
    }

    private StringBuilder convertImgStr(List<ImageInfo> imageInfos) {
        StringBuilder img = null;
        for (ImageInfo imageInfo : imageInfos) {
            if (img == null) {
                img = new StringBuilder(imageInfo.getUrl());
            } else {
                img.append(",").append(imageInfo.getUrl());
            }
        }
        return img;
    }
}
