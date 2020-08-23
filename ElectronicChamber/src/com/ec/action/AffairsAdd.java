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
 * Servlet implementation class AffairsAdd
 */
@WebServlet("/AffairsAdd")
public class AffairsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffairsAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Affair affair=new Affair();
		OperateJDBC jdbc=new OperateJDBC();
		int num=jdbc.recordCount();
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		int sortId=Integer.parseInt(request.getParameter("sort"));
		affair.setAffairId(++num);
		affair.setTitle(title);
		affair.setContent(content);
		
		DateFormat dateFormat=DateFormat.getDateTimeInstance();
		Date date=new Date();
		affair.setReleaseTime(dateFormat.format(date));				
		
		affair.setSortId(sortId);
		
		if(jdbc.save(affair))
		{
			request.setAttribute("result", "OK,添加记录成功！");
		}
		else
		{
			request.setAttribute("result","Sorry，添加记录失败");
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
