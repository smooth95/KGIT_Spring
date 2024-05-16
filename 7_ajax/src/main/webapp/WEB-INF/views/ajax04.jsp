<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function getFunc() {
		$.ajax({
			url : "rest",
			type : "get",
			dataType : "json",
			success : function ( result ) {
				$("#span").html( result.result );
			},
			error : function () {
				alert("문제 발생!!!")
			}
		})
	}
	function postFunc() {
		$.ajax({
			url : "rest",
			type : "post",
			dataType : "json",
			success : function ( result ) {
				$("#span").html( result.result );
			},
			error : function () {
				alert("문제 발생!!!")
			}
		})
	}
	function putFunc() {
		$.ajax({
			url : "rest",
			type : "put",
			dataType : "json",
			success : function ( result ) {
				$("#span").html( result.result );
			},
			error : function () {
				alert("문제 발생!!!")
			}
		})
	}
	function deleteFunc() {
		$.ajax({
			url : "rest",
			type : "delete",
			dataType : "json",
			success : function ( result ) {
				$("#span").html( result.result );
			},
			error : function () {
				alert("문제 발생!!!")
			}
		})
	}
	
</script>
</head>
<body>
	<span id="span"></span><hr>
	<input type="button" onclick="getFunc()" value="get요청">
	<input type="button" onclick="postFunc()" value="post요청">
	<input type="button" onclick="putFunc()" value="put요청">
	<input type="button" onclick="deleteFunc()" value="delete요청">
</body>
</html>