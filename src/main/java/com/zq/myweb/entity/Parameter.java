package com.zq.myweb.entity;

/**
 * @description:
 * @author: ZQ
 * @date: 2021-01-21-20:28
 */

import java.util.Objects;

/**
 * 计算参数
 */
public class Parameter {

    private int a;
    private int b;

    public Parameter(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return a == parameter.a &&
                b == parameter.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
