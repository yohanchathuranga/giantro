<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/prof.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
	<!-- Icomoon Icon Fonts -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/superfish.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>Schedule Form</title>
</head>
<body>
	 <%@include file="/header.jsp" %>
		<div class="fh5co-parallax-any">
			<div class="container">
				<div class="form">
					<fieldset>
						<legend>Schedule</legend>
							<form action="insert_s" method="post" enctype='multipart/form-data'>
					
										<c:if test="${schedule != null}">
								           <input type="text" name="Schedule_No" value="<c:out value='${schedule.schedule_No}' />" />
								        </c:if>
										Physio NIC : <input type="text"  name="Physio_NIC" value='${NIC}'   required="true" ><br>
										
										Customer NIC : <input type="text" name="Customer_NIC" value="<c:out value='${schedule.customer_NIC}'/>" ><br>
										
										Age :<br><input type="text" name="Age" value="<c:out value='${schedule.age}'/>" required="true"><br>
										
										Height :<br><input type="text" name="Height" value="<c:out value='${schedule.height}'/>" placeholder="In cm" required="true"><br>
										
										Weight :  <input type="text" name="Weight" value="<c:out value='${schedule.weight}'/>" placeholder="in kgs" required="true"><br>
										
										Photos : <input type="file" name="Photo" value="<c:out value='${schedule.photo}'/>" required="true"><br><br> 
										
							    		<input type="submit" value="Request for schedule">
						</form>
					</fieldset>
				</div>
			</div>
		
	</div>
	 <%@include file="/footer.jsp" %>

</body>
</html>