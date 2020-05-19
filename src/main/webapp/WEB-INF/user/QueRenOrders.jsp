<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认预定</title>
<script src="js/jquery.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	background-color: #D6D6D6;
}

.div_out {
	background-color: white;
	width: 600px;
	height: 400px;
	margin: auto;
	margin-top: 20px;
	border-radius: 12px;
	padding-top: 20px;
}

.form-horizontal {
	width: 500px;
	margin: auto;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	//返回按钮
	$("#returnBtn").click(function(){
		location.href = "searchUserOrders";
	})	
})

</script>
<script language="javascript">
//选择时间的空间，这里使用的是My97DatePicker
function createTime(){
WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'2019-01-01',maxDate:'%y-%M-%d'});
}
</script>
</head>
<body>
<span style="font-size:25px;display:block;width:100px;margin:auto;margin-top:100px;">确认车票</span>
	<div class="div_out">
		<form class="form-horizontal" action="orderChePiao" method="post">
		<input type="hidden" name="id" value="${xl.id }">
			<div class="form-group" style="margin-left: 80px; margin-top: 40px;">
				<label class="col-sm-2 control-label">起始地</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="goods_name"
						value="${xl.qsdsj }(${xl.qsdxj })" style="width: 200px;" readonly>
				</div>
			</div>
			<div class="form-group" style="margin-left: 80px;">
				<label class="col-sm-2 control-label">目的地</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="sex" name="type"
						value="${xl.mddsj }(${xl.mddxj })" style="width: 200px;" readonly>
				</div>
			</div>

			<div class="form-group" style="margin-left: 80px;">
				<label class="col-sm-2 control-label">发车时间</label>
				<div class="col-sm-10">
					<input type="text" class="form-control"  id="countTimestart" onclick="createTime()" name="fcsj"
						value="${xl.fcsj }" style="width: 200px;" readonly>
				</div>
			</div>
			<div class="form-group" style="margin-left: 80px;">
				<label class="col-sm-2 control-label">时&emsp;长</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="sc"
						value="${xl.sc }" style="width: 200px;" readonly>
				</div>
			</div>
			<div class="form-group" style="margin-left: 80px;">
				<label class="col-sm-2 control-label">价格</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="age" name="jg"
						 value="${xl.jg }元" style="width: 200px;" readonly>
				</div>
			</div>
			<div class="form-group" style="margin-left: 80px;">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">确认</button>
					<input type="button" id="returnBtn" class="btn btn-default" value="返回">
				</div>
			</div>
		</form>
	</div>
</body>
</html>