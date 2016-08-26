<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAZP Products</title>
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
<script type="text/javascript" src="js/product.js" ></script>
<link rel="stylesheet" href="css/external.css" />
</head>
<%@ include file="navbar.jsp"%>
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
							<table>
								<tr><td>Product Name</td></tr>
								<tr><td>
									<input type="text" id="productName" placeholder="Name" required="true" />
								</td></tr>
								<tr><td>Product Description</td><td>Short Name</td></tr>
								<tr><td>
									<input type="text" id="productDescription" placeholder="Description" required="true" />
								</td><td> 
									<input type="text" id="shortName" placeholder="Short Name" required="true" />
								</td></tr>
								<tr><td>Unit Cost</td><td>Retail Price</td></tr>
								<tr><td>
									<input type="text" id="unitCost" placeholder="Unit Cost" required="true" />
								</td><td> 
									<input type="text" id="retailPrice" placeholder="Retail Price" required="true" />
								</td></tr>
								<tr><td>Pack Size</td><td>Reorder Quantity</td></tr>
								<tr><td> 
									<input type="text" id="packSize" placeholder="Pack Size" required="true" />
								</td><td>
									<input type="text" id="reorderQuantity" placeholder="Reorder Quantity" required="true" />
								</td></tr>
								<tr><td>Quantity on Hand</td><td>Weight</td></tr>
								<tr><td> 
									<input type="text" id="quantityOnHand" placeholder="Quantity on Hand" />
								</td><td>
									<input type="text" id="productWeight" placeholder="Weight" />
								</td></tr>
								<tr><td>Image</td><td>Categories</td></tr>
								<tr><td>								
									<input type="file" id="productImage" placeholder="Image" disabled="disabled"/>
								</td><td>
									<select name="newProdCategories[]" id="newProdCategories" multiple>
										<c:forEach var="t" items="${prodCat}">
											<option value="${t.categoryId}"><c:out value="${t.categoryDescription}" /></option>
										</c:forEach>
									</select>
								</td></tr>
							</table>
						</div>
					</div>
					
					<div class="modal-footer">
						<input id="prodAdd" type="button" class="btn btn-primary" value="Add Product" />
<!-- 						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
						<input type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='create.do';" value="Close" />
					</div>
				</div>
			</div>
		</div>
		
		<h3>Update/Delete Product</h3>
		<select name="selected" id="selectProduct">
			<c:forEach var="prod" items="${allProducts}">
				<option value="${prod.productUpc}"><c:out
						value="${prod.productName}" /></option>
			</c:forEach>
		</select> <br />
		
		<input type="button" id="updateProduct" class="btn btn-primary btn-lg" data-toggle="modal"	data-target="#updateProductModal" value="Update/Delete Product" />

		<div class="modal fade" id="updateProductModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
				
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="updateProductTitle">Update Product</h4>
					</div>

					<div class="modal-body">
						<div class="container theme-showcase" role="main">
							<table>
								<tr><td>Product Name</td></tr>
								<tr><td>
									<input type="text" id="uProductName" placeholder="Name" required="true" />
								</td></tr>
								<tr><td>Product Description</td><td>Short Name</td></tr>
								<tr><td>
									<input type="text" id="uProductDescription" placeholder="Description" required="true" />
								</td><td> 
									<input type="text" id="uShortName" placeholder="Short Name" required="true" />
								</td></tr>
								<tr><td>Unit Cost</td><td>Retail Price</td></tr> 
								<tr><td>
									<input type="text" id="uUnitCost" placeholder="Unit Cost" required="true" />
								</td><td> 
									<input type="text" id="uRetailPrice" placeholder="Retail Price" required="true" />
								</td></tr>
								<tr><td>Pack Size</td><td>Reorder Quantity</td></tr>
								<tr><td>
									<input type="text" id="uPackSize" placeholder="Pack Size" required="true" />
								</td><td>
									<input type="text" id="uReorderQuantity" placeholder="Reorder Quantity" required="true" /> 
								</td></tr>
								<tr><td>Quantity on Hand</td><td>Product Weight</td></tr>
								<tr><td>
									<input type="text" id="uQuantityOnHand" placeholder="Quantity on Hand" />
								</td><td>
									<input type="text" id="uProductWeight" placeholder="Weight" /> 
								</td></tr>
								<tr><td>Image</td><td>Categories</td></tr>
								<tr><td>
									<input type="file" id="uProductImage" placeholder="Image" disabled="disabled"/>
								</td><td>
									<select name="categories[]" id="uCategories" multiple>
										<c:forEach var="t" items="${prodCat}">
											<option value="${t.categoryId}"><c:out value="${t.categoryDescription}" /></option>
										</c:forEach>
									</select>
								</td></tr>
							</table>
						</div>
					</div>
					
					<div class="modal-footer">
						<input id="updateProd" type="button" class="btn btn-primary" value="Update Product" />
						<input id="delete" type="button" class="btn btn-warning" value="Delete" />
						<input id="confirmDelete" type="button" class="btn btn-danger" value="Are you sure?" />
						<button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='create.do';">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>