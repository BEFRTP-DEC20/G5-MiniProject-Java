
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="<%=request.getContextPath()%>/webjars/bootstrap/4.5.3/css/bootstrap.css"
	rel="stylesheet">

<style>
.login-container {
	margin-top: 5%;
	margin-bottom: 5%;
}

.login-form-2 {
	padding: 9%;
	box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0
		rgba(0, 0, 0, 0.19);
}
</style>

</head>




<center>
	<div class="container login-container ml-5">


		<div class="col-md-6 login-form-2 bg-warning">
			<h1>Register</h1>
			<hr>
			<form method=post action="VisitorController/registration">
				<div class="form-group">
					<input type="text" class="form-control" name="fullName"
						placeholder="Full Name" pattern="[A-Za-z]{3}"
						title="name should contain atleast 3 character"
						required="required">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="userName"
						placeholder="Username" pattern="[a-z]{1,15}"
						title="Username should only contain lowercase letters.
						required="required">
				</div>
				<div class="form-group">
					<input type="password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain at least one number and one uppercase and
						lowercase letter, and at least 8 or more characters"
						class="form-control" name="userPassword" placeholder="Password"
						required="required">

				</div>

				<div class="form-group row">

					<div class="col-md-12 col-sm-12">
						<select class="security form-control" id="security1"
							name="security1" required>
							<option value="0">Select security Question</option>
							<option value="first School">What was the name of your
								first School?</option>
							<option value="Fav Color">What is your favorite color?</option>
							<option value="Mother's Maiden Name">What is your
								mother's maiden name?</option>
						</select>
					</div>
				</div>
				<div class="form-group row">

					<div class="col-sm-12 col-md-12">
						<input type="text" class="form-control" id="security_answer"
							placeholder="Enter Security Answer" name="securityAnswer"
							required="required">
					</div>
				</div>
				<br>
				<div class="form-group">
					<label>PRIME USER: </label> <input type="radio"
						class="form-control" value=true name="primeUser"> <label>REGULAR
						USER: </label> <input type="radio" class="form-control" value=false
						name="primeUser">
				</div>
				<div class="justify-content-center form-group">

					<button type="submit" class="btn btn-outline-dark m-3 "
						href="index.jsp" id="signUp">Register</button>

					<button class="btn btn-outline-danger" type="reset" id="btnCloseIt"
						data-dismiss="modal">Reset</button>
				</div>
			</form>
			</form>
		</div>

	</div>
</center>