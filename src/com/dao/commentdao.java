package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.book;
import com.entity.comment;
import com.util.DBUtil;

public class commentdao {
	public static Connection con;
	static{
		try {
			con = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<comment> querycomments(int bookID) throws SQLException{
		List<comment> commentlist=new ArrayList<comment>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM COMMENTS WHERE BOOKID="+bookID+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int commentid=rs.getInt("id");
			String comment=rs.getString("comment");
			int userID=rs.getInt("userID");
			comment com=new comment(commentid,comment,bookID,userID);
			commentlist.add(com);
		}
		DBUtil.close(stmt, rs);
		return commentlist;
	}
	public static void intocomment(String comment,int bookID,int userID) throws SQLException{
		Statement stmt=con.createStatement();
		String sql="INSERT INTO COMMENTS (COMMENT,BOOKID,USERID) VALUES('"+comment+"',"+bookID+","+userID+")";
		stmt.executeUpdate(sql);
		DBUtil.close(stmt);
	}
}
