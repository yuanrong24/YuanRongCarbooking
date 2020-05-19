<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>首页</title>
<style type="text/css">
div.head {
	width:100%;
	text-align:center;
	margin-top:24px;
	padding:5px;
	background:#F5F5F5;
	height:50px;
}
div.daohang{
	height:50px;
	width:100%;
	margin-top:10px;
	background:#1E90FF;
}
div.body{
	height:700px;
	width:100%;
	margin-top:10px;
}
.body_left{
	height:650px;
	/* border:1px solid black; */
	width:55%;
	margin-top:10px;
	margin-left:30px;
	float:left;
	background:url(img/beijing.jpg);
	background-size:100% 100%;
}
.body_right{
	height:650px;
	border:1px solid black; 
	width:40%;
	margin-top:10px;
	margin-right:30px;
	float:right;
}
.daohang li{
	list-style:none;
	float:left;
	width:200px;
	text-align:center;
	height:50px;

}
.li_div{
	color:white;
	height:50px;
	padding-top:15px;
}
.body_left button{
	margin-top:620px;
}
th{
	text-align:center;
}
td{
	text-align:center;
}
</style>
<script>
function background1(x)
{
	x.style.background="#4169E1";
}
function background2(x)
{
	x.style.background="#1E90FF";
}
$(document).ready(function(){
	$("#button1").click(function(){
		$(".body_left").css("background","url(img/beijing.jpg)");
		$(".body_left").css("background-size","100% 100%");
	})
	$("#button2").click(function(){
		$(".body_left").css("background","url(img/luntu1.jpg)");
		$(".body_left").css("background-size","100% 100%");
	})
	$("#button3").click(function(){
		$(".body_left").css("background","url(img/luntu2.jpg)");
		$(".body_left").css("background-size","100% 100%");
	})
	$("#button4").click(function(){
		$(".body_left").css("background","url(img/luntu3.jpg)");
		$(".body_left").css("background-size","100% 100%");
	})
	$("#addOrder").click(function(){
		//传输到后台，跳转到预定车票的界面
		location.href = "searchUserOrders";
	})
	$("#tuipiao").click(function(){
		//传输到后台，跳转到退票的界面
		location.href = "tuipiaoShow";
	})
	$("#gaiqian").click(function(){
		//传输到后台，跳转到改签的界面
		location.href = "gaiqianShow";
	})
	$("#xxcx").click(function(){
		//传输到后台，跳转到信息查询的界面
		location.href = "xxcxShow";
	})
	$("#grxx").click(function(){
		//传输到后台，跳转到个人信息查询的界面
		location.href = "grxxShow";
	})
	
	var orderResult = "${orderResult }";
	if(orderResult=="success"){
		alert("预定成功");
	}
	if(orderResult=="fail"){
		alert("已预定成功，请勿重复预订");
	}
	var editResult = "${editResult }";
	if(editResult=="success"){
		alert("修改成功");
	}
})
</script>
</head>
<body>
	<div>
		<div class="head">
			<form action="searchChePiao" method="post">
				<span style="float:left;font-size:24px;margin-left:10px;">
					汽车订票王
				</span>
				<span>
					<input type="text" class="form-control" id="firstname" name="qsdxj" placeholder="出发地(县/区级)" style="width:150px;display:inline;">&emsp;至&emsp;
					<input type="text" class="form-control" id="firstname" name="mddxj" placeholder="目的地(县/区级)" style="width:150px;display:inline;">
					<button type="submit" class="btn btn-default" name="search" >搜索</button>
				</span>
				<span style="float:right;margin-top:10px;margin-right:30px">
					<label>你好，${username }</label>&emsp;
					<a href="login" style="color:orange;text-decoration: none;" onclick="if(confirm('确认退出吗？')==false)return false">退出</a>
			    </span>
			</form>
		</div>
		<div class="daohang">
			<li><div class="li_div" id="addOrder" onmousemove="background1(this)" onmouseout="background2(this)">购票</div></li>
			<li><div class="li_div" id="tuipiao"  onmousemove="background1(this)" onmouseout="background2(this)">退票</div></li>
			<li><div class="li_div" id="gaiqian" onmousemove="background1(this)" onmouseout="background2(this)">改签</div></li>
			<li><div class="li_div" id="xxcx" onmousemove="background1(this)" onmouseout="background2(this)">信息查询</div></li>
			<li><div class="li_div" id="grxx" onmousemove="background1(this)" onmouseout="background2(this)">个人信息</div></li>
		</div>
		<div class="body">
			<div class="body_left" id="left">
				<button class="btn btn-default" id="button1" style="margin-left:10px"></button>
				<button class="btn btn-default" id="button2"></button>
				<button class="btn btn-default" id="button3"></button>
				<button class="btn btn-default" id="button4"></button>
			</div>
			<div class="body_right">
				<div style="border-bottom:1px solid black;color:white;background:#1E90FF;width:100%;height:30px;front-size:12px;padding-left:5px;padding-top:5px;">公告展示</div>
				<table class="table">
					<thead>
						<tr>
							<tr>
							<th>#</th>
							<th>公告标题</th>
							<th>发布时间</th>
							<th>操作</th>
						</tr>
						</tr>
					</thead>
					<tbody>
                   <c:forEach items="${ggs}" var="gg">
					<tr>
						<td>${gg.id}</td>
						<td>${gg.ggbt}</td>
						<td>${gg.cjsj}</td>
						<td>
						<a href="userLookGongGao?id=${gg.id}">查看</a>
						</td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="buttom" style="text-align:center;width:100%">
			版权所有©2008-2020 中国铁道科学研究院集团有限公司
		</div>
	</div>
</body>
</html>