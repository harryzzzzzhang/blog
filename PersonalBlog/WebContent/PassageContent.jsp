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
<div class="container">
	<%Passage passage=(Passage)(request.getAttribute("passage")); %>
	<h2 class="text-center"><%=passage.getTitle() %></h2>
	<h5 class="text-right">作者邮箱：<%=passage.getUserEmail() %></h5>
	<br/>
	<%=passage.getContent() %>
	<br/>
	<h5 class="text-right">发布时间：<%=passage.getPublishTime() %></h5>
	
	
	<%  List<Comment>  list= (List<Comment>)(request.getAttribute("list"));
		if(list==null){%>
		<h5>评论区：无评论</h5>
	<%}else {%>
	<h5>评论区：</h5>
	<ul>
    	<%for (int i=0;i<list.size();i++){ 
    		Comment comment=list.get(i);%>
    	 <li>评论   人:<%= comment.getUserEmail() %></li>
    	 <li style="list-style-type:none;">评论时间:<%= comment.getCommentTime()%></li>
    	 <li style="list-style-type:none;">评论内容:<%= comment.getCommentContent()%></li>
    	 <%}%>
    </ul>
		<% }%>
	<%User user=(User)(request.getAttribute("user"));
	String passageAuthor=request.getParameter("passageAuthor");
	if(session.getAttribute("userSession")!=null) {%>
    <form action="addComment" method="post">
		<textarea class="form-control" rows="10" cols="130" id="inputComment" name="inputComment" style="min-width: 90%"></textarea>
		<input type="hidden" name="title" value="<%=passage.getTitle() %>">
		<input type="hidden" name=passageAuthor value=<%= passageAuthor%>>
		<input type="hidden" name="userEmail" value="<%=user.getUserEmail() %>">
		<button type="submit" class="btn btn-default">提交评论</button>
	</form>
	<%} else { %>
		<textarea class="form-control" rows="10" cols="130" id="inputComment" name="inputComment" placeholder="未登陆，不允许评论" disabled></textarea>
	<% }%>
</div>

<div class="footer">
	<hr>
	<h5  class="text-center">Copyright By Harry Zhang</h5>
</div>
</body>
</html>