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
	<table border="0px" cellspacing ="0" cellpadding="10" align="center" width="90% gbColor="#a4E8EF">
		<tr>
			<%
				for(int i=0;i<list.size();i++)
				{
					sort=(Sort)list.get(i);
			%>
			<td>
			<a href ="AffairsListMaintain?sortId=<%=sort.getSortId() %>" target="mainFrame"><%=sort.getName() %></a>
			</td>
			<%
				}
			%>
		</tr>
	</table>
</body>
</html>