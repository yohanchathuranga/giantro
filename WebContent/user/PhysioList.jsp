<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/prof.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<!-- Superfish -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/superfish.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath}/js/modernizr-2.6.2.min.js"></script>

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
				src="${pageContext.request.contextPath}/images/fr-10.jpg"
				class="img-circle" width="100px" />
		</div>
		<a class="active" href="Home.jsp">Home</a> <a
			href="Profile?NIC=${user.NIC}">Profile</a> <a
			href="Physio_appointments?NIC=${user.NIC}">Appointments</a> <a
			href="Physio_schedule?NIC=${user.NIC}">Schedule Request</a> <a
			href="#about">About</a> <a href="Logout" class="fh5co-sub-ddown">Sign
			Out</a>
	</div>

	<div class="content">
		<%@include file="/header.jsp"%>


		<div align="center">
			<table class="table table-borderless table-dark" border="1"
				cellpadding="5">
				<div class="title" align="center">
					<h2>List of Physio</h2>
				</div>
				<thead>
					<tr>

						<th>Physio NIC</th>
						<th>Physio Name</th>
						<th>Name</th>
						<th>Certificate ID</th>
						<th>Address</th>
						<th>Experience</th>
						<th>Place Name</th>
						<th>Contact No</th>
						<th>Status</th>

					</tr>
					<c:forEach var="user" items="${listUser}">
						<tr>
							<td><c:out value="${user.NIC}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.certificate_ID}" /></td>
							<td><c:out value="${user.address}" /></td>
							<td><c:out value="${user.exp}" /></td>
							<td><c:out value="${user.place_Name}" /></td>
							<td><c:out value="${user.contact_No}" /></td>
							<td><c:out value="${user.status}" /></td>

							<td><a
								href="Physio_profile_user?NIC=<c:out value='${user.NIC}' />">View
									Profile</a></td>
						</tr>
					</c:forEach>
				</thead>
			</table>

		</div>

		<%@include file="/footer.jsp"%>
	</div>

	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script
		src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script
		src="${pageContext.request.contextPath}/js/jquery.waypoints.min.js"></script>
	<!-- Stellar -->
	<script
		src="${pageContext.request.contextPath}/js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="${pageContext.request.contextPath}/js/hoverIntent.js"></script>
	<script src="${pageContext.request.contextPath}/js/superfish.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>