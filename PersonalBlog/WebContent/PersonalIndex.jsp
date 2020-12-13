<%@ page language="java" import="java.util.*" import="com.sim.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人中心</title>

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
		</ul>.
	</div>
	
	<div class="PCcontent">
	  <table class="table table-striped">
    	<tr>
    		<th>邮箱</th>
    		<th>${ user.userEmail }</th>
    	</tr>
    	
    	<tr>
    		<th>昵称</th>
    		<th>${ user.userNickname }</th>
    	</tr>
    	
    	<tr>
    		<th>密码</th>
    		<th>${ user.userPassword }</th>
    	</tr>
    	
    	<tr>
    		<th>姓名</th>
    		<th>${ user.userName }</th>
    	</tr>
    	
    	<tr>
    		<th>性别</th>
    		<th>${ user.userSex }</th>
    	</tr>
    	
    	<tr>
    		<th>个人简介</th>
    		<th>${ user.userBriefIntroduction }</th>
    	</tr>
    	
    	<tr>
    		<th><a href="userModifyUser?userEmail=<%=user.getUserEmail() %>">修改个人信息</a><th>
    	</tr>
	</table>
	</div>
</div>

<div class="footer">
	<hr>
	<h5  class="text-center">Copyright By Harry Zhang</h5>
</div>
</body>
</html>