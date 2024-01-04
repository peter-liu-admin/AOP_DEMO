package com.exp.aop.config;

import com.exp.aop.service.AnOpService;
import com.exp.aop.service.impl.AnOpServiceImpl;
import com.exp.aop.advice.AnoOpsAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: PeterLiu
 * @Date: 2023/11/2 16:40
 * @Description:
 */
@Configuration
@EnableAspectJAutoProxy
public class AnoOpConfig {

    @Bean
    public AnOpService anOpService() {
        return new AnOpServiceImpl();
    }

    @Bean
    public AnoOpsAdvice anoOpsAdvice() {
        return new AnoOpsAdvice();
    }
}
