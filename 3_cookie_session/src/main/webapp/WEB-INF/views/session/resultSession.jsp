<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>resultSession Page</h1>
	id : ${ id }<br>
	sessionScope.id : ${ sessionScope.id }<br>
<!-- 	model이 범위가 더 적기때문에 세션과 model값이 같을 경우 model의 데이터가 출력된다. 
		값이 같을 경우 세션값을 가져오고싶을때 sessionScope를 사용한다.-->
	name : ${ name }<br>
	age : ${ age }<br>
	req.age : <%= session.getAttribute("age") %><hr>
	<a href="makeSession">세션 설정</a>
	<a href="delSession">세션 삭제</a>
</body>
</html>