<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/prof.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/animate.css">
<!-- Icomoon Icon Fonts -->
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
<title>Schedule Form</title>
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

		<div class="form">
			<fieldset>
				<legend>Schedule</legend>
				<form action="Schedule_update" method="post"
					enctype="multipart/form-data">


					Schedule No :<input type="text" name="Schedule_No" readonly="true"
						value="<c:out value='${schedule.schedule_No}' />" /> Physio NIC :
					<input type="text" name="Physio_NIC" value='${schedule.physio_NIC}'
						required="true"><br> Customer NIC : <input
						type="text" name="Customer_NIC"
						value="<c:out value='${schedule.customer_NIC}'/>"><br>

					Age :<br> <input type="text" name="Age"
						value="<c:out value='${schedule.age}'/>" required="true"><br>

					Height :<br> <input type="text" name="Height"
						value="<c:out value='${schedule.height}'/>" placeholder="In cm"
						required="true"><br> Weight : <input type="text"
						name="Weight" value="<c:out value='${schedule.weight}'/>"
						placeholder="in kgs" required="true"><br> Photos : <input
						type="file" name="Photo"
						value="<c:out value='${schedule.photos}'/>" required="true"><br>
					<br> <input type="submit" value="Request for schedule">
				</form>
			</fieldset>
		</div>

		<%@include file="/footer.jsp"%>
	</div>


</body>
</html>