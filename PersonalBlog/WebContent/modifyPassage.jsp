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
	
	<div class="PCcontent">
		<%Passage passage=(Passage)(request.getAttribute("passage")); %>
		<form class="form-inline" action="modifyPassage" Method="Post">
  			<div class="form-group">
    		<label class="sr-only">title</label>
    		文章标题：<input class="form-control" id="inputPassageTitle" name="inputPassageTitle" value="${ passage.title }">
  			</div>
  		
  			<br/>
  			<div class="form-group">
    		<label class="sr-only">style</label>
    		文章类型：<p class="form-control-static">${ passage.style }(不可修改)</p>
  			</div>
  		
  			<br/>
  			<div class="form-group">
    		<label class="sr-only">content</label>
    		文章内容：
    		<br/>
    		<textarea class="form-control" rows="40" cols="130" id="inputPassageContent" name="inputPassageContent" style="min-width: 90%">${ passage.content }</textarea>
  			</div>

			<input type="hidden" name="userEmail" value="<%=user.getUserEmail() %>">
			<div>
 			<button type="submit" class="btn btn-default">提交修改</button>
 			<h5 class="text-center" style="color:red">${Message}</h5>
  			</div> 		
		</form>
	</div>
</div>

<div class="footer">
	<hr>
	<h5  class="text-center">Copyright By Harry Zhang</h5>
</div>
</body>
</html>