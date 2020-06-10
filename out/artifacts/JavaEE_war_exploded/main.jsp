<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2020/6/4
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看留言界面</title>
    <link rel="stylesheet" href="css/main.css"/>
    <link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-1.11.3/jquery-1.11.3.min.js"></script>
    <script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div id="header">
    <img src="images/header.jpg"/>
    <h3 class="welcome">欢迎您，${sessionScope.user.username}</h3>
    <a id="loginout" href="${pageContext.request.contextPath}/login.jsp">退出</a>
    <div id="as">
        <a href="${pageContext.request.contextPath}/main.jsp">查看留言</a>
        <a href="${pageContext.request.contextPath}/publish.jsp">发表留言</a>
        <a href="${pageContext.request.contextPath}/modify.jsp">修改留言</a>
    </div>
</div>
<div id="center" class="container">
    <h4 id="title">查看留言</h4>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>主题</th>
            <th>作者</th>
            <th>内容</th>
            <th>时间</th>
        </tr>
        <c:forEach var="message" items="${sessionScope.allMessage}" varStatus="m">
            <tr>
                <td>${m.count}</td>
                <td>${message.topic}</td>
                <td>${message.username}</td>
                <td>${message.content}</td>
                <td>${message.time}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="footer">
    <img src="images/foot.jpg"/>
</div>
</body>
</html>
