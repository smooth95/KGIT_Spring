<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=1z0j30ozhj"></script>
</head>
<body>
	맵 화면
	<div id="map" style="width:100%;height:400px;"></div>

	<script>
		var mapOptions = {
		    center: new naver.maps.LatLng(37.3595704, 127.105399),
		    zoom: 15
		};

		var map = new naver.maps.Map('map', mapOptions);
	</script>
</body>
</html>

