<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退票</title>
<script src="js/jquery.js" type="text/javascript"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	background-color: #D6D6D6;
}

form {
	width: 850px;
	margin: auto;
	margin-top: 50px;
	background-color: white;
	border-radius: 12px;
}

th {
	text-align: center;
}

td {
	text-align: center;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#returnBtn").click(function() {
			location.href = "returnAdminIndex";	
		})
	})

</script>
</head>
<body>
	<form class="form-horizontal" role="form" action="" method="post">
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
					</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="form-group" >
				<div class="col-sm-offset-2 col-sm-10" style="margin-left: 760px;margin-top: 10px;height:40px;">
					<input type="button" id="returnBtn" class="btn btn-default"  value="返回">
				</div>
			</div>
</form>
</body>
</html>