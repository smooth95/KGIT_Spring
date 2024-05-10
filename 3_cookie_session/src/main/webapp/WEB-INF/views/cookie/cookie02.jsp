<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function popup() {
		
		let url = "popup02";
		let setWindow = "width=300,height=200, top=500, left=500";
// 		if ("${ cook }" == "") {
// 			window.open(url, "", setWindow);			
// 		}
		console.log("cook : ", document.cookie)
		let cookie = document.cookie.split("=");
		console.log("cookie : ", cookie)
		
		if (cookie[0] != "myCookie") {
			window.open(url, "", setWindow);
		}
	}
</script>

</head>
<body onload="popup()">
	cook : ${ cook }<br>
	<h1>cookie02 페이지</h1>
</body>
</html>