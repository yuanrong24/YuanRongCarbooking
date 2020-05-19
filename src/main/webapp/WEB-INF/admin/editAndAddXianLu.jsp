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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>维护线路</title>
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
	margin-left:100px;
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
		var qsdsj = $("#qsdsj").val();
		var qsdxj = $("#qsdxj").val();
		var mddsj = $("#mddsj").val();
		var mddxj = $("#mddxj").val();
		var lcs = $("#lcs").val();
		var sc = $("#sc").val();
		var cx = $("#cx").val();
		if (qsdsj == "") {
			alert("起始地(市级)不能为空！");
			return false;
		}
		if (qsdxj == "") {
			alert("起始地（县级）不能为空！");
			return false;
		}
		if (mddxj == "") {
			alert("目的地（县级）不能为空！");
			return false;
		}
		if (mddsj == "" ) {
			alert("目的地（市级）不能为空！");
            return false;
		}
		if (lcs == "" ) {
			alert("里程数不能为空！");
            return false;
		}
		if (sc == "" ) {
			alert("车型不能为空！");
            return false;
		}
		if (cx == "" ) {
			alert("时长不能为空！");
            return false;
		}
		
	})
	})
</script>
<body style="background-color:#D6D6D6">
	<span style="font-size:25px;display:block;width:100px;margin:auto;margin-top:50px;">维护线路</span>
	<c:if test="${type eq 'C'}">
	<div class="form_div">
		<form action="addXianLu"  class="form-horizontal" method="post" id="form1">
		<div class="form-group">
			<label class="col-sm-2 control-label">起始地</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="qsdsj" name="qsdsj"  placeholder=" 市级"  style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="qsdxj" name="qsdxj" placeholder=" 县级（区级）" style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">目的地</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="mddsj" name="mddsj"  placeholder=" 市级"  style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="mddxj" name="mddxj" placeholder=" 县级（区级）"  style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">里程数</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="lcs" name="lcs"  style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">车&emsp;型</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="cx" name="cx"  style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">时&emsp;长</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="sc" name="sc"  style="width:250px;"/>
			</div>
		</div>
			<button type="submit" class="btn btn-default edit">增加</button>&emsp;
			<input type="reset"  class="form-control"id="chongzhi" class="reset" style="width:54px;display:inline;">
			<input type="button" id="return" class="btn btn-default return" value="返回"  style="display:inline;">
		</form>
	</div>
	</c:if>
	<c:if test="${type eq 'U'}">
	<div class="form_div">
		<form action="editXianLu"  class="form-horizontal" method="post" id="form1">
		<input type="hidden" name="id" value="${xl.id }">
		<div class="form-group">
			<label class="col-sm-2 control-label">起始地</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="qsdsj" name="qsdsj"  placeholder=" 市级"  value="${xl.qsdsj }" style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="qsdxj" name="qsdxj" placeholder=" 县级（区级）" value="${xl.qsdxj }" style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">目的地</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="mddsj" name="mddsj"  placeholder=" 市级" value="${xl.mddsj }" style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="mddxj" name="mddxj" placeholder=" 县级（区级）"  value="${xl.mddxj }" style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">里程数</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="lcs" name="lcs" value="${xl.lcs }" style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">车&emsp;型</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="cx" name="cx" value="${xl.cx }" style="width:250px;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">时&emsp;长</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="sc" name="sc"  value="${xl.sc }" style="width:250px;"/>
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