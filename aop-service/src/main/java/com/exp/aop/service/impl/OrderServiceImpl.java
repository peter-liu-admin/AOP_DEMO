package com.exp.aop.service.impl;

import com.exp.aop.dao.OrderMapper;
import com.exp.aop.entity.Order;
import com.exp.aop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: PeterLiu
 * @Date: 2023/12/27 16:22
 * @Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public int saveOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int deleteOrder(Long id) {
        return orderMapper.deleteById(id);
    }

    @Override
    public List<Order> queryOrders(Map<String, Object> map) {
        return orderMapper.selectByMap(map);
    }
}
