<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/daumPost.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/default/header.jsp" %>
	<h3> - 회 원 가 입 - ${path } </h3>
	<form action="register" method="post">
		<input type="text" name="id"><br>
		<input type="text" name="pwd"><br>
		<input type="text" id="addr1" name="addr" readonly placeholder="우편번호"><br>
		<input type="text" id="addr2" name="addr" readonly placeholder="주소"><br>
		<input type="text" id="addr3" name="addr" placeholder="상세주소">
		<button type="button" onclick="daumPost()">우편번호검색</button>
		<br>
		<input type="submit" value="가입"><br>
	</form>
</body>
</html>




