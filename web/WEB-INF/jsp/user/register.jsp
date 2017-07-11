<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册chingblogs</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includefile.jsp"%>
</head>
<style>
	.ching-content{
		margin:20px 20px;
	}
	.ching-register-input{
		/*width:300px;*/
		margin:10px 0px;
	}
</style>
<script>
	function register() {
	    var name = $("#name").val();
	    var password = $("#password").val();
        var email = $("#email").val();
	    $.ajax({
            url:'/user/register/submitRegister',
            method:'post',
            type:"json",
			data:"name="+name+"&password="+password+"&email="+email,
            success: function (msg) {
                alert(msg.info);
            },
            error:function (error) {
                alert("网络异常！");
            }
        });
    }
	
</script>
<body>
	<div class="ching-content">
		<div class="input-group">
			<input type="text" class="form-control ching-register-input"
				   placeholder="请输入用户名"
				   aria-describedby="basic-addon2"
					id="name">
			<input type="password" class="form-control ching-register-input"
				   placeholder="请输入密码"
				   id="password"
				   aria-describedby="basic-addon2">
			<input type="text" class="form-control ching-register-input"
				   placeholder="请输入您的邮箱"
				   id="email"
				   aria-describedby="basic-addon2">
		</div>

		<button type="button" class="btn btn-primary" onclick="register()">开启新的章程吧~</button>

	</div>

</body>
</html>