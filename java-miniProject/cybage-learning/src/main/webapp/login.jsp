<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<%=request.getContextPath()%>/webjars/bootstrap/4.5.3/css/bootstrap.css" rel="stylesheet">

<!--  custom css here -->
<style>
	.login-container{
	border-radius: 30px;
    margin-top: 5%;
    margin-bottom: 5%;
    background: rgb(255, 193, 7);
	background: linear-gradient(90deg,rgba(23, 162, 184, 1)  30%,
		rgba(255, 193, 7, 1) 63%);
	}

	.login-form-2{
		border-radius: 20px;
	    padding: 9%;  
	    box-shadow: 10px 10px 10px 10px rgba(0, 0, 0, 0.2), 10px 10px 10px  rgba(0, 0, 0, 0.19);
	    background: rgb(255,193,7);
		background: linear-gradient(90deg, rgba(255,193,7,1) 49%, rgba(23,162,184,1) 49%);
	}	
	

</style>
</head>

<center>
<div class="container login-container ml-5">
            
               
                <div class="col-md-6 login-form-2">
                   <form method=post action="j_security_check">
                    <h1 ><span style="color:#17a2b8;">Lo</span><span style="color:#ffc107;">gin</span> </h1>
                    <hr>
                        <div class="form-group mt-4">
                            <input type="text" class="form-control" name="j_username"
					placeholder="Username" required="required" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="j_password"
					placeholder="Password" required="required" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="mt-4 btn btn-outline-dark" value="Login"/> 
                        </div>
                        <div class="form-group">

                            <a href="#" class="" value="Login">Forget Password?</a>
                        </div>
                    </form>
                </div>
           
        </div>
        </center>
<%-- <jsp:include page="registration.jsp"></jsp:include> --%>