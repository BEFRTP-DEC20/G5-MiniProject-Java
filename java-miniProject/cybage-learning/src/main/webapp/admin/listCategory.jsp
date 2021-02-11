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
	function f(i, n, u){
		<%--  window.location.href= "<%=request.getContextPath()%>/AdminController/showCategory?id="+e; --%>
		document.getElementById("cId").value=i;
		document.getElementById("cName").value=n;
		document.getElementById("cUrl").value=u;
	}

</script>

<div class="contrainer-fluid">
<div id="headerTag">
<h1>Categories</h1><hr><br>
</div>
	<div class="row">
		<!-- Add a category card. -->
		<div class="col-lg-4 col-sm-12">
			<div class="card">
				<img class="card-img-top "
					src="https://cdn2.iconfinder.com/data/icons/multimedia-sound-7/48/Add_category-_playlist-512.png">
				<div class="card-body">
					<h3 class="card-title">New Category</h3>
					<a data-toggle="modal" data-target="#addCategoryModal"
						class="btn btn-info mt-2 mr-2">Add a new category</a>
				</div>
			</div>
		</div>
		<!-- Modal for adding the category. -->
		<div class="modal fade" id="addCategoryModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<div>
							<h4 class="modal-title" id="categoryTitle">Add a new category</h4>
							<i>Enter the below fields to add a new category.</i>
						</div>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="addCatForm"
							action="<%=request.getContextPath()%>/AdminController/addCategory"
							method="post">
							<div class="form-group">
								<label class="control-label col-sm-5" for="categoryName">Category
									Name:</label><input class=" col-sm-7" type="text" id="cname"
									name="categoryName">
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5" for="imageUrl">Image
									Url:</label><input type="text" class=" col-sm-7" id="curl"
									name="imageUrl">
							</div>
							<input type="submit" value="Add" class="btn btn-info mt-2 mr-2">
						</form>
					</div>
				</div>
			</div>
		</div>


		<!-- Dynamic cards for listing all the categories -->

		<c:forEach var="c" items="${cat}">
			<div class="col-lg-4 col-sm-12">
				<div class="card">
					<img class="card-img-top " src="${c.getImageUrl()}">
					<div class="card-body">
						<h3 style="color: #663300;" class="card-title">${c.getCategoryName()}</h3>
						<input type="hidden" id="categoryId1" name="catgoryId"
							value="${c.getCategoryId()}"> <a id="updateButton"
							data-toggle="modal" data-target="#updateCategoryModal"
							class="btn btn-info mt-2 mr-2 "
							onclick="f(${c.getCategoryId()}, '${c.getCategoryName()}', '${c.getImageUrl()}' )">Update</a>

						<a
							href="<%=request.getContextPath()%>/AdminController/deleteCategory?id=${c.getCategoryId()}"
							class="btn btn-info mt-2 mr-2">Delete</a> <a
							href="<%=request.getContextPath()%>/AdminController/listCourse?cid=${c.getCategoryId()}"
							class="btn btn-info mt-2 mr-2 ">View Courses</a>
					</div>
				</div>
			</div>
		</c:forEach>
		<!-- Modal for updating the category. -->
		<div class="modal fade" id="updateCategoryModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="categoryTitle">Update selected category</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="updateCatForm"
							action="<%=request.getContextPath()%>/AdminController/updateCategory"
							method="post">
							<div class="form-group">
								<label class="control-label col-sm-5" for="categoryId">Category
									Id:</label><input type="text" class=" col-sm-7" id="cId"
									name="categoryId" readonly="readonly">
							</div>

							<div class="form-group">
								<label class="control-label col-sm-5" for="categoryName">Category
									Name:</label><input class=" col-sm-7" type="text" id="cName"
									name="categoryName">
							</div>

							<div class="form-group">
								<label class="control-label col-sm-5" for="imageUrl">Image
									Url:</label><input type="text" class=" col-sm-7" id="cUrl"
									name="imageUrl">
							</div>
							<input type="submit" value="Update" class="btn btn-info">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>