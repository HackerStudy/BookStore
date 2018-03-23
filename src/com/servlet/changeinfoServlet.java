package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userdao;
import com.entity.user;

public class changeinfoServlet extends HttpServlet {

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
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		int userID = (Integer) session.getAttribute("userID");
		user uinfo=(user)session.getAttribute("uinfo");
		String originalpassword = req.getParameter("originalpassword");
		String newpassword = req.getParameter("newpassword");
		String sex = req.getParameter("sex");
		String phone = req.getParameter("phone");
		try {
			if(!(originalpassword.equals("")||newpassword.equals("")
					||sex.equals("")||phone.equals(""))){
				if(uinfo.getPassword().equals(originalpassword)){
					userdao.modifyuserinfo(userID,newpassword, sex,
							phone);
					resp.sendRedirect(req.getContextPath()
							+ "/UserinfoServlet");
				}else{
					String OriginalPwdError="原密码错误，请重新输入";
					session.setAttribute("OriginalPwdError",OriginalPwdError);
					resp.sendRedirect(req.getContextPath()
							+ "/changeinfo.jsp");
				}
			}else{
				resp.sendRedirect(req.getContextPath()+"/modifyuserinfoerror.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
