<%@ page language="java" import="java.util.*,com.dao.*,com.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/rank.css"/>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<title>rank</title>
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
	      		<%}%>
	      		|　<a href="/BookStore/register.jsp">注册</a>　|　<a href="#">帮助中心</a>　|　<a href="/BookStore/UserinfoServlet">我的帐户</a>　|　<a href="/BookStore/cartservlet">购物车</a></span></div>
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
				<div id="c_right"">
					<ul class="nav nav-tabs" style="padding-left: 20px;margin-top: -60px;">
				        <li role="presentation" ><a href="indexServlet">首页</a></li>
				        <li role="presentation" ><a href="productlistServlet?bookTypeID1=0">全部商品目录</a></li>
				        <li role="presentation" class="active"><a href="rank.jsp">排行榜</a></li>
				        <li role="presentation"><a href="#">店家推荐</a></li>
				    </ul>
				    <div class="kongjan" style="background-color: black;width:800px;height: 3px"></div>
				    <div id="rank">
				    	<%
				    		List<book> salebooklist=bookdao.querysalesbook();
				    		int i=1;
				    		for(book list:salebooklist){
				    	%>
				    	<div class="rankbox" >
				    		<img src="img/<%=i%>.png" style="margin-left: 10px;">
				    		<a href="info.jsp?bookID=<%=list.getBookid()%>"><img style="margin-top: 40px;margin-left: 20px;" src="img/book/<%=list.getImage()%>" width="85" height="128"/></a>
				    		<p class="zuozhe">书名: <%=list.getBookName()%></br>作者:<%=list.getAuthor()%></p>
				    		<p class="chubanshe">出版社： <%=list.getPress()%></p>
				    		<p class="chubanshe">售价:<%=list.getPrice()%></p>
				    		<%int salesNumber=bookdao.getsaleNumber(list.getBookid());%>
				    		<p class="chubanshe">销售量:<%=salesNumber%>本</p>
				    		<button type="button" class="btn btn-danger" style="margin-left: 210px;margin-top: 10px;font-family: '微软雅黑';" onclick="javascript :window.location.href='/BookStore/AddCartServlet?addcart=<%=list.getBookid()%>';">加入购物车</button>
				    		<hr />
				    	</div>
				    	<%i++;}%>
				    </div>
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
	<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
