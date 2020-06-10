<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2020/6/6
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改留言界面</title>
    <link rel="stylesheet" href="css/modify.css"/>
    <link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-1.11.3/jquery-1.11.3.min.js"></script>
    <script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("#btn-modify").click(function () {
                var $oldTopic = $("#oldTopic").val().trim();
                var $newTopic = $("#topic").val().trim();
                var $content = $("#content").val().trim();
                if($oldTopic==null||$oldTopic=="") {
                    alert("请输入旧主题！");
                    return false;
                }
                if($newTopic==null||$oldTopic=="") {
                    alert("请输入新主题！");
                    return false;
                }
                if($content==null||$content=="") {
                    alert("请输入新内容！");
                    return false;
                }
                return true;
            });
        });
    </script>
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
    <h4 id="title">修改留言</h4>
    <form id="modify" action="${pageContext.request.contextPath}/modifyServlet" method="post">
        <p id="old_topic">旧主题：</p>
        <input type="text" id="oldTopic" name="oldTopic"/>
        <p id="static_topic">新主题：</p>
        <input id="topic" type="text" name="newTopic"/>
        <p id="static_content">新内容：</p>
        <textarea id="content" name="newContent"></textarea>
        <input type="submit" id="btn-modify" value="发表"/>
    </form>
    <div id="ModifyMsg" class="alert alert-warning alert-dismissable" role="alert">
        <button type="button" class="close" data-dismiss="alert">
            <span>x</span>
        </button>
        <strong>${requestScope.modifyFailure}</strong>
    </div>
</div>
<div id="footer">
    <img src="images/foot.jpg"/>
</div>
</body>
</html>
