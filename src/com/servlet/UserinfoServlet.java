package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userdao;
import com.entity.user;

public class UserinfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		try{
			int userID=(Integer)session.getAttribute("userID");
			try {
				user uinfo=userdao.selectuserinfo(userID);
				session.setAttribute("uinfo",uinfo);
				resp.sendRedirect(req.getContextPath()+"/my.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("系统正在维护中");
			}
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
	}
	
}
