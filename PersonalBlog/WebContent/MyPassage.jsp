<%@ page language="java" import="java.util.*" import="com.sim.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的发布</title>
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
		</ul>
	</div>
	
	<div class="PCcontent">
		<table class="table table-hover">
			<tr>
    			<th>文章标题</th>
    			<th>类       型</th>
    			<th>发布时间</th>
    			<th>更新时间</th>
    			<th>操       作</th>
    		</tr>
    	<% List<Passage>  list= (List<Passage>)(request.getAttribute("list")); 
			for (int i=0;i<list.size();i++){
    			Passage passage=list.get(i);%>
    		<tr>
    			<td><%=passage.getTitle() %></td>
    			<td><%=passage.getStyle() %></td>
    			<td><%=passage.getPublishTime() %></td>
    			<td><%=passage.getUpdateTime() %></td>
    			<td>
    				<a href="displayPassage?title=<%=passage.getTitle() %>&userEmail=<%=user.getUserEmail() %>">查看</a>
    				<a href="modifyPassage?title=<%=passage.getTitle() %>&userEmail=<%=user.getUserEmail() %>">修改</a>
    				<a href="deletePassage?title=<%=passage.getTitle() %>&userEmail=<%=user.getUserEmail() %>">删除</a>
    			</td>
   			</tr>
        	<% } %>
		</table>
	</div>
</div>
</body>
</html>