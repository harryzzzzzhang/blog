<%@ page language="java" import="java.util.*" import="com.sim.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>类型列表</title>
<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>
</head>
<body>
<h1 class="text-center">类型列表</h1>
<div class="container">
  	<jsp:include page="/include/managerHeader.jsp"></jsp:include>
  	<form class="form-inline" action="ListStyle" Method="Post">
  		<div class="form-group">
    	<label class="sr-only" for="exampleInputStyle">inputStyle</label>
    	输入要添加的类型：<input type="text" class="form-control" id="inputStyle" name="inputStyle"> 
    	<button type="submit" class="btn btn-default">添加类型</button>
  		</div>
  	</form>
    <table class="table table-striped">
    	<tr>
    		<th>类型名称</th>
    		<th>操作</th>
    	</tr>
    	<%  
    		List<Style>  listStyle= (List<Style>)(request.getAttribute("listStyle"));
    		for (int i=0;i<listStyle.size();i++){
    			Style style=listStyle.get(i);
    	 %>
    	 <tr>
    	 	<td><%= style.getStyle() %></td>
    	 	<td>
    	 		<a href="deleteStyle?style=<%=style.getStyle() %>">删        除</a>
    	 	</td>
    	 </tr>
    	 <% } %>
    </table>
    </div>
</body>
</html>