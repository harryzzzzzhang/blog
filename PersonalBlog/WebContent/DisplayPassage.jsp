<%@ page language="java" import="java.util.*" import="com.sim.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>
</head>
<body>
<jsp:include page="/include/header.jsp"></jsp:include>
<%User user=(User)(request.getAttribute("user"));%>
<div class="container">
	<div class="PCmenu">
		<ul class="nav nav-pills nav-stacked">
  			<li role="presentation" class="bg-info"><a href="PersonalIndex?userEmail=<%=user.getUserEmail() %>">个人信息</a></li>
  			<li role="presentation" class="bg-info"><a href="MyPassage?userEmail=<%=user.getUserEmail() %>">我的发布</a></li>
  			<li role="presentation" class="bg-info"><a href="#">我的问答</a></li>
  			<li role="presentation" class="bg-info"><a href="#">账户安全</a></li>
		</ul>
	</div>
	
		<%Passage passage=(Passage)(request.getAttribute("passage")); %>
		<h2 class="text-center"><%=passage.getTitle() %></h2>
		<h4 class="text-right">作者邮箱：<%=passage.getUserEmail() %></h4>
		<br/>
		<%=passage.getContent() %>
		<br/>
		<h4 class="text-right">发布时间：<%=passage.getPublishTime() %></h4>
		<h4 class="text-right">更新时间：<%=passage.getUpdateTime() %></h4>
</div>

<div class="footer">
	<hr>
	<h5  class="text-center">Copyright By Harry Zhang</h5>
</div>
</body>
</html>