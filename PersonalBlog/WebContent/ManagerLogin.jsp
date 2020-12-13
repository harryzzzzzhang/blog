<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆到管理员的空间</title>
<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>
</head>
<body>
<h1 class="text-center">世界0.6°空间<small>假装<mark>沉默</mark>的每个人</small></h1>

<div class="container">
	<h3 class="text-center">登陆到管理员的空间</h3><br>
	<form class="form-horizontal" action="ManagerLogin" method="post">
  		<div class="form-group">
    		<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
    		<div class="col-sm-10">
      			<input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email">
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    		<div class="col-sm-10">
      			<input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Password">
    		</div>
  		</div>
  		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-default">登陆</button>
    		</div>
  		</div>
	</form>
	<h5 class="text-center" style="color:red">${errorMessage}</h5>
</div>

</body>
</html>