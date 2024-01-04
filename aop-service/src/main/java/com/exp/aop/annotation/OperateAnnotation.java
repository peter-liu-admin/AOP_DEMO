package com.exp.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author: PeterLiu
 * @Date: 2023/12/28 0:37
 * @Description:
 */
@Documented
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface OperateAnnotation {

    String operation() default "无操作";
}
