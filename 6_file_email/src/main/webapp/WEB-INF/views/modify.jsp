<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify" method="post" enctype="multipart/form-data">
		<input type="text" name="id" value="${info.id }"><br>
		<input type="text" name="name" value="${info.name }"><br>
		<input type="text" name="originFile" value="${info.imgName }" hidden><br>
		<input type="file" name="changeFile"><br>
		<input type="submit" value="전송">
	</form>
	<a href="views">파일 보기</a>
</body>
</html>