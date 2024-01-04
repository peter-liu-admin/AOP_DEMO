package com.exp.aop.controller;

import com.exp.aop.annotation.OperateAnnotation;
import com.exp.aop.entity.Order;
import com.exp.aop.service.AnOpService;
import com.exp.aop.common.BaseResponse;
import com.exp.aop.service.OpsService;
import com.exp.aop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: PeterLiu
 * @Date: 2023/11/1 17:17
 * @Description:
 */
@RequestMapping("/demo")
@RestController
@Slf4j
public class DemoController {

    @Resource
    private OpsService opsService;

    @Resource
    private AnOpService anOpService;

    @Resource
    private OrderService orderService;

    /**
     * 测试Spring API自带的接口
     *
     * @param myMsg
     * @return
     */
    @GetMapping("/add/{msg}")
    public BaseResponse<?> add(@PathVariable("msg") String myMsg) {
        BaseResponse<?> response = new BaseResponse<>();
        opsService.addOps(myMsg);
        return response;
    }

    /**
     * 测试基于注解实现
     *
     * @param email
     * @return
     */
    @GetMapping("/send")
    public BaseResponse<?> send(@RequestParam String email) throws Exception {
        BaseResponse response = new BaseResponse<>();
        Integer sendEmail = anOpService.sendEmail(email);
        response.setData(sendEmail);
        return response;
    }

    /**
     * 基于自定义注解实现
     * @param order
     * @return
     */
    @PostMapping("/saveOrder")
    @OperateAnnotation(operation = "保存订单")
    public BaseResponse<?> saveOrder(@RequestBody Order order){
        BaseResponse response = new BaseResponse<>();
        int res=orderService.saveOrder(order);
        response.setData(res);
        return response;
    }


}
