<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ec.bean.Affair" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
	<%
		String sortName=(String)request.getAttribute("sortName");
		List<Affair> list=(ArrayList<Affair>)request.getAttribute("affairList");
	%>
	<h1 align="center"><%=sortName %></h1>
	<table  border="1px" cellspacing ="0" cellpadding="10" align="center" width="60%">
		<tr bgColor="#77A2E9">
			<td width="10%"> <div align="center">������</div></td>
			<td width="44%"> <div align="center">�������</div></td>
			<td width="20%"> <div align="center">����ʱ��</div></td>
			<td width="13%"> <div align="center">�༭</div></td>
			<td width="13%"> <div align="center">ɾ��</div></td>
		</tr>
		<%		
			for(int i=0;i<list.size();i++)
			{
				Affair affair=(Affair)list.get(i);			
				
		%>
		<tr>
			<td><div align="center"><%=i+1 %></div></td>
			<td><%=affair.getTitle() %></td>
			<td><div align="center"><%=affair.getReleaseTime() %></div></td>
			<td><div align="center"><a href="AffairModify?affairId=<%=affair.getAffairId() %>">�༭</a></div></td>
			<td><div align="center"><a onclick="return window.confirm('���������������Ҳ��ȫ����ɾ����ȷ��ɾ����');" href="AffairDelete?affairId=<%=affair.getAffairId() %>&sortId=<%=affair.getSortId()%>">ɾ��</a></div></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>