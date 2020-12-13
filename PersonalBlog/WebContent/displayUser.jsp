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
<title>用户的详细信息</title>

<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>

</head>
<body>
 <h1 class="text-center">用户的详细信息</h1>
 <div class="container">
 <nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
      			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        		<span class="icon-bar"></span>
        		<span class="icon-bar"></span>
        		<span class="icon-bar"></span>
      			</button>
    		</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      			<ul class="nav navbar-nav navbar-right">
					<li><a class="navbar-brand" href="ListUser">返回用户列表</a></li>
      			</ul>
    		</div>
  		</div>
	</nav>
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
    </table>
    </div>
</body>
</html>