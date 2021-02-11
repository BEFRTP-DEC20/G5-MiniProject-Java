<jsp:include page="user-header.jsp"></jsp:include>

<%@page import="com.cybage.model.Category"%>
<%@page import="com.cybage.model.Course"%>
<%@page import="java.util.List"%>
<body>
	<!-- To import list and Category Model -->



	<!--Inline CSS -->
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

.jumbotron {
	background-color: 60c7c1;
}
</style>
	<%
				if ((request.getAttribute("completedList")) != null) {
					out.print("<hr>");
					out.print("<h1>Completed Courses</h1>");
					out.print("<hr>");
				    out.print("<div class='contrainer-fluid'>");
				    out.print("<div class='row text-center'>");
					List<Course> course = (List) request.getAttribute("completedList");
					for (Course c : course) {
						out.print("<div class='col-md-3  col-sm-3'>");
						out.print("<div class='card' >");
						out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
						out.print("<div class='card-body'>");
						out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>");
						out.print("<p class='card-text'>" + c.getCourseDescription() + "</p>");
						out.print("<div class='text-center'>");
						out.print("<a href='UserController/start-course?id=" + c.getCourseId()
								+ "&amp;vid=0' class='btn btn-warning '>Generate Certificate(LINK)</a>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
						
					}
					out.print("</div>");
					out.print("</div>");
				}
			%>
	<hr>
			
			<% 
				if ((request.getAttribute("enrolledList")) != null) {
					out.print("<hr>");
					out.print("<h1>Enrolled Courses</h1>");
					out.print("<hr>");
				    out.print("<div class='contrainer-fluid'>");
				    out.print("<div class='row text-center'>");
					List<Course> course = (List) request.getAttribute("enrolledList");
					for (Course c : course) {
						out.print("<div class='col-md-3  col-sm-3'>");
						out.print("<div class='card' >");
						out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
						out.print("<div class='card-body'>");
						out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>");
						out.print("<p class='card-text'>" + c.getCourseDescription() + "</p>");
						out.print("<div class='text-center'>");
						out.print("<a href='UserController/start-course?id=" + c.getCourseId()
								+ "&amp;vid=0' class='btn btn-warning '>Continue to Course</a>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
						
					}
					out.print("</div>");
					out.print("</div>");
				}
			%>
	<hr>
	<h1>Categories</h1>
	<hr>
	<div class="contrainer-fluid">
		<div class="row text-center">

			<%
				if ((request.getAttribute("categoryList")) != null) {
					List<Category> category = (List) request.getAttribute("categoryList");
					for (Category c : category) {
						out.print("<div class='col-md-3  col-sm-3'>");
						out.print("<div class='card' >");
						out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
						out.print("<div class='card-body'>");
						out.print("<h3 class='card-title'>'" + c.getCategoryName() + "'</h3>");
						out.print("<div class='text-center'>");
						out.print("<a href='UserController/course?id=" + c.getCategoryId()
								+ "' class='btn btn-warning '>View Courses</a>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
					}
				}
			%>

			<%
				if ((request.getAttribute("courseList")) != null) {
					out.print("<h1>COURSES</h1>");
					List<Course> course = (List) request.getAttribute("courseList");
					for (Course c : course) {
						out.print("<div class='col-md-3  col-sm-3'>");
						out.print("<div class='card' >");
						out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
						out.print("<div class='card-body'>");
						out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>'");
						out.print("<div class='text-center'>");
						out.print("<a href='user-courses.jsp?id=" + c.getCourseId()
								+ "&amp;vid=0' class='btn btn-primary'>Start Courses (ADD THE VIDEO PAGE LINK)</a>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
					}
				}
			%>
		</div>
	</div>





</body>

<jsp:include page="../footer.jsp"></jsp:include>
