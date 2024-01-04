package com.exp.aop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: PeterLiu
 * @Date: 2023/12/27 16:24
 * @Description:
 */
@Data
@TableName(value = "ops_log")
public class OperationLog {

    private Long id;

    private String reqIp;

    private String macIp;

    private String methodName;

    private String reqParam;

    private String reqType;

    private String exeTime;

    private Date createTime;

    private String operationName;

    private String ipRegion;
}
