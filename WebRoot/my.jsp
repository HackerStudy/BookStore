<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/my.css"/>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<title>个人信息	</title>
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
		<%
			user uinfo=(user)session.getAttribute("uinfo");
			
		%>
		    <table width="100%" border="0" cellspacing="0" style="font-family: '微软雅黑';">
		   <tr>
      <td width="25%"><table width="100%" border="0" cellspacing="0" style="margin-top:-160px">
        <tr>
          <td class="listtitle">我的帐户</td>
        </tr>
        <tr>
          <td class="listtd"><img src="img/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="changeinfo.jsp">用户信息修改</a></td>
        </tr>
		
<tr>
          <td class="listtd"><img src="img/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="myorder.jsp">我的订单</a></td>
        </tr>
      </table></td>
		      <td>
		        <table cellspacing="0" class="infocontent">
		        <tr>
		          <td width="700px" height="400px">
		          	<div id="userinfo">
		          		<p>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;<%=uinfo.getUsername()%></p>
		          		<p>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=uinfo.getSex()%></p>
		          		<p>电话号码:&nbsp;&nbsp;&nbsp;&nbsp;<%=uinfo.getPhone()%></p>
		          		<p>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：&nbsp;&nbsp;&nbsp;&nbsp;<%=uinfo.getEmail()%></p>
		          	</div>
	            </td>
	        </tr>
	      </table>
	  </td>
    </tr>	
</table>
			</div>
		</div>
	</body>
</html>
