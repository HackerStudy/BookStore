package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.entity.book;
import com.entity.order;
import com.entity.orderinfo;
import com.util.DBUtil;

public class orderdao {
	public static Connection con;
	static{
		try {
			con = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String generateNo(){
		Date currentTime = new Date();  
		String odate = new SimpleDateFormat("yyyyMMddhhmmss").format(currentTime);  
		String No = "TD"+odate;
		return No;
	}
	public static String generatedate(){
		String date;
		Calendar now = Calendar.getInstance();
		date=now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1)+"-"+now.get(Calendar.DAY_OF_MONTH);
		return date; 
	}
	public static void intoorder(String No,String date,double totalprice,int userID) throws SQLException{
		Statement stmt=con.createStatement();
		String sql ="insert into orders (No,date,totalprice,userID) values('"+No+"','"+date+"',"+totalprice+","+userID+")";
		stmt.executeUpdate(sql);
		DBUtil.close(stmt);
	}
	public static void intoorderinfo(int bookID,String bookName,double price,int bookNumber,double Subtotal,String No) throws SQLException{
		Statement stmt=con.createStatement();
		String sql ="insert into orderinfo (bookID,bookName,price,bookNumber,Subtotal,No) values("+bookID+",'"+bookName+"',"+price+","+bookNumber+","+Subtotal+",'"+No+"')";
		stmt.executeUpdate(sql);
		DBUtil.close(stmt);
	}
	public static List<order> selectorder(int userID) throws SQLException{
		List<order> orderlist=new ArrayList<order>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM ORDERS WHERE USERID="+userID+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int orderid=rs.getInt("id");
			String No=rs.getString("No");
			String date=rs.getString("date");
			double totalprice=rs.getDouble("totalprice");
			order order=new order(orderid,No,date,totalprice,userID);
			orderlist.add(order);
		}
		DBUtil.close(stmt, rs);
		return orderlist;
	}
	public static List<orderinfo> selectorderinfo(String No) throws SQLException{
		List<orderinfo> orderinfolist=new ArrayList<orderinfo>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM ORDERINFO WHERE NO='"+No+"'";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int orderinfoid=rs.getInt("id");
			int bookID=rs.getInt("bookID");
			String bookName=rs.getString("bookName");
			double price=rs.getDouble("price");
			int bookNumber=rs.getInt("bookNumber");
			double Subtotal=rs.getDouble("Subtotal");
			orderinfo orderinfo=new orderinfo(orderinfoid,bookID,bookName,price,bookNumber,Subtotal,No);
			orderinfolist.add(orderinfo);
		}
		DBUtil.close(stmt, rs);
		return orderinfolist;
	}
	public static void delectorder(String No) throws SQLException {
		Statement stmt=con.createStatement();
		String dorderinfo="DELETE FROM ORDERINFO WHERE NO='"+No+"'";
		stmt.execute(dorderinfo);
		String dorder="DELETE FROM ORDERS WHERE NO='"+No+"'";
		stmt.execute(dorder);
		DBUtil.close(stmt);
	}
}
