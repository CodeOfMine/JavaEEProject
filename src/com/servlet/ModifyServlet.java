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

@WebServlet(name = "ModifyServlet",urlPatterns = "/modifyServlet")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取旧主题
        String oldTopic = request.getParameter("oldTopic");
        //获取新主题
        String newTopic = request.getParameter("newTopic");
        //获取新内容
        String newContent = request.getParameter("newContent");
        //创建session对象
        HttpSession session = request.getSession();
        //取域对象中的数据
        User user = (User)session.getAttribute("user");
        //调用UserService的根据用户名查ID的方法获取到userId
        UserService userService = new UserServieImpl();
        Integer userId = userService.getUserIdByName(user.getUsername());
        //调用查询方法
        MessageService messageService = new MessageServiceImpl();
        Integer messageId = messageService.getMessageByTopic(oldTopic, userId);
        if(messageId==null) {
            //说明留言信息不存在或者不是本人发布则不让修改
            String failureMessage = "修改失败！留言信息不存在或不是本人发布无法修改!";
            request.setAttribute("modifyFailure",failureMessage);
            request.getRequestDispatcher("/modify.jsp").forward(request,response);
        }else {
            //留言存在 可以修改
            Message message = new Message();
            message.setTopic(newTopic);
            message.setContent(newContent);
            //更新时间
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");
            String time = dateFormat.format(date);
            message.setTime(time);
            //调用修改方法完成修改
            messageService.modifyMessage(message,oldTopic);
            //重定向到displayServlet
            response.sendRedirect(request.getContextPath()+"/displayServlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
