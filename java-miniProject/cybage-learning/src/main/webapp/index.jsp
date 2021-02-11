<jsp:include page="header.jsp"></jsp:include>
<%@page import="com.cybage.model.Course"%>
<%@page import="com.cybage.model.Category"%>
<%@page import="java.util.List"%>
	<!-- To import list and Category Model -->



	<!--Inline CSS -->
	<style>
.card {
	width: 30rem;
	padding: 3%;
	padding-top: 5%;
	margin-top: 7%;
	margin-bottom: 5%;
	margin-left: 20%;
	margin-right: 20%;
}


.jumbotron {
	background-color: 60c7c1;
}


</style>




	<!-- Banner Jumbotron -->
	<div class="jumbotron">
		<h1 class="display-4">Cybage E-Learning</h1>
		<p class="lead">A learning system based on formalised teaching but
			with the help of electronic resources is known as E-learning. While
			teaching can be based in or out of the classrooms, the use of
			computers and the Internet forms the major component of E-learning.
			E-learning can also be termed as a network enabled transfer of skills
			and knowledge, and the delivery of education is made to a large
			number of recipients at the same or different times.</p>
		<hr class="my-4">
		<p>E-learning has proved to be the best means in the corporate
			sector, especially when training programs are conducted by MNCs for
			professionals across the globe and employees are able to acquire
			important skills while sitting in a board room, or by having
			seminars, which are conducted for employees of the same or the
			different organizations under one roof.</p>
		<p class="lead"></p>
	</div>


<div class="contrainer-fluid">
<div class="row">

	<%if((request.getAttribute("categoryList"))!=null) {
		List<Category> category = (List) request.getAttribute("categoryList");
		for (Category c : category) {
			out.print("<div class='col-md-6  col-sm-12'>");
			out.print("<div class='card' >");
			out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
			out.print("<div class='card-body'>");
			out.print("<h3 class='card-title'>'" + c.getCategoryName() + "'</h3>'");
			
			out.print(
					"<a href='courses.jsp?id="+c.getCategoryId()+"' class='btn btn-primary'>View Courses</a>");
			out.print("</div>");
			out.print("</div>");
			out.print("</div>");
		}
	}
	if((request.getAttribute("courseList"))!=null) {
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
<%
   out.print("<a class='btn btn-warning' href='"+request.getContextPath()+"/AppController'>USER HOME PAGE</a>");
%>
	
	<%  if((request.getAttribute("categoryList"))==null){
		out.print("<a class='btn btn-warning' href='"+request.getContextPath()+"/VisitorController/list'>Load Categories</a>");
	}%>
</div>





<jsp:include page="footer.jsp"></jsp:include>
