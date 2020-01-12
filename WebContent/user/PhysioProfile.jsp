<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/prof.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/WebContent/css/animate.css">
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

<style>
.map {
	height: 200px;
	width: 100%;
}
</style>

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

		<div class="row">
			<div class="column left" align="center">
				<h3>Profile Picture</h3>
				<div class="image" align="center">
					<img alt="Profile Picture"
						src="${pageContext.request.contextPath}/images/fr-10.jpg"
						width="80px" class="img-circle" />
				</div>
			</div>

			<div class="column middle">
				<fieldset style="align-self: center">
					<legend>Physio Profile</legend>
					<form action="/new_a">
						NIC :${user.NIC}<br> Name :${user.name}<br> Certificate
						ID :${user.certificate_ID}<br> Contact No :${user.contact_No}<br>
						Address : ${user.address}<br> Place Name :${user.place_Name}<br>
						Experience : ${user.exp}<br> <a
							href="user/Appointment_form.jsp?NIC=${user.NIC}">Make An
							Appointment</a> | <a href="user/schedule_form.jsp?NIC=${user.NIC}">Make
							a Schedule Request</a>
					</form>
				</fieldset>
			</div>
			<div class="column right">
				<div id="map">
					<h3>Location Map</h3>
				</div>
				<script>
					function initMap() {
						var test = {
							lat : 5.9430575,
							lng : 80.5455298
						};
						var map = new google.maps.Map(document
								.getElementById('map'), {
							zoom : 15,
							center : test
						});
						var marker = new google.maps.Marker({
							position : test,
							map : map
						});
					}
				</script>
				<script async defer
					src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBe-aM4GGPg-RPv5iAhvYKs0JVoJqej4D8&callback=initMap">
					
				</script>



			</div>
		</div>

		<%@include file="/footer.jsp"%>
	</div>


</body>
</html>