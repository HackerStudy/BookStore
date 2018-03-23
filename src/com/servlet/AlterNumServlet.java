package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Cartdao;
import com.dao.bookdao;
import com.entity.inventory;

public class AlterNumServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		int userID=(Integer)session.getAttribute("userID");
		int bookid=Integer.parseInt(req.getParameter("bookid"));
		double price=Double.parseDouble(req.getParameter("price"));
		int flag=Integer.parseInt(req.getParameter("flag"));
		int bookNumber=Integer.parseInt(req.getParameter("bookNumber"));
		inventory v;
		try {
			v = bookdao.qInventory(bookid);
			if(flag==1){
				if(v.getInventory()>=1){
					Cartdao.updateinventory(bookid,v.getInventory()-1);
					Cartdao.alternum(userID, bookid, price, flag,bookNumber);
					resp.sendRedirect(req.getContextPath()+"/cartservlet");
				}else{
					resp.sendRedirect(req.getContextPath()+"/cinvenerror.jsp");
				}
			}else{
				if(bookNumber>1){
					Cartdao.updateinventory(bookid,v.getInventory()+1);
					Cartdao.alternum(userID, bookid, price, flag,bookNumber);
				}
				resp.sendRedirect(req.getContextPath()+"/cartservlet");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
