<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
<%	
	String result=(String)request.getAttribute("result");
    out.println(result);	
%>
</body>
</html>