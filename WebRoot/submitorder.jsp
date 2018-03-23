<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	function myFunction(){
		var r=confirm("是否提交订单!");
		if (r==true){
			window.location.href='/BookStore/SubmitOrderServlet';
		}
		else{
			window.location.href='/BookStore/order.jsp';
		}
	}
</script>
<title>提示提交订单页面</title>
</head>
<body onload="myFunction();">
</body>
</html>
