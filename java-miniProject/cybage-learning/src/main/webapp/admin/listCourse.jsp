<%@page isELIgnored="false"%>
<%@page import="com.cybage.model.Course"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
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

.btn {
	width: 100%;
}

.modal-header {
	background-color: #ffe6ff;
}

.fa-plus {
	background-color: white;
	background-size: 50px;
	color: blue;
	font-size: 50px;
	padding-left: 100px;
	font-size: 50px;
}

.row {
	justify-content: space-around;
}

.jumbotron {
	background-color: 60c7c1;
}

#headerTag {
	color: #3c3b37;
	display: table-cell;
	text-align: center;
	width: 100rem;
	height: 20px;
	padding-top: 0.5%;
}
</style>
<script type="text/javascript">
	/* Function to show data in modal in update functionality. */
	function f(i, n, p, d, a, de, ts, u){
		document.getElementById("cid").value=i;
		document.getElementById("cname").value=n;
		document.getElementById("cprice").value=p;
		document.getElementById("cduration").value=d;
		document.getElementById("cauthor").value=a;
		document.getElementById("cdescription").value=de;
		document.getElementById("tsubcount").value=ts;
		document.getElementById("curl").value=u;
	}

</script>
<div class="contrainer-fluid">
	<div id="headerTag">
		<h1>Courses</h1>
		<hr>
		<br>
	</div>
	<div class="row">
		<!-- Add a course card. -->
		<div class="col-lg-4 col-sm-12">
			<div class="card">
				<img class="card-img-top "
					src="https://cdn2.iconfinder.com/data/icons/multimedia-sound-7/48/Add_category-_playlist-512.png">
				<div class="card-body">
					<h3 class="card-title">New Course</h3>
					<a data-toggle="modal" data-target="#addCourseModal"
						class="btn btn-info mt-2 mr-2">Add a new course</a>
				</div>
			</div>
		</div>
		<%
			int categoryId = (Integer) request.getAttribute("categoryId");
		%>
		<!-- Modal for adding the course. -->
		<div class="modal fade" id="addCourseModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<div>
							<h4 class="modal-title" id="courseTitle">Add a new course</h4>
							<i>Enter the below fields to add a new course.</i>
						</div>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="addCourseForm"
							action="<%=request.getContextPath()%>/AdminController/addCourse?cid=${categoryId}"
							method="post">
							<div class="form-group">
								<label class="control-label col-sm-5" for="courseName">Course
									Name:</label><input type="text" class=" col-sm-7" id="cName"
									name="courseName">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="coursePrice">Course
									Price:</label><input type="text" class=" col-sm-7" id="cPrice"
									name="coursePrice">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="courseDuration">Course
									Duration:</label><input class=" col-sm-7" type="text" id="cDuration"
									name="courseDuration">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="courseAuthor">Course
									Author:</label><input class=" col-sm-7" type="text" id="cAuthor"
									name="courseAuthor">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="courseDescription">Course
									Description:</label>
								<textarea rows="5" cols="5" id="cDescription" class=" col-sm-7"
									name="courseDescription"></textarea>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="totalSubCourse">Sub
									Course Count:</label><input class=" col-sm-7" type="text"
									id="tSubCount" name="totalSubCourse">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="imageUrl">Image
									Url:</label><input type="text" class=" col-sm-7" id="cUrl"
									name="imageUrl">
							</div>
							<input type="submit" value="Add" class="btn btn-info mt-2 mr-2">
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- Dynamic cards for listing all the courses -->
		<c:forEach var="c" items="${courses}">
			<div class="col-lg-4 col-sm-12">
				<div class="card">
					<img class="card-img-top" src="${c.getImageUrl()}">
					<div class="card-body">
						<div class="card-data">
							<h3 style="color: #663300;" class="card-title">${c.getCourseName()}</h3>
							<p>
								<i>by </i><b>${c.getCourseAuthor()}</b>
							</p>
							<input type="hidden" id="courseId" name="courseId"
								value="${c.getCourseId()}"> 
								<i>${c.getCourseDescription()}</i><br>
							<p style="color: #3377ff;">
								<b>&#8377; ${c.getCoursePrice() }</b>
							</p>

						</div>
						<a
							href="<%=request.getContextPath()%>/AdminController/showCourse?id=${c.getCourseId()}"
							id="updateButton" data-toggle="modal"
							data-target="#updateCourseModal" class="btn btn-info mt-2 mr-2"
							onclick="f(${c.getCourseId()}, '${c.getCourseName()}', '${c.getCoursePrice()}', '${c.getCourseDuration()}', '${c.getCourseAuthor()}', '${c.getCourseDescription()}', '${c.getTotalSubCourse()}', '${c.getImageUrl()}' )">Update</a>
						<a
							href="<%=request.getContextPath()%>/AdminController/deleteCourse?id=${ c.getCourseId()}&amp;cid=${c.getCategoryId()}"
							class="btn btn-info mt-2 mr-2">Delete</a> <a
							href="<%=request.getContextPath()%>/AdminController/listSubCourse?coid=${c.getCourseId()}"
							class="btn btn-info mt-2 mr-2">View subCourses</a>
					</div>
				</div>
			</div>
		</c:forEach>
		<!-- Modal for updating the course. -->
		<div class="modal fade" id="updateCourseModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="courseTitle">Update selected
							course</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="updateCatForm"
							action="<%=request.getContextPath()%>/AdminController/updateCourse?cid=${categoryId}"
							method="post">
							<div class="form-group">
								<label class="control-label col-sm-5" for="courseId">Course
									Id:</label><input type="text" class=" col-sm-7" id="cid"
									name="courseId" readonly="readonly">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="courseName">Course
									Name:</label><input type="text" class=" col-sm-7" id="cname"
									name="courseName">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="coursePrice">Course
									Price:</label><input type="text" class=" col-sm-7" id="cprice"
									name="coursePrice">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="courseDuration">Course
									Duration:</label><input type="text" class=" col-sm-7" id="cduration"
									name="courseDuration">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="courseAuthor">Course
									Author:</label><input class=" col-sm-7" type="text" id="cauthor"
									name="courseAuthor">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="courseDescription">Course
									Description:</label>
								<textarea rows="5" cols="5" id="cdescription" class=" col-sm-6"
									name="courseDescription"></textarea>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="totalSubCourse">Sub
									Course Count:</label><input class=" col-sm-7" type="text"
									id="tsubcount" name="totalSubCourse">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="imageUrl">Image
									Url:</label><input class=" col-sm-7" type="text" id="curl"
									name="imageUrl">
							</div>
							<input type="submit" value="Update"
								class="btn btn-info mt-2 mr-2">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<jsp:include page="footer.jsp"></jsp:include>