package com.mmz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @Classname CookieDemo1
 * @Description TODO
 * @Date 2020/12/17 8:51
 * @Created by mmz
 */
/*保留用户上一次访问的时间*/
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        // cookie,从客户端发送的请求中获取
        Cookie[] cookies = req.getCookies(); // 这里返回数组，说明cookie可能存在多个

        // 判断cookie是否存在
        if(cookies != null){
            System.out.println("cookie存在");
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("lastLoginTime")){
                    writer.println(cookie.getValue());
                    Long l =Long.parseLong(cookie.getValue());
                    Date date = new Date(l);
                    writer.println(date.toLocaleString());
                }
            }
        }else{
            System.out.println("cookie不存在 ");
            writer.println("这是您第一次访问网站");
        }



        // 服务器给客户端响应一个cookie

        Cookie cookie1 = new Cookie("lastLoginTime",System.currentTimeMillis()+"");

        // 设置cookie过期的时间
        cookie1.setMaxAge(24*60*60);
        resp.addCookie(cookie1);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
