package com.exp.aop.config;

import com.exp.aop.advice.OpsAdvice;
import com.exp.aop.service.OpsService;
import com.exp.aop.service.impl.OpsServiceImpl;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: PeterLiu
 * @Date: 2023/11/2 11:04
 * @Description: 使用 Spring API 实现
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    /**
     *
     *      execution() 是切点指示符，用于指定要匹配的方法。
     *      * 表示返回类型不限，即匹配任意返回类型的方法。
     *      com.exp.aop.service.impl.OpsServiceImpl 是类的全限定名，表示要匹配的类。
     *      .* 表示匹配类中的所有方法，不论方法的名称是什么。
     *      (..) 表示匹配方法的参数，.. 表示任意数量和任意类型的参数。
     *
     */
    private static final String EXPRESSION="execution(* com.exp.aop.service.impl.OpsServiceImpl.*(..))";

    @Bean
    public OpsService opsService(){
        return new OpsServiceImpl();
    }

    @Bean
    public OpsAdvice opsAdvice(){
        return new OpsAdvice();
    }

    //切入点
    @Bean
    public Pointcut pointcut(){
        return new AspectJExpressionPointcut(){{
            setExpression(EXPRESSION);
        }};
    }

    @Bean
    public Advisor advisor(){
        return new DefaultPointcutAdvisor(pointcut(),opsAdvice());
    }
}
