package com.ec.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ec.bean.Affair;
import com.ec.bean.OperateJDBC;
import com.ec.bean.Sort;

/**
 * Servlet implementation class AffairDelete
 */
@WebServlet("/AffairDelete")
public class AffairDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffairDelete() {
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
		Integer sortId=Integer.valueOf(request.getParameter("sortId"));
		OperateJDBC jdbc=new OperateJDBC();		
		
		if(jdbc.deleteAffair(affairId)&&jdbc.deleteCommentsByAffairId(affairId))
		{
			logger.info("É¾³ýÊÂÎñ£¬IDÎª£º"+affairId);
			Sort sort=jdbc.getSort(sortId);
			String sortName=sort.getName();
			List<Affair> list =jdbc.affairsList(sortId);
			request.setAttribute("affairList", list);
			request.setAttribute("sortName", sortName);
			request.getRequestDispatcher("affairs_list_maintain.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("result","Sorry£¬É¾³ý¼ÇÂ¼Ê§°Ü");
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
