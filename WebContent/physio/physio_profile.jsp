<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/prof.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/animate.css">
		<!-- Icomoon Icon Fonts-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/icomoon.css">
		<!-- Bootstrap  -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/bootstrap.css">
		<!-- Superfish -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/superfish.css">
	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/style.css">
		
	
		<!-- Modernizr JS -->
		<script src="${pageContext.request.contextPath}/Resources/physio/js/modernizr-2.6.2.min.js"></script>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		<div class="sidebar">
		<br><center><h5>You are Logged as Physiotherapist</h5></center>
			<div class="image" align="center">
				<img alt="Profile Picture" src="${pageContext.request.contextPath}/Resources/physio/images/fr-10.jpg" class="img-circle" width="100px"/>	  			
			</div>
		  <a class="active" href="Home.jsp">Home</a>
		  <a href="Profile?NIC=${user.NIC}">Profile</a>
		  <a href="Physio_appointments?NIC=${user.NIC}">Appointments</a>
		  <a href="Physio_schedule?NIC=${user.NIC}">Schedule Request</a>
		  <a href="#about">About</a>
		  <a href="Logout" class="fh5co-sub-ddown">Sign Out</a>
		</div>
		
		<div class="content" ">
		<%@include file="/header.jsp"%>
		
			<fieldset style="align-self:center">
			  <legend>Your Profile</legend>
			  		<table width="20%" align="center">
			  			<tr><td>NIC :<td>${user.NIC}</tr>
			  			<tr><td>Name :<td>${user.name}</tr>
			  			<tr><td>Email :<td>${user.email}</tr>
			  			<tr><td>Certificate ID :<td>${user.certificate_ID}</tr>
			  			<tr><td>Contact No :<td>${user.contact_No}</tr>
			  			<tr><td>Address : <td>${user.address}</tr>
			  			<tr><td>Place Name :<td>${user.place_Name}</tr>
			  			<tr><td>Experience : <td>${user.exp}</tr>
			  				
			  			<tr><td><a href="Edit_profile?NIC=${user.NIC}">Edit Your Profile</a> </tr>
			  		</table>
			</fieldset>
		
			<%@include file="/footer.jsp"%>
		</div>
	
	</body>
</html>