<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2020/6/4
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户登陆界面</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-1.11.3/jquery-1.11.3.min.js"></script>
    <script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("#login").click(function () {
                //获取输入框的值 判断为空则不提交表单
                var $username = $("#username").val().trim();
                var $password = $("#password").val().trim();
                if($username==null||$username=="") {
                    alert("请输入用户名！");
                    return false;
                }
                if($password==null||$password=="") {
                    alert("请输入密码！");
                    return false;
                }
                return true;
            });
        });
    </script>
</head>
<body>
<h3>欢迎来到用户登录界面</h3>
<br>
<div class="box">
    <table class="table-form">
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
            <tr>
                <td><label for="username">用户名：</label></td>
                <td><input type="text" name="username" id="username" placeholder="请输入用户名"/><br></td>
            </tr>
            <tr>
                <td><label for="password">密码：</label></td>
                <td><input type="password" name="password" id="password" placeholder="请输入密码"/><br></td>
            </tr>
            <tr>
                <td colspan="2"><input id="login" type="submit" value="登陆"/></td>
            </tr>
        </form>
    </table>
</div>
<p>没有账号？<a href="${pageContext.request.contextPath}/register.jsp">去注册</a></p>
<div id="loginMsg" class="alert alert-warning alert-dismissable" role="alert">
    <button type="button" class="close" data-dismiss="alert">
        <span>x</span>
    </button>
    <strong>${requestScope.loginMsg}</strong>
</div>
</body>
</html>
