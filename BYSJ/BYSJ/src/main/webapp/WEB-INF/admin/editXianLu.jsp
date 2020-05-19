<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js" type="text/javascript"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<script>
	$(document).ready(function(){
		//返回首页
		$("#return").click(function(){
			location.href = "returnAdminIndex";	
	})
	})
	//删除线路的弹窗				
var delResult = "${delResult }";
if(delResult=="success"){
	alert("删除成功");
}
</script>
<style type="text/css">
.table{
	width:600px;
	height:700px;
	margin:auto;
	background-color:white;
	border-bottom-left-radius:16px;
	border-bottom-right-radius:16px;
}
form{
	background-color:white;
	width:600px;
	margin:auto;
	margin-top:50px;
	border-top-left-radius:16px;
	border-top-right-radius:16px;
}
body{
	background-color:#D6D6D6;
}
th{
	text-align:center;
}
td{
	text-align:center;
}
</style>
<title>删除线路</title>
</head>
<body>
<div>
	<form class="form-horizontal"  role="form" action="" method="post">
	<label  style="display:block;width:550px;height:80px;margin:auto;margin-top:10px;">
	路线:
	<input type="text"  id="goods_name" class="form-control" name="goods_name" placeholder="请输入起始地" style="margin-top:20px;width:150px;display:inline;">
	&emsp; - &emsp;
	<input type="text"  id="goods_name" class="form-control" name="goods_name" placeholder="请输入目的地" style="width:150px;display:inline;">
	<button type="button" class="btn btn-default" style="display:inline">搜索</button>
	<input type="button" id="return" class="btn btn-default return" value="返回"  style="display:inline;">
	</label>
	</form>
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>起始地</th>
				<th>目的地</th>
				<th>里程数</th>
				<th>车型</th>
				<th>时长</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${xls}" var="xl">
					<tr>
						<td>${xl.id}</td>
						<td>${xl.qsdsj}(${xl.qsdxj})</td>
						<td>${xl.mddsj}(${xl.mddxj})</td>
						<td>${xl.lcs}</td>
						<td>${xl.cx}</td>
						<td>${xl.sc}</td>
						<td><a href="editXianLuShow?id=${xl.id}">编辑</a></td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>