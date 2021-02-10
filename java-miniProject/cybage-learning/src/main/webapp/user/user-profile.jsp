<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User-Profile</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="<%=request.getContextPath()%>/webjars/bootstrap/4.5.3/css/bootstrap.css"
	rel="stylesheet">

</head>

<body>
	<!-- <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content"> -->
	<div class="modal-header card bg-warning">
		<h5 class="modal-title" id="exampleModalLabel">User Profile</h5>
		<!-- <button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button> -->
	</div>
	<div class="modal-body">
		<form action ="<%=request.getContextPath()%>/UserController/profile" method="get">
			<div class="form-group">
				<label>Name</label> 
				<input type="text" class="form-control" value="${user.fullName} ">
			</div>
			<div class="form-group">
				<label>Username</label>
				 <input type="text" class="form-control" value="${user.userName} ">
			</div>
			<div class="form-group">
				<label>Password</label>
				<input type="password" class="form-control" value="${user.password} ">
			</div>
			<div class="m-4">
				<button type="button" class="btn btn-outline-dark" data-dismiss="modal">Submit</button>
				<button type="reset" class="btn btn-outline-danger">Reset</button>
			</div>
		</form>
	</div>

	<!-- </div>
		</div>
	</div> -->
</body>
</html>