<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章详情</title>
<%@ include file="../includefile.jsp"%>
</head>
<script type="text/javascript">
	
</script>
<body>

	<div class="container pull-left">
		<div class="row">
			<div class="col-md-9 col-md-offset-1">
				<ul class="list-group">
					<li class="list-group-item">${article.article_title }</li>
					<li class="list-group-item">${article.article_author_nickname }—
						${article.article_publish_date }</li>
					<li class="list-group-item">${article.article_content }</li>
				</ul>
			</div>
			<div class="col-md-2">
				<div data-spy="affix" class="affix-top">
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