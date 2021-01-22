package com.zq.myweb;

import com.zq.myweb.controller.MyWeb;

/**
 * @description:
 * @author: ZQ
 * @date: 2021-01-22-11:45
 */
public class WebStart {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir") + "/src/main/webapp/");
        new MyWeb().startServer(8000);
    }
}
