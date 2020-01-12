<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
  
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>header</title>
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

	</head>
	<body>
		
		<div id="fh5co-header">
			<header id="fh5co-header-section">
				<div class="container">
					<div class="nav-header">
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
						<h1 id="fh5co-logo"><a href="index.html">Gian<span>tro</span></a></h1>
						
						<!-- START #fh5co-menu-wrap -->
						<nav id="fh5co-menu-wrap" role="navigation">
						
							<ul class="sf-menu" id="fh5co-primary-menu">
								<li class="fh5co-sub-ddown">
									<a href="Home.jsp">Home</a>
								</li>
								<li>
									<a href="classes.html" class="fh5co-sub-ddown">Tutorials</a>
									 <ul class="fh5co-sub-menu">
									 	<li><a href="left-sidebar.html">Images</a></li>
									 	<li><a href="right-sidebar.html">Animations</a></li>
										<li>
											<a href="#" class="fh5co-sub-ddown">Video</a>
											<ul class="fh5co-sub-menu">
												<li><a href="http://freehtml5.co/preview/?item=build-free-html5-bootstrap-template" target="_blank">Categories</a></li>
												<li><a href="http://freehtml5.co/preview/?item=work-free-html5-template-bootstrap" target="_blank">Work</a></li>
												<li><a href="http://freehtml5.co/preview/?item=light-free-html5-template-bootstrap" target="_blank">Light</a></li>
												<li><a href="http://freehtml5.co/preview/?item=relic-free-html5-template-using-bootstrap" target="_blank">Relic</a></li>
												<li><a href="http://freehtml5.co/preview/?item=display-free-html5-template-using-bootstrap" target="_blank">Display</a></li>
												<li><a href="http://freehtml5.co/preview/?item=sprint-free-html5-template-bootstrap" target="_blank">Sprint</a></li>
											</ul>
										</li>
										<li><a href="#">Document</a></li>
										
									</ul>
								</li>
								<li>
									<a href="schedule.html" class="fh5co-sub-ddown">Supplements</a>
										<ul class="fh5co-sub-menu">
											<li><a href="http://freehtml5.co/preview/?item=build-free-html5-bootstrap-template" target="_blank">Shops</a></li>
											<li><a href="http://freehtml5.co/preview/?item=work-free-html5-template-bootstrap" target="_blank">Items</a></li>
											<li><a href="http://freehtml5.co/preview/?item=light-free-html5-template-bootstrap" target="_blank">Categories</a></li>
											<li><a href="http://freehtml5.co/preview/?item=relic-free-html5-template-using-bootstrap" target="_blank">Promotions</a></li>
										</ul>
								</li>
								<li><a href="list_u" class="fh5co-sub-ddown">Physiotherapists</a>
									<ul class="fh5co-sub-menu">
									 	<li><a href="Physio_list">Physios</a></li>
									 	<li><a href="User_appointments">Appointments</a></li>
										 
									</ul>
								</li>
								<li><a href="about.html" class="fh5co-sub-ddown">Gyms</a></li>
								<li><a href="about.html" class="fh5co-sub-ddown">About</a></li>
								<li><a href="contact.html" class="fh5co-sub-ddown">Contact</a></li>
								<li><a href="Logout" class="fh5co-sub-ddown">Sign Out</a></li>
								
							</ul>
						</nav>
					</div>
				</div>
			</header>		
		</div>
		<!-- end:fh5co-header -->
		<div class="fh5co-hero">
		
			<div class="fh5co-overlay"></div>
			
			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(images/home-image.jpg);">
						
				<div class="desc animate-box">
					<div class="image">
			  	<%-- <img alt="" src="${pageContext.request.contextPath}/images/logo.png"  class="img-circle" width="150px"/> --%>	  			
			</div>
					<div class="container">
						<div class="row">
							<div class="col-md-7">
								<h2>Fitness &amp; Health <br>is a <b>Mentality</b></h2>
								<p><span>Created with <i class="icon-heart3"></i> by the fine folks at <a href="http://freehtml5.co" class="fh5co-site-name"></a></span></p>
								<span><a class="btn btn-primary" href="#">Start Your Journey</a></span>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath}/js/jquery.waypoints.min.js"></script>
	<!-- Stellar -->
	<script src="${pageContext.request.contextPath}/js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="${pageContext.request.contextPath}/js/hoverIntent.js"></script>
	<script src="${pageContext.request.contextPath}/js/superfish.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
</body>
</html>