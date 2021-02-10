<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/webjars/bootstrap/4.5.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>


<!--  custom css here -->

</head>
<style>
body {
	font-family: 'Varela Round', sans-serif;
}

.modal-login {
	color: #636363;
	width: 350px;
}

.modal-login .modal-content {
	padding: 20px;
	border-radius: 5px;
	border: none;
}

.modal-login .modal-header {
	border-bottom: none;
	position: relative;
	justify-content: center;
}

.modal-login h4 {
	text-align: center;
	font-size: 26px;
	margin: 30px 0 -15px;
}

.modal-login .form-control:focus {
	border-color: #70c5c0;
}

.modal-login .form-control, .modal-login .btn {
	min-height: 40px;
	border-radius: 3px;
}

.modal-login .close {
	position: absolute;
	top: -5px;
	right: -5px;
}

.modal-login .modal-footer {
	background: #ecf0f1;
	border-color: #dee4e7;
	text-align: center;
	justify-content: center;
	margin: 0 -20px -20px;
	border-radius: 5px;
	font-size: 13px;
}

.modal-login .avatar {
	position: absolute;
	margin: 0 auto;
	left: 0;
	right: 0;
	top: -70px;
	width: 95px;
	height: 95px;
	border-radius: 50%;
	z-index: 9;
	background: #60c7c1;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}

.modal-login .avatar img {
	width: 100%;
}

.modal-login.modal-dialog {
	margin-top: 80px;
}

.modal-login .btn, .modal-login .btn:active {
	color: #fff;
	border-radius: 4px;
	background: #60c7c1 !important;
	text-decoration: none;
	transition: all 0.4s;
	line-height: normal;
	border: none;
}

.txt-none{
	text-decoration: none;
}
.modal-login .btn:hover, .modal-login .btn:focus {
	background: #45aba6 !important;
	outline: none;
}
</style>

<script>
	$(document).ready(function() {
		$('.openBtn').on('click', function() {
			var dataURL = $(this).attr('data-href');
			$('.modal-body').load(dataURL, function() {
				$('#myModal').modal({
					show : true
				});
			});
		});
	});
</script>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-warning ">
		<a class="navbar-brand" href="#">Cybage Learning</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<form class="form-inline my-2 my-lg-0"
				action="<%=request.getContextPath()%>/VisitorController/search"
				method="post">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search" name="search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			<ul class="navbar-nav mr-auto ">
				
				<li class="nav-item">
					<!-- <button href="#myModal"  data-toggle="modal" class="btn btn-outline-primary ">
						<a  data-href="login.jsp"
							class="openBtn " href="/AppController">Log In</a>
					</button> -->
				
				<a href="<%=request.getContextPath()%>/AppController" class="btn btn-outline-primary">Login</a>
				<a href="registration.jsp"><button class="btn btn-outline-info ">
						Register
					</button></a>

					<div id="myModal" class="modal fade">
						<div class="modal-dialog modal-login">
							<div class="modal-content">
								<div class="modal-header">
									<div class="avatar">
										<img
											src="https://cdn4.iconfinder.com/data/icons/avatars-xmas-giveaway/128/girl_female_woman_avatar-512.png"
											alt="Avatar">
									</div>
									<h4 class="modal-title">Member Login</h4>
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
								</div>
								<div class="modal-body">
								</div>
								<div class="modal-footer">
									<a href="<%=request.getContextPath()%>/UserController/search">Forgot
										Password?</a>
								</div>
							</div>
						</div>
				</li>
			</ul>
		</div>
	</nav>
	<!----------------------------------------- Modal HTML ------------------------------------------------------->

	</div>