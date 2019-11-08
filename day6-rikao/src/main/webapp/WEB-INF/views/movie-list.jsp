<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>电影列表</title>

<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div>
		<table class="table">
			<tr>
				电影名称：
				<input type="text" id="name" name="name">
				<button type="button" id="searchBtn" class="btn btn-primary">搜索</button>
				&nbsp;&nbsp;
				<a href="/toAdd"><button type="button" class="btn btn-primary">添加</button></a>
				&nbsp;&nbsp;
				<button id="batchRemoveBtn" type="button" class="btn btn-primary">批量删除</button>
			</tr>
			<tr>
				<th><input type="checkbox" id="selectAllBox">全选&nbsp;&nbsp;<a href="javascript:" id="reverse-select">反选</a></th>
				<th>电影名称</th>
				<th>剧情介绍</th>
				<th>导演</th>
				<th>电影分类</th>
				<th>发行日期</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${movies }" var="movie">
				<tr>
					<td><input type="checkbox" class="idSearchBox" value="${movie.id }"></td>
					<td>${movie.name }</td>
					<td>${movie.description }</td>
					<td>${movie.director }</td>
					<td>${movie.categoryNames }</td>
					<td>${movie.issuingDate}</td>
					<td><a href="/toUpdate?id=${movie.id }">编辑</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="remove(${movie.id})">删除</a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="7"><button id="firstBtn" type="button" class="btn btn-primary">首页</button>&nbsp;&nbsp;<button type="button" id="preBtn" class="btn btn-primary">上一页</button>&nbsp;&nbsp;<button type="button" id="nextBtn" class="btn btn-primary">下一页</button>&nbsp;&nbsp;<button type="button" id="lastBtn" class="btn btn-primary">末页</button></td></tr>
		</table>
	</div>
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(function(){
		var currentPage = ${currentPage};
		var last = ${pages};
		$('#selectAllBox').click(function(){
			if($(this).is(":checked")){
				$('.idSearchBox').prop('checked',true);
			}else{
				$('.idSearchBox').prop('checked',false);
			}
		})
		$('#reverse-select').click(function(){
			$('.idSearchBox').each(function(){
				$(this).is(":checked")?$(this).prop('checked',false):$(this).prop('checked',true);
			})
		})
		$('#searchBtn').click(function(){
		var name = $('#name').val();
		location="/?name="+name;
	})
	
		$('#firstBtn').click(function() {
				location = "/?pageNo=1";
			});
		$('#preBtn').click(function(){
			if(currentPage ==1){
				location="/?pageNo=1";
			}else if(currentPage<=last){
				location="/?pageNo="+(currentPage-1);
			}
		});
		$('#nextBtn').click(function(){
			if(last == 1){
				location="/?pageNo=1";
			}else if(currentPage <last){
				location="/?pageNo="+(currentPage+1);
			}else if(currentPage==last){
				location="/?pageNo="+currentPage;
			}
		})
		$('#lastBtn').click(function(){
			location="/?pageNo="+last;
		})
		$('#batchRemoveBtn').click(function(){
			var checkedList = $('.idSearchBox:checked');
			if(checkedList.length==0){
				alert("请选择要删除的影片信息");
			}else{
				var removeUrl = "/remove?"
					checkedList.each(function(){
						var id = $(this).val();
						removeUrl+="id="+id+"&"
					})
					removeUrl = removeUrl.substring(0,removeUrl.length-1);
				if(confirm("您是否要删除这些影片？")){
					$.ajax({
						url:removeUrl,
						type:'get',
						timeout:3000,
						async:false,
						dataType:'json',
					success:function(data){
							alert(data.message);
						location="/";
					}
					})
				}
			}
		})
		})
		function remove(id){
			var removeUrl = "/remove?id="+id;
			if(confirm("您是否要删除此影片？")){
				$.ajax({
					url:removeUrl,
					type:'get',
					timeout:3000,
					async:false,
					dataType:'json',
					success:function(data){
						alert(data.message);
						location="/";
					}
				})
			}
	}
	</script>
</body>
</html>