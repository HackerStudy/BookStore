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
import com.entity.Usercart;
import com.entity.inventory;

public class DeleteCServlet extends HttpServlet {

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
		int bookNumber = 0;
		inventory v;
		try {
			v = bookdao.qInventory(bookid);
			List<Usercart> cart=Cartdao.qUsercart(userID);
			for(Usercart list:cart){
				if(bookid==list.getBookID()){
					bookNumber=list.getBookNumber();
				}
			}
			Cartdao.delectcart(userID, bookid);
			Cartdao.updateinventory(bookid,v.getInventory()+bookNumber);
			resp.sendRedirect(req.getContextPath()+"/cartservlet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
