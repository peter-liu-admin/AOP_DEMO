package com.exp.aop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exp.aop.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: PeterLiu
 * @Date: 2023/12/28 11:55
 * @Description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
