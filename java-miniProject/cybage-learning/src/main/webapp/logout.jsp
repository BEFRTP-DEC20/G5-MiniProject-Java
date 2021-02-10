<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logged out</title>
</head>
<body>
	<%
		session.invalidate();
	%>
	
	<jsp:include page="index.jsp"></jsp:include>
</body>
</html>