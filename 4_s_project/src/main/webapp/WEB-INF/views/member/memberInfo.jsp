<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	if ("${id}" == ""){
		location.href="/root/member/login"
	}

</script>
</head>
<body>
<%@ include file="../default/header.jsp" %>
	<div align="center">
	<h3>회 원 정 보</h3>
	${id }
		<table border="1px">
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${ member }">
					<tr>
						<td><a href="/root/member/info?id=${item.getId()}">${ item.getId() }</a></td>
						<td>${ item.getPw() }</td>
						<td>${ item.getAddr() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<label onclick="test()">test</label>
	</div>


<%@ include file="../default/footer.jsp" %>

</body>
</html>