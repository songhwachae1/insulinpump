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
						<span style="margin-left: 20px;"><input type="text" id="start" readonly style="background-color: transparent;" class="form-control"><a id="picker1"></a></span>
						<em>~</em>
						<span style="margin-right: 17px;"><input type="text" id="end" readonly style="background-color: transparent;" class="form-control"><a id="picker2"></a></span>
						<a id="search" class="pt-1" style="cursor: pointer;">
							<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
								<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
							</svg>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div id="chart" style="width: 100%;height:400px;" class="mt-3"></div>
		<div class="preloaderDiv" style="display: none;">
			<div id="preloader"></div>
			<h1>Loading..</h1>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="/js/moment.js"></script>
	<script src="/js/mobiscroll.javascript.min.js"></script>
	<script src="/js/echarts.js"></script>
	<script src="/js/common.js"></script>
	<script src="/js/chart.js"></script>
</body>
</html>		