<%--
  Created by IntelliJ IDEA.
  User: rix
  Date: 2019/8/20
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙。。。</h1>
    <%
        String message = exception.getMessage();
        out.print(message);
    %>>
</body>
</html>
