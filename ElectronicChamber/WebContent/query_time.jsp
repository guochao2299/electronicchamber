<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> list1=(ArrayList<String>)request.getAttribute("yearList");
		List<String> list2=(ArrayList<String>)request.getAttribute("monthList");
	%>
	<div align="center"><br><h3>��ʱ��β�ѯ�༶����</h3>
	<form method="post" action="QueryTime" style=""><br><br>
		<font size="">��ѡ����ݣ�</font>
		<select name="year">
			<% 
				for(int i=0;i<list1.size();i++)
			  	{
			%>
					<option value="<%=list1.get(i) %>"><%=list1.get(i) %></option>
			<%
			  	}
			%>
		</select>
		<font size="">��ѡ��ʱ��Σ�</font>
		<select name="month">
			<% 
				for(int i=0;i<list2.size();i++)
			  	{
			%>
					<option value="<%=i %>"><%=list2.get(i) %></option>
			<%
			  	}
			%>
		</select>
		<br><br>
		<input type="submit" value="��   ��" name="query">
		</form>
	</div>
</body>
</html>