package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.userdao;

public class infoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req. setCharacterEncoding("UTF-8");
		int bookID=Integer.parseInt(req.getParameter("bookID"));
		try{
			int userID=Integer.parseInt(req.getSession().getAttribute("userID").toString());
			String comment=req.getParameter("comment");
			userdao.intocomment(comment, bookID, userID);
			resp.sendRedirect(req.getContextPath()+"/info.jsp?bookID="+bookID+"");
		}catch (Exception e) {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
	}
	
}
