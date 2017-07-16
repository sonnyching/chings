<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../includefile.jsp"%>
<html>
<script>
    function login() {
        var name = $("#name").val();
        var password = $("#password").val();
        $.ajax({
            url:'/user/login/submitLogin',
            method:'post',
            type:"json",
            data:"name="+name+"&password="+password,
            success: function (data) {
                if(data.code<=0){
                    window.location.href="/user/account";
                }else{
                    alert(data.msg);
                }
            },
            error:function (error) {
                alert("网络异常！");
            }
        });
    }

</script>
<head>
    <title>登陆</title>
</head>
<body>
<div class="input-group">
    <input type="text" class="form-control ching-register-input"
           placeholder="请输入用户名"
           aria-describedby="basic-addon2"
           id="name">
    <input type="password" class="form-control ching-register-input"
           placeholder="请输入密码"
           id="password"
           aria-describedby="basic-addon2">
</div>

<button type="button" class="btn btn-primary" onclick="login()">登陆~</button>

</body>
</html>
