<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车票购买</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.js"></script>

<style type="text/css">
body {
background-color:#D6D6D6;
}
div.head {
	width:850px;
	margin:auto;
	text-align:center;
	margin-top:50px;
	padding:5px;
	background:white;
	height:50px;
	border-top-right-radius:12px;
	border-top-left-radius:12px;
}
.table{
	width:850px;
	margin:auto;
	background-color:white;
	border-bottom-right-radius:12px;
	border-bottom-left-radius:12px;

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
	$("#buy").click(function(){
		
	})
})

</script>
</head>
<body>
<div class="head">
			<form action="" method="post">
				<span>
					<input type="text" class="form-control" id="firstname" name="" placeholder="请输入出发地" style="width:150px;display:inline;">&emsp;至&emsp;
					<input type="text" class="form-control" id="firstname" name="" placeholder="请输入目的地" style="width:150px;display:inline;">
					<button type="submit" class="btn btn-default" name="search" >搜索</button>
				</span>
			</form>
		</div>
<table class="table">
		<thead>
			<tr>
				<th>ID</th> <!-- 查询出所有的车票list -->
				<th>起始地</th>
				<th>目的地</th>
				<th>里程数</th>
				<th>车程</th>
				<th>发车时间</th>
				<th>价格</th>
				<!-- <th>身份证号</th> -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>济南市历下区</td>
				<td>青岛市黄岛区</td>
				<td>300km</td>
				<td>3小时</td>
				<td>2020-04-08 20:48</td>
				<td>50</td>
				<!-- <td>12小时</td> -->
				<td>
					<button type="button" class="btn btn-default" style="margin-top:-5px" id="buy">购买</button>
				</td>					
			</tr>
		</tbody>
	</table>
</body>
</html>