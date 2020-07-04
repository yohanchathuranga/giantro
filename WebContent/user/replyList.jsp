<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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

<title>appointment list</title>
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
		
		<caption>
			<h2>List of Replies</h2>
		</caption>
		<div align="center">
		<h3 >Schedule No :${schedule_no}</h3>
			<table width="30%" align="center">
					<tr>
						<th>Exercise</th>	
						<th>Rep</th>	
						<th>Turn</th>	
					</tr>
				
				
				<c:forEach var="schedule" items="${listSchedule}">
					<tr>
						<td><c:out value="${schedule.exercise}" /></td>
						<td><c:out value="${schedule.rep}" /></td>
						<td><c:out value="${schedule.turn}" /></td>	
					</tr>
					

					<tr>
						
						
					</tr>
				</c:forEach>
				<td>
						<a href="User_schedule?schedule_no=<c:out value='${schedule.schedule_No}' />">Back</a>
							&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</table>
		</div>

		<%@include file="/footer.jsp"%>
	</div>


</body>
</html>