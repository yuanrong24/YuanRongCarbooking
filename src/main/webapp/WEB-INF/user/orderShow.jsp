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
			location.href = "returnBtnUserIndex";	
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
	width:800px;
	height:700px;
	margin:auto;
	background-color:white;
	border-bottom-left-radius:16px;
	border-bottom-right-radius:16px;
}
form{
	background-color:white;
	width:800px;
	margin:auto;
	margin-top:20px;
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
<title>预定车票</title>
</head>
<body>
<div>
<span style="font-size:25px;display:block;width:100px;margin:auto;margin-top:50px;">预订车票</span>
	<form class="form-horizontal"  role="form" action="searchChePiao" method="post">
	<label  style="display:block;width:550px;height:80px;margin:auto;margin-top:10px;">
	路线:
	<input type="text"  id="goods_name" class="form-control" name="qsdxj" placeholder="起始地(县/区级)"" style="margin-top:20px;width:150px;display:inline;">
	&emsp; - &emsp;
	<input type="text"  id="goods_name" class="form-control" name="mddxj" placeholder="目的地(县/区级)"" style="width:150px;display:inline;">
	<button type="submit" class="btn btn-default" style="display:inline">搜索</button>
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
					<th>发车时间</th>
					<th>时长</th>
					<th>价格(元)</th>
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
						<td>${xl.fcsj}</td>
						<td>${xl.sc}</td>
						<td>${xl.jg}</td>
						<td><a href="QueRenOrders?id=${xl.id}">预定</a></td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>