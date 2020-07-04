<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
<!-- Google web font "Open Sans" -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/bootstrap.min.css">
<!-- Bootstrap style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/tooplate-style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/superfish.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div id="fh5co-header">
		<header id="fh5co-header-section">
			<div class="container">
				<div class="nav-header">
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
					<h1 id="fh5co-logo">
						<a href="index.html">Gian<span>tro</span></a>
					</h1>

					<!-- START #fh5co-menu-wrap -->
					<nav id="fh5co-menu-wrap" role="navigation">

						<ul class="sf-menu" id="fh5co-primary-menu">
							<li class="fh5co-sub-ddown"><a href="Home.jsp">Home</a></li>
							<li><a href="classes.html" class="fh5co-sub-ddown">Tutorials</a>
								<ul class="fh5co-sub-menu">
									<li><a href="Video_list" class="fh5co-sub-ddown">Video</a>
								</ul></li>
							<li><a href="#" class="fh5co-sub-ddown">Supplements</a>
								<ul class="fh5co-sub-menu">
									<li><a
										href="http://freehtml5.co/preview/?item=build-free-html5-bootstrap-template"
										target="_blank">Shops</a></li>
									<li><a
										href="http://freehtml5.co/preview/?item=work-free-html5-template-bootstrap"
										target="_blank">Products</a></li>
								
								</ul></li>
							<li><a href="#" class="fh5co-sub-ddown">Physiotherapists</a>
								<ul class="fh5co-sub-menu">
									<li><a href="Physio_list">Physios</a></li>
									<li><a href="User_schedule?NIC=${user.NIC}">Your Schedule Request</a></li>
									<li><a href="User_appointments?NIC=${user.NIC}">Your Appointments</a></li>

								</ul></li>
							<li><a href="#" class="fh5co-sub-ddown">Gyms</a></li>
							<li><a href="Discussion/disFull.jsp" class="fh5co-sub-ddown">QAs</a></li>
							<li><a href="#" class="fh5co-sub-ddown">Contact</a></li>
							<li><a href="Logout" class="fh5co-sub-ddown">Sign Out</a></li>

						</ul>
					</nav>
				</div>
			</div>
		</header>
	</div>
	<div class="headline" style="background-image: url(Resources/physio/images/header.jpg);">
		<div class="inner">
			<h1>Giantro</h1>
			<p>Scroll down the page</p>
		</div>
	</div>
	</header>
</body>
</html>