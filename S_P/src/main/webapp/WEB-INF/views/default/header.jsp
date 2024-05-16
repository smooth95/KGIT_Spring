<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="<%= request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> CARE LAB </h1>
	<hr>
		<a href="${path }/index">HOME</a> &nbsp;&nbsp;
		
		<a href="${path }/member/memberInfo">MEMBERS</a> &nbsp;&nbsp;
		
		<c:if test="${loginUser != null }">
			<a href="${path }/member/logout">LOGOUT</a> &nbsp;&nbsp;
		</c:if>
		<c:if test="${loginUser == null }">
			<a href="${path }/member/login">LOGIN</a> &nbsp;&nbsp;
		</c:if>
	<hr>
</body>
</html>






