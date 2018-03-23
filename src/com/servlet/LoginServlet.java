package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userdao;
import com.entity.user;
import com.util.DBUtil;

public class LoginServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req. setCharacterEncoding("UTF-8");
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		HttpSession session=req.getSession();
		boolean userflag;
		if(email.equals("")||pwd.equals("")){
			session.removeAttribute("ERROR_login");
			session.setAttribute("none","邮箱或密码为空");
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}else{
			try {
				userflag=userdao.validateuser(email, pwd);
				if(userflag){
					int userID=userdao.selectuserID(email);
					session=req.getSession();
					session.setAttribute("userID",userID);
					user info=userdao.selectuserinfo(userID);
					String username=info.getUsername();
					session.setAttribute("username", username);
					resp.sendRedirect(req.getContextPath()+"/indexServlet");
				}else{ 
					String error="你的邮箱或密码输入错误";
					session=req.getSession();
					session.setAttribute("ERROR_login",error);
					resp.sendRedirect(req.getContextPath()+"/login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("系统正在维护中...请等待");
			}
		}		
	}
	
}
