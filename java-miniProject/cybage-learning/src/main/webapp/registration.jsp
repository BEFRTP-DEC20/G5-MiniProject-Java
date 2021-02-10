
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
<!-- 
<form method=post action="VisitorController/registration">
	<div class="form-group">
		<input type="text" class="form-control" name="fullName"
			placeholder="Full Name" required="required">
	</div>
	<div class="form-group">
		<input type="text" class="form-control" name="userName"
			placeholder="Username" required="required">
	</div>
	<div class="form-group">
		<input type="password" class="form-control" name="userPassword"
			placeholder="Password" required="required">
	</div>

	<div class="form-group row">
		<label for="inputPassword" class="col-sm-3 col-form-label">
			Security Question </label>
		<div class="col-sm-7">
			<select class="security form-control" id="security1" name="security1"
				required>
				<option value="0">Select a question from the following
					options.</option>
				<option value="first School">What was the name of your first School?</option>
				<option value="Fav Color">What is your favorite color?</option>
				<option value="Mother's Maiden Name">What is your mother's maiden name?</option>
			</select>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputPassword" class="col-sm-3 col-form-label">Answer
		</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="security_answer"
				placeholder="Security Answer" name="securityAnswer">
		</div>

<div class="modal-footer justify-content-center form-group">
	<button type="submit" class="btn btn-login-form " id="signUp">Register</button>
	<button  class="btn btn-danger" id="btnCloseIt" data-dismiss="modal">Close</button>
</div>

</form>

 -->




<center>
	<div class="container login-container ml-5">


		<div class="col-md-6 login-form-2 bg-warning">
		<h1>Register</h1>
                    <hr>
			<form method=post action="VisitorController/registration">
				<div class="form-group">
					<input type="text" class="form-control" name="fullName" placeholder="Full Name" required="required">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="userName" placeholder="Username" required="required">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="userPassword" placeholder="Password" required="required">
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
							placeholder="Enter Security Answer" name="securityAnswer">
					</div>
					</div><br>
					<div class="justify-content-center form-group">
					
						<button type="submit" class="btn btn-outline-dark m-3 " href="index.jsp"  id="signUp">Register</button>
						
						<button class="btn btn-outline-danger" type="reset" id="btnCloseIt" data-dismiss="modal">Reset</button>
					</div>
			</form>
			</form>
		</div>

	</div>
</center>