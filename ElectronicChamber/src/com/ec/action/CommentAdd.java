package com.ec.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ec.bean.Affair;
import com.ec.bean.Comment;
import com.ec.bean.OperateJDBC;

/**
 * Servlet implementation class CommentAdd
 */
@WebServlet("/CommentAdd")
public class CommentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String sortName=(String)request.getParameter("sortName");
		Integer affairId=Integer.valueOf(request.getParameter("affairId"));
		OperateJDBC jdbc=new OperateJDBC();
		Affair affair=jdbc.getAffair(affairId);
		Comment comment=new Comment();
		String content=request.getParameter("comment");
		String author=request.getParameter("author");
		comment.setCommentId(new Integer(0));
		comment.setContent(content);
		comment.setUserAccount(author);
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		Date date=new Date();
		comment.setReleaseTime(dateFormat.format(date));
		comment.setAffairId(affairId);
		
		if(jdbc.saveComment(comment))
		{
			List<Comment> commentList=jdbc.getCommentList(affairId);
			request.setAttribute("commentList", commentList);
			request.setAttribute("affair", affair);
			request.setAttribute("sortName", sortName);
			request.getRequestDispatcher("affair_detail.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("result", "Sorry,ÃÌº”∆¿¬€ ß∞‹");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
