<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
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
모디파이폼페이지
<form action="modify" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writeNo" value="${dto.writeNo }">
	<input type="hidden" name="originName" value="${dto.imageFileName }">
	제목 : <input type="text" name="title" value="${dto.title }"><br>
	내용 : <textarea rows="" cols="" name="content">${dto.content }</textarea>
	<br>
	<img id="img" src="download?fileName=${dto.imageFileName }" width="100"><br>
	<input type="file" name="imageFileName" onchange="changeImg(this)"><br>
	<input type="submit" value="수정">
	<input type="button" onclick="history.back()" value="이전">
</form>

</body>
</html>