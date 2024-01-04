package com.exp.aop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: PeterLiu
 * @Date: 2023/12/28 0:53
 * @Description:
 */
@Data
@TableName("ops_order")
public class Order {

    @TableId(value = "od_id",type = IdType.AUTO)
    private Long id;

    private BigDecimal odMoney;

    private String odPayStatus;

    private String odRecipientName;

    private String odRecipientPhone;

    private String odAddress;

    private Date odCreateTime;
}
