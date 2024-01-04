package com.exp.aop.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: PeterLiu
 * @Date: 2024/1/4 16:11
 * @Description: 通过Spring获取请求
 */
public class HttpRequestUtil {
    public static HttpServletRequest getRequestObj(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }
}
