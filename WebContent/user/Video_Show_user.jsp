<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Video Show</title>
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

		
		<div class="content" style="background-image: url(Resources/physio/images/home1.jpg);">
		<%@include file="/header.jsp"%>
		
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<div class="heading-section text-center animate-box">
							<h2>Video Tutorial</h2>
							<p>Our Video Tutorials.</p>
						</div>
					</div>
				</div>
		</div>
		<div class="container">
			<div class="row text-center">
					<div class="">
						<div class="" style="background-image: url(Resources/physio/images/trainer-1.jpg);">
							<div class="overlay-section">
								<div class="desc">
									<h3></h3>
									<span></span>
									Video Name :${video.topic}<br>
						  			Owner NIC :${video.user_NIC}<br>
						  			Category :${video.category}<br>
									<video src="${video.video}" width="320" Height="240" controls></video>
									
								</div>
							</div>
						</div>
					</div>
				</div>
					
					<%@include file="/footer.jsp"%>
		
	</div>

	<script src="${pageContext.request.contextPath}/Resources/physio/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script
		src="${pageContext.request.contextPath}/Resources/physio/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/Resources/physio/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script
		src="${pageContext.request.contextPath}/Resources/physio/js/jquery.waypoints.min.js"></script>
	<!-- Stellar -->
	<script
		src="${pageContext.request.contextPath}/Resources/physio/js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="${pageContext.request.contextPath}/Resources/physio/js/hoverIntent.js"></script>
	<script src="${pageContext.request.contextPath}/Resources/physio/js/superfish.js"></script>

	
	<script src="${pageContext.request.contextPath}/Resources/physio/js/main.js"></script>

</body>
</html>