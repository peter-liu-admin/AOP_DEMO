package com.exp.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author: PeterLiu
 * @Date: 2023/11/2 16:42
 * @Description:
 */
@Slf4j
@Aspect
public class AnoOpsAdvice {

    /**
     *
     *      execution() 是切点指示符，用于指定要匹配的方法。
     *      * 表示返回类型不限，即匹配任意返回类型的方法。
     *      com.exp.aop.service.impl.AnOpServiceImpl 是类的全限定名，表示要匹配的类。
     *      .* 表示匹配类中的所有方法，不论方法的名称是什么。
     *      (..) 表示匹配方法的参数，.. 表示任意数量和任意类型的参数。
     *
     */
    private static final String EXPRESSION = "execution(* com.exp.aop.service.impl.AnOpServiceImpl.*(..))";

    @After(EXPRESSION)
    public void after() {
        log.info("方法执行之后执行日志打印...");
    }

    @Before(EXPRESSION)
    public void before() {
        log.info("之前执行日志打印...");
    }

    @AfterThrowing(EXPRESSION)
    public void afterT() {
        log.error("抛出异常后执行日志打印...");
    }

    @Around(EXPRESSION)
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object val = joinPoint.proceed();
        log.info("环绕通知...:{}",val);
        return val;
    }
}
