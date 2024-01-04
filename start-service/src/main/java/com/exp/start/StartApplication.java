package com.exp.start;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: PeterLiu
 * @Date: 2023/11/1 15:42
 * @Description:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.exp"})
@MapperScan(basePackages = "com.exp.aop.dao")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
