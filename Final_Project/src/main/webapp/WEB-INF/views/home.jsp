<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P><br>
<P>  The time on the server is ${sessionScope.time} </P><br>
	시간 : ${sessionScope.times}<br>
	name : ${userName }<br>
<a href="map/view">맵으로</a>
</body>
</html>
