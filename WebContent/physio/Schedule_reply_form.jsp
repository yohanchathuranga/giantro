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
		<a href="Physio_appointments?NIC=${user.NIC}">Appointments</a>
		<a href="Physio_schedule?NIC=${user.NIC}">Schedule Request</a>
		<a href="#about">About</a>
		<a href="Logout" class="fh5co-sub-ddown">Sign Out</a>
	</div>

	<div class="content">
		<%@include file="/header.jsp"%>

		<div id="form" class="form">
		<%String schedule_no=request.getParameter("schedule_no"); %>
		
			<fieldset style="align-self: center">

			<legend>Schedule</legend>

			<form action="../Add_schedule_reply" method="post">

				Schedule No :<%=schedule_no %><br> 
				<input type="hidden" name="Schedule_No" value=<%=schedule_no %> /> 

				<%String a=request.getParameter("noofstep");%>

				<br/><%int number=Integer.parseInt(a);
				for(int i=1;i<=number;i++)
				{
				%>
					<fieldset>
					<legend>Exercise <%=i %> :</legend>
					Exercise  :<input type="text" name="exercise<%=i %>"  value="" required="true"><br>
					No of Repeat  :<input type="text" name="rep<%=i %>"  value="" required="true"><br>
					No of Turns :<input type="text" name="turn<%=i %>"  value="" required="true"><br>
					</fieldset>
					
				<%} %>
									
				
				
				<br> <input type="submit" value="Submit the reply">
				
				<input type="button" class="btn btn-danger" onclick="window.location.href = '../Physio_schedule?scount=<%=number %>';" value="Cancel" align="center"/>

			</form>
		</fieldset>
		</div>

		<%@include file="/footer.jsp"%>
	</div>