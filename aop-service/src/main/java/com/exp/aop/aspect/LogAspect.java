package com.exp.aop.aspect;

import cn.hutool.json.JSONArray;
import com.exp.aop.annotation.OperateAnnotation;
import com.exp.aop.dao.LogMapper;
import com.exp.aop.entity.OperationLog;
import com.exp.aop.utils.HttpRequestUtil;
import com.exp.aop.utils.IPRegionUtil;
import com.exp.aop.utils.MacUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: PeterLiu
 * @Date: 2023/11/2 15:56
 * @Description: 连接点指定了切入点的位置，通知定义了在这些切入点上执行的操作。
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    @Resource
    private LogMapper logMapper;

    @Pointcut(value = "@annotation(com.exp.aop.annotation.OperateAnnotation)")
    public void pointCut() {

    }

    @Around(value = "pointCut()")
    public Object saveRequestLog(ProceedingJoinPoint joinPoint) throws Throwable {
        this.printAopInfo(joinPoint);

        long timeStart = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long timeEnd = System.currentTimeMillis();
        long timeUsed = timeEnd - timeStart;

        this.saveLog(timeUsed, joinPoint);

        return proceed;
    }

    private void saveLog(long usedTime, ProceedingJoinPoint joinPoint) throws Exception {
        OperationLog operationLog = new OperationLog();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Class returnType = methodSignature.getReturnType();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        OperateAnnotation annotation = method.getAnnotation(OperateAnnotation.class);
        log.info("内容输出：returnType:{}, method:{}, methodName：{}", returnType, method, methodName);
        if (annotation != null) {
            String operation = annotation.operation();
            log.info("内容输出： operation:{}", operation);
            operationLog.setOperationName(operation);
        }

        JSONArray jsonArray = new JSONArray();
        String ipv4 = IPRegionUtil.getIpv4(HttpRequestUtil.getRequestObj());

        operationLog.setExeTime(String.valueOf(usedTime));
        operationLog.setCreateTime(new Date());
        operationLog.setMethodName(methodName);
        operationLog.setReqIp(ipv4);
        operationLog.setMacIp(MacUtil.getMacAddress());
        operationLog.setIpRegion(IPRegionUtil.getRegion(ipv4));

        jsonArray.add(joinPoint.getArgs()[0]);
        operationLog.setReqParam(jsonArray.toStringPretty());

        logMapper.insert(operationLog);
    }

    private void printAopInfo(ProceedingJoinPoint joinPoint) {
        // Returns the method arguments.
        Object[] args = joinPoint.getArgs();
        // Returns the proxy object
        Object proxyObj = joinPoint.getThis();
        // Returns the target object
        Object targetObj = joinPoint.getTarget();
        // Returns a description of the method that is being advised
        Signature signature = joinPoint.getSignature();
        // Returns a String representing the kind of join point.
        String kind = joinPoint.getKind();
        // Returns the source location corresponding to the join point.
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        // Returns an object that encapsulates the static parts of this join point.
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        log.info("内容输出： args:{},proxyObj:{},targetObj:{},signature:{},kind:{},sourceLocation:{},staticPart:{}", args, proxyObj, targetObj, signature, kind, sourceLocation, staticPart);
    }

}
