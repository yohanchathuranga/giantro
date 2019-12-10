<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/prof.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/superfish.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	
	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath}/js/modernizr-2.6.2.min.js"></script>

<title>appointment list</title>
</head>
<body>

<%@include file="/header.jsp" %>
<% String message=(String)request.getAttribute("alertMsg");%>
<script type="text/javascript">
	var msg="<%=message%>";
	alert(msg);
</script>
<div class="fh5co-parallax-any">
	<div class="container">
		<div align="center">
	        <table class="table table-borderless table-dark" border="1" cellpadding="5">
	            <caption><h2>List of Appointments</h2></caption>
	            <tr>
	                <th>Appointment No</th>
	                <th>Physio NIC</th>
	                <th>Customer NIC</th>
	                <th>Date</th>
	                <th>Time</th>
	                <th>Status</th>
	                <th>Edit</th>
	            </tr>
	            <c:forEach var="appointment" items="${listAppointment}">
	                <tr>
	                    <td><c:out value="${appointment.appointment_No}" /></td>
	                    <td><c:out value="${appointment.physio_NIC}" /></td>
	                    <td><c:out value="${appointment.customer_NIC}" /></td>
	                    <td><c:out value="${appointment.date}" /></td>
	                    <td><c:out value="${appointment.time}" /></td>
	                    <td><c:out value="${appointment.status}" /></td>
	                    
	                    <td>
	                        <a href="edit_a?appointment_no=<c:out value='${appointment.appointment_No}' />">Edit</a>
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                                   
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>  
	</div>
</div>
	
    <%@include file="/footer.jsp" %> 
</body>
</html>