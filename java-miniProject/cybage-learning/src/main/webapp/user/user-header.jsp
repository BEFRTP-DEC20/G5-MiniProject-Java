<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">

<link
	href="<%=request.getContextPath()%>/webjars/bootstrap/4.5.3/css/bootstrap.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.css"
	integrity="sha512-EaaldggZt4DPKMYBa143vxXQqLq5LE29DG/0OoVenoyxDrAScYrcYcHIuxYO9YNTIQMgD8c8gIUU8FQw7WpXSQ=="
	crossorigin="anonymous" />
<!----------------------  custom css here ---------------------------->
<link rel="stylesheet" href="scss/start-course.css">
</head>
<style>
body {
	font-family: 'Varela Round', sans-serif;
}
</style>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-warning ">
		<a class="navbar-brand" href="#">Cybage Learning</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-between"
			id="navbarSupportedContent">
			<div class="search">
				<form class="form-inline my-2 my-lg-0"
					action="<%=request.getContextPath()%>/UserController/search"
					method="post">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" name="search">
					<button class="btn btn-outline-dark my-2 my-sm-0 fa fa-search"
						aria-hidden="true" type="submit"></button>
				</form>
			</div>
			<!------------------------------drop down----------------------->
			<div>
				<ul class="navbar-nav mr-auto ">
					<li class="nav-item">
						<div class="dropdown">
							<button class="btn btn-warning dropdown-toggle" type="button"
								id="dropdownMenuButton" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="true"><%=request.getRemoteUser()%></button>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item fa fa-user" aria-hidden="true"
									href="<%=request.getContextPath()%>/user/user-profile.jsp">
									Profile</a>
								<hr>
								<a class="dropdown-item fa fa-sign-out" aria-hidden="true"
									href="<%=request.getContextPath()%>/logout.jsp"> Logout</a>
							</div>
						</div>

					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!----------------------------------------- Modal HTML ------------------------------------------------------->

	</div>
	<!-- data-toggle="modal" data-target="#exampleModal" -->