<%@page import="org.apache.taglibs.standard.tei.ForEachTEI,java.util.*,com.entity.*,com.dao.*,java.sql.SQLException"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>主页</title>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="button.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script src="bootstrap/js/bootstrap.js"></script>
	</head>
	<body>
<div id="container">
	<div id="divhead">
	  <table cellspacing="0" class="headtable">
	    <tr>
	      <td style="padding-left: 400px;padding-top: 28px;"><a href="indexServlet"><img src="img/1.JPG" width="94" height="81"/></a></td>
	      	<div id="tou"><span style="padding-left: 750px;">
	      	<%try{
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
		<div id="c_left" style="width:20%;height: 330px;float: left;">
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
		<div id="c_right" style="width:80%;height: 400px;float: left;padding-top: 70px;">
						    <ul class="nav nav-tabs" style="padding-left: 20px;margin-top: -60px;">
				        <li role="presentation" class="active"><a href="indexServlet">首页</a></li>
				        <li role="presentation" ><a href="productlistServlet?bookTypeID1=0">全部商品目录</a></li>
				        <li role="presentation"><a href="rank.jsp">排行榜</a></li>
				        <li role="presentation"><a href="#">店家推荐</a></li>
				    </ul>
						<div class="kongjan" style="background-color: black;width:800px;height: 3px"></div>
					<div id="carousel-example-generic" class="carousel slide center-block" data-ride="carousel" style="margin-top: 5px">
			   			 <ol class="carousel-indicators">
			        	<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			        	<li data-target="#carousel-example-generic" data-slide-to="1" ></li>
			        	<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			   			 </ol>
			    	<div class="carousel-inner" role="listbox">
			        	<div class="item active">
			            	<a href="info.jsp?bookID=29"><img src="img/book/book2.png"></a>
			            		<div class="carousel-caption"></div>
			        	</div>
			        <div class="item">
			            	<a href="info.jsp?bookID=26"><img src="img/book/book3.png" ></a>
			            		<div class="carousel-caption"></div>
			        </div>
			        
			        <div class="item">
			            	<a href="info.jsp?bookID=56"><img src="img/book/book4.png" ></a>
			           	    <div class="carousel-caption"></div>
			        </div>

			
			    </div>
			    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			        <span class="sr-only">上一页</span>
			    </a>
			    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			        <span class="sr-only">下一页</span>
			    </a>
			</div>
			
		<p class="text-left" style="font-family: '微软雅黑'; font-size: 20px;margin-left: 145px;margin-top: 42px;">新书上架</p>
		</div>
	</div>
	<div id="main">
			<div id="m_left">
				<p class="text-left" style="font-family: '微软雅黑'; font-size: 20px;margin-top: 20px;">公告板</p>
				<p class="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;·图书3折起，支持在线浏览 先看再买不后悔,任何商品免费送货</p>
				<p class="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;·Lonely Planet 已出版600多种旅行指南，几乎覆盖了全世界的每个角落。</p>
				<p class="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;·2007年中旅游图书畅销榜速递 中国游,世界游,旅游图书全部7折封顶</p>
				<p class="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;·50万种图书3折,百货团购价热卖 畅销榜新书速递,促销天天有</p>
			</div>
			<div id="m_right">
				<div class="btn-group" role="group" aria-label="..." style="padding-left:350px;">
				<form action="indexServlet" method="post">
				  <button name="bookTypeID" value="1" type="submit" class="btn btn-default">哲学</button>
				  <button name="bookTypeID" value="2" type="submit" class="btn btn-default">宗教</button>
				  <button name="bookTypeID" value="13" type="submit" class="btn btn-default">小说</button>
				  <button name="bookTypeID" value="9" type="submit" class="btn btn-default">教育</button>
				  <button name="bookTypeID" value="4" type="submit" class="btn btn-default">法律</button>
				  <button name="bookTypeID" value="8" type="submit" class="btn btn-default">科技</button>
				</form>
				</div>
				<table cellspacing="0" class="booklist" border="0"style="border:1px solid gainsboro;width:687px;height: 250px">
					<%
						List<book> typebooklist=(List<book>)session.getAttribute("typebooklist");
					%>
            <tr>
            	<%for(book tblist:typebooklist){
            		int bookID=tblist.getBookid();
            		String bookName=tblist.getBookName();
            		double price=tblist.getPrice();
    				String image=tblist.getImage();%>
              <td style="padding-left:30px;"><div class="divbookpic"><p><a href="info.jsp?bookID=<%=bookID%>"><img src="img/book/<%=image%>" width="110" height="145" border="0" /></a></p>
              </div>
                <div class="divlisttitle"style="position:relative;left:-15px; text-align: center;"><a href="info.jsp?bookID=<%=bookID%>"><%=bookName%>
                    <br />
                  售价： <%=price%>
                  <br/>
                  </a>
                 <p class="Shelftime"> 上架时间：
                 <%
                 Shelftime shelftime=bookdao.qshelf(bookID);
                 String time=shelftime.getYear()+"-"+shelftime.getMonth()+"-"+shelftime.getDay();
                 %><%=time%></p>
                  </div></td>
                  <%}%>
            </tr>
          </table>
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
