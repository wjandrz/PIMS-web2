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
	<button type="button" id="updateSModal" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updateSupplier">
		Update/Delete Supplier
	</button>
	<button type="button" id="updateRModal" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updateRetailer">
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
							<div>
								Client Name
								<select id="suppliers">
								</select><br />
							</div>
							<div>
								<input type="text" id="sclientName" placeholder="Name" required="true" /> <br />
								<input type="text" id="sclientEmail" placeholder="Email" required="true" /> <br />
								<input type="text" id="spointOfContactName" placeholder="Point of Contact Name" required="true" /> <br />
								<input type="text" id="sclientPhone" placeholder="Phone Number" required="true" /> <br />
								<input type="text" id="sclientFax" placeholder="Fax" required="true" /> <br />
								<input type="hidden" id="saddressId" />
								<input type="text" id="sstreetAddress1" placeholder="Street Address 1" required="true" /> <br />
								<input type="text" id="sstreetAddress2" placeholder="Street Address 2" required="true" /> <br />
								<input type="text" id="saddressCity" placeholder="City" required="true" /> <br />
								<select id="sstateId" required="true">
									<c:forEach var="t" items="${saabb}">
										<option value="${t.abbrvId}"><c:out value="${t.stateAbbrv}"/></option>
									</c:forEach>
								</select>
								<br />
								<input type="text" id="saddressZip" placeholder="ZIP" required="true" /> <br />
								<select id="stype" required="true">
									<c:forEach var="t" items="${clientt}">
										<option value="${t.clientTypeId}"><c:out value="${t.clientType}"/></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<input id="supdate" type="button" class="btn btn-success" value="Update" />
							<input id="smdelete" type="button" class="btn btn-warning" value="Delete" />
							<input id="sdelete" type="button" class="btn btn-danger" value="Are you Sure?" />
							<input type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='createClient.do';" value="Close"/>
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
							<div>
								Client Name
								<select id="retailers">
								</select><br />
							</div>
							<div>
								<input type="text" id="rclientName" placeholder="Name" required="true" /> <br />
								<input type="text" id="rclientEmail" placeholder="Email" required="true" /> <br />
								<input type="text" id="rpointOfContactName" placeholder="Point of Contact Name" required="true" /> <br />
								<input type="text" id="rclientPhone" placeholder="Phone Number" required="true" /> <br />
								<input type="text" id="rclientFax" placeholder="Fax" required="true" /> <br />
								<input type="hidden" id="raddressId" />
								<input type="text" id="rstreetAddress1" placeholder="Street Address 1" required="true" /> <br />
								<input type="text" id="rstreetAddress2" placeholder="Street Address 2" required="true" /> <br />
								<input type="text" id="raddressCity" placeholder="City" required="true" /> <br />
								<select id="rstateId" required="true">
									<c:forEach var="t" items="${saabb}">
										<option value="${t.abbrvId}"><c:out value="${t.stateAbbrv}"/></option>
									</c:forEach>
								</select>
								<br />
								<input type="text" id="raddressZip" placeholder="ZIP" required="true" /> <br />
								<select id="rtype" required="true">
									<c:forEach var="t" items="${clientt}">
										<option value="${t.clientTypeId}"><c:out value="${t.clientType}"/></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<input id="rupdate" type="button" class="btn btn-success" value="Update" />
							<input id="rmdelete" type="button" class="btn btn-warning" value="Delete" />
							<input id="rdelete" type="button" class="btn btn-danger" value="Are you Sure?" />
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
	$("#suppliers").change(function(){
		$.ajax({
			// accepts application/json
			headers: {          
	    		Accept : "application/json; charset=utf-8"
    		}, 
			url: "http://localhost:7001/PIMS-web2/fillSupplier.do?value="+$("#suppliers").val(),
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
		$("#sdelete").hide();
        $("#smdelete").show();
	});
	$("#retailers").change(function(){
		$.ajax({
			// accepts application/json
			headers: {          
	    		Accept : "application/json; charset=utf-8"
    		}, 
			url: "http://localhost:7001/PIMS-web2/fillRetailer.do?value="+$("#retailers").val(),
			method: "GET",
			success: function(resp){
				$("#rclientName").val(resp.clientName);
				$("#rclientEmail").val(resp.clientEmail);
				$("#rpointOfContactName").val(resp.pointOfContactName);
				$("#rclientPhone").val(resp.clientPhone);
				$("#rclientFax").val(resp.clientFax);
				$("#raddressId").val(resp.addressId.addressId);
				$("#rstreetAddress1").val(resp.addressId.streetAddress1);
				$("#rstreetAddress2").val(resp.addressId.streetAddress2);
				$("#raddressCity").val(resp.addressId.addressCity);
				$("#rstateId").val(resp.addressId.stateId.abbrvId);
				$("#raddressZip").val(resp.addressId.addressZip);
				$("#rtype").val(resp.clientTypeId.clientTypeId);
			}
		});
		$("#rdelete").hide();
        $("#rmdelete").show();
	});
});
$(document).ready(function(){
	$("#updateSModal").click(function(){
		//reset form
		$("#suppliers").find("option").remove();
		$("#sclientName").val("");
		$("#sclientEmail").val("");
		$("#spointOfContactName").val("");
		$("#sclientPhone").val("");
		$("#sclientFax").val("");
		$("#saddressId").val("");
		$("#sstreetAddress1").val("");
		$("#sstreetAddress2").val("");
		$("#saddressCity").val("");
		$("#saddressZip").val("");
		$.ajax({
			// accepts application/json
			headers: {          
	    		Accept : "application/json; charset=utf-8"
    		}, 
			url: "http://localhost:7001/PIMS-web2/showSupplier.do",
			method: "GET",
			success: function(resp){
				$.each(resp, function(i, item){
					$("#suppliers").append(
					"<option name='supplyName' value='"+item.clientId+"'>"+item.clientName+"</option>");
				});
			}
		});
		$("#sdelete").hide();
        $("#smdelete").show();
	});
	$("#updateRModal").click(function(){
		//reset form
		$("#retailers").find("option").remove();
		$("#rclientName").val("");
		$("#rclientEmail").val("");
		$("#rpointOfContactName").val("");
		$("#rclientPhone").val("");
		$("#rclientFax").val("");
		$("#raddressId").val("");
		$("#rstreetAddress1").val("");
		$("#rstreetAddress2").val("");
		$("#raddressCity").val("");
		$("#raddressZip").val("");
		$.ajax({
			// accepts application/json
			headers: {          
	    		Accept : "application/json; charset=utf-8"
    		}, 
			url: "http://localhost:7001/PIMS-web2/showRetailer.do",
			method: "GET",
			success: function(resp){
				$.each(resp, function(i, item){
					$("#retailers").append(
					"<option name='retailName' value='"+item.clientId+"'>"+item.clientName+"</option>");
				});
			}
		});
		$("#rdelete").hide();
        $("#rmdelete").show();
	});
});
$(document).ready(function(){
	$("#smdelete").click(function(){
		$("#sdelete").show();
        $("#smdelete").hide();
	});
	$("#sdelete").click(function(){
		var id = $("#suppliers").val();
		var aid = $("#saddressId").val();
		$.ajax({
			// contentType application/json
			headers: {          
    			"Content-Type": "application/json; charset=utf-8"
    		},
			url: "http://localhost:7001/PIMS-web2/removeClient.do",
			method: "POST",
			data: JSON.stringify({
				 clientId : id, newaddressId : aid
			}),
			success: function(){
				alert("Removed client successfully!");
			}
		});
	});
	$("#rmdelete").click(function(){
		$("#rdelete").show();
        $("#rmdelete").hide();
	});
	$("#rdelete").click(function(){
		var id = $("#retailers").val();
		var aid = $("#raddressId").val();
		$.ajax({
			// contentType application/json
			headers: {          
    			"Content-Type": "application/json; charset=utf-8"
    		},
			url: "http://localhost:7001/PIMS-web2/removeClient.do",
			method: "POST",
			data: JSON.stringify({
				 clientId : id, newaddressId : aid
			}),
			success: function(){
				alert("Removed client successfully!");
			}
		});
	});
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
	$("#supdate").click(function(){
		var id = $("#suppliers").val();
		var name = $("#sclientName").val();
		var email = $("#sclientEmail").val();
		var contactName = $("#spointOfContactName").val();
		var phone = $("#sclientPhone").val();
		var fax = $("#sclientFax").val();
		var aId = $("#saddressId").val();
		var address1 = $("#sstreetAddress1").val();
		var address2 = $("#sstreetAddress2").val();
		var city = $("#saddressCity").val();
		var state = $("#sstateId").val();
		var zip = $("#saddressZip").val();
		var type = $("#stype").val();
		
		$.ajax({
			// contentType application/json
			headers: {          
    			"Content-Type": "application/json; charset=utf-8"
    		},
			url: "http://localhost:7001/PIMS-web2/updateClient.do",
			method: "POST",
			data: JSON.stringify({
				clientId : id, clientName : name, clientEmail : email, pointOfContactName : contactName, clientPhone : phone, clientFax : fax, newaddressId : aId, newAddress1 : address1, newAddress2 : address2, newCity : city, newState : state, newZip : zip, newType : type 
			}),
			success: function(){
				alert("Updated a supplier successfully!");
			}
		});
	});
	$("#rupdate").click(function(){
		var id = $("#retailers").val();
		var name = $("#rclientName").val();
		var email = $("#rclientEmail").val();
		var contactName = $("#rpointOfContactName").val();
		var phone = $("#rclientPhone").val();
		var fax = $("#rclientFax").val();
		var aId = $("#raddressId").val();
		var address1 = $("#rstreetAddress1").val();
		var address2 = $("#rstreetAddress2").val();
		var city = $("#raddressCity").val();
		var state = $("#rstateId").val();
		var zip = $("#raddressZip").val();
		var type = $("#rtype").val();
		
		$.ajax({
			// contentType application/json
			headers: {          
    			"Content-Type": "application/json; charset=utf-8"
    		},
			url: "http://localhost:7001/PIMS-web2/updateClient.do",
			method: "POST",
			data: JSON.stringify({
				clientId : id, clientName : name, clientEmail : email, pointOfContactName : contactName, clientPhone : phone, clientFax : fax, newaddressId : aId, newAddress1 : address1, newAddress2 : address2, newCity : city, newState : state, newZip : zip, newType : type 
			}),
			success: function(){
				alert("Updated a retailer successfully!");
			}
		});
	});
});
</script>
</body>
</html>