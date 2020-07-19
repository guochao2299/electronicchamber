package com.ec.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ec.bean.OperateJDBC;
import com.ec.bean.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		OperateJDBC userBuffer=(OperateJDBC)application.getAttribute("users");
		if(userBuffer==null)
		{
			userBuffer=new OperateJDBC();
			application.setAttribute("users", userBuffer);
		}
		
		User user=null;
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
					
		if(userBuffer.ValidateUser(account,password))
		{
			user=userBuffer.GetUser(account);
			application.setAttribute("currentUser", user);
			request.getRequestDispatcher("main.jsp").forward(request,response);
		}
		else
		{
			response.sendRedirect("error.jsp");
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
