<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function test(){
		let n = document.getElementById("name").value;
		let a = $("#age").val();
		let form = {name : n, age : a};
// 		dto와 key값이 맞으면 자동으로 dto에 적용된다.
		$.ajax({
			url : "result03",
			type : "post",
			data : JSON.stringify(form), // object타입을 json형식으로 변환하여 전달한다.
			dataType : "json", // 서버로부터 리턴받는 타입의 값
			contentType : "application/json; charset=utf-8", // 내가 전달할때 사용하는 타입
			success : ( result ) => {
				console.log( result )
				$("#result").html( "name : " + result.name + ", age : " + result.age);
			},
			error : () => {
				console.log("문제 발생!!!")
			}
		})
	}
</script>
</head>
<body>
	<input type="text" id="name"><br>
	<input type="text" id="age"><br>
	<input type="button" value="click" onclick="test()"><br>
	결과 : <span id="result"></span>
	
</body>
</html>