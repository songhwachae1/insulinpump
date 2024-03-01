<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Insulin Measurement</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="/css/sweetalert2.css" rel="stylesheet" type="text/css" />
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
					<a class="dropdown-item text-white" href="/insulin/chart">History</a>
					<a class="dropdown-item text-white" href="#">Settings</a>
				</div>
			</div>
		</div>
		<div class="container pt-5">
			<div class="row">
				<div class="section-head col-sm-12">
					<h4 class="safe" id="band"></h4>
				</div>
				<div class="mt-3">
					<div class="item">
						<h6>Your Glucose Level</h6>
						<h1 class="glucose"></h1>
						<p class="pt-3 mb0">last measured on: &nbsp<span class="mdate"></span></p>
					</div>
				</div>
			</div>
		</div>
		<div class="accordion">
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingOne">
					<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
						Details
					</button>
				</h2>
				<div id="collapseOne" class="accordion-collapse collapsed collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<p>Date : <span class="mdate">10</span></p>
						<p>Glucose level : <span class="glucose">10</span></p>
						<p>Band : <span id="band2"></span></p>
						<p>Insulin level : <span id="insulin">10</span></p>
						<p>Battery : <span id="battery">10</span></p>
						<p>Action : <span id="action">inject</span></p>
					</div>
				</div>
			</div>
			<div class="text-center pt-5">
				<button type="button" id="start" class="btn btn-outline-primary">start</button>
				<button type="button" id="stop" style="display: none;" class="btn btn-outline-primary">stop</button>
			</div>
		</div>
		<div class="preloaderDiv">
			<div id="preloader"></div>
			<h1>Loading..</h1>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="/js/common.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>		