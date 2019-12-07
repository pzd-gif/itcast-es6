<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>注册</title>

  <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
<form id="driverForm" action="/login" method="post">
	<p>手机号码<input type="text" name="phone"></p>
	<p>登录密码<input type="password" name="password"></p>
	<button type="submit" class="btn btn-primary">登录</button>
</form>
</div>
<script type="text/javascript">
	function login(){
		var driverStr = $('#driverForm').serialize();
		$.ajax({
			trpe :"POST",
			url:"/login",
			data:driverStr,
			async:false,
			dataType:"json",
			success:function(data){
				alert(data.message);
				location="/list";
			},
			error:function(){
				alert("Connection error");
			}
		});
	};
</script>
</body>
</html>