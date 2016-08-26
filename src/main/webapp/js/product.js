$(document).ready(function() {
			$("#myBtn").click(function() {
				$("#newProductModal").modal();
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
	
		$(document).ready(function() {
			$("#selectProduct").change(function(){
					//var sp = document.getElementById("#selectProduct");
					//var select = sp.options[sp.selectedIndex].value;
//					var sp = document.getElementByName("#selected");
//					console.log(sp);
//					console.log(sp.value);
					var value = $("#selectProduct").val();
					console.log(value);
					
					$.ajax({
						// accepts application/json
						headers: {          
				    		Accept : "application/json; charset=utf-8"
			    		}, 
						url: "http://localhost:7001/PIMS-web2/fillProduct.do?value="+value,
						method: "GET",
						success: function(resp){
							$("#uProductName").val(resp.productName);
							$("#uProductDescription").val(resp.productDescription);
							$("#uShortName").val(resp.shortName);
							$("#uUnitCost").val(resp.unitCost);
							$("#uPackSize").val(resp.packSize);
							$("#uReorderQuantity").val(resp.reorderQuantity);
							$("#uRetailPrice").val(resp.retailPrice);
							$("#uQuantityOnHand").val(resp.quantityOnHand);
// 							$("#productImage").val(resp.productImage);
							//$("#categories").val(resp.categories.categoryId);
							
						}
					});
//					$("#sdelete").hide();
//			        $("#smdelete").show();
				});
		});
		
		$(document).ready(function() {
			$("#updateProd").click(function() {
				var productUpc = $("#selectProduct").val();
				var productName = $("#uProductName").val();
				var productDescription = $("#uProductDescription").val();
				var shortName = $("#uShortName").val();
				var unitCost = $("#uUnitCost").val();
				var packSize = $("#uPackSize").val();
				var reorderQuantity = $("#uReorderQuantity").val();
				var retailPrice = $("#uRetailPrice").val();
				var productWeight = $("#uProductWeight").val();
				var quantityOnHand = $("#uQuantityOnHand").val();
				var productImage = $("#uProductImage").val();
				
				var selectProdCategories = document.getElementById("uCategories");
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
					url: "http://localhost:7001/PIMS-web2/updateProduct.do",
					method: "POST",
					data: JSON.stringify({ productUpc: productUpc,
						strName: productName, strDesc : productDescription, strShName : shortName,
						strUnitCost: unitCost, strPackSize: packSize, strReQuat: reorderQuantity, strRetail: retailPrice,
						strQOH: quantityOnHand, strProdCat: prodCategories}),
					success: function(){
						alert("Product successfully updated!");
					}
				})
				
			});
//			$("#delete").show();
			$("#confirmDelete").hide();	        
		});
$(document).ready(function(){
		$("#delete").click(function(){
			$("#confirmDelete").show();
	        $("#delete").hide();
		});
			
		$("#confirmDelete").click(function(){
			var productUpc = $("#selectProduct").val();
			
			$.ajax({
				// contentType application/json
				headers: {          
	    			"Content-Type": "application/json; charset=utf-8"
	    		},
				url: "http://localhost:7001/PIMS-web2/removeProduct.do",
				method: "POST",
				data: JSON.stringify({
					 productUpc: productUpc
				}),
				success: function(){
					alert("Removed product successfully!");
				}
			});
	});
});
		
		
