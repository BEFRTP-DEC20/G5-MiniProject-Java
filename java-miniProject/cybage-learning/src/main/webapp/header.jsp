<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cybage E-Learning</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="<%=request.getContextPath()%>/webjars/bootstrap/4.5.3/css/bootstrap.css"
	rel="stylesheet">
	
<link rel="stylesheet" href="user/scss/footer.css" />

<!--  custom css here -->

</head>
<style>
body {
	font-family: 'Varela Round', sans-serif;
}
</style>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-warning ">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/VisitorController/list">Cybage Learning</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-between"
			id="navbarSupportedContent">
			<div>
				<form class="form-inline my-2 my-lg-0"
					action="<%=request.getContextPath()%>/VisitorController/search"
					method="post">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" name="search">
					<button class="btn btn-outline-dark my-2 my-sm-0 fa fa-search"
						aria-hidden="true" type="submit"></button>
				</form>
			</div>
			<div>
				<ul class="navbar-nav mr-auto ">
					<li class="nav-item"><a
						href="<%=request.getContextPath()%>/AppController"
						class="btn btn-outline-dark">Login</a> <a href="registration.jsp"
						class="btn btn-outline-primary">Register</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!----------------------------------------- Modal HTML ------------------------------------------------------->