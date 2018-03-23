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
import com.entity.typeSon;

import com.dao.*;

public class productlistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<book> booklist = null;
		List<typeSon> Sonlist=null;
		HttpSession session=req.getSession();
		String bookTypeID1=req.getParameter("bookTypeID1");
		String bookTypeID2=req.getParameter("bookTypeID2");
		String bookTypeID3=req.getParameter("bookTypeID3");
		String bookTypeSonID=req.getParameter("bookTypeSonID");
		//1.获取当前页码
		String pageStr = req.getParameter("page");
		int page;
		if(pageStr != null){
			page = Integer.parseInt(pageStr);
		}else{
			page = 1;
		}
		int pageNum = 12;
		int start = (page-1)*pageNum;
		int end  = page*pageNum-1;
		String typeName=null;
		String typeName2=null;
		String typeName3=null;
			int bookType=Integer.parseInt(bookTypeID1.toString());
			if(bookType==0){
				try {
					typeName="全部商品";
					booklist = bookdao.queryAllbook(start,end);
					int bookpages=bookdao.bookspage();
					int count=bookdao.count();
					session.setAttribute("count",count);
					session.setAttribute("BOOK_PAGES",bookpages);
					session.setAttribute("typeName",typeName);
					session.setAttribute("BOOK_CURRENT_NUM",page);
					session.setAttribute("booklist",booklist);
					resp.sendRedirect("productlist.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					int bookpages = 0;
					if(bookTypeID2==null&&bookTypeID3==null){
						if(bookTypeSonID==null){
							bookpages=bookdao.bookspage(bookType);
							booklist = bookdao.querytypebook(start, end, bookType);
						}else{
							int SonType=Integer.parseInt(bookTypeSonID.toString());
							bookpages=bookdao.booksSonpage(SonType);
							booklist = bookdao.querytypesonbook(start, end, SonType);
						}
						Sonlist=bookdao.qtypeSon(bookType);
						session.setAttribute("Sonlist",Sonlist);
						int count=bookdao.countType(bookType);
						session.setAttribute("count",count);
						typeName=bookdao.querytypeName(bookType);
						session.setAttribute("typeName",typeName);
					}else if(bookTypeID2!=null&&bookTypeID3==null){
						int typeID2=Integer.parseInt(bookTypeID2);
						if(bookTypeSonID==null){
							bookpages=bookdao.bookspage(bookType,typeID2);
							booklist = bookdao.querytypebook(start, end, bookType,typeID2);
						}else{
							int SonType=Integer.parseInt(bookTypeSonID);
							bookpages=bookdao.booksSonpage(SonType);
							booklist = bookdao.querytypesonbook(start, end, SonType);
						}
						Sonlist=bookdao.qtypeSon(bookType,typeID2);
						session.setAttribute("Sonlist",Sonlist);
						int count=bookdao.countType(bookType,typeID2);
						session.setAttribute("count",count);
						typeName=bookdao.querytypeName(bookType);
						typeName2=bookdao.querytypeName(typeID2);
						session.setAttribute("typeName",typeName);
						session.setAttribute("typeName2",typeName2);
					}else if(bookTypeID2!=null&&bookTypeID3!=null){
						int typeID2=Integer.parseInt(bookTypeID2);
						int typeID3=Integer.parseInt(bookTypeID3);
						if(bookTypeSonID==null){
							bookpages=bookdao.bookspage(bookType,typeID2,typeID3);
							booklist = bookdao.querytypebook(start, end, bookType,typeID2,typeID3);
						}else{
							int SonType=Integer.parseInt(bookTypeSonID);
							bookpages=bookdao.booksSonpage(SonType);
							booklist = bookdao.querytypesonbook(start, end, SonType);
						}
						Sonlist=bookdao.qtypeSon(bookType,typeID2,typeID3);
						session.setAttribute("Sonlist",Sonlist);
						int count=bookdao.countType(bookType,typeID2,typeID3);
						session.setAttribute("count",count);
						typeName=bookdao.querytypeName(bookType);
						typeName2=bookdao.querytypeName(typeID2);
						typeName3=bookdao.querytypeName(typeID3);
						session.setAttribute("typeName",typeName);
						session.setAttribute("typeName2",typeName2);
						session.setAttribute("typeName3",typeName3);
					}
					session.setAttribute("BOOK_PAGES",bookpages);
					session.setAttribute("BOOK_CURRENT_NUM",page);
					session.setAttribute("booklist",booklist);
					resp.sendRedirect("productlist.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	
}
