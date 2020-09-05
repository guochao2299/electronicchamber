<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
 <%@ page import="com.ec.bean.User" %>
<!DOCTYPE html>
<html>
<head>
<title>左侧菜单</title>
</head>
<body>
<table width="169" height="300" border="1"> 
<%
	User user=(User)application.getAttribute("currentUser");
	if(user.getRole()==2)
	{
%>
		<tr><td height="30"><div align="center"><a href="SortList" target="mainFrame">班级事务发布</a></div></td></tr>
		<tr><td height="30"><div align="center"><a href="AffairsMaintain" target="mainFrame">班级事务维护</a></div></td></tr>
<%
	}
%>

<tr>
	<td height="100">班级事务浏览
	<p align="center"><a href="AffairsListView?sortId=1" target="mainFrame">学习竞赛</a></p>
	<p align="center"><a href="AffairsListView?sortId=2" target="mainFrame">文体活动</a></p>
	<p align="center"><a href="AffairsListView?sortId=3" target="mainFrame">社会事务</a></p>
	<p align="center"><a href="AffairsListView?sortId=4" target="mainFrame">各类补助</a></p>
</tr>
<tr><td height="30"><div align="center"><a href="query_pattern.jsp" target ="mainFrame">班级事务查询</a></div>
</table>
</body>
</html>