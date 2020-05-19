<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户维护</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<style type="text/css">
body {
background-color:#D6D6D6;
}
.div_out{
	background-color:white;
	width:600px;
	height:360px;
	margin:auto;
	margin-top:120px;
	border-radius:12px;
	padding-top:20px;
}
.form-horizontal{
    width:500px;
	margin:auto;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	//返回按钮
	$("#returnBtn").click(function(){
		location.href = "returnAdminIndex";
	})
	//新增用户的判断
	$("form").submit(function() {
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

</script>
</head>
<body>
	<div class="div_out">
		<form class="form-horizontal" action="addUser" method="post">
		<input type="hidden" name="id" value="${user.id }">
			<div class="form-group" style="margin-left:80px;margin-top:40px;">
				<label class="col-sm-2 control-label">账号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="username" name="username"
						placeholder="请输入账号"  value="${user.username }" style="width:200px;">
				</div>
			</div>
			<div class="form-group" style="margin-left:80px;">
				<label class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password"
						placeholder="请输入密码" value="${user.password }" style="width:200px;">
				</div>
			</div>
			<div class="form-group" style="margin-left:80px;">
				<label class="col-sm-2 control-label" >密码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="repassword" name="repassword"
						placeholder="请再次输入密码" value="${user.password }" style="width:200px;">
				</div>
			</div>
			<div class="form-group" style="margin-left:80px;">
				<label class="col-sm-2 control-label" >手机号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="phone" name="phone"
						placeholder="请输入手机号" value="${user.phone }" style="width:200px;">
				</div>
			</div>
			<!-- <div class="form-group" style="margin-left:80px;">
				<label class="col-sm-2 control-label">手机</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="telephone" name="price"
						placeholder="请输入手机号 " value="" style="width:200px;">
				</div>
			</div> -->
		<!-- 	<div class="form-group" style="margin-left:80px;">
				<label class="col-sm-2 control-label">身份证</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="请输入身份证号 " value="" style="width:200px;">
				</div>
			</div> -->

			<div class="form-group" style="margin-left:80px;margin-top:30px;">
				<div class="col-sm-offset-2 col-sm-10">
					<c:if test="${type eq 'C'}"><button type="submit" class="btn btn-default edit">增加</button>&emsp;</c:if>
			  		<c:if test="${type eq 'U'}"><button type="submit" class="btn btn-default edit">修改</button>&emsp;</c:if>
					<input type="button" id="returnBtn" class="btn btn-default" value="返回">
				</div>
			</div>
		</form>
	</div>
</body>
</html>