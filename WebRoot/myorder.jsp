<%@ page language="java" import="java.util.*,com.dao.*,com.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/myorder.css"/>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<title>我的订单</title>
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
	      		<%}%>　|　<a href="/BookStore/register.jsp">注册</a>　|　<a href="#">帮助中心</a>　|　<a href="/BookStore/UserinfoServlet">我的帐户</a>　|　<a href="/BookStore/cartservlet">购物车</a></span></div>
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
				<p style="font-family: '微软雅黑'; font-size: 25px;line-height: 25px;margin-left: 25px;">我的订单</p>
				<div class="kongjan" style="background-color: black;width:100%;height: 3px"></div>		
				<table class="table">
					<tr style="text-align: center;">
						<td width="50%">商品信息</td>
						<td width="10%">单价</td>
						<td width="10%">数量</td>
						<td width="20%">实付款</td>
						<td width="10%">操作</td>
					</tr>
					<%	
						 	int userID=Integer.parseInt(session.getAttribute("userID").toString());
						 	List<order> orderlist=orderdao.selectorder(userID);
						 	for(order olist:orderlist){ 
						 %>
						 <table style=" background:rgb(241,241,241); margin-top: 30px;">
		                    <tr height="40px">
		                    	<td width="150px"  style="padding-left: 62px;"><%=olist.getDate()%></td>
		                    	<td width="450px" style="padding-left:25px;">订单号:<%=olist.getNo()%></td>
		                    	<td width="300px" style="text-align: right;position: relative;right:-38px; "><p>总计：<span style="font-size: 19px;color: red;">&yen;<%=olist.getTotalprice()%></span></p></td>
		                    	<td width="200px" style="padding-left: 135px;"><a href="DeleteOrderServlet?No=<%=olist.getNo()%>"><span class="glyphicon glyphicon-trash"></span></a></td>
		  
		                    </tr>
		                  </table>
		                  <%
		                  	List<orderinfo> orderinfolist=orderdao.selectorderinfo(olist.getNo());
		                  	for(orderinfo infolist:orderinfolist){ 
		                  	book b=bookdao.queryb(infolist.getBookID());
		                  %>	    
							<table class="table-hover" border="0" style="border:2px solid gainsboro;">
			                    <tr height="100px">
			                      <td width="530px">
			                      		<div class="infoBox">
			                      			<div class="infoImg"><a href="info.jsp?bookID=<%=b.getBookid()%>"><img src="img/book/<%=b.getImage()%>" width="78px" height="90px"></a></div>
			                      			<div class="infoHref"><p><a href="info.jsp?bookID=<%=b.getBookid()%>"><%=infolist.getBookName()%></a></p></div>
			                      			<div class="infoSize"><p>作者：<%=b.getAuthor()%></p><p>出版社:<%=b.getPress()%></p></div>
			                      		</div>
			                      </td>
			                      <td width="120px"><p style="color: darkgray;"><del>&yen;<%=b.getCostPrice()%></del></p><span>&yen;<%=infolist.getPrice()%></span></td>
			                      <td width="130px"><%=infolist.getBookNumber()%></td>
			                      <td width="220px">&yen;<%=infolist.getSubtotal()%></td>
			                    </tr>
		                  </table>
		                  <%
		                  }
		                  }%>
		                  <!--
		                  	此处table是一个订单截止，一个订单里有几本书，就循环该订单的tr
                          -->
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
