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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "PublishServlet",urlPatterns = "/publishServlet")
public class PublishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //获取页面参数
        String topic = request.getParameter("topic");
        String content = request.getParameter("content");
        //添加时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");
        String time = dateFormat.format(date);
        //创建UserService对象
        UserService userService = new UserServieImpl();
        //获取session域对象中存的username
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        //执行根据用户名查ID的方法
        Integer userId = userService.getUserIdByName(user.getUsername());
        //把各个参数封装到Message对象
        Message message = new Message();
        message.setContent(content);
        message.setTopic(topic);
        message.setTime(time);
        message.setUserId(userId);
        //调用保存留言方法
        MessageService messageService = new MessageServiceImpl();
        messageService.saveMessage(message,user.getUsername());
        //重定向到displayServlet
        response.sendRedirect(request.getContextPath()+"/displayServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
