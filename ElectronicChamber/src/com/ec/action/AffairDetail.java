package com.ec.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ec.bean.Affair;
import com.ec.bean.Comment;
import com.ec.bean.OperateJDBC;
import com.ec.bean.Sort;

/**
 * Servlet implementation class AffairDetail
 */
@WebServlet("/AffairDetail")
public class AffairDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffairDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer affairId=Integer.valueOf(request.getParameter("affairId"));
		OperateJDBC jdbc=new OperateJDBC();
		Affair affair=jdbc.getAffair(affairId);
		Sort sort=jdbc.getSort(affair.getSortId());
		String sortName=sort.getName();
		List<Comment> commentList=jdbc.getCommentList(affairId);
		request.setAttribute("affair", affair);
		request.setAttribute("sortName", sortName);
		request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("affair_detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
