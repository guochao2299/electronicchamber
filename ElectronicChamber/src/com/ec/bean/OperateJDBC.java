package com.ec.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
			con=DriverManager.getConnection(url, "XXXXX", "XXXXXXXX");
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
	
	public List<Sort> getSorts()
	{
		List<Sort> list=new ArrayList<Sort>();
		Sort sort;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="SELECT * FROM sort";
			rs=stmt.executeQuery(queryString);	
			
			while(rs.next())
			{
				sort=new Sort();
				sort.setSortId(rs.getInt("sortId"));
				sort.setName(rs.getString("name"));
				
				list.add(sort);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int recordCount()
	{
		int num=0;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="SELECT * FROM affair";
			rs=stmt.executeQuery(queryString);	
			
			while(rs.next())
			{
				num++;
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return num;
	}
	
	public boolean save(Affair affair)
	{
		boolean boo=false;
		int num = affair.getAffairId();
		String title=affair.getTitle();
		String content=affair.getContent();
		String fbTime=affair.getReleaseTime();
		int sortId=affair.getSortId();
				
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			
			String str="insert into affair values(";
			str+=num+",'"+title+"','"+content+"','"+fbTime+"',"+sortId+")";			
			
			stmt.executeUpdate(str);	
			
			boo=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			boo=false;
		}
		finally
		{			
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return boo;
	}
	
	public Sort getSort(Integer sortId)
	{
		Sort sort=null;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="SELECT * FROM sort where sortId = "+sortId;
			rs=stmt.executeQuery(queryString);	
			
			while(rs.next())
			{
				sort=new Sort();
				sort.setSortId(rs.getInt("sortId"));
				sort.setName(rs.getString("name"));
				
				break;
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return sort;
	}
	
	public List<Affair> affairsList(Integer sortId)
	{
		List<Affair> list=new ArrayList<Affair>();
		Affair affair;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="SELECT * FROM affair where sortId = " +sortId;
			rs=stmt.executeQuery(queryString);	
			
			while(rs.next())
			{
				affair=new Affair();
				affair.setAffairId(rs.getInt("affairId"));
				affair.setTitle(rs.getString("title"));
				affair.setContent(rs.getString("content"));
				affair.setReleaseTime(rs.getString("releaseTime"));
				affair.setSortId(rs.getInt("sortId"));
				
				list.add(affair);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public Affair getAffair(Integer affairId)
	{
		Affair affair=null;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="SELECT * FROM affair where affairId = " +affairId;
			rs=stmt.executeQuery(queryString);	
			
			while(rs.next())
			{
				affair=new Affair();
				affair.setAffairId(rs.getInt("affairId"));
				affair.setTitle(rs.getString("title"));
				affair.setContent(rs.getString("content"));
				affair.setReleaseTime(rs.getString("releaseTime"));
				affair.setSortId(rs.getInt("sortId"));
				
				break;
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return affair;
	}
	
	public boolean updateAffair(Affair affair,Integer affairId)
	{
		boolean boo=false;
		String title=affair.getTitle();
		String content=affair.getContent();
		String faTime=affair.getReleaseTime();
		int sortId=affair.getSortId();
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="update affair set title = '"+title+"',content = '"+content+"',releaseTime = '" +faTime+"',sortId = "+sortId+" where affairId = " +affairId;
			stmt.executeUpdate(queryString);	
			
			boo=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return boo;
	}
	
	public boolean deleteAffair(Integer affairId)
	{
		boolean boo=false;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="delete FROM affair where affairId = " +affairId;
			stmt.executeUpdate(queryString);	
			
			boo=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return boo;
	}
	
	public boolean deleteCommentsByAffairId(Integer affairId)
	{
		boolean boo=false;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="delete FROM comment where affairId = " +affairId;
			stmt.executeUpdate(queryString);	
			
			boo=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return boo;
	}
	
	public boolean saveComment(Comment comment)
	{
		boolean boo=false;
		int commentId=comment.getCommentId();
		String content=comment.getContent();
		String releaseTime=comment.getReleaseTime();
		String author=comment.getUserAccount();
		int affairId=comment.getAffairId();		
				
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			
			String str="insert into comment values(";
			str+=commentId+",'"+content+"','"+releaseTime+"','"+author+"',"+affairId+")";			
			
			stmt.executeUpdate(str);	
			
			boo=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			boo=false;
		}
		finally
		{			
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return boo;
	}
	
	public List<Comment> getCommentList(Integer affairId)
	{
		List<Comment> list=new ArrayList<Comment>();
		Comment comment;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="SELECT * FROM comment where affairId = " +affairId;
			rs=stmt.executeQuery(queryString);	
			
			while(rs.next())
			{
				comment=new Comment();
				comment.setAffairId(rs.getInt("affairId"));
				comment.setUserAccount(rs.getString("userAccount"));
				comment.setContent(rs.getString("content"));
				comment.setReleaseTime(rs.getString("time"));
				comment.setCommentId(rs.getInt("commentId"));
				
				list.add(comment);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<String> getYears()
	{
		List<String> list=new ArrayList<String>();
		String temp;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="SELECT left(releaseTime,4) FROM affair group by left(releaseTime,4)";
			rs=stmt.executeQuery(queryString);	
			
			while(rs.next())
			{
				temp=rs.getString(1);
				
				list.add(temp);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public List<Affair> queryByTitle(String keyTitle)
	{
		List<Affair> list=new ArrayList<Affair>();
		Affair affair;
		
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			String queryString="SELECT * FROM affair where title like '%"+keyTitle+"%'";
			rs=stmt.executeQuery(queryString);	
			
			while(rs.next())
			{
				affair=new Affair();
				affair.setAffairId(rs.getInt("affairId"));
				affair.setTitle(rs.getString("title"));
				affair.setContent(rs.getString("content"));
				affair.setReleaseTime(rs.getString("releaseTime"));
				affair.setSortId(rs.getInt("sortId"));
				
				list.add(affair);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<Affair> queryByTime(String year,String month)
	{
		List<Affair> list=new ArrayList<Affair>();
		Affair affair;
		int temp=Integer.parseInt(month);
		String queryString=null;
				
		try
		{
			con=getConnection();
			stmt=con.createStatement();
			
			switch(temp)
			{
				case 0:
					queryString="select * from affair where left(releaseTime,4)='"+year+"'";
					break;
					
				case 1:
					queryString="select * from affair where mid(releaseTime,6,2) between '01' and '06' and left(releaseTime,4)='"+year+"'";
					break;
					
				case 2:
					queryString="select * from affair where mid(releaseTime,6,2) between '07' and '12' and left(releaseTime,4)='"+year+"'";
					break;					
					
			}
			
			rs=stmt.executeQuery(queryString);	
			
			while(rs.next())
			{
				affair=new Affair();
				affair.setAffairId(rs.getInt("affairId"));
				affair.setTitle(rs.getString("title"));
				affair.setContent(rs.getString("content"));
				affair.setReleaseTime(rs.getString("releaseTime"));
				affair.setSortId(rs.getInt("sortId"));
				
				list.add(affair);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
