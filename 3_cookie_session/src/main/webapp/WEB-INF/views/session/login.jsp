<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${ loginUser == null }">
			<form action="check" method="post">
				<input type="text" name="id"><br>
				<input type="text" name="pwd"><br>
				<input type="submit" value="로그인"><br>
			</form>			
		</c:when>
		<c:otherwise>
			${ nick } 님 로그인 상태<br>
			<a href="logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
</body>
</html>