<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<div>
  	 <p> This is my first struts2 page. <br>  	
  	</div>
	<div>
    <form action="<%=basePath %>/login/login" method="post">
    	用户名:<input type="text" name="username"><br>
    	密&nbsp;&nbsp;码:<input type="password" name="password"><br>
    	<input type="submit" value="提交">
    </form>
    <hr>
    </div>
    <div>
    	<%
		String name= (String)session.getAttribute("user");
		%>
		<%=name %>

    </div>
      <s:debug></s:debug>
  </body>

</html>