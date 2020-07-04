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
				src="${pageContext.request.contextPath}/Resources/physio/images/fr-10.jpg"
				class="img-circle" width="100px" />
		</div>
		  <a class="active" href="Home.jsp">Home</a>
		  <a href="Profile?NIC=${user.NIC}">Profile</a>
		  <a href="Physio_appointments?NIC=${user.NIC}">Appointments</a>
		  <a href="Physio_schedule?NIC=${user.NIC}">Schedule Request</a>
		  <a href="#about">About</a>
		  <a href="Logout" class="fh5co-sub-ddown">Sign Out</a>
	</div>

	<div class="content">
		<%@include file="/header.jsp"%>

		<div class="form">
			<fieldset>
				<legend>Schedule</legend>
				<form action="../Add_video" method="post"
					enctype="multipart/form-data">

					<c:if test="${video != null}">
						<input type="text" name="Video_No"
							value="<c:out value='${video.video_No}' />" />
					</c:if>
					Topic: <input type="text" name="Topic" value='${video.user_NIC}'
						required="true"><br> 
						User NIC : <input
						type="text" name="Customer_NIC"
						value="<c:out value='${video.user_NIC}'/>"><br>

					Video :<br>
					<input type="file" name="Video"
						value="<c:out value='${video.video}'/>" required="true"><br>

					Category :<br>
					<input type="text" name="Height"
						value="<c:out value='${video.category}'/>" placeholder="In cm"
						required="true"><br> 
					<br> <input type="submit" value="Upload Video">
				</form>
			</fieldset>
		</div>

		<%@include file="/footer.jsp"%>
	</div>


</body>
</html>