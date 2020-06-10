<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2020/6/4
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户注册界面</title>
    <link rel="stylesheet" href="css/register.css" type="text/css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-1.11.3/jquery-1.11.3.min.js"></script>
    <script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("#btn-register").click(function () {
                var $username = $("#username").val().trim();
                var $password = $("#password").val().trim();
                var $age = $("#age").val().trim();
                if($username==null||$username=="") {
                    alert("请输入用户名！");
                    return false;
                }
                if($age==null||$age=="") {
                    alert("请输入年龄！");
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
<h3>欢迎来到用户注册界面</h3>
<div class="container">
    <table>
        <form action="${pageContext.request.contextPath}/registerServlet" method="post" class="form-horizontal">
            <div class="form-group">
                <label for="username">用户名：</label>
                <input type="text" id="username" name="username" placeholder="请输入用户名" class="form-control"/>
            </div>
            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="gender" value="男" checked="checked"/>男
                <input type="radio" name="gender" value="女"/>女
            </div>
            <div class="form-group">
                <label for="age">年龄：</label>
                <input type="text" id="age" name="age" class="form-control" placeholder="请输入年龄"/>
            </div>
            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码"/>
            </div>
            <div id="register">
                <input type="submit" value="注册" id="btn-register"/>
            </div>
        </form>
    </table>
    <!-- 出现错误的提示框-->
    <div class="alert alert-warning alert-dismissable" role="alert">
        <button type="button" class="close" data-dismiss="alert">
            <span>x</span>
        </button>
        <strong>${requestScope.registerMsg}</strong>
    </div>
</div>
</body>
</html>
