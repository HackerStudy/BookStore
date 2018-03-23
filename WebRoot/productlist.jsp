<%@page import="com.dao.bookdao"%>
<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/prodcutlist.css"/>
		<!--<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />-->		
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<style>
		.wrapper{
			text-align:center;
			float:left;
			margin:0 25px 10px 22px;
		}
		
		</style>
		<title>全部商品目录</title>
	</head>
	<body>
		<div id="container">
			<div id="divhead">
					  <table cellspacing="0" class="headtable">
	  					  <tr>
	      						<td style="padding-left: 400px;padding-top: 28px;"><a href="indexServlet"><img src="img/1.JPG" width="94" height="81"/></a></td>
	      						<div id="tou"><span style="padding-left: 750px;"><%try{
	      			int userID=Integer.parseInt(session.getAttribute("userID").toString());
	      			String username=(String)session.getAttribute("username");
	      			%><a href="#"><%=username%>，</a><a href="/BookStore/logoutServlet"><span>注销</span></a>
	      		<%}catch (Exception e) {%>
	      			<a href="/BookStore/login.jsp" style="color: red;">你好，请登录</a>　
	      		<%}%>|　<a href="/BookStore/register.jsp">注册</a>　|　<a href="#">帮助中心</a>　|　<a href="/BookStore/UserinfoServlet">我的帐户</a>　|　<a href="/BookStore/cartservlet">购物车</a></span></div>
	    				  </tr>
	 				  </table>
			</div>
			<form action="SearchServlet" method="post">
			<div id="search">
					<div class="input-group" style="width: 300px; margin-left: 350px;">
			     	 <input name="keyword" type="text" class="form-control" placeholder="关键字搜索">
			      	<span class="input-group-btn">
			        <button class="btn btn-default" type="submit">Go!</button>
     				 </span>
     				 </div>
			</div>
			</form>
			<div id="center">
				<div id="c_left">
					<table width="100%" border="0" >
			        	<tr>
			          		<td class="listtitle" style="background: red; color: white;"><h3 style="margin-left: 10px;padding-bottom: 5px;font-size: 18px;">图书分类</h3></td>
			       	    </tr>
			            <tr>
			         	   <td class="listtd">&nbsp;&nbsp;&nbsp;&nbsp;
			          	   <a href="productlistServlet?bookTypeID1=1&bookTypeID2=2">哲学/宗教</a></td>
			        	</tr>
					
						<tr>
			         	   <td class="listtd">&nbsp;&nbsp;&nbsp;&nbsp;
			               <a href="productlistServlet?bookTypeID1=3&bookTypeID2=4">政治/法律</a></td>
			        	</tr>
					    <tr>
			          		<td class="listtd">&nbsp;&nbsp;&nbsp;&nbsp;
			                <a href="productlistServlet?bookTypeID1=5">军事</a> </td>
			       	    </tr>
						<tr>
			          		<td class="listtd">&nbsp;&nbsp;&nbsp;&nbsp;
			            	<a href="productlistServlet?bookTypeID1=6">经济</a></td>
			       	    </tr>
						<tr>
			         		<td class="listtd">&nbsp;&nbsp;&nbsp;&nbsp;
			            	<a href="productlistServlet?bookTypeID1=7&bookTypeID2=8&bookTypeID3=9">文化/科技/教育</a></td>
			        	</tr>
					    <tr>
			          	    <td class="listtd">&nbsp;&nbsp;&nbsp;&nbsp;
			            	<a href="productlistServlet?bookTypeID1=10">计算机</a> </td>
			       		</tr>
						<tr>
			         	    <td class="listtd">&nbsp;&nbsp;&nbsp;&nbsp;
			           	 	<a href="productlistServlet?bookTypeID1=11&bookTypeID2=12">历史 /地理</a> </td>
			        	</tr>
						<tr>
			          		<td class="listtd">&nbsp;&nbsp;&nbsp;&nbsp;
			            	<a href="productlistServlet?bookTypeID1=13">小说</a></td>
			        	</tr> 
			      </table></td>
				</div>
				<div id="c_right">
					<ul class="nav nav-tabs" style="padding-left: 20px;margin-top: -60px;">
				        <li role="presentation" ><a href="indexServlet">首页</a></li>
				        <li role="presentation" class="active"><a href="productlistServlet?bookTypeID1=0">全部商品目录</a></li>
				        <li role="presentation"><a href="rank.jsp">排行榜</a></li>
				        <li role="presentation"><a href="#">店家推荐</a></li>
				    </ul>
				    <div class="kongjan" style="background-color: black;width:688px;height: 3px"></div>
				<table cellspacing="0" class="listcontent" style="width:680px">
				<%
					List<book> booklist=(List<book>)session.getAttribute("booklist");
					String typeName=(String)session.getAttribute("typeName");
					String typeName2=(String)session.getAttribute("typeName2");
					String typeName3=(String)session.getAttribute("typeName3");
					List<typeSon> Sonlist=(List<typeSon>)session.getAttribute("Sonlist");
					int count=Integer.parseInt( session.getAttribute("count").toString());
					int typeName1flag=0;
					int typeName2flag=0;
					int typeName3flag=0;
					int bookTypeID1=-1;
					int bookTypeID2=-1;
					int bookTypeID3=-1;
					int ID2;
					int ID3;
					bookTypeID1=bookdao.querybookTypeID(typeName);
					if(typeName2==null){
						typeName2="";
					}else{
						bookTypeID2=bookdao.querybookTypeID(typeName2);;
						typeName2="/"+typeName2;
						typeName2flag=1;
					}
					if(typeName3==null){
						typeName3="";
					}else{
						bookTypeID3=bookdao.querybookTypeID(typeName3);
						typeName3="/"+typeName3;
						typeName3flag=1;
					}
				%>
							<tr>
								<td>
									<p style="font-size: 19px;font-family: '微软雅黑';margin-top: 0;">商品目录</p>
									<p style="font-size: 16px; font-family: '微软雅黑';position: relative;top: 7px;"><%=typeName%><%=typeName2%><%=typeName3%>类&nbsp;&nbsp;&nbsp;&nbsp;共<%=count%>种商品</p><hr/>
									 <%if(Sonlist!=null){%>
									<img src="images/miniicon2.gif" />
									&nbsp;&nbsp;&nbsp;&nbsp;<%=typeName%><%=typeName2%><%=typeName3%>类的子分类
									<% 
							          int i=1;
							          for(typeSon sonlist:Sonlist){%>
									|&nbsp;&nbsp;&nbsp;&nbsp;<a href="productlistServlet?bookTypeSonID=<%=sonlist.getBookTypeSonID()%>&bookTypeID1=<%=bookTypeID1%>&bookTypeID2=<%=bookTypeID2%>&bookTypeID3=<%=bookTypeID3%>"><%=sonlist.getTypeSonName()%></a>&nbsp;&nbsp;&nbsp;&nbsp;
							          	<%if(typeName3flag==1){if(i%4==0){%></br><%}}%>
							          <%
							          ++i;}
							          }
							          %>

									<div style="margin-top: 20px; margin-bottom: 5px">
										<img src="images/productlist.gif" width="631" height="38" />
									</div>
									<%
									for(book list:booklist){ 
									  %>
										
											<div class="wrapper">
												<div class="divbookpic">
													<p>
														<a href="info.jsp?bookID=<%=list.getBookid()%>">
														<img src="img/book/<%=list.getImage()%>" width="110"
																height="145" border="0" />
														</a>													</p>
												</div>
												<div class="divlisttitle">
													<a href="info.jsp?bookID=<%=list.getBookid()%>"><%=list.getBookName()%> <br /> 售价： &yen<%=list.getPrice()%> </a>
												</div>
											</div>
								   
								<%
								}%>
									<% int pages =(Integer)session.getAttribute("BOOK_PAGES"); 
									   int currentPage = (Integer)session.getAttribute("BOOK_CURRENT_NUM");
									%>
									<div class="pagination">
										<ul>
										   <% if(currentPage  == 1){ %>
											<li class="disablepage">
												 上一页
											</li>
										   <%}else{%>
										     <li class="disablepage">
												<a href="/BookStore/productlistServlet?page=<%=currentPage-1%>&bookTypeID1=<%=bookTypeID1%>&bookTypeID2=<%=bookTypeID2%>&bookTypeID3=<%=bookTypeID3%>">上一页</a>
											</li>
										   <%}%>	
											<% for(int index = 1; index <=pages; index++){
											    if(index == currentPage){
											  %>
												<li class="currentpage">
													<a href="/BookStore/productlistServlet?page=<%=index%>&bookTypeID1=<%=bookTypeID1%>&bookTypeID2=<%=bookTypeID2%>&bookTypeID3=<%=bookTypeID3%>"><%=index%></a>
												</li>
											<% }else{%>
											   <li><a href="/BookStore/productlistServlet?page=<%=index%>&bookTypeID1=<%=bookTypeID1%>&bookTypeID2=<%=bookTypeID2%>&bookTypeID3=<%=bookTypeID3%>"><%=index%></a></li> 
											<%}
											}%>
											
											<% if(currentPage  == pages){ %>
											<li class="disablepage">
												 下一页
											</li>
										   <%}else{%>
										     <li class="nextPage">
												<a href="/BookStore/productlistServlet?page=<%=currentPage+1%>&bookTypeID1=<%=bookTypeID1%>&bookTypeID2=<%=bookTypeID2%>&bookTypeID3=<%=bookTypeID3%>">下一页</a>
											</li>
										   <%}%>	
											 
										</ul>
									</div>
									 <%
			    session.removeAttribute("Sonlist");
			    session.removeAttribute("typeName");
				session.removeAttribute("typeName2");
				session.removeAttribute("typeName3"); 
			    %>
			</table>
			</div>
	<div id="foot">
			<div class="link">
				<a rel="nofollow" href="//www.jd.com/intro/about.aspx">关于我们</a>
				 | 
				<a rel="nofollow" href="//www.jd.com/contact/">联系我们</a>
				 | 
				<a rel="nofollow" href="//zhaopin.jd.com/">人才招聘</a>
				 | 
				<a rel="nofollow" href="//zhaopin.jd.com/">商家入驻</a>
				 | 
				<a rel="nofollow" href="//www.jd.com/intro/service.aspx">广告服务</a>
				 | 
				<a rel="nofollow" href="//app.jd.com/">手机书城</a>
				 |
				<a rel="nofollow" href="//club.jd.com/links.aspx">友情链接</a>
				 | 
				<a rel="nofollow" href="//media.jd.com/">销售联盟</a>
				 | 
				<a rel="nofollow" href="//club.jd.com/">书店社区</a>
				 | 
				<a rel="nofollow" href="//gongyi.jd.com">书店公益</a>
				 | 
				<a rel="nofollow" href="//en.jd.com/">English Site</a>
				 | 
			</div>
			<div class="copyright">
				Copyright © 2004-2017  书店BS.com 版权所有	
			</div>
	</div>
		
	
		</div>
	</body>
</html>
