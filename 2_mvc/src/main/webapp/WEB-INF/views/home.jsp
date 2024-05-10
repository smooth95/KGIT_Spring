<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="url" value="<%= request.getContextPath() %>"/>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<link href="${ url }/resources/css/test.css" rel="stylesheet">
	<link href="${ url }/css/test2.css" rel="stylesheet">
	<script type="text/javascript" src="${ url }/js/test.js"></script>
</head>
<body>
<c:url value="/resources/img/car01.png" var="path" />
path : ${ path }<br>
req : <%= request.getContextPath() %>/img/car01.png<br>
page : ${ pageContext.request.contextPath }/img/car01.png<br>
<img src="${ path }" width="100" height="100">
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<input type="button" onclick="test()" value="클릭">
한글
</body>
</html>
