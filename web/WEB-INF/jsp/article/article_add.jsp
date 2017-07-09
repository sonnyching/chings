<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新博客</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includefile.jsp"%>
</head>
<style>
html, body {
	height: 100%;
	width: 100%;
	background-color: #fff;
	min-width:300px;
}

.edit_left{
	margin-left:5px;
	height: 95%;
	width: 40%;
	display:inline-block;
	/* border:1px solid #000000; */
}

.edit_right{
	margin-right:5px;
	height: 95%;
	width: 55%;
	display:inline-block;
	/* border:1px solid #000000; */
}

.edit_content {
	height: 100%;
	width: 100%;
	padding: 10px;
	background-color: #fff;
	resize:none;
	margin-right: 10px;
}

.edit_content_show {
	height: 100%;
	width: 100%;
	padding: 10px;
	background-color: #fff;
	/* border:1px solid #000000; */
	position:relative;
    vertical-align: top;
    word-wrap:break-word;
	overflow-y:auto;
}

.edit_header {
	height: 6%;
	padding-left:10px;
	background-color: #fff;
	border: 1px solid gray;
	line-height: 30px;
	font-size: 16px;
	color: gray;
	margin-bottom:5px;
}

/* .edit_line {
	height: 2%;
} */

.btn_edit_complete {
	height: 5%;
	width: 10%;
	background-image: url(../static/img/chingsblog2.png);
}

.btn_article_next_step{
	
}

</style>
<script>
	$(function(){
		$("#btn_article_next_step").click(function(){
			
		});
		
		$("#btn_article_publish").click(function(){
			var def = $("#article_definition").val();
			var type = $("#article_type").val();
			var content = $("#article_content").val();
			var title = $("#article_title").text();
			var info = $("#article_intro").val();
			
			//alert(def+","+type+","+title+","+info+","+content);
			var form_data = "article_definition="+def+"&article_type="+type+"&article_content="+content
	   					+"&article_title="+title+"&article_intro="+info;
		 	$.ajax({
				   type: "POST",
				   url: "/article/add_article",
				   data: form_data,
				   success: function(msg){
					 var obj = jQuery.parseJSON(msg);
					 if(obj!=null && obj!=""){
						 if(obj.state==0){
							 alert("出错了，请稍后再试");
							 $('#myModal').modal("hide");
						 }else{
							 alert("发布成功！");
							 location.href="/xiaoqibaby/article/page";
						 }
					 }else{
						 alert("出错了，请稍后再试");
						 $('#myModal').modal("hide");
					 }
				   }
			}); 
		});
		
		$.ajax({
			   type: "GET",
			   url: "/article/article_defs",
			   success: function(msg){
				  	var json = jQuery.parseJSON(msg);
				  	for ( i=0;i<json.length;i++) {
				  		var op = "<option value='"+json[i].dict_id+"'>"+json[i].dict_name+"</option>";
					 	$("#article_definition").append(op);
					}
			   }
		});
		
		$.ajax({
			   type: "GET",
			   url: "/article/article_types",
			   success: function(msg){
				   var json = jQuery.parseJSON(msg);
				  	for ( i=0;i<json.length;i++) {
				  		var op = "<option value='"+json[i].dict_id+"'>"+json[i].dict_name+"</option>";
					 	$("#article_type").append(op);
					}
			   }
		});
		
	});
	
	
	function compile () {
        var text = document.getElementById("article_content").value;
        var converter = new showdown.Converter();
        //支持显示如同github的勾选框，默认false
        //ep: - [x] This task is done
        converter.setOption("tasklists", true);
        //支持显示table，默认false
        converter.setOption("tables", true);
        //支持图片大小设置，默认为false
        converter.setOption("parseImgDimensions", true);
        var html = converter.makeHtml(text);
        document.getElementById("article_preview").innerHTML = html;
    }
	
	function goNextStep() {
		
	}
	
</script>
<body>
<!-- 	<div style="width:100%; height:100%;">
		<div style="width:100%;height:100%;">
			<div style="width:100%;height:100%;" id="article_title" contenteditable="true">标题</div>
	 		<textarea style="width:100%;height:100%;" id="article_input" oninput="compile()"></textarea>
		</div>
		<div style="width:100%;height:100%;">
			<div style="width:100%;height:100%;" id="article_preview"></div>
		</div>
	</div> -->
	<div style="width:100%; height:87%">
		
		<div class="edit_left">
			<div class="edit_header" id="article_title" contenteditable="true" name="article_title" id="article_title">标题</div>
	 		<textarea class="edit_content" id="article_content" name="article_content" oninput="compile()"></textarea>
		</div>
		<div class="edit_right">
			<div style="height:7%;width:100%;vertical-align: middle;">
				<button id="btn_article_next_step" type="button"  class="btn btn-primary btn-dm" data-toggle="modal" data-target="#myModal">完成博客</button>
				<font style="color:#45bcf9;font-size:10px;text-align:center;"> Preview--></font>
			</div>
			<div class="edit_content_show" id="article_preview"></div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">文章选项</h4>
	      </div>
	      <div class="modal-body" >
	      		 <select class="form-control" id="article_definition" name="article_definition">
		   </select>
			
	       <select class="form-control" style="margin-top:10px;" id="article_type" name="article_type">
			</select>
			<h5>文章简介:</h5>
			<textarea style="width:100%;height:30%;" id="article_intro" name="article_intro"></textarea>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="btn_article_publish" >发布文章</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
</body>
</html>