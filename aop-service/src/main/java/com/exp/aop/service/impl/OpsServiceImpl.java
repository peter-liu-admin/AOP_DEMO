package com.exp.aop.service.impl;

import com.exp.aop.service.OpsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: PeterLiu
 * @Date: 2023/11/2 10:54
 * @Description:
 */
@Service
@Slf4j
public class OpsServiceImpl implements OpsService {
    @Override
    public void addOps(String msg) {
        log.info("新增操作--携带的消息：{}", msg);
    }
}
