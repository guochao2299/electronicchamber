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
 * Servlet implementation class QueryTitle
 */
@WebServlet("/QueryTitle")
public class QueryTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTitle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String keyTitle=(String)request.getParameter("keyTitle");
		keyTitle=new String(keyTitle.getBytes("GB18030"));
		OperateJDBC jdbc=new OperateJDBC();
		List<Affair> list=jdbc.queryByTitle(keyTitle);
		request.setAttribute("affairList", list);
		request.setAttribute("sortName", "²éÑ¯½á¹û");
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
