package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
import com.entity.book;
import com.entity.inventory;

public class indexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		String path=req.getServletPath();
//		String a[]=path.split("\\.");
//		if(a[0].equals("/index")){
//			doPost(req,resp);
//		}
//	}
//	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TypeID=req.getParameter("bookTypeID");
		if(TypeID!=null){
			try {
				int bookTypeID=Integer.parseInt(TypeID);
				List<book> typebooklist=bookdao.qshelftime(0,3,bookTypeID);
				HttpSession session=req.getSession();
				session.setAttribute("typebooklist",typebooklist);
				resp.sendRedirect("index.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			int bookTypeID=1;
			try {
				List<book> typebooklist=bookdao.qshelftime(0,3,bookTypeID);
				HttpSession session=req.getSession();
				session.setAttribute("typebooklist",typebooklist);
				resp.sendRedirect("index.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
