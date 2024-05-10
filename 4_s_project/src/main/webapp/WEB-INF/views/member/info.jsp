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
<%@ include file="../default/header.jsp" %>
	<div align="center">
	<h3>${ user.get(0).getId() } 정 보</h3>
		<table border="1px">
			<tbody>
					<tr>
						<td>아이디</td>
						<td>${ user.get(0).id }</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>${ user.get(0).pw }</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>${ user.get(0).addr }</td>
					</tr>
			</tbody>
		</table>
	</div>

<%@ include file="../default/footer.jsp" %>

</body>
</html>