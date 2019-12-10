<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
  
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>index</title>
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
									<a href="index.jsp">Home</a>
								</li>
							<!-- 	<li>
									<a href="classes.html" class="fh5co-sub-ddown">Classes</a>
									 <ul class="fh5co-sub-menu">
									 	<li><a href="left-sidebar.html">Web Development</a></li>
									 	<li><a href="right-sidebar.html">Branding &amp; Identity</a></li>
										<li>
											<a href="#" class="fh5co-sub-ddown">Free HTML5</a>
											<ul class="fh5co-sub-menu">
												<li><a href="http://freehtml5.co/preview/?item=build-free-html5-bootstrap-template" target="_blank">Build</a></li>
												<li><a href="http://freehtml5.co/preview/?item=work-free-html5-template-bootstrap" target="_blank">Work</a></li>
												<li><a href="http://freehtml5.co/preview/?item=light-free-html5-template-bootstrap" target="_blank">Light</a></li>
												<li><a href="http://freehtml5.co/preview/?item=relic-free-html5-template-using-bootstrap" target="_blank">Relic</a></li>
												<li><a href="http://freehtml5.co/preview/?item=display-free-html5-template-using-bootstrap" target="_blank">Display</a></li>
												<li><a href="http://freehtml5.co/preview/?item=sprint-free-html5-template-bootstrap" target="_blank">Sprint</a></li>
											</ul>
										</li>
										<li><a href="#">UI Animation</a></li>
										<li><a href="#">Copywriting</a></li>
										<li><a href="#">Photography</a></li> 
									</ul>
								</li>
								<li>
									<a href="schedule.html" class="fh5co-sub-ddown">Schedule</a>
								</li>
								<li><a href="list_u" class="fh5co-sub-ddown">Physiotherapists</a>
									<ul class="fh5co-sub-menu">
									 	<li><a href="list_u">List of Physio</a></li>
									 	<li><a href="list_a">Your Appointments</a></li>
										 
									</ul> -->
								</li>
								<li><a href="about.html" class="fh5co-sub-ddown">About</a></li>
								<li><a href="contact.html" class="fh5co-sub-ddown">Contact</a></li>
								<li><a href="login.jsp" class="fh5co-sub-ddown">Sign In</a></li>
								<li><a href="register_physio.jsp" class="fh5co-sub-ddown">Register</a></li>
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
			<div class="image">
			  				<img alt="" src="${pageContext.request.contextPath}/images/logo.png"  width="80px" height="100px"/>	  			
			  			</div>
				<div class="desc animate-box">
				
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
		
		
		
		<div id="fh5co-team-section" class="fh5co-light-section">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<div class="heading-section text-center animate-box">
							<h2>Video Tutorial</h2>
							<p>Our Video Tutorials.Register to see more Videos.</p>
						</div>
					</div>
				</div>
				<div class="row text-center">
					<div class="col-md-4 col-sm-6">
						<div class="team-section-grid animate-box" style="background-image: url(images/trainer-1.jpg);">
							<div class="overlay-section">
								<div class="desc">
									<h3>John Doe</h3>
									<span>Body Trainer</span>
									<video src="${pageContext.request.contextPath}/video/my.mp4" width="320" Height="240" controls></video>
									<p>Pilates Exercises for Kids</p>
									
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="team-section-grid animate-box" style="background-image: url(images/trainer-2.jpg);">
							<div class="overlay-section">
								<div class="desc">
									<h3>James Smith</h3>
									<span>Swimming Trainer</span>
									<video src="${pageContext.request.contextPath}/video/my.mp4" width="320" Height="240" controls></video>
									<p>Pilates Exercises for Kids</p>
									
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="team-section-grid animate-box" style="background-image: url(images/trainer-3.jpg);">
							<div class="overlay-section">
								<div class="desc">
									<h3>John Doe</h3>
									<span>Chief Executive Officer</span>
									<video src="${pageContext.request.contextPath}/video/my.mp4" width="320" Height="240" controls></video>
									<p>Pilates Exercises for Kids</p>
									
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="team-section-grid animate-box" style="background-image: url(images/trainer-4.jpg);">
							<div class="overlay-section">
								<div class="desc">
									<h3>John Doe</h3>
									<span>Chief Executive Officer</span>
									<video src="${pageContext.request.contextPath}/video/my.mp4" width="320" Height="240" controls></video>
									<p>Pilates Exercises for Kids</p>
									
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="team-section-grid animate-box" style="background-image: url(images/trainer-5.jpg);">
							<div class="overlay-section">
								<div class="desc">
									<h3>John Doe</h3>
									<span>Chief Executive Officer</span>
									<video src="${pageContext.request.contextPath}/video/my.mp4" width="320" Height="240" controls></video>
									<p>Pilates Exercises for Kids</p>
									

								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="team-section-grid animate-box" style="background-image: url(images/trainer-6.jpg);">
							<div class="overlay-section">
								<div class="desc">
									<h3>John Doe</h3>
									<span>Chief Executive Officer</span>
									<video src="${pageContext.request.contextPath}/video/my.mp4" width="320" Height="240" controls></video>
									<p>Pilates Exercises for Kids</p>
									
								</div>
							</div>
						</div>
					</div>	
				</div>
			</div>
		</div>
		
		
		
		<footer>
			<div id="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-4 animate-box">
							<h3 class="section-title">About Us</h3>
							<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics.</p>
						</div>

						<div class="col-md-4 animate-box">
							<h3 class="section-title">Our Address</h3>
							<ul class="contact-info">
								<li><i class="icon-map-marker"></i>198 Ward Place, Colombo 07, Srilanka</li>
								<li><i class="icon-phone"></i>+ 941 14 2355 98</li>
								<li><i class="icon-envelope"></i><a href="#">info@giantro.com</a></li>
								<li><i class="icon-globe2"></i><a href="#">www.giantro.com</a></li>
							</ul>
						</div>
						<div class="col-md-4 animate-box">
							<h3 class="section-title">Drop us a line</h3>
							<form class="contact-form">
								<div class="form-group">
									<label for="name" class="sr-only">Name</label>
									<input type="name" class="form-control" id="name" placeholder="Name">
								</div>
								<div class="form-group">
									<label for="email" class="sr-only">Email</label>
									<input type="email" class="form-control" id="email" placeholder="Email">
								</div>
								<div class="form-group">
									<label for="message" class="sr-only">Message</label>
									<textarea class="form-control" id="message" rows="7" placeholder="Message"></textarea>
								</div>
								<div class="form-group">
									<input type="submit" id="btn-submit" class="btn btn-send-message btn-md" value="Send Message">
								</div>
							</form>
						</div>
					</div>
					<div class="row copy-right">
						<div class="col-md-6 col-md-offset-3 text-center">
							<p class="fh5co-social-icons">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
							</p>
							<p>Copyright 2016  <a href="index.jsp">Giantro </a></p>
						</div>
					</div>
				</div>
			</div>
		</footer>
	

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