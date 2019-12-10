<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>appointment list</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/superfish.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Appointments</h2></caption>
            <tr>
                <th>Appointment No</th>
                <th>Physio NIC</th>
                <th>Customer NIC</th>
                <th>Date</th>
                <th>Time</th>
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
                        <a href="delete_a?appointment_no=<c:out value='${appointment.appointment_No}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
     <%@include file="/footer.jsp" %>
</body>
</html>