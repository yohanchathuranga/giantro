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
<title>USER DASHBOARD</title>
</head>
<body>
	
	<div class="sidebar">
		
		<br>
		<center>
			<h5>You are Logged as User</h5>
		</center>

		<div class="image" align="center">
			<img alt="Profile Picture"
			src="${pageContext.request.contextPath}/Resources/physio/images/fr-10.jpg"
			class="img-circle" width="100px" />
		</div>

		<a class="active" href="Home.jsp">Home</a> 
		<a href="Profile?NIC=${user.NIC}">Profile</a>
		<a href="#about">About</a> 
		<a href="Logout" class="fh5co-sub-ddown">Sign Out</a>
	</div>
	

	<div class="content">
		<%@include file="/header.jsp"%>
		<%@include file="/video_bar.jsp" %>
					
		<%@include file="/footer.jsp"%>
	</div>
	

</body>
</html>