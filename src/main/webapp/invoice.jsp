<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAZP Invoice</title>
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
		integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
		integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" 
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<%@ include file="navbar.jsp"%>
<body>
	<div class="container theme-showcase" role="main">
		<label for="clients">Clients</label>
		<select id="clients">
			<c:forEach var="t" items="${client}">
				<option value="${t.clientId}"><c:out value="${t.clientName}"/></option>
			</c:forEach>
		</select>
		<input type="hidden" id="clienttype"/>
		<label for="products">Products</label>
		<select id="products">
			<c:forEach var="t" items="${prod}">
				<option value="${t.productUpc}"><c:out value="${t.productName}"/></option>
			</c:forEach>
		</select>
		<table id="invoice" class="table table-hover">
			<tr>
				<th></th>
				<th>Product</th>
				<th>Desc</th>
				<th>Price</th>
				<th>QTY</th>
				<th>Total</th>
			</tr>
		</table>
		<table class="table table-hover">
			<tr>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>SubTotal</td>
				<td><input id="subttl" readonly="readonly"/></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>Tax(6%)</td>
				<td><input id="tax" readonly="readonly"/></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>Total</td>
				<td><input id="grandttl" readonly="readonly"/></td>
			</tr>
		</table>
		<input type="button" class="btn btn-success" id="submit" value="Submit"/>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#products").change(function(){
			$.ajax({
				// accepts application/json
				headers: {          
		    		Accept : "application/json; charset=utf-8"
    			}, 
				url: "http://localhost:7001/PIMS-web2/fillLine.do?value="+$("#products").val(),
				method: "GET",
				success: function(resp){
					$("#invoice tr:last").after("<tr class='line'><td><span class='del'>[-]</span></td>"
					+"<td class='prod'><input type='hidden' id='"+resp.productUpc+"prod' value='"+resp.productUpc+"'/><input id='"+resp.productName+"name'readonly='readonly' value='"+resp.productName+"'/></td>"
					+"<td class='desc'><input id='"+resp.productUpc+"desc' readonly='readonly' value='"+resp.productDescription+"'/></td>"
					+"<td class='price'><input id='"+resp.productUpc+"price' readonly='readonly' value='"+resp.retailPrice+"'/></td>"
					+"<td class='qty'><input id='"+resp.productUpc+"qty'/></td>"
					+"<td class='total'><input id='"+resp.productUpc+"total' readonly='readonly'/></td></tr>");
				}
			});
		});
		/*$("#clients").change(function(){
			$.ajax({
				// accepts application/json
				headers: {          
	    			Accept : "application/json; charset=utf-8"
    			}, 
				url: "http://localhost:7001/PIMS-web2/getclientType.do?value="+$("#clients").val(),
				method: "GET",
				success: function(resp){
					$("#sclientName").val(resp.clientName);
					$("#sclientEmail").val(resp.clientEmail);
					$("#spointOfContactName").val(resp.pointOfContactName);
					$("#sclientPhone").val(resp.clientPhone);
					$("#sclientFax").val(resp.clientFax);
					$("#saddressId").val(resp.addressId.addressId);
					$("#sstreetAddress1").val(resp.addressId.streetAddress1);
					$("#sstreetAddress2").val(resp.addressId.streetAddress2);
					$("#saddressCity").val(resp.addressId.addressCity);
					$("#sstateId").val(resp.addressId.stateId.abbrvId);
					$("#saddressZip").val(resp.addressId.addressZip);
					$("#stype").val(resp.clientTypeId.clientTypeId);
				}
			});
		});*/
	});
	$(document).ready(function(){
		$("#submit").click(function(){
			var clientId = $("#clients").val();
			var subtotal = $("#subttl").val(); 
			var tax = $("#tax").val();
			var total = $("#grandttl").val();
			$.ajax({
				// contentType application/json
				headers: {          
	    			"Content-Type": "application/json; charset=utf-8"
    			},
				url: "http://localhost:7001/PIMS-web2/makeInvoice.do",
				method: "POST",
				data: JSON.stringify({
					subtotal : subtotal, taxAmount : tax, poTotal : total, clientId : clientId
				}),
				success: function(){
					//alert("Invoice added successfully!");
				}
			});
			var i=1;
			$("tr.line").each(function(){
				var unitprice = $(this).find("[id$='price']").val();
				var quantity = $(this).children(".qty").children("[id$='qty']").val();
				var productupc = $(this).children(".prod").children("[id$='prod']").val();
				$.ajax({
					// contentType application/json
					headers: {          
		    			"Content-Type": "application/json; charset=utf-8"
    				},
					url: "http://localhost:7001/PIMS-web2/addLine.do",
					method: "POST",
					data: JSON.stringify({
						productUpc : productupc, unitPrice : unitprice, qty : quantity, lineNumber : i
					}),
					success: function(){
						alert("Invoice added successfully!");
					}
				});
				i++;
			});
		});
	});
	$(document).ready(function(){
		$("#invoice").on("click", ".del", function(){
			$(this).parent().parent().remove();
			var sum = 0;
			var qty = $(this).val();
			var price = $(this).parent().prev().children("[id$='price']").val();
			$(this).parent().next().children("[id$='total']").val((qty*price).toFixed(2));
			$("[id$='total']").each(function(){
				sum += Number($(this).val());
			});
			$("#subttl").val(sum.toFixed(2));
			$("#tax").val((sum*.06).toFixed(2));
			$("#grandttl").val((sum*1.06).toFixed(2));
		});
		$("#invoice").on("keyup", "[id$='qty']", function(){
			var sum = 0;
			var qty = $(this).val();
			var price = $(this).parent().prev().children("[id$='price']").val();
			$(this).parent().next().children("[id$='total']").val((qty*price).toFixed(2));
			$("[id$='total']").each(function(){
				sum += Number($(this).val());
			});
			$("#subttl").val(sum.toFixed(2));
			$("#tax").val((sum*.06).toFixed(2));
			$("#grandttl").val((sum*1.06).toFixed(2));
		});
	});
</script>
</body>
</html>