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
<title>公告查看</title>
</head>
<style>
.div_out{
	display:block;
	width:50%;
	height:500px;
	text-align:center;
	margin:auto;
	margin-top:10px;
	background-color:white;
	border:1px solid black;border-radius:16px;
}
.table{
	
	border:none;
}

.reset{
    margin-left:0px;
}
.return{
    margin-left:15px;
}
.edit{
    margin-left:-30px;
  }
</style>
<script>
	$(document).ready(function(){
		//返回首页
		$("#return").click(function(){
			location.href = "returnBtnUserIndex";
		})
	})
</script>
<body style="background-color:#D6D6D6">
	<span style="font-size:25px;display:block;width:100px;margin:auto;margin-top:100px;">公告查看</span>
	<div class="div_out">
	<table class="table" style="border:0;width:370px;margin-left:320px;margin-top:50px">
		<tr height="50px" >		
			<td align="left" style="width:50px">标题</td>
			<td align="left">${gg.ggbt}</td>
		</tr>
		<tr height="50px" >
			<td align="left" style="width:50px">时间</td>
			<td align="left">${gg.cjsj}</td>
		</tr>
		<tr height="50px" rowspan="10" >
			<td align="left" rowspan="10" style="width:50px">内容</td>
			<td align="left">${gg.ggnr}</td>
		<tr>
	</table>
		<input type="button" id="return" class="btn btn-default"  style="float:right;margin-right:250px" value="返回">
	</div>
</body>
</html>