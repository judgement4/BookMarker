<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>main page for resource</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<!--  
	<link rel="stylesheet" type="text/css" href="styles.css">
-->
	<script type="text/javascript" src="js/BookUpload.js"></script>
  </head>
  
  <body>
  <div>
 	<h1>本页面为显示资源的主页面</h1> <br />
  </div>
	<div>
		<input type="button" onclick="Upload()" value="submit">
	</div>
	<div id="info">
	</div>
	<div>
		<p>列表显示资源</p>
	</div>
  </body>
</html>
