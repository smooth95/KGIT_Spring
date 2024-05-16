<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/daumPost.js"></script>
</head>
<body>
<%@ include file="../default/header.jsp" %>
	<div align="center">
	<h3>회원가입 페이지 입니다.</h3>
	${msg }
		<form action="/root/member/registerChk" method="post">
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="text" name="pw" placeholder="비밀번호"><br>
			<input type="text" id="addr1" name="addr" readonly placeholder="우 편 번 호"><br>
			<input type="text" id="addr2" name="addr" readonly placeholder="주 소"><br>
			<input type="text" id="addr3" name="addr" placeholder="상 세 주 소">
			<input type="button" onclick="daumPost()" value="우편번호검색"><br>
			<input type="submit" value="회원가입">
		</form>
		
	</div>


<%@ include file="../default/footer.jsp" %>

</body>
</html>