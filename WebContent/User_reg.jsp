<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/prof.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/animate.css">
	<!-- Icomoon Icon Fonts -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/superfish.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/physio/css/style.css">
</head>
<body>


	
	<div class="container2" style="background-image: url(Resources/physio/images/header.jpg);">
	<h2 style="color:#000000;">Registration</h2>
		<nav class="nav" style="color: black;">
			<label for="users">Choose User Type:</label>
			<ul >
				
			<li><a href="supplement_shop/supplement_shop_registration.jsp" style="color:#FF0000;">Supplement Shop</a></li>	
			<li><a href="physio/register_physio.jsp" style="color:#FF0000;">Phyiotherapists</a> <br></li>	
			<li><a href="#" style="color:#FF0000;">Gym</a> <br> </li>	
			<li><a href="user/register_user.jsp" style="color:#FF0000;">Customer</a></li>	

			</ul>
		</nav>
			
		<div class="container" >
			<div class="inner">
				<h1>Giantro</h1>
			</div>
		</div>
		
	</div>
			


</body>
</html>