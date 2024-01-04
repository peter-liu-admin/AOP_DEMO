package com.exp.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: PeterLiu
 * @Date: 2023/11/2 10:57
 * @Description:
 */
@Component(value = "OpsAd")
@Slf4j
public class OpsAdvice implements AfterReturningAdvice , MethodBeforeAdvice{

    /**
     *
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("before--方法名:{}  方法参数:{}  代理目标类:{}", method.getName(), args, target);
    }

    /**
     * @param o       返回值
     * @param method  方法
     * @param objects 方法参数
     * @param o1      代理的目标类
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) {
        log.info("afterReturning--类名:{}   方法名:{}  方法参数:{}  返回值:{}", o1.getClass().getName(), method.getName(), objects, o);
    }
}
