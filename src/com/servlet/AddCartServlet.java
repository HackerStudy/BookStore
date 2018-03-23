package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Cartdao;
import com.dao.bookdao;
import com.entity.Usercart;
import com.entity.inventory;
import com.util.DBUtil;

public class AddCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		List<Usercart> cartlist=(List<Usercart>)req.getSession().getAttribute("cartlist");
		int bookid= Integer.parseInt(req.getParameter("addcart"));
		try{
			int userID=(Integer)session.getAttribute("userID");
				try {
					inventory v=bookdao.qInventory(bookid);
					if(v.getInventory()>=1){
						Connection con =DBUtil.getConnection();
						Statement stmt=con.createStatement();
						Statement stmt2=con.createStatement();
						Statement stmt3=con.createStatement();
						String cartsql="SELECT * FROM USERCART WHERE USERID="+userID+" and bookid="+bookid+"";
						ResultSet cartrs=stmt2.executeQuery(cartsql);
						boolean c= cartrs.next();
						cartrs.close();
						String booksql="SELECT BOOKNAME,PRICE,COSTPRICE FROM BOOK WHERE ID="+bookid+"";
						String insertsql;
						ResultSet bookrs=stmt.executeQuery(booksql);
						while(bookrs.next()){
							String bookname=bookrs.getString("bookName");
							double price=bookrs.getDouble("price");
							double costPrice=bookrs.getDouble("costPrice");
							if(c){
								String updatesql="UPDATE USERCART SET BOOKNUMBER=BOOKNUMBER+1,Subtotal=Subtotal+"+price+" WHERE BOOKID="+bookid+"";
								stmt2.execute(updatesql);
								stmt2.close();
							}else{
								insertsql="INSERT INTO USERCART (USERID,BOOKID,BOOKNAME,PRICE,COSTPRICE,BOOKNUMBER,SUBTOTAL) VALUES ("+userID+","+bookid+",'"+bookname+"',"+price+","+costPrice+",1,"+price+")";
								stmt3.execute(insertsql);
							}
						}
						Cartdao.updateinventory(bookid,v.getInventory()-1);
						bookrs.close();
						stmt3.close();
						stmt.close();
						resp.sendRedirect(req.getContextPath()+"/cartservlet");
					}else{
						resp.sendRedirect(req.getContextPath()+"/inventoryerror.jsp");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
	}
	
}
