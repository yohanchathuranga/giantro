<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/prof.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/bootstrap.css">
<!-- Superfish -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/superfish.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/style.css">


<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath}/Resources/physio/js/modernizr-2.6.2.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="sidebar">
		<br><center><h5>You are Logged as Physiotherapist</h5></center>
		<div class="image" align="center">
			<img alt="Profile Picture"
				src="${pageContext.request.contextPath}/Resources/physio/images/fr-10.jpg"
				class="img-circle" width="100px" />
		</div>
		<a class="active" href="Home.jsp">Home</a> 
		<a href="Profile?NIC=${user.NIC}">Profile</a> 
		<a href="Physio_appointments?NIC=${user.NIC}">Appointments</a> 
		<a href="Physio_schedule?NIC=${user.NIC}">Schedule Request</a> 
		<a href="#about">About</a> <a href="Logout" class="fh5co-sub-ddown">Sign Out</a>
	</div>

	<div class="content">
		<%@include file="/header.jsp"%>
		
		<div class="row text-center">
					<div class="col-md-4 col-sm-6">
						<div class="" style="background-image: url(Resources/physio/images/trainer-1.jpg);">
							<div class="overlay-section">
								<div class="desc">
									
									<h1>You Have </h1>
									<h1 style=font-size:200px>${app} </h1> 
									<h1>New Appointments</h1>

								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-4 col-sm-6">
						<div class="" style="background-image: url(Resources/physio/images/trainer-3.jpg);">
							<div class="overlay-section">
								<div class="desc">
									
									<h1>You Have </h1>
									<h1 style=font-size:200px>${sch} </h1> 
									<h1>New Schedule Requests</h1>

								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-4 col-sm-6">
						<div class="" style="background-image: url(Resources/physio/images/trainer-1.jpg);">
							<div class="overlay-section">
								<div class="desc">
									
									<h1>Today You Have </h1>
									<h1 style=font-size:200px>${today} </h1> 
									<h1> Appointments</h1>

								</div>
							</div>
						</div>
					</div>
		
		
		<%@include file="/footer.jsp"%>
	</div>



</body>
</html>