<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆界面</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style type="text/css">

body {
    height:750px;
	background: url(img/beijing.jpg);
	background-size:100% 100%;
	/* background-size: cover; */
}
.form-group {
	width: 480px;
}
#div1 {
	margin:auto;
	margin-top:150px;
	padding-top:10px;
	width: 600px;
	padding-bottom:10px;
	background-color: rgba(0, 0, 0, 0.3);
}
</style>
<script>
$().ready(function() {
	//登录的判断
	$("#form1").submit(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		if (username == "") {
			alert("账号不能为空");
			return false;
		}
		if (password == "" ) {
			alert("密码不能为空");
            return false;
		}
	})
	//注册的判断
	$("#form2").submit(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var repass = $("#repassword").val();
		var phone = $("#phone").val();
		if (username == "") {
			alert("账号不能为空");
			return false;
		}
		if (password == "" ) {
			alert("密码不能为空");
            return false;
		}
		if (password.length < 6) {
			alert("密码至少为6位");
			$("input[name='password']").val("");
			return false;
		}
		if (repass == "") {
			alert("请再次输入密码");
			return false;
		}
		if (repass != password) {
			alert("两次密码不一致，请重新输入");
			$("input[name='repassword']").val("");
			return false;
		}
	    if(!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(phone))){ 
		        alert("手机号码有误，请重填");  
		        return false;
		}
	})
})
//注册失败的弹窗				
var ZCresult = "${ZCresult }";
if(ZCresult=="success"){
	alert("注册成功");
}
if(ZCresult=="fail"){
	alert("注册失败");
}
//登录失败的弹窗
var DLresult = "${DLresult }";
if(DLresult=="fail"){
	alert("登录失败");
}
</script>
</head>
<body>
<div id="div1">
<!-- 登录页面 -->
	<c:if test="${operateType=='D'}">
		<h3 align=center>用户登录</h3>
		<div align="center" style="margin-top: 30px">
			<form class="form-horizontal" id="form1" role="form" action="dlyz" method="post">
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label"
						style="color: orange">账号：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname"
							name="username" placeholder="请输入账号">
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label"
						style="color: orange">密码：</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="lastname"
							name="password" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" style="margin-left:50px">
						<button type="submit" class="btn btn-default" name="denglu" >登录</button>
					</div>
				</div>
			</form>
			<a href="zcShow" style="color:#B7B7B7;margin-left:10px">还没有账号？请点击注册</a>
		</div>
	</c:if>
<!-- 注册页面	 -->	
	<c:if test="${operateType=='R'}">
		<h3 align=center >欢迎注册</h3>
		<div align="center" style="margin-top: 30px">
			<form class="form-horizontal" id="form2" role="form" action="zcyz"
				method="post">
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label" style="color:orange">账号：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="请输入账号">
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label" style="color:orange">密码：</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label" style="color:orange">密码：</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="repassword"
							name="repassword" placeholder="请再次输入密码">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label" style="color:orange">手机：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="phone"
							name="phone" placeholder="请输入手机号">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" style="margin-left:50px">
						<button type="submit" class="btn btn-default" name="denglu" id="zhuce">注册</button>
					</div>
				</div>
			</form>
			<a href="login" style="color:#B7B7B7;margin-left:18px">已有帐号，请登录</a>
		</div>
	</c:if>
	</div>
</body>
</html>