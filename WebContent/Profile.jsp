<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>physio profile</title>

<link rel="stylesheet" >
<style type="text/css">
.column1 {
  float: left;
  width: 30%;
  
  height: 300px;
}
.column {
  float: right;
  width: 70%;
  height: 300px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
</head>
<body>
<%@include file="header.jsp" %>
	
		<div class="row">
	  		<div class="column1" >
	  			<div class="image">
	  				<img alt="logo" src="1.jpg" width="100px" height="100px"/>	  			</div>
	  		</div>
	  		
	  		<div class="column" style="background-color:#aaa;">
	  		<fieldset>
	  		<legend>Physio Profile</legend>
	  			<form action="/new_a">
	  				NIC :${user.NIC}
	  				Name :${user.name}<br>
	  				Certificate ID :${user.certificate_ID}<br>
	  				Contact No :${user.contact_No}<br>
	  				Address : ${user.address}<br>
	  				Place Name :${user.place_Name}<br>
	  				Experience : ${user.exp}<br>
	  				
	  				<a href="new_a?NIC=${user.NIC}">Make An Appointment</a> 	
	  			</form>
	  		</fieldset>
	  		</div>
		</div>
	
	
<%@include file="footer.jsp" %>
</body>
</html>