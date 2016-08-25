<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<body>
	<div class="container theme-showcase" role="main">
		<label for="clients">Clients</label>
		<select id="clients">
			<c:forEach var="t" items="${client}">
				<option value="${t.clientId}"><c:out value="${t.clientName}"/></option>
			</c:forEach>
		</select>
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
				<td>Tax</td>
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
					$("#invoice tr:last").after("<tr><td><span class='del'>[-]</span></td>"
					+"<td><input id='"+resp.productUpc+"prod'readonly='readonly' value='"+resp.productName+"'/></td>"
					+"<td><input id='"+resp.productUpc+"desc' readonly='readonly' value='"+resp.productDescription+"'/></td>"
					+"<td><input id='"+resp.productUpc+"price' readonly='readonly' value='"+resp.retailPrice+"'/></td>"
					+"<td><input id='"+resp.productUpc+"qty'/></td>"
					+"<td><input id='"+resp.productUpc+"total' readonly='readonly'/></td></tr>");
				}
			});
		});
	});
	$(document).ready(function(){
		$("#invoice").on("click", ".del", function(){
			$(this).parent().parent().remove();
		});
		$("#invoice").on("keyup", "[id$=qty]", function(){
			var sum = 0;
			var qty = $(this).val();
			var price = $(this).parent().prev().children("[id$=price]").val();
			$(this).parent().next().children("[id$=total").val(qty*price);
			$("[id$=total").each(function(){
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