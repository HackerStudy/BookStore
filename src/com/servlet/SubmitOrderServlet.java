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
import com.dao.orderdao;
import com.entity.Usercart;
import com.entity.inventory;

public class SubmitOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		int userID=Integer.parseInt(session.getAttribute("userID").toString());
		String No=orderdao.generateNo();
		String date=orderdao.generatedate();
		List<Usercart> list =(List<Usercart>)session.getAttribute("cartlist");
		double totalprice=Double.parseDouble(session.getAttribute("total").toString());
		int saleNumber;
		int finNumber;
		try {
			orderdao.intoorder(No, date, totalprice, userID);
			for(Usercart cartlist:list){
				orderdao.intoorderinfo(cartlist.getBookID(),cartlist.getBookName(),cartlist.getPrice(),cartlist.getBookNumber(), cartlist.getSubtotal(),No);
				saleNumber=bookdao.getsalesNumber(cartlist.getBookID());
				finNumber=bookdao.addsalesNumber(cartlist.getBookNumber(),saleNumber);
				bookdao.updatesalesNumber(cartlist.getBookID(), finNumber);
			}
			Cartdao.clearcart(userID);
			resp.sendRedirect(req.getContextPath()+"/myorder.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
