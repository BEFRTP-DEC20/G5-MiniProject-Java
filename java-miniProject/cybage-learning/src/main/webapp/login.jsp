<form method=post action="j_security_check">
	<div class="form-group">
		<input type="text" class="form-control" name="j_username"
			placeholder="Username" required="required">
	</div>
	<div class="form-group">
		<input type="password" class="form-control" name="j_password"
			placeholder="Password" required="required">
	</div>
	<div class="form-group">
		<button type="submit"
			class="btn btn-primary btn-lg btn-block login-btn">Login</button>
	</div>
</form>

<jsp:include page="registration.jsp"></jsp:include>