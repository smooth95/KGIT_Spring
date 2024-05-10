<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>logout페이지</h1>
	request : <%= request.getAttribute("test") %> <br>
	el : ${ test }<br>
	<a href="login">로그인</a>
	<a href="index">기본</a>
</body>
</html>