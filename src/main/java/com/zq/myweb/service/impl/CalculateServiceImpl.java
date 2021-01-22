package com.zq.myweb.service.impl;

import com.zq.myweb.entity.Parameter;
import com.zq.myweb.service.CalculateService;

/**
 * @description:
 * @author: ZQ
 * @date: 2021-01-21-20:10
 */

/**
 * 业务层
 */
public class CalculateServiceImpl implements CalculateService {


    @Override
    public long sum(Parameter param) {
        return param.getA()+param.getB();
    }

    @Override
    public long multiplication(Parameter param) {
        return param.getA()*param.getB();
    }
}
