<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2020/6/6
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>发表留言界面</title>
    <link rel="stylesheet" href="css/publish.css"/>
    <link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-1.11.3/jquery-1.11.3.min.js"></script>
    <script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("#btn-publish").click(function () {
                //获取输入框的值
                var $topic = $("#topic").val().trim();
                var $content = $("#content").val().trim();
                if($topic==null||$topic=="") {
                    //为空则不提交
                    alert("主题不能为空!");
                    return false;
                }
                if($content==null||$content=="") {
                    alert("内容不能为空!");
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
    <h4 id="title">我要留言</h4>
    <form id="publish" action="${pageContext.request.contextPath}/publishServlet" method="post">
        <p id="static_topic">主题：</p>
        <input id="topic" type="text" name="topic"/>
        <p id="static_content">内容：</p>
        <textarea id="content" name="content"></textarea>
        <input type="submit" id="btn-publish" value="发表"/>
    </form>
</div>
<div id="footer">
    <img src="images/foot.jpg"/>
</div>
</body>
</html>
