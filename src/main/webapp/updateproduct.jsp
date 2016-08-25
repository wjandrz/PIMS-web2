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
								<input type="text" id="productName" placeholder="Name" required="true" /> <br />
								<input type="text" id="productDescription" placeholder="Description" required="true" /> <br /> 
								<input type="text" id="shortName" placeholder="Short Name" required="true" /> <br /> 
								<input type="text" id="unitCost" placeholder="Unit Cost" required="true" /> <br /> 
								<input type="text" id="packSize" placeholder="Pack Size" required="true" /> <br />
								<input type="text" id="reorderQuantity" placeholder="Reorder Quantity" required="true" /> <br /> 
								<input type="text" id="retailPrice" placeholder="Retail Price" required="true" /> <br /> 
								<input type="text" id="productWeight" placeholder="Weight" /> <br /> 
								<input type="text" id="quantityOnHand" placeholder="Quantity on Hand" /> <br /> 
								<input type="file" id="productImage" placeholder="Image" /> <br />
								<select name="newProdCategories[]" id="newProdCategories" multiple>
									<c:forEach var="t" items="${prodCat}">
										<option value="${t.categoryId}"><c:out value="${t.categoryDescription}" /></option>
									</c:forEach>
								</select>
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
			<select id="selectProduct">
				<c:forEach var="prod" items="${allProducts}">
					<option value="${prod.productUpc}"><c:out value="${prod.productName}" /></option>
				</c:forEach>
			</select>
		<br />
		
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
								<input type="text" id="productName" placeholder="Name" required="true" /> <br />
								<input type="text" id="productDescription" placeholder="Description" required="true" /> <br /> 
								<input type="text" id="shortName" placeholder="Short Name" required="true" /> <br /> 
								<input type="text" id="unitCost" placeholder="Unit Cost" required="true" /> <br /> 
								<input type="text" id="packSize" placeholder="Pack Size" required="true" /> <br />
								<input type="text" id="reorderQuantity" placeholder="Reorder Quantity" required="true" /> <br /> 
								<input type="text" id="retailPrice" placeholder="Retail Price" required="true" /> <br /> 
								<input type="text" id="productWeight" placeholder="Weight" /> <br /> 
								<input type="text" id="quantityOnHand" placeholder="Quantity on Hand" /> <br /> 
								<input type="file" id="productImage" placeholder="Image" /> <br />
								<select name="categories[]" id="categories" multiple>
									<c:forEach var="t" items="${prodCat}">
										<option value="${t.categoryId}"><c:out value="${t.categoryDescription}" /></option>
									</c:forEach>
								</select>
						</div>
					</div>
					
					<div class="modal-footer">
						<input id="prodAdd" type="button" class="btn btn-primary" value="Add Product" />
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
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="deleteProductTitle">Delete Product</h4>
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
			$("#selectProduct").change(function(){
					$.ajax({
						// accepts application/json
						headers: {          
				    		Accept : "application/json; charset=utf-8"
			    		}, 
						url: "http://localhost:7001/PIMS-web2/fillProduct.do?value="+$("#selectProduct").val(),
						method: "GET",
						success: function(resp){
							$("#productName").val(resp.productName);
							$("#productDescription").val(resp.productDescription);
							$("#shortName").val(resp.shortName);
							$("#unitCost").val(resp.unitCost);
							$("#packSize").val(resp.packSize);
							$("#reorderQuantity").val(resp.reorderQuantity);
							$("#productWeight").val(resp.productWeight);
							$("#quantityOnHand").val(resp.quantityOnHand);
// 							$("#productImage").val(resp.productImage);
							$("#categories").val(resp.categories.categoryId);
							
						}
					});
					$("#sdelete").hide();
			        $("#smdelete").show();
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
		
		$(document).ready(function() {
			$("#prodAdd").click(function() {
				var productName = $("#productName").val();
				var productDescription = $("#productDescription").val();
				var shortName = $("#shortName").val();
				var unitCost = $("#unitCost").val();
				var packSize = $("#packSize").val();
				var reorderQuantity = $("#reorderQuantity").val();
				var retailPrice = $("#retailPrice").val();
				var productWeight = $("#productWeight").val();
				var quantityOnHand = $("#quantityOnHand").val();
				var productImage = $("#productImage").val();
				
				var selectProdCategories = document.getElementById("newProdCategories");
				var prodCategories = new Array();
 				for (var i = 0; i < selectProdCategories.options.length; i++) {
    				if(selectProdCategories.options[i].selected ==true){
          				prodCategories.push(selectProdCategories.options[i].value);
          				console.log(prodCategories);
      				}
      			}
				
				$.ajax({
					headers: {                
		    			"Content-Type": "application/json; charset=utf-8"   
					} ,
					url: "http://localhost:7001/PIMS-web2/addProduct.do",
					method: "POST",
					data: JSON.stringify({
						strName: productName, strDesc : productDescription, strShName : shortName,
						strUnitCost: unitCost, strPackSize: packSize, strReQuat: reorderQuantity, strRetail: retailPrice,
						strQOH: quantityOnHand, strProdCat: prodCategories}),
// 					error: function(req, err){ console.log('my message' + err)},
					success: function(){
						alert("Product successfully added!");
					}
				})
				
				$("#productName").val("");
				$("#productDescription").val("");
				$("#shortName").val("");
				$("#unitCost").val("");
				$("#packSize").val("");
				$("#reorderQuantity").val("");
				$("#retailPrice").val("");
				$("#productWeight").val("");
				$("#quantityOnHand").val("");
				$("#productImage").val("");
				
			});
		});
	</script>
</body>
</html>