<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
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
	height: 500px;
	margin: auto;
	margin-top: 60px;
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
		$(".form-control").removeAttr("readonly");
		$("#save").css("display","");
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
	<div class="div_out">
		<form class="form-horizontal" action="editChePiao" method="post">
		<input type="hidden" name="id" value="${xl.id }">
			<div style="margin:auto;width:100px;">
				<img style="width:100px;height:100px" src="tx.png">
			</div>
			<div class="form-group" style="margin-left: 80px; margin-top: 40px;">
				<label class="col-sm-2 control-label">姓&emsp;名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="请输入姓名 " value="" style="width: 200px;" readonly>
				</div>
			</div>
			<div class="form-group" style="margin-left: 80px;">
				<label class="col-sm-2 control-label">性&emsp;别</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="sex" name="sex"
						placeholder="请输入性别" value="1" style="width: 200px;" readonly>
				</div>
			</div>

			<div class="form-group" style="margin-left: 80px;">
				<label class="col-sm-2 control-label">年&emsp;龄</label>
				<div class="col-sm-10">
					<input type="text" class="form-control"  id="age" name="age"
						placeholder="请输入年龄 " value="1" style="width: 200px;" readonly> 
				</div>
			</div>
			<div class="form-group" style="margin-left: 80px;">
				<label class="col-sm-2 control-label">手机号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="sc"
						placeholder="请输入手机号 " value="" style="width: 200px;" readonly>
				</div>
			</div>
			<div class="form-group" style="margin-left: 80px;">
				<label class="col-sm-2 control-label">身份证</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="age" name="jg"
						placeholder="请输入身份证" value="" style="width: 200px;" readonly>
				</div>
			</div>
			<div class="form-group" style="margin-left: 80px;">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" id="returnBtn" class="btn btn-default" value="修改信息">
					<button type="submit" class="btn btn-default" id="save" style="display:none">保存</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>