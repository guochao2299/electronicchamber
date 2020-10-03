package com.ec.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
	private static BasicDataSource dataSource;

	   private ConnectionFactory() {
	   }

	   public static Connection getConnection() throws SQLException {
	      if (dataSource == null) {
	         dataSource = new BasicDataSource();
	         dataSource.setUrl("jdbc:mysql://localhost:3306/electronicchamber?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	         dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	         dataSource.setUsername("XXXXX");
	         dataSource.setPassword("XXXXXXXXX");
	      }
	      return dataSource.getConnection();
	   }

	/*
	 * private static Connection con=null;
	 * 
	 * private ConnectionFactory() { }
	 * 
	 * public static Connection getConnection() throws SQLException { if (con ==
	 * null) { try { Class.forName("com.mysql.jdbc.Driver"); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * try { String url=
	 * "jdbc:mysql://localhost:3306/electronicchamber?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	 * con=DriverManager.getConnection(url, "root", "Abc1234567"); } catch
	 * (Exception e) { e.printStackTrace(); } } return con; }
	 */
}