<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="modal_wrap">
		<div id="first">
			<div style="width : 250px; margin : auto; padding-top : 20px;">
				<form id="frm">
					<input type="hidden" name="write_no" value="${dto.writeNo }">
					답글 작성 페이지<hr>
					작성자 : ${loginUser }<br>
					제목 : <input type="text"name="title" id="title"><br>
					내용 : <textarea rows="" cols="" name="content" id="content"></textarea><hr>
					<input type="button" onclick="rep()" value="답글">
					<input type="button" onclick="slide_hide()" value="취소">
				</form>
			</div>
		</div>
	</div>
</body>
</html>