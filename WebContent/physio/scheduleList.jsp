<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import ="java.io.*"%>
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
	
	<title>schedule list</title>
	</head>
	<body>
		<div class="sidebar">
			<h4>You are Logged as Physiotherapist</h4>
				<div class="image" align="center">
					<img alt="Profile Picture" src="${pageContext.request.contextPath}/images/fr-10.jpg" class="img-circle" width="100px"/>	  			
				</div>
			  <a class="active" href="Home.jsp">Home</a>
			  <a href="profile_p?NIC=${user.NIC}">Profile</a>
			  <a href="list_a?NIC=${user.NIC}">Appointments</a>
			  <a href="list_s?NIC=${user.NIC}">Schedule Request</a>
			  <a href="#about">About</a>
			  <a href="logout" class="fh5co-sub-ddown">Sign Out</a>
		</div>
	
		<div class="content">
			<%@include file="/header.jsp" %>
			<%-- <% String message=(String)request.getAttribute("alertMsg");%>
			<script type="text/javascript">
				var msg="<%=message%>";
				alert(msg);
			</script> --%>
			<div class="fh5co-parallax-any">
				<div class="container">
					<div align="center">
				        <table class="table table-borderless table-dark" border="1" cellpadding="5">
				            <caption><h2>List of Schedule</h2></caption>
				            <tr>
				                <th>Schedule No</th>
				                <th>Physio NIC</th>
				                <th>Customer NIC</th>
				                <th>Age</th>
				                <th>Height</th>
				                <th>Weight</th>
				                <th>Photos</th>
				                <th>Edit</th>
				            </tr>
				            <c:forEach var="schedule" items="${listSchedule}">
				                <tr>
				                    <td><c:out value="${schedule.schedule_No}" /></td>
				                    <td><c:out value="${schedule.physio_NIC}" /></td>
				                    <td><c:out value="${schedule.customer_NIC}" /></td>
				                    <td><c:out value="${schedule.age}" /></td>
				                    <td><c:out value="${schedule.height}" /></td>
				                    <td><c:out value="${schedule.weight}" /></td>
				                     
				               <%--      <%
				                    Blob image=getBlob('${schedule.weight}');
				                    byte ImageData=image.getBytes(1,(int)image.length());
				                    response.setContentType("image/gif");
				                    OutputStream o=response.getOutputStream();
				                    o.write(ImageData);
				                    o.flush();
				                    o.close();
				                    %> --%>
				                    <td>
				                        <a href="edit_s?schedule_no=<c:out value='${schedule.schedule_No}' />">Edit</a>
				                        &nbsp;&nbsp;&nbsp;&nbsp;
				                                   
				                    </td>
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