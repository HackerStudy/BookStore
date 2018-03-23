package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userdao;
import com.util.DBUtil;

public class registerServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request. setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		try {
			String username=request.getParameter("username");
			String sex=request.getParameter("sex");
			String password=request.getParameter("password");
			String confirmpassword=request.getParameter("confirmpassword");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			int emailformat = email.indexOf("@qq.com");
			boolean emailflage=userdao.checkemail(email);
			if(!(username.equals("")||sex==null||password.equals("")||confirmpassword.equals("")
					||phone.equals("")||email.equals(""))){
				if(!emailflage){
					if(emailformat!=-1){
						if(password.equals(confirmpassword)){
							userdao.intouser(username,sex,password, phone, email);
							response.sendRedirect(request.getContextPath()+"/login.jsp");
						}else{
							String pwderror="你输入的密码和重复密码不一样";
							session.setAttribute("pwderror",pwderror);
							response.sendRedirect(request.getContextPath()+"/register.jsp");
						}
					}else{	
						String emailerror="你输入的邮箱格式不对";
						session.setAttribute("emailerror",emailerror);
						response.sendRedirect(request.getContextPath()+"/register.jsp");
					}
				}else{
					String emailerror="该邮箱已被注册";
					session.setAttribute("emailerror",emailerror);
					response.sendRedirect(request.getContextPath()+"/register.jsp");
				}
			}else{
				response.sendRedirect(request.getContextPath()+"/registererror.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("系统正在维护中...请等待");
		}
	}
}
