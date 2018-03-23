package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static String url="jdbc:mysql://localhost:3306/bookstore?useUnicode=true&characterEncoding=UTF-8";
	private static String name="root";
	private static String pwd="123456";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, name, pwd);
	}
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		if(rs != null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(stmt != null)try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(conn != null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}
	}	
	public static void close(Connection conn,Statement stmt){
		close(conn,stmt,null);
	}
	public static void close(Statement stmt,ResultSet rs){
		close(null,stmt,rs);
	}
	public static void close(Statement stmt){
		close(null,stmt,null);
	}
}
