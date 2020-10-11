package com.robot.admin.service;

import com.robot.admin.request.OrderDelivery;
import com.robot.admin.request.OrderDetail;
import com.robot.admin.request.OrderList;
import com.robot.admin.util.Message;

public interface OrderService {

    /**
     * 订单列表
     */
    Message orderList(OrderList orderList) throws Exception;

    /**
     * 订单详情
     */
    Message orderDetail(OrderDetail orderDetail) throws Exception;

    /**
     * 退款
     */
    Message refund(OrderDetail orderDetail)throws Exception;

    /**
     * 订单发货
     */
    Message OrderDelivery(OrderDelivery orderDelivery) throws Exception;
}
