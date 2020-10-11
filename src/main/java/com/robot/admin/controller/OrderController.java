package com.robot.admin.controller;


import com.robot.admin.request.OrderDelivery;
import com.robot.admin.request.OrderDetail;
import com.robot.admin.request.OrderList;
import com.robot.admin.service.OrderService;
import com.robot.admin.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 订单controller
 */
@Controller
@RequestMapping("/order")
@CrossOrigin
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 查询订单列表
     * @param orderList
     * @return
     * @throws Exception
     */
    @RequiresPermissions("order:list")
    @RequestMapping("/list")
    @ResponseBody
    public Message orderList(@RequestBody OrderList orderList) throws Exception {
        return orderService.orderList(orderList);
    }

    /**
     * 订单发货
     * @param orderDelivery
     * @return
     * @throws Exception
     */
    @RequiresPermissions("order:delivery")
    @RequestMapping("/delivery")
    @ResponseBody
    public Message OrderDelivery(@RequestBody OrderDelivery orderDelivery) throws Exception {
        return orderService.OrderDelivery(orderDelivery);
    }

    /**
     * 订单退款
     * @param orderDetail
     * @return
     * @throws Exception
     */
    @RequiresPermissions("order:refund")
    @RequestMapping("/refund")
    @ResponseBody
    public Message refund(@RequestBody OrderDetail orderDetail) throws Exception {
        return orderService.refund(orderDetail);
    }

    /**
     * 订单详情
     * @param orderDetail
     * @return
     * @throws Exception
     */
    @RequiresPermissions("order:detail")
    @RequestMapping("/detail")
    @ResponseBody
    public Message orderDetail(@RequestBody OrderDetail orderDetail) throws Exception {
        return orderService.orderDetail(orderDetail);
    }

}
