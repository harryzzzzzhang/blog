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
<title>文章列表</title>
<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>

</head>
<body>
 <h1 class="text-center">文章列表</h1>
 <div class="container">
   	<jsp:include page="/include/managerHeader.jsp"></jsp:include>
    <table class="table table-striped">
    	<tr>
    		<th>用户名</th>
    		<th>类   型</th>
    		<th>文章名</th>
    		<th>操   作</th>
    	</tr>
    	<%  
    		List<Passage>  list= (List<Passage>)(request.getAttribute("list"));
    		for (int i=0;i<list.size();i++){
    			Passage passage=list.get(i);
    	 %>
    	 <tr>
    	 	<td><%= passage.getUserEmail() %></td>
    	 	<td><%= passage.getStyle() %></td>
    	 	<td><%= passage.getTitle() %></td>
    	 	<td>
    	 		<a href="managerDisplayPassage?title=<%=passage.getTitle() %>">详情</a>
    	 		<a href="managerModifyPassage?title=<%=passage.getTitle() %>">修改</a>
    	 		<a href="managerDeletePassage?title=<%=passage.getTitle() %>">删除</a>
    	 	</td>
    	 </tr>
    	 <% } %>
    </table>
    </div>
</body>
</html>