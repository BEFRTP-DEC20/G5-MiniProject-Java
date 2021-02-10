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

.jumbotron {
	background-color: 60c7c1;
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

<div class="col-lg-6 col-sm-12">
	<!-- Add a category card. -->
	<div class="card">
		<i class="fa fa-plus addSymbol" aria-hidden="true"></i>
		<div class="card-body">
			<h3 class="card-title">New Course</h3>
			<a data-toggle="modal" data-target="#addSubCourseModal"
				class="btn btn-primary">Add a new Subcourse</a>
		</div>
	</div>
	<%
		int courseId = (Integer) request.getAttribute("courseId");
	%>
	<!-- Modal for adding the subcourse. -->
	<div class="modal fade" id="addSubCourseModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="courseTitle">Add a SubCourse</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="addCourseForm"
						action="<%=request.getContextPath()%>/AdminController/addSubCourse?coid=${courseId}"
						method="post">
						<label for="subCourseName">SubCourse Name:</label><input
							type="text" id="scName" name="subCourseName"><br> <br>
						<label for="subCourseDuration">SubCourse Duration:</label><input
							type="text" id="scDuration" name="subCourseDuration"><br>
						<br> <label for="subcourseDescription">SubCourse
							Description:</label>
						<textarea rows="5" cols="5" id="scDescription"
							name="subCourseDescription"></textarea>
						<br> <br> <label for="videoUrl">Video URL:</label><input
							type="text" id="videoUrl" name="videoUrl"><br> <br>
						<label for="videoSeq">Video Sequence:</label> <input type="text"
							id="videoSeq" name="videoSeq"> <input type="submit"
							value="Add" class="btn btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- Dynamic cards for listing all the Sub courses -->
	<c:forEach var="c" items="${subcourses}">
		<div class="card">
			<img class="card-img-top" src="${c.getSubCvidUrl()}">
			<div class="card-body">
				<h3 class="card-title">${c.getSubCourseName()}</h3>
				<input type="hidden" id="subcourseId" name="subcourseId"
					value="${c.getSubCourseId()}"> <a id="updateButton"
					data-toggle="modal" data-target="#updateSubCourseModal"
					class="btn btn-primary"
					onclick="f(${c.getSubCourseId()}, '${c.getSubCourseName()}',
					 '${c.getSubCourseDuration()}', '${c.getCourseId()}', '${c.getSubCourseDesc()}',
					   '${c.getSubCvidUrl()}', '${c.getSubCvidSeq()}' )">Update
				</a> <a
					href="<%=request.getContextPath()%>/AdminController/deleteSubCourse?scid=${ c.getSubCourseId()}&amp;coid=${c.getCourseId()}"
					class="btn btn-primary">Delete</a>
			</div>
		</div>
	</c:forEach>

	<!-- Modal for updating the subcourse. -->
	<div class="modal fade" id="updateSubCourseModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="courseTitle">Update Sub Course</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="updateSubCourseForm"
						action="<%=request.getContextPath()%>/AdminController/updateSubCourse?coid=${courseId}"
						method="post">
						<input type="hidden" id="cid" name="cid"><br>
						<br> <label for="subcourseId">Sub-Course Id:</label> <input
							type="text" id="scid" name="subcourseId" readonly="readonly"><br>
						<br> <label for="subcourseName">Sub-Course Name:</label> <input
							type="text" id="scname" name="scname"><br>
						<br> <label for="subcourseDuration">Sub-Course
							Duration:</label> <input type="text" id="scduration" name="scduration"><br>
						<br> <label for="subcourseDescription">Sub-Course
							Description:</label> <input type="text" id="scdescription"
							name="scdescription"><br>
						<br> <label for="subcoursevideoUrl">Video Url:</label> <input
							type="text" id="scvideourl" name="scvideourl"><br>
						<br> <label for="subcoursevideoSeq">Video Sequence:</label> <input
							type="text" id="scvideoseq" name="scvideoseq"><br>
						<br> <input type="submit" value="Update"
							class="btn btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>


</div>
<jsp:include page="footer.jsp"></jsp:include>