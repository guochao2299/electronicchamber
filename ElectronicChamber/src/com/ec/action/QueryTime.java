package com.ec.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ec.bean.Affair;
import com.ec.bean.OperateJDBC;

/**
 * Servlet implementation class QueryTime
 */
@WebServlet("/QueryTime")
public class QueryTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String year=(String)request.getParameter("year");
		String month=(String)request.getParameter("month");
		OperateJDBC jdbc=new OperateJDBC();
		List<Affair> list=jdbc.queryByTime(year, month);
		request.setAttribute("affairList", list);
		request.setAttribute("sortName", "您的查询结果如下");
		request.getRequestDispatcher("affairs_list_view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
