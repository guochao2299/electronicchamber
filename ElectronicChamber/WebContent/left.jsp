<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
 <%@ page import="com.ec.bean.User" %>
<!DOCTYPE html>
<html>
<head>
<title>���˵�</title>
</head>
<body>
<table width="169" height="300" border="1"> 
<%
	User user=(User)application.getAttribute("currentUser");
	if(user.getRole()==2)
	{
%>
		<tr><td height="30"><div align="center"><a href="#" target="mainFrame">�༶���񷢲�</a></div></td></tr>
		<tr><td height="30"><div align="center"><a href="#" target="mainFrame">�༶����ά��</a></div></td></tr>
<%
	}
%>

<tr>
	<td height="100">�༶�������
	<p align="center"><a href="#" target="mainFrame">ѧϰ����</a></p>
	<p align="center"><a href="#" target="mainFrame">����</a></p>
	<p align="center"><a href="#" target="mainFrame">�������</a></p>
	<p align="center"><a href="#" target="mainFrame">���ಹ��</a></p>
</tr>
<tr><td height="30"><div align="center"><a href="#" target ="mainFrame">�༶�����ѯ</a></div>
</table>
</body>
</html>