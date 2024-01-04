package com.exp.aop.common;

/**
 * @Author: PeterLiu
 * @Date: 2023/6/12 17:49
 * @Description: 通用的状态枚举类
 */
public enum StatusEnum {

    SUCCESS(200, "执行成功"),
    FAIL(10001, "执行失败");

    private int code;
    private String msg;

    StatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
