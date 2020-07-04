<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<title>physioList</title>
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


		<div align="center">
			<table width="100%">
				<div class="title" align="center">
					<h2>List of Physio</h2>
				</div>
				<thead>
					<tr>

					
						<th>Physio Name</th>
						<th>Name</th>
						<th>Address</th>
						<th>Experience</th>
						<th>Place Name</th>
						<th>Contact No</th>
					

					</tr>
					<c:forEach var="user" items="${listUser}">
						<tr>
							
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.address}" /></td>
							<td><c:out value="${user.exp}" /></td>
							<td><c:out value="${user.place_Name}" /></td>
							<td><c:out value="${user.contact_No}" /></td>

							<td><a
								href="Physio_profile_user?NIC1=<c:out value='${user.NIC}' />">View
									Profile</a></td>
						</tr>
					</c:forEach>
				</thead>
			</table>

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