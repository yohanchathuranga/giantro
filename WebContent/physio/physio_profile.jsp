<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/prof.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
		<!-- Icomoon Icon Fonts-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icomoon.css">
		<!-- Bootstrap  -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
		<!-- Superfish -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/superfish.css">
	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		
	
		<!-- Modernizr JS -->
		<script src="${pageContext.request.contextPath}/js/modernizr-2.6.2.min.js"></script>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		<div class="sidebar">
		<br><center><h5>You are Logged as Physiotherapist</h5></center>
			<div class="image" align="center">
				<img alt="Profile Picture" src="${pageContext.request.contextPath}/images/fr-10.jpg" class="img-circle" width="100px"/>	  			
			</div>
		  <a class="active" href="Home.jsp">Home</a>
		  <a href="Profile?NIC=${user.NIC}">Profile</a>
		  <a href="Physio_appointments?NIC=${user.NIC}">Appointments</a>
		  <a href="Physio_schedule?NIC=${user.NIC}">Schedule Request</a>
		  <a href="#about">About</a>
		  <a href="Logout" class="fh5co-sub-ddown">Sign Out</a>
		</div>
		
		<div class="content" style="background-image: url(images/home.jpg);">
		<%@include file="/header.jsp"%>
		
			<fieldset style="align-self:center">
			  <legend>Your Profile</legend>
			  		<form action="">
			  			NIC :${user.NIC}<br>
			  			Name :${user.name}<br>
			  			Email :${user.email}<br>
			  			Certificate ID :${user.certificate_ID}<br>
			  			Contact No :${user.contact_No}<br>
			  			Address : ${user.address}<br>
			  			Place Name :${user.place_Name}<br>
			  			Experience : ${user.exp}<br>
			  				
			  			<a href="Edit_profile?NIC=${user.NIC}">Edit Your Profile</a> 	
			  		</form>
			</fieldset>
		
			<%@include file="/footer.jsp"%>
		</div>
	
	</body>
</html>