<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>后台管理</title>
<script src="js/jquery.js" type="text/javascript"></script>
<style>
.head{
	margin-top:10px;
	height:50px;
	width:100%;
}
body{
	margin-top:10px;

	width:100%;
	background-color:#F5F5F5;

}
li{
	float:left;
	color:white;
	height:50px;
	width:200px;
	text-align:center;
	list-style:none;
	border-left:1px solid white;
}
li:hover{
	float:left;
	color:white;
	height:50px;
	width:200px;
	text-align:center;
	list-style:none;
	border-left:1px solid white;
	background-color:#337ab7;
}
.daohang{
	height:50px;
	width:100%;
	background-color:#00acec;
	border-radius:7px;
}
.on{
	display:true;
	border:1px solid black;border-radius:12px;
	height:500px;
	width:70%;margin:auto;
	margin-top:10px;
	background-color:white;
}
.out{
	display:none;
}
td{
	text-align:center;

}
button{
	display: inline-block;
	background-color: #fff;
    padding: 6px 12px;
    margin-bottom: 0;
    font-size: 14px;
    font-weight: 400;
    line-height: 1.42857143;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    touch-action: manipulation;
    cursor: pointer;
    user-select: none;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#li_pwgl").click(function(){
		debugger
		$("[name='div3']").attr("class","out");
		$("#pwgl").attr("class","on");
		//location.href = "piaoWuGuanLiShow";
	})
	$("#li_ddgl").click(function(){
		$("[name='div3']").attr("class","out");
		$("#ddgl").attr("class","on");
	})
	$("#li_yhgl").click(function(){
		$("[name='div3']").attr("class","out");
		$("#yhgl").attr("class","on");
	})
	$("#li_gggl").click(function(){
		$("[name='div3']").attr("class","out");
		$("#gggl").attr("class","on");
	})
	$("#addXianLu").click(function(){
		//传输到后台，跳转到增加线路的界面
		location.href = "addXianLuShow";
	})
	$("#editXianLu").click(function(){
		//传输到后台，跳转到修改线路的列表信息展示界面
		location.href = "editXianLuLBShow";
	})
	$("#delXianLu").click(function(){
		//传输到后台，跳转到删除线路界面
		location.href = "delXianLuShow";
	})
	$("#weiHuChePiao").click(function(){
		//传输到后台，跳转到删除线路界面
		location.href = "weiHuChePiao";
	})
	$("#addUser").click(function(){
		//传输到后台，跳转到增加用户界面
		location.href = "addUserShow";
	})
	$("#editUser").click(function(){
		//传输到后台，跳转到修改用户界面
		location.href = "editUserShow";
	})
	$("#delUser").click(function(){
		//传输到后台，跳转到删除用户的界面
		location.href = "delUserShow";
	})
	$("#searchUserSign").click(function(){
		//传输到后台，跳转到删除用户的界面
		location.href = "searchUserSignShow";
	})
	
})
//增加线路的弹窗				
var ZJXLresult = "${ZJXLresult }";
if(ZJXLresult=="success"){
	alert("增加成功");
}
if(ZJXLresult=="fail"){
	alert("增加失败");
}
var editResult = "${editResult }";
if(editResult=="success"){
	alert("修改成功");
}
var addUserResult = "${addUserResult }";
if(addUserResult=="success"){
	alert("新增成功");
}
</script>
</head>
<body>
	<div class="head">
		<span style="font-size:35px;margin-left:10px;"><b>订票王管理页面</b></span>
		<span style="float:right;font-size:14px;margin-top:30px;"><label>你好，管理员</label>&emsp;
					<a href="" style="color:orange;text-decoration: none;">退出&emsp;&emsp;</a></span>
	</div>
	<div class="body">
		<div class="daohang">
			<ul style="margin:auto;width:810px">
				<li id="li_pwgl"><span style="display:block;margin-top:10px">票务管理</span></li>
				<li id="li_ddgl"><span style="display:block;margin-top:10px" >订单管理</span></li>
				<li id="li_yhgl"><span style="display:block;margin-top:10px">用户管理</span></li>
				<li id="li_gggl" style="border-right:1px solid white;"><span style="display:block;margin-top:10px;">公告管理</span></li>
			</ul>
		</div>
		<div id="pwgl" class="on" name="div3">
			<div id="addXianLu"style="float:left;margin-top:100px;margin-left:380px;cursor:pointer;" >
				<div style="background-color:green;width:250px;height:60px;border-radius:7px 7px 0 0;"><img src="img/xianlu.png" style="margin-left:90px;height:60px;width:60px"/></div>
				<div style="background-color:#CCCCCC;width:250px;height:26px;font-size:15px;text-align:center;padding-top:5px;border-radius:0 0 7px 7px;">
					增加线路
				</div>
			</div>
			<div id="editXianLu" style="float:left;margin-top:100px;margin-left:100px;cursor:pointer;">
				<div style="background-color:yellow;width:250px;height:60px;border-radius:7px 7px 0 0;"><img src="img/xianlu.png" style="margin-left:90px;height:60px;width:60px"/></div>
				<div style="background-color:#CCCCCC;width:250px;height:26px;font-size:15px;text-align:center;padding-top:5px;border-radius:0 0 7px 7px;">
					修改线路
				</div>
			</div>
			<div id="delXianLu" style="float:left;margin-top:50px;margin-left:380px;cursor:pointer;">
				<div style="background-color:red;width:250px;height:60px;border-radius:7px 7px 0 0;"><img src="img/xianlu.png" style="margin-left:90px;height:60px;width:60px"/></div>
				<div style="background-color:#CCCCCC;width:250px;height:26px;font-size:15px;text-align:center;padding-top:5px;border-radius:0 0 7px 7px;">
					删除线路
				</div>
			</div>
			<div id="weiHuChePiao" style="float:left;margin-top:50px;margin-left:100px;cursor:pointer;">
				<div style="background-color:#00acec;width:250px;height:60px;border-radius:7px 7px 0 0;"><img src="img/chepiao.png" style="margin-left:90px;height:60px;width:60px"/></div>
				<div style="background-color:#CCCCCC;width:250px;height:26px;font-size:15px;text-align:center;padding-top:5px;border-radius:0 0 7px 7px;">
					车票维护
				</div>
			</div>
		</div>
		<div id="ddgl" class="out" name ="div3">
			查询出订单list，最后一列的操作有修改和删除
		</div>
		<div id="yhgl" class="out" name="div3"> 
			<div id="addUser" style="float:left;margin-top:100px;margin-left:380px;cursor:pointer;" >
				<div style="background-color:green;width:250px;height:60px;border-radius:7px 7px 0 0;"><img src="img/yonghu.png" style="margin-left:90px;height:60px;width:60px"/></div>
				<div style="background-color:#CCCCCC;width:250px;height:26px;font-size:15px;text-align:center;padding-top:5px;border-radius:0 0 7px 7px;">
					增加用户
				</div>
			</div>
			<div id="editUser" style="float:left;margin-top:100px;margin-left:100px;cursor:pointer;">
				<div style="background-color:yellow;width:250px;height:60px;border-radius:7px 7px 0 0;"><img src="img/yonghu.png" style="margin-left:90px;height:60px;width:60px"/></div>
				<div style="background-color:#CCCCCC;width:250px;height:26px;font-size:15px;text-align:center;padding-top:5px;border-radius:0 0 7px 7px;">
					修改信息
				</div>
			</div>
			<div id="delUser" style="float:left;margin-top:50px;margin-left:380px;cursor:pointer;">
				<div style="background-color:red;width:250px;height:60px;border-radius:7px 7px 0 0;"><img src="img/yonghu.png" style="margin-left:90px;height:60px;width:60px"/></div>
				<div style="background-color:#CCCCCC;width:250px;height:26px;font-size:15px;text-align:center;padding-top:5px;border-radius:0 0 7px 7px;">
					删除用户
				</div>
			</div>
			<div id="searchUserSign" style="float:left;margin-top:50px;margin-left:100px;cursor:pointer;">
				<div style="background-color:#00acec;width:250px;height:60px;border-radius:7px 7px 0 0;"><img src="img/yonghu.png" style="margin-left:90px;height:60px;width:60px"/></div>
				<div style="background-color:#CCCCCC;width:250px;height:26px;font-size:15px;text-align:center;padding-top:5px;border-radius:0 0 7px 7px;">
					查看记录
				</div>
			</div>
		</div>
		<div id="gggl" class="out" name="div3"> 
			<button style="float:right;margin-top:20px;margin-right:30px;margin-bottom:20px;">增加公告</button>
				<table class="table" style="width:100%;">
					<thead>
						<tr>
							<th>ID</th>
							<th>公告名称</th>
							<th>发布时间</th>
							<th>发布者</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
<%-- 						<%
							for (;;) {
						%> --%>
					<tr>
						<td>1</td>
						<td><a href="" style="text-decoration: none;">汽车订票王开始订票啦！</a></td>
						<td>2020-04-02</td>
						<td>管理员</td>
						<td><a src="">删除</a></td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="" style="text-decoration: none;">11汽车订票王开始订票啦！</a></td>
						<td>2020-04-02</td>
						<td>管理员</td>
						<td><a src="">删除</a></td>
					</tr>
<%-- 					<%
						}
					%> --%>
					</tbody>
				</table>
			</div>
		</div>

</body>
</html>