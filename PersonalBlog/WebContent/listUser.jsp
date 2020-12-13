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
    <table class="table table-striped">
    	<tr>
    		<th>用户名</th>
    		<th>用户昵称</th>
    		<th>操作</th>
    	</tr>
    	<%  
    		List<User>  list= (List<User>)(request.getAttribute("list"));
    		for (int i=0;i<list.size();i++){
    			User user=list.get(i);
    	 %>
    	 <tr>
    	 	<td><%= user.getUserEmail() %></td>
    	 	<td><%=user.getUserNickname() %></td>
    	 	<td>
    	 		<a href="displayUser?userEmail=<%=user.getUserEmail() %>">详       情</a>
    	 		<a href="modifyUser?userEmail=<%=user.getUserEmail() %>">修        改</a>
    	 		<a href="deleteUser?userEmail=<%=user.getUserEmail() %>">删        除</a>
    	 		<%if(user.getUserState().equals("1")) {%>
    	 		<a href="disableUser?userEmail=<%=user.getUserEmail() %>">禁       用</a>
    	 		解除禁用
    	 		<%} else { %>
    	 		禁       用
    	 		<a href="activeUser?userEmail=<%=user.getUserEmail() %>">解除禁用</a>
    	 		<%} %>
    	 	</td>
    	 </tr>
    	 <% } %>
    </table>
    </div>
</body>
</html>