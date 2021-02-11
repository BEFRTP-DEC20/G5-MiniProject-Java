<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="${request.getContextPath}/cybage-learning/user/scss/certificate.css" rel="stylesheet" ></link>
<title>Certificate</title>

<%
	String fullName = request.getAttribute("full_name").toString();
	String courseName = request.getAttribute("category_name").toString();
	String categoryName = request.getAttribute("course_name").toString();
	
	System.out.println("in certificate:"+fullName);
	System.out.println("in certificate:"+courseName);
	System.out.println("in certificate:"+categoryName);
%>
</head>
<body>
	<div class="container">
		<div class="logo">Cybage Software</div>

		<div class="marquee">Certificate of Completion</div>

		<div class="assignment">This is to Certify that</div>

		<div class="person"><%=fullName %></div>

		<div class="reason">For Successfully Completing Course in</div>
		<b><%=courseName %></b> in <b><%=categoryName %></b> category.

	</div>
	
	<button class="printbtn"onclick="window.print()">Generate PDF</button>
	
	
</body>
</html>
