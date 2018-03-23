<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  	<link rel="stylesheet" type="text/css" href="button.css">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
	<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
	</script>
	<style type="text/css">
	body{
			font-size: 14px;
			font-family:"microsoft yahei","Hiragino Sans GB" ;
		}
		#top{
				padding-left:30px;
				padding-top: 20px;
				/*padding-bottom:20px;*/
				margin-bottom:40px;
				height: 60px;
				/*width: 990px;*/
			}
			#image{
				float: left;
				width: 100px;
				height: 60px;
			}
			#first{
				color:black;
				font-size: 24px;
				margin-top:15px ;
				float: left;
			}
			.have-account{
				position: relative;
				top:35px;
				right: 25px;
				color: #999;
				float: right;
				font-size: 16px;
				text-decoration: none;
			}
			#top a{
				color: black;
				font-size: 16px;
			}
			.space{
				height:70px;
			}
			.input-group{
				width:250px;
				margin:0px auto;
				/*margin-bottom: 40px;*/
			}
			.Emessage{
				position: relative;
				top:-80px;
				left:280px;
			}
			.form-control{
				padding-top:26px;
				padding-bottom:26px ;
				padding-left:20px;
			}
			.register_btn{
					width:250px;
					height:40px;
					margin-left:45px;
					/*letter-spacing:20px;*/
					text-align: center;
					font-weight: bold;
					color: #fff;
					background-color:red;
				}
				#foot{
					text-align: center;
					margin-top:70px;
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
<div id="top">
			<div id="image">
				<a href="/BookStore/indexServlet"><img src="img/logo.JPG"/></a>
			</div>
			<div id="first">
				欢迎注册
			</div>
			<div class="have-account">
				已有账号？
				<a href="/BookStore/login.jsp">请登录</a>
			</div>
</div>
<HR style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)" width="95%" color=#987cb9 SIZE=1>
<div id="input" style="text-align: center">
<form action="registerServlet" method="post">
	<!--<div class="space"></div>-->
	<%
	String emailerror=(String)session.getAttribute("emailerror");
	String pwderror=(String)session.getAttribute("pwderror");
	if(emailerror==null){
		emailerror="";
	}
	if(pwderror==null){
		pwderror="";
	}

 %>
	<table  width="850px" border="0" cellspacing="0" style="margin-left:420px;">
		<tr>
    		<td style="width:40%">
    		<div class="input-group input-group-sm">
	  			<span class="input-group-addon" id="sizing-addon3">用户邮箱:</span>
	 	 		<input name="email" type="text" class="form-control" aria-describedby="sizing-addon3">
			</div>
    		</td>
    		<td><font color="#999999" size="2"><%=emailerror%></font></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
    		<td style="width:40%">
    		<div class="input-group input-group-sm">
	  			<span class="input-group-addon" id="sizing-addon3">用户名:&nbsp;&nbsp;&nbsp;</span>
	 	 		<input name="username" type="text" class="form-control" aria-describedby="sizing-addon3">
			</div>
    		</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
    		<td style="width:40%">
			<div class=" input-group input-group-sm">
			  <span class="input-group-addon" id="sizing-addon3">密&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;&nbsp;</span>
			  <input name="password" type="password" class="form-control" aria-describedby="sizing-addon3">
			</div>
    		</td>
    		<td><font color="#999999" size="2">建议密码设置至少6位,请区分大小写</font></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
    		<td style="width:40%">
    		<div class="input-group input-group-sm">
	  			<span class="input-group-addon" id="sizing-addon3">确认密码:</span>
	 	 		<input name="confirmpassword" type="password" class="form-control" aria-describedby="sizing-addon3">
			</div>
    		</td>
    		<td><font color="#999999" size="2"><%=pwderror%></font></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
    	<td style="position: relative;left:60px;"><span style="font-size:13px;">性别:</span></td>
		    <td colspan="2"style="position: relative;left: -230px; font-size:13px;">&nbsp;&nbsp;<input type="radio" name="sex" value="男" />
		      男
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" />
		女</td>
    	</tr>
    	<tr><td>&nbsp;</td></tr>
    	<tr>
    		<td style="width:40%">
    		<div class="input-group input-group-sm">
	  			<span class="input-group-addon" id="sizing-addon3">联系电话:</span>
	 	 		<input name="phone" type="text" class="form-control" aria-describedby="sizing-addon3">
			</div>
    		</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><input type="submit" class="register_btn" value="立即注册" /></td></tr>
	</table>
	<%
	session.removeAttribute("emailerror");
	session.removeAttribute("pwderror");
 %>
</form>
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