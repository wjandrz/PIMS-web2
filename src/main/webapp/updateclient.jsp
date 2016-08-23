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
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#newModal">
		New Client
	</button>
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updateSupplier">
		Update/Delete Supplier
	</button>
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updateRetailer">
		Update/Delete Retailer
	</button>

	<div class="modal fade" id="newModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">New Client</h4>
					</div>
						<div class="modal-body">
							<input type="text" id="clientName" placeholder="Name" required="true" /> <br />
							<input type="text" id="clientEmail" placeholder="Email" required="true" /> <br />
							<input type="text" id="pointOfContactName" placeholder="Point of Contact Name" required="true" /> <br />
							<input type="text" id="clientPhone" placeholder="Phone Number" required="true" /> <br />
							<input type="text" id="clientFax" placeholder="Fax" required="true" /> <br />
							<input type="text" id="streetAddress1" placeholder="Street Address 1" required="true" /> <br />
							<input type="text" id="streetAddress2" placeholder="Street Address 2" required="true" /> <br />
							<input type="text" id="addressCity" placeholder="City" required="true" /> <br />
							<select id="stateId" required="true">
								<c:forEach var="t" items="${saabb}">
									<option value="${t.abbrvId}"><c:out value="${t.stateAbbrv}"/></option>
								</c:forEach>
							</select>
							<br />
							<input type="text" id="addressZip" placeholder="ZIP" required="true" /> <br />
							<select id="type" required="true">
								<c:forEach var="t" items="${clientt}">
									<option value="${t.clientTypeId}"><c:out value="${t.clientType}"/></option>
								</c:forEach>
							</select>
						</div>
						<div class="modal-footer">
							<input id="add" type="button" class="btn btn-success" value="Add"/>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
				</div>
			</div>
	</div>
	<div class="modal fade" id="updateSupplier" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">Update a Supplier</h4>
					</div>
						<div class="modal-body">
							<table id="suppliers">
									<tr>
										<th>Client Name</th>
									</tr>
							</table>
						</div>
						<div class="modal-footer">
							<input id="" type="button" class="btn btn-success" value="Update" />
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
				</div>
			</div>
	</div>
	<div class="modal fade" id="updateRetailer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">Update a Retailer</h4>
					</div>
					<form action="" method="post">
						<div class="modal-body">
							<table>
								<thead>
									<tr>
										<th>Client Name</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											<input type="radio" name="retailName" value="1" checked>Walmart<br>
										</td>
									</tr>
									<tr>
										<td>
											<input type="radio" name="retailName" value="2" checked>K-Mart<br>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-success">Update</button>
						</div>
					</form>
				</div>
			</div>
	</div>
	</div>
<script type="text/javascript">
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#newModal").modal();
    });
    $("#myBtn").click(function(){
        $("#updateSupplier").modal();
    });
    $("#myBtn").click(function(){
        $("#updateRetailer").modal();
    });
});
$(document).ready(function(){
	setInterval(function(){
		$.ajax({
			// accepts application/json
			headers: {          
	    		Accept : "application/json; charset=utf-8"
    		}, 
			url: "http://localhost:7001/PIMS-web2/showSupplier.do",
			method: "GET",
			success: function(resp){
				$("#suppliers").html("<tr><th>Client Name</th></tr>");
				$.each(resp, function(i, item){
					$("#suppliers").append(
					"<tr><td><input type='radio' name='supplyName' value='"+item.clientId+"' checked>"+item.clientName+"</td></tr>");
				});
			}
		});
	}, 2000);
});
$(document).ready(function(){
    $("#add").click(function(){
		var name = $("#clientName").val();
		var email = $("#clientEmail").val();
		var contactName = $("#pointOfContactName").val();
		var phone = $("#clientPhone").val();
		var fax = $("#clientFax").val();
		var address1 = $("#streetAddress1").val();
		var address2 = $("#streetAddress2").val();
		var city = $("#addressCity").val();
		var state = $("#stateId").val();
		var zip = $("#addressZip").val();
		var type = $("#type").val();
		//reset form
		$("#clientName").val("");
		$("#clientEmail").val("");
		$("#pointOfContactName").val("");
		$("#clientPhone").val("");
		$("#clientFax").val("");
		$("#streetAddress1").val("");
		$("#streetAddress2").val("");
		$("#addressCity").val("");
		$("#addressZip").val("");
		
		$.ajax({
			// contentType application/json
			headers: {          
    			"Content-Type": "application/json; charset=utf-8"
    		},
			url: "http://localhost:7001/PIMS-web2/addClient.do",
			method: "POST",
			data: JSON.stringify({
				clientName : name, clientEmail : email, pointOfContactName : contactName, clientPhone : phone, clientFax : fax, newAddress1 : address1, newAddress2 : address2, newCity : city, newState : state, newZip : zip, newType : type 
			}),
			success: function(){
				alert("Added person successfully!");
			}
		});
		
	});
});
</script>
</body>
</html>