<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="user/scss/footer.css" />

</head>
<body>

	<div class="container">
		<div style="text-align: center">
			<h1>Contact Us</h1>
		</div>
		<div class="rows">
			<div class="col">
				<img class="img_class" src="images/logo.jpg" style="width: 60%">
			</div>
			<div class="col">
				<form action="/action_page.php">
					<label for="fname">First Name</label> <input type="text" id="fname"
						name="firstname" placeholder="Your name.."> <label
						for="lname">Last Name</label> <input type="text" id="lname"
						name="lastname" placeholder="Your last name.."> <label
						for="lname">Last Name</label> <input type="text" id="lname"
						name="lastname" placeholder="Your Email.."> <label
						for="subject">Subject</label>
					<textarea id="subject" name="subject"
						placeholder="Write something.." style="height: 170px"></textarea>
					<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>
	
	<div class="footer">
      <p class="footer-text-center">
      <a class="menu">@copyright 2020</a>
      </a>
        <a href="" class="menu">Home</a>
        <a href="about.jsp" class="menu">About</a>
        <a href="contact.jsp" class="menu">Contact</a>
        
      </p>
    </div>

</body>
</html>
