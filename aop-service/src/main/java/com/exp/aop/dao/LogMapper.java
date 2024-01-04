package com.exp.aop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exp.aop.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: PeterLiu
 * @Date: 2023/12/27 17:21
 * @Description:
 */
@Mapper
public interface LogMapper extends BaseMapper<OperationLog> {
}
