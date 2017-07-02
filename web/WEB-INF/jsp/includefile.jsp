<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>今日文章</title>
<!-- Bootstrap -->
<link href="../static/css/bootstrap.min.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<style type="text/css">
body{
	background-color:#EFEFED;
}
.navbar-brand{
	padding:0px;
}
.navbar-brand img{
	width:150px;
	height:50px;
}

</style>

</head>
<body>

<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">
      	<img alt="Brand" src="../static/img/chingsblog2.png">
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Java <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">分类</a></li>
            <li><a href="#">分类</a></li>
            <li><a href="#">分类</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">分类</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">分类</a></li>
          </ul>
          
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Android <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">分类</a></li>
            <li><a href="#">分类</a></li>
            <li><a href="#">分类</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">分类</a></li>
          </ul>
      </li>
      </ul>
     <!--  <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form> -->
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

	<script src="../static/js/jquery.min.js"></script>
	<script src="../static/js/bootstrap.min.js"></script>
</body>
</html>