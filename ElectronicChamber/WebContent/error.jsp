<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta charset="GB18030">
<title>用户名密码错误</title>
</head>
<body>
你输入的用户名或密码有误，2秒后将跳转回登录页面！
<% response.setHeader("refresh", "2;URL=login.jsp");%>
</body>
</html>