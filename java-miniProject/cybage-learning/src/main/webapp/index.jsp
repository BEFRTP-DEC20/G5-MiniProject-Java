
<%@page import="com.cybage.model.Course"%>
<%@page import="com.cybage.model.Category"%>
<%@page import="java.util.List"%>

<jsp:include page="header.jsp"></jsp:include>
<!-- To import list and Category Model -->

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

.carousel {
	background: #2f4357;
	margin-top: 20px;
	width: 1200px;
	height: 500px;
}

.carousel-item {
	text-align: center;
	min-height: 280px;
	/* Prevent carousel from being distorted if for some reason image doesn't load */
}
</style>

<div class="container-lg my-3">
	<div id="myCarousel" class="carousel slide" data-interval="2000"
		data-ride="carousel">
		<!-- Carousel indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
		</ol>
		<!-- Wrapper for carousel items -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="images/banner.png" alt="First Slide">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
			<div class="carousel-item">
				<img src="images/banners.png" alt="Second Slide">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>

		</div>
		<!-- Carousel controls -->
		<a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#myCarousel" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
</div>




<div class="contrainer-fluid">
	<div class="row">

		<%
			if ((request.getAttribute("categoryList")) != null) {
				List<Category> category = (List) request.getAttribute("categoryList");
				for (Category c : category) {
					out.print("<div class='col-md-6  col-sm-12'>");
					out.print("<div class='card' >");
					out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
					out.print("<div class='card-body'>");
					out.print("<h3 class='card-title'>'" + c.getCategoryName() + "'</h3>'");

					out.print("<a href='courses.jsp?id=" + c.getCategoryId()
							+ "' class='btn btn-primary'>View Courses</a>");
					out.print("</div>");
					out.print("</div>");
					out.print("</div>");
				}
			}
			if ((request.getAttribute("courseList")) != null) {
				List<Course> course = (List) request.getAttribute("courseList");
				for (Course c : course) {
					out.print("<div class='col-md-6  col-sm-12'>");
					out.print("<div class='card' >");
					out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
					out.print("<div class='card-body'>");
					out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>'");

					out.print("<a href='courses.jsp?id=" + c.getCourseId()
							+ "' class='btn btn-primary'>Start Courses</a>");
					out.print("</div>");
					out.print("</div>");
					out.print("</div>");
				}
			}
		%>
	</div>
	<%
		out.print("<a class='btn btn-warning' href='" + request.getContextPath()
				+ "/AppController'>USER HOME PAGE</a>");
	%>

	<%
		if ((request.getAttribute("categoryList")) == null) {
			out.print("<a class='btn btn-warning' href='" + request.getContextPath()
					+ "/VisitorController/list'>Load Categories</a>");
		}	
%>
</div>
<%
   out.print("<a class='btn btn-info' href='"+request.getContextPath()+"/AppController'>USER HOME PAGE</a>");
%>
	
	<%  if((request.getAttribute("categoryList"))==null){
		out.print("<a class='btn btn-info' href='"+request.getContextPath()+"/VisitorController/list'>Load Categories</a>");
	}%>
</div>





<jsp:include page="footer.jsp"></jsp:include>