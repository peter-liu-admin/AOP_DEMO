package com.exp.aop.service;

import com.exp.aop.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @Author: PeterLiu
 * @Date: 2023/12/27 16:22
 * @Description:
 */
public interface OrderService{

    int saveOrder(Order order);

    int deleteOrder(Long id);

    List<Order> queryOrders(Map<String,Object> map);
}
