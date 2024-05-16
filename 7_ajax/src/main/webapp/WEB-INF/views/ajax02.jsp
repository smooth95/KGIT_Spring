<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function test() {
		$.ajax({
			url : "result02",
			type : "get",
			success : function ( data ) {
// 			넘겨받은 값은 data의 변수 값으로 들어온다.
				$("#count").html(data);
			},
			error : () => {
				console.log("실패!!!")
			}
		});
		
	}
</script>
</head>
<body>
	<h1>일</h1>	<h1>이</h1>
	<h1>삼</h1>	<h1>사</h1>
	<h1>오</h1>	<h1>육</h1>
	<hr>
	<input type="button" onclick="test()" value="클릭">
	<hr>
	count : <span id="count">0</span>
	
</body>
</html>