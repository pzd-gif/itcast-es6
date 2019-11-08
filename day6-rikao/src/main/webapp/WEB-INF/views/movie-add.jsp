<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Document</title>

<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div>
		<form id="movieForm">
		<input type="hidden" id="categoryIds" name="categoryIds">
			<table class="table">
				<tr>
					<td><span>电影名称：</span></td>
					<td><input type="text" name="name"></td>
				</tr>
				
				<tr>
					<td><span>电影描述：</span></td>
					<td><input type="text" name="description"></td>
				</tr>
				<br/>
				<tr>
					<td><span>导演：</span></td>
					<td><input type="text" name="director"></td>
				</tr>
				<tr>
					<td id="category"><span>分类：</span></td>
					<c:forEach items="${categories }" var="category">
						<td><input type="checkbox" class="categoryId" value="${category.id }">${category.name }</td>
					</c:forEach>
				</tr>
				<tr>
					<td><span>发行日期：</span></td>
					<td><input type="text" name="issuingDate"></td>
				</tr>
			</table>
			<button id="saveBtn" type="button" onclick="add()" class="btn btn-primary">保存</button>
		</form>
	</div>
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
			function add() {
				//多选框
				var check_value =[];  
				  $('.categoryId:checked').each(function(){  
					  check_value.push($(this).val());
				  });
				  //多选框的值传递给隐藏域，返回到后台
				  $('#categoryIds').val(check_value);
				var movieStr=$('#movieForm').serialize();
				$.ajax({
					type : "POST", //提交的方法
					url : "/add", //提交的地址  
					data : movieStr,// 序列化表单值  
					async : false,
					dataType:"json",
					success : function(data) { //成功
						alert(data.message); //就将返回的数据显示出来
						//添加成功后刷新页面
						location = "/";
					},
				error : function() { //失败的话
					alert("Connection error");
				}
				});
			};
	</script>
</body>
</html>