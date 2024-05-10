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
	meminfo<hr>
	size : ${ arr.size() }
	<table border="1">
		<thead>
			<th>id</th>
			<th>pwd</th>
			<th>name</th>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${ arr.size() != 0 }">
					<c:forEach var="arr1" items="${ arr }">
						<tr>
							<td>${ arr1.getId() }</td>
							<td>${ arr1.getPwd() }</td>
							<td>${ arr1.getName() }</td>
						</tr>
					</c:forEach>				
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="3">데이터가 없음!!!</td>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="3"><a href="member">메인페이지</a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>