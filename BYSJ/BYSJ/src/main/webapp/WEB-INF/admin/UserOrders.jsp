<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户订单信息</title>
<script type="text/javascript" src="jquery-1.3.1.js" ></script>
<link href="bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
background-color:#D6D6D6;
}
.table{
	width:850px;
	margin:auto;
	margin-top:50px;
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
$(document).ready(function(){
	$("#update").click(function(){
	})
})
</script>
</head>
<body>
<form class="form-horizontal"  role="form" action="" method="post">
<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>性别</th>
				<th>手机号</th>
				<th>起始地</th>
				<th>目的地</th>
				<th>发车时间</th>
				<!-- <th>身份证号</th> -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>王二</td>
				<td>女</td>
				<td>12345678910</td>
				<td>起始地</td>
				<td>目的地</td>
				<td>2020.04.20 15:30</td>
				<!-- <td>12小时</td> -->
				<td>
					<button type="button" class="btn btn-default" style="margin-top:-5px" id="delete">删除</button>
				</td>					
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>