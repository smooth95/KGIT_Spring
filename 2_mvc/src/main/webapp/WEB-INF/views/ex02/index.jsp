<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index페이지</h1>
	msg : ${ msg }
	<h1>get 전송</h1>
	<form action="result">
		이름 : <input type="text" name="name" ><br>
		나이 : <input type="text" name="age" ><br>
		<input type="submit" value="전송"><br>
	</form>
	<h1>post object 전송</h1>
	<form action="object" method="post">
		이름 : <input type="text" name="name" ><br>
		나이 : <input type="text" name="age" ><br>
		<input type="submit" value="전송"><br>
	</form>
</body>
</html>