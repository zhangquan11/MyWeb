package com.zq.myweb.service.impl;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZQ
 * @date: 2021-01-22-11:38
 */
public class HttpServer extends Thread {

    /**
     * 输入流对象,读取浏览器请求
     */
    private InputStream input;

    /**
     * 输出流对象，响应内容给浏览器
     */
    private OutputStream out;

    /**
     * 初始化socket对象,获取对应输入、输出流
     * @param socket
     */
    public HttpServer(Socket socket) {
        try {
            input = socket.getInputStream();
            out = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String read = read();
        System.out.println("read              "+ read);
        List<String> param = new ArrayList<>();
        String type = "";
        for(int i = 0 ; i < read.length() ; i++){
            if(read.charAt(i) == '?'){
                type = read.substring(0,i);
                for(int j = 0 ; j < read.length() ; j++){
                    if(read.charAt(j) == '='){
                        i = j + 1;
                    }
                    if(read.charAt(j) == '&'){
                        param.add(read.substring(i,j));
                    }
                    if(j == read.length() - 1){
                        param.add(read.substring(i,j + 1));
                    }
                }
                break;
            }
        }
        response(type,param);
    }


    private void response(String type,List<String> param) {

        StringBuffer result = new StringBuffer();
        result.append("HTTP /1.1 400 file not found /r/n");
        result.append("Content-Type:text/html \r\n");
        result.append("Content-Length:20 \r\n").append("\r\n");
        if(type == null)return;
        else if(type.equals("/sum")){
            Long value = Long.valueOf(param.get(0))+Long.valueOf(param.get(1));
            result.append("<h1 >");
            result.append(value.toString());
            if(value.toString().length() < 16){
                for (int i = 1 ; i < 16 - value.toString().length() ; i++){
                    result.append(" ");
                }
            }
            result.append("</h1>");
        }
        else if(type.equals("/mult")){
            Long value = Long.valueOf(param.get(0))*Long.valueOf(param.get(1));
            result.append("<h1 >");
            result.append(value.toString());
            if(value.toString().length() < 16){
                for (int i = 1 ; i < 16 - value.toString().length() ; i++){
                    result.append(" ");
                }
            }
            result.append("</h1>");
        }

        try {
            out.write(result.toString().getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 解析资源文件路径
     * @return
     */
    private String read() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        try {
            // 读取请求头， 如：GET /index.html HTTP/1.1
            String readLine = reader.readLine();
            String[] split = readLine.split(" ");
            if (split.length != 3) {
                return null;
            }
            return split[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
