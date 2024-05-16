<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/default/header.jsp" %>
	<h3>login 페이지</h3>
	<form action="user_check" method="post">
		<input type="text" name="id"><br>
		<input type="text" name="pwd"><br>
		<input type="submit" value="로그인" ><br>
		<input id="auto" type="checkbox" name="autoLogin">
		<label for="auto">자동 로그인</label>
	</form>
	<a href="register_form">회원가입</a>

</body>
</html>






