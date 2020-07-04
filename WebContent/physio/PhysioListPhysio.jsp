<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>physioList</title>
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
		
		<div align="center">
	        <table border="1" cellpadding="5">
	            <caption><h2>List of Physio</h2></caption>
	            <tr>
	               
	                <th>Physio NIC</th>
	                <th>Physio Name</th>
	                <th>Name</th>
	                <th>Certificate ID</th>
	                <th>Address</th>
	                <th>Experience</th>
	                <th>Place Name</th>
	                <th>Contact No</th>
	                <th>Status</th>
	
	            </tr>
	            <c:forEach var="user" items="${listUser}">
	                <tr>
	                    <td><c:out value="${user.NIC}" /></td>
	                    <td><c:out value="${user.name}" /></td>
	                    <td><c:out value="${user.email}" /></td>
	                    <td><c:out value="${user.certificate_ID}" /></td>
	                    <td><c:out value="${user.address}" /></td>
	                    <td><c:out value="${user.exp}" /></td>
	                    <td><c:out value="${user.place_Name}" /></td>
	                    <td><c:out value="${user.contact_No}" /></td>
	                    <td><c:out value="${user.status}" /></td>
	                    
	                    <td>
	                        <a href="edit_u?NIC=<c:out value='${user.NIC}' />">Edit</a>
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                        <a href="profile_u?NIC=<c:out value='${user.NIC}' />">View Profile</a>                   
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>  
	    <%@include file="/footer.jsp" %> 
		</div>
	</body>
</html>