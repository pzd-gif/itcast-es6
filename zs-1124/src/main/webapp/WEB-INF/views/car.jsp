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
<div align="center">
	<div align="center">
		<form id="carForm" enctype="multipart/form-data">
			<input type="hidden" name="id" id="id" value="${car.id }">
				<div>
					<p>
						车辆名称:<input type="text" name="name" value="${car.name }">
					</p>
					<p>
						车辆品牌:<input type="text" name="trademark" value="${car.trademark }">
					</p>
					<p>
						日租金:<input type="text" name="rent" value="${car.rent }"> 
					</p>
					<p>
					<c:if test="${not empty car.picUrl }">
						<span><img alt="图片预览" src="${car.picUrl }" height="50"></span>
					</c:if>
					上传图片：<input type="file" name="file" id="picUrl">
					</p>
					<p>
						要求最低驾照:<select name="carType">
							<c:forEach items="${types }" var="type">
								<option value="${type.code }">${type.code }</option>
							</c:forEach>
						</select>
					</p>
					<p>
						<button type="button" id="carBth">提交
						</button>
					</p>
				</div>			
		</form>
	</div>
</div>
<script type="text/javascript">
	$("#carBth").click(function(){
		var data = new FormData($('#carForm')[0]);
		$.each($('picUrl')[0].files,function(i,file){
			data.append('file',file);
		});
		$.ajax({
			type:POST,
			url:"/publish",
			data:data,
			async:false,
			contentType:false,
			processData:false,
			dataType:"json",
			success:function(data){
				alert(data.message);
				location = "/toPublish";
			},
			error : function(){
				alert("Connection error");
			}
		});
	});
	
</script>
</body>
</html>