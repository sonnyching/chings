<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>博客列表</title>
<!-- Bootstrap -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ include file="../includefile.jsp"%>
<style type="text/css">
.article_container{
	margin:10px;
	padding:20px;
	/* border:1px solid #BFBABA; */
	border-radius:6px;
	background-color:#ffffff;
}
.article_time_line{
	padding-left:20px;
	margin-left:10px;
}

.header{
	font-size:20px;
	font-family:微软雅黑;
	font-weight:bold;
	color:#5B4F4F;
	
}
.header a{
	text-decoration:none;
}
a:hover{
	color: #45bcf9;
	text-decoration:none;
}
.timeline{
	font-size:10px;
	color:#CCCCCC;
}
.content{
	font-size:12px;
	font-family:微软雅黑;
	color:#22B8DD;
}
.posttime{
	background:url(../static/img/ico_time.png) no-repeat left center;
}
.author{
	background:url(../static/img/ico_praise.png) no-repeat left center;
}
.article_def {
    color: #fff;
    background-color: #45bcf9;
    padding: 3px 6px;
    font-size: 12px;
    display: inline-block;
    position: relative;
    top: -2px;
    margin-right: 2px;
}
.article_type {
    color: #fff;
    background-color: #F2C685;
    padding: 3px 6px;
    font-size: 12px;
    display: inline-block;
    position: relative;
    top: -2px;
    margin-right: 2px;
}

.article_content{
	padding-top:3px;
}
.panel{
	background-color:#ffffff;
	border:none;
}
.bloginfo{
	background-color:#ffffff;
	border-radius:6px;
}

.likes-clicked{
	background:url(../static/img/ico_praise.png) no-repeat left center;
	width: 30px;
	height: 30px;
}

	.article-list-botom{
		height: 30px;
		width: auto;
		text-align: center;
	}

</style>



<script type="text/javascript">
	$(function(){
		var totalPage = "${page.totalPages}";
		for (var int = 1; int <= totalPage; int++) {
			var pagecode = "<li><a href='/article/page?currentPage="+int+"'>"+int+"</a></li>";
			$("#article_pagination").append(pagecode);
		}
	});
	function likes(articleId) {
		$.ajax({
			url:'/message/addNotice?id='+articleId,
			method:"get",
			success:function (data) {
				if(data.code<=0){
				    alert('like success!');
				}else{
				    alert(data.msg);
				}
            }
		});
    }
	
</script>


</head>
<body>
	<div class="container pull-left">
		<div class="row">
			<div class="col-md-7 col-md-offset-1" >
				<!--文章列表  -->
				<c:forEach items="${page.list}" var="article">
					<div class="article_container">
					  <div>
						  <i class="article_def header">${article.article_definition_name }</i>
						  <i class="article_type header">${article.article_type_name }</i>
						  <a class="header" href='detail?article_id=${article.article_id}'>${article.article_title }</a>
					  </div>
					  <div>
						  <div class="timeline">
							<span class="author article_time_line">
								${article.article_author_nickname }
							</span>
							<span class="posttime article_time_line">
								${article.article_publish_date }
							</span>
						  </div>
						  <div>
						  	 &nbsp;&nbsp;&nbsp;&nbsp;${article.article_intro }
						  </div>	
					  </div>

						<div class="article-list-botom">
							<span class="glyphicon glyphicon-thumbs-up" onclick="likes(${article.article_id})"/>
						</div>

					</div>
				</c:forEach>
				
				<!-- 分页组件 -->
				<nav style="margin:10px;">
				  <ul class="pagination" id="article_pagination">
				  </ul>
				</nav>
				
			</div>
			
			<!-- 博客简介 -->
			<div class="col-md-4">
				<div class="bloginfo">
					<div class="panel panel-default">
					<div class="panel-heading">SonnyChing</div>
					<div class="panel-body">
						<p>路途遥远，
						<p>但终究会到达，
						<p>在此记录下路途的点点滴滴，
						<p>希望有一天自己能够记起...
						<hr style="margin:0 0 10px 0"/>
					 </div>
					</div>
				</div>
				
				
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
</body>
</html>