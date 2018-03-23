<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/info.css"/>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<title>商品详情</title>
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
					<table width="100%" border="0" cellspacing="0">
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
					<div class="kongjan" style="background-color: black;width:100%;height: 3px;margin-top:-70px;"></div>
					<form action="AddCartServlet" method="post">
					<% 
							book b=null;
							int bookID=Integer.parseInt(request.getParameter("bookID"));
							b=bookdao.queryb(bookID);
					%>
					<div style="width:800px;height:500px;float: left;font-family: '微软雅黑'">
					<div style="float: left;width: 100px;height: 100px;margin-right: 130px;margin-left: 50px;margin-top: 50px;"><img  style="width:160px;height:188px;" src="img/book/<%=b.getImage()%>"></div>
						<table style="margin-left: 20px;background: rgb(252,252,252);">
							<tr>
								<td><br></td>
							</tr>
							<tr height="60px;">
								<td><p style="font-size: 19px;"><%=b.getBookName()%></p></td>
							</tr>
							<tr>
								<td>作者:<%=b.getAuthor()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出版社：<%=b.getPress()%>
								</br></br>上架时间:<%
                 Shelftime shelftime=bookdao.qshelf(bookID);
                 String time=shelftime.getYear()+"-"+shelftime.getMonth()+"-"+shelftime.getDay();
                 %><%=time%>
								</td>
							</tr>
							<tr height="10px;">
								<td><br></td>
							</tr>
							<tr height="60px">
								<td>市场价:&nbsp;&nbsp;&nbsp;&nbsp;<del>&yen;<%=b.getCostPrice()%></del>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;优惠价:<p style="font-size: 22px;color: red;margin-top: -26px;margin-left: 190px;">&yen<%=b.getPrice()%></p>
								<% 
								inventory v=bookdao.qInventory(b.getBookid());
								%>
								<p class="kucun">库存<%=v.getInventory()%>本</p>
								</td>
							</tr>
							<tr>
								<td><p>内容简介：</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=b.getContent()%></p></td>
							</tr>
						</table>
						<div style="position: absolute; top:420px;left:420px;">
						<button name="addcart" value="<%=bookID%>" type="submit" class="btn btn-danger"style="font-size: 20px;">加入购物车</button>
						</div>
					</div>
					</form>
				</div>
				<div id="remark">
						<p style="margin:20px 30px 20px 40px; font-size: 18px;">用户评论</p>
						<table border="0" style="width:700px;height: auto; margin-left: 50px;border:1px solid gainsboro;">
						<%
							List<comment> clist=userdao.qcomments(bookID);
							for(comment list:clist){
								String username=userdao.qusername(list.getUserID());
						%>
							<tr height="60px">
								<td width="20%" class="user"><%=username%>:</td>
								<td width="80%" style="position: relative;top:5px;"><p class="p"><%=list.getComment()%></p></td>
							</tr>
							<%}%>
						</table>
						<form action="infoServlet?bookID=<%=bookID%>" method="post">
						<textarea name="comment" class="form-control" rows="3" placeholder="用户评论" style="width: 700px;height:37px;margin-left: 50px;margin-top: 20px;"></textarea>
						<button type="submit" class="btn btn-default" style="margin-left: 330px;margin-top: 20px;">提交评论</button>
						</form>
					</div>
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

