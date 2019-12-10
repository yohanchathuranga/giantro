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
	<h3>You are Logged as Customer</h3>
		<div class="image" align="center">
			<img alt="Profile Picture" src="${pageContext.request.contextPath}/images/fr-10.jpg" class="img-circle" width="100px"/>	  			
		</div>
	  <a class="active" href="Home.jsp">Home</a>
	  <a href="profile_p?NIC=${user.NIC}">Profile</a>
	  <a href="list_a_u?NIC=${user.NIC}">Appointments</a>
	  <a href="list_s_u?NIC=${user.NIC}">Schedule Request</a>
	  <a href="#about">About</a>
	  <a href="logout" class="fh5co-sub-ddown">Sign Out</a>
	</div>
	
	<div class="content">
	  <%@include file="/header.jsp" %>
	  <%@include file="/video_bar.jsp" %>
	  <%@include file="/footer.jsp" %>
	</div>
	
	

</body>
</html>