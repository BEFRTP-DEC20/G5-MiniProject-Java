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