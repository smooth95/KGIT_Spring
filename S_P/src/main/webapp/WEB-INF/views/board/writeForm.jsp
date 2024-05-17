<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function back() {
		location.href="allList"
	}
	function changeImg(input) {
		console.log(input.files)
		var reader = new FileReader();
		reader.readAsDataURL(input.files[0]);
		reader.onload = function (e) {
			$("#img").attr('src', e.target.result);
		}
	}
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/default/header.jsp" %>
글작성 페이지입니다.

<div>
	<form action="writeSave" method="post" enctype="multipart/form-data">
		<b>작성자</b><br>
		<input type="text" name="id">
		<hr>
		<b>제목</b><br>
		<input type="text" name="title">
		<hr>
		<b>내용</b><br>
		<textarea name="content"></textarea>
		<hr>
		<b>이미지 파일 첨부</b><br>
		<input type="file" name="file" onchange="changeImg(this)">
		<img width="100" id="img" height="100" src="">
		<hr>
		<input type="submit" value="글쓰기">
		<input type="button" onclick="back()" value="목록보기">
	</form>
</div>
</body>
</html>