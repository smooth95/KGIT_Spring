<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/default/header.jsp" %>
<h3> - 개 인 정 보 - </h3>
id : ${ info.id }<br>
pwd : ${ info.pwd }<br>
addr : ${ info.addr }<br>
</body>
</html>