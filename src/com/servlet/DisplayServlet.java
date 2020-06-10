package com.servlet;

import com.domain.Message;
import com.domain.User;
import com.service.Impl.MessageServiceImpl;
import com.service.Impl.UserServieImpl;
import com.service.MessageService;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet(name = "DisplayServlet",urlPatterns = "/displayServlet")
public class DisplayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //创建MessageService对象并调用方法
        MessageService messageService = new MessageServiceImpl();
        List<Message> messages = messageService.getAllMessage();
        //创建session域对象
        HttpSession session = request.getSession();
        session.setAttribute("allMessage",messages);
        //重定向到主界面
        response.sendRedirect(request.getContextPath()+"/main.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
