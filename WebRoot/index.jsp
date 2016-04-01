<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>BookMarker's index page</title>
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
  	 <p> This is the index page for BookMarker website. <br>
  	 <P> show the points and log in function. <br>   
  	 <%System.out.println(basePath); %>
  	 <hr>	
  	</div>
	<div>
    <form action="<%=basePath %>user/login" method="post">
    	用户名:<input type="text" name="userName"><br>
    	密&nbsp;&nbsp;码:<input type="password" name="passWord"><br>
    	<input type="submit" value="提交">
    </form>
    <hr>
    </div>
    <div>
    	>> <a href="<%=basePath %>register.jsp">注册</a> <br>
    	<p><s:property value="#session.userName" /></p> <br>
    	<s:property value="#session.uid" />
    	<p id="reginfo"></p> 
    </div>
    <div>

    </div>
      <s:debug></s:debug>
    <div>
    <hr>
    	<h3>测试用户账号</h3>
   		<ul>
    		<li>英文用户名：FF/123</li>
    		<li>中文用户名:狒狒/123</li>
    		<li>管理员用户名:admin/admin</li>
    	</ul>
    </div>
  </body>

</html>
