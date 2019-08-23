<%--
  Created by IntelliJ IDEA.
  User: rix
  Date: 2019/8/5
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<h3>传统文件上传</h3>

<form action="load/fileupload1" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>

<h3>Springmvc文件上传</h3>

<form action="load/fileupload2" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>

<h3>跨服务器文件上传</h3>

<form action="load/fileupload3" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
