<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/prof.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/animate.css">
<!-- Icomoon Icon Fonts -->
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
<title>Appointment Form</title>
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

		<div id="form" class="form">
			<fieldset>
				<legend>Make New Appointment Form</legend>
				<form action="Add_appointment" method="post">


					<c:if test="${Appointment != null}">
						<input type="text" name="appointment_No"
							value="<c:out value='${appointment.appointment_No}' />" />
					</c:if>

					Physio NIC : <input type="text" name="physio_NIC" value='${NIC1}'
						required="true" readonly="readonly"><br> 
					
					Customer NIC :
					<input type="text" name="customer_NIC"
						value="<c:out value='${appointment.customer_NIC}'/>" minlength="10" maxlength="13"><br>

					Date :<br>
					<input type="Date" name="date"
						value="<c:out value='${appointment.date}'/>" required="true"><br>

					Time :<br>
					<input type="Time" name="time"
						value="<c:out value='${appointment.time}'/>" required="true"><br>

					<input type="hidden" name="status"
						value="1" required="true"><br>
					<br> 
					
					<input type="submit" value="Make an Appointment">

				</form>
			</fieldset>
		</div>

		<%@include file="/footer.jsp"%>
	</div>


</body>
</html>