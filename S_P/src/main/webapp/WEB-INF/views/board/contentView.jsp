<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/modal.js"></script>
<link href="<%= request.getContextPath() %>/resources/css/modal.css" rel="stylesheet"/>

</head>
<body onload="readData('${dto.writeNo}')">
<%@ include file="/WEB-INF/views/default/header.jsp" %>
<%@ include file="/WEB-INF/views/board/modal.jsp" %>
	<table border="1">
		<tr>
			<th>글 번호</th><td>${dto.writeNo }</td>
			<th>작성자</th><td>${dto.id }</td>
		</tr>
		<tr>
			<th>제목</th><td>${dto.title }</td>
			<th>등록일자</th><td>${dto.date }</td>
		</tr>
		<tr>
			<th>내용</th><td>${dto.content }</td>
			<td colspan="2">
				<img src="download?fileName=${dto.imageFileName }" width="100" height="100">
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<c:if test="${ loginUser == dto.id }">
				<input type="button" onclick="location.href='modify_form?writeNo=${dto.writeNo}'" value="수정">
				<input type="button" onclick="location.href='delete?writeNo=${dto.writeNo}&fileName=${dto.imageFileName}'" value="삭제">			
			</c:if>
				<input type="button" onclick="slideClick()" value="답글">
				<input type="button" onclick="location.href='allList'" value="목록이동">
			</td>
		</tr>
	</table>
	<div id="data">
	
	</div>
</body>
</html>