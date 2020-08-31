package com.ec.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ec.bean.Affair;
import com.ec.bean.OperateJDBC;

/**
 * Servlet implementation class AffairsUpdate
 */
@WebServlet("/AffairsUpdate")
public class AffairsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffairsUpdate() {
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
		Affair affair=new Affair();
		OperateJDBC jdbc=new OperateJDBC();		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		int sortId=Integer.parseInt(request.getParameter("sort"));		
		affair.setTitle(title);
		affair.setContent(content);
		
		DateFormat dateFormat=DateFormat.getDateTimeInstance();
		Date date=new Date();
		affair.setReleaseTime(dateFormat.format(date));				
		
		affair.setSortId(sortId);
		
		if(jdbc.updateAffair(affair, affairId))
		{
			request.setAttribute("result", "OK,修改记录成功！");
		}
		else
		{
			request.setAttribute("result","Sorry，修改记录失败");
		}
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
