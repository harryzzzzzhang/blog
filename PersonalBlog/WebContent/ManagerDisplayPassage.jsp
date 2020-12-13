<%@ page language="java" import="java.util.*" import="com.sim.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>

</head>
<body>
<h1 class="text-center">用户列表</h1>

<div class="container">
 	<jsp:include page="/include/managerHeader.jsp"></jsp:include>
    <div class="PCcontent">
		<%Passage passage=(Passage)(request.getAttribute("passage")); %>
		<h2 class="text-center"><%=passage.getTitle() %></h2>
		<h5 class="text-right">作者邮箱：<%=passage.getUserEmail() %></h5>
		<br/>
		<%=passage.getContent() %>
		<br/>
		<h5 class="text-right">发布时间：<%=passage.getPublishTime() %></h5>
		<h5 class="text-right">更新时间：<%=passage.getUpdateTime() %></h5>
	</div>
    </div>
</body>
</html>