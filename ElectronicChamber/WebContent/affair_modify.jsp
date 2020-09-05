<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ec.bean.Affair" %>
<%@ page import="com.ec.bean.Sort" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
	<%
		Affair affair=(Affair)request.getAttribute("affair");
		Sort sort=new Sort();
		List<Sort> list=(ArrayList<Sort>)request.getAttribute("sortList");
		Integer sortId=affair.getSortId();
		String sortName=((Sort)list.get(sortId-1)).getName();
	%>
	<br><div align="center">班级事务修改更新</div>
	<form method="post" action="AffairsUpdate?affairId=<%=affair.getAffairId() %>" style="">
		<font size="2">事务标题：</font>&nbsp;
		<input type="text" size="60" name="title" value="<%=affair.getTitle() %>">&nbsp;
		<font size="2">栏目：</font>&nbsp;
		<select name="sort" id="sort">
			<option Selected value="<%=sortId %>"><%=sortName %></option>
		<%
			int num=list.size();
			for(int i=0;i<num;i++)
			{
				sort=(Sort)list.get(i);		
				if(sort.getSortId()!=sortId)
				{
		%>
		<option value="<%=sort.getSortId() %>"><%=sort.getName()%></option>
		<%
				}
			}
		%>
		</select>
		<p>		
		<textarea rows="15" cols="80" name="content" id="area"><%=affair.getContent() %></textarea>
		<br>
		<input type="submit" value="提交修改" name="xiugai">
		</p>
	</form>
</body>
</html>