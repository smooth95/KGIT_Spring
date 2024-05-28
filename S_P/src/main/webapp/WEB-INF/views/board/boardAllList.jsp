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
<%@ include file="/WEB-INF/views/default/header.jsp" %>
게시판 페이지입니다
<table border="1">
	<tr>
		<th>번호</th>
		<th>id</th>
		<th>제목</th>
		<th>날짜</th>
		<th>조회수</th>
		<th>image_file_name</th>
	</tr>
	<c:choose>
		<c:when test="${list == null }">
			<tr>
				<td colspan="7">게시물이 없습니다.</td>
			</tr>		
		</c:when>
		<c:otherwise>
			<c:forEach items="${list }" var="list">
				<tr>
					<td>${list.getWriteNo()}</td>
					<td>${list.getId()}</td>
					<td>
					<a href="contentView?writeNo=${list.getWriteNo() }">${list.getTitle()}</a></td>
					<td>${list.getDate()}</td>
					<td>${list.getHit()}</td>
					<td>${list.getImageFileName()}</td>
				</tr>
			</c:forEach>	
		</c:otherwise>
	</c:choose>
	
	<tr>
		<td colspan="6" align="right">
		<c:forEach var="num" begin="1" end="${repeat }">
			<a href="allList?start=${num}">${num}</a> &nbsp;
		</c:forEach>
		<a href="writeForm">글작성</a></td>
	</tr>
	
</table>
</body>
</html>