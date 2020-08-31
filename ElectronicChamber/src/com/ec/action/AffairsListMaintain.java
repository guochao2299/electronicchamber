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
import com.ec.bean.Sort;

/**
 * Servlet implementation class AffairsListMaintain
 */
@WebServlet("/AffairsListMaintain")
public class AffairsListMaintain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffairsListMaintain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer sortId=Integer.valueOf(request.getParameter("sortId"));
		OperateJDBC jdbc=new OperateJDBC();
		Sort sort=jdbc.getSort(sortId);
		String sortName=sort.getName();
		List<Affair> list =jdbc.affairsList(sortId);
		request.setAttribute("affairList", list);
		request.setAttribute("sortName", sortName);
		request.getRequestDispatcher("affairs_list_maintain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
