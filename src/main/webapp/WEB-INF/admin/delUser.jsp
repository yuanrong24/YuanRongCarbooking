<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<style type="text/css">
body {
background-color:#D6D6D6;
}
form{
	width:850px;
	margin:auto;
	margin-top:20px;
	background-color:white;
	border-radius:12px;

}
th{
	text-align:center;
}
td{
	text-align:center;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$("#returnBtn").click(function() {
		location.href = "returnAdminIndex";	
	})
})

var delResult = "${delResult }";
if(delResult=="success"){
	alert("删除成功");
}
</script>
</head>
<body>
<span style="font-size:25px;display:block;width:100px;margin:auto;margin-top:100px;">删除用户</span>
<form class="form-horizontal"  role="form" action="" method="post">
<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>账号</th>
				<th>手机号</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.phone}</td>
                <td><a href="delUser?id=${user.id}"
							onclick="if(confirm('确认删除吗？')==false)return false">删除</a></td>	
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="form-group" >
				<div class="col-sm-offset-2 col-sm-10" style="margin-left: 742px;margin-top: 10px;height:40px;">
					<input type="button" id="returnBtn" class="btn btn-default"  value="返回">
				</div>
	</div>
</form>
</body>
</html>