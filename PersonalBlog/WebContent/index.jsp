<%@ page language="java" import="java.util.*" import="com.sim.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>世界0.6°空间</title>

<link type="text/css" rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>
</head>
<body>
<jsp:include page="/include/header.jsp"></jsp:include>
<div class="container">
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  	<!-- Indicators -->
  		<ol class="carousel-indicators">
    		<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    		<li data-target="#carousel-example-generic" data-slide-to="1"></li>
    		<li data-target="#carousel-example-generic" data-slide-to="2"></li>
  		</ol>

  	<!-- Wrapper for slides -->
  		<div class="carousel-inner" role="listbox" >
    		<div class="item active">
      			<img src="img/movie2.jpg" alt="...">
      			<div class="carousel-caption">
        			电影
      			</div>
   			</div>
    		<div class="item">
      			<img src="img/book2.jpg" alt="...">
      			<div class="carousel-caption">
        			读书
      			</div>
    		</div>
    		<div class="item">
      			<img src="img/music1.jpg" alt="...">
      			<div class="carousel-caption">
        			音乐
      			</div>
    		</div>
  		</div>

  	<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    		<span class="sr-only">Previous</span>
  		</a>
  		<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    		<span class="sr-only">Next</span>
  		</a>
	</div>
	
	 <%User user=(User)(request.getAttribute("user"));
				if(session.getAttribute("userSession")!=null){ %>
	<div class="row">
		<div class="col-sm-6 col-md-4">
    		<div class="thumbnail">
      			<img src="img/movie1.jpg" alt="电影">
      			<div class="caption">
        			<h3>电影 Movie</h3>
        			<p>所有人生的谜语都可以从电影找到答案。</p>
        			<p>——史蒂夫•马丁Steve Martin</p>
        			<p><a href="moviePassage?userEmail=<%=user.getUserEmail() %>" class="btn btn-primary" role="button">进来看看</a></p>
      			</div>
    		</div>
		</div>
  
		<div class="col-sm-6 col-md-4">
    		<div class="thumbnail">
      			<img src="img/book1.jpg" alt="读书">
      			<div class="caption">
        			<h3>读书 Literature</h3>
        			<p>读一本好书，就是和许多高尚的人谈话。</p>
        			<p>——歌德</p>
        			<p><a href="booksPassage?userEmail=<%=user.getUserEmail() %>" class="btn btn-primary" role="button">进来看看</a></p>
      			</div>
    		</div>
		</div>
  
  		<div class="col-sm-6 col-md-4">
    		<div class="thumbnail">
      			<img src="img/music2.jpg" alt="音乐">
      			<div class="caption">
       				<h3>音乐 Music</h3>
        			<p>音乐是生活中最好的一面</p>
        			<p>——恩格斯</p>
        			<p><a href="musicPassage?userEmail=<%=user.getUserEmail() %>" class="btn btn-primary" role="button">进来看看</a></p>
      			</div>
    		</div>
  		</div>
</div>
<%}else{ %>
	<div class="row">
		<div class="col-sm-6 col-md-4">
    		<div class="thumbnail">
      			<img src="img/movie1.jpg" alt="电影">
      			<div class="caption">
        			<h3>电影 Movie</h3>
        			<p>所有人生的谜语都可以从电影找到答案。</p>
        			<p>——史蒂夫•马丁Steve Martin</p>
        			<p><a href="moviePassage" class="btn btn-primary" role="button">进来看看</a></p>
      			</div>
    		</div>
		</div>
  
		<div class="col-sm-6 col-md-4">
    		<div class="thumbnail">
      			<img src="img/book1.jpg" alt="读书">
      			<div class="caption">
        			<h3>读书 Literature</h3>
        			<p>读一本好书，就是和许多高尚的人谈话。</p>
        			<p>——歌德</p>
        			<p><a href="booksPassage" class="btn btn-primary" role="button">进来看看</a></p>
      			</div>
    		</div>
		</div>
  
  		<div class="col-sm-6 col-md-4">
    		<div class="thumbnail">
      			<img src="img/music2.jpg" alt="音乐">
      			<div class="caption">
       				<h3>音乐 Music</h3>
        			<p>音乐是生活中最好的一面</p>
        			<p>——恩格斯</p>
        			<p><a href="musicPassage" class="btn btn-primary" role="button">进来看看</a></p>
      			</div>
    		</div>
  		</div>
</div>
<%} %>
</div>
<div class="footer">
	<hr>
	<h5  class="text-center">Copyright By Harry Zhang</h5>
</div>

</body>
</html>