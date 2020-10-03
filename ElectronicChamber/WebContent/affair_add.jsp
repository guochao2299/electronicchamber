<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.ec.bean.Sort" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
	<% Sort sort= new Sort(); 
		List<Sort> list=(ArrayList<Sort>)request.getAttribute("sortList");
	%>
	<br>
	<div align="center">
		班级事务发布
		<form method="post" action="AffairsAdd" style="">
			<font size="2">事务标题：</font>&nbsp;
			<input type="text" size="60" name="title">&nbsp;
			<font size="2">栏目：</font>&nbsp;
			<select name="sort">
			<%
				int num=list.size();
				for(int i=0;i<num;i++)
				{
					sort=(Sort)list.get(i);				
			%>
			<option value=<%=String.valueOf(sort.getSortId())%>>
				<%=sort.getName()%></option>
			<%  } %>
			</select>
			<p>
			<textarea rows="15" cols="80" name="content"></textarea>
			<br>
			<input type="submit" value="事务发布" name="fabu">
			</p>
		</form>
   	</div>
</body>
</html>