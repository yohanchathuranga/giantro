<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- <link rel="stylesheet" href="css/animate.css">
	Icomoon Icon Fonts
	<link rel="stylesheet" href="css/icomoon.css">
	Bootstrap 
	<link rel="stylesheet" href="css/bootstrap.css">
	Superfish
	<link rel="stylesheet" href="css/superfish.css">

	<link rel="stylesheet" href="css/style.css"> -->
<title>Insert title here</title>
</head>
<body>
	<c:import url="header.jsp"/>


	<a href="list_a">List All Appointments</a><br>
	<fieldset>
		<legend>Add New Appointment</legend>
		 <form action="insert_a" method="post">
	           
	
				<c:if test="${Appointment != null}">
		           <input type="text" name="appointment_No" value="<c:out value='${appointment.appointment_No}' />" />
		        </c:if>
				Doctor NIC : <input type="text"  name="physio_NIC" value='${NIC}'   required="true" readonly="readonly"><br>
				
				Customer NIC : <input type="text" name="customer_NIC" value="<c:out value='${appointment.customer_NIC}'/>" ><br>
				
				Date : <input type="Date" name="date" value="<c:out value='${appointment.date}'/>" required="true"><br>
				
				Time : <input type="Time" name="time" value="<c:out value='${appointment.time}'/>" required="true"><br>
				
				Status :  <input type="Text" name="status" value="<c:out value='${appointment.status}'/>" required="true"><br> 
				<%-- <select value="<c:out value='${appointment.status}'/>" name="tert">
						  <option value="0">Deleted</option>
						  <option value="1">Pending</option>
						  <option value="2">Active</option>
						  
					</select><br> --%>
					
	
	    	<input type="submit" value="Save">
	    </form>
	</fieldset>
	
       
    <%@include file="footer.jsp" %>

</body>
</html>