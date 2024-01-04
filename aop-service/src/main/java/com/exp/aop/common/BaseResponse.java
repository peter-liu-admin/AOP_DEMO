package com.exp.aop.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: PeterLiu
 * @Date: 2023/6/10 0:56
 * @Description: 通用的返回类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private String msg;

    private int code;

    private T data;

    public BaseResponse(StatusEnum statusEnum) {
        this.msg = statusEnum.getMsg();
        this.code = statusEnum.getCode();
    }

    public BaseResponse(StatusEnum statusEnum, T data) {
        this.msg = statusEnum.getMsg();
        this.code = statusEnum.getCode();
        this.data = data;
    }

    public BaseResponse(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }
}
