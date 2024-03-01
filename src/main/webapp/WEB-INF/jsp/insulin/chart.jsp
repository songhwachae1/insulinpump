<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Insulin Measurement History</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="/css/sweetalert2.css" rel="stylesheet" type="text/css" />
	<link href="/css/mobiscroll.javascript.min.css" rel="stylesheet" type="text/css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css?a=1">
	<script src="/js/sweetalert2.js"></script>
	
</head>
<body>
	<div class="wrapper pb-5">
		<div class="pos-f-t">
			<nav class="navbar navbar-dark bg-dark">
				<button class="navbar-toggler ms-auto" style="border-color: transparent;" type="button" data-toggle="collapse"  aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
					<!-- <span class="navbar-toggler-icon"></span> -->
					<div class="animated-icon" id="bgr"><span></span><span></span><span></span></div>
				</button>
			</nav>
			<div class="ddmenu" id="ddmenu">
				<div class="bg-dark p-4">
					<a class="dropdown-item text-white" href="/insulin/main">Main</a>
					<a class="dropdown-item text-white" href="#">Settings</a>
				</div>
			</div>
			<div class="row pt-5">
				<div class="section-head col-sm-12">
					<h4 class="safe">Your History</h4>
				</div>
				<div class="main__qna pt-5">  
					<div class="main__qna--input">
						<span><input type="text" id="start" readonly style="background-color: transparent;" class="form-control"><a id="picker1"></a></span>
						<em>~</em>
						<span><input type="text" id="end" readonly style="background-color: transparent;" class="form-control"><a id="picker2"></a></span>
					</div>
				</div>
			</div>
		</div>
		<div class="preloaderDiv" style="display: none;">
			<div id="preloader"></div>
			<h1>Loading..</h1>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="/js/moment.js"></script>
	<script src="/js/mobiscroll.javascript.min.js"></script>
	<script type="text/javascript" src="/js/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="/js/echarts/theme/macarons.js"></script>
	<script type="text/javascript" src="/js/echarts/theme/infographic.js"></script>
	<script type="text/javascript" src="/js/echarts/theme/roma.js"></script>
	<script type="text/javascript" src="/js/echarts/theme/shine.js"></script>
	<script src="/js/common.js"></script>
	<script src="/js/chart.js"></script>
</body>
</html>		