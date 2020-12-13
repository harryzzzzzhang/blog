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
<title>修改用户信息</title>

<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>

</head>
<body>
<h1 class="text-center">修改用户的信息</h1>
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
	
	<%User user=(User)(request.getAttribute("user"));%>
	<form class="form-inline" action="modifyUser" Method="Post">
  		<div class="form-group">
    	<label class="sr-only" for="exampleInputEmail3">userEmail</label>
    	邮箱：<input type="email" class="form-control" id="inputUserEmail" name="inputUserEmail" value="${ user.userEmail }">
  		</div>
  		
  		<br/>
  		<div class="form-group">
    	<label class="sr-only" for="exampleInputNickname3">userNickname</label>
    	昵称：<input type="text" class="form-control" id="inputUserNickname" name="inputUserNickname" value="${ user.userNickname }">
  		</div>
  		
  		<br/>
  		<div class="form-group">
    	<label class="sr-only" for="exampleInputPassword3">userPassword</label>
    	密码：<input type="text" class="form-control" id="inputUserPassword" name="inputUserPassword" value="${ user.userPassword }">
  		</div>
  		
  		<br/>
  		<div class="form-group">
    	<label class="sr-only" for="exampleInputName3">userName</label>
    	名字：<input type="text" class="form-control" id="inputUserName" name="inputUserName" value="${ user.userName }">
  		</div>
  		
  		<br/>
  		<div class="form-group">
    	<label class="sr-only" for="exampleInputSex3">userSex</label>
    	性别：
    	<label class="checkbox-inline">
  		<input type="radio" id="inlineCheckbox1" name="inputUserSex" value="男" checked> 男
		</label>
		<label class="checkbox-inline">
  		<input type="radio" id="inlineCheckbox2" name="inputUserSex" value="女"> 女
		</label>
  		</div>
  		
  		<br/>
  		<div class="form-group">
    	<label class="sr-only" for="exampleInputBriefIntroduction3">userBriefIntroduction</label>
    	简介：<input type="text" class="form-control" id="inputUserBriefIntroduction" name="inputUserBriefIntroduction" value="${ user.userBriefIntroduction }">
  		
  		<br/>
 		<button type="submit" class="btn btn-default">提交修改</button>
 		<h5 class="text-center" style="color:red">${Message}</h5>
  		</div> 		
	</form>
    </div>
</body>
</html>