<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAZP Navbar</title>
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
		integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
		integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" 
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="Brand" src="http://wazp-gr.com/application/files/thumbnails/small/1114/4661/6225/WAZPGROUP_LOGO.jpg"
        	width="115" height="56">
      </a>
      <input type="button" class="btn btn-default navbar-btn" onclick="location.href='index.jsp';" value="Home" />
      <input type="button" class="btn btn-default navbar-btn" onclick="location.href='create.do';" value="Products" />
      <input type="button" class="btn btn-default navbar-btn" onclick="location.href='createClient.do';" value="Clients" />
      <input type="button" class="btn btn-default navbar-btn" onclick="location.href='createInvoice.do';" value="Invoice" />
      <input type="button" class="btn btn-default navbar-btn" onclick="location.href='';" disabled="disabled" value="Reports" />
    </div>
  </div>
</nav>

</body>
</html>