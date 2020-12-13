<%@ page language="java" import="java.util.*" import="com.sim.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>显示选定用户的信息和文章</title>
<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>

</head>
<body>
<jsp:include page="/include/header.jsp"></jsp:include>

<div class="container">
	<div class="PCcontent">
	  <table class="table table-striped">
    	<tr>
    		<th>邮箱</th>
    		<th>${ user2.userEmail }</th>
    	</tr>
    	
    	<tr>
    		<th>昵称</th>
    		<th>${ user2.userNickname }</th>
    	</tr>
    	
    	<tr>
    		<th>密码</th>
    		<th>${ user2.userPassword }</th>
    	</tr>
    	
    	<tr>
    		<th>姓名</th>
    		<th>${ user2.userName }</th>
    	</tr>
    	
    	<tr>
    		<th>性别</th>
    		<th>${ user2.userSex }</th>
    	</tr>
    	
    	<tr>
    		<th>个人简介</th>
    		<th>${ user2.userBriefIntroduction }</th>
    	</tr>
	</table>
	</div>
	
	 <table class="table table-striped">
    	<tr>
    		<th>文章标题</th>
    		<th>类       型</th>
    		<th>发布时间</th>
    		<th>更新时间</th>
    	</tr>
    	<%  
    		List<Passage>  list= (List<Passage>)(request.getAttribute("list"));
    		for (int i=0;i<list.size();i++){
    			Passage passage=list.get(i);
    	 %>
    	 <%User user=(User)(request.getAttribute("user"));
    	 if(session.getAttribute("userSession")!=null){%>
    	 <tr>
    	 	<td><a href="passageContent?title=<%=passage.getTitle() %>&passageAuthor=<%=passage.getUserEmail()%>&userEmail=<%=user.getUserEmail()%>"><%=passage.getTitle()%></a></td>
    	 	<td><%= passage.getStyle() %></td>
    	 	<td><%=passage.getPublishTime() %></td>
    	 	<td><%=passage.getUpdateTime() %></td>
    	 </tr>
    	 <%}else{ %>
    	 <tr>
    	 	<td><a href="passageContent?title=<%=passage.getTitle() %>&passageAuthor=<%=passage.getUserEmail()%>"><%=passage.getTitle() %></a></td>
    	 	<td><%= passage.getStyle() %></td>
    	 	<td><%=passage.getPublishTime() %></td>
    	 	<td><%=passage.getUpdateTime() %></td>
    	 </tr>
    	 <%} %>
    	 <% } %>
    </table>
	
</div>

<div class="footer">
	<hr>
	<h5  class="text-center">Copyright By Harry Zhang</h5>
</div>
</body>
</html>