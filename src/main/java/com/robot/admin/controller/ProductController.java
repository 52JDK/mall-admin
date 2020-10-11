package com.robot.admin.controller;

import com.robot.admin.request.AddProduct;
import com.robot.admin.request.EnableProduct;
import com.robot.admin.request.ProductDetail;
import com.robot.admin.request.ProductList;
import com.robot.admin.service.ProductService;
import com.robot.admin.util.Message;
import com.robot.admin.util.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 商品product
 */
@Controller
@RequestMapping("/product")
@CrossOrigin
@Slf4j
public class ProductController {

    @Resource
    private ProductService productService;

    @Value("${accessKey}")
    private String accessKey;

    @Value("${secretKey}")
    private String secretKey;

    @Value("${bucket}")
    private String bucket;

    @Value("${resourceHost}")
    private String resourceHost;

    /**
     * 商品list
     * @param productList
     * @return
     */
    @RequiresPermissions("product:list")
    @RequestMapping("/list")
    @ResponseBody
    public Message productList(@RequestBody ProductList productList) {
        return productService.ProductList(productList);
    }

    /**
     * 商品详情
     * @param productDetail
     * @return
     * @throws Exception
     */
    @RequestMapping("/detail")
    @ResponseBody
    public Message productDetail(@RequestBody ProductDetail productDetail) throws Exception {
        return productService.productDetail(productDetail);
    }

    /**
     * 商品的启用禁用
     * @param enableProduct
     * @return
     * @throws Exception
     */
    @RequiresPermissions("product:enable")
    @RequestMapping("/enable")
    @ResponseBody
    public Message enableProduct(@RequestBody EnableProduct enableProduct) throws Exception {
        return productService.enableProduct(enableProduct);
    }

    /**
     * 查询商品的规格信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/findSpecies")
    @ResponseBody
    public Message findSpecies() throws Exception {
        return productService.findSpecies();
    }


    /**
     * 商品的添加
     * @param addProduct
     * @return
     * @throws Exception
     */
    @RequiresPermissions("product:add")
    @RequestMapping("/add")
    @ResponseBody
    public Message AddProduct(@RequestBody AddProduct addProduct) throws Exception {
        return productService.ProductAdd(addProduct);
    }

    /**
     * 商品的删除
     * @param productDetail
     * @return
     * @throws Exception
     */
    @RequiresPermissions("product:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public Message deleteProduct(@RequestBody ProductDetail productDetail) throws Exception {
        return productService.deleteProduct(productDetail);
    }

    /**
     * 上传图片
     * @param request
     * @return
     * @throws Exception
     */
    @RequiresPermissions("product:uploadFile")
    @RequestMapping("/uploadFile")
    @ResponseBody
    public Message uploadFile(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("files");
        String result = UploadUtil.upload(multipartFile.getInputStream(), accessKey, secretKey, bucket, resourceHost);
        return Message.success(result);
    }


}


