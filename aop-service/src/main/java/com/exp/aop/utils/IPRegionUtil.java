package com.exp.aop.utils;

import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: PeterLiu
 * @Date: 2024/1/4 11:48
 * @Description: 获取ip和归属地的工具类
 */
public class IPRegionUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(IPRegionUtil.class);

    private static final String LOCAL_HOST = "127.0.0.1";

    private static final String LOCAL_PREFIX = "192.168";

    private static final String RES = "局域网IP";

    private static final String REGION_DATA_LOCATION = "ip2region/ip2region.xdb";

    private static Searcher searcher;

    public static String getIpv4(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getRegion(String ip) throws Exception {
        String region = "";
        if (LOCAL_HOST.equals(ip) || LOCAL_PREFIX.startsWith(ip)) {
            return RES;
        }
        if (searcher == null) {
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + REGION_DATA_LOCATION);
            String regionPath = file.getPath();
            LOGGER.info("regionPath:{}", regionPath);
            searcher = Searcher.newWithFileOnly(regionPath);
            region = searcher.search(ip);
        }
        return region;
    }
}
