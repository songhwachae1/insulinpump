<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<link href="/css/sweetalert2.css" rel="stylesheet" type="text/css" />
	<script src="/js/jquery-2.1.4.min.js"></script>
	<link href="/css/style.css" rel="stylesheet" type="text/css" />
	<script src="/js/main.js"></script>
	<script src="/js/sweetalert2.js"></script>
</head>
<body>
	<label>interval:<input type="number" id="interval"/></label>
	<button id="start">start</button>
	<button id="stop" disabled="true">stop</button>
	<p>Battery: <span id="battery"></span></p>
	<span id="inject"></span></p> 
	<div class="box">
		<p id="glucose">100</p>
	</div>
	<p>measured on : <span></span></p>
	<!-- <script type="text/javascript" src="./js/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="./js/echarts/theme/macarons.js"></script>
	<script type="text/javascript" src="./js/echarts/theme/infographic.js"></script>
	<script type="text/javascript" src="./js/echarts/theme/roma.js"></script>
	<script type="text/javascript" src="./js/echarts/theme/shine.js"></script> -->
</body>
</html>