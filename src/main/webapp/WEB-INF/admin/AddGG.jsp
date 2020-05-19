<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="jquery-1.3.1.js" ></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>增加公告</title>
</head>
<style>
.form_div{
	width:600px;
	height:500px;
	text-align:center;
	margin:auto;
	margin-top:10px;
	background-color:white;
	border:1px solid black;border-radius:16px;
}
#form1{
	height:200px;
	width:450px;
	margin-left:50px;
	margin-top:50px;
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
			location.href = "returnAdminIndex";
		})
		//在前台界面判断文本框的值是否符合条件
		$("form").submit(function() {
		var ggbt = $("#ggbt").val();
		var cjsj = $("#cjsj").val();
		var ggnr = $("#ggnr").val();
		if (ggbt == "") {
			alert("公告标题不能为空！");
			return false;
		}
		if (cjsj == "") {
			alert("创建时间不能为空！");
			return false;
		}
		if (ggnr == "" ) {
			alert("公告内容不能为空！");
            return false;
		}
		
		
	})
	})
</script>
<script language="javascript">
//选择时间的空间，这里使用的是My97DatePicker
function createTime(){
WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'2019-01-01',maxDate:'%y-%M-%d'});
}
</script>
<body style="background-color:#D6D6D6">
	<span style="font-size:25px;display:block;width:100px;margin:auto;margin-top:100px;">增加公告</span>
	<c:if test="${type=='A'}">
	<div class="form_div">
		<form action="addGonggao"  class="form-horizontal" method="post" id="form1">
		<div class="form-group">
			<label class="col-sm-2 control-label">标题</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="ggbt" name="ggbt"  placeholder=" 公告标题"  value="${gg.ggbt }" style="width:370px;"/>
			</div>
		</div>
		<div class="form-group" >
				<label class="col-sm-2 control-label">时间</label>
				<div class="col-sm-10">
					<input type="text" class="form-control"  id="cjsj" onclick="createTime()" name="cjsj"
						placeholder="请输入时间 " value="${gg.cjsj }" style="width:370px;">
				</div>
			</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">内容</label>
			<div class="col-sm-10">
				<textarea  class="form-control"  rows="10" cols="10" name="ggnr" id="ggnr">${gg.ggnr }</textarea>
			</div>
		</div>
			<button type="submit" class="btn btn-default edit">增加</button>&emsp;
			<input type="reset"  class="form-control"id="chongzhi" class="reset" style="width:54px;display:inline;">
			<input type="button" id="return" class="btn btn-default return" value="返回"  style="display:inline;">
		</form>
	</div>
</c:if>
<c:if test="${type=='C'}">
	<div class="form_div">
		<form action="editGonggao"  class="form-horizontal" method="post" id="form1">
		<input type="hidden" name="id" value="${gg.id }">
		<div class="form-group">
			<label class="col-sm-2 control-label">标题</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="ggbt" name="ggbt"  placeholder=" 公告标题"  value="${gg.ggbt }" style="width:370px;"/>
			</div>
		</div>
		<div class="form-group" >
				<label class="col-sm-2 control-label">时间</label>
				<div class="col-sm-10">
					<input type="text" class="form-control"  id="cjsj" onclick="createTime()" name="cjsj"
						placeholder="请输入时间 " value="${gg.cjsj }" style="width:370px;">
				</div>
			</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">内容</label>
			<div class="col-sm-10">
				<textarea  class="form-control"  rows="10" cols="10" name="ggnr" id="ggnr">${gg.ggnr }</textarea>
			</div>
		</div>
			<button type="submit" class="btn btn-default edit">修改</button>&emsp;
			<input type="reset"  class="form-control"id="chongzhi" class="reset" style="width:54px;display:inline;">
			<input type="button" id="return" class="btn btn-default return" value="返回"  style="display:inline;">
		</form>
	</div>
</c:if>
</body>
</html>