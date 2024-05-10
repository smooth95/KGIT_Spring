<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>object</h1>
	dto : ${ dto }<br>
	name : ${ dto.name }<br>
	age : ${ dto.getAge() }<br>
	<a href="index">index이동</a>
</body>
</html>