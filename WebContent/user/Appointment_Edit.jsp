<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/prof.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
	<!-- Icomoon Icon Fonts -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/superfish.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="/header.jsp" %>
<div class="fh5co-parallax-any">
	<div class="container">
		<a href="list_a">List All Appointments</a><br>
	        <div id="form" class="form">
	        	<form action="update_a" method="post">
		       
		        
			 
	                <h2>
	                    <c:if test="${appointment != null}">
	                        Edit Appointment
	                    </c:if>
	                    
	                </h2>
	          
	
				<fieldset>
					<legend>Edit Appointment:</legend>
					
					Appointment No :<input type="text" name="appointment_No" value="<c:out value='${appointment.appointment_No}' />" readonly="readonly"><br>
		        
					Physio NIC : <input type="text"  name="physio_NIC" value="<c:out value='${appointment.physio_NIC}'/>" placeholder="<c:out value='${Appointment.Physio_NIC}'/>" readonly="readonly"  ><br>
					
					Customer NIC : <input type="text" name="customer_NIC" value="<c:out value='${appointment.customer_NIC}'/>" readonly="readonly"><br>
					
					Date : <br><input type="Date" name="date" value="<c:out value='${appointment.date}'/>" required="true" min="08:00:00" max="20:00:00"><br>
					
					Time : <br><input type="Time" name="time" value="<c:out value='${appointment.time}'/>" required="true"><br>
					
					Status : <input type="Text" name="status" value="<c:out value='${appointment.status}'/>" required="true"><br><br> 
					
					<!-- <select>
						  <option value="0">Deleted</option>
						  <option value="1">Pending</option>
						  <option value="2">Active</option>
						  
					</select><br> -->
		
	
	    			<input type="submit" value="Save">
				</fieldset>
			</form>
	        </div>
	</div>
</div>


	
	        
    
<%@include file="/footer.jsp" %>
</body>
</html>