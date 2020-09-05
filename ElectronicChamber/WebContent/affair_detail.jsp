<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.ec.bean.Affair" %>
<%@ page import="com.ec.bean.Comment" %>
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
	Affair affair=(Affair)request.getAttribute("affair");
    String sortName=(String)request.getAttribute("sortName");   
    List<Comment> commentList=(ArrayList<Comment>)request.getAttribute("commentList");
%>
<table border="0px" cellspacing ="0" cellpadding="10" align="center" width="70" noborder>
	<tr bgcolor="#77A2E9">
	<td nowrap="nowrap">
		<center><h3>事务标题：<%=affair.getTitle() %></h3></center>
	</td>
	</tr>
	<tr><td><br>
		<center>所属类别：<%=sortName %>&nbsp;&nbsp;&nbsp;发布日期：<%=affair.getReleaseTime() %></center>
		</td>
	</tr>
	<tr><td><hr width="100%"><br><%=affair.getContent() %></td></tr>
</table>
<hr align="left" width="80%">
<font size="2" color="#ff0000">读着评论</font>
<%
	if(commentList.size()>0)
	{
		for(int i=0;i<commentList.size();i++)
		{
			Comment comment=(Comment)commentList.get(i);
%>
			<hr align="left" width="80%">
			<font size="2" color="#0000ff"><%=comment.getUserAccount() %> 评论&nbsp;&nbsp;&nbsp;评论日期：<%=comment.getReleaseTime() %></font>
			<p>
			<font size="2"><%=comment.getContent() %></font>
<%
		}
	}
%>
<form method="post" action="CommentAdd?affairId=<%=affair.getAffairId() %>&sortName">
	<font size="2"><br>发表评论：</font>
	<p><textarea cols="60" rows="4" name="content"></textarea></p>
	<p>
	<font size="2"><br>发布者：</font>
	<input type="text" size="30" name="author">
	<input type="submit" value="发表评论" name="comment">
	</p>
</form>
</body>
</html>