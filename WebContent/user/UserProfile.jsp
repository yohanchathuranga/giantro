<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/css/prof.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/physio/WebContent/css/animate.css">
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

		<fieldset style="align-self: center">
			<legend>User Profile</legend>
			<%-- <form action="">
				NIC :${user.NIC}<br> Name :${user.name}<br>
				Email:${user.email}<br> Contact No :${user.contact_No}<br>
				Address : ${user.address}<br> 
				<tr><td><a href="Edit_profile?NIC=${user.NIC}">Edit Your Profile</a>

			</form> --%>
			
			<table width="50%" align="center">
						<tr><td>NIC :<td>${user.NIC}<br> </tr>
						<tr><td>Name :<td>${user.name}<br> </tr>
						<tr><td>Contact No :<td>${user.contact_No}<br></tr>
						<tr><td>Email:<td>${user.email}</tr>
						<tr><td>Address : <td>${user.address}<br> </tr>
				<tr><td><a href="Edit_profile?NIC=${user.NIC}">Edit Your Profile</a>
				
			</table>
		</fieldset>

		<%@include file="/footer.jsp"%>
	</div>





</body>
</html>