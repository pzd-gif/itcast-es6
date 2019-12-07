<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title></title>
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div align="center" style="padding:10px 0;">
	欢迎${driver.name},您是${driver.driveType}驾驶证,可以准驾以下车型
</div>
<div>
	<ul style="list-style-type:none">
		<c:forEach items="${cars }" var="car">
			<li style="float: left;width: 25%;padding: 10px 0;">
				<div>
					<img alt="${car.name }" src="${car.picUrl }" width="300" height="200">
				</div>
				<div>
					<strong>${car.name }</strong>
				</div>
				<div>
					<strong>${car.trademark }</strong>
				</div>
				<div>
					<em>￥</em><strong>${car.rent }</strong>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>