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
		<%Passage passage=(Passage)(request.getAttribute("passage"));
		User user=(User)(request.getAttribute("user"));%>
		<form class="form-inline" action="managerModifyPassage" Method="Post">
  			<div class="form-group">
    		<label class="sr-only">title</label>
    		文章标题：<input class="form-control" id="inputPassageTitle" name="inputPassageTitle" value="${ passage.title }">
  			</div>
  		
  			<br/>
  			<div class="form-group">
    		<label class="sr-only">title</label>
    		文章作者：${ passage.userEmail }（不可修改）
  			</div>
  		
  			<br/>
  			<div class="form-group">
    		<label class="sr-only">style</label>
    		文章类型：
    		<label class="checkbox-inline">
  			<input type="radio" id="inlineCheckbox1" name="inputPassageStyle" value="电影"> 电影
			</label>
			<label class="checkbox-inline">
  			<input type="radio" id="inlineCheckbox2" name="inputPassageStyle" value="读书"> 读书
			</label>
			<label class="checkbox-inline">
 			<input type="radio" id="inlineCheckbox3" name="inputPassageStyle" value="音乐"> 音乐
			</label>
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
</body>
</html>