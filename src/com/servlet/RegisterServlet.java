package com.servlet;

import com.domain.User;
import com.service.Impl.UserServieImpl;
import com.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        User user = new User();
        //获取界面参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        //调用service层查询userId 判断用户名是否已经注册
        UserService userService = new UserServieImpl();
        Integer userId = userService.getUserIdByName(user.getUsername());
        if(userId==null) {
            //为空说明不存在 可以注册
            //调用service层方法完成注册
            userService.registerUser(user);
            //注册成功之后跳转到登陆界面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else {
            //注册失败 提示信息并在界面上显示出来
            request.setAttribute("registerMsg","注册失败，该用户名已经注册！");
            //重新加载注册界面
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
