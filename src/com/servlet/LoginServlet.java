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

@WebServlet(name = "loginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //获取页面参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用UserService的登陆方法
        UserService userService = new UserServieImpl();
        User user = userService.loginUser(username, password);
        //如果user为空则说明用户不存在
        if(user == null) {
            //界面上提示信息
            request.setAttribute("loginMsg","登陆失败，用户不存在或密码错误!");
            //重新加载登陆界面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            //把user保存到session域中
            session.setAttribute("user",user);
            //不为空user存在 跳转到主界面
            response.sendRedirect(request.getContextPath()+"/displayServlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
