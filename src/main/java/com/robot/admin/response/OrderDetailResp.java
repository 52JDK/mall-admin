package com.robot.admin.response;

import com.robot.admin.pojo.Order;
import com.robot.admin.pojo.OrderLine;
import com.robot.admin.pojo.OrderLog;
import com.robot.admin.pojo.UserAddress;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailResp {


    private Order order;

    private List<UserAddress> userAddress;

    private List<OrderLine> orderLineList;

    private List<OrderLog> orderLogs;


}
