package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.comment;
import com.entity.user;
import com.util.DBUtil;

public class userdao {
	public  static boolean validateuser(String email,String pwd) throws SQLException{
		boolean flag;
		Connection con=DBUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql="SELECT EMAIL,PASSWORD FROM USER WHERE EMAIL='"+email+"'AND PASSWORD='"+pwd+"'";
		ResultSet r=stmt.executeQuery(sql);
		flag=r.next();
		r.close();
		stmt.close();
		con.close();
		return flag;
	}
	public static int selectuserID(String email) throws SQLException{
		int userID = 0;
		Connection con=DBUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql="SELECT ID FROM USER WHERE EMAIL='"+email+"'";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			userID=rs.getInt("id");
		}
		rs.close();
		stmt.close();
		con.close();
		return userID;
	}
	public static boolean checkemail(String email) throws SQLException{
		Connection con=DBUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM USER WHERE email='"+email+"'";
		ResultSet rs=stmt.executeQuery(sql);
		boolean emailflage=rs.next();
		return emailflage;
	}
	public	static user selectuserinfo(int userID) throws SQLException{
		Connection con=DBUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql="SELECT USERNAME,SEX,PASSWORD,PHONE,EMAIL FROM USER WHERE ID="+userID+"";
		user info = null;
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			String username=rs.getString("username");
			String sex=rs.getString("sex");
			String password=rs.getString("password");
			String phone=rs.getString("phone");
			String email=rs.getString("email");
			info=new user(userID,username,sex,password,phone,email);
		}
		rs.close();
		stmt.close();
		con.close();
		return info;
	}
	public	static void intouser(String username,String sex,String password,String phone,String email) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstm=(PreparedStatement) con.prepareStatement("insert into user (username,sex,password,phone,email) values(?,?,?,?,?)");
		pstm.setString(1, username);
		pstm.setString(2,sex);
		pstm.setString(3, password);
		pstm.setString(4, phone);
		pstm.setString(5,email);
		pstm.executeUpdate();
		pstm.close();
		con.close();
	}
	public	static void modifyuserinfo(int userID,String newpassword,String sex,String phone) throws SQLException{
		Connection con=DBUtil.getConnection();
		Statement stmt=con.createStatement();
		String updateuser="UPDATE USER SET PASSWORD='"+newpassword+"',SEX='"+sex+"',PHONE='"+phone+"' WHERE ID="+userID+"";
		stmt.execute(updateuser);
		stmt.close();
		con.close();
	}
	public	static List<comment> qcomments(int bookID){
		List<comment> clist = new ArrayList<comment>();
		Connection con;
		try {
			con = DBUtil.getConnection();
			Statement stmt=con.createStatement();
			String sql="SELECT * FROM COMMENTS WHERE BOOKID="+bookID+"";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int commentID=rs.getInt("id");
				String comment=rs.getString("comment");
				int userID=rs.getInt("userID");
				comment c=new comment(commentID,comment,bookID,userID);
				clist.add(c);
			}
			DBUtil.close(con, stmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
	}
	public	static String qusername(int userID){
		String username = null;
		Connection con;
		try {
			con = DBUtil.getConnection();
			Statement stmt=con.createStatement();
			String sql="SELECT username FROM user WHERE id="+userID+"";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				username=rs.getString("username");
			}
			DBUtil.close(con, stmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return username;
	}
	public	static void intocomment(String comment,int bookID,int userID){
		String username = null;
		Connection con;
		try {
			con = DBUtil.getConnection();
			Statement stmt=con.createStatement();
			String sql="INSERT INTO COMMENTS (COMMENT,BOOKID,USERID) VALUES('"+comment+"',"+bookID+","+userID+")";
			stmt.execute(sql);
			DBUtil.close(con, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
