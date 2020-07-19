package com.ec.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperateJDBC
{	
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	
	private static Connection getConnection() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("load successfully£¡");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			String url="jdbc:mysql://localhost:3306/electronicchamber?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			con=DriverManager.getConnection(url, "XXX", "XXXXXXX");
			System.out.println("connected successfully!");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	public OperateJDBC()
	{		
		
	}
	
	public Boolean ValidateUser(String userAccount,String password)
	{
		Boolean result=false;
		
		try
		{
			con=getConnection();			
			stmt=con.createStatement();			
			String queryString="select 1 from user where UserAccount='"+userAccount+"' and Password= '"+password+"'";
			rs=stmt.executeQuery(queryString);
			result=rs.next();
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public User GetUser(String userAccount)
	{		
		User u=null;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="SELECT `UserAccount`,`UserName`,`Role` FROM user where UserAccount='"+userAccount+"'";
			rs=stmt.executeQuery(queryString);				
			
			rs.first();
			u=new User();
			u.setAccount(rs.getString("UserAccount"));
			u.setName(rs.getString("UserName"));
			u.setRole(rs.getInt("Role"));
						
			rs.close();
			stmt.close();
			con.close();		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return u;
	}	
}
