package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Usercart;
import com.util.DBUtil;

public class Cartdao {
	public static Connection con;
	static{
		try {
			con = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<Usercart> qUsercart(int userID){
		List<Usercart> cart=new ArrayList<Usercart>();
		try {
			Statement stmt=con.createStatement();
			String sql="SELECT * FROM USERCART WHERE USERID = "+userID+" ";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int bookID=rs.getInt(3);
				String bookName=rs.getString(4);
				double price=rs.getDouble(5);
				double costPrice=rs.getDouble(6);
				int bookNumber=rs.getInt(7);
				double Subtotal=rs.getDouble(8);
				Usercart ucart=new Usercart(bookID,bookName,price,costPrice,bookNumber,Subtotal);
				cart.add(ucart);
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return cart;
		}
	}
	public static void clearcart(int userID) {
		try {
			Statement stmt=con.createStatement();
			String sql="DELETE FROM USERCART WHERE USERID = "+userID+" ";
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delectcart(int userID,int bookID) {
		try {
			Statement stmt=con.createStatement();
			String sql="DELETE FROM USERCART WHERE userID = "+userID+" AND BOOKID = "+bookID+" ";
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void alternum(int userID,int bookID,double price,int flag,int bookNumber) {
		try {
			Statement stmt=con.createStatement();
			if(flag==0){
				if(bookNumber>1){
					String sql0="UPDATE usercart SET bookNumber=bookNumber-1,Subtotal=Subtotal-"+price+" WHERE USERID = "+userID+" AND BOOKID="+bookID+"";
					stmt.execute(sql0);
				}
			}else{
				String sql1="UPDATE usercart SET bookNumber=bookNumber+1,Subtotal=Subtotal+"+price+" WHERE USERID = "+userID+" AND BOOKID="+bookID+"";
				stmt.execute(sql1);
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int getinven(int bookID,int bookNumber){
		int inventory=0;
		try {
			Statement stmt=con.createStatement();
			String sql3="SELECT * FROM INVENTORY WHERE BOOKID="+bookID+"";
			ResultSet rs=stmt.executeQuery(sql3);
			while(rs.next()){
				inventory=rs.getInt("inventory")-bookNumber;
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return inventory;
		}
	}
	public static int getnid(int bookID){
		int nid=0;
		try {
			Statement stmt=con.createStatement();
			String sql3="SELECT id FROM INVENTORY WHERE BOOKID="+bookID+"";
			ResultSet rs=stmt.executeQuery(sql3);
			while(rs.next()){
				nid=rs.getInt("id");
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return nid;
		}
	}
	public static void updateinventory(int bookID,int inventory){
		try {
			Statement stmt=con.createStatement();
				String sql3="UPDATE inventory SET inventory="+inventory+" WHERE BOOKID="+bookID+"";
				stmt.executeUpdate(sql3);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static double total(int userID) {
		try {
			Statement stmt=con.createStatement();
			String sql="SELECT SUBTOTAL FROM USERCART WHERE USERID="+userID+"";
			double total = 0;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				double Subtotal=rs.getDouble("Subtotal");
				total=total+Subtotal;
			}
			stmt.close();
			return total;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
