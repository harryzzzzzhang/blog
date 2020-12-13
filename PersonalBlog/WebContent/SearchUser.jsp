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
<title>查找用户</title>
<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>
</head>
<body>
<jsp:include page="/include/header.jsp"></jsp:include>
<div class="container">
    <table class="table table-striped">
    	<tr>
    		<th>邮       箱</th>
    		<th>用户昵称</th>
    		<th>姓       名</th>
    		<th>性      别</th>
    	</tr>
    	<%  
    		List<User>  list= (List<User>)(request.getAttribute("list"));
    		for (int i=0;i<list.size();i++){
    			User user2=list.get(i);
    	 %>
    	 <tr>
    	 	<td><%= user2.getUserEmail() %></td>
    	 	<td><%= user2.getUserNickname() %></td>
    	 	<td><%= user2.getUserName() %></td>
    	 	<td><%= user2.getUserSex() %></td>
    	 </tr>
    	 <% } %>
    </table>
    </div>
<div class="footer">
	<hr>
	<h5  class="text-center">Copyright By Harry Zhang</h5>
</div>
</body>
</html>