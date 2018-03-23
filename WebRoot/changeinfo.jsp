<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/changeyinfo.css"/>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<title>修改个人信息</title>
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
			     	 <input type="text" class="form-control" placeholder="关键字搜索">
			      	<span class="input-group-btn">
			        <button class="btn btn-default" type="button">Go!</button>
     				 </span>
     				 </div>
			</div>
			</form>
			<div id="center">
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
		      <%
		      	 user uinfo=(user)session.getAttribute("uinfo");
		      	 String OriginalPwdError=(String)session.getAttribute("OriginalPwdError");
		      	 if(OriginalPwdError==null){
					OriginalPwdError="";
					}
		      %>
		      <form action="changeinfoServlet" method="post">
	      <table>
		        <tr>
		          <td width="700px" height="400px">
		          	<div id="userinfo" style="padding-top: 50px;">
		          	<table width="100%"style="font-size: 15px;">
					  <tr height="40px">
					    <td style="width:20%;position: relative;left:180px;">用户邮箱：</td>
					    <td style="width:40%; position: relative;left:100px;padding-left:20px"><%=uinfo.getEmail()%></td>
					  </tr>
					  <tr height="40px">
					    <td style="position: relative;left:180px;">用户名：</td>
					    <td style="position: relative;left:104px; padding-left:20px"><%=uinfo.getUsername()%></td>
					  </tr > 
					  <tr height="40px">
					    <td style="position: relative;left:180px;">原密码：</td>
					    <td><input name="originalpassword" type="password" class="textinput" style="position: relative;left:125px;"/></td>
					    <td  style="position: relative;left:40px;"><font color="#999999"><%=OriginalPwdError%></font></td>
					  </tr>
					  <tr height="40px">
					    <td style="position: relative;left:180px;">新密码：</td>
					    <td><input name="newpassword" type="password" class="textinput" style="position: relative;left:125px;"/></td>
					  </tr>
					  <tr height="40px">
					    <td style="position: relative;left:180px;">性别：</td>
					    <td colspan="2" style="position: relative;left:140px;">&nbsp;&nbsp;<input type="radio" name="sex" value="男" />
					      男
					        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" />
					女</td>
					    </tr>
					  <tr height="40px">
					    <td style="position: relative;left:180px;">联系方式：</td>
					    <td colspan="2" style="position: relative;left:125px;"><input name="phone" type="text" class="textinput"/></td>
					   </tr>
				</table>
				<div style="margin-left:300px;margin-top: 20px;">
					<button type="submit" class="btn btn-primary">提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
				</div>
	      </form>
	      <%
		session.removeAttribute("OriginalPwdError");
 	  %>
	  </td>
    </tr>	
</table>
			</div>
		</div>
	</body>
</html>
