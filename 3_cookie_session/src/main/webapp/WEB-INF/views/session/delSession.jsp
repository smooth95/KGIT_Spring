<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>delSession Page</h1>
	id : ${ id }<br>
	sessionScope.id : ${ sessionScope.id }<br>
	name : ${ name }<br>
	age : ${ age }<br>
	req.age : <%= session.getAttribute("age") %><hr>
	<a href="makeSession">세션 설정</a>
	<a href="resultSession">세션 확인</a>

</body>
</html>