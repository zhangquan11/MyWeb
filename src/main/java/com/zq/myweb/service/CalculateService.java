package com.zq.myweb.service;

import com.zq.myweb.entity.Parameter;

/**
 * @description:
 * @author: ZQ
 * @date: 2021-01-21-20:09
 */
public interface CalculateService {

    /**
     * 计算加法
     * @param param
     * @return long
     */
    long sum(Parameter param);

    /**
     * 计算乘法
     * @param param
     * @return long
     */
    long multiplication(Parameter param);

}
