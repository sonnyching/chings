<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Chi's sweet home</title>
<!-- Bootstrap -->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<style type="text/css">

</style>

<script type="text/javascript">
	var articleItem = "";
</script>


</head>
<body>

<nav class="navbar navbar-default">
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
       logo
      <!--   <img alt="Brand" src="static/img/brand_image.jpg" style="width:60px;height:50px;margin_top:-10px;"> -->
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
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	<div class="container pull-left">
		<div class="row">
			<div class="col-md-9 col-md-offset-1" >
				<c:forEach items="${allArticles}" var="article">
					<div class="panel panel-default">
				  		<div class="panel-body">
				   		  ${article.article_definition }——${article.article_title }
				  		</div>
				  		<div>
				  		  ${article.articel_intro }
				  		</div>
				 		<div class="panel-footer">${article.articel_author } ${article.article_publish_date }</div>
					</div>
				
				</c:forEach>
			</div>
			<div class="col-md-2">
				<div data-spy="affix" class="affix-top" >
					<ul class="list-group">
					  <li class="list-group-item">Cras justo odio</li>
					  <li class="list-group-item">Dapibus ac facilisis in</li>
					  <li class="list-group-item">Morbi leo risus</li>
					  <li class="list-group-item">Porta ac consectetur ac</li>
					  <li class="list-group-item">Vestibulum at eros</li>
					</ul>
				</div>
			
			</div>
			
		
		</div>
	</div>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>