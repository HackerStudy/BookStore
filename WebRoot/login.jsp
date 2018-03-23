<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录界面</title>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<style type="text/css">
			body{
				margin: 0px;
				padding: 0px;
				color:#fff;
				font-family: "microsoft yahei","微软雅黑";
				font-size: 14px;
			}
			#top{
				padding-left: 140px;
				height: 60px;
				width: 1100px;
			}
			#image{
				float: left;
				width: 100px;
				height: 81px;
			}
			#first{
				color:rgb(123,123,123);
				font-size: 23px;
				margin-top:15px ;
				float: left;
			}
			#top a{
				/*float: left;*/
				font-size: 12px;
				text-decoration: none;
			}
			.q-link{
				position: relative;
				top:35px;
				color: #999;
				float: right;
			}
			#user_login{
				position:relative;
				float:right;
				background-color:white;
				width:300px;
				height:325px;
				margin-top: 50px;
				margin-right:170px;
			}
			.top_space{
				height:15px;
			}
			#topic{
				margin: 0 auto;
				position: relative;
				top: 12px;
				width:75px;
				/*height:20px;*/
				color: #666;
			}
			#topic span{
				font-size:18px;
				text-align:center;
			}
			.space{
				height:25px;
			}
			.foot_space{
				height: 32px;
			}
			.input-group{
				width: 250px;
				margin: 0 auto;
			}
			/*.login_input{
				padding: 15px;
			}*/
			.login_btn{
				width:250px;
				margin-left:26px;
				/*letter-spacing:20px;*/
				text-align: center;
				font-weight: bold;
				color: #fff;
				background-color:rgb(228,27,60);
				/*margin-bottom:25px ;*/
			}
			input{
				border: none;
				height:38px;
				padding-left:5px;
			}
			.Emessage{
				margin: 0px auto;
				position: relative;
				top: 8px;
				/*padding-top: px;*/
				text-align: center;
			}
			.Emessage span{
				/*line-height:40px;*/
				color:red ;
			}
			#rg{
				position: relative;
				top: -10px;
				/*right: 12px;*/
				float: right;
				width:90px;
				/*height: 50px;*/
				/*line-height:25px;*/
			}
			#rg a{
				font-size: 14px;
				color: #b61d1d;
				text-decoration: none;					
			}
			.bg{
				background-image: url(img/58e45885N66d2b4c3.jpg);
				width:990px;
				height:475px;
				margin: 0px auto;
			}
			#foot{
				text-align: center;
				margin-top: 20px;
				color: #666;
			}
			#foot link{
				display: block;
			}
			a{
				font-size: 12px;
				text-decoration: none;
				color: #666666;
				padding:0px 10px;
			}
			.copyright{
				margin-top:15px;
				height: 50px;
				font-size: 12px;
			}
		</style>
	</head>
	<body>
		<!--块标签:标签前后都有换行符 -->
		<div id="top">
			<div id="image">
				<a href="/BookStore/indexServlet"><img src="img/logo.JPG"/></a>
			</div>
			<div id="first">
				欢迎登录
			</div>
			<a href="http://surveys.jd.com/index.php?r=survey/index/sid/568245/lang/zh-Hans"  target="_blank" class="q-link">登录页面,调查问卷</a>
		</div>
		<div>
		  	<div id="user_login">
				<form action="LoginServlet" method="post">
				 <%
		    		String none=(String)session.getAttribute("none");
		    		String ERROR_login=(String)session.getAttribute("ERROR_login");
		    		if(none==null){
						none="";
					}
					if(ERROR_login==null){
						ERROR_login="";
					}
		    	 %>
					<div id="topic">
						<span>账户登录</span>
					</div>
					<HR style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)" width="99%" color=#987cb9 SIZE=1>
					<div class="top_space"></div>
					<div class="input-group">
					  <span class="input-group-addon" id="basic-addon1">邮&nbsp;&nbsp;&nbsp;箱:</span>
					  <input name="email" type="text" class="form-control" placeholder="请输入邮箱" aria-describedby="basic-addon1">
					</div>
					<div class="space"></div>
					<div class="input-group">
					  <span class="input-group-addon" id="basic-addon1">密&nbsp;&nbsp;&nbsp;码:</span>
					  <input name="pwd" type="password" class="form-control" placeholder="请输入密码" aria-describedby="basic-addon1">
					</div>
					<div class="foot_space"></div>
					<div>
						<input type="submit" class="login_btn" value="登&nbsp&nbsp&nbsp&nbsp录" />
					</div>
					<div class="Emessage">
						<span><%=none%><%=ERROR_login%></span>
					</div>
					<HR style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)" width="99%" color=#987cb9 SIZE=1>
					<div id="rg"><a href="/BookStore/register.jsp">立即注册</a></div>
					  <%
			          	session.removeAttribute("none");
						session.removeAttribute("ERROR_login"); 
			          %>
				</form>
				<!--<a href="/JingDong/register.jsp" style="color: #b61d1d;>立即注册</a>-->
				<!--<a href="/JingDong/register.jsp" style="color: #b61d1d;>立即注册</a>-->
			</div>
	  		<div class="bg">
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
	</body>
</html>
