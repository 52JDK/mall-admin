package com.robot.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.admin.dao.OrderDao;
import com.robot.admin.dao.OrderLineDao;
import com.robot.admin.dao.OrderLogDao;
import com.robot.admin.dao.UserAddressDao;
import com.robot.admin.pojo.Order;
import com.robot.admin.pojo.OrderLine;
import com.robot.admin.pojo.OrderLog;
import com.robot.admin.pojo.UserAddress;
import com.robot.admin.request.OrderDelivery;
import com.robot.admin.request.OrderDetail;
import com.robot.admin.request.OrderList;
import com.robot.admin.response.OrderDetailResp;
import com.robot.admin.service.OrderService;
import com.robot.admin.util.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private OrderLineDao orderLineDao;

    @Resource
    private UserAddressDao userAddressDao;

    @Resource
    private OrderLogDao orderLogDao;

    @Override
    public Message orderList(OrderList params) {
        Page page = PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Order> orderList = orderDao.findOrderList(params);
        PageInfo pageInfo = new PageInfo(orderList);
        pageInfo.setTotal(page.getTotal());
        return Message.success(pageInfo);
    }


    @Override
    public Message orderDetail(OrderDetail orderDetail) throws Exception {
        OrderDetailResp orderDetailResp = new OrderDetailResp();
        List<UserAddress> userAddressList = new ArrayList<>();
        List<OrderLine> orderLines = orderLineDao.findOrderLine(orderDetail.getOrderCode());
        Order order = orderDao.findOrderByCode(orderDetail.getOrderCode());
        UserAddress userAddress = userAddressDao.selectByPrimaryKey(order.getAddressId());
        List<OrderLog> orderLogs = orderLogDao.findLogByCode(orderDetail.getOrderCode());
        orderDetailResp.setOrderLineList(orderLines);
        orderDetailResp.setOrder(order);
        userAddressList.add(userAddress);
        orderDetailResp.setOrderLogs(orderLogs);
        orderDetailResp.setUserAddress(userAddressList);
        return Message.success(orderDetailResp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Message refund(OrderDetail orderDetail) throws Exception {
        //这里只做订单状态的改变，有需要的可以联系本人开发退款
        OrderLog orderLog = new OrderLog();
        orderLog.setCreateTime(new Date());
        orderLog.setManager("管理员");
        orderLog.setControlLog("退款");
        orderLog.setOrderCode(orderDetail.getOrderCode());
        orderLogDao.insert(orderLog);
        orderDao.refund(orderDetail.getOrderCode());
        return Message.success();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Message OrderDelivery(OrderDelivery orderDelivery) throws Exception {
        Order order = new Order();
        order.setExpressCode(orderDelivery.getExpressCode());
        order.setExpressCompany(orderDelivery.getExpressCompany());
        order.setOrderCode(orderDelivery.getOrderCode());
        order.setShipTime(new Date());
        order.setOrderStatus(3);
        OrderLog orderLog = new OrderLog();
        orderLog.setCreateTime(new Date());
        orderLog.setManager("管理员");
        orderLog.setControlLog("发货");
        orderLog.setOrderCode(orderDelivery.getOrderCode());
        orderLogDao.insert(orderLog);
        orderDao.updateOrderExpressByCode(order);
        return Message.success();
    }
}
