<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/search.css"/>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<title>搜索</title>
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
	      		<%}%>　　|　<a href="/BookStore/register.jsp">注册</a>　|　<a href="#">帮助中心</a>　|　<a href="/BookStore/UserinfoServlet">我的帐户</a>　|　<a href="/BookStore/cartservlet">购物车</a></span></div>
	    				  </tr>
	 				  </table>
			</div>
			<form action="SearchServlet" method="post">
			<div id="search">
			<%String keyword=(String)session.getAttribute("keyword");%>
					<div class="input-group" style="width: 300px; margin-left: 350px;">
			     	<input name="keyword" type="text" class="form-control" placeholder="关键字搜索" value=<%=keyword%>>
			      	<span class="input-group-btn">
			        <button class="btn btn-default" type="submit">Go!</button>
     				 </span>
     				 </div>
			</div>
			</form>
			<div id="center"">
				<p style="font-family: '微软雅黑'; font-size: 25px;line-height: 25px;margin-left: 25px;">搜索</p>
				<div class="kongjan" style="background-color: black;width:974px;height: 3px"></div>		
				<table width="100%">
					<tr>
						<td width="26%" style="vertical-align: top;">
						<form action="SearchServlet" method="post">
							<table width="100%">
								<div style="margin-top: 150px;margin-left: 40px;">
									<p style="margin-top:-100px;position: relative;">缩小搜索范围</p>
									<hr />
									<p>关键字:<input name="keyword" type="text" class="form-control" style="width: 150px;height: 25px;margin-left:60px;margin-top: -22px;"></p>
																	<div  style="margin-top: 20px;">
										类&nbsp;&nbsp;&nbsp;别:&nbsp;&nbsp;&nbsp;
										<select name="typeID" class="form-control" style="width: 150px;height: 31px;margin-top: -27px;margin-left: 60px;">
								        <option value=1>哲学</option>
									  	<option value=2>宗教</option>
									  	<option value=3>政治</option>
									  	<option value=4>法律</option>
									  	<option value=5>军事</option>
									  	<option value=6>经济</option>
									  	<option value=7>文化</option>
									  	<option value=8>科技</option>
									  	<option value=9>教育</option>
									  	<option value=10>计算机</option>
									  	<option value=11>历史</option>
									  	<option value=12>地理</option>
									  	<option value=13>小说</option>
							          	</select>
									</div>
										<div style="margin-top:20px;">
										价&nbsp;&nbsp;&nbsp;格:&nbsp;&nbsp;&nbsp;
										<select name="price" class="form-control" style="width: 150px;height: 31px;margin-top: -27px;margin-left: 60px;">
									  	<option value=0>价格从高到低</option>
									  	<option value=1>价格从低到高</option>
							          	</select>
									</div>									
									<button class="btn btn-default" type="submit" style="width: 70px;height: 30px;margin-top: 20px;margin-left:85px;">搜索</button>
							</table>
						   </form>
						</td>
							<td width="74%">
							<%
							List<book> searchbooklist=(List<book>)session.getAttribute("searchbooklist");
							for(book list:searchbooklist){
							%>
								<table style="border-collapse: collapse; background: rgb(252,252,252);margin-top: 20px; margin-left: 50px;">
									<tr style="border:1px solid gray;">
										<td>
											<div>
												<div style="margin:10px 50px 10px 40px;float: left;"><a href="info.jsp?bookID=<%=list.getBookid()%>"><img src="img/book/<%=list.getImage()%>" width="120" height="170"/></a></div>	
												<div style="float: left;width:450px;">
													<p style="font-size: 19px;margin-top: 25px;"><a href="info.jsp?bookID=<%=list.getBookid()%>"><%=list.getBookName()%></a></p>
													<p>作者：&nbsp;&nbsp;&nbsp;&nbsp;<%=list.getAuthor()%></p>
													<p>出版社:&nbsp;&nbsp;&nbsp;&nbsp;<%=list.getPress()%></p>
													<p style="margin-top: 35px;">市场价：&nbsp;&nbsp;&nbsp;&nbsp;<del>&yen<%=list.getCostPrice()%></del>
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														优惠价:<p style="margin-top: -38px;margin-left:210px;color: red;font-size: 22px;">&yen;<%=list.getPrice()%></p></p>
														<button type="button" class="btn btn-danger"style="font-size: 20px;margin-left: 310px;margin-top: -70px;" onclick="javascript :window.location.href='/BookStore/AddCartServlet?addcart=<%=list.getBookid()%>';">加入购物车</button>
												</div>
											</div>
										</td>
									</tr>
								</table>
								<%}%>
							</td>
						</tr>
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
