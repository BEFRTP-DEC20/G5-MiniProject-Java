<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@page import="com.cybage.model.PrimeUser"%>
<jsp:include page="user-header.jsp"></jsp:include>

<body>

	<% PrimeUser user = (PrimeUser)request.getAttribute("user");%>
	<div class="modal-body">
		<form action ="<%=request.getContextPath()%>/UserController/updateProfile" method="post">
			<div class="form-group">
				<label>Name</label> 
				<input type="text" class="form-control" value="${user.fullName}" name="fullName">
			</div>
			<div class="form-group">
				<label>Username</label>
				 <input type="text" class="form-control" value="${user.userName}" name="userName" readonly>
			</div>
			<div class="form-group">
				<label>Password</label>
				<input type="password" class="form-control" value="${user.password}" name="oldPassword">
			</div>
			<div class="form-group">
				<label>New Password</label>
				<input type="password" class="form-control" name="newPassword" value="null">
			</div>
			<div class="form-group">
			<%if(user.isIs_prime_user()==false) 
				{	
				out.print("<label>DO YOU WANT TO BE A PRIME USER: </label>");
				out.print("<label>PRIME USER: </label>");
				out.print("<input type='radio' class='form-control' value='true' name='primeUser'>");
				out.print("<label>Regular USER: </label>");
				out.print("<input type='radio' class='form-control' value='false' name='primeUser'  checked>");
				}
			else
			{
				out.print("<label>PRIME USER: </label>");
				out.print("<input type='radio' class='form-control' value='true' name='primeUser' checked>");
				out.print("<label>Regular USER: </label>");
				out.print("<input type='radio' class='form-control' value='false' name='primeUser' >");
			}	%>
			</div>
			<div class="m-4">
				<button type="submit" class="btn btn-outline-dark" data-dismiss="modal">Submit</button>
				<button type="reset" class="btn btn-outline-danger">Reset</button>
			</div>
		</form>
	</div>

<jsp:include page="user-footer.jsp"></jsp:include>