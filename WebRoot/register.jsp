<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     本页面提供用户注册功能. <br>
   <hr>
   
   <form action="<%=basePath %>user/register" method="post">
   	用户名：<input type="text" name="userName"><br>
   	密&nbsp;&nbsp;码：<input type="text" name="passWord"><br>
   	邮&nbsp;&nbsp;箱:&nbsp;<input type="text" name="email"><br>
   	<input type="submit" value="注册"><br>
   </form>
  </body>
</html>
