package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.bookdao;
import com.entity.book;

public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<book> searchbooklist = null;
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req. setCharacterEncoding("UTF-8");
		HttpSession session=req.getSession();
		String keyword=req.getParameter("keyword");
		try {
			try{
				int typeID=Integer.parseInt(req.getParameter("typeID"));
				int priceflag=Integer.parseInt(req.getParameter("price"));
				searchbooklist=bookdao.searchbook(keyword,typeID,priceflag);
			}catch (Exception e) {
				searchbooklist=bookdao.searchbook(keyword);
			}
			finally{
				session.setAttribute("searchbooklist",searchbooklist);
				session.setAttribute("keyword",keyword);
				resp.sendRedirect(req.getContextPath()+"/search.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
