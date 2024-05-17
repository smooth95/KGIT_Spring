<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function chat() {
			window.open("socket", "", "width=300px, height=500px")
			
		}
	</script>
	<h3>test_socket</h3>
	<input type="button" onclick="chat()" value="상담사 연결">
</body>
</html>