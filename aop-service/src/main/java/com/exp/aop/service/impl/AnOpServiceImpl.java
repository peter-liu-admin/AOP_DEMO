package com.exp.aop.service.impl;

import com.exp.aop.service.AnOpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: PeterLiu
 * @Date: 2023/11/2 16:38
 * @Description:
 */
@Service
@Slf4j
public class AnOpServiceImpl implements AnOpService {

    private static final String EMAIL = "110";

    @Override
    public Integer sendEmail(String email) throws Exception{
        log.info("email:{}", email);
//        int res=10/0;
        return EMAIL.equals(email) ? 100 : 9;
    }
}
