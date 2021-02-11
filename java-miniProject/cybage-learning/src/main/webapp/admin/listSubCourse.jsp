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

video {
	width: 100% !important;
	height: auto !important;
	border-radius: 5px;
}
</style>
<script type="text/javascript">
	/* Function to show data in modal in update functionality. */
	function f(scid, scn, scd, ci, scde, scu, scvs){
		document.getElementById("cid").value=ci;
		document.getElementById("scname").value=scn;
		document.getElementById("scduration").value=scd;
		document.getElementById("scdescription").value=scde;
		document.getElementById("scvideourl").value=scu;
		document.getElementById("scvideoseq").value=scvs;
		document.getElementById("scid").value=scid;

	}

</script>

<div class="contrainer-fluid">
	<div id="headerTag">
		<h1>Sub-Courses</h1>
		<hr>
		<br>
	</div>
	<div class="row">
		<!-- Add a category card. -->
		<div class="col-lg-4 col-sm-12">
			<div class="card">
				<img class="card-img-top "
					src="https://cdn2.iconfinder.com/data/icons/multimedia-sound-7/48/Add_category-_playlist-512.png">
				<div class="card-body">
					<h4 class="card-title">New Sub-Course</h4>
					<a data-toggle="modal" data-target="#addSubCourseModal"
						class="btn btn-info mt-2 mr-2">Add a new Sub-Course</a>
				</div>
			</div>
		</div>
		<%
			int courseId = (Integer) request.getAttribute("courseId");
		%>
		<!-- Modal for adding the subcourse. -->
		<div class="modal fade" id="addSubCourseModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<div>
							<h5 class="modal-title" id="courseTitle">Add a new
								sub-course</h5>
							<i>Enter the below fields to add a new sub-course.</i>
						</div>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="addCourseForm"
							action="<%=request.getContextPath()%>/AdminController/addSubCourse?coid=${courseId}"
							method="post">
							<div class="form-group">
								<label class="control-label col-sm-5" for="subCourseName">SubCourse
									Name:</label><input class=" col-sm-7" type="text" id="scName"
									name="subCourseName">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="subCourseDuration">SubCourse
									Duration:</label><input class=" col-sm-7" type="text" id="scDuration"
									name="subCourseDuration">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="subCourseDescription">SubCourse
									Description:</label>
								<textarea rows="5" id="scDescription" class=" col-sm-6"
									name="subCourseDescription"></textarea>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="videoUrl">Video
									URL:</label><input type="text" class=" col-sm-7" id="videoUrl"
									name="videoUrl">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="videoSeq">Video
									Sequence:</label> <input type="text" class="col-sm-6" id="videoSeq"
									name="videoSeq">
							</div>
							<input type="submit" value="Add" class="btn btn-info mt-2 mr-2">
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- Dynamic cards for listing all the Sub courses -->
		<c:forEach var="c" items="${subcourses}">
			<div class="col-lg-4 col-sm-12">
				<div class="card">
					<video controls>
						<source src="${c.getVideoUrl()}" type="video/mp4" />
					</video>
					<div class="card-body">
						<input type="hidden" id="subcourseId" name="subcourseId"
							value="${c.getSubCourseId()}">
						<div class="card-data">
							<h3 style="color: #663300;" class="card-title">${c.getSubCourseName()}</h3>
							<p style="color: #ff0000;">
								<b> ${c.getSubCourseDuration() } Hours</b>
							</p>
							<i>${c.getSubCourseDescription()}</i><br>
						</div>


						<a id="updateButton" data-toggle="modal"
							data-target="#updateSubCourseModal"
							class="btn btn-info mt-2 mr-2"
							onclick="f(${c.getSubCourseId()}, '${c.getSubCourseName()}',
					 '${c.getSubCourseDuration()}', '${c.getCourseId()}', '${c.getSubCourseDescription()}',
					   '${c.getVideoUrl()}', '${c.getVideoSequence()}' )">Update
						</a> <a
							href="<%=request.getContextPath()%>/AdminController/deleteSubCourse?scid=${ c.getSubCourseId()}&amp;coid=${c.getCourseId()}"
							class="btn btn-info mt-2 mr-2">Delete</a>
					</div>
				</div>
			</div>
		</c:forEach>

		<!-- Modal for updating the subcourse. -->
		<div class="modal fade" id="updateSubCourseModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="courseTitle">Update selected
							sub-course</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="updateSubCourseForm"
							action="<%=request.getContextPath()%>/AdminController/updateSubCourse?coid=${courseId}"
							method="post">

							<input type="hidden" id="cid" name="cid">
							<div class="form-group">
								<label class="control-label col-sm-5" for="subcourseId">Sub-Course
									Id:</label> <input class=" col-sm-6" type="text" id="scid"
									name="subcourseId" readonly="readonly">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="subcourseName">Sub-Course
									Name:</label> <input class=" col-sm-6" type="text" id="scname"
									name="scname">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="subcourseDuration">Sub-Course
									Duration:</label> <input class=" col-sm-6" type="text" id="scduration"
									name="scduration">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="subcourseDescription">Sub-Course
									Description:</label> <input type="text" id="scdescription"
									class=" col-sm-6" name="scdescription">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="subcoursevideoUrl">Video
									Url:</label> <input class=" col-sm-6" type="text" id="scvideourl"
									name="scvideourl">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="subcoursevideoSeq">Video
									Sequence:</label> <input class=" col-sm-6" type="text" id="scvideoseq"
									name="scvideoseq">
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