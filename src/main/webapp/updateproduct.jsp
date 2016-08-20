<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container theme-showcase" role="main">
		<button type="button" id="newProduct" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#newProductModal">
			Insert a New Product
		</button>

		<div class="modal fade" id="newProductModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="newProductTitle">New Product</h4>
					</div>
					<div class="modal-body">
						<div class="container theme-showcase" role="main">
							<form:form action="addProduct.do" method="post" commandName="newProd">
								<form:input type="text" path="productName" placeholder="Name" required="true" /> <br />
								<form:input type="text" path="productDescription" placeholder="Description" required="true" /> <br /> 
								<form:input type="text" path="shortName" placeholder="Short Name" required="true" /> <br /> 
								<form:input type="text" path="unitCost" placeholder="Unit Cost" required="true" /> <br /> 
								<form:input type="text" path="packSize" placeholder="Pack Size" required="true" /> <br />
								<form:input type="text" path="reorderQuantity" placeholder="Reoder Quantity" required="true" /> <br /> 
								<form:input type="text" path="retailPrice" placeholder="Retail Price" required="true" /> <br /> 
								<form:input type="text" path="productWeight" placeholder="Weight" /> <br /> 
								<form:input type="file" path="productImage" placeholder="Image" /> <br />
								<button type="submit" class="btn btn-primary">Add</button>
							</form:form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<h3>Update/Delete Product</h3>
		<form action="" method="POST">
			<select>
				<option></option>
			</select>
		</form>
		<br />
		<button type="button" id="updateProduct"
			class="btn btn-primary btn-lg" data-toggle="modal"
			data-target="#updateProductModal">Update Product</button>

		<div class="modal fade" id="updateProductModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="updateProductTitle">Update Product</h4>
					</div>
					<div class="modal-body">
						<div class="container theme-showcase" role="main">
							<form action="" method="post">
								<input type="text" placeholder="Name" required="true"> <br />
								<input type="text" placeholder="Description" required="true">
								<br /> <input type="text" placeholder="Short Name"
									required="true"> <br /> <input type="text"
									placeholder="Unit Cost" required="true"> <br /> <input
									type="text" placeholder="Pack Size" required="true"> <br />
								<input type="text" placeholder="Reoder Quantity" required="true">
								<br /> <input type="text" placeholder="Retail Price"
									required="true"> <br /> <input type="text"
									placeholder="Weight"> <br /> <input type="file"
									placeholder="Image"> <br />
								<button type="submit" class="btn btn-primary">Add</button>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<button type="button" id="deleteProduct"
			class="btn btn-primary btn-lg" data-toggle="modal"
			data-target="#deleteProductModal">
			<i class="glyphicon glyphicon-remove-circle"> Delete Product</i>
		</button>

		<div class="modal fade" id="deleteProductModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="deleteProductTitle">Delete
							Product</h4>
					</div>
					<div class="modal-body">
						<div class="container theme-showcase" role="main">
							<form action="" method="post">
								<input type="radio" name="accept" value="true"> Confirm
								<input type="radio" name="accept" value="false"> Deny <br />
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script>
		$(document).ready(function() {
			$("#myBtn").click(function() {
				$("#newProductModal").modal();
			});
		});

		$(document).ready(function() {
			$("#myBtn").click(function() {
				$("#updateProductModal").modal();
			});
		});

		$(document).ready(function() {
			$("#myBtn").click(function() {
				$("#deleteProductModal").modal();
			});
		});
	</script>
</body>
</html>