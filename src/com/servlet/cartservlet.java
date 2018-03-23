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
import com.entity.Usercart;
import com.entity.book;
import com.entity.inventory;
import com.util.DBUtil;

public class cartservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		try {
			int userID=(Integer)session.getAttribute("userID");
			try {
					Connection con = DBUtil.getConnection();
					Statement stmt=con.createStatement();
					String sql="SELECT BOOKID,BOOKNAME,PRICE,COSTPRICE,BOOKNUMBER,SUBTOTAL FROM USERCART WHERE userID="+userID+"";
					ResultSet rs=stmt.executeQuery(sql);
					List<Usercart> cartlist=new ArrayList<Usercart>(); 
					while(rs.next()){
						int bookid=rs.getInt("bookid");
						String bookname=rs.getString("bookName");
						double price=rs.getDouble("price");
						double costPrice=rs.getDouble("costPrice");
						int num=rs.getInt("bookNumber");
						double Subtotal=rs.getDouble("Subtotal");
						Usercart cart=new Usercart(bookid,bookname,price,costPrice,num,Subtotal);
						cartlist.add(cart);
					}
					double total=Cartdao.total(userID);
					session.setAttribute("cartlist",cartlist);
					session.setAttribute("total", total);
					resp.sendRedirect(req.getContextPath()+"/shoppingcart.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
		
	}
	
}
