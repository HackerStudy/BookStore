<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/order.css"/>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<title>确认订单</title>
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
				<p style="font-family: '微软雅黑'; font-size: 25px;line-height: 25px;margin-left: 25px;">确认订单</p>
				<div class="kongjan" style="background-color: black;width:100%;height: 3px"></div>		
				<table class="table table-hover">
					<tr style="text-align: center;">
						<td width="10%">序号</td>
						<td width="40%">商品名称</td>
						<td width="10%">市场价</td>
						<td width="10%">优惠价</td>
						<td width="10%">数量</td>
						<td width="20%">小计</td>
					</tr>
					<!--
						循环tr
                    -->
                    <%List<Usercart> list =(List)session.getAttribute("cartlist");
                	int i=1;
	    				for(Usercart cart:list){
	    				int bookID=cart.getBookID();
	    				book b=bookdao.queryb(bookID);
	    				%>
					<tr style="text-align: center;">
						<td width="10%">00<%=i++%></td>
						<td width="40%"><%=cart.getBookName()%></td>
						<td width="10%">&yen<%=cart.getCostPrice()%></td>
						<td width="10%">&yen<%=cart.getPrice()%></td>
						<td width="15%"><%=cart.getBookNumber()%></td>
						<td width="15%">&yen<%=cart.getSubtotal()%></td>
					</tr>
					<%}%>					
				</table>
				<div style="margin-top: 50px;">
					<p style="font-size:19px;color: red;text-align: center;margin-left: 770px;">总计：&yen;<%=session.getAttribute("total")%></p>
					<button type="button" class="btn btn-default"style="font-size: 20px;margin-left: 770px;" onclick="javascript :window.history.go(-1);";>返&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回</button>
					<button type="button" class="btn btn-danger"style="font-size: 20px;margin-left: 20px;" onclick="javascript :window.location.href='/BookStore/submitorder.jsp';">提交订单</button>
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
