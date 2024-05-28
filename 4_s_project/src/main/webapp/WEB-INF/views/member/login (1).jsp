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
		<h2>로그인페이지 입니다.</h2>
		<c:choose>
			<c:when test="${id != null }">
				${id }님은 로그인 상태 입니다.
			</c:when>
			<c:otherwise>
				<form action="/root/member/successChk" method="post">
			<table>
				<tbody>
					<tr>
						<td><input type="text" name="id" placeholder="아이디"><br></td>
						<td rowspan="2" ><input style="height: 50px;" type="submit" value="로그인"><br></td>
					</tr>
					<tr>
						<td><input type="text" name="pw" placeholder="비밀번호"></td>
					</tr>
				</tbody>
			</table>
			<a href="/root/member/register">회원가입</a>
		</form>
			</c:otherwise>
		</c:choose>
		
		
	</div>
<%@ include file="../default/footer.jsp" %>

</body>
</html>