package com.mmz.servlet;

import com.mmz.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Classname SessionDemo1
 * @Description TODO
 * @Date 2020/12/17 9:54
 * @Created by mmz
 */
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码问题
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        // 得到session
        HttpSession session = req.getSession();


        // 给session存放东西
        session.setAttribute("name",new Person("mmz",25));
        String id = session.getId();

        // 判断session是不是新创建的
        if(session.isNew()){
            resp.getWriter().write("session创建成功,ID为"+id);
        }else{
            resp.getWriter().write("已经创建了");
        }

        // session创建做了什么


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
