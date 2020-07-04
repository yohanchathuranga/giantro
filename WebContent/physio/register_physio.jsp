<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/prof.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/animate.css">
		<!-- Icomoon Icon Fonts -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/icomoon.css">
		<!-- Bootstrap  -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/bootstrap.css">
		<!-- Superfish -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/superfish.css">
	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/style.css">
	<title>register physio</title>
	</head>
	<body>
		
		<div class="continer">
			<%@include file="/header.jsp" %>
			<div class="fh5co-parallax-any">
				<div class="container">
					
					<div id="form" class="form">
						<fieldset>
							<%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>
							<legend>Physiotherapists Register Form</legend>
							 <form action="../Addphysio" method="post">
						           
						
									
							        Physio NIC :<input type="text" name="NIC" value='${user.NIC}' minlengh="10" maxlength="12" placeholder="891256238v/198912506238"/>
							        
									Physio Name : <input type="text"  name="Name" value='${user.name}'   required="true" ><br>
									
									Email : <input type="Email" name="Email" value='${user.email}' required="true">
									
									Certificate ID :<br><input type="text" name="Certificate_ID" value='${user.certificate_ID}' required="true"><br>
									
									Address :<br><input type="Text" name="Address" value='${user.address}' required="true"><br>
									
									Experience :  <input type="Text" name="Exp" value='${user.exp}'required="true"><br>
									
									Place Name :<input type="Text" name="Place_Name" value='${user.place_Name}' required="true"><br>
									 
									Contact No :<input type="Text" name="Contact_No" value='${user.contact_No }' required="true" minlengh="10" maxlength="10" placeholder="eg :0773582940"><br>
									
									<input type="hidden" name="Status" value="1" >
									<input type="hidden" name="PF" value="1" >
									
									Password :<input type="password" name="Password"  required="true"><br>
									
									Re Enter Password :<input type="password" name="Password1" required="true"><br><br>
	
						    	<input type="submit" value="Register">
						    </form>
						</fieldset>
					</div>
				</div>
			</div>
			<%@include file="/footer.jsp" %>
		</div>
	</body>
</html>