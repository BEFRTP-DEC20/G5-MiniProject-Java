<%@page isELIgnored="false"%>
<%@page import="com.cybage.model.Category"%>
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

.addSymbol {
	left-margin: 19px;
	height: 10%;
	width: 10%;
}

.jumbotron {
	background-color: 60c7c1;
}
</style>
<script type="text/javascript">
	/* Function to show data in modal in update functionality. */
	function f(i, n, u){
		<%--  window.location.href= "<%=request.getContextPath()%>/AdminController/showCategory?id="+e; --%>
		document.getElementById("cId").value=i;
		document.getElementById("cName").value=n;
		document.getElementById("cUrl").value=u;
	}

</script>

<div class="col-lg-6 col-sm-12">
	<!-- Add a category card. -->
	<div class="card">
		<i class="fa fa-plus addSymbol" aria-hidden="true"></i>
		<div class="card-body">
			<h3 class="card-title">New Category</h3>
			<a data-toggle="modal" data-target="#addCategoryModal"
				class="btn btn-primary">Add a new category</a>
		</div>
	</div>

	<!-- Modal for adding the category. -->
	<div class="modal fade" id="addCategoryModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="categoryTitle">Add a Category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="addCatForm"
						action="<%=request.getContextPath()%>/AdminController/addCategory"
						method="post">
						<label for="categoryName">Category Name:</label><input type="text"
							id="cname" name="categoryName"><br> <br> <label
							for="imageUrl">Image Url:</label><input type="text" id="curl"
							name="imageUrl"><br> <input type="submit"
							value="Add" class="btn btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- Dynamic cards for listing all the categories -->

	<c:forEach var="c" items="${cat}">
		<div class="card">
			<img class="card-img-top" src="${c.getImageUrl()}">
			<div class="card-body">
				<h3 class="card-title">${c.getCategoryName()}</h3>
				<input type="hidden" id="categoryId1" name="catgoryId"
					value="${c.getCategoryId()}"> <a id="updateButton"
					data-toggle="modal" data-target="#updateCategoryModal"
					class="btn btn-primary"
					onclick="f(${c.getCategoryId()}, '${c.getCategoryName()}', '${c.getImageUrl()}' )">Update</a>

				<a
					href="<%=request.getContextPath()%>/AdminController/deleteCategory?id=${c.getCategoryId()}"
					class="btn btn-primary">Delete</a> <a
					href="<%=request.getContextPath()%>/AdminController/listCourse?cid=${c.getCategoryId()}"
					class="btn btn-primary">View Courses</a>
			</div>
		</div>
	</c:forEach>
	<!-- Modal for updating the category. -->
	<div class="modal fade" id="updateCategoryModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="categoryTitle">Update Category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="updateCatForm"
						action="<%=request.getContextPath()%>/AdminController/updateCategory"
						method="post">
						<label for="categoryId">Category Id:</label><input type="text"
							id="cId" name="categoryId" readonly="readonly"><br>
						<label for="categoryName">Category Name:</label><input type="text"
							id="cName" name="categoryName"><br> <br>
						<label for="imageUrl">Image Url:</label><input type="text"
							id="cUrl" name="imageUrl"><br> <input type="submit"
							value="Update" class="btn btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>


</div>
<jsp:include page="footer.jsp"></jsp:include>