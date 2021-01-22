package com.zq.myweb.controller;

import com.zq.myweb.entity.Parameter;
import com.zq.myweb.service.CalculateService;
import com.zq.myweb.service.impl.CalculateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: ZQ
 * @date: 2021-01-21-20:08
 */

/**
 * Controller层
 * 传参进行加法
 */
public class SumController extends HttpServlet {


    private CalculateServiceImpl calculateService = new CalculateServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String a1 = req.getParameter("a");
        String b1 = req.getParameter("b");
        req.setCharacterEncoding("utf-8");
        if(a1.length() > 9 || b1.length() > 9){
            req.setAttribute("error","计算参数过大，请重新输入");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
        try {
            Integer a = Integer.valueOf(req.getParameter("a"));
            Integer b = Integer.valueOf(req.getParameter("b"));
        }catch (NumberFormatException e){
            req.setAttribute("error","参数格式不正确");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
        Integer a = Integer.valueOf(req.getParameter("a"));
        Integer b = Integer.valueOf(req.getParameter("b"));
        Parameter parameter = new Parameter(a,b);

        long sum = calculateService.sum(parameter);
        req.setAttribute("sum",sum);
        long multiplication = calculateService.multiplication(parameter);
        req.setAttribute("multiplication",multiplication);
        req.getRequestDispatcher("result.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
