<%@ page language="java" import="java.util.*" import="com.sim.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<style>
	#carousel-example-generic {
		height: 650px;
		width: 1140px;
		text-align: center
	}
			
	#carousel-example-generic .carousel-inner>.item>img {
		display: block;
		width: 1140px;
		height: 650px;
	}
	
	.PCmenu{
		margin:15px;
		width:90px;
		text-align:center;
		float:left;
	}
	
	.PCcontent{
	margin:15px;
	float:left;
	}
	
</style>

    <%User user=(User)(request.getAttribute("user"));
				if(session.getAttribute("userSession")!=null){ %>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand active" href="Index?userEmail=<%=user.getUserEmail() %>"><span class="glyphicon glyphicon-home"></span>世界0.6°空间</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a class="navbar-brand" href="Index?userEmail=<%=user.getUserEmail() %>"> 首页</a></li>
            <li><a class="navbar-brand" href="Passage?userEmail=<%=user.getUserEmail() %>">树洞</a></li>
          </ul>
          
          <form class="navbar-form navbar-left" action="searchPassage?userEmail=<%=user.getUserEmail() %>" method="post">
        			<div class="form-group">
          			<input type="text" class="form-control" placeholder="输入你要搜索的文章关键字"  id="searchPassageKeyword" name="searchPassageKeyword">
        			</div>
        		<button type="submit" class="btn btn-default">搜索</button>
      			</form>
      			
      			<form class="navbar-form navbar-left" action="searchUser?userEmail=<%=user.getUserEmail() %>"" method="post">
        			<div class="form-group">
          			<input type="text" class="form-control" placeholder="输入你要搜索的用户名关键字" id="searchUserKeyword" name="searchUserKeyword">
        			</div>
        		<button type="submit" class="btn btn-default">搜索</button>
      			</form>
      			
          <ul class="nav navbar-nav navbar-right">
            <li><a href="Remind">提醒 <span class="badge">4</span> </a></li>
      				<li role="presentation" class="dropdown">
        				<a id="drop4" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          					${user.userNickname}
         					<span class="caret"></span>
        				</a>
        				<ul id="menu1" class="dropdown-menu" aria-labelledby="drop4">
          					<li><a href="PersonalIndex?userEmail=<%=user.getUserEmail() %>">个人主页</a></li>
          					<li><a href="PostPassage?userEmail=<%=user.getUserEmail() %>">发布文章</a></li>
          					<li role="separator" class="divider"></li>
          					<li><a href="Logout">退出</a></li>
        				</ul>
      				</li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
  <%} else {%>
  <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand active" href="index.jsp"><span class="glyphicon glyphicon-home"></span>世界0.6°空间</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a class="navbar-brand" href="index.jsp">首页</a></li>
            <li><a class="navbar-brand" href="Passage">树洞</a></li>
          </ul>
          
          <form class="navbar-form navbar-left" action="searchPassage" method="post">
        			<div class="form-group">
          			<input type="text" class="form-control" placeholder="输入你要搜索的文章关键字"  id="searchPassageKeyword" name="searchPassageKeyword">
        			</div>
        		<button type="submit" class="btn btn-default">搜索</button>
      			</form>
      			
      			<form class="navbar-form navbar-left" action="searchUser" method="post">
        			<div class="form-group">
          			<input type="text" class="form-control" placeholder="输入你要搜索的用户名关键字" id="searchUserKeyword" name="searchUserKeyword">
        			</div>
        		<button type="submit" class="btn btn-default">搜索</button>
      			</form>
      			
         	 <ul class="nav navbar-nav navbar-right">
        			<li><a href="Login">普通用户登陆</a></li>
        			<li><a href="ManagerLogin">管理员登陆</a></li>
      			</ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
  <%} %>
 <br/>
<br/>
<br/>
