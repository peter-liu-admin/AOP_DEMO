package com.exp.aop.utils;

import cn.hutool.core.net.NetUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: PeterLiu
 * @Date: 2024/1/4 15:22
 * @Description: 获取mac地址
 */
public class MacUtil {
    public static String getMacAddress() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String macAddress = NetUtil.getMacAddress(inetAddress);
        return macAddress;
    }

    public static void main(String[] args) throws UnknownHostException {
        String macAddress = getMacAddress();
        System.out.println(macAddress);
    }
}
