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


<%if((request.getAttribute("courseList"))!=null) {
		List<Course> course = (List) request.getAttribute("courseList");
		for (Course c : course) {
			out.print("<div class='col-md-6  col-sm-12'>");
			out.print("<div class='card' >");
			out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
			out.print("<div class='card-body'>");
			out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>'");
			
			out.print(
					"<a href='courses.jsp?id="+c.getCourseId()+"' class='btn btn-primary'>Start Courses</a>");
			out.print("</div>");
			out.print("</div>");
			out.print("</div>");
		}
	}
	
%>
</div>
</div>

<jsp:include page="user-footer.jsp"></jsp:include>