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
	<nav class="navbar navbar-expand-lg navbar-light bg-info ">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/AdminController/listCategory">Cybage Learning - ADMIN</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-between"
			id="navbarSupportedContent">
			<div class="search">
			
			</div>
			<!------------------------------drop down----------------------->
			<div>

			<ul class="navbar-nav mr-auto ">
				<li class="nav-item">
					<div class="dropdown">
						<button class="btn btn-info dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="true"><%=request.getRemoteUser() %></button>
						<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item fa fa-sign-out" aria-hidden="true" href="<%= request.getContextPath()%>/logout.jsp"> Logout</a> 
						</div>

					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!----------------------------------------- Modal HTML ------------------------------------------------------->

<body onload="document.refresh();">