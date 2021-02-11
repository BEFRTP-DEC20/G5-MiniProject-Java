<html lang="en">
<%@ page isELIgnored="false" %>

<head>
<title>Index Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webjars/bootstrap/4.5.3/css/bootstrap.min.css">


</head>
<body>



<a href="<%=request.getContextPath()%>/AdminController/listCategory"  class="btn btn-primary">List</a>





<%-- <!-- Category Card. -->
<div class="card" style="width: 18rem;">
	<img class="card-img-top" src="..." alt="Card image cap">
	<div class="card-body">
		<h5 class="card-title">Category to be added</h5>
		<p class="card-text">Some quick example text to build on the card
			title and make up the bulk of the card's content.</p>
		<a href="#" class="btn btn-primary" data-toggle="modal"
			data-target="#categoryModal">Add Category</a>
	</div>
</div>

<!-- Modal for adding the category. -->
<div class="modal fade" id="categoryModal" tabindex="-1" role="dialog"
	aria-hidden="true">
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
						name="imageUrl"><br>
					<input type="submit" value="Add" class="btn btn-primary">
				</form>
			</div>
		</div>
	</div>
</div> --%>
<%-- <!--Update Category Card. -->
<div class="card" style="width: 18rem;">
	<img class="card-img-top" src="..." alt="Card image cap">
	<div class="card-body">
		<h5 class="card-title">Category name</h5>
		<a href="<%=request.getContextPath()%>/AdminController/showCategory" class="btn btn-primary" data-toggle="modal"
			data-target="#updateCategoryModal">Update</a>
			<a href="#" class="btn btn-primary">Delete</a>
	</div>
</div> 

<!-- Modal for updating the category. -->
<div class="modal fade" id="updateCategoryModal" tabindex="-1" role="dialog"
	aria-hidden="true">
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
						id="cId" name="categoryId" value="${category.categoryId }" readonly="readonly" ><br>
					<label for="categoryName">Category Name:</label><input type="text"
						id="cname" name="categoryName" value="${category.categoryName }"><br> <br> <label
						for="imageUrl">Image Url:</label><input type="text" id="curl"
						name="imageUrl" value="${category.imageUrl}"><br>
					<input type="submit" value="Update" class="btn btn-primary">
				</form>
			</div>
		</div>
	</div>
</div> --%>

		<script src="<%=request.getContextPath()%>/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/webjars/bootstrap/4.5.3/js/bootstrap.min.js"></script>
</body>
</html>
