<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/prof.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/animate.css">
		<!-- Icomoon Icon Fonts-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/icomoon.css">
		<!-- Bootstrap  -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/bootstrap.css">
		<!-- Superfish -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/superfish.css">
	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/style.css">
		
		<!-- Modernizr JS -->
		<script src="${pageContext.request.contextPath}/Resources/physio/js/modernizr-2.6.2.min.js"></script>
	
	<title>appointment list</title>
	</head>
	<body>
	
	<div class="sidebar">
		<br><center><h5>You are Logged as Physiotherapist</h5></center>
			<div class="image" align="center">
				<img alt="Profile Picture" src="${pageContext.request.contextPath}/Resources/physio/images/fr-10.jpg" class="img-circle" width="100px"/>	  			
			</div>
		  <a class="active" href="Home.jsp">Home</a>
		  <a href="Profile?NIC=${user.NIC}">Profile</a>
		  <a href="Physio_appointments?NIC=${user.NIC}">Appointments</a>
		  <a href="Physio_schedule?NIC=${user.NIC}">Schedule Request</a>
		  <a href="#about">About</a>
		  <a href="Logout" class="fh5co-sub-ddown">Sign Out</a>
		</div>
	
	<div class="content">
		<%@include file="/header.jsp" %>
	<% String message=(String)request.getAttribute("alertMsg");%>
	<%-- <script type="text/javascript">
		var msg="<%=message%>";
		alert(msg);
	</script> --%>
	<div class="fh5co-parallax-any">
		<div class="container">
			<div align="center">
		        <table width="100%">
		            <caption><h2>List of Appointments</h2></caption>
		            <tr>
		                <th>Appointment No</th>
		                <th>Physio NIC</th>
		                <th>Customer NIC</th>
		                <th>Date</th>
		                <th>Time</th>
		                <th>Edit</th>
		            </tr>
		            <c:forEach var="appointment" items="${listAppointment}">
		                <tr>
		                    <td><c:out value="${appointment.appointment_No}" /></td>
		                    <td><c:out value="${appointment.physio_NIC}" /></td>
		                    <td><c:out value="${appointment.customer_NIC}" /></td>
		                    <td><c:out value="${appointment.date}" /></td>
		                    <td><c:out value="${appointment.time}" /></td>
		                    
		                    
		                    <td>
		                        <a href="Appointment_edit_physio?appointment_no=<c:out value='${appointment.appointment_No}' />">Edit</a>
		                        &nbsp;&nbsp;&nbsp;&nbsp;
		                        <a href="Appointment_delete?appointment_no=<c:out value='${appointment.appointment_No}' />">Delete</a>
		                        &nbsp;&nbsp;&nbsp;&nbsp;
		                                   
		                    </td>
		                    
		                    <td>
							<a href="Completed?appointment_no=<c:out value='${appointment.appointment_No}' />">Mark As Completed</a>
							&nbsp;&nbsp;&nbsp;&nbsp;</td>
		                </tr>
		            </c:forEach>
		        </table>
		    </div>  
		</div>
	</div>
	<%@include file="/footer.jsp" %> 
	</div>
	
	</body>
</html>