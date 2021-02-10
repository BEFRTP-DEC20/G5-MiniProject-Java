<jsp:include page="user-header.jsp"></jsp:include>

<%@page import="com.cybage.model.Category"%>
<%@page import="com.cybage.model.Course"%>
<%@page import="java.util.List"%>
	
<body>	
<style>
.card {
	width: 18rem;
	padding: 3%;
	padding-top: 5%;
	margin-top: 7%;
	margin-bottom: 5%;
	margin-left: 5%;
	margin-right: 5%;
}
</style>

<div class="contrainer-fluid">
<div class="row">

<%if((request.getAttribute("enrolledList"))!=null) {
 out.print("<h1>ENROLLED COURSES</h1>");
		List<Course> course = (List) request.getAttribute("enrolledList");
		for (Course c : course) {
			out.print("<div class='col-md-6  col-sm-12'>");
			out.print("<div class='card' >");
			out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
			out.print("<div class='card-body'>");
			out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>'");
			out.print("<p class='card-text'>"+c.getCourseDescription()+"</p>");
			out.print(
					"<a href='/UserController/start-course?id="+c.getCourseId()+"&amp;vid=0' class='btn btn-primary'>Continue Courses(ADD THE VIDEO PAGE LINK)</a>");
			out.print("</div>");
			out.print("</div>");
			out.print("</div>");
		}
	}
	
%>

<%if((request.getAttribute("courseList"))!=null) {
		List<Course> course = (List) request.getAttribute("courseList");
		for (Course c : course) {
			out.print("<div class='col-md-6  col-sm-12'>");
			out.print("<div class='card' >");
			out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
			out.print("<div class='card-body'>");
			out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>'");
			out.print("<p class='card-text'>ABOUT COURSE:<br>"+c.getCourseDescription()+"</p>");
			out.print("<p class='card-text'>COURSE PRICE: "+c.getCoursePrice()+"&#8377</p>");
			out.print(
					"<a href='UserController/start-course?id="+c.getCourseId()+"&amp;vid=0' class='btn btn-primary'>Start Courses</a>");
			out.print("</div>");
			out.print("</div>");
			out.print("</div>");
		}
	}
	
%>
</div>
</div>

<jsp:include page="user-footer.jsp"></jsp:include>
