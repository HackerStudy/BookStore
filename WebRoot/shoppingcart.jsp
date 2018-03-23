<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/shopingcar.css"/>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
		<style>
		.kucun{
	color: gray;
	font-size: 12px;
	font-style: italic;
	margin-bottom: -20px;
	margin-left: -10px;
}
		</style>
		<title>购物车</title>
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
				<p style="font-family: '微软雅黑'; font-size: 25px;line-height: 25px;margin-left: 25px;">购物车</p>
				<div class="kongjan" style="background-color: black;width:100%;height: 3px"></div>		
				<table>
					<tr style="height: 40px;">
						<td width="50px">&nbsp;&nbsp;&nbsp;&nbsp;序号</td>
	                    <td width="500px" style="text-align: center;">商品信息</td>
	                    <td width="100px">市场价</td>
	                    <td width="100px">优惠价</td>
	                    <td width="100px">数量</td>
	                    <td width="100px">小计</td>
						<td width="50px">操作</td>
					</tr>
				</table>
                  <%
                  	  int userID=Integer.parseInt(session.getAttribute("userID").toString());	 
                  	  List<repeat> replist=bookdao.qrepeatbookTypeID(userID);
                  	  List<only>  onlist=bookdao.qonlybookTypeID(userID);
	                  List<book> recommendlist=bookdao.qrecommendbook(replist,onlist); 
	                  List<Usercart> list =(List)session.getAttribute("cartlist");
                		int i=1;
	    				for(Usercart cart:list){
	    				int bookID=cart.getBookID();
	    				book b=bookdao.queryb(bookID);
	    				int bookTypeID=b.getBookTypeID();
	    				%>
	    			<form action="" method="post">
                  <table border="0" style="border:2px solid gainsboro; background: rgb(252,252,252);margin-top: 20px;">
                    <tr height="100px">
                      <td width="50px">&nbsp;&nbsp;&nbsp;&nbsp;00<%=i++%></td>
                      <td width="500px">
                      		<div class="infoBox">
                      			<div class="infoImg"><a href="info.jsp?bookID=<%=bookID%>"><img src="img/book/<%=b.getImage()%>" width="78px" height="90px"></a></div>
                      			<div class="infoHref"><p><a href="info.jsp?bookID=<%=bookID%>"><%=cart.getBookName()%></a></p></div>
                      			<div class="infoSize"><p>作者：<%=b.getAuthor()%></p><p>出版社:<%=b.getPress()%></p></div>
                      		</div>
                      </td>
                      <td width="100px"><del>&yen;<%=cart.getCostPrice()%></del></td>
                      <td width="100px" style="color: red;">&yen;<%=cart.getPrice()%></td>
                      <td width="100px"><a href="/BookStore/AlterNumServlet?bookid=<%=cart.getBookID()%>&price=<%=cart.getPrice()%>&flag=0&bookNumber=<%=cart.getBookNumber()%>" class="arithmetic">-</a><span style="width:30px;text-align: center;padding-left: 5px;padding-right: 5px;"><%=cart.getBookNumber()%></span><a href="/BookStore/AlterNumServlet?bookid=<%=cart.getBookID()%>&price=<%=cart.getPrice()%>&flag=1&bookNumber=<%=cart.getBookNumber()%>" class="arithmetic">+</a>
                      	<p class="kucun">库存<%inventory v=bookdao.qInventory(bookID);%><%=v.getInventory()%>本</p>
                      </td>
                      <td width="100px"><%=cart.getSubtotal()%></td>
                      <td width="50px">&nbsp;&nbsp;<a href="/BookStore/DeleteCServlet?bookid=<%=cart.getBookID()%>" style="color:#FF0000; font-weight:bold">X</a></td>
                    </tr>
                  </table>
                  <%}%>
                  <div style="margin-top: 20px;margin-left: 750px;">
                  	   <p style="font-size:19px;color: red;text-align: center;">总计：&yen;<%=session.getAttribute("total")%></p>
                  	<button type="button" class="btn btn-default"style="font-size: 20px;" onClick="javascript :window.location.href='/BookStore/productlistServlet?bookTypeID1=0';">继续购物</button>
                	 <button type="button" class="btn btn-danger"style="font-size: 20px;margin-left: 130px;margin-top: -60px;" onclick="javascript :window.location.href='/BookStore/order.jsp';">结&nbsp;&nbsp;&nbsp;&nbsp;算</button>
				  </div>
				  </form>
				    <p style="font-size: 22px;line-height: 22px;">猜你还会喜欢</p>
			<!---->	  <div id="carousel-example-generic" class="carousel slide center-block" data-ride="carousel" style="margin-top: 5px;width: 800px;height: 250px;">
			   			 <ol class="carousel-indicators">
			        	<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			        	<li data-target="#carousel-example-generic" data-slide-to="1" ></li>
			        	<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			   			 </ol>
			    	<div class="carousel-inner" role="listbox">
			    	<%
			    		int size=recommendlist.size(); 
			    	%>
			        	<div class="item active">
			        		<table 	 style=" margin-top: 15px;margin-left: 70px;">
			        			<tr height="250px">
			        			<%if(size<4){
			        				for(int k=0;k<size;k++){%>
				        			<td width="170px"><a href="info.jsp?bookID=<%=recommendlist.get(k).getBookid()%>"><img src="img/book/<%=recommendlist.get(k).getImage()%>" width="110" height="145" class="img"/></a>
				        					 <p class="p"><%=recommendlist.get(k).getBookName()%></p>
				        					<p class="p">售价:<span>&yen;<%=recommendlist.get(k).getPrice()%></span></p>
					        		</td>
					        		<%}
			        			}
			        			if(size>=4){
			        				for(int k=0;k<4;k++){%>
				        			<td width="170px"><a href="info.jsp?bookID=<%=recommendlist.get(k).getBookid()%>"><img src="img/book/<%=recommendlist.get(k).getImage()%>" width="110" height="145" class="img"/></a>
				        					 <p class="p"><%=recommendlist.get(k).getBookName()%></p>
				        					<p class="p">售价:<span>&yen;<%=recommendlist.get(k).getPrice()%></span></p>
					        		</td>
					        		<%}
			        			}%>
			        			</tr>
			        		</table>
			            		<div class="carousel-caption"></div>
			        	</div>
			        <div class="item">
			        		<table 	 style=" margin-top: 15px;margin-left: 70px;">
			        			<tr height="250px">
			        			<%if(size>4&&size<=8){
			        				for(int k=4;k<size;k++){%>
				        			<td width="170px"><a href="info.jsp?bookID=<%=recommendlist.get(k).getBookid()%>"><img src="img/book/<%=recommendlist.get(k).getImage()%>"width="110" height="145" class="img"/></a>
				        					 <p class="p"><%=recommendlist.get(k).getBookName()%></p>
				        					<p class="p">售价:<span>&yen;<%=recommendlist.get(k).getPrice()%></span></p>
				        			</td>
				        			<%}
				        		}
				        		if(size>8){
				        			for(int k=4;k<8;k++){%>
				        			<td width="170px"><a href="info.jsp?bookID=<%=recommendlist.get(k).getBookid()%>"><img src="img/book/<%=recommendlist.get(k).getImage()%>"width="110" height="145" class="img"/></a>
				        					 <p class="p"><%=recommendlist.get(k).getBookName()%></p>
				        					<p class="p">售价:<span>&yen;<%=recommendlist.get(k).getPrice()%></span></p>
				        			</td>
				        			<%}
				        		}%>
			        			</tr>
			        		</table>			            		
			          <div class="carousel-caption"></div>
			        </div>
			    </div>
			    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev" >
			        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			        <span class="sr-only">上一页</span>
			    </a>
			    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			        <span class="sr-only">下一页</span>
			    </a>
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
					 <%=size%>
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
